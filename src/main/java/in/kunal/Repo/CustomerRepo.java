package in.kunal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.binding.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, Integer>{
	
	public Customer findByUname(String uname);

}
