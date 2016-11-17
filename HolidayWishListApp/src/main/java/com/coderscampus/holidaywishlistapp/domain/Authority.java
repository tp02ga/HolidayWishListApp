package com.coderscampus.holidaywishlistapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority
{
  private static final long serialVersionUID = -1191580360416958205L;
  private Long id;
  private String authority;
  private FamilyMember familyMember;
  
  @Override
  public String getAuthority()
  {
    return authority;
  }

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

  public void setAuthority(String authority)
  {
    this.authority = authority;
  }

  @ManyToOne
  public FamilyMember getFamilyMember()
  {
    return familyMember;
  }

  public void setFamilyMember(FamilyMember familyMember)
  {
    this.familyMember = familyMember;
  }

}
