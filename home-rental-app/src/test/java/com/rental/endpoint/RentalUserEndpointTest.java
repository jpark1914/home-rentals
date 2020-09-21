package com.rental.endpoint;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.rental.entity.RentalUsers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RentalUserEndpointTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	public HttpEntity<RentalUsers> createHttpEntity(String username, String password) {
		HttpHeaders headers = new HttpHeaders();
		String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64( 
           auth.getBytes(Charset.forName("US-ASCII")) );
        String authHeader = "Basic " + new String( encodedAuth );
        headers.add("Authorization", authHeader);
        return new HttpEntity<RentalUsers>(headers);
	}
	
	@Test
	public void login() {
		String url = "http://localhost:" + port + "/user/get";
		ResponseEntity<RentalUsers> response = restTemplate.exchange(url, HttpMethod.GET, 
			createHttpEntity("naughtynas@gmail.com", "pass"), RentalUsers.class);
		
		assertThat(response.getBody().getUserId()).isEqualTo(1);
		assertThat(response.getStatusCode()).isEqualTo(200);
		assertThat(response.getBody().getEmail()).isEqualTo("naughtynas@gmail.com");
	}
	
	
}
