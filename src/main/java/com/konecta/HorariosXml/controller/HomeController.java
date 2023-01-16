package com.konecta.HorariosXml.controller;

import com.konecta.HorariosXml.model.HorarioModel;
import com.konecta.HorariosXml.repository.HorarioCrud;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @author yeison
 */
@Controller
public class HomeController {

    @Autowired
    private HorarioCrud horarioCrud;

    @GetMapping("/")
    public String vistaPrincipal() {

        return "index";
    }
    
    @ResponseBody //Retornar datos a la vista
    @PostMapping("/consult")
    public List<String> consultClientes() { //ArrayList para retornar objetos a la vista
       
        List<String> clients = horarioCrud.clientesAll();
        return clients;
    }
    
    @ResponseBody //Retornar datos a la vista
    @PostMapping("/consultPath")
    public List<String> consultPathClients(@RequestBody String id) { 
       
        List<String> clients = horarioCrud.clientRoute(id);
        System.out.println("Routhe: " + clients);
        return clients;
    }
    
}
