package net.one97.paytm.h5paytmsdk.b;

import android.content.Context;
import androidx.core.content.b;
import com.alipay.iap.android.common.b.c;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class x extends y {
    public x() {
        super("paytmCheckPermission");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (b(h5Event)) {
            if (h5Event == null) {
                k.a();
            }
            String string = h5Event.getParam().getString("permission");
            ArrayList<String> arrayList = new ArrayList<>();
            k.a((Object) string, "permissionToCheck");
            CharSequence charSequence = string;
            if (p.c(charSequence, (CharSequence) AppConstants.COMMA)) {
                List<String> b2 = p.b(charSequence, new String[]{AppConstants.COMMA});
                if (b2.isEmpty()) {
                    a(H5Event.Error.INVALID_PARAM, "invalid params");
                    return true;
                }
                for (String str : b2) {
                    CharSequence charSequence2 = str;
                    if (charSequence2.length() > 0) {
                        if (str == null) {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        } else if (a(p.b(charSequence2).toString(), arrayList) == -1) {
                            return true;
                        }
                    }
                }
            } else if (a(string, arrayList) == -1) {
                return true;
            }
            for (String str2 : arrayList) {
                if (b.a((Context) h5Event.getActivity(), str2) == 0) {
                    String b3 = b(str2);
                    if (b3 != null) {
                        str2 = b3;
                    }
                    a(str2, (Object) 1);
                } else {
                    String b4 = b(str2);
                    if (b4 != null) {
                        str2 = b4;
                    }
                    a(str2, (Object) 0);
                }
            }
            a((Object) null);
        }
        return true;
    }

    private int a(String str, ArrayList<String> arrayList) {
        k.c(str, "rawPermission");
        k.c(arrayList, "array");
        String[] a2 = a(str);
        if (a2 == null) {
            c.e();
            a(H5Event.Error.INVALID_PARAM, "invalid params");
            return -1;
        }
        kotlin.a.k.a(arrayList, (T[]) a2);
        return 0;
    }
}
