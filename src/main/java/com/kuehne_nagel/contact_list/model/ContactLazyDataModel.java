package com.kuehne_nagel.contact_list.model;

import com.kuehne_nagel.contact_list.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contact lazy data model to support lazy pagination for data table
 */
@RequiredArgsConstructor
public class ContactLazyDataModel extends LazyDataModel<Contact> {

    private static final String NAME_COLUMN = "name";

    private final ContactService contactService;

    private Page<Contact> contacts;

    @Override
    public List<Contact> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        if (filterBy.isEmpty() || filterBy.get(NAME_COLUMN).getFilterValue() == null)
            contacts = contactService.getContacts(first, pageSize);
        else
            contacts = contactService.searchContactsByName(filterBy.get(NAME_COLUMN).getFilterValue().toString(), first, pageSize);
        return contacts.get().collect(Collectors.toList());
    }

    @Override
    public Object getRowKey(Contact contact) {
        return contact.getId();
    }

    @Override
    public Contact getRowData(String rowKey) {
        return contactService.getContact(Long.parseLong(rowKey)).orElseThrow(RuntimeException::new);
    }

    @Override
    public int getRowCount() {
        return contacts != null ? (int)contacts.getTotalElements() : 0;
    }
}
