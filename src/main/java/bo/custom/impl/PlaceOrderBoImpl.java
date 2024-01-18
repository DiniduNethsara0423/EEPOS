package bo.custom.impl;

import bo.custom.PlaceOrderBo;

import dao.DaoFactory;
import dao.util.DaoType;
import dao.custom.PlaceOrderDao;
import dto.CustomerDto;
import dto.tm.PlaceOrderTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    PlaceOrderDao placeOrderDao= DaoFactory.getInstance().getDao(DaoType.PLACE_ORDER_DAO);

    public void save(){
        placeOrderDao.save(new CustomerDto(
                "cus2",
                "dinidu",
                "0763162359",
                "dinidubandara2004@gmail.com",
                "ord1",
                null,
                null
        ));
    }
}