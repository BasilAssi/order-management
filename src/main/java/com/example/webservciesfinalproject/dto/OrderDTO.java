/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 10:14 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class OrderDTO extends RepresentationModel<OrderDTO> {

    private Integer id;
    private Integer customerId;
    private LocalDateTime orderAt;
}
