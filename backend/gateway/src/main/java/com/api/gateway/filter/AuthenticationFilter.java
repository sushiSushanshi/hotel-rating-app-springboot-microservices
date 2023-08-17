package com.api.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.api.gateway.util.JwtUtil;
import com.google.common.net.HttpHeaders;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	
	@Autowired
	private RouteValidator validator;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {

		return ((exchange,chain)->{
			if(validator.isSecured.test((exchange.getRequest()))) {
				//header contains token or not
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}
				
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader=authHeader.substring(7);
				}
				try {
					//REST call to auth service
					//restTemplate.getForObject("http://localhost:8085/validate?token"+authHeader, String.class);
					jwtUtil.validateToken(authHeader);
				}catch(Exception e) {
					System.out.println("invalid access.....");
					throw new RuntimeException("un-authorized access.....");
				}
			}
			
			return chain.filter(exchange);
		});
	}

	public static class Config {

	}
}
