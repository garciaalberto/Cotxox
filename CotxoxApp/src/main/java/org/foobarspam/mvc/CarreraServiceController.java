/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import javax.servlet.http.HttpServletRequest;
import org.foobarspam.repository.Conductor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

/**
 *
 * @author Sergi
 */
@Controller
public class CarreraServiceController {

    @RequestMapping(path = "/SetPickup")
    @ResponseBody
    public String setPickUp() {
        return "setpickup";
    }

    // sense template
//    @RequestMapping(value = "/Bones", method = RequestMethod.GET)
//    @ResponseBody
//    public String bones(HttpServletRequest request, Model model) {
//
//        String nom = request.getParameter("nom");
//
//        if (nom.isEmpty()) {
//            nom = "merda";
//        }
//        model.addAttribute("missatge", nom);
//        return "Uep, " + nom;
//
//    }

    // amb template
    
    /*
       @Id
    @Column
    private String id = null;
    @Column
    private String nombre = null;
    @Column
    private String matricula = null;
    @Column
    private String modelo = null;
    private ArrayList<Byte> valoraciones = new ArrayList<Byte>();
    @Column
    private boolean ocupado = false;
    @Column
    private double valoracionMedia = 0d;

    */
    @RequestMapping("/")
    public String mostrarConductor(Model model, Conductor conductor) {
        
        model.addAttribute("id", conductor.getId());
        model.addAttribute("nombre", conductor.getNombre());
        model.addAttribute("matricula", conductor.getMatricula());
        model.addAttribute("ocupado", conductor.estaOcupado());
        model.addAttribute("valoracion", String.valueOf(conductor.getValoracionMedia()));

        return "index";
    }

}
