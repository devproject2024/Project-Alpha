package net.one97.paytm.coins.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import net.one97.paytm.vipcashback.R;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    boolean f16724a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f16725b = false;

    /* renamed from: c  reason: collision with root package name */
    private final Context f16726c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f16727d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f16728e;

    /* renamed from: f  reason: collision with root package name */
    private Animation f16729f;

    /* renamed from: g  reason: collision with root package name */
    private Animation f16730g;

    public c(Context context, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.f16726c = context;
        this.f16727d = linearLayout;
        this.f16728e = linearLayout2;
        this.f16729f = AnimationUtils.loadAnimation(this.f16726c, R.anim.coins_text_scroll_bottom_to_up);
        this.f16730g = AnimationUtils.loadAnimation(this.f16726c, R.anim.coins_text_scroll_top_to_bottom);
    }

    public final void a() {
        if (!this.f16724a) {
            this.f16727d.startAnimation(this.f16729f);
        }
        this.f16729f.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                c.this.f16724a = true;
            }

            public final void onAnimationEnd(Animation animation) {
                c.this.f16724a = false;
            }
        });
    }

    public final void b() {
        this.f16729f.cancel();
        this.f16727d.clearAnimation();
    }

    public final void c() {
        this.f16730g.cancel();
        this.f16728e.clearAnimation();
    }

    public final void d() {
        if (!this.f16725b) {
            this.f16728e.startAnimation(this.f16730g);
        }
        this.f16730g.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                c.this.f16725b = false;
            }
        });
    }
}
