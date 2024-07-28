package net.one97.paytm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import net.one97.paytm.common.widgets.R;

public class EditView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f72343a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f72344b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f72345c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f72346d;

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
        this.f72343a = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        this.f72343a.setBackgroundColor(-12303292);
        this.f72344b = new TextView(context);
        this.f72344b.setTextSize(2, 15.0f);
        setEditText("Edit");
        this.f72344b.setTextColor(getResources().getColor(R.color.paytm_blue));
        b.c(this.f72344b);
        this.f72344b.setGravity(17);
        this.f72343a.addView(this.f72344b, new RelativeLayout.LayoutParams(-2, -2));
        addView(this.f72343a, layoutParams);
        this.f72343a.setClickable(true);
        this.f72343a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditView.this.f72345c.onEditViewClick(view);
            }
        });
    }

    public void setMainLayoutParams(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f72343a.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        ((RelativeLayout.LayoutParams) this.f72344b.getLayoutParams()).addRule(13);
    }

    public void setMainLayoutPadding(int i2, int i3, int i4, int i5) {
        this.f72343a.setPadding(i2, i3, i4, i5);
    }

    public void setEditTextMargin(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f72344b.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
    }

    public void setMainLayoutBackground(int i2) {
        this.f72343a.setBackgroundResource(i2);
    }

    public void setEditTextBackground(int i2) {
        this.f72344b.setBackgroundResource(i2);
    }

    public void setEditTextColor(int i2) {
        this.f72344b.setTextColor(i2);
    }

    public void setEditText(String str) {
        if (str != null) {
            this.f72344b.setVisibility(0);
            this.f72344b.setText(str);
            return;
        }
        this.f72344b.setVisibility(8);
    }

    public void setClickable(boolean z) {
        if (!this.f72346d) {
            this.f72343a.setClickable(z);
        }
    }

    public String getEditText() {
        return this.f72344b.getText().toString();
    }

    public void setTextSize(float f2) {
        this.f72344b.setTextSize(f2);
    }

    public void setEditTextVisibility(int i2) {
        this.f72344b.setVisibility(i2);
    }

    public void setOnEditViewClickListener(a aVar) {
        this.f72345c = aVar;
    }
}
