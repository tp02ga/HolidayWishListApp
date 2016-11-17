package com.coderscampus.holidaywishlistapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gift
{
  private Long id;
  private String name;
  private String url;
  private FamilyMember familyMember;
  private String dibsName;
  
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
  public String getDibsName()
  {
    return dibsName;
  }
  public void setDibsName(String dibsName)
  {
    this.dibsName = dibsName;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getUrl()
  {
    return url;
  }
  public void setUrl(String url)
  {
    this.url = url;
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
