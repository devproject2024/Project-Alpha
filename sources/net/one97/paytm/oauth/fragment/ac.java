package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.oauth.e.b;

public final class ac extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56296a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private b f56297b;

    /* renamed from: c  reason: collision with root package name */
    private String f56298c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56299d;

    public final View a(int i2) {
        if (this.f56299d == null) {
            this.f56299d = new HashMap();
        }
        View view = (View) this.f56299d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56299d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56299d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public ac() {
        this.f56298c = "dual_sim_mismatch";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ac a(Bundle bundle, b bVar) {
            k.c(bVar, "listener");
            ac acVar = new ac(bVar);
            acVar.setArguments(bundle);
            return acVar;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ac(b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56297b = bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dont_have_sim, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean("is_from_select_sim_card")) {
            this.f56298c = "sim_selection";
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        View a2 = a(R.id.view_login);
        if (a2 != null) {
            a2.setOnClickListener(this);
        }
        View a3 = a(R.id.view_update);
        if (a3 != null) {
            a3.setOnClickListener(this);
        }
        v.a("/login-signup", "login_signup", "dont_have_sim_popup_loaded", kotlin.a.k.d(this.f56298c), 16);
    }

    public final void onClick(View view) {
        net.one97.paytm.oauth.utils.k c2;
        OAuthMainActivity oAuthMainActivity = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/login-signup", "login_signup", "dont_have_sim_popup_closed", kotlin.a.k.d(this.f56298c), 16);
            b bVar = this.f56297b;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        int i3 = R.id.view_update;
        if (valueOf != null && valueOf.intValue() == i3) {
            v.a("/login-signup", "login_signup", "update_phone_number_clicked", kotlin.a.k.d(this.f56298c), 16);
            OauthModule.b().checkDeepLinking(getContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
            return;
        }
        int i4 = R.id.view_login;
        if (valueOf != null && valueOf.intValue() == i4) {
            v.a("/login-signup", "login_signup", "login_with_another_mobile_number_clicked", kotlin.a.k.d(this.f56298c), 16);
            Bundle bundle = new Bundle(getArguments());
            bundle.putBoolean("clear_mobile_number", true);
            FragmentActivity activity = getActivity();
            if (activity instanceof OAuthMainActivity) {
                oAuthMainActivity = activity;
            }
            OAuthMainActivity oAuthMainActivity2 = oAuthMainActivity;
            if (!(oAuthMainActivity2 == null || (c2 = oAuthMainActivity2.c()) == null)) {
                c2.a(Boolean.TRUE);
            }
            b bVar2 = this.f56297b;
            if (bVar2 != null) {
                bVar2.g(bundle);
            }
        }
    }
}
