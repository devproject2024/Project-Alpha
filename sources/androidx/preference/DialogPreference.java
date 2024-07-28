package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.b.g;

public abstract class DialogPreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f30763a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f30764b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f30765c;

    /* renamed from: d  reason: collision with root package name */
    CharSequence f30766d;

    /* renamed from: e  reason: collision with root package name */
    CharSequence f30767e;

    /* renamed from: f  reason: collision with root package name */
    int f30768f;

    public interface a {
        <T extends Preference> T a();
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogPreference, i2, 0);
        this.f30763a = g.b(obtainStyledAttributes, R.styleable.DialogPreference_dialogTitle, R.styleable.DialogPreference_android_dialogTitle);
        if (this.f30763a == null) {
            this.f30763a = this.n;
        }
        this.f30764b = g.b(obtainStyledAttributes, R.styleable.DialogPreference_dialogMessage, R.styleable.DialogPreference_android_dialogMessage);
        int i3 = R.styleable.DialogPreference_dialogIcon;
        int i4 = R.styleable.DialogPreference_android_dialogIcon;
        Drawable drawable = obtainStyledAttributes.getDrawable(i3);
        this.f30765c = drawable == null ? obtainStyledAttributes.getDrawable(i4) : drawable;
        this.f30766d = g.b(obtainStyledAttributes, R.styleable.DialogPreference_positiveButtonText, R.styleable.DialogPreference_android_positiveButtonText);
        this.f30767e = g.b(obtainStyledAttributes, R.styleable.DialogPreference_negativeButtonText, R.styleable.DialogPreference_android_negativeButtonText);
        this.f30768f = g.a(obtainStyledAttributes, R.styleable.DialogPreference_dialogLayout, R.styleable.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.dialogPreferenceStyle, 16842897));
    }
}
