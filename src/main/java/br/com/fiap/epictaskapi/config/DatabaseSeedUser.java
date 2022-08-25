package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
public class DatabaseSeedUser implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(List.of(
            new User("Chris", "chrissytirocerto@gmail.com", "password123"),
            new User("Julius", "juliusrock@gmail.com", "pass123456w"),
            new User("Greg", "chrisegreg@gmail.com", "taonasua23")
        ));
    }
}

