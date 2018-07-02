package mum.edu.sa.FirstSaProject.membership.component.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Account account;
    private Address address;
    private List<CreditCard> creditCards;

    public Customer(){
        creditCards = new ArrayList<>();
    }

    public void addCreditCard(CreditCard creditCard){
        this.creditCards.add(creditCard);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CreditCard> getCreditCards() {
        return Collections.unmodifiableList(creditCards);
    }

}
