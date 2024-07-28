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

public final class bu extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56529a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.oauth.e.b f56530b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f56531c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f56532d;

    /* renamed from: e  reason: collision with root package name */
    private List<SubscriptionInfo> f56533e;

    /* renamed from: f  reason: collision with root package name */
    private String f56534f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56535g;

    public final View a(int i2) {
        if (this.f56535g == null) {
            this.f56535g = new HashMap();
        }
        View view = (View) this.f56535g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56535g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56535g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public bu() {
        this.f56533e = new ArrayList();
        this.f56534f = "";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bu(net.one97.paytm.oauth.e.b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56530b = bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static bu a(Bundle bundle, net.one97.paytm.oauth.e.b bVar) {
            k.c(bVar, "listener");
            bu buVar = new bu(bVar);
            buVar.setArguments(bundle);
            return buVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_verification_failed, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        List<SubscriptionInfo> list;
        String str;
        Bundle arguments;
        Bundle arguments2;
        ArrayList parcelableArrayList;
        super.onActivityCreated(bundle);
        Bundle arguments3 = getArguments();
        this.f56531c = arguments3 != null ? arguments3.getBoolean("intervene") : false;
        if (this.f56531c) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_description);
            k.a((Object) roboTextView, "tv_description");
            roboTextView.setText(getString(R.string.lbl_intervene_verification_failed));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnRetry);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.retry));
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnRetry);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        Bundle arguments4 = getArguments();
        this.f56532d = arguments4 != null ? arguments4.getBoolean("is_new_signup") : false;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (parcelableArrayList = arguments5.getParcelableArrayList("simInfoList")) == null) {
            list = new ArrayList<>();
        } else {
            list = parcelableArrayList;
        }
        this.f56533e = list;
        if (!this.f56531c ? (arguments = getArguments()) == null || (str = arguments.getString("gaLabel")) == null : (arguments2 = getArguments()) == null || (str = arguments2.getString("timer")) == null) {
            str = "";
        }
        this.f56534f = str;
        a("/login-signup", "login_signup", this.f56531c ? "app_switch_error_popup_loaded" : "technical_error_popup_loaded", (ArrayList<String>) kotlin.a.k.d(this.f56534f), this.f56532d ? "signup" : "login");
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnRetry;
        String str = "signup";
        if (valueOf != null && valueOf.intValue() == i2) {
            String str2 = this.f56531c ? "app_switch_error_retry_clicked" : "technical_error_retry_clicked";
            ArrayList d2 = kotlin.a.k.d(this.f56534f);
            if (!this.f56532d) {
                str = "login";
            }
            a("/login-signup", "login_signup", str2, (ArrayList<String>) d2, str);
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnRetry);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            if (this.f56531c) {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    arguments.putString(p.f56797b, "post_app_switch_error_retry");
                }
            } else if (this.f56533e.size() > 1) {
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    arguments2.putString(p.f56797b, "post_ver_dual_sim_mismatch_error_retry");
                }
            } else {
                Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    arguments3.putString(p.f56797b, "post_ver_single_sim_mismatch_error_retry");
                }
            }
            net.one97.paytm.oauth.e.b bVar = this.f56530b;
            if (bVar != null) {
                bVar.a(new Bundle(getArguments()), new b(this));
                return;
            }
            return;
        }
        int i3 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i3) {
            String str3 = this.f56531c ? "app_switch_error_popup_closed" : "technical_error_popup_closed";
            ArrayList d3 = kotlin.a.k.d(this.f56534f);
            if (!this.f56532d) {
                str = "login";
            }
            a("/login-signup", "login_signup", str3, (ArrayList<String>) d3, str);
            net.one97.paytm.oauth.e.b bVar2 = this.f56530b;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    public static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bu f56536a;

        b(bu buVar) {
            this.f56536a = buVar;
        }

        public final void a() {
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56536a.a(R.id.btnRetry);
            if (progressViewButton != null) {
                progressViewButton.d();
            }
        }
    }
}
