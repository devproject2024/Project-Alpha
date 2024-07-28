package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import net.one97.paytm.passbook.R;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    boolean f59232a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f59233b = false;

    /* renamed from: c  reason: collision with root package name */
    private final Context f59234c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f59235d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f59236e;

    /* renamed from: f  reason: collision with root package name */
    private Animation f59237f;

    /* renamed from: g  reason: collision with root package name */
    private Animation f59238g;

    public g(Context context, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.f59234c = context;
        this.f59235d = linearLayout;
        this.f59236e = linearLayout2;
        this.f59237f = AnimationUtils.loadAnimation(this.f59234c, R.anim.pass_text_scroll_bottom_to_up);
        this.f59238g = AnimationUtils.loadAnimation(this.f59234c, R.anim.pass_text_scroll_top_to_bottom);
    }

    public final void a() {
        if (!this.f59232a) {
            this.f59235d.startAnimation(this.f59237f);
        }
        this.f59237f.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                g.this.f59232a = true;
            }

            public final void onAnimationEnd(Animation animation) {
                g.this.f59232a = false;
            }
        });
    }

    public final void b() {
        this.f59237f.cancel();
        this.f59235d.clearAnimation();
    }

    public final void c() {
        this.f59238g.cancel();
        this.f59236e.clearAnimation();
    }

    public final void d() {
        if (!this.f59233b) {
            this.f59236e.startAnimation(this.f59238g);
        }
        this.f59238g.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                g.this.f59233b = false;
            }
        });
    }
}
