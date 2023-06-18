package com.example.Web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "oder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String delivery_time;
    private Date oder_date;
    private Double  total_amount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
