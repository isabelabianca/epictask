package br.com.fiap.epictaskapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> index() {
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> show (@PathVariable Long id) {
        return ResponseEntity.of(service.getById(id));
    } 

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<User> optional = service.getById(id);

        if (optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid User newUser){

        Optional<User> optional = service.getById(id);

        if (optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        var user = optional.get();
        BeanUtils.copyProperties(newUser, user);
        user.setId(id);

        service.save(user);

        return ResponseEntity.ok(user);
        
    }

}
