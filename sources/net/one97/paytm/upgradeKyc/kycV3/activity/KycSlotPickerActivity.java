package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.upgradeKyc.AvailableSlots;
import net.one97.paytm.common.entity.upgradeKyc.KycAddress;
import net.one97.paytm.common.entity.upgradeKyc.PostAppointmentObject;
import net.one97.paytm.common.entity.upgradeKyc.PostAppointmentResponse;
import net.one97.paytm.common.entity.upgradeKyc.TimeSlots;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.kycV3.a.b;
import net.one97.paytm.upgradeKyc.kycV3.b.a;
import net.one97.paytm.upgradeKyc.kycV3.c.j;
import net.one97.paytm.upgradeKyc.utils.l;

public final class KycSlotPickerActivity extends UpgradeKycBaseActivity implements b.C1323b {

    /* renamed from: i  reason: collision with root package name */
    public static final a f66132i = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    boolean f66133a;

    /* renamed from: b  reason: collision with root package name */
    boolean f66134b;

    /* renamed from: d  reason: collision with root package name */
    List<IJRDataModel> f66135d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    String f66136e = "";

    /* renamed from: f  reason: collision with root package name */
    String f66137f = "";

    /* renamed from: g  reason: collision with root package name */
    public j f66138g;

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.kycV3.c.e f66139h;
    /* access modifiers changed from: private */
    public boolean j;
    private net.one97.paytm.upgradeKyc.kycV3.a.b k;
    private net.one97.paytm.upgradeKyc.kycV3.a.c l;
    private List<IJRDataModel> m = new ArrayList();
    private int n;
    private int o;
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<List<IJRDataModel>>> p = new e(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> q = new c(this);
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycSlotPickerActivity f66141a;

        c(KycSlotPickerActivity kycSlotPickerActivity) {
            this.f66141a = kycSlotPickerActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = f.f66161b[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66141a.a(R.id.wallet_loader));
                    if (!(bVar.f66169b instanceof PostAppointmentResponse)) {
                        return;
                    }
                    if (bVar.f66169b != null) {
                        a.C1325a aVar = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
                        Context applicationContext = this.f66141a.getApplicationContext();
                        k.a((Object) applicationContext, "this.applicationContext");
                        a.C1325a.a(applicationContext);
                        net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData");
                        if (this.f66141a.f66133a || this.f66141a.f66134b) {
                            KycSlotPickerActivity.e(this.f66141a);
                        } else {
                            KycSlotPickerActivity.d(this.f66141a);
                        }
                        Button button = (Button) this.f66141a.a(R.id.fragment_request_visit_button_book);
                        k.a((Object) button, "fragment_request_visit_button_book");
                        button.setClickable(true);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.PostAppointmentResponse");
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        Button button2 = (Button) this.f66141a.a(R.id.fragment_request_visit_button_book);
                        k.a((Object) button2, "fragment_request_visit_button_book");
                        button2.setClickable(false);
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66141a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66141a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66141a.a(R.id.wallet_loader));
                        Button button3 = (Button) this.f66141a.a(R.id.fragment_request_visit_button_book);
                        k.a((Object) button3, "fragment_request_visit_button_book");
                        button3.setClickable(true);
                        Snackbar.a((View) (ConstraintLayout) this.f66141a.a(R.id.slot_picker_parent_lyt), (CharSequence) this.f66141a.getString(R.string.some_went_wrong), -1).c();
                    }
                }
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<List<? extends IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycSlotPickerActivity f66143a;

