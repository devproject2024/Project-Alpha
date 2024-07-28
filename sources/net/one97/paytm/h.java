package net.one97.paytm;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating;
import net.one97.paytm.landingpage.utils.c;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    Context f52402a;

    /* renamed from: b  reason: collision with root package name */
    protected CJROrderSummarySellarRating f52403b;

    /* renamed from: c  reason: collision with root package name */
    a f52404c;

    public interface a {
        void a(CJROrderSummarySellarRating cJROrderSummarySellarRating);
    }

    public h(Context context) {
        this.f52402a = context;
    }

    public final void a(String str, CJROrderSummarySellarRating cJROrderSummarySellarRating) {
        this.f52403b = cJROrderSummarySellarRating;
        a aVar = this.f52404c;
        if (aVar != null) {
            aVar.a(this.f52403b);
        }
        if (this.f52403b != null) {
            new StringBuilder("save favorite list  ").append(this.f52403b);
            com.paytm.utility.a.c();
            new c(this.f52402a, new t() {
                public final void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
                }

                public final void onFileWriteComplete(String str) {
                }
            }, cJROrderSummarySellarRating, "seller_rating_list_".concat(String.valueOf(str))).execute(new Void[0]);
        }
    }

    public final void a(String str) {
        net.one97.paytm.common.utility.c.b(this.f52402a, "seller_rating_list_".concat(String.valueOf(str)));
    }
}
