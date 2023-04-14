/*
 * package com.hdfc.midtermproject.grocery.config;
 * 
 * import java.util.Collection; import java.util.Collections;
 * 
 * import org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.stereotype.Component;
 * 
 * import com.hdfc.midtermproject.grocery.entity.Customer;
 * 
 * 
 * public class CustomCustomerDetails implements UserDetails{
 * 
 * private Customer customer;
 * 
 * public CustomCustomerDetails(Customer customer) { super(); this.customer =
 * customer; }
 * 
 * @Override public Collection<? extends GrantedAuthority> getAuthorities() { //
 * TODO Auto-generated method stub return Collections.singleton(new
 * SimpleGrantedAuthority(customer.getRole())); }
 * 
 * @Override public String getPassword() { // TODO Auto-generated method stub
 * return customer.getCustomerPassword(); }
 * 
 * @Override public String getUsername() { // TODO Auto-generated method stub
 * return customer.getCustomerEmail(); }
 * 
 * @Override public boolean isAccountNonExpired() { // TODO Auto-generated
 * method stub return true; }
 * 
 * @Override public boolean isAccountNonLocked() { // TODO Auto-generated method
 * stub return true; }
 * 
 * @Override public boolean isCredentialsNonExpired() { // TODO Auto-generated
 * method stub return true; }
 * 
 * @Override public boolean isEnabled() { // TODO Auto-generated method stub
 * return true; }
 * 
 * }
 */