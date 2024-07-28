package net.one97.paytm.upi.util;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public abstract class UpiSimpleTransformation implements ViewPager.f {
    /* access modifiers changed from: protected */
    public boolean hideOffscreenPages() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isPagingEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPostTransform(View view, float f2) {
    }

    /* access modifiers changed from: protected */
    public abstract void onTransform(View view, float f2);

    public void transformPage(View view, float f2) {
        onPreTransform(view, f2);
        onTransform(view, f2);
        onPostTransform(view, f2);
    }

    /* access modifiers changed from: protected */
    public void onPreTransform(View view, float f2) {
        float width = (float) view.getWidth();
        float f3 = 0.0f;
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(isPagingEnabled() ? 0.0f : (-width) * f2);
        if (hideOffscreenPages()) {
            if (f2 > -1.0f && f2 < 1.0f) {
                f3 = 1.0f;
            }
            view.setAlpha(f3);
            return;
        }
        view.setAlpha(1.0f);
    }

    public static class RotateDownTransformer extends UpiSimpleTransformation {
        private static final float ROT_MOD = -15.0f;

        /* access modifiers changed from: protected */
        public boolean isPagingEnabled() {
            return true;
        }

        /* access modifiers changed from: protected */
        public void onTransform(View view, float f2) {
            view.setPivotX(((float) view.getWidth()) * 0.5f);
            view.setPivotY((float) view.getHeight());
            view.setRotation(f2 * ROT_MOD * -1.25f);
        }
    }
}
