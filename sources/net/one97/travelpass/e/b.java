package net.one97.travelpass.e;

import android.content.Context;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {
    /* access modifiers changed from: private */
    public static final String A = A;
    /* access modifiers changed from: private */
    public static final String B = B;
    /* access modifiers changed from: private */
    public static final String C = C;

    /* renamed from: a  reason: collision with root package name */
    public static final a f30322a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f30323b = f30323b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f30324c = f30324c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f30325d = f30325d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f30326e = f30326e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f30327f = f30327f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String f30328g = f30328g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f30329h = f30329h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f30330i = f30330i;
    /* access modifiers changed from: private */
    public static final String j = j;
    /* access modifiers changed from: private */
    public static final String k = k;
    /* access modifiers changed from: private */
    public static final String l = l;
    /* access modifiers changed from: private */
    public static final String m = "strip_clicked";
    /* access modifiers changed from: private */
    public static final String n = n;
    /* access modifiers changed from: private */
    public static final String o = o;
    /* access modifiers changed from: private */
    public static final String p = p;
    /* access modifiers changed from: private */
    public static final String q = q;
    /* access modifiers changed from: private */
    public static final String r = r;
    /* access modifiers changed from: private */
    public static final String s = s;
    private static final String t = "share_clicked";
    /* access modifiers changed from: private */
    public static final String u = u;
    /* access modifiers changed from: private */
    public static final String v = v;
    /* access modifiers changed from: private */
    public static final String w = w;
    /* access modifiers changed from: private */
    public static final String x = x;
    /* access modifiers changed from: private */
    public static final String y = y;
    /* access modifiers changed from: private */
    public static final String z = z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            k.c(context, "context");
            k.c(str, "category");
            k.c(str2, "action");
            HashMap hashMap = new HashMap();
            String str9 = d.cv;
            if (str8 == null) {
                k.a();
            }
            hashMap.put(str9, str8);
            hashMap.put("event_category", str);
            hashMap.put("event_action", str2);
            CharSequence charSequence = str7;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str7);
            }
            CharSequence charSequence2 = str3;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                hashMap.put("event_label", str3);
            }
            CharSequence charSequence3 = str4;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                hashMap.put("event_label2", str4);
            }
            CharSequence charSequence4 = str5;
            if (!(charSequence4 == null || charSequence4.length() == 0)) {
                hashMap.put("event_label3", str5);
            }
            CharSequence charSequence5 = str6;
            if (charSequence5 == null || charSequence5.length() == 0) {
                z = true;
            }
            if (!z) {
                hashMap.put("event_value", str6);
            }
            k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
            net.one97.travelpass.d.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
        }

        public static /* synthetic */ void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
            String str9;
            int i3 = i2;
            String str10 = (i3 & 8) != 0 ? null : str3;
            String str11 = (i3 & 16) != 0 ? null : str4;
            String str12 = (i3 & 32) != 0 ? null : str5;
            String str13 = (i3 & 64) != 0 ? null : str6;
            String str14 = (i3 & 128) != 0 ? null : str7;
            if ((i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0) {
                str9 = b.f30323b;
            } else {
                str9 = str8;
            }
            a(context, str, str2, str10, str11, str12, str13, str14, str9);
        }

        public static void a(Context context, String str) {
            k.c(context, "context");
            k.c(str, "offerId");
            a(context, b.f30329h, b.o, str, (String) null, (String) null, (String) null, b.f30324c, (String) null, 368);
        }

        public static void a(Context context) {
            k.c(context, "context");
            a(context, b.k, b.u, (String) null, (String) null, (String) null, (String) null, b.f30327f, (String) null, 376);
        }

        public static void b(Context context) {
            k.c(context, "context");
            a(context, b.k, b.v, b.B, (String) null, (String) null, (String) null, b.f30327f, (String) null, 368);
        }

        public static void c(Context context) {
            k.c(context, "context");
            a(context, b.k, b.v, b.C, (String) null, (String) null, (String) null, b.f30327f, (String) null, 368);
        }

        public static void d(Context context) {
            k.c(context, "context");
            a(context, b.f30329h, b.x, (String) null, (String) null, (String) null, (String) null, b.f30324c, (String) null, 376);
        }
    }
}
