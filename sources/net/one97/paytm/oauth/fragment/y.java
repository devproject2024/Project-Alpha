package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.p;

public final class y extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56672a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private b f56673b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f56674c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56675d;

    public interface b {
        void b();
    }

    private View a(int i2) {
        if (this.f56675d == null) {
            this.f56675d = new HashMap();
        }
        View view = (View) this.f56675d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56675d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public y() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public y(b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56673b = bVar;
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
        setStyle(1, R.style.DialogFragmentStyle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return layoutInflater.inflate(R.layout.fragment_dialog_cancel_login_process, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.f56674c = arguments != null ? arguments.getBoolean("is_new_signup") : false;
        RoboTextView roboTextView = (RoboTextView) a(R.id.tvYes);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvNo);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        a("close_confirm_popup_loaded");
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tvYes;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("close_confirm_yes_clicked");
            b bVar = this.f56673b;
            if (bVar != null) {
                bVar.b();
            }
            dismissAllowingStateLoss();
            return;
        }
        int i3 = R.id.tvNo;
        if (valueOf != null && valueOf.intValue() == i3) {
            a("close_confirm_no_clicked");
            dismissAllowingStateLoss();
        }
    }

    private final void a(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments == null || (str2 = arguments.getString("timer")) == null) {
            str2 = "";
        }
        arrayList.add(str2);
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "login_signup", str, arrayList, this.f56674c ? "signup" : "login", "/login-signup", p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56675d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
