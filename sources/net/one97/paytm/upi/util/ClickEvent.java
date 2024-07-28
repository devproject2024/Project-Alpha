package net.one97.paytm.upi.util;

import java.util.ArrayList;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;

public class ClickEvent {
    private int count;
    private int position;
    private boolean selectAll;
    private ArrayList<UpiDBTransactionModel> upiDBTransactionModelArrayList;

    public ClickEvent(int i2, int i3, ArrayList<UpiDBTransactionModel> arrayList, boolean z) {
        this.position = i2;
        this.count = i3;
        this.selectAll = z;
        this.upiDBTransactionModelArrayList = arrayList;
    }

    public ArrayList<UpiDBTransactionModel> getUpiDBTransactionModelArrayList() {
        return this.upiDBTransactionModelArrayList;
    }

    public void setUpiDBTransactionModelArrayList(ArrayList<UpiDBTransactionModel> arrayList) {
        this.upiDBTransactionModelArrayList = arrayList;
    }

    public boolean isSelectAll() {
        return this.selectAll;
    }

    public void setSelectAll(boolean z) {
        this.selectAll = z;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }
}
