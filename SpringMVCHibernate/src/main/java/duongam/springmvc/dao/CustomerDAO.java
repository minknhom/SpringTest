package duongam.springmvc.dao;

import duongam.springmvc.dto.CustomerForCreate;
import duongam.springmvc.dto.CustomerForUpdate;
import duongam.springmvc.entity.Customer;

import java.util.List;


public interface CustomerDAO {

    public List<Customer> getAll();

    public void save(Customer customer);

    public void update(Customer customer);

    public Customer getById(int theId);

    public void deleteById(int theId);
}
