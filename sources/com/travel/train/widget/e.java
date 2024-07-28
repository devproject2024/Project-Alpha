package com.travel.train.widget;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.paytm.utility.b;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.utils.n;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    ImageView f28377a = ((ImageView) this.f28379c.findViewById(R.id.front_tree_image));

    /* renamed from: b  reason: collision with root package name */
    ImageView f28378b = ((ImageView) this.f28379c.findViewById(R.id.back_tree_image));

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f28379c;

    /* renamed from: d  reason: collision with root package name */
    private Context f28380d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f28381e = ((ImageView) this.f28379c.findViewById(R.id.animation_train_image));

    /* renamed from: f  reason: collision with root package name */
    private ImageView f28382f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f28383g = ((RelativeLayout) this.f28379c.findViewById(R.id.relativeLayout2));

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f28384h = ((RelativeLayout) this.f28379c.findViewById(R.id.right_hover_lyt));

    /* renamed from: i  reason: collision with root package name */
    private int f28385i = b.f(this.f28380d);

    public e(Context context, RelativeLayout relativeLayout) {
        this.f28380d = context;
        this.f28379c = relativeLayout;
        this.f28383g.getLayoutParams().width = (int) (((double) this.f28385i) * 2.5d);
        this.f28383g.getLayoutParams().height = this.f28385i * 13;
        this.f28384h.getLayoutParams().width = (int) (((double) this.f28385i) * 1.5d);
        this.f28384h.getLayoutParams().height = this.f28385i * 13;
        this.f28382f = (ImageView) this.f28379c.findViewById(R.id.wheel_image);
        ResourceUtils.loadTrainImagesFromCDN(this.f28381e, "train_image.png", false, false, n.a.V1);
        ResourceUtils.loadTrainImagesFromCDN(this.f28382f, "wheel_image.png", false, false, n.a.V1);
    }

    public final void a() {
        d();
        c();
        b();
    }

    private void b() {
        this.f28381e.startAnimation(AnimationUtils.loadAnimation(this.f28380d, R.anim.train_image_animation));
    }

    private void c() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.f28380d, R.anim.train_progree_animation);
        this.f28377a.post(new Runnable() {
            public final void run() {
                e.this.f28377a.startAnimation(loadAnimation);
            }
        });
    }

    private void d() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.f28380d, R.anim.train_progress_backimage_animation);
        this.f28378b.post(new Runnable() {
            public final void run() {
                e.this.f28378b.startAnimation(loadAnimation);
            }
        });
    }
}
