package net.one97.paytm.wallet.newdesign.postcard;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRPostcardFetchInitiatorList;
import net.one97.paytm.common.entity.CJRPostcardFetchRecipientList;
import net.one97.paytm.wallet.newdesign.postcard.b.b;
import net.one97.paytm.wallet.newdesign.postcard.b.d;

public final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    private Context f71156a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRPostcardFetchInitiatorList> f71157b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRPostcardFetchRecipientList> f71158c;

    /* renamed from: d  reason: collision with root package name */
    private b f71159d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.postcard.b.a f71160e;

    /* renamed from: f  reason: collision with root package name */
    private d.a f71161f;

    public final int getCount() {
        return 2;
    }

    public final CharSequence getPageTitle(int i2) {
        return i2 == 0 ? "Received" : "Sent";
    }

    public a(j jVar, Context context, ArrayList<CJRPostcardFetchInitiatorList> arrayList, ArrayList<CJRPostcardFetchRecipientList> arrayList2, d.a aVar) {
        super(jVar);
        this.f71156a = context;
        this.f71157b = arrayList;
        this.f71158c = arrayList2;
        this.f71161f = aVar;
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0) {
            b bVar = this.f71159d;
            if (bVar != null) {
                return bVar;
            }
            this.f71159d = b.a(this.f71158c, this.f71161f);
            return this.f71159d;
        } else if (i2 != 1) {
            return null;
        } else {
            net.one97.paytm.wallet.newdesign.postcard.b.a aVar = this.f71160e;
            if (aVar != null) {
                return aVar;
            }
            this.f71160e = net.one97.paytm.wallet.newdesign.postcard.b.a.a(this.f71157b, this.f71161f);
            return this.f71160e;
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((LinearLayout) obj);
    }
}
