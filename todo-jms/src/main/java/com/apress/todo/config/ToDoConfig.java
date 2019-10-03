package com.apress.todo.config;

import com.apress.todo.error.ToDoErrorHandler;
import com.apress.todo.validator.ToDoValidator;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class ToDoConfig {

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {

        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        converter.setTargetType(MessageType.TEXT);

        converter.setTypeIdPropertyName("_class_");

        return converter;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        factory.setErrorHandler(new ToDoErrorHandler());

        configurer.configure(factory, connectionFactory);

        return factory;
    }

    /**
     * For multiple consumer
     * @return
     */
//    @Bean
//    public DefaultMessageListenerContainer jmsListenerContainerFactory(){
//
//        DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
//
//        dmlc.setPubSubDomain(true);
//
//        // Other configuration here ...
//        return dmlc;
//    }

    @Configuration
    static class MethodListenerConfig implements JmsListenerConfigurer {

        @Override
        public void configureJmsListeners(JmsListenerEndpointRegistrar jmsListenerEndpointRegistrar){
            jmsListenerEndpointRegistrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
        }

        @Bean
        public DefaultMessageHandlerMethodFactory myHandlerMethodFactory()
        {
            DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();

            factory.setValidator(new ToDoValidator());

            return factory;
        }
    }

}
