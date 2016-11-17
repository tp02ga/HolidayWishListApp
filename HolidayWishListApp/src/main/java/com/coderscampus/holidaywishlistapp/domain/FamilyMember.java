package com.coderscampus.holidaywishlistapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class FamilyMember implements UserDetails {
  private static final long serialVersionUID = -4449884434043869426L;
  private Long id;
  private String name;
  private Family family;
  private Set<Gift> gifts = new HashSet<>();
  
  // code for spring security
  private String username;
  private String password;
  private Set<Authority> authorities = new HashSet<>();
  private boolean isAccountNonExpired = true;
  private boolean isAccountNonLocked = true;
  private boolean isEnabled = true;
  private boolean isCredentialsNonExpired = true;
  // --------------------------
  
  @Id
  @GeneratedValue
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="familyMember")
  public Set<Authority> getAuthorities()
  {
    return authorities;
  }
  public void setAuthorities(Set<Authority> authorities)
  {
    this.authorities = authorities;
  }
  public String getUsername()
  {
    return username;
  }
  public void setUsername(String username)
  {
    this.username = username;
  }
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  @Override
  public boolean isAccountNonExpired()
  {
    return isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled()
  {
    return isEnabled;
  }

  public void setAccountNonExpired(boolean isAccountNonExpired)
  {
    this.isAccountNonExpired = isAccountNonExpired;
  }

  public void setAccountNonLocked(boolean isAccountNonLocked)
  {
    this.isAccountNonLocked = isAccountNonLocked;
  }

  public void setEnabled(boolean isEnabled)
  {
    this.isEnabled = isEnabled;
  }

  public void setCredentialsNonExpired(boolean isCredentialsNonExpired)
  {
    this.isCredentialsNonExpired = isCredentialsNonExpired;
  }
  
  @ManyToOne
  public Family getFamily()
  {
    return family;
  }
  public void setFamily(Family family)
  {
    this.family = family;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="familyMember")
  public Set<Gift> getGifts()
  {
    return gifts;
  }
  public void setGifts(Set<Gift> gifts)
  {
    this.gifts = gifts;
  }
}
