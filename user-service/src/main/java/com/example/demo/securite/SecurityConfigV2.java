package com.example.demo.securite;

import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfigV2 {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Autorise toutes les routes
                        .allowedOrigins("http://localhost:4200") // Autorise Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Autorise ces méthodes
                        .allowedHeaders("*") // Autorise tous les headers
                        .allowCredentials(true); // Autorise les cookies
            }
        };
    }
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		
		
		return new ProviderManager(daoAuthenticationProvider);
		
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.cors(Customizer.withDefaults())
				.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(csrf->csrf.disable())
				.headers(h->h.frameOptions(fo->fo.disable()))
				.authorizeHttpRequests(ar->ar.requestMatchers("/auth/**").permitAll())
				//.authorizeHttpRequests(ar->ar.requestMatchers("/accounts/**").hasAuthority("ADMIN"))
				.authorizeHttpRequests(ar->ar.anyRequest().authenticated())
				.oauth2ResourceServer(o2->o2.jwt(Customizer.withDefaults()))
				.build();
		
	}
	@Bean
	JwtEncoder jwtEncoder() {
		String secretKey="HG46367-71GH227-eéç7t5é8-6g6g-HG46367-71GH227-eéç7t5é8-6g6g-8h";
		return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
	}
	@Bean
	JwtDecoder jwtDecoder() {
		String secretKey="HG46367-71GH227-eéç7t5é8-6g6g-HG46367-71GH227-eéç7t5é8-6g6g-8h";
		SecretKeySpec secretKeySpec=new SecretKeySpec(secretKey.getBytes(), "RSA");
		return  NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
	}

}
