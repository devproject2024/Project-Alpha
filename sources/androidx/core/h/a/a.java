package androidx.core.h.a;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f3037a;

    /* renamed from: b  reason: collision with root package name */
    private final c f3038b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3039c;

    public a(int i2, c cVar, int i3) {
        this.f3037a = i2;
        this.f3038b = cVar;
        this.f3039c = i3;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f3037a);
        c cVar = this.f3038b;
        int i2 = this.f3039c;
        if (Build.VERSION.SDK_INT >= 16) {
            cVar.f3041a.performAction(i2, bundle);
        }
    }
}
