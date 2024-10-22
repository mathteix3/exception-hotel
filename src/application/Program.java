package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Room number: ");
        int roomNumber = scanner.nextInt();

        System.out.print("Check-in date (dd/MM/yyy): ");
        Date checkIn = simpleDateFormat.parse(scanner.next());

        System.out.print("Check-out date (dd/MM/yyy): ");
        Date checkOut = simpleDateFormat.parse(scanner.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        }else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);

            System.out.println("\nEnter data to update the reservation:");

            System.out.print("Check-in date (dd/MM/yyy): ");
            checkIn = simpleDateFormat.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyy): ");
            checkOut = simpleDateFormat.parse(scanner.next());

            String error = reservation.updateDate(checkIn,checkOut);

            if(error != null){
                System.out.println("Error in reservation: " + error);
            }else {
                System.out.println("Reservation: "+reservation);
            }

        }

        scanner.close();
    }

}

