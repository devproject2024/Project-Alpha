package net.one97.paytm.o2o.movies.common.movies.widget;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieWidgetInfo implements IJRDataModel {
    @b(a = "category")
    private String category;
    @b(a = "values")
    private ArrayList<CJRMovieWidgetValue> values = null;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public ArrayList<CJRMovieWidgetValue> getValues() {
        return this.values;
    }

    public void setValues(ArrayList<CJRMovieWidgetValue> arrayList) {
        this.values = arrayList;
    }
}
