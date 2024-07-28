package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.KycAddDetail;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycDoorStepActivity;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycSlotPickerActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.a;
import net.one97.paytm.upgradeKyc.utils.l;

public final class AppointmentBookedActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.kycV3.c.a f66066a;

    /* renamed from: b  reason: collision with root package name */
    String f66067b;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.kycV3.b.a f66068d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f66069e;

    public final View a(int i2) {
        if (this.f66069e == null) {
            this.f66069e = new HashMap();
        }
        View view = (View) this.f66069e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66069e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66070a;

        a(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66070a = appointmentBookedActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            KycSavedUserData kycSavedUserData;
            List<KYCDetail> kYCDetail;
            List<KYCDetail> kYCDetail2;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            KYCDetail kYCDetail3 = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f66151a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66070a.a(R.id.wallet_loader));
                    if (bVar.f66169b == null || (kycSavedUserData = (KycSavedUserData) bVar.f66169b) == null || (kYCDetail = kycSavedUserData.getKYCDetail()) == null || !(!kYCDetail.isEmpty())) {
                        Snackbar.a((View) (ConstraintLayout) this.f66070a.a(R.id.visit_scheduled_parent_lyt), (CharSequence) this.f66070a.getString(R.string.some_went_wrong), -1).c();
                        return;
                    }
                    AppointmentBookedActivity appointmentBookedActivity = this.f66070a;
                    KycSavedUserData kycSavedUserData2 = (KycSavedUserData) bVar.f66169b;
                    if (!(kycSavedUserData2 == null || (kYCDetail2 = kycSavedUserData2.getKYCDetail()) == null)) {
                        kYCDetail3 = kYCDetail2.get(0);
                    }
                    if (kYCDetail3 == null) {
                        k.a();
                    }
                    appointmentBookedActivity.a(kYCDetail3);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66070a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66070a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66070a.a(R.id.wallet_loader));
                        Snackbar.a((View) (ConstraintLayout) this.f66070a.a(R.id.visit_scheduled_parent_lyt), (CharSequence) this.f66070a.getString(R.string.some_went_wrong), -1).c();
                    }
                }
            }
        }
    }

    public final int a() {
        return R.layout.appointment_booked_lyt;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final void onCreate(Bundle bundle) {
        KYCDetail kYCDetail;
        Bundle extras;
        Serializable serializable;
        super.onCreate(bundle);
        a("/kyc/confirmation-screen", "kyc_new", "signal");
        this.f66066a = (net.one97.paytm.upgradeKyc.kycV3.c.a) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.kycV3.c.a.class);
        net.one97.paytm.upgradeKyc.kycV3.c.a aVar = this.f66066a;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.f66200c.observe(this, new a(this));
        a.C1325a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        this.f66068d = a.C1325a.a(applicationContext);
        if (this.f66068d != null) {
            net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData");
        }
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || (serializable = extras.getSerializable("kyc_additional_info")) == null) {
            kYCDetail = null;
        } else if (serializable != null) {
            kYCDetail = (KYCDetail) serializable;
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.KYCDetail");
        }
        if (kYCDetail != null) {
            a(kYCDetail);
        } else {
            net.one97.paytm.upgradeKyc.kycV3.c.a aVar3 = this.f66066a;
            if (aVar3 == null) {
                k.a("viewModel");
            }
            aVar3.a("QR_F");
        }
        ((TextView) a(R.id.know_more_tv)).setOnClickListener(new b(this));
        ((TextView) a(R.id.change_slot_tv)).setOnClickListener(new c(this));
        ((TextView) a(R.id.change_add_tv)).setOnClickListener(new d(this));
        a(R.id.transparent_view_nearby).setOnClickListener(new e(this));
        ((TextView) a(R.id.cancel_tv)).setOnClickListener(new f(this));
        a(R.id.transparent_view_need_help).setOnClickListener(new g(this));
        ((ImageView) a(R.id.qr_code)).setOnClickListener(new h(this));
    }

    private final void a(String str) {
        ImageView imageView = (ImageView) a(R.id.qr_code);
        k.a((Object) imageView, "qr_code");
        int width = imageView.getWidth();
        ImageView imageView2 = (ImageView) a(R.id.qr_code);
        k.a((Object) imageView2, "qr_code");
        ((ImageView) a(R.id.qr_code)).setImageBitmap(com.google.zxing.client.android.d.a.a(str, width, imageView2.getHeight(), false));
    }

    private final String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.ninetotweleve);
            k.a((Object) str, "getString(R.string.ninetotweleve)");
        }
        List<String> a2 = p.a((CharSequence) str, new String[]{"TO"});
        String string = getString(R.string.ninetotweleve);
        String str3 = "";
        if (p.a((CharSequence) a2.get(0), (CharSequence) "AM", false)) {
            str2 = p.a(a2.get(0), "AM", " " + getString(R.string.kyc_am), false);
        } else if (p.a((CharSequence) a2.get(0), (CharSequence) "NOON", false)) {
            str2 = p.a(a2.get(0), "NOON", " " + getString(R.string.kyc_noon), false);
        } else if (p.a((CharSequence) a2.get(0), (CharSequence) "PM", false)) {
            str2 = p.a(a2.get(0), "PM", " " + getString(R.string.kyc_pm), false);
        } else {
            str2 = str3;
        }
        if (p.a((CharSequence) a2.get(1), (CharSequence) "AM", false)) {
            str3 = p.a(a2.get(1), "AM", " " + getString(R.string.kyc_am), false);
        } else if (p.a((CharSequence) a2.get(1), (CharSequence) "NOON", false)) {
            str3 = p.a(a2.get(1), "NOON", " " + getString(R.string.kyc_noon), false);
        } else if (p.a((CharSequence) a2.get(1), (CharSequence) "PM", false)) {
            str3 = p.a(a2.get(1), "PM", " " + getString(R.string.kyc_pm), false);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            string = str2 + " " + getString(R.string.kyc_to) + " " + str3;
        }
        k.a((Object) string, "formattedTitle");
        return string;
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        KycSlotPickerActivity.a aVar = KycSlotPickerActivity.f66132i;
        KycSlotPickerActivity.a.a(this, true, false, z, 4);
        finish();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66071a;

        b(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66071a = appointmentBookedActivity;
        }

        public final void onClick(View view) {
            AppointmentBookedActivity.a(this.f66071a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66072a;

        c(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66072a = appointmentBookedActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f66072a, "/kyc/confirmation-screen", "change_slot_clicked", (HashMap) null, (String) null, 12);
            this.f66072a.a(false);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66073a;

        d(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66073a = appointmentBookedActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f66073a, "/kyc/confirmation-screen", "change_address_clicked", (HashMap) null, (String) null, 12);
            AppointmentBookedActivity.c(this.f66073a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66074a;

        e(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66074a = appointmentBookedActivity;
        }

        public final void onClick(View view) {
            this.f66074a.startActivity(new Intent(this.f66074a, KycNearByActivity.class));
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66075a;

        f(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66075a = appointmentBookedActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f66075a, "/kyc/confirmation-screen", "cancel_button_clicked", (HashMap) null, (String) null, 12);
            this.f66075a.startActivity(new Intent(this.f66075a, CancelAppointmentActivity.class));
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66076a;

        g(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66076a = appointmentBookedActivity;
        }

        public final void onClick(View view) {
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            e.a.b().a((Context) this.f66076a, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000007&l1=1600221");
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppointmentBookedActivity f66077a;

        h(AppointmentBookedActivity appointmentBookedActivity) {
            this.f66077a = appointmentBookedActivity;
        }

        public final void onClick(View view) {
            if (!TextUtils.isEmpty(this.f66077a.f66067b)) {
                AppointmentBookedActivity.f(this.f66077a);
            }
        }
    }

    private static String a(KycAddDetail kycAddDetail) {
        StringBuilder sb = new StringBuilder();
        sb.append(kycAddDetail.getAddressLine1() + ", " + kycAddDetail.getAddressLine3() + ", " + kycAddDetail.getCity() + ", " + kycAddDetail.getState() + "-" + kycAddDetail.getPincodeC());
        String sb2 = sb.toString();
        k.a((Object) sb2, "address.toString()");
        return sb2;
    }

    /* access modifiers changed from: private */
    public final void a(KYCDetail kYCDetail) {
        List<KycAddDetail> addDetails;
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.appointment_booked_lyt_grp);
        k.a((Object) constraintLayout, "appointment_booked_lyt_grp");
        net.one97.paytm.upgradeKyc.kycV3.b.b(constraintLayout);
        if (!(kYCDetail.getAddDetails() == null || (addDetails = kYCDetail.getAddDetails()) == null || !(!addDetails.isEmpty()))) {
            TextView textView = (TextView) a(R.id.address_for_in_person_value_tv);
            k.a((Object) textView, "address_for_in_person_value_tv");
            List<KycAddDetail> addDetails2 = kYCDetail.getAddDetails();
            KycAddDetail kycAddDetail = addDetails2 != null ? addDetails2.get(0) : null;
            if (kycAddDetail == null) {
                k.a();
            }
            textView.setText(a(kycAddDetail));
        }
        String appointmentDate = kYCDetail.getAppointmentDate();
        String appointmentTimeSlot = kYCDetail.getAppointmentTimeSlot();
        if (TextUtils.isEmpty(appointmentDate) || TextUtils.isEmpty(appointmentTimeSlot)) {
            TextView textView2 = (TextView) a(R.id.appointment_book_time_tv);
            k.a((Object) textView2, "appointment_book_time_tv");
            textView2.setText(getString(R.string.we_will_contact_visit));
            TextView textView3 = (TextView) a(R.id.cancel_tv);
            k.a((Object) textView3, "cancel_tv");
            textView3.setVisibility(8);
            TextView textView4 = (TextView) a(R.id.change_slot_tv);
            k.a((Object) textView4, "change_slot_tv");
            textView4.setVisibility(8);
        } else {
            String h2 = com.paytm.utility.b.h(appointmentDate, "yyyy-MM-dd", "EEEE, dd MMM yyyy");
            k.a((Object) appointmentTimeSlot, "time");
            String b2 = b(appointmentTimeSlot);
            TextView textView5 = (TextView) a(R.id.appointment_book_time_tv);
            k.a((Object) textView5, "appointment_book_time_tv");
            textView5.setText(getString(R.string.poitype_with_poinumber, new Object[]{h2, b2}));
            if (d().after(new SimpleDateFormat("EEEE, dd MMM yyyy").parse(h2))) {
                a(true);
            }
        }
        this.f66067b = kYCDetail.getQrCodeId();
        if (!TextUtils.isEmpty(this.f66067b)) {
            String str = this.f66067b;
            if (str == null) {
                k.a();
            }
            a(str);
        }
    }

    private static Date d() {
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "cal");
        instance.setTime(new Date());
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Date time = instance.getTime();
        k.a((Object) time, "cal.time");
        return time;
    }

    public static final /* synthetic */ void a(AppointmentBookedActivity appointmentBookedActivity) {
        e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        Intent intent = new Intent(appointmentBookedActivity, Class.forName(e.a.b().d()));
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("withoutAadhaarKnowMoreUrl") : null;
        if (!TextUtils.isEmpty(a2)) {
            intent.putExtra("url", a2);
        }
        intent.putExtra("title", appointmentBookedActivity.getString(R.string.rbi_directive));
        appointmentBookedActivity.startActivity(intent);
    }

    public static final /* synthetic */ void c(AppointmentBookedActivity appointmentBookedActivity) {
        KycDoorStepActivity.a aVar = KycDoorStepActivity.f66107b;
        KycDoorStepActivity.a.a(appointmentBookedActivity, true);
        appointmentBookedActivity.finish();
    }

    public static final /* synthetic */ void f(AppointmentBookedActivity appointmentBookedActivity) {
        Intent intent = new Intent(appointmentBookedActivity, FullScreenQRActivity.class);
        intent.putExtra("qrCode", appointmentBookedActivity.f66067b);
        appointmentBookedActivity.startActivity(intent, androidx.core.app.b.a(appointmentBookedActivity, (ImageView) appointmentBookedActivity.a(R.id.qr_code), appointmentBookedActivity.getString(R.string.complete_kyc_now)).a());
    }
}
