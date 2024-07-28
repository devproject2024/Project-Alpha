package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.e.g;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class be extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56407a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f56408b;

    /* renamed from: c  reason: collision with root package name */
    private int f56409c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.oauth.e.b f56410d;

    /* renamed from: e  reason: collision with root package name */
    private List<SubscriptionInfo> f56411e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f56412f;

    public final View a(int i2) {
        if (this.f56412f == null) {
            this.f56412f = new HashMap();
        }
        View view = (View) this.f56412f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56412f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56412f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public be() {
        this.f56408b = "";
        this.f56411e = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public be(net.one97.paytm.oauth.e.b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56410d = bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static be a(Bundle bundle, net.one97.paytm.oauth.e.b bVar) {
            k.c(bVar, "listener");
            be beVar = new be(bVar);
            beVar.setArguments(bundle);
            return beVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_select_sim_card, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        List<SubscriptionInfo> list;
        RoboTextView roboTextView;
        ArrayList parcelableArrayList;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("login_mobile")) == null) {
            str = "";
        }
        this.f56408b = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (parcelableArrayList = arguments2.getParcelableArrayList("simInfoList")) == null) {
            list = new ArrayList<>();
        } else {
            list = parcelableArrayList;
        }
        this.f56411e = list;
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_description1);
        if (roboTextView2 != null) {
            roboTextView2.setText(getString(R.string.lbl_select_sim_associated_with_number, this.f56408b));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.proceed));
        }
        a((AppCompatImageView) a(R.id.ivSim1), (RoboTextView) a(R.id.tvCarrier1), 0);
        a((AppCompatImageView) a(R.id.ivSim2), (RoboTextView) a(R.id.tvCarrier2), 1);
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.bgViewSim1);
        if (appCompatImageView != null) {
            appCompatImageView.setSelected(true);
        }
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || arguments3.getSerializable("auth_flow") == null || (roboTextView = (RoboTextView) a(R.id.tv_change_mobile)) == null)) {
            roboTextView.setVisibility(0);
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.bgViewSim1);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) a(R.id.bgViewSim2);
        if (appCompatImageView4 != null) {
            appCompatImageView4.setOnClickListener(this);
        }
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_change_mobile);
        if (roboTextView3 != null) {
            roboTextView3.setOnClickListener(this);
        }
        RoboTextView roboTextView4 = (RoboTextView) a(R.id.btnDontHaveAccess);
        if (roboTextView4 != null) {
            roboTextView4.setOnClickListener(this);
        }
        ArrayList arrayList = new ArrayList();
        if (this.f56411e.size() == 1) {
            arrayList.add("single_sim");
            arrayList.add(this.f56411e.get(0).getCarrierName().toString());
        } else if (this.f56411e.size() == 2) {
            arrayList.add("dual_sim");
            arrayList.add(this.f56411e.get(0).getCarrierName().toString());
            arrayList.add(this.f56411e.get(1).getCarrierName().toString());
        }
        v.a("/login-signup", "login_signup", "sim_selection_popup_loaded", arrayList, 16);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tv_change_mobile;
        if (valueOf != null && valueOf.intValue() == i2) {
            String[] strArr = new String[1];
            strArr[0] = this.f56411e.size() == 1 ? "single_sim" : "dual_sim";
            v.a("/login-signup", "login_signup", "change_phone_number_clicked", kotlin.a.k.d(strArr), 16);
            net.one97.paytm.oauth.e.b bVar = this.f56410d;
            if (bVar != null) {
                bVar.g(new Bundle(getArguments()));
                return;
            }
            return;
        }
        int i3 = R.id.btnProceed;
        if (valueOf != null && valueOf.intValue() == i3) {
            String[] strArr2 = new String[1];
            strArr2[0] = this.f56409c == 0 ? "sim 1" : "sim 2";
            v.a("/login-signup", "login_signup", "proceed_to_send_sms_clicked", kotlin.a.k.d(strArr2), 16);
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            k.a((Object) arguments, "arguments ?: Bundle()");
            arguments.putInt("simSlotIndex", this.f56409c);
            arguments.putString("iccid", this.f56411e.get(this.f56409c).getIccId());
            arguments.putString(p.f56797b, "post_sim_selection");
            net.one97.paytm.oauth.e.b bVar2 = this.f56410d;
            if (bVar2 != null) {
                bVar2.a(arguments, new b(this));
                return;
            }
            return;
        }
        int i4 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i4) {
            v.a("/login-signup", "login_signup", "sim_selection_popup_closed", (ArrayList) null, 24);
            net.one97.paytm.oauth.e.b bVar3 = this.f56410d;
            if (bVar3 != null) {
                bVar3.b();
                return;
            }
            return;
        }
        int i5 = R.id.bgViewSim1;
        if (valueOf != null && valueOf.intValue() == i5) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.bgViewSim1);
            if (appCompatImageView != null) {
                appCompatImageView.setSelected(true);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.bgViewSim2);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setSelected(false);
            }
            this.f56409c = 0;
            return;
        }
        int i6 = R.id.bgViewSim2;
        if (valueOf != null && valueOf.intValue() == i6) {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.bgViewSim2);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setSelected(true);
            }
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) a(R.id.bgViewSim1);
            if (appCompatImageView4 != null) {
                appCompatImageView4.setSelected(false);
            }
            this.f56409c = 1;
            return;
        }
        int i7 = R.id.btnDontHaveAccess;
        if (valueOf != null && valueOf.intValue() == i7) {
            v.a("/login-signup", "login_signup", "dont_have_sim_clicked", new ArrayList(), 16);
            Bundle bundle = new Bundle(getArguments());
            bundle.putBoolean("is_from_select_sim_card", true);
            net.one97.paytm.oauth.e.b bVar4 = this.f56410d;
            if (bVar4 != null) {
                bVar4.h(bundle);
            }
        }
    }

    public static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ be f56413a;

        b(be beVar) {
            this.f56413a = beVar;
        }

        public final void a() {
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56413a.a(R.id.btnProceed);
            if (progressViewButton != null) {
                progressViewButton.d();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r4 == null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(androidx.appcompat.widget.AppCompatImageView r3, com.paytm.utility.RoboTextView r4, int r5) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 22
            if (r0 < r1) goto L_0x007e
            java.util.List<android.telephony.SubscriptionInfo> r0 = r2.f56411e
            java.lang.Object r0 = r0.get(r5)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            if (r4 == 0) goto L_0x0017
            r4.setText(r0)
        L_0x0017:
            if (r0 == 0) goto L_0x003e
            java.lang.String r4 = r0.toString()
            if (r4 == 0) goto L_0x003e
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r1 = "Locale.getDefault()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            if (r4 == 0) goto L_0x0036
            java.lang.String r4 = r4.toLowerCase(r0)
            java.lang.String r0 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            if (r4 != 0) goto L_0x0040
            goto L_0x003e
        L_0x0036:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)
            throw r3
        L_0x003e:
            java.lang.String r4 = ""
        L_0x0040:
            java.lang.String r4 = net.one97.paytm.oauth.utils.OAuthUtils.g(r4)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0063
            if (r3 == 0) goto L_0x0062
            java.util.List<android.telephony.SubscriptionInfo> r4 = r2.f56411e
            java.lang.Object r4 = r4.get(r5)
            android.telephony.SubscriptionInfo r4 = (android.telephony.SubscriptionInfo) r4
            android.content.Context r5 = r2.requireContext()
            android.graphics.Bitmap r4 = r4.createIconBitmap(r5)
            r3.setImageBitmap(r4)
        L_0x0062:
            return
        L_0x0063:
            android.content.res.Resources r5 = r2.getResources()
            int r0 = net.one97.paytm.common.assets.R.dimen.dimen_26dp
            int r5 = r5.getDimensionPixelSize(r0)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r4 = r0.a((java.lang.String) r4)
            com.squareup.picasso.aa r4 = r4.a((int) r5, (int) r5)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r4.a((android.widget.ImageView) r3)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.be.a(androidx.appcompat.widget.AppCompatImageView, com.paytm.utility.RoboTextView, int):void");
    }
}
