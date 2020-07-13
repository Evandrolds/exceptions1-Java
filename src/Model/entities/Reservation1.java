package Model.entities;

import Model.Exceptions.DomainExceptions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Evandro Lima
 *
 *                                \\ Good solution //
 */
public class Reservation1 {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation1(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions {
        if (!checkOut.after(checkIn)) {
            throw new DomainExceptions(" Check-out date must be after check-in date ");
        } else {

            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Integer getHoomNumber() {
        return roomNumber;
    }

    public void setHoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public long duration() {
        long dif = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainExceptions(" Reservation dates for Update must be future dates!");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainExceptions(" Check-out date must be after check-in date ");
        }
        this.checkOut = checkOut;
        this.checkIn = checkIn;

    }

    @Override
    public String toString() {
        return " Room: ("
                + roomNumber
                + "), Check-In ("
                + sdf.format(checkIn)
                + "), Check-Out ("
                + sdf.format(checkOut)
                + "), ("
                + duration()
                + ") Nights";
    }

}
