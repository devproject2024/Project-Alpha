package net.one97.paytm.upi.passbook.c;

import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.passbook.a.a;
import net.one97.paytm.upi.passbook.b.a.b;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar, a.b bVar2, int i2, boolean z) {
        super(bVar, bVar2, i2, z);
        k.c(bVar, "repository");
        k.c(bVar2, "passbookView");
    }

    public final int a() {
        if (this.f67694d == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            return Math.min(this.f67692b.size(), 2);
        }
        if (this.f67694d == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            return Math.min(this.f67693c.size(), 1);
        }
        return super.a();
    }

    /* access modifiers changed from: protected */
    public final void a(ArrayList<UpiPendingRequestModel> arrayList) {
        k.c(arrayList, "pendingRequestList");
        int size = this.f67693c.size();
        int i2 = 0;
        for (UpiPendingRequestModel upiPendingRequestModel : arrayList) {
            if (upiPendingRequestModel.getDirection().equals("RECEIVED")) {
                this.f67693c.add(upiPendingRequestModel);
                i2++;
            } else {
                this.f67696f = true;
            }
        }
        this.f67691a.a(size, i2);
    }
}
