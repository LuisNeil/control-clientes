package co.com.gm.web;

import co.com.gm.domain.Persona;
import co.com.gm.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/inicio")
    public String inicio(Model model){
        var personas = personaService.listarPersonas();

        log.info("ejecutando el controlador spring mvc");
        model.addAttribute("personas",personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if (errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/inicio";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona, Model model){
        personaService.eliminar(persona);
        return "redirect:/inicio";
    }

}
