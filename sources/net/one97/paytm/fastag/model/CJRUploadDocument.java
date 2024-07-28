package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRUploadDocument extends IJRPaytmDataModel {
    @b(a = "keys")
    public ArrayList<String> keys = new ArrayList<>();
}
