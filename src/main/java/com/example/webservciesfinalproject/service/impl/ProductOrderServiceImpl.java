/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 10:49 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.service.impl;

import com.example.webservciesfinalproject.dto.ProductOrderDTO;
import com.example.webservciesfinalproject.entity.ProductOrder;
import com.example.webservciesfinalproject.entity.ProductOrderKey;
import com.example.webservciesfinalproject.exception.ResourceNotFoundException;
import com.example.webservciesfinalproject.repository.OrderRepository;
import com.example.webservciesfinalproject.repository.ProductOrderRepository;
import com.example.webservciesfinalproject.repository.ProductRepository;
import com.example.webservciesfinalproject.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//@Service
//public class ProductOrderServiceImpl implements ProductOrderService {
//
//    @Autowired
//    private ProductOrderRepository productOrderRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public List<ProductOrderDTO> getAllProductOrders() {
//        return productOrderRepository.findAll().stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ProductOrderDTO> getProductOrdersByOrderId(Integer orderId) {
//        return productOrderRepository.findByOrderId(orderId).stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ProductOrderDTO> getProductOrdersByProductId(Integer productId) {
//        return productOrderRepository.findByProductId(productId).stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ProductOrderDTO getProductOrderById(Integer productId, Integer orderId) {
//        ProductOrder productOrder = productOrderRepository.findById(new ProductOrderKey(productId, orderId))
//                .orElseThrow(() -> new ResourceNotFoundException("Product Order","productId: "+productId + "orderId"+orderId, orderId ));
//        return convertToDTO(productOrder);
//    }
//
//    @Override
//    public ProductOrderDTO createProductOrder(ProductOrderDTO productOrderDTO) {
//        ProductOrder productOrder = convertToEntity(productOrderDTO);
//        return convertToDTO(productOrderRepository.save(productOrder));
//    }
//
//    @Override
//    public ProductOrderDTO updateProductOrder(Integer productId, Integer orderId, ProductOrderDTO productOrderDTO) {
//        productOrderRepository.findById(new ProductOrderKey(productId, orderId))
//                .orElseThrow(() -> new ResourceNotFoundException("Product Order","productId: "+productId + "orderId"+orderId, orderId ));
//
//        ProductOrder productOrder = convertToEntity(productOrderDTO);
//        productOrder.setId(new ProductOrderKey(productId, orderId));
//        return convertToDTO(productOrderRepository.save(productOrder));
//    }
//
//    @Override
//    public void deleteProductOrder(Integer productId, Integer orderId) {
//        productOrderRepository.deleteById(new ProductOrderKey(productId, orderId));
//    }
//
//    // Method to convert ProductOrder to ProductOrderDTO
//    private ProductOrderDTO convertToDTO(ProductOrder productOrder) {
//        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
//        productOrderDTO.setOrderId(productOrder.getId().getOrderId());
//        productOrderDTO.setProductId(productOrder.getId().getProductId());
//        productOrderDTO.setQuantity(productOrder.getQuantity());
//        productOrderDTO.setPrice(productOrder.getPrice());
//        productOrderDTO.setVat(productOrder.getVat());
//        return productOrderDTO;
//    }
//
//    // Method to convert ProductOrderDTO to ProductOrder
//    private ProductOrder convertToEntity(ProductOrderDTO productOrderDTO) {
//        ProductOrder productOrder = new ProductOrder();
//
//        ProductOrderKey productOrderKey = new ProductOrderKey();
//
//        productOrderKey.setOrderId(productOrderDTO.getOrderId());
//        productOrderKey.setProductId(productOrderDTO.getProductId());
//
//        productOrder.setId(productOrderKey);
//
//        productOrder.setQuantity(productOrderDTO.getQuantity());
//        productOrder.setPrice(productOrderDTO.getPrice());
//        productOrder.setVat(productOrderDTO.getVat());
//        productOrder.setProduct(productRepository.findById(productOrderDTO.getProductId())
//                .orElseThrow(() -> new ResourceNotFoundException("Product" ,"id" , productOrderDTO.getOrderId())));
//        productOrder.setOrder(orderRepository.findById(productOrderDTO.getOrderId())
//                .orElseThrow(() -> new ResourceNotFoundException("Order" , "id" ,productOrderDTO.getProductId())));
//        return productOrder;
//    }
//}

