/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FooBarSpam.Cotxox.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Sergi
 */
@Controller
public class CarreraServiceController {

    @RequestMapping(path="/")
    public String setPickUp() {
    	return "SetPickup";
    }

}
