package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.OAuthBaseActivity;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.u;
import net.one97.paytm.oauth.view.PasswordStrengthLayout;
import org.json.JSONObject;

public final class SetNewPasswordFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56173a = {y.a((t) new u(y.b(SetNewPasswordFragment.class), "args", "<v#0>"))};

    /* renamed from: c  reason: collision with root package name */
    public static final a f56174c = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    String f56175b;

    /* renamed from: d  reason: collision with root package name */
    private String f56176d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f56177e = true;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.oauth.g.d f56178f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56179g;

    public final View a(int i2) {
        if (this.f56179g == null) {
            this.f56179g = new HashMap();
        }
        View view = (View) this.f56179g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56179g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56179g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class d extends l implements kotlin.g.a.a<Bundle> {
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

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetNewPasswordFragment f56180a;

        b(SetNewPasswordFragment setNewPasswordFragment) {
            this.f56180a = setNewPasswordFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56180a.a(R.id.loader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        ErrorModel errorModel = (ErrorModel) t;
                        SetNewPasswordFragment setNewPasswordFragment = this.f56180a;
                        k.c(errorModel, "model");
                        if (OAuthUtils.a((Activity) setNewPasswordFragment.getActivity(), (Fragment) setNewPasswordFragment, errorModel.getCustomError())) {
                            return;
                        }
                        if (errorModel.getStatus() == -1) {
                            String string = setNewPasswordFragment.getString(R.string.no_connection);
                            k.a((Object) string, "getString(R.string.no_connection)");
                            String string2 = setNewPasswordFragment.getString(R.string.no_internet);
                            k.a((Object) string2, "getString(R.string.no_internet)");
                            OAuthUtils.a(setNewPasswordFragment.requireContext(), string, string2, new c(setNewPasswordFragment));
                        } else if (errorModel.getCustomError() instanceof NetworkCustomError) {
                            byte[] bArr = errorModel.getCustomError().networkResponse.data;
                            if (bArr != null) {
                                JSONObject jSONObject = new JSONObject(new String(bArr, kotlin.m.d.f47971a));
                                String string3 = jSONObject.getString("message");
                                String string4 = jSONObject.getString("responseCode");
                                int status = errorModel.getStatus();
                                Integer num = n.f56784c;
                                if (num != null && status == num.intValue() && k.a((Object) "BE1423003", (Object) string4)) {
                                    net.one97.paytm.oauth.b b2 = OauthModule.b();
                                    FragmentActivity requireActivity = setNewPasswordFragment.requireActivity();
                                    if (requireActivity != null) {
                                        b2.handleSessionTimeOut((AppCompatActivity) requireActivity, errorModel.getCustomError(), (String) null, (Bundle) null, true, false);
                                        return;
                                    }
                                    throw new kotlin.u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                                }
                                OAuthUtils.a((Activity) setNewPasswordFragment.requireActivity(), string3);
                            }
                        } else {
                            com.paytm.utility.b.b(setNewPasswordFragment.requireContext(), setNewPasswordFragment.getString(R.string.oauth_error), setNewPasswordFragment.getString(R.string.some_went_wrong));
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                    }
                } else {
                    SetNewPasswordFragment setNewPasswordFragment2 = this.f56180a;
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
                    if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
                        SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
                        String responseCode = simplifiedLoginInit.getResponseCode();
                        if (responseCode != null && responseCode.hashCode() == 1537 && responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(setNewPasswordFragment2.requireContext());
                            builder.setCancelable(false);
                            builder.setMessage(R.string.msg_password_changed_from_profile);
                            builder.setPositiveButton(R.string.ok, new f(setNewPasswordFragment2));
                            builder.show();
                            net.one97.paytm.oauth.b b3 = OauthModule.b();
                            k.a((Object) b3, "OauthModule.getOathDataProvider()");
                            com.paytm.utility.b.n(b3.getApplicationContext(), setNewPasswordFragment2.f56175b);
                            return;
                        }
                        com.paytm.utility.b.b(setNewPasswordFragment2.requireContext(), setNewPasswordFragment2.getString(R.string.oauth_error), simplifiedLoginInit.getMessage());
                    }
                }
            }
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
        k.c(layoutInflater, "inflater");
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.d.class);
        k.a((Object) a2, "ViewModelProviders.of(th…PwdViewModel::class.java)");
        this.f56178f = (net.one97.paytm.oauth.g.d) a2;
        return layoutInflater.inflate(R.layout.fragment_set_new_password, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        OauthModule.b().sendOpenScreenWithDeviceInfo("/forgot-password-set-new", p.f56796a, requireContext());
        FragmentActivity requireActivity = requireActivity();
        k.a((Object) requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        k.a((Object) intent, "requireActivity().intent");
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString(p.f56797b, "") : null;
        String[] strArr = new String[1];
        if (string == null) {
            string = "";
        }
        strArr[0] = string;
        a("forgot_password_set_new_loaded", (ArrayList<String>) kotlin.a.k.d(strArr));
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            window.setSoftInputMode(16);
        }
        g dVar = new androidx.navigation.d(y.b(bo.class), new d(this));
        this.f56175b = ((bo) dVar.getValue()).a();
        this.f56176d = ((bo) dVar.getValue()).b();
        RoboTextView roboTextView = (RoboTextView) a(R.id.lblForAccntLinked);
        if (roboTextView != null) {
            aa aaVar = aa.f47921a;
            String string2 = getString(R.string.lbl_for_account_linked_to);
            k.a((Object) string2, "getString(R.string.lbl_for_account_linked_to)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{OAuthUtils.e(this.f56175b)}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView.setText(format);
        }
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilNewPwd);
        if (textInputLayout != null) {
            textInputLayout.setHint(getString(R.string.lbl_enter_new_paytm_password));
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.tilReNewPwd);
        if (textInputLayout2 != null) {
            textInputLayout2.setHint(getString(R.string.lbl_re_enter_new_paytm_password));
        }
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        this.f56177e = net.one97.paytm.oauth.a.p();
        FragmentActivity requireActivity2 = requireActivity();
        if (requireActivity2 != null) {
            ((OAuthBaseActivity) requireActivity2).a((CheckBox) a(R.id.checkboxLogOutAllDevices));
            if (requireActivity() != null) {
                k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                OAuthBaseActivity.a(Boolean.valueOf(net.one97.paytm.oauth.a.p()), (CheckBox) a(R.id.checkboxLogOutAllDevices));
                RoboTextView roboTextView2 = (RoboTextView) a(R.id.btnSave);
                if (roboTextView2 != null) {
                    roboTextView2.setOnClickListener(this);
                }
                CheckBox checkBox = (CheckBox) a(R.id.checkboxLogOutAllDevices);
                if (checkBox != null) {
                    checkBox.setOnClickListener(this);
                }
                AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etNewPwd);
                if (appCompatEditText != null) {
                    appCompatEditText.addTextChangedListener(new e(this));
                    return;
                }
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.activity.OAuthBaseActivity");
        }
        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.activity.OAuthBaseActivity");
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetNewPasswordFragment f56182a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        e(SetNewPasswordFragment setNewPasswordFragment) {
            this.f56182a = setNewPasswordFragment;
        }

        public final void afterTextChanged(Editable editable) {
            PasswordStrengthLayout passwordStrengthLayout = (PasswordStrengthLayout) this.f56182a.a(R.id.layoutPwdStrength);
            if (passwordStrengthLayout != null) {
                passwordStrengthLayout.a(String.valueOf(editable));
            }
        }
    }

    public final void onClick(View view) {
        String str;
        Editable editable = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnSave;
        boolean z = true;
        if (valueOf != null && valueOf.intValue() == i2) {
            AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etNewPwd);
            String valueOf2 = String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null);
            if (valueOf2 != null) {
                String obj = kotlin.m.p.b(valueOf2).toString();
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etReNewPwd);
                String valueOf3 = String.valueOf(appCompatEditText2 != null ? appCompatEditText2.getText() : null);
                if (valueOf3 != null) {
                    String obj2 = kotlin.m.p.b(valueOf3).toString();
                    if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                        str = getString(R.string.fill_all_fields);
                        k.a((Object) str, "getString(R.string.fill_all_fields)");
                    } else {
                        int length = obj.length();
                        u.a aVar = net.one97.paytm.oauth.utils.u.Companion;
                        if (length < net.one97.paytm.oauth.utils.u.REQUIRED_LENGTH) {
                            str = getString(R.string.lbl_error_new_pwd_less_five);
                            k.a((Object) str, "getString(R.string.lbl_error_new_pwd_less_five)");
                        } else if (!k.a((Object) obj, (Object) obj2)) {
                            str = getString(R.string.password_do_not_match);
                            k.a((Object) str, "getString(R.string.password_do_not_match)");
                        } else {
                            str = "";
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        com.paytm.utility.b.b(requireContext(), "", str);
                        a("set_new_password_save_clicked", (ArrayList<String>) kotlin.a.k.d(str));
                        z = false;
                    }
                    if (z) {
                        a("set_new_password_save_clicked", (ArrayList<String>) new ArrayList());
                        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.etNewPwd);
                        if (appCompatEditText3 != null) {
                            editable = appCompatEditText3.getText();
                        }
                        String valueOf4 = String.valueOf(editable);
                        if (valueOf4 != null) {
                            a(kotlin.m.p.b(valueOf4).toString());
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        int i3 = R.id.checkboxLogOutAllDevices;
        if (valueOf != null && valueOf.intValue() == i3) {
            this.f56177e = !this.f56177e;
            CheckBox checkBox = (CheckBox) a(R.id.checkboxLogOutAllDevices);
            k.a((Object) checkBox, "checkboxLogOutAllDevices");
            checkBox.setChecked(this.f56177e);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        OAuthUtils.a((Activity) requireActivity());
        OAuthUtils.a((LottieAnimationView) a(R.id.loader));
        if (this.f56178f == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.d.a(this.f56176d, str, this.f56177e).observe(this, new b(this));
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetNewPasswordFragment f56181a;

        c(SetNewPasswordFragment setNewPasswordFragment) {
            this.f56181a = setNewPasswordFragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            SetNewPasswordFragment setNewPasswordFragment = this.f56181a;
            AppCompatEditText appCompatEditText = (AppCompatEditText) setNewPasswordFragment.a(R.id.etNewPwd);
            String valueOf = String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null);
            if (valueOf != null) {
                setNewPasswordFragment.a(kotlin.m.p.b(valueOf).toString());
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    public static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetNewPasswordFragment f56183a;

        f(SetNewPasswordFragment setNewPasswordFragment) {
            this.f56183a = setNewPasswordFragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            SetNewPasswordFragment.a(this.f56183a);
            this.f56183a.requireActivity().finish();
        }
    }

    private static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "forgot_password", str, arrayList, (String) null, "/forgot-password-set-new", p.f56796a);
    }

    public static final /* synthetic */ void a(SetNewPasswordFragment setNewPasswordFragment) {
        List arrayList = new ArrayList();
        if (setNewPasswordFragment.f56177e) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            if (com.paytm.utility.b.r(b2.getApplicationContext())) {
                o oVar = o.f56791a;
                String str = setNewPasswordFragment.f56175b;
                if (str == null) {
                    str = "";
                }
                o.b(str);
            }
            OauthModule.b().onLogout(setNewPasswordFragment.requireActivity(), false, (VolleyError) null);
            OauthModule.b().openHomePage(setNewPasswordFragment.requireContext(), true, "/forgot-password-set-new", true);
            arrayList.add("logout_all");
        } else {
            net.one97.paytm.oauth.b b3 = OauthModule.b();
            k.a((Object) b3, "OauthModule.getOathDataProvider()");
            if (com.paytm.utility.b.r(b3.getApplicationContext())) {
                OauthModule.b().openHomePage(setNewPasswordFragment.requireContext(), true, "/forgot-password-set-new", false);
            } else {
                OauthModule.b().openHomePage(setNewPasswordFragment.requireContext(), true, "/forgot-password-set-new", true);
            }
            arrayList.add("logout_none");
        }
        a("password_set_success", (ArrayList<String>) (ArrayList) arrayList);
    }
}
