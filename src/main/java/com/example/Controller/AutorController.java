package com.example.Controller;

import com.example.Model.Autor;
import com.example.Service.AutoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class AutorController {

    @Autowired
    public AutoresService service;

    @GetMapping("/autor/list")
    public ModelAndView list() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("autor/list");
        mv.addObject("autores", service.findAll());
        return mv;
    }

    @GetMapping("/autor/create")
    public String create() {

        return "autor/create";
    }

    @PostMapping("/autor/create")
    public String create(Autor autor) {

        service.insert(autor);

        return "redirect:list";
    }

    @PostMapping("/autor/find")
    public ModelAndView find(@RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "fNac", required = false) String fNac) {

        List<Autor> autores = service.findAll();

        if (!Objects.equals(nombre, "")) {

            autores = service.findByNombre(nombre);
        } else if (!Objects.equals(fNac, "")) {

            autores = service.findByDate(Date.valueOf(fNac));
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("autor/list");
        mv.addObject("autores", autores);

        return mv;
    }
}
