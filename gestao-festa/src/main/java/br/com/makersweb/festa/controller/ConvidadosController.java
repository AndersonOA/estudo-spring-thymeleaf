package br.com.makersweb.festa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author aaristides
 */
@Controller
public class ConvidadosController {

    @GetMapping("/convidados")
    public String listar() {
        return "ListaConvidados";
    }
}
