package com.coderscampus.holidaywishlistapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.holidaywishlistapp.domain.FamilyMember;
import com.coderscampus.holidaywishlistapp.repositories.FamilyMemberRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
  @Autowired 
  private FamilyMemberRepository familyMemberRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException
  {
    FamilyMember familyMember = familyMemberRepo.findByUsername(username);
    
    if (familyMember == null)
      throw new UsernameNotFoundException("Invalid username / password combination");
    
    return familyMember;
  }

}
