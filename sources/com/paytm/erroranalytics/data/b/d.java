package com.paytm.erroranalytics.data.b;

import android.content.Context;
import android.util.Base64;
import com.google.gson.f;
import com.paytm.erroranalytics.c.b;
import com.paytm.erroranalytics.data.a.a;
import com.paytm.erroranalytics.data.b.a;
import com.paytm.erroranalytics.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Map;

public final class d extends b implements c {
    public d(Context context) {
        super(context);
    }

    public final <T> b a(T t, String str, String str2, Map<String, String> map) throws a, MalformedURLException {
        this.f42794b = new f().b(t);
        String str3 = e.f42808a;
        new StringBuilder("EventRestApiImpl createRequest ").append(this.f42794b);
        String str4 = map.get("app_id");
        String str5 = map.get("secret");
        try {
            str2 = Base64.encodeToString((str4 + AppConstants.COLON + str5).getBytes(AppConstants.UTF_8), 10);
        } catch (UnsupportedEncodingException e2) {
            if (e2.getMessage() != null) {
                e2.getMessage();
            }
        }
        this.f42796d = str + "/appdebuganalytics/triggers/save";
        this.f42795c = str2;
        a.C0713a a2 = a.a(this.f42796d, this.f42794b, this.f42795c).call();
        b bVar = new b();
        int i2 = a2.f42789a;
        if (i2 == 1) {
            bVar.f42758b = "Network Error";
            bVar.f42757a = false;
        } else if (i2 == 200) {
            bVar.f42758b = null;
            bVar.f42757a = true;
        } else if (i2 == 202) {
            bVar.f42758b = null;
            bVar.f42757a = true;
        } else if (i2 == 403) {
            bVar.f42758b = "Forbidden";
            bVar.f42759c = true;
            bVar.f42757a = false;
        } else if (i2 == 500) {
            bVar.f42758b = "Server Error";
            bVar.f42757a = false;
        } else if (i2 == 400) {
            bVar.f42758b = "Invalid Request";
            bVar.f42759c = true;
            bVar.f42757a = false;
            bVar.f42760d = true;
        } else if (i2 != 401) {
            bVar.f42758b = "UnKnown Error";
            bVar.f42757a = false;
        } else {
            bVar.f42758b = "Unauthorized";
            bVar.f42759c = true;
            bVar.f42757a = false;
        }
        return bVar;
    }
}
