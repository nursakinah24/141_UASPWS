/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS.FINAL_EXAM.firebase;

import jakarta.annotation.PostConstruct;
import java.io.FileInputStream;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

/**
 *
 * @author Asus
 */
@Service
public class connectFirestore {
    
    @PostConstruct
            public void check() {
                FileInputStream serviceAccount = null;
                try{
                    serviceAccount = new FileInputStream("./serviceAccountKey.json");
                    FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://final-exam-a0982-default-rtdb.firebaseio.com")
                    .build();
                    
                FirebaseApp.initializeApp(options);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }




}
