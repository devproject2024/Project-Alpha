package net.one97.paytm.landingpage.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import net.one97.paytm.landingpage.R;

public class SignInMenuView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f53047a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f53048b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f53049c;

    /* renamed from: d  reason: collision with root package name */
    private int f53050d;

    public interface a {
        void onSignInMenuClick(View view);
    }

    public SignInMenuView(Context context) {
        super(context);
        a(context);
    }

    public SignInMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SignInMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f53047a = new RelativeLayout(context);
        this.f53050d = (int) TypedValue.applyDimension(1, 14.0f, context.getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        this.f53048b = new TextView(context);
        this.f53048b.setTextSize(2, 18.0f);
        setEditText("Sign In");
        if (context != null) {
            this.f53048b.setTextColor(context.getResources().getColor(R.color.paytm_blue));
        } else {
            this.f53048b.setTextColor(Color.rgb(0, 183, 227));
        }
        b.c(this.f53048b);
        this.f53048b.setGravity(17);
        this.f53047a.addView(this.f53048b, new RelativeLayout.LayoutParams(-2, -2));
        addView(this.f53047a, layoutParams);
        this.f53047a.setClickable(true);
        setEditTextMargin$3b4dfe4b(this.f53050d);
        this.f53047a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignInMenuView.this.f53049c.onSignInMenuClick(view);
            }
        });
    }

    public int getTextWidth() {
        Rect rect = new Rect();
        String charSequence = this.f53048b.getText().toString();
        this.f53048b.getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return rect.width() + (this.f53050d * 2);
    }

    public void setMainLayoutParams(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53047a.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f53048b.getLayoutParams();
        layoutParams2.addRule(15);
        layoutParams2.addRule(11, -1);
    }

    public void setMainLayoutPadding(int i2, int i3, int i4, int i5) {
        this.f53047a.setPadding(i2, i3, i4, i5);
    }

    private void setEditTextMargin$3b4dfe4b(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53048b.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = 0;
    }

    public void setEditTextBackground(int i2) {
        this.f53048b.setBackgroundResource(i2);
    }

    public void setEditTextColor(int i2) {
        this.f53048b.setTextColor(i2);
    }

    public void setEditText(String str) {
        if (str != null) {
            this.f53048b.setVisibility(0);
            this.f53047a.setVisibility(0);
            this.f53048b.setText(str);
            return;
        }
        this.f53048b.setVisibility(8);
    }

    public void setClickable(boolean z) {
        this.f53047a.setClickable(z);
    }

    public String getSignInText() {
        return this.f53048b.getText().toString();
    }

    public void setSignInTextVisibility(int i2) {
        this.f53047a.setVisibility(i2);
    }

    public void setOnSignInMenuViewClickListener(a aVar) {
        this.f53049c = aVar;
    }
}
