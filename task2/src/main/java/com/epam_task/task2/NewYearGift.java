package com.epam_task.task2;
import java.util.*;
import java.util.Scanner;
public class NewYearGift {
		static Scanner cin=new Scanner(System.in);
		static ArrayList<Chocolate> chocos = new ArrayList<Chocolate>();
		static ArrayList<Chocolate> candies = new ArrayList<Chocolate>();
		static ArrayList<Sweet> sweets = new ArrayList<Sweet>();
		static HashMap<String,Integer> weight = new HashMap<String,Integer>();
		static HashMap<String,Integer> price = new HashMap<String,Integer>();
		public static void main(String[] args) {
			Chocolates();
			Sweets();
			System.out.println("total weight of gift is:"+totWeight());
			System.out.println("Choose the way to sort the chocolates in the gift: 1.By price 2.By weight");
			int type_sort=cin.nextInt();
			if(type_sort==1) {
					Comparator<Chocolate> compByPrice=new 
					Comparator<Chocolate>() {
					@Override
					public int compare(Chocolate c1, Chocolate c2) {
					return ((Integer)c1.getPrice()).compareTo(c2.getPrice());
					}
				};
				Collections.sort(chocos,compByPrice);
				System.out.println("sorted result:");
				for(Chocolate chocolate:chocos) {
					System.out.println(chocolate.getPrice());
				}
			}
			else {
					Comparator<Chocolate> compByWeight=new 
					Comparator<Chocolate>() {
					@Override
					public int compare(Chocolate c1, Chocolate c2) {
					return ((Integer)c1.getWeight()).compareTo(c2.getWeight());
					}
				};
				Collections.sort(chocos,compByWeight);
			//}
			System.out.println("sorted result:");
			for(Chocolate chocolate:chocos) {
				System.out.println(chocolate.getWeight());
			}
			}
			findRange(type_sort);
			
			System.out.println("Choose the way to sort the sweets in the gift: 1.By price 2.By weight");
			type_sort=cin.nextInt();
			if(type_sort==1) {
					Comparator<Sweet> compareByPrice=new 
					Comparator<Sweet>() {
					@Override
					public int compare(Sweet s1,Sweet s2) {
					return ((Integer)s1.getPrice()).compareTo(s2.getPrice());
					}
				};
				Collections.sort(sweets,compareByPrice);
			}
			else {
					Comparator<Sweet> compareByWeight=new 
					Comparator<Sweet>() {
					@Override
					public int compare(Sweet s1,Sweet s2) {
					return ((Integer)s1.getWeight()).compareTo(s2.getWeight());
					}
				};
				Collections.sort(sweets,compareByWeight);
			}
			System.out.println("sorted result:");
			for(Sweet sweet:sweets) {
				System.out.println(sweet.getWeight());
			}
			
		}
		public static void Chocolates() {
			System.out.println("enter no. of chocolates in gifts:");
			int noOfChocolates=cin.nextInt();
			for(int chocoCount=1;chocoCount<=noOfChocolates;chocoCount++) {
				System.out.println("Enter the chocolate type: (1.Candy 2.Wafer 3.Toffee 4.Cocoa)");
				int chocolateType=cin.nextInt();
				System.out.println("Enter the weight of chocolate:");
				int chocoWeight=cin.nextInt();
				System.out.println("Enter the price of chocolate:");
				int chocoPrice=cin.nextInt();
				if(chocolateType==1)
				{
					System.out.println("enter the name of candy:");
					String candyName=cin.next();
					if(weight.containsKey(candyName)) {
						weight.put(candyName,(int)weight.get(candyName)+chocoWeight);
					}
					else
						weight.put(candyName, chocoWeight);
					
					if(price.containsKey(candyName)) {
						price.put(candyName,(int)price.get(candyName)+chocoPrice);
					}
					else
						price.put(candyName,chocoPrice);
				}
				Chocolate choco=new Chocolate(chocoWeight,chocoPrice);
				chocos.add(choco);
				if(chocolateType==1) {
					candies.add(choco);
				}
			}
		}
		
		public static void Sweets() {
			System.out.println("enter no. of sweets in gifts:");
			int noOfSweets=cin.nextInt();
			for(int sweetCount=1;sweetCount<=noOfSweets;sweetCount++) {
				System.out.println("Enter the weight of sweet:");
				int sweetWeight=cin.nextInt();
				System.out.println("Enter the price of sweet:");
				int sweetPrice=cin.nextInt();
				Sweet sweet=new Sweet(sweetWeight,sweetPrice);
				sweets.add(sweet);
			}
		}
		public static int totWeight() {
			int weight_total=0;
			for(Chocolate choco:chocos) {
				weight_total+=choco.getWeight();
			}
			for(Sweet sweet:sweets) {
				weight_total+=sweet.getWeight();
			}
			return weight_total;
		}
		public static void findRange(int type_sort) {
			System.out.println("enter the range to find the candies within that range:");
			int lLimit,hLimit;
			if(type_sort==1) {
				System.out.println("Enter lowerlimit of price:");
				lLimit=cin.nextInt();
				System.out.println("Enter upperlimit of price:");
				hLimit=cin.nextInt();
				Set<Map.Entry<String,Integer>> cSet=price.entrySet();
				Iterator<Map.Entry<String,Integer>> cIter=cSet.iterator();
				while(cIter.hasNext()) {
					Map.Entry<String,Integer> candyElement=(Map.Entry<String,Integer>)cIter.next();
					int curPrice=(int)candyElement.getValue();
					if(curPrice>=lLimit && curPrice<=hLimit)
						System.out.println(candyElement.getKey());
				}
			}
			else {
				System.out.println("Enter lowerlimit of weight:");
				lLimit=cin.nextInt();
				System.out.println("Enter upperlimit of weight:");
				hLimit=cin.nextInt();
				Set<Map.Entry<String,Integer>> cSet=weight.entrySet();
				Iterator<Map.Entry<String,Integer>> cIter=cSet.iterator();
				while(cIter.hasNext()) {
					Map.Entry<String,Integer> candyElement=(Map.Entry<String,Integer>)cIter.next();
					int curWeight=(int)candyElement.getValue();
					if(curWeight>=lLimit && curWeight<=hLimit)
						System.out.println(candyElement.getKey());
				}
		
			}
		}
}