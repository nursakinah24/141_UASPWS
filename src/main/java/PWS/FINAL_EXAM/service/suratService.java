/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package PWS.FINAL_EXAM.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

import PWS.FINAL_EXAM.model.Surat;

/**
 *
 * @author Asus
 */
@Service
public class suratService {
    private static final String COLLECTION_NAME = "Surat";
    
    public String save(Surat surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture;
        collectionApiFuture = dbfirestore.collection(COLLECTION_NAME).document(surat.getNo_Surat()).set(surat);

        return collectionApiFuture.get().getUpdateTime().toString() ;
    }

    public Surat getSurat(String No_Surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference=dbfirestore.collection(COLLECTION_NAME).document(No_Surat);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot doc = future.get();

        Surat surat = null;
        
        if(doc.exists()){
            surat = doc.toObject(Surat.class);
        }

        return surat;
    }

    public String update(Surat surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME).document(surat.getNo_Surat()).set(surat);

        return collectionApiFuture.get().getUpdateTime().toString() ;
    }

    public String delete(String No_Surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME).document(No_Surat).delete();

        return "Letter with name : " + No_Surat + " Has been Deleted";
    }

    public List<Surat> getSuratAll() throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference=dbfirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<Surat> suratList=new ArrayList<>();
        Surat surat = null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot doc = future.get();
           surat = doc.toObject(Surat.class);
           suratList.add(surat);
        }
        return suratList;
    }
}
