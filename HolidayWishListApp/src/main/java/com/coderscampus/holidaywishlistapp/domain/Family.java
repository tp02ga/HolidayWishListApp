package com.coderscampus.holidaywishlistapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // syn. Database Table 
public class Family
{
  private Long id;
  private String name;
  private Set<FamilyMember> familyMembers = new HashSet<>();
  
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
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="family")
  public Set<FamilyMember> getFamilyMembers()
  {
    return familyMembers;
  }
  public void setFamilyMembers(Set<FamilyMember> familyMembers)
  {
    this.familyMembers = familyMembers;
  }
}
