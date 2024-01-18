package bo.custom.impl;

import bo.custom.PlaceOrderBo;

import dao.DaoFactory;
import dao.util.DaoType;
import dao.custom.PlaceOrderDao;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    PlaceOrderDao placeOrderDao= DaoFactory.getInstance().getDao(DaoType.PLACE_ORDER_DAO);
}