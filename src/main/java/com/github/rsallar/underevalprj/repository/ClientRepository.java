package com.github.rsallar.underevalprj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.github.rsallar.underevalprj.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Page<Client> findAll(Pageable pageable);
    
    Client findByUsernameAllIgnoringCase(String username);

}