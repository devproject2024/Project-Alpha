package net.one97.paytm.recharge.widgets.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.recharge.widgets.c.d;

public final class CJRRechargeLottieAnimationView extends LottieAnimationView {
    public CJRRechargeLottieAnimationView(Context context) {
        super(context);
    }

    public CJRRechargeLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CJRRechargeLottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final Parcelable onSaveInstanceState() {
        try {
            super.onSaveInstanceState();
            return null;
        } catch (Exception e2) {
            d dVar = d.f64967a;
            StringBuilder sb = new StringBuilder();
            sb.append(CJRRechargeLottieAnimationView.class.getSimpleName());
            sb.append(" onSaveInstanceState : parcelable exception ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            d.a(sb.toString());
            return null;
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        try {
            super.onRestoreInstanceState(parcelable);
        } catch (Exception e2) {
            d dVar = d.f64967a;
            StringBuilder sb = new StringBuilder();
            sb.append(CJRRechargeLottieAnimationView.class.getSimpleName());
            sb.append(" onRestoreInstanceState : parcelable exception ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            d.a(sb.toString());
        }
    }
}
