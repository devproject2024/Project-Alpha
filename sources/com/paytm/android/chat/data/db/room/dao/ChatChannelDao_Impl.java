package com.paytm.android.chat.data.db.room.dao;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.room.rxjava3.a;
import androidx.sqlite.db.f;
import com.paytm.android.chat.data.db.room.converters.Converters;
import com.paytm.android.chat.data.db.room.dao.ChatChannelDao;
import com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.y;
import java.util.List;
import java.util.concurrent.Callable;

public final class ChatChannelDao_Impl implements ChatChannelDao {
    /* access modifiers changed from: private */
    public final Converters __converters = new Converters();
    /* access modifiers changed from: private */
    public final j __db;
    /* access modifiers changed from: private */
    public final c<ChatChannelEntity> __insertionAdapterOfChatChannelEntity;
    /* access modifiers changed from: private */
    public final q __preparedStmtOfDeleteAllChannel;
    /* access modifiers changed from: private */
    public final q __preparedStmtOfDeleteChannel;
    /* access modifiers changed from: private */
    public final q __preparedStmtOfUpdateDraftMessage;
    /* access modifiers changed from: private */
    public final q __preparedStmtOfUpdatePinnedState;

    public ChatChannelDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfChatChannelEntity = new c<ChatChannelEntity>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `ChatChannelEntity` (`isFake`,`channelUrl`,`name`,`createdAt`,`isPinned`,`draftMessage`,`lastMessageTs`,`rawChannel`,`members`,`lastMessageId`,`lastMessageType`,`memberCount`,`myLastRead`,`unreadMessageCount`,`unreadMentionCount`,`data`,`createdBy`,`isBroadcast`,`customType`,`invitedAt`,`inviter`,`isDiscoverable`,`isDistinct`,`isHidden`,`isPublic`,`isPushEnabled`,`joinedMemberCount`,`metaData`,`payAllowed`,`requestAllowed`,`replyStatus`,`previewText`,`previewDrawable`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                ChatChannelEntity chatChannelEntity = (ChatChannelEntity) obj;
                fVar.a(1, chatChannelEntity.isFake() ? 1 : 0);
                if (chatChannelEntity.getChannelUrl() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, chatChannelEntity.getChannelUrl());
                }
                if (chatChannelEntity.getName() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, chatChannelEntity.getName());
                }
                if (chatChannelEntity.getCreatedAt() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, chatChannelEntity.getCreatedAt().longValue());
                }
                fVar.a(5, chatChannelEntity.isPinned() ? 1 : 0);
                if (chatChannelEntity.getDraftMessage() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, chatChannelEntity.getDraftMessage());
                }
                if (chatChannelEntity.getLastMessageTs() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, chatChannelEntity.getLastMessageTs().longValue());
                }
                if (chatChannelEntity.getRawChannel() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, chatChannelEntity.getRawChannel());
                }
                String memberListToJson = ChatChannelDao_Impl.this.__converters.memberListToJson(chatChannelEntity.getMembers());
                if (memberListToJson == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, memberListToJson);
                }
                if (chatChannelEntity.getLastMessageId() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, chatChannelEntity.getLastMessageId().longValue());
                }
                if (chatChannelEntity.getLastMessageType() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, chatChannelEntity.getLastMessageType());
                }
                fVar.a(12, (long) chatChannelEntity.getMemberCount());
                fVar.a(13, chatChannelEntity.getMyLastRead());
                fVar.a(14, (long) chatChannelEntity.getUnreadMessageCount());
                fVar.a(15, (long) chatChannelEntity.getUnreadMentionCount());
                if (chatChannelEntity.getData() == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, chatChannelEntity.getData());
                }
                if (chatChannelEntity.getCreatedBy() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, chatChannelEntity.getCreatedBy());
                }
                fVar.a(18, chatChannelEntity.isBroadcast() ? 1 : 0);
                if (chatChannelEntity.getCustomType() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, chatChannelEntity.getCustomType());
                }
                fVar.a(20, chatChannelEntity.getInvitedAt());
                if (chatChannelEntity.getInviter() == null) {
                    fVar.a(21);
                } else {
                    fVar.a(21, chatChannelEntity.getInviter());
                }
                fVar.a(22, chatChannelEntity.isDiscoverable() ? 1 : 0);
                fVar.a(23, chatChannelEntity.isDistinct() ? 1 : 0);
                fVar.a(24, chatChannelEntity.isHidden() ? 1 : 0);
                fVar.a(25, chatChannelEntity.isPublic() ? 1 : 0);
                fVar.a(26, chatChannelEntity.isPushEnabled() ? 1 : 0);
                fVar.a(27, (long) chatChannelEntity.getJoinedMemberCount());
                String fromChannelMetadataToJson = ChatChannelDao_Impl.this.__converters.fromChannelMetadataToJson(chatChannelEntity.getMetaData());
                if (fromChannelMetadataToJson == null) {
                    fVar.a(28);
                } else {
                    fVar.a(28, fromChannelMetadataToJson);
                }
                fVar.a(29, chatChannelEntity.getPayAllowed() ? 1 : 0);
                fVar.a(30, chatChannelEntity.getRequestAllowed() ? 1 : 0);
                fVar.a(31, chatChannelEntity.getReplyAllowed() ? 1 : 0);
                MPCMessagePreview messagePreview = chatChannelEntity.getMessagePreview();
                if (messagePreview != null) {
                    if (messagePreview.getPreviewText() == null) {
                        fVar.a(32);
                    } else {
                        fVar.a(32, messagePreview.getPreviewText());
                    }
                    Integer messagePreviewDrawable = ChatChannelDao_Impl.this.__converters.toMessagePreviewDrawable(messagePreview.getPreviewDrawable());
                    if (messagePreviewDrawable == null) {
                        fVar.a(33);
                    } else {
                        fVar.a(33, (long) messagePreviewDrawable.intValue());
                    }
                } else {
                    fVar.a(32);
                    fVar.a(33);
                }
            }
        };
        this.__preparedStmtOfUpdatePinnedState = new q(jVar) {
            public final String createQuery() {
                return "UPDATE ChatChannelEntity SET isPinned = ? WHERE channelUrl = ?";
            }
        };
        this.__preparedStmtOfUpdateDraftMessage = new q(jVar) {
            public final String createQuery() {
                return "UPDATE ChatChannelEntity SET draftMessage = ? WHERE channelUrl = ?";
            }
        };
        this.__preparedStmtOfDeleteChannel = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatChannelEntity WHERE channelUrl = ?";
            }
        };
        this.__preparedStmtOfDeleteAllChannel = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatChannelEntity";
            }
        };
    }

    public final void insertDeprecated(ChatChannelEntity chatChannelEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfChatChannelEntity.insert(chatChannelEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final b insert(final ChatChannelEntity chatChannelEntity) {
        return b.a((Callable<?>) new Callable<Void>() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Void call() throws Exception {
                ChatChannelDao_Impl.this.__db.beginTransaction();
                try {
                    ChatChannelDao_Impl.this.__insertionAdapterOfChatChannelEntity.insert(chatChannelEntity);
                    ChatChannelDao_Impl.this.__db.setTransactionSuccessful();
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    return null;
                } catch (Throwable th) {
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public final void upsertDeprecated(List<ChatChannelEntity> list) {
        this.__db.beginTransaction();
        try {
            ChatChannelDao.DefaultImpls.upsertDeprecated(this, list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final b updatePinnedState(final String str, final boolean z) {
        return b.a((Callable<?>) new Callable<Void>() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Void call() throws Exception {
                f acquire = ChatChannelDao_Impl.this.__preparedStmtOfUpdatePinnedState.acquire();
                acquire.a(1, z ? 1 : 0);
                String str = str;
                if (str == null) {
                    acquire.a(2);
                } else {
                    acquire.a(2, str);
                }
                ChatChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.a();
                    ChatChannelDao_Impl.this.__db.setTransactionSuccessful();
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfUpdatePinnedState.release(acquire);
                    return null;
                } catch (Throwable th) {
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfUpdatePinnedState.release(acquire);
                    throw th;
                }
            }
        });
    }

    public final b updateDraftMessage(final String str, final String str2) {
        return b.a((Callable<?>) new Callable<Void>() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Void call() throws Exception {
                f acquire = ChatChannelDao_Impl.this.__preparedStmtOfUpdateDraftMessage.acquire();
                String str = str2;
                if (str == null) {
                    acquire.a(1);
                } else {
                    acquire.a(1, str);
                }
                String str2 = str;
                if (str2 == null) {
                    acquire.a(2);
                } else {
                    acquire.a(2, str2);
                }
                ChatChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.a();
                    ChatChannelDao_Impl.this.__db.setTransactionSuccessful();
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfUpdateDraftMessage.release(acquire);
                    return null;
                } catch (Throwable th) {
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfUpdateDraftMessage.release(acquire);
                    throw th;
                }
            }
        });
    }

    public final b deleteChannel(final String str) {
        return b.a((Callable<?>) new Callable<Void>() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Void call() throws Exception {
                f acquire = ChatChannelDao_Impl.this.__preparedStmtOfDeleteChannel.acquire();
                String str = str;
                if (str == null) {
                    acquire.a(1);
                } else {
                    acquire.a(1, str);
                }
                ChatChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.a();
                    ChatChannelDao_Impl.this.__db.setTransactionSuccessful();
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfDeleteChannel.release(acquire);
                    return null;
                } catch (Throwable th) {
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfDeleteChannel.release(acquire);
                    throw th;
                }
            }
        });
    }

    public final b deleteAllChannel() {
        return b.a((Callable<?>) new Callable<Void>() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Void call() throws Exception {
                f acquire = ChatChannelDao_Impl.this.__preparedStmtOfDeleteAllChannel.acquire();
                ChatChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.a();
                    ChatChannelDao_Impl.this.__db.setTransactionSuccessful();
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfDeleteAllChannel.release(acquire);
                    return null;
                } catch (Throwable th) {
                    ChatChannelDao_Impl.this.__db.endTransaction();
                    ChatChannelDao_Impl.this.__preparedStmtOfDeleteAllChannel.release(acquire);
                    throw th;
                }
            }
        });
    }

    public final h<List<ChatChannelEntity>> getAllChannel() {
        final m a2 = m.a("SELECT * FROM ChatChannelEntity", 0);
        return androidx.room.rxjava3.b.a(this.__db, new String[]{"ChatChannelEntity"}, new Callable<List<ChatChannelEntity>>() {
            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x015f A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0161 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0179 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x017c A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x018f A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x01a0 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x01a3 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x01d1 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0232 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0234 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x0261 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0265 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x0275 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x0277 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x0285 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0287 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0295 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0297 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x02a5 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x02a7 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x02d5 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x02d7 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x02e3 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x02e7 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x02f7 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x02f9 A[Catch:{ all -> 0x0327 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity> call() throws java.lang.Exception {
                /*
                    r44 = this;
                    r1 = r44
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this
                    androidx.room.j r0 = r0.__db
                    androidx.room.m r2 = r0
                    r3 = 0
                    android.database.Cursor r2 = androidx.room.b.c.a(r0, r2, r3)
                    java.lang.String r0 = "isFake"
                    int r0 = androidx.room.b.b.b(r2, r0)     // Catch:{ all -> 0x0327 }
                    java.lang.String r4 = "channelUrl"
                    int r4 = androidx.room.b.b.b(r2, r4)     // Catch:{ all -> 0x0327 }
                    java.lang.String r5 = "name"
                    int r5 = androidx.room.b.b.b(r2, r5)     // Catch:{ all -> 0x0327 }
                    java.lang.String r6 = "createdAt"
                    int r6 = androidx.room.b.b.b(r2, r6)     // Catch:{ all -> 0x0327 }
                    java.lang.String r7 = "isPinned"
                    int r7 = androidx.room.b.b.b(r2, r7)     // Catch:{ all -> 0x0327 }
                    java.lang.String r8 = "draftMessage"
                    int r8 = androidx.room.b.b.b(r2, r8)     // Catch:{ all -> 0x0327 }
                    java.lang.String r9 = "lastMessageTs"
                    int r9 = androidx.room.b.b.b(r2, r9)     // Catch:{ all -> 0x0327 }
                    java.lang.String r10 = "rawChannel"
                    int r10 = androidx.room.b.b.b(r2, r10)     // Catch:{ all -> 0x0327 }
                    java.lang.String r11 = "members"
                    int r11 = androidx.room.b.b.b(r2, r11)     // Catch:{ all -> 0x0327 }
                    java.lang.String r12 = "lastMessageId"
                    int r12 = androidx.room.b.b.b(r2, r12)     // Catch:{ all -> 0x0327 }
                    java.lang.String r13 = "lastMessageType"
                    int r13 = androidx.room.b.b.b(r2, r13)     // Catch:{ all -> 0x0327 }
                    java.lang.String r14 = "memberCount"
                    int r14 = androidx.room.b.b.b(r2, r14)     // Catch:{ all -> 0x0327 }
                    java.lang.String r15 = "myLastRead"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x0327 }
                    java.lang.String r3 = "unreadMessageCount"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r16 = r3
                    java.lang.String r3 = "unreadMentionCount"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r17 = r3
                    java.lang.String r3 = "data"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r18 = r3
                    java.lang.String r3 = "createdBy"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r19 = r3
                    java.lang.String r3 = "isBroadcast"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r20 = r3
                    java.lang.String r3 = "customType"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r21 = r3
                    java.lang.String r3 = "invitedAt"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r22 = r3
                    java.lang.String r3 = "inviter"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r23 = r3
                    java.lang.String r3 = "isDiscoverable"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r24 = r3
                    java.lang.String r3 = "isDistinct"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r25 = r3
                    java.lang.String r3 = "isHidden"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r26 = r3
                    java.lang.String r3 = "isPublic"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r27 = r3
                    java.lang.String r3 = "isPushEnabled"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r28 = r3
                    java.lang.String r3 = "joinedMemberCount"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r29 = r3
                    java.lang.String r3 = "metaData"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r30 = r3
                    java.lang.String r3 = "payAllowed"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r31 = r3
                    java.lang.String r3 = "requestAllowed"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r32 = r3
                    java.lang.String r3 = "replyStatus"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r33 = r3
                    java.lang.String r3 = "previewText"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x0327 }
                    r34 = r15
                    java.lang.String r15 = "previewDrawable"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x0327 }
                    r35 = r14
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0327 }
                    r36 = r13
                    int r13 = r2.getCount()     // Catch:{ all -> 0x0327 }
                    r14.<init>(r13)     // Catch:{ all -> 0x0327 }
                L_0x0108:
                    boolean r13 = r2.moveToNext()     // Catch:{ all -> 0x0327 }
                    if (r13 == 0) goto L_0x0323
                    boolean r13 = r2.isNull(r3)     // Catch:{ all -> 0x0327 }
                    r37 = 0
                    if (r13 == 0) goto L_0x0124
                    boolean r13 = r2.isNull(r15)     // Catch:{ all -> 0x0327 }
                    if (r13 != 0) goto L_0x011d
                    goto L_0x0124
                L_0x011d:
                    r39 = r3
                    r38 = r15
                    r15 = r37
                    goto L_0x0152
                L_0x0124:
                    java.lang.String r13 = r2.getString(r3)     // Catch:{ all -> 0x0327 }
                    boolean r38 = r2.isNull(r15)     // Catch:{ all -> 0x0327 }
                    if (r38 == 0) goto L_0x0135
                    r39 = r3
                    r38 = r15
                    r3 = r37
                    goto L_0x0143
                L_0x0135:
                    int r38 = r2.getInt(r15)     // Catch:{ all -> 0x0327 }
                    java.lang.Integer r38 = java.lang.Integer.valueOf(r38)     // Catch:{ all -> 0x0327 }
                    r39 = r3
                    r3 = r38
                    r38 = r15
                L_0x0143:
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r15 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this     // Catch:{ all -> 0x0327 }
                    com.paytm.android.chat.data.db.room.converters.Converters r15 = r15.__converters     // Catch:{ all -> 0x0327 }
                    com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r3 = r15.fromMessagePreviewDrawable(r3)     // Catch:{ all -> 0x0327 }
                    com.paytm.android.chat.data.models.messages.MPCMessagePreview r15 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x0327 }
                    r15.<init>(r13, r3)     // Catch:{ all -> 0x0327 }
                L_0x0152:
                    com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity r3 = new com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity     // Catch:{ all -> 0x0327 }
                    r3.<init>()     // Catch:{ all -> 0x0327 }
                    int r13 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r40 = 1
                    if (r13 == 0) goto L_0x0161
                    r13 = 1
                    goto L_0x0162
                L_0x0161:
                    r13 = 0
                L_0x0162:
                    r3.setFake(r13)     // Catch:{ all -> 0x0327 }
                    java.lang.String r13 = r2.getString(r4)     // Catch:{ all -> 0x0327 }
                    r3.setChannelUrl(r13)     // Catch:{ all -> 0x0327 }
                    java.lang.String r13 = r2.getString(r5)     // Catch:{ all -> 0x0327 }
                    r3.setName(r13)     // Catch:{ all -> 0x0327 }
                    boolean r13 = r2.isNull(r6)     // Catch:{ all -> 0x0327 }
                    if (r13 == 0) goto L_0x017c
                    r13 = r37
                    goto L_0x0184
                L_0x017c:
                    long r41 = r2.getLong(r6)     // Catch:{ all -> 0x0327 }
                    java.lang.Long r13 = java.lang.Long.valueOf(r41)     // Catch:{ all -> 0x0327 }
                L_0x0184:
                    r3.setCreatedAt(r13)     // Catch:{ all -> 0x0327 }
                    int r13 = r2.getInt(r7)     // Catch:{ all -> 0x0327 }
                    if (r13 == 0) goto L_0x018f
                    r13 = 1
                    goto L_0x0190
                L_0x018f:
                    r13 = 0
                L_0x0190:
                    r3.setPinned(r13)     // Catch:{ all -> 0x0327 }
                    java.lang.String r13 = r2.getString(r8)     // Catch:{ all -> 0x0327 }
                    r3.setDraftMessage(r13)     // Catch:{ all -> 0x0327 }
                    boolean r13 = r2.isNull(r9)     // Catch:{ all -> 0x0327 }
                    if (r13 == 0) goto L_0x01a3
                    r13 = r37
                    goto L_0x01ab
                L_0x01a3:
                    long r41 = r2.getLong(r9)     // Catch:{ all -> 0x0327 }
                    java.lang.Long r13 = java.lang.Long.valueOf(r41)     // Catch:{ all -> 0x0327 }
                L_0x01ab:
                    r3.setLastMessageTs(r13)     // Catch:{ all -> 0x0327 }
                    byte[] r13 = r2.getBlob(r10)     // Catch:{ all -> 0x0327 }
                    r3.setRawChannel(r13)     // Catch:{ all -> 0x0327 }
                    java.lang.String r13 = r2.getString(r11)     // Catch:{ all -> 0x0327 }
                    r41 = r0
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this     // Catch:{ all -> 0x0327 }
                    com.paytm.android.chat.data.db.room.converters.Converters r0 = r0.__converters     // Catch:{ all -> 0x0327 }
                    java.util.List r0 = r0.jsonToMemberList(r13)     // Catch:{ all -> 0x0327 }
                    r3.setMembers(r0)     // Catch:{ all -> 0x0327 }
                    boolean r0 = r2.isNull(r12)     // Catch:{ all -> 0x0327 }
                    if (r0 == 0) goto L_0x01d1
                L_0x01ce:
                    r0 = r37
                    goto L_0x01da
                L_0x01d1:
                    long r42 = r2.getLong(r12)     // Catch:{ all -> 0x0327 }
                    java.lang.Long r37 = java.lang.Long.valueOf(r42)     // Catch:{ all -> 0x0327 }
                    goto L_0x01ce
                L_0x01da:
                    r3.setLastMessageId(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r36
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x0327 }
                    r3.setLastMessageType(r13)     // Catch:{ all -> 0x0327 }
                    r36 = r0
                    r13 = r35
                    int r0 = r2.getInt(r13)     // Catch:{ all -> 0x0327 }
                    r3.setMemberCount(r0)     // Catch:{ all -> 0x0327 }
                    r35 = r5
                    r0 = r34
                    r34 = r4
                    long r4 = r2.getLong(r0)     // Catch:{ all -> 0x0327 }
                    r3.setMyLastRead(r4)     // Catch:{ all -> 0x0327 }
                    r4 = r16
                    int r5 = r2.getInt(r4)     // Catch:{ all -> 0x0327 }
                    r3.setUnreadMessageCount(r5)     // Catch:{ all -> 0x0327 }
                    r16 = r0
                    r5 = r17
                    int r0 = r2.getInt(r5)     // Catch:{ all -> 0x0327 }
                    r3.setUnreadMentionCount(r0)     // Catch:{ all -> 0x0327 }
                    r17 = r4
                    r0 = r18
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x0327 }
                    r3.setData(r4)     // Catch:{ all -> 0x0327 }
                    r18 = r0
                    r4 = r19
                    java.lang.String r0 = r2.getString(r4)     // Catch:{ all -> 0x0327 }
                    r3.setCreatedBy(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r20
                    int r19 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r20 = r0
                    if (r19 == 0) goto L_0x0234
                    r0 = 1
                    goto L_0x0235
                L_0x0234:
                    r0 = 0
                L_0x0235:
                    r3.setBroadcast(r0)     // Catch:{ all -> 0x0327 }
                    r19 = r4
                    r0 = r21
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x0327 }
                    r3.setCustomType(r4)     // Catch:{ all -> 0x0327 }
                    r21 = r6
                    r4 = r22
                    r22 = r5
                    long r5 = r2.getLong(r4)     // Catch:{ all -> 0x0327 }
                    r3.setInvitedAt(r5)     // Catch:{ all -> 0x0327 }
                    r5 = r23
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x0327 }
                    r3.setInviter(r6)     // Catch:{ all -> 0x0327 }
                    r6 = r24
                    int r23 = r2.getInt(r6)     // Catch:{ all -> 0x0327 }
                    if (r23 == 0) goto L_0x0265
                    r23 = r0
                    r0 = 1
                    goto L_0x0268
                L_0x0265:
                    r23 = r0
                    r0 = 0
                L_0x0268:
                    r3.setDiscoverable(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r25
                    int r24 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r25 = r0
                    if (r24 == 0) goto L_0x0277
                    r0 = 1
                    goto L_0x0278
                L_0x0277:
                    r0 = 0
                L_0x0278:
                    r3.setDistinct(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r26
                    int r24 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r26 = r0
                    if (r24 == 0) goto L_0x0287
                    r0 = 1
                    goto L_0x0288
                L_0x0287:
                    r0 = 0
                L_0x0288:
                    r3.setHidden(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r27
                    int r24 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r27 = r0
                    if (r24 == 0) goto L_0x0297
                    r0 = 1
                    goto L_0x0298
                L_0x0297:
                    r0 = 0
                L_0x0298:
                    r3.setPublic(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r28
                    int r24 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r28 = r0
                    if (r24 == 0) goto L_0x02a7
                    r0 = 1
                    goto L_0x02a8
                L_0x02a7:
                    r0 = 0
                L_0x02a8:
                    r3.setPushEnabled(r0)     // Catch:{ all -> 0x0327 }
                    r24 = r4
                    r0 = r29
                    int r4 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r3.setJoinedMemberCount(r4)     // Catch:{ all -> 0x0327 }
                    r29 = r0
                    r4 = r30
                    java.lang.String r0 = r2.getString(r4)     // Catch:{ all -> 0x0327 }
                    r30 = r4
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r4 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this     // Catch:{ all -> 0x0327 }
                    com.paytm.android.chat.data.db.room.converters.Converters r4 = r4.__converters     // Catch:{ all -> 0x0327 }
                    com.paytm.android.chat.bean.ChannelMetaData r0 = r4.fromJsonToChannelMetadata(r0)     // Catch:{ all -> 0x0327 }
                    r3.setMetaData(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r31
                    int r4 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    if (r4 == 0) goto L_0x02d7
                    r4 = 1
                    goto L_0x02d8
                L_0x02d7:
                    r4 = 0
                L_0x02d8:
                    r3.setPayAllowed(r4)     // Catch:{ all -> 0x0327 }
                    r4 = r32
                    int r31 = r2.getInt(r4)     // Catch:{ all -> 0x0327 }
                    if (r31 == 0) goto L_0x02e7
                    r31 = r0
                    r0 = 1
                    goto L_0x02ea
                L_0x02e7:
                    r31 = r0
                    r0 = 0
                L_0x02ea:
                    r3.setRequestAllowed(r0)     // Catch:{ all -> 0x0327 }
                    r0 = r33
                    int r32 = r2.getInt(r0)     // Catch:{ all -> 0x0327 }
                    r33 = r0
                    if (r32 == 0) goto L_0x02f9
                    r0 = 1
                    goto L_0x02fa
                L_0x02f9:
                    r0 = 0
                L_0x02fa:
                    r3.setReplyAllowed(r0)     // Catch:{ all -> 0x0327 }
                    r3.setMessagePreview(r15)     // Catch:{ all -> 0x0327 }
                    r14.add(r3)     // Catch:{ all -> 0x0327 }
                    r32 = r4
                    r4 = r34
                    r15 = r38
                    r3 = r39
                    r0 = r41
                    r34 = r16
                    r16 = r17
                    r17 = r22
                    r22 = r24
                    r24 = r6
                    r6 = r21
                    r21 = r23
                    r23 = r5
                    r5 = r35
                    r35 = r13
                    goto L_0x0108
                L_0x0323:
                    r2.close()
                    return r14
                L_0x0327:
                    r0 = move-exception
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.AnonymousClass3.call():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x015a A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x015c A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0174 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0177 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0188 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x018a A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x019b A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x019e A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01c6 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0217 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0219 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0240 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0242 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x024e A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0250 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x025c A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x025e A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x026a A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x026c A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0278 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x027a A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x029e A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02a0 A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02ac A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02ae A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02ba A[Catch:{ all -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02bc A[Catch:{ all -> 0x02cd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity getChannelDeprecated(java.lang.String r39) {
        /*
            r38 = this;
            r1 = r38
            r0 = r39
            r2 = 1
            java.lang.String r3 = "SELECT * FROM ChatChannelEntity WHERE channelUrl = ?"
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
            java.lang.String r0 = "isFake"
            int r0 = androidx.room.b.b.b(r5, r0)     // Catch:{ all -> 0x02cf }
            java.lang.String r6 = "channelUrl"
            int r6 = androidx.room.b.b.b(r5, r6)     // Catch:{ all -> 0x02cf }
            java.lang.String r7 = "name"
            int r7 = androidx.room.b.b.b(r5, r7)     // Catch:{ all -> 0x02cf }
            java.lang.String r8 = "createdAt"
            int r8 = androidx.room.b.b.b(r5, r8)     // Catch:{ all -> 0x02cf }
            java.lang.String r9 = "isPinned"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x02cf }
            java.lang.String r10 = "draftMessage"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x02cf }
            java.lang.String r11 = "lastMessageTs"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x02cf }
            java.lang.String r12 = "rawChannel"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x02cf }
            java.lang.String r13 = "members"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x02cf }
            java.lang.String r14 = "lastMessageId"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x02cf }
            java.lang.String r15 = "lastMessageType"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = "memberCount"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x02cf }
            java.lang.String r4 = "myLastRead"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02cf }
            r16 = r3
            java.lang.String r3 = "unreadMessageCount"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r17 = r3
            java.lang.String r3 = "unreadMentionCount"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r18 = r3
            java.lang.String r3 = "data"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r19 = r3
            java.lang.String r3 = "createdBy"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r20 = r3
            java.lang.String r3 = "isBroadcast"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r21 = r3
            java.lang.String r3 = "customType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r22 = r3
            java.lang.String r3 = "invitedAt"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r23 = r3
            java.lang.String r3 = "inviter"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r24 = r3
            java.lang.String r3 = "isDiscoverable"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r25 = r3
            java.lang.String r3 = "isDistinct"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r26 = r3
            java.lang.String r3 = "isHidden"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r27 = r3
            java.lang.String r3 = "isPublic"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r28 = r3
            java.lang.String r3 = "isPushEnabled"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r29 = r3
            java.lang.String r3 = "joinedMemberCount"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r30 = r3
            java.lang.String r3 = "metaData"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r31 = r3
            java.lang.String r3 = "payAllowed"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r32 = r3
            java.lang.String r3 = "requestAllowed"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r33 = r3
            java.lang.String r3 = "replyStatus"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r34 = r3
            java.lang.String r3 = "previewText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02cd }
            r35 = r4
            java.lang.String r4 = "previewDrawable"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02cd }
            boolean r36 = r5.moveToFirst()     // Catch:{ all -> 0x02cd }
            r37 = 0
            if (r36 == 0) goto L_0x02c4
            boolean r36 = r5.isNull(r3)     // Catch:{ all -> 0x02cd }
            if (r36 == 0) goto L_0x012b
            boolean r36 = r5.isNull(r4)     // Catch:{ all -> 0x02cd }
            if (r36 != 0) goto L_0x0126
            goto L_0x012b
        L_0x0126:
            r36 = r2
            r4 = r37
            goto L_0x014f
        L_0x012b:
            java.lang.String r3 = r5.getString(r3)     // Catch:{ all -> 0x02cd }
            boolean r36 = r5.isNull(r4)     // Catch:{ all -> 0x02cd }
            if (r36 == 0) goto L_0x013a
            r36 = r2
            r4 = r37
            goto L_0x0144
        L_0x013a:
            int r4 = r5.getInt(r4)     // Catch:{ all -> 0x02cd }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x02cd }
            r36 = r2
        L_0x0144:
            com.paytm.android.chat.data.db.room.converters.Converters r2 = r1.__converters     // Catch:{ all -> 0x02cd }
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r2 = r2.fromMessagePreviewDrawable(r4)     // Catch:{ all -> 0x02cd }
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r4 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02cd }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x02cd }
        L_0x014f:
            com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity r2 = new com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity     // Catch:{ all -> 0x02cd }
            r2.<init>()     // Catch:{ all -> 0x02cd }
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x015c
            r0 = 1
            goto L_0x015d
        L_0x015c:
            r0 = 0
        L_0x015d:
            r2.setFake(r0)     // Catch:{ all -> 0x02cd }
            java.lang.String r0 = r5.getString(r6)     // Catch:{ all -> 0x02cd }
            r2.setChannelUrl(r0)     // Catch:{ all -> 0x02cd }
            java.lang.String r0 = r5.getString(r7)     // Catch:{ all -> 0x02cd }
            r2.setName(r0)     // Catch:{ all -> 0x02cd }
            boolean r0 = r5.isNull(r8)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x0177
            r0 = r37
            goto L_0x017f
        L_0x0177:
            long r6 = r5.getLong(r8)     // Catch:{ all -> 0x02cd }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x02cd }
        L_0x017f:
            r2.setCreatedAt(r0)     // Catch:{ all -> 0x02cd }
            int r0 = r5.getInt(r9)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x018a
            r0 = 1
            goto L_0x018b
        L_0x018a:
            r0 = 0
        L_0x018b:
            r2.setPinned(r0)     // Catch:{ all -> 0x02cd }
            java.lang.String r0 = r5.getString(r10)     // Catch:{ all -> 0x02cd }
            r2.setDraftMessage(r0)     // Catch:{ all -> 0x02cd }
            boolean r0 = r5.isNull(r11)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x019e
            r0 = r37
            goto L_0x01a6
        L_0x019e:
            long r6 = r5.getLong(r11)     // Catch:{ all -> 0x02cd }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x02cd }
        L_0x01a6:
            r2.setLastMessageTs(r0)     // Catch:{ all -> 0x02cd }
            byte[] r0 = r5.getBlob(r12)     // Catch:{ all -> 0x02cd }
            r2.setRawChannel(r0)     // Catch:{ all -> 0x02cd }
            java.lang.String r0 = r5.getString(r13)     // Catch:{ all -> 0x02cd }
            com.paytm.android.chat.data.db.room.converters.Converters r3 = r1.__converters     // Catch:{ all -> 0x02cd }
            java.util.List r0 = r3.jsonToMemberList(r0)     // Catch:{ all -> 0x02cd }
            r2.setMembers(r0)     // Catch:{ all -> 0x02cd }
            boolean r0 = r5.isNull(r14)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x01c6
        L_0x01c3:
            r0 = r37
            goto L_0x01cf
        L_0x01c6:
            long r6 = r5.getLong(r14)     // Catch:{ all -> 0x02cd }
            java.lang.Long r37 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x02cd }
            goto L_0x01c3
        L_0x01cf:
            r2.setLastMessageId(r0)     // Catch:{ all -> 0x02cd }
            java.lang.String r0 = r5.getString(r15)     // Catch:{ all -> 0x02cd }
            r2.setLastMessageType(r0)     // Catch:{ all -> 0x02cd }
            r0 = r36
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            r2.setMemberCount(r0)     // Catch:{ all -> 0x02cd }
            r0 = r35
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x02cd }
            r2.setMyLastRead(r6)     // Catch:{ all -> 0x02cd }
            r0 = r17
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            r2.setUnreadMessageCount(r0)     // Catch:{ all -> 0x02cd }
            r0 = r18
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            r2.setUnreadMentionCount(r0)     // Catch:{ all -> 0x02cd }
            r0 = r19
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x02cd }
            r2.setData(r0)     // Catch:{ all -> 0x02cd }
            r0 = r20
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x02cd }
            r2.setCreatedBy(r0)     // Catch:{ all -> 0x02cd }
            r0 = r21
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x0219
            r0 = 1
            goto L_0x021a
        L_0x0219:
            r0 = 0
        L_0x021a:
            r2.setBroadcast(r0)     // Catch:{ all -> 0x02cd }
            r0 = r22
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x02cd }
            r2.setCustomType(r0)     // Catch:{ all -> 0x02cd }
            r0 = r23
            long r6 = r5.getLong(r0)     // Catch:{ all -> 0x02cd }
            r2.setInvitedAt(r6)     // Catch:{ all -> 0x02cd }
            r0 = r24
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x02cd }
            r2.setInviter(r0)     // Catch:{ all -> 0x02cd }
            r0 = r25
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x0242
            r0 = 1
            goto L_0x0243
        L_0x0242:
            r0 = 0
        L_0x0243:
            r2.setDiscoverable(r0)     // Catch:{ all -> 0x02cd }
            r0 = r26
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x0250
            r0 = 1
            goto L_0x0251
        L_0x0250:
            r0 = 0
        L_0x0251:
            r2.setDistinct(r0)     // Catch:{ all -> 0x02cd }
            r0 = r27
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x025e
            r0 = 1
            goto L_0x025f
        L_0x025e:
            r0 = 0
        L_0x025f:
            r2.setHidden(r0)     // Catch:{ all -> 0x02cd }
            r0 = r28
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x026c
            r0 = 1
            goto L_0x026d
        L_0x026c:
            r0 = 0
        L_0x026d:
            r2.setPublic(r0)     // Catch:{ all -> 0x02cd }
            r0 = r29
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x027a
            r0 = 1
            goto L_0x027b
        L_0x027a:
            r0 = 0
        L_0x027b:
            r2.setPushEnabled(r0)     // Catch:{ all -> 0x02cd }
            r0 = r30
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            r2.setJoinedMemberCount(r0)     // Catch:{ all -> 0x02cd }
            r0 = r31
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x02cd }
            com.paytm.android.chat.data.db.room.converters.Converters r3 = r1.__converters     // Catch:{ all -> 0x02cd }
            com.paytm.android.chat.bean.ChannelMetaData r0 = r3.fromJsonToChannelMetadata(r0)     // Catch:{ all -> 0x02cd }
            r2.setMetaData(r0)     // Catch:{ all -> 0x02cd }
            r0 = r32
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x02a0
            r0 = 1
            goto L_0x02a1
        L_0x02a0:
            r0 = 0
        L_0x02a1:
            r2.setPayAllowed(r0)     // Catch:{ all -> 0x02cd }
            r0 = r33
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x02ae
            r0 = 1
            goto L_0x02af
        L_0x02ae:
            r0 = 0
        L_0x02af:
            r2.setRequestAllowed(r0)     // Catch:{ all -> 0x02cd }
            r0 = r34
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x02cd }
            if (r0 == 0) goto L_0x02bc
            r0 = 1
            goto L_0x02bd
        L_0x02bc:
            r0 = 0
        L_0x02bd:
            r2.setReplyAllowed(r0)     // Catch:{ all -> 0x02cd }
            r2.setMessagePreview(r4)     // Catch:{ all -> 0x02cd }
            goto L_0x02c6
        L_0x02c4:
            r2 = r37
        L_0x02c6:
            r5.close()
            r16.a()
            return r2
        L_0x02cd:
            r0 = move-exception
            goto L_0x02d2
        L_0x02cf:
            r0 = move-exception
            r16 = r3
        L_0x02d2:
            r5.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.getChannelDeprecated(java.lang.String):com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity");
    }

    public final l<ChatChannelEntity> getChannel(String str) {
        final m a2 = m.a("SELECT * FROM ChatChannelEntity WHERE channelUrl = ?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        return l.a(new Callable<ChatChannelEntity>() {
            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x014b A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x014d A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0165 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0168 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0179 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x017b A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x018c A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x018f A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x01bb A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x020c A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x020e A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0235 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x0237 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x0243 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x0245 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0251 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x0253 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x025f A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0261 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x026d A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x026f A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0297 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0299 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x02a5 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x02a7 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x02b3 A[Catch:{ all -> 0x02c2 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x02b4 A[Catch:{ all -> 0x02c2 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity call() throws java.lang.Exception {
                /*
                    r37 = this;
                    r1 = r37
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this
                    androidx.room.j r0 = r0.__db
                    androidx.room.m r2 = r1
                    r3 = 0
                    android.database.Cursor r2 = androidx.room.b.c.a(r0, r2, r3)
                    java.lang.String r0 = "isFake"
                    int r0 = androidx.room.b.b.b(r2, r0)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r4 = "channelUrl"
                    int r4 = androidx.room.b.b.b(r2, r4)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r5 = "name"
                    int r5 = androidx.room.b.b.b(r2, r5)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r6 = "createdAt"
                    int r6 = androidx.room.b.b.b(r2, r6)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r7 = "isPinned"
                    int r7 = androidx.room.b.b.b(r2, r7)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r8 = "draftMessage"
                    int r8 = androidx.room.b.b.b(r2, r8)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r9 = "lastMessageTs"
                    int r9 = androidx.room.b.b.b(r2, r9)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r10 = "rawChannel"
                    int r10 = androidx.room.b.b.b(r2, r10)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r11 = "members"
                    int r11 = androidx.room.b.b.b(r2, r11)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r12 = "lastMessageId"
                    int r12 = androidx.room.b.b.b(r2, r12)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r13 = "lastMessageType"
                    int r13 = androidx.room.b.b.b(r2, r13)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r14 = "memberCount"
                    int r14 = androidx.room.b.b.b(r2, r14)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r15 = "myLastRead"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r3 = "unreadMessageCount"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r16 = r3
                    java.lang.String r3 = "unreadMentionCount"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r17 = r3
                    java.lang.String r3 = "data"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r18 = r3
                    java.lang.String r3 = "createdBy"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r19 = r3
                    java.lang.String r3 = "isBroadcast"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r20 = r3
                    java.lang.String r3 = "customType"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r21 = r3
                    java.lang.String r3 = "invitedAt"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r22 = r3
                    java.lang.String r3 = "inviter"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r23 = r3
                    java.lang.String r3 = "isDiscoverable"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r24 = r3
                    java.lang.String r3 = "isDistinct"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r25 = r3
                    java.lang.String r3 = "isHidden"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r26 = r3
                    java.lang.String r3 = "isPublic"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r27 = r3
                    java.lang.String r3 = "isPushEnabled"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r28 = r3
                    java.lang.String r3 = "joinedMemberCount"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r29 = r3
                    java.lang.String r3 = "metaData"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r30 = r3
                    java.lang.String r3 = "payAllowed"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r31 = r3
                    java.lang.String r3 = "requestAllowed"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r32 = r3
                    java.lang.String r3 = "replyStatus"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r33 = r3
                    java.lang.String r3 = "previewText"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c2 }
                    r34 = r15
                    java.lang.String r15 = "previewDrawable"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x02c2 }
                    boolean r35 = r2.moveToFirst()     // Catch:{ all -> 0x02c2 }
                    r36 = 0
                    if (r35 == 0) goto L_0x02bc
                    boolean r35 = r2.isNull(r3)     // Catch:{ all -> 0x02c2 }
                    if (r35 == 0) goto L_0x0117
                    boolean r35 = r2.isNull(r15)     // Catch:{ all -> 0x02c2 }
                    if (r35 != 0) goto L_0x0112
                    goto L_0x0117
                L_0x0112:
                    r35 = r14
                    r15 = r36
                    goto L_0x013f
                L_0x0117:
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x02c2 }
                    boolean r35 = r2.isNull(r15)     // Catch:{ all -> 0x02c2 }
                    if (r35 == 0) goto L_0x0126
                    r35 = r14
                    r15 = r36
                    goto L_0x0130
                L_0x0126:
                    int r15 = r2.getInt(r15)     // Catch:{ all -> 0x02c2 }
                    java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x02c2 }
                    r35 = r14
                L_0x0130:
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r14 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.data.db.room.converters.Converters r14 = r14.__converters     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r14 = r14.fromMessagePreviewDrawable(r15)     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.data.models.messages.MPCMessagePreview r15 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02c2 }
                    r15.<init>(r3, r14)     // Catch:{ all -> 0x02c2 }
                L_0x013f:
                    com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity r3 = new com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity     // Catch:{ all -> 0x02c2 }
                    r3.<init>()     // Catch:{ all -> 0x02c2 }
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    r14 = 1
                    if (r0 == 0) goto L_0x014d
                    r0 = 1
                    goto L_0x014e
                L_0x014d:
                    r0 = 0
                L_0x014e:
                    r3.setFake(r0)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r0 = r2.getString(r4)     // Catch:{ all -> 0x02c2 }
                    r3.setChannelUrl(r0)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r0 = r2.getString(r5)     // Catch:{ all -> 0x02c2 }
                    r3.setName(r0)     // Catch:{ all -> 0x02c2 }
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x0168
                    r0 = r36
                    goto L_0x0170
                L_0x0168:
                    long r4 = r2.getLong(r6)     // Catch:{ all -> 0x02c2 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x02c2 }
                L_0x0170:
                    r3.setCreatedAt(r0)     // Catch:{ all -> 0x02c2 }
                    int r0 = r2.getInt(r7)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x017b
                    r0 = 1
                    goto L_0x017c
                L_0x017b:
                    r0 = 0
                L_0x017c:
                    r3.setPinned(r0)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r0 = r2.getString(r8)     // Catch:{ all -> 0x02c2 }
                    r3.setDraftMessage(r0)     // Catch:{ all -> 0x02c2 }
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x018f
                    r0 = r36
                    goto L_0x0197
                L_0x018f:
                    long r4 = r2.getLong(r9)     // Catch:{ all -> 0x02c2 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x02c2 }
                L_0x0197:
                    r3.setLastMessageTs(r0)     // Catch:{ all -> 0x02c2 }
                    byte[] r0 = r2.getBlob(r10)     // Catch:{ all -> 0x02c2 }
                    r3.setRawChannel(r0)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r0 = r2.getString(r11)     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r4 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.data.db.room.converters.Converters r4 = r4.__converters     // Catch:{ all -> 0x02c2 }
                    java.util.List r0 = r4.jsonToMemberList(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setMembers(r0)     // Catch:{ all -> 0x02c2 }
                    boolean r0 = r2.isNull(r12)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x01bb
                L_0x01b8:
                    r0 = r36
                    goto L_0x01c4
                L_0x01bb:
                    long r4 = r2.getLong(r12)     // Catch:{ all -> 0x02c2 }
                    java.lang.Long r36 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x02c2 }
                    goto L_0x01b8
                L_0x01c4:
                    r3.setLastMessageId(r0)     // Catch:{ all -> 0x02c2 }
                    java.lang.String r0 = r2.getString(r13)     // Catch:{ all -> 0x02c2 }
                    r3.setLastMessageType(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r35
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setMemberCount(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r34
                    long r4 = r2.getLong(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setMyLastRead(r4)     // Catch:{ all -> 0x02c2 }
                    r0 = r16
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setUnreadMessageCount(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r17
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setUnreadMentionCount(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r18
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setData(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r19
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setCreatedBy(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r20
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x020e
                    r0 = 1
                    goto L_0x020f
                L_0x020e:
                    r0 = 0
                L_0x020f:
                    r3.setBroadcast(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r21
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setCustomType(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r22
                    long r4 = r2.getLong(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setInvitedAt(r4)     // Catch:{ all -> 0x02c2 }
                    r0 = r23
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setInviter(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r24
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x0237
                    r0 = 1
                    goto L_0x0238
                L_0x0237:
                    r0 = 0
                L_0x0238:
                    r3.setDiscoverable(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r25
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x0245
                    r0 = 1
                    goto L_0x0246
                L_0x0245:
                    r0 = 0
                L_0x0246:
                    r3.setDistinct(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r26
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x0253
                    r0 = 1
                    goto L_0x0254
                L_0x0253:
                    r0 = 0
                L_0x0254:
                    r3.setHidden(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r27
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x0261
                    r0 = 1
                    goto L_0x0262
                L_0x0261:
                    r0 = 0
                L_0x0262:
                    r3.setPublic(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r28
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x026f
                    r0 = 1
                    goto L_0x0270
                L_0x026f:
                    r0 = 0
                L_0x0270:
                    r3.setPushEnabled(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r29
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setJoinedMemberCount(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r30
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl r4 = com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.this     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.data.db.room.converters.Converters r4 = r4.__converters     // Catch:{ all -> 0x02c2 }
                    com.paytm.android.chat.bean.ChannelMetaData r0 = r4.fromJsonToChannelMetadata(r0)     // Catch:{ all -> 0x02c2 }
                    r3.setMetaData(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r31
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x0299
                    r0 = 1
                    goto L_0x029a
                L_0x0299:
                    r0 = 0
                L_0x029a:
                    r3.setPayAllowed(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r32
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x02a7
                    r0 = 1
                    goto L_0x02a8
                L_0x02a7:
                    r0 = 0
                L_0x02a8:
                    r3.setRequestAllowed(r0)     // Catch:{ all -> 0x02c2 }
                    r0 = r33
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x02c2 }
                    if (r0 == 0) goto L_0x02b4
                    goto L_0x02b5
                L_0x02b4:
                    r14 = 0
                L_0x02b5:
                    r3.setReplyAllowed(r14)     // Catch:{ all -> 0x02c2 }
                    r3.setMessagePreview(r15)     // Catch:{ all -> 0x02c2 }
                    goto L_0x02be
                L_0x02bc:
                    r3 = r36
                L_0x02be:
                    r2.close()
                    return r3
                L_0x02c2:
                    r0 = move-exception
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatChannelDao_Impl.AnonymousClass4.call():com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    public final y<Integer> getChannelCount() {
        final m a2 = m.a("SELECT COUNT(*) FROM ChatChannelEntity", 0);
        return androidx.room.rxjava3.b.a(new Callable<Integer>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Integer call() throws Exception {
                Cursor a2 = androidx.room.b.c.a(ChatChannelDao_Impl.this.__db, a2, false);
                try {
                    Integer valueOf = (!a2.moveToFirst() || a2.isNull(0)) ? null : Integer.valueOf(a2.getInt(0));
                    if (valueOf != null) {
                        return valueOf;
                    }
                    throw new a("Query returned empty result set: " + a2.f4472a);
                } finally {
                    a2.close();
                }
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    public final y<Integer> getPinnedChannelCount() {
        final m a2 = m.a("SELECT COUNT(*) FROM ChatChannelEntity WHERE isPinned = 1", 0);
        return androidx.room.rxjava3.b.a(new Callable<Integer>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Integer call() throws Exception {
                Cursor a2 = androidx.room.b.c.a(ChatChannelDao_Impl.this.__db, a2, false);
                try {
                    Integer valueOf = (!a2.moveToFirst() || a2.isNull(0)) ? null : Integer.valueOf(a2.getInt(0));
                    if (valueOf != null) {
                        return valueOf;
                    }
                    throw new a("Query returned empty result set: " + a2.f4472a);
                } finally {
                    a2.close();
                }
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    public final b upsert(List<ChatChannelEntity> list) {
        return ChatChannelDao.DefaultImpls.upsert(this, list);
    }
}
