package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.p;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    final Context f3913a;

    /* renamed from: b  reason: collision with root package name */
    final Intent f3914b;

    /* renamed from: c  reason: collision with root package name */
    m f3915c;

    /* renamed from: d  reason: collision with root package name */
    int f3916d;

    private j(Context context) {
        Intent intent;
        this.f3913a = context;
        Context context2 = this.f3913a;
        if (context2 instanceof Activity) {
            intent = new Intent(context2, context2.getClass());
        } else {
            intent = context2.getPackageManager().getLaunchIntentForPackage(this.f3913a.getPackageName());
            if (intent == null) {
                intent = new Intent();
            }
        }
        this.f3914b = intent;
        this.f3914b.addFlags(268468224);
    }

    public final p a() {
        if (this.f3914b.getIntArrayExtra("android-support-nav:controller:deepLinkIds") != null) {
            p b2 = p.a(this.f3913a).b(new Intent(this.f3914b));
            for (int i2 = 0; i2 < b2.f2808a.size(); i2++) {
                b2.f2808a.get(i2).putExtra("android-support-nav:controller:deepLinkIntent", this.f3914b);
            }
            return b2;
        } else if (this.f3915c == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        } else {
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
    }

    j(h hVar) {
        this(hVar.f3898a);
        if (hVar.f3899b != null) {
            this.f3915c = hVar.f3899b;
            return;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }
}
