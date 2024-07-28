package net.one97.paytm.phoenix.d;

import android.content.DialogInterface;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import net.one97.paytm.phoenix.api.H5Event;

public final class r extends net.one97.paytm.phoenix.core.a {
    public r() {
        super(H5Plugin.CommonEvents.ALERT, H5Plugin.CommonEvents.CONFIRM);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r9, net.one97.paytm.phoenix.api.b r10) {
        /*
            r8 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r10, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.b) r10)
            boolean r10 = r8.a((net.one97.paytm.phoenix.api.H5Event) r9)
            if (r10 == 0) goto L_0x0168
            android.app.Activity r10 = r9.getActivity()
            r0 = 0
            if (r10 == 0) goto L_0x0038
            android.app.Activity r10 = r9.getActivity()
            if (r10 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            boolean r10 = r10 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r10 == 0) goto L_0x0038
            android.app.Activity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x0030
            net.one97.paytm.phoenix.ui.PhoenixActivity r10 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r10
            goto L_0x0039
        L_0x0030:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            r10 = r0
        L_0x0039:
            r1 = 0
            if (r10 != 0) goto L_0x003d
            return r1
        L_0x003d:
            java.lang.String r2 = r9.getAction$phoenix_debug()
            if (r2 != 0) goto L_0x0045
            goto L_0x0168
        L_0x0045:
            int r3 = r2.hashCode()
            r4 = 92899676(0x589895c, float:1.2933876E-35)
            java.lang.String r5 = "YES"
            java.lang.String r6 = "message"
            java.lang.String r7 = "title"
            if (r3 == r4) goto L_0x00f9
            r4 = 951117504(0x38b0e6c0, float:8.4353145E-5)
            if (r3 == r4) goto L_0x005c
            goto L_0x0168
        L_0x005c:
            java.lang.String r3 = "confirm"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0168
            org.json.JSONObject r2 = r9.getParams()
            if (r2 == 0) goto L_0x006f
            java.lang.String r3 = r2.optString(r7)
            goto L_0x0070
        L_0x006f:
            r3 = r0
        L_0x0070:
            if (r2 == 0) goto L_0x0077
            java.lang.String r4 = r2.optString(r6)
            goto L_0x0078
        L_0x0077:
            r4 = r0
        L_0x0078:
            if (r2 == 0) goto L_0x0081
            java.lang.String r6 = "okButton"
            java.lang.String r6 = r2.optString(r6)
            goto L_0x0082
        L_0x0081:
            r6 = r0
        L_0x0082:
            if (r2 == 0) goto L_0x008a
            java.lang.String r0 = "cancelButton"
            java.lang.String r0 = r2.optString(r0)
        L_0x008a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 == 0) goto L_0x00b4
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00b4
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00b4
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00b4
            net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, "")
            goto L_0x0168
        L_0x00b4:
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r5 = r6
        L_0x00bf:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00ca
            java.lang.String r0 = "Cancel"
        L_0x00ca:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r10 = (android.content.Context) r10
            r2.<init>(r10)
            r2.setTitle(r3)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setMessage(r4)
            r2.setCancelable(r1)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            net.one97.paytm.phoenix.d.r$b r10 = new net.one97.paytm.phoenix.d.r$b
            r10.<init>(r8, r9)
            android.content.DialogInterface$OnClickListener r10 = (android.content.DialogInterface.OnClickListener) r10
            r2.setPositiveButton(r5, r10)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            net.one97.paytm.phoenix.d.r$c r10 = new net.one97.paytm.phoenix.d.r$c
            r10.<init>(r8, r9)
            android.content.DialogInterface$OnClickListener r10 = (android.content.DialogInterface.OnClickListener) r10
            r2.setNegativeButton(r0, r10)
            r2.show()
            goto L_0x0168
        L_0x00f9:
            java.lang.String r3 = "alert"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0168
            org.json.JSONObject r2 = r9.getParams()
            if (r2 == 0) goto L_0x010c
            java.lang.String r3 = r2.optString(r7)
            goto L_0x010d
        L_0x010c:
            r3 = r0
        L_0x010d:
            if (r2 == 0) goto L_0x0114
            java.lang.String r4 = r2.optString(r6)
            goto L_0x0115
        L_0x0114:
            r4 = r0
        L_0x0115:
            if (r2 == 0) goto L_0x011d
            java.lang.String r0 = "button"
            java.lang.String r0 = r2.optString(r0)
        L_0x011d:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 == 0) goto L_0x013d
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x013d
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x013d
            net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, "")
            goto L_0x0168
        L_0x013d:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0147
            r0 = r5
        L_0x0147:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r10 = (android.content.Context) r10
            r2.<init>(r10)
            r2.setTitle(r3)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setMessage(r4)
            r2.setCancelable(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            net.one97.paytm.phoenix.d.r$a r10 = new net.one97.paytm.phoenix.d.r$a
            r10.<init>(r8, r9)
            android.content.DialogInterface$OnClickListener r10 = (android.content.DialogInterface.OnClickListener) r10
            r2.setPositiveButton(r0, r10)
            r2.show()
        L_0x0168:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.r.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f59546a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59547b;

        a(r rVar, H5Event h5Event) {
            this.f59546a = rVar;
            this.f59547b = h5Event;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f59546a.a(H5StartParamManager.index, (Object) 0);
            this.f59546a.a("success", (Object) Boolean.TRUE);
            net.one97.paytm.phoenix.core.a.a(this.f59546a, this.f59547b, (Object) null, true, 2);
            dialogInterface.dismiss();
        }
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f59548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59549b;

        b(r rVar, H5Event h5Event) {
            this.f59548a = rVar;
            this.f59549b = h5Event;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f59548a.a("ok", (Object) Boolean.TRUE);
            net.one97.paytm.phoenix.core.a.a(this.f59548a, this.f59549b, (Object) null, true, 2);
            dialogInterface.dismiss();
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f59550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59551b;

        c(r rVar, H5Event h5Event) {
            this.f59550a = rVar;
            this.f59551b = h5Event;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f59550a.a("ok", (Object) Boolean.FALSE);
            net.one97.paytm.phoenix.core.a.a(this.f59550a, this.f59551b, (Object) null, true, 2);
            dialogInterface.dismiss();
        }
    }
}
