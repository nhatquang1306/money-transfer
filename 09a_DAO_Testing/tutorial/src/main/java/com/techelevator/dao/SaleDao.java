package com.techelevator.dao;

import com.techelevator.model.Sale;

import java.util.List;

public interface SaleDao {

    Sale getSaleById(int saleId);

    List<Sale> getSalesByCustomerId(int customerId);

    Sale createSale(Sale sale);

    Sale updateSale(Sale sale);

    int deleteSaleById(int saleId);
}
