package com.kylemanagement.service.impl;

import com.api.model.CustomerApi;
import com.kylemanagement.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveCustomer() throws Exception {


    }

    @Test
    void getCustomers() {
    }

    @Test
    void findCustomerById() {

    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void testSaveCustomer() {
    }

    @Test
    void testGetCustomers() {
    }

    @Test
    void testFindCustomerById() {
    }

    @Test
    void testDeleteCustomerById() {
    }
}