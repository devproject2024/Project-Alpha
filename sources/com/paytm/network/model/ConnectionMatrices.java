package com.paytm.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ConnectionMatrices implements Parcelable {
    public static final Parcelable.Creator<ConnectionMatrices> CREATOR = new Parcelable.Creator<ConnectionMatrices>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ConnectionMatrices[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ConnectionMatrices(parcel);
        }
    };
    String ipa;
    double metricConnectionTime;
    double metricDomainLookupTime;
    double metricRequestTime;
    double metricResponseTime;
    double metricSecureConnectionTime;
    double metricTotalTime;
    long requestWaitTime;
    long totalRoundTripTime;
    String url;

    public int describeContents() {
        return 0;
    }

    public ConnectionMatrices(double d2, double d3, double d4, double d5, double d6, double d7, String str) {
        this.metricConnectionTime = d2;
        this.metricDomainLookupTime = d3;
        this.metricRequestTime = d4;
        this.metricResponseTime = d5;
        this.metricSecureConnectionTime = d6;
        this.metricTotalTime = d7;
        this.url = str;
    }

    protected ConnectionMatrices(Parcel parcel) {
        this.metricConnectionTime = parcel.readDouble();
        this.metricDomainLookupTime = parcel.readDouble();
        this.metricRequestTime = parcel.readDouble();
        this.metricResponseTime = parcel.readDouble();
        this.metricSecureConnectionTime = parcel.readDouble();
        this.metricTotalTime = parcel.readDouble();
        this.metricTotalTime = parcel.readDouble();
        this.url = parcel.readString();
    }

    public ConnectionMatrices() {
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeDouble(this.metricConnectionTime);
        parcel.writeDouble(this.metricDomainLookupTime);
        parcel.writeDouble(this.metricRequestTime);
        parcel.writeDouble(this.metricResponseTime);
        parcel.writeDouble(this.metricSecureConnectionTime);
        parcel.writeDouble(this.metricTotalTime);
        parcel.writeString(this.url);
    }

    public double getMetricConnectionTime() {
        return this.metricConnectionTime;
    }

    public void setMetricConnectionTime(double d2) {
        this.metricConnectionTime = d2;
    }

    public double getMetricDomainLookupTime() {
        return this.metricDomainLookupTime;
    }

    public void setMetricDomainLookupTime(double d2) {
        this.metricDomainLookupTime = d2;
    }

    public double getMetricRequestTime() {
        return this.metricRequestTime;
    }

    public void setMetricRequestTime(double d2) {
        this.metricRequestTime = d2;
    }

    public double getMetricResponseTime() {
        return this.metricResponseTime;
    }

    public void setMetricResponseTime(double d2) {
        this.metricResponseTime = d2;
    }

    public double getMetricSecureConnectionTime() {
        return this.metricSecureConnectionTime;
    }

    public void setMetricSecureConnectionTime(double d2) {
        this.metricSecureConnectionTime = d2;
    }

    public double getMetricTotalTime() {
        return this.metricTotalTime;
    }

    public void setMetricTotalTime(double d2) {
        this.metricTotalTime = d2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getIpa() {
        return this.ipa;
    }

    public void setIpa(String str) {
        this.ipa = str;
    }

    public long getRequestWaitTime() {
        return this.requestWaitTime;
    }

    public void setRequestWaitTime(long j) {
        this.requestWaitTime = j;
    }

    public void setTotalRoundTripTime(long j) {
        this.totalRoundTripTime = j;
    }

    public long getTotalRoundTripTime() {
        return this.totalRoundTripTime;
    }
}
