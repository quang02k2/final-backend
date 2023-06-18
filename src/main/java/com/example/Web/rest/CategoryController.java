package com.example.Web.rest;

import com.example.Web.DTO.CategoryDTO;
import com.example.Web.DTO.CategoryDTOResponse;
import com.example.Web.contans.ReponsitoryCode;
import com.example.Web.model.Category;
import com.example.Web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "category")
public class CategoryController extends BaseRestCotroller{
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCategory(){
        try {
            List<Category> categories = this.categoryRepository.findAll();
            List<CategoryDTO> responses = categories.stream().map(CategoryDTO::new).toList();
            return super.success(responses);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.error(ReponsitoryCode.NOT_FOUND.getCode(), ReponsitoryCode.NOT_FOUND.getMessage());
    }


        @GetMapping()
    public ResponseEntity<?> getAllCategory(@RequestParam(defaultValue = "0") Integer offset,
                                            @RequestParam(defaultValue = "100") Integer limit){
        try {
            Pageable pageable = PageRequest.of(offset,limit);
            List<Category> categories;
            categories = this.categoryRepository.findAll(pageable).stream().map(x->x).toList();
            List<CategoryDTOResponse> responses = categories.stream().map(CategoryDTOResponse::new).toList();
            return super.success(responses);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.error(ReponsitoryCode.NOT_FOUND.getCode(), ReponsitoryCode.NOT_FOUND.getMessage());
    }


//
//    @GetMapping
//    public ResponseEntity<?> getAllCategoryProduct(@RequestParam(defaultValue = "-1") Integer status,
//                                            @RequestParam(defaultValue = "0") Integer offset,
//                                            @RequestParam(defaultValue = "100") Integer limit,
//                                            @RequestParam(defaultValue = "") String sortByProductId ){
//        try {
//            if(!Arrays.asList(-1,0,1).contains(status)){
//                return super.error(ReponsitoryCode.NOT_FOUND.getCode(), ReponsitoryCode.NOT_FOUND.getMessage());
//            }
//
//            Pageable pageable = PageRequest.of(offset,limit);
//            List<Sort.Order> orders = new ArrayList<>();
//            if(!ObjectUtils.isEmpty(sortByProductId)){
//                orders.add(new Sort.Order(convertDirection(sortByProductId),"name"));
//            }
//            if(!orders.isEmpty()){
//                pageable = PageRequest.of(offset,limit,Sort.by(orders));
//            }
//            List<Category> categories;
//            if(status == -1){
//                categories = this.categoryRepository.findAll(pageable).stream().map(x->x).toList();
//            }else if (status == 0 ){
//                categories = this.categoryRepository.findByDeletedFalse(pageable);
//            }else {
//                categories = this.categoryRepository.findByDeletedTrue(pageable);
//            }
//            List<CategoryDTOResponse> responses = categories.stream().map(CategoryDTOResponse::new).toList();
//            return super.success(responses);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return super.error(ReponsitoryCode.NO_CONTENT.getCode(),ReponsitoryCode.NO_CONTENT.getMessage());
//    }
//
//
//
//
//    private static Sort.Direction convertDirection(String direction){
//        return direction.equalsIgnoreCase("ASC")? Sort.Direction.ASC: Sort.Direction.DESC;
//    }


}
