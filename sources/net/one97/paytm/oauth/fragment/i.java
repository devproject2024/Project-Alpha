package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.p;

public final class i extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56596a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f56597b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f56598c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56599d;

    private View a(int i2) {
        if (this.f56599d == null) {
            this.f56599d = new HashMap();
        }
        View view = (View) this.f56599d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56599d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.PermissionDialogFragmentStyle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_fragment_account_block_security, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("message")) == null) {
            str = getString(R.string.some_went_wrong);
            k.a((Object) str, "getString(R.string.some_went_wrong)");
        }
        this.f56597b = str;
        Bundle arguments2 = getArguments();
        this.f56598c = arguments2 != null ? arguments2.getBoolean("IS_SHOW_RAISE_REQUEST", false) : false;
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_message);
        if (roboTextView != null) {
            roboTextView.setText(this.f56597b);
        }
        if (this.f56598c) {
            a("block_popup_loaded", (ArrayList<String>) kotlin.a.k.d("", this.f56597b));
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_cancel);
            if (roboTextView2 != null) {
                roboTextView2.setVisibility(0);
            }
            AppCompatButton appCompatButton = (AppCompatButton) a(R.id.btnOk);
            k.a((Object) appCompatButton, "btnOk");
            appCompatButton.setText(getString(R.string.lbl_unblock_account));
        }
        AppCompatButton appCompatButton2 = (AppCompatButton) a(R.id.btnOk);
        if (appCompatButton2 != null) {
            appCompatButton2.setOnClickListener(this);
        }
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_cancel);
        if (roboTextView3 != null) {
            roboTextView3.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnOk;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.tv_cancel;
            if (valueOf != null && valueOf.intValue() == i3) {
                a("cancel_clicked", (ArrayList<String>) new ArrayList());
                dismissAllowingStateLoss();
            }
        } else if (this.f56598c) {
            a("unblock_account_clicked", (ArrayList<String>) new ArrayList());
            dismissAllowingStateLoss();
            OauthModule.b().checkDeepLinking(requireContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
        } else {
            dismissAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(requireContext(), "login_signup", str, arrayList, (String) null, (String) null, p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56599d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
