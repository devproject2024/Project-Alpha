package com.paytm.android.chat.data.db.room;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.android.chat.data.db.room.dao.ChatChannelDao;
import com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl;
import com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao;
import com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao_Impl;
import com.paytm.android.chat.data.db.room.dao.ChatMessageDao;
import com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl;
import com.paytm.android.chat.data.db.room.dao.ChatUserDao;
import com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl;
import com.paytm.android.chat.data.db.room.dao.SendbirdNotificationDao;
import com.paytm.android.chat.data.db.room.dao.SendbirdNotificationDao_Impl;
import com.paytm.android.chat.data.db.room.dao.UserExtendedMetadataDao;
import com.paytm.android.chat.data.db.room.dao.UserExtendedMetadataDao_Impl;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.HashSet;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiContract;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class ChatDB_Impl extends ChatDB {
    private volatile ChatChannelDao _chatChannelDao;
    private volatile ChatChannelUsersJoinDao _chatChannelUsersJoinDao;
    private volatile ChatMessageDao _chatMessageDao;
    private volatile ChatUserDao _chatUserDao;
    private volatile SendbirdNotificationDao _sendbirdNotificationDao;
    private volatile UserExtendedMetadataDao _userExtendedMetadataDao;

    public final c createOpenHelper(a aVar) {
        l lVar = new l(aVar, new l.a() {
            public final void onPostMigrate(b bVar) {
            }

            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `UserExtendedMetaData` (`sendbirdUserId` TEXT NOT NULL, `metaDataString` TEXT, `updatedAt` INTEGER, PRIMARY KEY(`sendbirdUserId`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `SendbirdNotification` (`id` TEXT NOT NULL, `channel_url` TEXT, `payload` TEXT, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `ChatMessageEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `messageId` INTEGER NOT NULL, `messageType` TEXT, `requestId` TEXT NOT NULL, `channelUrl` TEXT NOT NULL, `senderId` TEXT, `senderName` TEXT, `messageCustomType` TEXT, `createdAt` INTEGER, `updatedAt` INTEGER, `messageState` INTEGER NOT NULL, `readEngageEventSent` INTEGER NOT NULL, `rawMessage` BLOB, `showAnim` INTEGER, `messageContent` TEXT, `isOperatorMessage` INTEGER NOT NULL, `channelType` TEXT, `customType` TEXT, `data` TEXT, `errorCode` INTEGER NOT NULL, `isSilent` INTEGER NOT NULL, `mentionType` TEXT, `sender` BLOB, `parentMessageId` INTEGER, `parentMessageText` TEXT, `type` TEXT, `fileUrl` TEXT, `fileName` TEXT, `previewText` TEXT, `previewDrawable` INTEGER)");
                bVar.c("CREATE TABLE IF NOT EXISTS `ChatChannelEntity` (`isFake` INTEGER NOT NULL, `channelUrl` TEXT NOT NULL, `name` TEXT, `createdAt` INTEGER, `isPinned` INTEGER NOT NULL, `draftMessage` TEXT, `lastMessageTs` INTEGER, `rawChannel` BLOB, `members` TEXT NOT NULL, `lastMessageId` INTEGER, `lastMessageType` TEXT, `memberCount` INTEGER NOT NULL, `myLastRead` INTEGER NOT NULL, `unreadMessageCount` INTEGER NOT NULL, `unreadMentionCount` INTEGER NOT NULL, `data` TEXT, `createdBy` TEXT, `isBroadcast` INTEGER NOT NULL, `customType` TEXT, `invitedAt` INTEGER NOT NULL, `inviter` TEXT, `isDiscoverable` INTEGER NOT NULL, `isDistinct` INTEGER NOT NULL, `isHidden` INTEGER NOT NULL, `isPublic` INTEGER NOT NULL, `isPushEnabled` INTEGER NOT NULL, `joinedMemberCount` INTEGER NOT NULL, `metaData` TEXT, `payAllowed` INTEGER NOT NULL, `requestAllowed` INTEGER NOT NULL, `replyStatus` INTEGER NOT NULL, `previewText` TEXT, `previewDrawable` INTEGER, PRIMARY KEY(`channelUrl`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `ChatUserEntity` (`primaryKey` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `identifier` TEXT NOT NULL, `sendbirdUserId` TEXT NOT NULL, `type` TEXT, `avatarUrl` TEXT, `isUserFake` INTEGER NOT NULL DEFAULT 0, `sendbirdUserName` TEXT, `lastSeenAt` TEXT, `isActive` INTEGER, `friendName` TEXT, `friendDiscoveryKey` TEXT, `isBlockingMe` INTEGER NOT NULL, `isBlockedByMe` INTEGER NOT NULL, `connectionStatus` TEXT, `isMuted` INTEGER NOT NULL, `rawMember` BLOB, `phoneNumber` TEXT, `phoneHash` TEXT, `contactId` TEXT, `source` TEXT, `userMetadata` TEXT, `userExtendedMetaData` TEXT, `lastUpdatedUserExtendedMetaData` INTEGER NOT NULL DEFAULT -1, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `paymentIdentifier` TEXT, `paymentIdentifierType` TEXT, `name` TEXT, `bankName` TEXT, `accRefId` TEXT, `mobileNo` TEXT, `mid` TEXT, `txnCategory` TEXT, `vpa` TEXT, `isVerifiedMerchant` INTEGER, `bankLogoUrl` TEXT, `ifsc` TEXT, `maskedAccNo` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS `ChatChannelUsersJoinEntity` (`entryId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `channelUrl` TEXT NOT NULL, `uniqueId` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6eb6cd54c2defaccdae947fc27aa0f24')");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `UserExtendedMetaData`");
                bVar.c("DROP TABLE IF EXISTS `SendbirdNotification`");
                bVar.c("DROP TABLE IF EXISTS `ChatMessageEntity`");
                bVar.c("DROP TABLE IF EXISTS `ChatChannelEntity`");
                bVar.c("DROP TABLE IF EXISTS `ChatUserEntity`");
                bVar.c("DROP TABLE IF EXISTS `ChatChannelUsersJoinEntity`");
                if (ChatDB_Impl.this.mCallbacks != null) {
                    int size = ChatDB_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ChatDB_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onCreate(b bVar) {
                if (ChatDB_Impl.this.mCallbacks != null) {
                    int size = ChatDB_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ChatDB_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = ChatDB_Impl.this.mDatabase = bVar;
                ChatDB_Impl.this.internalInitInvalidationTracker(bVar);
                if (ChatDB_Impl.this.mCallbacks != null) {
                    int size = ChatDB_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ChatDB_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public final l.b onValidateSchema(b bVar) {
                b bVar2 = bVar;
                HashMap hashMap = new HashMap(3);
                hashMap.put("sendbirdUserId", new f.a("sendbirdUserId", "TEXT", true, 1, (String) null, 1));
                hashMap.put("metaDataString", new f.a("metaDataString", "TEXT", false, 0, (String) null, 1));
                hashMap.put("updatedAt", new f.a("updatedAt", "INTEGER", false, 0, (String) null, 1));
                f fVar = new f("UserExtendedMetaData", hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar2, "UserExtendedMetaData");
                if (!fVar.equals(a2)) {
                    return new l.b(false, "UserExtendedMetaData(com.paytm.android.chat.data.db.room.db_entities.UserExtendedMetaDataEntity).\n Expected:\n" + fVar + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(3);
                hashMap2.put("id", new f.a("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put(StringSet.channel_url, new f.a(StringSet.channel_url, "TEXT", false, 0, (String) null, 1));
                hashMap2.put("payload", new f.a("payload", "TEXT", false, 0, (String) null, 1));
                f fVar2 = new f("SendbirdNotification", hashMap2, new HashSet(0), new HashSet(0));
                f a3 = f.a(bVar2, "SendbirdNotification");
                if (!fVar2.equals(a3)) {
                    return new l.b(false, "SendbirdNotification(com.paytm.android.chat.data.db.room.db_entities.SendbirdNotificationEntity).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(30);
                hashMap3.put("id", new f.a("id", "INTEGER", true, 1, (String) null, 1));
                hashMap3.put("messageId", new f.a("messageId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("messageType", new f.a("messageType", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("requestId", new f.a("requestId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("channelUrl", new f.a("channelUrl", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("senderId", new f.a("senderId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("senderName", new f.a("senderName", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("messageCustomType", new f.a("messageCustomType", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("createdAt", new f.a("createdAt", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("updatedAt", new f.a("updatedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("messageState", new f.a("messageState", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("readEngageEventSent", new f.a("readEngageEventSent", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("rawMessage", new f.a("rawMessage", "BLOB", false, 0, (String) null, 1));
                hashMap3.put("showAnim", new f.a("showAnim", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("messageContent", new f.a("messageContent", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("isOperatorMessage", new f.a("isOperatorMessage", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("channelType", new f.a("channelType", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("customType", new f.a("customType", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("data", new f.a("data", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(CLConstants.FIELD_ERROR_CODE, new f.a(CLConstants.FIELD_ERROR_CODE, "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("isSilent", new f.a("isSilent", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("mentionType", new f.a("mentionType", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("sender", new f.a("sender", "BLOB", false, 0, (String) null, 1));
                hashMap3.put("parentMessageId", new f.a("parentMessageId", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("parentMessageText", new f.a("parentMessageText", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("type", new f.a("type", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("fileUrl", new f.a("fileUrl", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, new f.a(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, "TEXT", false, 0, (String) null, 1));
                hashMap3.put("previewText", new f.a("previewText", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("previewDrawable", new f.a("previewDrawable", "INTEGER", false, 0, (String) null, 1));
                f fVar3 = new f("ChatMessageEntity", hashMap3, new HashSet(0), new HashSet(0));
                f a4 = f.a(bVar2, "ChatMessageEntity");
                if (!fVar3.equals(a4)) {
                    return new l.b(false, "ChatMessageEntity(com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity).\n Expected:\n" + fVar3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(33);
                hashMap4.put("isFake", new f.a("isFake", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("channelUrl", new f.a("channelUrl", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("name", new f.a("name", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("createdAt", new f.a("createdAt", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("isPinned", new f.a("isPinned", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("draftMessage", new f.a("draftMessage", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("lastMessageTs", new f.a("lastMessageTs", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("rawChannel", new f.a("rawChannel", "BLOB", false, 0, (String) null, 1));
                hashMap4.put("members", new f.a("members", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("lastMessageId", new f.a("lastMessageId", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("lastMessageType", new f.a("lastMessageType", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("memberCount", new f.a("memberCount", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("myLastRead", new f.a("myLastRead", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("unreadMessageCount", new f.a("unreadMessageCount", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("unreadMentionCount", new f.a("unreadMentionCount", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("data", new f.a("data", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("createdBy", new f.a("createdBy", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("isBroadcast", new f.a("isBroadcast", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("customType", new f.a("customType", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("invitedAt", new f.a("invitedAt", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("inviter", new f.a("inviter", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("isDiscoverable", new f.a("isDiscoverable", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("isDistinct", new f.a("isDistinct", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("isHidden", new f.a("isHidden", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("isPublic", new f.a("isPublic", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("isPushEnabled", new f.a("isPushEnabled", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("joinedMemberCount", new f.a("joinedMemberCount", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("metaData", new f.a("metaData", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("payAllowed", new f.a("payAllowed", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("requestAllowed", new f.a("requestAllowed", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("replyStatus", new f.a("replyStatus", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("previewText", new f.a("previewText", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("previewDrawable", new f.a("previewDrawable", "INTEGER", false, 0, (String) null, 1));
                f fVar4 = new f("ChatChannelEntity", hashMap4, new HashSet(0), new HashSet(0));
                f a5 = f.a(bVar2, "ChatChannelEntity");
                if (!fVar4.equals(a5)) {
                    return new l.b(false, "ChatChannelEntity(com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity).\n Expected:\n" + fVar4 + "\n Found:\n" + a5);
                }
                HashMap hashMap5 = new HashMap(38);
                hashMap5.put("primaryKey", new f.a("primaryKey", "INTEGER", true, 1, (String) null, 1));
                hashMap5.put("identifier", new f.a("identifier", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("sendbirdUserId", new f.a("sendbirdUserId", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("type", new f.a("type", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("avatarUrl", new f.a("avatarUrl", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("isUserFake", new f.a("isUserFake", "INTEGER", true, 0, "0", 1));
                hashMap5.put("sendbirdUserName", new f.a("sendbirdUserName", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("lastSeenAt", new f.a("lastSeenAt", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("isActive", new f.a("isActive", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("friendName", new f.a("friendName", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("friendDiscoveryKey", new f.a("friendDiscoveryKey", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("isBlockingMe", new f.a("isBlockingMe", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("isBlockedByMe", new f.a("isBlockedByMe", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("connectionStatus", new f.a("connectionStatus", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("isMuted", new f.a("isMuted", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("rawMember", new f.a("rawMember", "BLOB", false, 0, (String) null, 1));
                hashMap5.put("phoneNumber", new f.a("phoneNumber", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("phoneHash", new f.a("phoneHash", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("contactId", new f.a("contactId", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("source", new f.a("source", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("userMetadata", new f.a("userMetadata", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("userExtendedMetaData", new f.a("userExtendedMetaData", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("lastUpdatedUserExtendedMetaData", new f.a("lastUpdatedUserExtendedMetaData", "INTEGER", true, 0, H5BridgeContext.INVALID_ID, 1));
                hashMap5.put("createdAt", new f.a("createdAt", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("updatedAt", new f.a("updatedAt", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("paymentIdentifier", new f.a("paymentIdentifier", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("paymentIdentifierType", new f.a("paymentIdentifierType", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("name", new f.a("name", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("bankName", new f.a("bankName", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("accRefId", new f.a("accRefId", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("mobileNo", new f.a("mobileNo", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("mid", new f.a("mid", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("txnCategory", new f.a("txnCategory", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("vpa", new f.a("vpa", "TEXT", false, 0, (String) null, 1));
                hashMap5.put(UpiConstants.UPI_IS_VERIFIED_MERCHANT, new f.a(UpiConstants.UPI_IS_VERIFIED_MERCHANT, "INTEGER", false, 0, (String) null, 1));
                hashMap5.put(UpiContract.UPI_ACCOUNT_PROVIDER.BANK_LOGO_URL, new f.a(UpiContract.UPI_ACCOUNT_PROVIDER.BANK_LOGO_URL, "TEXT", false, 0, (String) null, 1));
                hashMap5.put("ifsc", new f.a("ifsc", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("maskedAccNo", new f.a("maskedAccNo", "TEXT", false, 0, (String) null, 1));
                f fVar5 = new f("ChatUserEntity", hashMap5, new HashSet(0), new HashSet(0));
                f a6 = f.a(bVar2, "ChatUserEntity");
                if (!fVar5.equals(a6)) {
                    return new l.b(false, "ChatUserEntity(com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity).\n Expected:\n" + fVar5 + "\n Found:\n" + a6);
                }
                HashMap hashMap6 = new HashMap(3);
                hashMap6.put("entryId", new f.a("entryId", "INTEGER", true, 1, (String) null, 1));
                hashMap6.put("channelUrl", new f.a("channelUrl", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("uniqueId", new f.a("uniqueId", "TEXT", false, 0, (String) null, 1));
                f fVar6 = new f("ChatChannelUsersJoinEntity", hashMap6, new HashSet(0), new HashSet(0));
                f a7 = f.a(bVar2, "ChatChannelUsersJoinEntity");
                if (fVar6.equals(a7)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "ChatChannelUsersJoinEntity(com.paytm.android.chat.data.db.room.db_entities.ChatChannelUsersJoinEntity).\n Expected:\n" + fVar6 + "\n Found:\n" + a7);
            }
        }, "6eb6cd54c2defaccdae947fc27aa0f24", "6dfde8bae08bc909b8af3a6b70978cb6");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "UserExtendedMetaData", "SendbirdNotification", "ChatMessageEntity", "ChatChannelEntity", "ChatUserEntity", "ChatChannelUsersJoinEntity");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `UserExtendedMetaData`");
            b2.c("DELETE FROM `SendbirdNotification`");
            b2.c("DELETE FROM `ChatMessageEntity`");
            b2.c("DELETE FROM `ChatChannelEntity`");
            b2.c("DELETE FROM `ChatUserEntity`");
            b2.c("DELETE FROM `ChatChannelUsersJoinEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final UserExtendedMetadataDao userExtendedMetaDataDao() {
        UserExtendedMetadataDao userExtendedMetadataDao;
        if (this._userExtendedMetadataDao != null) {
            return this._userExtendedMetadataDao;
        }
        synchronized (this) {
            if (this._userExtendedMetadataDao == null) {
                this._userExtendedMetadataDao = new UserExtendedMetadataDao_Impl(this);
            }
            userExtendedMetadataDao = this._userExtendedMetadataDao;
        }
        return userExtendedMetadataDao;
    }

    public final SendbirdNotificationDao sendbirdNotificationDao() {
        SendbirdNotificationDao sendbirdNotificationDao;
        if (this._sendbirdNotificationDao != null) {
            return this._sendbirdNotificationDao;
        }
        synchronized (this) {
            if (this._sendbirdNotificationDao == null) {
                this._sendbirdNotificationDao = new SendbirdNotificationDao_Impl(this);
            }
            sendbirdNotificationDao = this._sendbirdNotificationDao;
        }
        return sendbirdNotificationDao;
    }

    public final ChatMessageDao chatMessageDao() {
        ChatMessageDao chatMessageDao;
        if (this._chatMessageDao != null) {
            return this._chatMessageDao;
        }
        synchronized (this) {
            if (this._chatMessageDao == null) {
                this._chatMessageDao = new ChatMessageDao_Impl(this);
            }
            chatMessageDao = this._chatMessageDao;
        }
        return chatMessageDao;
    }

    public final ChatChannelDao chatChannelDao() {
        ChatChannelDao chatChannelDao;
        if (this._chatChannelDao != null) {
            return this._chatChannelDao;
        }
        synchronized (this) {
            if (this._chatChannelDao == null) {
                this._chatChannelDao = new ChatChannelDao_Impl(this);
            }
            chatChannelDao = this._chatChannelDao;
        }
        return chatChannelDao;
    }

    public final ChatUserDao chatUserDao() {
        ChatUserDao chatUserDao;
        if (this._chatUserDao != null) {
            return this._chatUserDao;
        }
        synchronized (this) {
            if (this._chatUserDao == null) {
                this._chatUserDao = new ChatUserDao_Impl(this);
            }
            chatUserDao = this._chatUserDao;
        }
        return chatUserDao;
    }

    public final ChatChannelUsersJoinDao chatChannelUserDao() {
        ChatChannelUsersJoinDao chatChannelUsersJoinDao;
        if (this._chatChannelUsersJoinDao != null) {
            return this._chatChannelUsersJoinDao;
        }
        synchronized (this) {
            if (this._chatChannelUsersJoinDao == null) {
                this._chatChannelUsersJoinDao = new ChatChannelUsersJoinDao_Impl(this);
            }
            chatChannelUsersJoinDao = this._chatChannelUsersJoinDao;
        }
        return chatChannelUsersJoinDao;
    }
}
