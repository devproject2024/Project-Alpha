package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import net.one97.paytm.passbook.R;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    final Context f59267a;

    /* renamed from: b  reason: collision with root package name */
    final TextView f59268b;

    public o(Context context, TextView textView) {
        this.f59267a = context;
        this.f59268b = textView;
    }

    public final void a(final String str) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f59267a, R.anim.pass_text_scroll_up);
        this.f59268b.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                o.this.f59268b.setText(str);
                o.this.f59268b.startAnimation(AnimationUtils.loadAnimation(o.this.f59267a, R.anim.pass_text_scroll_bottom_to_up));
            }
        });
    }
}
