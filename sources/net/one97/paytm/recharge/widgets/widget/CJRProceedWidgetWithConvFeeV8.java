package net.one97.paytm.recharge.widgets.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.recharge.widgets.R;

public final class CJRProceedWidgetWithConvFeeV8 extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public CJRRechargeLottieAnimationView f64981a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f64982b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f64983c;

    public final View a(int i2) {
        if (this.f64983c == null) {
            this.f64983c = new HashMap();
        }
        View view = (View) this.f64983c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64983c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRProceedWidgetWithConvFeeV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(R.layout.v8_widget_proceed_btn_with_conv_fee, this, true);
        this.f64982b = (RelativeLayout) findViewById(R.id.lyt_proceed_btn);
        this.f64981a = (CJRRechargeLottieAnimationView) findViewById(R.id.loading_three_dots_lav);
        setGravity(17);
        setDescendantFocusability(131072);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRProceedWidgetWithConvFeeV8(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRProceedWidgetWithConvFeeV8 f64984a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f64985b;

        a(CJRProceedWidgetWithConvFeeV8 cJRProceedWidgetWithConvFeeV8, View.OnClickListener onClickListener) {
            this.f64984a = cJRProceedWidgetWithConvFeeV8;
            this.f64985b = onClickListener;
        }

        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.f64985b;
            if (onClickListener != null) {
                onClickListener.onClick(this.f64984a);
            }
        }
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout = this.f64982b;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new a(this, onClickListener));
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        RelativeLayout relativeLayout = this.f64982b;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z);
        }
        RelativeLayout relativeLayout2 = this.f64982b;
        if (relativeLayout2 != null) {
            relativeLayout2.setClickable(z);
        }
    }

    public final void setProceedBtnText(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        TextView textView = (TextView) a(R.id.txt_amount);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setConvFeeText(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        TextView textView = (TextView) a(R.id.txt_conv_fee);
        if (textView != null) {
            textView.setText(str);
        }
        if (TextUtils.isEmpty(str)) {
            TextView textView2 = (TextView) a(R.id.txt_conv_fee);
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = (TextView) a(R.id.txt_conv_fee);
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    public final void a() {
        TextView textView;
        TextView textView2 = (TextView) a(R.id.txt_amount);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = (TextView) a(R.id.txt_conv_fee);
        if (!TextUtils.isEmpty(textView3 != null ? textView3.getText() : null) && (textView = (TextView) a(R.id.txt_conv_fee)) != null) {
            textView.setVisibility(0);
        }
        b(this.f64981a);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.lyt_proceed_btn);
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.bg_recharge_rounded_corner_3dp_blue);
        }
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    private static void b(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }
}
