package application;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();
            System.out.print("Check-in date (dd/MM/yyy): ");
            Date checkIn = simpleDateFormat.parse(scanner.next());
            System.out.print("Check-out date (dd/MM/yyy): ");
            Date checkOut = simpleDateFormat.parse(scanner.next());
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyy): ");
            checkIn = simpleDateFormat.parse(scanner.next());
            System.out.print("Check-out date (dd/MM/yyy): ");
            checkOut = simpleDateFormat.parse(scanner.next());
            reservation.updateDate(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        }catch (ParseException exception){
            System.out.println("Invalid date format.");
        }catch (DomainException exception){
            System.out.println("Error in reservation: " + exception.getMessage());
        }catch (RuntimeException exception){
            System.out.println("Unexpected error.");
        }finally {
            scanner.close();
        }

    }

}

