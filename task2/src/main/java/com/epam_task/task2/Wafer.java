package com.epam_task.task2;

public class Wafer extends Chocolate{
	Wafer(int w,int p){
		super(w,p);
	}
	public int getWeight() {
		return this.giftWeight;
	}
	public int getPrice() {
		return this.giftPrice;
	}
}
