package com.travel.bus.pojo.photos;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusBPOnward implements IJRDataModel {
    @b(a = "boarding_photos")
    private ArrayList<BoardingPhoto> boardingPhotos = null;
    @b(a = "lat")
    private Double lat;
    @b(a = "lng")
    private Double lng;

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double d2) {
        this.lat = d2;
    }

    public Double getLng() {
        return this.lng;
    }

    public void setLng(Double d2) {
        this.lng = d2;
    }

    public ArrayList<BoardingPhoto> getBoardingPhotos() {
        return this.boardingPhotos;
    }

    public void setBoardingPhotos(ArrayList<BoardingPhoto> arrayList) {
        this.boardingPhotos = arrayList;
    }
}
