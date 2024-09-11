package com.example.SpringBootBai1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBootBai1.model.entity.Product;
import com.example.SpringBootBai1.model.entity.TypeProduct;
import com.example.SpringBootBai1.model.repo.ProductRepo;
import com.example.SpringBootBai1.model.repo.TypeProductRepo;

@Controller
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    TypeProductRepo typeProductRepo;

    @GetMapping("/ViewDetail/{id}")
    public String ViewDetail(@PathVariable("id") int id, Model model) throws Exception {
        Product product = productRepo.getProductBypid(id);
        model.addAttribute("ProducDetail", product);
        return "public/ViewDeTail";
    }

    // -------------------------------------------------------------------------------------------//
    // ADD PRODUCT
    @GetMapping("/ShowAddProduct")
    public String ShowAddProduct(Model model) throws Exception {
        ArrayList<TypeProduct> typeList = typeProductRepo.getAllTypeProduct();
        model.addAttribute("TypeList", typeList);
        return "Product/AddProduct";
    }

    @PostMapping("/AddProducts")
    public String AddProduct(@RequestParam("Name") String pName, @RequestParam("Type") int tid,
            @RequestParam("Price") double price, @RequestParam("Quantity") int quantity,
            @RequestParam("Img") String img) throws Exception {
        TypeProduct typeProduct = typeProductRepo.getTypeProductByProductId(tid);
        Product product = new Product(0, pName, typeProduct, price, quantity, img);
        System.out.println(typeProduct.getTName());
        productRepo.AddProduct(product);
        return "redirect:/";
    }

    // -------------------------------------------------------------------------------------------//
    // EDIT PRODUCT
    @GetMapping("/ShowEditProduct/{id}")
    public String ShowEditProduct(Model model, @PathVariable("id") int pid) throws Exception {
        ArrayList<TypeProduct> typeList = typeProductRepo.getAllTypeProduct();
        model.addAttribute("TypeList", typeList);
        Product product = productRepo.getProductBypid(pid);
        model.addAttribute("Product", product);
        return "Product/EditProduct";
    }

    @PostMapping("/EditProducts")
    public String EidtProduct(@RequestParam("pid") int pid, @RequestParam("Name") String pName, @RequestParam("Type") int tid,
            @RequestParam("Price") double price, @RequestParam("Quantity") int quantity,
            @RequestParam("Img") String img) throws Exception {
        TypeProduct typeProduct = typeProductRepo.getTypeProductByProductId(tid);
        Product product = new Product(pid, pName, typeProduct, price, quantity, img);
        System.out.println(typeProduct.getTName());
        productRepo.updateProductBypid(product);
        return "redirect:/";
    }

}
