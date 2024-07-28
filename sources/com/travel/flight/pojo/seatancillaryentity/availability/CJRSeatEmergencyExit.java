package com.travel.flight.pojo.seatancillaryentity.availability;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRSeatEmergencyExit extends IJRPaytmDataModel implements Parcelable {
    public static final Parcelable.Creator<CJRSeatEmergencyExit> CREATOR = new Parcelable.Creator<CJRSeatEmergencyExit>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRSeatEmergencyExit[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRSeatEmergencyExit(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @a
    @b(a = "contents")
    private List<String> contents = null;
    @a
    @b(a = "description")
    private String description;
    @a
    @b(a = "title")
    private String title;

    public int describeContents() {
        return 0;
    }

    public CJRSeatEmergencyExit(List<String> list) {
    }

    protected CJRSeatEmergencyExit(Parcel parcel) {
        this.contents = parcel.createStringArrayList();
        this.description = parcel.readString();
        this.title = parcel.readString();
    }

    public List<String> getContents() {
        return this.contents;
    }

    public void setContents(List<String> list) {
        this.contents = list;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.contents);
        parcel.writeString(this.description);
        parcel.writeString(this.title);
    }
}
