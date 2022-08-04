package br.com.fiap.epictaskapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.epictaskapi.model.Task;

@Service
public class TaskService {

    public List<Task> listAll() {

        return List.of(
            new Task("Modelar o Banco de Dados", "Modelar as tabelas do BD"),
            new Task("Protótipo", "Prototipar as telas", 50, 0));
    }

}
