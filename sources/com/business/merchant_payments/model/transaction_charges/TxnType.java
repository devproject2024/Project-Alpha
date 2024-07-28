package com.business.merchant_payments.model.transaction_charges;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class TxnType {
    @c(a = "instruments")
    @a
    public List<Instrument> instruments = null;
    @c(a = "txnType")
    @a
    public String txnType;

    public String getTxnType() {
        return this.txnType;
    }

    public void setTxnType(String str) {
        this.txnType = str;
    }

    public List<Instrument> getInstruments() {
        return this.instruments;
    }

    public void setInstruments(List<Instrument> list) {
        this.instruments = list;
    }
}
