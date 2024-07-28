package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class bb extends ba {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f29226g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f29227h;

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f29228i;
    private long j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29227h = sparseIntArray;
        sparseIntArray.put(R.id.divider1, 4);
        f29227h.put(R.id.rv_policy, 5);
    }

    public bb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f29226g, f29227h));
    }

    private bb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[2], objArr[5], objArr[3], objArr[1]);
        this.j = -1;
        this.f29221b.setTag((Object) null);
        this.f29228i = objArr[0];
        this.f29228i.setTag((Object) null);
        this.f29223d.setTag((Object) null);
        this.f29224e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.R != i2) {
            return false;
        }
        a((DataViewModel) obj);
        return true;
    }

    public final void a(DataViewModel dataViewModel) {
        this.f29225f = dataViewModel;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(a.R);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.j     // Catch:{ all -> 0x008b }
            r4 = 0
            r1.j = r4     // Catch:{ all -> 0x008b }
            monitor-exit(r18)     // Catch:{ all -> 0x008b }
            net.one97.paytm.hotel4.viewmodel.DataViewModel r0 = r1.f29225f
            r6 = 7
            long r8 = r2 & r6
            r10 = 6
            r12 = 0
            r13 = 0
            int r14 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x006a
            long r8 = r2 & r10
            r14 = 8
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x003d
            if (r0 == 0) goto L_0x002b
            boolean r8 = r0.getShowClose()
            java.lang.String r9 = r0.getTitle()
            goto L_0x002d
        L_0x002b:
            r9 = r12
            r8 = 0
        L_0x002d:
            if (r15 == 0) goto L_0x0037
            if (r8 == 0) goto L_0x0034
            r15 = 64
            goto L_0x0036
        L_0x0034:
            r15 = 32
        L_0x0036:
            long r2 = r2 | r15
        L_0x0037:
            if (r8 == 0) goto L_0x003a
            goto L_0x003e
        L_0x003a:
            r8 = 8
            goto L_0x003f
        L_0x003d:
            r9 = r12
        L_0x003e:
            r8 = 0
        L_0x003f:
            if (r0 == 0) goto L_0x0046
            androidx.lifecycle.y r0 = r0.getDataToShow()
            goto L_0x0047
        L_0x0046:
            r0 = r12
        L_0x0047:
            r1.updateLiveDataRegistration(r13, r0)
            if (r0 == 0) goto L_0x0053
            java.lang.Object r0 = r0.getValue()
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
        L_0x0053:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            long r15 = r2 & r6
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0065
            if (r0 == 0) goto L_0x0062
            r15 = 16
            goto L_0x0064
        L_0x0062:
            r15 = 8
        L_0x0064:
            long r2 = r2 | r15
        L_0x0065:
            if (r0 == 0) goto L_0x006c
            r13 = 8
            goto L_0x006c
        L_0x006a:
            r9 = r12
            r8 = 0
        L_0x006c:
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x007b
            android.widget.ImageView r0 = r1.f29221b
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.f29224e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x007b:
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x008a
            android.widget.TextView r0 = r1.f29223d
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
            android.widget.TextView r0 = r1.f29223d
            r0.setVisibility(r13)
        L_0x008a:
            return
        L_0x008b:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x008b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.bb.executeBindings():void");
    }
}
