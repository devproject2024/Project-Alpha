package net.one97.paytm.phoenix.d;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.f;
import org.json.JSONObject;

public final class au extends net.one97.paytm.phoenix.core.a {
    public au() {
        super("paytmRequestPermission");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r11, net.one97.paytm.phoenix.api.b r12) {
        /*
            r10 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r12, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.b) r12)
            boolean r12 = r10.a((net.one97.paytm.phoenix.api.H5Event) r11)
            r0 = 1
            if (r12 == 0) goto L_0x011c
            android.app.Activity r12 = r11.getActivity()
            r1 = 0
            if (r12 == 0) goto L_0x0039
            android.app.Activity r12 = r11.getActivity()
            if (r12 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            boolean r12 = r12 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r12 == 0) goto L_0x0039
            android.app.Activity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x0031
            net.one97.paytm.phoenix.ui.PhoenixActivity r12 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r12
            goto L_0x003a
        L_0x0031:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            r12 = r1
        L_0x003a:
            r2 = 0
            if (r12 != 0) goto L_0x003e
            return r2
        L_0x003e:
            org.json.JSONObject r3 = r11.getParams()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r3 == 0) goto L_0x004f
            java.lang.String r1 = "permission"
            java.lang.String r1 = r3.optString(r1)
        L_0x004f:
            java.lang.String r3 = "invalid permission name"
            java.lang.String r5 = "PhoenixPermissionRequestPlugin"
            java.lang.String r6 = "invalid params"
            if (r1 == 0) goto L_0x00dc
            r7 = r1
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r8 = ","
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r9, false)
            if (r9 == 0) goto L_0x00c4
            java.lang.String[] r1 = new java.lang.String[]{r8}
            java.util.List r1 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.String[]) r1)
            boolean r7 = r1.isEmpty()
            if (r7 == 0) goto L_0x007a
            net.one97.paytm.phoenix.api.a r12 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r10.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.a) r12, (java.lang.String) r6)
            goto L_0x011c
        L_0x007a:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0080:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00f6
            java.lang.Object r7 = r1.next()
            java.lang.String r7 = (java.lang.String) r7
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r9 = r8.length()
            if (r9 <= 0) goto L_0x0097
            r9 = 1
            goto L_0x0098
        L_0x0097:
            r9 = 0
        L_0x0098:
            if (r9 == 0) goto L_0x0080
            if (r7 == 0) goto L_0x00bc
            java.lang.CharSequence r7 = kotlin.m.p.b(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String[] r7 = net.one97.paytm.phoenix.util.f.b(r7)
            if (r7 != 0) goto L_0x00b5
            net.one97.paytm.phoenix.util.j r12 = net.one97.paytm.phoenix.util.j.f59646a
            net.one97.paytm.phoenix.util.j.b(r5, r3)
            net.one97.paytm.phoenix.api.a r12 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r10.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.a) r12, (java.lang.String) r6)
            goto L_0x011c
        L_0x00b5:
            r8 = r4
            java.util.Collection r8 = (java.util.Collection) r8
            kotlin.a.k.a(r8, (T[]) r7)
            goto L_0x0080
        L_0x00bc:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.CharSequence"
            r11.<init>(r12)
            throw r11
        L_0x00c4:
            java.lang.String[] r1 = net.one97.paytm.phoenix.util.f.b(r1)
            if (r1 != 0) goto L_0x00d5
            net.one97.paytm.phoenix.util.j r12 = net.one97.paytm.phoenix.util.j.f59646a
            net.one97.paytm.phoenix.util.j.b(r5, r3)
            net.one97.paytm.phoenix.api.a r12 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r10.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.a) r12, (java.lang.String) r6)
            goto L_0x011c
        L_0x00d5:
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            kotlin.a.k.a(r3, (T[]) r1)
            goto L_0x00f6
        L_0x00dc:
            r7 = r10
            net.one97.paytm.phoenix.d.au r7 = (net.one97.paytm.phoenix.d.au) r7
            java.lang.String[] r1 = net.one97.paytm.phoenix.util.f.b(r1)
            if (r1 != 0) goto L_0x00f0
            net.one97.paytm.phoenix.util.j r12 = net.one97.paytm.phoenix.util.j.f59646a
            net.one97.paytm.phoenix.util.j.b(r5, r3)
            net.one97.paytm.phoenix.api.a r12 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r7.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.a) r12, (java.lang.String) r6)
            goto L_0x011c
        L_0x00f0:
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            kotlin.a.k.a(r3, (T[]) r1)
        L_0x00f6:
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.String[] r1 = new java.lang.String[r2]
            java.lang.Object[] r1 = r4.toArray(r1)
            if (r1 == 0) goto L_0x0114
            java.lang.String[] r1 = (java.lang.String[]) r1
            net.one97.paytm.phoenix.ui.PhoenixActivity$n r2 = r12.k
            java.util.Observable r2 = (java.util.Observable) r2
            net.one97.paytm.phoenix.d.au$a r3 = new net.one97.paytm.phoenix.d.au$a
            r3.<init>(r10, r11, r12)
            java.util.Observer r3 = (java.util.Observer) r3
            r2.addObserver(r3)
            r12.a((java.lang.String[]) r1)
            goto L_0x011c
        L_0x0114:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T>"
            r11.<init>(r12)
            throw r11
        L_0x011c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.au.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ au f59532a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59533b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59534c;

        a(au auVar, H5Event h5Event, PhoenixActivity phoenixActivity) {
            this.f59532a = auVar;
            this.f59533b = h5Event;
            this.f59534c = phoenixActivity;
        }

        public final void update(Observable observable, Object obj) {
            au auVar = this.f59532a;
            if (obj instanceof o) {
                o oVar = (o) obj;
                Object first = oVar.getFirst();
                if (first != null) {
                    Object[] objArr = (Object[]) first;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        HashMap hashMap = new HashMap();
                        int length = objArr.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            Object obj2 = objArr[i2];
                            int i4 = i3 + 1;
                            if (obj2 != null) {
                                String a2 = f.a((String) obj2);
                                if (a2 != null) {
                                    hashMap.put(a2, Integer.valueOf(iArr[i3] == 0 ? 1 : 0));
                                }
                                i2++;
                                i3 = i4;
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                        net.one97.paytm.phoenix.core.a.a(auVar, this.f59533b, new JSONObject(hashMap), false, 4);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<*>");
                }
            } else {
                k.a(obj, "arg");
                auVar.a("success", obj);
                net.one97.paytm.phoenix.core.a.a(auVar, this.f59533b, (Object) null, false, 6);
            }
            this.f59534c.k.deleteObservers();
        }
    }
}
