package com.example.demo.service;

import com.example.demo.model.Actor;

import java.util.List;

public interface ActorService {


    public Actor add(Actor actor);

    public Actor getById(int id);

    List<Actor> list();

    Actor updateActor(int id, Actor actorDetails);

    String deleteActor(int id);
}
