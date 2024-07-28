package net.one97.paytm.oauth.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.d;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class NumberUpdateSuccessFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56152a = {y.a((t) new u(y.b(NumberUpdateSuccessFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    public static final a f56153b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private String f56154c;

    /* renamed from: d  reason: collision with root package name */
    private String f56155d = "phone_update_logout";

    /* renamed from: e  reason: collision with root package name */
    private String f56156e = "";

    /* renamed from: f  reason: collision with root package name */
    private HashMap f56157f;

    public final View a(int i2) {
        if (this.f56157f == null) {
            this.f56157f = new HashMap();
        }
        View view = (View) this.f56157f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56157f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56157f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_number_update_success, viewGroup, false);
    }

    public static final class b extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.$this_navArgs = fragment;
        }

        public final Bundle invoke() {
            Bundle arguments = this.$this_navArgs.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException("Fragment " + this.$this_navArgs + " has null arguments");
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        g dVar = new d(y.b(ax.class), new b(this));
        this.f56154c = ((ax) dVar.getValue()).a();
        this.f56156e = ((ax) dVar.getValue()).b();
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedLogin);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.lbl_login_with_new_number));
        }
        if (com.paytm.utility.b.r(requireContext())) {
            this.f56155d = "phone_update_login";
        }
        String str = this.f56155d;
        String[] strArr = new String[3];
        strArr[0] = c();
        String str2 = this.f56156e;
        if (str2 == null) {
            str2 = "";
        }
        strArr[1] = str2;
        FragmentActivity requireActivity = requireActivity();
        k.a((Object) requireActivity, "requireActivity()");
        String stringExtra = requireActivity.getIntent().getStringExtra("screen_name");
        k.a((Object) stringExtra, "requireActivity().intent…tStringExtra(SCREEN_NAME)");
        strArr[2] = stringExtra;
        v.a("/phone_update_success", str, "success_page_loaded", kotlin.a.k.d(strArr), 16);
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedLogin);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnProceedLogin;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/phone_update_success", this.f56155d, "login_with_new_mobile_number_clicked", (ArrayList) null, 24);
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            com.paytm.utility.b.n(b2.getApplicationContext(), this.f56154c);
            if (com.paytm.utility.b.r(requireContext())) {
                OauthModule.b().onLogout(requireActivity(), false, (VolleyError) null);
                OauthModule.b().openHomePage(requireContext(), false, "/phone_update_success", true);
            } else {
                Intent intent = new Intent();
                intent.putExtra(p.f56797b, "/phone_update_success");
                requireActivity().setResult(-1, intent);
            }
            requireActivity().finish();
        }
    }
}
