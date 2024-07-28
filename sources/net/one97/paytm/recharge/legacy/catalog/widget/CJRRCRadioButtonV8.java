package net.one97.paytm.recharge.legacy.catalog.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import kotlin.g.b.k;

public final class CJRRCRadioButtonV8 extends RadioButton {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f62979a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Typeface f62980b;

    /* renamed from: c  reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f62981c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f62982d;

    public CJRRCRadioButtonV8(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f62979a = Typeface.create("sans-serif-medium", 0);
        this.f62980b = Typeface.create("sans-serif", 0);
        this.f62981c = new a(this);
        super.setOnCheckedChangeListener(this.f62981c);
    }

    public CJRRCRadioButtonV8(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRRCRadioButtonV8(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    static final class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRRCRadioButtonV8 f62983a;

        a(CJRRCRadioButtonV8 cJRRCRadioButtonV8) {
            this.f62983a = cJRRCRadioButtonV8;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            k.a((Object) compoundButton, "radioButton");
            CJRRCRadioButtonV8 cJRRCRadioButtonV8 = this.f62983a;
            compoundButton.setTypeface(z ? cJRRCRadioButtonV8.f62979a : cJRRCRadioButtonV8.f62980b);
            CompoundButton.OnCheckedChangeListener c2 = this.f62983a.f62982d;
            if (c2 != null) {
                c2.onCheckedChanged(compoundButton, z);
            }
        }
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f62982d = onCheckedChangeListener;
    }
}
