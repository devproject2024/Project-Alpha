package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRFrontEndFilter extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "applied")
    private ArrayList<CJRFilterValue> mAppliedFrontEndFiltersList = new ArrayList<>();
    @b(a = "filter_param")
    private String mFilterParam;
    @b(a = "title")
    private String mTitle;
    @b(a = "type")
    private String mType;

    public String getName() {
        return null;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public ArrayList<CJRFilterValue> getAppliedFrontEndFiltersList() {
        return this.mAppliedFrontEndFiltersList;
    }

    public String getFilterParam() {
        return this.mFilterParam;
    }

    public String getType() {
        return this.mType;
    }
}
