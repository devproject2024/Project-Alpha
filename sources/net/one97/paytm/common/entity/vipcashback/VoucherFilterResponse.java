package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class VoucherFilterResponse extends IJRPaytmDataModel {
    @b(a = "facets")
    private ArrayList<Facets> facets;
    @b(a = "status")
    private String status;

    public ArrayList<Facets> getFacetsList() {
        return this.facets;
    }

    public void setFacets(ArrayList<Facets> arrayList) {
        this.facets = arrayList;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
