import java.util.InputMismatchException;
import java.util.Scanner;

public class NewMain{

    public static void main(String[] args) {
        double gas_gallon = 2.25;
        int cars_count = 9;
        String car_category[]={"suv","hybird","minivan","Truck","Crossover","Sedan","coupe","Van","Truck"};
        String car_names[]={"2022 Kia Telluride","2022 Lexus ES","2022 Honda Odyssey",
                "2022 Toyota Tacoma Access Cab","2022 Toyota RAV4","2022 Mercedes-Benz S-Class","2022 MAZDA MX-5 Miata"
                ,"2021 Kia Sedona","2022 Ford F150 SuperCrew Cab"};
        int car_gas[]={23,28,27,21,30,24,29,21,23};
        int car_passengers[]={5,4,7,5,5,4,5,7,5};
        int car_cost[]={55,50,70,55,55,50,45,55,55};
        int selectedCars[] = new int[cars_count];
        int selectedCarsCount = 0;
        String car_comfort[]={"good","medium","medium","good","good","medium","poor","good","good"};


        car_project all_cars[] = new car_project[cars_count];

        for(int i=0;i<cars_count;i++){
            all_cars[i] = new car_project(car_category[i],car_names[i],car_comfort[i],
                    car_cost[i],car_passengers[i],car_gas[i]);
        }

        Scanner sc= new Scanner(System.in);


        System.out.print("Enter number of passengers: ");
        int c_passengers= getInput(sc);
        while(c_passengers < 1 || c_passengers > 7){
            System.out.println("Number of passengers must be in range (1-7)" +
                    "\nEnter number of passengers again:");
            c_passengers = getInput(sc);
        }
        
        System.out.print("Enter number of rental days: ");
        int c_days= getInput(sc);
        while(c_days < 1){
            System.out.println("we can only rent the cars for at least 1 full day");
            System.out.print("Enter number of rental days: ");
            c_days= getInput(sc);
        }
        
        System.out.print("Enter number of mileage for the trip: ");
        int c_miles= getInput(sc);
        while (c_miles < 1){
            System.out.println("Number of miles must be greater than 1.");
            System.out.print("Enter number of mileage for the trip: ");
            c_miles= getInput(sc);
        }


        double currentMinPrice = 10000000;
        selectedCarsCount = -1;

        for(int i=0;i<cars_count;i++){

            if(c_passengers <= all_cars[i].getPassengers()){
                double currentPrice = calculateCost(all_cars[i],c_days,c_miles,gas_gallon);
                if(currentPrice < currentMinPrice){
                    currentMinPrice = currentPrice;
                    selectedCarsCount = 0;
                    selectedCars[selectedCarsCount] = i;
                }
                else if(currentPrice == currentMinPrice){
                    selectedCarsCount = selectedCarsCount + 1;
                    selectedCars[selectedCarsCount] = i;
                }
            }
        }

        System.out.println("");
        for(int i=0;i<=selectedCarsCount;i++){

            String type = all_cars[ selectedCars[i] ].getType();
            if(type.equals("coupe")){
                System.out.println("Economy Package");
                displayCost(all_cars[ selectedCars [i] ],currentMinPrice);
            }

            if(type.equals("Sedan") || type.equals("hybrid")){
                System.out.println("Intermediate Package");
                displayCost(all_cars[ selectedCars [i] ],currentMinPrice);
            }
            
            if(type.equals("Truck") || type.equals("Crossover") || type.equals("suv")){
                System.out.println("Standard Package");
                displayCost(all_cars[ selectedCars [i] ],currentMinPrice);
            }

            if(type.equals("Van") || type.equals("minivan")){
                System.out.println("Van Package");
                displayCost(all_cars[ selectedCars [i] ],currentMinPrice);
            }

        }

        if(selectedCarsCount == -1){
            System.out.println("Sorry No Cars could be found for you\n");
        }

    }

    public static double calculateCost (car_project currentCar,int c_day, int c_miles, double gas_gallon){
        double mileage_cost = (c_miles/currentCar.getGas() )* gas_gallon;
        int base_cost = c_day*currentCar.getCost();
        double total_cost = mileage_cost + base_cost;
        return total_cost;
    }

    public static void displayCost (car_project currentCar, double total_cost){

        System.out.println("Car Name: " + currentCar.getName());
        System.out.println("Car type: " + currentCar.getType());
        System.out.println("Car Maximum Passenger Capacity : " + currentCar.getPassengers());
        System.out.println("Car Comfort Level: " + currentCar.getComfort());
        System.out.println("Total Cost: " + total_cost + "\n")    ;
    }



    
    public static int getInput(Scanner sc){
        int inp = -1;
        boolean validInput = true;
        do {
            validInput = true;
            try {
                inp = sc.nextInt();
            }
            catch(InputMismatchException ex) {
                sc.nextLine();
                validInput = false;
                System.out.print("Please enter only integer numbers\nEnter your data again: ");
            }
        } while(validInput == false);

        return inp;
    }
}
