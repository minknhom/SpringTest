package duongam.springmvc.service;

import java.util.List;

import duongam.springmvc.dto.CustomerForCreate;
import duongam.springmvc.dao.CustomerDAO;
import duongam.springmvc.dto.CustomerForUpdate;
import duongam.springmvc.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    @Transactional
    public void save(CustomerForCreate customerDTO) {
        Customer theCustomer = modelMapper.map(customerDTO, Customer.class);
        customerDAO.save(theCustomer);
    }

    @Override
    @Transactional
    public void update(CustomerForUpdate customerDTO) {
        Customer theCustomer = modelMapper.map(customerDTO, Customer.class);
        customerDAO.update(theCustomer);
    }

    @Override
    @Transactional
    public CustomerForUpdate getById(int theId) {
        Customer customer = customerDAO.getById(theId);
        CustomerForUpdate customerDTO = modelMapper.map(customer, CustomerForUpdate.class);
        return customerDTO;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerDAO.deleteById(theId);
    }
}
