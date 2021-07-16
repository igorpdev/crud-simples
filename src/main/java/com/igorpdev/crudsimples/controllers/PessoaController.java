package com.igorpdev.crudsimples.controllers;

import com.igorpdev.crudsimples.model.Pessoa;
import com.igorpdev.crudsimples.repositories.PessoaRepository;

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
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaRepository repository;

    @GetMapping("/{id}") 
    public ResponseEntity<Pessoa> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pessoa> post(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
    }

    @PutMapping
    public ResponseEntity<Pessoa> put(@RequestBody Pessoa pessoa) { 
        return ResponseEntity.ok(repository.save(pessoa)); 
    }

     @DeleteMapping("/{id}") 
     public void delete(@PathVariable long id) {
	    repository.deleteById(id); 
    }
}
