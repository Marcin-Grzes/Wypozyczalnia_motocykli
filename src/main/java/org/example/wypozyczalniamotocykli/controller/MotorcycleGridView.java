//package org.example.wypozyczalniamotocykli.controller;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.inject.Named;
//import jakarta.faces.view.ViewScoped;
//import jakarta.inject.Inject;
//import org.example.wypozyczalniamotocykli.model.Motorcycle;
//import org.example.wypozyczalniamotocykli.service.MotorcycleService;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Named
//@ViewScoped
//public class MotorcycleGridView implements Serializable {
//    private List<Motorcycle> motorcycles;
//
//    private final MotorcycleService motorcycleService;
//
//    @Inject
//    public MotorcycleGridView(MotorcycleService motorcycleService) {
//        this.motorcycleService = motorcycleService;
//    }
//
//    @PostConstruct
//    public void init() {
//        this.motorcycles = this.motorcycleService.getAllMotorcycles();
//    }
//
//    public List<Motorcycle> getMotorcycles() {
//        return motorcycles;
//    }
//}
