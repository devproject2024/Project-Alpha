package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class p implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Intent> f2808a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final Context f2809b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private p(Context context) {
        this.f2809b = context;
    }

    public static p a(Context context) {
        return new p(context);
    }

    public final p a(Intent intent) {
        this.f2808a.add(intent);
        return this;
    }

    public final p b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f2809b.getPackageManager());
        }
        if (component != null) {
            a(component);
        }
        a(intent);
        return this;
    }

    public final p a(ComponentName componentName) {
        int size = this.f2808a.size();
        try {
            Intent a2 = f.a(this.f2809b, componentName);
            while (a2 != null) {
                this.f2808a.add(size, a2);
                a2 = f.a(this.f2809b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f2808a.iterator();
    }

    public final void a() {
        if (!this.f2808a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f2808a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            b.a(this.f2809b, intentArr);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
