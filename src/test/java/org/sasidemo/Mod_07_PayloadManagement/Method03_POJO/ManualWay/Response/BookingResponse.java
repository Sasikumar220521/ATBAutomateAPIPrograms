package org.sasidemo.Mod_07_PayloadManagement.Method03_POJO.ManualWay.Response;

import org.sasidemo.Mod_07_PayloadManagement.Method03_POJO.ManualWay.Request.Booking;

public class BookingResponse {

    private Integer bookingid;
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
