package net.one97.paytm.h5.a;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.loader.a.a;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
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
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class l extends ad implements a.C0056a<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16874a = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String k = k;
    private static final String l = "page";
    private static final String m = m;
    private static final String n = "name";
    private static final String o = "number";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public H5BridgeContext f16875d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f16876e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Integer f16877f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f16878g;

    /* renamed from: h  reason: collision with root package name */
    private String f16879h;

    /* renamed from: i  reason: collision with root package name */
    private String f16880i;
    private final int j;

    public final void a(androidx.loader.b.c<Cursor> cVar) {
        k.c(cVar, "loader");
    }

    public l() {
        super(k);
    }

    public final /* synthetic */ void a(androidx.loader.b.c cVar, Object obj) {
        k.c(cVar, "loader");
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new c(this, (Cursor) obj));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f0, code lost:
        if (r0 == null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r4 = r13.getParam();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleEvent(com.alipay.mobile.h5container.api.H5Event r13, com.alipay.mobile.h5container.api.H5BridgeContext r14) {
        /*
            r12 = this;
            super.handleEvent(r13, r14)
            boolean r0 = r12.b(r13)
            r1 = 1
            r2 = 2
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0131
            r12.f16875d = r14
            r0 = 0
            if (r13 == 0) goto L_0x001f
            com.alibaba.a.e r4 = r13.getParam()
            if (r4 == 0) goto L_0x001f
            java.lang.String r5 = l
            java.lang.Integer r4 = r4.getInteger(r5)
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            r12.f16877f = r4
            if (r13 == 0) goto L_0x0031
            com.alibaba.a.e r4 = r13.getParam()
            if (r4 == 0) goto L_0x0031
            java.lang.String r5 = m
            java.lang.Integer r4 = r4.getInteger(r5)
            goto L_0x0032
        L_0x0031:
            r4 = r0
        L_0x0032:
            r12.f16878g = r4
            if (r13 == 0) goto L_0x0043
            com.alibaba.a.e r4 = r13.getParam()
            if (r4 == 0) goto L_0x0043
            java.lang.String r5 = n
            java.lang.String r4 = r4.getString(r5)
            goto L_0x0044
        L_0x0043:
            r4 = r0
        L_0x0044:
            r12.f16879h = r4
            if (r13 == 0) goto L_0x0055
            com.alibaba.a.e r4 = r13.getParam()
            if (r4 == 0) goto L_0x0055
            java.lang.String r5 = o
            java.lang.String r4 = r4.getString(r5)
            goto L_0x0056
        L_0x0055:
            r4 = r0
        L_0x0056:
            r12.f16880i = r4
            if (r13 == 0) goto L_0x0124
            android.app.Activity r4 = r13.getActivity()
            if (r4 == 0) goto L_0x0124
            java.lang.String r5 = r13.getAction()
            java.lang.String r6 = k
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00f3
            boolean r3 = r4 instanceof net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity
            if (r3 == 0) goto L_0x00c0
            r12.f16876e = r4
            kotlin.g.b.x$a r6 = new kotlin.g.b.x$a
            r6.<init>()
            r6.element = r1
            boolean r0 = com.paytm.utility.s.a()
            java.lang.String r3 = "android.permission.READ_CONTACTS"
            if (r0 == 0) goto L_0x008d
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            int r0 = androidx.core.content.b.a((android.content.Context) r0, (java.lang.String) r3)
            if (r0 == 0) goto L_0x008d
            r0 = 0
            r6.element = r0
        L_0x008d:
            boolean r0 = r6.element
            if (r0 == 0) goto L_0x0099
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r4 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r4
            r12.a((net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r4)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x00f0
        L_0x0099:
            java.lang.String r0 = "Requesting permission"
            com.paytm.utility.q.b(r0)
            r0 = r4
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r0 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r0
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$m r0 = r0.f17103a
            java.util.Observable r0 = (java.util.Observable) r0
            net.one97.paytm.h5.a.l$b r11 = new net.one97.paytm.h5.a.l$b
            r5 = r11
            r7 = r4
            r8 = r12
            r9 = r13
            r10 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            java.util.Observer r11 = (java.util.Observer) r11
            r0.addObserver(r11)
            java.lang.String[] r13 = new java.lang.String[]{r3}
            r0 = 101(0x65, float:1.42E-43)
            androidx.core.app.a.a(r4, r13, r0)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x00f0
        L_0x00c0:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r3 = "Activity is not "
            r13.<init>(r3)
            java.lang.Class<net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity> r4 = net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.class
            java.lang.String r4 = r4.getName()
            r13.append(r4)
            java.lang.String r13 = r13.toString()
            com.paytm.utility.q.b(r13)
            if (r14 == 0) goto L_0x00f0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r3)
            java.lang.Class<net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity> r0 = net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.class
            java.lang.String r0 = r0.getName()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r14.sendError((int) r2, (java.lang.String) r13)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x00f0:
            if (r0 != 0) goto L_0x0165
            goto L_0x0124
        L_0x00f3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Event not handled "
            r0.<init>(r4)
            java.lang.String r5 = r13.getAction()
            if (r5 != 0) goto L_0x0101
            r5 = r3
        L_0x0101:
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.paytm.utility.q.b(r0)
            if (r14 == 0) goto L_0x0123
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.String r13 = r13.getAction()
            if (r13 != 0) goto L_0x0119
            r13 = r3
        L_0x0119:
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.sendError((int) r2, (java.lang.String) r13)
        L_0x0123:
            return r1
        L_0x0124:
            java.lang.String r13 = "Activity is NULL"
            com.paytm.utility.q.b(r13)
            if (r14 == 0) goto L_0x0165
            r14.sendError((int) r2, (java.lang.String) r13)
            kotlin.x r13 = kotlin.x.f47997a
            goto L_0x0165
        L_0x0131:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid Event "
            r0.<init>(r4)
            if (r13 == 0) goto L_0x0140
            java.lang.String r5 = r13.getAction()
            if (r5 != 0) goto L_0x0141
        L_0x0140:
            r5 = r3
        L_0x0141:
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.paytm.utility.q.b(r0)
            if (r14 == 0) goto L_0x0165
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            if (r13 == 0) goto L_0x015a
            java.lang.String r13 = r13.getAction()
            if (r13 != 0) goto L_0x015b
        L_0x015a:
            r13 = r3
        L_0x015b:
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.sendError((int) r2, (java.lang.String) r13)
        L_0x0165:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.a.l.handleEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.a f16881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16882b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f16883c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f16884d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f16885e;

        b(x.a aVar, Activity activity, l lVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f16881a = aVar;
            this.f16882b = activity;
            this.f16883c = lVar;
            this.f16884d = h5Event;
            this.f16885e = h5BridgeContext;
        }

        public final void update(Observable observable, Object obj) {
            this.f16881a.element = false;
            if (obj instanceof o) {
                o oVar = (o) obj;
                Object first = oVar.getFirst();
                if (first != null) {
                    String[] strArr = (String[]) first;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        if (f.a((T[]) strArr, "android.permission.READ_CONTACTS") && s.a(iArr)) {
                            this.f16881a.element = true;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<out kotlin.String>");
                }
            }
            if (this.f16881a.element) {
                this.f16883c.a((PaytmH5Activity) this.f16882b);
                return;
            }
            a aVar = l.f16874a;
            String unused = l.k;
            q.b("Permission not granted");
            H5BridgeContext h5BridgeContext = this.f16885e;
            if (h5BridgeContext != null) {
                h5BridgeContext.sendError(2, "Permission not granted");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(PaytmH5Activity paytmH5Activity) {
        androidx.lifecycle.q qVar = paytmH5Activity;
        if (androidx.loader.a.a.a(qVar).b(this.j) == null) {
            androidx.loader.a.a.a(qVar).a(this.j, (Bundle) null, this);
        } else {
            androidx.loader.a.a.a(qVar).a(this.j, this);
        }
    }

    public final androidx.loader.b.c<Cursor> a(Bundle bundle) {
        Integer num;
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] strArr = {"_id", "display_name", "data1", "photo_uri"};
        StringBuilder sb = new StringBuilder("data1 IS NOT NULL AND data1 != \"\"");
        k.a((Object) sb, "StringBuilder()\n        …s.Phone.NUMBER} != \\\"\\\"\")");
        if (!TextUtils.isEmpty(this.f16879h)) {
            StringBuilder sb2 = new StringBuilder(" AND display_name LIKE '%");
            String str = this.f16879h;
            if (str == null) {
                k.a();
            }
            sb2.append(str);
            sb2.append("%' COLLATE NOCASE");
            sb.append(sb2.toString());
        }
        if (!TextUtils.isEmpty(this.f16880i)) {
            StringBuilder sb3 = new StringBuilder(" AND data1 LIKE '%");
            String str2 = this.f16880i;
            if (str2 == null) {
                k.a();
            }
            sb3.append(str2);
            sb3.append("%' COLLATE NOCASE");
            sb.append(sb3.toString());
        }
        String str3 = "display_name ASC";
        Integer num2 = this.f16877f;
        if (num2 != null) {
            if (num2 == null) {
                k.a();
            }
            if (num2.intValue() >= 0 && (num = this.f16878g) != null) {
                if (num == null) {
                    k.a();
                }
                if (num.intValue() >= 0) {
                    StringBuilder sb4 = new StringBuilder(" LIMIT ");
                    Integer num3 = this.f16877f;
                    if (num3 == null) {
                        k.a();
                    }
                    int intValue = num3.intValue();
                    Integer num4 = this.f16878g;
                    if (num4 == null) {
                        k.a();
                    }
                    sb4.append(intValue * num4.intValue());
                    sb4.append(',');
                    Integer num5 = this.f16878g;
                    if (num5 == null) {
                        k.a();
                    }
                    sb4.append(num5.intValue());
                    str3 = k.a(str3, (Object) sb4.toString());
                }
            }
        }
        String str4 = str3;
        Activity activity = this.f16876e;
        if (activity == null) {
            k.a();
        }
        return new androidx.loader.b.b(activity, uri, strArr, sb.toString(), (String[]) null, str4);
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f16886a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Cursor f16887b;

        c(l lVar, Cursor cursor) {
            this.f16886a = lVar;
            this.f16887b = cursor;
        }

        public final void run() {
            Cursor cursor = this.f16887b;
            if (cursor == null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f16888a;

                    {
                        this.f16888a = r1;
                    }

                    public final void run() {
                        a aVar = l.f16874a;
                        String unused = l.k;
                        q.b("Connect with system not successful, try again");
                        H5BridgeContext a2 = this.f16888a.f16886a.f16875d;
                        if (a2 != null) {
                            a2.sendError(2, "Connect with system not successful, try again");
                        }
                    }
                });
                return;
            }
            try {
                final Collection a2 = l.a(cursor);
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f16889a;

                    {
                        this.f16889a = r1;
                    }

                    public final void run() {
                        String str;
                        try {
                            HashMap hashMap = new HashMap(3);
                            Map map = hashMap;
                            Integer b2 = this.f16889a.f16886a.f16877f;
                            if (b2 == null || (str = String.valueOf(b2.intValue())) == null) {
                                str = "0";
                            }
                            map.put("page", str);
                            hashMap.put("totalContacts", Integer.valueOf(a2.size()));
                            hashMap.put(Tables.CONTACTS, a2);
                            this.f16889a.f16886a.a((Object) hashMap);
                        } catch (Exception e2) {
                            a aVar = l.f16874a;
                            String unused = l.k;
                            q.b("Exception in parsing " + e2.getMessage());
                            H5BridgeContext a2 = this.f16889a.f16886a.f16875d;
                            if (a2 != null) {
                                a2.sendError(2, "Exception in parsing " + e2.getMessage());
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f16891a;

                    {
                        this.f16891a = r1;
                    }

                    public final void run() {
                        a aVar = l.f16874a;
                        String unused = l.k;
                        q.b("Exception in parsing " + e2.getMessage());
                        H5BridgeContext a2 = this.f16891a.f16886a.f16875d;
                        if (a2 != null) {
                            a2.sendError(2, "Exception in parsing " + e2.getMessage());
                        }
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
