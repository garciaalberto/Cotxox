/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FooBarSpam.Cotxox.mvc;

import FooBarSpam.Cotxox.repository.Carrera;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sergi
 */
@Controller
public class CarreraServiceController {

    /*
    System.out.println("\n#####" + "\t Set Pickup: \t" + "#####\n" );
		
		System.out.println("Visa: " + carrera.getTarjetaCredito());
		System.out.println("From: "+ carrera.getOrigen());
		System.out.println("To: " + carrera.getDestino());
		System.out.println("Distance: " + carrera.getDistancia());
     */
    @RequestMapping("/setpickup")
    public String setPickUp(Carrera carrera) {

        String sms = "\\n#####\" + \"\\t Set Pickup: \\t\" + \"#####\\n";
        sms.concat("\nVisa: " + carrera.getTarjetaCredito());
        sms.concat("\nFrom: " + carrera.getOrigen());
        sms.concat("\nTo:" + carrera.getDestino());
        sms.concat("\nDistance:" + carrera.getDistancia());

        return "s";
    }

}
