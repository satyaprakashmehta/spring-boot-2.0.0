package com.sp.mehta.applications.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sp.mehta.applications.web.model.Product;

@Controller
public class DemoProductController
{
    @RequestMapping("/save-product")
    public String uploadResources( HttpServletRequest servletRequest,
                                 @ModelAttribute Product product,
                                 Model model)
    {
        //Get the uploaded files and store them
        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0)
        {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
 
                File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
                try
                {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
 
        // Here, you can save the product details in database
         
        model.addAttribute("product", product);
        return "viewProductDetail";
    }
     
    @RequestMapping(value = "/product-input-form")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }
}