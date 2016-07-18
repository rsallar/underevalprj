package com.github.rsallar.underevalprj.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import com.github.rsallar.underevalprj.security.mongo.MongoConnectionTransformers;
import com.github.rsallar.underevalprj.security.mongo.MongoUsersConnectionRepository;
import com.github.rsallar.underevalprj.service.AccountConnectionSignUpService;

/**
 * Created by Mohamed on 5/29/2014
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
	 Logger logger = LoggerFactory.getLogger(SocialConfig.class);
	@Autowired
	private AccountConnectionSignUpService accountConnectionSignUpService;
    
	@Autowired
    private MongoOperations mongo;

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
    	
       logger.info("adapting social connections");
    	
       MongoConnectionTransformers transformers = new MongoConnectionTransformers(connectionFactoryLocator, Encryptors.noOpText());
       MongoUsersConnectionRepository repository = new MongoUsersConnectionRepository(mongo, connectionFactoryLocator, transformers);
       repository.setConnectionSignUp(accountConnectionSignUpService);	
       
        return repository;
    }
}