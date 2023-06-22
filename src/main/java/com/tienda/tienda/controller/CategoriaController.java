/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.controller;

import com.tienda.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    
    @Autowired
    private CategoriaService categoriaService;
   
    @GetMapping("/listado")
    public String listado(Model model){
      var categorias = categoriaService.getCategorias(false);

        model.addAttribute("categorias",
                categorias);
         model.addAttribute("totalcateogiras",
                categorias.size());

      
        return "/categoria/listado";
        
    }
}
