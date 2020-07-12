package Model.aplication;

import Model.entities.Reservation1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Evandro Lima
 *
 *                        \\ Bad solution //
 */
public class Program1 {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter hoom number... ");
        int roomNumber = sc.nextInt();
        System.out.print(" Enter Check-In date: (dd/mm/yyyy) ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print(" Enter Check-Out date: (dd/mm/yyyy) ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkIn.before(checkOut)) {
            System.out.println(" Error in reservation: Check-out date must be after check-in date ");
        } else {
            Reservation1 res = new Reservation1(roomNumber, checkIn, checkOut);

            System.out.println(" Reservation: " + res.toString());
            System.out.println();

            System.out.println(" Enter date to update reservation: ");
            System.out.print(" Enter Check-In date: (dd/mm/yyyy) ");
            checkIn = sdf.parse(sc.next());
            System.out.print(" Enter Check-Out date: (dd/mm/yyyy) ");
            checkOut = sdf.parse(sc.next());

            String error = res.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println(" Error in reservation: " + error);
            } else {

                System.out.println(" Reservation: " + res);
            }

            sc.close();

        }
    }

}
