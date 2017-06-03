/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import java.util.Date;
import org.foobarspam.repository.Conductor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sergi
 */
@Controller
public class VistaController {

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "RomainCoder");
        return "index";
    }

}
