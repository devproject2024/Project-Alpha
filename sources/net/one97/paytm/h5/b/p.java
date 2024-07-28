package net.one97.paytm.h5.b;

import android.content.Context;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.j;
import net.one97.paytm.utils.v;

public final class p implements j {
    public final void a(Context context, String str, HashMap<String, String> hashMap) {
        k.c(context, "context");
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        v.f69802a.a(context, str, hashMap);
    }
}
