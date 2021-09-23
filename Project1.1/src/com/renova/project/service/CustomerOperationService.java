package com.renova.project.service;

import com.renova.project.model.Customer;

import java.util.ArrayList;

public interface CustomerOperationService {
    void createSomeCustomer();
    ArrayList<Customer> getCustomerArrayList();
    void listCustomers();
}
