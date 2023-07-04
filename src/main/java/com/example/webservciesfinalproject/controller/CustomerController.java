/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/29/2023
 * Time: 3:51 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.controller;

import com.example.webservciesfinalproject.dto.CustomerDTO;
import com.example.webservciesfinalproject.service.CustomerService;
import com.example.webservciesfinalproject.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.webservciesfinalproject.user.Role.ADMIN;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Api(tags = "Customers")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "Get all customers")
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> cs=customerService.getAllCustomers();
        for ( CustomerDTO c: cs ) {
            Link ordersLink = linkTo(methodOn(OrderController.class)
                    .getAllOrdersByCustomer(c.getId()))
                    .withRel("customerOrders");
            c.add(ordersLink);
        }
        return ResponseEntity.ok(cs);
    }

    @ApiOperation(value = "Get customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id, Authentication auth) {
//        UserDetails userDetails = (UserDetails) auth.getPrincipal();
//        User user = (User) userDetails;
//        System.out.println(user);
//        Integer authCustomerId = user.getCustomerId();


      //  boolean isAdmin = auth.getAuthorities().stream()
      //          .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(ADMIN.name() ));

     //   if(isAdmin || authCustomerId==id) {

            CustomerDTO customerDTO = customerService.getCustomerById(id);
            Link ordersLink = linkTo(methodOn(OrderController.class)
                    .getAllOrdersByCustomer(customerDTO.getId()))
                    .withRel("customerOrders");
            customerDTO.add(ordersLink);
            return ResponseEntity.ok(customerDTO);
        // }else{  return  new ResponseEntity("UnAuthorized",HttpStatus.UNAUTHORIZED);}
    }

    @ApiOperation(value = "Create a new customer")
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @ApiOperation(value = "Update customer")
    @PutMapping("/{id}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));
    }

    @ApiOperation(value = "Delete customer by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}