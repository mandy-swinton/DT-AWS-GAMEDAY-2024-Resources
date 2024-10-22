package com.dynatrace.demo.controller;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynatrace.demo.util.Configurations;


@CrossOrigin(origins = "*")
@RestController
public class LambdaCallerController {
	
	private Configurations config = new Configurations();
	private Boolean isMakeError = true;
	
	
	public LambdaCallerController() {
	}
	
	@GetMapping(path = "/makeerror")
	public ResponseEntity<String> makeError() {
		if (isMakeError) {
			int currentMinute = LocalDateTime.now().getMinute();
			if (currentMinute < 20) {
				return new ResponseEntity<>("THIS TURTLE NEEDS A LITTLE BIT LONGER", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}
	}
		
	@GetMapping(path = "/fixerror")
	public ResponseEntity<String> fixerror() {
		isMakeError = false;
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
	@GetMapping(path = "/turnerroron")
	public ResponseEntity<String> turnerroron() {
		isMakeError = true;
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
	
	
	
	@GetMapping(path = "/lambda1")
	public ResponseEntity<String> retrieveCars() {
		System.out.println("made it to java");
		try {
			System.out.println(config.getProperty("lambda_one"));
			URL url = new URL(config.getProperty("lambda_one"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			int status = con.getResponseCode();

			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
		      content.append(inputLine);
			}
			in.close();
			
			System.out.println("response");
			System.out.println(content.toString());
			
			System.out.print("lambda2");
			System.out.println(config.getProperty("lambda_two"));
			
			URL url2 = new URL(config.getProperty("lambda_two"));
			HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
			con2.setRequestMethod("GET");
			
			int status2 = con2.getResponseCode();

			System.out.println("response2");
			System.out.println(status2);
			
	
			
			return new ResponseEntity<>(content.toString(), HttpStatus.OK);
			
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
