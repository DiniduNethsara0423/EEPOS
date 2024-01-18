package dao.custom;

import dao.SuperDao;
import dto.CustomerDto;

public interface PlaceOrderDao extends SuperDao {
    public void save(CustomerDto customerDto);
}
