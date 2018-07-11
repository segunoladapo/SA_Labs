package edu.mum.sa.lab.reactive.reactiveassignment.dao;

import edu.mum.sa.lab.reactive.reactiveassignment.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockRepository {
    private static List<Stock> stocks = new ArrayList<>();

    public static List<Stock> getAllStocks(){
        return stocks;
    }

    public static void addStock(Stock stock){
        stocks.add(stock);
    }
}
