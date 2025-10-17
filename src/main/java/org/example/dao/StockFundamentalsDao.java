package org.example.dao;


import org.example.services.StockFundamentalsService;
import org.example.vo.StocksFundamentals;

import java.util.List;

public class StockFundamentalsDao {
     private final StockFundamentalsService srvc = new StockFundamentalsService();
     public List<StocksFundamentals> getAllStockFundamentals() {
         return srvc.getStockFundamentals();
     }



}

