import java.util.Arrays;
import java.util.Scanner;

public class ApiImplementation extends WeatherLatte {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		int temp;
		while(true){
			System.out.print("Input search: ");
			input = scan.nextLine();
			if(input.length() == 0) {
				System.out.println();
				System.out.println("That was blank. Try again.");
				System.out.println();
				continue;
			}

			System.out.println();
			System.out.println("Searching...");

			WeatherLatte query = WeatherLatte.fetch(input);
			if(query.getNames().length == 0) {
				System.out.println();
				System.out.println("That search returned no results. Please try again.");
				System.out.println();
				continue;
			}

			while(query.getNames().length>1) {
				System.out.print("Results found: ");
				for(int i = 0; i < query.getNames().length; i++ ) {
					System.out.print(i + ":" + query.getNames()[i] + " ");
				}
				System.out.println();
				System.out.println("Please select a city by typing the corresponding number...");
				temp = scan.nextInt();
				scan.nextLine();
				System.out.println("Selected " + query.getNames()[temp]);
				query = WeatherLatte.fetch(query.getNames()[temp]);
			}

			System.out.println();
			System.out.println("The weather in " + query.getNames()[0] + " is " + query.getTemps()[0] + "ºC");
			System.out.println("The daily high is currently " + query.getHighs()[0] + "ºC, and the low is " + query.getLows()[0] + "ºC.");

			for(int i = 0; i < 3; i++) {
				if(i==1) {
					System.out.println("---------------");
				} else {
					System.out.println();
				}
			}
		}
	}
}
