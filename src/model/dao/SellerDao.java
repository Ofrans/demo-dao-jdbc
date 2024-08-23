package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller Seller);
    void update(Seller Seller);
    void deleteById(Seller Seller);
    Seller findById(Integer id);
    List<Seller> findAll();
}
