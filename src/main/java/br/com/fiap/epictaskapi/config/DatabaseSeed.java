package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        taskRepository.saveAll(List.of(
            new Task("Modelar BD", "Modelar tabelas do banco", 150),
            new Task("Protótipo", "Prototipar as telas", 250),
            new Task("Bug", "Corrigir erro da API", 50)
        ));
        userRepository.saveAll(List.of(
            new User("Chris", "chrissytirocerto@gmail.com", "password123"),
            new User("Julius", "juliusrock@gmail.com", "pass123456w"),
            new User("Greg", "chrisegreg@gmail.com", "taonasua23")
        ));
    }
    
}
