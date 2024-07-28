package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSeatDetailsModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "delivery")
    private Integer delivery;
    @b(a = "delivery_description")
    private String deliveryDescription;
    @b(a = "isSeasonPass")
    private int isSeasonPass;
    @b(a = "item_name")
    private String item_name;
    @b(a = "item_state")
    private String item_state;
    @b(a = "inventory")
    private int mInventory;
    @b(a = "price")
    private int mPrice;
    @b(a = "provider_seat_id")
    private String mProviderSeatId;
    @b(a = "seat_description")
    private String mSeatDescription;
    @b(a = "seat_id")
    private String mSeatId;
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
    @b(a = "seats_io_id")
    private String seats_io_id;
    @b(a = "svg")
    private String svg;

    public int getIsSeasonPass() {
        return this.isSeasonPass;
    }

    public String getItem_name() {
        return this.item_name;
    }

    public String getSeats_io_id() {
        return this.seats_io_id;
    }

    public String getItem_state() {
        return this.item_state;
    }

    public String getSeatId() {
        return this.mSeatId;
    }

    public void setSeatId(String str) {
        this.mSeatId = str;
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

    public String getSvg() {
        return this.svg;
    }

    public Integer getDelivery() {
        return this.delivery;
    }

    public void setDelivery(Integer num) {
        this.delivery = num;
    }

    public String getDeliveryDescription() {
        return this.deliveryDescription;
    }

    public void setDeliveryDescription(String str) {
        this.deliveryDescription = str;
    }
}
