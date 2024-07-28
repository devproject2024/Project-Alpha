package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.content.b.g;

public class SwitchPreference extends TwoStatePreference {

    /* renamed from: c  reason: collision with root package name */
    private final a f30820c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f30821d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f30822e;

    private SwitchPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        this.f30820c = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, i2, 0);
        c(g.b(obtainStyledAttributes, R.styleable.SwitchPreference_summaryOn, R.styleable.SwitchPreference_android_summaryOn));
        d((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreference_summaryOff, R.styleable.SwitchPreference_android_summaryOff));
        this.f30821d = g.b(obtainStyledAttributes, R.styleable.SwitchPreference_switchTextOn, R.styleable.SwitchPreference_android_switchTextOn);
        b();
        this.f30822e = g.b(obtainStyledAttributes, R.styleable.SwitchPreference_switchTextOff, R.styleable.SwitchPreference_android_switchTextOff);
        b();
        this.f30829b = g.a(obtainStyledAttributes, R.styleable.SwitchPreference_disableDependentsState, R.styleable.SwitchPreference_android_disableDependentsState, false);
        obtainStyledAttributes.recycle();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.switchPreferenceStyle, 16843629));
    }

    public final void a(k kVar) {
        super.a(kVar);
        c(kVar.a(16908352));
        b(kVar);
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        super.a(view);
        if (((AccessibilityManager) this.j.getSystemService("accessibility")).isEnabled()) {
            c(view.findViewById(16908352));
            b(view.findViewById(16908304));
        }
    }

    private void c(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f30828a);
        }
        if (z) {
            Switch switchR = (Switch) view;
            switchR.setTextOn(this.f30821d);
            switchR.setTextOff(this.f30822e);
            switchR.setOnCheckedChangeListener(this.f30820c);
        }
    }

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SwitchPreference switchPreference = SwitchPreference.this;
            Boolean.valueOf(z);
            if (!switchPreference.l()) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreference.this.d(z);
            }
        }
    }
}
