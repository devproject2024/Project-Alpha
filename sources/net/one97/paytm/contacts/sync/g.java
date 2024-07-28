package net.one97.paytm.contacts.sync;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.paytm.contactsSdk.database.Tables;
import com.paytm.utility.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.ContactHealthReqt;
import net.one97.paytm.contacts.entities.beans.Contacts;
import net.one97.paytm.contacts.entities.beans.PaymentInstrument;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONObject;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f50203a = new g();

    private g() {
    }

    public static String a(String str, int i2, int i3, long j, Context context) {
        k.c(str, "contactType");
        k.c(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
        if (p.a(str, e.b.PHONEBOOK.name(), true)) {
            jSONObject.put("contactStatus", "ACTIVE");
        }
        jSONObject.put("contactType", str);
        jSONObject.put("timeStamp", j);
        jSONObject.put("limit", i2);
        jSONObject.put("offset", i3);
        String jSONObject2 = jSONObject.toString();
        k.a((Object) jSONObject2, "obj.toString()");
        return jSONObject2;
    }

    public static HashMap<String, String> a(Context context) {
        k.c(context, "context");
        HashMap<String, String> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put("clientId", "PAYTM");
        String a2 = d.a(context);
        if (a2 != null) {
            if (a2.length() > 0) {
                map.put(UpiRequestBuilder.SESSION_TOKEN, a2);
            }
        }
        map.put("Content-Type", "application/json");
        return hashMap;
    }

    public static String a(Context context, ContactDetail contactDetail) {
        k.c(context, "context");
        k.c(contactDetail, "item");
        HashSet<PaymentInstrument> paymentInstrument = contactDetail.getPaymentInstrument();
        String str = null;
        if (paymentInstrument != null) {
            for (PaymentInstrument type : paymentInstrument) {
                str = type.getType();
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
        e eVar = e.f50261a;
        jSONObject.put("contactType", e.a(contactDetail.getContactType()));
        jSONObject.put("contactId", contactDetail.getContactId());
        jSONObject.put("paymentInstrumentId", contactDetail.getPaymentInstrumentId());
        jSONObject.put("paymentInstrumentType", str);
        String jSONObject2 = jSONObject.toString();
        k.a((Object) jSONObject2, "obj.toString()");
        return jSONObject2;
    }

    public static String a(Context context, ArrayList<Contacts> arrayList) {
        k.c(context, "context");
        k.c(arrayList, Tables.CONTACTS);
        ContactHealthReqt contactHealthReqt = new ContactHealthReqt();
        contactHealthReqt.setDeviceId(UpiUtils.getDeviceId(context));
        contactHealthReqt.setContacts(arrayList);
        String a2 = new f().a((Object) contactHealthReqt);
        k.a((Object) a2, "Gson().toJson(contactHealthReqt)");
        return a2;
    }
}
