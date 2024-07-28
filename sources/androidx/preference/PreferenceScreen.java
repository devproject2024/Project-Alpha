package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.b.g;

public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: d  reason: collision with root package name */
    boolean f30805d = true;

    /* access modifiers changed from: protected */
    public final boolean o() {
        return false;
    }

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, g.a(context, R.attr.preferenceScreenStyle, 16842891));
    }

    /* access modifiers changed from: protected */
    public final void a() {
        if (!(this.q == null && this.r == null && g() != 0)) {
        }
    }
}
