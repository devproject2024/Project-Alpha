package net.one97.paytm.hotels2.b;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import java.util.List;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PriceData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Ratings;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.viewmodel.SRPListItemViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class gh extends gg implements b.a {
    private static final SparseIntArray A;
    private static final ViewDataBinding.b z = null;
    private final ConstraintLayout B;
    private final TextView C;
    private final TextView D;
    private final View.OnClickListener E;
    private long F;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.recycler_header_image, 12);
        A.put(R.id.amazingDeals, 13);
        A.put(R.id.amazingDealsBackground, 14);
        A.put(R.id.dealsText, 15);
        A.put(R.id.spacer, 16);
    }

    public gh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 17, z, A));
    }

    private gh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[13], objArr[14], objArr[7], objArr[8], objArr[9], objArr[10], objArr[15], objArr[1], objArr[6], objArr[12], objArr[16], objArr[2], objArr[5], objArr[4]);
        this.F = -1;
        this.f29825c.setTag((Object) null);
        this.f29826d.setTag((Object) null);
        this.f29827e.setTag((Object) null);
        this.f29828f.setTag((Object) null);
        this.f29830h.setTag((Object) null);
        this.B = objArr[0];
        this.B.setTag((Object) null);
        this.C = objArr[11];
        this.C.setTag((Object) null);
        this.D = objArr[3];
        this.D.setTag((Object) null);
        this.f29831i.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        setRootTag(view);
        this.E = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.F = 2048;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.A == i2) {
            e((String) obj);
        } else if (a.k == i2) {
            e((Integer) obj);
        } else if (a.z == i2) {
            c((String) obj);
        } else if (a.ag == i2) {
            a((String) obj);
        } else if (a.ab == i2) {
            a((Integer) obj);
        } else if (a.K == i2) {
            d((Integer) obj);
        } else if (a.ad == i2) {
            d((String) obj);
        } else if (a.G == i2) {
            b((String) obj);
        } else if (a.V == i2) {
            b((Integer) obj);
        } else if (a.r == i2) {
            c((Integer) obj);
        } else if (a.f29088c != i2) {
            return false;
        } else {
            a((SRPListItemViewModel) obj);
        }
        return true;
    }

    public final void e(String str) {
        this.y = str;
        synchronized (this) {
            this.F |= 1;
        }
        notifyPropertyChanged(a.A);
        super.requestRebind();
    }

    public final void e(Integer num) {
        this.t = num;
        synchronized (this) {
            this.F |= 2;
        }
        notifyPropertyChanged(a.k);
        super.requestRebind();
    }

    public final void c(String str) {
        this.w = str;
        synchronized (this) {
            this.F |= 4;
        }
        notifyPropertyChanged(a.z);
        super.requestRebind();
    }

    public final void a(String str) {
        this.u = str;
        synchronized (this) {
            this.F |= 8;
        }
        notifyPropertyChanged(a.ag);
        super.requestRebind();
    }

    public final void a(Integer num) {
        this.p = num;
        synchronized (this) {
            this.F |= 16;
        }
        notifyPropertyChanged(a.ab);
        super.requestRebind();
    }

    public final void d(Integer num) {
        this.s = num;
        synchronized (this) {
            this.F |= 32;
        }
        notifyPropertyChanged(a.K);
        super.requestRebind();
    }

    public final void d(String str) {
        this.x = str;
        synchronized (this) {
            this.F |= 64;
        }
        notifyPropertyChanged(a.ad);
        super.requestRebind();
    }

    public final void b(String str) {
        this.v = str;
        synchronized (this) {
            this.F |= 128;
        }
        notifyPropertyChanged(a.G);
        super.requestRebind();
    }

    public final void b(Integer num) {
        this.q = num;
        synchronized (this) {
            this.F |= 256;
        }
        notifyPropertyChanged(a.V);
        super.requestRebind();
    }

    public final void c(Integer num) {
        this.r = num;
        synchronized (this) {
            this.F |= 512;
        }
        notifyPropertyChanged(a.r);
        super.requestRebind();
    }

    public final void a(SRPListItemViewModel sRPListItemViewModel) {
        this.o = sRPListItemViewModel;
        synchronized (this) {
            this.F |= 1024;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        int i2;
        int i3;
        int i4;
        double d2;
        double d3;
        String str;
        int i5;
        int i6;
        String str2;
        String str3;
        String str4;
        int i7;
        SRPDataItem sRPDataItem;
        PriceData priceData;
        String str5;
        Ratings ratings;
        String str6;
        List<String> list;
        double d4;
        synchronized (this) {
            j = this.F;
            this.F = 0;
        }
        String str7 = this.y;
        Integer num = this.t;
        String str8 = this.w;
        String str9 = this.u;
        Integer num2 = this.p;
        Integer num3 = this.s;
        String str10 = this.x;
        String str11 = this.v;
        Integer num4 = this.q;
        Integer num5 = this.r;
        SRPListItemViewModel sRPListItemViewModel = this.o;
        String str12 = str7;
        if ((j & 2050) != 0) {
            i2 = ViewDataBinding.safeUnbox(num);
        } else {
            i2 = 0;
        }
        int safeUnbox = (j & 2064) != 0 ? ViewDataBinding.safeUnbox(num2) : 0;
        if ((j & 2080) != 0) {
            i3 = ViewDataBinding.safeUnbox(num3);
        } else {
            i3 = 0;
        }
        int safeUnbox2 = (j & 2304) != 0 ? ViewDataBinding.safeUnbox(num4) : 0;
        int safeUnbox3 = (j & 2560) != 0 ? ViewDataBinding.safeUnbox(num5) : 0;
        double d5 = 0.0d;
        int i8 = ((j & 3072) > 0 ? 1 : ((j & 3072) == 0 ? 0 : -1));
        if (i8 != 0) {
            if (sRPListItemViewModel != null) {
                i7 = sRPListItemViewModel.isOriginalPriceVisible();
                sRPDataItem = sRPListItemViewModel.getRowSRPData();
            } else {
                sRPDataItem = null;
                i7 = 0;
            }
            if (sRPDataItem != null) {
                str6 = sRPDataItem.getName();
                ratings = sRPDataItem.getRatings();
                str5 = sRPDataItem.getLocality();
                priceData = sRPDataItem.getPriceData();
                list = sRPDataItem.getPromos();
            } else {
                list = null;
                str6 = null;
                ratings = null;
                str5 = null;
                priceData = null;
            }
            String starRating = ratings != null ? ratings.getStarRating() : null;
            if (priceData != null) {
                d5 = priceData.getFinalPrice();
                d4 = priceData.getOriginalPrice();
            } else {
                d4 = 0.0d;
            }
            int i9 = 0;
            String str13 = list != null ? (String) getFromList(list, 0) : null;
            boolean isEmpty = TextUtils.isEmpty(str13);
            if (i8 != 0) {
                j |= isEmpty ? 8192 : 4096;
            }
            if (isEmpty) {
                i9 = 4;
            }
            i5 = i9;
            i4 = i7;
            str = str6;
            d3 = d5;
            str4 = starRating;
            d2 = d4;
            i6 = i2;
            str3 = str13;
            str2 = str5;
        } else {
            i6 = i2;
            d3 = 0.0d;
            d2 = 0.0d;
            str4 = null;
            str3 = null;
            str2 = null;
            i5 = 0;
            str = null;
            i4 = 0;
        }
        if ((j & 2064) != 0) {
            this.f29825c.setVisibility(safeUnbox);
        }
        if ((2056 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29825c, str9, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j & 2304) != 0) {
            this.f29826d.setVisibility(safeUnbox2);
        }
        if ((2176 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29826d, str11, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j & 2560) != 0) {
            this.f29827e.setVisibility(safeUnbox3);
        }
        if ((2052 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29827e, str8, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j & 2080) != 0) {
            this.f29828f.setVisibility(i3);
        }
        if ((2112 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29828f, str10, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
        if ((j & 3072) != 0) {
            net.one97.paytm.hotel4.utils.a.b(this.f29830h, str4);
            d.a(this.D, (CharSequence) str2);
            d.a(this.f29831i, (CharSequence) str3);
            this.f29831i.setVisibility(i5);
            d.a(this.l, (CharSequence) str);
            net.one97.paytm.hotel4.utils.a.a(this.m, d3);
            net.one97.paytm.hotel4.utils.a.a(this.n, d2);
            this.n.setVisibility(i4);
        }
        if ((2048 & j) != 0) {
            this.B.setOnClickListener(this.E);
            net.one97.paytm.hotel4.utils.a.a(this.n);
        }
        if ((2049 & j) != 0) {
            d.a(this.C, (CharSequence) str12);
        }
        if ((j & 2050) != 0) {
            this.C.setVisibility(i6);
        }
    }

    public final void a(int i2) {
        SRPListItemViewModel sRPListItemViewModel = this.o;
        if (sRPListItemViewModel != null) {
            sRPListItemViewModel.onRecyclerItemClick();
        }
    }
}
