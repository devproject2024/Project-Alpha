package net.one97.paytm.oauth.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.m.p;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.d;
import net.one97.paytm.oauth.models.DoViewResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.RenderDataRes;
import net.one97.paytm.oauth.models.VerificationInitResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.TerminalPageState;
import net.one97.paytm.oauth.view.MobilePrefixEditText;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class AccountBlockEnterNumberFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56002a = {y.a((t) new u(y.b(AccountBlockEnterNumberFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.oauth.g.a f56003b;

    /* renamed from: c  reason: collision with root package name */
    private String f56004c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f56005d;

    /* renamed from: e  reason: collision with root package name */
    private String f56006e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f56007f;

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56012a = new d();

        d() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.f56007f == null) {
            this.f56007f = new HashMap();
        }
        View view = (View) this.f56007f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56007f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56007f;
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
        final /* synthetic */ AccountBlockEnterNumberFragment f56008a;

        a(AccountBlockEnterNumberFragment accountBlockEnterNumberFragment) {
            this.f56008a = accountBlockEnterNumberFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56008a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountBlockEnterNumberFragment.a(this.f56008a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountBlockEnterNumberFragment.a(this.f56008a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterNumberFragment f56009a;

        b(AccountBlockEnterNumberFragment accountBlockEnterNumberFragment) {
            this.f56009a = accountBlockEnterNumberFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56009a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountBlockEnterNumberFragment.a(this.f56009a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountBlockEnterNumberFragment.a(this.f56009a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_account_block_enter_number, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        Editable text;
        super.onActivityCreated(bundle);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText != null) {
            mobilePrefixEditText.setOnClickListener(this);
        }
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_registered_mobile);
        if (textInputLayout != null) {
            textInputLayout.setOnClickListener(this);
        }
        this.f56006e = ((c) new androidx.navigation.d(y.b(c.class), new f(this)).getValue()).a();
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ockViewModel::class.java)");
        this.f56003b = (net.one97.paytm.oauth.g.a) a2;
        if (!TextUtils.isEmpty(this.f56006e)) {
            String str = "+91 " + OAuthUtils.e(this.f56006e);
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
        if (!TextUtils.isEmpty(this.f56006e)) {
            String str2 = this.f56006e;
            if (str2 == null) {
                str2 = "";
            }
            a(str2);
        }
    }

    public final void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(b())) {
            OAuthUtils.a((EditText) (MobilePrefixEditText) a(R.id.et_registered_mobile));
        }
    }

    static final class e implements MobilePrefixEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterNumberFragment f56013a;

        e(AccountBlockEnterNumberFragment accountBlockEnterNumberFragment) {
            this.f56013a = accountBlockEnterNumberFragment;
        }

        public final void a(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56013a.a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56013a.a(R.id.til_registered_mobile);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
        }
    }

    private final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setError(getString(R.string.empty_mob_no_error));
            }
        } else if (!OAuthUtils.a(str)) {
            TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout2 != null) {
                textInputLayout2.setError(getString(R.string.enter_valid_mobile));
            }
        } else {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            b(str);
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

    private final void b(String str) {
        if (this.f56003b == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.a(str, "ACCOUNT_BLOCK_VERIFY").observe(this, new b(this));
    }

    private final void c(String str) {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56003b == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.b(str, "passcode").observe(this, new a(this));
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterNumberFragment f56010a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56011b;

        c(AccountBlockEnterNumberFragment accountBlockEnterNumberFragment, String str) {
            this.f56010a = accountBlockEnterNumberFragment;
            this.f56011b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AccountBlockEnterNumberFragment.a(this.f56010a, this.f56011b);
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
        d.b b2 = d.b();
        k.a((Object) b2, "AccountBlockEnterNumberF…ionAccountBlockTerminal()");
        b2.c();
        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) b2);
    }

    public static final /* synthetic */ void a(AccountBlockEnterNumberFragment accountBlockEnterNumberFragment, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof VerificationInitResModel) {
            VerificationInitResModel verificationInitResModel = (VerificationInitResModel) iJRPaytmDataModel;
            String responseCode = verificationInitResModel.getResponseCode();
            if (responseCode != null) {
                int hashCode = responseCode.hashCode();
                if (hashCode != -1260518837) {
                    if (hashCode != -1258552593) {
                        if (hashCode == -1258492986 && responseCode.equals("BE1426022")) {
                            v.a("", "diy_block_logout", "passcode_exists", kotlin.a.k.d("no"), 16);
                        }
                    } else if (responseCode.equals("BE1424018")) {
                        d.b b2 = d.b();
                        k.a((Object) b2, "AccountBlockEnterNumberF…ionAccountBlockTerminal()");
                        b2.c();
                        b2.a(TerminalPageState.IS_ACCOUNT_BLOCKED);
                        androidx.navigation.fragment.a.a(accountBlockEnterNumberFragment).a((androidx.navigation.l) b2);
                        return;
                    }
                } else if (responseCode.equals("BE1400001")) {
                    v.a("", "diy_block_logout", "passcode_exists", kotlin.a.k.d(H5AppHandler.CHECK_VALUE), 16);
                    String verifierId = verificationInitResModel.getVerifierId();
                    if (verifierId == null) {
                        verifierId = "";
                    }
                    accountBlockEnterNumberFragment.f56004c = verifierId;
                    accountBlockEnterNumberFragment.f56005d = verificationInitResModel.getStateCode();
                    String verifierId2 = verificationInitResModel.getVerifierId();
                    if (verifierId2 == null) {
                        verifierId2 = "";
                    }
                    accountBlockEnterNumberFragment.c(verifierId2);
                    return;
                }
            }
            accountBlockEnterNumberFragment.d();
            return;
        } else if (iJRPaytmDataModel instanceof DoViewResModel) {
            DoViewResModel doViewResModel = (DoViewResModel) iJRPaytmDataModel;
            String httpStatus = doViewResModel.getHttpStatus();
            if (httpStatus != null && httpStatus.hashCode() == 49586 && httpStatus.equals("200")) {
                d.a a2 = d.a();
                k.a((Object) a2, "AccountBlockEnterNumberF…countBlockEnterPasscode()");
                a2.a(doViewResModel.getVerifyId());
                RenderDataRes renderData = doViewResModel.getRenderData();
                String str = null;
                a2.b(renderData != null ? renderData.getAccount_encrypt_pubkey() : null);
                RenderDataRes renderData2 = doViewResModel.getRenderData();
                if (renderData2 != null) {
                    str = renderData2.getAccount_encrypt_salt();
                }
                a2.c(str);
                a2.d(accountBlockEnterNumberFragment.f56005d);
                a2.e(accountBlockEnterNumberFragment.b());
                androidx.navigation.fragment.a.a(accountBlockEnterNumberFragment).a((androidx.navigation.l) a2);
                return;
            }
        } else {
            return;
        }
        accountBlockEnterNumberFragment.d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c0, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) "BE1426001") != false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) "BE1426003") != false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        net.one97.paytm.oauth.d.a.a(r3.requireContext(), r3.getString(net.one97.paytm.oauth.R.string.lbl_could_not_process_request), (android.view.View.OnClickListener) net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment.d.f56012a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ea, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment r3, net.one97.paytm.oauth.models.ErrorModel r4, java.lang.String r5) {
        /*
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = r3
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            com.paytm.network.model.NetworkCustomError r2 = r4.getCustomError()
            boolean r0 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r0, (androidx.fragment.app.Fragment) r1, (com.paytm.network.model.NetworkCustomError) r2)
            if (r0 != 0) goto L_0x0132
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
            net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment$c r2 = new net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment$c
            r2.<init>(r3, r5)
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            net.one97.paytm.oauth.utils.OAuthUtils.a(r1, r4, r0, r2)
            return
        L_0x003f:
            com.paytm.network.model.NetworkCustomError r0 = r4.getCustomError()
            boolean r0 = r0 instanceof com.paytm.network.model.NetworkCustomError
            if (r0 == 0) goto L_0x012f
            com.paytm.network.model.NetworkCustomError r0 = r4.getCustomError()
            com.paytm.network.model.NetworkResponse r0 = r0.networkResponse
            byte[] r0 = r0.data
            if (r0 == 0) goto L_0x012e
            java.lang.String r1 = new java.lang.String
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a
            r1.<init>(r0, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x012b
            java.lang.String r1 = new java.lang.String     // Catch:{ JSONException -> 0x012b }
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x012b }
            r1.<init>(r0, r2)     // Catch:{ JSONException -> 0x012b }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x012b }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x012b }
            java.lang.String r1 = "responseCode"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x012b }
            if (r5 != 0) goto L_0x0076
            goto L_0x0127
        L_0x0076:
            int r1 = r5.hashCode()     // Catch:{ JSONException -> 0x012b }
            r2 = -2106100499(0xffffffff827774ed, float:-1.818025E-37)
            if (r1 == r2) goto L_0x0081
            goto L_0x0127
        L_0x0081:
            java.lang.String r1 = "oauthUserVerificationInit"
            boolean r5 = r5.equals(r1)     // Catch:{ JSONException -> 0x012b }
            if (r5 == 0) goto L_0x0127
            int r5 = r4.getStatus()     // Catch:{ JSONException -> 0x012b }
            java.lang.Integer r1 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x012b }
            java.lang.String r2 = "AccountBlockEnterNumberF…ionAccountBlockTerminal()"
            if (r1 != 0) goto L_0x0094
            goto L_0x00ab
        L_0x0094:
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x012b }
            if (r5 != r1) goto L_0x00ab
            net.one97.paytm.oauth.fragment.d$b r4 = net.one97.paytm.oauth.fragment.d.b()     // Catch:{ JSONException -> 0x012b }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)     // Catch:{ JSONException -> 0x012b }
            androidx.navigation.h r5 = androidx.navigation.fragment.a.a(r3)     // Catch:{ JSONException -> 0x012b }
            androidx.navigation.l r4 = (androidx.navigation.l) r4     // Catch:{ JSONException -> 0x012b }
            r5.a((androidx.navigation.l) r4)     // Catch:{ JSONException -> 0x012b }
            return
        L_0x00ab:
            int r5 = r4.getStatus()     // Catch:{ JSONException -> 0x012b }
            java.lang.Integer r1 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x012b }
            if (r1 != 0) goto L_0x00b4
            goto L_0x00c2
        L_0x00b4:
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x012b }
            if (r5 != r1) goto L_0x00c2
            java.lang.String r5 = "BE1426001"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x012b }
            if (r5 != 0) goto L_0x00d9
        L_0x00c2:
            int r5 = r4.getStatus()     // Catch:{ JSONException -> 0x012b }
            java.lang.Integer r1 = net.one97.paytm.oauth.utils.n.f56786e     // Catch:{ JSONException -> 0x012b }
            if (r1 != 0) goto L_0x00cb
            goto L_0x00eb
        L_0x00cb:
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x012b }
            if (r5 != r1) goto L_0x00eb
            java.lang.String r5 = "BE1426003"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x012b }
            if (r5 == 0) goto L_0x00eb
        L_0x00d9:
            android.content.Context r4 = r3.requireContext()     // Catch:{ JSONException -> 0x012b }
            int r5 = net.one97.paytm.oauth.R.string.lbl_could_not_process_request     // Catch:{ JSONException -> 0x012b }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ JSONException -> 0x012b }
            net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment$d r0 = net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment.d.f56012a     // Catch:{ JSONException -> 0x012b }
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0     // Catch:{ JSONException -> 0x012b }
            net.one97.paytm.oauth.d.a.a((android.content.Context) r4, (java.lang.String) r5, (android.view.View.OnClickListener) r0)     // Catch:{ JSONException -> 0x012b }
            return
        L_0x00eb:
            int r4 = r4.getStatus()     // Catch:{ JSONException -> 0x012b }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56788g     // Catch:{ JSONException -> 0x012b }
            if (r5 != 0) goto L_0x00f4
            goto L_0x0123
        L_0x00f4:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x012b }
            if (r4 != r5) goto L_0x0123
            java.lang.String r4 = "BE1425012"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x012b }
            if (r4 != 0) goto L_0x010a
            java.lang.String r4 = "BE1425013"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x012b }
            if (r4 == 0) goto L_0x0123
        L_0x010a:
            net.one97.paytm.oauth.fragment.d$b r4 = net.one97.paytm.oauth.fragment.d.b()     // Catch:{ JSONException -> 0x012b }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)     // Catch:{ JSONException -> 0x012b }
            r4.c()     // Catch:{ JSONException -> 0x012b }
            net.one97.paytm.oauth.utils.TerminalPageState r5 = net.one97.paytm.oauth.utils.TerminalPageState.IS_LIMIT_EXCEED     // Catch:{ JSONException -> 0x012b }
            r4.a(r5)     // Catch:{ JSONException -> 0x012b }
            androidx.navigation.h r5 = androidx.navigation.fragment.a.a(r3)     // Catch:{ JSONException -> 0x012b }
            androidx.navigation.l r4 = (androidx.navigation.l) r4     // Catch:{ JSONException -> 0x012b }
            r5.a((androidx.navigation.l) r4)     // Catch:{ JSONException -> 0x012b }
            return
        L_0x0123:
            r3.d()     // Catch:{ JSONException -> 0x012b }
            return
        L_0x0127:
            r3.d()     // Catch:{ JSONException -> 0x012b }
            return
        L_0x012b:
            r3.d()
        L_0x012e:
            return
        L_0x012f:
            r3.d()
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment.a(net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment, net.one97.paytm.oauth.models.ErrorModel, java.lang.String):void");
    }

    public static final /* synthetic */ void a(AccountBlockEnterNumberFragment accountBlockEnterNumberFragment, String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2106100499) {
                if (hashCode == -333255865 && str.equals("oauthDoView")) {
                    accountBlockEnterNumberFragment.c(accountBlockEnterNumberFragment.f56004c);
                }
            } else if (str.equals("oauthUserVerificationInit")) {
                accountBlockEnterNumberFragment.b(accountBlockEnterNumberFragment.b());
            }
        }
    }
}
