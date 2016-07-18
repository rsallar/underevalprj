package com.github.rsallar.underevalprj.service;

import javax.annotation.PostConstruct;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.github.rsallar.underevalprj.domain.Client;
import com.github.rsallar.underevalprj.domain.Roles;
import com.github.rsallar.underevalprj.repository.ClientRepository;

@Service
public class InitService {
	
	static Logger logger = LoggerFactory.getLogger(InitService.class);

	@Autowired
	private ClientRepository clientRepository;
	
	@PostConstruct
    public void init() {
		logger.info("Adding mocking user to demo purposes");
		Client client = new Client("user1", "pwd", AuthorityUtils.createAuthorityList(Roles.USER));	
		clientRepository.save(client);
    }
	
}
