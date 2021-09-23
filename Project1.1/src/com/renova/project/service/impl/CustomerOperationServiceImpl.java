package com.renova.project.service.impl;

import com.renova.project.model.Company;
import com.renova.project.model.Customer;
import com.renova.project.model.Individual;
import com.renova.project.service.CustomerOperationService;

import java.util.ArrayList;

public class CustomerOperationServiceImpl implements CustomerOperationService {
    private static ArrayList<Customer> customerArrayList;

    public CustomerOperationServiceImpl() {
        if (customerArrayList == null) {
            customerArrayList = new ArrayList<>();
        }
    }

    // customer nesneleri oluşturan metot
    @Override
    public void createSomeCustomer() {
        Customer company1 = new Company(1, "Threat Company", "3412341233", "Aaa Aaa aaa", "İletişim bilgileri", 15);
        Customer individual1 = new Individual(2, "Ahmet HAKAN", "123141555", "Ccc Ccc ccc", "PWsEHs4IH");

        customerArrayList.add(company1);
        customerArrayList.add(individual1);
    }

    // mevcut customer list döndürür
    @Override
    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    // mevcut customer' ları yazdırır
    @Override
    public void listCustomers() {
        for (Customer customer : customerArrayList) {
            System.out.println(customer.toString());
        }
    }
}
