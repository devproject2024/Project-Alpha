package net.one97.paytm.paymentsBank.pdc.c.b;

import android.content.Context;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.f.f;
import net.one97.paytm.bankCommon.model.PBCJRAddress;
import net.one97.paytm.bankCommon.model.PBTncData;

public interface a {
    void a(Context context, ArrayList<PBTncData> arrayList, f fVar);

    void a(Context context, f fVar);

    void a(PBCJRAddress pBCJRAddress, String str, String str2, String str3, Context context, f fVar);
}
