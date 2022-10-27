package com.example.test.controller;

import com.example.test.infrastructure.reponse.ProductReponse;
import com.example.test.infrastructure.request.ProductRequest;
import com.example.test.model.Brand;
import com.example.test.model.Product;
import com.example.test.model.Status;
import com.example.test.model.SubCategory;
import com.example.test.repository.*;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductReponseController {

    @Autowired
    private ProductReponseRepository productReponseRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private SubcategoryRepositoryName subCategoryRepository;

    @Autowired
    private StatusRepository statusRepository;




    @GetMapping("/{id}")
    public String getList(ModelMap modelMap,@PathVariable(name = "id") Long id) {
        ProductReponse productReponses = productReponseRepository.getByProductId(id);
        modelMap.addAttribute("productReponses",productReponses);
        return "showProduct";
    }


    @GetMapping(value = "/addProduct")
    public String showAddProduct(Model model) {
        ProductRequest productReponse = new ProductRequest();
        model.addAttribute("productReponse", productReponse);
        return "addProduct";
    }

    @PostMapping(value = "/addProduct")
    public String saveProduct(Model model, //
                              @ModelAttribute("productReponse") @Valid @RequestBody ProductRequest productRequest, BindingResult result) {
    if (result.hasErrors()) {
        return "addProduct";
    }

        productService.insert(productRequest);
        return "redirect:/page";
    }



    @ModelAttribute(name = "brandName")
    public List<Brand> getListBrand() {
        return brandRepository.findAll();
    }

    @ModelAttribute(name = "subCategoryName")
    public List<SubCategory> getListSubcategoryNAme() {
        return subCategoryRepository.findAll();
    }

    @ModelAttribute(name = "statusName")
    public List<Status> getListStatusName() {
        return statusRepository.findAll();
    }





    @GetMapping(value = "/updateProduct/{id}")
    public String showUpdateProduct(Model model,@PathVariable(name = "id") Long idd) {
//        ProductRequest productReponse = new ProductRequest();
//        model.addAttribute("productReponse", productReponse);
        model.addAttribute("heheeh",productReponseRepository.getByProductId(idd));
        model.addAttribute("iddd",idd);
        return "updateProduct";
    }


    @PostMapping(value = "/updateProduct/{id}")
    public String updateProduct(Model model, //
                                @ModelAttribute("personForm") @RequestBody ProductRequest productRequest,@PathVariable(name = "id") Long id) {


        productService.update(id,productRequest);
        return "redirect:/page";
    }

    @GetMapping("/page")
    public String paginate(Model model, @RequestParam("p")Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0),3);
        Page<ProductReponse> page = productService.getList(pageable);

        model.addAttribute("products", page);
        return "product";
    }

}
