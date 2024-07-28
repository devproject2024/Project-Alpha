package net.one97.paytm.o2o.movies.common.movies.seats;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRObjRow implements IJRDataModel {
    @b(a = "GridRowId")
    private int GridRowId;
    @b(a = "PhyRowId")
    private String PhyRowId;
    @b(a = "objSeat")
    private ArrayList<CJRObjSeat> objSeatList;

    public int getGridRowId() {
        return this.GridRowId;
    }

    public String getPhyRowId() {
        return this.PhyRowId;
    }

    public ArrayList<CJRObjSeat> getObjSeat() {
        return this.objSeatList;
    }

    public void sortObjSeat() {
        ArrayList<CJRObjSeat> arrayList = this.objSeatList;
        if (arrayList != null) {
            Collections.sort(arrayList, new Comparator<CJRObjSeat>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    CJRObjSeat cJRObjSeat = (CJRObjSeat) obj;
                    if (cJRObjSeat.getGridSeatNum() == ((CJRObjSeat) obj2).getGridSeatNum()) {
                        return 0;
                    }
                    return cJRObjSeat.getGridSeatNum() < cJRObjSeat.getGridSeatNum() ? -1 : 1;
                }
            });
        }
    }
}
