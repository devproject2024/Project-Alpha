package com.travel.flight.pojo.seatancillaryentity.availability;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatNotes extends IJRPaytmDataModel implements Parcelable {
    public static final Parcelable.Creator<CJRSeatNotes> CREATOR = new Parcelable.Creator<CJRSeatNotes>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRSeatNotes[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRSeatNotes(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @a
    @b(a = "emergency_exit")
    private final CJRSeatEmergencyExit CJRSeatEmergencyExit;
    @a
    @b(a = "extra_leg_room")
    private final String extraLegRoom;
    @a
    @b(a = "free_seat")
    private final String freeSeat;
    @a
    @b(a = "non_reclining")
    private final String nonReclining;
    @a
    @b(a = "SG_combo")
    private String sGCombo;

    public int describeContents() {
        return 0;
    }

    protected CJRSeatNotes(Parcel parcel) {
        this.freeSeat = parcel.readString();
        this.nonReclining = parcel.readString();
        this.extraLegRoom = parcel.readString();
        this.CJRSeatEmergencyExit = (CJRSeatEmergencyExit) parcel.readParcelable(CJRSeatEmergencyExit.class.getClassLoader());
        this.sGCombo = parcel.readString();
    }

    public String getFreeSeat() {
        return this.freeSeat;
    }

    public String getNonReclining() {
        return this.nonReclining;
    }

    public String getExtraLegRoom() {
        return this.extraLegRoom;
    }

    public CJRSeatEmergencyExit getCJRSeatEmergencyExit() {
        return this.CJRSeatEmergencyExit;
    }

    public String getSGCombo() {
        return this.sGCombo;
    }

    public void setSGCombo(String str) {
        this.sGCombo = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.freeSeat);
        parcel.writeString(this.nonReclining);
        parcel.writeString(this.extraLegRoom);
        parcel.writeParcelable(this.CJRSeatEmergencyExit, i2);
        parcel.writeString(this.sGCombo);
    }
}
