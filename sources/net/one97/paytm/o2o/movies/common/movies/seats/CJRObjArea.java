package net.one97.paytm.o2o.movies.common.movies.seats;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.Collections;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRObjArea implements IJRDataModel {
    @b(a = "AreaCode")
    private String AreaCode;
    @b(a = "AreaDesc")
    private String AreaDesc;
    @b(a = "AreaNum")
    private String AreaNum;
    @b(a = "HasCurrentOrder")
    private boolean hasCurrentOrder;
    @b(a = "objRow")
    private ArrayList<CJRObjRow> objRowList;

    public String getAreaDesc() {
        return this.AreaDesc;
    }

    public String getAreaCode() {
        return this.AreaCode;
    }

    public String getAreaNum() {
        return this.AreaNum;
    }

    public boolean getHasCurrentOrder() {
        return this.hasCurrentOrder;
    }

    public ArrayList<CJRObjRow> getObjRow() {
        return this.objRowList;
    }

    public void sortObjRow() {
        ArrayList<CJRObjRow> arrayList = this.objRowList;
        if (arrayList != null && !this.hasCurrentOrder) {
            Collections.reverse(arrayList);
        }
    }
}
