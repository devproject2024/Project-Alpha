package net.one97.paytm.upgradeKyc.minkycotp;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.data.models.requestotp.RequestOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.resendotp.KycResendOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.verifykycotp.KycVerifyOtpResponse;
import net.one97.paytm.upgradeKyc.kycV3.c.g;
import net.one97.paytm.upgradeKyc.minkycotp.a;
import net.one97.paytm.upgradeKyc.utils.KycPinEntryView;
import net.one97.paytm.upgradeKyc.utils.l;

public final class b extends net.one97.paytm.i.f implements KycPinEntryView.b {

    /* renamed from: a  reason: collision with root package name */
    public d f66281a;

    /* renamed from: b  reason: collision with root package name */
    boolean f66282b;

    /* renamed from: c  reason: collision with root package name */
    private View f66283c;

    /* renamed from: d  reason: collision with root package name */
    private a f66284d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnClickListener f66285e = new a(this);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f66286f;

    public final View a(int i2) {
        if (this.f66286f == null) {
            this.f66286f = new HashMap();
        }
        View view = (View) this.f66286f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f66286f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str) {
    }

    static final class c<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<RequestOtpResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66289a;

        c(b bVar) {
            this.f66289a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66289a.a(R.id.kyc_otp_wallet_loader));
            b.a(this.f66289a);
            int i2 = c.f66294a[bVar.f66168a.ordinal()];
            boolean z = true;
            String str = null;
            if (i2 == 1) {
                if (bVar.f66169b != null) {
                    RequestOtpResponse requestOtpResponse = (RequestOtpResponse) bVar.f66169b;
                    if (p.a("SUCCESS", requestOtpResponse != null ? requestOtpResponse.getStatus() : null, true)) {
                        RequestOtpResponse requestOtpResponse2 = (RequestOtpResponse) bVar.f66169b;
                        CharSequence message = requestOtpResponse2 != null ? requestOtpResponse2.getMessage() : null;
                        if (!(message == null || message.length() == 0)) {
                            z = false;
                        }
                        if (!z) {
                            b bVar2 = this.f66289a;
                            RequestOtpResponse requestOtpResponse3 = (RequestOtpResponse) bVar.f66169b;
                            if (requestOtpResponse3 != null) {
                                str = requestOtpResponse3.getMessage();
                            }
                            if (str == null) {
                                k.a();
                            }
                            Snackbar.a((View) (CoordinatorLayout) bVar2.a(R.id.kyc_snackbar_holder), (CharSequence) str, -1).c();
                            return;
                        }
                        b bVar3 = this.f66289a;
                        String string = bVar3.getString(R.string.kyc_message_sent_successfully);
                        k.a((Object) string, "getString(R.string.kyc_message_sent_successfully)");
                        Snackbar.a((View) (CoordinatorLayout) bVar3.a(R.id.kyc_snackbar_holder), (CharSequence) string, -1).c();
                        return;
                    }
                }
                b bVar4 = this.f66289a;
                RequestOtpResponse requestOtpResponse4 = (RequestOtpResponse) bVar.f66169b;
                if (requestOtpResponse4 != null) {
                    str = requestOtpResponse4.getMessage();
                }
                b.a(bVar4, str);
            } else if (i2 == 2) {
                l.a();
                Context context = this.f66289a.getContext();
                if (context == null) {
                    k.a();
                }
                NetworkCustomError networkCustomError = bVar.f66170c;
                if (networkCustomError == null) {
                    k.a();
                }
                if (!l.a(context, networkCustomError)) {
                    b bVar5 = this.f66289a;
                    NetworkCustomError networkCustomError2 = bVar.f66170c;
                    if (networkCustomError2 != null) {
                        str = networkCustomError2.getAlertMessage();
                    }
                    b.a(bVar5, str);
                }
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycResendOtpResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66290a;

        d(b bVar) {
            this.f66290a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66290a.a(R.id.kyc_otp_wallet_loader));
            b.a(this.f66290a);
            int i2 = c.f66295b[bVar.f66168a.ordinal()];
            boolean z = true;
            String str = null;
            if (i2 == 1) {
                if (bVar.f66169b != null) {
                    KycResendOtpResponse kycResendOtpResponse = (KycResendOtpResponse) bVar.f66169b;
                    if (p.a("SUCCESS", kycResendOtpResponse != null ? kycResendOtpResponse.getStatus() : null, true)) {
                        KycResendOtpResponse kycResendOtpResponse2 = (KycResendOtpResponse) bVar.f66169b;
                        CharSequence message = kycResendOtpResponse2 != null ? kycResendOtpResponse2.getMessage() : null;
                        if (!(message == null || message.length() == 0)) {
                            z = false;
                        }
                        if (!z) {
                            b bVar2 = this.f66290a;
                            KycResendOtpResponse kycResendOtpResponse3 = (KycResendOtpResponse) bVar.f66169b;
                            if (kycResendOtpResponse3 != null) {
                                str = kycResendOtpResponse3.getMessage();
                            }
                            if (str == null) {
                                k.a();
                            }
                            Snackbar.a((View) (CoordinatorLayout) bVar2.a(R.id.kyc_snackbar_holder), (CharSequence) str, -1).c();
                            return;
                        }
                        b bVar3 = this.f66290a;
                        String string = bVar3.getString(R.string.kyc_message_sent_successfully);
                        k.a((Object) string, "getString(R.string.kyc_message_sent_successfully)");
                        Snackbar.a((View) (CoordinatorLayout) bVar3.a(R.id.kyc_snackbar_holder), (CharSequence) string, -1).c();
                        return;
                    }
                }
                b bVar4 = this.f66290a;
                KycResendOtpResponse kycResendOtpResponse4 = (KycResendOtpResponse) bVar.f66169b;
                if (kycResendOtpResponse4 != null) {
                    str = kycResendOtpResponse4.getMessage();
                }
                b.a(bVar4, str);
            } else if (i2 == 2) {
                l.a();
                Context context = this.f66290a.getContext();
                if (context == null) {
                    k.a();
                }
                NetworkCustomError networkCustomError = bVar.f66170c;
                if (networkCustomError == null) {
                    k.a();
                }
                if (!l.a(context, networkCustomError)) {
                    b bVar5 = this.f66290a;
                    NetworkCustomError networkCustomError2 = bVar.f66170c;
                    if (networkCustomError2 != null) {
                        str = networkCustomError2.getAlertMessage();
                    }
                    b.a(bVar5, str);
                }
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycVerifyOtpResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66291a;

        e(b bVar) {
            this.f66291a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66291a.a(R.id.kyc_otp_wallet_loader));
            b.a(this.f66291a);
            int i2 = c.f66296c[bVar.f66168a.ordinal()];
            String str = null;
            if (i2 == 1) {
                if (bVar.f66169b != null) {
                    KycVerifyOtpResponse kycVerifyOtpResponse = (KycVerifyOtpResponse) bVar.f66169b;
                    if (p.a("SUCCESS", kycVerifyOtpResponse != null ? kycVerifyOtpResponse.getStatus() : null, true)) {
                        b.b(this.f66291a);
                        d dVar = this.f66291a.f66281a;
                        if (dVar == null) {
                            k.a("minKycOtpListener");
                        }
                        dVar.a();
                        if (this.f66291a.f66282b) {
                            this.f66291a.dismiss();
                            return;
                        }
                        return;
                    }
                }
                b bVar2 = this.f66291a;
                KycVerifyOtpResponse kycVerifyOtpResponse2 = (KycVerifyOtpResponse) bVar.f66169b;
                if (kycVerifyOtpResponse2 != null) {
                    str = kycVerifyOtpResponse2.getMessage();
                }
                b.a(bVar2, str);
            } else if (i2 == 2) {
                l.a();
                Context context = this.f66291a.getContext();
                if (context == null) {
                    k.a();
                }
                NetworkCustomError networkCustomError = bVar.f66170c;
                if (networkCustomError == null) {
                    k.a();
                }
                if (!l.a(context, networkCustomError)) {
                    b bVar3 = this.f66291a;
                    NetworkCustomError networkCustomError2 = bVar.f66170c;
                    if (networkCustomError2 != null) {
                        str = networkCustomError2.getAlertMessage();
                    }
                    b.a(bVar3, str);
                }
            }
        }
    }

