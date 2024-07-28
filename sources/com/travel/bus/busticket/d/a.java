package com.travel.bus.busticket.d;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.travel.bus.R;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    ImageView f22106a = ((ImageView) this.f22109d.findViewById(R.id.img_back_tree));

    /* renamed from: b  reason: collision with root package name */
    ImageView f22107b = ((ImageView) this.f22109d.findViewById(R.id.img_front_tree));

    /* renamed from: c  reason: collision with root package name */
    private Activity f22108c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f22109d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f22110e = ((ImageView) this.f22109d.findViewById(R.id.img_bus));

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22111f = ((ImageView) this.f22109d.findViewById(R.id.img_road));

    public a(Activity activity, LinearLayout linearLayout) {
        this.f22108c = activity;
        this.f22109d = linearLayout;
        ResourceUtils.loadBusImagesFromCDN(this.f22110e, "bus.png", false, false, n.a.V1);
        ResourceUtils.loadBusImagesFromCDN(this.f22111f, "road.png", false, false, n.a.V1);
    }

    public final void a() {
        this.f22109d.setVisibility(0);
        c();
    }

    public final void b() {
        this.f22109d.setVisibility(8);
    }

    private void c() {
        this.f22110e.startAnimation(AnimationUtils.loadAnimation(this.f22108c, R.anim.pre_b_train_image_animation));
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.f22108c, R.anim.pre_b_train_progree_animation);
        this.f22107b.post(new Runnable() {
            public final void run() {
                a.this.f22107b.startAnimation(loadAnimation);
            }
        });
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f22108c, R.anim.pre_b_train_progress_backimage_animation);
        this.f22106a.post(new Runnable() {
            public final void run() {
                a.this.f22106a.startAnimation(loadAnimation2);
            }
        });
    }
}
