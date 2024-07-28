package com.paytm.android.chat.data.db.room.helper;

import com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity;
import java.util.List;
import kotlin.g.b.k;

public final class MessageInsertOrUpdatedModel {
    private final List<ChatMessageEntity> insertedList;
    private final List<ChatMessageEntity> updatedList;

    public static /* synthetic */ MessageInsertOrUpdatedModel copy$default(MessageInsertOrUpdatedModel messageInsertOrUpdatedModel, List<ChatMessageEntity> list, List<ChatMessageEntity> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = messageInsertOrUpdatedModel.insertedList;
        }
        if ((i2 & 2) != 0) {
            list2 = messageInsertOrUpdatedModel.updatedList;
        }
        return messageInsertOrUpdatedModel.copy(list, list2);
    }

    public final List<ChatMessageEntity> component1() {
        return this.insertedList;
    }

    public final List<ChatMessageEntity> component2() {
        return this.updatedList;
    }

    public final MessageInsertOrUpdatedModel copy(List<ChatMessageEntity> list, List<ChatMessageEntity> list2) {
        k.c(list, "insertedList");
        k.c(list2, "updatedList");
        return new MessageInsertOrUpdatedModel(list, list2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageInsertOrUpdatedModel)) {
            return false;
        }
        MessageInsertOrUpdatedModel messageInsertOrUpdatedModel = (MessageInsertOrUpdatedModel) obj;
        return k.a((Object) this.insertedList, (Object) messageInsertOrUpdatedModel.insertedList) && k.a((Object) this.updatedList, (Object) messageInsertOrUpdatedModel.updatedList);
    }

    public final int hashCode() {
        List<ChatMessageEntity> list = this.insertedList;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ChatMessageEntity> list2 = this.updatedList;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MessageInsertOrUpdatedModel(insertedList=" + this.insertedList + ", updatedList=" + this.updatedList + ")";
    }

    public MessageInsertOrUpdatedModel(List<ChatMessageEntity> list, List<ChatMessageEntity> list2) {
        k.c(list, "insertedList");
        k.c(list2, "updatedList");
        this.insertedList = list;
        this.updatedList = list2;
    }

    public final List<ChatMessageEntity> getInsertedList() {
        return this.insertedList;
    }

    public final List<ChatMessageEntity> getUpdatedList() {
        return this.updatedList;
    }
}
