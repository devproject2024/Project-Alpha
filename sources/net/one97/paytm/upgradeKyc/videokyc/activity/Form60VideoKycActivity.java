package net.one97.paytm.upgradeKyc.videokyc.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.z;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.upgradeKyc.Form60Data;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;

public final class Form60VideoKycActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.videokyc.b.a f66421a;

    /* renamed from: b  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> f66422b = new e(this);

    /* renamed from: d  reason: collision with root package name */
    private HashMap f66423d;

    public final View a(int i2) {
        if (this.f66423d == null) {
            this.f66423d = new HashMap();
        }
        View view = (View) this.f66423d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66423d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    static final class e<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Form60VideoKycActivity f66428a;

        e(Form60VideoKycActivity form60VideoKycActivity) {
            this.f66428a = form60VideoKycActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bb, code lost:
            r1 = r1.getError();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                net.one97.paytm.upgradeKyc.kycV3.b.b r6 = (net.one97.paytm.upgradeKyc.kycV3.b.b) r6
                r0 = 0
                if (r6 == 0) goto L_0x0008
                net.one97.paytm.upgradeKyc.kycV3.b.d r1 = r6.f66168a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.upgradeKyc.videokyc.activity.b.f66452a
                int r1 = r1.ordinal()
                r1 = r2[r1]
                java.lang.String r2 = "getString(R.string.some_went_wrong)"
                r3 = 1
                if (r1 == r3) goto L_0x0062
                r0 = 2
                if (r1 == r0) goto L_0x002e
                r6 = 3
                if (r1 == r6) goto L_0x0020
                goto L_0x0061
            L_0x0020:
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r6 = r5.f66428a
                int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r6 = r6.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
                net.one97.paytm.common.widgets.a.a(r6)
                goto L_0x0061
            L_0x002e:
                com.paytm.network.model.NetworkCustomError r0 = r6.f66170c
                if (r0 == 0) goto L_0x0061
                net.one97.paytm.upgradeKyc.utils.l.a()
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r0 = r5.f66428a
                android.content.Context r0 = (android.content.Context) r0
                com.paytm.network.model.NetworkCustomError r6 = r6.f66170c
                if (r6 != 0) goto L_0x0040
                kotlin.g.b.k.a()
            L_0x0040:
                boolean r6 = net.one97.paytm.upgradeKyc.utils.l.a((android.content.Context) r0, (com.paytm.network.model.NetworkCustomError) r6)
                if (r6 != 0) goto L_0x0061
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r6 = r5.f66428a
                int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r6 = r6.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
                net.one97.paytm.common.widgets.a.b(r6)
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r6 = r5.f66428a
                int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
                java.lang.String r0 = r6.getString(r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r6.a((java.lang.String) r0)
            L_0x0061:
                return
            L_0x0062:
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r1 = r5.f66428a
                int r4 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r1 = r1.a((int) r4)
                com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
                net.one97.paytm.common.widgets.a.b(r1)
                ResultType r1 = r6.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x00b5
                java.lang.String r1 = r1.getStatusMessage()
                if (r1 == 0) goto L_0x00b5
                java.lang.String r4 = "success"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
                if (r1 != r3) goto L_0x00b5
                ResultType r1 = r6.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x00b5
                java.lang.String r1 = r1.getStatusCode()
                if (r1 == 0) goto L_0x00b5
                java.lang.String r4 = "01"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
                if (r1 != r3) goto L_0x00b5
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r6 = r5.f66428a
                r0 = r6
                android.content.Context r0 = (android.content.Context) r0
                int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_success
                java.lang.String r6 = r6.getString(r1)
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r1 = r5.f66428a
                int r2 = net.one97.paytm.upgradeKyc.R.string.details_updated_sucessfully
                java.lang.String r1 = r1.getString(r2)
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity$e$1 r2 = new net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity$e$1
                r2.<init>(r5)
                com.paytm.utility.g$c r2 = (com.paytm.utility.g.c) r2
                com.paytm.utility.g.b(r0, r6, r1, r2)
                return
            L_0x00b5:
                ResultType r1 = r6.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x00c6
                net.one97.paytm.common.entity.CJRAadharPanSave$Error r1 = r1.getError()
                if (r1 == 0) goto L_0x00c6
                java.lang.String r1 = r1.getErrorMsg()
                goto L_0x00c7
            L_0x00c6:
                r1 = r0
            L_0x00c7:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r4 = 0
                if (r1 == 0) goto L_0x00d5
                int r1 = r1.length()
                if (r1 != 0) goto L_0x00d3
                goto L_0x00d5
            L_0x00d3:
                r1 = 0
                goto L_0x00d6
            L_0x00d5:
                r1 = 1
            L_0x00d6:
                if (r1 != 0) goto L_0x00f3
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r1 = r5.f66428a
                ResultType r6 = r6.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r6 = (net.one97.paytm.common.entity.CJRAadharPanSave) r6
                if (r6 == 0) goto L_0x00ea
                net.one97.paytm.common.entity.CJRAadharPanSave$Error r6 = r6.getError()
                if (r6 == 0) goto L_0x00ea
                java.lang.String r0 = r6.getErrorMsg()
            L_0x00ea:
                if (r0 != 0) goto L_0x00ef
                kotlin.g.b.k.a()
            L_0x00ef:
                r1.a((java.lang.String) r0)
                return
            L_0x00f3:
                ResultType r1 = r6.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x00fe
                java.lang.String r1 = r1.getErrorMessage()
                goto L_0x00ff
            L_0x00fe:
                r1 = r0
            L_0x00ff:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x010b
                int r1 = r1.length()
                if (r1 != 0) goto L_0x010a
                goto L_0x010b
            L_0x010a:
                r3 = 0
            L_0x010b:
                if (r3 != 0) goto L_0x0122
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r1 = r5.f66428a
                ResultType r6 = r6.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r6 = (net.one97.paytm.common.entity.CJRAadharPanSave) r6
                if (r6 == 0) goto L_0x0119
                java.lang.String r0 = r6.getErrorMessage()
            L_0x0119:
                if (r0 != 0) goto L_0x011e
                kotlin.g.b.k.a()
            L_0x011e:
                r1.a((java.lang.String) r0)
                return
            L_0x0122:
                net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity r6 = r5.f66428a
                int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
                java.lang.String r0 = r6.getString(r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r6.a((java.lang.String) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.videokyc.activity.Form60VideoKycActivity.e.onChanged(java.lang.Object):void");
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.videokyc.b.a b(Form60VideoKycActivity form60VideoKycActivity) {
        net.one97.paytm.upgradeKyc.videokyc.b.a aVar = form60VideoKycActivity.f66421a;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f66421a = (net.one97.paytm.upgradeKyc.videokyc.b.a) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.videokyc.b.a.class);
        net.one97.paytm.upgradeKyc.videokyc.b.a aVar = this.f66421a;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.f66457b.observe(this, this.f66422b);
        ((TextInputEditText) a(R.id.agricultureEt)).addTextChangedListener(new a(this));
        ((TextInputEditText) a(R.id.nonAgricultureEt)).addTextChangedListener(new b(this));
        ((TextView) a(R.id.submit_btn)).setOnClickListener(new c(this));
        ((ImageView) a(R.id.back_btn)).setOnClickListener(new d(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Form60VideoKycActivity f66426a;

        c(Form60VideoKycActivity form60VideoKycActivity) {
            this.f66426a = form60VideoKycActivity;
        }

        public final void onClick(View view) {
            this.f66426a.b("ok_button_clicked", "kyc/video_kyc/pan_verify/form60_form");
            if (Form60VideoKycActivity.a(this.f66426a)) {
                CheckBox checkBox = (CheckBox) this.f66426a.a(R.id.i_declare_cb);
                k.a((Object) checkBox, "i_declare_cb");
                if (checkBox.isChecked()) {
                    TextInputEditText textInputEditText = (TextInputEditText) this.f66426a.a(R.id.agricultureEt);
                    k.a((Object) textInputEditText, "agricultureEt");
                    String valueOf = String.valueOf(textInputEditText.getText());
                    TextInputEditText textInputEditText2 = (TextInputEditText) this.f66426a.a(R.id.nonAgricultureEt);
                    k.a((Object) textInputEditText2, "nonAgricultureEt");
                    Form60Data form60Data = new Form60Data(valueOf, String.valueOf(textInputEditText2.getText()));
                    net.one97.paytm.upgradeKyc.videokyc.b.a b2 = Form60VideoKycActivity.b(this.f66426a);
                    k.c(form60Data, "form60");
                    b2.f66456a.setValue(form60Data);
                }
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Form60VideoKycActivity f66427a;

        d(Form60VideoKycActivity form60VideoKycActivity) {
            this.f66427a = form60VideoKycActivity;
        }

        public final void onClick(View view) {
            this.f66427a.onBackPressed();
        }
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Form60VideoKycActivity f66424a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(Form60VideoKycActivity form60VideoKycActivity) {
            this.f66424a = form60VideoKycActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f66424a.b("agricultural_income_entered", "kyc/video_kyc/pan_verify/form60_form");
            TextInputLayout textInputLayout = (TextInputLayout) this.f66424a.a(R.id.til_enter_pan);
            if (textInputLayout != null) {
                textInputLayout.setErrorEnabled(false);
            }
            this.f66424a.b("pan_entered", "/kyc/video_kyc/pan_verify");
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Form60VideoKycActivity f66425a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        b(Form60VideoKycActivity form60VideoKycActivity) {
            this.f66425a = form60VideoKycActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f66425a.b("non_agricultural_income_entered", "kyc/video_kyc/pan_verify/form60_form");
            TextInputLayout textInputLayout = (TextInputLayout) this.f66425a.a(R.id.til_enter_pan);
            if (textInputLayout != null) {
                textInputLayout.setErrorEnabled(false);
            }
            this.f66425a.b("pan_entered", "/kyc/video_kyc/pan_verify");
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        Snackbar.a((View) (ScrollView) a(R.id.form60Parent), (CharSequence) str, -1).c();
    }

    public final int a() {
        return R.layout.activity_form60_video_kyc;
    }

    public static final /* synthetic */ boolean a(Form60VideoKycActivity form60VideoKycActivity) {
        TextInputEditText textInputEditText = (TextInputEditText) form60VideoKycActivity.a(R.id.agricultureEt);
        k.a((Object) textInputEditText, "agricultureEt");
        if (textInputEditText.getText() != null) {
            TextInputEditText textInputEditText2 = (TextInputEditText) form60VideoKycActivity.a(R.id.agricultureEt);
            k.a((Object) textInputEditText2, "agricultureEt");
            if (!(String.valueOf(textInputEditText2.getText()).length() == 0)) {
                TextInputEditText textInputEditText3 = (TextInputEditText) form60VideoKycActivity.a(R.id.agricultureEt);
                k.a((Object) textInputEditText3, "agricultureEt");
                if (Long.parseLong(String.valueOf(textInputEditText3.getText())) > 1000000000) {
                    String string = form60VideoKycActivity.getString(R.string.error_greater_agri);
                    k.a((Object) string, "getString(R.string.error_greater_agri)");
                    form60VideoKycActivity.a(string);
                    return false;
                }
                TextInputEditText textInputEditText4 = (TextInputEditText) form60VideoKycActivity.a(R.id.nonAgricultureEt);
                k.a((Object) textInputEditText4, "nonAgricultureEt");
                if (textInputEditText4.getText() != null) {
                    TextInputEditText textInputEditText5 = (TextInputEditText) form60VideoKycActivity.a(R.id.nonAgricultureEt);
                    k.a((Object) textInputEditText5, "nonAgricultureEt");
                    if (!(String.valueOf(textInputEditText5.getText()).length() == 0)) {
                        TextInputEditText textInputEditText6 = (TextInputEditText) form60VideoKycActivity.a(R.id.nonAgricultureEt);
                        k.a((Object) textInputEditText6, "nonAgricultureEt");
                        if (Long.parseLong(String.valueOf(textInputEditText6.getText())) <= 250000) {
                            return true;
                        }
                        String string2 = form60VideoKycActivity.getString(R.string.error_greater_nonagri);
                        k.a((Object) string2, "getString(R.string.error_greater_nonagri)");
                        form60VideoKycActivity.a(string2);
                        return false;
                    }
                }
                String string3 = form60VideoKycActivity.getString(R.string.kyc_error_your_non_agriculture_income);
                k.a((Object) string3, "getString(R.string.kyc_e…r_non_agriculture_income)");
                form60VideoKycActivity.a(string3);
                return false;
            }
        }
        String string4 = form60VideoKycActivity.getString(R.string.kyc_error_enter_agriculture_income);
        k.a((Object) string4, "getString(R.string.kyc_e…enter_agriculture_income)");
        form60VideoKycActivity.a(string4);
        return false;
    }
}
