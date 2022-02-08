package com.kuehne_nagel.contact_list;

import com.kuehne_nagel.contact_list.model.Contact;
import com.kuehne_nagel.contact_list.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
public class ContactServiceTest {

    @Autowired
    ContactService contactService;

    @Test
    public void getContactList(){
        Page<Contact> list = contactService.getContacts(0, 10);
        assert(list.getSize() == 10);
    }

    @Test
    public void searchContacts(){
        String searchQuery = "brodka";
        Page<Contact> list = contactService.searchContactsByName(searchQuery, 0, 10);
        list.forEach(contact -> {assert(contact.getName().toLowerCase().contains(searchQuery));});
    }

}
