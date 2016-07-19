package com.github.rsallar.underevalprj.domain;

import java.util.List;

import javax.annotation.concurrent.Immutable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.rsallar.underevalprj.domain.serializer.GrantedAuthorityDeserializer;
import com.github.rsallar.underevalprj.domain.serializer.GrantedAuthoritySerializer;


@Immutable
public class Client {

	public Client(String email, List<GrantedAuthority> roles){
		this.email = email;
		this.roles = roles;
	}

	private String id;
    private String email;

    @JsonSerialize(contentUsing = GrantedAuthoritySerializer.class)
    @JsonDeserialize(contentUsing = GrantedAuthorityDeserializer.class)
    private List<GrantedAuthority> roles;


     public String getEmail(){
    	return email;
    }
    
    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
        		.append("email", email)
                .append("roles", roles)
                .toString();
    }

	public String getId() {
		return id;
	}

}