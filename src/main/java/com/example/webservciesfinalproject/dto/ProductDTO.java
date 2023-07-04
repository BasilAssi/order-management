/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 10:15 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;


@Getter
@Setter
@Data
public class ProductDTO  extends RepresentationModel<ProductDTO> {
    private Integer id;
    private String slug;
    private String name;
    private String reference;
    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal price;
    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal vat;
    private Boolean stockable;
}
