/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 10:16 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Data
public class ProductOrderDTO {

    private Integer id;
    private Integer productId;
    private Integer orderId;
    private Integer quantity;
    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal price;
    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal vat;
}
