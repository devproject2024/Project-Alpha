package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class NpciMetaDetails implements UpiBaseDataModel {
    @c(a = "banksDown")
    private ArrayList<String> banksDown;
    @c(a = "category")
    private String category;
    @c(a = "displayMsg")
    private String displayMsg;
    @c(a = "txnAction")
    private String txnAction;

    public String getCategory() {
        return this.category;
    }

    public String getTxnAction() {
        return this.txnAction;
    }

    public String getDisplayMsg() {
        return this.displayMsg;
    }

    public ArrayList<String> getBanksDown() {
        return this.banksDown;
    }
}
