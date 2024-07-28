package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.g.k;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.VerificationResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.oauth.view.a;

public final class bw extends u implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56541c = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    b f56542b;

    /* renamed from: d  reason: collision with root package name */
    private k f56543d;

    /* renamed from: e  reason: collision with root package name */
    private String f56544e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f56545f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f56546g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f56547h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f56548i = "phone_update_logout";
    private TextWatcher j;
    private TextWatcher k;
    private int l;
    private String m = "";
    private HashMap n;

    public interface b {
        void a(String str);
    }

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bw f56549a;

        c(bw bwVar) {
            this.f56549a = bwVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56549a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56549a.a((ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56549a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bw f56550a;

        d(bw bwVar) {
            this.f56550a = bwVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56550a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56550a.a((ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56550a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
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

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogStyle);
    }

    static final class f implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final f f56553a = new f();

        f() {
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
            dialog.setOnShowListener(f.f56553a);
        }
        ai a2 = am.a((Fragment) this).a(k.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…oneViewModel::class.java)");
        this.f56543d = (k) a2;
        return layoutInflater.inflate(R.layout.fragment_bottom_verify_card, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        String str2;
        super.onActivityCreated(bundle);
        if (com.paytm.utility.b.r(requireContext())) {
            this.f56548i = "phone_update_login";
        }
        Bundle arguments = getArguments();
        this.f56544e = arguments != null ? arguments.getString("stateToken", "") : null;
        Bundle arguments2 = getArguments();
        this.f56545f = arguments2 != null ? arguments2.getString("verifierId", "") : null;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str = arguments3.getString("marked_card_no", "")) == null) {
            str = "";
        }
        this.f56547h = str;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str2 = arguments4.getString("card_position")) == null) {
            str2 = "";
        }
        this.m = str2;
        this.l = this.f56547h.length();
        u.a("/list_of_saved_cards", this.f56548i, "card_details_pop_up_loaded", kotlin.a.k.d(this.m), 16);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.lbl_confirm_card_details));
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etExpiry);
        if (appCompatEditText != null) {
            appCompatEditText.setHint(getString(R.string.lbl_mm_yy));
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etCardNo);
        if (appCompatEditText2 != null) {
            appCompatEditText2.requestFocus();
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.etExpiry);
        kotlin.g.b.k.a((Object) appCompatEditText3, "etExpiry");
        this.k = new net.one97.paytm.oauth.view.a(appCompatEditText3, (a.C1055a) null);
        AppCompatEditText appCompatEditText4 = (AppCompatEditText) a(R.id.etExpiry);
        if (appCompatEditText4 != null) {
            appCompatEditText4.addTextChangedListener(this.k);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etCardNo);
        if (appCompatEditText != null) {
            appCompatEditText.removeTextChangedListener(this.j);
        }
        this.j = null;
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etExpiry);
        if (appCompatEditText2 != null) {
            appCompatEditText2.removeTextChangedListener(this.k);
        }
        this.k = null;
        a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x000c
            int r11 = r11.getId()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x000d
        L_0x000c:
            r11 = r0
        L_0x000d:
            int r1 = net.one97.paytm.oauth.R.id.imgCross
            r2 = 16
            java.lang.String r3 = "/list_of_saved_cards"
            r4 = 1
            r5 = 0
            if (r11 != 0) goto L_0x0018
            goto L_0x0033
        L_0x0018:
            int r6 = r11.intValue()
            if (r6 != r1) goto L_0x0033
            java.lang.String r11 = r10.f56548i
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.String r1 = r10.m
            r0[r5] = r1
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            java.lang.String r1 = "card_details_pop_up_discarded"
            net.one97.paytm.oauth.fragment.u.a((java.lang.String) r3, (java.lang.String) r11, (java.lang.String) r1, (java.util.ArrayList) r0, (int) r2)
            r10.dismissAllowingStateLoss()
            return
        L_0x0033:
            int r1 = net.one97.paytm.oauth.R.id.btnConfirm
            if (r11 != 0) goto L_0x0038
            return
        L_0x0038:
            int r11 = r11.intValue()
            if (r11 != r1) goto L_0x014a
            int r11 = net.one97.paytm.oauth.R.id.etCardNo
            android.view.View r11 = r10.a((int) r11)
            androidx.appcompat.widget.AppCompatEditText r11 = (androidx.appcompat.widget.AppCompatEditText) r11
            if (r11 == 0) goto L_0x004d
            android.text.Editable r11 = r11.getText()
            goto L_0x004e
        L_0x004d:
            r11 = r0
        L_0x004e:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r1 = " "
            java.lang.String r6 = ""
            java.lang.String r11 = kotlin.m.p.a(r11, r1, r6, r5)
            java.lang.String r1 = "-?\\d+(\\.\\d+)?"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.util.regex.Matcher r11 = r1.matcher(r11)
            boolean r11 = r11.matches()
            java.lang.String r1 = "app"
            r6 = 2
            r7 = 3
            java.lang.String r8 = "confirm_card_details_clicked"
            if (r11 != 0) goto L_0x00ae
            int r11 = net.one97.paytm.oauth.R.string.err_valid_card_no
            java.lang.String r11 = r10.getString(r11)
            java.lang.String r0 = "getString(R.string.err_valid_card_no)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            int r0 = net.one97.paytm.oauth.R.id.tilCardNo
            android.view.View r0 = r10.a((int) r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x008a
            r0.setErrorEnabled(r4)
        L_0x008a:
            int r0 = net.one97.paytm.oauth.R.id.tilCardNo
            android.view.View r0 = r10.a((int) r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x009a
            r9 = r11
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setError(r9)
        L_0x009a:
            java.lang.String r0 = r10.f56548i
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.String r9 = r10.m
            r7[r5] = r9
            r7[r4] = r11
            r7[r6] = r1
            java.util.ArrayList r11 = kotlin.a.k.d(r7)
            net.one97.paytm.oauth.fragment.u.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r8, (java.util.ArrayList) r11, (int) r2)
            return
        L_0x00ae:
            int r11 = net.one97.paytm.oauth.R.id.etExpiry
            android.view.View r11 = r10.a((int) r11)
            androidx.appcompat.widget.AppCompatEditText r11 = (androidx.appcompat.widget.AppCompatEditText) r11
            if (r11 == 0) goto L_0x00bc
            android.text.Editable r0 = r11.getText()
        L_0x00bc:
            java.lang.String r11 = java.lang.String.valueOf(r0)
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r9 = "/"
            java.lang.String[] r9 = new java.lang.String[]{r9}
            java.util.List r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.String[]) r9)
            int r11 = r11.length()
            r9 = 5
            if (r11 >= r9) goto L_0x00d6
        L_0x00d4:
            r11 = 0
            goto L_0x00fa
        L_0x00d6:
            java.lang.Object r11 = r0.get(r5)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Integer r11 = kotlin.m.p.c(r11)
            if (r11 == 0) goto L_0x00e7
            int r11 = r11.intValue()
            goto L_0x00e8
        L_0x00e7:
            r11 = 0
        L_0x00e8:
            if (r11 == 0) goto L_0x00d4
            java.lang.Object r11 = r0.get(r5)
            java.lang.String r11 = (java.lang.String) r11
            int r11 = java.lang.Integer.parseInt(r11)
            r0 = 12
            if (r11 <= r0) goto L_0x00f9
            goto L_0x00d4
        L_0x00f9:
            r11 = 1
        L_0x00fa:
            if (r11 != 0) goto L_0x0138
            int r11 = net.one97.paytm.oauth.R.string.err_valid_card_expiry
            java.lang.String r11 = r10.getString(r11)
            java.lang.String r0 = "getString(R.string.err_valid_card_expiry)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            int r0 = net.one97.paytm.oauth.R.id.tilExpiry
            android.view.View r0 = r10.a((int) r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x0114
            r0.setErrorEnabled(r4)
        L_0x0114:
            int r0 = net.one97.paytm.oauth.R.id.tilExpiry
            android.view.View r0 = r10.a((int) r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x0124
            r9 = r11
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setError(r9)
        L_0x0124:
            java.lang.String r0 = r10.f56548i
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.String r9 = r10.m
            r7[r5] = r9
            r7[r4] = r11
            r7[r6] = r1
            java.util.ArrayList r11 = kotlin.a.k.d(r7)
            net.one97.paytm.oauth.fragment.u.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r8, (java.util.ArrayList) r11, (int) r2)
            return
        L_0x0138:
            int r11 = net.one97.paytm.oauth.R.id.btnConfirm
            android.view.View r11 = r10.a((int) r11)
            net.one97.paytm.oauth.view.ProgressViewButton r11 = (net.one97.paytm.oauth.view.ProgressViewButton) r11
            if (r11 == 0) goto L_0x014a
            boolean r11 = r11.f56843a
            if (r11 != 0) goto L_0x014a
            r10.b()
        L_0x014a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.bw.onClick(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public final void b() {
        OAuthUtils.a((Activity) requireActivity());
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etExpiry);
        Editable editable = null;
        List<String> a2 = p.a((CharSequence) String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null), new String[]{"/"});
        if (this.f56543d == null) {
            kotlin.g.b.k.a("viewModel");
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etCardNo);
        if (appCompatEditText2 != null) {
            editable = appCompatEditText2.getText();
        }
        String str = "";
        String a3 = p.a(String.valueOf(editable), " ", str, false);
        if (a3 != null) {
            String obj = p.b(a3).toString();
            String str2 = a2.get(0);
            String str3 = a2.get(1);
            String str4 = this.f56545f;
            if (str4 != null) {
                str = str4;
            }
            k.a(obj, str2, str3, str).observe(this, new d(this));
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* access modifiers changed from: private */
    public final void c() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56543d == null) {
            kotlin.g.b.k.a("viewModel");
        }
        k.b(this.f56544e).observe(this, new c(this));
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        int hashCode;
        if (iJRPaytmDataModel instanceof VerificationResModel) {
            VerificationResModel verificationResModel = (VerificationResModel) iJRPaytmDataModel;
            String responseCode = verificationResModel.getResponseCode();
            if (responseCode == null || ((hashCode = responseCode.hashCode()) == -1260518837 ? !responseCode.equals("BE1400001") : hashCode != 1537 || !responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS))) {
                String str2 = this.f56548i;
                String[] strArr = new String[4];
                strArr[0] = this.m;
                String message = verificationResModel.getMessage();
                if (message == null) {
                    message = "";
                }
                strArr[1] = message;
                strArr[2] = SDKConstants.KEY_API;
                String responseCode2 = verificationResModel.getResponseCode();
                if (responseCode2 == null) {
                    responseCode2 = "";
                }
                strArr[3] = responseCode2;
                u.a("/list_of_saved_cards", str2, "confirm_card_details_clicked", kotlin.a.k.d(strArr), 16);
                com.paytm.utility.b.b(requireContext(), (String) null, verificationResModel.getMessage());
            } else if (str != null && str.hashCode() == -1079153376 && str.equals("oauthVerifyCard")) {
                c();
            } else {
                u.a("/list_of_saved_cards", this.f56548i, "confirm_card_details_clicked", kotlin.a.k.d(this.m), 16);
                b bVar = this.f56542b;
                if (bVar != null) {
                    String stateCode = verificationResModel.getStateCode();
                    if (stateCode == null) {
                        stateCode = "";
                    }
                    bVar.a(stateCode);
                }
                dismissAllowingStateLoss();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ae, code lost:
        if (r8.equals("400") != false) goto L_0x00b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.oauth.models.ErrorModel r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "model"
            kotlin.g.b.k.c(r7, r0)
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = r6
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            com.paytm.network.model.NetworkCustomError r2 = r7.getCustomError()
            boolean r0 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r0, (androidx.fragment.app.Fragment) r1, (com.paytm.network.model.NetworkCustomError) r2)
            if (r0 == 0) goto L_0x0019
            return
        L_0x0019:
            int r0 = r7.getStatus()
            r1 = -1
            if (r0 != r1) goto L_0x0045
            int r7 = net.one97.paytm.oauth.R.string.no_connection
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r0 = "getString(R.string.no_connection)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            int r0 = net.one97.paytm.oauth.R.string.no_internet
            java.lang.String r0 = r6.getString(r0)
            java.lang.String r1 = "getString(R.string.no_internet)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r1 = r6.requireContext()
            net.one97.paytm.oauth.fragment.bw$e r2 = new net.one97.paytm.oauth.fragment.bw$e
            r2.<init>(r6, r8)
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            net.one97.paytm.oauth.utils.OAuthUtils.a(r1, r7, r0, r2)
            return
        L_0x0045:
            com.paytm.network.model.NetworkCustomError r0 = r7.getCustomError()
            boolean r0 = r0 instanceof com.paytm.network.model.NetworkCustomError
            if (r0 == 0) goto L_0x00f4
            com.paytm.network.model.NetworkCustomError r0 = r7.getCustomError()
            com.paytm.network.model.NetworkResponse r0 = r0.networkResponse
            byte[] r0 = r0.data
            if (r0 == 0) goto L_0x00f3
            java.lang.String r1 = new java.lang.String     // Catch:{ JSONException -> 0x00ef }
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x00ef }
            r1.<init>(r0, r2)     // Catch:{ JSONException -> 0x00ef }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00ef }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r1 = "message"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "oauthVerifyCard"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00ef }
            if (r8 == 0) goto L_0x00eb
            int r8 = r7.getStatus()     // Catch:{ JSONException -> 0x00ef }
            r2 = 400(0x190, float:5.6E-43)
            if (r8 != r2) goto L_0x00eb
            java.lang.String r8 = "responseCode"
            java.lang.String r8 = r0.getString(r8)     // Catch:{ JSONException -> 0x00ef }
            if (r8 != 0) goto L_0x0082
            goto L_0x00b4
        L_0x0082:
            int r0 = r8.hashCode()     // Catch:{ JSONException -> 0x00ef }
            r2 = 51508(0xc934, float:7.2178E-41)
            if (r0 == r2) goto L_0x00a8
            r2 = 51510(0xc936, float:7.2181E-41)
            if (r0 == r2) goto L_0x009f
            r2 = 51543(0xc957, float:7.2227E-41)
            if (r0 == r2) goto L_0x0096
            goto L_0x00b4
        L_0x0096:
            java.lang.String r0 = "414"
            boolean r8 = r8.equals(r0)     // Catch:{ JSONException -> 0x00ef }
            if (r8 == 0) goto L_0x00b4
            goto L_0x00b0
        L_0x009f:
            java.lang.String r0 = "402"
            boolean r8 = r8.equals(r0)     // Catch:{ JSONException -> 0x00ef }
            if (r8 == 0) goto L_0x00b4
            goto L_0x00b0
        L_0x00a8:
            java.lang.String r0 = "400"
            boolean r8 = r8.equals(r0)     // Catch:{ JSONException -> 0x00ef }
            if (r8 == 0) goto L_0x00b4
        L_0x00b0:
            r6.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x00ef }
            return
        L_0x00b4:
            android.content.Context r8 = r6.requireContext()     // Catch:{ JSONException -> 0x00ef }
            r0 = 0
            com.paytm.utility.b.b((android.content.Context) r8, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r8 = "/list_of_saved_cards"
            java.lang.String r0 = r6.f56548i     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "confirm_card_details_clicked"
            r3 = 4
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x00ef }
            r4 = 0
            java.lang.String r5 = r6.f56547h     // Catch:{ JSONException -> 0x00ef }
            r3[r4] = r5     // Catch:{ JSONException -> 0x00ef }
            r4 = 1
            if (r1 != 0) goto L_0x00cf
            java.lang.String r1 = ""
        L_0x00cf:
            r3[r4] = r1     // Catch:{ JSONException -> 0x00ef }
            r1 = 2
            java.lang.String r4 = "api"
            r3[r1] = r4     // Catch:{ JSONException -> 0x00ef }
            r1 = 3
            int r7 = r7.getStatus()     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ JSONException -> 0x00ef }
            r3[r1] = r7     // Catch:{ JSONException -> 0x00ef }
            java.util.ArrayList r7 = kotlin.a.k.d(r3)     // Catch:{ JSONException -> 0x00ef }
            r1 = 16
            net.one97.paytm.oauth.fragment.u.a((java.lang.String) r8, (java.lang.String) r0, (java.lang.String) r2, (java.util.ArrayList) r7, (int) r1)     // Catch:{ JSONException -> 0x00ef }
            return
        L_0x00eb:
            r6.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x00ef }
            return
        L_0x00ef:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00f3:
            return
        L_0x00f4:
            int r7 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r7 = r6.getString(r7)
            r6.a((java.lang.String) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.bw.a(net.one97.paytm.oauth.models.ErrorModel, java.lang.String):void");
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bw f56551a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56552b;

        e(bw bwVar, String str) {
            this.f56551a = bwVar;
            this.f56552b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (kotlin.g.b.k.a((Object) this.f56552b, (Object) "oauthVerifyCard")) {
                this.f56551a.b();
            } else {
                this.f56551a.c();
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bw f56554a;

        g(bw bwVar) {
            this.f56554a = bwVar;
        }

        public final void onClick(View view) {
            this.f56554a.dismissAllowingStateLoss();
            this.f56554a.requireActivity().setResult(-1);
            this.f56554a.requireActivity().finish();
        }
    }

    private final void a(String str) {
        net.one97.paytm.oauth.d.a.a(requireContext(), str, (View.OnClickListener) new g(this));
    }
}
