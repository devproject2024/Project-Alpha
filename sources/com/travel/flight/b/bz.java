package com.travel.flight.b;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.Card;
import com.travel.flight.pojo.Info;
import java.util.List;

public final class bz extends by {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f23767e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f23768f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f23769g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f23770h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f23771i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23768f = sparseIntArray;
        sparseIntArray.put(R.id.separator, 5);
    }

    public bz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f23767e, f23768f));
    }

    private bz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[5], objArr[1]);
        this.j = -1;
        this.f23769g = objArr[0];
        this.f23769g.setTag((Object) null);
        this.f23770h = objArr[2];
        this.f23770h.setTag((Object) null);
        this.f23771i = objArr[3];
        this.f23771i.setTag((Object) null);
        this.f23763a.setTag((Object) null);
        this.f23765c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 2;
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
        if (a.S != i2) {
            return false;
        }
        a((Card) obj);
        return true;
    }

    public final void a(Card card) {
        this.f23766d = card;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(a.S);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        List<Info> list;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        Card card = this.f23766d;
        String str3 = null;
        int i2 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        if (i2 == 0 || card == null) {
            list = null;
            str2 = null;
            str = null;
        } else {
            str3 = card.getSource();
            list = card.getInfo();
            String icon = card.getIcon();
            str2 = card.getAmount();
            str = icon;
        }
        if (i2 != 0) {
            d.a(this.f23770h, (CharSequence) str3);
            com.travel.flight.utils.a.a(this.f23771i, str2);
            com.travel.flight.utils.a.a(this.f23763a, list);
            ClickableRVChildViewHolder.setImageUrl(this.f23765c, str, 0, false, false, 0, (Context) null);
        }
    }
}
