package com.travel.booking.datamodel;

import java.util.List;

public final class Body {
    private List<BookingInfo> cancelled;
    private EmptyBookingMessage cancelledPageHeading;
    private List<BookingInfo> completed;
    private EmptyBookingMessage completedPageHeading;
    private List<BookingInfo> upcoming;
    private EmptyBookingMessage upcomingHeading;
    private String zeroSearchImage;

    public final EmptyBookingMessage getUpcomingHeading() {
        return this.upcomingHeading;
    }

    public final void setUpcomingHeading(EmptyBookingMessage emptyBookingMessage) {
        this.upcomingHeading = emptyBookingMessage;
    }

    public final String getZeroSearchImage() {
        return this.zeroSearchImage;
    }

    public final void setZeroSearchImage(String str) {
        this.zeroSearchImage = str;
    }

    public final EmptyBookingMessage getCancelledPageHeading() {
        return this.cancelledPageHeading;
    }

    public final void setCancelledPageHeading(EmptyBookingMessage emptyBookingMessage) {
        this.cancelledPageHeading = emptyBookingMessage;
    }

    public final EmptyBookingMessage getCompletedPageHeading() {
        return this.completedPageHeading;
    }

    public final void setCompletedPageHeading(EmptyBookingMessage emptyBookingMessage) {
        this.completedPageHeading = emptyBookingMessage;
    }

    public final List<BookingInfo> getCompleted() {
        return this.completed;
    }

    public final void setCompleted(List<BookingInfo> list) {
        this.completed = list;
    }

    public final List<BookingInfo> getCancelled() {
        return this.cancelled;
    }

    public final void setCancelled(List<BookingInfo> list) {
        this.cancelled = list;
    }

    public final List<BookingInfo> getUpcoming() {
        return this.upcoming;
    }

    public final void setUpcoming(List<BookingInfo> list) {
        this.upcoming = list;
    }
}
