package edu.icet.crm.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class OrdersEntity {
    public class OrdersEntity {
        private String orderDate;

        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        private CustomerEntity customer;

        @Column(name = "note")
        private String note;

        @Column(name = "order_status")
        private String orderStatus;

        @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
        private List<ItemsEntity> items;

        public OrdersEntity(String orderId, String orderDate, String note,String orderStatus) {
            this.orderId = orderId;
            this.orderDate = orderDate;
            this.note = note;
            this.orderStatus=orderStatus;
        }
    }