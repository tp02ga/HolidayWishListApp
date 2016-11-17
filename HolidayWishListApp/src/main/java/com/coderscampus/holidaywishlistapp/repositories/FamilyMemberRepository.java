package com.coderscampus.holidaywishlistapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.holidaywishlistapp.domain.FamilyMember;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long>
{

  FamilyMember findByUsername(String username);

}
