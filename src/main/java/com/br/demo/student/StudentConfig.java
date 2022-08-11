package com.br.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.NOVEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {
                    Student Ze = new Student(
                            1,
                            "Zé",
                            "Zé@Zé.com",
                            LocalDate.of(2001, NOVEMBER, 7));

                    Student Jao = new Student(
                            2,
                            "Jão",
                            "Jão@jão.com",
                            LocalDate.of(2003, NOVEMBER, 7));

                    repository.saveAll(List.of(Ze, Jao));
        };
    }
}
