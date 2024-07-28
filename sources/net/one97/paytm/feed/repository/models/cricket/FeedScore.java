package net.one97.paytm.feed.repository.models.cricket;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class FeedScore implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private Integer batteamname;
    private Float batteamovers;
    private Integer batteamruns;
    private Integer batteamwkts;
    private Integer bwlteamname;
    private Float inning0Overs;
    private Integer inning0Team;
    private Integer inning0Wkts;
    private Integer inning0runs;
    private Integer innings;
    private String matchID;
    private Float maxovers;
    private String resulttype;
    private String status;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedScore(parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedScore[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.matchID);
    }

    public FeedScore(String str) {
        k.c(str, "matchID");
        this.matchID = str;
    }

    public final String getMatchID() {
        return this.matchID;
    }

    public final void setMatchID(String str) {
        k.c(str, "<set-?>");
        this.matchID = str;
    }

    public final Integer getInnings() {
        return this.innings;
    }

    public final void setInnings(Integer num) {
        this.innings = num;
    }

    public final Integer getBatteamname() {
        return this.batteamname;
    }

    public final void setBatteamname(Integer num) {
        this.batteamname = num;
    }

    public final Integer getBwlteamname() {
        return this.bwlteamname;
    }

    public final void setBwlteamname(Integer num) {
        this.bwlteamname = num;
    }

    public final Integer getBatteamruns() {
        return this.batteamruns;
    }

    public final void setBatteamruns(Integer num) {
        this.batteamruns = num;
    }

    public final Integer getBatteamwkts() {
        return this.batteamwkts;
    }

    public final void setBatteamwkts(Integer num) {
        this.batteamwkts = num;
    }

    public final Float getBatteamovers() {
        return this.batteamovers;
    }

    public final void setBatteamovers(Float f2) {
        this.batteamovers = f2;
    }

    public final Float getMaxovers() {
        return this.maxovers;
    }

    public final void setMaxovers(Float f2) {
        this.maxovers = f2;
    }

    public final Integer getInning0runs() {
        return this.inning0runs;
    }

    public final void setInning0runs(Integer num) {
        this.inning0runs = num;
    }

    public final Float getInning0Overs() {
        return this.inning0Overs;
    }

    public final void setInning0Overs(Float f2) {
        this.inning0Overs = f2;
    }

    public final Integer getInning0Wkts() {
        return this.inning0Wkts;
    }

    public final void setInning0Wkts(Integer num) {
        this.inning0Wkts = num;
    }

    public final Integer getInning0Team() {
        return this.inning0Team;
    }

    public final void setInning0Team(Integer num) {
        this.inning0Team = num;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getResulttype() {
        return this.resulttype;
    }

    public final void setResulttype(String str) {
        this.resulttype = str;
    }
}
