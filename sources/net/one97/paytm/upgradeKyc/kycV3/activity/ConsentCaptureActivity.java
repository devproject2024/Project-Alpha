package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.upgradeKyc.ConsentSaveForm60;
import net.one97.paytm.common.entity.upgradeKyc.ConsentSaveObject;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.KycAddDetail;
import net.one97.paytm.common.entity.upgradeKyc.KycAddress;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.common.entity.upgradeKyc.PostAppointmentObject;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.b.a;
import net.one97.paytm.upgradeKyc.utils.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class ConsentCaptureActivity extends UpgradeKycBaseActivity implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.kycV3.c.a f66085a;

    /* renamed from: b  reason: collision with root package name */
    String f66086b = "";

    /* renamed from: d  reason: collision with root package name */
    String f66087d = "";

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.kycV3.b.a f66088e;

    /* renamed from: f  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> f66089f = new n(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f66090g;

    public final View a(int i2) {
        if (this.f66090g == null) {
            this.f66090g = new HashMap();
        }
        View view = (View) this.f66090g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66090g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    static final class a<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66091a;

        a(ConsentCaptureActivity consentCaptureActivity) {
            this.f66091a = consentCaptureActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f66154b[dVar.ordinal()];
                if (i2 == 1) {
                    TextView textView = (TextView) this.f66091a.a(R.id.proceed_to_tv);
                    kotlin.g.b.k.a((Object) textView, "proceed_to_tv");
                    textView.setClickable(true);
                    this.f66091a.d().a(CJRQRScanResultModel.REQ_TYPE);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        TextView textView2 = (TextView) this.f66091a.a(R.id.proceed_to_tv);
                        kotlin.g.b.k.a((Object) textView2, "proceed_to_tv");
                        textView2.setClickable(false);
                        ConsentCaptureActivity.a(this.f66091a, false);
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66091a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f66091a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        TextView textView3 = (TextView) this.f66091a.a(R.id.proceed_to_tv);
                        kotlin.g.b.k.a((Object) textView3, "proceed_to_tv");
                        textView3.setClickable(true);
                        ConsentCaptureActivity.a(this.f66091a, true);
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66091a.a(R.id.wallet_loader));
                        Snackbar.a((View) (ConstraintLayout) this.f66091a.a(R.id.consent_capture_parent_lyt), (CharSequence) this.f66091a.getString(R.string.some_went_wrong), -1).c();
                    }
                }
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66092a;

        b(ConsentCaptureActivity consentCaptureActivity) {
            this.f66092a = consentCaptureActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f66155c[dVar.ordinal()];
                if (i2 == 1) {
                    ConsentCaptureActivity.a(this.f66092a, true);
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66092a.a(R.id.wallet_loader));
                    if (bVar.f66169b != null) {
                        ConsentCaptureActivity consentCaptureActivity = this.f66092a;
                        ResultType resulttype = bVar.f66169b;
                        if (resulttype == null) {
                            kotlin.g.b.k.a();
                        }
                        ConsentCaptureActivity.a(consentCaptureActivity, (KycSavedUserData) resulttype);
                        return;
                    }
                    Snackbar.a((View) (ConstraintLayout) this.f66092a.a(R.id.consent_capture_parent_lyt), (CharSequence) this.f66092a.getString(R.string.some_went_wrong), -1).c();
                } else if (i2 == 2 && bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f66092a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        ConsentCaptureActivity.a(this.f66092a, true);
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66092a.a(R.id.wallet_loader));
                        Snackbar.a((View) (ConstraintLayout) this.f66092a.a(R.id.consent_capture_parent_lyt), (CharSequence) this.f66092a.getString(R.string.some_went_wrong), -1).c();
                    }
                }
            }
        }
    }

    static final class n<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66105a;

        n(ConsentCaptureActivity consentCaptureActivity) {
            this.f66105a = consentCaptureActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
            r1 = (r1 = r1.getTncDataList()).get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r8) {
            /*
                r7 = this;
                net.one97.paytm.upgradeKyc.kycV3.b.b r8 = (net.one97.paytm.upgradeKyc.kycV3.b.b) r8
                r0 = 0
                if (r8 == 0) goto L_0x0008
                net.one97.paytm.upgradeKyc.kycV3.b.d r1 = r8.f66168a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.upgradeKyc.kycV3.activity.c.f66153a
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 1
                if (r1 == r2) goto L_0x004c
                r0 = 2
                if (r1 == r0) goto L_0x001c
                goto L_0x0195
            L_0x001c:
                com.paytm.network.model.NetworkCustomError r0 = r8.f66170c
                if (r0 == 0) goto L_0x0195
                net.one97.paytm.upgradeKyc.utils.l.a()
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r7.f66105a
                android.content.Context r0 = (android.content.Context) r0
                com.paytm.network.model.NetworkCustomError r8 = r8.f66170c
                if (r8 != 0) goto L_0x002e
                kotlin.g.b.k.a()
            L_0x002e:
                boolean r8 = net.one97.paytm.upgradeKyc.utils.l.a((android.content.Context) r0, (com.paytm.network.model.NetworkCustomError) r8)
                if (r8 != 0) goto L_0x0195
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r8 = r7.f66105a
                r0 = r8
                android.content.Context r0 = (android.content.Context) r0
                int r1 = net.one97.paytm.upgradeKyc.R.string.error
                java.lang.String r8 = r8.getString(r1)
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r1 = r7.f66105a
                int r2 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
                java.lang.String r1 = r1.getString(r2)
                com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r8, (java.lang.String) r1)
                goto L_0x0195
            L_0x004c:
                ResultType r1 = r8.f66169b
                net.one97.paytm.common.entity.auth.KYCFetchTnc r1 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r1
                if (r1 == 0) goto L_0x0195
                java.util.ArrayList r1 = r1.getTncDataList()
                if (r1 == 0) goto L_0x0195
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                r1 = r1 ^ r2
                if (r1 != r2) goto L_0x0195
                ResultType r1 = r8.f66169b
                net.one97.paytm.common.entity.auth.KYCFetchTnc r1 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r1
                r2 = 0
                if (r1 == 0) goto L_0x007b
                java.util.ArrayList r1 = r1.getTncDataList()
                if (r1 == 0) goto L_0x007b
                java.lang.Object r1 = r1.get(r2)
                net.one97.paytm.common.entity.auth.TncData r1 = (net.one97.paytm.common.entity.auth.TncData) r1
                if (r1 == 0) goto L_0x007b
                java.lang.String r1 = r1.getCode()
                goto L_0x007c
            L_0x007b:
                r1 = r0
            L_0x007c:
                java.lang.String r3 = "appkycconsent"
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
                java.lang.String r3 = "appsaconsent"
                java.lang.String r4 = "<set-?>"
                java.lang.String r5 = ""
                if (r1 == 0) goto L_0x00e0
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r7.f66105a
                ResultType r8 = r8.f66169b
                net.one97.paytm.common.entity.auth.KYCFetchTnc r8 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r8
                if (r8 == 0) goto L_0x00a6
                java.util.ArrayList r8 = r8.getTncDataList()
                if (r8 == 0) goto L_0x00a6
                java.lang.Object r8 = r8.get(r2)
                net.one97.paytm.common.entity.auth.TncData r8 = (net.one97.paytm.common.entity.auth.TncData) r8
                if (r8 == 0) goto L_0x00a6
                java.lang.String r8 = r8.getDescription()
                if (r8 != 0) goto L_0x00a7
            L_0x00a6:
                r8 = r5
            L_0x00a7:
                kotlin.g.b.k.c(r8, r4)
                r0.f66086b = r8
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r8 = r7.f66105a
                int r0 = net.one97.paytm.upgradeKyc.R.id.full_kyc_cb
                android.view.View r8 = r8.a((int) r0)
                android.widget.CheckBox r8 = (android.widget.CheckBox) r8
                java.lang.String r0 = "full_kyc_cb"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
                android.view.View r8 = (android.view.View) r8
                net.one97.paytm.upgradeKyc.kycV3.b.b(r8)
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r8 = r7.f66105a
                int r1 = net.one97.paytm.upgradeKyc.R.id.full_kyc_cb
                android.view.View r8 = r8.a((int) r1)
                android.widget.CheckBox r8 = (android.widget.CheckBox) r8
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r7.f66105a
                java.lang.String r0 = r0.f66086b
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r8.setText(r0)
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r8 = r7.f66105a
                net.one97.paytm.upgradeKyc.kycV3.c.a r8 = r8.d()
                r8.b((java.lang.String) r3)
                return
            L_0x00e0:
                ResultType r1 = r8.f66169b
                net.one97.paytm.common.entity.auth.KYCFetchTnc r1 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r1
                if (r1 == 0) goto L_0x00f9
                java.util.ArrayList r1 = r1.getTncDataList()
                if (r1 == 0) goto L_0x00f9
                java.lang.Object r1 = r1.get(r2)
                net.one97.paytm.common.entity.auth.TncData r1 = (net.one97.paytm.common.entity.auth.TncData) r1
                if (r1 == 0) goto L_0x00f9
                java.lang.String r1 = r1.getCode()
                goto L_0x00fa
            L_0x00f9:
                r1 = r0
            L_0x00fa:
                java.lang.String r6 = "appbiometricconsent"
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r6)
                if (r1 == 0) goto L_0x014c
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r7.f66105a
                int r1 = net.one97.paytm.upgradeKyc.R.id.bioconsent_cb
                android.view.View r0 = r0.a((int) r1)
                android.widget.CheckBox r0 = (android.widget.CheckBox) r0
                java.lang.String r1 = "bioconsent_cb"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.upgradeKyc.kycV3.b.b(r0)
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r7.f66105a
                int r3 = net.one97.paytm.upgradeKyc.R.id.bioconsent_cb
                android.view.View r0 = r0.a((int) r3)
                android.widget.CheckBox r0 = (android.widget.CheckBox) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                ResultType r8 = r8.f66169b
                net.one97.paytm.common.entity.auth.KYCFetchTnc r8 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r8
                if (r8 == 0) goto L_0x013e
                java.util.ArrayList r8 = r8.getTncDataList()
                if (r8 == 0) goto L_0x013e
                java.lang.Object r8 = r8.get(r2)
                net.one97.paytm.common.entity.auth.TncData r8 = (net.one97.paytm.common.entity.auth.TncData) r8
                if (r8 == 0) goto L_0x013e
                java.lang.String r8 = r8.getDescription()
                if (r8 == 0) goto L_0x013e
                goto L_0x0146
            L_0x013e:
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r8 = r7.f66105a
                int r1 = net.one97.paytm.upgradeKyc.R.string.i_consent_auth_uidai
                java.lang.String r8 = r8.getString(r1)
            L_0x0146:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r0.setText(r8)
                return
            L_0x014c:
                ResultType r1 = r8.f66169b
                net.one97.paytm.common.entity.auth.KYCFetchTnc r1 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r1
                if (r1 == 0) goto L_0x0164
                java.util.ArrayList r1 = r1.getTncDataList()
                if (r1 == 0) goto L_0x0164
                java.lang.Object r1 = r1.get(r2)
                net.one97.paytm.common.entity.auth.TncData r1 = (net.one97.paytm.common.entity.auth.TncData) r1
                if (r1 == 0) goto L_0x0164
                java.lang.String r0 = r1.getCode()
            L_0x0164:
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
                if (r0 == 0) goto L_0x0195
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r7.f66105a
                net.one97.paytm.upgradeKyc.kycV3.c.a r0 = r0.d()
                r0.b((java.lang.String) r6)
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r7.f66105a
                ResultType r8 = r8.f66169b
                net.one97.paytm.common.entity.auth.KYCFetchTnc r8 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r8
                if (r8 == 0) goto L_0x018f
                java.util.ArrayList r8 = r8.getTncDataList()
                if (r8 == 0) goto L_0x018f
                java.lang.Object r8 = r8.get(r2)
                net.one97.paytm.common.entity.auth.TncData r8 = (net.one97.paytm.common.entity.auth.TncData) r8
                if (r8 == 0) goto L_0x018f
                java.lang.String r8 = r8.getDescription()
                if (r8 != 0) goto L_0x0190
            L_0x018f:
                r8 = r5
            L_0x0190:
                kotlin.g.b.k.c(r8, r4)
                r0.f66087d = r8
            L_0x0195:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity.n.onChanged(java.lang.Object):void");
        }
    }

    public final net.one97.paytm.upgradeKyc.kycV3.c.a d() {
        net.one97.paytm.upgradeKyc.kycV3.c.a aVar = this.f66085a;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        a("/kyc/slot-preference", "kyc_new", "signal");
        ((RadioGroup) a(R.id.service_avail_grp)).setOnCheckedChangeListener(new d(this));
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.kyc_enter_doc_num_et);
        kotlin.g.b.k.a((Object) textInputEditText, "kyc_enter_doc_num_et");
        textInputEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(10)});
        ((ImageView) a(R.id.ic_back)).setOnClickListener(new f(this));
        ((TextView) a(R.id.proceed_to_tv)).setOnClickListener(new g(this));
        ((RadioGroup) a(R.id.layout_kyc_do_you_have_pan)).setOnCheckedChangeListener(new h(this));
        ((RadioGroup) a(R.id.layout_kyc_have_applied_pan)).setOnCheckedChangeListener(new i(this));
        ((TextInputEditText) a(R.id.pan_ack_date_et)).setOnClickListener(new j(this));
        ((CheckBox) a(R.id.full_kyc_cb)).setOnCheckedChangeListener(new k(this));
        ((CheckBox) a(R.id.bioconsent_cb)).setOnCheckedChangeListener(new l(this));
        ((CheckBox) a(R.id.above_eighteen_cb)).setOnCheckedChangeListener(new m(this));
        ((CheckBox) a(R.id.i_declare_cb)).setOnCheckedChangeListener(new e(this));
        this.f66085a = (net.one97.paytm.upgradeKyc.kycV3.c.a) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.kycV3.c.a.class);
        net.one97.paytm.upgradeKyc.kycV3.c.a aVar = this.f66085a;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        q qVar = this;
        aVar.f66199b.observe(qVar, new a(this));
        net.one97.paytm.upgradeKyc.kycV3.c.a aVar2 = this.f66085a;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar2.f66200c.observe(qVar, new b(this));
        net.one97.paytm.upgradeKyc.kycV3.c.a aVar3 = this.f66085a;
        if (aVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar3.f66202e.observe(qVar, this.f66089f);
        if (getIntent().hasExtra("time")) {
            String stringExtra = getIntent().getStringExtra(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            String stringExtra2 = getIntent().getStringExtra("time");
            kotlin.g.b.k.a((Object) stringExtra2, "time");
            String a2 = a(stringExtra2);
            Serializable serializableExtra = getIntent().getSerializableExtra(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            if (serializableExtra != null) {
                String a3 = a((KycAddress) serializableExtra);
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(a2) || TextUtils.isEmpty(a3)) {
                    TextView textView = (TextView) a(R.id.appointment_details_tv);
                    kotlin.g.b.k.a((Object) textView, "appointment_details_tv");
                    textView.setText(getString(R.string.we_will_contact_visit));
                } else {
                    TextView textView2 = (TextView) a(R.id.appointment_details_tv);
                    kotlin.g.b.k.a((Object) textView2, "appointment_details_tv");
                    textView2.setText(getString(R.string.time_date_address, new Object[]{a2, stringExtra, a3}));
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.KycAddress");
            }
        } else {
            a.C1325a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
            Context applicationContext = getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
            this.f66088e = a.C1325a.a(applicationContext);
            String a4 = this.f66088e != null ? net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData") : null;
            if (!TextUtils.isEmpty(a4)) {
                PostAppointmentObject postAppointmentObject = (PostAppointmentObject) new com.google.gsonhtcfix.f().a(a4, PostAppointmentObject.class);
                if (postAppointmentObject != null) {
                    if (postAppointmentObject.getKycAddress() != null) {
                        KycAddress kycAddress = postAppointmentObject.getKycAddress();
                        if (kycAddress == null) {
                            kotlin.g.b.k.a();
                        }
                        str = a(kycAddress);
                    } else {
                        str = "";
                    }
                    String appointmentDate = postAppointmentObject.getAppointmentDate();
                    String appointmentTimeSlot = postAppointmentObject.getAppointmentTimeSlot();
                    if (TextUtils.isEmpty(appointmentDate) || TextUtils.isEmpty(appointmentTimeSlot)) {
                        TextView textView3 = (TextView) a(R.id.appointment_details_tv);
                        kotlin.g.b.k.a((Object) textView3, "appointment_details_tv");
                        textView3.setText(getString(R.string.we_will_contact_visit));
                    } else {
                        String h2 = com.paytm.utility.b.h(appointmentDate, "yyyy-MM-dd", "EEEE, dd MMM yyyy");
                        if (appointmentTimeSlot == null) {
                            kotlin.g.b.k.a();
                        }
                        String a5 = a(appointmentTimeSlot);
                        TextView textView4 = (TextView) a(R.id.appointment_details_tv);
                        kotlin.g.b.k.a((Object) textView4, "appointment_details_tv");
                        textView4.setText(getString(R.string.time_date_address, new Object[]{a5, h2, str}));
                    }
                }
            } else {
                TextView textView5 = (TextView) a(R.id.appointment_details_tv);
                kotlin.g.b.k.a((Object) textView5, "appointment_details_tv");
                textView5.setText(getString(R.string.we_will_contact_visit));
            }
        }
        net.one97.paytm.upgradeKyc.kycV3.c.a aVar5 = this.f66085a;
        if (aVar5 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar5.b("appkycconsent");
        d.a aVar6 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        net.one97.paytm.upgradeKyc.helper.d a6 = d.a.a();
        if (a6 == null) {
            return;
        }
        if (net.one97.paytm.upgradeKyc.helper.d.a("isFASTagToShowOnConsent", false)) {
            RadioGroup radioGroup = (RadioGroup) a(R.id.rg_fasttag);
            kotlin.g.b.k.a((Object) radioGroup, "rg_fasttag");
            radioGroup.setVisibility(0);
            TextView textView6 = (TextView) a(R.id.do_you_want_fasttag);
            kotlin.g.b.k.a((Object) textView6, "do_you_want_fasttag");
            textView6.setVisibility(0);
            TextView textView7 = (TextView) a(R.id.learn_fastag_tv);
            kotlin.g.b.k.a((Object) textView7, "learn_fastag_tv");
            textView7.setVisibility(0);
            TextView textView8 = (TextView) a(R.id.note_fastag_tv);
            kotlin.g.b.k.a((Object) textView8, "note_fastag_tv");
            textView8.setVisibility(0);
            String string = getString(R.string.kyc_fastag_note);
            String string2 = getString(R.string.kyc_note_fastag_delivery);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ' ' + string2);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, string.length(), 18);
            TextView textView9 = (TextView) a(R.id.note_fastag_tv);
            kotlin.g.b.k.a((Object) textView9, "note_fastag_tv");
            textView9.setText(spannableStringBuilder);
            String string3 = getString(R.string.kyc_learn_fastag);
            String string4 = getString(R.string.kyc_about_fastag);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string3 + ' ' + string4);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this, R.color.paytm_blue)), 0, string3.length(), 33);
            TextView textView10 = (TextView) a(R.id.learn_fastag_tv);
            kotlin.g.b.k.a((Object) textView10, "learn_fastag_tv");
            textView10.setText(spannableStringBuilder2);
            ((TextView) a(R.id.learn_fastag_tv)).setOnClickListener(new c(a6, this));
            return;
        }
        RadioGroup radioGroup2 = (RadioGroup) a(R.id.rg_fasttag);
        kotlin.g.b.k.a((Object) radioGroup2, "rg_fasttag");
        radioGroup2.setVisibility(8);
        TextView textView11 = (TextView) a(R.id.do_you_want_fasttag);
        kotlin.g.b.k.a((Object) textView11, "do_you_want_fasttag");
        textView11.setVisibility(8);
        TextView textView12 = (TextView) a(R.id.learn_fastag_tv);
        kotlin.g.b.k.a((Object) textView12, "learn_fastag_tv");
        textView12.setVisibility(8);
        TextView textView13 = (TextView) a(R.id.note_fastag_tv);
        kotlin.g.b.k.a((Object) textView13, "note_fastag_tv");
        textView13.setVisibility(8);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.upgradeKyc.helper.d f66093a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66094b;

        c(net.one97.paytm.upgradeKyc.helper.d dVar, ConsentCaptureActivity consentCaptureActivity) {
            this.f66093a = dVar;
            this.f66094b = consentCaptureActivity;
        }

        public final void onClick(View view) {
            String a2 = net.one97.paytm.upgradeKyc.helper.d.a("kycfastTagLearnMoreUrl");
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            Intent intent = new Intent(this.f66094b, Class.forName(e.a.b().d()));
            intent.putExtra("url", a2);
            intent.putExtra("Close", true);
            this.f66094b.startActivity(intent);
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        super.attachBaseContext(e.a.b().a(context));
    }

    public final int a() {
        return R.layout.consent_capture_lyt;
    }

    private final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.ninetotweleve);
            kotlin.g.b.k.a((Object) str, "getString(R.string.ninetotweleve)");
        }
        return b(str);
    }

    private final String b(String str) {
        String str2;
        List<String> a2 = p.a((CharSequence) str, new String[]{"TO"});
        String string = getString(R.string.ninetotweleve);
        String str3 = "";
        if (p.a((CharSequence) a2.get(0), (CharSequence) "AM", false)) {
            str2 = p.a(a2.get(0), "AM", " " + getString(R.string.kyc_am), false);
        } else if (p.a((CharSequence) a2.get(0), (CharSequence) "NOON", false)) {
            str2 = p.a(a2.get(0), "NOON", " " + getString(R.string.kyc_noon), false);
        } else if (p.a((CharSequence) a2.get(0), (CharSequence) "PM", false)) {
            str2 = p.a(a2.get(0), "PM", " " + getString(R.string.kyc_pm), false);
        } else {
            str2 = str3;
        }
        if (p.a((CharSequence) a2.get(1), (CharSequence) "AM", false)) {
            str3 = p.a(a2.get(1), "AM", " " + getString(R.string.kyc_am), false);
        } else if (p.a((CharSequence) a2.get(1), (CharSequence) "NOON", false)) {
            str3 = p.a(a2.get(1), "NOON", " " + getString(R.string.kyc_noon), false);
        } else if (p.a((CharSequence) a2.get(1), (CharSequence) "PM", false)) {
            str3 = p.a(a2.get(1), "PM", " " + getString(R.string.kyc_pm), false);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            string = str2 + " " + getString(R.string.kyc_to) + " " + str3;
        }
        kotlin.g.b.k.a((Object) string, "formattedTitle");
        return string;
    }

    private static String a(KycAddress kycAddress) {
        StringBuilder sb = new StringBuilder();
        sb.append(kycAddress.getAddressLine1() + ", " + kycAddress.getAddressLine2() + ", " + kycAddress.getCity() + ", " + kycAddress.getState() + "-" + kycAddress.getPincode());
        String sb2 = sb.toString();
        kotlin.g.b.k.a((Object) sb2, "address.toString()");
        return sb2;
    }

    static final class d implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66095a;

        d(ConsentCaptureActivity consentCaptureActivity) {
            this.f66095a = consentCaptureActivity;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f66095a.f66086b) && !TextUtils.isEmpty(this.f66095a.f66087d)) {
                if (i2 == R.id.full_kyc_ppb_option) {
                    hashMap.put("event_label", this.f66095a.f66087d);
                    CheckBox checkBox = (CheckBox) this.f66095a.a(R.id.full_kyc_cb);
                    kotlin.g.b.k.a((Object) checkBox, "full_kyc_cb");
                    checkBox.setText(this.f66095a.f66087d);
                } else if (i2 == R.id.full_kyc_wallet_option) {
                    hashMap.put("event_label", this.f66095a.f66086b);
                    CheckBox checkBox2 = (CheckBox) this.f66095a.a(R.id.full_kyc_cb);
                    kotlin.g.b.k.a((Object) checkBox2, "full_kyc_cb");
                    checkBox2.setText(this.f66095a.f66086b);
                } else if (i2 == R.id.savings_acnt_option) {
                    hashMap.put("event_label", this.f66095a.f66087d);
                    CheckBox checkBox3 = (CheckBox) this.f66095a.a(R.id.full_kyc_cb);
                    kotlin.g.b.k.a((Object) checkBox3, "full_kyc_cb");
                    checkBox3.setText(this.f66095a.f66087d);
                }
            }
            UpgradeKycBaseActivity.a(this.f66095a, "/kyc/slot-preference", "services_radio_button_selected", hashMap, (String) null, 8);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66097a;

        f(ConsentCaptureActivity consentCaptureActivity) {
            this.f66097a = consentCaptureActivity;
        }

        public final void onClick(View view) {
            this.f66097a.onBackPressed();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66098a;

        g(ConsentCaptureActivity consentCaptureActivity) {
            this.f66098a = consentCaptureActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f66098a, "/kyc/slot-preference", "book_appointment_clicked", (HashMap) null, (String) null, 12);
            if (ConsentCaptureActivity.a(this.f66098a)) {
                TextView textView = (TextView) this.f66098a.a(R.id.proceed_to_tv);
                kotlin.g.b.k.a((Object) textView, "proceed_to_tv");
                textView.setClickable(false);
                ConsentSaveObject b2 = ConsentCaptureActivity.b(this.f66098a);
                net.one97.paytm.upgradeKyc.kycV3.c.a d2 = this.f66098a.d();
                kotlin.g.b.k.c(b2, "consentSaveObject");
                d2.f66198a.setValue(b2);
            }
        }
    }

    static final class h implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66099a;

        h(ConsentCaptureActivity consentCaptureActivity) {
            this.f66099a = consentCaptureActivity;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            HashMap hashMap = new HashMap();
            if (i2 == R.id.yes_have_pan) {
                hashMap.put("event_label", H5AppHandler.CHECK_VALUE);
                TextInputLayout textInputLayout = (TextInputLayout) this.f66099a.a(R.id.kyc_til_pan_number);
                kotlin.g.b.k.a((Object) textInputLayout, "kyc_til_pan_number");
                net.one97.paytm.upgradeKyc.kycV3.b.b(textInputLayout);
                View a2 = this.f66099a.a(R.id.id_dont_have_pan_lyt);
                kotlin.g.b.k.a((Object) a2, "id_dont_have_pan_lyt");
                net.one97.paytm.upgradeKyc.kycV3.b.a(a2);
            } else {
                hashMap.put("event_label", "no");
                TextInputLayout textInputLayout2 = (TextInputLayout) this.f66099a.a(R.id.kyc_til_pan_number);
                kotlin.g.b.k.a((Object) textInputLayout2, "kyc_til_pan_number");
                net.one97.paytm.upgradeKyc.kycV3.b.a((View) textInputLayout2);
                View a3 = this.f66099a.a(R.id.id_dont_have_pan_lyt);
                kotlin.g.b.k.a((Object) a3, "id_dont_have_pan_lyt");
                net.one97.paytm.upgradeKyc.kycV3.b.b(a3);
            }
            UpgradeKycBaseActivity.a(this.f66099a, "/kyc/slot-preference", "pan_radio_button_selected", hashMap, (String) null, 8);
        }
    }

    static final class i implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66100a;

        i(ConsentCaptureActivity consentCaptureActivity) {
            this.f66100a = consentCaptureActivity;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == R.id.yes_have_applied_pan) {
                TextInputLayout textInputLayout = (TextInputLayout) this.f66100a.a(R.id.pan_ack_date_til);
                kotlin.g.b.k.a((Object) textInputLayout, "pan_ack_date_til");
                net.one97.paytm.upgradeKyc.kycV3.b.b(textInputLayout);
                TextInputLayout textInputLayout2 = (TextInputLayout) this.f66100a.a(R.id.pan_ack_num_til);
                kotlin.g.b.k.a((Object) textInputLayout2, "pan_ack_num_til");
                net.one97.paytm.upgradeKyc.kycV3.b.b(textInputLayout2);
                return;
            }
            TextInputLayout textInputLayout3 = (TextInputLayout) this.f66100a.a(R.id.pan_ack_date_til);
            kotlin.g.b.k.a((Object) textInputLayout3, "pan_ack_date_til");
            net.one97.paytm.upgradeKyc.kycV3.b.a((View) textInputLayout3);
            TextInputLayout textInputLayout4 = (TextInputLayout) this.f66100a.a(R.id.pan_ack_num_til);
            kotlin.g.b.k.a((Object) textInputLayout4, "pan_ack_num_til");
            net.one97.paytm.upgradeKyc.kycV3.b.a((View) textInputLayout4);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66101a;

        j(ConsentCaptureActivity consentCaptureActivity) {
            this.f66101a = consentCaptureActivity;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00b2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r5) {
            /*
                r4 = this;
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r5 = r4.f66101a
                int r0 = net.one97.paytm.upgradeKyc.R.id.pan_ack_date_et
                android.view.View r5 = r5.a((int) r0)
                com.google.android.material.textfield.TextInputEditText r5 = (com.google.android.material.textfield.TextInputEditText) r5
                java.lang.String r0 = "pan_ack_date_et"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
                android.text.Editable r5 = r5.getText()
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 == 0) goto L_0x0021
                net.one97.paytm.upgradeKyc.utils.d r5 = net.one97.paytm.upgradeKyc.utils.d.a()
                goto L_0x009f
            L_0x0021:
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r5 = r4.f66101a
                int r1 = net.one97.paytm.upgradeKyc.R.id.pan_ack_date_et
                android.view.View r5 = r5.a((int) r1)
                com.google.android.material.textfield.TextInputEditText r5 = (com.google.android.material.textfield.TextInputEditText) r5
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
                android.text.Editable r5 = r5.getText()
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                kotlin.m.l r0 = new kotlin.m.l
                java.lang.String r1 = "-"
                r0.<init>((java.lang.String) r1)
                r1 = 0
                java.util.List r5 = r0.split(r5, r1)
                boolean r0 = r5.isEmpty()
                r2 = 1
                if (r0 != 0) goto L_0x0078
                int r0 = r5.size()
                java.util.ListIterator r0 = r5.listIterator(r0)
            L_0x0053:
                boolean r3 = r0.hasPrevious()
                if (r3 == 0) goto L_0x0078
                java.lang.Object r3 = r0.previous()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                if (r3 != 0) goto L_0x0069
                r3 = 1
                goto L_0x006a
            L_0x0069:
                r3 = 0
            L_0x006a:
                if (r3 != 0) goto L_0x0053
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                int r0 = r0.nextIndex()
                int r0 = r0 + r2
                java.util.List r5 = kotlin.a.k.b(r5, (int) r0)
                goto L_0x007c
            L_0x0078:
                kotlin.a.w r5 = kotlin.a.w.INSTANCE
                java.util.List r5 = (java.util.List) r5
            L_0x007c:
                java.util.Collection r5 = (java.util.Collection) r5
                java.lang.String[] r0 = new java.lang.String[r1]
                java.lang.Object[] r5 = r5.toArray(r0)
                if (r5 == 0) goto L_0x00b2
                java.lang.String[] r5 = (java.lang.String[]) r5
                r0 = r5[r1]
                int r0 = java.lang.Integer.parseInt(r0)
                r1 = r5[r2]
                int r1 = java.lang.Integer.parseInt(r1)
                r2 = 2
                r5 = r5[r2]
                int r5 = java.lang.Integer.parseInt(r5)
                net.one97.paytm.upgradeKyc.utils.d r5 = net.one97.paytm.upgradeKyc.utils.d.a(r5, r1, r0)
            L_0x009f:
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r4.f66101a
                androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
                java.lang.String r1 = "DatePicker"
                r5.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
                net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity r0 = r4.f66101a
                net.one97.paytm.upgradeKyc.utils.d$a r0 = (net.one97.paytm.upgradeKyc.utils.d.a) r0
                r5.a((net.one97.paytm.upgradeKyc.utils.d.a) r0)
                return
            L_0x00b2:
                kotlin.u r5 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity.j.onClick(android.view.View):void");
        }
    }

    static final class k implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66102a;

        k(ConsentCaptureActivity consentCaptureActivity) {
            this.f66102a = consentCaptureActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            UpgradeKycBaseActivity.a(this.f66102a, "/kyc/slot-preference", "checkbox_checked", (HashMap) null, (String) null, 12);
        }
    }

    static final class l implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66103a;

        l(ConsentCaptureActivity consentCaptureActivity) {
            this.f66103a = consentCaptureActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            UpgradeKycBaseActivity.a(this.f66103a, "/kyc/slot-preference", "checkbox_checked", (HashMap) null, (String) null, 12);
        }
    }

    static final class m implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66104a;

        m(ConsentCaptureActivity consentCaptureActivity) {
            this.f66104a = consentCaptureActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            UpgradeKycBaseActivity.a(this.f66104a, "/kyc/slot-preference", "checkbox_checked", (HashMap) null, (String) null, 12);
        }
    }

    static final class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConsentCaptureActivity f66096a;

        e(ConsentCaptureActivity consentCaptureActivity) {
            this.f66096a = consentCaptureActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            UpgradeKycBaseActivity.a(this.f66096a, "/kyc/slot-preference", "checkbox_checked", (HashMap) null, (String) null, 12);
        }
    }

    public final void a(int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append('-');
        sb.append(i3);
        sb.append('-');
        sb.append(i2);
        ((TextInputEditText) a(R.id.pan_ack_date_et)).setText(sb.toString());
    }

    private final void c(String str) {
        Snackbar.a((View) (ConstraintLayout) a(R.id.consent_capture_parent_lyt), (CharSequence) str, -1).c();
    }

    public static final /* synthetic */ boolean a(ConsentCaptureActivity consentCaptureActivity) {
        CheckBox checkBox = (CheckBox) consentCaptureActivity.a(R.id.bioconsent_cb);
        kotlin.g.b.k.a((Object) checkBox, "bioconsent_cb");
        if (checkBox.isChecked()) {
            CheckBox checkBox2 = (CheckBox) consentCaptureActivity.a(R.id.full_kyc_cb);
            kotlin.g.b.k.a((Object) checkBox2, "full_kyc_cb");
            if (checkBox2.isChecked()) {
                CheckBox checkBox3 = (CheckBox) consentCaptureActivity.a(R.id.i_declare_cb);
                kotlin.g.b.k.a((Object) checkBox3, "i_declare_cb");
                if (checkBox3.isChecked()) {
                    CheckBox checkBox4 = (CheckBox) consentCaptureActivity.a(R.id.above_eighteen_cb);
                    kotlin.g.b.k.a((Object) checkBox4, "above_eighteen_cb");
                    if (checkBox4.isChecked()) {
                        RadioGroup radioGroup = (RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_do_you_have_pan);
                        kotlin.g.b.k.a((Object) radioGroup, "layout_kyc_do_you_have_pan");
                        if (radioGroup.getCheckedRadioButtonId() == R.id.yes_have_pan) {
                            TextInputEditText textInputEditText = (TextInputEditText) consentCaptureActivity.a(R.id.kyc_enter_doc_num_et);
                            kotlin.g.b.k.a((Object) textInputEditText, "kyc_enter_doc_num_et");
                            if (!TextUtils.isEmpty(textInputEditText.getText())) {
                                TextInputEditText textInputEditText2 = (TextInputEditText) consentCaptureActivity.a(R.id.kyc_enter_doc_num_et);
                                kotlin.g.b.k.a((Object) textInputEditText2, "kyc_enter_doc_num_et");
                                if (com.paytm.utility.b.V(String.valueOf(textInputEditText2.getText()))) {
                                    return true;
                                }
                            }
                            String string = consentCaptureActivity.getString(R.string.error_valid_pan);
                            kotlin.g.b.k.a((Object) string, "getString(R.string.error_valid_pan)");
                            consentCaptureActivity.c(string);
                            return false;
                        }
                        RadioGroup radioGroup2 = (RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_do_you_have_pan);
                        kotlin.g.b.k.a((Object) radioGroup2, "layout_kyc_do_you_have_pan");
                        if (radioGroup2.getCheckedRadioButtonId() != R.id.no_have_pan) {
                            return true;
                        }
                        TextInputEditText textInputEditText3 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_agri_income_et);
                        kotlin.g.b.k.a((Object) textInputEditText3, "annual_agri_income_et");
                        if (!TextUtils.isEmpty(textInputEditText3.getText())) {
                            TextInputEditText textInputEditText4 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_non_agri_income_et);
                            kotlin.g.b.k.a((Object) textInputEditText4, "annual_non_agri_income_et");
                            if (!TextUtils.isEmpty(textInputEditText4.getText())) {
                                TextInputEditText textInputEditText5 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_agri_income_et);
                                kotlin.g.b.k.a((Object) textInputEditText5, "annual_agri_income_et");
                                if (!TextUtils.isEmpty(textInputEditText5.getText())) {
                                    TextInputEditText textInputEditText6 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_non_agri_income_et);
                                    kotlin.g.b.k.a((Object) textInputEditText6, "annual_non_agri_income_et");
                                    if (!TextUtils.isEmpty(textInputEditText6.getText())) {
                                        TextInputEditText textInputEditText7 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_agri_income_et);
                                        kotlin.g.b.k.a((Object) textInputEditText7, "annual_agri_income_et");
                                        if (Long.parseLong(String.valueOf(textInputEditText7.getText())) > 1000000000) {
                                            String string2 = consentCaptureActivity.getString(R.string.error_greater_agri);
                                            kotlin.g.b.k.a((Object) string2, "getString(R.string.error_greater_agri)");
                                            consentCaptureActivity.c(string2);
                                            return false;
                                        }
                                        TextInputEditText textInputEditText8 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_non_agri_income_et);
                                        kotlin.g.b.k.a((Object) textInputEditText8, "annual_non_agri_income_et");
                                        if (Long.parseLong(String.valueOf(textInputEditText8.getText())) <= 250000) {
                                            return true;
                                        }
                                        String string3 = consentCaptureActivity.getString(R.string.error_greater_nonagri);
                                        kotlin.g.b.k.a((Object) string3, "getString(R.string.error_greater_nonagri)");
                                        consentCaptureActivity.c(string3);
                                        return false;
                                    }
                                }
                                RadioGroup radioGroup3 = (RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_have_applied_pan);
                                kotlin.g.b.k.a((Object) radioGroup3, "layout_kyc_have_applied_pan");
                                if (radioGroup3.getCheckedRadioButtonId() != R.id.yes_have_applied_pan) {
                                    return true;
                                }
                                TextInputEditText textInputEditText9 = (TextInputEditText) consentCaptureActivity.a(R.id.pan_ack_num_et);
                                kotlin.g.b.k.a((Object) textInputEditText9, "pan_ack_num_et");
                                if (TextUtils.isEmpty(textInputEditText9.getText())) {
                                    String string4 = consentCaptureActivity.getString(R.string.error_fill_details);
                                    kotlin.g.b.k.a((Object) string4, "getString(R.string.error_fill_details)");
                                    consentCaptureActivity.c(string4);
                                    return false;
                                }
                                TextInputEditText textInputEditText10 = (TextInputEditText) consentCaptureActivity.a(R.id.pan_ack_num_et);
                                kotlin.g.b.k.a((Object) textInputEditText10, "pan_ack_num_et");
                                if (TextUtils.isEmpty(textInputEditText10.getText())) {
                                    String string5 = consentCaptureActivity.getString(R.string.pan_ack_date_error);
                                    kotlin.g.b.k.a((Object) string5, "getString(R.string.pan_ack_date_error)");
                                    consentCaptureActivity.c(string5);
                                    return false;
                                }
                                TextInputEditText textInputEditText11 = (TextInputEditText) consentCaptureActivity.a(R.id.pan_ack_date_et);
                                kotlin.g.b.k.a((Object) textInputEditText11, "pan_ack_date_et");
                                if (TextUtils.isEmpty(textInputEditText11.getText())) {
                                    return true;
                                }
                                TextInputEditText textInputEditText12 = (TextInputEditText) consentCaptureActivity.a(R.id.pan_ack_date_et);
                                kotlin.g.b.k.a((Object) textInputEditText12, "pan_ack_date_et");
                                if (!net.one97.paytm.upgradeKyc.kycV3.b.a(String.valueOf(textInputEditText12.getText()))) {
                                    return true;
                                }
                                String string6 = consentCaptureActivity.getString(R.string.pan_ack_date_error);
                                kotlin.g.b.k.a((Object) string6, "getString(R.string.pan_ack_date_error)");
                                consentCaptureActivity.c(string6);
                                return false;
                            }
                        }
                        String string7 = consentCaptureActivity.getString(R.string.error_fill_details);
                        kotlin.g.b.k.a((Object) string7, "getString(R.string.error_fill_details)");
                        consentCaptureActivity.c(string7);
                        return false;
                    }
                }
            }
        }
        String string8 = consentCaptureActivity.getString(R.string.error_fill_details);
        kotlin.g.b.k.a((Object) string8, "getString(R.string.error_fill_details)");
        consentCaptureActivity.c(string8);
        return false;
    }

    public static final /* synthetic */ ConsentSaveObject b(ConsentCaptureActivity consentCaptureActivity) {
        ConsentSaveObject consentSaveObject = new ConsentSaveObject(false, false, (String) null, (String) null, (ConsentSaveForm60) null, false, false, false, PriceRangeSeekBar.INVALID_POINTER_ID, (kotlin.g.b.g) null);
        consentSaveObject.setBiometricConsent(true);
        consentSaveObject.setFatca(true);
        RadioGroup radioGroup = (RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_do_you_have_pan);
        kotlin.g.b.k.a((Object) radioGroup, "layout_kyc_do_you_have_pan");
        if (radioGroup.getCheckedRadioButtonId() == R.id.yes_have_pan) {
            TextInputEditText textInputEditText = (TextInputEditText) consentCaptureActivity.a(R.id.kyc_enter_doc_num_et);
            kotlin.g.b.k.a((Object) textInputEditText, "kyc_enter_doc_num_et");
            consentSaveObject.setPan(String.valueOf(textInputEditText.getText()));
        } else {
            ConsentSaveForm60 consentSaveForm60 = new ConsentSaveForm60((String) null, (String) null, (String) null, (String) null, 15, (kotlin.g.b.g) null);
            TextInputEditText textInputEditText2 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_agri_income_et);
            kotlin.g.b.k.a((Object) textInputEditText2, "annual_agri_income_et");
            consentSaveForm60.setAgriculturalIncome(String.valueOf(textInputEditText2.getText()));
            TextInputEditText textInputEditText3 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_non_agri_income_et);
            kotlin.g.b.k.a((Object) textInputEditText3, "annual_non_agri_income_et");
            consentSaveForm60.setNonAgriculturalIncome(String.valueOf(textInputEditText3.getText()));
            TextInputEditText textInputEditText4 = (TextInputEditText) consentCaptureActivity.a(R.id.pan_ack_date_et);
            kotlin.g.b.k.a((Object) textInputEditText4, "pan_ack_date_et");
            consentSaveForm60.setPanAckDate(String.valueOf(textInputEditText4.getText()));
            TextInputEditText textInputEditText5 = (TextInputEditText) consentCaptureActivity.a(R.id.pan_ack_num_et);
            kotlin.g.b.k.a((Object) textInputEditText5, "pan_ack_num_et");
            consentSaveForm60.setPanAckNumber(String.valueOf(textInputEditText5.getText()));
            consentSaveObject.setForm60(consentSaveForm60);
            consentSaveObject.setForm60Consent(true);
        }
        RadioGroup radioGroup2 = (RadioGroup) consentCaptureActivity.a(R.id.rg_fasttag);
        kotlin.g.b.k.a((Object) radioGroup2, "rg_fasttag");
        consentSaveObject.setFastagKycConsent(radioGroup2.getCheckedRadioButtonId() == R.id.yes_fasttag);
        consentSaveObject.setNonMinorConsent(true);
        RadioGroup radioGroup3 = (RadioGroup) consentCaptureActivity.a(R.id.service_avail_grp);
        kotlin.g.b.k.a((Object) radioGroup3, "service_avail_grp");
        if (radioGroup3.getCheckedRadioButtonId() == R.id.savings_acnt_option) {
            consentSaveObject.setProductSelected("Savings Account");
        } else {
            RadioGroup radioGroup4 = (RadioGroup) consentCaptureActivity.a(R.id.service_avail_grp);
            kotlin.g.b.k.a((Object) radioGroup4, "service_avail_grp");
            if (radioGroup4.getCheckedRadioButtonId() == R.id.full_kyc_wallet_option) {
                consentSaveObject.setProductSelected("Wallet upgrade");
            } else {
                consentSaveObject.setProductSelected("Wallet upgrade and Savings Account");
            }
        }
        return consentSaveObject;
    }

    public static final /* synthetic */ void a(ConsentCaptureActivity consentCaptureActivity, boolean z) {
        RadioGroup radioGroup = (RadioGroup) consentCaptureActivity.a(R.id.service_avail_grp);
        kotlin.g.b.k.a((Object) radioGroup, "service_avail_grp");
        int childCount = radioGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = ((RadioGroup) consentCaptureActivity.a(R.id.service_avail_grp)).getChildAt(i2);
            kotlin.g.b.k.a((Object) childAt, "service_avail_grp.getChildAt(i)");
            childAt.setClickable(z);
        }
        RadioGroup radioGroup2 = (RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_do_you_have_pan);
        kotlin.g.b.k.a((Object) radioGroup2, "layout_kyc_do_you_have_pan");
        int childCount2 = radioGroup2.getChildCount();
        for (int i3 = 0; i3 < childCount2; i3++) {
            View childAt2 = ((RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_do_you_have_pan)).getChildAt(i3);
            kotlin.g.b.k.a((Object) childAt2, "layout_kyc_do_you_have_pan.getChildAt(i)");
            childAt2.setClickable(z);
        }
        RadioGroup radioGroup3 = (RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_have_applied_pan);
        kotlin.g.b.k.a((Object) radioGroup3, "layout_kyc_have_applied_pan");
        int childCount3 = radioGroup3.getChildCount();
        for (int i4 = 0; i4 < childCount3; i4++) {
            View childAt3 = ((RadioGroup) consentCaptureActivity.a(R.id.layout_kyc_have_applied_pan)).getChildAt(i4);
            kotlin.g.b.k.a((Object) childAt3, "layout_kyc_have_applied_pan.getChildAt(i)");
            childAt3.setClickable(z);
        }
        TextInputEditText textInputEditText = (TextInputEditText) consentCaptureActivity.a(R.id.annual_agri_income_et);
        kotlin.g.b.k.a((Object) textInputEditText, "annual_agri_income_et");
        textInputEditText.setClickable(z);
        TextInputEditText textInputEditText2 = (TextInputEditText) consentCaptureActivity.a(R.id.annual_non_agri_income_et);
        kotlin.g.b.k.a((Object) textInputEditText2, "annual_non_agri_income_et");
        textInputEditText2.setClickable(z);
        TextInputEditText textInputEditText3 = (TextInputEditText) consentCaptureActivity.a(R.id.pan_ack_num_et);
        kotlin.g.b.k.a((Object) textInputEditText3, "pan_ack_num_et");
        textInputEditText3.setClickable(z);
        CheckBox checkBox = (CheckBox) consentCaptureActivity.a(R.id.bioconsent_cb);
        kotlin.g.b.k.a((Object) checkBox, "bioconsent_cb");
        checkBox.setClickable(z);
        CheckBox checkBox2 = (CheckBox) consentCaptureActivity.a(R.id.full_kyc_cb);
        kotlin.g.b.k.a((Object) checkBox2, "full_kyc_cb");
        checkBox2.setClickable(z);
        TextInputEditText textInputEditText4 = (TextInputEditText) consentCaptureActivity.a(R.id.kyc_enter_doc_num_et);
        kotlin.g.b.k.a((Object) textInputEditText4, "kyc_enter_doc_num_et");
        textInputEditText4.setClickable(z);
        ConstraintLayout constraintLayout = (ConstraintLayout) consentCaptureActivity.a(R.id.consent_capture_parent_lyt);
        kotlin.g.b.k.a((Object) constraintLayout, "consent_capture_parent_lyt");
        constraintLayout.setClickable(z);
        CheckBox checkBox3 = (CheckBox) consentCaptureActivity.a(R.id.above_eighteen_cb);
        kotlin.g.b.k.a((Object) checkBox3, "above_eighteen_cb");
        checkBox3.setClickable(z);
        CheckBox checkBox4 = (CheckBox) consentCaptureActivity.a(R.id.i_declare_cb);
        kotlin.g.b.k.a((Object) checkBox4, "i_declare_cb");
        checkBox4.setClickable(z);
    }

    public static final /* synthetic */ void a(ConsentCaptureActivity consentCaptureActivity, KycSavedUserData kycSavedUserData) {
        boolean z;
        Intent intent = new Intent(consentCaptureActivity, AppointmentBookedActivity.class);
        if (kycSavedUserData.getKYCDetail() == null || kycSavedUserData.getKYCDetail().size() <= 0) {
            Snackbar.a((View) (ConstraintLayout) consentCaptureActivity.a(R.id.consent_capture_parent_lyt), (CharSequence) consentCaptureActivity.getString(R.string.some_went_wrong), -1).c();
            return;
        }
        KYCDetail kYCDetail = kycSavedUserData.getKYCDetail().get(0);
        if (kYCDetail != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("customerId", com.paytm.utility.b.n((Context) consentCaptureActivity));
                jSONObject.put("leadSource", "App");
                jSONObject.put("addressChanged", "false");
                if (!TextUtils.isEmpty(com.paytm.utility.b.l((Context) consentCaptureActivity))) {
                    jSONObject.put("phoneNumber", com.paytm.utility.b.l((Context) consentCaptureActivity));
                    jSONObject.put("altPhoneNumber", com.paytm.utility.b.l((Context) consentCaptureActivity));
                }
                JSONObject jSONObject2 = new JSONObject();
                Collection addDetails = kYCDetail.getAddDetails();
                if (addDetails != null) {
                    if (!addDetails.isEmpty()) {
                        z = false;
                        if (!z && kYCDetail.getAddDetails().get(0) != null) {
                            KycAddDetail kycAddDetail = kYCDetail.getAddDetails().get(0);
                            kotlin.g.b.k.a((Object) kycAddDetail, "res.addDetails[0]");
                            jSONObject2.put("addressLine1", kycAddDetail.getAddressLine1());
                            KycAddDetail kycAddDetail2 = kYCDetail.getAddDetails().get(0);
                            kotlin.g.b.k.a((Object) kycAddDetail2, "res.addDetails[0]");
                            jSONObject2.put("addressLine2", kycAddDetail2.getAddressLine3());
                            KycAddDetail kycAddDetail3 = kYCDetail.getAddDetails().get(0);
                            kotlin.g.b.k.a((Object) kycAddDetail3, "res.addDetails[0]");
                            jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, kycAddDetail3.getPincodeC());
                            KycAddDetail kycAddDetail4 = kYCDetail.getAddDetails().get(0);
                            kotlin.g.b.k.a((Object) kycAddDetail4, "res.addDetails[0]");
                            jSONObject2.put("city", kycAddDetail4.getCity());
                            KycAddDetail kycAddDetail5 = kYCDetail.getAddDetails().get(0);
                            kotlin.g.b.k.a((Object) kycAddDetail5, "res.addDetails[0]");
                            jSONObject2.put("state", kycAddDetail5.getState());
                        }
                        jSONObject.put("kycAddress", jSONObject2);
                        jSONObject.put("kycDocument", new JSONObject());
                        a.C1325a aVar = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
                        Context applicationContext = consentCaptureActivity.getApplicationContext();
                        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                        a.C1325a.a(applicationContext);
                        net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData", jSONObject.toString());
                        intent.putExtra("kyc_additional_info", kYCDetail);
                    }
                }
                z = true;
                KycAddDetail kycAddDetail6 = kYCDetail.getAddDetails().get(0);
                kotlin.g.b.k.a((Object) kycAddDetail6, "res.addDetails[0]");
                jSONObject2.put("addressLine1", kycAddDetail6.getAddressLine1());
                KycAddDetail kycAddDetail22 = kYCDetail.getAddDetails().get(0);
                kotlin.g.b.k.a((Object) kycAddDetail22, "res.addDetails[0]");
                jSONObject2.put("addressLine2", kycAddDetail22.getAddressLine3());
                KycAddDetail kycAddDetail32 = kYCDetail.getAddDetails().get(0);
                kotlin.g.b.k.a((Object) kycAddDetail32, "res.addDetails[0]");
                jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, kycAddDetail32.getPincodeC());
                KycAddDetail kycAddDetail42 = kYCDetail.getAddDetails().get(0);
                kotlin.g.b.k.a((Object) kycAddDetail42, "res.addDetails[0]");
                jSONObject2.put("city", kycAddDetail42.getCity());
                KycAddDetail kycAddDetail52 = kYCDetail.getAddDetails().get(0);
                kotlin.g.b.k.a((Object) kycAddDetail52, "res.addDetails[0]");
                jSONObject2.put("state", kycAddDetail52.getState());
                jSONObject.put("kycAddress", jSONObject2);
                jSONObject.put("kycDocument", new JSONObject());
            } catch (JSONException e2) {
                com.paytm.utility.q.b(e2.getMessage());
            }
            a.C1325a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
            Context applicationContext2 = consentCaptureActivity.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext2, "applicationContext");
            a.C1325a.a(applicationContext2);
            net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData", jSONObject.toString());
            intent.putExtra("kyc_additional_info", kYCDetail);
        }
        consentCaptureActivity.startActivity(intent);
        consentCaptureActivity.finish();
    }
}
