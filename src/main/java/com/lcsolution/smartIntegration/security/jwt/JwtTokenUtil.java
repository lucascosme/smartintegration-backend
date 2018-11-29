package com.lcsolution.smartIntegration.security.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author lucas
 * 
 * This class is responsible for managing the token 
 */

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -1854490249310649592L;
	
	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_CREATED = "created";
	static final String CLAIM_KEY_EXPIRED = "exp";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String getUserNameFromToken(String token) {
		String username;
		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			e.printStackTrace();
			username = null;
		}
		return username;
	}
	
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			e.printStackTrace();
			expiration = null;
		}
		return expiration;
	}
	

	//This method is parse JWT ( get information )
	public Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			claims = null;
		}
		return claims;
	}
	
	//This method verify expiration token
	private Boolean isTokenExpired(String token) {
		final Date expiration  = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//This method generate token
	public String generateToken(UserDetails userDatails) {
		Map<String, Object> claims = new HashMap<>();
		
		claims.put(CLAIM_KEY_USERNAME, userDatails.getUsername());
		
		final Date createDate = new Date();
		claims.put(CLAIM_KEY_CREATED, createDate);
		
		return doGenerateToken(claims);
	}

	private String doGenerateToken(Map<String, Object> claims) {
		final Date createDate = (Date) claims.get(CLAIM_KEY_CREATED);
		final Date expirationDate = new Date(createDate.getTime() + expiration * 1000);
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	//Verify can token refresh
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token));
	}
	
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = doGenerateToken(claims);
		} catch (Exception e) {
			e.printStackTrace();
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String userName = getUserNameFromToken(token);
		return (userName.equals(user.getUsername()) && !isTokenExpired(token));
	}

}
