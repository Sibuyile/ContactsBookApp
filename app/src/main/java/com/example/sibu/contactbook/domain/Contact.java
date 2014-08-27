package com.example.sibu.contactbook.domain;

/**
 * Created by Sibu on 2014-08-25.
 */
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellNo;
    private String address;

    public Contact(){};

    public Contact(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        cellNo = builder.cellNo;
        address = builder.address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        public int id;
        public String firstName;
        public String lastName;
        public String email;
        public String cellNo;
        public String address;

        public Builder(String cellNumber)
        {
            cellNo = cellNumber;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setfirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setlastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setemail(String email) {
            this.email = email;
            return this;
        }

        public Builder setcellNo(String cellNo) {
            this.cellNo = cellNo;
            return this;
        }

        public Builder setaddress(String address) {
            this.address = address;
            return this;
        }

        public Builder Contact(Contact contact){

            firstName = contact.getFirstName();
            lastName = contact.getLastName();
            cellNo = contact.getCellNo();
            email = contact.getEmail();
            address = contact.getAddress();


            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }

}
