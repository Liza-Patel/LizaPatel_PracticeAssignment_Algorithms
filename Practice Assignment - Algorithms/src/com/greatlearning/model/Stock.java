package com.greatlearning.model;

public class Stock {
	private double price;
	private boolean roseToday;

	public Stock(double price, boolean roseToday) {
		this.price = price;
		this.roseToday = roseToday;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isRoseToday() {
		return roseToday;
	}

	public void setRoseToday(boolean roseToday) {
		this.roseToday = roseToday;
	}

	@Override
	public String toString() {
		return "Stock{" + "price=" + price + ", roseToday=" + roseToday + '}';
	}
}
