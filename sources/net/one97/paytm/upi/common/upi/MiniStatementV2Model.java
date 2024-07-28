package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class MiniStatementV2Model implements UpiBaseDataModel {
    @c(a = "transactions")
    private ArrayList<UpiTransactionModelV2> mTransactions;

    public ArrayList<UpiTransactionModelV2> getTransactions() {
        return this.mTransactions;
    }

    public void setmTransactions(ArrayList<UpiTransactionModelV2> arrayList) {
        this.mTransactions = arrayList;
    }
}
