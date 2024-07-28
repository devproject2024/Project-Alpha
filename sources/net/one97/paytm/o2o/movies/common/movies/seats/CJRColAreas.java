package net.one97.paytm.o2o.movies.common.movies.seats;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRColAreas implements IJRDataModel {
    @b(a = "objArea")
    private ArrayList<CJRObjArea> objArea;

    public ArrayList<CJRObjArea> getObjArea() {
        return this.objArea;
    }
}
