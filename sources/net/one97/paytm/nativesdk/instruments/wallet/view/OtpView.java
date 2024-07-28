package net.one97.paytm.nativesdk.instruments.wallet.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.a;
import androidx.core.content.b;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletOtpViewModel;
import net.one97.paytm.nativesdk.transcation.OtpEditText;

public final class OtpView extends LinearLayout {
    private HashMap _$_findViewCache;
    private LottieAnimationView lottieAnimationView;
    /* access modifiers changed from: private */
    public OtpViewWatcher mOtpWatcher;
    private WalletOtpViewModel walletOtpViewModel;

    public interface OtpViewWatcher {
        void onOtpClickedValidated(String str);

        void onResendOtpClicked();
    }

    public OtpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OtpView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
        View inflate = LayoutInflater.from(context).inflate(R.layout.wlt_otp_view, this, true);
        ao aoVar = (ao) context;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ai a2 = new al(aoVar, (al.b) new al.a((Application) applicationContext)).a(WalletOtpViewModel.class);
            k.a((Object) a2, "ViewModelProvider((conte…OtpViewModel::class.java)");
            this.walletOtpViewModel = (WalletOtpViewModel) a2;
            if (!hasReadSmsPermission()) {
                requestReadSendPermission();
            }
            this.lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.ltv_loading);
            ((OtpEditText) _$_findCachedViewById(R.id.otpEditText)).addTextChangedListener(this.walletOtpViewModel);
            ((RelativeLayout) _$_findCachedViewById(R.id.payButton)).setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ OtpView this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    OtpViewWatcher access$getMOtpWatcher$p;
                    this.this$0.showOtpViewProgress();
                    OtpEditText otpEditText = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
                    k.a((Object) otpEditText, "otpEditText");
                    Editable text = otpEditText.getText();
                    if (text == null) {
                        k.a();
                    }
                    if (text.length() == 6 && (access$getMOtpWatcher$p = this.this$0.mOtpWatcher) != null) {
                        OtpEditText otpEditText2 = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
                        k.a((Object) otpEditText2, "otpEditText");
                        access$getMOtpWatcher$p.onOtpClickedValidated(String.valueOf(otpEditText2.getText()));
                    }
                }
            });
            ((TextView) _$_findCachedViewById(R.id.tvResendOtp)).setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ OtpView this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.hideOtpViewProgress();
                    OtpViewWatcher access$getMOtpWatcher$p = this.this$0.mOtpWatcher;
                    if (access$getMOtpWatcher$p != null) {
                        access$getMOtpWatcher$p.onResendOtpClicked();
                    }
                }
            });
            observeData();
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Application");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OtpView(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void hideOtpViewProgress() {
        LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(8);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaySecurely);
        k.a((Object) textView, "tvPaySecurely");
        textView.setVisibility(0);
        LottieAnimationView lottieAnimationView3 = this.lottieAnimationView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setAnimation("Payments-Loader.json");
        }
        LottieAnimationView lottieAnimationView4 = this.lottieAnimationView;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.loop(true);
        }
        LottieAnimationView lottieAnimationView5 = this.lottieAnimationView;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.pauseAnimation();
        }
    }

    public final void showOtpViewProgress() {
        LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaySecurely);
        k.a((Object) textView, "tvPaySecurely");
        textView.setVisibility(8);
        LottieAnimationView lottieAnimationView3 = this.lottieAnimationView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setAnimation("Payments-Loader.json");
        }
        LottieAnimationView lottieAnimationView4 = this.lottieAnimationView;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.loop(true);
        }
        LottieAnimationView lottieAnimationView5 = this.lottieAnimationView;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.playAnimation();
        }
    }

    private final void observeData() {
        if (getContext() instanceof q) {
            y<String> otpText = this.walletOtpViewModel.getOtpText();
            Context context = getContext();
            if (context != null) {
                otpText.observe((q) context, new OtpView$observeData$1(this));
                y<String> mOtpTextChanged = this.walletOtpViewModel.getMOtpTextChanged();
                Context context2 = getContext();
                if (context2 != null) {
                    mOtpTextChanged.observe((q) context2, new OtpView$observeData$2(this));
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            throw new u("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
    }

    private final boolean hasReadSmsPermission() {
        return b.a(getContext(), "android.permission.READ_SMS") == 0 && b.a(getContext(), "android.permission.RECEIVE_SMS") == 0;
    }

    private final void requestReadSendPermission() {
        try {
            Context context = getContext();
            if (context == null) {
                throw new u("null cannot be cast to non-null type android.app.Activity");
            } else if (!a.a((Activity) context, "android.permission.READ_SMS")) {
                Context context2 = getContext();
                if (context2 != null) {
                    a.a((Activity) context2, new String[]{"android.permission.READ_SMS", "android.permission.RECEIVE_SMS"}, 102);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        } catch (Exception unused) {
        }
    }

    public final void setOtpCalllback(OtpViewWatcher otpViewWatcher) {
        k.c(otpViewWatcher, "subsCriber");
        this.mOtpWatcher = otpViewWatcher;
    }

    public final void startOtpDetection(Context context) {
        this.walletOtpViewModel.registerOtpBroadCast();
    }

    public final void otpError(boolean z) {
        ((OtpEditText) _$_findCachedViewById(R.id.otpEditText)).activateOtpError();
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvInvalidOtpText);
        k.a((Object) textView, "tvInvalidOtpText");
        textView.setVisibility(0);
    }

    public final void setWalletOtpTcText(String str) {
        if (str != null) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_wallet_otp_tc);
            k.a((Object) textView, "tv_wallet_otp_tc");
            textView.setText(str);
            x xVar = x.f47997a;
        }
    }

    public final void setWalletOtpTcVisibilty(Integer num) {
        if (num != null) {
            num.intValue();
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_wallet_otp_tc);
            k.a((Object) textView, "tv_wallet_otp_tc");
            textView.setVisibility(num.intValue());
            x xVar = x.f47997a;
        }
    }

    public final void setpayButtonText(String str) {
        if (str != null) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaySecurely);
            k.a((Object) textView, "tvPaySecurely");
            textView.setText(str);
            x xVar = x.f47997a;
        }
    }
}
