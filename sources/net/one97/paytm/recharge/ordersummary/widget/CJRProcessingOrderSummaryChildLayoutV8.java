package net.one97.paytm.recharge.ordersummary.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryChildLayout;

public final class CJRProcessingOrderSummaryChildLayoutV8 extends CJRProcessingOrderSummaryChildLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f64499a;

    /* renamed from: b  reason: collision with root package name */
    private String f64500b;

    public final String getDescriptionReceived() {
        return this.f64500b;
    }

    public final String getTitleReceived() {
        return this.f64499a;
    }

    public final void setDescriptionReceived(String str) {
        k.c(str, "<set-?>");
        this.f64500b = str;
    }

    public final void setTitleReceived(String str) {
        k.c(str, "<set-?>");
        this.f64499a = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRProcessingOrderSummaryChildLayoutV8(Context context, String str, String str2, String str3, String str4, String str5, int i2) {
        super(context, str, str2, str5, i2);
        k.c(context, "context");
        k.c(str, "titleProcessing");
        k.c(str2, "descriptionProcessing");
        k.c(str3, "titleReceived");
        k.c(str4, "descriptionReceived");
        k.c(str5, "imageUrl");
        this.f64499a = str3;
        this.f64500b = str4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, com.paytm.utility.b.c(35));
        setLayoutParams(layoutParams);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        if (Build.VERSION.SDK_INT < 21) {
            k.a((Object) progressBar, "progressBar");
            Drawable f2 = androidx.core.graphics.drawable.a.f(progressBar.getIndeterminateDrawable());
            androidx.core.graphics.drawable.a.a(f2, androidx.core.content.b.c(getContext(), R.color.rc_os_status_green_color));
            progressBar.setIndeterminateDrawable(androidx.core.graphics.drawable.a.g(f2));
        }
        a(str, str2, (AnimatorListenerAdapter) null);
    }

    public final void setDefaultLogo() {
        if (Build.VERSION.SDK_INT < 21) {
            int c2 = com.paytm.utility.b.c(5) + ((int) getResources().getDimension(R.dimen.margin_pre_processing_progress_bar_v8));
            ImageView imageView = (ImageView) findViewById(R.id.logo);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = c2;
                layoutParams2.rightMargin = c2;
                layoutParams2.bottomMargin = c2;
                layoutParams2.leftMargin = c2;
                imageView.setImageResource(R.drawable.ic_order_summary_processing_payment);
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ((ImageView) findViewById(R.id.logo)).setImageResource(R.drawable.ic_os_pre_processing_bank_default_icon);
    }

    public final void a(String str) {
        k.c(str, "postLottieAnim");
        View findViewById = findViewById(R.id.progress_bar);
        k.a((Object) findViewById, "findViewById<View>(R.id.progress_bar)");
        findViewById.setVisibility(4);
        View findViewById2 = findViewById(R.id.logo);
        k.a((Object) findViewById2, "findViewById<View>(R.id.logo)");
        findViewById2.setVisibility(4);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.img_lottie_logo);
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation(str);
        lottieAnimationView.playAnimation();
    }

    public final void a(String str, String str2, AnimatorListenerAdapter animatorListenerAdapter) {
        k.c(str, "title");
        String str3 = str2;
        k.c(str3, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        TextView textView = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.description);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView2, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a(textView, str, textView2, str3, animatorListenerAdapter, ofFloat, ofFloat2));
        animatorSet.setDuration(200);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f64501a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f64502b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f64503c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f64504d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ AnimatorListenerAdapter f64505e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f64506f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f64507g;

        a(TextView textView, String str, TextView textView2, String str2, AnimatorListenerAdapter animatorListenerAdapter, ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
            this.f64501a = textView;
            this.f64502b = str;
            this.f64503c = textView2;
            this.f64504d = str2;
            this.f64505e = animatorListenerAdapter;
            this.f64506f = objectAnimator;
            this.f64507g = objectAnimator2;
        }

        public final void onAnimationStart(Animator animator) {
            TextView textView = this.f64501a;
            k.a((Object) textView, "titleView");
            textView.setText(this.f64502b);
            TextView textView2 = this.f64503c;
            k.a((Object) textView2, "descriptionView");
            textView2.setText(this.f64504d);
        }

        public final void onAnimationEnd(Animator animator) {
            AnimatorListenerAdapter animatorListenerAdapter = this.f64505e;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }
    }

    public final void a(AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) findViewById(R.id.title), View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) findViewById(R.id.description), View.ALPHA, new float[]{1.0f, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new b(this, animatorListenerAdapter, ofFloat, ofFloat2));
        animatorSet.setDuration(200);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRProcessingOrderSummaryChildLayoutV8 f64508a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AnimatorListenerAdapter f64509b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f64510c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f64511d;

        b(CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8, AnimatorListenerAdapter animatorListenerAdapter, ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
            this.f64508a = cJRProcessingOrderSummaryChildLayoutV8;
            this.f64509b = animatorListenerAdapter;
            this.f64510c = objectAnimator;
            this.f64511d = objectAnimator2;
        }

        public final void onAnimationEnd(Animator animator) {
            CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8 = this.f64508a;
            cJRProcessingOrderSummaryChildLayoutV8.a(cJRProcessingOrderSummaryChildLayoutV8.getTitleReceived(), this.f64508a.getDescriptionReceived(), this.f64509b);
        }
    }
}
