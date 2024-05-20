package in.kunal.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.kunal.Repo.CustomerRepo;
import in.kunal.binding.Customer;

@RestController
public class RegistrationREst {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private CustomerRepo customerrepo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public String register(@RequestBody Customer customer) {
		String encodepwd = encoder.encode(customer.getPwd());
		customer.setPwd(encodepwd);
		customerrepo.save(customer);
		System.out.println(customer);
		return "Registration Completed";
	}
   
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer customer) {
         UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(customer.getUname(), customer.getPwd());
          try {
			Authentication authenticate = authenticationManager.authenticate(token);
			return new ResponseEntity<String>("WElCOME TO ASHOK IT" , HttpStatus.CREATED);
		} catch (Exception e) {
			
		}
          return new ResponseEntity<String>("INVALID CREDENTIALS" ,HttpStatus.BAD_REQUEST);
	}

}
