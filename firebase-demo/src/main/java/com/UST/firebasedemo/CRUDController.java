package com.UST.firebasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class CRUDController {
    @Autowired
    public CRUDService crudService;

    @PostMapping("/create")
    public String createCRUD (@RequestBody CRUD crud)  {
        return crudService.createCRUD(crud);
    }


    @GetMapping("/get/{documentId}")
    public CRUD getCRUD (@PathVariable("documentId") String documentId) throws ExecutionException, InterruptedException {
        return crudService.getCRUD(documentId);
    }
    @GetMapping("/get")
    public List<CRUD> getallCRUD () throws ExecutionException, InterruptedException {
        return crudService.getallCRUD();
    }

    @PutMapping("/update")
    public String updateCRUD (@RequestBody CRUD crud) {
        return crudService.updateCRUD(crud);
    }

    @DeleteMapping ("/delete/{documentId}")
    public String deleteCRUD (@PathVariable("documentId") String documentId)throws ExecutionException, InterruptedException {
        return crudService.deleteCRUD(documentId);
    }


    }


