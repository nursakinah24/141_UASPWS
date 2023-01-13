/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS.FINAL_EXAM.controller;

import PWS.FINAL_EXAM.model.Surat;
import PWS.FINAL_EXAM.service.suratService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api")
public class SuratController {
    @Autowired
    private suratService suratService;
    
     @GetMapping("/check")
    @ResponseBody
    public String checkAPI(){
        return "hello";
    }

    @PostMapping("/surat")
    public String saveStudent(@RequestBody Surat surat) throws InterruptedException, ExecutionException{
        
        return suratService.save(surat);
        
    }

    @GetMapping("/suratall")
    public List<Surat> viewSuratAll() throws InterruptedException, ExecutionException{
        
        return suratService.getSuratAll();
        
    }

    @GetMapping("/surat/{No_Surat}")
    public Surat viewStudent(@PathVariable String No_Surat) throws InterruptedException, ExecutionException{
        
        return suratService.getSurat(No_Surat);
        
    }

    @PutMapping("/surat")
    public String updateSurat(@RequestBody Surat surat) throws InterruptedException, ExecutionException{
        
        return suratService.update(surat);
        
    }

    @DeleteMapping("/surat/{No_Surat}")
    public String deleteSurat(@PathVariable String No_Surat) throws InterruptedException, ExecutionException{
        
        return suratService.delete(No_Surat);
        
    }
}
