/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.c.restfull_projects;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HAHAHA
 */
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        honey.setQty("2");
        honey.setPrice("1000");
        productRepo.put(honey.getId(), honey);
        
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        almond.setQty("2");
        almond.setPrice("1000");
        productRepo.put(almond.getId(), almond);
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is delete successsfully", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        
        if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Data tidak ditemukan", HttpStatus.OK);
        }
        else{
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
        }
      
   }
   
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
       
       if(productRepo.containsKey(product.getId())){
           return new ResponseEntity<>("ID TIDAK BOLEH SAMA", HttpStatus.OK);
       }
       
       else {
           productRepo.put(product.getId(), product);
           return new ResponseEntity<>("DATA BERHASIL DITAMBAHKAN", HttpStatus.CREATED);
       }
      
      
   }
   
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
}
