package net.one97.paytm.common.entity.events;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSelectedInsiderSeats implements IJRDataModel {
    private String action = "add";
    private String category;
    private int delivery;
    private int minSeat;
    private String name;
    private String seatsIoId;
    private int selectedSeatCount;

    public CJRSelectedInsiderSeats(String str, String str2, String str3) {
        this.category = str;
        this.name = str2;
        this.seatsIoId = str3;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getSeatId() {
        return this.name;
    }

    public void setSeatId(String str) {
        this.name = str;
    }

    public int getMinSeat() {
        return this.minSeat;
    }

    public void setMinSeat(int i2) {
        this.minSeat = i2;
    }

    public int getSelectedSeatCount() {
        return this.selectedSeatCount;
    }

    public void setSelectedSeatCount(int i2) {
        this.selectedSeatCount = i2;
    }

    public String getSeatsIoId() {
        return this.seatsIoId;
    }

    public void setSeatsIoId(String str) {
        this.seatsIoId = str;
    }

    public int getDelivery() {
        return this.delivery;
    }

    public void setDelivery(int i2) {
        this.delivery = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CJRSelectedInsiderSeats) {
            CJRSelectedInsiderSeats cJRSelectedInsiderSeats = (CJRSelectedInsiderSeats) obj;
            if (!cJRSelectedInsiderSeats.getSeatId().equals(this.name) || !cJRSelectedInsiderSeats.getCategory().equals(this.category) || !cJRSelectedInsiderSeats.getSeatsIoId().equals(this.seatsIoId)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
