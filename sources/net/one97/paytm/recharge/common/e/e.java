package net.one97.paytm.recharge.common.e;

import java.util.HashMap;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData;

public interface e {
    void a(String str, boolean z, HashMap<String, String> hashMap, String str2, String str3, CJRBrowsePlansDescAttributes cJRBrowsePlansDescAttributes, boolean z2);

    void a(CJRBrowsePlanDescription cJRBrowsePlanDescription, String str);

    void a(CJRMadeForYouPlanData cJRMadeForYouPlanData, String str);
}
