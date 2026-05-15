package br.com.contador.cont.controller;

import br.com.contador.cont.dtos.EquipamentoDto;
import br.com.contador.cont.model.Equipamentos;
import br.com.contador.cont.services.ServiceEquipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ControllerEqui {

    @Autowired
    private ServiceEquipamento service;

    @GetMapping("/home")
    public ModelAndView Home(){
        var modelAndView = new ModelAndView("home");

        List<Equipamentos> listaEquipamentos = service.exibir();

        modelAndView.addObject("equipamentos",listaEquipamentos);

        return modelAndView;
    }

    @GetMapping("/cadastro")
    public String Cadastro(Model model){
        model.addAttribute("equipamento", new EquipamentoDto());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("equipamento") EquipamentoDto dto) {
        service.salvar(dto); // Agora este método funciona!
        return "redirect:/home"; // Redireciona para a lista atualizada
    }

    @GetMapping("/detalhes/{id}") // Verifique se tem a barra antes de detalhes
    public ModelAndView detalhes(@PathVariable("id") Long id) {
        var modelAndView = new ModelAndView("detalhes");
        Equipamentos equipamento = service.buscarPorId(id);
        modelAndView.addObject("equipamento", equipamento);
        return modelAndView;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return "redirect:/home"; // Redireciona para a lista após deletar
    }
}























