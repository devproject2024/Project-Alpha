package com.paytm.contactsSdk.database.daos;

import androidx.sqlite.db.e;
import com.paytm.contactsSdk.models.EnrichedContactModel;
import com.paytm.contactsSdk.models.EnrichmentData;
import java.util.List;

public interface EnrichmentDao {
    void deletedAllData();

    List<EnrichedContactModel> getEnrichedContacts(e eVar);

    List<EnrichedContactModel> getEnrichedContactsPaginated(e eVar);

    List<EnrichmentData> getEnrichmentData(e eVar);

    void insertEnrichmentData(List<EnrichmentData> list);
}
