package com.example.orderserivce.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="orders")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String productId;

    private Integer qty;

    private Integer unitPrice;

    private Integer totalPrice;


    private String userId;

    private String orderId;

    private Date createdAt;
}
