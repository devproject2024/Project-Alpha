package com.paytm.android.chat.data.db.room.dao;

import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.room.rxjava3.b;
import androidx.sqlite.db.f;
import com.paytm.android.chat.data.db.room.converters.Converters;
import com.paytm.android.chat.data.db.room.dao.ChatUserDao;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import io.reactivex.rxjava3.a.h;
import java.util.List;
import java.util.concurrent.Callable;

public final class ChatUserDao_Impl implements ChatUserDao {
    /* access modifiers changed from: private */
    public final Converters __converters = new Converters();
    /* access modifiers changed from: private */
    public final j __db;
    private final c<ChatUserEntity> __insertionAdapterOfChatUserEntity;
    private final q __preparedStmtOfDeleteAllChatUsers;
    private final q __preparedStmtOfDeleteChatUser;

    public ChatUserDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfChatUserEntity = new c<ChatUserEntity>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `ChatUserEntity` (`primaryKey`,`identifier`,`sendbirdUserId`,`type`,`avatarUrl`,`isUserFake`,`sendbirdUserName`,`lastSeenAt`,`isActive`,`friendName`,`friendDiscoveryKey`,`isBlockingMe`,`isBlockedByMe`,`connectionStatus`,`isMuted`,`rawMember`,`phoneNumber`,`phoneHash`,`contactId`,`source`,`userMetadata`,`userExtendedMetaData`,`lastUpdatedUserExtendedMetaData`,`createdAt`,`updatedAt`,`paymentIdentifier`,`paymentIdentifierType`,`name`,`bankName`,`accRefId`,`mobileNo`,`mid`,`txnCategory`,`vpa`,`isVerifiedMerchant`,`bankLogoUrl`,`ifsc`,`maskedAccNo`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                ChatUserEntity chatUserEntity = (ChatUserEntity) obj;
                fVar.a(1, chatUserEntity.getPrimaryKey());
                if (chatUserEntity.getIdentifier() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, chatUserEntity.getIdentifier());
                }
                if (chatUserEntity.getSendbirdUserId() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, chatUserEntity.getSendbirdUserId());
                }
                if (chatUserEntity.getType() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, chatUserEntity.getType());
                }
                if (chatUserEntity.getAvatarUrl() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, chatUserEntity.getAvatarUrl());
                }
                fVar.a(6, chatUserEntity.isUserFake() ? 1 : 0);
                if (chatUserEntity.getSendbirdUserName() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, chatUserEntity.getSendbirdUserName());
                }
                if (chatUserEntity.getLastSeenAt() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, chatUserEntity.getLastSeenAt());
                }
                Integer valueOf = chatUserEntity.isActive() == null ? null : Integer.valueOf(chatUserEntity.isActive().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, (long) valueOf.intValue());
                }
                if (chatUserEntity.getFriendName() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, chatUserEntity.getFriendName());
                }
                if (chatUserEntity.getFriendDiscoveryKey() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, chatUserEntity.getFriendDiscoveryKey());
                }
                fVar.a(12, chatUserEntity.isBlockingMe() ? 1 : 0);
                fVar.a(13, chatUserEntity.isBlockedByMe() ? 1 : 0);
                if (chatUserEntity.getConnectionStatus() == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, chatUserEntity.getConnectionStatus());
                }
                fVar.a(15, chatUserEntity.isMuted() ? 1 : 0);
                if (chatUserEntity.getRawMember() == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, chatUserEntity.getRawMember());
                }
                if (chatUserEntity.getPhoneNumber() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, chatUserEntity.getPhoneNumber());
                }
                if (chatUserEntity.getPhoneHash() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, chatUserEntity.getPhoneHash());
                }
                if (chatUserEntity.getContactId() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, chatUserEntity.getContactId());
                }
                String fromUserInfoSource = ChatUserDao_Impl.this.__converters.fromUserInfoSource(chatUserEntity.getSource());
                if (fromUserInfoSource == null) {
                    fVar.a(20);
                } else {
                    fVar.a(20, fromUserInfoSource);
                }
                String fromUserMetaData = ChatUserDao_Impl.this.__converters.fromUserMetaData(chatUserEntity.getUserMetadata());
                if (fromUserMetaData == null) {
                    fVar.a(21);
                } else {
                    fVar.a(21, fromUserMetaData);
                }
                String fromUserExtendedMeta = ChatUserDao_Impl.this.__converters.fromUserExtendedMeta(chatUserEntity.getUserExtendedMetaData());
                if (fromUserExtendedMeta == null) {
                    fVar.a(22);
                } else {
                    fVar.a(22, fromUserExtendedMeta);
                }
                fVar.a(23, chatUserEntity.getLastUpdatedUserExtendedMetaData());
                fVar.a(24, chatUserEntity.getCreatedAt());
                fVar.a(25, chatUserEntity.getUpdatedAt());
                if (chatUserEntity.getPaymentIdentifier() == null) {
                    fVar.a(26);
                } else {
                    fVar.a(26, chatUserEntity.getPaymentIdentifier());
                }
                if (chatUserEntity.getPaymentIdentifierType() == null) {
                    fVar.a(27);
                } else {
                    fVar.a(27, chatUserEntity.getPaymentIdentifierType());
                }
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata = chatUserEntity.getChatPaymentMetadata();
                if (chatPaymentMetadata != null) {
                    if (chatPaymentMetadata.getName() == null) {
                        fVar.a(28);
                    } else {
                        fVar.a(28, chatPaymentMetadata.getName());
                    }
                    if (chatPaymentMetadata.getBankName() == null) {
                        fVar.a(29);
                    } else {
                        fVar.a(29, chatPaymentMetadata.getBankName());
                    }
                    if (chatPaymentMetadata.getAccRefId() == null) {
                        fVar.a(30);
                    } else {
                        fVar.a(30, chatPaymentMetadata.getAccRefId());
                    }
                    if (chatPaymentMetadata.getMobileNo() == null) {
                        fVar.a(31);
                    } else {
                        fVar.a(31, chatPaymentMetadata.getMobileNo());
                    }
                    if (chatPaymentMetadata.getMid() == null) {
                        fVar.a(32);
                    } else {
                        fVar.a(32, chatPaymentMetadata.getMid());
                    }
                    if (chatPaymentMetadata.getTxnCategory() == null) {
                        fVar.a(33);
                    } else {
                        fVar.a(33, chatPaymentMetadata.getTxnCategory());
                    }
                    if (chatPaymentMetadata.getVpa() == null) {
                        fVar.a(34);
                    } else {
                        fVar.a(34, chatPaymentMetadata.getVpa());
                    }
                    Integer valueOf2 = chatPaymentMetadata.isVerifiedMerchant() == null ? null : Integer.valueOf(chatPaymentMetadata.isVerifiedMerchant().booleanValue() ? 1 : 0);
                    if (valueOf2 == null) {
                        fVar.a(35);
                    } else {
                        fVar.a(35, (long) valueOf2.intValue());
                    }
                    if (chatPaymentMetadata.getBankLogoUrl() == null) {
                        fVar.a(36);
                    } else {
                        fVar.a(36, chatPaymentMetadata.getBankLogoUrl());
                    }
                    if (chatPaymentMetadata.getIfsc() == null) {
                        fVar.a(37);
                    } else {
                        fVar.a(37, chatPaymentMetadata.getIfsc());
                    }
                    if (chatPaymentMetadata.getMaskedAccNo() == null) {
                        fVar.a(38);
                    } else {
                        fVar.a(38, chatPaymentMetadata.getMaskedAccNo());
                    }
                } else {
                    fVar.a(28);
                    fVar.a(29);
                    fVar.a(30);
                    fVar.a(31);
                    fVar.a(32);
                    fVar.a(33);
                    fVar.a(34);
                    fVar.a(35);
                    fVar.a(36);
                    fVar.a(37);
                    fVar.a(38);
                }
            }
        };
        this.__preparedStmtOfDeleteChatUser = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatUserEntity WHERE sendbirdUserId = ?";
            }
        };
        this.__preparedStmtOfDeleteAllChatUsers = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatUserEntity";
            }
        };
    }

    public final void insert(ChatUserEntity chatUserEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfChatUserEntity.insert(chatUserEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void upsert(List<ChatUserEntity> list) {
        this.__db.beginTransaction();
        try {
            ChatUserDao.DefaultImpls.upsert(this, list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void deleteChatUser(String str) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteChatUser.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteChatUser.release(acquire);
        }
    }

    public final void deleteAllChatUsers() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteAllChatUsers.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllChatUsers.release(acquire);
        }
    }

    public final h<List<ChatUserEntity>> getAllChatUsers() {
        final m a2 = m.a("SELECT * FROM ChatUserEntity", 0);
        return b.a(this.__db, new String[]{"ChatUserEntity"}, new Callable<List<ChatUserEntity>>() {
            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x021d A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0221 A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x0245 A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0248 A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0257 A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0288 A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x028c A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x029a A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x029e A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x02b7 A[Catch:{ all -> 0x03a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x02bb A[Catch:{ all -> 0x03a5 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity> call() throws java.lang.Exception {
                /*
                    r55 = this;
                    r1 = r55
                    com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl.this
                    androidx.room.j r0 = r0.__db
                    androidx.room.m r2 = r0
                    r3 = 0
                    android.database.Cursor r2 = androidx.room.b.c.a(r0, r2, r3)
                    java.lang.String r0 = "primaryKey"
                    int r0 = androidx.room.b.b.b(r2, r0)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r4 = "identifier"
                    int r4 = androidx.room.b.b.b(r2, r4)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r5 = "sendbirdUserId"
                    int r5 = androidx.room.b.b.b(r2, r5)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r6 = "type"
                    int r6 = androidx.room.b.b.b(r2, r6)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r7 = "avatarUrl"
                    int r7 = androidx.room.b.b.b(r2, r7)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r8 = "isUserFake"
                    int r8 = androidx.room.b.b.b(r2, r8)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r9 = "sendbirdUserName"
                    int r9 = androidx.room.b.b.b(r2, r9)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r10 = "lastSeenAt"
                    int r10 = androidx.room.b.b.b(r2, r10)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r11 = "isActive"
                    int r11 = androidx.room.b.b.b(r2, r11)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r12 = "friendName"
                    int r12 = androidx.room.b.b.b(r2, r12)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r13 = "friendDiscoveryKey"
                    int r13 = androidx.room.b.b.b(r2, r13)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r14 = "isBlockingMe"
                    int r14 = androidx.room.b.b.b(r2, r14)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r15 = "isBlockedByMe"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r3 = "connectionStatus"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r1 = "isMuted"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r16 = r1
                    java.lang.String r1 = "rawMember"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r17 = r1
                    java.lang.String r1 = "phoneNumber"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r18 = r1
                    java.lang.String r1 = "phoneHash"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r19 = r1
                    java.lang.String r1 = "contactId"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r20 = r1
                    java.lang.String r1 = "source"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r21 = r1
                    java.lang.String r1 = "userMetadata"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r22 = r1
                    java.lang.String r1 = "userExtendedMetaData"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r23 = r1
                    java.lang.String r1 = "lastUpdatedUserExtendedMetaData"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r24 = r1
                    java.lang.String r1 = "createdAt"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r25 = r1
                    java.lang.String r1 = "updatedAt"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r26 = r1
                    java.lang.String r1 = "paymentIdentifier"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r27 = r1
                    java.lang.String r1 = "paymentIdentifierType"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r28 = r1
                    java.lang.String r1 = "name"
                    int r1 = androidx.room.b.b.b(r2, r1)     // Catch:{ all -> 0x03a5 }
                    r29 = r3
                    java.lang.String r3 = "bankName"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x03a5 }
                    r30 = r15
                    java.lang.String r15 = "accRefId"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x03a5 }
                    r31 = r14
                    java.lang.String r14 = "mobileNo"
                    int r14 = androidx.room.b.b.b(r2, r14)     // Catch:{ all -> 0x03a5 }
                    r32 = r13
                    java.lang.String r13 = "mid"
                    int r13 = androidx.room.b.b.b(r2, r13)     // Catch:{ all -> 0x03a5 }
                    r33 = r12
                    java.lang.String r12 = "txnCategory"
                    int r12 = androidx.room.b.b.b(r2, r12)     // Catch:{ all -> 0x03a5 }
                    r34 = r11
                    java.lang.String r11 = "vpa"
                    int r11 = androidx.room.b.b.b(r2, r11)     // Catch:{ all -> 0x03a5 }
                    r35 = r10
                    java.lang.String r10 = "isVerifiedMerchant"
                    int r10 = androidx.room.b.b.b(r2, r10)     // Catch:{ all -> 0x03a5 }
                    r36 = r9
                    java.lang.String r9 = "bankLogoUrl"
                    int r9 = androidx.room.b.b.b(r2, r9)     // Catch:{ all -> 0x03a5 }
                    r37 = r8
                    java.lang.String r8 = "ifsc"
                    int r8 = androidx.room.b.b.b(r2, r8)     // Catch:{ all -> 0x03a5 }
                    r38 = r7
                    java.lang.String r7 = "maskedAccNo"
                    int r7 = androidx.room.b.b.b(r2, r7)     // Catch:{ all -> 0x03a5 }
                    r39 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03a5 }
                    r40 = r5
                    int r5 = r2.getCount()     // Catch:{ all -> 0x03a5 }
                    r6.<init>(r5)     // Catch:{ all -> 0x03a5 }
                L_0x0137:
                    boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x03a1
                    boolean r5 = r2.isNull(r1)     // Catch:{ all -> 0x03a5 }
                    r41 = 0
                    r42 = 1
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r3)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r10)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r9)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r8)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x0189
                    boolean r5 = r2.isNull(r7)     // Catch:{ all -> 0x03a5 }
                    if (r5 != 0) goto L_0x0184
                    goto L_0x0189
                L_0x0184:
                    r43 = r1
                    r5 = r41
                    goto L_0x01df
                L_0x0189:
                    java.lang.String r44 = r2.getString(r1)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r45 = r2.getString(r3)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r46 = r2.getString(r15)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r47 = r2.getString(r14)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r48 = r2.getString(r13)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r49 = r2.getString(r12)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r50 = r2.getString(r11)     // Catch:{ all -> 0x03a5 }
                    boolean r5 = r2.isNull(r10)     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x01ae
                    r5 = r41
                    goto L_0x01b6
                L_0x01ae:
                    int r5 = r2.getInt(r10)     // Catch:{ all -> 0x03a5 }
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x03a5 }
                L_0x01b6:
                    if (r5 != 0) goto L_0x01bb
                    r51 = r41
                    goto L_0x01ca
                L_0x01bb:
                    int r5 = r5.intValue()     // Catch:{ all -> 0x03a5 }
                    if (r5 == 0) goto L_0x01c3
                    r5 = 1
                    goto L_0x01c4
                L_0x01c3:
                    r5 = 0
                L_0x01c4:
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x03a5 }
                    r51 = r5
                L_0x01ca:
                    java.lang.String r52 = r2.getString(r9)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r53 = r2.getString(r8)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r54 = r2.getString(r7)     // Catch:{ all -> 0x03a5 }
                    com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r5 = new com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata     // Catch:{ all -> 0x03a5 }
                    r43 = r5
                    r43.<init>(r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)     // Catch:{ all -> 0x03a5 }
                    r43 = r1
                L_0x01df:
                    com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity r1 = new com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity     // Catch:{ all -> 0x03a5 }
                    r1.<init>()     // Catch:{ all -> 0x03a5 }
                    r45 = r7
                    r44 = r8
                    long r7 = r2.getLong(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setPrimaryKey(r7)     // Catch:{ all -> 0x03a5 }
                    java.lang.String r7 = r2.getString(r4)     // Catch:{ all -> 0x03a5 }
                    r1.setIdentifier(r7)     // Catch:{ all -> 0x03a5 }
                    r7 = r40
                    java.lang.String r8 = r2.getString(r7)     // Catch:{ all -> 0x03a5 }
                    r1.setSendbirdUserId(r8)     // Catch:{ all -> 0x03a5 }
                    r8 = r39
                    r39 = r0
                    java.lang.String r0 = r2.getString(r8)     // Catch:{ all -> 0x03a5 }
                    r1.setType(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r38
                    r38 = r3
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setAvatarUrl(r3)     // Catch:{ all -> 0x03a5 }
                    r3 = r37
                    int r37 = r2.getInt(r3)     // Catch:{ all -> 0x03a5 }
                    if (r37 == 0) goto L_0x0221
                    r37 = r0
                    r0 = 1
                    goto L_0x0224
                L_0x0221:
                    r37 = r0
                    r0 = 0
                L_0x0224:
                    r1.setUserFake(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r36
                    r36 = r3
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setSendbirdUserName(r3)     // Catch:{ all -> 0x03a5 }
                    r3 = r35
                    r35 = r0
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setLastSeenAt(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r34
                    boolean r34 = r2.isNull(r0)     // Catch:{ all -> 0x03a5 }
                    if (r34 == 0) goto L_0x0248
                    r34 = r41
                    goto L_0x0250
                L_0x0248:
                    int r34 = r2.getInt(r0)     // Catch:{ all -> 0x03a5 }
                    java.lang.Integer r34 = java.lang.Integer.valueOf(r34)     // Catch:{ all -> 0x03a5 }
                L_0x0250:
                    if (r34 != 0) goto L_0x0257
                L_0x0252:
                    r34 = r0
                    r0 = r41
                    goto L_0x0267
                L_0x0257:
                    int r34 = r34.intValue()     // Catch:{ all -> 0x03a5 }
                    if (r34 == 0) goto L_0x0260
                    r34 = 1
                    goto L_0x0262
                L_0x0260:
                    r34 = 0
                L_0x0262:
                    java.lang.Boolean r41 = java.lang.Boolean.valueOf(r34)     // Catch:{ all -> 0x03a5 }
                    goto L_0x0252
                L_0x0267:
                    r1.setActive(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r33
                    r33 = r3
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setFriendName(r3)     // Catch:{ all -> 0x03a5 }
                    r3 = r32
                    r32 = r0
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setFriendDiscoveryKey(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r31
                    int r31 = r2.getInt(r0)     // Catch:{ all -> 0x03a5 }
                    if (r31 == 0) goto L_0x028c
                    r31 = r0
                    r0 = 1
                    goto L_0x028f
                L_0x028c:
                    r31 = r0
                    r0 = 0
                L_0x028f:
                    r1.setBlockingMe(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r30
                    int r30 = r2.getInt(r0)     // Catch:{ all -> 0x03a5 }
                    if (r30 == 0) goto L_0x029e
                    r30 = r0
                    r0 = 1
                    goto L_0x02a1
                L_0x029e:
                    r30 = r0
                    r0 = 0
                L_0x02a1:
                    r1.setBlockedByMe(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r29
                    r29 = r3
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setConnectionStatus(r3)     // Catch:{ all -> 0x03a5 }
                    r3 = r16
                    int r16 = r2.getInt(r3)     // Catch:{ all -> 0x03a5 }
                    if (r16 == 0) goto L_0x02bb
                    r16 = r0
                    r0 = 1
                    goto L_0x02be
                L_0x02bb:
                    r16 = r0
                    r0 = 0
                L_0x02be:
                    r1.setMuted(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r17
                    r17 = r3
                    byte[] r3 = r2.getBlob(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setRawMember(r3)     // Catch:{ all -> 0x03a5 }
                    r3 = r18
                    r18 = r0
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setPhoneNumber(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r19
                    r19 = r3
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setPhoneHash(r3)     // Catch:{ all -> 0x03a5 }
                    r3 = r20
                    r20 = r0
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setContactId(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r21
                    r21 = r3
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r41 = r0
                    r40 = r4
                    r4 = r55
                    com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl.this     // Catch:{ all -> 0x03a5 }
                    com.paytm.android.chat.data.db.room.converters.Converters r0 = r0.__converters     // Catch:{ all -> 0x03a5 }
                    com.paytm.android.chat.data.db.room.db_entities.UserInfoSource r0 = r0.toUserInfoSource(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setSource(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r22
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r22 = r0
                    com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl.this     // Catch:{ all -> 0x03a5 }
                    com.paytm.android.chat.data.db.room.converters.Converters r0 = r0.__converters     // Catch:{ all -> 0x03a5 }
                    com.paytm.android.chat.bean.UserMetaData r0 = r0.toUserMetaData(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setUserMetadata(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r23
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x03a5 }
                    r23 = r0
                    com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl.this     // Catch:{ all -> 0x03a5 }
                    com.paytm.android.chat.data.db.room.converters.Converters r0 = r0.__converters     // Catch:{ all -> 0x03a5 }
                    com.paytm.android.chat.bean.UserExtendedMetaData r0 = r0.toUserExtendedMetaData(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setUserExtendedMetaData(r0)     // Catch:{ all -> 0x03a5 }
                    r0 = r24
                    long r3 = r2.getLong(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setLastUpdatedUserExtendedMetaData(r3)     // Catch:{ all -> 0x03a5 }
                    r4 = r7
                    r24 = r8
                    r3 = r25
                    long r7 = r2.getLong(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setCreatedAt(r7)     // Catch:{ all -> 0x03a5 }
                    r25 = r3
                    r8 = r4
                    r7 = r26
                    long r3 = r2.getLong(r7)     // Catch:{ all -> 0x03a5 }
                    r1.setUpdatedAt(r3)     // Catch:{ all -> 0x03a5 }
                    r3 = r27
                    java.lang.String r4 = r2.getString(r3)     // Catch:{ all -> 0x03a5 }
                    r1.setPaymentIdentifier(r4)     // Catch:{ all -> 0x03a5 }
                    r26 = r0
                    r4 = r28
                    java.lang.String r0 = r2.getString(r4)     // Catch:{ all -> 0x03a5 }
                    r1.setPaymentIdentifierType(r0)     // Catch:{ all -> 0x03a5 }
                    r1.setChatPaymentMetadata(r5)     // Catch:{ all -> 0x03a5 }
                    r6.add(r1)     // Catch:{ all -> 0x03a5 }
                    r27 = r3
                    r28 = r4
                    r3 = r38
                    r0 = r39
                    r4 = r40
                    r1 = r43
                    r40 = r8
                    r39 = r24
                    r24 = r26
                    r38 = r37
                    r8 = r44
                    r26 = r7
                    r37 = r36
                    r7 = r45
                    r36 = r35
                    r35 = r33
                    r33 = r32
                    r32 = r29
                    r29 = r16
                    r16 = r17
                    r17 = r18
                    r18 = r19
                    r19 = r20
                    r20 = r21
                    r21 = r41
                    goto L_0x0137
                L_0x03a1:
                    r2.close()
                    return r6
                L_0x03a5:
                    r0 = move-exception
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl.AnonymousClass4.call():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0212 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0214 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0232 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0235 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0242 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x026d A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x026f A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x027b A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x027d A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0292 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0294 A[Catch:{ all -> 0x0329 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity getChatUserBySendbirdId(java.lang.String r55) {
        /*
            r54 = this;
            r1 = r54
            r0 = r55
            r2 = 1
            java.lang.String r3 = "SELECT * FROM ChatUserEntity WHERE sendbirdUserId = ?"
            androidx.room.m r3 = androidx.room.m.a((java.lang.String) r3, (int) r2)
            if (r0 != 0) goto L_0x0012
            int[] r0 = r3.f4477f
            r0[r2] = r2
            goto L_0x0015
        L_0x0012:
            r3.a((int) r2, (java.lang.String) r0)
        L_0x0015:
            androidx.room.j r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.j r0 = r1.__db
            r4 = 0
            android.database.Cursor r5 = androidx.room.b.c.a(r0, r3, r4)
            java.lang.String r0 = "primaryKey"
            int r0 = androidx.room.b.b.b(r5, r0)     // Catch:{ all -> 0x032f }
            java.lang.String r6 = "identifier"
            int r6 = androidx.room.b.b.b(r5, r6)     // Catch:{ all -> 0x032f }
            java.lang.String r7 = "sendbirdUserId"
            int r7 = androidx.room.b.b.b(r5, r7)     // Catch:{ all -> 0x032f }
            java.lang.String r8 = "type"
            int r8 = androidx.room.b.b.b(r5, r8)     // Catch:{ all -> 0x032f }
            java.lang.String r9 = "avatarUrl"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x032f }
            java.lang.String r10 = "isUserFake"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x032f }
            java.lang.String r11 = "sendbirdUserName"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x032f }
            java.lang.String r12 = "lastSeenAt"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x032f }
            java.lang.String r13 = "isActive"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x032f }
            java.lang.String r14 = "friendName"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x032f }
            java.lang.String r15 = "friendDiscoveryKey"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x032f }
            java.lang.String r2 = "isBlockingMe"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x032f }
            java.lang.String r4 = "isBlockedByMe"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x032f }
            r16 = r3
            java.lang.String r3 = "connectionStatus"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x032d }
            java.lang.String r1 = "isMuted"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r17 = r1
            java.lang.String r1 = "rawMember"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r18 = r1
            java.lang.String r1 = "phoneNumber"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r19 = r1
            java.lang.String r1 = "phoneHash"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r20 = r1
            java.lang.String r1 = "contactId"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r21 = r1
            java.lang.String r1 = "source"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r22 = r1
            java.lang.String r1 = "userMetadata"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r23 = r1
            java.lang.String r1 = "userExtendedMetaData"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r24 = r1
            java.lang.String r1 = "lastUpdatedUserExtendedMetaData"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r25 = r1
            java.lang.String r1 = "createdAt"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r26 = r1
            java.lang.String r1 = "updatedAt"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r27 = r1
            java.lang.String r1 = "paymentIdentifier"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r28 = r1
            java.lang.String r1 = "paymentIdentifierType"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r29 = r1
            java.lang.String r1 = "name"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r30 = r3
            java.lang.String r3 = "bankName"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0329 }
            r31 = r4
            java.lang.String r4 = "accRefId"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x0329 }
            r32 = r2
            java.lang.String r2 = "mobileNo"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x0329 }
            r33 = r15
            java.lang.String r15 = "mid"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x0329 }
            r34 = r14
            java.lang.String r14 = "txnCategory"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x0329 }
            r35 = r13
            java.lang.String r13 = "vpa"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x0329 }
            r36 = r12
            java.lang.String r12 = "isVerifiedMerchant"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x0329 }
            r37 = r11
            java.lang.String r11 = "bankLogoUrl"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x0329 }
            r38 = r10
            java.lang.String r10 = "ifsc"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x0329 }
            r39 = r9
            java.lang.String r9 = "maskedAccNo"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x0329 }
            boolean r40 = r5.moveToFirst()     // Catch:{ all -> 0x0329 }
            r41 = 0
            if (r40 == 0) goto L_0x031e
            boolean r40 = r5.isNull(r1)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r3)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r4)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r2)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r15)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r14)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r13)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r12)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r11)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r10)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r9)     // Catch:{ all -> 0x0329 }
            if (r40 != 0) goto L_0x0189
            goto L_0x018c
        L_0x0189:
            r1 = r41
            goto L_0x01e0
        L_0x018c:
            java.lang.String r43 = r5.getString(r1)     // Catch:{ all -> 0x0329 }
            java.lang.String r44 = r5.getString(r3)     // Catch:{ all -> 0x0329 }
            java.lang.String r45 = r5.getString(r4)     // Catch:{ all -> 0x0329 }
            java.lang.String r46 = r5.getString(r2)     // Catch:{ all -> 0x0329 }
            java.lang.String r47 = r5.getString(r15)     // Catch:{ all -> 0x0329 }
            java.lang.String r48 = r5.getString(r14)     // Catch:{ all -> 0x0329 }
            java.lang.String r49 = r5.getString(r13)     // Catch:{ all -> 0x0329 }
            boolean r1 = r5.isNull(r12)     // Catch:{ all -> 0x0329 }
            if (r1 == 0) goto L_0x01b1
            r1 = r41
            goto L_0x01b9
        L_0x01b1:
            int r1 = r5.getInt(r12)     // Catch:{ all -> 0x0329 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0329 }
        L_0x01b9:
            if (r1 != 0) goto L_0x01be
            r50 = r41
            goto L_0x01cd
        L_0x01be:
            int r1 = r1.intValue()     // Catch:{ all -> 0x0329 }
            if (r1 == 0) goto L_0x01c6
            r1 = 1
            goto L_0x01c7
        L_0x01c6:
            r1 = 0
        L_0x01c7:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0329 }
            r50 = r1
        L_0x01cd:
            java.lang.String r51 = r5.getString(r11)     // Catch:{ all -> 0x0329 }
            java.lang.String r52 = r5.getString(r10)     // Catch:{ all -> 0x0329 }
            java.lang.String r53 = r5.getString(r9)     // Catch:{ all -> 0x0329 }
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r1 = new com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata     // Catch:{ all -> 0x0329 }
            r42 = r1
            r42.<init>(r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53)     // Catch:{ all -> 0x0329 }
        L_0x01e0:
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity r2 = new com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity     // Catch:{ all -> 0x0329 }
            r2.<init>()     // Catch:{ all -> 0x0329 }
            long r3 = r5.getLong(r0)     // Catch:{ all -> 0x0329 }
            r2.setPrimaryKey(r3)     // Catch:{ all -> 0x0329 }
            java.lang.String r0 = r5.getString(r6)     // Catch:{ all -> 0x0329 }
            r2.setIdentifier(r0)     // Catch:{ all -> 0x0329 }
            java.lang.String r0 = r5.getString(r7)     // Catch:{ all -> 0x0329 }
            r2.setSendbirdUserId(r0)     // Catch:{ all -> 0x0329 }
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x0329 }
            r2.setType(r0)     // Catch:{ all -> 0x0329 }
            r0 = r39
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setAvatarUrl(r0)     // Catch:{ all -> 0x0329 }
            r0 = r38
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x0214
            r0 = 1
            goto L_0x0215
        L_0x0214:
            r0 = 0
        L_0x0215:
            r2.setUserFake(r0)     // Catch:{ all -> 0x0329 }
            r0 = r37
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setSendbirdUserName(r0)     // Catch:{ all -> 0x0329 }
            r0 = r36
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setLastSeenAt(r0)     // Catch:{ all -> 0x0329 }
            r0 = r35
            boolean r3 = r5.isNull(r0)     // Catch:{ all -> 0x0329 }
            if (r3 == 0) goto L_0x0235
            r0 = r41
            goto L_0x023d
        L_0x0235:
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0329 }
        L_0x023d:
            if (r0 != 0) goto L_0x0242
        L_0x023f:
            r0 = r41
            goto L_0x0250
        L_0x0242:
            int r0 = r0.intValue()     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x024a
            r0 = 1
            goto L_0x024b
        L_0x024a:
            r0 = 0
        L_0x024b:
            java.lang.Boolean r41 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0329 }
            goto L_0x023f
        L_0x0250:
            r2.setActive(r0)     // Catch:{ all -> 0x0329 }
            r0 = r34
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setFriendName(r0)     // Catch:{ all -> 0x0329 }
            r0 = r33
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setFriendDiscoveryKey(r0)     // Catch:{ all -> 0x0329 }
            r0 = r32
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x026f
            r0 = 1
            goto L_0x0270
        L_0x026f:
            r0 = 0
        L_0x0270:
            r2.setBlockingMe(r0)     // Catch:{ all -> 0x0329 }
            r0 = r31
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x027d
            r0 = 1
            goto L_0x027e
        L_0x027d:
            r0 = 0
        L_0x027e:
            r2.setBlockedByMe(r0)     // Catch:{ all -> 0x0329 }
            r0 = r30
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setConnectionStatus(r0)     // Catch:{ all -> 0x0329 }
            r0 = r17
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x0294
            r0 = 1
            goto L_0x0295
        L_0x0294:
            r0 = 0
        L_0x0295:
            r2.setMuted(r0)     // Catch:{ all -> 0x0329 }
            r0 = r18
            byte[] r0 = r5.getBlob(r0)     // Catch:{ all -> 0x0329 }
            r2.setRawMember(r0)     // Catch:{ all -> 0x0329 }
            r0 = r19
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setPhoneNumber(r0)     // Catch:{ all -> 0x0329 }
            r0 = r20
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setPhoneHash(r0)     // Catch:{ all -> 0x0329 }
            r0 = r21
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setContactId(r0)     // Catch:{ all -> 0x0329 }
            r0 = r22
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r3 = r54
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r3.__converters     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.data.db.room.db_entities.UserInfoSource r0 = r4.toUserInfoSource(r0)     // Catch:{ all -> 0x031c }
            r2.setSource(r0)     // Catch:{ all -> 0x031c }
            r0 = r23
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r3.__converters     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.bean.UserMetaData r0 = r4.toUserMetaData(r0)     // Catch:{ all -> 0x031c }
            r2.setUserMetadata(r0)     // Catch:{ all -> 0x031c }
            r0 = r24
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r3.__converters     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.bean.UserExtendedMetaData r0 = r4.toUserExtendedMetaData(r0)     // Catch:{ all -> 0x031c }
            r2.setUserExtendedMetaData(r0)     // Catch:{ all -> 0x031c }
            r0 = r25
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x031c }
            r2.setLastUpdatedUserExtendedMetaData(r6)     // Catch:{ all -> 0x031c }
            r0 = r26
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x031c }
            r2.setCreatedAt(r6)     // Catch:{ all -> 0x031c }
            r0 = r27
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x031c }
            r2.setUpdatedAt(r6)     // Catch:{ all -> 0x031c }
            r0 = r28
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            r2.setPaymentIdentifier(r0)     // Catch:{ all -> 0x031c }
            r0 = r29
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            r2.setPaymentIdentifierType(r0)     // Catch:{ all -> 0x031c }
            r2.setChatPaymentMetadata(r1)     // Catch:{ all -> 0x031c }
            goto L_0x0322
        L_0x031c:
            r0 = move-exception
            goto L_0x0333
        L_0x031e:
            r3 = r54
            r2 = r41
        L_0x0322:
            r5.close()
            r16.a()
            return r2
        L_0x0329:
            r0 = move-exception
            r3 = r54
            goto L_0x0333
        L_0x032d:
            r0 = move-exception
            goto L_0x0332
        L_0x032f:
            r0 = move-exception
            r16 = r3
        L_0x0332:
            r3 = r1
        L_0x0333:
            r5.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl.getChatUserBySendbirdId(java.lang.String):com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0212 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0214 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0232 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0235 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0242 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x026d A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x026f A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x027b A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x027d A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0292 A[Catch:{ all -> 0x0329 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0294 A[Catch:{ all -> 0x0329 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity getChatUserByIdentifier(java.lang.String r55) {
        /*
            r54 = this;
            r1 = r54
            r0 = r55
            r2 = 1
            java.lang.String r3 = "SELECT * FROM ChatUserEntity WHERE identifier = ?"
            androidx.room.m r3 = androidx.room.m.a((java.lang.String) r3, (int) r2)
            if (r0 != 0) goto L_0x0012
            int[] r0 = r3.f4477f
            r0[r2] = r2
            goto L_0x0015
        L_0x0012:
            r3.a((int) r2, (java.lang.String) r0)
        L_0x0015:
            androidx.room.j r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.j r0 = r1.__db
            r4 = 0
            android.database.Cursor r5 = androidx.room.b.c.a(r0, r3, r4)
            java.lang.String r0 = "primaryKey"
            int r0 = androidx.room.b.b.b(r5, r0)     // Catch:{ all -> 0x032f }
            java.lang.String r6 = "identifier"
            int r6 = androidx.room.b.b.b(r5, r6)     // Catch:{ all -> 0x032f }
            java.lang.String r7 = "sendbirdUserId"
            int r7 = androidx.room.b.b.b(r5, r7)     // Catch:{ all -> 0x032f }
            java.lang.String r8 = "type"
            int r8 = androidx.room.b.b.b(r5, r8)     // Catch:{ all -> 0x032f }
            java.lang.String r9 = "avatarUrl"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x032f }
            java.lang.String r10 = "isUserFake"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x032f }
            java.lang.String r11 = "sendbirdUserName"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x032f }
            java.lang.String r12 = "lastSeenAt"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x032f }
            java.lang.String r13 = "isActive"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x032f }
            java.lang.String r14 = "friendName"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x032f }
            java.lang.String r15 = "friendDiscoveryKey"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x032f }
            java.lang.String r2 = "isBlockingMe"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x032f }
            java.lang.String r4 = "isBlockedByMe"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x032f }
            r16 = r3
            java.lang.String r3 = "connectionStatus"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x032d }
            java.lang.String r1 = "isMuted"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r17 = r1
            java.lang.String r1 = "rawMember"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r18 = r1
            java.lang.String r1 = "phoneNumber"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r19 = r1
            java.lang.String r1 = "phoneHash"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r20 = r1
            java.lang.String r1 = "contactId"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r21 = r1
            java.lang.String r1 = "source"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r22 = r1
            java.lang.String r1 = "userMetadata"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r23 = r1
            java.lang.String r1 = "userExtendedMetaData"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r24 = r1
            java.lang.String r1 = "lastUpdatedUserExtendedMetaData"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r25 = r1
            java.lang.String r1 = "createdAt"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r26 = r1
            java.lang.String r1 = "updatedAt"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r27 = r1
            java.lang.String r1 = "paymentIdentifier"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r28 = r1
            java.lang.String r1 = "paymentIdentifierType"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r29 = r1
            java.lang.String r1 = "name"
            int r1 = androidx.room.b.b.b(r5, r1)     // Catch:{ all -> 0x0329 }
            r30 = r3
            java.lang.String r3 = "bankName"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0329 }
            r31 = r4
            java.lang.String r4 = "accRefId"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x0329 }
            r32 = r2
            java.lang.String r2 = "mobileNo"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x0329 }
            r33 = r15
            java.lang.String r15 = "mid"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x0329 }
            r34 = r14
            java.lang.String r14 = "txnCategory"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x0329 }
            r35 = r13
            java.lang.String r13 = "vpa"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x0329 }
            r36 = r12
            java.lang.String r12 = "isVerifiedMerchant"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x0329 }
            r37 = r11
            java.lang.String r11 = "bankLogoUrl"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x0329 }
            r38 = r10
            java.lang.String r10 = "ifsc"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x0329 }
            r39 = r9
            java.lang.String r9 = "maskedAccNo"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x0329 }
            boolean r40 = r5.moveToFirst()     // Catch:{ all -> 0x0329 }
            r41 = 0
            if (r40 == 0) goto L_0x031e
            boolean r40 = r5.isNull(r1)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r3)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r4)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r2)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r15)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r14)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r13)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r12)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r11)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r10)     // Catch:{ all -> 0x0329 }
            if (r40 == 0) goto L_0x018c
            boolean r40 = r5.isNull(r9)     // Catch:{ all -> 0x0329 }
            if (r40 != 0) goto L_0x0189
            goto L_0x018c
        L_0x0189:
            r1 = r41
            goto L_0x01e0
        L_0x018c:
            java.lang.String r43 = r5.getString(r1)     // Catch:{ all -> 0x0329 }
            java.lang.String r44 = r5.getString(r3)     // Catch:{ all -> 0x0329 }
            java.lang.String r45 = r5.getString(r4)     // Catch:{ all -> 0x0329 }
            java.lang.String r46 = r5.getString(r2)     // Catch:{ all -> 0x0329 }
            java.lang.String r47 = r5.getString(r15)     // Catch:{ all -> 0x0329 }
            java.lang.String r48 = r5.getString(r14)     // Catch:{ all -> 0x0329 }
            java.lang.String r49 = r5.getString(r13)     // Catch:{ all -> 0x0329 }
            boolean r1 = r5.isNull(r12)     // Catch:{ all -> 0x0329 }
            if (r1 == 0) goto L_0x01b1
            r1 = r41
            goto L_0x01b9
        L_0x01b1:
            int r1 = r5.getInt(r12)     // Catch:{ all -> 0x0329 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0329 }
        L_0x01b9:
            if (r1 != 0) goto L_0x01be
            r50 = r41
            goto L_0x01cd
        L_0x01be:
            int r1 = r1.intValue()     // Catch:{ all -> 0x0329 }
            if (r1 == 0) goto L_0x01c6
            r1 = 1
            goto L_0x01c7
        L_0x01c6:
            r1 = 0
        L_0x01c7:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0329 }
            r50 = r1
        L_0x01cd:
            java.lang.String r51 = r5.getString(r11)     // Catch:{ all -> 0x0329 }
            java.lang.String r52 = r5.getString(r10)     // Catch:{ all -> 0x0329 }
            java.lang.String r53 = r5.getString(r9)     // Catch:{ all -> 0x0329 }
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r1 = new com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata     // Catch:{ all -> 0x0329 }
            r42 = r1
            r42.<init>(r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53)     // Catch:{ all -> 0x0329 }
        L_0x01e0:
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity r2 = new com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity     // Catch:{ all -> 0x0329 }
            r2.<init>()     // Catch:{ all -> 0x0329 }
            long r3 = r5.getLong(r0)     // Catch:{ all -> 0x0329 }
            r2.setPrimaryKey(r3)     // Catch:{ all -> 0x0329 }
            java.lang.String r0 = r5.getString(r6)     // Catch:{ all -> 0x0329 }
            r2.setIdentifier(r0)     // Catch:{ all -> 0x0329 }
            java.lang.String r0 = r5.getString(r7)     // Catch:{ all -> 0x0329 }
            r2.setSendbirdUserId(r0)     // Catch:{ all -> 0x0329 }
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x0329 }
            r2.setType(r0)     // Catch:{ all -> 0x0329 }
            r0 = r39
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setAvatarUrl(r0)     // Catch:{ all -> 0x0329 }
            r0 = r38
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x0214
            r0 = 1
            goto L_0x0215
        L_0x0214:
            r0 = 0
        L_0x0215:
            r2.setUserFake(r0)     // Catch:{ all -> 0x0329 }
            r0 = r37
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setSendbirdUserName(r0)     // Catch:{ all -> 0x0329 }
            r0 = r36
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setLastSeenAt(r0)     // Catch:{ all -> 0x0329 }
            r0 = r35
            boolean r3 = r5.isNull(r0)     // Catch:{ all -> 0x0329 }
            if (r3 == 0) goto L_0x0235
            r0 = r41
            goto L_0x023d
        L_0x0235:
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0329 }
        L_0x023d:
            if (r0 != 0) goto L_0x0242
        L_0x023f:
            r0 = r41
            goto L_0x0250
        L_0x0242:
            int r0 = r0.intValue()     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x024a
            r0 = 1
            goto L_0x024b
        L_0x024a:
            r0 = 0
        L_0x024b:
            java.lang.Boolean r41 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0329 }
            goto L_0x023f
        L_0x0250:
            r2.setActive(r0)     // Catch:{ all -> 0x0329 }
            r0 = r34
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setFriendName(r0)     // Catch:{ all -> 0x0329 }
            r0 = r33
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setFriendDiscoveryKey(r0)     // Catch:{ all -> 0x0329 }
            r0 = r32
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x026f
            r0 = 1
            goto L_0x0270
        L_0x026f:
            r0 = 0
        L_0x0270:
            r2.setBlockingMe(r0)     // Catch:{ all -> 0x0329 }
            r0 = r31
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x027d
            r0 = 1
            goto L_0x027e
        L_0x027d:
            r0 = 0
        L_0x027e:
            r2.setBlockedByMe(r0)     // Catch:{ all -> 0x0329 }
            r0 = r30
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setConnectionStatus(r0)     // Catch:{ all -> 0x0329 }
            r0 = r17
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0329 }
            if (r0 == 0) goto L_0x0294
            r0 = 1
            goto L_0x0295
        L_0x0294:
            r0 = 0
        L_0x0295:
            r2.setMuted(r0)     // Catch:{ all -> 0x0329 }
            r0 = r18
            byte[] r0 = r5.getBlob(r0)     // Catch:{ all -> 0x0329 }
            r2.setRawMember(r0)     // Catch:{ all -> 0x0329 }
            r0 = r19
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setPhoneNumber(r0)     // Catch:{ all -> 0x0329 }
            r0 = r20
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setPhoneHash(r0)     // Catch:{ all -> 0x0329 }
            r0 = r21
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r2.setContactId(r0)     // Catch:{ all -> 0x0329 }
            r0 = r22
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0329 }
            r3 = r54
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r3.__converters     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.data.db.room.db_entities.UserInfoSource r0 = r4.toUserInfoSource(r0)     // Catch:{ all -> 0x031c }
            r2.setSource(r0)     // Catch:{ all -> 0x031c }
            r0 = r23
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r3.__converters     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.bean.UserMetaData r0 = r4.toUserMetaData(r0)     // Catch:{ all -> 0x031c }
            r2.setUserMetadata(r0)     // Catch:{ all -> 0x031c }
            r0 = r24
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r3.__converters     // Catch:{ all -> 0x031c }
            com.paytm.android.chat.bean.UserExtendedMetaData r0 = r4.toUserExtendedMetaData(r0)     // Catch:{ all -> 0x031c }
            r2.setUserExtendedMetaData(r0)     // Catch:{ all -> 0x031c }
            r0 = r25
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x031c }
            r2.setLastUpdatedUserExtendedMetaData(r6)     // Catch:{ all -> 0x031c }
            r0 = r26
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x031c }
            r2.setCreatedAt(r6)     // Catch:{ all -> 0x031c }
            r0 = r27
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x031c }
            r2.setUpdatedAt(r6)     // Catch:{ all -> 0x031c }
            r0 = r28
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            r2.setPaymentIdentifier(r0)     // Catch:{ all -> 0x031c }
            r0 = r29
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x031c }
            r2.setPaymentIdentifierType(r0)     // Catch:{ all -> 0x031c }
            r2.setChatPaymentMetadata(r1)     // Catch:{ all -> 0x031c }
            goto L_0x0322
        L_0x031c:
            r0 = move-exception
            goto L_0x0333
        L_0x031e:
            r3 = r54
            r2 = r41
        L_0x0322:
            r5.close()
            r16.a()
            return r2
        L_0x0329:
            r0 = move-exception
            r3 = r54
            goto L_0x0333
        L_0x032d:
            r0 = move-exception
            goto L_0x0332
        L_0x032f:
            r0 = move-exception
            r16 = r3
        L_0x0332:
            r3 = r1
        L_0x0333:
            r5.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatUserDao_Impl.getChatUserByIdentifier(java.lang.String):com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity");
    }
}
