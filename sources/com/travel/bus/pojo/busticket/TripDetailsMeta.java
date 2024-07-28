package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class TripDetailsMeta extends IJRPaytmDataModel {
    @a
    @b(a = "boardingPoints")
    private ArrayList<CJRLocation> boardingPoints = new ArrayList<>();
    @a
    @b(a = "cancellation_policy")
    private ArrayList<CJRBusCancellationPolicy> cancellationPolicy = new ArrayList<>();
    @a
    @b(a = "concession")
    private CJRConcessionObj concessionString;
    @a
    @b(a = "droppingPoints")
    private ArrayList<CJRLocation> droppingPoints = new ArrayList<>();
    @b(a = "is_business_user")
    private boolean isBusinessUser;
    @b(a = "isExtraPaxDetailsRequired")
    private boolean isExtraPaxDetailsRequired;
    @a
    @b(a = "maxSeatsAllowed")
    private Integer maxSeatAllowed;
    @a
    @b(a = "product_id")
    private String productId;
    @a
    @b(a = "provider")
    private TripDetailProvider provider;
    @a
    @b(a = "requestid")
    private String requestid;
    @a
    @b(a = "serverTime")
    private long serverTime;

    public boolean getIsBusinessUser() {
        return this.isBusinessUser;
    }

    public void setIsBusinessUser(boolean z) {
        this.isBusinessUser = z;
    }

    public boolean isExtraPaxDetailsRequired() {
        return this.isExtraPaxDetailsRequired;
    }

    public void setExtraPaxDetailsRequired(boolean z) {
        this.isExtraPaxDetailsRequired = z;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public void setRequestid(String str) {
        this.requestid = str;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

    public ArrayList<CJRBusCancellationPolicy> getCancellationPolicy() {
        return this.cancellationPolicy;
    }

    public void setCancellationPolicy(ArrayList<CJRBusCancellationPolicy> arrayList) {
        this.cancellationPolicy = arrayList;
    }

    public CJRConcessionObj getConcessionString() {
        return this.concessionString;
    }

    public void setConcessionString(CJRConcessionObj cJRConcessionObj) {
        this.concessionString = cJRConcessionObj;
    }

    public ArrayList<CJRLocation> getBoardingPoints() {
        return this.boardingPoints;
    }

    public void setBoardingPoints(ArrayList<CJRLocation> arrayList) {
        this.boardingPoints = arrayList;
    }

    public ArrayList<CJRLocation> getDroppingPoints() {
        return this.droppingPoints;
    }

    public void setDroppingPoints(ArrayList<CJRLocation> arrayList) {
        this.droppingPoints = arrayList;
    }

    public Integer getMaxSeatAllowed() {
        return this.maxSeatAllowed;
    }

    public void setMaxSeatAllowed(Integer num) {
        this.maxSeatAllowed = num;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public TripDetailProvider getProvider() {
        return this.provider;
    }

    public void setProvider(TripDetailProvider tripDetailProvider) {
        this.provider = tripDetailProvider;
    }
}
