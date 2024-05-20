package in.kunal.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.kunal.Repo.CustomerRepo;
import in.kunal.binding.Customer;

@Service
public class MyUserDetailsService  implements UserDetailsService {
	
	@Autowired
	private CustomerRepo service;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer name = service.findByUname(username);
		return new User(name.getUname(), name.getPwd(),Collections.emptyList());
	}

}
