package calcul;

import java.util.Scanner;

//////////////////////////////////////
//									//
// Calculating two entered numbers	//
// from the console					//
//									//
//////////////////////////////////////


public class Calculate {


	private static Scanner in;

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		double[] mass = new double[2];
		int j = 0;

		for(double i: mass) {
			mass[j]=in.nextDouble();
			j +=1;
		}
		
		double first = Double.valueOf(mass[0]);
		double second = Double.valueOf(mass[1]);
		System.out.println("Calculating..");
		double sum = Double.sum(first, second);
		System.out.println("sum = " + sum);
		
	}

}

// next(): считывает введенную строку до первого пробела
// nextLine(): считывает всю введенную строку
// nextInt(): считывает введенное число int
// nextDouble(): считывает введенное число double
// hasNext(): проверяет, было ли введено слово
// hasNextInt(): проверяет, было ли введено число int
// hasNextDouble(): проверяет, было ли введено double

