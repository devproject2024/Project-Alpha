package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRSelectableAttributes {
    @b(a = "id")
    private String mID;
    @b(a = "name")
    private String mName;
    @b(a = "values")
    private ArrayList<String> mValues;

    public String getID() {
        return this.mID;
    }

    public String getName() {
        return this.mName;
    }

    public ArrayList<String> getValues() {
        return this.mValues;
    }
}
