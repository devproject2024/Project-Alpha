package net.one97.paytm.acceptPayment.e;

import android.content.Context;
import com.business.common_module.b.e;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.Map;
import net.one97.paytm.acceptPayment.configs.a;
import net.one97.paytm.acceptPayment.model.GAEvent;
import net.one97.paytm.acceptPayment.utils.b;

public final class d implements e {
    public final void a(String str, Map<String, Object> map, Context context) {
        a.f52046a.f52049d.a(str, map, context);
    }

    public final void a(Context context, String str, String str2, String str3, String str4) {
        a.f52046a.f52049d.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) b.a(new GAEvent(str, str2, str4, "", "", str3)), context);
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Context context2 = context;
        a.f52046a.f52049d.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) b.a(new GAEvent(str, str2, str4, str5, str6, str3)), context);
    }

    public final void b(Context context, String str, String str2, String str3, String str4) {
        a.f52046a.f52049d.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) b.a(new GAEvent(str, str2, str4, "", "", "", str3)), context);
    }
}
