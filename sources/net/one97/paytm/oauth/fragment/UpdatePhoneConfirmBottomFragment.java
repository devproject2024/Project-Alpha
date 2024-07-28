package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.u;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.UpdatePhoneNumberActivity;
import net.one97.paytm.oauth.g.k;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.models.VerificationResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;
import org.json.JSONException;
import org.json.JSONObject;

public final class UpdatePhoneConfirmBottomFragment extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f56184b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    b f56185a;

    /* renamed from: c  reason: collision with root package name */
    private k f56186c;

    /* renamed from: d  reason: collision with root package name */
    private String f56187d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f56188e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f56189f;

    /* renamed from: g  reason: collision with root package name */
    private final String f56190g = "UpdatePhoneConfirmBottomFragment";

    /* renamed from: h  reason: collision with root package name */
    private HashMap f56191h;

    public interface b {
        void a(Bundle bundle);
    }

    public final View a(int i2) {
        if (this.f56191h == null) {
            this.f56191h = new HashMap();
        }
        View view = (View) this.f56191h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56191h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpdatePhoneConfirmBottomFragment f56192a;

        c(UpdatePhoneConfirmBottomFragment updatePhoneConfirmBottomFragment) {
            this.f56192a = updatePhoneConfirmBottomFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56192a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56192a.a((ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56192a.a((IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpdatePhoneConfirmBottomFragment f56193a;

        d(UpdatePhoneConfirmBottomFragment updatePhoneConfirmBottomFragment) {
            this.f56193a = updatePhoneConfirmBottomFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56193a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56193a.a((ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56193a.a((IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpdatePhoneConfirmBottomFragment f56194a;

        e(UpdatePhoneConfirmBottomFragment updatePhoneConfirmBottomFragment) {
            this.f56194a = updatePhoneConfirmBottomFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56194a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56194a.a((ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56194a.a((IJRPaytmDataModel) eVar.f52603b);
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

    static final class g implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final g f56197a = new g();

        g() {
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
                    kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from(it)");
                    from.setState(3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(g.f56197a);
        }
        this.f56189f = com.paytm.utility.b.r(requireContext());
        FragmentActivity requireActivity = requireActivity();
        kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        kotlin.g.b.k.a((Object) intent, "requireActivity().intent");
        Bundle extras = intent.getExtras();
        this.f56187d = extras != null ? extras.getString("stateToken", "") : null;
        ai a2 = am.a((Fragment) this).a(k.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…oneViewModel::class.java)");
        this.f56186c = (k) a2;
        return layoutInflater.inflate(R.layout.fragment_update_phone_confirm, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a("upi_popup_loaded", (ArrayList<String>) new ArrayList());
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.lbl_confirm_and_update_number));
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.btnCancel);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        this.f56188e = true;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnConfirm;
        if (valueOf != null && valueOf.intValue() == i2) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
            if (progressViewButton != null && progressViewButton.f56843a) {
                return;
            }
            if (this.f56189f) {
                a();
                return;
            }
            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
            if (net.one97.paytm.oauth.a.e()) {
                c();
                return;
            }
            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
            if (net.one97.paytm.oauth.a.i()) {
                b();
                return;
            }
            String string = getString(R.string.lbl_could_not_verify_you);
            kotlin.g.b.k.a((Object) string, "getString(R.string.lbl_could_not_verify_you)");
            a(string, true);
            return;
        }
        int i3 = R.id.btnCancel;
        if (valueOf != null && valueOf.intValue() == i3) {
            a("cancel_clicked", (ArrayList<String>) new ArrayList());
            dismissAllowingStateLoss();
        }
    }

    public final void onStop() {
        super.onStop();
        if (!this.f56188e) {
            a("upi_popup_discarded", (ArrayList<String>) new ArrayList());
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        if (isAdded()) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            if (this.f56186c == null) {
                kotlin.g.b.k.a("viewModel");
            }
            k.a(com.paytm.utility.b.ab(requireContext()), "UPDATE_PHONE").observe(this, new d(this));
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56186c == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String str = this.f56187d;
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
        k.a(str, "1", b2.getSSOToken()).observe(this, new c(this));
    }

    /* access modifiers changed from: private */
    public final void c() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56186c == null) {
            kotlin.g.b.k.a("viewModel");
        }
        k.d(this.f56187d, "DIY_PHONE_UPDATE").observe(this, new e(this));
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof UpdatePhoneResModel) {
            UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel;
            String responseCode = updatePhoneResModel.getResponseCode();
            if (responseCode != null) {
                int hashCode = responseCode.hashCode();
                if (hashCode != -321998554) {
                    if (hashCode == 1537 && responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        if (this.f56189f) {
                            a("continue_clicked", (ArrayList<String>) new ArrayList());
                            Intent intent = new Intent(requireContext(), UpdatePhoneNumberActivity.class);
                            intent.putExtra("mode", "2");
                            intent.putExtra("stateToken", updatePhoneResModel.getState());
                            intent.putExtra(p.f56797b, "/update_profile");
                            intent.putExtra("screen_name", "profile");
                            startActivity(intent);
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putString("stateToken", updatePhoneResModel.getState());
                            bundle.putString("meta", updatePhoneResModel.getMeta());
                            bundle.putString(p.f56797b, "/upi_popup");
                            b bVar = this.f56185a;
                            if (bVar != null) {
                                bVar.a(bundle);
                            }
                            a("continue_clicked", (ArrayList<String>) kotlin.a.k.d("email_present"));
                        }
                        dismissAllowingStateLoss();
                        return;
                    }
                } else if (responseCode.equals("PU_DIY_01")) {
                    a("continue_clicked", (ArrayList<String>) kotlin.a.k.d("no_verification"));
                    String message = updatePhoneResModel.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    a(message, true);
                    return;
                }
            }
            String message2 = updatePhoneResModel.getMessage();
            if (message2 == null) {
                message2 = getString(R.string.some_went_wrong);
                kotlin.g.b.k.a((Object) message2, "getString(R.string.some_went_wrong)");
            }
            a(message2, false);
        } else if (iJRPaytmDataModel instanceof VerificationResModel) {
            VerificationResModel verificationResModel = (VerificationResModel) iJRPaytmDataModel;
            String responseCode2 = verificationResModel.getResponseCode();
            if (responseCode2 != null && responseCode2.hashCode() == -1260518837 && responseCode2.equals("BE1400001")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("stateToken", verificationResModel.getStateCode());
                bundle2.putString("verifierId", verificationResModel.getVerifierId());
                bundle2.putString(p.f56797b, "/upi_popup");
                b bVar2 = this.f56185a;
                if (bVar2 != null) {
                    bVar2.a(bundle2);
                }
                a("continue_clicked", (ArrayList<String>) kotlin.a.k.d("saved_cards_present"));
                dismissAllowingStateLoss();
                return;
            }
            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
            if (net.one97.paytm.oauth.a.i()) {
                b();
                return;
            }
            String string = getString(R.string.lbl_could_not_verify_you);
            kotlin.g.b.k.a((Object) string, "getString(R.string.lbl_could_not_verify_you)");
            a(string, true);
        }
    }

    public final void a(ErrorModel errorModel, String str) {
        kotlin.g.b.k.c(errorModel, "model");
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, errorModel.getCustomError())) {
            if (errorModel.getStatus() == -1) {
                String string = getString(R.string.no_connection);
                kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                String string2 = getString(R.string.no_internet);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.no_internet)");
                OAuthUtils.a(requireContext(), string, string2, new f(this, str));
            } else if (errorModel.getCustomError() instanceof NetworkCustomError) {
                byte[] bArr = errorModel.getCustomError().networkResponse.data;
                if (bArr == null) {
                    return;
                }
                if (!TextUtils.isEmpty(new String(bArr, kotlin.m.d.f47971a))) {
                    try {
                        String string3 = new JSONObject(new String(bArr, kotlin.m.d.f47971a)).getString("message");
                        kotlin.g.b.k.a((Object) string3, "message");
                        a(string3, false);
                    } catch (JSONException e2) {
                        q.b(e2.getMessage());
                    }
                } else {
                    NetworkCustomError customError = errorModel.getCustomError();
                    kotlin.g.b.k.a((Object) customError, "model.customError");
                    if (!TextUtils.isEmpty(customError.getAlertMessage())) {
                        Context requireContext = requireContext();
                        String string4 = getString(R.string.oauth_error);
                        NetworkCustomError customError2 = errorModel.getCustomError();
                        kotlin.g.b.k.a((Object) customError2, "model.customError");
                        com.paytm.utility.b.b(requireContext, string4, customError2.getAlertMessage());
                    }
                }
            } else {
                com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), getString(R.string.some_went_wrong));
            }
        }
    }

    static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpdatePhoneConfirmBottomFragment f56195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56196b;

        f(UpdatePhoneConfirmBottomFragment updatePhoneConfirmBottomFragment, String str) {
            this.f56195a = updatePhoneConfirmBottomFragment;
            this.f56196b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            String str = this.f56196b;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 10476425) {
                    if (hashCode != 11948129) {
                        if (hashCode == 78540418 && str.equals("oauthVerificationInit")) {
                            this.f56195a.c();
                        }
                    } else if (str.equals("sendOtpV4")) {
                        this.f56195a.b();
                    }
                } else if (str.equals("oauthSendOtpV3")) {
                    this.f56195a.a();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, ArrayList<String> arrayList) {
        String str2 = this.f56189f ? "phone_update_login" : "phone_update_logout";
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), str2, str, arrayList, (String) null, "/upi_popup", p.f56796a);
    }

    private final void a(String str, boolean z) {
        net.one97.paytm.oauth.d.a aVar = new net.one97.paytm.oauth.d.a(requireContext());
        aVar.setTitle((CharSequence) null);
        aVar.setCancelable(false);
        aVar.a(str);
        aVar.a(-3, (CharSequence) getString(R.string.ok), (View.OnClickListener) new h(this, aVar, z));
        aVar.show();
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpdatePhoneConfirmBottomFragment f56198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.oauth.d.a f56199b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f56200c;

        h(UpdatePhoneConfirmBottomFragment updatePhoneConfirmBottomFragment, net.one97.paytm.oauth.d.a aVar, boolean z) {
            this.f56198a = updatePhoneConfirmBottomFragment;
            this.f56199b = aVar;
            this.f56200c = z;
        }

        public final void onClick(View view) {
            this.f56199b.dismiss();
            if (this.f56200c) {
                net.one97.paytm.oauth.b b2 = OauthModule.b();
                net.one97.paytm.oauth.b b3 = OauthModule.b();
                kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
                b2.checkDeepLinking(b3.getApplicationContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
            }
            this.f56198a.dismissAllowingStateLoss();
            if (!this.f56198a.f56189f) {
                this.f56198a.requireActivity().setResult(-1);
                this.f56198a.requireActivity().finish();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56191h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
