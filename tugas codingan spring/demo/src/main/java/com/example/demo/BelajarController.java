package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.MahasiswaService;
import com.example.demo.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class BelajarController {
    
    @Autowired
    private MahasiswaService mahasiswaService;
    
    @Autowired
    private JurusanService jurusanService;
    
    @GetMapping("/")
    public String showDashboard(Model model) {
        model.addAttribute("totalMahasiswa", mahasiswaService.getAllMahasiswa().size());
        model.addAttribute("totalJurusan", jurusanService.getAllJurusan().size());
        return "dashboard";
    }
}