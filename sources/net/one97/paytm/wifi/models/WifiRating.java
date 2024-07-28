package net.one97.paytm.wifi.models;

public final class WifiRating {
    private final double maxRating;
    private final double rating;
    private final int totalCount;

    public static /* synthetic */ WifiRating copy$default(WifiRating wifiRating, double d2, int i2, double d3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            d2 = wifiRating.rating;
        }
        double d4 = d2;
        if ((i3 & 2) != 0) {
            i2 = wifiRating.totalCount;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            d3 = wifiRating.maxRating;
        }
        return wifiRating.copy(d4, i4, d3);
    }

    public final double component1() {
        return this.rating;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final double component3() {
        return this.maxRating;
    }

    public final WifiRating copy(double d2, int i2, double d3) {
        return new WifiRating(d2, i2, d3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof WifiRating) {
                WifiRating wifiRating = (WifiRating) obj;
                if (Double.compare(this.rating, wifiRating.rating) == 0) {
                    if (!(this.totalCount == wifiRating.totalCount) || Double.compare(this.maxRating, wifiRating.maxRating) != 0) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.rating);
        long doubleToLongBits2 = Double.doubleToLongBits(this.maxRating);
        return (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + this.totalCount) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "WifiRating(rating=" + this.rating + ", totalCount=" + this.totalCount + ", maxRating=" + this.maxRating + ")";
    }

    public WifiRating(double d2, int i2, double d3) {
        this.rating = d2;
        this.totalCount = i2;
        this.maxRating = d3;
    }

    public final double getMaxRating() {
        return this.maxRating;
    }

    public final double getRating() {
        return this.rating;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }
}
