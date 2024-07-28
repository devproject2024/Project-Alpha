package com.travel.train.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.travel.train.R;

public class EditView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f28340a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f28341b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f28342c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28343d;

    /* renamed from: e  reason: collision with root package name */
    private String f28344e = "EditView";

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
        this.f28340a = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        this.f28340a.setBackgroundColor(-12303292);
        this.f28341b = new TextView(context);
        this.f28341b.setTextSize(2, 15.0f);
        setEditText("Edit");
        this.f28341b.setTextColor(getResources().getColor(R.color.paytm_blue));
        b.c(this.f28341b);
        this.f28341b.setGravity(17);
        this.f28340a.addView(this.f28341b, new RelativeLayout.LayoutParams(-2, -2));
        addView(this.f28340a, layoutParams);
        this.f28340a.setClickable(true);
        this.f28340a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditView.this.f28342c.onEditViewClick(view);
            }
        });
    }

    public void setMainLayoutParams(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f28340a.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        ((RelativeLayout.LayoutParams) this.f28341b.getLayoutParams()).addRule(13);
    }

    public void setMainLayoutPadding(int i2, int i3, int i4, int i5) {
        this.f28340a.setPadding(i2, i3, i4, i5);
    }

    public void setEditTextMargin(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f28341b.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
    }

    public void setMainLayoutBackground(int i2) {
        this.f28340a.setBackgroundResource(i2);
    }

    public void setEditTextBackground(int i2) {
        this.f28341b.setBackgroundResource(i2);
    }

    public void setEditTextColor(int i2) {
        this.f28341b.setTextColor(i2);
    }

    public void setEditText(String str) {
        if (str != null) {
            this.f28341b.setVisibility(0);
            this.f28341b.setText(str);
            return;
        }
        this.f28341b.setVisibility(8);
    }

    public void setClickable(boolean z) {
        if (!this.f28343d) {
            this.f28340a.setClickable(z);
        }
    }

    public String getEditText() {
        return this.f28341b.getText().toString();
    }

    public void setTextSize(float f2) {
        this.f28341b.setTextSize(f2);
    }

    public void setEditTextVisibility(int i2) {
        this.f28341b.setVisibility(i2);
    }

    public void setOnEditViewClickListener(a aVar) {
        this.f28342c = aVar;
    }
}
