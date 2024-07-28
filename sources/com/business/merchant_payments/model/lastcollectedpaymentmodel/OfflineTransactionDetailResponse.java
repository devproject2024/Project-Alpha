package com.business.merchant_payments.model.lastcollectedpaymentmodel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;
import java.util.ArrayList;

public class OfflineTransactionDetailResponse extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "endResult")
    public int mEndResult;
    @c(a = "fieldsName")
    public ArrayList<String> mFildNames;
    @c(a = "result")
    public ArrayList<OfflineTransDetailObject> mOfflineTransDetailObj;
    @c(a = "resultSize")
    public int mResultSize;
    @c(a = "startResult")
    public int mStartResult;

    public int getmResultSize() {
        return this.mResultSize;
    }

    public int getmStartResult() {
        return this.mStartResult;
    }

    public int getmEndResult() {
        return this.mEndResult;
    }

    public ArrayList<String> getmFildNames() {
        return this.mFildNames;
    }

    public ArrayList<OfflineTransDetailObject> getmOfflineTransDetailObj() {
        return this.mOfflineTransDetailObj;
    }

    public void setmOfflineTransDetailObj(ArrayList<OfflineTransDetailObject> arrayList) {
        this.mOfflineTransDetailObj = arrayList;
    }
}
