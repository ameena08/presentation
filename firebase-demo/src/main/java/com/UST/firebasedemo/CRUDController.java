package com.UST.firebasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CRUDController {
    @Autowired
    public CRUDService crudService;

    @PostMapping("/create")
    public String createCRUD (@RequestBody CRUD crud)  {
        return crudService.createCRUD(crud);
    }


    @GetMapping("/get")
    public CRUD getCRUD (@RequestParam String documentId) throws ExecutionException, InterruptedException {
        return crudService.getCRUD(documentId);
    }

    @PutMapping("/update")
    public String updateCRUD (@RequestBody CRUD crud) {
        return crudService.updateCRUD(crud);
    }

    @DeleteMapping ("/delete")
    public String deleteCRUD (@RequestParam String documentId)throws ExecutionException, InterruptedException {
        return crudService.deleteCRUD(documentId);
    }


    }


