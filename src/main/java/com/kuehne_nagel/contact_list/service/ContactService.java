package com.kuehne_nagel.contact_list.service;

import com.kuehne_nagel.contact_list.model.Contact;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ContactService {

    Page<Contact> getContacts(int index, int size);

    Page<Contact> searchContactsByName(String name, int index, int size);

    Optional<Contact> getContact(long id);
}
