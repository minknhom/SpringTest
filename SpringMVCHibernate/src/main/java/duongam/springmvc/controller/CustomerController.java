package duongam.springmvc.controller;

import java.util.List;

import duongam.springmvc.dto.CustomerForCreate;
import duongam.springmvc.dto.CustomerForUpdate;
import duongam.springmvc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import duongam.springmvc.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String list(Model theModel) {
        List<Customer> theCustomers = customerService.getAll();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/add")
    public String addForm(Model theModel) {
        CustomerForCreate customerDTO = new CustomerForCreate();
        theModel.addAttribute("customer", customerDTO);
        return "customer-add-form";
    }

    @PostMapping("/add")
    public String addDatabase(@ModelAttribute("customer") CustomerForCreate customerDTO) {
        customerService.save(customerDTO);
        return "redirect:/customer/list";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("customerId") int theId,
                             Model theModel) {
        CustomerForUpdate customerDTO = customerService.getById(theId);
        theModel.addAttribute("customer", customerDTO);
        return "customer-update-form";
    }

    @PostMapping("/update")
    public String updateDatabase(@ModelAttribute("customer") CustomerForUpdate customerDTO) {
        customerService.update(customerDTO);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {
        customerService.deleteById(theId);
        return "redirect:/customer/list";
    }
}
