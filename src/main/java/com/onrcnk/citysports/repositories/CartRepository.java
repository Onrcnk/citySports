package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Cart;
import com.onrcnk.citysports.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    Set<Cart> findByUser(String user);
}
