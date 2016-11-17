package com.coderscampus.holidaywishlistapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.holidaywishlistapp.domain.Gift;

public interface GiftRepository extends JpaRepository<Gift, Long>
{

}
