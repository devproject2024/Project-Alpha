package net.one97.paytm.oauth.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.navigation.d;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class AccountUnblockSuccessFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56079a = {y.a((t) new u(y.b(AccountUnblockSuccessFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private String f56080b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.oauth.c.a f56081c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56082d;

    public final View a(int i2) {
        if (this.f56082d == null) {
            this.f56082d = new HashMap();
        }
        View view = (View) this.f56082d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56082d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56082d;
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
        this.f56081c = (net.one97.paytm.oauth.c.a) context;
    }

    public final void onDetach() {
        super.onDetach();
        this.f56081c = null;
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

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f56080b = ((o) new d(y.b(o.class), new a(this)).getValue()).a();
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_title);
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.lbl_account_unblocked));
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_title);
        if (roboTextView2 != null) {
            roboTextView2.setGravity(17);
        }
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_description);
        if (roboTextView3 != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.lbl_account_unblocked_description);
            k.a((Object) string, "getString(R.string.lbl_a…nt_unblocked_description)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f56080b}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView3.setText(format);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imageView);
        if (appCompatImageView != null) {
            appCompatImageView.setImageResource(R.drawable.ic_account_unblocked_successfully);
        }
        ((ProgressViewButton) a(R.id.btnOk)).setButtonText(getString(R.string.lbl_proceed_to_login));
        net.one97.paytm.oauth.c.a aVar = this.f56081c;
        if (aVar != null) {
            aVar.a();
        }
        ((ProgressViewButton) a(R.id.btnOk)).setOnClickListener(this);
        v.a("/unblock_success", "diy_unblock", "unblock_success_page_loaded", (ArrayList) null, 24);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnOk;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/unblock_success", "diy_unblock", "proceed_to_login_clicked", (ArrayList) null, 24);
            OauthModule.b().signOutAndLogin(requireActivity(), true, OAuthUtils.b.SESSION_TIME_OUT);
        }
    }
}
