package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;

public final class af extends ae implements a.C0556a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = null;
    private final ConstraintLayout l;
    private final ImageView m;
    private final View.OnClickListener n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public af(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, j, k));
    }

    private af(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[4], objArr[3], objArr[5], objArr[1]);
        this.o = -1;
        this.f33820a.setTag((Object) null);
        this.f33821b.setTag((Object) null);
        this.f33822c.setTag((Object) null);
        this.f33823d.setTag((Object) null);
        this.f33824e.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.m = objArr[2];
        this.m.setTag((Object) null);
        setRootTag(view);
        this.n = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.t == i2) {
            this.f33828i = (Boolean) obj;
            synchronized (this) {
                this.o |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.t);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33778e == i2) {
            this.f33826g = (Integer) obj;
            synchronized (this) {
                this.o |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33778e);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g == i2) {
            this.f33825f = (FeedGeneric) obj;
            synchronized (this) {
                this.o |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b != i2) {
            return false;
        } else {
            this.f33827h = (net.one97.paytm.feed.ui.feed.a) obj;
            synchronized (this) {
                this.o |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        int i4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.o;
            this.o = 0;
        }
        Boolean bool = this.f33828i;
        FeedGeneric feedGeneric = this.f33825f;
        int i5 = 4;
        int i6 = 0;
        int i7 = ((j2 & 17) > 0 ? 1 : ((j2 & 17) == 0 ? 0 : -1));
        if (i7 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i7 != 0) {
                if (safeUnbox) {
                    j4 = j2 | 256;
                    j3 = 4096;
                } else {
                    j4 = j2 | 128;
                    j3 = 2048;
                }
                j2 = j4 | j3;
            }
            i2 = safeUnbox ? 0 : 4;
            i3 = safeUnbox ? 4 : 0;
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i8 = ((j2 & 20) > 0 ? 1 : ((j2 & 20) == 0 ? 0 : -1));
        if (i8 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                str9 = feedGenericData.getImageUrl();
                str8 = feedGenericData.getCtaImageUrl();
                str7 = feedGenericData.getCtaDisplayText();
                str6 = feedGenericData.getDescription();
                str10 = feedGenericData.getTitle();
            } else {
                str10 = null;
                str9 = null;
                str8 = null;
                str7 = null;
                str6 = null;
            }
            boolean z = true;
            boolean z2 = str8 == null;
            if (str7 != null) {
                z = false;
            }
            if (i8 != 0) {
                j2 |= z2 ? 64 : 32;
            }
            if ((j2 & 20) != 0) {
                j2 |= z ? 1024 : 512;
            }
            if (!z2) {
                i5 = 0;
            }
            if (z) {
                i6 = 8;
            }
            i4 = i5;
            str = str9;
            str4 = str8;
            str3 = str6;
            str2 = str10;
            str5 = str7;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i4 = 0;
        }
        if ((20 & j2) != 0) {
            d.a(this.f33820a, (CharSequence) str5);
            this.f33820a.setVisibility(i6);
            d.a(this.f33821b, (CharSequence) str3);
            d.a(this.f33822c, (CharSequence) str2);
            this.f33823d.setVisibility(i4);
            net.one97.paytm.feed.utility.a.a(this.f33823d, str4, (String) null, (String) null);
            String str11 = str;
            net.one97.paytm.feed.utility.a.a(this.f33824e, str11, (String) null, (String) null);
            net.one97.paytm.feed.utility.a.a(this.m, str11, (String) null, (String) null);
        }
        if ((17 & j2) != 0) {
            this.f33824e.setVisibility(i2);
            this.m.setVisibility(i3);
        }
        if ((j2 & 16) != 0) {
            this.l.setOnClickListener(this.n);
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.a aVar = this.f33827h;
        Integer num = this.f33826g;
        FeedGeneric feedGeneric = this.f33825f;
        if (aVar != null) {
            net.one97.paytm.feed.ui.feed.a.a(view, feedGeneric, num.intValue());
        }
    }
}
