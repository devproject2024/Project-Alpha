package net.one97.paytm.p2mNewDesign.nativeOTP;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.entity.BankForm;
import net.one97.paytm.p2mNewDesign.entity.DirectForm;
import net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsBody;
import net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResponse;
import net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResultInfo;
import net.one97.paytm.p2mNewDesign.nativeOTP.AJRNativeOTPActivity;
import net.one97.paytm.wallet.R;

public final class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final b f56951a = new b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static BankForm f56952f;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public e f56953b;

    /* renamed from: c  reason: collision with root package name */
    private View f56954c;

    /* renamed from: d  reason: collision with root package name */
    private c f56955d;

    /* renamed from: e  reason: collision with root package name */
    private C1060a f56956e = C1060a.GO_TO_BANK;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56957g;

    /* renamed from: net.one97.paytm.p2mNewDesign.nativeOTP.a$a  reason: collision with other inner class name */
    public enum C1060a {
        GO_TO_BANK,
        WAIT_FOR_OTP,
        USE_ANOTHER_PAY_MODE,
        CANCEL_PAYMENT
    }

    static final class c<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f56958a;

        c(a aVar) {
            this.f56958a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            if (fVar.f55796a == h.SUCCESS) {
                a.b(this.f56958a);
                IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                if (iJRPaytmDataModel != null) {
                    DirectFormsResponse directFormsResponse = (DirectFormsResponse) iJRPaytmDataModel;
                    DirectFormsBody body = directFormsResponse.getBody();
                    k.a((Object) body, "response.body");
                    DirectFormsResultInfo resultInfo = body.getResultInfo();
                    k.a((Object) resultInfo, "it");
                    if (k.a((Object) resultInfo.getResultStatus(), (Object) "S")) {
                        e a2 = this.f56958a.f56953b;
                        if (a2 != null) {
                            AJRNativeOTPActivity.a aVar = AJRNativeOTPActivity.a.CANCEL;
                            DirectFormsBody body2 = directFormsResponse.getBody();
                            k.a((Object) body2, "response.body");
                            a2.a(aVar, body2.getTxnInfo());
                            return;
                        }
                        return;
                    }
                    e a3 = this.f56958a.f56953b;
                    if (a3 != null) {
                        AJRNativeOTPActivity.a aVar2 = AJRNativeOTPActivity.a.CANCEL;
                        DirectFormsBody body3 = directFormsResponse.getBody();
                        k.a((Object) body3, "response.body");
                        DirectFormsResultInfo resultInfo2 = body3.getResultInfo();
                        k.a((Object) resultInfo2, "response.body.resultInfo");
                        String resultMsg = resultInfo2.getResultMsg();
                        k.a((Object) resultMsg, "response.body.resultInfo.resultMsg");
                        a3.a(aVar2, resultMsg);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResponse");
            } else if (fVar.f55796a == h.ERROR) {
                a.b(this.f56958a);
                e a4 = this.f56958a.f56953b;
                if (a4 != null) {
                    a4.a(AJRNativeOTPActivity.a.SUBMIT, "Something went wrong!");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        r5 = r5.getDisplayField();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r3, android.view.ViewGroup r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r5 = "inflater"
            kotlin.g.b.k.c(r3, r5)
            int r5 = net.one97.paytm.wallet.R.layout.offline_native_otp_cancel_payment_bottomsheet
            r0 = 0
            android.view.View r3 = r3.inflate(r5, r4, r0)
            java.lang.String r4 = "inflater.inflate(R.layou…msheet, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r2.f56954c = r3
            android.view.View r3 = r2.f56954c
            java.lang.String r4 = "rootView"
            if (r3 != 0) goto L_0x001c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x001c:
            int r5 = net.one97.paytm.wallet.R.id.go_to_bank_tv
            android.view.View r3 = r3.findViewById(r5)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r5 = "rootView.go_to_bank_tv"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.BankForm r5 = f56952f
            if (r5 == 0) goto L_0x0038
            net.one97.paytm.p2mNewDesign.entity.DisplayField r5 = r5.getDisplayField()
            if (r5 == 0) goto L_0x0038
            java.lang.String r5 = r5.getPayOnBankMessage()
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
            android.view.View r3 = r2.f56954c
            if (r3 != 0) goto L_0x0045
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0045:
            int r5 = net.one97.paytm.wallet.R.id.option_go_to_bank
            android.view.View r3 = r3.findViewById(r5)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r5 = r2
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r3.setOnClickListener(r5)
            android.view.View r3 = r2.f56954c
            if (r3 != 0) goto L_0x005a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x005a:
            int r0 = net.one97.paytm.wallet.R.id.option_wait_for_otp
            android.view.View r3 = r3.findViewById(r0)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.setOnClickListener(r5)
            android.view.View r3 = r2.f56954c
            if (r3 != 0) goto L_0x006c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x006c:
            int r0 = net.one97.paytm.wallet.R.id.option_use_another_option
            android.view.View r3 = r3.findViewById(r0)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.setOnClickListener(r5)
            android.view.View r3 = r2.f56954c
            if (r3 != 0) goto L_0x007e
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x007e:
            int r5 = net.one97.paytm.wallet.R.id.go_to_bank_button
            android.view.View r3 = r3.findViewById(r5)
            androidx.appcompat.widget.AppCompatButton r3 = (androidx.appcompat.widget.AppCompatButton) r3
            net.one97.paytm.p2mNewDesign.nativeOTP.a$d r5 = new net.one97.paytm.p2mNewDesign.nativeOTP.a$d
            r5.<init>(r2)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r3.setOnClickListener(r5)
            android.view.View r3 = r2.f56954c
            if (r3 != 0) goto L_0x0097
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0097:
            int r5 = net.one97.paytm.wallet.R.id.lyt_go_back
            android.view.View r3 = r3.findViewById(r5)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            net.one97.paytm.p2mNewDesign.nativeOTP.a$e r5 = new net.one97.paytm.p2mNewDesign.nativeOTP.a$e
            r5.<init>(r2)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r3.setOnClickListener(r5)
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x00db
            java.lang.String r5 = "it"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            android.app.Application r3 = r3.getApplication()
            java.lang.String r5 = "it.application"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            androidx.lifecycle.al r5 = new androidx.lifecycle.al
            r0 = r2
            androidx.lifecycle.ao r0 = (androidx.lifecycle.ao) r0
            net.one97.paytm.p2mNewDesign.nativeOTP.d r1 = new net.one97.paytm.p2mNewDesign.nativeOTP.d
            r1.<init>(r3)
            androidx.lifecycle.al$b r1 = (androidx.lifecycle.al.b) r1
            r5.<init>((androidx.lifecycle.ao) r0, (androidx.lifecycle.al.b) r1)
            java.lang.Class<net.one97.paytm.p2mNewDesign.nativeOTP.c> r3 = net.one97.paytm.p2mNewDesign.nativeOTP.c.class
            androidx.lifecycle.ai r3 = r5.a(r3)
            java.lang.String r5 = "ViewModelProvider(this, …OTPViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.nativeOTP.c r3 = (net.one97.paytm.p2mNewDesign.nativeOTP.c) r3
            r2.f56955d = r3
        L_0x00db:
            android.view.View r3 = r2.f56954c
            if (r3 != 0) goto L_0x00e2
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00e2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.nativeOTP.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
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

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f56959a;

        d(a aVar) {
            this.f56959a = aVar;
        }

        public final void onClick(View view) {
            e a2 = this.f56959a.f56953b;
            if (a2 != null) {
                a2.c();
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f56960a;

        e(a aVar) {
            this.f56960a = aVar;
        }

        public final void onClick(View view) {
            this.f56960a.dismissAllowingStateLoss();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof e) {
            this.f56953b = (e) context;
        }
    }

    public final void onDetach() {
        super.onDetach();
        this.f56953b = null;
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.option_go_to_bank;
        if (valueOf != null && valueOf.intValue() == i2) {
            a(C1060a.GO_TO_BANK);
            return;
        }
        int i3 = R.id.option_wait_for_otp;
        if (valueOf != null && valueOf.intValue() == i3) {
            a(C1060a.WAIT_FOR_OTP);
            return;
        }
        int i4 = R.id.option_use_another_option;
        if (valueOf != null && valueOf.intValue() == i4) {
            a(C1060a.USE_ANOTHER_PAY_MODE);
        }
    }

    private final void a(C1060a aVar) {
        if (aVar == C1060a.GO_TO_BANK) {
            this.f56956e = C1060a.GO_TO_BANK;
            View view = this.f56954c;
            if (view == null) {
                k.a("rootView");
            }
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.radio_button_go_to_bank);
            k.a((Object) radioButton, "rootView.radio_button_go_to_bank");
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            radioButton.setButtonDrawable(androidx.core.content.b.a(context, R.drawable.ic_radio_active));
            View view2 = this.f56954c;
            if (view2 == null) {
                k.a("rootView");
            }
            RadioButton radioButton2 = (RadioButton) view2.findViewById(R.id.radio_button_wait_for_otp);
            k.a((Object) radioButton2, "rootView.radio_button_wait_for_otp");
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            radioButton2.setButtonDrawable(androidx.core.content.b.a(context2, R.drawable.ic_radio_inactive));
            View view3 = this.f56954c;
            if (view3 == null) {
                k.a("rootView");
            }
            RadioButton radioButton3 = (RadioButton) view3.findViewById(R.id.radio_button_use_another_option);
            k.a((Object) radioButton3, "rootView.radio_button_use_another_option");
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            radioButton3.setButtonDrawable(androidx.core.content.b.a(context3, R.drawable.ic_radio_inactive));
        } else if (aVar == C1060a.WAIT_FOR_OTP) {
            this.f56956e = C1060a.WAIT_FOR_OTP;
            View view4 = this.f56954c;
            if (view4 == null) {
                k.a("rootView");
            }
            RadioButton radioButton4 = (RadioButton) view4.findViewById(R.id.radio_button_wait_for_otp);
            k.a((Object) radioButton4, "rootView.radio_button_wait_for_otp");
            Context context4 = getContext();
            if (context4 == null) {
                k.a();
            }
            radioButton4.setButtonDrawable(androidx.core.content.b.a(context4, R.drawable.ic_radio_active));
            View view5 = this.f56954c;
            if (view5 == null) {
                k.a("rootView");
            }
            RadioButton radioButton5 = (RadioButton) view5.findViewById(R.id.radio_button_go_to_bank);
            k.a((Object) radioButton5, "rootView.radio_button_go_to_bank");
            Context context5 = getContext();
            if (context5 == null) {
                k.a();
            }
            radioButton5.setButtonDrawable(androidx.core.content.b.a(context5, R.drawable.ic_radio_inactive));
            View view6 = this.f56954c;
            if (view6 == null) {
                k.a("rootView");
            }
            RadioButton radioButton6 = (RadioButton) view6.findViewById(R.id.radio_button_use_another_option);
            k.a((Object) radioButton6, "rootView.radio_button_use_another_option");
            Context context6 = getContext();
            if (context6 == null) {
                k.a();
            }
            radioButton6.setButtonDrawable(androidx.core.content.b.a(context6, R.drawable.ic_radio_inactive));
            dismissAllowingStateLoss();
        } else if (aVar == C1060a.USE_ANOTHER_PAY_MODE) {
            this.f56956e = C1060a.USE_ANOTHER_PAY_MODE;
            View view7 = this.f56954c;
            if (view7 == null) {
                k.a("rootView");
            }
            RadioButton radioButton7 = (RadioButton) view7.findViewById(R.id.radio_button_use_another_option);
            k.a((Object) radioButton7, "rootView.radio_button_use_another_option");
            Context context7 = getContext();
            if (context7 == null) {
                k.a();
            }
            radioButton7.setButtonDrawable(androidx.core.content.b.a(context7, R.drawable.ic_radio_active));
            View view8 = this.f56954c;
            if (view8 == null) {
                k.a("rootView");
            }
            RadioButton radioButton8 = (RadioButton) view8.findViewById(R.id.radio_button_go_to_bank);
            k.a((Object) radioButton8, "rootView.radio_button_go_to_bank");
            Context context8 = getContext();
            if (context8 == null) {
                k.a();
            }
            radioButton8.setButtonDrawable(androidx.core.content.b.a(context8, R.drawable.ic_radio_inactive));
            View view9 = this.f56954c;
            if (view9 == null) {
                k.a("rootView");
            }
            RadioButton radioButton9 = (RadioButton) view9.findViewById(R.id.radio_button_wait_for_otp);
            k.a((Object) radioButton9, "rootView.radio_button_wait_for_otp");
            Context context9 = getContext();
            if (context9 == null) {
                k.a();
            }
            radioButton9.setButtonDrawable(androidx.core.content.b.a(context9, R.drawable.ic_radio_inactive));
            e eVar = this.f56953b;
            if (eVar != null) {
                eVar.b();
            }
            dismissAllowingStateLoss();
        } else if (aVar == C1060a.CANCEL_PAYMENT) {
            this.f56956e = C1060a.CANCEL_PAYMENT;
            View view10 = this.f56954c;
            if (view10 == null) {
                k.a("rootView");
            }
            RadioButton radioButton10 = (RadioButton) view10.findViewById(R.id.radio_button_go_to_bank);
            k.a((Object) radioButton10, "rootView.radio_button_go_to_bank");
            Context context10 = getContext();
            if (context10 == null) {
                k.a();
            }
            radioButton10.setButtonDrawable(androidx.core.content.b.a(context10, R.drawable.ic_radio_inactive));
            View view11 = this.f56954c;
            if (view11 == null) {
                k.a("rootView");
            }
            RadioButton radioButton11 = (RadioButton) view11.findViewById(R.id.radio_button_wait_for_otp);
            k.a((Object) radioButton11, "rootView.radio_button_wait_for_otp");
            Context context11 = getContext();
            if (context11 == null) {
                k.a();
            }
            radioButton11.setButtonDrawable(androidx.core.content.b.a(context11, R.drawable.ic_radio_inactive));
            View view12 = this.f56954c;
            if (view12 == null) {
                k.a("rootView");
            }
            RadioButton radioButton12 = (RadioButton) view12.findViewById(R.id.radio_button_use_another_option);
            k.a((Object) radioButton12, "rootView.radio_button_use_another_option");
            Context context12 = getContext();
            if (context12 == null) {
                k.a();
            }
            radioButton12.setButtonDrawable(androidx.core.content.b.a(context12, R.drawable.ic_radio_inactive));
            a();
        }
    }

    private final void a() {
        ArrayList<DirectForm> directForms;
        if (com.paytm.utility.b.c(getContext())) {
            b();
            BankForm bankForm = f56952f;
            if (bankForm != null && (directForms = bankForm.getDirectForms()) != null) {
                for (DirectForm directForm : directForms) {
                    k.a((Object) directForm, "it");
                    if (k.a((Object) directForm.getType(), (Object) DirectFormItemType.CANCEL)) {
                        if (this.f56955d == null) {
                            k.a("nativeOTPViewModel");
                        }
                        FragmentActivity activity = getActivity();
                        if (activity == null) {
                            k.a();
                        }
                        k.a((Object) activity, "activity!!");
                        String actionUrl = directForm.getActionUrl();
                        k.a((Object) actionUrl, "it.actionUrl");
                        String method = directForm.getMethod();
                        k.a((Object) method, "it.method");
                        HashMap<String, String> headers = directForm.getHeaders();
                        k.a((Object) headers, "it.headers");
                        HashMap<String, String> content = directForm.getContent();
                        k.a((Object) content, "it.content");
                        LiveData<net.one97.paytm.network.f> a2 = c.a(activity, actionUrl, method, headers, content);
                        if (a2 != null) {
                            a2.observeForever(new c(this));
                        }
                    }
                }
                return;
            }
            return;
        }
        e eVar = this.f56953b;
        if (eVar != null) {
            eVar.f();
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        e eVar = this.f56953b;
        if (eVar != null) {
            eVar.d();
        }
    }

    private final void b() {
        View view = this.f56954c;
        if (view == null) {
            k.a("rootView");
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lyt_go_back);
        k.a((Object) linearLayout, "rootView.lyt_go_back");
        linearLayout.setVisibility(4);
        View view2 = this.f56954c;
        if (view2 == null) {
            k.a("rootView");
        }
        View findViewById = view2.findViewById(R.id.lyt_divider);
        k.a((Object) findViewById, "rootView.lyt_divider");
        findViewById.setVisibility(4);
        View view3 = this.f56954c;
        if (view3 == null) {
            k.a("rootView");
        }
        TextView textView = (TextView) view3.findViewById(R.id.main_header);
        k.a((Object) textView, "rootView.main_header");
        textView.setVisibility(4);
        View view4 = this.f56954c;
        if (view4 == null) {
            k.a("rootView");
        }
        TextView textView2 = (TextView) view4.findViewById(R.id.main_select_an_option_tv);
        k.a((Object) textView2, "rootView.main_select_an_option_tv");
        textView2.setVisibility(4);
        View view5 = this.f56954c;
        if (view5 == null) {
            k.a("rootView");
        }
        RelativeLayout relativeLayout = (RelativeLayout) view5.findViewById(R.id.option_go_to_bank);
        k.a((Object) relativeLayout, "rootView.option_go_to_bank");
        relativeLayout.setVisibility(4);
        View view6 = this.f56954c;
        if (view6 == null) {
            k.a("rootView");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) view6.findViewById(R.id.option_wait_for_otp);
        k.a((Object) relativeLayout2, "rootView.option_wait_for_otp");
        relativeLayout2.setVisibility(4);
        View view7 = this.f56954c;
        if (view7 == null) {
            k.a("rootView");
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) view7.findViewById(R.id.option_use_another_option);
        k.a((Object) relativeLayout3, "rootView.option_use_another_option");
        relativeLayout3.setVisibility(4);
        View view8 = this.f56954c;
        if (view8 == null) {
            k.a("rootView");
        }
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) view8.findViewById(R.id.submit_button_loader));
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void b(a aVar) {
        View view = aVar.f56954c;
        if (view == null) {
            k.a("rootView");
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lyt_go_back);
        k.a((Object) linearLayout, "rootView.lyt_go_back");
        linearLayout.setVisibility(0);
        View view2 = aVar.f56954c;
        if (view2 == null) {
            k.a("rootView");
        }
        View findViewById = view2.findViewById(R.id.lyt_divider);
        k.a((Object) findViewById, "rootView.lyt_divider");
        findViewById.setVisibility(0);
        View view3 = aVar.f56954c;
        if (view3 == null) {
            k.a("rootView");
        }
        TextView textView = (TextView) view3.findViewById(R.id.main_header);
        k.a((Object) textView, "rootView.main_header");
        textView.setVisibility(0);
        View view4 = aVar.f56954c;
        if (view4 == null) {
            k.a("rootView");
        }
        TextView textView2 = (TextView) view4.findViewById(R.id.main_select_an_option_tv);
        k.a((Object) textView2, "rootView.main_select_an_option_tv");
        textView2.setVisibility(0);
        View view5 = aVar.f56954c;
        if (view5 == null) {
            k.a("rootView");
        }
        RelativeLayout relativeLayout = (RelativeLayout) view5.findViewById(R.id.option_go_to_bank);
        k.a((Object) relativeLayout, "rootView.option_go_to_bank");
        relativeLayout.setVisibility(0);
        View view6 = aVar.f56954c;
        if (view6 == null) {
            k.a("rootView");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) view6.findViewById(R.id.option_wait_for_otp);
        k.a((Object) relativeLayout2, "rootView.option_wait_for_otp");
        relativeLayout2.setVisibility(0);
        View view7 = aVar.f56954c;
        if (view7 == null) {
            k.a("rootView");
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) view7.findViewById(R.id.option_use_another_option);
        k.a((Object) relativeLayout3, "rootView.option_use_another_option");
        relativeLayout3.setVisibility(0);
        View view8 = aVar.f56954c;
        if (view8 == null) {
            k.a("rootView");
        }
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) view8.findViewById(R.id.submit_button_loader));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56957g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
