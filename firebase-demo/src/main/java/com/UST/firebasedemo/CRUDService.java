package com.UST.firebasedemo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CRUDService {

    public String createCRUD(CRUD crud)  {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("crud_user").document(crud.getDocumentId()).set(crud);

    return "Successfully created :  " + crud.getDocumentId();
    }

    public CRUD getCRUD(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("crud_user").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        CRUD crud;
        if(document.exists()){
            crud=document.toObject(CRUD.class);
            return crud;
        }
        return null;
    }

    public String updateCRUD(CRUD crud) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("crud_user").document(crud.getDocumentId()).set(crud);
        return "successfully updated :  " + crud.getDocumentId();
    }

    public String deleteCRUD(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("crud_user").document(documentId);
        ApiFuture<WriteResult> future = documentReference.delete();
        future.get();

        return "successfully deleted: " + documentId;
    }


    public List<CRUD> getallCRUD() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFirestore.collection("crud_user");
        ApiFuture<QuerySnapshot> future = collectionReference.get();
        QuerySnapshot querySnapshot = future.get();

        List<CRUD> crudList = new ArrayList<>();
        for (DocumentSnapshot document : querySnapshot.getDocuments()) {
            if (document.exists()) {
                CRUD crud = document.toObject(CRUD.class);
                crudList.add(crud);
            }
        }

        return crudList;
    }

}
