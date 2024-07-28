package net.one97.paytm.recharge.b;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.recharge.a;
import net.one97.paytm.recharge.legacy.catalog.model.CJRRichMessage;

public final class d extends c {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f60320f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f60321g = null;

    /* renamed from: h  reason: collision with root package name */
    private long f60322h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f60320f, f60321g));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[0], objArr[2]);
        this.f60322h = -1;
        this.f60315a.setTag((Object) null);
        this.f60316b.setTag((Object) null);
        this.f60317c.setTag((Object) null);
        this.f60318d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60322h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f60322h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f60180a != i2) {
            return false;
        }
        a((CJRRichMessage) obj);
        return true;
    }

    public final void a(CJRRichMessage cJRRichMessage) {
        this.f60319e = cJRRichMessage;
        synchronized (this) {
            this.f60322h |= 1;
        }
        notifyPropertyChanged(a.f60180a);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.f60322h;
            this.f60322h = 0;
        }
        CJRRichMessage cJRRichMessage = this.f60319e;
        int i2 = 0;
        String str3 = null;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (cJRRichMessage != null) {
                str3 = cJRRichMessage.getSub_heading();
                str2 = cJRRichMessage.getImage();
                str = cJRRichMessage.getText();
            } else {
                str = null;
                str2 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (i3 != 0) {
                j |= isEmpty ? 8 : 4;
            }
            if (isEmpty) {
                i2 = 8;
            }
        } else {
            str = null;
        }
        if ((j & 3) != 0) {
            androidx.databinding.a.d.a(this.f60315a, (CharSequence) str);
            this.f60316b.setVisibility(i2);
            androidx.databinding.a.d.a(this.f60318d, (CharSequence) str3);
        }
    }
}
