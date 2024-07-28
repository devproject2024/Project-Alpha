package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.a.h;
import androidx.navigation.common.R;
import androidx.navigation.k;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class m extends k implements Iterable<k> {

    /* renamed from: a  reason: collision with root package name */
    final h<k> f3929a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    int f3930b;

    /* renamed from: i  reason: collision with root package name */
    String f3931i;

    public m(s<? extends m> sVar) {
        super((s<? extends k>) sVar);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        super.a(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NavGraphNavigator);
        b(obtainAttributes.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
        this.f3931i = a(context, this.f3930b);
        obtainAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public final k.a a(Uri uri) {
        k.a a2 = super.a(uri);
        Iterator<k> it2 = iterator();
        while (it2.hasNext()) {
            k.a a3 = it2.next().a(uri);
            if (a3 != null && (a2 == null || a3.compareTo(a2) > 0)) {
                a2 = a3;
            }
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final k a(int i2, boolean z) {
        boolean z2 = z;
        m mVar = this;
        while (true) {
            k a2 = mVar.f3929a.a(i2, null);
            if (a2 != null) {
                return a2;
            }
            if (!z2 || mVar.f3920d == null) {
                return null;
            }
            mVar = mVar.f3920d;
            z2 = true;
        }
        return null;
    }

    public final Iterator<k> iterator() {
        return new Iterator<k>() {

            /* renamed from: b  reason: collision with root package name */
            private int f3933b = -1;

            /* renamed from: c  reason: collision with root package name */
            private boolean f3934c = false;

            public final boolean hasNext() {
                return this.f3933b + 1 < m.this.f3929a.b();
            }

            public final void remove() {
                if (this.f3934c) {
                    m.this.f3929a.c(this.f3933b).f3920d = null;
                    h<k> hVar = m.this.f3929a;
                    int i2 = this.f3933b;
                    if (hVar.f963c[i2] != h.f961a) {
                        hVar.f963c[i2] = h.f961a;
                        hVar.f962b = true;
                    }
                    this.f3933b--;
                    this.f3934c = false;
                    return;
                }
                throw new IllegalStateException("You must call next() before you can remove an element");
            }

            public final /* synthetic */ Object next() {
                if (hasNext()) {
                    this.f3934c = true;
                    h<k> hVar = m.this.f3929a;
                    int i2 = this.f3933b + 1;
                    this.f3933b = i2;
                    return hVar.c(i2);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public final void b(int i2) {
        this.f3930b = i2;
        this.f3931i = null;
    }

    public final void a(k kVar) {
        if (kVar.f3921e != 0) {
            k a2 = this.f3929a.a(kVar.f3921e, null);
            if (a2 != kVar) {
                if (kVar.f3920d == null) {
                    if (a2 != null) {
                        a2.f3920d = null;
                    }
                    kVar.f3920d = this;
                    this.f3929a.b(kVar.f3921e, kVar);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            return;
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        return this.f3921e != 0 ? super.c() : "the root navigation";
    }
}
