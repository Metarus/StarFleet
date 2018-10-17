import java.util.Scanner;

import static java.lang.System.currentTimeMillis;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Starfleet fleet=new Starfleet();
        System.out.println("Hi! Welcome to the game! Please name your first ship!");
        fleet.addShip(sc.nextLine(), 100, 30, 30, 30);
        fleet.showFleet();
        long prevTime=currentTimeMillis();
        boolean game=true;
        while(game) {
            System.out.println("\nEnter the corresponding menu options: ");
            String input[]=sc.nextLine().split(" ");
            fleet.tick(currentTimeMillis()-prevTime);
            prevTime=currentTimeMillis();
            switch(input[0]) {
                case "/viewShip":
                    if(input.length>1) {
                        for(int i=0; i<fleet.getFleet().length; i++) {
                            if(fleet.getShip(i).getName().equals(input[1])) {
                                fleet.getShip(i).detailedInfo();
                            }
                        }
                    } else System.out.println("Please enter a ship number");
                    break;
                case "/viewFleet":
                    fleet.showFleet();
                    break;
                case "/exit":
                    game=false;
                    break;
                case "/help":
                    System.out.println("/viewFleet: Displays entire fleet in compact form");
                    System.out.println("/viewShip <ShipName>: Shows detailed form of a specific ship");
                    System.out.println("/exit: Closes the game");
                    break;
                default:
                    mainMenu(input);
                    break;
            }
        }
    }
    public static void mainMenu(String[] input) {

    }
}
