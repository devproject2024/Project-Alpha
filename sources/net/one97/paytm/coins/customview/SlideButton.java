package net.one97.paytm.coins.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.vipcashback.R;

public class SlideButton extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f16742a;

    /* renamed from: b  reason: collision with root package name */
    LottieAnimationView f16743b;

    /* renamed from: c  reason: collision with root package name */
    SlideBar f16744c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f16745d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f16746e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f16747f;

    /* renamed from: g  reason: collision with root package name */
    private int f16748g;

    public interface a {
    }

    public interface b {
        void a();
    }

    public SlideButton(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public SlideButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public SlideButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public SlideButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(attributeSet);
    }

    private int b() {
        return (int) (getContext().getResources().getDisplayMetrics().density * 16.0f);
    }

    private void a(AttributeSet attributeSet) {
        View inflate = inflate(getContext(), R.layout.point_sliding_layout, (ViewGroup) null);
        addView(inflate);
        this.f16748g = b();
        this.f16745d = (TextView) inflate.findViewById(R.id.tv_amount);
        this.f16743b = (LottieAnimationView) inflate.findViewById(R.id.loader);
        this.f16742a = (LinearLayout) findViewById(R.id.layout);
        this.f16744c = new SlideBar(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.f16744c.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f16744c.setSplitTrack(false);
        }
        inflate.setLayoutParams(layoutParams);
        this.f16744c.setProgressDrawable(androidx.core.content.b.a(getContext(), R.drawable.back_slide_layer));
        this.f16745d.setGravity(17);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.slider_button, 0, 0);
            setThumb(androidx.core.content.b.a(getContext(), R.drawable.ic_swipe_points_icon));
            setBackground(androidx.core.content.b.a(getContext(), R.drawable.back_slide_button));
            obtainStyledAttributes.recycle();
        }
        setThumbOffset(this.f16748g);
        addView(this.f16744c);
    }

    public TextView getAmountTexView() {
        return this.f16745d;
    }

    public void setText(int i2) {
        this.f16745d.setText(i2);
    }

    public void setText(CharSequence charSequence) {
        this.f16745d.setText(charSequence);
    }

    public void setThumb(Drawable drawable) {
        this.f16744c.setThumb(drawable);
    }

    public void setThumbOffset(int i2) {
        this.f16744c.setThumbOffset(i2);
    }

    public void setOnSlideChangeListener(a aVar) {
        this.f16747f = aVar;
    }

    public final void a() {
        this.f16743b.setVisibility(8);
        this.f16744c.setEnabled(true);
        this.f16742a.setVisibility(0);
        this.f16744c.setVisibility(0);
        net.one97.paytm.common.widgets.a.b(this.f16743b);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f16744c.setEnabled(z);
        this.f16745d.setEnabled(z);
        int i2 = 0;
        if (!z) {
            i2 = androidx.core.content.b.c(getContext(), R.color.disabled_filter);
            this.f16745d.setVisibility(8);
        } else {
            this.f16745d.setVisibility(0);
        }
        this.f16744c.getThumb().setColorFilter(i2, PorterDuff.Mode.XOR);
    }

    protected class SlideBar extends AppCompatSeekBar {

        /* renamed from: b  reason: collision with root package name */
        private Drawable f16750b;

        /* renamed from: c  reason: collision with root package name */
        private SeekBar.OnSeekBarChangeListener f16751c = new SeekBar.OnSeekBarChangeListener() {
            public final void onStartTrackingTouch(SeekBar seekBar) {
            }

            public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                SlideBar slideBar = SlideBar.this;
                slideBar.getMax();
                SlideBar.a(slideBar);
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
                SlideBar.this.setProgress(0);
            }
        };

        public SlideBar(Context context) {
            super(context);
            setMax(100);
            setOnSeekBarChangeListener(this.f16751c);
        }

        public void setThumb(Drawable drawable) {
            super.setThumb(drawable);
            this.f16750b = drawable;
        }

        public Drawable getThumb() {
            return this.f16750b;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                if (!this.f16750b.getBounds().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
                super.onTouchEvent(motionEvent);
            } else if (motionEvent.getAction() == 1) {
                if (getProgress() > 90 && SlideButton.this.f16746e != null) {
                    SlideButton slideButton = SlideButton.this;
                    if (slideButton.f16743b.getVisibility() != 0) {
                        slideButton.f16743b.setVisibility(0);
                        slideButton.f16742a.setVisibility(8);
                        net.one97.paytm.common.widgets.a.a(slideButton.f16743b);
                        slideButton.f16744c.setVisibility(8);
                    }
                    slideButton.f16744c.setEnabled(false);
                    SlideButton.this.f16746e.a();
                }
                setProgress(0);
            } else {
                super.onTouchEvent(motionEvent);
            }
            return true;
        }

        static /* synthetic */ void a(SlideBar slideBar) {
            if (SlideButton.this.f16747f != null) {
                a unused = SlideButton.this.f16747f;
            }
        }
    }

    public void setSlideButtonListener(b bVar) {
        this.f16746e = bVar;
    }
}
