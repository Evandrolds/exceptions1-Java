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
 *                          \\ Very bad solution //
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

        if (checkOut.before(checkIn)) {
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
            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println(" Error in reservatio: Reservation dates for Update must be future dates!");
            } else if (!checkOut.after(checkIn)) {
                System.out.println(" Error in reservation: Check-out date must be after check-in date ");
            } else {

                res.updateDates(checkIn, checkOut);

                System.out.println(" Reservation: " + res.toString());
            }
            sc.close();

        }
    }

}