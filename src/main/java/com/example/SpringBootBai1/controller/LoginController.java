package com.example.SpringBootBai1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import com.example.SpringBootBai1.model.entity.Product;
import com.example.SpringBootBai1.model.entity.User;
import com.example.SpringBootBai1.model.repo.LoginRepo;
import com.example.SpringBootBai1.model.repo.ProductRepo;

import jakarta.servlet.http.HttpSession;
@Controller
public class LoginController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    LoginRepo loginRepo;
    @GetMapping("/")
    public String ShowIndex(Model model) throws Exception {
        ArrayList<Product> plist = productRepo.getAllProduct();
        model.addAttribute("ProductList", plist);
        return "public/index";
    }

    @GetMapping("/Login")
    public String ShowLogin(){
        return "public/Login";
    }

    @GetMapping("/Logout")
    public String Logout(HttpSession httpSession){
        httpSession.removeAttribute("UserAfterLogin");
        return "redirect:/";
    }

    @PostMapping("/LoginToSystem")
    public String LoginToSystem(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) throws Exception{
        User user = loginRepo.checkLogin(username, password);
        if (user == null) {
            return "public/Login";
        } else {
            httpSession.setAttribute("UserAfterLogin", user);
            return "redirect:/";
        }
    }
}
