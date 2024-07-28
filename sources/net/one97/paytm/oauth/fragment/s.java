package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.UpdateEmailActivity;
import net.one97.paytm.oauth.g.j;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f56612b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f56613f = "title";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String f56614g = "description";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f56615h = f56615h;

    /* renamed from: a  reason: collision with root package name */
    boolean f56616a;

    /* renamed from: c  reason: collision with root package name */
    private j f56617c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f56618d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f56619e;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f56620i;

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56623a = new d();

        d() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.f56620i == null) {
            this.f56620i = new HashMap();
        }
        View view = (View) this.f56620i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56620i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f56621a;

        b(s sVar) {
            this.f56621a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56621a.a(R.id.btnVerifyEmail);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                String str = "auto_email";
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        ErrorModel errorModel = (ErrorModel) t;
                        s sVar = this.f56621a;
                        k.c(errorModel, "model");
                        if (OAuthUtils.a((Activity) sVar.getActivity(), (Fragment) sVar, errorModel.getCustomError())) {
                            return;
                        }
                        if (errorModel.getStatus() == -1) {
                            String string = sVar.getString(R.string.no_connection);
                            k.a((Object) string, "getString(R.string.no_connection)");
                            String string2 = sVar.getString(R.string.no_internet);
                            k.a((Object) string2, "getString(R.string.no_internet)");
                            OAuthUtils.a(sVar.requireContext(), string, string2, new c(sVar));
                        } else if (errorModel.getCustomError() instanceof NetworkCustomError) {
                            byte[] bArr = errorModel.getCustomError().networkResponse.data;
                            if (bArr != null) {
                                try {
                                    String string3 = new JSONObject(new String(bArr, kotlin.m.d.f47971a)).getString("message");
                                    String[] strArr = new String[3];
                                    if (!sVar.f56616a) {
                                        str = AppConstants.KEY_EMAIL;
                                    }
                                    strArr[0] = str;
                                    k.a((Object) string3, "message");
                                    strArr[1] = string3;
                                    strArr[2] = SDKConstants.KEY_API;
                                    s.a("add_email_clicked", kotlin.a.k.d(strArr));
                                    com.paytm.utility.b.b(sVar.requireContext(), sVar.getString(R.string.oauth_error), string3);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    com.paytm.utility.b.b(sVar.requireContext(), sVar.getString(R.string.oauth_error), sVar.getString(R.string.some_went_wrong));
                                }
                            }
                        } else {
                            String[] strArr2 = new String[3];
                            if (!sVar.f56616a) {
                                str = AppConstants.KEY_EMAIL;
                            }
                            strArr2[0] = str;
                            String string4 = sVar.getString(R.string.some_went_wrong);
                            k.a((Object) string4, "getString(R.string.some_went_wrong)");
                            strArr2[1] = string4;
                            strArr2[2] = SDKConstants.KEY_API;
                            s.a("add_email_clicked", kotlin.a.k.d(strArr2));
                            com.paytm.utility.b.b(sVar.requireContext(), sVar.getString(R.string.oauth_error), sVar.getString(R.string.some_went_wrong));
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                    }
                } else {
                    s sVar2 = this.f56621a;
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
                    if (iJRPaytmDataModel instanceof UpdatePhoneResModel) {
                        UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel;
                        String responseCode = updatePhoneResModel.getResponseCode();
                        if (responseCode != null && responseCode.hashCode() == 1537 && responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                            String[] strArr3 = new String[1];
                            if (!sVar2.f56616a) {
                                str = AppConstants.KEY_EMAIL;
                            }
                            strArr3[0] = str;
                            s.a("add_email_clicked", kotlin.a.k.d(strArr3));
                            Intent intent = new Intent(sVar2.requireContext(), UpdateEmailActivity.class);
                            intent.putExtra(p.f56797b, "/add_email_prompt");
                            AppCompatEditText appCompatEditText = (AppCompatEditText) sVar2.a(R.id.etEmail);
                            intent.putExtra(AppConstants.KEY_EMAIL, String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null));
                            intent.putExtra("stateToken", updatePhoneResModel.getState());
                            sVar2.requireActivity().startActivityForResult(intent, 110);
                            sVar2.dismissAllowingStateLoss();
                            return;
                        }
                        String[] strArr4 = new String[3];
                        if (!sVar2.f56616a) {
                            str = AppConstants.KEY_EMAIL;
                        }
                        strArr4[0] = str;
                        String message = updatePhoneResModel.getMessage();
                        if (message == null) {
                            message = sVar2.getString(R.string.some_went_wrong);
                            k.a((Object) message, "getString(R.string.some_went_wrong)");
                        }
                        strArr4[1] = message;
                        strArr4[2] = SDKConstants.KEY_API;
                        s.a("add_email_clicked", kotlin.a.k.d(strArr4));
                        Context requireContext = sVar2.requireContext();
                        String message2 = updatePhoneResModel.getMessage();
                        if (message2 == null) {
                            message2 = sVar2.getString(R.string.some_went_wrong);
                        }
                        net.one97.paytm.oauth.d.a.a(requireContext, message2, (View.OnClickListener) d.f56623a);
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

        public static s a(Bundle bundle) {
            k.c(bundle, "bundle");
            s sVar = new s();
            sVar.setArguments(bundle);
            return sVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogStyle);
    }

    static final class e implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final e f56624a = new e();

        e() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
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
            dialog.setOnShowListener(e.f56624a);
        }
        ai a2 = am.a((Fragment) this).a(j.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ailViewModel::class.java)");
        this.f56617c = (j) a2;
        return layoutInflater.inflate(R.layout.fragment_dialog_add_email, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        String[] strArr = new String[1];
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("screen_name")) == null) {
            str = "";
        }
        strArr[0] = str;
        a("add_email_popup_loaded", kotlin.a.k.d(strArr));
        boolean isEmpty = TextUtils.isEmpty(com.paytm.utility.b.m(requireContext()));
        Bundle arguments2 = getArguments();
        String str2 = null;
        CharSequence string = arguments2 != null ? arguments2.getString(f56613f) : null;
        if (!TextUtils.isEmpty(string)) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tvHeader);
            if (roboTextView != null) {
                roboTextView.setText(string);
            }
        } else if (isEmpty) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvHeader);
            if (roboTextView2 != null) {
                roboTextView2.setText(getString(R.string.lbl_add_email_to_improve_security));
            }
        } else {
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.tvHeader);
            if (roboTextView3 != null) {
                roboTextView3.setText(getString(R.string.lbl_update_email_id));
            }
        }
        Bundle arguments3 = getArguments();
        CharSequence string2 = arguments3 != null ? arguments3.getString(f56614g) : null;
        if (!TextUtils.isEmpty(string2)) {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.tvDesc1);
            if (roboTextView4 != null) {
                roboTextView4.setText(string2);
            }
        } else if (isEmpty) {
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.tvDesc1);
            if (roboTextView5 != null) {
                roboTextView5.setText(getString(R.string.lbl_add_email_description));
            }
        } else {
            RoboTextView roboTextView6 = (RoboTextView) a(R.id.tvDesc1);
            if (roboTextView6 != null) {
                roboTextView6.setText(getString(R.string.lbl_update_email_description));
            }
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            str2 = arguments4.getString(f56615h);
        }
        if (!TextUtils.isEmpty(str2)) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnVerifyEmail);
            if (progressViewButton != null) {
                progressViewButton.setButtonText(str2);
            }
        } else if (isEmpty) {
            ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnVerifyEmail);
            if (progressViewButton2 != null) {
                progressViewButton2.setButtonText(getString(R.string.lbl_add_email_id));
            }
        } else {
            ProgressViewButton progressViewButton3 = (ProgressViewButton) a(R.id.btnVerifyEmail);
            if (progressViewButton3 != null) {
                progressViewButton3.setButtonText(getString(R.string.lbl_update_email_id));
            }
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton4 = (ProgressViewButton) a(R.id.btnVerifyEmail);
        if (progressViewButton4 != null) {
            progressViewButton4.setOnClickListener(this);
        }
        RoboTextView roboTextView7 = (RoboTextView) a(R.id.tvDoItLater);
        if (roboTextView7 != null) {
            roboTextView7.setOnClickListener(this);
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etEmail);
        if (appCompatEditText != null) {
            appCompatEditText.setOnClickListener(this);
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etEmail);
        if (appCompatEditText2 != null) {
            appCompatEditText2.addTextChangedListener(new f(this));
        }
    }

    public static final class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f56625a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        f(s sVar) {
            this.f56625a = sVar;
        }

        public final void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56625a.a(R.id.tilEmail);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56625a.a(R.id.tilEmail);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!this.f56618d) {
            a("add_email_popup_discarded", new ArrayList());
        }
    }

    public final void onResume() {
        Editable text;
        super.onResume();
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etEmail);
        if (appCompatEditText != null) {
            appCompatEditText.requestFocus();
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etEmail);
        if (appCompatEditText2 != null && (text = appCompatEditText2.getText()) != null) {
            if ((text.length() == 0) && !this.f56619e) {
                OAuthUtils.a((Activity) requireActivity(), (Fragment) this, false);
                a("email_list_popup_loaded", new ArrayList());
            }
        }
    }

    public final void onClick(View view) {
        ProgressViewButton progressViewButton;
        Intent intent = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.tvDoItLater;
            if (valueOf == null || valueOf.intValue() != i3) {
                int i4 = R.id.btnVerifyEmail;
                if (valueOf != null && valueOf.intValue() == i4 && (progressViewButton = (ProgressViewButton) a(R.id.btnVerifyEmail)) != null && !progressViewButton.f56843a) {
                    AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etEmail);
                    k.a((Object) appCompatEditText, "etEmail");
                    if (OAuthUtils.b(String.valueOf(appCompatEditText.getText()))) {
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etEmail);
                        if (appCompatEditText2 != null) {
                            appCompatEditText2.requestFocus();
                        }
                        OAuthUtils.a((Fragment) this);
                        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnVerifyEmail);
                        if (progressViewButton2 != null) {
                            progressViewButton2.c();
                        }
                        d();
                        return;
                    }
                    String string = getString(R.string.err_email_id);
                    k.a((Object) string, "getString(R.string.err_email_id)");
                    a("add_email_clicked", kotlin.a.k.d(AppConstants.KEY_EMAIL, string, AppManagerUtil.EXTEND_PREFIX_DEFAULT));
                    TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilEmail);
                    if (textInputLayout != null) {
                        textInputLayout.setError(string);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.f56618d = false;
        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.etEmail);
        if (appCompatEditText3 != null) {
            appCompatEditText3.requestFocus();
        }
        OAuthUtils.a((Fragment) this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        }
        if (intent != null) {
            intent.setFlags(536870912);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.startActivity(intent);
            }
        }
        dismissAllowingStateLoss();
    }

    private final void d() {
        if (this.f56617c == null) {
            k.a("viewModel");
        }
        j.a(com.paytm.utility.b.ab(requireContext()), "UPDATE_EMAIL").observe(this, new b(this));
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f56622a;

        c(s sVar) {
            this.f56622a = sVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.a(this.f56622a);
        }
    }

    /* access modifiers changed from: package-private */
    public static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "add_email", str, arrayList, (String) null, "/add_email_prompt", p.f56796a);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1094) {
            AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etEmail);
            if (appCompatEditText != null) {
                appCompatEditText.requestFocus();
            }
            if (i3 != -1) {
                OAuthUtils.a((EditText) (AppCompatEditText) a(R.id.etEmail));
                a("nota_selected", new ArrayList());
                a("email_list_popup_dismissed", new ArrayList());
                this.f56619e = true;
            } else if (intent != null) {
                Parcelable parcelableExtra = intent.getParcelableExtra("com.google.android.gms.credentials.Credential");
                if (parcelableExtra != null) {
                    String a2 = ((Credential) parcelableExtra).a();
                    k.a((Object) a2, "credential.id");
                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etEmail);
                    if (appCompatEditText2 != null) {
                        appCompatEditText2.setText(a2);
                    }
                    AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.etEmail);
                    if (appCompatEditText3 != null) {
                        appCompatEditText3.setSelection(a2.length());
                    }
                    a("email_selected", new ArrayList());
                    OAuthUtils.a((Fragment) this);
                    ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnVerifyEmail);
                    if (progressViewButton != null) {
                        progressViewButton.c();
                    }
                    this.f56616a = true;
                    d();
                    return;
                }
                throw new u("null cannot be cast to non-null type com.google.android.gms.auth.api.credentials.Credential");
            }
        }
    }

    public static final /* synthetic */ void a(s sVar) {
        if (sVar.isAdded()) {
            sVar.d();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56620i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