    public static final /* synthetic */ a c(b bVar) {
        a aVar = bVar.f66284d;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public final void a(d dVar) {
        k.c(dVar, "<set-?>");
        this.f66281a = dVar;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66287a;

        a(b bVar) {
            this.f66287a = bVar;
        }

        public final void onClick(View view) {
            k.a((Object) view, "it");
            int id = view.getId();
            if (id == R.id.request_another_otp) {
                if (com.paytm.utility.b.c(this.f66287a.getContext())) {
                    a c2 = b.c(this.f66287a);
                    String str = b.c(this.f66287a).f66279d;
                    k.c(str, "state");
                    Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(c2), (kotlin.d.f) null, (CoroutineStart) null, new a.b(c2, str, (kotlin.d.d) null), 3, (Object) null);
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66287a.a(R.id.kyc_otp_wallet_loader));
                    this.f66287a.a();
                    return;
                }
                b bVar = this.f66287a;
                b.a(bVar, bVar.getString(R.string.err_nonetwork_msg));
            } else if (id == R.id.confirm_otp) {
                KycPinEntryView kycPinEntryView = (KycPinEntryView) this.f66287a.a(R.id.otpView);
                k.a((Object) kycPinEntryView, "otpView");
                if (kycPinEntryView.getText().toString().length() < 6) {
                    TextView textView = (TextView) this.f66287a.a(R.id.tv_otp_error);
                    k.a((Object) textView, "tv_otp_error");
                    textView.setVisibility(0);
                } else if (com.paytm.utility.b.c(this.f66287a.getContext())) {
                    a c3 = b.c(this.f66287a);
                    String str2 = b.c(this.f66287a).f66279d;
                    KycPinEntryView kycPinEntryView2 = (KycPinEntryView) this.f66287a.a(R.id.otpView);
                    k.a((Object) kycPinEntryView2, "otpView");
                    String obj = kycPinEntryView2.getText().toString();
                    k.c(str2, "state");
                    k.c(obj, "otp");
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(aj.a(c3), (kotlin.d.f) null, (CoroutineStart) null, new a.c(c3, str2, obj, (kotlin.d.d) null), 3, (Object) null);
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66287a.a(R.id.kyc_otp_wallet_loader));
                    this.f66287a.a();
                } else {
                    b bVar2 = this.f66287a;
                    b.a(bVar2, bVar2.getString(R.string.err_nonetwork_msg));
                }
            } else if (id == R.id.iv_back_btn) {
                b.b(this.f66287a);
                if (this.f66287a.f66282b) {
                    this.f66287a.dismiss();
                    return;
                }
                FragmentActivity activity = this.f66287a.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            } else if (id == R.id.iv_close) {
                b.b(this.f66287a);
                if (this.f66287a.f66282b) {
                    this.f66287a.dismiss();
                    return;
                }
                FragmentActivity activity2 = this.f66287a.getActivity();
                if (activity2 != null) {
                    activity2.onBackPressed();
                }
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("isBottomSheetView")) {
            this.f66282b = true;
            try {
                setStyle(0, R.style.KycCustomBottomSheetDialogTheme);
            } catch (Exception unused) {
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_kyc_verify_otp, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…rify_otp,container,false)");
        this.f66283c = inflate;
        View view = this.f66283c;
        if (view == null) {
            k.a("lay");
        }
        return view;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ao aoVar = this;
        g.a aVar = g.f66236a;
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        ai a2 = new al(aoVar, (al.b) g.a.a(application)).a(a.class);
        k.a((Object) a2, "ViewModelProvider(this,K…OtpViewModel::class.java)");
        this.f66284d = (a) a2;
        KycPinEntryView kycPinEntryView = (KycPinEntryView) a(R.id.otpView);
        k.a((Object) kycPinEntryView, "otpView");
        EditText editText = kycPinEntryView.getEditText();
        k.a((Object) editText, "otpView.editText");
        View view2 = editText;
        view2.postDelayed(new f(this, view2), 100);
        TextView textView = (TextView) a(R.id.verify_mobile_no_text);
        k.a((Object) textView, "verify_mobile_no_text");
        textView.setText(getString(R.string.kyc_verify_mobile_no) + " " + com.paytm.utility.b.l(getContext()));
        if (this.f66282b) {
            ImageView imageView = (ImageView) a(R.id.iv_close);
            k.a((Object) imageView, "iv_close");
            imageView.setVisibility(0);
        }
        a aVar2 = this.f66284d;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        aVar2.f66276a.observe(getViewLifecycleOwner(), new c(this));
        a aVar3 = this.f66284d;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        aVar3.f66277b.observe(getViewLifecycleOwner(), new d(this));
        a aVar4 = this.f66284d;
        if (aVar4 == null) {
            k.a("viewModel");
        }
        aVar4.f66278c.observe(getViewLifecycleOwner(), new e(this));
        ((TextView) a(R.id.request_another_otp)).setOnClickListener(this.f66285e);
        ((TextView) a(R.id.confirm_otp)).setOnClickListener(this.f66285e);
        ((ImageView) a(R.id.iv_back_btn)).setOnClickListener(this.f66285e);
        ((ImageView) a(R.id.iv_close)).setOnClickListener(this.f66285e);
        KycPinEntryView kycPinEntryView2 = (KycPinEntryView) a(R.id.otpView);
        k.a((Object) kycPinEntryView2, "otpView");
        kycPinEntryView2.setOnPinEnteredListener(this);
        if (com.paytm.utility.b.c(getContext())) {
            a aVar5 = this.f66284d;
            if (aVar5 == null) {
                k.a("viewModel");
            }
            String l = com.paytm.utility.b.l(getContext());
            k.a((Object) l, "CJRAppCommonUtility.getMobile(context)");
            k.c(l, "phoneNo");
            Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(aVar5), (kotlin.d.f) null, (CoroutineStart) null, new a.C1328a(aVar5, l, (kotlin.d.d) null), 3, (Object) null);
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.kyc_otp_wallet_loader));
            a();
            return;
        }
        new Handler().postDelayed(new C1329b(this), 200);
    }

    /* renamed from: net.one97.paytm.upgradeKyc.minkycotp.b$b  reason: collision with other inner class name */
    static final class C1329b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66288a;

        C1329b(b bVar) {
            this.f66288a = bVar;
        }

        public final void run() {
            b bVar = this.f66288a;
            b.a(bVar, bVar.getString(R.string.err_nonetwork_msg));
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66292a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f66293b;

        f(b bVar, View view) {
            this.f66292a = bVar;
            this.f66293b = view;
        }

        public final void run() {
            this.f66293b.requestFocus();
            Context context = this.f66292a.getContext();
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager != null) {
                    View view = this.f66293b;
                    if (view != null) {
                        inputMethodManager.showSoftInput((EditText) view, 2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.EditText");
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        TextView textView = (TextView) a(R.id.confirm_otp);
        k.a((Object) textView, "confirm_otp");
        textView.setClickable(false);
        TextView textView2 = (TextView) a(R.id.request_another_otp);
        k.a((Object) textView2, "request_another_otp");
        textView2.setClickable(false);
    }

    public final void b(String str) {
        TextView textView = (TextView) a(R.id.tv_otp_error);
        k.a((Object) textView, "tv_otp_error");
        textView.setVisibility(8);
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            com.paytm.utility.b.b(bVar.getContext(), bVar.getString(R.string.error), bVar.getString(R.string.some_went_wrong));
        } else {
            com.paytm.utility.b.b(bVar.getContext(), bVar.getString(R.string.error), str);
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        TextView textView = (TextView) bVar.a(R.id.confirm_otp);
        k.a((Object) textView, "confirm_otp");
        textView.setClickable(true);
        TextView textView2 = (TextView) bVar.a(R.id.request_another_otp);
        k.a((Object) textView2, "request_another_otp");
        textView2.setClickable(true);
    }

    public static final /* synthetic */ void b(b bVar) {
        FragmentActivity activity = bVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            FragmentActivity activity2 = bVar.getActivity();
            if (activity2 == null) {
                k.a();
            }
            Object systemService = activity2.getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66286f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
