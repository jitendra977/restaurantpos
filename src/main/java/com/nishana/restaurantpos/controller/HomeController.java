package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.API;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        List<API> apiList = Arrays.asList(
                new API("GET CUSTOMER", "Retrieve customer information", "/customer/"),
                new API("GET MENU", "Retrieve menu details", "/menu/"),
                new API("GET CATEGORY", "Retrieve category details", "/category/"),
                new API("POST CUSTOMER", "Add a new customer", "/customer/"),
                new API("GET TABLE", "Retrieve table details", "/restaurant-table/")
        );
        model.addAttribute("apiList", apiList);
        return "index";
    }

    @GetMapping("/post")
    public String postPage() {
        return "post";
    }
}
