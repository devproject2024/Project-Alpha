package com.paytm.android.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytm.android.chat.R;
import java.util.HashMap;
import kotlin.g.b.k;

public final class PayButtonView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f42508a;

    public final View a(int i2) {
        if (this.f42508a == null) {
            this.f42508a = new HashMap();
        }
        View view = (View) this.f42508a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f42508a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayButtonView(Context context) {
        super(context);
        k.c(context, "context");
        ConstraintLayout.inflate(getContext(), R.layout.chat_view_pay_button_with_loader, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        ConstraintLayout.inflate(getContext(), R.layout.chat_view_pay_button_with_loader, this);
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayButtonView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        ConstraintLayout.inflate(getContext(), R.layout.chat_view_pay_button_with_loader, this);
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayButtonView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        k.c(context, "context");
        ConstraintLayout.inflate(getContext(), R.layout.chat_view_pay_button_with_loader, this);
        a(attributeSet);
    }

    private final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16843087});
        if (obtainStyledAttributes.length() > 0) {
            String string = obtainStyledAttributes.getString(0);
            TextView textView = (TextView) a(R.id.buttonText);
            if (textView != null) {
                textView.setText(string);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
