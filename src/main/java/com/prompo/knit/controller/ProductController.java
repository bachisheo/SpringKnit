package com.prompo.knit.controller;

import com.prompo.knit.Dao.ProductService;
import com.prompo.knit.model.Product;
import com.prompo.knit.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller

public class ProductController {
    private final String UPLOAD_DIR = "./src/main/resources/static/uploads";
    @Autowired
    ProductService productService;
    @Autowired
    SellerRepository sellers;

    /**
     * Просмотр списка всех товаров в системе
     * @param vars
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model vars) {
        /* Заполняем модель для представления */
        vars.addAttribute("products", productService.getAll());
        /* Возвращаем имя шаблона, который надо рендерить */
        return "index";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/e")
    public String empty() {
        /* Возвращаем имя шаблона, который надо рендерить */
        return "empty_template";
    }

    /**
     * Подробный просмотр информации о товаре
     * @param productid id запрашиваемого товара
     * @param vars
     * @return
     */
    @GetMapping("/product/{productid}")
    private String getProduct(@PathVariable("productid") Long productid, Model vars){
        //todo проверка на случай, если файл не найден
        vars.addAttribute("product", productService.find(productid).get());
        return "product_details";
    }

    /**
     * Получение страницы редактирования продукта
     * @param productid
     * @param vars
     * @return
     */
    @GetMapping("/edit/{productid}")
    private String editProduct(@PathVariable("productid") Long productid, Model vars){
        vars.addAttribute("product", productService.find(productid).get());
        return "product_edit";
    }

    /**
     * Сохранение результата изменения продукта
     * @param product
     * @param vars
     * @param productid
     * @return
     */
    @PostMapping("/edit/{productid}")
    public String editProduct(@ModelAttribute Product product, Model vars, @PathVariable String productid) {
        Product original = productService.find(Long.valueOf(productid)).get();
        original.setName(product.getName());
        original.setCount(product.getCount());
        original.setDescription(product.getDescription());
        original.setPrice(product.getPrice());
        productService.save(original);
        vars.addAttribute("product", original);
        return "product_details";
    }
    /**
     * Получение страницы для управления объявлениями
     * @param vars
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/monitor")
    public String monitor(Model vars) {
        vars.addAttribute("products", productService.getAll());
        return "product_monitor";
    }

    /**
     * Удаление объекта
     * @return
     */
    @GetMapping("/delete/{productid}")
    public String delete(@PathVariable String productid, Model vars) {
        productService.deleteById(Long.valueOf(productid));
        return "redirect:/monitor";
    }

    /**
     * Загрузка страницы для добавления объекта
     * @return
     */
    @GetMapping("/create")
    public String create(Model vars) {
        vars.addAttribute("product", new Product());
        return "product_create";
    }
    /**
     * Добавление объекта в бд
     * @return
     */
    @PostMapping ("/create")
    public String create(@ModelAttribute Product product, Model vars) {
        product.setImage("def.png");
        product.setSeller(sellers.findAll().get(0));
        productService.save(product);
        return "redirect:/monitor";
    }

    @PostMapping("/upload")
    public String uploadFile(@ModelAttribute("file") MultipartFile file) throws IOException {

        // check if file is empty
        if (file.isEmpty()) {
           return "redirect:/";
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        return "redirect:/";
    }

}