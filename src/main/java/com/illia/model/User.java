package com.illia.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(generator = "USER_GEN")
    @SequenceGenerator(name = "USER_GEN", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "REGISTER_DATE")
    private LocalDateTime registerDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<ProductOrder> productOrders = new ArrayList<>();

    public User() {}




    public void setProductOrder(ProductOrder productOrder) {
        this.productOrders.add(productOrder);
        productOrder.setUser(this);
    }
}