package com.paytm.android.chat.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.AppUtilKt;

public class CharPortraitView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private Context f42034a;

    /* renamed from: b  reason: collision with root package name */
    private String f42035b;

    private static boolean a(char c2) {
        if (c2 == 0 || c2 == 9 || c2 == 10 || c2 == 13) {
            return false;
        }
        if (c2 >= ' ' && c2 <= ')') {
            return false;
        }
        if (c2 >= '*' && c2 <= ':') {
            return false;
        }
        if (c2 >= '@' && c2 <= 168) {
            return false;
        }
        if (c2 >= 175 && c2 <= 8251) {
            return false;
        }
        if (c2 >= 8253 && c2 <= 8264) {
            return false;
        }
        if (c2 >= 8272 && c2 <= 8418) {
            return false;
        }
        if (c2 >= 8420 && c2 <= 8448) {
            return false;
        }
        if (c2 >= 8623 && c2 <= 8960) {
            return false;
        }
        if (c2 >= 9215 && c2 <= 9409) {
            return false;
        }
        if (c2 >= 9411 && c2 <= 9472) {
            return false;
        }
        if (c2 >= 10240 && c2 <= 10547) {
            return false;
        }
        if (c2 >= 10550 && c2 <= 11007) {
            return false;
        }
        if (c2 >= 11264 && c2 <= 12329) {
            return false;
        }
        if (c2 >= 12337 && c2 <= 12348) {
            return false;
        }
        if (c2 >= 12350 && c2 <= 12950) {
            return false;
        }
        if (c2 >= 12960 && c2 <= 55295) {
            return false;
        }
        if (c2 >= 57344 && c2 <= 65038) {
            return false;
        }
        if (c2 < 65040 || c2 > 65533) {
            return c2 < 0 || c2 > 65535;
        }
        return false;
    }

    public CharPortraitView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CharPortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42034a = context;
        this.f42034a.obtainStyledAttributes(attributeSet, R.styleable.CharPortraitView).recycle();
        setTextColor(this.f42034a.getResources().getColor(R.color.white));
        a();
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int min = Math.min(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        setMeasuredDimension(min, min);
    }

    private void a() {
        String str = this.f42035b;
        if (str == null || "".equals(str)) {
            this.f42035b = "1";
        }
        String substring = this.f42035b.substring(0, 1);
        int hashCode = this.f42035b.hashCode();
        if (hashCode < 0) {
            hashCode = 1;
        }
        int a2 = a(hashCode % 10);
        setGravity(17);
        setBackgroundResource(R.drawable.chat_shape_drawable);
        GradientDrawable gradientDrawable = (GradientDrawable) getBackground();
        setBackgroundDrawable(gradientDrawable);
        setText(this.f42035b.substring(0, 1).toUpperCase());
        gradientDrawable.setColor(a2);
        if ((b(substring) || AppUtilKt.isNumber(substring) || AppUtilKt.isSpecialSymbols(substring)) && Build.VERSION.SDK_INT >= 23) {
            setBackgroundDrawable((Drawable) null);
            setBackgroundResource(0);
            setBackgroundResource(R.drawable.chat_shape_default_avatar);
            LayerDrawable layerDrawable = (LayerDrawable) getBackground();
            layerDrawable.setDrawable(0, gradientDrawable);
            if (layerDrawable.getNumberOfLayers() == 2) {
                layerDrawable.setLayerGravity(1, 17);
            }
            setText("");
            setBackgroundDrawable(layerDrawable);
        }
    }

    public final CharPortraitView a(String str) {
        this.f42035b = str;
        a();
        return this;
    }

    private int a(int i2) {
        return Color.parseColor(this.f42034a.getResources().getStringArray(R.array.chat_module_color)[i2]);
    }

    private static boolean b(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return a(str.charAt(0));
    }
}
