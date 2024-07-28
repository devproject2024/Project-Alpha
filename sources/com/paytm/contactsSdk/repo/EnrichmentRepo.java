package com.paytm.contactsSdk.repo;

import com.paytm.contactsSdk.api.query.EnrichmentQuery;
import com.paytm.contactsSdk.manager.DatabaseManager;
import com.paytm.contactsSdk.models.DynamicMapping;
import com.paytm.contactsSdk.models.EnrichedContactModel;
import com.paytm.contactsSdk.models.EnrichmentData;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class EnrichmentRepo {
    public final void saveDynamicMapping(List<DynamicMapping> list) {
        k.c(list, "featureList");
        DatabaseManager.INSTANCE.getDatabase().dynamicMappingDao().insertDynamicMappingList(list);
    }

    public final List<DynamicMapping> getDynamicMapping() {
        return DatabaseManager.INSTANCE.getDatabase().dynamicMappingDao().getDynamicMapping();
    }

    public final void saveEnrichmentDataList(ArrayList<EnrichmentData> arrayList) {
        k.c(arrayList, "enrichmentDataList");
        DatabaseManager.INSTANCE.getDatabase().enrichmentDao().insertEnrichmentData(arrayList);
    }

    public final List<EnrichmentData> getEnrichmentData(EnrichmentQuery enrichmentQuery) {
        k.c(enrichmentQuery, "enrichmentQuery");
        return DatabaseManager.INSTANCE.getDatabase().enrichmentDao().getEnrichmentData(enrichmentQuery.getEnrichmentDataQuery());
    }

    public final List<EnrichedContactModel> getEnrichedContacts(EnrichmentQuery enrichmentQuery) {
        k.c(enrichmentQuery, "enrichmentQuery");
        return DatabaseManager.INSTANCE.getDatabase().enrichmentDao().getEnrichedContacts(enrichmentQuery.getEnrichedContactsQuery());
    }

    public final List<EnrichedContactModel> getEnrichedContactsPaginated(EnrichmentQuery enrichmentQuery) {
        k.c(enrichmentQuery, "enrichmentQuery");
        return DatabaseManager.INSTANCE.getDatabase().enrichmentDao().getEnrichedContactsPaginated(enrichmentQuery.getEnrichedContactsPaginatedQuery());
    }
}
