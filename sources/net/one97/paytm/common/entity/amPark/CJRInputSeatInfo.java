package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInputSeatInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "count")
    private int count = 1;
    @b(a = "description")
    private String description = "";
    @b(a = "packageType")
    private String packageType;
    @b(a = "pricePerSeat")
    private String pricePerSeat = "600";
    @b(a = "providerSeatId")
    private String providerSeatId = "97700";
    @b(a = "seatId")
    private String seatId = "25929";
    @b(a = "seatType")
    private String seatType = "fees";

    public String getSeatId() {
        return this.seatId;
    }

    public void setSeatId(String str) {
        this.seatId = str;
    }

    public String getSeatType() {
        return this.seatType;
    }

    public void setSeatType(String str) {
        this.seatType = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getPricePerSeat() {
        return this.pricePerSeat;
    }

    public void setPricePerSeat(String str) {
        this.pricePerSeat = str;
    }

    public String getProviderSeatId() {
        return this.providerSeatId;
    }

    public void setProviderSeatId(String str) {
        this.providerSeatId = str;
    }

    public void setPackageType(String str) {
        this.packageType = str;
    }

    public String getPackageType() {
        return this.packageType;
    }
}
