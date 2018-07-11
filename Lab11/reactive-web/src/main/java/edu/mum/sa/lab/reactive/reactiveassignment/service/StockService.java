package edu.mum.sa.lab.reactive.reactiveassignment.service;

import edu.mum.sa.lab.reactive.reactiveassignment.dao.StockRepository;
import edu.mum.sa.lab.reactive.reactiveassignment.model.Stock;

import java.util.List;

public class StockService {

    public static List<Stock> getAllStocks() {
        return StockRepository.getAllStocks();
    }

    public static void addStock(Stock stock) {
        StockRepository.addStock(stock);
    }
}
