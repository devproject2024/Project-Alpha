package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.b.g;

public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: c  reason: collision with root package name */
    private final a f30824c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f30825d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f30826e;

    private SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        this.f30824c = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreferenceCompat, i2, 0);
        c(g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOn, R.styleable.SwitchPreferenceCompat_android_summaryOn));
        d((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOff, R.styleable.SwitchPreferenceCompat_android_summaryOff));
        this.f30825d = g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOn, R.styleable.SwitchPreferenceCompat_android_switchTextOn);
        b();
        this.f30826e = g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOff, R.styleable.SwitchPreferenceCompat_android_switchTextOff);
        b();
        this.f30829b = g.a(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_disableDependentsState, R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false);
        obtainStyledAttributes.recycle();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }

    public final void a(k kVar) {
        super.a(kVar);
        c(kVar.a(R.id.switchWidget));
        b(kVar);
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        super.a(view);
        if (((AccessibilityManager) this.j.getSystemService("accessibility")).isEnabled()) {
            c(view.findViewById(R.id.switchWidget));
            b(view.findViewById(16908304));
        }
    }

    private void c(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f30828a);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f30825d);
            switchCompat.setTextOff(this.f30826e);
            switchCompat.setOnCheckedChangeListener(this.f30824c);
        }
    }

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SwitchPreferenceCompat switchPreferenceCompat = SwitchPreferenceCompat.this;
            Boolean.valueOf(z);
            if (!switchPreferenceCompat.l()) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreferenceCompat.this.d(z);
            }
        }
    }
}
