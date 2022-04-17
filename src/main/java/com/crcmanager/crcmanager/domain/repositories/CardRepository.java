package com.crcmanager.crcmanager.domain.repositories;

import com.crcmanager.crcmanager.domain.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}