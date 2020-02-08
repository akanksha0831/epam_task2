package com.epam_task.task2;

public class Cocoa extends Chocolate {
	Cocoa(int w,int p){
		super(w,p);
	}
	public int getWeight() {
		return this.giftWeight;
	}
	public int getPrice() {
		return this.giftPrice;
	}
}
