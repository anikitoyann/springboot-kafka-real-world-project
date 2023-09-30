package com.example.repository;

import com.example.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {
}
