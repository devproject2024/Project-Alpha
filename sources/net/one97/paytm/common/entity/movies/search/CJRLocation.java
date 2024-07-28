package net.one97.paytm.common.entity.movies.search;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLocation implements IJRDataModel {
    @b(a = "label")
    private String mLabel;
    private String mLastSelectedValue;
    @b(a = "searchKeys")
    private ArrayList<String> mSearchKey;
    @b(a = "value")
    private String mValue;

    public ArrayList<String> getmSearchKey() {
        return this.mSearchKey;
    }

    public void setmSearchKey(ArrayList<String> arrayList) {
        this.mSearchKey = arrayList;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public String getLastSelected() {
        return this.mLastSelectedValue;
    }

    public void setLastSelected(String str) {
        this.mLastSelectedValue = str;
    }
}
