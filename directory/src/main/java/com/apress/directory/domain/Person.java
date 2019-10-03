package com.apress.directory.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(unique = true)
    private String email;

    private String name;

    private String password;

    private String role = "USER";

    private boolean enabled = true;

    private LocalDate birthday;

    @Column(insertable = true, updatable = false)
    private LocalDateTime created;

    private LocalDateTime modified;

    public Person() {
    }
    public Person(String email, String name, String password, String
            birthday) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.birthday = LocalDate.parse(birthday, DateTimeFormatter.
                ofPattern("yyyy-MM-dd"));
    }

}
