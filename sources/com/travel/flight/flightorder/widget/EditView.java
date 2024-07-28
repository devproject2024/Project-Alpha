package com.travel.flight.flightorder.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.travel.flight.R;

public class EditView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f24582a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f24583b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f24584c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24585d;

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
        this.f24582a = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        this.f24582a.setBackgroundColor(-12303292);
        this.f24583b = new TextView(context);
        this.f24583b.setTextSize(2, 15.0f);
        setEditText("Edit");
        this.f24583b.setTextColor(getResources().getColor(R.color.paytm_blue_flight));
        b.c(this.f24583b);
        this.f24583b.setGravity(17);
        this.f24582a.addView(this.f24583b, new RelativeLayout.LayoutParams(-2, -2));
        addView(this.f24582a, layoutParams);
        this.f24582a.setClickable(true);
        this.f24582a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditView.this.f24584c.onEditViewClick(view);
            }
        });
    }

    public void setMainLayoutParams(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24582a.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        ((RelativeLayout.LayoutParams) this.f24583b.getLayoutParams()).addRule(13);
    }

    public void setMainLayoutPadding(int i2, int i3, int i4, int i5) {
        this.f24582a.setPadding(i2, i3, i4, i5);
    }

    public void setEditTextMargin(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24583b.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
    }

    public void setMainLayoutBackground(int i2) {
        this.f24582a.setBackgroundResource(i2);
    }

    public void setEditTextBackground(int i2) {
        this.f24583b.setBackgroundResource(i2);
    }

    public void setEditTextColor(int i2) {
        this.f24583b.setTextColor(i2);
    }

    public void setEditText(String str) {
        if (str != null) {
            this.f24583b.setVisibility(0);
            this.f24583b.setText(str);
            return;
        }
        this.f24583b.setVisibility(8);
    }

    public void setClickable(boolean z) {
        if (!this.f24585d) {
            this.f24582a.setClickable(z);
        }
    }

    public String getEditText() {
        return this.f24583b.getText().toString();
    }

    public void setTextSize(float f2) {
        this.f24583b.setTextSize(f2);
    }

    public void setEditTextVisibility(int i2) {
        this.f24583b.setVisibility(i2);
    }

    public void setOnEditViewClickListener(a aVar) {
        this.f24584c = aVar;
    }
}
