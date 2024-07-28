package com.paytm.contactsSdk.database.daos;

import com.paytm.contactsSdk.models.DynamicMapping;
import java.util.List;

public interface DynamiceMappingDao {
    void deletedAllData();

    List<DynamicMapping> getDynamicMapping();

    void insertDynamicMapping(DynamicMapping dynamicMapping);

    void insertDynamicMappingList(List<DynamicMapping> list);
}
