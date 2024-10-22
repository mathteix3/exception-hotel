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
        Date dateNow = new Date();

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
            System.out.println("\nReservation: "+reservation);

            System.out.println("\nEnter data to update the reservation:");

            System.out.print("Check-in date (dd/MM/yyy): ");
            checkIn = simpleDateFormat.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyy): ");
            checkOut = simpleDateFormat.parse(scanner.next());


            if (checkIn.before(dateNow) || checkOut.before(dateNow)){
                System.out.println("Error in reservation: Reservation dates for update must be future.");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            }else {
                reservation.updateDate(checkIn,checkOut);
                System.out.println("\nReservation: "+reservation);
            }

        }

        scanner.close();
    }

}

