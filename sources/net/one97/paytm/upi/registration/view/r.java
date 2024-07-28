package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.appsflyer.internal.referrer.Payload;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.q;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class r extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f69034a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f69035b = UpiConstants.ARG_BANK_LIST;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f69036c = "status";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f69037d = "vpa";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<BankAccountDetails.BankAccount> f69038e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private int f69039f = -1;

    /* renamed from: g  reason: collision with root package name */
    private final int f69040g = 10;

    /* renamed from: h  reason: collision with root package name */
    private String f69041h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f69042i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable(this.f69035b) : null;
            if (!(serializable instanceof ArrayList)) {
                serializable = null;
            }
            ArrayList<BankAccountDetails.BankAccount> arrayList = (ArrayList) serializable;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f69038e = arrayList;
            Bundle arguments2 = getArguments();
            this.f69039f = arguments2 != null ? arguments2.getInt(this.f69036c) : -1;
            Bundle arguments3 = getArguments();
            if (arguments3 == null || (str = arguments3.getString(this.f69037d)) == null) {
                str = "";
            }
            this.f69041h = str;
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f69045a;

        d(r rVar) {
            this.f69045a = rVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f69045a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        k.c(layoutInflater2, "inflater");
        View inflate = layoutInflater2.inflate(R.layout.fragment_sign_up_status, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.back_to_home_bt);
        if (findViewById != null) {
            ((Button) findViewById).setOnClickListener(new d(this));
            ((RelativeLayout) inflate.findViewById(R.id.rl_money_transfer)).setOnClickListener(new e(this));
            ((RelativeLayout) inflate.findViewById(R.id.rl_explore)).setOnClickListener(new f(this));
            ((ImageView) inflate.findViewById(R.id.iv_back)).setOnClickListener(new g(this));
            ((RelativeLayout) inflate.findViewById(R.id.rl_recharge)).setOnClickListener(new h(this));
            k.a((Object) inflate, "view");
            int i2 = this.f69039f;
            if (i2 == 0) {
                CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "congratulation_screen_landing", "false", "", "", "/bhim-upi/signup/congratulations", "wallet");
                View findViewById2 = inflate.findViewById(R.id.paytm_square);
                k.a((Object) findViewById2, "view.findViewById<ImageView>(R.id.paytm_square)");
                ((ImageView) findViewById2).setVisibility(0);
                View findViewById3 = inflate.findViewById(R.id.paytm_trust_tv);
                k.a((Object) findViewById3, "view.findViewById<TextView>(R.id.paytm_trust_tv)");
                ((TextView) findViewById3).setVisibility(0);
                View findViewById4 = inflate.findViewById(R.id.rl_money_transfer);
                k.a((Object) findViewById4, "view.findViewById<Relati…>(R.id.rl_money_transfer)");
                ((RelativeLayout) findViewById4).setVisibility(8);
                View findViewById5 = inflate.findViewById(R.id.error_layout);
                k.a((Object) findViewById5, "view.findViewById<Relati…ayout>(R.id.error_layout)");
                ((RelativeLayout) findViewById5).setVisibility(0);
                View findViewById6 = inflate.findViewById(R.id.tv_error_header);
                k.a((Object) findViewById6, "view.findViewById<TextView>(R.id.tv_error_header)");
                ((TextView) findViewById6).setText(getString(R.string.upi_bank_could_not_be_added));
                View findViewById7 = inflate.findViewById(R.id.tv_error_desc);
                k.a((Object) findViewById7, "view.findViewById<TextView>(R.id.tv_error_desc)");
                ((TextView) findViewById7).setText(getString(R.string.upi_signup_common_error));
                View findViewById8 = inflate.findViewById(R.id.tv_action);
                k.a((Object) findViewById8, "view.findViewById<TextView>(R.id.tv_action)");
                ((TextView) findViewById8).setVisibility(8);
            } else if (i2 == 1) {
                CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "congratulation_screen_landing", "true", "", "", "/bhim-upi/signup/congratulations", "wallet");
                q a2 = getChildFragmentManager().a();
                int i3 = R.id.invite_container;
                i a3 = i.a();
                k.a((Object) a3, "PaytmUpiSdk.getInstance()");
                net.one97.paytm.upi.h c2 = a3.c();
                k.a((Object) c2, "PaytmUpiSdk.getInstance().onLoadActivityListener");
                a2.a(i3, c2.d(), "").c();
                View findViewById9 = inflate.findViewById(R.id.rl_money_transfer);
                k.a((Object) findViewById9, "view.findViewById<Relati…>(R.id.rl_money_transfer)");
                ((RelativeLayout) findViewById9).setVisibility(8);
                View findViewById10 = inflate.findViewById(R.id.error_layout);
                k.a((Object) findViewById10, "view.findViewById<Relati…ayout>(R.id.error_layout)");
                ((RelativeLayout) findViewById10).setVisibility(0);
                View findViewById11 = inflate.findViewById(R.id.tv_error_header);
                k.a((Object) findViewById11, "view.findViewById<TextView>(R.id.tv_error_header)");
                ((TextView) findViewById11).setText(getString(R.string.upi_set_pin_header));
                View findViewById12 = inflate.findViewById(R.id.tv_error_desc);
                k.a((Object) findViewById12, "view.findViewById<TextView>(R.id.tv_error_desc)");
                ((TextView) findViewById12).setText(getString(R.string.upi_signup_set_mpin_desc));
                View findViewById13 = inflate.findViewById(R.id.tv_action);
                k.a((Object) findViewById13, "view.findViewById<TextView>(R.id.tv_action)");
                ((TextView) findViewById13).setText(getString(R.string.set_upi_pin));
                ((TextView) inflate.findViewById(R.id.tv_action)).setOnClickListener(new c(this));
            } else if (i2 == 3) {
                CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "congratulation_screen_landing", "true", "", "", "/bhim-upi/signup/congratulations", "wallet");
                q a4 = getChildFragmentManager().a();
                int i4 = R.id.invite_container;
                i a5 = i.a();
                k.a((Object) a5, "PaytmUpiSdk.getInstance()");
                net.one97.paytm.upi.h c3 = a5.c();
                k.a((Object) c3, "PaytmUpiSdk.getInstance().onLoadActivityListener");
                a4.a(i4, c3.d(), "").c();
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "true", "", "", "/upi_onb_congrats", "wallet");
            if (getActivity() != null) {
                if (getActivity() == null) {
                    k.a();
                }
                if (getActivity() == null) {
                    k.a();
                }
                net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null)).c(new b(), "", "");
            }
            return inflate;
        }
        throw new u("null cannot be cast to non-null type android.widget.Button");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f69046a;

        e(r rVar) {
            this.f69046a = rVar;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f69046a.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "congratulations_screen_money_transfer", "", "", "", "/bhim-upi/signup/congratulations", "wallet");
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            String a3 = a2.c().a();
            i a4 = i.a();
            k.a((Object) a4, "PaytmUpiSdk.getInstance()");
            a4.c().a((Activity) this.f69046a.getActivity(), a3);
            FragmentActivity activity = this.f69046a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f69047a;

        f(r rVar) {
            this.f69047a = rVar;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f69047a.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "congratulations_screen_explore_services", "", "", "", "/bhim-upi/signup/congratulations", "wallet");
            FragmentActivity activity = this.f69047a.getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity2 = this.f69047a.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f69048a;

        g(r rVar) {
            this.f69048a = rVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f69048a.getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity2 = this.f69048a.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f69049a;

        h(r rVar) {
            this.f69049a = rVar;
        }

        public final void onClick(View view) {
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            net.one97.paytm.upi.h c2 = a2.c();
            k.a((Object) c2, "PaytmUpiSdk.getInstance().onLoadActivityListener");
            String b2 = c2.b();
            if (this.f69049a.getActivity() != null) {
                CJRSendGTMTag.sendNewCustomGTMEvents(this.f69049a.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "congratulations_screen_recharge", "", "", "", "/bhim-upi/signup/congratulations", "wallet");
                i a3 = i.a();
                k.a((Object) a3, "PaytmUpiSdk.getInstance()");
                a3.c().a((Activity) this.f69049a.getActivity(), b2);
                FragmentActivity activity = this.f69049a.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    public static final class b implements a.C1389a {
        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
        }

        b() {
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f69043a;

        c(r rVar) {
            this.f69043a = rVar;
        }

        public final void onClick(View view) {
            if (!this.f69043a.f69038e.isEmpty()) {
                if (this.f69043a.f69038e.size() == 1) {
                    r rVar = this.f69043a;
                    Object obj = rVar.f69038e.get(0);
                    k.a(obj, "bankList.get(0)");
                    rVar.a((BankAccountDetails.BankAccount) obj);
                } else {
                    q.a aVar = q.f69021a;
                    q a2 = q.a.a(this.f69043a.f69038e, new q.b(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ c f69044a;

                        {
                            this.f69044a = r1;
                        }

                        public final void a() {
                            FragmentActivity activity = this.f69044a.f69043a.getActivity();
                            if (activity != null) {
                                activity.setResult(-1);
                            }
                            FragmentActivity activity2 = this.f69044a.f69043a.getActivity();
                            if (activity2 != null) {
                                activity2.finish();
                            }
                        }

                        public final void a(BankAccountDetails.BankAccount bankAccount) {
                            k.c(bankAccount, "bankAccountDetails");
                            this.f69044a.f69043a.a(bankAccount);
                        }
                    });
                    j childFragmentManager = this.f69043a.getChildFragmentManager();
                    k.a((Object) childFragmentManager, "childFragmentManager");
                    a2.show(childFragmentManager, r.class.getName());
                }
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f69043a.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "congratulations_screen_set_pin", "", "", "", "/bhim-upi/signup/congratulations", "wallet");
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        Intent intent = new Intent(getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bankAccount);
        String str = this.f69041h;
        if (str == null) {
            k.a("vpa");
        }
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, str).setBankAccountList(arrayList).build());
        intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, true);
        intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal());
        startActivityForResult(intent, this.f69040g);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        Intent intent2 = intent;
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f69040g) {
            if (i3 == -1) {
                CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "mpin_set_success_onboarding", intent2 != null ? intent2.getStringExtra(UpiConstants.EXTRA_SELECTED_BANK) : null, "", "", "/bhim-upi/signup/congratulations", "wallet");
            } else {
                CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "mpin_set_failed_onboarding", "", "", "", "/bhim-upi/signup/congratulations", "wallet");
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f69042i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
