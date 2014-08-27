package com.example.sibu.contactbook.repository;

import com.example.sibu.contactbook.domain.Contact;

import java.util.List;

/**
 * Created by Sibu on 2014-08-25.
 */
public interface DataSourceDAO {

    public void createContact(Contact contact);
    public void updateContact(Contact contact);
    public Contact findContactByID(int id);
    public void deleteContact(Contact contact);
    public Contact getContact();
    public List<Contact> getContactList();
    public int getCursor();
}
