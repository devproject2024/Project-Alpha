package net.one97.paytm.feed.b;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.e.c;
import net.one97.paytm.feed.repository.models.sheroes.FeedSheroes;
import net.one97.paytm.feed.utility.j;

public final class cd extends cc implements a.C0556a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f34034d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f34035e = null;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f34036f;

    /* renamed from: g  reason: collision with root package name */
    private long f34037g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public cd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f34034d, f34035e));
    }

    private cd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f34037g = -1;
        this.f34031a.setTag((Object) null);
        setRootTag(view);
        this.f34036f = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34037g = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34037g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f34033c = (net.one97.paytm.feed.ui.feed.sheroes.a) obj;
            synchronized (this) {
                this.f34037g |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f34032b = (FeedSheroes) obj;
            synchronized (this) {
                this.f34037g |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r9 = this;
            monitor-enter(r9)
            long r0 = r9.f34037g     // Catch:{ all -> 0x0038 }
            r2 = 0
            r9.f34037g = r2     // Catch:{ all -> 0x0038 }
            monitor-exit(r9)     // Catch:{ all -> 0x0038 }
            net.one97.paytm.feed.repository.models.sheroes.FeedSheroes r4 = r9.f34032b
            r5 = 6
            long r5 = r5 & r0
            r7 = 0
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0021
            if (r4 == 0) goto L_0x0019
            net.one97.paytm.feed.repository.models.sheroes.FeedSheroesData r4 = r4.getFeedSheroesData()
            goto L_0x001a
        L_0x0019:
            r4 = r7
        L_0x001a:
            if (r4 == 0) goto L_0x0021
            java.lang.String r4 = r4.getImageUrl()
            goto L_0x0022
        L_0x0021:
            r4 = r7
        L_0x0022:
            r5 = 4
            long r0 = r0 & r5
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0030
            android.widget.ImageView r0 = r9.f34031a
            android.view.View$OnClickListener r1 = r9.f34036f
            r0.setOnClickListener(r1)
        L_0x0030:
            if (r8 == 0) goto L_0x0037
            android.widget.ImageView r0 = r9.f34031a
            net.one97.paytm.feed.utility.a.a(r0, r4, r7, r7)
        L_0x0037:
            return
        L_0x0038:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0038 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.cd.executeBindings():void");
    }

    public final void a(int i2, View view) {
        if (this.f34033c != null) {
            k.c(view, "view");
            j jVar = j.f35397a;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            if (j.e(context)) {
                c cVar = c.f34275a;
                if (c.a(view.getContext())) {
                    b bVar = b.f34268c;
                    if (b.n()) {
                        Context context2 = view.getContext();
                        k.a((Object) context2, "view.context");
                        net.one97.paytm.feed.ui.feed.sheroes.a.a(context2);
                        return;
                    }
                    c cVar2 = c.f34275a;
                    if (p.a("Female", c.c(), true)) {
                        Context context3 = view.getContext();
                        k.a((Object) context3, "view.context");
                        net.one97.paytm.feed.ui.feed.sheroes.a.a(context3);
                        return;
                    }
                    Toast.makeText(view.getContext(), "Please try again later", 0).show();
                    return;
                }
                return;
            }
            Toast.makeText(view.getContext(), view.getContext().getString(R.string.feed_no_internet_post), 0).show();
        }
    }
}
