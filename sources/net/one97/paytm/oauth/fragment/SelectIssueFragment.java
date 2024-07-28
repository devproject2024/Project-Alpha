package net.one97.paytm.oauth.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.navigation.l;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.ForgotPasswordContainerActivity;
import net.one97.paytm.oauth.fragment.UpdatePhoneConfirmBottomFragment;
import net.one97.paytm.oauth.fragment.bd;
import net.one97.paytm.oauth.utils.p;

public final class SelectIssueFragment extends v implements View.OnClickListener, UpdatePhoneConfirmBottomFragment.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56171a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f56172b;

    public final View a(int i2) {
        if (this.f56172b == null) {
            this.f56172b = new HashMap();
        }
        View view = (View) this.f56172b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56172b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56172b;
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
        return layoutInflater.inflate(R.layout.fragment_select_issue, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        v.a("/need_help_otp_page", "login_signup", "need_help_otp_page_loaded", kotlin.a.k.d(c()), 16);
        FragmentActivity requireActivity = requireActivity();
        k.a((Object) requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        k.a((Object) intent, "requireActivity().intent");
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString("login_mobile", "") : null;
        RoboTextView roboTextView = (RoboTextView) a(R.id.txtMobileNo);
        if (roboTextView != null) {
            roboTextView.setText(string);
        }
        View a2 = a(R.id.viewForgotPwd);
        if (a2 != null) {
            a2.setOnClickListener(this);
        }
        View a3 = a(R.id.viewUpdateNumber);
        if (a3 != null) {
            a3.setOnClickListener(this);
        }
        View a4 = a(R.id.viewTransferKyc);
        if (a4 != null) {
            a4.setOnClickListener(this);
        }
        View a5 = a(R.id.viewNotListed);
        if (a5 != null) {
            a5.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        q qVar = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.viewForgotPwd;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/need_help_otp_page", "login_signup", "forgot_password_clicked", (ArrayList) null, 24);
            startActivity(new Intent(requireContext(), ForgotPasswordContainerActivity.class));
            return;
        }
        int i3 = R.id.viewUpdateNumber;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.viewTransferKyc;
            if (valueOf == null || valueOf.intValue() != i4) {
                int i5 = R.id.viewNotListed;
                if (valueOf != null && valueOf.intValue() == i5) {
                    v.a("/need_help_otp_page", "login_signup", "other_issue_clicked", (ArrayList) null, 24);
                    OauthModule.b().checkDeepLinking(requireContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
                    return;
                }
                return;
            }
        }
        v.a("/need_help_otp_page", "login_signup", "update_phone_clicked", (ArrayList) null, 24);
        UpdatePhoneConfirmBottomFragment.a aVar = UpdatePhoneConfirmBottomFragment.f56184b;
        UpdatePhoneConfirmBottomFragment updatePhoneConfirmBottomFragment = new UpdatePhoneConfirmBottomFragment();
        updatePhoneConfirmBottomFragment.f56185a = this;
        j fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            qVar = fragmentManager.a();
        }
        if (qVar != null) {
            qVar.a((Fragment) updatePhoneConfirmBottomFragment, UpdatePhoneConfirmBottomFragment.class.getName());
        }
        if (qVar != null) {
            qVar.c();
        }
    }

    public final void a(Bundle bundle) {
        k.c(bundle, "bundle");
        if (!TextUtils.isEmpty(bundle.getString("verifierId", ""))) {
            bd.b b2 = bd.b();
            k.a((Object) b2, "SelectIssueFragmentDirec….navActionSavedCardList()");
            b2.a(bundle.getString("stateToken", ""));
            b2.b(bundle.getString("verifierId", ""));
            b2.c(bundle.getString(p.f56797b, ""));
            androidx.navigation.fragment.a.a(this).a((l) b2);
            return;
        }
        bd.a a2 = bd.a();
        k.a((Object) a2, "SelectIssueFragmentDirec….navActionEmailEnterOtp()");
        a2.a(bundle.getString("meta", ""));
        a2.b(bundle.getString("stateToken", ""));
        a2.c("1");
        a2.d(bundle.getString(p.f56797b, ""));
        androidx.navigation.fragment.a.a(this).a((l) a2);
    }
}
