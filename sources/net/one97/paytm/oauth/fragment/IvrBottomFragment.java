package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.c;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.h;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class IvrBottomFragment extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56136a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private List<SubscriptionInfo> f56137b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private int f56138c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56139d;

    private View a(int i2) {
        if (this.f56139d == null) {
            this.f56139d = new HashMap();
        }
        View view = (View) this.f56139d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56139d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56140a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(R.id.design_bottom_sheet);
                if (findViewById2 != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(findViewById2);
                    k.a((Object) from, "BottomSheetBehavior.from(it)");
                    from.setState(3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(b.f56140a);
        }
        return layoutInflater.inflate(net.one97.paytm.oauth.R.layout.fragment_ivr_bottom, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OauthModule.b().sendOpenScreenWithDeviceInfo("/forgot-password-ivr", p.f56796a, requireContext());
        List<SubscriptionInfo> a2 = OAuthUtils.a();
        if (a2 != null) {
            this.f56137b = ab.c(a2);
            String[] strArr = new String[2];
            strArr[0] = "/forgot-password-phone-number";
            strArr[1] = this.f56137b.size() < 2 ? "single" : "dual";
            a("forgot_password_ivr_pop_up_loaded", kotlin.a.k.d(strArr));
            ProgressViewButton progressViewButton = (ProgressViewButton) a(net.one97.paytm.oauth.R.id.btnCall);
            if (progressViewButton != null) {
                aa aaVar = aa.f47921a;
                String string = getString(net.one97.paytm.oauth.R.string.lbl_call_ivr);
                k.a((Object) string, "getString(R.string.lbl_call_ivr)");
                c a3 = OauthModule.a();
                k.a((Object) a3, "OauthModule.getConfig()");
                String format = String.format(string, Arrays.copyOf(new Object[]{a3.a()}, 1));
                k.a((Object) format, "java.lang.String.format(format, *args)");
                progressViewButton.setButtonText(format);
            }
            if (this.f56137b.size() > 1) {
                Bundle arguments = getArguments();
                String string2 = arguments != null ? arguments.getString("login_mobile", "") : null;
                if (TextUtils.isEmpty(string2)) {
                    string2 = com.paytm.utility.b.ab(requireContext());
                }
                RoboTextView roboTextView = (RoboTextView) a(net.one97.paytm.oauth.R.id.lblSelectSim);
                if (roboTextView != null) {
                    roboTextView.setText(getString(net.one97.paytm.oauth.R.string.lbl_select_sim_registered_with_mobile_number, OAuthUtils.e(string2)));
                }
                Group group = (Group) a(net.one97.paytm.oauth.R.id.groupDualSim);
                if (group != null) {
                    h.a(group);
                }
                RoboTextView roboTextView2 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim1);
                if (roboTextView2 != null) {
                    roboTextView2.setText(getString(net.one97.paytm.oauth.R.string.lbl_sim_one, this.f56137b.get(0).getCarrierName()));
                }
                RoboTextView roboTextView3 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim1);
                if (roboTextView3 != null) {
                    roboTextView3.setSelected(true);
                }
                RoboTextView roboTextView4 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim2);
                if (roboTextView4 != null) {
                    roboTextView4.setText(getString(net.one97.paytm.oauth.R.string.lbl_sim_two, this.f56137b.get(1).getCarrierName()));
                }
            } else {
                Group group2 = (Group) a(net.one97.paytm.oauth.R.id.groupDualSim);
                if (group2 != null) {
                    h.b(group2);
                }
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(net.one97.paytm.oauth.R.id.imgCross);
            if (appCompatImageView != null) {
                appCompatImageView.setOnClickListener(this);
            }
            ProgressViewButton progressViewButton2 = (ProgressViewButton) a(net.one97.paytm.oauth.R.id.btnCall);
            if (progressViewButton2 != null) {
                progressViewButton2.setOnClickListener(this);
            }
            RoboTextView roboTextView5 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim1);
            if (roboTextView5 != null) {
                roboTextView5.setOnClickListener(this);
            }
            RoboTextView roboTextView6 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim2);
            if (roboTextView6 != null) {
                roboTextView6.setOnClickListener(this);
            }
            ay ayVar = ay.f56391a;
            FragmentActivity requireActivity = requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            if (ay.a((Activity) requireActivity)) {
                ay ayVar2 = ay.f56391a;
                ay.a(new String[]{"android.permission.CALL_PHONE"}, this, 1);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<android.telephony.SubscriptionInfo>");
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = net.one97.paytm.oauth.R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismissAllowingStateLoss();
            return;
        }
        int i3 = net.one97.paytm.oauth.R.id.btnCall;
        if (valueOf != null && valueOf.intValue() == i3) {
            List arrayList = new ArrayList();
            if (!this.f56137b.isEmpty()) {
                arrayList.add(this.f56138c == 0 ? "sim 1" : "sim 2");
                if (Build.VERSION.SDK_INT >= 22) {
                    arrayList.add(((SubscriptionInfo) (this.f56138c == 0 ? this.f56137b.get(0) : this.f56137b.get(1))).getCarrierName().toString());
                }
            }
            a("ivr_pop_up_clicked", (ArrayList) arrayList);
            Intent intent = new Intent();
            StringBuilder sb = new StringBuilder("tel:");
            c a2 = OauthModule.a();
            k.a((Object) a2, "OauthModule.getConfig()");
            sb.append(a2.a());
            intent.setData(Uri.parse(sb.toString()));
            ay ayVar = ay.f56391a;
            FragmentActivity requireActivity = requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            if (!ay.c((Activity) requireActivity) || Build.VERSION.SDK_INT < 23 || !(!this.f56137b.isEmpty())) {
                intent.setAction("android.intent.action.DIAL");
            } else {
                intent.setAction("android.intent.action.CALL");
                try {
                    intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", new PhoneAccountHandle(new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService"), String.valueOf(this.f56137b.get(this.f56138c).getSubscriptionId())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                intent.addFlags(268435456);
            }
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e3) {
                e3.printStackTrace();
            }
            dismissAllowingStateLoss();
            return;
        }
        int i4 = net.one97.paytm.oauth.R.id.txtSim1;
        if (valueOf != null && valueOf.intValue() == i4) {
            RoboTextView roboTextView = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim1);
            if (roboTextView != null) {
                roboTextView.setSelected(true);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim2);
            if (roboTextView2 != null) {
                roboTextView2.setSelected(false);
            }
            this.f56138c = 0;
            return;
        }
        int i5 = net.one97.paytm.oauth.R.id.txtSim2;
        if (valueOf != null && valueOf.intValue() == i5) {
            RoboTextView roboTextView3 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim2);
            if (roboTextView3 != null) {
                roboTextView3.setSelected(true);
            }
            RoboTextView roboTextView4 = (RoboTextView) a(net.one97.paytm.oauth.R.id.txtSim1);
            if (roboTextView4 != null) {
                roboTextView4.setSelected(false);
            }
            this.f56138c = 1;
        }
    }

    private static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "forgot_password", str, arrayList, (String) null, "/forgot-password-ivr", p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56139d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
