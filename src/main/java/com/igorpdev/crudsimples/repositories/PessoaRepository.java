package com.igorpdev.crudsimples.repositories;

import java.util.Optional;

import com.igorpdev.crudsimples.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    Optional<Pessoa> findById(Long id);
}
