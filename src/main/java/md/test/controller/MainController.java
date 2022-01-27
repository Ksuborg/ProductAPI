package md.test.controller;

import md.test.entity.Product;
import md.test.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        return mainService.addProduct(product);
    }

    @PutMapping("/addProduct")
    public ResponseEntity<?> editProduct(@RequestBody Product product) {
        return mainService.editProduct(product);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(@RequestParam String manufacturer_id) {
        return mainService.getAllProducts(manufacturer_id);
    }

    @GetMapping("/getManufacturers")
    public ResponseEntity<?> getManufacturersByNum(@RequestParam int num) {
        return mainService.getManufacturersByNum(num);
    }
}
