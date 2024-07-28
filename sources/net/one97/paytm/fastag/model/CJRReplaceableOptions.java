package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRReplaceableOptions extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "is_only_variant")
    private boolean isOnlyVariant;
    @b(a = "filter_label")
    private String mFilterLabel;
    @b(a = "filter_param")
    private String mFilterParam;
    @b(a = "product_variants")
    private ArrayList<CJRProductVarient> mProductVarientList;

    public String getFilterParam() {
        return this.mFilterParam;
    }

    public void setFilterParam(String str) {
        this.mFilterParam = str;
    }

    public String getFilterLabel() {
        return this.mFilterLabel;
    }

    public void setFilterLabel(String str) {
        this.mFilterLabel = str;
    }

    public ArrayList<CJRProductVarient> getProductVarientList() {
        return this.mProductVarientList;
    }

    public void setProductVarientList(ArrayList<CJRProductVarient> arrayList) {
        this.mProductVarientList = arrayList;
    }

    public boolean isOnlyVariant() {
        return this.isOnlyVariant;
    }
}
