package com.kuehne_nagel.contact_list.bean;

import com.kuehne_nagel.contact_list.model.Contact;
import com.kuehne_nagel.contact_list.model.ContactLazyDataModel;
import com.kuehne_nagel.contact_list.service.ContactService;
import lombok.Data;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@Data
public class ContactBean {

    private final ContactService contactService;

    LazyDataModel<Contact> contacts;


    @Inject
    public ContactBean(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void init(){
        contacts = new ContactLazyDataModel(contactService);
    }
}
