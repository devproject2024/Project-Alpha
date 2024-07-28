package net.one97.paytm.recharge.metro.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.common.utility.a;
import net.one97.paytm.recharge.metro.a.c;
import net.one97.paytm.recharge.metro.f.b;

public final class d extends c {

    /* renamed from: h  reason: collision with root package name */
    private int f63166h;

    /* renamed from: i  reason: collision with root package name */
    private int f63167i;
    private List<CJRActiveMetroTicketModel> j;
    private Map<Integer, Integer> k = new HashMap();

    public d(Context context, List<CJRActiveMetroTicketModel> list, String str, boolean z, String str2, boolean z2, View.OnClickListener onClickListener) {
        this.f63148a = context;
        this.f63149b = str;
        this.f63151d = onClickListener;
        this.f63152e = z2;
        this.j = list;
        this.f63153f = z;
        for (CJRActiveMetroTicketModel qrCodes : list) {
            Iterator<CJRActiveMetroTicketQRItemModel> it2 = qrCodes.getQrCodes().iterator();
            while (it2.hasNext()) {
                it2.next();
                Map<Integer, Integer> map = this.k;
                int i2 = this.f63167i;
                this.f63167i = i2 + 1;
                map.put(Integer.valueOf(i2), Integer.valueOf(this.f63166h));
            }
            this.f63166h++;
        }
        this.f63150c = a.a(AppConstants.READ_TIME_OUT, context);
        this.f63154g = str2;
    }

    public final int getCount() {
        return this.f63167i;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, View view, int i2, CJRActiveMetroTicketModel cJRActiveMetroTicketModel, b.C1228b bVar) {
        b bVar2 = new b(context, bVar);
        bVar2.f63572a = view;
        bVar2.f63573b = i2;
        bVar2.a(cJRActiveMetroTicketModel);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        if ((this.f63151d instanceof c.a) && i2 != -1) {
            try {
                ((c.a) this.f63151d).a(this.j.get(this.k.get(Integer.valueOf(i2)).intValue()));
            } catch (Exception unused) {
            }
        }
    }

    public final void a(List<CJRActiveMetroTicketModel> list) {
        this.j = list;
        this.f63167i = 0;
        this.f63166h = 0;
        this.k = new HashMap();
        for (CJRActiveMetroTicketModel qrCodes : list) {
            Iterator<CJRActiveMetroTicketQRItemModel> it2 = qrCodes.getQrCodes().iterator();
            while (it2.hasNext()) {
                it2.next();
                Map<Integer, Integer> map = this.k;
                int i2 = this.f63167i;
                this.f63167i = i2 + 1;
                map.put(Integer.valueOf(i2), Integer.valueOf(this.f63166h));
            }
            this.f63166h++;
        }
        notifyDataSetChanged();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        int intValue = this.k.get(Integer.valueOf(i2)).intValue();
        CJRActiveMetroTicketModel cJRActiveMetroTicketModel = this.j.get(intValue);
        int i3 = 0;
        for (int i4 = 0; i4 < intValue; i4++) {
            i3 += this.j.get(i4).getQrCodes().size();
        }
        androidx.core.g.d dVar = new androidx.core.g.d(cJRActiveMetroTicketModel, cJRActiveMetroTicketModel.getQrCodes().get(i2 - i3));
        return a(viewGroup, i2, (CJRActiveMetroTicketModel) dVar.f2964a, (CJRActiveMetroTicketQRItemModel) dVar.f2965b);
    }
}
