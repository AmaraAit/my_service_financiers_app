package com.example.demo.securite;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtEncodingException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtEncoder jwtEncoder;
	
	@GetMapping("/profile")
	public Authentication authentication(Authentication authentication) {
		return authentication;
	}
	
	@PostMapping("/login")
    public Map<String, String> login(String email,String password) throws JwtException{
        Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(email, password));
        Instant instant=Instant.now();
        String scope=authentication.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
        		.issuedAt(instant)
        		.expiresAt(instant.plus(10,ChronoUnit.MINUTES))
        		.subject(email)
        		.claim("scope",scope)
        		.build();
        JwtEncoderParameters  jwtEncoderParameters=JwtEncoderParameters.from(
        		JwsHeader.with(MacAlgorithm.HS512).build(),jwtClaimsSet);
        String jwt =jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return Map.of("access-token",jwt);
    }

}
