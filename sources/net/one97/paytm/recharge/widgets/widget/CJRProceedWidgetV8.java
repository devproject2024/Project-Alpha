package net.one97.paytm.recharge.widgets.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.b.k;
import net.one97.paytm.recharge.widgets.R;

public final class CJRProceedWidgetV8 extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Button f64977a;

    /* renamed from: b  reason: collision with root package name */
    private CJRRechargeLottieAnimationView f64978b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRProceedWidgetV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(R.layout.v8_widget_proceed_btn, this, true);
        this.f64977a = (Button) findViewById(R.id.btn);
        this.f64978b = (CJRRechargeLottieAnimationView) findViewById(R.id.loading_three_dots_lav);
        setGravity(17);
        setDescendantFocusability(131072);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRProceedWidgetV8(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRProceedWidgetV8 f64979a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f64980b;

        a(CJRProceedWidgetV8 cJRProceedWidgetV8, View.OnClickListener onClickListener) {
            this.f64979a = cJRProceedWidgetV8;
            this.f64980b = onClickListener;
        }

        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.f64980b;
            if (onClickListener != null) {
                onClickListener.onClick(this.f64979a);
            }
        }
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        Button button = this.f64977a;
        if (button != null) {
            button.setOnClickListener(new a(this, onClickListener));
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        Button button = this.f64977a;
        if (button != null) {
            button.setEnabled(z);
        }
        Button button2 = this.f64977a;
        if (button2 != null) {
            button2.setClickable(z);
        }
    }

    public final void setProceedBtnText(String str) {
        Button button = this.f64977a;
        if (button != null) {
            button.setText(str);
        }
    }

    public final void a() {
        Button button = this.f64977a;
        if (button != null) {
            button.setVisibility(8);
        }
        a(this.f64978b);
        setBackgroundResource(R.drawable.proceed_animation_bg);
    }

    public final void b() {
        Button button = this.f64977a;
        if (button != null) {
            button.setVisibility(0);
        }
        b(this.f64978b);
        setBackgroundColor(0);
    }

    private static void a(LottieAnimationView lottieAnimationView) {
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
