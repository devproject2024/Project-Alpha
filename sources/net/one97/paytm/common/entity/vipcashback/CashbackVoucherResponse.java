package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CashbackVoucherResponse {
    @b(a = "isNext")
    private String isNext;
    @b(a = "voucherList")
    private ArrayList<CashbackVoucher> voucherList;

    public ArrayList<CashbackVoucher> getVoucherList() {
        return this.voucherList;
    }

    public void setVoucherList(ArrayList<CashbackVoucher> arrayList) {
        this.voucherList = arrayList;
    }

    public String getIsNext() {
        return this.isNext;
    }

    public void setIsNext(String str) {
        this.isNext = str;
    }
}
