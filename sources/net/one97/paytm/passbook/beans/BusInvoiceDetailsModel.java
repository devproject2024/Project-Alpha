package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class BusInvoiceDetailsModel extends IJRDataModel {
    private static final long serialVersionUID = 2;
    @b(a = "headerName")
    ArrayList<String> headerName;
    @b(a = "itemDetails")
    ArrayList<ArrayList<String>> itemDetails;
    @b(a = "otherDetails")
    private ArrayList<BusOtherDetailsModel> otherDetails;
    @b(a = "taxDetails")
    private String taxDetails;

    public ArrayList<String> getHeaderName() {
        return this.headerName;
    }

    public ArrayList<ArrayList<String>> getItemDetails() {
        return this.itemDetails;
    }

    public String getTaxDetails() {
        return this.taxDetails;
    }

    public ArrayList<BusOtherDetailsModel> getOtherDetails() {
        return this.otherDetails;
    }
}
