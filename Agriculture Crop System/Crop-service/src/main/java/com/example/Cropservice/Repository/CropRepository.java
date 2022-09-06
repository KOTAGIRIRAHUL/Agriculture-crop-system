package com.example.Cropservice.Repository;

import com.example.Cropservice.Model.Crop;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CropRepository  extends MongoRepository<Crop, String> {

    public List<Crop> findByFarmerEmail(String farmeremail);

    public void delete(Crop foundproduct);
}