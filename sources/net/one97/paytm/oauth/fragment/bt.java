package net.one97.paytm.oauth.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.alipay.mobile.nebula.util.H5Utils;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.e.g;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.h;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class bt extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56521a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.oauth.e.b f56522b;

    /* renamed from: c  reason: collision with root package name */
    private List<SubscriptionInfo> f56523c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f56524d;

    /* renamed from: e  reason: collision with root package name */
    private String f56525e;

    /* renamed from: f  reason: collision with root package name */
    private int f56526f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56527g;

    public final View a(int i2) {
        if (this.f56527g == null) {
            this.f56527g = new HashMap();
        }
        View view = (View) this.f56527g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56527g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56527g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public bt() {
        this.f56523c = new ArrayList();
        this.f56525e = "";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bt(net.one97.paytm.oauth.e.b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56522b = bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static bt a(Bundle bundle, net.one97.paytm.oauth.e.b bVar) {
            k.c(bVar, "listener");
            bt btVar = new bt(bVar);
            btVar.setArguments(bundle);
            return btVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_sms_sending_failed, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        List<SubscriptionInfo> list;
        List<SubscriptionInfo> list2;
        String str;
        String str2;
        String str3;
        ProgressViewButton progressViewButton;
        ArrayList parcelableArrayList;
        ArrayList parcelableArrayList2;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (parcelableArrayList2 = arguments.getParcelableArrayList("simInfoList")) == null) {
            list = new ArrayList<>();
        } else {
            list = parcelableArrayList2;
        }
        this.f56523c = list;
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnLoginWithOtp);
        if (progressViewButton2 != null) {
            progressViewButton2.setButtonText(getString(R.string.lbl_login_with_otp));
        }
        ProgressViewButton progressViewButton3 = (ProgressViewButton) a(R.id.btnLoginWithOtp);
        if (progressViewButton3 != null) {
            progressViewButton3.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.btnTryWithSms);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (parcelableArrayList = arguments2.getParcelableArrayList("simInfoList")) == null) {
            list2 = new ArrayList<>();
        } else {
            list2 = parcelableArrayList;
        }
        this.f56523c = list2;
        Bundle arguments3 = getArguments();
        int i2 = 0;
        this.f56524d = arguments3 != null ? arguments3.getBoolean("is_new_signup") : false;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = arguments4.getString(Item.KEY_REASON)) == null) {
            str = H5Utils.NETWORK_TYPE_UNKNOWN;
        }
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str2 = arguments5.getString("login_mobile")) == null) {
            str2 = "";
        }
        this.f56525e = str2;
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (str3 = arguments6.getString("iccid")) == null) {
            str3 = "";
        }
        this.f56526f = OAuthUtils.a(str3, this.f56523c);
        a("/login-signup", "login_signup", "sms_send_failed_popup_loaded", (ArrayList<String>) kotlin.a.k.d(SDKConstants.UNKNOWN, str, d()), this.f56524d ? "signup" : "login");
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        String str4 = this.f56525e;
        if (Build.VERSION.SDK_INT >= 22) {
            i2 = this.f56523c.get(this.f56526f).getSimSlotIndex();
        }
        b2.logHawEyeEvent(new net.one97.paytm.oauth.models.a("sms_send_failed_popup_loaded", "/login-signup", str4, str, i2 == 0 ? "sim 1" : "sim 2", 0, 32));
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        boolean r = net.one97.paytm.oauth.a.r();
        net.one97.paytm.oauth.a.a();
        boolean q = net.one97.paytm.oauth.a.q();
        b3.logHawEyeEvent(new net.one97.paytm.oauth.models.a((!r || !q) ? (r || !q) ? (!r || q) ? (r || q) ? "default" : "parallel_and_without_receipt" : "sequential_and_without_receipt" : "parallel_and_check_receipt" : "sequential_and_check_receipt", d(), this.f56525e, str, "verification_failed", 0, 32));
        Context context = getContext();
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        if (!OAuthUtils.b(context, net.one97.paytm.oauth.a.n()) && (progressViewButton = (ProgressViewButton) a(R.id.btnLoginWithOtp)) != null) {
            h.b(progressViewButton);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnLoginWithOtp;
        String str = "signup";
        if (valueOf != null && valueOf.intValue() == i2) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnLoginWithOtp);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            Bundle bundle = new Bundle(getArguments());
            bundle.putString(p.f56797b, "send_sms_failed_error_retry");
            bundle.putString("device_binding_flow", "otp");
            net.one97.paytm.oauth.e.b bVar = this.f56522b;
            if (bVar != null) {
                bVar.a(bundle, new b(this));
            }
            ArrayList arrayList = new ArrayList();
            if (!this.f56524d) {
                str = "login";
            }
            a("/login-signup", "login_signup", "sms_send_failed_login_otp_clicked", (ArrayList<String>) arrayList, str);
            return;
        }
        int i3 = R.id.btnTryWithSms;
        if (valueOf != null && valueOf.intValue() == i3) {
            ArrayList arrayList2 = new ArrayList();
            if (!this.f56524d) {
                str = "login";
            }
            a("/login-signup", "login_signup", "sms_send_failed_retry_clicked", (ArrayList<String>) arrayList2, str);
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            k.a((Object) arguments, "arguments ?: Bundle()");
            arguments.putString("device_binding_flow", "sms");
            if (b()) {
                net.one97.paytm.oauth.e.b bVar2 = this.f56522b;
                if (bVar2 != null) {
                    bVar2.a(arguments);
                    return;
                }
                return;
            }
            arguments.putString(p.f56797b, "send_sms_failed_error_retry");
            net.one97.paytm.oauth.e.b bVar3 = this.f56522b;
            if (bVar3 != null) {
                bVar3.e(arguments);
                return;
            }
            return;
        }
        int i4 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i4) {
            ArrayList arrayList3 = new ArrayList();
            if (!this.f56524d) {
                str = "login";
            }
            a("/login-signup", "login_signup", "sms_send_failed_popup_closed", (ArrayList<String>) arrayList3, str);
            net.one97.paytm.oauth.e.b bVar4 = this.f56522b;
            if (bVar4 != null) {
                bVar4.b();
            }
        }
    }

    public static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bt f56528a;

        b(bt btVar) {
            this.f56528a = btVar;
        }

        public final void a() {
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56528a.a(R.id.btnLoginWithOtp);
            if (progressViewButton != null) {
                progressViewButton.d();
            }
        }
    }

    private final boolean b() {
        return this.f56523c.size() > 1;
    }

    private final String d() {
        return b() ? "dual_sim" : "single_sim";
    }
}
