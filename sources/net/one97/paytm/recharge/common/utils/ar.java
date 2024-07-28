package net.one97.paytm.recharge.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.recharge.model.CJRBrowsePlanHeader;
import net.one97.paytm.recharge.model.CJRBrowsePlansHeader;
import net.one97.paytm.recharge.model.CJRDynamicBrowsePlans;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansRichDesc;

public final class ar {
    public static HashMap<Integer, CJRBrowsePlanDescriptions> a(CJRDynamicBrowsePlans cJRDynamicBrowsePlans) {
        HashMap<Integer, CJRBrowsePlanDescriptions> hashMap = new HashMap<>();
        if (!(cJRDynamicBrowsePlans == null || cJRDynamicBrowsePlans.getUserPlansResponse() == null || cJRDynamicBrowsePlans.getUserPlansResponse().getPlansArray() == null)) {
            Iterator<CJRDynamicBrowsePlans.DynamicPlansData> it2 = cJRDynamicBrowsePlans.getUserPlansResponse().getPlansArray().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                CJRDynamicBrowsePlans.DynamicPlansData next = it2.next();
                CJRBrowsePlanDescriptions cJRBrowsePlanDescriptions = new CJRBrowsePlanDescriptions();
                ArrayList arrayList = new ArrayList();
                ArrayList<HashMap<String, String>> plansColumnsData = next.getPlansColumnsData();
                if (plansColumnsData != null) {
                    for (int i3 = 0; i3 < plansColumnsData.size(); i3++) {
                        CJRBrowsePlanDescription cJRBrowsePlanDescription = new CJRBrowsePlanDescription();
                        CJRBrowsePlansRichDesc cJRBrowsePlansRichDesc = new CJRBrowsePlansRichDesc();
                        cJRBrowsePlansRichDesc.setmDescription((String) plansColumnsData.get(i3).get("PlanName"));
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(cJRBrowsePlansRichDesc);
                        cJRBrowsePlanDescription.setmLongRichDesc(arrayList2);
                        cJRBrowsePlanDescription.setmOfferPrice((String) plansColumnsData.get(i3).get("PlanCostInRs"));
                        cJRBrowsePlanDescription.setmPlanName((String) plansColumnsData.get(i3).get("PlanName"));
                        cJRBrowsePlanDescription.setmPlanGuiId((String) plansColumnsData.get(i3).get("PlanGuiId"));
                        cJRBrowsePlanDescription.setmPlanDescription((String) plansColumnsData.get(i3).get("PlanDescription"));
                        cJRBrowsePlanDescription.setmPlanValidity((String) plansColumnsData.get(i3).get("PlanValidity"));
                        cJRBrowsePlanDescription.setOTC(next.isOTC());
                        cJRBrowsePlanDescription.setmProductId((String) plansColumnsData.get(i3).get("PlanId"));
                        cJRBrowsePlanDescription.setTransactionType(next.getTransactionType());
                        cJRBrowsePlanDescription.setmDynamicDataObject(plansColumnsData.get(i3));
                        arrayList.add(cJRBrowsePlanDescription);
                    }
                }
                cJRBrowsePlanDescriptions.setmDescription(arrayList);
                hashMap.put(Integer.valueOf(i2), cJRBrowsePlanDescriptions);
                i2++;
            }
        }
        return hashMap;
    }

    public static CJRBrowsePlansHeader b(CJRDynamicBrowsePlans cJRDynamicBrowsePlans) {
        CJRBrowsePlansHeader cJRBrowsePlansHeader = new CJRBrowsePlansHeader();
        ArrayList arrayList = new ArrayList();
        if (cJRDynamicBrowsePlans == null || cJRDynamicBrowsePlans.getUserPlansResponse() == null || cJRDynamicBrowsePlans.getUserPlansResponse().getPlansArray() == null) {
            cJRBrowsePlansHeader.setBrowsePlans(arrayList);
            return cJRBrowsePlansHeader;
        }
        Iterator<CJRDynamicBrowsePlans.DynamicPlansData> it2 = cJRDynamicBrowsePlans.getUserPlansResponse().getPlansArray().iterator();
        while (it2.hasNext()) {
            CJRDynamicBrowsePlans.DynamicPlansData next = it2.next();
            if (next.getPlanLabel() != null) {
                CJRBrowsePlanHeader cJRBrowsePlanHeader = new CJRBrowsePlanHeader();
                cJRBrowsePlanHeader.setmName(next.getPlanLabel());
                cJRBrowsePlanHeader.setOtc(next.isOTC());
                arrayList.add(cJRBrowsePlanHeader);
            }
        }
        cJRBrowsePlansHeader.setBrowsePlans(arrayList);
        return cJRBrowsePlansHeader;
    }
}
