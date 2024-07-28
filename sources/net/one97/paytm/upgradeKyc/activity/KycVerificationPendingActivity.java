package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.view.View;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.e;

public final class KycVerificationPendingActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65345a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static final String f65346b = f65346b;

    /* renamed from: d  reason: collision with root package name */
    private static final String f65347d = f65347d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f65348e;

    public final View a(int i2) {
        if (this.f65348e == null) {
            this.f65348e = new HashMap();
        }
        View view = (View) this.f65348e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65348e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.activity_verification_pending;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0133, code lost:
        if (r0 == null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0157, code lost:
        if (r0 == null) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x017b, code lost:
        if (r0 == null) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x019f, code lost:
        if (r0 == null) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c3, code lost:
        if (r0 == null) goto L_0x01c5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            android.content.Intent r9 = r8.getIntent()
            r0 = 0
            if (r9 == 0) goto L_0x0025
            android.os.Bundle r9 = r9.getExtras()
            if (r9 == 0) goto L_0x0025
            java.lang.String r1 = "kyc_additional_info"
            java.io.Serializable r9 = r9.getSerializable(r1)
            if (r9 == 0) goto L_0x0025
            if (r9 == 0) goto L_0x001d
            net.one97.paytm.common.entity.upgradeKyc.KYCDetail r9 = (net.one97.paytm.common.entity.upgradeKyc.KYCDetail) r9
            goto L_0x0026
        L_0x001d:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.KYCDetail"
            r9.<init>(r0)
            throw r9
        L_0x0025:
            r9 = r0
        L_0x0026:
            if (r9 == 0) goto L_0x002d
            java.lang.String r1 = r9.getAppointmentDate()
            goto L_0x002e
        L_0x002d:
            r1 = r0
        L_0x002e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 8
            java.lang.String r3 = "appointment_book_time_tv"
            r4 = 0
            if (r1 != 0) goto L_0x00a2
            if (r9 != 0) goto L_0x0040
            kotlin.g.b.k.a()
        L_0x0040:
            java.lang.String r1 = r9.getAppointmentDate()
            java.lang.String r5 = "kycDetail!!.appointmentDate"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            java.lang.String r5 = "yyyy-mm-dd"
            java.lang.String r6 = "EEEE, dd MMM yyyy"
            java.lang.String r1 = b(r5, r6, r1)
            java.lang.String r5 = r9.getAppointmentTimeSlot()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0083
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = "\n"
            r5.append(r1)
            java.lang.String r1 = r9.getAppointmentTimeSlot()
            java.lang.String r6 = "kycDetail.appointmentTimeSlot"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r6 = "-"
            java.lang.String r7 = " to "
            java.lang.String r1 = kotlin.m.p.a(r1, r6, r7, r4)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
        L_0x0083:
            int r5 = net.one97.paytm.upgradeKyc.R.id.appointment_book_time_tv
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            r5.setVisibility(r4)
            int r5 = net.one97.paytm.upgradeKyc.R.id.appointment_book_time_tv
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
            goto L_0x00b0
        L_0x00a2:
            int r1 = net.one97.paytm.upgradeKyc.R.id.appointment_book_time_tv
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r1.setVisibility(r2)
        L_0x00b0:
            r1 = 1
            if (r9 == 0) goto L_0x00e6
            java.lang.String r3 = r9.getPOIType()
            if (r3 == 0) goto L_0x00e6
            java.lang.String r3 = r9.getPoINumber()
            if (r3 == 0) goto L_0x00e6
            int r3 = net.one97.paytm.upgradeKyc.R.id.fragment_appointment_book_card_data_tv
            android.view.View r3 = r8.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r5 = "fragment_appointment_book_card_data_tv"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.upgradeKyc.R.string.poitype_with_poinumber
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = r9.getPOIType()
            r6[r4] = r7
            java.lang.String r7 = r9.getPoINumber()
            r6[r1] = r7
            java.lang.String r5 = r8.getString(r5, r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
        L_0x00e6:
            if (r9 == 0) goto L_0x00ed
            java.util.List r3 = r9.getAddDetails()
            goto L_0x00ee
        L_0x00ed:
            r3 = r0
        L_0x00ee:
            if (r3 == 0) goto L_0x020e
            java.util.List r3 = r9.getAddDetails()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x020e
            java.util.List r9 = r9.getAddDetails()
            java.lang.Object r9 = r9.get(r4)
            net.one97.paytm.common.entity.upgradeKyc.KycAddDetail r9 = (net.one97.paytm.common.entity.upgradeKyc.KycAddDetail) r9
            java.lang.String r3 = ", "
            java.lang.String r5 = "kycAddDetail"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r5)
            java.lang.String r5 = r9.getAddressLine1()
            if (r5 == 0) goto L_0x011d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = r9.getAddressLine1()
            r0.<init>(r5)
            r0.append(r3)
        L_0x011d:
            java.lang.String r5 = r9.getAddressLine2()
            if (r5 == 0) goto L_0x0141
            if (r0 == 0) goto L_0x0135
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = r9.getAddressLine2()
            r5.<init>(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.append(r5)
            if (r0 != 0) goto L_0x013e
        L_0x0135:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = r9.getAddressLine2()
            r0.<init>(r5)
        L_0x013e:
            r0.append(r3)
        L_0x0141:
            java.lang.String r5 = r9.getAddressLine3()
            if (r5 == 0) goto L_0x0165
            if (r0 == 0) goto L_0x0159
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = r9.getAddressLine3()
            r5.<init>(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.append(r5)
            if (r0 != 0) goto L_0x0162
        L_0x0159:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = r9.getAddressLine3()
            r0.<init>(r5)
        L_0x0162:
            r0.append(r3)
        L_0x0165:
            java.lang.String r5 = r9.getCity()
            if (r5 == 0) goto L_0x0189
            if (r0 == 0) goto L_0x017d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = r9.getCity()
            r5.<init>(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.append(r5)
            if (r0 != 0) goto L_0x0186
        L_0x017d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = r9.getCity()
            r0.<init>(r5)
        L_0x0186:
            r0.append(r3)
        L_0x0189:
            java.lang.String r5 = r9.getPincodeC()
            if (r5 == 0) goto L_0x01ad
            if (r0 == 0) goto L_0x01a1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = r9.getPincodeC()
            r5.<init>(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.append(r5)
            if (r0 != 0) goto L_0x01aa
        L_0x01a1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = r9.getPincodeC()
            r0.<init>(r5)
        L_0x01aa:
            r0.append(r3)
        L_0x01ad:
            java.lang.String r5 = r9.getState()
            if (r5 == 0) goto L_0x01d1
            if (r0 == 0) goto L_0x01c5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = r9.getState()
            r5.<init>(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.append(r5)
            if (r0 != 0) goto L_0x01ce
        L_0x01c5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r9 = r9.getState()
            r0.<init>(r9)
        L_0x01ce:
            r0.append(r3)
        L_0x01d1:
            java.lang.String r9 = "address_for_in_person_value_tv"
            if (r0 == 0) goto L_0x0200
            int r2 = r0.length()
            int r2 = r2 - r1
            r0.setLength(r2)
            int r1 = net.one97.paytm.upgradeKyc.R.id.address_for_in_person_value_tv
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            r1.setVisibility(r4)
            int r1 = net.one97.paytm.upgradeKyc.R.id.address_for_in_person_value_tv
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            java.lang.String r9 = r0.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1.setText(r9)
            goto L_0x020e
        L_0x0200:
            int r0 = net.one97.paytm.upgradeKyc.R.id.address_for_in_person_value_tv
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            r0.setVisibility(r2)
        L_0x020e:
            int r9 = net.one97.paytm.upgradeKyc.R.id.activity_verification_pending_lyt_need_help
            android.view.View r9 = r8.a((int) r9)
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            net.one97.paytm.upgradeKyc.activity.KycVerificationPendingActivity$b r0 = new net.one97.paytm.upgradeKyc.activity.KycVerificationPendingActivity$b
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.KycVerificationPendingActivity.onCreate(android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycVerificationPendingActivity f65349a;

        b(KycVerificationPendingActivity kycVerificationPendingActivity) {
            this.f65349a = kycVerificationPendingActivity;
        }

        public final void onClick(View view) {
            KycVerificationPendingActivity.a(this.f65349a);
        }
    }

    private static String b(String str, String str2, String str3) {
        k.c(str, "fromFormat");
        k.c(str2, "toFormat");
        k.c(str3, "time");
        try {
            String format = new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
            k.a((Object) format, "targetFormat.format(date)");
            return format;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final /* synthetic */ void a(KycVerificationPendingActivity kycVerificationPendingActivity) {
        String format = String.format("paytmmp://csttree?featuretype=cst_issue&verticalid=%s&l1=%s", new Object[]{f65347d, f65346b});
        e.a aVar = e.f66028b;
        k.a((Object) format, "deeplink");
        e.a.b().a((Context) kycVerificationPendingActivity, format);
    }
}
