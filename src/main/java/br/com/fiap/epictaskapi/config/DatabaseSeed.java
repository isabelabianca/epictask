package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        taskRepository.saveAll(List.of(
            new Task("Modelar BD", "Modelar tabelas do banco", 150),
            new Task("Protótipo", "Prototipar as telas", 250),
            new Task("Bug", "Corrigir erro da API", 50),
            new Task("Login", "Modelar tabelas do banco", 100),
            new Task("Deploy", "Prototipar as telas", 75),
            new Task("Cadastro de usuário", "Corrigir erro da API", 200),
            new Task("Testes", "Modelar tabelas do banco", 100),
            new Task("Logout", "Prototipar as telas", 150),
            new Task("Internacionalização", "Corrigir erro da API", 80),
            new Task("Segundo teste", "Corrigir erro da API", 70)
        ));
        userRepository.saveAll(List.of(
            new User("Chris", "chrissytirocerto@gmail.com", "password123"),
            new User("Julius", "juliusrock@gmail.com", "pass123456w"),
            new User("Greg", "chrisegreg@gmail.com", "taonasua23")
        ));
        userRepository.save(
            new User()
                .name("Isabela")
                .email("isabela@fiap.com.br")
                .password(passwordEncoder.encode("123")))
        );
    }
    
}
