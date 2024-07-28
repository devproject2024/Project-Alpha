package com.alipay.mobile.nebulaappcenter.dbhelp;

import com.alipay.mobile.nebulaappcenter.dbapi.H5Transaction;

public class H5TransactionImpl implements H5Transaction {
    private static final String TAG = "H5TransactionImpl";

    private boolean enable() {
        return false;
    }

    public void beginTransaction() {
        if (!enable()) {
        }
    }

    public void endTransaction() {
        if (enable()) {
            H5DBUtil.getOnLineDBHelperInstance().getWritableDatabase().endTransaction();
        }
    }

    public void setTransactionSuccessful() {
        if (enable()) {
            H5DBUtil.getOnLineDBHelperInstance().getWritableDatabase().setTransactionSuccessful();
        }
    }
}
