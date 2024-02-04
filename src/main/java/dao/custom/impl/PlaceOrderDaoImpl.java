package dao.custom.impl;

import dao.custom.PlaceOrderDao;
import dao.util.HibernateUtil;
import dto.OrderDetailsDto;
import dto.PlaceOrderDto;
import entity.CustomerEntity;
import entity.OrdersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderDaoImpl implements PlaceOrderDao {

    public void save(PlaceOrderDto placeOrderDto) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Save Customer
            CustomerEntity customerEntity = new CustomerEntity(
                    placeOrderDto.getCustomerId(),
                    placeOrderDto.getCustomerName(),
                    placeOrderDto.getEmail(),
                    placeOrderDto.getContactNumber()
            );
            session.save(customerEntity);

            // Save Order
            OrdersEntity ordersEntity = new OrdersEntity(
                    placeOrderDto.getOrderId(),
                    placeOrderDto.getDate(),
                    placeOrderDto.getNote(),
                    "pending"
            );
            ordersEntity.setCustomer(customerEntity);  // Set the association manually
            session.save(ordersEntity);

            // Save Items
            List<ItemsEntity> itemsEntities = new ArrayList<>();
            for (OrderDetailsDto dto : placeOrderDto.getOrderDetailsDtoList()) {
                ItemsEntity itemsEntity = new ItemsEntity(
                        dto.getItemCode(),
                        dto.getItemName(),
                        dto.getCategory(),
                        "pending"
                );
                itemsEntity.setOrder(ordersEntity);  // Set the association manually
                itemsEntities.add(itemsEntity);
                session.save(itemsEntity);
            }

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            transaction.rollback();
            e.printStackTrace(); // Handle the exception appropriately in a production environment
        } finally {
            session.close();
        }
    }
}