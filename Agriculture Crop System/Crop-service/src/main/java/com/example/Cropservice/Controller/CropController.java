package com.example.Cropservice.Controller;

import com.example.Cropservice.Model.Crop;
import com.example.Cropservice.Service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/crop")
@RestController
public class CropController {

    @Autowired
    public CropService cropService;

    @GetMapping("/list")
    public ResponseEntity<List<Crop>> getAllproduct()
    {
        try {
            return new ResponseEntity<>(cropService.getAllproduct(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Crop>> getProduct(@PathVariable("id") String productid)
    {
        try {
            return new ResponseEntity<>(cropService.getProduct(productid),HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/farmer/{femail}")
    public ResponseEntity<List<Crop>> getfarmer(@PathVariable("femail") String farmeremail)
    {
        try
        {
            return new ResponseEntity<>(cropService.getfarmer(farmeremail),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/list/add")
    public ResponseEntity<Crop> Addproduct(@RequestBody Crop crop)
    {
        try
        {
            return new ResponseEntity<>(cropService.Addproduct(crop),HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/list/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Crop crop ,@PathVariable("id") String productid)
    {
        try
        {
            return new ResponseEntity<>(cropService.updateProduct(crop,productid),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String productid)
    {
        try
        {
            cropService.deleteProduct(productid);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productid+" was deleted",HttpStatus.OK);
    }
}
