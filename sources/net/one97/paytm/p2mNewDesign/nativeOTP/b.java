package net.one97.paytm.p2mNewDesign.nativeOTP;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import androidx.transition.v;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.widgets.DotProgressBar;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.p2mNewDesign.entity.BankForm;
import net.one97.paytm.p2mNewDesign.entity.DirectForm;
import net.one97.paytm.p2mNewDesign.entity.TxnInfo;
import net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsBody;
import net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResponse;
import net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResultInfo;
import net.one97.paytm.p2mNewDesign.nativeOTP.AJRNativeOTPActivity;
import net.one97.paytm.utils.ae;
import net.one97.paytm.wallet.R;

public final class b extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56961a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static BankForm f56962h;

    /* renamed from: b  reason: collision with root package name */
    private CountDownTimer f56963b;

    /* renamed from: c  reason: collision with root package name */
    private CountDownTimer f56964c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f56965d;

    /* renamed from: e  reason: collision with root package name */
    private View f56966e;

    /* renamed from: f  reason: collision with root package name */
    private e f56967f;

    /* renamed from: g  reason: collision with root package name */
    private c f56968g;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f56969i;

    static final class j<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56978a;

        j(b bVar) {
            this.f56978a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
                IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                if (iJRPaytmDataModel != null) {
                    DirectFormsResponse directFormsResponse = (DirectFormsResponse) iJRPaytmDataModel;
                    DirectFormsBody body = directFormsResponse.getBody();
                    kotlin.g.b.k.a((Object) body, "response.body");
                    boolean isResendRetry = body.isResendRetry();
                    DirectFormsBody body2 = directFormsResponse.getBody();
                    kotlin.g.b.k.a((Object) body2, "response.body");
                    DirectFormsResultInfo resultInfo = body2.getResultInfo();
                    kotlin.g.b.k.a((Object) resultInfo, "it");
                    if (kotlin.g.b.k.a((Object) resultInfo.getResultStatus(), (Object) "S")) {
                        b.i(this.f56978a);
                        b.g(this.f56978a).a(AJRNativeOTPActivity.a.RESEND, (TxnInfo) null);
                        if (isResendRetry) {
                            this.f56978a.b();
                        }
                    } else {
                        b.i(this.f56978a);
                        e g2 = b.g(this.f56978a);
                        AJRNativeOTPActivity.a aVar = AJRNativeOTPActivity.a.RESEND;
                        String resultMsg = resultInfo.getResultMsg();
                        kotlin.g.b.k.a((Object) resultMsg, "it.resultMsg");
                        g2.a(aVar, resultMsg);
                    }
                    if (!isResendRetry) {
                        b.g(this.f56978a).e();
                        AppCompatTextView appCompatTextView = (AppCompatTextView) b.e(this.f56978a).findViewById(R.id.native_otp_sheet_resend_otp_timer);
                        kotlin.g.b.k.a((Object) appCompatTextView, "rootView.native_otp_sheet_resend_otp_timer");
                        appCompatTextView.setVisibility(8);
                        ((AppCompatTextView) b.e(this.f56978a).findViewById(R.id.native_otp_sheet_resend_otp)).setTextColor(this.f56978a.getResources().getColor(R.color.hint_grey));
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) b.e(this.f56978a).findViewById(R.id.native_otp_sheet_resend_otp);
                        kotlin.g.b.k.a((Object) appCompatTextView2, "rootView.native_otp_sheet_resend_otp");
                        appCompatTextView2.setClickable(false);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResponse");
            } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
                b.i(this.f56978a);
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_is_from_fragment", true);
                if (fVar.f55798c != null) {
                    ae aeVar = ae.f69602a;
                    if (ae.a(fVar.f55798c.f55799a)) {
                        ae aeVar2 = ae.f69602a;
                        FragmentActivity activity = this.f56978a.getActivity();
                        if (activity == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity, "activity!!");
                        ae.a(activity, fVar.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                        return;
                    }
                }
                b.g(this.f56978a).a(AJRNativeOTPActivity.a.RESEND, "Unable to resend OTP");
            }
        }
    }

    static final class o<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56986a;

        o(b bVar) {
            this.f56986a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
                IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                if (iJRPaytmDataModel != null) {
                    DirectFormsResponse directFormsResponse = (DirectFormsResponse) iJRPaytmDataModel;
                    DirectFormsBody body = directFormsResponse.getBody();
                    kotlin.g.b.k.a((Object) body, "response.body");
                    DirectFormsResultInfo resultInfo = body.getResultInfo();
                    kotlin.g.b.k.a((Object) resultInfo, "it");
                    if (kotlin.g.b.k.a((Object) resultInfo.getResultStatus(), (Object) "S")) {
                        b.h(this.f56986a);
                    } else {
                        b.h(this.f56986a);
                        if (resultInfo.isBankRetry()) {
                            this.f56986a.f56965d = true;
                            ((RelativeLayout) b.e(this.f56986a).findViewById(R.id.native_otp_sheet_et_container)).setBackgroundResource(R.drawable.round_corner_red_shape);
                            TextInputLayout textInputLayout = (TextInputLayout) b.e(this.f56986a).findViewById(R.id.text_input_layout);
                            kotlin.g.b.k.a((Object) textInputLayout, "rootView.text_input_layout");
                            textInputLayout.setHint("Incorrect OTP");
                            TextInputLayout textInputLayout2 = (TextInputLayout) b.e(this.f56986a).findViewById(R.id.text_input_layout);
                            kotlin.g.b.k.a((Object) textInputLayout2, "rootView.text_input_layout");
                            textInputLayout2.setError(" ");
                            return;
                        } else if (resultInfo.getRetry()) {
                            e g2 = b.g(this.f56986a);
                            String resultMsg = resultInfo.getResultMsg();
                            kotlin.g.b.k.a((Object) resultMsg, "it.resultMsg");
                            g2.b(resultMsg);
                            return;
                        }
                    }
                    e g3 = b.g(this.f56986a);
                    AJRNativeOTPActivity.a aVar = AJRNativeOTPActivity.a.SUBMIT;
                    DirectFormsBody body2 = directFormsResponse.getBody();
                    kotlin.g.b.k.a((Object) body2, "response.body");
                    g3.a(aVar, body2.getTxnInfo());
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResponse");
            } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
                b.h(this.f56986a);
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_is_from_fragment", true);
                if (fVar.f55798c != null) {
                    ae aeVar = ae.f69602a;
                    if (ae.a(fVar.f55798c.f55799a)) {
                        ae aeVar2 = ae.f69602a;
                        FragmentActivity activity = this.f56986a.getActivity();
                        if (activity == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity, "activity!!");
                        ae.a(activity, fVar.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                        return;
                    }
                }
                b.g(this.f56986a).a(AJRNativeOTPActivity.a.SUBMIT, "Something went wrong!");
            }
        }
    }

    public static final /* synthetic */ View e(b bVar) {
        View view = bVar.f56966e;
        if (view == null) {
            kotlin.g.b.k.a("rootView");
        }
        return view;
    }

    public static final /* synthetic */ e g(b bVar) {
        e eVar = bVar.f56967f;
        if (eVar == null) {
            kotlin.g.b.k.a("listener");
        }
        return eVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            com.paytm.utility.b.e((Activity) activity);
        }
        setStyle(2, 0);
        FragmentActivity activity2 = getActivity();
        if (!(activity2 == null || (window = activity2.getWindow()) == null)) {
            window.setSoftInputMode(16);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            kotlin.g.b.k.a((Object) activity3, "it");
            Application application = activity3.getApplication();
            kotlin.g.b.k.a((Object) application, "it.application");
            ai a2 = new al((ao) this, (al.b) new d(application)).a(c.class);
            kotlin.g.b.k.a((Object) a2, "ViewModelProvider(this, …OTPViewModel::class.java)");
            this.f56968g = (c) a2;
        }
    }

    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d2, code lost:
        r3 = r3.getDisplayField();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r12, android.view.ViewGroup r13, android.os.Bundle r14) {
        /*
            r11 = this;
            java.lang.String r14 = "inflater"
            kotlin.g.b.k.c(r12, r14)
            int r14 = net.one97.paytm.wallet.R.layout.offline_native_otp_bottomsheet
            r0 = 0
            android.view.View r12 = r12.inflate(r14, r13, r0)
            java.lang.String r13 = "inflater.inflate(R.layou…msheet, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r11.f56966e = r12
            android.view.View r12 = r11.f56966e
            java.lang.String r13 = "rootView"
            if (r12 != 0) goto L_0x001c
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x001c:
            int r14 = net.one97.paytm.wallet.R.id.native_otp_sheet_resend_otp
            android.view.View r12 = r12.findViewById(r14)
            androidx.appcompat.widget.AppCompatTextView r12 = (androidx.appcompat.widget.AppCompatTextView) r12
            net.one97.paytm.p2mNewDesign.nativeOTP.b$c r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$c
            r14.<init>(r11)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r12.setOnClickListener(r14)
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x0035
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0035:
            int r14 = net.one97.paytm.wallet.R.id.native_otp_sheet_submit_button
            android.view.View r12 = r12.findViewById(r14)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            net.one97.paytm.p2mNewDesign.nativeOTP.b$d r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$d
            r14.<init>(r11)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r12.setOnClickListener(r14)
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x004e
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x004e:
            int r14 = net.one97.paytm.wallet.R.id.native_otp_sheet_close
            android.view.View r12 = r12.findViewById(r14)
            androidx.appcompat.widget.AppCompatImageView r12 = (androidx.appcompat.widget.AppCompatImageView) r12
            net.one97.paytm.p2mNewDesign.nativeOTP.b$e r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$e
            r14.<init>(r11)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r12.setOnClickListener(r14)
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x0067
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0067:
            int r14 = net.one97.paytm.wallet.R.id.lyt_pay_on_bank
            android.view.View r12 = r12.findViewById(r14)
            net.one97.paytm.p2mNewDesign.nativeOTP.b$f r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$f
            r14.<init>(r11)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r12.setOnClickListener(r14)
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x007e
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x007e:
            int r14 = net.one97.paytm.wallet.R.id.native_otp_sheet_et
            android.view.View r12 = r12.findViewById(r14)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.p2mNewDesign.nativeOTP.b$g r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$g
            r14.<init>(r11)
            android.view.View$OnFocusChangeListener r14 = (android.view.View.OnFocusChangeListener) r14
            r12.setOnFocusChangeListener(r14)
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x0097
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0097:
            int r14 = net.one97.paytm.wallet.R.id.native_otp_sheet_et
            android.view.View r12 = r12.findViewById(r14)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            net.one97.paytm.p2mNewDesign.nativeOTP.b$h r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$h
            r14.<init>(r11)
            android.text.TextWatcher r14 = (android.text.TextWatcher) r14
            r12.addTextChangedListener(r14)
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x00b0
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x00b0:
            int r14 = net.one97.paytm.wallet.R.id.pay_on_bank_header_description
            android.view.View r12 = r12.findViewById(r14)
            androidx.appcompat.widget.AppCompatTextView r12 = (androidx.appcompat.widget.AppCompatTextView) r12
            java.lang.String r14 = "rootView.pay_on_bank_header_description"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)
            kotlin.g.b.aa r14 = kotlin.g.b.aa.f47921a
            int r14 = net.one97.paytm.wallet.R.string.still_did_not_receive_otp_desc
            java.lang.String r14 = r11.getString(r14)
            java.lang.String r1 = "getString(R.string.still_did_not_receive_otp_desc)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            net.one97.paytm.p2mNewDesign.entity.BankForm r3 = f56962h
            r4 = 0
            if (r3 == 0) goto L_0x00dd
            net.one97.paytm.p2mNewDesign.entity.DisplayField r3 = r3.getDisplayField()
            if (r3 == 0) goto L_0x00dd
            java.lang.String r3 = r3.getBankName()
            goto L_0x00de
        L_0x00dd:
            r3 = r4
        L_0x00de:
            r2[r0] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r14 = java.lang.String.format(r14, r0)
            java.lang.String r0 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r12.setText(r14)
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x00f9
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x00f9:
            int r14 = net.one97.paytm.wallet.R.id.text_input_layout
            android.view.View r12 = r12.findViewById(r14)
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
            java.lang.String r14 = "rootView.text_input_layout"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)
            android.view.ViewTreeObserver r12 = r12.getViewTreeObserver()
            net.one97.paytm.p2mNewDesign.nativeOTP.b$i r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$i
            r14.<init>(r11)
            android.view.ViewTreeObserver$OnPreDrawListener r14 = (android.view.ViewTreeObserver.OnPreDrawListener) r14
            r12.addOnPreDrawListener(r14)
            r11.b()
            net.one97.paytm.p2mNewDesign.entity.BankForm r12 = f56962h
            if (r12 == 0) goto L_0x012b
            net.one97.paytm.p2mNewDesign.entity.DisplayField r12 = r12.getDisplayField()
            if (r12 == 0) goto L_0x012b
            java.lang.String r12 = r12.getPageExpiryTime()
            if (r12 == 0) goto L_0x012b
            java.lang.Long r4 = kotlin.m.p.d(r12)
        L_0x012b:
            if (r4 == 0) goto L_0x0141
            java.lang.Number r4 = (java.lang.Number) r4
            long r8 = r4.longValue()
            net.one97.paytm.p2mNewDesign.nativeOTP.b$l r12 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$l
            r5 = r12
            r6 = r8
            r10 = r11
            r5.<init>(r6, r8, r10)
            android.os.CountDownTimer r12 = r12.start()
            r11.f56963b = r12
        L_0x0141:
            net.one97.paytm.p2mNewDesign.entity.BankForm r12 = f56962h
            if (r12 == 0) goto L_0x0164
            net.one97.paytm.p2mNewDesign.entity.DisplayField r12 = r12.getDisplayField()
            if (r12 == 0) goto L_0x0164
            java.lang.String r12 = r12.getPayOnBankTime()
            if (r12 == 0) goto L_0x0164
            long r0 = java.lang.Long.parseLong(r12)
            android.os.Handler r12 = new android.os.Handler
            r12.<init>()
            net.one97.paytm.p2mNewDesign.nativeOTP.b$m r14 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$m
            r14.<init>(r11)
            java.lang.Runnable r14 = (java.lang.Runnable) r14
            r12.postDelayed(r14, r0)
        L_0x0164:
            net.one97.paytm.p2mNewDesign.entity.BankForm r12 = f56962h
            if (r12 == 0) goto L_0x0187
            net.one97.paytm.p2mNewDesign.entity.DisplayField r12 = r12.getDisplayField()
            if (r12 == 0) goto L_0x0187
            java.lang.String r12 = r12.getExpiryAlertTime()
            if (r12 == 0) goto L_0x0187
            android.os.Handler r14 = new android.os.Handler
            r14.<init>()
            net.one97.paytm.p2mNewDesign.nativeOTP.b$k r0 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$k
            r0.<init>(r12, r11)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            long r1 = java.lang.Long.parseLong(r12)
            r14.postDelayed(r0, r1)
        L_0x0187:
            android.view.View r12 = r11.f56966e
            if (r12 != 0) goto L_0x018e
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x018e:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.nativeOTP.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        this.f56967f = (e) context;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56971a;

        c(b bVar) {
            this.f56971a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f56971a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56972a;

        d(b bVar) {
            this.f56972a = bVar;
        }

        public final void onClick(View view) {
            b.b(this.f56972a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56973a;

        e(b bVar) {
            this.f56973a = bVar;
        }

        public final void onClick(View view) {
            b.c(this.f56973a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56974a;

        f(b bVar) {
            this.f56974a = bVar;
        }

        public final void onClick(View view) {
            b.d(this.f56974a);
        }
    }

    static final class g implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56975a;

        g(b bVar) {
            this.f56975a = bVar;
        }

        public final void onFocusChange(View view, boolean z) {
            b bVar = this.f56975a;
            TextInputEditText textInputEditText = (TextInputEditText) b.e(bVar).findViewById(R.id.native_otp_sheet_et);
            kotlin.g.b.k.a((Object) textInputEditText, "rootView.native_otp_sheet_et");
            CharSequence text = textInputEditText.getText();
            b.a(bVar, z, !(text == null || text.length() == 0), true);
            if (z) {
                ((RelativeLayout) b.e(this.f56975a).findViewById(R.id.native_otp_sheet_et_container)).setBackgroundResource(R.drawable.blue_rounded_border);
                ((TextInputEditText) b.e(this.f56975a).findViewById(R.id.native_otp_sheet_et)).requestFocus();
                FragmentActivity activity = this.f56975a.getActivity();
                Object systemService = activity != null ? activity.getSystemService("input_method") : null;
                if (systemService != null) {
                    ((InputMethodManager) systemService).showSoftInput((TextInputEditText) b.e(this.f56975a).findViewById(R.id.native_otp_sheet_et), 1);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
            ((RelativeLayout) b.e(this.f56975a).findViewById(R.id.native_otp_sheet_et_container)).setBackgroundResource(R.drawable.gray_rounded_border);
        }
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56976a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(b bVar) {
            this.f56976a = bVar;
        }

        public final void afterTextChanged(Editable editable) {
            if (editable != null && editable.length() == 4 && ' ' == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable != null && editable.length() == 4 && Character.isDigit(editable.charAt(editable.length() - 1))) {
                InputFilter[] filters = editable.getFilters();
                editable.setFilters(new InputFilter[0]);
                editable.insert(editable.length() - 1, " ");
                editable.setFilters(filters);
            }
            if (this.f56976a.f56965d) {
                this.f56976a.f56965d = false;
                ((RelativeLayout) b.e(this.f56976a).findViewById(R.id.native_otp_sheet_et_container)).setBackgroundResource(R.drawable.blue_rounded_border);
                TextInputLayout textInputLayout = (TextInputLayout) b.e(this.f56976a).findViewById(R.id.text_input_layout);
                kotlin.g.b.k.a((Object) textInputLayout, "rootView.text_input_layout");
                textInputLayout.setError((CharSequence) null);
                TextInputLayout textInputLayout2 = (TextInputLayout) b.e(this.f56976a).findViewById(R.id.text_input_layout);
                kotlin.g.b.k.a((Object) textInputLayout2, "rootView.text_input_layout");
                textInputLayout2.setHint(this.f56976a.getString(R.string.enter_otp));
            }
        }
    }

    public static final class i implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56977a;

        i(b bVar) {
            this.f56977a = bVar;
        }

        public final boolean onPreDraw() {
            TextInputLayout textInputLayout = (TextInputLayout) b.e(this.f56977a).findViewById(R.id.text_input_layout);
            kotlin.g.b.k.a((Object) textInputLayout, "rootView.text_input_layout");
            if (textInputLayout.getHeight() <= 0) {
                return true;
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) b.e(this.f56977a).findViewById(R.id.text_input_layout);
            kotlin.g.b.k.a((Object) textInputLayout2, "rootView.text_input_layout");
            textInputLayout2.getViewTreeObserver().removeOnPreDrawListener(this);
            b bVar = this.f56977a;
            boolean hasFocus = ((TextInputEditText) b.e(bVar).findViewById(R.id.native_otp_sheet_et)).hasFocus();
            TextInputEditText textInputEditText = (TextInputEditText) b.e(this.f56977a).findViewById(R.id.native_otp_sheet_et);
            kotlin.g.b.k.a((Object) textInputEditText, "rootView.native_otp_sheet_et");
            CharSequence text = textInputEditText.getText();
            b.a(bVar, hasFocus, true ^ (text == null || text.length() == 0), false);
            return false;
        }
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f56979a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f56980b;

        k(String str, b bVar) {
            this.f56979a = str;
            this.f56980b = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r0 = (r0 = r0.getDisplayField()).getPageExpiryTime();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r4 = this;
                net.one97.paytm.p2mNewDesign.entity.BankForm r0 = net.one97.paytm.p2mNewDesign.nativeOTP.b.f56962h
                if (r0 == 0) goto L_0x0022
                net.one97.paytm.p2mNewDesign.entity.DisplayField r0 = r0.getDisplayField()
                if (r0 == 0) goto L_0x0022
                java.lang.String r0 = r0.getPageExpiryTime()
                if (r0 == 0) goto L_0x0022
                long r0 = java.lang.Long.parseLong(r0)
                java.lang.String r2 = r4.f56979a
                long r2 = java.lang.Long.parseLong(r2)
                long r0 = r0 - r2
                java.lang.Long r0 = java.lang.Long.valueOf(r0)
                goto L_0x0023
            L_0x0022:
                r0 = 0
            L_0x0023:
                if (r0 == 0) goto L_0x0047
                r1 = r0
                java.lang.Number r1 = (java.lang.Number) r1
                r1.longValue()
                long r0 = r0.longValue()
                r2 = 1000(0x3e8, double:4.94E-321)
                long r0 = r0 / r2
                java.lang.Long r0 = java.lang.Long.valueOf(r0)
                net.one97.paytm.p2mNewDesign.nativeOTP.b r1 = r4.f56980b
                net.one97.paytm.p2mNewDesign.nativeOTP.e r1 = net.one97.paytm.p2mNewDesign.nativeOTP.b.g(r1)
                long r2 = r0.longValue()
                java.lang.String r0 = java.lang.String.valueOf(r2)
                r1.a(r0)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.nativeOTP.b.k.run():void");
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56983a;

        m(b bVar) {
            this.f56983a = bVar;
        }

        public final void run() {
            View findViewById = b.e(this.f56983a).findViewById(R.id.lyt_pay_on_bank);
            kotlin.g.b.k.a((Object) findViewById, "rootView.lyt_pay_on_bank");
            findViewById.setVisibility(0);
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        kotlin.g.b.k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            View view = this.f56966e;
            if (view == null) {
                kotlin.g.b.k.a("rootView");
            }
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.native_otp_sheet_et);
            kotlin.g.b.k.a((Object) textInputEditText, "rootView.native_otp_sheet_et");
            inputMethodManager.hideSoftInputFromWindow(textInputEditText.getWindowToken(), 1);
            CountDownTimer countDownTimer = this.f56964c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CountDownTimer countDownTimer2 = this.f56963b;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    /* renamed from: net.one97.paytm.p2mNewDesign.nativeOTP.b$b  reason: collision with other inner class name */
    static final class C1061b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56970a;

        C1061b(b bVar) {
            this.f56970a = bVar;
        }

        public final void onClick(View view) {
            b.c(this.f56970a);
        }
    }

    public static final class l extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f56981a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f56982b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(long j, long j2, b bVar) {
            super(j2, 1000);
            this.f56981a = j;
            this.f56982b = bVar;
        }

        public final void onTick(long j) {
            if (this.f56982b.getActivity() != null) {
                long j2 = j / 1000;
                b bVar = this.f56982b;
                aa aaVar = aa.f47921a;
                String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j2 / 60)}, 1));
                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                aa aaVar2 = aa.f47921a;
                String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j2 % 60)}, 1));
                kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                b.a(bVar, format, format2);
            }
        }

        public final void onFinish() {
            FragmentActivity activity = this.f56982b.getActivity();
            if (activity != null) {
                kotlin.g.b.k.a((Object) activity, "it");
                if (!activity.isFinishing()) {
                    b.g(this.f56982b).b();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        r0 = (r0 = r0.getDisplayField()).getResendOtpEnableTime();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r7 = this;
            android.view.View r0 = r7.f56966e
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "rootView"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            int r1 = net.one97.paytm.wallet.R.id.native_otp_sheet_resend_otp
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = "rootView.native_otp_sheet_resend_otp"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 8
            r0.setVisibility(r1)
            net.one97.paytm.p2mNewDesign.entity.BankForm r0 = f56962h
            if (r0 == 0) goto L_0x0030
            net.one97.paytm.p2mNewDesign.entity.DisplayField r0 = r0.getDisplayField()
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r0.getResendOtpEnableTime()
            if (r0 == 0) goto L_0x0030
            java.lang.Long r0 = kotlin.m.p.d(r0)
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 == 0) goto L_0x0047
            java.lang.Number r0 = (java.lang.Number) r0
            long r4 = r0.longValue()
            net.one97.paytm.p2mNewDesign.nativeOTP.b$n r0 = new net.one97.paytm.p2mNewDesign.nativeOTP.b$n
            r1 = r0
            r2 = r4
            r6 = r7
            r1.<init>(r2, r4, r6)
            android.os.CountDownTimer r0 = r0.start()
            r7.f56964c = r0
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.nativeOTP.b.b():void");
    }

    public static final class n extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f56984a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f56985b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(long j, long j2, b bVar) {
            super(j2, 1000);
            this.f56984a = j;
            this.f56985b = bVar;
        }

        public final void onTick(long j) {
            FragmentActivity activity = this.f56985b.getActivity();
            if (activity != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) b.e(this.f56985b).findViewById(R.id.native_otp_sheet_resend_otp_timer);
                kotlin.g.b.k.a((Object) appCompatTextView, "rootView.native_otp_sheet_resend_otp_timer");
                aa aaVar = aa.f47921a;
                String string = activity.getString(R.string.native_resend_otp_timer_text);
                kotlin.g.b.k.a((Object) string, "it.getString(R.string.na…ve_resend_otp_timer_text)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(j / 1000)}, 1));
                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                appCompatTextView.setText(format);
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) b.e(this.f56985b).findViewById(R.id.native_otp_sheet_resend_otp_timer);
                kotlin.g.b.k.a((Object) appCompatTextView2, "rootView.native_otp_sheet_resend_otp_timer");
                appCompatTextView2.setVisibility(0);
            }
        }

        public final void onFinish() {
            AppCompatTextView appCompatTextView = (AppCompatTextView) b.e(this.f56985b).findViewById(R.id.native_otp_sheet_resend_otp_timer);
            kotlin.g.b.k.a((Object) appCompatTextView, "rootView.native_otp_sheet_resend_otp_timer");
            appCompatTextView.setVisibility(8);
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) b.e(this.f56985b).findViewById(R.id.native_otp_sheet_resend_otp);
            kotlin.g.b.k.a((Object) appCompatTextView2, "rootView.native_otp_sheet_resend_otp");
            appCompatTextView2.setVisibility(0);
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        ArrayList<DirectForm> directForms;
        if (bVar.f56965d) {
            bVar.f56965d = false;
            View view = bVar.f56966e;
            if (view == null) {
                kotlin.g.b.k.a("rootView");
            }
            ((RelativeLayout) view.findViewById(R.id.native_otp_sheet_et_container)).setBackgroundResource(R.drawable.blue_rounded_border);
            View view2 = bVar.f56966e;
            if (view2 == null) {
                kotlin.g.b.k.a("rootView");
            }
            TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(R.id.text_input_layout);
            kotlin.g.b.k.a((Object) textInputLayout, "rootView.text_input_layout");
            textInputLayout.setError((CharSequence) null);
            View view3 = bVar.f56966e;
            if (view3 == null) {
                kotlin.g.b.k.a("rootView");
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) view3.findViewById(R.id.text_input_layout);
            kotlin.g.b.k.a((Object) textInputLayout2, "rootView.text_input_layout");
            textInputLayout2.setHint(bVar.getString(R.string.enter_otp));
        }
        if (com.paytm.utility.b.c(bVar.getContext())) {
            View view4 = bVar.f56966e;
            if (view4 == null) {
                kotlin.g.b.k.a("rootView");
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) view4.findViewById(R.id.native_otp_sheet_resend_otp);
            kotlin.g.b.k.a((Object) appCompatTextView, "rootView.native_otp_sheet_resend_otp");
            appCompatTextView.setVisibility(8);
            View view5 = bVar.f56966e;
            if (view5 == null) {
                kotlin.g.b.k.a("rootView");
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view5.findViewById(R.id.native_otp_sheet_resend_otp_timer);
            kotlin.g.b.k.a((Object) appCompatTextView2, "rootView.native_otp_sheet_resend_otp_timer");
            appCompatTextView2.setVisibility(8);
            View view6 = bVar.f56966e;
            if (view6 == null) {
                kotlin.g.b.k.a("rootView");
            }
            DotProgressBar dotProgressBar = (DotProgressBar) view6.findViewById(R.id.resend_progress_bar);
            if (dotProgressBar != null) {
                dotProgressBar.setXCoordinateChange(true);
                dotProgressBar.setVisibility(0);
            }
            BankForm bankForm = f56962h;
            if (bankForm != null && (directForms = bankForm.getDirectForms()) != null) {
                for (DirectForm directForm : directForms) {
                    kotlin.g.b.k.a((Object) directForm, "it");
                    if (kotlin.g.b.k.a((Object) directForm.getType(), (Object) DirectFormItemType.RESEND)) {
                        if (bVar.f56968g == null) {
                            kotlin.g.b.k.a("nativeOTPViewModel");
                        }
                        FragmentActivity activity = bVar.getActivity();
                        if (activity == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity, "activity!!");
                        String actionUrl = directForm.getActionUrl();
                        kotlin.g.b.k.a((Object) actionUrl, "it.actionUrl");
                        String method = directForm.getMethod();
                        kotlin.g.b.k.a((Object) method, "it.method");
                        HashMap<String, String> headers = directForm.getHeaders();
                        kotlin.g.b.k.a((Object) headers, "it.headers");
                        HashMap<String, String> content = directForm.getContent();
                        kotlin.g.b.k.a((Object) content, "it.content");
                        LiveData<net.one97.paytm.network.f> a2 = c.a(activity, actionUrl, method, headers, content);
                        if (a2 != null) {
                            a2.observeForever(new j(bVar));
                        }
                    }
                }
                return;
            }
            return;
        }
        e eVar = bVar.f56967f;
        if (eVar == null) {
            kotlin.g.b.k.a("listener");
        }
        eVar.f();
    }

    public static final /* synthetic */ void b(b bVar) {
        ArrayList<DirectForm> directForms;
        View view = bVar.f56966e;
        if (view == null) {
            kotlin.g.b.k.a("rootView");
        }
        if (((TextInputEditText) view.findViewById(R.id.native_otp_sheet_et)).length() < 7) {
            bVar.f56965d = true;
            View view2 = bVar.f56966e;
            if (view2 == null) {
                kotlin.g.b.k.a("rootView");
            }
            ((RelativeLayout) view2.findViewById(R.id.native_otp_sheet_et_container)).setBackgroundResource(R.drawable.round_corner_red_shape);
        } else if (com.paytm.utility.b.c(bVar.getContext())) {
            View view3 = bVar.f56966e;
            if (view3 == null) {
                kotlin.g.b.k.a("rootView");
            }
            ((AppCompatImageView) view3.findViewById(R.id.native_otp_sheet_close)).setOnClickListener((View.OnClickListener) null);
            View view4 = bVar.f56966e;
            if (view4 == null) {
                kotlin.g.b.k.a("rootView");
            }
            LinearLayout linearLayout = (LinearLayout) view4.findViewById(R.id.native_otp_sheet_submit_button);
            kotlin.g.b.k.a((Object) linearLayout, "rootView.native_otp_sheet_submit_button");
            linearLayout.setEnabled(false);
            View view5 = bVar.f56966e;
            if (view5 == null) {
                kotlin.g.b.k.a("rootView");
            }
            TextView textView = (TextView) view5.findViewById(R.id.button_text_submit);
            kotlin.g.b.k.a((Object) textView, "rootView.button_text_submit");
            textView.setVisibility(8);
            View view6 = bVar.f56966e;
            if (view6 == null) {
                kotlin.g.b.k.a("rootView");
            }
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) view6.findViewById(R.id.submit_button_loader));
            bVar.getResources();
            View view7 = bVar.f56966e;
            if (view7 == null) {
                kotlin.g.b.k.a("rootView");
            }
            ((LinearLayout) view7.findViewById(R.id.native_otp_sheet_submit_button)).setBackgroundColor(bVar.getResources().getColor(R.color.grid_offer_blue));
            BankForm bankForm = f56962h;
            if (bankForm != null && (directForms = bankForm.getDirectForms()) != null) {
                for (DirectForm directForm : directForms) {
                    kotlin.g.b.k.a((Object) directForm, "it");
                    if (kotlin.g.b.k.a((Object) directForm.getType(), (Object) DirectFormItemType.SUBMIT)) {
                        HashMap<String, String> content = directForm.getContent();
                        kotlin.g.b.k.a((Object) content, "body");
                        Map map = content;
                        View view8 = bVar.f56966e;
                        if (view8 == null) {
                            kotlin.g.b.k.a("rootView");
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) view8.findViewById(R.id.native_otp_sheet_et);
                        kotlin.g.b.k.a((Object) textInputEditText, "rootView.native_otp_sheet_et");
                        map.put("otp", p.a(String.valueOf(textInputEditText.getText()), " ", "", false));
                        if (bVar.f56968g == null) {
                            kotlin.g.b.k.a("nativeOTPViewModel");
                        }
                        FragmentActivity activity = bVar.getActivity();
                        if (activity == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity, "activity!!");
                        String actionUrl = directForm.getActionUrl();
                        kotlin.g.b.k.a((Object) actionUrl, "it.actionUrl");
                        String method = directForm.getMethod();
                        kotlin.g.b.k.a((Object) method, "it.method");
                        HashMap<String, String> headers = directForm.getHeaders();
                        kotlin.g.b.k.a((Object) headers, "it.headers");
                        LiveData<net.one97.paytm.network.f> a2 = c.a(activity, actionUrl, method, headers, content);
                        if (a2 != null) {
                            a2.observeForever(new o(bVar));
                        }
                    }
                }
            }
        } else {
            e eVar = bVar.f56967f;
            if (eVar == null) {
                kotlin.g.b.k.a("listener");
            }
            eVar.f();
        }
    }

    public static final /* synthetic */ void c(b bVar) {
        e eVar = bVar.f56967f;
        if (eVar == null) {
            kotlin.g.b.k.a("listener");
        }
        eVar.b();
    }

    public static final /* synthetic */ void d(b bVar) {
        e eVar = bVar.f56967f;
        if (eVar == null) {
            kotlin.g.b.k.a("listener");
        }
        eVar.a();
    }

    public static final /* synthetic */ void a(b bVar, boolean z, boolean z2, boolean z3) {
        int id;
        TextInputLayout textInputLayout;
        if (z3) {
            View view = bVar.f56966e;
            if (view == null) {
                kotlin.g.b.k.a("rootView");
            }
            v.a((ViewGroup) (TextInputLayout) view.findViewById(R.id.text_input_layout));
        }
        if (z || z2) {
            View view2 = bVar.f56966e;
            if (view2 == null) {
                kotlin.g.b.k.a("rootView");
            }
            ((TextInputEditText) view2.findViewById(R.id.native_otp_sheet_et)).setPadding(0, 0, 0, 0);
            return;
        }
        View view3 = bVar.f56966e;
        if (view3 == null) {
            kotlin.g.b.k.a("rootView");
        }
        TextInputEditText textInputEditText = (TextInputEditText) view3.findViewById(R.id.native_otp_sheet_et);
        View view4 = bVar.f56966e;
        if (view4 == null) {
            kotlin.g.b.k.a("rootView");
        }
        TextInputEditText textInputEditText2 = (TextInputEditText) view4.findViewById(R.id.native_otp_sheet_et);
        kotlin.g.b.k.a((Object) textInputEditText2, "rootView.native_otp_sheet_et");
        View view5 = textInputEditText2;
        int i2 = 0;
        do {
            i2 += view5.getTop();
            ViewParent parent = view5.getParent();
            if (parent != null) {
                view5 = (View) parent;
                id = view5.getId();
                View view6 = bVar.f56966e;
                if (view6 == null) {
                    kotlin.g.b.k.a("rootView");
                }
                textInputLayout = (TextInputLayout) view6.findViewById(R.id.text_input_layout);
                kotlin.g.b.k.a((Object) textInputLayout, "rootView.text_input_layout");
            } else {
                throw new u("null cannot be cast to non-null type android.view.View");
            }
        } while (id != textInputLayout.getId());
        textInputEditText.setPadding(0, 0, 0, i2);
    }

    public static final /* synthetic */ void h(b bVar) {
        View view = bVar.f56966e;
        if (view == null) {
            kotlin.g.b.k.a("rootView");
        }
        ((AppCompatImageView) view.findViewById(R.id.native_otp_sheet_close)).setOnClickListener(new C1061b(bVar));
        View view2 = bVar.f56966e;
        if (view2 == null) {
            kotlin.g.b.k.a("rootView");
        }
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.native_otp_sheet_submit_button);
        kotlin.g.b.k.a((Object) linearLayout, "rootView.native_otp_sheet_submit_button");
        linearLayout.setEnabled(true);
        View view3 = bVar.f56966e;
        if (view3 == null) {
            kotlin.g.b.k.a("rootView");
        }
        TextView textView = (TextView) view3.findViewById(R.id.button_text_submit);
        kotlin.g.b.k.a((Object) textView, "rootView.button_text_submit");
        textView.setVisibility(0);
        View view4 = bVar.f56966e;
        if (view4 == null) {
            kotlin.g.b.k.a("rootView");
        }
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) view4.findViewById(R.id.submit_button_loader));
        Resources resources = bVar.getResources();
        View view5 = bVar.f56966e;
        if (view5 == null) {
            kotlin.g.b.k.a("rootView");
        }
        LinearLayout linearLayout2 = (LinearLayout) view5.findViewById(R.id.native_otp_sheet_submit_button);
        kotlin.g.b.k.a((Object) linearLayout2, "rootView.native_otp_sheet_submit_button");
        linearLayout2.setBackground(resources.getDrawable(R.drawable.pay_button_rounded_corners));
    }

    public static final /* synthetic */ void i(b bVar) {
        View view = bVar.f56966e;
        if (view == null) {
            kotlin.g.b.k.a("rootView");
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.native_otp_sheet_resend_otp_timer);
        kotlin.g.b.k.a((Object) appCompatTextView, "rootView.native_otp_sheet_resend_otp_timer");
        appCompatTextView.setVisibility(0);
        View view2 = bVar.f56966e;
        if (view2 == null) {
            kotlin.g.b.k.a("rootView");
        }
        DotProgressBar dotProgressBar = (DotProgressBar) view2.findViewById(R.id.resend_progress_bar);
        if (dotProgressBar != null) {
            dotProgressBar.setXCoordinateChange(true);
            dotProgressBar.setVisibility(8);
        }
    }

    public static final /* synthetic */ void a(b bVar, String str, String str2) {
        CharSequence charSequence = bVar.getString(R.string.native_page_expiry_timer_text) + str + " " + bVar.getString(R.string.native_otp_min) + " : " + str2 + " " + bVar.getString(R.string.native_otp_sec);
        SpannableString spannableString = new SpannableString(charSequence);
        int a2 = p.a(charSequence, str, 0, false, 6);
        int length = str.length() + a2;
        spannableString.setSpan(new ForegroundColorSpan(bVar.getResources().getColor(R.color.color_506d85)), a2, length, 33);
        spannableString.setSpan(new StyleSpan(1), a2, length, 33);
        int a3 = p.a(charSequence, str2, a2 + str.length(), false, 4);
        int length2 = str2.length() + a3;
        spannableString.setSpan(new ForegroundColorSpan(bVar.getResources().getColor(R.color.color_506d85)), a3, length2, 33);
        spannableString.setSpan(new StyleSpan(1), a3, length2, 33);
        View view = bVar.f56966e;
        if (view == null) {
            kotlin.g.b.k.a("rootView");
        }
        ((AppCompatTextView) view.findViewById(R.id.native_otp_sheet_page_expiry_timer)).setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56969i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
