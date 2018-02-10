package br.com.makersweb.festa.controller;

import br.com.makersweb.festa.model.Convidado;
import br.com.makersweb.festa.service.IConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author aaristides
 */
@Controller
public class ConvidadosController {

    @Autowired
    private IConvidadoService convidadoService;

    @GetMapping("/convidados")
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView("ListaConvidados");
        mav.addObject("convidados", this.convidadoService.listar());
        mav.addObject(new Convidado());

        return mav;
    }

    @PostMapping("/convidados")
    public String salvar(Convidado convidado) {
        this.convidadoService.salvar(convidado);
        return "redirect:convidados";
    }
}
