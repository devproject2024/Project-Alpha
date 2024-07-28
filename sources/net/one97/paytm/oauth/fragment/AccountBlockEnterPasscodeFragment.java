package net.one97.paytm.oauth.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.f;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class AccountBlockEnterPasscodeFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56014a = {y.a((t) new u(y.b(AccountBlockEnterPasscodeFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private boolean f56015b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<AppCompatEditText> f56016c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.oauth.g.a f56017d;

    /* renamed from: e  reason: collision with root package name */
    private String f56018e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f56019f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f56020g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f56021h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f56022i;
    private String j;
    private final String k = "true";
    private final View.OnFocusChangeListener l = new g(this);
    private final h m = new h(this);
    private final View.OnKeyListener n = new f(this);
    private HashMap o;

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56027a = new d();

        d() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.o.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
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

    static final class a<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterPasscodeFragment f56023a;

        a(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment) {
            this.f56023a = accountBlockEnterPasscodeFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56023a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountBlockEnterPasscodeFragment.a(this.f56023a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountBlockEnterPasscodeFragment.a(this.f56023a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterPasscodeFragment f56024a;

        b(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment) {
            this.f56024a = accountBlockEnterPasscodeFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56024a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountBlockEnterPasscodeFragment.a(this.f56024a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountBlockEnterPasscodeFragment.a(this.f56024a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    public static final /* synthetic */ ArrayList a(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment) {
        ArrayList<AppCompatEditText> arrayList = accountBlockEnterPasscodeFragment.f56016c;
        if (arrayList == null) {
            k.a("passcodeEditViewsArr");
        }
        return arrayList;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_account_block_enter_passcode, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f56015b) {
            ImageView imageView = (ImageView) a(R.id.passcode_hide_show_icon);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.showpassword);
            }
        } else {
            ImageView imageView2 = (ImageView) a(R.id.passcode_hide_show_icon);
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.hidepasswrd);
            }
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.edit1);
        k.a((Object) appCompatEditText, "edit1");
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.edit2);
        k.a((Object) appCompatEditText2, "edit2");
        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.edit3);
        k.a((Object) appCompatEditText3, "edit3");
        AppCompatEditText appCompatEditText4 = (AppCompatEditText) a(R.id.edit4);
        k.a((Object) appCompatEditText4, "edit4");
        this.f56016c = kotlin.a.k.d(appCompatEditText, appCompatEditText2, appCompatEditText3, appCompatEditText4);
        ImageView imageView3 = (ImageView) a(R.id.passcode_hide_show_icon);
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_forgot_passcode);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        ArrayList<AppCompatEditText> arrayList = this.f56016c;
        if (arrayList == null) {
            k.a("passcodeEditViewsArr");
        }
        Iterator<AppCompatEditText> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AppCompatEditText next = it2.next();
            next.setOnClickListener(this);
            k.a((Object) next, "editText");
            next.setOnFocusChangeListener(this.l);
            next.addTextChangedListener(this.m);
            next.setOnKeyListener(this.n);
            next.setTransformationMethod(new PasswordTransformationMethod());
        }
        kotlin.g dVar = new androidx.navigation.d(y.b(e.class), new e(this));
        String a2 = ((e) dVar.getValue()).a();
        if (a2 == null) {
            a2 = "";
        }
        this.f56018e = a2;
        String b2 = ((e) dVar.getValue()).b();
        if (b2 == null) {
            b2 = "";
        }
        this.f56020g = b2;
        String c2 = ((e) dVar.getValue()).c();
        if (c2 == null) {
            c2 = "";
        }
        this.f56021h = c2;
        this.f56022i = ((e) dVar.getValue()).d();
        this.j = ((e) dVar.getValue()).e();
        ai a3 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.a.class);
        k.a((Object) a3, "ViewModelProviders.of(th…ockViewModel::class.java)");
        this.f56017d = (net.one97.paytm.oauth.g.a) a3;
        v.a("/passcode_verification", "diy_block_logout", "passcode_page_loaded", (ArrayList) null, 24);
        OAuthUtils.a((EditText) (AppCompatEditText) a(R.id.edit1));
    }

    private final void a(String str, String str2) {
        if (this.f56017d == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.a(str, str2, "passcode").observe(this, new a(this));
    }

    private final void b() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56017d == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.a(this.f56022i).observe(this, new b(this));
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterPasscodeFragment f56025a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56026b;

        c(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment, String str) {
            this.f56025a = accountBlockEnterPasscodeFragment;
            this.f56026b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AccountBlockEnterPasscodeFragment.a(this.f56025a, this.f56026b);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x000c
            int r8 = r8.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x000d
        L_0x000c:
            r8 = r0
        L_0x000d:
            int r1 = net.one97.paytm.oauth.R.id.btnProceed
            java.lang.String r2 = "diy_block_logout"
            java.lang.String r3 = "/passcode_verification"
            r4 = 1
            r5 = 0
            if (r8 != 0) goto L_0x0019
            goto L_0x0173
        L_0x0019:
            int r6 = r8.intValue()
            if (r6 != r1) goto L_0x0173
            int r8 = net.one97.paytm.oauth.R.id.edit1
            android.view.View r8 = r7.a((int) r8)
            androidx.appcompat.widget.AppCompatEditText r8 = (androidx.appcompat.widget.AppCompatEditText) r8
            java.lang.String r1 = "edit1"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            android.text.Editable r8 = r8.getText()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0085
            int r8 = net.one97.paytm.oauth.R.id.edit2
            android.view.View r8 = r7.a((int) r8)
            androidx.appcompat.widget.AppCompatEditText r8 = (androidx.appcompat.widget.AppCompatEditText) r8
            java.lang.String r1 = "edit2"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            android.text.Editable r8 = r8.getText()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0085
            int r8 = net.one97.paytm.oauth.R.id.edit3
            android.view.View r8 = r7.a((int) r8)
            androidx.appcompat.widget.AppCompatEditText r8 = (androidx.appcompat.widget.AppCompatEditText) r8
            java.lang.String r1 = "edit3"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            android.text.Editable r8 = r8.getText()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0085
            int r8 = net.one97.paytm.oauth.R.id.edit4
            android.view.View r8 = r7.a((int) r8)
            androidx.appcompat.widget.AppCompatEditText r8 = (androidx.appcompat.widget.AppCompatEditText) r8
            java.lang.String r1 = "edit4"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            android.text.Editable r8 = r8.getText()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0085
            r8 = 1
            goto L_0x0086
        L_0x0085:
            r8 = 0
        L_0x0086:
            if (r8 == 0) goto L_0x012e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r8.<init>(r1)
            int r1 = net.one97.paytm.oauth.R.id.edit1
            android.view.View r1 = r7.a((int) r1)
            androidx.appcompat.widget.AppCompatEditText r1 = (androidx.appcompat.widget.AppCompatEditText) r1
            if (r1 == 0) goto L_0x009e
            android.text.Editable r1 = r1.getText()
            goto L_0x009f
        L_0x009e:
            r1 = r0
        L_0x009f:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r8.append(r1)
            int r1 = net.one97.paytm.oauth.R.id.edit2
            android.view.View r1 = r7.a((int) r1)
            androidx.appcompat.widget.AppCompatEditText r1 = (androidx.appcompat.widget.AppCompatEditText) r1
            if (r1 == 0) goto L_0x00b5
            android.text.Editable r1 = r1.getText()
            goto L_0x00b6
        L_0x00b5:
            r1 = r0
        L_0x00b6:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r8.append(r1)
            int r1 = net.one97.paytm.oauth.R.id.edit3
            android.view.View r1 = r7.a((int) r1)
            androidx.appcompat.widget.AppCompatEditText r1 = (androidx.appcompat.widget.AppCompatEditText) r1
            if (r1 == 0) goto L_0x00cc
            android.text.Editable r1 = r1.getText()
            goto L_0x00cd
        L_0x00cc:
            r1 = r0
        L_0x00cd:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r8.append(r1)
            int r1 = net.one97.paytm.oauth.R.id.edit4
            android.view.View r1 = r7.a((int) r1)
            androidx.appcompat.widget.AppCompatEditText r1 = (androidx.appcompat.widget.AppCompatEditText) r1
            if (r1 == 0) goto L_0x00e2
            android.text.Editable r0 = r1.getText()
        L_0x00e2:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r8.append(r0)
            com.google.gson.o r0 = new com.google.gson.o
            r0.<init>()
            java.lang.String r1 = r7.f56020g
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = r8.toString()
            r2.append(r8)
            java.lang.String r8 = r7.f56021h
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.lang.String r8 = net.one97.paytm.oauth.utils.OAuthUtils.b((java.lang.String) r1, (java.lang.String) r8)
            java.lang.String r1 = "data"
            r0.a((java.lang.String) r1, (java.lang.String) r8)
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "obj.toString()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            r7.f56019f = r8
            int r8 = net.one97.paytm.oauth.R.id.btnProceed
            android.view.View r8 = r7.a((int) r8)
            net.one97.paytm.oauth.view.ProgressViewButton r8 = (net.one97.paytm.oauth.view.ProgressViewButton) r8
            if (r8 == 0) goto L_0x0126
            r8.c()
        L_0x0126:
            java.lang.String r8 = r7.f56018e
            java.lang.String r0 = r7.f56019f
            r7.a((java.lang.String) r8, (java.lang.String) r0)
            return
        L_0x012e:
            int r8 = net.one97.paytm.oauth.R.string.lbl_invalid_passcode
            java.lang.String r8 = r7.getString(r8)
            java.lang.String r0 = "getString(R.string.lbl_invalid_passcode)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            r0 = 3
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = "passcode"
            r0[r5] = r1
            r0[r4] = r8
            r1 = 2
            java.lang.String r4 = "app"
            r0[r1] = r4
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            r1 = 16
            java.lang.String r4 = "proceed_clicked"
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r4, (java.util.ArrayList) r0, (int) r1)
            int r0 = net.one97.paytm.oauth.R.id.error_text_passcode
            android.view.View r0 = r7.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "error_text_passcode"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r5)
            int r0 = net.one97.paytm.oauth.R.id.error_text_passcode
            android.view.View r0 = r7.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
            return
        L_0x0173:
            int r1 = net.one97.paytm.oauth.R.id.passcode_hide_show_icon
            if (r8 != 0) goto L_0x0178
            goto L_0x01e9
        L_0x0178:
            int r6 = r8.intValue()
            if (r6 != r1) goto L_0x01e9
            boolean r8 = r7.f56015b
            java.lang.String r1 = "editText"
            java.lang.String r2 = "passcodeEditViewsArr"
            if (r8 == 0) goto L_0x01bb
            int r8 = net.one97.paytm.oauth.R.id.passcode_hide_show_icon
            android.view.View r8 = r7.a((int) r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            int r0 = net.one97.paytm.oauth.R.drawable.hidepasswrd
            r8.setImageResource(r0)
            java.util.ArrayList<androidx.appcompat.widget.AppCompatEditText> r8 = r7.f56016c
            if (r8 != 0) goto L_0x019a
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x019a:
            java.util.Iterator r8 = r8.iterator()
        L_0x019e:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x01b8
            java.lang.Object r0 = r8.next()
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.text.method.PasswordTransformationMethod r2 = new android.text.method.PasswordTransformationMethod
            r2.<init>()
            android.text.method.TransformationMethod r2 = (android.text.method.TransformationMethod) r2
            r0.setTransformationMethod(r2)
            goto L_0x019e
        L_0x01b8:
            r7.f56015b = r5
            return
        L_0x01bb:
            int r8 = net.one97.paytm.oauth.R.id.passcode_hide_show_icon
            android.view.View r8 = r7.a((int) r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            int r3 = net.one97.paytm.oauth.R.drawable.showpassword
            r8.setImageResource(r3)
            java.util.ArrayList<androidx.appcompat.widget.AppCompatEditText> r8 = r7.f56016c
            if (r8 != 0) goto L_0x01cf
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01cf:
            java.util.Iterator r8 = r8.iterator()
        L_0x01d3:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x01e6
            java.lang.Object r2 = r8.next()
            androidx.appcompat.widget.AppCompatEditText r2 = (androidx.appcompat.widget.AppCompatEditText) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r2.setTransformationMethod(r0)
            goto L_0x01d3
        L_0x01e6:
            r7.f56015b = r4
            return
        L_0x01e9:
            int r1 = net.one97.paytm.oauth.R.id.tv_forgot_passcode
            if (r8 != 0) goto L_0x01ee
            return
        L_0x01ee:
            int r8 = r8.intValue()
            if (r8 != r1) goto L_0x021f
            r8 = 24
            java.lang.String r1 = "forgot_passcode_clicked"
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r1, (java.util.ArrayList) r0, (int) r8)
            net.one97.paytm.oauth.fragment.ao r8 = new net.one97.paytm.oauth.fragment.ao
            r8.<init>()
            androidx.fragment.app.j r0 = r7.getChildFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            java.lang.String r1 = "childFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            net.one97.paytm.oauth.fragment.ao$a r1 = net.one97.paytm.oauth.fragment.ao.f56350b
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.a((androidx.fragment.app.Fragment) r8, (java.lang.String) r1)
            r0.c()
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment.onClick(android.view.View):void");
    }

    static final class g implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterPasscodeFragment f56029a;

        g(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment) {
            this.f56029a = accountBlockEnterPasscodeFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            Context context;
            int i2;
            if (this.f56029a.getActivity() == null) {
                return;
            }
            if (view != null) {
                EditText editText = (EditText) view;
                if (z) {
                    context = editText.getContext();
                    i2 = R.color.color_00b9f5;
                } else {
                    context = editText.getContext();
                    i2 = R.color.color_002e6e;
                }
                editText.setTextColor(androidx.core.content.b.c(context, i2));
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.EditText");
        }
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterPasscodeFragment f56030a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        h(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment) {
            this.f56030a = accountBlockEnterPasscodeFragment;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "s");
            if (this.f56030a.isVisible()) {
                Iterator it2 = AccountBlockEnterPasscodeFragment.a(this.f56030a).iterator();
                while (it2.hasNext()) {
                    AppCompatEditText appCompatEditText = (AppCompatEditText) it2.next();
                    k.a((Object) appCompatEditText, "editText");
                    if (TextUtils.isEmpty(String.valueOf(appCompatEditText.getText()))) {
                        break;
                    }
                    Editable text = appCompatEditText.getText();
                    if (text != null) {
                        appCompatEditText.setSelection(text.length());
                    }
                }
                RoboTextView roboTextView = (RoboTextView) this.f56030a.a(R.id.error_text_passcode);
                if (roboTextView != null) {
                    roboTextView.setVisibility(8);
                }
                AccountBlockEnterPasscodeFragment.b(this.f56030a);
            }
        }
    }

    static final class f implements View.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountBlockEnterPasscodeFragment f56028a;

        f(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment) {
            this.f56028a = accountBlockEnterPasscodeFragment;
        }

        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67) {
                return false;
            }
            k.a((Object) keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (keyEvent.getAction() != 0) {
                return false;
            }
            EditText editText = null;
            Iterator it2 = AccountBlockEnterPasscodeFragment.a(this.f56028a).iterator();
            while (it2.hasNext()) {
                AppCompatEditText appCompatEditText = (AppCompatEditText) it2.next();
                if (k.a((Object) view, (Object) appCompatEditText)) {
                    k.a((Object) appCompatEditText, "editText");
                    AccountBlockEnterPasscodeFragment.a((EditText) appCompatEditText, editText);
                }
                editText = appCompatEditText;
            }
            return true;
        }
    }

    private final void d() {
        f.b b2 = f.b();
        k.a((Object) b2, "AccountBlockEnterPasscod…ionAccountBlockTerminal()");
        b2.c();
        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) b2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0187, code lost:
        if (r2.equals("BE1426006") != false) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0190, code lost:
        if (r2.equals("BE1426005") != false) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0192, code lost:
        r16.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0195, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment r16, com.paytm.network.model.IJRPaytmDataModel r17) {
        /*
            r0 = r16
            r1 = r17
            boolean r2 = r1 instanceof net.one97.paytm.oauth.models.DoVerify
            if (r2 == 0) goto L_0x016c
            net.one97.paytm.oauth.models.DoVerify r1 = (net.one97.paytm.oauth.models.DoVerify) r1
            java.lang.String r2 = r1.getHttpStatus()
            r3 = 3
            java.lang.String r4 = "api"
            r5 = 2
            r6 = 1
            r7 = 4
            r8 = 16
            java.lang.String r9 = "passcode"
            r10 = 0
            java.lang.String r11 = "proceed_clicked"
            java.lang.String r12 = "diy_block_logout"
            java.lang.String r13 = "/passcode_verification"
            if (r2 != 0) goto L_0x0023
            goto L_0x013a
        L_0x0023:
            int r15 = r2.hashCode()
            r14 = 49586(0xc1b2, float:6.9485E-41)
            if (r15 == r14) goto L_0x002e
            goto L_0x013a
        L_0x002e:
            java.lang.String r14 = "200"
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x013a
            net.one97.paytm.oauth.models.ResultInfoResModel r2 = r1.getResultInfo()
            if (r2 == 0) goto L_0x0041
            java.lang.String r14 = r2.getResultCodeId()
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            if (r14 != 0) goto L_0x0046
            goto L_0x0107
        L_0x0046:
            int r2 = r14.hashCode()
            r15 = -1950136507(0xffffffff8bc34745, float:-7.52185E-32)
            if (r2 == r15) goto L_0x006d
            r15 = -1173940224(0xffffffffba071800, float:-5.1534176E-4)
            if (r2 == r15) goto L_0x0056
            goto L_0x0107
        L_0x0056:
            java.lang.String r2 = "00000000"
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L_0x0107
            java.lang.String[] r1 = new java.lang.String[]{r9}
            java.util.ArrayList r1 = kotlin.a.k.d(r1)
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r13, (java.lang.String) r12, (java.lang.String) r11, (java.util.ArrayList) r1, (int) r8)
            r16.b()
            return
        L_0x006d:
            java.lang.String r2 = "12011004"
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L_0x0107
            java.lang.String[] r2 = new java.lang.String[r7]
            r2[r10] = r9
            net.one97.paytm.oauth.models.ResultInfoResModel r7 = r1.getResultInfo()
            java.lang.String r7 = r7.getResultMsg()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r2[r6] = r7
            r2[r5] = r4
            net.one97.paytm.oauth.models.ResultInfoResModel r4 = r1.getResultInfo()
            java.lang.String r4 = r4.getResultCodeId()
            r2[r3] = r4
            java.util.ArrayList r2 = kotlin.a.k.d(r2)
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r13, (java.lang.String) r12, (java.lang.String) r11, (java.util.ArrayList) r2, (int) r8)
            java.lang.String r2 = r1.getCanRetry()
            java.lang.String r3 = r0.k
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x00ec
            java.util.ArrayList<androidx.appcompat.widget.AppCompatEditText> r2 = r0.f56016c
            if (r2 != 0) goto L_0x00af
            java.lang.String r3 = "passcodeEditViewsArr"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00af:
            java.util.Iterator r2 = r2.iterator()
        L_0x00b3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00c7
            java.lang.Object r3 = r2.next()
            androidx.appcompat.widget.AppCompatEditText r3 = (androidx.appcompat.widget.AppCompatEditText) r3
            java.lang.String r4 = ""
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x00b3
        L_0x00c7:
            int r2 = net.one97.paytm.oauth.R.id.error_text_passcode
            android.view.View r2 = r0.a((int) r2)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            if (r2 == 0) goto L_0x00d4
            r2.setVisibility(r10)
        L_0x00d4:
            int r2 = net.one97.paytm.oauth.R.id.error_text_passcode
            android.view.View r0 = r0.a((int) r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x00eb
            net.one97.paytm.oauth.models.ResultInfoResModel r1 = r1.getResultInfo()
            java.lang.String r1 = r1.getResultMsg()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00eb:
            return
        L_0x00ec:
            net.one97.paytm.oauth.fragment.f$b r1 = net.one97.paytm.oauth.fragment.f.b()
            java.lang.String r2 = "AccountBlockEnterPasscod…ionAccountBlockTerminal()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r1.c()
            net.one97.paytm.oauth.utils.TerminalPageState r2 = net.one97.paytm.oauth.utils.TerminalPageState.IS_LIMIT_EXCEED
            r1.a(r2)
            androidx.navigation.h r0 = androidx.navigation.fragment.a.a(r16)
            androidx.navigation.l r1 = (androidx.navigation.l) r1
            r0.a((androidx.navigation.l) r1)
            return
        L_0x0107:
            java.lang.String[] r2 = new java.lang.String[r7]
            r2[r10] = r9
            net.one97.paytm.oauth.models.ResultInfoResModel r7 = r1.getResultInfo()
            if (r7 == 0) goto L_0x0116
            java.lang.String r14 = r7.getResultMsg()
            goto L_0x0117
        L_0x0116:
            r14 = 0
        L_0x0117:
            java.lang.String r7 = java.lang.String.valueOf(r14)
            r2[r6] = r7
            r2[r5] = r4
            net.one97.paytm.oauth.models.ResultInfoResModel r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x012a
            java.lang.String r14 = r1.getResultCodeId()
            goto L_0x012b
        L_0x012a:
            r14 = 0
        L_0x012b:
            java.lang.String r1 = java.lang.String.valueOf(r14)
            r2[r3] = r1
            java.util.ArrayList r1 = kotlin.a.k.d(r2)
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r13, (java.lang.String) r12, (java.lang.String) r11, (java.util.ArrayList) r1, (int) r8)
            goto L_0x01c0
        L_0x013a:
            java.lang.String[] r2 = new java.lang.String[r7]
            r2[r10] = r9
            net.one97.paytm.oauth.models.ResultInfoResModel r7 = r1.getResultInfo()
            if (r7 == 0) goto L_0x0149
            java.lang.String r14 = r7.getResultMsg()
            goto L_0x014a
        L_0x0149:
            r14 = 0
        L_0x014a:
            java.lang.String r7 = java.lang.String.valueOf(r14)
            r2[r6] = r7
            r2[r5] = r4
            net.one97.paytm.oauth.models.ResultInfoResModel r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x015d
            java.lang.String r14 = r1.getResultCodeId()
            goto L_0x015e
        L_0x015d:
            r14 = 0
        L_0x015e:
            java.lang.String r1 = java.lang.String.valueOf(r14)
            r2[r3] = r1
            java.util.ArrayList r1 = kotlin.a.k.d(r2)
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r13, (java.lang.String) r12, (java.lang.String) r11, (java.util.ArrayList) r1, (int) r8)
            goto L_0x01c0
        L_0x016c:
            boolean r2 = r1 instanceof net.one97.paytm.oauth.models.VerificationResModel
            if (r2 == 0) goto L_0x01c3
            net.one97.paytm.oauth.models.VerificationResModel r1 = (net.one97.paytm.oauth.models.VerificationResModel) r1
            java.lang.String r2 = r1.getResponseCode()
            if (r2 != 0) goto L_0x0179
            goto L_0x01c0
        L_0x0179:
            int r3 = r2.hashCode()
            switch(r3) {
                case -1260518837: goto L_0x0196;
                case -1258493045: goto L_0x018a;
                case -1258493044: goto L_0x0181;
                default: goto L_0x0180;
            }
        L_0x0180:
            goto L_0x01c0
        L_0x0181:
            java.lang.String r1 = "BE1426006"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x01c0
            goto L_0x0192
        L_0x018a:
            java.lang.String r1 = "BE1426005"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x01c0
        L_0x0192:
            r16.d()
            return
        L_0x0196:
            java.lang.String r3 = "BE1400001"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x01c0
            net.one97.paytm.oauth.fragment.f$a r2 = net.one97.paytm.oauth.fragment.f.a()
            java.lang.String r3 = "AccountBlockEnterPasscod…ctionAccountBlockReason()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r2.c()
            java.lang.String r1 = r1.getStateCode()
            r2.a(r1)
            java.lang.String r1 = r0.j
            r2.b(r1)
            androidx.navigation.h r0 = androidx.navigation.fragment.a.a(r16)
            androidx.navigation.l r2 = (androidx.navigation.l) r2
            r0.a((androidx.navigation.l) r2)
            return
        L_0x01c0:
            r16.d()
        L_0x01c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment.a(net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment, com.paytm.network.model.IJRPaytmDataModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00da, code lost:
        if (r9 != r0.intValue()) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0109, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) "BE1426003") != false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0120, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) "BE1426001") != false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0122, code lost:
        net.one97.paytm.oauth.d.a.a(r7.requireContext(), r7.getString(net.one97.paytm.oauth.R.string.lbl_could_not_process_request), (android.view.View.OnClickListener) net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment.d.f56027a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0133, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment r7, net.one97.paytm.oauth.models.ErrorModel r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "responseCode"
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            android.app.Activity r1 = (android.app.Activity) r1
            r2 = r7
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            com.paytm.network.model.NetworkCustomError r3 = r8.getCustomError()
            boolean r1 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r1, (androidx.fragment.app.Fragment) r2, (com.paytm.network.model.NetworkCustomError) r3)
            if (r1 != 0) goto L_0x0161
            int r1 = r8.getStatus()
            r2 = -1
            if (r1 != r2) goto L_0x0041
            int r8 = net.one97.paytm.oauth.R.string.no_connection
            java.lang.String r8 = r7.getString(r8)
            java.lang.String r0 = "getString(R.string.no_connection)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            int r0 = net.one97.paytm.oauth.R.string.no_internet
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = "getString(R.string.no_internet)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r1 = r7.requireContext()
            net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment$c r2 = new net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment$c
            r2.<init>(r7, r9)
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            net.one97.paytm.oauth.utils.OAuthUtils.a(r1, r8, r0, r2)
            return
        L_0x0041:
            com.paytm.network.model.NetworkCustomError r1 = r8.getCustomError()
            boolean r1 = r1 instanceof com.paytm.network.model.NetworkCustomError
            if (r1 == 0) goto L_0x015e
            com.paytm.network.model.NetworkCustomError r1 = r8.getCustomError()
            com.paytm.network.model.NetworkResponse r1 = r1.networkResponse
            byte[] r1 = r1.data
            if (r1 == 0) goto L_0x015d
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = kotlin.m.d.f47971a
            r2.<init>(r1, r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x015a
            java.lang.String r2 = new java.lang.String     // Catch:{ JSONException -> 0x015a }
            java.nio.charset.Charset r3 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x015a }
            r2.<init>(r1, r3)     // Catch:{ JSONException -> 0x015a }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x015a }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x015a }
            java.lang.String r1 = r1.getString(r0)     // Catch:{ JSONException -> 0x015a }
            if (r9 != 0) goto L_0x0076
            goto L_0x0156
        L_0x0076:
            int r2 = r9.hashCode()     // Catch:{ JSONException -> 0x015a }
            r3 = 875734478(0x3432a5ce, float:1.6637861E-7)
            if (r2 == r3) goto L_0x00c3
            r3 = 1860343963(0x6ee2989b, float:3.506405E28)
            if (r2 == r3) goto L_0x0086
            goto L_0x0156
        L_0x0086:
            java.lang.String r2 = "oauthDoVerify"
            boolean r9 = r9.equals(r2)     // Catch:{ JSONException -> 0x015a }
            if (r9 == 0) goto L_0x0156
            java.lang.String r9 = "/passcode_verification"
            java.lang.String r2 = "diy_block_logout"
            java.lang.String r3 = "proceed_clicked"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x015a }
            r5 = 0
            java.lang.String r6 = "passcode"
            r4[r5] = r6     // Catch:{ JSONException -> 0x015a }
            r5 = 1
            com.paytm.network.model.NetworkCustomError r8 = r8.getCustomError()     // Catch:{ JSONException -> 0x015a }
            java.lang.String r8 = r8.getMessage()     // Catch:{ JSONException -> 0x015a }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ JSONException -> 0x015a }
            r4[r5] = r8     // Catch:{ JSONException -> 0x015a }
            r8 = 2
            java.lang.String r5 = "api"
            r4[r8] = r5     // Catch:{ JSONException -> 0x015a }
            r8 = 3
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)     // Catch:{ JSONException -> 0x015a }
            r4[r8] = r1     // Catch:{ JSONException -> 0x015a }
            java.util.ArrayList r8 = kotlin.a.k.d(r4)     // Catch:{ JSONException -> 0x015a }
            r0 = 16
            net.one97.paytm.oauth.fragment.v.a((java.lang.String) r9, (java.lang.String) r2, (java.lang.String) r3, (java.util.ArrayList) r8, (int) r0)     // Catch:{ JSONException -> 0x015a }
            r7.d()     // Catch:{ JSONException -> 0x015a }
            return
        L_0x00c3:
            java.lang.String r0 = "oauthVerificationFulfill"
            boolean r9 = r9.equals(r0)     // Catch:{ JSONException -> 0x015a }
            if (r9 == 0) goto L_0x0156
            int r9 = r8.getStatus()     // Catch:{ JSONException -> 0x015a }
            java.lang.Integer r0 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x015a }
            java.lang.String r2 = "AccountBlockEnterPasscod…ionAccountBlockTerminal()"
            if (r0 != 0) goto L_0x00d6
            goto L_0x00dc
        L_0x00d6:
            int r0 = r0.intValue()     // Catch:{ JSONException -> 0x015a }
            if (r9 == r0) goto L_0x0145
        L_0x00dc:
            int r9 = r8.getStatus()     // Catch:{ JSONException -> 0x015a }
            java.lang.Integer r0 = net.one97.paytm.oauth.utils.n.f56789h     // Catch:{ JSONException -> 0x015a }
            if (r0 != 0) goto L_0x00e5
            goto L_0x00f4
        L_0x00e5:
            int r0 = r0.intValue()     // Catch:{ JSONException -> 0x015a }
            if (r9 != r0) goto L_0x00f4
            java.lang.String r9 = "BE1426002"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x015a }
            if (r9 == 0) goto L_0x00f4
            goto L_0x0145
        L_0x00f4:
            int r9 = r8.getStatus()     // Catch:{ JSONException -> 0x015a }
            java.lang.Integer r0 = net.one97.paytm.oauth.utils.n.f56786e     // Catch:{ JSONException -> 0x015a }
            if (r0 != 0) goto L_0x00fd
            goto L_0x010b
        L_0x00fd:
            int r0 = r0.intValue()     // Catch:{ JSONException -> 0x015a }
            if (r9 != r0) goto L_0x010b
            java.lang.String r9 = "BE1426003"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x015a }
            if (r9 != 0) goto L_0x0122
        L_0x010b:
            int r8 = r8.getStatus()     // Catch:{ JSONException -> 0x015a }
            java.lang.Integer r9 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x015a }
            if (r9 != 0) goto L_0x0114
            goto L_0x0134
        L_0x0114:
            int r9 = r9.intValue()     // Catch:{ JSONException -> 0x015a }
            if (r8 != r9) goto L_0x0134
            java.lang.String r8 = "BE1426001"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x015a }
            if (r8 == 0) goto L_0x0134
        L_0x0122:
            android.content.Context r8 = r7.requireContext()     // Catch:{ JSONException -> 0x015a }
            int r9 = net.one97.paytm.oauth.R.string.lbl_could_not_process_request     // Catch:{ JSONException -> 0x015a }
            java.lang.String r9 = r7.getString(r9)     // Catch:{ JSONException -> 0x015a }
            net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment$d r0 = net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment.d.f56027a     // Catch:{ JSONException -> 0x015a }
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0     // Catch:{ JSONException -> 0x015a }
            net.one97.paytm.oauth.d.a.a((android.content.Context) r8, (java.lang.String) r9, (android.view.View.OnClickListener) r0)     // Catch:{ JSONException -> 0x015a }
            return
        L_0x0134:
            net.one97.paytm.oauth.fragment.f$b r8 = net.one97.paytm.oauth.fragment.f.b()     // Catch:{ JSONException -> 0x015a }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)     // Catch:{ JSONException -> 0x015a }
            androidx.navigation.h r9 = androidx.navigation.fragment.a.a(r7)     // Catch:{ JSONException -> 0x015a }
            androidx.navigation.l r8 = (androidx.navigation.l) r8     // Catch:{ JSONException -> 0x015a }
            r9.a((androidx.navigation.l) r8)     // Catch:{ JSONException -> 0x015a }
            return
        L_0x0145:
            net.one97.paytm.oauth.fragment.f$b r8 = net.one97.paytm.oauth.fragment.f.b()     // Catch:{ JSONException -> 0x015a }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)     // Catch:{ JSONException -> 0x015a }
            androidx.navigation.h r9 = androidx.navigation.fragment.a.a(r7)     // Catch:{ JSONException -> 0x015a }
            androidx.navigation.l r8 = (androidx.navigation.l) r8     // Catch:{ JSONException -> 0x015a }
            r9.a((androidx.navigation.l) r8)     // Catch:{ JSONException -> 0x015a }
            return
        L_0x0156:
            r7.d()     // Catch:{ JSONException -> 0x015a }
            return
        L_0x015a:
            r7.d()
        L_0x015d:
            return
        L_0x015e:
            r7.d()
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment.a(net.one97.paytm.oauth.fragment.AccountBlockEnterPasscodeFragment, net.one97.paytm.oauth.models.ErrorModel, java.lang.String):void");
    }

    public static final /* synthetic */ void a(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment, String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 875734478) {
                if (hashCode == 1860343963 && str.equals("oauthDoVerify")) {
                    accountBlockEnterPasscodeFragment.a(accountBlockEnterPasscodeFragment.f56018e, accountBlockEnterPasscodeFragment.f56019f);
                }
            } else if (str.equals("oauthVerificationFulfill")) {
                accountBlockEnterPasscodeFragment.b();
            }
        }
    }

    public static final /* synthetic */ void b(AccountBlockEnterPasscodeFragment accountBlockEnterPasscodeFragment) {
        ArrayList<AppCompatEditText> arrayList = accountBlockEnterPasscodeFragment.f56016c;
        if (arrayList == null) {
            k.a("passcodeEditViewsArr");
        }
        Iterator<AppCompatEditText> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AppCompatEditText next = it2.next();
            k.a((Object) next, "editText");
            if (TextUtils.isEmpty(String.valueOf(next.getText()))) {
                next.requestFocus();
                return;
            }
        }
    }

    public static final /* synthetic */ void a(EditText editText, EditText editText2) {
        if (!TextUtils.isEmpty(editText.getText().toString())) {
            editText.setText("");
            return;
        }
        if (editText2 != null) {
            editText2.setText("");
        }
        if (editText2 != null) {
            editText2.setEnabled(true);
        }
        if (editText2 != null) {
            editText2.requestFocus();
        }
    }
}
