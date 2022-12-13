package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows;
        int numberOfSeatsInEachRow;
        System.out.println("Enter the number of rows:");
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numberOfSeatsInEachRow = scanner.nextInt();
        String [][] cinema = new String[numberOfRows][numberOfSeatsInEachRow + 1];
        System.out.println();
        menu(cinema,numberOfSeatsInEachRow,numberOfRows,scanner);




    }
    public static void printCinema(String[][] cinema, int numberOfSeatsInEachRow) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= numberOfSeatsInEachRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (String[] strings : cinema) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void fillCinema(String[][] cinema) {

        int pomoc = 0;
        for (int i = 0; i < cinema.length; i++){
            cinema[i][0] = Integer.toString(++pomoc);
        }
        for (int i = 0; i < cinema.length; i++){
            for (int j = 1; j < cinema[i].length; j++) {
                cinema[i][j] = "S";
            }
        }

    }
    public static void pickASeat(String[][] cinema, int numberOfRows, int numberOfSeatsInEachRow, Scanner scanner) {
        System.out.println();
        int rowNumber = 0;
        int seatNumber = 0;
        do {

            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();
            if (rowNumber > numberOfRows ||
                    rowNumber < 0 ||
                    seatNumber > numberOfSeatsInEachRow ||
                    seatNumber < 0) {
                System.out.println("Wrong input!");

            } else {
                if (cinema[rowNumber - 1][seatNumber].equals("B")) {
                    System.out.println("That ticket has already been purchased!");

                } else {
                    System.out.println();
                    cinema[rowNumber - 1][seatNumber] = "B";
                    int ticketPrice = 0;
                    int totalNumberOfSeats = numberOfRows * numberOfSeatsInEachRow;
                    int numberOfElementsInArray = 0;
                    if (totalNumberOfSeats <= 60) {
                        ticketPrice = 10;
                        System.out.println("Ticket price: $" + ticketPrice);
                    } else if (numberOfRows % 2 == 0) {
                        if (rowNumber - 1 <= numberOfRows / 2 - 1) {
                            ticketPrice = 10;
                        } else {
                            ticketPrice = 8;
                        }
                        System.out.println("Ticket price: $" + ticketPrice + "\n");
                        System.out.println();

                    } else {
                        if (rowNumber - 1 <= numberOfRows / 2 - 1) {
                            ticketPrice = 10;
                            System.out.println("Ticket price: $" + ticketPrice + "\n");

                        } else {
                            ticketPrice = 8;
                            System.out.println("Ticket price: $" + ticketPrice + "\n");


                        }
                    }
                    break;
                }
            }
        }
        while (true);
    }








    public static void countNumberOfPurchasedTickets(String[][] cinema, int numberOfSeatsInEachRow, int numberOfRows) {
        int numberOfTickets = 0;
        int totalNumberOfSeats = numberOfSeatsInEachRow * numberOfRows;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j].equals("B")) {
                    numberOfTickets++;
                }
            }
        }
        double percentage = ((double)numberOfTickets / (double)totalNumberOfSeats) * 100;
        System.out.println("Number of purchased tickets: " + numberOfTickets);
        System.out.printf("Percentage: %.2f%c\n", percentage, '%');



    }

    public static void countCurrentIncome(String[][] cinema, int numberOfRows) {
        int sumOfTicketPrices = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j].equals("B")) {
                    if (numberOfRows % 2 == 0) {
                        if (i <= numberOfRows / 2) {
                            sumOfTicketPrices += 10;
                        } else {
                            sumOfTicketPrices += 8;
                        }

                    } else if (numberOfRows % 2 == 1) {
                        if (i < numberOfRows / 2) {
                            sumOfTicketPrices += 10;


                        } else {
                            sumOfTicketPrices += 8;



                        }
                    }
                }
            }
        }
        System.out.println("Current Income: $" + sumOfTicketPrices);

    }

    public static void countTotalIncome(String[][] cinema, int numberOfRows, int numberOfSeatsInEachRow ) {
        int totalNumberOfSeats = numberOfRows * numberOfSeatsInEachRow;
        int priceOfTicketsSmallerHall;
        if (totalNumberOfSeats <= 60) {
            priceOfTicketsSmallerHall = 10 * totalNumberOfSeats;
            System.out.println("Total income: $" + priceOfTicketsSmallerHall);
        } else {
            if (numberOfRows % 2 == 0) {
                int frontHall = numberOfRows / 2;
                int backHall = numberOfRows / 2;
                int totalNumberOfSeatsFrontHall = frontHall * numberOfSeatsInEachRow;
                int totalNumberOfSeatsBackHall = backHall * numberOfSeatsInEachRow;
                int priceOfTicketsFrontHall = totalNumberOfSeatsFrontHall * 10;
                int priceOfTicketsBackHall = totalNumberOfSeatsBackHall * 8;
                int priceOfTicketsBiggerHall = priceOfTicketsFrontHall + priceOfTicketsBackHall;
                System.out.println("Total income: $" + priceOfTicketsBiggerHall);

            } else {
                int frontHall = numberOfRows / 2;
                int backHall = numberOfRows / 2 + 1;
                int totalNumberOfSeatsFrontHall = frontHall * numberOfSeatsInEachRow;
                int totalNumberOfSeatsBackHall = backHall * numberOfSeatsInEachRow;
                int priceOfTicketsFrontHall = totalNumberOfSeatsFrontHall * 10;
                int priceOfTicketsBackHall = totalNumberOfSeatsBackHall * 8;
                int priceOfTicketsBiggerHall = priceOfTicketsFrontHall + priceOfTicketsBackHall;
                System.out.println("Total income: $" + priceOfTicketsBiggerHall);
            }


        }
    }

    public static void menu(String[][] cinema, int numberOfSeatsInEachRow, int numberOfRows, Scanner scanner) {
        int decision;
        fillCinema(cinema);
        int sum = 0;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            decision = scanner.nextInt();
            if (decision == 1) {
                System.out.println();
                printCinema(cinema, numberOfSeatsInEachRow);
            } else if (decision == 2) {
                pickASeat(cinema, numberOfRows, numberOfSeatsInEachRow, scanner);

            } else if (decision == 3) {
                countNumberOfPurchasedTickets(cinema, numberOfSeatsInEachRow, numberOfRows);
                countCurrentIncome(cinema,numberOfRows);
                countTotalIncome(cinema,numberOfRows,numberOfSeatsInEachRow);
                System.out.println();
            }


        }while (decision != 0);
    }
}