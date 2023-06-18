package com.example.Web.DTO;

import com.example.Web.model.Category;
import com.example.Web.model.Product;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Data
public class CategoryDTOResponse {
    private Long id;
    private String name;
//    private Long productId;
//    private String productName;

    private List<Map<String,Object>> product;

    public CategoryDTOResponse(Category category){
        this.id = category.getId();
        this.name = category.getName();
//        if(!ObjectUtils.isEmpty(category.getProduct())) {
////          Product  product = category.getProduct();
//          this.productId = product.getId();
//          this.productName = product.getName();
            this.product = new ArrayList<>();
            for (Product product1 : category.getProduct()
            ) {
                this.product.add(Map.of("productId", product1.getId()));
                this.product.add(Map.of("productName", product1.getName()));
            }
//        }



    }

}
