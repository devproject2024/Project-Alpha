package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.database.Tables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.d;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    b f19812a;

    /* renamed from: b  reason: collision with root package name */
    H5Event f19813b;

    /* renamed from: c  reason: collision with root package name */
    private int f19814c;

    /* renamed from: d  reason: collision with root package name */
    private String f19815d = "id";

    /* renamed from: e  reason: collision with root package name */
    private String f19816e = "name";

    /* renamed from: f  reason: collision with root package name */
    private String f19817f = H5Param.PAGE;

    /* renamed from: g  reason: collision with root package name */
    private String f19818g = "phoneNumbers";

    /* renamed from: h  reason: collision with root package name */
    private String f19819h = Tables.CONTACTS;

    /* renamed from: i  reason: collision with root package name */
    private String f19820i = "totalContacts";

    public k() {
        super("paytmFetchContacts");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String bridgeName;
        kotlin.g.b.k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        kotlin.g.b.k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.f19812a = bVar;
        this.f19813b = h5Event;
        Activity activity = h5Event.getActivity();
        if (activity == null || (bridgeName = h5Event.getBridgeName()) == null || bridgeName.hashCode() != 1606650252 || !bridgeName.equals("paytmFetchContacts")) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_CONTACTS");
        d.a aVar = d.f19890a;
        if (d.a.a(arrayList, activity)) {
            a(activity);
            return true;
        } else if (activity != null) {
            PhoenixActivity phoenixActivity = (PhoenixActivity) activity;
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                phoenixActivity.g().addObserver(new a(this, phoenixActivity));
                phoenixActivity.a((String[]) array);
                return true;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
        }
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f19821a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f19822b;

        a(k kVar, PhoenixActivity phoenixActivity) {
            this.f19821a = kVar;
            this.f19822b = phoenixActivity;
        }

        public final void update(Observable observable, Object obj) {
            k kVar = this.f19821a;
            if (obj instanceof o) {
                o oVar = (o) obj;
                Object first = oVar.getFirst();
                if (first != null) {
                    Object[] objArr = (Object[]) first;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        int length = objArr.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            int i4 = i3 + 1;
                            if (iArr[i3] == 0) {
                                kVar.a(this.f19822b);
                            } else {
                                d.a aVar = d.f19890a;
                                d.a.a(kVar.f19813b, Integer.valueOf(net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal()), "Unable to process your request", kVar.f19812a);
                            }
                            i2++;
                            i3 = i4;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<*>");
                }
            } else {
                d.a aVar2 = d.f19890a;
                d.a.a(kVar.f19813b, Integer.valueOf(net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal()), "Unable to process your request", kVar.f19812a);
            }
            this.f19822b.g().deleteObservers();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Activity activity) {
        int i2;
        JSONObject params;
        Object obj;
        Object obj2;
        Object obj3;
        H5Event h5Event = this.f19813b;
        int i3 = 25;
        Object obj4 = null;
        if (h5Event == null || (params = h5Event.getParams()) == null) {
            i2 = 1;
        } else {
            if (!params.has(H5Param.PAGE) || (obj3 = params.get(H5Param.PAGE)) == null) {
                i2 = 1;
            } else if (obj3 != null) {
                i2 = ((Integer) obj3).intValue();
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Int");
            }
            if (params.has("pageSize") && (obj2 = params.get("pageSize")) != null && (obj2 instanceof Integer)) {
                i3 = ((Number) obj2).intValue();
            }
            if (params.has("searchTerm") && (obj = params.get("searchTerm")) != null) {
                obj4 = obj;
            }
        }
        d.a aVar = d.f19890a;
        if (!d.a.a(this.f19813b, this.f19812a, activity, "whitelisted_aids_contacts", true)) {
            a(activity, i2, i3, obj4);
        }
    }

    private final void a(Activity activity, int i2, int i3, Object obj) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        List<net.one97.paytm.phoenix.model.a> b2 = b(activity, i2, i3, obj);
        jSONObject.put(this.f19817f, i2);
        jSONObject.put(this.f19820i, this.f19814c);
        if (b2 != null) {
            jSONArray = new JSONArray();
            for (net.one97.paytm.phoenix.model.a next : b2) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(this.f19815d, next.a());
                jSONObject2.put(this.f19816e, next.b());
                jSONObject2.put(this.f19818g, next.c());
                jSONArray.put(jSONObject2);
            }
        } else {
            jSONArray = null;
        }
        jSONObject.put(this.f19819h, jSONArray);
        H5Event h5Event = this.f19813b;
        if (h5Event != null) {
            net.one97.paytm.phoenix.core.a.a(this, h5Event, jSONObject, false, 4);
        }
    }

    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r14v1, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<net.one97.paytm.phoenix.model.a> b(android.app.Activity r21, int r22, int r23, java.lang.Object r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r24
            java.lang.String r2 = "activity"
            r3 = r21
            kotlin.g.b.k.c(r3, r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r5 = 5
            if (r2 >= r5) goto L_0x0027
            net.one97.paytm.phoenix.util.d$a r1 = net.one97.paytm.phoenix.util.d.f19890a
            net.one97.paytm.phoenix.api.H5Event r1 = r0.f19813b
            net.one97.paytm.phoenix.api.a r2 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            int r2 = r2.ordinal()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            net.one97.paytm.phoenix.api.b r3 = r0.f19812a
            java.lang.String r5 = "Unable to process your request"
            net.one97.paytm.phoenix.util.d.a.a(r1, r2, r5, r3)
            return r4
        L_0x0027:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            android.content.ContentResolver r3 = r21.getContentResolver()
            java.lang.String r5 = "activity.getContentResolver()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r11 = "display_name ASC"
            android.net.Uri r6 = android.provider.ContactsContract.Contacts.CONTENT_URI
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r3
            r10 = r11
            android.database.Cursor r12 = r5.query(r6, r7, r8, r9, r10)
            int r5 = r22 + -1
            int r13 = r5 * r23
            int r5 = r22 * r23
            r14 = 1
            int r15 = r5 + -1
            if (r12 == 0) goto L_0x015a
            int r5 = r12.getCount()
            if (r5 <= 0) goto L_0x015a
        L_0x0055:
            boolean r5 = r12.moveToNext()
            if (r5 == 0) goto L_0x0157
            java.lang.String r5 = "_id"
            int r5 = r12.getColumnIndex(r5)
            java.lang.String r10 = r12.getString(r5)
            java.lang.String r5 = "has_phone_number"
            int r5 = r12.getColumnIndex(r5)
            int r5 = r12.getInt(r5)
            if (r5 <= 0) goto L_0x014b
            android.net.Uri r6 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            r7 = 0
            java.lang.String[] r9 = new java.lang.String[r14]
            r16 = 0
            r9[r16] = r10
            java.lang.String r8 = "contact_id = ?"
            r5 = r3
            r4 = r10
            r10 = r11
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)
            java.lang.String r6 = "display_name"
            int r6 = r12.getColumnIndex(r6)
            java.lang.String r6 = r12.getString(r6)
            java.lang.String r7 = "mobile"
            java.lang.String r8 = "data1"
            if (r1 == 0) goto L_0x0103
            boolean r9 = r1 instanceof java.lang.String
            if (r9 == 0) goto L_0x00aa
            java.lang.String r9 = "name"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            r9 = r6
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = r24.toString()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r14)
            goto L_0x00ab
        L_0x00aa:
            r9 = 0
        L_0x00ab:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x00b0:
            if (r5 == 0) goto L_0x00ec
            boolean r17 = r5.moveToNext()
            if (r17 == 0) goto L_0x00ec
            int r14 = r5.getColumnIndex(r8)
            java.lang.String r14 = r5.getString(r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            r17 = r3
            r3 = r14
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r18 = r24.toString()
            r19 = r11
            r11 = r18
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r3 = kotlin.m.p.c((java.lang.CharSequence) r3, (java.lang.CharSequence) r11)
            if (r3 == 0) goto L_0x00e3
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r10.add(r14)
            r16 = 1
            goto L_0x00f0
        L_0x00e3:
            a((java.lang.String) r14, (java.util.ArrayList<java.lang.String>) r10)
            r3 = r17
            r11 = r19
            r14 = 1
            goto L_0x00b0
        L_0x00ec:
            r17 = r3
            r19 = r11
        L_0x00f0:
            if (r9 != 0) goto L_0x00f4
            if (r16 == 0) goto L_0x013f
        L_0x00f4:
            net.one97.paytm.phoenix.model.a r3 = new net.one97.paytm.phoenix.model.a
            r3.<init>()
            r3.a((java.lang.String) r4)
            r3.b(r6)
            r3.a((java.util.ArrayList<java.lang.String>) r10)
            goto L_0x0140
        L_0x0103:
            r17 = r3
            r19 = r11
            int r3 = r12.getPosition()
            if (r3 < r13) goto L_0x013f
            int r3 = r12.getPosition()
            if (r3 > r15) goto L_0x013f
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x0118:
            if (r5 == 0) goto L_0x012f
            boolean r9 = r5.moveToNext()
            if (r9 == 0) goto L_0x012f
            int r9 = r5.getColumnIndex(r8)
            java.lang.String r9 = r5.getString(r9)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            a((java.lang.String) r9, (java.util.ArrayList<java.lang.String>) r3)
            goto L_0x0118
        L_0x012f:
            net.one97.paytm.phoenix.model.a r7 = new net.one97.paytm.phoenix.model.a
            r7.<init>()
            r7.a((java.lang.String) r4)
            r7.b(r6)
            r7.a((java.util.ArrayList<java.lang.String>) r3)
            r3 = r7
            goto L_0x0140
        L_0x013f:
            r3 = 0
        L_0x0140:
            if (r3 == 0) goto L_0x0145
            r2.add(r3)
        L_0x0145:
            if (r5 == 0) goto L_0x014f
            r5.close()
            goto L_0x014f
        L_0x014b:
            r17 = r3
            r19 = r11
        L_0x014f:
            r3 = r17
            r11 = r19
            r4 = 0
            r14 = 1
            goto L_0x0055
        L_0x0157:
            r12.close()
        L_0x015a:
            int r3 = r2.size()
            r0.f19814c = r3
            if (r1 == 0) goto L_0x016f
            int r1 = r0.f19814c
            if (r1 <= r13) goto L_0x016f
            r3 = 1
            int r3 = r3 + r15
            if (r3 >= r1) goto L_0x016b
            r1 = r3
        L_0x016b:
            java.util.List r2 = r2.subList(r13, r1)
        L_0x016f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.k.b(android.app.Activity, int, int, java.lang.Object):java.util.List");
    }

    private static void a(String str, ArrayList<String> arrayList) {
        if (!arrayList.isEmpty()) {
            boolean z = false;
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (PhoneNumberUtils.compare(str, it2.next())) {
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(str);
                return;
            }
            return;
        }
        arrayList.add(str);
    }
}
