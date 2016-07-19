package com.github.rsallar.underevalprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;

import com.github.rsallar.underevalprj.domain.Client;
import com.github.rsallar.underevalprj.domain.Roles;
import com.github.rsallar.underevalprj.repository.ClientRepository;

@Service
public class AccountConnectionSignUpService implements ConnectionSignUp {

	@Autowired
    private ClientRepository clientRepository;

    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        clientRepository.save(new Client(profile.getEmail(), AuthorityUtils.createAuthorityList(Roles.USER)));
        return profile.getEmail();
    }

}