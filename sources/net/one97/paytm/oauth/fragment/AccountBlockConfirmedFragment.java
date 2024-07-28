package net.one97.paytm.oauth.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.d;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.m.p;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class AccountBlockConfirmedFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f55997a = {y.a((t) new u(y.b(AccountBlockConfirmedFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.oauth.c.a f55998b;

    /* renamed from: c  reason: collision with root package name */
    private String f55999c = "";

    /* renamed from: d  reason: collision with root package name */
    private boolean f56000d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f56001e;

    public final View a(int i2) {
        if (this.f56001e == null) {
            this.f56001e = new HashMap();
        }
        View view = (View) this.f56001e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56001e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56001e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_account_block_confirmed, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f55998b = (net.one97.paytm.oauth.c.a) context;
    }

    public static final class a extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
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

    public final void onDetach() {
        super.onDetach();
        this.f55998b = null;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnOk);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        d dVar = new d(y.b(b.class), new a(this));
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_title);
        if (roboTextView != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.lbl_paytm_account_blocked);
            k.a((Object) string, "getString(R.string.lbl_paytm_account_blocked)");
            Object[] objArr = new Object[1];
            g gVar = dVar;
            objArr[0] = TextUtils.isEmpty(((b) gVar.getValue()).b()) ? b.ab(requireContext()) : ((b) gVar.getValue()).b();
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView.setText(format);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_description);
        if (roboTextView2 != null) {
            roboTextView2.setText(b());
        }
        net.one97.paytm.oauth.c.a aVar = this.f55998b;
        if (aVar != null) {
            aVar.a();
        }
        g gVar2 = dVar;
        this.f56000d = ((b) gVar2.getValue()).a();
        this.f55999c = ((b) gVar2.getValue()).a() ? "diy_block_logout" : "diy_block_login";
        v.a("/diy_block_success", this.f55999c, "block_success_page_loaded", (ArrayList) null, 24);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnOk;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/diy_block_success", this.f55999c, "goto_homepage_clicked", (ArrayList) null, 24);
            if (this.f56000d) {
                OauthModule.b().openHomePage(requireContext(), false, "", false);
            } else {
                OauthModule.b().signOutAndLogin(requireActivity(), true, OAuthUtils.b.DEFAULT);
            }
        }
    }

    private final SpannableString b() {
        String string = getString(R.string.lbl_desc_to_unblock_account);
        k.a((Object) string, "getString(R.string.lbl_desc_to_unblock_account)");
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        String string2 = getString(R.string.customer_care_number);
        k.a((Object) string2, "getString(R.string.customer_care_number)");
        int a2 = p.a(charSequence, string2, 0, false, 6);
        try {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), a2, string2.length() + a2, 33);
        } catch (IndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
        return spannableString;
    }
}
