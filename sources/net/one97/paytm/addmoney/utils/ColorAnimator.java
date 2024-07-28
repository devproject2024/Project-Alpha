package net.one97.paytm.addmoney.utils;

import android.animation.TypeEvaluator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

public final class ColorAnimator {

    static class ColorEvaluator implements TypeEvaluator<Integer> {
        private ColorEvaluator() {
        }

        public Integer evaluate(float f2, Integer num, Integer num2) {
            int alpha = Color.alpha(num2.intValue());
            int alpha2 = Color.alpha(num.intValue());
            int red = Color.red(num2.intValue());
            int red2 = Color.red(num.intValue());
            int green = Color.green(num2.intValue());
            int green2 = Color.green(num.intValue());
            int blue = Color.blue(num2.intValue());
            int blue2 = Color.blue(num.intValue());
            return Integer.valueOf(Color.argb(alpha2 + ((int) (((float) (alpha - alpha2)) * f2)), red2 + ((int) (((float) (red - red2)) * f2)), green2 + ((int) (((float) (green - green2)) * f2)), blue2 + ((int) (((float) (blue - blue2)) * f2))));
        }
    }

    public static class ViewBackgroundWrapper {
        private View mView;

        public ViewBackgroundWrapper(View view) {
            this.mView = view;
        }

        public int getBackgroundColor() {
            try {
                return ((ColorDrawable) this.mView.getBackground()).getColor();
            } catch (ClassCastException unused) {
                throw new IllegalStateException(String.format("Attempt to read View background color when background isn't a ColorDrawable (is %s instead)", new Object[]{this.mView.getBackground().getClass().getSimpleName()}));
            }
        }

        public void setBackgroundColor(int i2) {
            this.mView.setBackgroundColor(i2);
        }
    }
}
