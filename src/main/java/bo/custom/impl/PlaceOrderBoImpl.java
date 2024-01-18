package bo.custom.impl;

import bo.custom.PlaceOrderBo;

import dao.DaoFactory;
import dao.util.DaoType;
import dao.custom.PlaceOrderDao;
import dto.CustomerDto;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    PlaceOrderDao placeOrderDao= DaoFactory.getInstance().getDao(DaoType.PLACE_ORDER_DAO);
    public void save(){
        placeOrderDao.save(new CustomerDto(
                "cus1",
                "dinidu",
                "0763162359",
                "dinidubandara2004@gmail.com",
                "ord1",
                null,
                null
        ));
    }
}