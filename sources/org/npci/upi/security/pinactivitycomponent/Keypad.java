package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.content.b;

public class Keypad extends TableLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f72915a;

    /* renamed from: b  reason: collision with root package name */
    private int f72916b;

    /* renamed from: c  reason: collision with root package name */
    private int f72917c;

    /* renamed from: d  reason: collision with root package name */
    private float f72918d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ac f72919e;

    public Keypad(Context context) {
        this(context, (AttributeSet) null);
    }

    public Keypad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f72915a = 61;
        a(attributeSet);
        a();
    }

    private int a(float f2) {
        return (int) (f2 * ((float) (getResources().getDisplayMetrics().densityDpi / 160)));
    }

    private void a() {
        setBackgroundColor(this.f72916b);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(-1, 0, 1.0f);
        int i2 = 0;
        int i3 = 1;
        while (i2 < 3) {
            TableRow tableRow = new TableRow(getContext());
            tableRow.setLayoutParams(layoutParams);
            tableRow.setWeightSum(3.0f);
            int i4 = i3;
            for (int i5 = 0; i5 < 3; i5++) {
                TextView textView = new TextView(getContext());
                textView.setGravity(17);
                textView.setLayoutParams(getItemParams());
                textView.setTextColor(this.f72917c);
                textView.setTextSize(2, this.f72918d);
                textView.setText(String.valueOf(i4));
                textView.setClickable(true);
                setClickFeedback(textView);
                textView.setOnClickListener(new y(this, i4));
                tableRow.addView(textView);
                i4++;
            }
            addView(tableRow);
            i2++;
            i3 = i4;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ic_action_backspace);
        imageView.setLayoutParams(getItemParams());
        imageView.setClickable(true);
        setClickFeedback(imageView);
        imageView.setOnClickListener(new z(this));
        TextView textView2 = new TextView(getContext());
        textView2.setLayoutParams(getItemParams());
        textView2.setGravity(17);
        textView2.setText("0");
        textView2.setTextColor(this.f72917c);
        textView2.setTextSize(2, this.f72918d);
        textView2.setClickable(true);
        setClickFeedback(textView2);
        textView2.setOnClickListener(new aa(this));
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.ic_action_submit);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView2.setAdjustViewBounds(true);
        TableRow.LayoutParams itemParams = getItemParams();
        itemParams.height = (int) (((float) a((float) this.f72915a)) * 1.25f);
        imageView2.setLayoutParams(itemParams);
        imageView2.setClickable(true);
        setClickFeedback(imageView2);
        imageView2.setOnClickListener(new ab(this));
        TableRow tableRow2 = new TableRow(getContext());
        tableRow2.setLayoutParams(layoutParams);
        tableRow2.setWeightSum(3.0f);
        tableRow2.addView(imageView);
        tableRow2.addView(textView2);
        tableRow2.addView(imageView2);
        addView(tableRow2);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Keypad, 0, 0);
        this.f72916b = obtainStyledAttributes.getColor(R.styleable.Keypad_keypad_bg_color, b.c(getContext(), R.color.npci_keypad_bg_color));
        this.f72917c = obtainStyledAttributes.getColor(R.styleable.Keypad_key_digit_color, b.c(getContext(), R.color.npci_key_digit_color));
        this.f72918d = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.Keypad_key_digit_size, 36);
        this.f72915a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Keypad_key_digit_height, this.f72915a);
        obtainStyledAttributes.recycle();
    }

    private TableRow.LayoutParams getItemParams() {
        return new TableRow.LayoutParams(0, a((float) this.f72915a), 1.0f);
    }

    private void setClickFeedback(View view) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        view.setBackgroundResource(typedValue.resourceId);
    }

    public void setOnKeyPressCallback(ac acVar) {
        this.f72919e = acVar;
    }
}
