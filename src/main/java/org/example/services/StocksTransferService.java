package org.example.services;

import org.example.dao.CrudStockInsertDao;
import org.example.dao.StocksPriceHistoryDao;
import org.example.model.StockPriceHistory;

import java.util.List;

public class StocksTransferService {
    public static void main(String[] args) {
        StocksPriceHistoryDao sourceDao = new StocksPriceHistoryDao();
        CrudStockInsertDao targetDao = new CrudStockInsertDao();

        int batchSize = 500;
        int offset = 0;

        for (int page = 1; page <= 100; page++) { // 100 pages, each 500 records = 50,000 total
            System.out.println("🔹 Fetching batch " + page + " (records " + offset + " to " + (offset + batchSize) + ")");

            List<StockPriceHistory> batch = sourceDao.getAllStocks(offset, batchSize);

            if (batch.isEmpty()) {
                System.out.println(" No more data to transfer.");
                break;
            }

            targetDao.insertStocks(batch);
            offset += batchSize;

            System.out.println(" Batch " + page + " transferred successfully.\n");
        }

        System.out.println("🚀 Data transfer completed for all batches.");
    }
}

