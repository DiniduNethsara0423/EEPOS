package bo.custom.impl;

import bo.custom.PlaceOrderBo;

import dao.DaoFactory;
import dao.util.DaoType;
import dao.custom.PlaceOrderDao;
import dto.CustomerDto;
import dto.OrderDetailsDto;
import dto.PlaceOrderDto;
import dto.tm.PlaceOrderTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    PlaceOrderDao placeOrderDao= DaoFactory.getInstance().getDao(DaoType.PLACE_ORDER_DAO);


    public void save(){	    public void save(){
        PlaceOrderDao placeOrderDao= DaoFactory.getInstance().getDao(DaoType.PLACE_ORDER_DAO);

        public void save(){
            List<OrderDetailsDto> orderDetailsDtoList=new ArrayList<>();
            orderDetailsDtoList.add(new OrderDetailsDto(
                    "itm2",
                    "Tv",
                    "electrical"
            ));
            placeOrderDao.save(new PlaceOrderDto(

                    "cus20",
                    "minura",
                    "0705606683",
                    "mranaweera793@gmail.com",
                    "ord21",
                    "1",
                    "note",
                    orderDetailsDtoList
            ));
        }
    }