package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    ActorRepository actorRepository;

    public Actor add(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor getById(int id) {
        return actorRepository.findById(id)
                              .orElse(null);
    }

    @Override
    public List<Actor> list() {
        return actorRepository.findAll();
    }

    @Override
    public Actor updateActor(int id, Actor actorDetails) {
        Actor actor = actorRepository.findById(id).orElse(null);;
        actor.setNombre(actorDetails.getNombre());
        actor.setApellido(actorDetails.getApellido());
        actor.setCentimetros(actorDetails.getCentimetros());
        return actorRepository.save(actor);
    }

    @Override
    public String deleteActor(int id) {
        Actor actorExistente = actorRepository.findById(id).orElse(null);
        if (actorExistente != null){
            actorRepository.delete(actorExistente);
            return "El Actor se ha borrado con exito";
        }
        return "No hay ningun Actor para eliminar";
    }


}
