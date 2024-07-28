package com.paytm.contactsSdk.utils;

import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.models.EnrichmentData;
import com.paytm.contactsSdk.models.MappingInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import org.json.JSONObject;

public final class EnrichmentUtil {
    public static final EnrichmentUtil INSTANCE = new EnrichmentUtil();

    public final long getBitCode(int i2) {
        int i3 = i2 - 64;
        if (i3 >= 0) {
            if (i2 - 126 < 0) {
                return 1 << i3;
            }
            i2 = i2 + -189 < 0 ? i2 - 128 : i2 - 192;
        }
        return 1 << i2;
    }

    public final int getColumnNumber(int i2) {
        if (i2 - 64 < 0) {
            return 0;
        }
        if (i2 - 128 < 0) {
            return 1;
        }
        return i2 + -192 < 0 ? 2 : 3;
    }

    private EnrichmentUtil() {
    }

    public final boolean isFeature(JSONObject jSONObject) {
        k.c(jSONObject, "featureJson");
        if (!jSONObject.has("value")) {
            return false;
        }
        Object obj = jSONObject.get("value");
        if (!(obj instanceof Boolean) && !k.a(obj, (Object) "true") && !k.a(obj, (Object) "false")) {
            return false;
        }
        return true;
    }

    public final boolean isAlreadyPresentInDynamicMapping(String str, HashMap<String, MappingInfo> hashMap) {
        k.c(str, "featureKey");
        k.c(hashMap, "dynamicMapping");
        return hashMap.containsKey(str);
    }

    public final boolean isFeaturePresent(JSONObject jSONObject) {
        k.c(jSONObject, "featureJson");
        return jSONObject.getBoolean("value");
    }

    public final void prepareEnrichmentData(EnrichmentData enrichmentData, MappingInfo mappingInfo) {
        k.c(enrichmentData, "enrichmentData");
        k.c(mappingInfo, "mappingInfo");
        int columnNumber = mappingInfo.getColumnNumber();
        if (columnNumber == 0) {
            enrichmentData.setEnrichmentBitCodeCol_0(enrichmentData.getEnrichmentBitCodeCol_0() | mappingInfo.getBitCode());
        } else if (columnNumber == 1) {
            enrichmentData.setEnrichmentBitCodeCol_1(enrichmentData.getEnrichmentBitCodeCol_1() | mappingInfo.getBitCode());
        } else if (columnNumber == 2) {
            enrichmentData.setEnrichmentBitCodeCol_2(enrichmentData.getEnrichmentBitCodeCol_2() | mappingInfo.getBitCode());
        } else if (columnNumber == 3) {
            enrichmentData.setEnrichmentBitCodeCol_3(enrichmentData.getEnrichmentBitCodeCol_3() | mappingInfo.getBitCode());
        }
    }

    public final JSONObject getSampleModuleJson(JSONObject jSONObject) {
        k.c(jSONObject, "modulesJson");
        for (int i2 = 1; i2 <= 250; i2++) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("value", i2 % 2 == 0);
            jSONObject.put("isPaytmUser".concat(String.valueOf(i2)), jSONObject2);
        }
        return jSONObject;
    }

    public final ArrayList<String> getAllFeaturesList() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String add : ContactsProvider.INSTANCE.getDynamicMapping$contacts_sdk_release().keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
