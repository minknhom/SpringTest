package duongam.springmvc.service;

import duongam.springmvc.dto.CustomerForCreate;
import duongam.springmvc.dto.CustomerForUpdate;
import duongam.springmvc.entity.Customer;

import java.util.List;


public interface CustomerService {

    public List<Customer> getAll();

    public void save(CustomerForCreate customerDTO);

    public void update(CustomerForUpdate customerDTO);

    public CustomerForUpdate getById(int theId);

    public void deleteById(int theId);

}