//@Service
//public class ProductOrderServiceImpl implements ProductOrderService {
//
//    @Autowired
//    private ProductOrderRepository productOrderRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public List<ProductOrderDTO> getProductsOfOrder(Integer orderId) {
//        return productOrderRepository.findByOrderId(orderId).stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ProductOrderDTO getProductOfOrder(Integer orderId, Integer productId) {
//       // ProductOrder productOrder = productOrderRepository.findById(new ProductOrderKey(productId, orderId))
//                //.orElseThrow(() -> new ResourceNotFoundException("Product Order " ,"productId: "+productId + " orderId: "+orderId  , productId));
//    //    return convertToDTO(productOrder);
//        return null;
//    }
//
//    @Override
//    public ProductOrderDTO addProductToOrder(Integer orderId, ProductOrderDTO productOrderDTO) {
//        ProductOrder productOrder = convertToEntity(productOrderDTO);
//      //  productOrder.setId(new ProductOrderKey(productOrderDTO.getProductId(), orderId));
//        return convertToDTO(productOrderRepository.save(productOrder));
//    }
//
//    @Override
//    public ProductOrderDTO updateProductOfOrder(Integer orderId, Integer productId, ProductOrderDTO productOrderDTO) {
//        ProductOrder productOrder = convertToEntity(productOrderDTO);
//       // productOrder.setId(new ProductOrderKey(productId, orderId));
//        return convertToDTO(productOrderRepository.save(productOrder));
//    }
//
//    @Override
//    public void deleteProductOfOrder(Integer orderId, Integer productId) {
//      //  productOrderRepository.deleteById(new ProductOrderKey(productId, orderId));
//    }
//
//    @Override
//    public List<ProductOrderDTO> getOrdersOfProduct(Integer productId) {
//        return productOrderRepository.findByProductId(productId).stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ProductOrderDTO getOrderOfProduct(Integer productId, Integer orderId) {
//     //   ProductOrder productOrder = productOrderRepository.findById(new ProductOrderKey(productId, orderId))
//                //.orElseThrow(() -> new ResourceNotFoundException("Product Order " ,"productId: "+productId + " orderId: "+orderId  , productId));
//       // return convertToDTO(productOrder);
//    return null;
//    }
//
//    @Override
//    public ProductOrderDTO addOrderToProduct(Integer productId, ProductOrderDTO productOrderDTO) {
//        ProductOrder productOrder = convertToEntity(productOrderDTO);
//        //productOrder.setId(new ProductOrderKey(productId, productOrderDTO.getOrderId()));
//        return convertToDTO(productOrderRepository.save(productOrder));
//    }
//
//    @Override
//    public ProductOrderDTO updateOrderOfProduct(Integer productId, Integer orderId, ProductOrderDTO productOrderDTO) {
//        ProductOrder productOrder = convertToEntity(productOrderDTO);
//       // productOrder.setId(new ProductOrderKey(productId, orderId));
//        return convertToDTO(productOrderRepository.save(productOrder));
//    }
//
//    @Override
//    public void deleteOrderOfProduct(Integer productId, Integer orderId) {
//        //productOrderRepository.deleteById(new ProductOrderKey(productId, orderId));
//    }
//
//    // Method to convert ProductOrder to ProductOrderDTO
//    private ProductOrderDTO convertToDTO(ProductOrder productOrder) {
//        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
//    //    productOrderDTO.setOrderId(productOrder.getId().getOrderId());
//     //   productOrderDTO.setProductId(productOrder.getId().getProductId());
//        productOrderDTO.setQuantity(productOrder.getQuantity());
//        productOrderDTO.setPrice(productOrder.getPrice());
//        productOrderDTO.setVat(productOrder.getVat());
//        return productOrderDTO;
//    }
//
//    // Method to convert ProductOrderDTO to ProductOrder
//    private ProductOrder convertToEntity(ProductOrderDTO productOrderDTO) {
//        ProductOrder productOrder = new ProductOrder();
//     //   productOrder.setId(new ProductOrderKey(productOrderDTO.getProductId(), productOrderDTO.getOrderId()));
//        productOrder.setQuantity(productOrderDTO.getQuantity());
//        productOrder.setPrice(productOrderDTO.getPrice());
//        productOrder.setVat(productOrderDTO.getVat());
//        productOrder.setProduct(productRepository.findById(productOrderDTO.getProductId())
//                .orElseThrow(() -> new ResourceNotFoundException("Product" , "id" , productOrderDTO.getProductId())));
//        productOrder.setOrder(orderRepository.findById(productOrderDTO.getOrderId())
//                .orElseThrow(() -> new ResourceNotFoundException("Order" , "id" ,productOrderDTO.getOrderId())));
//        return productOrder;
//    }
//}

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductOrderDTO> getProductsOfOrder(Integer orderId) {
        return productOrderRepository.findByOrderId(orderId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductOrderDTO getProductOfOrder(Integer orderId, Integer productId) {
        ProductOrder productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Order " ,"productId: "+productId + " orderId: "+orderId  , productId));
        return convertToDTO(productOrder);
    }

    @Override
    public ProductOrderDTO addProductToOrder(Integer orderId, ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = convertToEntity(productOrderDTO);
        productOrder.getOrder().setId(orderId);
        return convertToDTO(productOrderRepository.save(productOrder));
    }

    @Override
    public ProductOrderDTO updateProductOfOrder(Integer orderId, Integer productId, ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Order " ,"productId: "+productId + " orderId: "+orderId  , productId));

        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setVat(productOrderDTO.getVat());

        return convertToDTO(productOrderRepository.save(productOrder));
    }

    @Override
    public void deleteProductOfOrder(Integer orderId, Integer productId) {
        ProductOrder productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Order " ,"productId: "+productId + " orderId: "+orderId  , productId));
        productOrderRepository.delete(productOrder);
    }

    @Override
    public List<ProductOrderDTO> getOrdersOfProduct(Integer productId) {
        return productOrderRepository.findByProductId(productId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductOrderDTO getOrderOfProduct(Integer productId, Integer orderId) {
        ProductOrder productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Order " ,"productId: "+productId + " orderId: "+orderId  , productId));
        return convertToDTO(productOrder);
    }

    @Override
    public ProductOrderDTO addOrderToProduct(Integer productId, ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = convertToEntity(productOrderDTO);
        productOrder.getProduct().setId(productId);
        return convertToDTO(productOrderRepository.save(productOrder));
    }

    @Override
    public ProductOrderDTO updateOrderOfProduct(Integer productId, Integer orderId, ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Order " ,"productId: "+productId + " orderId: "+orderId  , productId));

        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setVat(productOrderDTO.getVat());

        return convertToDTO(productOrderRepository.save(productOrder));
    }

    @Override
    public void deleteOrderOfProduct(Integer productId, Integer orderId) {
        ProductOrder productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Order not found for orderId: "+orderId + " and productId: "+productId ,"" ,orderId));
        productOrderRepository.delete(productOrder);
    }

    // Method to convert ProductOrder to ProductOrderDTO
    private ProductOrderDTO convertToDTO(ProductOrder productOrder) {
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setOrderId(productOrder.getOrder().getId());
        productOrderDTO.setProductId(productOrder.getProduct().getId());
        productOrderDTO.setQuantity(productOrder.getQuantity());
        productOrderDTO.setPrice(productOrder.getPrice());
        productOrderDTO.setVat(productOrder.getVat());
        return productOrderDTO;
    }

    // Method to convert ProductOrderDTO to ProductOrder
    private ProductOrder convertToEntity(ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = new ProductOrder();

        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setVat(productOrderDTO.getVat());
        productOrder.setProduct(productRepository.findById(productOrderDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product" ,"id" , productOrderDTO.getProductId())));
        productOrder.setOrder(orderRepository.findById(productOrderDTO.getOrderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order" , "id" ,productOrderDTO.getOrderId())));
        return productOrder;
    }
}
