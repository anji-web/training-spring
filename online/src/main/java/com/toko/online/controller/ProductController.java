package com.toko.online.controller;

import com.toko.online.model.dto.ProductDto;
import com.toko.online.model.entity.Product;
import com.toko.online.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductController {


  @Autowired
  private ProductService productService;

  @GetMapping("/product")
  public ResponseEntity getProduct(){
    List<Product> product = productService.getProduct();
    ProductDto productDto = new ProductDto();
    productDto.setNamaProduct(product.get(0).getNamaProduct());
    productDto.setKodeProduct(product.get(0).getKodeProduct());
    return ResponseEntity.ok(productDto);
  }

  @PostMapping("/product")
  public String addProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return "data berhasil disimpan";
  }

  @PutMapping("/product")
  public String updateProduct(@RequestBody Product product,@RequestParam("id") int id){
          productService.updateProduct(product, id);
          return "Data berhasil di update";
  }

  @DeleteMapping("/product")
  public String deleteProduct(@RequestParam("id") int id){
    productService.deleteProduct(id);
    return "Data berhasil di hapus";
  }

}
