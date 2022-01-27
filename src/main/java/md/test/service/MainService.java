package md.test.service;

import md.test.entity.Product;
import md.test.repository.ManufacturerRepository;
import md.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public MainService(ManufacturerRepository manufacturerRepository, ProductRepository productRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<?> addProduct(Product product) {
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> editProduct(Product product) {
        if (product.getProduct_id() == null || product.getManufacturer_id() == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean isProductExists = productRepository.existsById(product.getProduct_id());
        if (!isProductExists) {
            return ResponseEntity.notFound().build();
        }

        Product productFromDB = productRepository.getById(product.getProduct_id());
        productFromDB.setProduct_id(product.getProduct_id());
        productFromDB.setProduct_name(product.getProduct_name());
        productFromDB.setManufacturer_id(product.getManufacturer_id());
        productRepository.save(productFromDB);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getAllProducts(String m_id) {
        List<Product> products = productRepository.findAllByManufacturerId(m_id);
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<?> getManufacturersByNum(int num) {
        return ResponseEntity.ok(manufacturerRepository.findManufacturersByNum(num));
    }
}