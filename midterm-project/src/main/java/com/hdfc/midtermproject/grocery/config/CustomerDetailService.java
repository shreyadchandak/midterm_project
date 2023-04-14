/*
 * package com.hdfc.midtermproject.grocery.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.hdfc.midtermproject.grocery.entity.Customer; import
 * com.hdfc.midtermproject.grocery.repository.CustomerRepo;
 * 
 * 
 * @Service public class CustomerDetailService implements UserDetailsService {
 * 
 * @Autowired CustomerRepo repo;
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { // TODO Auto-generated method stub Customer
 * customer=repo.findByCustomerEmail(email); if(customer==null) { throw new
 * UsernameNotFoundException("Customer Not Found"); } return new
 * CustomCustomerDetails(customer); }
 * 
 * }
 */
