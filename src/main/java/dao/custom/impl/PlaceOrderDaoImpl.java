package dao.custom.impl;

import dao.custom.PlaceOrderDao;
import dao.util.HibernateUtil;
import dto.OrderDetailsDto;
import dto.PlaceOrderDto;
import entity.CustomerEntity;
import entity.ItemsEntity;
import entity.OrdersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceOrderDaoImpl implements PlaceOrderDao {
    public void save(PlaceOrderDto placeOrderDto){
        Session session= HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        CustomerEntity customerEntity=new CustomerEntity(

                placeOrderDto.getCustomerId(),
                placeOrderDto.getCustomerName(),
                placeOrderDto.getEmail(),
                placeOrderDto.getContactNumber()
        );

        OrdersEntity ordersEntity = new OrdersEntity(

                placeOrderDto.getOrderId(),
                placeOrderDto.getDate(),
                placeOrderDto.getNote(),
                "pending"
        );
        ordersEntity.setCustomer(customerEntity);

        List<ItemsEntity> itemsEntities=new ArrayList<>();

        for(OrderDetailsDto dto:placeOrderDto.getOrderDetailsDtoList()){

            itemsEntities.add( new ItemsEntity(
                    dto.getItemCode(),
                    dto.getItemName(),
                    dto.getCategory(),
                    "pending"
            ));
        }

        ordersEntity.setItems(itemsEntities);
        customerEntity.setOrders(Arrays.asList(ordersEntity));

        session.save(customerEntity);
        System.out.println(customerEntity);

        transaction.commit();
        session.close();
    }
}