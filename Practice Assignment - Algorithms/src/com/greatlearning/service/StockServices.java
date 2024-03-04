package com.greatlearning.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.greatlearning.model.Stock;

public class StockServices {
	private ArrayList<Stock> stockPrices = new ArrayList<>();

	public void inputStockData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of companies: ");
		int numCompanies = scanner.nextInt();

		for (int i = 1; i <= numCompanies; i++) {
			System.out.print("Enter current stock price of the company " + i + ": ");
			double price = scanner.nextDouble();
			System.out.print("Whether the company's stock price rose today compared to yesterday? (true/false): ");
			boolean riseToday = scanner.nextBoolean();
			stockPrices.add(new Stock(price, riseToday));
		}
	}

	public void displayStockPrices(String order) {
		ArrayList<Stock> sortedStockPrices = new ArrayList<>(stockPrices);
		if (order.equals("asc")) {
			Collections.sort(sortedStockPrices, Comparator.comparingDouble(Stock::getPrice));
		} else {
			Collections.sort(sortedStockPrices, Comparator.comparingDouble(Stock::getPrice).reversed());
		}

		System.out.print("Stock prices in " + order + " order are: ");
		for (Stock stock : sortedStockPrices) {
			System.out.print(stock.getPrice() + " ");
		}
		System.out.println();
	}

	public void displayRiseDeclineStats(String option) {
		long riseCount = stockPrices.stream().filter(Stock::isRoseToday).count();
		long declineCount = stockPrices.size() - riseCount;
		if (option.equals("rise")) {
			System.out.println("Total no of companies whose stock price rose today: " + riseCount);
		} else {
			System.out.println("Total no of companies whose stock price declined today: " + declineCount);
		}

	}

	public void searchStockPrice(double keyValue) {
		boolean found = false;
		for (Stock stock : stockPrices) {
			if (stock.getPrice() == keyValue) {
				System.out.println("Stock of value " + keyValue + " is present");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Value " + keyValue + " not found");
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. Press 0 to exit");
			System.out.println("-----------------------------------------------");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				displayStockPrices("asc");
				break;
			case 2:
				displayStockPrices("desc");
				break;
			case 3:
				displayRiseDeclineStats("rise");
				break;
			case 4:
				displayRiseDeclineStats("decline");
				break;
			case 5:
				System.out.print("Enter the key value: ");
				double keyValue = scanner.nextDouble();
				searchStockPrice(keyValue);
				break;
			case 0:
				System.out.println("Exited successfully");
				System.exit(0);
				return;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}

	}
}
