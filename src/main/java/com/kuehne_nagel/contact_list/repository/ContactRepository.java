package com.kuehne_nagel.contact_list.repository;

import com.kuehne_nagel.contact_list.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
