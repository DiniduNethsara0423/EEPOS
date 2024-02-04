package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Item")
public class ItemsEntity {
    @@ -27,18 +26,14 @@ public class ItemsEntity {
        @Column(name = "status")
        private String status;

        @ManyToOne
        @JoinColumn(name = "order_id", nullable = false)
        private OrdersEntity order;

        public ItemsEntity(String itemId, String name, String category, String status) {
            this.itemId = itemId;
            this.name = name;
            this.category = category;
            this.status = status;
        }
    }