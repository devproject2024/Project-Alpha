package com.travel.bus.pojo.busticket;

public enum e {
    BUS_DEPARTURE_TIME(1, "Departure Time"),
    BUS_TYPE(2, "Bus Type"),
    BUS_OPERATOR(3, "Bus Operator"),
    BOARDING_POINT(4, "Boarding Point"),
    DROPPING_POINT(5, "Dropping Point"),
    BUS_FARE(6, "Bus Fare"),
    BUS_AMENITY(7, "bus_amenity"),
    BUS_OPERATORTAG(8, "bus_operatorTag"),
    BUS_SORT_BY(9, "bus_sort_by"),
    BUS_RATING(10, "Bus Rating"),
    BUS_DEALS(11, "Bus Deals"),
    BUS_COVID(12, "Social Distancing"),
    BUS_POPULAR_CHOICE(13, "Popular Choice");
    
    private final String name;
    private final int value;

    private e(int i2, String str) {
        this.value = i2;
        this.name = str;
    }

    public final int getValue() {
        return this.value;
    }

    public final String getName() {
        return this.name;
    }
}
