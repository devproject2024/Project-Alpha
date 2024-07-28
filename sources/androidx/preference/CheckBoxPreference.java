package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.core.content.b.g;

public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: c  reason: collision with root package name */
    private final a f30761c;

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private CheckBoxPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        this.f30761c = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckBoxPreference, i2, 0);
        c(g.b(obtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOn, R.styleable.CheckBoxPreference_android_summaryOn));
        d((CharSequence) g.b(obtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOff, R.styleable.CheckBoxPreference_android_summaryOff));
        this.f30829b = g.a(obtainStyledAttributes, R.styleable.CheckBoxPreference_disableDependentsState, R.styleable.CheckBoxPreference_android_disableDependentsState, false);
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.checkBoxPreferenceStyle, 16842895));
    }

    public final void a(k kVar) {
        super.a(kVar);
        c(kVar.a(16908289));
        b(kVar);
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        super.a(view);
        if (((AccessibilityManager) this.j.getSystemService("accessibility")).isEnabled()) {
            c(view.findViewById(16908289));
            b(view.findViewById(16908304));
        }
    }

    private void c(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f30828a);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f30761c);
        }
    }

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CheckBoxPreference checkBoxPreference = CheckBoxPreference.this;
            Boolean.valueOf(z);
            if (!checkBoxPreference.l()) {
                compoundButton.setChecked(!z);
            } else {
                CheckBoxPreference.this.d(z);
            }
        }
    }
}
