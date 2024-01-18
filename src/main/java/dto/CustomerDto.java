package dto;


import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDto {
    private String customerId;
    private String customerName;
    private String contactNumber;
    private String email;
    private String orderId;
    private List<OrderDto> orderDtoList;
    private List<OrderDetailsDto> orderDetailsDtoList;//optional???
}