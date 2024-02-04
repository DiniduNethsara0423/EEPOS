package edu.icet.crm.bo.custom;

import edu.icet.crm.bo.SuperBo;

import java.util.List;

public interface CustomerReportsViewBo extends SuperBo {
    List<CustomerDto> getCustomers();
    boolean deleteCustomer(String id);
}
