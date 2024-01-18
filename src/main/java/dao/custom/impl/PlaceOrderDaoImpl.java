package dao.custom.impl;

import dao.custom.PlaceOrderDao;
import dao.util.HibernateUtil;
import dto.CustomerDto;
import entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlaceOrderDaoImpl implements PlaceOrderDao {
    public void save(CustomerDto customerDto){
        Session session= HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(new CustomerEntity(
                customerDto.getOrderId(),
                customerDto.getCustomerName(),
                customerDto.getEmail(),
                customerDto.getContactNumber()
        ));

        transaction.commit();
        session.close();
    }
}
