package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class j extends i {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29895h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29896i;
    private final LinearLayout j;
    private final TextView k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29896i = sparseIntArray;
        sparseIntArray.put(R.id.iv_hotelRoomCard, 5);
        f29896i.put(R.id.iv_hotel_room_icon, 6);
        f29896i.put(R.id.iv_map, 7);
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f29895h, f29896i));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[6], objArr[7], objArr[2], objArr[3], objArr[1]);
        this.l = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.k = objArr[4];
        this.k.setTag((Object) null);
        this.f29891d.setTag((Object) null);
        this.f29892e.setTag((Object) null);
        this.f29893f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29094i != i2) {
            return false;
        }
        a((MetaData) obj);
        return true;
    }

    public final void a(MetaData metaData) {
        this.f29894g = metaData;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(a.f29094i);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        Integer num;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        MetaData metaData = this.f29894g;
        String str4 = null;
        int i2 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (metaData != null) {
                str3 = metaData.roomName;
                num = metaData.guestCount;
                str2 = metaData.mealPlan;
                str = metaData.roomBedType;
            } else {
                str3 = null;
                num = null;
                str2 = null;
                str = null;
            }
            String valueOf = String.valueOf(ViewDataBinding.safeUnbox(num));
            if (valueOf != null) {
                str4 = valueOf.concat(this.k.getResources().getString(R.string.h4_guest));
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i2 != 0) {
            d.a(this.k, (CharSequence) str4);
            d.a(this.f29891d, (CharSequence) str2);
            d.a(this.f29892e, (CharSequence) str);
            d.a(this.f29893f, (CharSequence) str3);
        }
    }
}
