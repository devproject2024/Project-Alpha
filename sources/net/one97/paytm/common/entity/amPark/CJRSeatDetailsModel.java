package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSeatDetailsModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private int mIndex;
    @b(a = "inventory")
    private int mInventory;
    private String mPackageDescription;
    private int mPackageId;
    private String mPackageType;
    @b(a = "price")
    private int mPrice;
    @b(a = "provider_seat_id")
    private String mProviderSeatId;
    @b(a = "seat_description")
    private String mSeatDescription;
    @b(a = "seat_id")
    private int mSeatId;
    @b(a = "seat_limit")
    private int mSeatLimit;
    @b(a = "seat_min")
    private int mSeatMin;
    @b(a = "seat_type")
    private String mSeatType;
    @b(a = "seats_available")
    private int mSeatsAvailable;
    private int mSelectedQuantity;
    private int mSelectedQuantityAtStart;

    public int getSeatId() {
        return this.mSeatId;
    }

    public void setSeatId(int i2) {
        this.mSeatId = this.mSeatId;
    }

    public String getSeatType() {
        return this.mSeatType;
    }

    public void setSeatType(String str) {
        this.mSeatType = str;
    }

    public String getSeatDescription() {
        return this.mSeatDescription;
    }

    public void setSeatDescription(String str) {
        this.mSeatDescription = str;
    }

    public int getPrice() {
        return this.mPrice;
    }

    public void setPrice(int i2) {
        this.mPrice = i2;
    }

    public int getInventory() {
        return this.mInventory;
    }

    public void setInventory(int i2) {
        this.mInventory = i2;
    }

    public int getSeatsAvailable() {
        return this.mSeatsAvailable;
    }

    public void setSeatsAvailable(int i2) {
        this.mSeatsAvailable = i2;
    }

    public int getSeatLimit() {
        return this.mSeatLimit;
    }

    public void setSeatLimit(int i2) {
        this.mSeatLimit = i2;
    }

    public int getSeatMin() {
        return this.mSeatMin;
    }

    public void setSeatMin(int i2) {
        this.mSeatMin = i2;
    }

    public String getProviderSeatId() {
        return this.mProviderSeatId;
    }

    public void setProviderSeatId(String str) {
        this.mProviderSeatId = str;
    }

    public void setSelectedQuantity(int i2) {
        this.mSelectedQuantity = i2;
    }

    public int getSelectedQuantity() {
        return this.mSelectedQuantity;
    }

    public void incrementQuantityAtStart() {
        this.mSelectedQuantityAtStart++;
    }

    public void decrementQuantityAtStart() {
        this.mSelectedQuantityAtStart--;
    }

    public int getSelectedQuantityAtStart() {
        return this.mSelectedQuantityAtStart;
    }

    public void setSelectedQuantityAtStart(int i2) {
        this.mSelectedQuantityAtStart = i2;
    }

    public String getmPackageType() {
        return this.mPackageType;
    }

    public void setmPackageType(String str) {
        this.mPackageType = str;
    }

    public String getmPackageDescription() {
        return this.mPackageDescription;
    }

    public void setmPackageDescription(String str) {
        this.mPackageDescription = str;
    }

    public int getmIndex() {
        return this.mIndex;
    }

    public void setmIndex(int i2) {
        this.mIndex = i2;
    }

    public int getmPackageId() {
        return this.mPackageId;
    }

    public void setmPackageId(int i2) {
        this.mPackageId = i2;
    }

    public boolean equals(Object obj) {
        return getSeatType().equals(((CJRSeatDetailsModel) obj).getSeatType());
    }
}
