package bo.custom;

import dto.PlaceOrderDto;

public interface PlaceOrderBo {
    String getLastOrderId();

    int getLstItemId();

    Object getLastCustomerId();

    void save(PlaceOrderDto placeOrderDto);
}
