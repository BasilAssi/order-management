/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 10:15 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Data
public class ProductDTO {
    private Integer id;
    private String slug;
    private String name;
    private String reference;
    private BigDecimal price;
    private BigDecimal vat;
    private Boolean stockable;
}
