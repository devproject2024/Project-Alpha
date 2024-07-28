package com.paytm.contactsSdk.network;

import android.content.Context;
import com.google.gson.f;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.listener.EnrichmentDataSyncListener;
import com.paytm.contactsSdk.models.DynamicMapping;
import com.paytm.contactsSdk.models.EnrichmentData;
import com.paytm.contactsSdk.models.MappingInfo;
import com.paytm.contactsSdk.models.requests.SearchContactRequest;
import com.paytm.contactsSdk.models.responses.Search.EnrichedContact;
import com.paytm.contactsSdk.repo.EnrichmentRepo;
import com.paytm.contactsSdk.utils.ContactPrefUtils;
import com.paytm.contactsSdk.utils.EnrichmentUtil;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import org.json.JSONObject;

public final class ContactEnrichmentManager {
    public static final ContactEnrichmentManager INSTANCE = new ContactEnrichmentManager();
    /* access modifiers changed from: private */
    public static final String TAG;
    private static final EnrichmentRepo dynamicMapingRepo = ContactsProvider.INSTANCE.getEnrichmentRepo$contacts_sdk_release();
    /* access modifiers changed from: private */
    public static EnrichmentDataSyncListener listener;

    static {
        String simpleName = ContactEnrichmentManager.class.getSimpleName();
        k.a((Object) simpleName, "ContactEnrichmentManager::class.java.simpleName");
        TAG = simpleName;
    }

    private ContactEnrichmentManager() {
    }

    /* access modifiers changed from: private */
    public final void getEnrichmentData(Context context) {
        a searchContactNetworkCall = NetworkRequestHelper.INSTANCE.searchContactNetworkCall(context, getSearchContactRequest(context), getAPIListener(context));
        if (searchContactNetworkCall != null) {
            searchContactNetworkCall.a();
        }
    }

    public final void startFetchingEnrichmentData(Context context, EnrichmentDataSyncListener enrichmentDataSyncListener) {
        k.c(context, "context");
        listener = enrichmentDataSyncListener;
        getEnrichmentData(context);
    }

    private final ContactEnrichmentManager$getAPIListener$1 getAPIListener(Context context) {
        return new ContactEnrichmentManager$getAPIListener$1(context);
    }

    /* access modifiers changed from: private */
    public final void saveEnrichmentDataToLocal(List<EnrichedContact> list) {
        ContactsSdk.INSTANCE.setDbSyncInProgress$contacts_sdk_release(true);
        HashMap<String, MappingInfo> dynamicMapping$contacts_sdk_release = ContactsProvider.INSTANCE.getDynamicMapping$contacts_sdk_release();
        int size = dynamicMapping$contacts_sdk_release.size();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null) {
            k.a();
        }
        for (EnrichedContact profiles : list) {
            Map<String, Object> profiles2 = profiles.getProfiles();
            if (profiles2 != null) {
                for (String next : profiles2.keySet()) {
                    JSONObject jSONObject = new JSONObject(new f().b(profiles2.get(next)));
                    JSONObject jSONObject2 = jSONObject;
                    EnrichmentData enrichmentData = new EnrichmentData(next, 0, 0, 0, 0, jSONObject.toString(), 30, (g) null);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next2 = keys.next();
                        JSONObject jSONObject3 = jSONObject2;
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(next2);
                        EnrichmentUtil enrichmentUtil = EnrichmentUtil.INSTANCE;
                        k.a((Object) jSONObject4, "featureJson");
                        if (enrichmentUtil.isFeature(jSONObject4)) {
                            EnrichmentUtil enrichmentUtil2 = EnrichmentUtil.INSTANCE;
                            k.a((Object) next2, "featureKey");
                            if (!enrichmentUtil2.isAlreadyPresentInDynamicMapping(next2, dynamicMapping$contacts_sdk_release)) {
                                addFeatureToDynamicMapping(next2, dynamicMapping$contacts_sdk_release, size, arrayList);
                                size++;
                            }
                            if (EnrichmentUtil.INSTANCE.isFeaturePresent(jSONObject4)) {
                                EnrichmentUtil enrichmentUtil3 = EnrichmentUtil.INSTANCE;
                                MappingInfo mappingInfo = dynamicMapping$contacts_sdk_release.get(next2);
                                if (mappingInfo == null) {
                                    k.a();
                                }
                                k.a((Object) mappingInfo, "dynamicMapping.get(featureKey)!!");
                                enrichmentUtil3.prepareEnrichmentData(enrichmentData, mappingInfo);
                            }
                        }
                        jSONObject2 = jSONObject3;
                    }
                    arrayList2.add(enrichmentData);
                }
            }
        }
        saveFeatureListInTable(arrayList);
        saveEnrichmentDataListInTable(arrayList2);
        ContactsSdk.INSTANCE.setDbSyncInProgress$contacts_sdk_release(false);
    }

    private final void saveFeatureListInTable(ArrayList<DynamicMapping> arrayList) {
        if (arrayList.size() > 0) {
            dynamicMapingRepo.saveDynamicMapping(arrayList);
        }
    }

    private final void saveEnrichmentDataListInTable(ArrayList<EnrichmentData> arrayList) {
        dynamicMapingRepo.saveEnrichmentDataList(arrayList);
    }

    private final void addFeatureToDynamicMapping(String str, HashMap<String, MappingInfo> hashMap, int i2, ArrayList<DynamicMapping> arrayList) {
        DynamicMapping dynamicMapping = new DynamicMapping(str, EnrichmentUtil.INSTANCE.getColumnNumber(i2), EnrichmentUtil.INSTANCE.getBitCode(i2));
        hashMap.put(dynamicMapping.getFeature(), new MappingInfo(dynamicMapping.getColumnNumber(), dynamicMapping.getBitCode()));
        arrayList.add(dynamicMapping);
    }

    private final SearchContactRequest getSearchContactRequest(Context context) {
        String A = b.A(context);
        long lastEnrichmentDataSyncedTimeStamp = getLastEnrichmentDataSyncedTimeStamp(context);
        q.d("Requesting time stamp ".concat(String.valueOf(lastEnrichmentDataSyncedTimeStamp)));
        return new SearchContactRequest(A, ContactsConstant.CONTACT_TYPE_VALUE, "ACTIVE", Long.valueOf(lastEnrichmentDataSyncedTimeStamp), Integer.valueOf(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().downloadBatchSize()), Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public final void saveLastEnrichmentDataSyncedTimeStamp(Context context, long j) {
        q.d("Next time stamp ".concat(String.valueOf(j)));
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        companion.getPref(applicationContext).a(ContactsConstant.SEARCH_CONTACT_LAST_TIME_STAMP, j, false);
    }

    public final long getLastEnrichmentDataSyncedTimeStamp(Context context) {
        k.c(context, "context");
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return companion.getPref(applicationContext).b(ContactsConstant.SEARCH_CONTACT_LAST_TIME_STAMP, 0, false);
    }
}
