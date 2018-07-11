package edu.mum.sa.lab.reactive.reactiveassignment.controller;

import edu.mum.sa.lab.reactive.reactiveassignment.model.Stock;
import edu.mum.sa.lab.reactive.reactiveassignment.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StockController {

    @GetMapping
    public Flux<Stock> getStocks(){
        Flux<Stock> stockFlux = Flux.interval(
        return stockFlux;
    }

    public
}
