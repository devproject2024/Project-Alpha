package net.one97.paytm.upi.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class UpiCustomViewPagerTrasfomationView extends ViewPager implements ViewPager.f {
    public static final String TAG = UpiCustomViewPagerTrasfomationView.class.getSimpleName();
    private float MAX_SCALE;
    private boolean animationEnabled;
    private boolean fadeEnabled;
    private float fadeFactor;
    private int mPageMargin;

    public UpiCustomViewPagerTrasfomationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public UpiCustomViewPagerTrasfomationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MAX_SCALE = 0.0f;
        this.animationEnabled = true;
        this.fadeEnabled = false;
        this.fadeFactor = 0.5f;
        setClipChildren(false);
        setClipToPadding(false);
        setOverScrollMode(2);
        setPageTransformer(false, this);
        setOffscreenPageLimit(3);
        this.mPageMargin = dp2px(context.getResources(), 25);
        int i2 = this.mPageMargin;
        setPadding(i2, 15, i2, 20);
    }

    public int dp2px(Resources resources, int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, resources.getDisplayMetrics());
    }

    public void setAnimationEnabled(boolean z) {
        this.animationEnabled = z;
    }

    public void setFadeEnabled(boolean z) {
        this.fadeEnabled = z;
    }

    public void setFadeFactor(float f2) {
        this.fadeFactor = f2;
    }

    public void setPageMargin(int i2) {
        this.mPageMargin = i2;
        int i3 = this.mPageMargin;
        setPadding(i3, i3, i3, i3);
    }

    public void transformPage(View view, float f2) {
        int i2 = this.mPageMargin;
        if (i2 > 0 && this.animationEnabled) {
            view.setPadding(i2 / 3, i2 / 3, i2 / 3, i2 / 3);
            if (this.MAX_SCALE == 0.0f && f2 > 0.0f && f2 < 1.0f) {
                this.MAX_SCALE = f2;
            }
            float f3 = f2 - this.MAX_SCALE;
            float abs = Math.abs(f3);
            if (f3 <= -1.0f || f3 >= 1.0f) {
                if (this.fadeEnabled) {
                    view.setAlpha(this.fadeFactor);
                }
            } else if (f3 == 0.0f) {
                view.setScaleX(this.MAX_SCALE + 1.0f);
                view.setScaleY(this.MAX_SCALE + 1.0f);
                view.setAlpha(1.0f);
            } else {
                float f4 = 1.0f - abs;
                view.setScaleX((this.MAX_SCALE * f4) + 1.0f);
                view.setScaleY((this.MAX_SCALE * f4) + 1.0f);
                if (this.fadeEnabled) {
                    view.setAlpha(Math.max(this.fadeFactor, f4));
                }
            }
        }
    }
}
