package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotels2.a;

public final class cj extends ci {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29367e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29368f = null;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29369g;

    /* renamed from: h  reason: collision with root package name */
    private long f29370h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public cj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29367e, f29368f));
    }

    private cj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[3]);
        this.f29370h = -1;
        this.f29369g = objArr[0];
        this.f29369g.setTag((Object) null);
        this.f29363a.setTag((Object) null);
        this.f29364b.setTag((Object) null);
        this.f29365c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29370h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29370h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.x != i2) {
            return false;
        }
        a((CJRRoom) obj);
        return true;
    }

    public final void a(CJRRoom cJRRoom) {
        this.f29366d = cJRRoom;
        synchronized (this) {
            this.f29370h |= 1;
        }
        notifyPropertyChanged(a.x);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.f29370h;
            this.f29370h = 0;
        }
        CJRRoom cJRRoom = this.f29366d;
        String str3 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || cJRRoom == null) {
            str2 = null;
            str = null;
        } else {
            str3 = cJRRoom.getRoomPrice();
            str2 = cJRRoom.getRoomTitle();
            str = cJRRoom.getRoomDetails();
        }
        if (i2 != 0) {
            d.a(this.f29363a, (CharSequence) str2);
            d.a(this.f29364b, (CharSequence) str);
            d.a(this.f29365c, (CharSequence) str3);
        }
    }
}
