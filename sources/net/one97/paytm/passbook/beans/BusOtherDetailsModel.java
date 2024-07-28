package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class BusOtherDetailsModel extends IJRDataModel {
    public static final String ROW_NAME_BARCODE_ID = "BarCodeId";
    public static final String ROW_NAME_BARCODE_IMAGE = "BarCodeImage";
    public static final String ROW_NAME_BOKKING_TIME = "BookingTime";
    public static final String ROW_NAME_SERVER_TIME = "ServerTime";
    public static final String ROW_NAME_VALIDITY = "Validity";
    private static final long serialVersionUID = 2;
    @b(a = "rowname")
    private String rowname;
    @b(a = "rowvalue")
    private String rowvalue;

    public String getRowname() {
        return this.rowname;
    }

    public String getRowvalue() {
        return this.rowvalue;
    }
}
