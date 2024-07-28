package net.one97.travelpass.b;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.travelpass.R;
import net.one97.travelpass.c.a.a;
import net.one97.travelpass.model.BookingDetailsResponse;
import net.one97.travelpass.ui.a.b;

public final class r extends q implements a.C0511a {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m;
    private final View.OnClickListener n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.guid_line, 4);
        m.put(R.id.seperator_view, 5);
        m.put(R.id.dot_view, 6);
        m.put(R.id.next_arrow, 7);
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, l, m));
    }

    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[4], objArr[7], objArr[2], objArr[3], objArr[1], objArr[0], objArr[5]);
        this.o = -1;
        this.f30275d.setTag((Object) null);
        this.f30276e.setTag((Object) null);
        this.f30277f.setTag((Object) null);
        this.f30278g.setTag((Object) null);
        setRootTag(view);
        this.n = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 8;
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
        if (net.one97.travelpass.a.f30029b == i2) {
            a((BookingDetailsResponse.BookingItems) obj);
        } else if (net.one97.travelpass.a.f30030c == i2) {
            a((Integer) obj);
        } else if (net.one97.travelpass.a.f30032e != i2) {
            return false;
        } else {
            a((b.a) obj);
        }
        return true;
    }

    public final void a(BookingDetailsResponse.BookingItems bookingItems) {
        this.f30280i = bookingItems;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(net.one97.travelpass.a.f30029b);
        super.requestRebind();
    }

    public final void a(Integer num) {
        this.j = num;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(net.one97.travelpass.a.f30030c);
        super.requestRebind();
    }

    public final void a(b.a aVar) {
        this.k = aVar;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(net.one97.travelpass.a.f30032e);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.o;
            this.o = 0;
        }
        BookingDetailsResponse.BookingItems bookingItems = this.f30280i;
        Integer num = this.j;
        boolean z = true;
        int i3 = 0;
        String str5 = null;
        if ((j & 9) != 0) {
            if (bookingItems != null) {
                str5 = bookingItems.getJourneyDetails();
                str3 = bookingItems.getJourneyStatusColor();
                str = bookingItems.getJourneyStatus();
                str4 = bookingItems.getOrderId();
            } else {
                str4 = null;
                str3 = null;
                str = null;
            }
            i2 = Color.parseColor(str3);
            str2 = this.f30275d.getResources().getString(R.string.redemption_order_id, new Object[]{str4});
        } else {
            str2 = null;
            str = null;
            i2 = 0;
        }
        int i4 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (ViewDataBinding.safeUnbox(num) % 2 != 0) {
                z = false;
            }
            if (i4 != 0) {
                j |= z ? 32 : 16;
            }
            i3 = getColorFromResource(this.f30278g, z ? R.color.color_F5F8FA : R.color.white);
        }
        if ((9 & j) != 0) {
            d.a(this.f30275d, (CharSequence) str2);
            d.a(this.f30276e, (CharSequence) str);
            this.f30276e.setTextColor(i2);
            d.a(this.f30277f, (CharSequence) str5);
        }
        if ((j & 10) != 0) {
            androidx.databinding.a.e.a((View) this.f30278g, (Drawable) androidx.databinding.a.b.a(i3));
        }
        if ((j & 8) != 0) {
            this.f30278g.setOnClickListener(this.n);
        }
    }

    public final void a() {
        BookingDetailsResponse.BookingItems bookingItems = this.f30280i;
        Integer num = this.j;
        b.a aVar = this.k;
        if (aVar != null) {
            num.intValue();
            aVar.a(bookingItems);
        }
    }
}
