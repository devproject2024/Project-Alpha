package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class EmailEditResponse extends IJRDataModel {
    @b(a = "message")
    public String message;
    @b(a = "responseCode")
    public String responseCode;
    @b(a = "state")
    public String state;
    @b(a = "status")
    public String status;
}
