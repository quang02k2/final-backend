package com.example.Web.DTO;

import com.example.Web.model.Category;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
