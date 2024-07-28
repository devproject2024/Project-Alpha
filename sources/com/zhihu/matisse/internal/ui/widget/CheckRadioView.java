package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b.f;
import com.paytm.android.chat.R;

public class CheckRadioView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f45853a;

    /* renamed from: b  reason: collision with root package name */
    private int f45854b;

    /* renamed from: c  reason: collision with root package name */
    private int f45855c;

    public CheckRadioView(Context context) {
        super(context);
        a();
    }

    public CheckRadioView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f45854b = f.b(getResources(), R.color.zhihu_item_checkCircle_backgroundColor, getContext().getTheme());
        this.f45855c = f.b(getResources(), R.color.zhihu_check_original_radio_disable, getContext().getTheme());
        setChecked(false);
    }

    public void setChecked(boolean z) {
        if (z) {
            setImageResource(R.drawable.chat_ic_preview_radio_on);
            this.f45853a = getDrawable();
            this.f45853a.setColorFilter(this.f45854b, PorterDuff.Mode.SRC_IN);
            return;
        }
        setImageResource(R.drawable.chat_ic_preview_radio_off);
        this.f45853a = getDrawable();
        this.f45853a.setColorFilter(this.f45855c, PorterDuff.Mode.SRC_IN);
    }

    public void setColor(int i2) {
        if (this.f45853a == null) {
            this.f45853a = getDrawable();
        }
        this.f45853a.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
    }
}
