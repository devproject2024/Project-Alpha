package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
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
import kotlin.m.p;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.n;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.oauth.view.a;

public final class AccountUnblockSavedCardFragment extends v implements View.OnClickListener, a.C1055a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56064a = {y.a((t) new u(y.b(AccountUnblockSavedCardFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private String f56065b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f56066c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.oauth.g.a f56067d;

    /* renamed from: e  reason: collision with root package name */
    private final String f56068e = "unblock my phone";

    /* renamed from: f  reason: collision with root package name */
    private String f56069f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f56070g;

    /* renamed from: h  reason: collision with root package name */
    private TextWatcher f56071h;

    /* renamed from: i  reason: collision with root package name */
    private final String f56072i = "true";
    private final c j = new c(this);
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
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

    static final class a<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockSavedCardFragment f56073a;

        a(AccountUnblockSavedCardFragment accountUnblockSavedCardFragment) {
            this.f56073a = accountUnblockSavedCardFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56073a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    AccountUnblockSavedCardFragment.a(this.f56073a, (ErrorModel) eVar.f52603b, eVar.f52605d);
                    return;
                }
                AccountUnblockSavedCardFragment.a(this.f56073a, (IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockSavedCardFragment f56074a;

        b(AccountUnblockSavedCardFragment accountUnblockSavedCardFragment) {
            this.f56074a = accountUnblockSavedCardFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56074a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountUnblockSavedCardFragment.a(this.f56074a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountUnblockSavedCardFragment.a(this.f56074a, (IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockSavedCardFragment f56076a;

        d(AccountUnblockSavedCardFragment accountUnblockSavedCardFragment) {
            this.f56076a = accountUnblockSavedCardFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56076a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountUnblockSavedCardFragment.a(this.f56076a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountUnblockSavedCardFragment.a(this.f56076a, (IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_enter_saved_card, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        g dVar = new androidx.navigation.d(y.b(m.class), new f(this));
        this.f56066c = ((m) dVar.getValue()).b();
        String a2 = ((m) dVar.getValue()).a();
        if (a2 == null) {
            a2 = "";
        }
        this.f56065b = a2;
        String c2 = ((m) dVar.getValue()).c();
        if (c2 == null) {
            c2 = "";
        }
        this.f56069f = c2;
        this.f56070g = ((m) dVar.getValue()).d();
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_header);
        if (roboTextView != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.lbl_enter_saved_card_details_header);
            k.a((Object) string, "getString(R.string.lbl_e…aved_card_details_header)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f56070g}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView.setText(format);
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etCardExpiry);
        if (appCompatEditText != null) {
            appCompatEditText.setHint(getString(R.string.lbl_expiry_text));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_dont_have_card);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etCardNo);
        if (appCompatEditText2 != null) {
            appCompatEditText2.addTextChangedListener(this.j);
        }
        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.etCardExpiry);
        k.a((Object) appCompatEditText3, "etCardExpiry");
        this.f56071h = new net.one97.paytm.oauth.view.a(appCompatEditText3, this);
        AppCompatEditText appCompatEditText4 = (AppCompatEditText) a(R.id.etCardNo);
        if (appCompatEditText4 != null) {
            appCompatEditText4.setGravity(8388611);
        }
        AppCompatEditText appCompatEditText5 = (AppCompatEditText) a(R.id.etCardExpiry);
        if (appCompatEditText5 != null) {
            appCompatEditText5.addTextChangedListener(this.f56071h);
        }
        ai a3 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.a.class);
        k.a((Object) a3, "ViewModelProviders.of(th…ockViewModel::class.java)");
        this.f56067d = (net.one97.paytm.oauth.g.a) a3;
        v.a("/unblock_saved_card", "diy_unblock", "saved_card_loaded", (ArrayList) null, 24);
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockSavedCardFragment f56075a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(AccountUnblockSavedCardFragment accountUnblockSavedCardFragment) {
            this.f56075a = accountUnblockSavedCardFragment;
        }

        public final void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56075a.a(R.id.tilCardNo);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56075a.a(R.id.tilCardNo);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
            RoboTextView roboTextView = (RoboTextView) this.f56075a.a(R.id.tv_card_err_msg);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r13) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x000c
            int r13 = r13.getId()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            goto L_0x000d
        L_0x000c:
            r13 = r0
        L_0x000d:
            int r1 = net.one97.paytm.oauth.R.id.btnProceed
            java.lang.String r2 = "diy_unblock"
            java.lang.String r3 = "/unblock_saved_card"
            if (r13 != 0) goto L_0x0017
            goto L_0x0125
        L_0x0017:
            int r4 = r13.intValue()
            if (r4 != r1) goto L_0x0125
            int r13 = net.one97.paytm.oauth.R.id.etCardNo
            android.view.View r13 = r12.a(r13)
            androidx.appcompat.widget.AppCompatEditText r13 = (androidx.appcompat.widget.AppCompatEditText) r13
            if (r13 == 0) goto L_0x002c
            android.text.Editable r13 = r13.getText()
            goto L_0x002d
        L_0x002c:
            r13 = r0
        L_0x002d:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r1 = ""
            r4 = 0
            java.lang.String r5 = " "
            java.lang.String r13 = kotlin.m.p.a(r13, r5, r1, r4)
            java.lang.String r5 = "-?\\d+(\\.\\d+)?"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            java.util.regex.Matcher r13 = r5.matcher(r13)
            boolean r13 = r13.matches()
            r5 = 16
            java.lang.String r6 = "app"
            r7 = 2
            r8 = 3
            java.lang.String r9 = "proceed_clicked"
            r10 = 1
            if (r13 != 0) goto L_0x008d
            int r13 = net.one97.paytm.oauth.R.string.err_valid_card_no
            java.lang.String r13 = r12.getString(r13)
            java.lang.String r0 = "getString(R.string.err_valid_card_no)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            int r0 = net.one97.paytm.oauth.R.id.tilCardNo
            android.view.View r0 = r12.a(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x006d
            r0.setErrorEnabled(r10)
        L_0x006d:
            int r0 = net.one97.paytm.oauth.R.id.tilCardNo
            android.view.View r0 = r12.a(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x007d
            r11 = r13
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.setError(r11)
        L_0x007d:
            java.lang.String[] r0 = new java.lang.String[r8]
            r0[r4] = r1
            r0[r10] = r13
            r0[r7] = r6
            java.util.ArrayList r13 = kotlin.a.k.d(r0)
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r9, (java.util.ArrayList) r13, (int) r5)
            return
        L_0x008d:
            int r13 = net.one97.paytm.oauth.R.id.etCardExpiry
            android.view.View r13 = r12.a(r13)
            androidx.appcompat.widget.AppCompatEditText r13 = (androidx.appcompat.widget.AppCompatEditText) r13
            if (r13 == 0) goto L_0x009b
            android.text.Editable r0 = r13.getText()
        L_0x009b:
            java.lang.String r13 = java.lang.String.valueOf(r0)
            r0 = r13
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r11 = "/"
            java.lang.String[] r11 = new java.lang.String[]{r11}
            java.util.List r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.String[]) r11)
            int r13 = r13.length()
            r11 = 5
            if (r13 >= r11) goto L_0x00b5
        L_0x00b3:
            r13 = 0
            goto L_0x00d9
        L_0x00b5:
            java.lang.Object r13 = r0.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Integer r13 = kotlin.m.p.c(r13)
            if (r13 == 0) goto L_0x00c6
            int r13 = r13.intValue()
            goto L_0x00c7
        L_0x00c6:
            r13 = 0
        L_0x00c7:
            if (r13 == 0) goto L_0x00b3
            java.lang.Object r13 = r0.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            int r13 = java.lang.Integer.parseInt(r13)
            r0 = 12
            if (r13 <= r0) goto L_0x00d8
            goto L_0x00b3
        L_0x00d8:
            r13 = 1
        L_0x00d9:
            if (r13 != 0) goto L_0x0113
            int r13 = net.one97.paytm.oauth.R.string.err_valid_card_expiry
            java.lang.String r13 = r12.getString(r13)
            java.lang.String r0 = "getString(R.string.err_valid_card_expiry)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            int r0 = net.one97.paytm.oauth.R.id.tilCardExpiry
            android.view.View r0 = r12.a(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x00f3
            r0.setErrorEnabled(r10)
        L_0x00f3:
            int r0 = net.one97.paytm.oauth.R.id.tilCardExpiry
            android.view.View r0 = r12.a(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            if (r0 == 0) goto L_0x0103
            r11 = r13
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.setError(r11)
        L_0x0103:
            java.lang.String[] r0 = new java.lang.String[r8]
            r0[r4] = r1
            r0[r10] = r13
            r0[r7] = r6
            java.util.ArrayList r13 = kotlin.a.k.d(r0)
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r9, (java.util.ArrayList) r13, (int) r5)
            return
        L_0x0113:
            int r13 = net.one97.paytm.oauth.R.id.btnProceed
            android.view.View r13 = r12.a(r13)
            net.one97.paytm.oauth.view.ProgressViewButton r13 = (net.one97.paytm.oauth.view.ProgressViewButton) r13
            if (r13 == 0) goto L_0x0124
            boolean r13 = r13.f56843a
            if (r13 != 0) goto L_0x0124
            r12.d()
        L_0x0124:
            return
        L_0x0125:
            int r1 = net.one97.paytm.oauth.R.id.tv_dont_have_card
            if (r13 != 0) goto L_0x012a
            return
        L_0x012a:
            int r13 = r13.intValue()
            if (r13 != r1) goto L_0x015d
            r13 = 24
            java.lang.String r1 = "dont_have_card_clicked"
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r1, (java.util.ArrayList) r0, (int) r13)
            r13 = r12
            androidx.fragment.app.Fragment r13 = (androidx.fragment.app.Fragment) r13
            net.one97.paytm.oauth.utils.OAuthUtils.a((androidx.fragment.app.Fragment) r13)
            net.one97.paytm.oauth.fragment.aj r13 = new net.one97.paytm.oauth.fragment.aj
            r13.<init>()
            androidx.fragment.app.j r0 = r12.getChildFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            java.lang.String r1 = "childFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.fragment.app.Fragment r13 = (androidx.fragment.app.Fragment) r13
            java.lang.Class<net.one97.paytm.oauth.fragment.aj> r1 = net.one97.paytm.oauth.fragment.aj.class
            java.lang.String r1 = r1.getName()
            r0.a((androidx.fragment.app.Fragment) r13, (java.lang.String) r1)
            r0.c()
        L_0x015d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment.onClick(android.view.View):void");
    }

    private final void d() {
        OAuthUtils.a((Activity) requireActivity());
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etCardExpiry);
        Editable editable = null;
        List<String> a2 = p.a((CharSequence) String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null), new String[]{"/"});
        if (this.f56067d == null) {
            k.a("viewModel");
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
            String str4 = this.f56069f;
            if (str4 != null) {
                str = str4;
            }
            net.one97.paytm.oauth.g.a.b(obj, str2, str3, str).observe(this, new d(this));
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    private final void e() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56067d == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.a(this.f56065b).observe(this, new b(this));
    }

    private final void f() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56067d == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.a(this.f56068e, this.f56065b, "STATE_CODE", "UNBLOCK").observe(this, new a(this));
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockSavedCardFragment f56077a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56078b;

        e(AccountUnblockSavedCardFragment accountUnblockSavedCardFragment, String str) {
            this.f56077a = accountUnblockSavedCardFragment;
            this.f56078b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56077a.a(R.id.btnProceed);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            AccountUnblockSavedCardFragment.a(this.f56077a, this.f56078b);
        }
    }

    private final void g() {
        n.a a2 = n.a();
        k.a((Object) a2, "AccountUnblockSavedCardF…ionAccountBlockTerminal()");
        a2.c();
        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) a2);
    }

    public final void b() {
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_card_err_msg);
        if (roboTextView != null) {
            roboTextView.setVisibility(8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e5, code lost:
        if (r3.equals(net.one97.paytm.common.entity.auth.WebLogin.RESPONSE_CODE_SUCCESS) != false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ec, code lost:
        if (r3.equals("BE1400001") != false) goto L_0x00ee;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment r17, com.paytm.network.model.IJRPaytmDataModel r18, java.lang.String r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r1 instanceof net.one97.paytm.oauth.models.AccountBlockStatusResModel
            java.lang.String r4 = "BE1400001"
            r5 = -1260518837(0xffffffffb4de024b, float:-4.135239E-7)
            if (r3 == 0) goto L_0x004a
            net.one97.paytm.oauth.models.AccountBlockStatusResModel r1 = (net.one97.paytm.oauth.models.AccountBlockStatusResModel) r1
            java.lang.String r1 = r1.getResponseCode()
            if (r1 != 0) goto L_0x0018
            goto L_0x0046
        L_0x0018:
            int r2 = r1.hashCode()
            if (r2 == r5) goto L_0x001f
            goto L_0x0046
        L_0x001f:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0046
            net.one97.paytm.oauth.fragment.n$b r1 = net.one97.paytm.oauth.fragment.n.b()
            java.lang.String r2 = "AccountUnblockSavedCardF…tUnblockSuccessFragment()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r2 = r0.f56066c
            r1.a(r2)
            android.content.Context r2 = r17.requireContext()
            java.lang.String r3 = r0.f56066c
            com.paytm.utility.b.n(r2, r3)
            androidx.navigation.h r0 = androidx.navigation.fragment.a.a(r17)
            androidx.navigation.l r1 = (androidx.navigation.l) r1
            r0.a((androidx.navigation.l) r1)
            return
        L_0x0046:
            r17.g()
            return
        L_0x004a:
            boolean r3 = r1 instanceof net.one97.paytm.oauth.models.VerificationResModel
            if (r3 == 0) goto L_0x0191
            net.one97.paytm.oauth.models.VerificationResModel r1 = (net.one97.paytm.oauth.models.VerificationResModel) r1
            java.lang.String r3 = r1.getResponseCode()
            java.lang.String r6 = "getString(R.string.some_went_wrong)"
            java.lang.String r8 = "api"
            r11 = 4
            r12 = 0
            java.lang.String r13 = "proceed_clicked"
            java.lang.String r14 = "diy_unblock"
            java.lang.String r15 = "/unblock_saved_card"
            java.lang.String r16 = ""
            if (r3 != 0) goto L_0x0066
            goto L_0x0160
        L_0x0066:
            int r7 = r3.hashCode()
            java.lang.String r9 = "oauthVerifyCard"
            r10 = -1079153376(0xffffffffbfad6d20, float:-1.3548927)
            if (r7 == r5) goto L_0x00e8
            r4 = 1537(0x601, float:2.154E-42)
            if (r7 == r4) goto L_0x00df
            r4 = 1538(0x602, float:2.155E-42)
            if (r7 == r4) goto L_0x007b
            goto L_0x0160
        L_0x007b:
            java.lang.String r4 = "02"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0160
            if (r2 != 0) goto L_0x0086
            goto L_0x00db
        L_0x0086:
            int r3 = r19.hashCode()
            if (r3 == r10) goto L_0x008d
            goto L_0x00db
        L_0x008d:
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00db
            java.lang.String r2 = r1.getCanRetry()
            java.lang.String r3 = r0.f56072i
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x00c0
            int r2 = net.one97.paytm.oauth.R.id.tv_card_err_msg
            android.view.View r2 = r0.a(r2)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            if (r2 == 0) goto L_0x00ac
            r2.setVisibility(r12)
        L_0x00ac:
            int r2 = net.one97.paytm.oauth.R.id.tv_card_err_msg
            android.view.View r0 = r0.a(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x00bf
            java.lang.String r1 = r1.getMessage()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00bf:
            return
        L_0x00c0:
            net.one97.paytm.oauth.fragment.n$a r1 = net.one97.paytm.oauth.fragment.n.a()
            java.lang.String r2 = "AccountUnblockSavedCardF…ionAccountBlockTerminal()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r1.c()
            net.one97.paytm.oauth.utils.TerminalPageState r2 = net.one97.paytm.oauth.utils.TerminalPageState.IS_LIMIT_EXCEED
            r1.a(r2)
            androidx.navigation.h r0 = androidx.navigation.fragment.a.a(r17)
            androidx.navigation.l r1 = (androidx.navigation.l) r1
            r0.a((androidx.navigation.l) r1)
            return
        L_0x00db:
            r17.g()
            return
        L_0x00df:
            java.lang.String r4 = "01"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0160
            goto L_0x00ee
        L_0x00e8:
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0160
        L_0x00ee:
            if (r2 != 0) goto L_0x00f1
            goto L_0x0123
        L_0x00f1:
            int r3 = r19.hashCode()
            if (r3 == r10) goto L_0x0113
            r4 = 875734478(0x3432a5ce, float:1.6637861E-7)
            if (r3 == r4) goto L_0x00fd
            goto L_0x0123
        L_0x00fd:
            java.lang.String r3 = "oauthVerificationFulfill"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0123
            java.lang.String r1 = r1.getStateCode()
            if (r1 != 0) goto L_0x010d
            r1 = r16
        L_0x010d:
            r0.f56065b = r1
            r17.f()
            return
        L_0x0113:
            boolean r3 = r2.equals(r9)
            if (r3 == 0) goto L_0x0123
            r1 = 0
            r2 = 24
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r15, (java.lang.String) r14, (java.lang.String) r13, (java.util.ArrayList) r1, (int) r2)
            r17.e()
            return
        L_0x0123:
            if (r2 != 0) goto L_0x0126
            goto L_0x015c
        L_0x0126:
            int r3 = r19.hashCode()
            if (r3 == r10) goto L_0x012d
            goto L_0x015c
        L_0x012d:
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x015c
            java.lang.String[] r2 = new java.lang.String[r11]
            r2[r12] = r16
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x0146
            int r3 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r3 = r0.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
        L_0x0146:
            r4 = 1
            r2[r4] = r3
            r3 = 2
            r2[r3] = r8
            java.lang.String r1 = r1.getResponseCode()
            r3 = 3
            r2[r3] = r1
            java.util.ArrayList r1 = kotlin.a.k.d(r2)
            r2 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r15, (java.lang.String) r14, (java.lang.String) r13, (java.util.ArrayList) r1, (int) r2)
        L_0x015c:
            r17.g()
            return
        L_0x0160:
            java.lang.String[] r2 = new java.lang.String[r11]
            r2[r12] = r16
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x0173
            int r3 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r3 = r0.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
        L_0x0173:
            r4 = 1
            r2[r4] = r3
            r3 = 2
            r2[r3] = r8
            java.lang.String r1 = r1.getResponseCode()
            if (r1 != 0) goto L_0x0180
            goto L_0x0182
        L_0x0180:
            r16 = r1
        L_0x0182:
            r1 = 3
            r2[r1] = r16
            java.util.ArrayList r1 = kotlin.a.k.d(r2)
            r2 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r15, (java.lang.String) r14, (java.lang.String) r13, (java.util.ArrayList) r1, (int) r2)
            r17.g()
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment.a(net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment, com.paytm.network.model.IJRPaytmDataModel, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f8, code lost:
        if (r2 != r3.intValue()) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012f, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) "BE1426027") != false) goto L_0x0140;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment r16, net.one97.paytm.oauth.models.ErrorModel r17, java.lang.String r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "responseCode"
            androidx.fragment.app.FragmentActivity r4 = r16.getActivity()
            android.app.Activity r4 = (android.app.Activity) r4
            r5 = r0
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            r6 = 0
            if (r1 == 0) goto L_0x0019
            com.paytm.network.model.NetworkCustomError r7 = r17.getCustomError()
            goto L_0x001a
        L_0x0019:
            r7 = r6
        L_0x001a:
            boolean r4 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r4, (androidx.fragment.app.Fragment) r5, (com.paytm.network.model.NetworkCustomError) r7)
            if (r4 != 0) goto L_0x0191
            android.content.Context r4 = r16.requireContext()
            net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment$e r5 = new net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment$e
            r5.<init>(r0, r2)
            android.content.DialogInterface$OnClickListener r5 = (android.content.DialogInterface.OnClickListener) r5
            boolean r4 = net.one97.paytm.oauth.utils.l.a(r1, r4, r5)
            if (r4 != 0) goto L_0x0191
            if (r1 == 0) goto L_0x0037
            com.paytm.network.model.NetworkCustomError r6 = r17.getCustomError()
        L_0x0037:
            boolean r4 = r6 instanceof com.paytm.network.model.NetworkCustomError
            java.lang.String r5 = "getString(R.string.some_went_wrong)"
            java.lang.String r8 = "api"
            r11 = 4
            java.lang.String r12 = "proceed_clicked"
            java.lang.String r13 = "diy_unblock"
            java.lang.String r14 = "/unblock_saved_card"
            java.lang.String r15 = ""
            r6 = 0
            if (r4 == 0) goto L_0x016f
            com.paytm.network.model.NetworkCustomError r4 = r17.getCustomError()
            com.paytm.network.model.NetworkResponse r4 = r4.networkResponse
            byte[] r4 = r4.data
            if (r4 == 0) goto L_0x016e
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r9 = kotlin.m.d.f47971a
            r7.<init>(r4, r9)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x014c
            java.lang.String r5 = new java.lang.String     // Catch:{ JSONException -> 0x0148 }
            java.nio.charset.Charset r7 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x0148 }
            r5.<init>(r4, r7)     // Catch:{ JSONException -> 0x0148 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0148 }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0148 }
            java.lang.String r5 = r4.getString(r3)     // Catch:{ JSONException -> 0x0148 }
            java.lang.String r7 = "oauthVerifyCard"
            if (r2 != 0) goto L_0x0077
            goto L_0x00ab
        L_0x0077:
            int r9 = r18.hashCode()     // Catch:{ JSONException -> 0x0148 }
            r10 = -1079153376(0xffffffffbfad6d20, float:-1.3548927)
            if (r9 == r10) goto L_0x0081
            goto L_0x00ab
        L_0x0081:
            boolean r9 = r2.equals(r7)     // Catch:{ JSONException -> 0x0148 }
            if (r9 == 0) goto L_0x00ab
            java.lang.String[] r9 = new java.lang.String[r11]     // Catch:{ JSONException -> 0x0148 }
            r9[r6] = r15     // Catch:{ JSONException -> 0x0148 }
            java.lang.String r10 = "message"
            java.lang.String r10 = r4.getString(r10)     // Catch:{ JSONException -> 0x0148 }
            java.lang.String r11 = "jsonObj.getString(KEY_MESSAGE)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)     // Catch:{ JSONException -> 0x0148 }
            r11 = 1
            r9[r11] = r10     // Catch:{ JSONException -> 0x0148 }
            r10 = 2
            r9[r10] = r8     // Catch:{ JSONException -> 0x0148 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ JSONException -> 0x0148 }
            r3 = 3
            r9[r3] = r5     // Catch:{ JSONException -> 0x0148 }
            java.util.ArrayList r3 = kotlin.a.k.d(r9)     // Catch:{ JSONException -> 0x0148 }
            r8 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r13, (java.lang.String) r12, (java.util.ArrayList) r3, (int) r8)     // Catch:{ JSONException -> 0x0148 }
        L_0x00ab:
            int r3 = r17.getStatus()     // Catch:{ JSONException -> 0x0148 }
            java.lang.Integer r8 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x0148 }
            if (r8 != 0) goto L_0x00b4
            goto L_0x00eb
        L_0x00b4:
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x0148 }
            if (r3 != r8) goto L_0x00eb
            java.lang.String r3 = "408"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0148 }
            if (r3 == 0) goto L_0x00eb
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r6)     // Catch:{ JSONException -> 0x0148 }
            if (r2 == 0) goto L_0x00eb
            int r1 = net.one97.paytm.oauth.R.id.tv_card_err_msg     // Catch:{ JSONException -> 0x0148 }
            android.view.View r1 = r0.a(r1)     // Catch:{ JSONException -> 0x0148 }
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ JSONException -> 0x0148 }
            if (r1 == 0) goto L_0x00d5
            r1.setVisibility(r6)     // Catch:{ JSONException -> 0x0148 }
        L_0x00d5:
            int r1 = net.one97.paytm.oauth.R.id.tv_card_err_msg     // Catch:{ JSONException -> 0x0148 }
            android.view.View r1 = r0.a(r1)     // Catch:{ JSONException -> 0x0148 }
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ JSONException -> 0x0148 }
            if (r1 == 0) goto L_0x00ea
            java.lang.String r2 = "message"
            java.lang.String r2 = r4.getString(r2)     // Catch:{ JSONException -> 0x0148 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ JSONException -> 0x0148 }
            r1.setText(r2)     // Catch:{ JSONException -> 0x0148 }
        L_0x00ea:
            return
        L_0x00eb:
            int r2 = r17.getStatus()     // Catch:{ JSONException -> 0x0148 }
            java.lang.Integer r3 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x0148 }
            if (r3 != 0) goto L_0x00f4
            goto L_0x00fa
        L_0x00f4:
            int r3 = r3.intValue()     // Catch:{ JSONException -> 0x0148 }
            if (r2 == r3) goto L_0x0144
        L_0x00fa:
            int r2 = r17.getStatus()     // Catch:{ JSONException -> 0x0148 }
            java.lang.Integer r3 = net.one97.paytm.oauth.utils.n.f56789h     // Catch:{ JSONException -> 0x0148 }
            if (r3 != 0) goto L_0x0103
            goto L_0x0112
        L_0x0103:
            int r3 = r3.intValue()     // Catch:{ JSONException -> 0x0148 }
            if (r2 != r3) goto L_0x0112
            java.lang.String r2 = "BE1426025"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x0148 }
            if (r2 == 0) goto L_0x0112
            goto L_0x0144
        L_0x0112:
            int r2 = r17.getStatus()     // Catch:{ JSONException -> 0x0148 }
            java.lang.Integer r3 = net.one97.paytm.oauth.utils.n.f56786e     // Catch:{ JSONException -> 0x0148 }
            if (r3 != 0) goto L_0x011b
            goto L_0x0131
        L_0x011b:
            int r3 = r3.intValue()     // Catch:{ JSONException -> 0x0148 }
            if (r2 != r3) goto L_0x0131
            java.lang.String r2 = "BE1426003"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x0148 }
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "BE1426027"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x0148 }
            if (r2 != 0) goto L_0x0140
        L_0x0131:
            int r1 = r17.getStatus()     // Catch:{ JSONException -> 0x0148 }
            java.lang.Integer r2 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x0148 }
            if (r2 != 0) goto L_0x013a
            return
        L_0x013a:
            int r2 = r2.intValue()     // Catch:{ JSONException -> 0x0148 }
            if (r1 != r2) goto L_0x0143
        L_0x0140:
            r16.g()     // Catch:{ JSONException -> 0x0148 }
        L_0x0143:
            return
        L_0x0144:
            r16.g()     // Catch:{ JSONException -> 0x0148 }
            return
        L_0x0148:
            r16.g()
            return
        L_0x014c:
            java.lang.String[] r1 = new java.lang.String[r11]
            r1[r6] = r15
            int r2 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r2 = r0.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r3 = 1
            r1[r3] = r2
            r2 = 2
            r1[r2] = r8
            r2 = 3
            r1[r2] = r15
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            r2 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r13, (java.lang.String) r12, (java.util.ArrayList) r1, (int) r2)
            r16.g()
        L_0x016e:
            return
        L_0x016f:
            java.lang.String[] r1 = new java.lang.String[r11]
            r1[r6] = r15
            int r2 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r2 = r0.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r3 = 1
            r1[r3] = r2
            r2 = 2
            r1[r2] = r8
            r2 = 3
            r1[r2] = r15
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            r2 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r13, (java.lang.String) r12, (java.util.ArrayList) r1, (int) r2)
            r16.g()
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment.a(net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment, net.one97.paytm.oauth.models.ErrorModel, java.lang.String):void");
    }

    public static final /* synthetic */ void a(AccountUnblockSavedCardFragment accountUnblockSavedCardFragment, String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1079153376) {
                if (hashCode != 875734478) {
                    if (hashCode == 1486683944 && str.equals("oauthAccountStatus")) {
                        accountUnblockSavedCardFragment.f();
                    }
                } else if (str.equals("oauthVerificationFulfill")) {
                    accountUnblockSavedCardFragment.e();
                }
            } else if (str.equals("oauthVerifyCard")) {
                accountUnblockSavedCardFragment.d();
            }
        }
    }
}
