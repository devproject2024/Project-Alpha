package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.oauth.e.b;

public final class bs extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56517a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private b f56518b;

    /* renamed from: c  reason: collision with root package name */
    private String f56519c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56520d;

    public final View a(int i2) {
        if (this.f56520d == null) {
            this.f56520d = new HashMap();
        }
        View view = (View) this.f56520d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56520d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56520d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public bs() {
        this.f56519c = "";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static bs a(Bundle bundle, b bVar) {
            k.c(bVar, "listener");
            bs bsVar = new bs(bVar);
            bsVar.setArguments(bundle);
            return bsVar;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bs(b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56518b = bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_single_sim_mismatch, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("login_mobile")) == null) {
            str = "";
        }
        this.f56519c = str;
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_header);
        if (roboTextView != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.lbl_single_sim_mismatch_header);
            k.a((Object) string, "getString(R.string.lbl_single_sim_mismatch_header)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f56519c}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView.setText(format);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        View a2 = a(R.id.view_update);
        if (a2 != null) {
            a2.setOnClickListener(this);
        }
        View a3 = a(R.id.view_login);
        if (a3 != null) {
            a3.setOnClickListener(this);
        }
        v.a("/login-signup", "login_signup", "single_sim_mismatch_popup_loaded", (ArrayList) null, 24);
    }

    public final void onClick(View view) {
        net.one97.paytm.oauth.utils.k c2;
        OAuthMainActivity oAuthMainActivity = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/login-signup", "login_signup", "single_sim_mismatch_popup_closed", (ArrayList) null, 24);
            b bVar = this.f56518b;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        int i3 = R.id.view_update;
        if (valueOf != null && valueOf.intValue() == i3) {
            v.a("/login-signup", "login_signup", "update_phone_number_clicked", kotlin.a.k.d("single_sim_mismatch"), 16);
            OauthModule.b().checkDeepLinking(getContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
            return;
        }
        int i4 = R.id.view_login;
        if (valueOf != null && valueOf.intValue() == i4) {
            v.a("/login-signup", "login_signup", "login_with_another_mobile_number_clicked", kotlin.a.k.d("single_sim_mismatch"), 16);
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
            b bVar2 = this.f56518b;
            if (bVar2 != null) {
                bVar2.g(bundle);
            }
        }
    }
}
