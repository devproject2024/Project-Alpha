package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.List;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.e.ac;
import net.one97.paytm.upi.e.ae;
import net.one97.paytm.upi.e.t;
import net.one97.paytm.upi.registration.view.h;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.SimUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class o extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f68987a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f68988b;

    /* renamed from: c  reason: collision with root package name */
    private String f68989c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<? extends SubscriptionInfo> f68990d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f68991e = -1;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f68992f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f68993g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f68994h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f68995i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private View o;
    private View p;
    private t q;
    private HashMap r;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f68988b = arguments.getString("param1");
            this.f68989c = arguments.getString("param2");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_sign_up_device_registration, viewGroup, false);
        this.q = t.a(inflate);
        t tVar = this.q;
        if (tVar != null) {
            this.f68992f = tVar.f66898f;
            TextView textView = tVar.f66899g.f66744a;
            kotlin.g.b.k.a((Object) textView, "simSelection.serviceProvider1");
            this.f68994h = textView;
            TextView textView2 = tVar.f66899g.f66745b;
            kotlin.g.b.k.a((Object) textView2, "simSelection.serviceProvider2");
            this.f68995i = textView2;
            TextView textView3 = tVar.f66899g.f66750g;
            kotlin.g.b.k.a((Object) textView3, "simSelection.simNumber1");
            this.j = textView3;
            TextView textView4 = tVar.f66899g.f66751h;
            kotlin.g.b.k.a((Object) textView4, "simSelection.simNumber2");
            this.k = textView4;
            ConstraintLayout constraintLayout = tVar.f66899g.f66748e;
            kotlin.g.b.k.a((Object) constraintLayout, "simSelection.sim1");
            View rootView = constraintLayout.getRootView();
            kotlin.g.b.k.a((Object) rootView, "simSelection.sim1.rootView");
            this.o = rootView;
            ConstraintLayout constraintLayout2 = tVar.f66899g.f66749f;
            kotlin.g.b.k.a((Object) constraintLayout2, "simSelection.sim2");
            View rootView2 = constraintLayout2.getRootView();
            kotlin.g.b.k.a((Object) rootView2, "simSelection.sim2.rootView");
            this.p = rootView2;
            ImageView imageView = tVar.f66899g.f66746c;
            kotlin.g.b.k.a((Object) imageView, "simSelection.serviceProviderLogo1");
            this.m = imageView;
            ImageView imageView2 = tVar.f66899g.f66747d;
            kotlin.g.b.k.a((Object) imageView2, "simSelection.serviceProviderLogo2");
            this.n = imageView2;
            TextView textView5 = tVar.o;
            kotlin.g.b.k.a((Object) textView5, "tvUpiOffer");
            this.f68993g = textView5;
            ImageView imageView3 = tVar.f66896d;
            kotlin.g.b.k.a((Object) imageView3, "ivLogo");
            this.l = imageView3;
            TextView textView6 = tVar.n;
            kotlin.g.b.k.a((Object) textView6, "tvTitle");
            textView6.setText(getString(R.string.upi_verify_mobile_number_dynamic, com.paytm.utility.a.b(getContext())));
            tVar.f66895c.setOnClickListener(new b(this));
            tVar.f66900h.setOnClickListener(new c(this));
            tVar.f66899g.f66748e.setOnClickListener(new d(this));
            tVar.f66899g.f66749f.setOnClickListener(new e(this));
        }
        if (UpiUtils.isPaytmFirstApp()) {
            View findViewById = inflate.findViewById(R.id.rel_bottom);
            kotlin.g.b.k.a((Object) findViewById, "view.findViewById<RelativeLayout>(R.id.rel_bottom)");
            ((RelativeLayout) findViewById).setVisibility(8);
            View findViewById2 = inflate.findViewById(R.id.skip_tv);
            kotlin.g.b.k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.skip_tv)");
            ((TextView) findViewById2).setVisibility(8);
            View findViewById3 = inflate.findViewById(R.id.motif_iv);
            kotlin.g.b.k.a((Object) findViewById3, "view.findViewById<ImageView>(R.id.motif_iv)");
            ((ImageView) findViewById3).setVisibility(8);
        }
        b();
        kotlin.g.b.k.a((Object) inflate, "view");
        ((TextView) inflate.findViewById(R.id.tv_re_activate_account)).setOnClickListener(new j(this));
        TextView textView7 = this.f68993g;
        if (textView7 == null) {
            kotlin.g.b.k.a("mTvOffer");
        }
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        textView7.setText(instance.getUpiQRHomeOfferText());
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f68996a;

        b(o oVar) {
            this.f68996a = oVar;
        }

        public final void onClick(View view) {
            this.f68996a.a();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f68997a;

        c(o oVar) {
            this.f68997a = oVar;
        }

        public final void onClick(View view) {
            o oVar = this.f68997a;
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 23) {
                FragmentActivity activity = oVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                if (androidx.core.content.b.a((Context) activity, "android.permission.READ_PHONE_STATE") == 0) {
                    z = true;
                }
            }
            if (!z || !UpiUtils.isMultiSimDevice(oVar.getActivity())) {
                CJRSendGTMTag.sendNewCustomGTMEvents(oVar.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "add_account_screen_skip", "", "", "", "/bhim-upi/signup/addaccount", "wallet");
            } else {
                CJRSendGTMTag.sendNewCustomGTMEvents(oVar.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "sim_selection_skip", "", "", "", "/bhim-upi/signup/simselection", "wallet");
            }
            if (oVar.getActivity() instanceof SignUpAddBankActivity) {
                FragmentActivity activity2 = oVar.getActivity();
                if (activity2 != null) {
                    ((SignUpAddBankActivity) activity2).b(2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankActivity");
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f68998a;

        d(o oVar) {
            this.f68998a = oVar;
        }

        public final void onClick(View view) {
            o.a(this.f68998a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f68999a;

        e(o oVar) {
            this.f68999a = oVar;
        }

        public final void onClick(View view) {
            o.b(this.f68999a);
        }
    }

    public final void a() {
        FragmentActivity activity;
        androidx.fragment.app.j supportFragmentManager;
        if (isAdded() && (activity = getActivity()) != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.d();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f69004a;

        j(o oVar) {
            this.f69004a = oVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r11) {
            /*
                r10 = this;
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                androidx.fragment.app.FragmentActivity r11 = r11.getActivity()
                android.content.Context r11 = (android.content.Context) r11
                boolean r11 = net.one97.paytm.upi.util.UpiUtils.isMultiSimDevice(r11)
                r0 = 0
                r1 = -1
                if (r11 == 0) goto L_0x00f4
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                int r11 = r11.f68991e
                r2 = 0
                java.lang.String r3 = "Please select a SIM card to send SMS"
                if (r11 != r1) goto L_0x002b
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                android.content.Context r11 = r11.getContext()
                r4 = r3
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                android.widget.Toast r11 = android.widget.Toast.makeText(r11, r4, r2)
                r11.show()
            L_0x002b:
                int r11 = android.os.Build.VERSION.SDK_INT
                r4 = 22
                if (r11 < r4) goto L_0x005a
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                java.util.List r11 = r11.f68990d
                if (r11 == 0) goto L_0x005a
                java.util.Iterator r11 = r11.iterator()
            L_0x003d:
                boolean r5 = r11.hasNext()
                if (r5 == 0) goto L_0x005a
                java.lang.Object r5 = r11.next()
                android.telephony.SubscriptionInfo r5 = (android.telephony.SubscriptionInfo) r5
                int r6 = r5.getSimSlotIndex()
                net.one97.paytm.upi.registration.view.o r7 = r10.f69004a
                int r7 = r7.f68991e
                if (r6 != r7) goto L_0x003d
                int r11 = r5.getSubscriptionId()
                goto L_0x005b
            L_0x005a:
                r11 = -1
            L_0x005b:
                if (r11 != r1) goto L_0x005e
                return
            L_0x005e:
                net.one97.paytm.upi.registration.view.o r1 = r10.f69004a
                int r1 = r1.f68991e
                if (r1 != 0) goto L_0x0095
                int r1 = android.os.Build.VERSION.SDK_INT
                if (r1 < r4) goto L_0x00dc
                net.one97.paytm.upi.registration.view.o r1 = r10.f69004a
                android.content.Context r2 = r1.getContext()
                java.lang.String r3 = "bhim_upi"
                java.lang.String r4 = "sim_selection"
                java.lang.String r5 = "sim1"
                java.lang.String r6 = ""
                java.lang.String r7 = ""
                java.lang.String r8 = ""
                java.lang.String r9 = "wallet"
                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEvents(r2, r3, r4, r5, r6, r7, r8, r9)
                net.one97.paytm.upi.registration.view.o r1 = r10.f69004a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                boolean r2 = r1 instanceof net.one97.paytm.upi.registration.view.SignUpAddBankActivity
                if (r2 != 0) goto L_0x008c
                goto L_0x008d
            L_0x008c:
                r0 = r1
            L_0x008d:
                net.one97.paytm.upi.registration.view.SignUpAddBankActivity r0 = (net.one97.paytm.upi.registration.view.SignUpAddBankActivity) r0
                if (r0 == 0) goto L_0x00dc
                r0.a((int) r11)
                goto L_0x00dc
            L_0x0095:
                net.one97.paytm.upi.registration.view.o r1 = r10.f69004a
                int r1 = r1.f68991e
                r5 = 1
                if (r1 != r5) goto L_0x00cd
                int r1 = android.os.Build.VERSION.SDK_INT
                if (r1 < r4) goto L_0x00dc
                net.one97.paytm.upi.registration.view.o r1 = r10.f69004a
                android.content.Context r2 = r1.getContext()
                java.lang.String r3 = "bhim_upi"
                java.lang.String r4 = "sim_selection"
                java.lang.String r5 = "sim2"
                java.lang.String r6 = ""
                java.lang.String r7 = ""
                java.lang.String r8 = ""
                java.lang.String r9 = "wallet"
                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEvents(r2, r3, r4, r5, r6, r7, r8, r9)
                net.one97.paytm.upi.registration.view.o r1 = r10.f69004a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                boolean r2 = r1 instanceof net.one97.paytm.upi.registration.view.SignUpAddBankActivity
                if (r2 != 0) goto L_0x00c4
                goto L_0x00c5
            L_0x00c4:
                r0 = r1
            L_0x00c5:
                net.one97.paytm.upi.registration.view.SignUpAddBankActivity r0 = (net.one97.paytm.upi.registration.view.SignUpAddBankActivity) r0
                if (r0 == 0) goto L_0x00dc
                r0.a((int) r11)
                goto L_0x00dc
            L_0x00cd:
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                android.content.Context r11 = r11.getContext()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                android.widget.Toast r11 = android.widget.Toast.makeText(r11, r3, r2)
                r11.show()
            L_0x00dc:
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                android.content.Context r0 = r11.getContext()
                java.lang.String r1 = "bhim_upi"
                java.lang.String r2 = "sim_selection_proceed"
                java.lang.String r3 = ""
                java.lang.String r4 = ""
                java.lang.String r5 = ""
                java.lang.String r6 = "/bhim-upi/signup/simselection"
                java.lang.String r7 = "wallet"
                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEvents(r0, r1, r2, r3, r4, r5, r6, r7)
                return
            L_0x00f4:
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                android.content.Context r2 = r11.getContext()
                java.lang.String r3 = "bhim_upi"
                java.lang.String r4 = "add_account_screen_proceed"
                java.lang.String r5 = ""
                java.lang.String r6 = ""
                java.lang.String r7 = ""
                java.lang.String r8 = "/bhim-upi/signup/addaccount"
                java.lang.String r9 = "wallet"
                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEvents(r2, r3, r4, r5, r6, r7, r8, r9)
                net.one97.paytm.upi.registration.view.o r11 = r10.f69004a
                androidx.fragment.app.FragmentActivity r11 = r11.getActivity()
                boolean r2 = r11 instanceof net.one97.paytm.upi.registration.view.SignUpAddBankActivity
                if (r2 != 0) goto L_0x0116
                r11 = r0
            L_0x0116:
                net.one97.paytm.upi.registration.view.SignUpAddBankActivity r11 = (net.one97.paytm.upi.registration.view.SignUpAddBankActivity) r11
                if (r11 == 0) goto L_0x011d
                r11.a((int) r1)
            L_0x011d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.registration.view.o.j.onClick(android.view.View):void");
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            int a2 = androidx.core.content.b.a((Context) activity, "android.permission.READ_PHONE_STATE");
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            int a3 = androidx.core.content.b.a((Context) activity2, "android.permission.READ_SMS");
            if (!(a2 == 0 && a3 == 0)) {
                requestPermissions(new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_SMS"}, 16);
                return;
            }
        }
        c();
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 16) {
            if (PermissionUtil.areAllPermissionsGranted(iArr)) {
                b();
            } else {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                if (!PermissionUtil.hasSelectedNeverShowThisAgain(activity, "android.permission.READ_PHONE_STATE")) {
                    FragmentActivity activity2 = getActivity();
                    if (activity2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!PermissionUtil.hasSelectedNeverShowThisAgain(activity2, "android.permission.READ_SMS")) {
                        UpiUtils.showReadPhoneStatePermissionDialog(getActivity(), Boolean.FALSE, new h(this), new i(this));
                    }
                }
                UpiUtils.showTakeToSettingsPermissionDialog(getActivity(), Boolean.FALSE, new f(this), new g(this));
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    static final class f implements CustomDialog.OkClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f69000a;

        f(o oVar) {
            this.f69000a = oVar;
        }

        public final void onOkClick() {
            PermissionUtil.openAppSettingPage((Fragment) this.f69000a, 16);
        }
    }

    static final class g implements CustomDialog.OnDialogDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f69001a;

        g(o oVar) {
            this.f69001a = oVar;
        }

        public final void onDialogDismissed() {
            FragmentActivity activity = this.f69001a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class h implements CustomDialog.OkClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f69002a;

        h(o oVar) {
            this.f69002a = oVar;
        }

        public final void onOkClick() {
            this.f69002a.b();
        }
    }

    static final class i implements CustomDialog.OnDialogDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f69003a;

        i(o oVar) {
            this.f69003a = oVar;
        }

        public final void onDialogDismissed() {
            FragmentActivity activity = this.f69003a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 16) {
            b();
        }
    }

    private final void c() {
        ac acVar;
        ConstraintLayout a2;
        ac acVar2;
        TextView textView;
        if (!UpiUtils.isSimAvailable(getActivity())) {
            return;
        }
        if (UpiUtils.isMultiSimDevice(getActivity())) {
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "onboarding_signup_initiation", "", "", "", "/bhim-upi/signup/simselection", "wallet");
            RelativeLayout relativeLayout = this.f68992f;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            t tVar = this.q;
            if (!(tVar == null || (acVar2 = tVar.f66893a) == null || (textView = acVar2.f66738b) == null)) {
                textView.setText(getString(R.string.upi_account_change_bottom_bar_text, com.paytm.utility.a.b(getContext())));
            }
            t tVar2 = this.q;
            if (!(tVar2 == null || (acVar = tVar2.f66893a) == null || (a2 = acVar.a()) == null)) {
                a2.setVisibility(0);
                a2.getRootView().setOnClickListener(new k(this));
            }
            ImageView imageView = this.l;
            if (imageView == null) {
                kotlin.g.b.k.a("mIvLogo");
            }
            imageView.setVisibility(8);
            d();
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "dialog_opens", "", "", GAConstants.SCREEN_NAME.UPI_ONB_SIM_SELECTION_SIGN_UP, "wallet");
            return;
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "onboarding_signup_initiation", "", "", "", "/bhim-upi/signup/addaccount", "wallet");
        RelativeLayout relativeLayout2 = this.f68992f;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        ImageView imageView2 = this.l;
        if (imageView2 == null) {
            kotlin.g.b.k.a("mIvLogo");
        }
        imageView2.setVisibility(0);
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f69005a;

        k(o oVar) {
            this.f69005a = oVar;
        }

        public final void onClick(View view) {
            o.f(this.f69005a);
        }
    }

    private final void d() {
        this.f68990d = UpiUtils.getAllCarrier(getActivity());
        if (this.f68990d != null && Build.VERSION.SDK_INT >= 22) {
            SimUtils.TelcoOperatorModel gTMOperatorMapping = SimUtils.Companion.getGTMOperatorMapping();
            List<? extends SubscriptionInfo> list = this.f68990d;
            if (list == null) {
                kotlin.g.b.k.a();
            }
            boolean z = false;
            boolean z2 = false;
            for (SubscriptionInfo subscriptionInfo : list) {
                if (subscriptionInfo.getSimSlotIndex() == 0) {
                    TextView textView = this.f68994h;
                    if (textView == null) {
                        kotlin.g.b.k.a("mTvOperator1");
                    }
                    textView.setText(subscriptionInfo.getCarrierName());
                    TextView textView2 = this.j;
                    if (textView2 == null) {
                        kotlin.g.b.k.a("mTvSim1");
                    }
                    textView2.setText(getString(R.string.upi_sim_1));
                    String obj = subscriptionInfo.getCarrierName().toString();
                    ImageView imageView = this.m;
                    if (imageView == null) {
                        kotlin.g.b.k.a("opLogo1");
                    }
                    a(obj, imageView, gTMOperatorMapping);
                    z = true;
                } else if (subscriptionInfo.getSimSlotIndex() == 1) {
                    TextView textView3 = this.f68995i;
                    if (textView3 == null) {
                        kotlin.g.b.k.a("mTvOperator2");
                    }
                    textView3.setText(subscriptionInfo.getCarrierName());
                    TextView textView4 = this.k;
                    if (textView4 == null) {
                        kotlin.g.b.k.a("mTvSim2");
                    }
                    textView4.setText(getString(R.string.upi_sim_2));
                    String obj2 = subscriptionInfo.getCarrierName().toString();
                    ImageView imageView2 = this.n;
                    if (imageView2 == null) {
                        kotlin.g.b.k.a("opLogo2");
                    }
                    a(obj2, imageView2, gTMOperatorMapping);
                    z2 = true;
                }
            }
            if (z) {
                View view = this.o;
                if (view == null) {
                    kotlin.g.b.k.a("mLlSim1");
                }
                view.setVisibility(0);
            } else {
                View view2 = this.o;
                if (view2 == null) {
                    kotlin.g.b.k.a("mLlSim1");
                }
                view2.setVisibility(8);
            }
            if (z2) {
                View view3 = this.p;
                if (view3 == null) {
                    kotlin.g.b.k.a("mLlSim2");
                }
                view3.setVisibility(0);
                return;
            }
            View view4 = this.p;
            if (view4 == null) {
                kotlin.g.b.k.a("mLlSim2");
            }
            view4.setVisibility(8);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.q = null;
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private static void a(String str, ImageView imageView, SimUtils.TelcoOperatorModel telcoOperatorModel) {
        if (telcoOperatorModel != null && telcoOperatorModel.getTelcoIconsMap() != null) {
            String uRLFromMap = SimUtils.Companion.getURLFromMap(str, telcoOperatorModel.getTelcoIconsMap());
            if (!TextUtils.isEmpty(uRLFromMap)) {
                w.a().a(uRLFromMap).a(imageView);
            }
        }
    }

    public static final /* synthetic */ void a(o oVar) {
        ae aeVar;
        Context context = oVar.getContext();
        if (context != null) {
            oVar.f68991e = 0;
            t tVar = oVar.q;
            if (tVar != null && (aeVar = tVar.f66899g) != null) {
                ConstraintLayout constraintLayout = aeVar.f66748e;
                kotlin.g.b.k.a((Object) constraintLayout, "sim1");
                constraintLayout.setBackground(androidx.core.content.b.a(context, R.drawable.upi_sim_box_selected));
                ConstraintLayout constraintLayout2 = aeVar.f66749f;
                kotlin.g.b.k.a((Object) constraintLayout2, "sim2");
                constraintLayout2.setBackground(androidx.core.content.b.a(context, R.drawable.upi_sim_box_unselected));
            }
        }
    }

    public static final /* synthetic */ void b(o oVar) {
        ae aeVar;
        Context context = oVar.getContext();
        if (context != null) {
            oVar.f68991e = 1;
            t tVar = oVar.q;
            if (tVar != null && (aeVar = tVar.f66899g) != null) {
                ConstraintLayout constraintLayout = aeVar.f66748e;
                kotlin.g.b.k.a((Object) constraintLayout, "sim1");
                constraintLayout.setBackground(androidx.core.content.b.a(context, R.drawable.upi_sim_box_unselected));
                ConstraintLayout constraintLayout2 = aeVar.f66749f;
                kotlin.g.b.k.a((Object) constraintLayout2, "sim2");
                constraintLayout2.setBackground(androidx.core.content.b.a(context, R.drawable.upi_sim_box_selected));
            }
        }
    }

    public static final /* synthetic */ void f(o oVar) {
        if (oVar.isAdded()) {
            h.a aVar = h.f68882a;
            new h().showNow(oVar.getChildFragmentManager(), h.f68882a.getClass().getName());
        }
    }
}
