package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class z extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1837a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<z>> f1838b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f1839c;

    /* renamed from: d  reason: collision with root package name */
    private final Resources.Theme f1840d;

    private z(Context context) {
        super(context);
        if (ah.a()) {
            this.f1839c = new ah(this, context.getResources());
            this.f1840d = this.f1839c.newTheme();
            this.f1840d.setTo(context.getTheme());
            return;
        }
        this.f1839c = new ab(this, context.getResources());
        this.f1840d = null;
    }

    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f1840d;
        return theme == null ? super.getTheme() : theme;
    }

    public final void setTheme(int i2) {
        Resources.Theme theme = this.f1840d;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }

    public final Resources getResources() {
        return this.f1839c;
    }

    public final AssetManager getAssets() {
        return this.f1839c.getAssets();
    }

    public static Context a(Context context) {
        boolean z = false;
        if (!(context instanceof z) && !(context.getResources() instanceof ab) && !(context.getResources() instanceof ah) && (Build.VERSION.SDK_INT < 21 || ah.a())) {
            z = true;
        }
        if (!z) {
            return context;
        }
        synchronized (f1837a) {
            if (f1838b == null) {
                f1838b = new ArrayList<>();
            } else {
                for (int size = f1838b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1838b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1838b.remove(size);
                    }
                }
                for (int size2 = f1838b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1838b.get(size2);
                    z zVar = weakReference2 != null ? (z) weakReference2.get() : null;
                    if (zVar != null && zVar.getBaseContext() == context) {
                        return zVar;
                    }
                }
            }
            z zVar2 = new z(context);
            f1838b.add(new WeakReference(zVar2));
            return zVar2;
        }
    }
}
