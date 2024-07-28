package com.alipay.mobile.nebulaappcenter.dbapi;

public interface H5Transaction {
    void beginTransaction();

    void endTransaction();

    void setTransactionSuccessful();
}
