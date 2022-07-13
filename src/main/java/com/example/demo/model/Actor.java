package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int idActor;

   private  String apellido;

       private String nombre;

   private int centimetros;


}
