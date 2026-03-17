package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GuestBook;

@Repository
public interface IGuestBookRepository extends JpaRepository<GuestBook, Long> {
    // JpaRepository already provides:
    // save(), findById(), findAll(), deleteById(), existsById() etc.
}
