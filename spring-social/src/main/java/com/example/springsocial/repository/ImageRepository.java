package com.example.springsocial.repository;

import com.example.springsocial.model.images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<images, Long> {
}
