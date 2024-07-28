package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.navigation.l;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.af;
import net.one97.paytm.oauth.g.k;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.MobilePrefixEditText;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;
import org.json.JSONObject;

public final class EnterNewNumberFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56098a = {y.a((t) new u(y.b(EnterNewNumberFragment.class), "args", "<v#0>"))};

    /* renamed from: d  reason: collision with root package name */
    public static final a f56099d = new a((byte) 0);
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public String f56100b = "phone_update_logout";

    /* renamed from: c  reason: collision with root package name */
    String f56101c = "";

    /* renamed from: e  reason: collision with root package name */
    private k f56102e;

    /* renamed from: f  reason: collision with root package name */
    private String f56103f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56104g;

    public final View a(int i2) {
        if (this.f56104g == null) {
            this.f56104g = new HashMap();
        }
        View view = (View) this.f56104g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56104g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56104g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterNewNumberFragment f56105a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56106b;

        b(EnterNewNumberFragment enterNewNumberFragment, String str) {
            this.f56105a = enterNewNumberFragment;
            this.f56106b = str;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56105a.a(R.id.btnProceedSecurely);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                String str = "";
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        ErrorModel errorModel = (ErrorModel) t;
                        EnterNewNumberFragment enterNewNumberFragment = this.f56105a;
                        kotlin.g.b.k.c(errorModel, "model");
                        if (OAuthUtils.a((Activity) enterNewNumberFragment.getActivity(), (Fragment) enterNewNumberFragment, errorModel.getCustomError())) {
                            return;
                        }
                        if (errorModel.getStatus() == -1) {
                            String string = enterNewNumberFragment.getString(R.string.no_connection);
                            kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                            String string2 = enterNewNumberFragment.getString(R.string.no_internet);
                            kotlin.g.b.k.a((Object) string2, "getString(R.string.no_internet)");
                            OAuthUtils.a(enterNewNumberFragment.requireContext(), string, string2, new c(enterNewNumberFragment));
                        } else if (errorModel.getCustomError() instanceof NetworkCustomError) {
                            byte[] bArr = errorModel.getCustomError().networkResponse.data;
                            if (bArr != null) {
                                String string3 = new JSONObject(new String(bArr, kotlin.m.d.f47971a)).getString("message");
                                String str2 = enterNewNumberFragment.f56100b;
                                String[] strArr = new String[4];
                                strArr[0] = "mobile_number";
                                if (string3 != null) {
                                    str = string3;
                                }
                                strArr[1] = str;
                                strArr[2] = SDKConstants.KEY_API;
                                strArr[3] = String.valueOf(errorModel.getStatus());
                                v.a("/new_phone_number", str2, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr), 16);
                                kotlin.g.b.k.a((Object) string3, "message");
                                enterNewNumberFragment.a(string3);
                            }
                        } else {
                            com.paytm.utility.b.b(enterNewNumberFragment.requireContext(), enterNewNumberFragment.getString(R.string.oauth_error), enterNewNumberFragment.getString(R.string.some_went_wrong));
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                    }
                } else {
                    EnterNewNumberFragment enterNewNumberFragment2 = this.f56105a;
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
                    String str3 = this.f56106b;
                    kotlin.g.b.k.c(str3, "mobileNo");
                    if (iJRPaytmDataModel instanceof UpdatePhoneResModel) {
                        UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel;
                        String responseCode = updatePhoneResModel.getResponseCode();
                        if (responseCode != null && responseCode.hashCode() == 1539 && responseCode.equals("03")) {
                            af.a a2 = af.a();
                            kotlin.g.b.k.a((Object) a2, "EnterNewNumberFragmentDi…tions.navActionEnterOtp()");
                            a2.a(str3);
                            String state = updatePhoneResModel.getState();
                            if (state == null) {
                                state = str;
                            }
                            a2.c(state);
                            a2.b("/new_phone_number");
                            a2.d(enterNewNumberFragment2.f56101c);
                            androidx.navigation.fragment.a.a(enterNewNumberFragment2).a((l) a2);
                            v.a("/new_phone_number", enterNewNumberFragment2.f56100b, Events.Action.PROCEED_CLICKED, kotlin.a.k.d("mobile_number"), 16);
                            return;
                        }
                        String str4 = enterNewNumberFragment2.f56100b;
                        String[] strArr2 = new String[4];
                        strArr2[0] = "mobile_number";
                        String message = updatePhoneResModel.getMessage();
                        if (message == null) {
                            message = str;
                        }
                        strArr2[1] = message;
                        strArr2[2] = SDKConstants.KEY_API;
                        String responseCode2 = updatePhoneResModel.getResponseCode();
                        if (responseCode2 == null) {
                            responseCode2 = str;
                        }
                        strArr2[3] = responseCode2;
                        v.a("/new_phone_number", str4, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr2), 16);
                        String message2 = updatePhoneResModel.getMessage();
                        if (message2 == null) {
                            message2 = enterNewNumberFragment2.getString(R.string.some_went_wrong);
                            kotlin.g.b.k.a((Object) message2, "getString(R.string.some_went_wrong)");
                        }
                        enterNewNumberFragment2.a(message2);
                    }
                }
            }
        }
    }

    public static final class d extends kotlin.g.b.l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
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

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        ai a2 = am.a((Fragment) this).a(k.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…oneViewModel::class.java)");
        this.f56102e = (k) a2;
        return layoutInflater.inflate(R.layout.fragment_enter_new_number, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (com.paytm.utility.b.r(requireContext())) {
            this.f56100b = "phone_update_login";
        }
        v.a("/new_phone_number", this.f56100b, "new_phone_number_page_loaded", kotlin.a.k.d(c()), 16);
        kotlin.g dVar = new androidx.navigation.d(y.b(ae.class), new d(this));
        this.f56103f = ((ae) dVar.getValue()).a();
        this.f56101c = ((ae) dVar.getValue()).b();
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.etMobileNo);
        if (mobilePrefixEditText != null) {
            mobilePrefixEditText.setTextChangedListener(new e(this));
        }
        MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.etMobileNo);
        if (mobilePrefixEditText2 != null) {
            mobilePrefixEditText2.setOnEditorActionListener(new f(this));
        }
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilMobileNo);
        if (textInputLayout != null) {
            textInputLayout.setHint(getString(R.string.lbl_new_mobile_number));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.lbl_proceed_to_verify));
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
    }

    static final class e implements MobilePrefixEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterNewNumberFragment f56108a;

        e(EnterNewNumberFragment enterNewNumberFragment) {
            this.f56108a = enterNewNumberFragment;
        }

        public final void a(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56108a.a(R.id.tilMobileNo);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56108a.a(R.id.tilMobileNo);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
            if (editable.length() == 15) {
                v.a("/new_phone_number", this.f56108a.f56100b, "mobile_number_entered", (ArrayList) null, 24);
            }
        }
    }

    static final class f implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterNewNumberFragment f56109a;

        f(EnterNewNumberFragment enterNewNumberFragment) {
            this.f56109a = enterNewNumberFragment;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            this.f56109a.b();
            return true;
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnProceedSecurely;
        if (valueOf != null && valueOf.intValue() == i2) {
            b();
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton == null || !progressViewButton.f56843a) {
            String d2 = d();
            if (OAuthUtils.a(d2)) {
                TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilMobileNo);
                kotlin.g.b.k.a((Object) textInputLayout, "tilMobileNo");
                textInputLayout.setErrorEnabled(false);
                TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.tilMobileNo);
                kotlin.g.b.k.a((Object) textInputLayout2, "tilMobileNo");
                textInputLayout2.setError((CharSequence) null);
                b(d2);
                return;
            }
            TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.tilMobileNo);
            kotlin.g.b.k.a((Object) textInputLayout3, "tilMobileNo");
            textInputLayout3.setErrorEnabled(true);
            TextInputLayout textInputLayout4 = (TextInputLayout) a(R.id.tilMobileNo);
            kotlin.g.b.k.a((Object) textInputLayout4, "tilMobileNo");
            textInputLayout4.setError(getString(R.string.msg_invalid_mobile));
            String str = this.f56100b;
            String string = getString(R.string.msg_invalid_mobile);
            kotlin.g.b.k.a((Object) string, "getString(R.string.msg_invalid_mobile)");
            v.a("/new_phone_number", str, Events.Action.PROCEED_CLICKED, kotlin.a.k.d("mobile_number", string, AppManagerUtil.EXTEND_PREFIX_DEFAULT), 16);
        }
    }

    private final void b(String str) {
        OAuthUtils.a((Activity) requireActivity());
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56102e == null) {
            kotlin.g.b.k.a("viewModel");
        }
        k.b(this.f56103f, str).observe(this, new b(this, str));
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterNewNumberFragment f56107a;

        c(EnterNewNumberFragment enterNewNumberFragment) {
            this.f56107a = enterNewNumberFragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56107a.b();
        }
    }

    private final String d() {
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.etMobileNo);
        kotlin.g.b.k.a((Object) mobilePrefixEditText, "etMobileNo");
        if (TextUtils.isEmpty(String.valueOf(mobilePrefixEditText.getText()))) {
            return "";
        }
        MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.etMobileNo);
        return new kotlin.m.l("\\s+").replace((CharSequence) p.a(String.valueOf(mobilePrefixEditText2 != null ? mobilePrefixEditText2.getText() : null), "+91 ", "", false), "");
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        net.one97.paytm.oauth.d.a aVar = new net.one97.paytm.oauth.d.a(requireContext());
        aVar.setTitle((CharSequence) null);
        aVar.setCancelable(false);
        aVar.a(str);
        aVar.a(-3, (CharSequence) getString(R.string.ok), (View.OnClickListener) new g(this, aVar));
        aVar.show();
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterNewNumberFragment f56110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.oauth.d.a f56111b;

        g(EnterNewNumberFragment enterNewNumberFragment, net.one97.paytm.oauth.d.a aVar) {
            this.f56110a = enterNewNumberFragment;
            this.f56111b = aVar;
        }

        public final void onClick(View view) {
            this.f56111b.dismiss();
            this.f56110a.requireActivity().setResult(-1);
            this.f56110a.requireActivity().finish();
        }
    }
}
