package net.one97.paytm.acceptPayment.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRMerchantContextListObject extends IJRPaytmDataModel {
    @b(a = "aggregator")
    private boolean aggregator;
    @b(a = "isSdMerchant")
    private boolean isSdMerchant;
    @b(a = "id")
    private long mId;
    @b(a = "isActive")
    private boolean mIsActive;
    @b(a = "isMerchant")
    private int mIsMerchant;
    @b(a = "merchantType")
    private String mMerchantType;
    @b(a = "mid")
    private String mMid;
    @b(a = "name")
    private String mName;
    @b(a = "roles")
    private ArrayList<CJRMerchantRoles> mRoles;
    @b(a = "migrated")
    private boolean migrated;

    public String getMid() {
        return this.mMid;
    }

    public void setMid(String str) {
        this.mMid = str;
    }

    public String getMerchantType() {
        return this.mMerchantType;
    }

    public void setMerchantType(String str) {
        this.mMerchantType = str;
    }

    public boolean getIsActive() {
        return this.mIsActive;
    }

    public void setIsActive(boolean z) {
        this.mIsActive = z;
    }

    public ArrayList<CJRMerchantRoles> getMerchantRolesList() {
        return this.mRoles;
    }

    public void setMerchantRolesList(ArrayList<CJRMerchantRoles> arrayList) {
        this.mRoles = arrayList;
    }

    public long getId() {
        return this.mId;
    }

    public boolean isMerchant() {
        return this.mIsMerchant == 1;
    }

    public String getName() {
        return this.mName;
    }

    public String getmMid() {
        return this.mMid;
    }

    public void setmMid(String str) {
        this.mMid = str;
    }

    public String getmMerchantType() {
        return this.mMerchantType;
    }

    public void setmMerchantType(String str) {
        this.mMerchantType = str;
    }

    public long getmId() {
        return this.mId;
    }

    public void setmId(long j) {
        this.mId = j;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public int getmIsMerchant() {
        return this.mIsMerchant;
    }

    public void setmIsMerchant(int i2) {
        this.mIsMerchant = i2;
    }

    public boolean ismIsActive() {
        return this.mIsActive;
    }

    public void setmIsActive(boolean z) {
        this.mIsActive = z;
    }

    public boolean isAggregator() {
        return this.aggregator;
    }

    public void setAggregator(boolean z) {
        this.aggregator = z;
    }

    public boolean isMigrated() {
        return this.migrated;
    }

    public void setMigrated(boolean z) {
        this.migrated = z;
    }

    public boolean isSdMerchant() {
        return this.isSdMerchant;
    }

    public void setSdMerchant(boolean z) {
        this.isSdMerchant = z;
    }

    public ArrayList<CJRMerchantRoles> getmRoles() {
        return this.mRoles;
    }

    public void setmRoles(ArrayList<CJRMerchantRoles> arrayList) {
        this.mRoles = arrayList;
    }
}
