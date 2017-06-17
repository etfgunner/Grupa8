package etf.si.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.si.dto.LoginDataRequest;
import etf.si.dto.LoginDataResponse;
import etf.si.models.Korisnik;
import etf.si.services.AuthService;
import etf.si.services.JwtService;

@RestController
@CrossOrigin
@RequestMapping(path= "/auth")
public class AuthController {

    @Autowired
    private AuthService _authService;

    @RequestMapping(path="", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<LoginDataResponse> login(@RequestBody LoginDataRequest request) {
    	try {
        	Korisnik user = _authService.checkLoginData(request.getUsername(), request.getPassword());
        	
        	if (user != null) {
        		user.setPassword(null); // obviously :)
        		
        		String token = JwtService.issueToken(user.getAdmin(), user.getSuperAdmin());
        		
	            return ResponseEntity
	            		.status(HttpStatus.OK)
	                    .body(new LoginDataResponse(user, token));
        	}
        	else {
        		throw new ServiceException("");
        	}
           
    	}
    	catch (ServiceException e) {
    		return ResponseEntity
    				.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginDataResponse("Incorrect username or password."));
    	}
    }
}