        e(KycSlotPickerActivity kycSlotPickerActivity) {
            this.f66143a = kycSlotPickerActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = f.f66160a[dVar.ordinal()];
                if (i2 == 1) {
                    Button button = (Button) this.f66143a.a(R.id.fragment_request_visit_button_book);
                    k.a((Object) button, "fragment_request_visit_button_book");
                    button.setClickable(true);
                    Group group = (Group) this.f66143a.a(R.id.slot_view_group);
                    k.a((Object) group, "slot_view_group");
                    group.setVisibility(0);
                    if (this.f66143a.f66133a) {
                        if (!this.f66143a.j) {
                            Group group2 = (Group) this.f66143a.a(R.id.reschedule_grp);
                            k.a((Object) group2, "reschedule_grp");
                            group2.setVisibility(0);
                        }
                        Button button2 = (Button) this.f66143a.a(R.id.fragment_request_visit_button_book);
                        k.a((Object) button2, "fragment_request_visit_button_book");
                        button2.setText(this.f66143a.getString(R.string.reschdule_appointment));
                    } else {
                        Group group3 = (Group) this.f66143a.a(R.id.reschedule_grp);
                        k.a((Object) group3, "reschedule_grp");
                        group3.setVisibility(8);
                    }
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66143a.a(R.id.wallet_loader));
                    List list = (List) bVar.f66169b;
                    if (list != null && (!list.isEmpty())) {
                        this.f66143a.f66135d.clear();
                        List<IJRDataModel> list2 = this.f66143a.f66135d;
                        ResultType resulttype = bVar.f66169b;
                        if (resulttype == null) {
                            k.a();
                        }
                        list2.addAll((Collection) resulttype);
                        this.f66143a.f();
                    }
                    if (this.f66143a.j) {
                        View a2 = this.f66143a.a(R.id.appointment_missed);
                        k.a((Object) a2, "appointment_missed");
                        net.one97.paytm.upgradeKyc.kycV3.b.b(a2);
                        TextView textView = (TextView) this.f66143a.a(R.id.slot);
                        k.a((Object) textView, "slot");
                        textView.setVisibility(8);
                    }
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        Button button3 = (Button) this.f66143a.a(R.id.fragment_request_visit_button_book);
                        k.a((Object) button3, "fragment_request_visit_button_book");
                        button3.setClickable(false);
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66143a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66143a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        Button button4 = (Button) this.f66143a.a(R.id.fragment_request_visit_button_book);
                        k.a((Object) button4, "fragment_request_visit_button_book");
                        button4.setClickable(true);
                        Group group4 = (Group) this.f66143a.a(R.id.slot_view_group);
                        k.a((Object) group4, "slot_view_group");
                        group4.setVisibility(8);
                        Group group5 = (Group) this.f66143a.a(R.id.reschedule_grp);
                        k.a((Object) group5, "reschedule_grp");
                        group5.setVisibility(8);
                    }
                }
            }
        }
    }

    public KycSlotPickerActivity() {
        b.C1323b bVar = this;
        this.k = new net.one97.paytm.upgradeKyc.kycV3.a.b(bVar);
        this.l = new net.one97.paytm.upgradeKyc.kycV3.a.c(bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r3 = r3.get(0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9, int r10) {
        /*
            r8 = this;
            java.lang.String r2 = "date"
            kotlin.g.b.k.c(r9, r2)
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r2 = r8.f66135d
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x0090
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r2 = r8.f66135d
            java.lang.Object r2 = r2.get(r10)
            if (r2 == 0) goto L_0x0088
            net.one97.paytm.common.entity.upgradeKyc.TimeSlots r2 = (net.one97.paytm.common.entity.upgradeKyc.TimeSlots) r2
            java.util.List r3 = r2.getAvailableSlots()
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0030
            java.lang.Object r3 = r3.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.AvailableSlots r3 = (net.one97.paytm.common.entity.upgradeKyc.AvailableSlots) r3
            if (r3 == 0) goto L_0x0030
            java.lang.String r3 = r3.getTimeRange()
            goto L_0x0031
        L_0x0030:
            r3 = r4
        L_0x0031:
            if (r3 != 0) goto L_0x0036
            kotlin.g.b.k.a()
        L_0x0036:
            r8.f66137f = r3
            java.util.List r2 = r2.getAvailableSlots()
            if (r2 == 0) goto L_0x006b
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x004b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r2.next()
            r6 = r4
            net.one97.paytm.common.entity.upgradeKyc.AvailableSlots r6 = (net.one97.paytm.common.entity.upgradeKyc.AvailableSlots) r6
            java.lang.String r6 = r6.getAvailability()
            java.lang.String r7 = "true"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r5)
            if (r6 == 0) goto L_0x004b
            r3.add(r4)
            goto L_0x004b
        L_0x0068:
            r4 = r3
            java.util.List r4 = (java.util.List) r4
        L_0x006b:
            int r2 = r8.o
            if (r2 == 0) goto L_0x0078
            net.one97.paytm.upgradeKyc.kycV3.a.c r3 = r8.l
            java.lang.String r6 = "timeUnselected"
            r3.notifyItemChanged(r2, r6)
            r8.o = r5
        L_0x0078:
            net.one97.paytm.upgradeKyc.kycV3.a.c r2 = r8.l
            if (r4 == 0) goto L_0x0080
            r2.a(r4)
            goto L_0x0090
        L_0x0080:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.IJRDataModel>"
            r0.<init>(r1)
            throw r0
        L_0x0088:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.TimeSlots"
            r0.<init>(r1)
            throw r0
        L_0x0090:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x009b
            r8.f66136e = r9
        L_0x009b:
            int r0 = r8.n
            if (r10 == r0) goto L_0x00b1
            net.one97.paytm.upgradeKyc.kycV3.a.b r0 = r8.k
            java.lang.String r2 = "daySelected"
            r0.notifyItemChanged(r10, r2)
            net.one97.paytm.upgradeKyc.kycV3.a.b r0 = r8.k
            int r2 = r8.n
            java.lang.String r3 = "dayUnselected"
            r0.notifyItemChanged(r2, r3)
            r8.n = r10
        L_0x00b1:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r0 = r3
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = r8.f66136e
            java.lang.String r2 = "event_label"
            r0.put(r2, r1)
            boolean r1 = r8.f66133a
            if (r1 == 0) goto L_0x00d7
            java.lang.String r1 = "event_label2"
            java.lang.String r2 = "reschedule_screen"
            r0.put(r1, r2)
            r4 = 0
            r5 = 8
            java.lang.String r1 = "/kyc/reschedule-screen"
            java.lang.String r2 = "slot_time_selected"
            r0 = r8
            net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity.a(r0, r1, r2, r3, r4, r5)
            return
        L_0x00d7:
            r3 = 0
            r4 = 0
            r5 = 12
            java.lang.String r1 = "/kyc/slot-preference"
            java.lang.String r2 = "slot_date_selected"
            r0 = r8
            net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity.a(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.activity.KycSlotPickerActivity.a(java.lang.String, int):void");
    }

    public final void b(String str, int i2) {
        k.c(str, "time");
        if (!TextUtils.isEmpty(str)) {
            this.f66137f = str;
        }
        int i3 = this.o;
        if (!(i2 == i3 || i2 == -1 || i3 == -1)) {
            this.l.notifyItemChanged(i2, "timeSelected");
            this.l.notifyItemChanged(this.o, "timeUnselected");
            this.o = i2;
        }
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("event_label", this.f66137f);
        if (this.f66133a) {
            map.put("event_label2", "reschedule_screen");
            UpgradeKycBaseActivity.a(this, "/kyc/reschedule-screen", "slot_time_selected", hashMap, (String) null, 8);
            return;
        }
        UpgradeKycBaseActivity.a(this, "/kyc/slot-preference", "slot_time_selected", (HashMap) null, (String) null, 12);
    }

    public final j d() {
        j jVar = this.f66138g;
        if (jVar == null) {
            k.a("viewModel");
        }
        return jVar;
    }

    public final int a() {
        return R.layout.slot_picker_layout;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ void a(Activity activity, boolean z, boolean z2, boolean z3, int i2) {
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            if ((i2 & 8) != 0) {
                z3 = false;
            }
            a(activity, z, z2, z3);
        }

        private static void a(Activity activity, boolean z, boolean z2, boolean z3) {
            k.c(activity, "activity");
            Intent intent = new Intent(activity, KycSlotPickerActivity.class);
            intent.putExtra("isSlotChange", z);
            intent.putExtra("isAppointmentMissed", z3);
            intent.putExtra("isAddressChange", z2);
            activity.startActivity(intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f66138g = (j) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, j.class);
        this.f66139h = (net.one97.paytm.upgradeKyc.kycV3.c.e) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.kycV3.c.e.class);
        Intent intent = getIntent();
        boolean z = false;
        this.f66133a = intent != null ? intent.getBooleanExtra("isSlotChange", false) : false;
        Intent intent2 = getIntent();
        this.j = intent2 != null ? intent2.getBooleanExtra("isAppointmentMissed", false) : false;
        Intent intent3 = getIntent();
        if (intent3 != null) {
            z = intent3.getBooleanExtra("isAddressChange", false);
        }
        this.f66134b = z;
        e();
        ((Button) a(R.id.fragment_request_visit_button_book)).setOnClickListener(new b(this));
        a(this.f66133a ? "/kyc/reschedule-screen" : "/kyc/slot-preference", "kyc_new", "signal");
        j jVar = this.f66138g;
        if (jVar == null) {
            k.a("viewModel");
        }
        q qVar = this;
        jVar.f66248a.observe(qVar, this.q);
        if (this.f66133a) {
            net.one97.paytm.upgradeKyc.kycV3.c.e eVar = this.f66139h;
            if (eVar == null) {
                k.a("slotViewModel");
            }
            eVar.f66224b.observe(qVar, this.p);
        }
        ((TextView) a(R.id.tv_retry)).setOnClickListener(new d(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycSlotPickerActivity f66140a;

        b(KycSlotPickerActivity kycSlotPickerActivity) {
            this.f66140a = kycSlotPickerActivity;
        }

        public final void onClick(View view) {
            Button button = (Button) this.f66140a.a(R.id.fragment_request_visit_button_book);
            k.a((Object) button, "fragment_request_visit_button_book");
            button.setClickable(false);
            if (!TextUtils.isEmpty(this.f66140a.f66136e) && !TextUtils.isEmpty(this.f66140a.f66137f)) {
                if (this.f66140a.f66133a) {
                    RadioGroup radioGroup = (RadioGroup) this.f66140a.a(R.id.cancel_reason_lyt_rg);
                    k.a((Object) radioGroup, "cancel_reason_lyt_rg");
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    String str = "No one has showed up to complete my KYC";
                    if (!this.f66140a.j) {
                        if (checkedRadioButtonId == R.id.no_longer_kyc_rb) {
                            str = "This time slot no longer works for me";
                        } else if (checkedRadioButtonId != R.id.exec_rb) {
                            str = checkedRadioButtonId == R.id.busy_rb ? "KYC agent showed up for doing KYC but was unable to complete the process" : checkedRadioButtonId == R.id.agent_rb ? "KYC agent asked me to reschedule" : checkedRadioButtonId == R.id.not_listed_rb ? "My reason is not listed here" : "";
                        }
                    }
                    j.a(this.f66140a.d(), str, this.f66140a.f66133a, this.f66140a.f66136e, this.f66140a.f66137f, false, (String) null, 48);
                    new HashMap().put("event_label", "reschedule_screen");
                    UpgradeKycBaseActivity.a(this.f66140a, "/kyc/reschedule-screen", "slot_proceed_clicked", (HashMap) null, (String) null, 12);
                    return;
                }
                j.a(this.f66140a.d(), (String) null, false, this.f66140a.f66136e, this.f66140a.f66137f, false, (String) null, 51);
                UpgradeKycBaseActivity.a(this.f66140a, "/kyc/slot-preference", "slot_proceed_clicked", (HashMap) null, (String) null, 12);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycSlotPickerActivity f66142a;

        d(KycSlotPickerActivity kycSlotPickerActivity) {
            this.f66142a = kycSlotPickerActivity;
        }

        public final void onClick(View view) {
            this.f66142a.e();
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f66133a) {
            Group group = (Group) a(R.id.reschedule_grp);
            k.a((Object) group, "reschedule_grp");
            group.setVisibility(8);
            Group group2 = (Group) a(R.id.slot_view_group);
            k.a((Object) group2, "slot_view_group");
            group2.setVisibility(8);
            a.C1325a aVar = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "this.applicationContext");
            a.C1325a.a(applicationContext);
            PostAppointmentObject postAppointmentObject = (PostAppointmentObject) new f().a(net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData"), PostAppointmentObject.class);
            net.one97.paytm.upgradeKyc.kycV3.c.e eVar = this.f66139h;
            if (eVar == null) {
                k.a("slotViewModel");
            }
            KycAddress kycAddress = postAppointmentObject.getKycAddress();
            String pincode = kycAddress != null ? kycAddress.getPincode() : null;
            if (pincode == null) {
                k.a();
            }
            eVar.a(pincode);
            return;
        }
        Group group3 = (Group) a(R.id.reschedule_grp);
        k.a((Object) group3, "reschedule_grp");
        group3.setVisibility(8);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        Group group4 = (Group) a(R.id.slot_view_group);
        k.a((Object) group4, "slot_view_group");
        group4.setVisibility(0);
        a.C1325a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
        Context applicationContext2 = getApplicationContext();
        k.a((Object) applicationContext2, "applicationContext");
        if (!a.C1325a.a(applicationContext2).f66164a.isEmpty()) {
            this.f66135d.clear();
            List<IJRDataModel> list = this.f66135d;
            a.C1325a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
            Context applicationContext3 = getApplicationContext();
            k.a((Object) applicationContext3, "applicationContext");
            list.addAll(a.C1325a.a(applicationContext3).f66164a);
            f();
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        List list;
        RecyclerView recyclerView = (RecyclerView) a(R.id.date_rv);
        k.a((Object) recyclerView, "date_rv");
        recyclerView.setAdapter(this.k);
        this.k.a(this.f66135d);
        IJRDataModel iJRDataModel = this.f66135d.get(0);
        if (iJRDataModel != null) {
            TimeSlots timeSlots = (TimeSlots) iJRDataModel;
            String date = timeSlots.getDate();
            if (date == null) {
                k.a();
            }
            this.f66136e = date;
            List<AvailableSlots> availableSlots = timeSlots.getAvailableSlots();
            if (availableSlots != null) {
                Collection arrayList = new ArrayList();
                for (Object next : availableSlots) {
                    if (p.a(((AvailableSlots) next).getAvailability(), "true", false)) {
                        arrayList.add(next);
                    }
                }
                list = (List) arrayList;
            } else {
                list = null;
            }
            RecyclerView recyclerView2 = (RecyclerView) a(R.id.time_rv);
            k.a((Object) recyclerView2, "time_rv");
            recyclerView2.setAdapter(this.l);
            net.one97.paytm.upgradeKyc.kycV3.a.c cVar = this.l;
            if (list != null) {
                cVar.a(list);
                if (!list.isEmpty()) {
                    String timeRange = ((AvailableSlots) list.get(0)).getTimeRange();
                    if (timeRange == null) {
                        k.a();
                    }
                    this.f66137f = timeRange;
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.IJRDataModel>");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.TimeSlots");
    }

    public static final /* synthetic */ void d(KycSlotPickerActivity kycSlotPickerActivity) {
        Intent intent = new Intent(kycSlotPickerActivity, ConsentCaptureActivity.class);
        String h2 = com.paytm.utility.b.h(kycSlotPickerActivity.f66136e, "dd-MM-yyyy", "EEEE, dd MMM yyyy");
        a.C1325a aVar = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
        Context applicationContext = kycSlotPickerActivity.getApplicationContext();
        k.a((Object) applicationContext, "this.applicationContext");
        a.C1325a.a(applicationContext);
        PostAppointmentObject postAppointmentObject = (PostAppointmentObject) new f().a(net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData"), PostAppointmentObject.class);
        if ((postAppointmentObject != null ? postAppointmentObject.getKycAddress() : null) != null) {
            intent.putExtra(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, postAppointmentObject.getKycAddress());
        }
        if (!TextUtils.isEmpty(kycSlotPickerActivity.f66137f)) {
            intent.putExtra("time", kycSlotPickerActivity.f66137f);
        }
        if (!TextUtils.isEmpty(h2)) {
            intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, h2);
        }
        kycSlotPickerActivity.startActivity(intent);
        kycSlotPickerActivity.finish();
    }

    public static final /* synthetic */ void e(KycSlotPickerActivity kycSlotPickerActivity) {
        kycSlotPickerActivity.startActivity(new Intent(kycSlotPickerActivity, AppointmentBookedActivity.class));
        kycSlotPickerActivity.finish();
    }
}
