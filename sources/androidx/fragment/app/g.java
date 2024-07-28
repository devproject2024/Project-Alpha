package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.a;
import androidx.core.g.f;
import java.io.PrintWriter;

public abstract class g<E> extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f3414a;

    /* renamed from: b  reason: collision with root package name */
    final Activity f3415b;

    /* renamed from: c  reason: collision with root package name */
    final Context f3416c;

    /* renamed from: d  reason: collision with root package name */
    final Handler f3417d;

    /* renamed from: e  reason: collision with root package name */
    final j f3418e;

    public View a(int i2) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
    }

    public void a(Fragment fragment, String[] strArr, int i2) {
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    public boolean b() {
        return true;
    }

    public void d() {
    }

    public abstract E e();

    g(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler());
    }

    private g(Activity activity, Context context, Handler handler) {
        this.f3418e = new k();
        this.f3415b = activity;
        this.f3416c = (Context) f.a(context, "context == null");
        this.f3417d = (Handler) f.a(handler, "handler == null");
        this.f3414a = 0;
    }

    public LayoutInflater c() {
        return LayoutInflater.from(this.f3416c);
    }

    public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            this.f3416c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void a(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            a.a(this.f3415b, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }
}
