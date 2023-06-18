package com.example.Web.repository;

import com.example.Web.model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

//    List<Category> findByDeletedTrue(Pageable pageable);
//    List<Category> findByDeletedFalse(Pageable pageable);


    // cach 2

//    List<Category> findAllByDeleted(boolean isDelete);
}
