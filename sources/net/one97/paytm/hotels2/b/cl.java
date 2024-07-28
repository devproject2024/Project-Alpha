package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import java.util.List;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PaytmImages;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PriceData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Ratings;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.upi.util.UpiConstants;

public final class cl extends ck {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private long m;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.amelitiesList, 8);
    }

    public cl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private cl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[8], objArr[0], objArr[1], objArr[3], objArr[2], objArr[6], objArr[5], objArr[7]);
        this.m = -1;
        this.f29371a.setTag((Object) null);
        this.f29373c.setTag((Object) null);
        this.f29374d.setTag((Object) null);
        this.f29375e.setTag((Object) null);
        this.f29376f.setTag((Object) null);
        this.f29377g.setTag((Object) null);
        this.f29378h.setTag((Object) null);
        this.f29379i.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.S != i2) {
            return false;
        }
        a((SRPDataItem) obj);
        return true;
    }

    public final void a(SRPDataItem sRPDataItem) {
        this.j = sRPDataItem;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(a.S);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        double d2;
        String str;
        List<String> list;
        String str2;
        String str3;
        String str4;
        PriceData priceData;
        Ratings ratings;
        PaytmImages paytmImages;
        synchronized (this) {
            j = this.m;
            this.m = 0;
        }
        SRPDataItem sRPDataItem = this.j;
        double d3 = 0.0d;
        int i2 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (sRPDataItem != null) {
                str2 = sRPDataItem.getLocality();
                paytmImages = sRPDataItem.getPaytmImages();
                list = sRPDataItem.getPromos();
                ratings = sRPDataItem.getRatings();
                priceData = sRPDataItem.getPriceData();
                str4 = sRPDataItem.getName();
            } else {
                str4 = null;
                str2 = null;
                paytmImages = null;
                list = null;
                ratings = null;
                priceData = null;
            }
            List<String> full = paytmImages != null ? paytmImages.getFull() : null;
            str = ratings != null ? ratings.getStarRating() : null;
            if (priceData != null) {
                d3 = priceData.getFinalPrice();
                d2 = priceData.getOriginalPrice();
            } else {
                d2 = 0.0d;
            }
            str3 = full != null ? full.get(0) : null;
        } else {
            d2 = 0.0d;
            str4 = null;
            str3 = null;
            str2 = null;
            list = null;
            str = null;
        }
        if (i2 != 0) {
            d.a(this.f29371a, (CharSequence) str2);
            net.one97.paytm.hotel4.utils.a.a(this.f29374d, str3, (com.paytm.utility.b.b.e) null, Integer.valueOf(UpiConstants.REQUEST_CODE_BANK_DETAIL));
            d.a(this.f29375e, (CharSequence) str4);
            net.one97.paytm.hotel4.utils.a.b(this.f29376f, str);
            net.one97.paytm.hotel4.utils.a.a(this.f29377g, d3);
            net.one97.paytm.hotel4.utils.a.a(this.f29378h, d2);
            net.one97.paytm.hotel4.utils.a.c(this.f29378h, d3);
            net.one97.paytm.hotel4.utils.a.a(this.f29379i, list);
        }
        if ((j & 2) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29378h);
        }
    }
}
