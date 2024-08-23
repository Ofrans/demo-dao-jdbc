package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println(" === Test 1: findById ======");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n === Test 2: findByDepartment ======");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n === Test 3: findAll ======");
		list = sellerDao.findAll();
		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n === Test 4: seller insert ======");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}
}
