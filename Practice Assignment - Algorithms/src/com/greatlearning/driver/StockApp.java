package com.greatlearning.driver;

import com.greatlearning.service.StockServices;

public class StockApp {

	public static void main(String[] args) {
		
		StockServices app = new StockServices();
        app.inputStockData();
        app.run();

	}

}
