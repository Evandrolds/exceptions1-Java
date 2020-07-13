package Model.aplication;

import Model.Exceptions.DomainExceptions;
import Model.entities.Reservation1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Evandro Lima
 *
 *                             \\ Good solution //
 */
public class Program1 {

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Scanner sc = new Scanner(System.in);
            System.out.print(" Enter hoom number... ");
            int roomNumber = sc.nextInt();
            System.out.print(" Enter Check-In date: (dd/mm/yyyy) ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print(" Enter Check-Out date: (dd/mm/yyyy) ");
            Date checkOut = sdf.parse(sc.next());

            Reservation1 res = new Reservation1(roomNumber, checkIn, checkOut);

            System.out.println(" Reservation: " + res.toString());
            System.out.println();

            System.out.println(" Enter date to update reservation: ");
            System.out.print(" Enter Check-In date: (dd/mm/yyyy) ");
            checkIn = sdf.parse(sc.next());
            System.out.print(" Enter Check-Out date: (dd/mm/yyyy) ");
            checkOut = sdf.parse(sc.next());

            res.updateDates(checkIn, checkOut);

            System.out.println(" Reservation: " + res);
            sc.close();
        } catch (ParseException e) {
            System.out.println("Invalid date format ");
        } catch (DomainExceptions e) {
            System.out.println(" Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(" Unexpected error!");
        }

    }

}
