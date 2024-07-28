package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import net.one97.paytm.locale.a;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.phoenix.api.H5Event;

public final class c extends net.one97.paytm.phoenix.core.a {

    static final class b implements net.one97.paytm.locale.b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f19755a = new b();

        b() {
        }

        public final void refreshHomeLocaleChange(boolean z, boolean z2) {
        }
    }

    public c() {
        super("paytmUpdateAppData", "paytmGetUserData");
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r8, net.one97.paytm.phoenix.api.b r9) {
        /*
            r7 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r9, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.b) r9)
            b(r8, r9)
            android.app.Activity r9 = r8.getActivity()
            r0 = 1
            if (r9 == 0) goto L_0x010e
            java.lang.String r1 = r8.getBridgeName()
            if (r1 != 0) goto L_0x001f
            goto L_0x010e
        L_0x001f:
            int r2 = r1.hashCode()
            r3 = -1490725974(0xffffffffa72553aa, float:-2.2943704E-15)
            r4 = 4
            r5 = 0
            r6 = 0
            if (r2 == r3) goto L_0x0099
            r3 = -1206413119(0xffffffffb81798c1, float:-3.614347E-5)
            if (r2 == r3) goto L_0x0032
            goto L_0x010e
        L_0x0032:
            java.lang.String r2 = "paytmUpdateAppData"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x010e
            org.json.JSONObject r1 = r8.getParams()
            if (r1 == 0) goto L_0x0046
            java.lang.String r2 = "languageId"
            java.lang.String r5 = r1.getString(r2)
        L_0x0046:
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0054
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r1 = 0
            goto L_0x0055
        L_0x0054:
            r1 = 1
        L_0x0055:
            if (r1 == 0) goto L_0x005f
            net.one97.paytm.phoenix.api.a r9 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r0 = "Language id not passed!"
            r7.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.a) r9, (java.lang.String) r0)
            return r6
        L_0x005f:
            net.one97.paytm.phoenix.d.c$a r1 = new net.one97.paytm.phoenix.d.c$a     // Catch:{ Exception -> 0x0087 }
            r1.<init>(r9, r7, r8)     // Catch:{ Exception -> 0x0087 }
            net.one97.paytm.locale.a r2 = new net.one97.paytm.locale.a     // Catch:{ Exception -> 0x0087 }
            net.one97.paytm.locale.a$a r1 = (net.one97.paytm.locale.a.C0945a) r1     // Catch:{ Exception -> 0x0087 }
            net.one97.paytm.phoenix.d.c$b r3 = net.one97.paytm.phoenix.d.c.b.f19755a     // Catch:{ Exception -> 0x0087 }
            net.one97.paytm.locale.b r3 = (net.one97.paytm.locale.b) r3     // Catch:{ Exception -> 0x0087 }
            r2.<init>(r1, r9, r3)     // Catch:{ Exception -> 0x0087 }
            if (r9 == 0) goto L_0x007f
            net.one97.paytm.phoenix.ui.PhoenixActivity r9 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r9     // Catch:{ Exception -> 0x0087 }
            androidx.fragment.app.j r9 = r9.getSupportFragmentManager()     // Catch:{ Exception -> 0x0087 }
            r2.a((androidx.fragment.app.j) r9)     // Catch:{ Exception -> 0x0087 }
            r2.b((java.lang.String) r5)     // Catch:{ Exception -> 0x0087 }
            goto L_0x010e
        L_0x007f:
            kotlin.u r9 = new kotlin.u     // Catch:{ Exception -> 0x0087 }
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r9.<init>(r1)     // Catch:{ Exception -> 0x0087 }
            throw r9     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            r9 = move-exception
            java.lang.String r1 = "error"
            net.one97.paytm.phoenix.core.a.a(r7, r8, r1, r6, r4)
            r9.printStackTrace()
            net.one97.paytm.phoenix.api.a r9 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r1 = "Language id is not valid"
            r7.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.a) r9, (java.lang.String) r1)
            goto L_0x010e
        L_0x0099:
            java.lang.String r2 = "paytmGetUserData"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x010e
            org.json.JSONObject r1 = r8.getParams()
            if (r1 == 0) goto L_0x00ae
            java.lang.String r2 = "key"
            java.lang.String r1 = r1.getString(r2)
            goto L_0x00af
        L_0x00ae:
            r1 = r5
        L_0x00af:
            if (r1 != 0) goto L_0x00b2
            goto L_0x00f4
        L_0x00b2:
            int r2 = r1.hashCode()
            r3 = 177705091(0xa979083, float:1.459513E-32)
            if (r2 == r3) goto L_0x00d0
            r3 = 1094007236(0x413539c4, float:11.326603)
            if (r2 == r3) goto L_0x00c1
            goto L_0x00f4
        L_0x00c1:
            java.lang.String r2 = "xAppRid"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00f4
            android.content.Context r9 = (android.content.Context) r9
            java.lang.String r5 = com.paytm.network.b.d.a(r9)
            goto L_0x010b
        L_0x00d0:
            java.lang.String r2 = "profileType"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00f4
            android.content.Context r9 = (android.content.Context) r9
            java.lang.String r9 = com.paytm.utility.b.ak(r9)
            com.paytm.utility.e$b r1 = com.paytm.utility.e.b.RESELLER
            java.lang.String r1 = r1.name()
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r1, (boolean) r0)
            if (r9 == 0) goto L_0x00ef
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            goto L_0x010b
        L_0x00ef:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            goto L_0x010b
        L_0x00f4:
            net.one97.paytm.utils.ag$a r2 = net.one97.paytm.utils.ag.f69605a
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r2 = "activity.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
            com.paytm.b.a.a r9 = net.one97.paytm.utils.ag.a.a(r9)
            if (r1 == 0) goto L_0x010b
            java.lang.String r2 = ""
            java.lang.String r5 = r9.b((java.lang.String) r1, (java.lang.String) r2, (boolean) r0)
        L_0x010b:
            net.one97.paytm.phoenix.core.a.a(r7, r8, r5, r6, r4)
        L_0x010e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.c.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a implements a.C0945a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f19752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f19753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f19754c;

        a(Activity activity, c cVar, H5Event h5Event) {
            this.f19752a = activity;
            this.f19753b = cVar;
            this.f19754c = h5Event;
        }

        public final void a(boolean z) {
            if (z) {
                Intent intent = new Intent("net.paytm.one97.action.REFRESH_LOGIN");
                intent.putExtra("setLanguage", true);
                androidx.localbroadcastmanager.a.a.a((Context) this.f19752a).a(intent);
                net.one97.paytm.phoenix.core.a.a(this.f19753b, this.f19754c, "success", false, 4);
                return;
            }
            net.one97.paytm.phoenix.core.a.a(this.f19753b, this.f19754c, DirectFormItemType.CANCEL, false, 4);
        }
    }
}
