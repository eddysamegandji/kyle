package com.kylemanagement.controller;

import com.api.model.CustomerApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kylemanagement.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@AutoConfigureMockMvc
class CustomerControllerTest extends IntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    void setUp() {
        baseUrl = baseUrl.concat(":").concat(port+"");
    }

    @Test
//    @WithMockUser("/admin")
    void createCustomer() throws Exception {

        CustomerApi customerApi = new CustomerApi();
        customerApi.setFirstName("testname");

        given().
            body(customerApi).
            contentType("application/json").
        when().
            post(baseUrl+"/customers").
        then().
            statusCode(201)
            .and()
            .body("firstName", is(equalTo("testname")));


//       mockMvc.perform(post("/customers")
//                .content(mapper.writeValueAsString(customerApi))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void editCustomer() {
    }

    @Test
    void getCustomer() {
    }

    @Test
    void getCustomers() {
    }
}