package com.travel.flight.flightticket.e;

public enum g {
    Flight(0),
    Passengers(1),
    Passenger(2),
    Charges(3),
    Note(4),
    ImgNote(5),
    Important(6),
    Empty(7);
    
    public static final a Companion = null;
    private final int value;

    private g(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new a((byte) 0);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g a(int i2) {
            for (g gVar : g.values()) {
                if (gVar.getValue() == i2) {
                    return gVar;
                }
            }
            return g.Empty;
        }
    }
}
