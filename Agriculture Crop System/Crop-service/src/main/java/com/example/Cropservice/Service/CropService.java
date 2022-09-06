package com.example.Cropservice.Service;

import com.example.Cropservice.Model.Crop;
import com.example.Cropservice.Repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    public CropRepository croprepo;

    public List<Crop> getAllproduct() {
        return croprepo.findAll();

    }

    public Optional<Crop> getProduct(String productid) {

        return croprepo.findById(productid);
    }

    public Crop Addproduct(Crop product) {

        return croprepo.save(product);
    }

    public String updateProduct(Crop product, String productid) {
        Optional<Crop> productData = croprepo.findById(productid);
        if (productData.isPresent()) {
            Crop produ = productData.get();
            produ.setProductName(product.getProductName());
            produ.setProductPrice(product.getProductPrice());
            produ.setProductType(product.getProductType());
            produ.setLocation(product.getLocation());
            this.croprepo.save(produ);
            return "Product details are updated";
        } else {
            return "Product detail is not updated";
        }


    }

    public String deleteProduct(String productid) {
        croprepo.deleteById(productid);
        return productid + " was deleted successfully";
    }

    public List<Crop> getfarmer(String farmeremail) {

        return croprepo.findByFarmerEmail(farmeremail);
    }
}
