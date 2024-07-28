package net.one97.paytm.oauth.fragment;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.a;
import net.one97.paytm.oauth.fragment.h;
import net.one97.paytm.oauth.models.AccountBlockStatusResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiConstants;

public final class AccountBlockReasonFragment extends v implements View.OnClickListener, a.b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56031a = {y.a((t) new u(y.b(AccountBlockReasonFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.oauth.g.a f56032b;

    /* renamed from: c  reason: collision with root package name */
    private String f56033c = "";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f56034d = "";

    /* renamed from: e  reason: collision with root package name */
    private boolean f56035e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f56036f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f56037g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f56038h;

    /* renamed from: i  reason: collision with root package name */
    private String f56039i = "";
    private HashMap j;

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56045a = new d();

        d() {
        }

        public final void onClick(View view) {
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final f f56046a = new f();

        f() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.j;
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
        final /* synthetic */ AccountBlockReasonFragment f56040a;

        a(AccountBlockReasonFragment accountBlockReasonFragment) {
            this.f56040a = accountBlockReasonFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56040a.a(R.id.progressBtn);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    AccountBlockReasonFragment.a(this.f56040a, (ErrorModel) eVar.f52603b);
                    return;
                }
                AccountBlockReasonFragment.a(this.f56040a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    public static final class e extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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
        return layoutInflater.inflate(R.layout.fragment_account_block, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ockViewModel::class.java)");
        this.f56032b = (net.one97.paytm.oauth.g.a) a2;
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.progressBtn);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) a(R.id.radioBtn1);
        if (appCompatRadioButton != null) {
            appCompatRadioButton.setOnClickListener(this);
        }
        AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) a(R.id.radioBtn2);
        if (appCompatRadioButton2 != null) {
            appCompatRadioButton2.setOnClickListener(this);
        }
        AppCompatRadioButton appCompatRadioButton3 = (AppCompatRadioButton) a(R.id.radioBtn3);
        if (appCompatRadioButton3 != null) {
            appCompatRadioButton3.setOnClickListener(this);
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.tv_description);
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(new g(this));
        }
        kotlin.g dVar = new androidx.navigation.d(y.b(g.class), new e(this));
        this.f56035e = ((g) dVar.getValue()).b();
        this.f56036f = this.f56035e ? "diy_block_logout" : "diy_block_login";
        String a3 = ((g) dVar.getValue()).a();
        if (a3 == null) {
            a3 = "";
        }
        this.f56037g = a3;
        this.f56038h = ((g) dVar.getValue()).c();
        if (TextUtils.isEmpty(this.f56037g)) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            String sSOToken = b2.getSSOToken();
            if (sSOToken == null) {
                sSOToken = "";
            }
            this.f56037g = sSOToken;
        }
        v.a("/diy_block_reason", this.f56036f, "reason_page_loaded", (ArrayList) null, 24);
    }

    public static final class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockReasonFragment f56047a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        g(AccountBlockReasonFragment accountBlockReasonFragment) {
            this.f56047a = accountBlockReasonFragment;
        }

        public final void afterTextChanged(Editable editable) {
            RoboTextView roboTextView = (RoboTextView) this.f56047a.a(R.id.tv_characters_limit);
            if (roboTextView != null) {
                aa aaVar = aa.f47921a;
                AccountBlockReasonFragment accountBlockReasonFragment = this.f56047a;
                int i2 = R.string.lbl_char_limit;
                Object[] objArr = new Object[1];
                objArr[0] = String.valueOf(editable != null ? Integer.valueOf(editable.length()) : null);
                String string = accountBlockReasonFragment.getString(i2, objArr);
                k.a((Object) string, "getString(R.string.lbl_c…mit,s?.length.toString())");
                String format = String.format(string, Arrays.copyOf(new Object[0], 0));
                k.a((Object) format, "java.lang.String.format(format, *args)");
                roboTextView.setText(format);
            }
        }
    }

    public final void onClick(View view) {
        CharSequence charSequence = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.progressBtn;
        if (valueOf != null && valueOf.intValue() == i2) {
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) a(R.id.radioBtn1);
            k.a((Object) appCompatRadioButton, "radioBtn1");
            if (!appCompatRadioButton.isChecked()) {
                AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) a(R.id.radioBtn2);
                k.a((Object) appCompatRadioButton2, "radioBtn2");
                if (!appCompatRadioButton2.isChecked()) {
                    AppCompatRadioButton appCompatRadioButton3 = (AppCompatRadioButton) a(R.id.radioBtn3);
                    k.a((Object) appCompatRadioButton3, "radioBtn3");
                    if (!appCompatRadioButton3.isChecked()) {
                        String str = this.f56036f;
                        String string = getString(R.string.lbl_no_reason_selected);
                        k.a((Object) string, "getString(R.string.lbl_no_reason_selected)");
                        v.a("/diy_block_reason", str, Events.Action.PROCEED_CLICKED, kotlin.a.k.d("", string, AppManagerUtil.EXTEND_PREFIX_DEFAULT), 16);
                        net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.select_reason_to_proceed), (View.OnClickListener) f.f56046a);
                        return;
                    }
                }
            }
            a aVar = new a();
            a.b bVar = this;
            k.c(bVar, "listener");
            aVar.f56274a = bVar;
            q a2 = getChildFragmentManager().a();
            k.a((Object) a2, "childFragmentManager.beginTransaction()");
            a2.a((Fragment) aVar, a.f56273b.getClass().getName());
            a2.c();
            return;
        }
        int i3 = R.id.radioBtn1;
        if (valueOf != null && valueOf.intValue() == i3) {
            AppCompatRadioButton appCompatRadioButton4 = (AppCompatRadioButton) a(R.id.radioBtn1);
            this.f56034d = String.valueOf(appCompatRadioButton4 != null ? appCompatRadioButton4.getText() : null);
            AppCompatRadioButton appCompatRadioButton5 = (AppCompatRadioButton) a(R.id.radioBtn1);
            if (appCompatRadioButton5 != null) {
                charSequence = appCompatRadioButton5.getText();
            }
            this.f56033c = String.valueOf(charSequence);
            this.f56039i = "";
            AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.tv_description);
            if (appCompatEditText != null) {
                appCompatEditText.setText("");
            }
            d();
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.tv_description);
            if (appCompatEditText2 != null) {
                appCompatEditText2.setVisibility(8);
            }
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_characters_limit);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
            e();
            return;
        }
        int i4 = R.id.radioBtn2;
        if (valueOf != null && valueOf.intValue() == i4) {
            AppCompatRadioButton appCompatRadioButton6 = (AppCompatRadioButton) a(R.id.radioBtn2);
            this.f56034d = String.valueOf(appCompatRadioButton6 != null ? appCompatRadioButton6.getText() : null);
            AppCompatRadioButton appCompatRadioButton7 = (AppCompatRadioButton) a(R.id.radioBtn2);
            if (appCompatRadioButton7 != null) {
                charSequence = appCompatRadioButton7.getText();
            }
            this.f56033c = String.valueOf(charSequence);
            this.f56039i = "";
            AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.tv_description);
            if (appCompatEditText3 != null) {
                appCompatEditText3.setText("");
            }
            d();
            AppCompatEditText appCompatEditText4 = (AppCompatEditText) a(R.id.tv_description);
            if (appCompatEditText4 != null) {
                appCompatEditText4.setVisibility(8);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_characters_limit);
            if (roboTextView2 != null) {
                roboTextView2.setVisibility(8);
            }
            e();
            return;
        }
        int i5 = R.id.radioBtn3;
        if (valueOf != null && valueOf.intValue() == i5) {
            AppCompatRadioButton appCompatRadioButton8 = (AppCompatRadioButton) a(R.id.radioBtn3);
            this.f56034d = String.valueOf(appCompatRadioButton8 != null ? appCompatRadioButton8.getText() : null);
            AppCompatRadioButton appCompatRadioButton9 = (AppCompatRadioButton) a(R.id.radioBtn3);
            if (appCompatRadioButton9 != null) {
                charSequence = appCompatRadioButton9.getText();
            }
            this.f56033c = String.valueOf(charSequence);
            AppCompatEditText appCompatEditText5 = (AppCompatEditText) a(R.id.tv_description);
            if (appCompatEditText5 != null) {
                appCompatEditText5.setVisibility(0);
            }
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_characters_limit);
            if (roboTextView3 != null) {
                roboTextView3.setVisibility(0);
            }
            d();
            e();
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) a(R.id.radioBtn3);
        k.a((Object) appCompatRadioButton, "radioBtn3");
        if (appCompatRadioButton.isChecked()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f56033c);
            sb.append(AppConstants.COMMA);
            AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.tv_description);
            sb.append(appCompatEditText != null ? appCompatEditText.getText() : null);
            this.f56033c = sb.toString();
        }
        if (this.f56032b == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.a(this.f56033c, this.f56037g, this.f56035e ? "STATE_CODE" : "session_token", UpiConstants.BANK_HEALTH_STATUS_BLOCK).observe(this, new a(this));
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockReasonFragment f56043a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ErrorModel f56044b;

        c(AccountBlockReasonFragment accountBlockReasonFragment, ErrorModel errorModel) {
            this.f56043a = accountBlockReasonFragment;
            this.f56044b = errorModel;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x003b, code lost:
            r1 = r1.getCustomError();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.content.DialogInterface r4, int r5) {
            /*
                r3 = this;
                net.one97.paytm.oauth.fragment.AccountBlockReasonFragment r4 = r3.f56043a
                int r5 = net.one97.paytm.oauth.R.id.progressBtn
                android.view.View r4 = r4.a((int) r5)
                net.one97.paytm.oauth.view.ProgressViewButton r4 = (net.one97.paytm.oauth.view.ProgressViewButton) r4
                if (r4 == 0) goto L_0x000f
                r4.c()
            L_0x000f:
                net.one97.paytm.oauth.fragment.AccountBlockReasonFragment r4 = r3.f56043a
                java.lang.String r4 = r4.f56036f
                r5 = 4
                java.lang.String[] r5 = new java.lang.String[r5]
                r0 = 0
                net.one97.paytm.oauth.fragment.AccountBlockReasonFragment r1 = r3.f56043a
                java.lang.String r1 = r1.f56034d
                r5[r0] = r1
                r0 = 1
                net.one97.paytm.oauth.fragment.AccountBlockReasonFragment r1 = r3.f56043a
                int r2 = net.one97.paytm.oauth.R.string.lbl_something_went_wrong
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r2 = "getString(R.string.lbl_something_went_wrong)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                r5[r0] = r1
                r0 = 2
                java.lang.String r1 = "api"
                r5[r0] = r1
                r0 = 3
                net.one97.paytm.oauth.models.ErrorModel r1 = r3.f56044b
                if (r1 == 0) goto L_0x0044
                com.paytm.network.model.NetworkCustomError r1 = r1.getCustomError()
                if (r1 == 0) goto L_0x0044
                com.paytm.network.model.NetworkResponse r1 = r1.networkResponse
                goto L_0x0045
            L_0x0044:
                r1 = 0
            L_0x0045:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r5[r0] = r1
                java.util.ArrayList r5 = kotlin.a.k.d(r5)
                r0 = 16
                java.lang.String r1 = "/diy_block_reason"
                java.lang.String r2 = "proceed_clicked"
                net.one97.paytm.oauth.fragment.v.a((java.lang.String) r1, (java.lang.String) r4, (java.lang.String) r2, (java.util.ArrayList) r5, (int) r0)
                net.one97.paytm.oauth.fragment.AccountBlockReasonFragment r4 = r3.f56043a
                r4.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountBlockReasonFragment.c.onClick(android.content.DialogInterface, int):void");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockReasonFragment f56041a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ErrorModel f56042b;

        b(AccountBlockReasonFragment accountBlockReasonFragment, ErrorModel errorModel) {
            this.f56041a = accountBlockReasonFragment;
            this.f56042b = errorModel;
        }

        public final void onClick(View view) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            FragmentActivity requireActivity = this.f56041a.requireActivity();
            if (requireActivity != null) {
                b2.handleSessionTimeOut((AppCompatActivity) requireActivity, this.f56042b.getCustomError(), (String) null, (Bundle) null, true, false);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    private final void d() {
        RoboTextView roboTextView;
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.tv_description);
        if (TextUtils.isEmpty(appCompatEditText != null ? appCompatEditText.getText() : null) && (roboTextView = (RoboTextView) a(R.id.tv_characters_limit)) != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.lbl_char_limit);
            k.a((Object) string, "getString(R.string.lbl_char_limit)");
            String format = String.format(string, Arrays.copyOf(new Object[]{0}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView.setText(format);
        }
    }

    private final void e() {
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) a(R.id.radioBtn1);
        k.a((Object) appCompatRadioButton, "radioBtn1");
        if (appCompatRadioButton.isChecked()) {
            AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) a(R.id.radioBtn1);
            if (appCompatRadioButton2 != null) {
                appCompatRadioButton2.setTypeface((Typeface) null, 1);
            }
            AppCompatRadioButton appCompatRadioButton3 = (AppCompatRadioButton) a(R.id.radioBtn2);
            if (appCompatRadioButton3 != null) {
                appCompatRadioButton3.setTypeface((Typeface) null, 0);
            }
            AppCompatRadioButton appCompatRadioButton4 = (AppCompatRadioButton) a(R.id.radioBtn3);
            if (appCompatRadioButton4 != null) {
                appCompatRadioButton4.setTypeface((Typeface) null, 0);
                return;
            }
            return;
        }
        AppCompatRadioButton appCompatRadioButton5 = (AppCompatRadioButton) a(R.id.radioBtn2);
        k.a((Object) appCompatRadioButton5, "radioBtn2");
        if (appCompatRadioButton5.isChecked()) {
            AppCompatRadioButton appCompatRadioButton6 = (AppCompatRadioButton) a(R.id.radioBtn1);
            if (appCompatRadioButton6 != null) {
                appCompatRadioButton6.setTypeface((Typeface) null, 0);
            }
            AppCompatRadioButton appCompatRadioButton7 = (AppCompatRadioButton) a(R.id.radioBtn2);
            if (appCompatRadioButton7 != null) {
                appCompatRadioButton7.setTypeface((Typeface) null, 1);
            }
            AppCompatRadioButton appCompatRadioButton8 = (AppCompatRadioButton) a(R.id.radioBtn3);
            if (appCompatRadioButton8 != null) {
                appCompatRadioButton8.setTypeface((Typeface) null, 0);
                return;
            }
            return;
        }
        AppCompatRadioButton appCompatRadioButton9 = (AppCompatRadioButton) a(R.id.radioBtn1);
        if (appCompatRadioButton9 != null) {
            appCompatRadioButton9.setTypeface((Typeface) null, 0);
        }
        AppCompatRadioButton appCompatRadioButton10 = (AppCompatRadioButton) a(R.id.radioBtn2);
        if (appCompatRadioButton10 != null) {
            appCompatRadioButton10.setTypeface((Typeface) null, 0);
        }
        AppCompatRadioButton appCompatRadioButton11 = (AppCompatRadioButton) a(R.id.radioBtn3);
        if (appCompatRadioButton11 != null) {
            appCompatRadioButton11.setTypeface((Typeface) null, 1);
        }
    }

    public final void aa_() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.progressBtn);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        b();
    }

    private final void f() {
        h.b b2 = h.b();
        k.a((Object) b2, "AccountBlockReasonFragme…ionAccountBlockTerminal()");
        b2.c();
        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) b2);
    }

    public static final /* synthetic */ void a(AccountBlockReasonFragment accountBlockReasonFragment, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof AccountBlockStatusResModel) {
            AccountBlockStatusResModel accountBlockStatusResModel = (AccountBlockStatusResModel) iJRPaytmDataModel;
            String responseCode = accountBlockStatusResModel.getResponseCode();
            if (responseCode != null && responseCode.hashCode() == -1260518837 && responseCode.equals("BE1400001")) {
                v.a("/diy_block_reason", accountBlockReasonFragment.f56036f, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(accountBlockReasonFragment.f56034d), 16);
                h.a a2 = h.a();
                k.a((Object) a2, "AccountBlockReasonFragme…onAccountBlockConfirmed()");
                a2.a(accountBlockReasonFragment.f56035e);
                a2.a(accountBlockReasonFragment.f56038h);
                androidx.navigation.fragment.a.a(accountBlockReasonFragment).a((androidx.navigation.l) a2);
                return;
            }
            v.a("/diy_block_reason", accountBlockReasonFragment.f56036f, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(accountBlockReasonFragment.f56034d, String.valueOf(accountBlockStatusResModel.getMessage()), SDKConstants.KEY_API, String.valueOf(accountBlockStatusResModel.getResponseCode())), 16);
            accountBlockReasonFragment.f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r5 != r15.intValue()) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0103, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) "BE1426028") != false) goto L_0x011c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.oauth.fragment.AccountBlockReasonFragment r17, net.one97.paytm.oauth.models.ErrorModel r18) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "responseCode"
            androidx.fragment.app.FragmentActivity r3 = r17.getActivity()
            android.app.Activity r3 = (android.app.Activity) r3
            r4 = r0
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            if (r1 == 0) goto L_0x0016
            com.paytm.network.model.NetworkCustomError r6 = r18.getCustomError()
            goto L_0x0017
        L_0x0016:
            r6 = 0
        L_0x0017:
            boolean r3 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r3, (androidx.fragment.app.Fragment) r4, (com.paytm.network.model.NetworkCustomError) r6)
            if (r3 != 0) goto L_0x01e4
            android.content.Context r3 = r17.requireContext()
            net.one97.paytm.oauth.fragment.AccountBlockReasonFragment$c r4 = new net.one97.paytm.oauth.fragment.AccountBlockReasonFragment$c
            r4.<init>(r0, r1)
            android.content.DialogInterface$OnClickListener r4 = (android.content.DialogInterface.OnClickListener) r4
            boolean r3 = net.one97.paytm.oauth.utils.l.a(r1, r3, r4)
            if (r3 != 0) goto L_0x01e4
            if (r1 == 0) goto L_0x0035
            com.paytm.network.model.NetworkCustomError r3 = r18.getCustomError()
            goto L_0x0036
        L_0x0035:
            r3 = 0
        L_0x0036:
            boolean r3 = r3 instanceof com.paytm.network.model.NetworkCustomError
            java.lang.String r4 = "getString(R.string.lbl_something_went_wrong)"
            java.lang.String r8 = "api"
            r9 = 2
            r10 = 1
            r11 = 0
            r12 = 4
            java.lang.String r13 = "proceed_clicked"
            java.lang.String r14 = "/diy_block_reason"
            if (r3 == 0) goto L_0x01ad
            com.paytm.network.model.NetworkCustomError r3 = r18.getCustomError()
            com.paytm.network.model.NetworkResponse r3 = r3.networkResponse
            byte[] r3 = r3.data
            if (r3 == 0) goto L_0x01ac
            java.lang.String r15 = new java.lang.String
            java.nio.charset.Charset r5 = kotlin.m.d.f47971a
            r15.<init>(r3, r5)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r5 = android.text.TextUtils.isEmpty(r15)
            if (r5 != 0) goto L_0x0177
            java.lang.String r4 = new java.lang.String     // Catch:{ JSONException -> 0x0173 }
            java.nio.charset.Charset r5 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x0173 }
            r4.<init>(r3, r5)     // Catch:{ JSONException -> 0x0173 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0173 }
            r3.<init>(r4)     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r4 = r3.getString(r2)     // Catch:{ JSONException -> 0x0173 }
            int r5 = r18.getStatus()     // Catch:{ JSONException -> 0x0173 }
            java.lang.Integer r15 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r6 = "jsonObj.getString(KEY_MESSAGE)"
            java.lang.String r7 = "message"
            if (r15 != 0) goto L_0x007c
            goto L_0x0082
        L_0x007c:
            int r15 = r15.intValue()     // Catch:{ JSONException -> 0x0173 }
            if (r5 == r15) goto L_0x014d
        L_0x0082:
            int r5 = r18.getStatus()     // Catch:{ JSONException -> 0x0173 }
            java.lang.Integer r15 = net.one97.paytm.oauth.utils.n.f56789h     // Catch:{ JSONException -> 0x0173 }
            if (r15 != 0) goto L_0x008b
            goto L_0x009b
        L_0x008b:
            int r15 = r15.intValue()     // Catch:{ JSONException -> 0x0173 }
            if (r5 != r15) goto L_0x009b
            java.lang.String r5 = "BE1426026"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x0173 }
            if (r5 == 0) goto L_0x009b
            goto L_0x014d
        L_0x009b:
            int r2 = r18.getStatus()     // Catch:{ JSONException -> 0x0173 }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56785d     // Catch:{ JSONException -> 0x0173 }
            if (r5 != 0) goto L_0x00a4
            goto L_0x00e6
        L_0x00a4:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0173 }
            if (r2 != r5) goto L_0x00e6
            java.lang.String r2 = "BE1426029"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x0173 }
            if (r2 == 0) goto L_0x00e6
            java.lang.String r2 = r0.f56036f     // Catch:{ JSONException -> 0x0173 }
            java.lang.String[] r5 = new java.lang.String[r12]     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r12 = r0.f56034d     // Catch:{ JSONException -> 0x0173 }
            r5[r11] = r12     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r3 = r3.getString(r7)     // Catch:{ JSONException -> 0x0173 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)     // Catch:{ JSONException -> 0x0173 }
            r5[r10] = r3     // Catch:{ JSONException -> 0x0173 }
            r5[r9] = r8     // Catch:{ JSONException -> 0x0173 }
            r3 = 3
            r5[r3] = r4     // Catch:{ JSONException -> 0x0173 }
            java.util.ArrayList r3 = kotlin.a.k.d(r5)     // Catch:{ JSONException -> 0x0173 }
            r4 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r2, (java.lang.String) r13, (java.util.ArrayList) r3, (int) r4)     // Catch:{ JSONException -> 0x0173 }
            android.content.Context r2 = r17.requireContext()     // Catch:{ JSONException -> 0x0173 }
            int r3 = net.one97.paytm.oauth.R.string.lbl_something_went_wrong     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ JSONException -> 0x0173 }
            net.one97.paytm.oauth.fragment.AccountBlockReasonFragment$b r4 = new net.one97.paytm.oauth.fragment.AccountBlockReasonFragment$b     // Catch:{ JSONException -> 0x0173 }
            r4.<init>(r0, r1)     // Catch:{ JSONException -> 0x0173 }
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4     // Catch:{ JSONException -> 0x0173 }
            net.one97.paytm.oauth.d.a.a((android.content.Context) r2, (java.lang.String) r3, (android.view.View.OnClickListener) r4)     // Catch:{ JSONException -> 0x0173 }
            return
        L_0x00e6:
            int r2 = r18.getStatus()     // Catch:{ JSONException -> 0x0173 }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56786e     // Catch:{ JSONException -> 0x0173 }
            if (r5 != 0) goto L_0x00ef
            goto L_0x0105
        L_0x00ef:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0173 }
            if (r2 != r5) goto L_0x0105
            java.lang.String r2 = "BE1526003"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x0173 }
            if (r2 != 0) goto L_0x011c
            java.lang.String r2 = "BE1426028"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x0173 }
            if (r2 != 0) goto L_0x011c
        L_0x0105:
            int r1 = r18.getStatus()     // Catch:{ JSONException -> 0x0173 }
            java.lang.Integer r2 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x0173 }
            if (r2 != 0) goto L_0x010e
            return
        L_0x010e:
            int r2 = r2.intValue()     // Catch:{ JSONException -> 0x0173 }
            if (r1 != r2) goto L_0x014c
            java.lang.String r1 = "BE1426030"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x0173 }
            if (r1 == 0) goto L_0x014c
        L_0x011c:
            java.lang.String r1 = r0.f56036f     // Catch:{ JSONException -> 0x0173 }
            java.lang.String[] r2 = new java.lang.String[r12]     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r5 = r0.f56034d     // Catch:{ JSONException -> 0x0173 }
            r2[r11] = r5     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r3 = r3.getString(r7)     // Catch:{ JSONException -> 0x0173 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)     // Catch:{ JSONException -> 0x0173 }
            r2[r10] = r3     // Catch:{ JSONException -> 0x0173 }
            r2[r9] = r8     // Catch:{ JSONException -> 0x0173 }
            r3 = 3
            r2[r3] = r4     // Catch:{ JSONException -> 0x0173 }
            java.util.ArrayList r2 = kotlin.a.k.d(r2)     // Catch:{ JSONException -> 0x0173 }
            r3 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r1, (java.lang.String) r13, (java.util.ArrayList) r2, (int) r3)     // Catch:{ JSONException -> 0x0173 }
            android.content.Context r1 = r17.requireContext()     // Catch:{ JSONException -> 0x0173 }
            int r2 = net.one97.paytm.oauth.R.string.lbl_could_not_process_request     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x0173 }
            net.one97.paytm.oauth.fragment.AccountBlockReasonFragment$d r3 = net.one97.paytm.oauth.fragment.AccountBlockReasonFragment.d.f56045a     // Catch:{ JSONException -> 0x0173 }
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3     // Catch:{ JSONException -> 0x0173 }
            net.one97.paytm.oauth.d.a.a((android.content.Context) r1, (java.lang.String) r2, (android.view.View.OnClickListener) r3)     // Catch:{ JSONException -> 0x0173 }
        L_0x014c:
            return
        L_0x014d:
            java.lang.String r1 = r0.f56036f     // Catch:{ JSONException -> 0x0173 }
            java.lang.String[] r5 = new java.lang.String[r12]     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r12 = r0.f56034d     // Catch:{ JSONException -> 0x0173 }
            r5[r11] = r12     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r3 = r3.getString(r7)     // Catch:{ JSONException -> 0x0173 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)     // Catch:{ JSONException -> 0x0173 }
            r5[r10] = r3     // Catch:{ JSONException -> 0x0173 }
            r5[r9] = r8     // Catch:{ JSONException -> 0x0173 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0173 }
            r2 = 3
            r5[r2] = r4     // Catch:{ JSONException -> 0x0173 }
            java.util.ArrayList r2 = kotlin.a.k.d(r5)     // Catch:{ JSONException -> 0x0173 }
            r3 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r1, (java.lang.String) r13, (java.util.ArrayList) r2, (int) r3)     // Catch:{ JSONException -> 0x0173 }
            r17.f()     // Catch:{ JSONException -> 0x0173 }
            return
        L_0x0173:
            r17.f()
            return
        L_0x0177:
            java.lang.String r2 = r0.f56036f
            java.lang.String[] r3 = new java.lang.String[r12]
            java.lang.String r5 = r0.f56034d
            r3[r11] = r5
            int r5 = net.one97.paytm.oauth.R.string.lbl_something_went_wrong
            java.lang.String r5 = r0.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            r3[r10] = r5
            r3[r9] = r8
            com.paytm.network.model.NetworkCustomError r1 = r18.getCustomError()
            if (r1 == 0) goto L_0x0197
            com.paytm.network.model.NetworkResponse r5 = r1.networkResponse
            r16 = r5
            goto L_0x0199
        L_0x0197:
            r16 = 0
        L_0x0199:
            java.lang.String r1 = java.lang.String.valueOf(r16)
            r4 = 3
            r3[r4] = r1
            java.util.ArrayList r1 = kotlin.a.k.d(r3)
            r3 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r2, (java.lang.String) r13, (java.util.ArrayList) r1, (int) r3)
            r17.f()
        L_0x01ac:
            return
        L_0x01ad:
            java.lang.String r2 = r0.f56036f
            java.lang.String[] r3 = new java.lang.String[r12]
            java.lang.String r5 = r0.f56034d
            r3[r11] = r5
            int r5 = net.one97.paytm.oauth.R.string.lbl_something_went_wrong
            java.lang.String r5 = r0.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            r3[r10] = r5
            r3[r9] = r8
            if (r1 == 0) goto L_0x01cf
            com.paytm.network.model.NetworkCustomError r1 = r18.getCustomError()
            if (r1 == 0) goto L_0x01cf
            com.paytm.network.model.NetworkResponse r5 = r1.networkResponse
            r16 = r5
            goto L_0x01d1
        L_0x01cf:
            r16 = 0
        L_0x01d1:
            java.lang.String r1 = java.lang.String.valueOf(r16)
            r4 = 3
            r3[r4] = r1
            java.util.ArrayList r1 = kotlin.a.k.d(r3)
            r3 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r14, (java.lang.String) r2, (java.lang.String) r13, (java.util.ArrayList) r1, (int) r3)
            r17.f()
        L_0x01e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountBlockReasonFragment.a(net.one97.paytm.oauth.fragment.AccountBlockReasonFragment, net.one97.paytm.oauth.models.ErrorModel):void");
    }
}
