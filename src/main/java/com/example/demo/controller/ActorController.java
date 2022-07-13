package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
public class ActorController {

    /*
    GET   ->  Listar
    POST  ->  Crear
    PUT   ->  Actualizar
    DELETE -> Borrar
     */

    @Autowired
    ActorService actorService;

    @PostMapping("/create")
    public Actor crear(@RequestBody Actor actor) {
        return actorService.add(actor);
    }



}
