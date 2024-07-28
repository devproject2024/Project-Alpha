package net.one97.paytm.h5.a;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.contactsSdk.database.Tables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.h5.a.e;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class h extends ad {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public H5BridgeContext f16850a;

    /* renamed from: d  reason: collision with root package name */
    private H5Event f16851d;

    /* renamed from: e  reason: collision with root package name */
    private int f16852e;

    /* renamed from: f  reason: collision with root package name */
    private String f16853f = "id";

    /* renamed from: g  reason: collision with root package name */
    private String f16854g = "name";

    /* renamed from: h  reason: collision with root package name */
    private String f16855h = H5Param.PAGE;

    /* renamed from: i  reason: collision with root package name */
    private String f16856i = "phoneNumbers";
    private String j = Tables.CONTACTS;
    private String k = "totalContacts";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h() {
        super(e.q);
        e.a aVar = e.f16836a;
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        this.f16850a = h5BridgeContext;
        this.f16851d = h5Event;
        if (h5Event == null || (activity = h5Event.getActivity()) == null) {
            return true;
        }
        String action = h5Event.getAction();
        e.a aVar = e.f16836a;
        if (!k.a((Object) action, (Object) e.q)) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_CONTACTS");
        e.a aVar2 = e.f16836a;
        if (e.a.a((ArrayList<String>) arrayList, activity)) {
            a(activity);
            return true;
        } else if (activity != null) {
            PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                paytmH5Activity.f17103a.addObserver(new a(this, paytmH5Activity));
                paytmH5Activity.a((String[]) array);
                return true;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
        }
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f16857a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmH5Activity f16858b;

        a(h hVar, PaytmH5Activity paytmH5Activity) {
            this.f16857a = hVar;
            this.f16858b = paytmH5Activity;
        }

        public final void update(Observable observable, Object obj) {
            h hVar = this.f16857a;
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
                                hVar.a((Activity) this.f16858b);
                            } else {
                                e.a aVar = e.f16836a;
                                e.a.a(Integer.valueOf(H5Event.Error.UNKNOWN_ERROR.ordinal()), "Unable to process your request", hVar.f16850a);
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
                e.a aVar2 = e.f16836a;
                e.a.a(Integer.valueOf(H5Event.Error.UNKNOWN_ERROR.ordinal()), "Unable to process your request", hVar.f16850a);
            }
            this.f16858b.f17103a.deleteObservers();
        }
    }

    /* access modifiers changed from: private */
    public final void a(Activity activity) {
        int i2;
        com.alibaba.a.e param;
        H5Event h5Event = this.f16851d;
        int i3 = 25;
        Object obj = null;
        if (h5Event == null || (param = h5Event.getParam()) == null) {
            i2 = 1;
        } else {
            Object obj2 = param.get(H5Param.PAGE);
            i2 = (obj2 == null || !(obj2 instanceof Integer)) ? 1 : ((Number) obj2).intValue();
            Object obj3 = param.get("pageSize");
            if (obj3 != null && (obj3 instanceof Integer)) {
                i3 = ((Number) obj3).intValue();
            }
            Object obj4 = param.get("searchTerm");
            if (obj4 != null) {
                obj = obj4;
            }
        }
        e.a aVar = e.f16836a;
        if (!e.a.a(this.f16850a, activity, "whitelisted_aids_contacts", true)) {
            a(activity, i2, i3, obj);
        }
    }

    private final void a(Activity activity, int i2, int i3, Object obj) {
        ArrayList arrayList;
        com.alibaba.a.e eVar = new com.alibaba.a.e();
        List<net.one97.paytm.h5.model.a> b2 = b(activity, i2, i3, obj);
        eVar.put(this.f16855h, (Object) Integer.valueOf(i2));
        eVar.put(this.k, (Object) Integer.valueOf(this.f16852e));
        if (b2 != null) {
            arrayList = new ArrayList();
            for (net.one97.paytm.h5.model.a next : b2) {
                com.alibaba.a.e eVar2 = new com.alibaba.a.e();
                eVar2.put(this.f16853f, (Object) next.a());
                eVar2.put(this.f16854g, (Object) next.b());
                eVar2.put(this.f16856i, (Object) next.c());
                arrayList.add(eVar2);
            }
        } else {
            arrayList = null;
        }
        eVar.put(this.j, (Object) arrayList);
        a((Object) eVar);
    }

    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r14v1, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0153 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<net.one97.paytm.h5.model.a> b(android.app.Activity r21, int r22, int r23, java.lang.Object r24) {
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
            if (r2 >= r5) goto L_0x0025
            net.one97.paytm.h5.a.e$a r1 = net.one97.paytm.h5.a.e.f16836a
            com.alipay.mobile.h5container.api.H5Event$Error r1 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
            int r1 = r1.ordinal()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.alipay.mobile.h5container.api.H5BridgeContext r2 = r0.f16850a
            java.lang.String r3 = "Unable to process your request"
            net.one97.paytm.h5.a.e.a.a(r1, r3, r2)
            return r4
        L_0x0025:
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
            if (r12 == 0) goto L_0x015e
            int r5 = r12.getCount()
            if (r5 <= 0) goto L_0x015e
        L_0x0053:
            boolean r5 = r12.moveToNext()
            if (r5 == 0) goto L_0x015b
            java.lang.String r5 = "_id"
            int r5 = r12.getColumnIndex(r5)
            java.lang.String r10 = r12.getString(r5)
            java.lang.String r5 = "has_phone_number"
            int r5 = r12.getColumnIndex(r5)
            int r5 = r12.getInt(r5)
            if (r5 <= 0) goto L_0x014f
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
            if (r1 == 0) goto L_0x0104
            boolean r9 = r1 instanceof java.lang.String
            if (r9 == 0) goto L_0x00a8
            java.lang.String r9 = "name"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            r9 = r6
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = r24.toString()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r14)
            goto L_0x00a9
        L_0x00a8:
            r9 = 0
        L_0x00a9:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x00ae:
            if (r5 != 0) goto L_0x00b3
            kotlin.g.b.k.a()
        L_0x00b3:
            boolean r17 = r5.moveToNext()
            if (r17 == 0) goto L_0x00ed
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
            if (r3 == 0) goto L_0x00e4
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r10.add(r14)
            r16 = 1
            goto L_0x00f1
        L_0x00e4:
            a((java.lang.String) r14, (java.util.ArrayList<java.lang.String>) r10)
            r3 = r17
            r11 = r19
            r14 = 1
            goto L_0x00ae
        L_0x00ed:
            r17 = r3
            r19 = r11
        L_0x00f1:
            if (r9 != 0) goto L_0x00f5
            if (r16 == 0) goto L_0x0143
        L_0x00f5:
            net.one97.paytm.h5.model.a r3 = new net.one97.paytm.h5.model.a
            r3.<init>()
            r3.a((java.lang.String) r4)
            r3.b(r6)
            r3.a((java.util.ArrayList<java.lang.String>) r10)
            goto L_0x0144
        L_0x0104:
            r17 = r3
            r19 = r11
            int r3 = r12.getPosition()
            if (r3 < r13) goto L_0x0143
            int r3 = r12.getPosition()
            if (r3 > r15) goto L_0x0143
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x0119:
            if (r5 != 0) goto L_0x011e
            kotlin.g.b.k.a()
        L_0x011e:
            boolean r9 = r5.moveToNext()
            if (r9 == 0) goto L_0x0133
            int r9 = r5.getColumnIndex(r8)
            java.lang.String r9 = r5.getString(r9)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            a((java.lang.String) r9, (java.util.ArrayList<java.lang.String>) r3)
            goto L_0x0119
        L_0x0133:
            net.one97.paytm.h5.model.a r7 = new net.one97.paytm.h5.model.a
            r7.<init>()
            r7.a((java.lang.String) r4)
            r7.b(r6)
            r7.a((java.util.ArrayList<java.lang.String>) r3)
            r3 = r7
            goto L_0x0144
        L_0x0143:
            r3 = 0
        L_0x0144:
            if (r3 == 0) goto L_0x0149
            r2.add(r3)
        L_0x0149:
            if (r5 == 0) goto L_0x0153
            r5.close()
            goto L_0x0153
        L_0x014f:
            r17 = r3
            r19 = r11
        L_0x0153:
            r3 = r17
            r11 = r19
            r4 = 0
            r14 = 1
            goto L_0x0053
        L_0x015b:
            r12.close()
        L_0x015e:
            int r3 = r2.size()
            r0.f16852e = r3
            if (r1 == 0) goto L_0x0173
            int r1 = r0.f16852e
            if (r1 <= r13) goto L_0x0173
            r3 = 1
            int r3 = r3 + r15
            if (r3 >= r1) goto L_0x016f
            r1 = r3
        L_0x016f:
            java.util.List r2 = r2.subList(r13, r1)
        L_0x0173:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.a.h.b(android.app.Activity, int, int, java.lang.Object):java.util.List");
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
