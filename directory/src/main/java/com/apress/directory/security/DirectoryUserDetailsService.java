package com.apress.directory.security;

import com.apress.directory.domain.Person;
import com.apress.directory.repository.PersonRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DirectoryUserDetailsService implements UserDetailsService {

    private PersonRepository repo;

    public DirectoryUserDetailsService(PersonRepository repo) {
        this.repo = repo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            final Person person = this.repo.findByEmailIgnoreCase(username);

            if (person != null) {

                PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

                String password = encoder.encode(person.getPassword());

                // return UserDetails
                return User
                        .withUsername(person.getEmail())
                        .accountLocked(!person.isEnabled())
                        .password(password).
                        roles(person.getRole())
                        .build();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        throw new UsernameNotFoundException(username);
    }

}
