package com.lcsolution.smartIntegration.security.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.lcsolution.smartIntegration.model.User;
import com.lcsolution.smartIntegration.model.UserRole;

public class JwtUserFactory {

	private JwtUserFactory() {
	}
	
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getUsername(), user.getPassword(), mapToGranteAuthorities(user.getRole()));
	}

	private static Collection<? extends GrantedAuthority> mapToGranteAuthorities(UserRole role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));
		return authorities;
	}
}
