package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.loader.a.a;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.database.Tables;
import com.paytm.utility.q;
import com.paytm.utility.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.a.f;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.d;
import org.json.JSONObject;

public final class h extends net.one97.paytm.phoenix.core.a implements a.C0056a<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.phoenix.api.b f19783a;

    /* renamed from: b  reason: collision with root package name */
    H5Event f19784b;

    /* renamed from: c  reason: collision with root package name */
    Integer f19785c;

    /* renamed from: d  reason: collision with root package name */
    final int f19786d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f19787e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f19788f;

    /* renamed from: g  reason: collision with root package name */
    private String f19789g;

    /* renamed from: h  reason: collision with root package name */
    private String f19790h;

    public final void a(androidx.loader.b.c<Cursor> cVar) {
        k.c(cVar, "loader");
    }

    public h() {
        super("paytmFetchAllContacts");
    }

    public final /* synthetic */ void a(androidx.loader.b.c cVar, Object obj) {
        k.c(cVar, "loader");
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new c(this, (Cursor) obj));
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        StringBuilder sb;
        H5Event h5Event2;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        String str = "";
        if (a(h5Event)) {
            this.f19783a = bVar;
            this.f19784b = h5Event;
            JSONObject params = h5Event.getParams();
            String str2 = null;
            if (params != null && params.has(H5Param.PAGE)) {
                JSONObject params2 = h5Event.getParams();
                this.f19785c = params2 != null ? Integer.valueOf(params2.getInt(H5Param.PAGE)) : null;
            }
            JSONObject params3 = h5Event.getParams();
            if (params3 != null && params3.has("count")) {
                JSONObject params4 = h5Event.getParams();
                this.f19788f = params4 != null ? Integer.valueOf(params4.getInt("count")) : null;
            }
            JSONObject params5 = h5Event.getParams();
            if (params5 != null && params5.has("name")) {
                JSONObject params6 = h5Event.getParams();
                this.f19789g = params6 != null ? params6.getString("name") : null;
            }
            JSONObject params7 = h5Event.getParams();
            if (params7 != null && params7.has("number")) {
                JSONObject params8 = h5Event.getParams();
                if (params8 != null) {
                    str2 = params8.getString("number");
                }
                this.f19790h = str2;
            }
            Activity activity = h5Event.getActivity();
            if (activity != null) {
                String bridgeName = h5Event.getBridgeName();
                if (bridgeName == null || bridgeName.hashCode() != 166800699 || !bridgeName.equals("paytmFetchAllContacts")) {
                    StringBuilder sb2 = new StringBuilder("Event not handled ");
                    String bridgeName2 = h5Event.getBridgeName();
                    if (bridgeName2 == null) {
                        bridgeName2 = str;
                    }
                    sb2.append(bridgeName2);
                    q.b(sb2.toString());
                    d.a aVar = d.f19890a;
                    StringBuilder sb3 = new StringBuilder("Event not handled ");
                    String bridgeName3 = h5Event.getBridgeName();
                    if (bridgeName3 != null) {
                        str = bridgeName3;
                    }
                    sb3.append(str);
                    d.a.a(h5Event, 2, sb3.toString(), bVar);
                    return true;
                } else if (activity instanceof PhoenixActivity) {
                    this.f19787e = activity;
                    x.a aVar2 = new x.a();
                    aVar2.element = true;
                    if (s.a() && androidx.core.content.b.a((Context) activity, "android.permission.READ_CONTACTS") != 0) {
                        aVar2.element = false;
                    }
                    if (aVar2.element) {
                        a((PhoenixActivity) activity);
                    } else {
                        q.b("Requesting permission");
                        ((PhoenixActivity) activity).g().addObserver(new a(aVar2, activity, this, h5Event, bVar));
                        androidx.core.app.a.a(activity, new String[]{"android.permission.READ_CONTACTS"}, 101);
                    }
                } else {
                    q.b("Activity is not " + PhoenixActivity.class.getName());
                    d.a aVar3 = d.f19890a;
                    StringBuilder sb4 = new StringBuilder("Activity is not ");
                    str = PhoenixActivity.class.getName();
                    sb = sb4;
                    h5Event2 = h5Event;
                }
            } else {
                q.b("Activity is NULL");
                d.a aVar4 = d.f19890a;
                d.a.a(h5Event, 2, "Activity is NULL", bVar);
            }
            return true;
        }
        StringBuilder sb5 = new StringBuilder("Invalid Event ");
        String bridgeName4 = h5Event.getBridgeName();
        if (bridgeName4 == null) {
            bridgeName4 = str;
        }
        sb5.append(bridgeName4);
        q.b(sb5.toString());
        d.a aVar5 = d.f19890a;
        h5Event2 = this.f19784b;
        sb = new StringBuilder("Invalid Event ");
        String bridgeName5 = h5Event.getBridgeName();
        if (bridgeName5 != null) {
            str = bridgeName5;
        }
        sb.append(str);
        d.a.a(h5Event2, 2, sb.toString(), bVar);
        return true;
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.a f19791a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19792b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f19793c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f19794d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f19795e;

        a(x.a aVar, Activity activity, h hVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
            this.f19791a = aVar;
            this.f19792b = activity;
            this.f19793c = hVar;
            this.f19794d = h5Event;
            this.f19795e = bVar;
        }

        public final void update(Observable observable, Object obj) {
            this.f19791a.element = false;
            if (obj instanceof o) {
                o oVar = (o) obj;
                Object first = oVar.getFirst();
                if (first != null) {
                    String[] strArr = (String[]) first;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        if (f.a((T[]) strArr, "android.permission.READ_CONTACTS") && s.a(iArr)) {
                            this.f19791a.element = true;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<out kotlin.String>");
                }
            }
            if (this.f19791a.element) {
                this.f19793c.a((PhoenixActivity) this.f19792b);
                return;
            }
            q.b("Permission not granted");
            d.a aVar = d.f19890a;
            d.a.a(this.f19794d, 2, "Permission not granted", this.f19795e);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f19796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f19797b;

        b(h hVar, PhoenixActivity phoenixActivity) {
            this.f19796a = hVar;
            this.f19797b = phoenixActivity;
        }

        public final void run() {
            if (androidx.loader.a.a.a(this.f19797b).b(this.f19796a.f19786d) == null) {
                androidx.loader.a.a.a(this.f19797b).a(this.f19796a.f19786d, (Bundle) null, this.f19796a);
            } else {
                androidx.loader.a.a.a(this.f19797b).a(this.f19796a.f19786d, this.f19796a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(PhoenixActivity phoenixActivity) {
        new Handler(Looper.getMainLooper()).post(new b(this, phoenixActivity));
    }

    public final androidx.loader.b.c<Cursor> a(Bundle bundle) {
        Integer num;
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] strArr = {"_id", "display_name", "data1", "photo_uri"};
        StringBuilder sb = new StringBuilder("data1 IS NOT NULL AND data1 != \"\"");
        k.a((Object) sb, "StringBuilder()\n        …s.Phone.NUMBER} != \\\"\\\"\")");
        if (!TextUtils.isEmpty(this.f19789g)) {
            StringBuilder sb2 = new StringBuilder(" AND display_name LIKE '%");
            String str = this.f19789g;
            if (str == null) {
                k.a();
            }
            sb2.append(str);
            sb2.append("%' COLLATE NOCASE");
            sb.append(sb2.toString());
        }
        if (!TextUtils.isEmpty(this.f19790h)) {
            StringBuilder sb3 = new StringBuilder(" AND data1 LIKE '%");
            String str2 = this.f19790h;
            if (str2 == null) {
                k.a();
            }
            sb3.append(str2);
            sb3.append("%' COLLATE NOCASE");
            sb.append(sb3.toString());
        }
        String str3 = "display_name ASC";
        Integer num2 = this.f19785c;
        if (num2 != null) {
            if (num2 == null) {
                k.a();
            }
            if (num2.intValue() >= 0 && (num = this.f19788f) != null) {
                if (num == null) {
                    k.a();
                }
                if (num.intValue() >= 0) {
                    StringBuilder sb4 = new StringBuilder(" LIMIT ");
                    Integer num3 = this.f19785c;
                    if (num3 == null) {
                        k.a();
                    }
                    int intValue = num3.intValue();
                    Integer num4 = this.f19788f;
                    if (num4 == null) {
                        k.a();
                    }
                    sb4.append(intValue * num4.intValue());
                    sb4.append(',');
                    Integer num5 = this.f19788f;
                    if (num5 == null) {
                        k.a();
                    }
                    sb4.append(num5.intValue());
                    str3 = k.a(str3, (Object) sb4.toString());
                }
            }
        }
        String str4 = str3;
        Activity activity = this.f19787e;
        if (activity == null) {
            k.a();
        }
        return new androidx.loader.b.b(activity, uri, strArr, sb.toString(), (String[]) null, str4);
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f19798a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Cursor f19799b;

        c(h hVar, Cursor cursor) {
            this.f19798a = hVar;
            this.f19799b = cursor;
        }

        public final void run() {
            if (this.f19799b == null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f19800a;

                    {
                        this.f19800a = r1;
                    }

                    public final void run() {
                        q.b("Connect with system not successful, try again");
                        d.a aVar = d.f19890a;
                        d.a.a(this.f19800a.f19798a.f19784b, 2, "Connect with system not successful, try again", this.f19800a.f19798a.f19783a);
                    }
                });
                return;
            }
            try {
                if (this.f19798a.f19784b != null) {
                    final Collection a2 = h.a(this.f19799b);
                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ c f19801a;

                        {
                            this.f19801a = r1;
                        }

                        public final void run() {
                            String str;
                            try {
                                HashMap hashMap = new HashMap(3);
                                Map map = hashMap;
                                Integer num = this.f19801a.f19798a.f19785c;
                                if (num == null || (str = String.valueOf(num.intValue())) == null) {
                                    str = "0";
                                }
                                map.put(H5Param.PAGE, str);
                                hashMap.put("totalContacts", Integer.valueOf(a2.size()));
                                hashMap.put(Tables.CONTACTS, a2);
                                h hVar = this.f19801a.f19798a;
                                H5Event h5Event = this.f19801a.f19798a.f19784b;
                                if (h5Event == null) {
                                    k.a();
                                }
                                net.one97.paytm.phoenix.core.a.a(hVar, h5Event, hashMap, false, 4);
                            } catch (Exception e2) {
                                q.b("Exception in parsing " + e2.getMessage());
                                d.a aVar = d.f19890a;
                                H5Event h5Event2 = this.f19801a.f19798a.f19784b;
                                d.a.a(h5Event2, 2, "Exception in parsing " + e2.getMessage(), this.f19801a.f19798a.f19783a);
                            }
                        }
                    });
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f19803a;

                    {
                        this.f19803a = r1;
                    }

                    public final void run() {
                        q.b("Event not available, try again");
                        d.a aVar = d.f19890a;
                        d.a.a(this.f19803a.f19798a.f19784b, 2, "Event not available, try again", this.f19803a.f19798a.f19783a);
                    }
                });
            } catch (Exception e2) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f19804a;

                    {
                        this.f19804a = r1;
                    }

                    public final void run() {
                        q.b("Exception in parsing " + e2.getMessage());
                        d.a aVar = d.f19890a;
                        H5Event h5Event = this.f19804a.f19798a.f19784b;
                        d.a.a(h5Event, 2, "Exception in parsing " + e2.getMessage(), this.f19804a.f19798a.f19783a);
                    }
                });
            }
        }
    }

    public static final /* synthetic */ Collection a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String string = cursor.getString(cursor.getColumnIndex("_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("display_name"));
            String string3 = cursor.getString(cursor.getColumnIndex("data1"));
            String string4 = cursor.getString(cursor.getColumnIndex("photo_uri"));
            if (!TextUtils.isEmpty(string3)) {
                if (TextUtils.isEmpty(string2)) {
                    string2 = string3;
                }
                HashMap hashMap = new HashMap(4);
                Map map = hashMap;
                map.put("id", string);
                map.put("name", string2);
                map.put("phoneNumber", string3);
                map.put("photoUri", string4);
                arrayList.add(hashMap);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }
}
