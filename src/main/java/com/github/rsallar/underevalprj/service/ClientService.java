package com.github.rsallar.underevalprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import com.github.rsallar.underevalprj.domain.Client;
import com.github.rsallar.underevalprj.repository.ClientRepository;

@Service
public class ClientService implements SocialUserDetailsService {

	@Autowired
    private ClientRepository clientRepository;

    
    public Client findClient(String name) {
       return clientRepository.findByUsernameAllIgnoringCase(name);
    }


	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		Client client = findClient(userId);
		return new SocialUser(client.getUsername(), client.getPassword(), client.getRoles());
	}
    
    
}