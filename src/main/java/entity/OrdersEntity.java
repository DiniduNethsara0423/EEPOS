package entity;

import Controller.CustomerReportsFormController;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Orders")
public class OrdersEntity {

    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "order_date")
    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_name", nullable = false)
    private CustomerReportsFormController.CustomerEntity customer;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "order")
    private List<ItemsEntity> items;

    public OrdersEntity(String orderId, String orderDate, String note) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.note = note;
    }
}