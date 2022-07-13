package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Actores")
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

    @Operation(summary = "Creación de usuarios", tags = "Actores")
    @PostMapping("/create")
    public Actor crear(@RequestBody Actor actor) {
        return actorService.add(actor);
    }

    @Operation(summary = "Listar usuario por Id", tags = "Actores")
    @GetMapping("/obtenerId/{id}")
    public Actor getById(@PathVariable int id) {
        return actorService.getById(id);
    }

    @Operation(summary = "Listar usuarios", tags = "Actores")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de Usuarios")
    @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado o Error de BD")

    @ApiResponse(
            responseCode = "500",
            description = "Error del sistema"
    )
    @GetMapping("/listar")
    public List<Actor> list() {
        return actorService.list();
    }

    @Operation(summary = "Actualizacion de usuario", tags = "Actores")
    @PutMapping("/updateUser/{id}")
    public Actor updateActor(@PathVariable int id, @RequestBody Actor actorDetails) {
        return actorService.updateActor(id, actorDetails);
    }

    @Operation(summary = "Eliminacion de usuario", tags = "Actores")
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return  actorService.deleteActor(id);
    }

}
