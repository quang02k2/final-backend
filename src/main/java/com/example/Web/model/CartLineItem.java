package com.example.Web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartLineItem")
public class CartLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isdeleted;
    private int quantity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    @OneToMany(mappedBy = "cartLineItem",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<VariantProduct> variantProducts;

}
