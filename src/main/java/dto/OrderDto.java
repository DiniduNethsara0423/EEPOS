package edu.icet.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderDto {
    private String orderId;
    private String status;
    private String customerId;
    private String orderDate;
    private String note;
}