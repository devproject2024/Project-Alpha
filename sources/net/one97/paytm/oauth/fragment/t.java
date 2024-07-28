package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class t extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56626a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f56627b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f56628c;

    private View a(int i2) {
        if (this.f56628c == null) {
            this.f56628c = new HashMap();
        }
        View view = (View) this.f56628c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56628c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static t a(Bundle bundle) {
            k.c(bundle, "bundle");
            t tVar = new t();
            tVar.setArguments(bundle);
            return tVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dialog_app_lock, viewGroup, false);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.PermissionDialogFragmentStyle);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        net.one97.paytm.oauth.utils.a aVar = net.one97.paytm.oauth.utils.a.f56763a;
        Context requireContext = requireContext();
        k.a((Object) requireContext, "requireContext()");
        this.f56627b = net.one97.paytm.oauth.utils.a.a(requireContext);
        if (this.f56627b) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_description1);
            if (roboTextView != null) {
                roboTextView.setText(getString(R.string.lbl_use_your_existing_phone_lock));
            }
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnActivate);
            if (progressViewButton != null) {
                progressViewButton.setButtonText(getString(R.string.activate_paytm_security_shield));
            }
        } else {
            ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnActivate);
            if (progressViewButton2 != null) {
                progressViewButton2.setButtonText(getString(R.string.lbl_set_device_lock));
            }
        }
        ProgressViewButton progressViewButton3 = (ProgressViewButton) a(R.id.btnActivate);
        if (progressViewButton3 != null) {
            progressViewButton3.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvSkip);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        if (this.f56627b) {
            a("activate_app_lock_popup_loaded");
        } else {
            a("set_app_lock_popup_loaded");
        }
    }

    public final void onClick(View view) {
        Bundle arguments = getArguments();
        int i2 = arguments != null ? arguments.getInt("request_code") : 0;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R.id.btnActivate;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (this.f56627b) {
                a("activate_app_lock_clicked");
                if (Build.VERSION.SDK_INT >= 21) {
                    net.one97.paytm.oauth.utils.a aVar = net.one97.paytm.oauth.utils.a.f56763a;
                    FragmentActivity requireActivity = requireActivity();
                    k.a((Object) requireActivity, "requireActivity()");
                    Activity activity = requireActivity;
                    if (i2 == 0) {
                        i2 = 2002;
                    }
                    net.one97.paytm.oauth.utils.a.a(activity, i2, getString(R.string.activate_paytm_security_shield));
                }
            } else {
                a("set_app_lock_clicked");
                net.one97.paytm.oauth.utils.a aVar2 = net.one97.paytm.oauth.utils.a.f56763a;
                FragmentActivity requireActivity2 = requireActivity();
                k.a((Object) requireActivity2, "requireActivity()");
                Activity activity2 = requireActivity2;
                if (i2 == 0) {
                    i2 = H5RpcPlugin.RpcRequest.H5_APP_ERROR_CODE;
                }
                net.one97.paytm.oauth.utils.a.a(activity2, i2);
            }
            q qVar = q.f56798a;
            q.b(true);
        } else {
            int i4 = R.id.tvSkip;
            if (valueOf != null && valueOf.intValue() == i4) {
                q qVar2 = q.f56798a;
                q.b(false);
                a("do_later_clicked");
                if (i2 > 0) {
                    b b2 = OauthModule.b();
                    k.a((Object) b2, "OauthModule.getOathDataProvider()");
                    androidx.localbroadcastmanager.a.a.a(b2.getApplicationContext()).a(new Intent("net.one97.paytm.action.APP_LOCK_DISCARD"));
                }
            } else {
                return;
            }
        }
        dismissAllowingStateLoss();
    }

    private final void a(String str) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), this.f56627b ? "activate_app_lock" : "set_app_lock", str, (ArrayList<String>) null, (String) null, "", p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56628c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
