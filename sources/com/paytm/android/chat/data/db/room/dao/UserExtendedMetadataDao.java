package com.paytm.android.chat.data.db.room.dao;

import com.paytm.android.chat.data.db.room.db_entities.UserExtendedMetaDataEntity;
import java.util.List;

public interface UserExtendedMetadataDao {
    List<UserExtendedMetaDataEntity> getAllRecord();

    UserExtendedMetaDataEntity getBySendbirdUserId(String str);

    void insertOrReplace(UserExtendedMetaDataEntity userExtendedMetaDataEntity);
}
