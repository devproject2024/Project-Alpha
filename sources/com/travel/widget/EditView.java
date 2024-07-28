package com.travel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.travel.R;

public class EditView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f28576a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f28577b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f28578c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28579d;

    public interface a {
        void onEditViewClick(View view);
    }

    public EditView(Context context) {
        super(context);
        a(context);
    }

    public EditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public EditView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f28576a = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        this.f28576a.setBackgroundColor(-12303292);
        this.f28577b = new TextView(context);
        this.f28577b.setTextSize(2, 15.0f);
        setEditText("Edit");
        this.f28577b.setTextColor(getResources().getColor(R.color.paytm_blue));
        b.c(this.f28577b);
        this.f28577b.setGravity(17);
        this.f28576a.addView(this.f28577b, new RelativeLayout.LayoutParams(-2, -2));
        addView(this.f28576a, layoutParams);
        this.f28576a.setClickable(true);
        this.f28576a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditView.this.f28578c.onEditViewClick(view);
            }
        });
    }

    public void setEditText(String str) {
        if (str != null) {
            this.f28577b.setVisibility(0);
            this.f28577b.setText(str);
            return;
        }
        this.f28577b.setVisibility(8);
    }

    public void setClickable(boolean z) {
        if (!this.f28579d) {
            this.f28576a.setClickable(z);
        }
    }

    public void setTextSize(float f2) {
        this.f28577b.setTextSize(f2);
    }
}
