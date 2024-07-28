package net.one97.paytm.oauth.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.m.p;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.l;
import net.one97.paytm.oauth.models.DoViewResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.ResultInfoRes;
import net.one97.paytm.oauth.models.VerificationInitResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.TerminalPageState;
import net.one97.paytm.oauth.view.MobilePrefixEditText;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class AccountUnblockMobileNumberFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56052a = {y.a((t) new u(y.b(AccountUnblockMobileNumberFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.oauth.g.a f56053b;

    /* renamed from: c  reason: collision with root package name */
    private String f56054c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f56055d;

    /* renamed from: e  reason: collision with root package name */
    private String f56056e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f56057f;

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56062a = new d();

        d() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.f56057f == null) {
            this.f56057f = new HashMap();
        }
        View view = (View) this.f56057f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56057f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56057f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    static final class a<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockMobileNumberFragment f56058a;

        a(AccountUnblockMobileNumberFragment accountUnblockMobileNumberFragment) {
            this.f56058a = accountUnblockMobileNumberFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56058a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountUnblockMobileNumberFragment.a(this.f56058a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountUnblockMobileNumberFragment.a(this.f56058a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockMobileNumberFragment f56059a;

        b(AccountUnblockMobileNumberFragment accountUnblockMobileNumberFragment) {
            this.f56059a = accountUnblockMobileNumberFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56059a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountUnblockMobileNumberFragment.a(this.f56059a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountUnblockMobileNumberFragment.a(this.f56059a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_account_block_enter_number, viewGroup, false);
    }

    public static final class f extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
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
        Editable text;
        super.onActivityCreated(bundle);
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText != null) {
            mobilePrefixEditText.setOnClickListener(this);
        }
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_registered_mobile);
        if (textInputLayout != null) {
            textInputLayout.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        String a2 = ((k) new androidx.navigation.d(y.b(k.class), new f(this)).getValue()).a();
        if (a2 == null) {
            a2 = "";
        }
        this.f56055d = a2;
        ai a3 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.a.class);
        k.a((Object) a3, "ViewModelProviders.of(th…ockViewModel::class.java)");
        this.f56053b = (net.one97.paytm.oauth.g.a) a3;
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_title);
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.lbl_enter_mobile_number_for_unblock));
        }
        if (!TextUtils.isEmpty(this.f56055d)) {
            String str = "+91 " + OAuthUtils.e(this.f56055d);
            MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText2 != null) {
                mobilePrefixEditText2.setText(str);
            }
            MobilePrefixEditText mobilePrefixEditText3 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (!(mobilePrefixEditText3 == null || (text = mobilePrefixEditText3.getText()) == null)) {
                ((MobilePrefixEditText) a(R.id.et_registered_mobile)).setSelection(text.length());
            }
            MobilePrefixEditText mobilePrefixEditText4 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText4 != null) {
                mobilePrefixEditText4.requestFocus();
            }
        }
        MobilePrefixEditText mobilePrefixEditText5 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText5 != null) {
            mobilePrefixEditText5.setTextChangedListener(new e(this));
        }
        if (!TextUtils.isEmpty(this.f56055d)) {
            String str2 = this.f56055d;
            if (str2 == null) {
                str2 = "";
            }
            a(str2);
        }
    }

    public final void onClick(View view) {
        ProgressViewButton progressViewButton;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnProceed;
        if (valueOf != null && valueOf.intValue() == i2 && (progressViewButton = (ProgressViewButton) a(R.id.btnProceed)) != null && !progressViewButton.f56843a) {
            a(b());
        }
    }

    static final class e implements MobilePrefixEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockMobileNumberFragment f56063a;

        e(AccountUnblockMobileNumberFragment accountUnblockMobileNumberFragment) {
            this.f56063a = accountUnblockMobileNumberFragment;
        }

        public final void a(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56063a.a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56063a.a(R.id.til_registered_mobile);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
        }
    }

    private final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setErrorEnabled(true);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout2 != null) {
                textInputLayout2.setError(getString(R.string.empty_mob_no_error));
            }
        } else if (!OAuthUtils.a(str)) {
            TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout3 != null) {
                textInputLayout3.setErrorEnabled(true);
            }
            TextInputLayout textInputLayout4 = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout4 != null) {
                textInputLayout4.setError(getString(R.string.enter_valid_mobile));
            }
        } else {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            b(str);
        }
    }

    private final void b(String str) {
        if (this.f56053b == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.a(str, "ACCOUNT_UNBLOCK_VERIFY").observe(this, new b(this));
    }

    private final void c(String str) {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56053b == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.b(str, "OTP_SMS").observe(this, new a(this));
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockMobileNumberFragment f56060a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56061b;

        c(AccountUnblockMobileNumberFragment accountUnblockMobileNumberFragment, String str) {
            this.f56060a = accountUnblockMobileNumberFragment;
            this.f56061b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AccountUnblockMobileNumberFragment.a(this.f56060a, this.f56061b);
        }
    }

    private final String b() {
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        Editable editable = null;
        if (TextUtils.isEmpty(String.valueOf(mobilePrefixEditText != null ? mobilePrefixEditText.getText() : null))) {
            return "";
        }
        MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText2 != null) {
            editable = mobilePrefixEditText2.getText();
        }
        String replace = new kotlin.m.l("\\s").replace((CharSequence) p.a(String.valueOf(editable), "+91 ", "", false), "");
        if (replace != null) {
            return p.b(replace).toString();
        }
        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    private final void d() {
        l.a b2 = l.b();
        k.a((Object) b2, "AccountUnblockMobileNumb…ionAccountBlockTerminal()");
        b2.c();
        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) b2);
    }

    public static final /* synthetic */ void a(AccountUnblockMobileNumberFragment accountUnblockMobileNumberFragment, IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        if (iJRPaytmDataModel instanceof VerificationInitResModel) {
            VerificationInitResModel verificationInitResModel = (VerificationInitResModel) iJRPaytmDataModel;
            String responseCode = verificationInitResModel.getResponseCode();
            if (responseCode != null) {
                int hashCode = responseCode.hashCode();
                if (hashCode != -1260518837) {
                    if (hashCode != -1258552569) {
                        if (hashCode == -1258492949 && responseCode.equals("BE1426038")) {
                            l.a b2 = l.b();
                            k.a((Object) b2, "AccountUnblockMobileNumb…ionAccountBlockTerminal()");
                            b2.c();
                            b2.a(TerminalPageState.IS_RECENTLY_BLOCKED);
                            androidx.navigation.fragment.a.a(accountUnblockMobileNumberFragment).a((androidx.navigation.l) b2);
                            return;
                        }
                    } else if (responseCode.equals("BE1424021")) {
                        l.a b3 = l.b();
                        k.a((Object) b3, "AccountUnblockMobileNumb…ionAccountBlockTerminal()");
                        b3.c();
                        b3.a(TerminalPageState.IS_ACCOUNT_ACTIVE);
                        androidx.navigation.fragment.a.a(accountUnblockMobileNumberFragment).a((androidx.navigation.l) b3);
                        return;
                    }
                } else if (responseCode.equals("BE1400001")) {
                    String verifierId = verificationInitResModel.getVerifierId();
                    if (verifierId == null) {
                        verifierId = "";
                    }
                    accountUnblockMobileNumberFragment.f56054c = verifierId;
                    accountUnblockMobileNumberFragment.f56056e = verificationInitResModel.getStateCode();
                    accountUnblockMobileNumberFragment.c(accountUnblockMobileNumberFragment.f56054c);
                    return;
                }
            }
            accountUnblockMobileNumberFragment.d();
        } else if (iJRPaytmDataModel instanceof DoViewResModel) {
            DoViewResModel doViewResModel = (DoViewResModel) iJRPaytmDataModel;
            String httpStatus = doViewResModel.getHttpStatus();
            if (httpStatus != null && httpStatus.hashCode() == 49586 && httpStatus.equals("200")) {
                ResultInfoRes resultInfo = doViewResModel.getResultInfo();
                if (resultInfo == null || (str = resultInfo.getResultCode()) == null) {
                    str = "";
                }
                if (str.equals("SUCCESS")) {
                    l.b a2 = l.a();
                    k.a((Object) a2, "AccountUnblockMobileNumb…AccountUnblockVerifyOtp()");
                    a2.a(accountUnblockMobileNumberFragment.f56054c);
                    a2.b(accountUnblockMobileNumberFragment.b());
                    a2.c(accountUnblockMobileNumberFragment.f56056e);
                    androidx.navigation.fragment.a.a(accountUnblockMobileNumberFragment).a((androidx.navigation.l) a2);
                    return;
                }
                accountUnblockMobileNumberFragment.d();
                return;
            }
            accountUnblockMobileNumberFragment.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) "BE1426001") != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0102, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) "BE1426003") != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0104, code lost:
        net.one97.paytm.oauth.d.a.a(r3.requireContext(), r3.getString(net.one97.paytm.oauth.R.string.lbl_could_not_process_request), (android.view.View.OnClickListener) net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment.d.f56062a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0115, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment r3, net.one97.paytm.oauth.models.ErrorModel r4, java.lang.String r5) {
        /*
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = r3
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            com.paytm.network.model.NetworkCustomError r2 = r4.getCustomError()
            boolean r0 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r0, (androidx.fragment.app.Fragment) r1, (com.paytm.network.model.NetworkCustomError) r2)
            if (r0 != 0) goto L_0x0125
            int r0 = r4.getStatus()
            r1 = -1
            if (r0 != r1) goto L_0x003f
            int r4 = net.one97.paytm.oauth.R.string.no_connection
            java.lang.String r4 = r3.getString(r4)
            java.lang.String r0 = "getString(R.string.no_connection)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            int r0 = net.one97.paytm.oauth.R.string.no_internet
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "getString(R.string.no_internet)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r1 = r3.requireContext()
            net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment$c r2 = new net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment$c
            r2.<init>(r3, r5)
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            net.one97.paytm.oauth.utils.OAuthUtils.a(r1, r4, r0, r2)
            return
        L_0x003f:
            com.paytm.network.model.NetworkCustomError r0 = r4.getCustomError()
            boolean r0 = r0 instanceof com.paytm.network.model.NetworkCustomError
            if (r0 == 0) goto L_0x0122
            com.paytm.network.model.NetworkCustomError r0 = r4.getCustomError()
            com.paytm.network.model.NetworkResponse r0 = r0.networkResponse
            byte[] r0 = r0.data
            if (r0 == 0) goto L_0x0121
            java.lang.String r1 = new java.lang.String
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a
            r1.<init>(r0, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x011e
            java.lang.String r1 = new java.lang.String     // Catch:{ JSONException -> 0x011e }
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x011e }
            r1.<init>(r0, r2)     // Catch:{ JSONException -> 0x011e }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011e }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x011e }
            java.lang.String r1 = "responseCode"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x011e }
            if (r5 != 0) goto L_0x0076
            goto L_0x011a
        L_0x0076:
            int r1 = r5.hashCode()     // Catch:{ JSONException -> 0x011e }
            r2 = -2106100499(0xffffffff827774ed, float:-1.818025E-37)
            if (r1 == r2) goto L_0x0081
            goto L_0x011a
        L_0x0081:
            java.lang.String r1 = "oauthUserVerificationInit"
            boolean r5 = r5.equals(r1)     // Catch:{ JSONException -> 0x011e }
            if (r5 == 0) goto L_0x011a
            int r5 = r4.getStatus()     // Catch:{ JSONException -> 0x011e }
            java.lang.Integer r1 = net.one97.paytm.oauth.utils.n.f56788g     // Catch:{ JSONException -> 0x011e }
            if (r1 != 0) goto L_0x0092
            goto L_0x00c3
        L_0x0092:
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x011e }
            if (r5 != r1) goto L_0x00c3
            java.lang.String r5 = "BE1425010"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x011e }
            if (r5 != 0) goto L_0x00a8
            java.lang.String r5 = "BE1425011"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x011e }
            if (r5 == 0) goto L_0x00c3
        L_0x00a8:
            net.one97.paytm.oauth.fragment.l$a r4 = net.one97.paytm.oauth.fragment.l.b()     // Catch:{ JSONException -> 0x011e }
            java.lang.String r5 = "AccountUnblockMobileNumb…ionAccountBlockTerminal()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ JSONException -> 0x011e }
            r4.c()     // Catch:{ JSONException -> 0x011e }
            net.one97.paytm.oauth.utils.TerminalPageState r5 = net.one97.paytm.oauth.utils.TerminalPageState.IS_LIMIT_EXCEED     // Catch:{ JSONException -> 0x011e }
            r4.a(r5)     // Catch:{ JSONException -> 0x011e }
            androidx.navigation.h r5 = androidx.navigation.fragment.a.a(r3)     // Catch:{ JSONException -> 0x011e }
            androidx.navigation.l r4 = (androidx.navigation.l) r4     // Catch:{ JSONException -> 0x011e }
            r5.a((androidx.navigation.l) r4)     // Catch:{ JSONException -> 0x011e }
            return
        L_0x00c3:
            int r5 = r4.getStatus()     // Catch:{ JSONException -> 0x011e }
            java.lang.Integer r1 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x011e }
            if (r1 != 0) goto L_0x00cc
            goto L_0x00d6
        L_0x00cc:
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x011e }
            if (r5 != r1) goto L_0x00d6
            r3.d()     // Catch:{ JSONException -> 0x011e }
            return
        L_0x00d6:
            int r5 = r4.getStatus()     // Catch:{ JSONException -> 0x011e }
            java.lang.Integer r1 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x011e }
            if (r1 != 0) goto L_0x00df
            goto L_0x00ed
        L_0x00df:
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x011e }
            if (r5 != r1) goto L_0x00ed
            java.lang.String r5 = "BE1426001"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x011e }
            if (r5 != 0) goto L_0x0104
        L_0x00ed:
            int r4 = r4.getStatus()     // Catch:{ JSONException -> 0x011e }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56786e     // Catch:{ JSONException -> 0x011e }
            if (r5 != 0) goto L_0x00f6
            goto L_0x0116
        L_0x00f6:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x011e }
            if (r4 != r5) goto L_0x0116
            java.lang.String r4 = "BE1426003"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x011e }
            if (r4 == 0) goto L_0x0116
        L_0x0104:
            android.content.Context r4 = r3.requireContext()     // Catch:{ JSONException -> 0x011e }
            int r5 = net.one97.paytm.oauth.R.string.lbl_could_not_process_request     // Catch:{ JSONException -> 0x011e }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ JSONException -> 0x011e }
            net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment$d r0 = net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment.d.f56062a     // Catch:{ JSONException -> 0x011e }
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0     // Catch:{ JSONException -> 0x011e }
            net.one97.paytm.oauth.d.a.a((android.content.Context) r4, (java.lang.String) r5, (android.view.View.OnClickListener) r0)     // Catch:{ JSONException -> 0x011e }
            return
        L_0x0116:
            r3.d()     // Catch:{ JSONException -> 0x011e }
            return
        L_0x011a:
            r3.d()     // Catch:{ JSONException -> 0x011e }
            return
        L_0x011e:
            r3.d()
        L_0x0121:
            return
        L_0x0122:
            r3.d()
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment.a(net.one97.paytm.oauth.fragment.AccountUnblockMobileNumberFragment, net.one97.paytm.oauth.models.ErrorModel, java.lang.String):void");
    }

    public static final /* synthetic */ void a(AccountUnblockMobileNumberFragment accountUnblockMobileNumberFragment, String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2106100499) {
                if (hashCode == -333255865 && str.equals("oauthDoView")) {
                    accountUnblockMobileNumberFragment.c(accountUnblockMobileNumberFragment.f56054c);
                }
            } else if (str.equals("oauthUserVerificationInit")) {
                accountUnblockMobileNumberFragment.b(accountUnblockMobileNumberFragment.b());
            }
        }
    }
}
