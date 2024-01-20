package dao.custom;

import dao.SuperDao;
import dto.PlaceOrderDto;

public interface PlaceOrderDao extends SuperDao {
    public void save(PlaceOrderDto PlaceOrderDto);
}
