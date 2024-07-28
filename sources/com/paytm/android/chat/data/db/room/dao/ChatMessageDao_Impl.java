package com.paytm.android.chat.data.db.room.dao;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import com.paytm.android.chat.data.db.room.converters.Converters;
import com.paytm.android.chat.data.db.room.dao.ChatMessageDao;
import com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity;
import com.paytm.android.chat.data.db.room.helper.MessageInsertOrUpdatedModel;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import io.reactivex.rxjava3.a.h;
import java.util.List;
import java.util.concurrent.Callable;

public final class ChatMessageDao_Impl implements ChatMessageDao {
    /* access modifiers changed from: private */
    public final Converters __converters = new Converters();
    /* access modifiers changed from: private */
    public final j __db;
    private final c<ChatMessageEntity> __insertionAdapterOfChatMessageEntity;
    private final q __preparedStmtOfDeleteAllMessages;
    private final q __preparedStmtOfDeleteMessage;
    /* access modifiers changed from: private */
    public final q __preparedStmtOfDeleteMessageForChannel;
    private final q __preparedStmtOfDeleteMessage_1;
    private final q __preparedStmtOfMarkReadEngageEventSent;
    private final q __preparedStmtOfUpdateAnimationState;
    private final b<ChatMessageEntity> __updateAdapterOfChatMessageEntity;

    public ChatMessageDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfChatMessageEntity = new c<ChatMessageEntity>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `ChatMessageEntity` (`id`,`messageId`,`messageType`,`requestId`,`channelUrl`,`senderId`,`senderName`,`messageCustomType`,`createdAt`,`updatedAt`,`messageState`,`readEngageEventSent`,`rawMessage`,`showAnim`,`messageContent`,`isOperatorMessage`,`channelType`,`customType`,`data`,`errorCode`,`isSilent`,`mentionType`,`sender`,`parentMessageId`,`parentMessageText`,`type`,`fileUrl`,`fileName`,`previewText`,`previewDrawable`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                ChatMessageEntity chatMessageEntity = (ChatMessageEntity) obj;
                fVar.a(1, (long) chatMessageEntity.getId());
                fVar.a(2, chatMessageEntity.getMessageId());
                if (chatMessageEntity.getMessageType() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, chatMessageEntity.getMessageType());
                }
                if (chatMessageEntity.getRequestId() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, chatMessageEntity.getRequestId());
                }
                if (chatMessageEntity.getChannelUrl() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, chatMessageEntity.getChannelUrl());
                }
                if (chatMessageEntity.getSenderId() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, chatMessageEntity.getSenderId());
                }
                if (chatMessageEntity.getSenderName() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, chatMessageEntity.getSenderName());
                }
                if (chatMessageEntity.getMessageCustomType() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, chatMessageEntity.getMessageCustomType());
                }
                if (chatMessageEntity.getCreatedAt() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, chatMessageEntity.getCreatedAt().longValue());
                }
                if (chatMessageEntity.getUpdatedAt() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, chatMessageEntity.getUpdatedAt().longValue());
                }
                fVar.a(11, (long) chatMessageEntity.getMessageState());
                fVar.a(12, chatMessageEntity.getReadEngageEventSent() ? 1 : 0);
                if (chatMessageEntity.getRawMessage() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, chatMessageEntity.getRawMessage());
                }
                Integer valueOf = chatMessageEntity.getShowAnim() == null ? null : Integer.valueOf(chatMessageEntity.getShowAnim().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, (long) valueOf.intValue());
                }
                if (chatMessageEntity.getMessageContent() == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, chatMessageEntity.getMessageContent());
                }
                fVar.a(16, chatMessageEntity.isOperatorMessage() ? 1 : 0);
                if (chatMessageEntity.getChannelType() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, chatMessageEntity.getChannelType());
                }
                if (chatMessageEntity.getCustomType() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, chatMessageEntity.getCustomType());
                }
                if (chatMessageEntity.getData() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, chatMessageEntity.getData());
                }
                fVar.a(20, (long) chatMessageEntity.getErrorCode());
                fVar.a(21, chatMessageEntity.isSilent() ? 1 : 0);
                if (chatMessageEntity.getMentionType() == null) {
                    fVar.a(22);
                } else {
                    fVar.a(22, chatMessageEntity.getMentionType());
                }
                if (chatMessageEntity.getSender() == null) {
                    fVar.a(23);
                } else {
                    fVar.a(23, chatMessageEntity.getSender());
                }
                if (chatMessageEntity.getParentMessageId() == null) {
                    fVar.a(24);
                } else {
                    fVar.a(24, chatMessageEntity.getParentMessageId().longValue());
                }
                if (chatMessageEntity.getParentMessageText() == null) {
                    fVar.a(25);
                } else {
                    fVar.a(25, chatMessageEntity.getParentMessageText());
                }
                if (chatMessageEntity.getType() == null) {
                    fVar.a(26);
                } else {
                    fVar.a(26, chatMessageEntity.getType());
                }
                if (chatMessageEntity.getFileUrl() == null) {
                    fVar.a(27);
                } else {
                    fVar.a(27, chatMessageEntity.getFileUrl());
                }
                if (chatMessageEntity.getFileName() == null) {
                    fVar.a(28);
                } else {
                    fVar.a(28, chatMessageEntity.getFileName());
                }
                MPCMessagePreview messagePreview = chatMessageEntity.getMessagePreview();
                if (messagePreview != null) {
                    if (messagePreview.getPreviewText() == null) {
                        fVar.a(29);
                    } else {
                        fVar.a(29, messagePreview.getPreviewText());
                    }
                    Integer messagePreviewDrawable = ChatMessageDao_Impl.this.__converters.toMessagePreviewDrawable(messagePreview.getPreviewDrawable());
                    if (messagePreviewDrawable == null) {
                        fVar.a(30);
                    } else {
                        fVar.a(30, (long) messagePreviewDrawable.intValue());
                    }
                } else {
                    fVar.a(29);
                    fVar.a(30);
                }
            }
        };
        this.__updateAdapterOfChatMessageEntity = new b<ChatMessageEntity>(jVar) {
            public final String createQuery() {
                return "UPDATE OR REPLACE `ChatMessageEntity` SET `id` = ?,`messageId` = ?,`messageType` = ?,`requestId` = ?,`channelUrl` = ?,`senderId` = ?,`senderName` = ?,`messageCustomType` = ?,`createdAt` = ?,`updatedAt` = ?,`messageState` = ?,`readEngageEventSent` = ?,`rawMessage` = ?,`showAnim` = ?,`messageContent` = ?,`isOperatorMessage` = ?,`channelType` = ?,`customType` = ?,`data` = ?,`errorCode` = ?,`isSilent` = ?,`mentionType` = ?,`sender` = ?,`parentMessageId` = ?,`parentMessageText` = ?,`type` = ?,`fileUrl` = ?,`fileName` = ?,`previewText` = ?,`previewDrawable` = ? WHERE `id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                ChatMessageEntity chatMessageEntity = (ChatMessageEntity) obj;
                fVar.a(1, (long) chatMessageEntity.getId());
                fVar.a(2, chatMessageEntity.getMessageId());
                if (chatMessageEntity.getMessageType() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, chatMessageEntity.getMessageType());
                }
                if (chatMessageEntity.getRequestId() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, chatMessageEntity.getRequestId());
                }
                if (chatMessageEntity.getChannelUrl() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, chatMessageEntity.getChannelUrl());
                }
                if (chatMessageEntity.getSenderId() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, chatMessageEntity.getSenderId());
                }
                if (chatMessageEntity.getSenderName() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, chatMessageEntity.getSenderName());
                }
                if (chatMessageEntity.getMessageCustomType() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, chatMessageEntity.getMessageCustomType());
                }
                if (chatMessageEntity.getCreatedAt() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, chatMessageEntity.getCreatedAt().longValue());
                }
                if (chatMessageEntity.getUpdatedAt() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, chatMessageEntity.getUpdatedAt().longValue());
                }
                fVar.a(11, (long) chatMessageEntity.getMessageState());
                fVar.a(12, chatMessageEntity.getReadEngageEventSent() ? 1 : 0);
                if (chatMessageEntity.getRawMessage() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, chatMessageEntity.getRawMessage());
                }
                Integer valueOf = chatMessageEntity.getShowAnim() == null ? null : Integer.valueOf(chatMessageEntity.getShowAnim().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, (long) valueOf.intValue());
                }
                if (chatMessageEntity.getMessageContent() == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, chatMessageEntity.getMessageContent());
                }
                fVar.a(16, chatMessageEntity.isOperatorMessage() ? 1 : 0);
                if (chatMessageEntity.getChannelType() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, chatMessageEntity.getChannelType());
                }
                if (chatMessageEntity.getCustomType() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, chatMessageEntity.getCustomType());
                }
                if (chatMessageEntity.getData() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, chatMessageEntity.getData());
                }
                fVar.a(20, (long) chatMessageEntity.getErrorCode());
                fVar.a(21, chatMessageEntity.isSilent() ? 1 : 0);
                if (chatMessageEntity.getMentionType() == null) {
                    fVar.a(22);
                } else {
                    fVar.a(22, chatMessageEntity.getMentionType());
                }
                if (chatMessageEntity.getSender() == null) {
                    fVar.a(23);
                } else {
                    fVar.a(23, chatMessageEntity.getSender());
                }
                if (chatMessageEntity.getParentMessageId() == null) {
                    fVar.a(24);
                } else {
                    fVar.a(24, chatMessageEntity.getParentMessageId().longValue());
                }
                if (chatMessageEntity.getParentMessageText() == null) {
                    fVar.a(25);
                } else {
                    fVar.a(25, chatMessageEntity.getParentMessageText());
                }
                if (chatMessageEntity.getType() == null) {
                    fVar.a(26);
                } else {
                    fVar.a(26, chatMessageEntity.getType());
                }
                if (chatMessageEntity.getFileUrl() == null) {
                    fVar.a(27);
                } else {
                    fVar.a(27, chatMessageEntity.getFileUrl());
                }
                if (chatMessageEntity.getFileName() == null) {
                    fVar.a(28);
                } else {
                    fVar.a(28, chatMessageEntity.getFileName());
                }
                MPCMessagePreview messagePreview = chatMessageEntity.getMessagePreview();
                if (messagePreview != null) {
                    if (messagePreview.getPreviewText() == null) {
                        fVar.a(29);
                    } else {
                        fVar.a(29, messagePreview.getPreviewText());
                    }
                    Integer messagePreviewDrawable = ChatMessageDao_Impl.this.__converters.toMessagePreviewDrawable(messagePreview.getPreviewDrawable());
                    if (messagePreviewDrawable == null) {
                        fVar.a(30);
                    } else {
                        fVar.a(30, (long) messagePreviewDrawable.intValue());
                    }
                } else {
                    fVar.a(29);
                    fVar.a(30);
                }
                fVar.a(31, (long) chatMessageEntity.getId());
            }
        };
        this.__preparedStmtOfMarkReadEngageEventSent = new q(jVar) {
            public final String createQuery() {
                return "UPDATE ChatMessageEntity SET readEngageEventSent = ? WHERE messageId = ?";
            }
        };
        this.__preparedStmtOfDeleteMessage = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatMessageEntity WHERE messageId = ? OR requestId = ?";
            }
        };
        this.__preparedStmtOfDeleteMessage_1 = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatMessageEntity WHERE messageId = ?";
            }
        };
        this.__preparedStmtOfDeleteMessageForChannel = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatMessageEntity WHERE channelUrl = ?";
            }
        };
        this.__preparedStmtOfDeleteAllMessages = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatMessageEntity";
            }
        };
        this.__preparedStmtOfUpdateAnimationState = new q(jVar) {
            public final String createQuery() {
                return "Update ChatMessageEntity SET showAnim = ? WHERE messageId = ?";
            }
        };
    }

    public final void insert(ChatMessageEntity chatMessageEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfChatMessageEntity.insert(chatMessageEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void update(ChatMessageEntity chatMessageEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfChatMessageEntity.handle(chatMessageEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final MessageInsertOrUpdatedModel insertOrUpdate(List<ChatMessageEntity> list) {
        this.__db.beginTransaction();
        try {
            MessageInsertOrUpdatedModel insertOrUpdate = ChatMessageDao.DefaultImpls.insertOrUpdate(this, list);
            this.__db.setTransactionSuccessful();
            return insertOrUpdate;
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void bulkDeleteByMessageId(List<Long> list) {
        this.__db.beginTransaction();
        try {
            ChatMessageDao.DefaultImpls.bulkDeleteByMessageId(this, list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void markReadEngageEventSent(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfMarkReadEngageEventSent.acquire();
        acquire.a(1, z ? 1 : 0);
        acquire.a(2, j);
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkReadEngageEventSent.release(acquire);
        }
    }

    public final void deleteMessage(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteMessage.acquire();
        acquire.a(1, j);
        if (str == null) {
            acquire.a(2);
        } else {
            acquire.a(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteMessage.release(acquire);
        }
    }

    public final void deleteMessage(long j) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteMessage_1.acquire();
        acquire.a(1, j);
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteMessage_1.release(acquire);
        }
    }

    public final io.reactivex.rxjava3.a.b deleteMessageForChannel(final String str) {
        return io.reactivex.rxjava3.a.b.a((Callable<?>) new Callable<Void>() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Void call() throws Exception {
                f acquire = ChatMessageDao_Impl.this.__preparedStmtOfDeleteMessageForChannel.acquire();
                String str = str;
                if (str == null) {
                    acquire.a(1);
                } else {
                    acquire.a(1, str);
                }
                ChatMessageDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.a();
                    ChatMessageDao_Impl.this.__db.setTransactionSuccessful();
                    ChatMessageDao_Impl.this.__db.endTransaction();
                    ChatMessageDao_Impl.this.__preparedStmtOfDeleteMessageForChannel.release(acquire);
                    return null;
                } catch (Throwable th) {
                    ChatMessageDao_Impl.this.__db.endTransaction();
                    ChatMessageDao_Impl.this.__preparedStmtOfDeleteMessageForChannel.release(acquire);
                    throw th;
                }
            }
        });
    }

    public final void deleteAllMessages() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteAllMessages.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllMessages.release(acquire);
        }
    }

    public final void updateAnimationState(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfUpdateAnimationState.acquire();
        acquire.a(1, z ? 1 : 0);
        acquire.a(2, j);
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateAnimationState.release(acquire);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0188 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x018b A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x019c A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x019f A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01bd A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01bf A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01d6 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01d9 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01e3 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e8 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0211 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0215 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0251 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0253 A[Catch:{ all -> 0x02d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x027a A[Catch:{ all -> 0x02d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity> getAllMessages() {
        /*
            r39 = this;
            r1 = r39
            r0 = 0
            java.lang.String r2 = "SELECT * FROM ChatMessageEntity"
            androidx.room.m r2 = androidx.room.m.a((java.lang.String) r2, (int) r0)
            androidx.room.j r3 = r1.__db
            r3.assertNotSuspendingTransaction()
            androidx.room.j r3 = r1.__db
            android.database.Cursor r3 = androidx.room.b.c.a(r3, r2, r0)
            java.lang.String r4 = "id"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02d7 }
            java.lang.String r5 = "messageId"
            int r5 = androidx.room.b.b.b(r3, r5)     // Catch:{ all -> 0x02d7 }
            java.lang.String r6 = "messageType"
            int r6 = androidx.room.b.b.b(r3, r6)     // Catch:{ all -> 0x02d7 }
            java.lang.String r7 = "requestId"
            int r7 = androidx.room.b.b.b(r3, r7)     // Catch:{ all -> 0x02d7 }
            java.lang.String r8 = "channelUrl"
            int r8 = androidx.room.b.b.b(r3, r8)     // Catch:{ all -> 0x02d7 }
            java.lang.String r9 = "senderId"
            int r9 = androidx.room.b.b.b(r3, r9)     // Catch:{ all -> 0x02d7 }
            java.lang.String r10 = "senderName"
            int r10 = androidx.room.b.b.b(r3, r10)     // Catch:{ all -> 0x02d7 }
            java.lang.String r11 = "messageCustomType"
            int r11 = androidx.room.b.b.b(r3, r11)     // Catch:{ all -> 0x02d7 }
            java.lang.String r12 = "createdAt"
            int r12 = androidx.room.b.b.b(r3, r12)     // Catch:{ all -> 0x02d7 }
            java.lang.String r13 = "updatedAt"
            int r13 = androidx.room.b.b.b(r3, r13)     // Catch:{ all -> 0x02d7 }
            java.lang.String r14 = "messageState"
            int r14 = androidx.room.b.b.b(r3, r14)     // Catch:{ all -> 0x02d7 }
            java.lang.String r15 = "readEngageEventSent"
            int r15 = androidx.room.b.b.b(r3, r15)     // Catch:{ all -> 0x02d7 }
            java.lang.String r0 = "rawMessage"
            int r0 = androidx.room.b.b.b(r3, r0)     // Catch:{ all -> 0x02d7 }
            r16 = r2
            java.lang.String r2 = "showAnim"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r17 = r2
            java.lang.String r2 = "messageContent"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r18 = r2
            java.lang.String r2 = "isOperatorMessage"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r19 = r2
            java.lang.String r2 = "channelType"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r20 = r2
            java.lang.String r2 = "customType"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r21 = r2
            java.lang.String r2 = "data"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r22 = r2
            java.lang.String r2 = "errorCode"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r23 = r2
            java.lang.String r2 = "isSilent"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r24 = r2
            java.lang.String r2 = "mentionType"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r25 = r2
            java.lang.String r2 = "sender"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r26 = r2
            java.lang.String r2 = "parentMessageId"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r27 = r2
            java.lang.String r2 = "parentMessageText"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r28 = r2
            java.lang.String r2 = "type"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r29 = r2
            java.lang.String r2 = "fileUrl"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r30 = r2
            java.lang.String r2 = "fileName"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r31 = r2
            java.lang.String r2 = "previewText"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x02d5 }
            r32 = r0
            java.lang.String r0 = "previewDrawable"
            int r0 = androidx.room.b.b.b(r3, r0)     // Catch:{ all -> 0x02d5 }
            r33 = r15
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x02d5 }
            r34 = r14
            int r14 = r3.getCount()     // Catch:{ all -> 0x02d5 }
            r15.<init>(r14)     // Catch:{ all -> 0x02d5 }
        L_0x00fd:
            boolean r14 = r3.moveToNext()     // Catch:{ all -> 0x02d5 }
            if (r14 == 0) goto L_0x02cd
            boolean r14 = r3.isNull(r2)     // Catch:{ all -> 0x02d5 }
            r35 = 0
            if (r14 == 0) goto L_0x0119
            boolean r14 = r3.isNull(r0)     // Catch:{ all -> 0x02d5 }
            if (r14 != 0) goto L_0x0112
            goto L_0x0119
        L_0x0112:
            r37 = r0
            r36 = r2
            r2 = r35
            goto L_0x0143
        L_0x0119:
            java.lang.String r14 = r3.getString(r2)     // Catch:{ all -> 0x02d5 }
            boolean r36 = r3.isNull(r0)     // Catch:{ all -> 0x02d5 }
            if (r36 == 0) goto L_0x012a
            r37 = r0
            r36 = r2
            r0 = r35
            goto L_0x0138
        L_0x012a:
            int r36 = r3.getInt(r0)     // Catch:{ all -> 0x02d5 }
            java.lang.Integer r36 = java.lang.Integer.valueOf(r36)     // Catch:{ all -> 0x02d5 }
            r37 = r0
            r0 = r36
            r36 = r2
        L_0x0138:
            com.paytm.android.chat.data.db.room.converters.Converters r2 = r1.__converters     // Catch:{ all -> 0x02d5 }
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r0 = r2.fromMessagePreviewDrawable(r0)     // Catch:{ all -> 0x02d5 }
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r2 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02d5 }
            r2.<init>(r14, r0)     // Catch:{ all -> 0x02d5 }
        L_0x0143:
            com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r0 = new com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity     // Catch:{ all -> 0x02d5 }
            r0.<init>()     // Catch:{ all -> 0x02d5 }
            int r14 = r3.getInt(r4)     // Catch:{ all -> 0x02d5 }
            r0.setId(r14)     // Catch:{ all -> 0x02d5 }
            r38 = r15
            long r14 = r3.getLong(r5)     // Catch:{ all -> 0x02d5 }
            r0.setMessageId(r14)     // Catch:{ all -> 0x02d5 }
            java.lang.String r14 = r3.getString(r6)     // Catch:{ all -> 0x02d5 }
            r0.setMessageType(r14)     // Catch:{ all -> 0x02d5 }
            java.lang.String r14 = r3.getString(r7)     // Catch:{ all -> 0x02d5 }
            r0.setRequestId(r14)     // Catch:{ all -> 0x02d5 }
            java.lang.String r14 = r3.getString(r8)     // Catch:{ all -> 0x02d5 }
            r0.setChannelUrl(r14)     // Catch:{ all -> 0x02d5 }
            java.lang.String r14 = r3.getString(r9)     // Catch:{ all -> 0x02d5 }
            r0.setSenderId(r14)     // Catch:{ all -> 0x02d5 }
            java.lang.String r14 = r3.getString(r10)     // Catch:{ all -> 0x02d5 }
            r0.setSenderName(r14)     // Catch:{ all -> 0x02d5 }
            java.lang.String r14 = r3.getString(r11)     // Catch:{ all -> 0x02d5 }
            r0.setMessageCustomType(r14)     // Catch:{ all -> 0x02d5 }
            boolean r14 = r3.isNull(r12)     // Catch:{ all -> 0x02d5 }
            if (r14 == 0) goto L_0x018b
            r14 = r35
            goto L_0x0193
        L_0x018b:
            long r14 = r3.getLong(r12)     // Catch:{ all -> 0x02d5 }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x02d5 }
        L_0x0193:
            r0.setCreatedAt(r14)     // Catch:{ all -> 0x02d5 }
            boolean r14 = r3.isNull(r13)     // Catch:{ all -> 0x02d5 }
            if (r14 == 0) goto L_0x019f
            r14 = r35
            goto L_0x01a7
        L_0x019f:
            long r14 = r3.getLong(r13)     // Catch:{ all -> 0x02d5 }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x02d5 }
        L_0x01a7:
            r0.setUpdatedAt(r14)     // Catch:{ all -> 0x02d5 }
            r14 = r34
            int r15 = r3.getInt(r14)     // Catch:{ all -> 0x02d5 }
            r0.setMessageState(r15)     // Catch:{ all -> 0x02d5 }
            r15 = r33
            int r33 = r3.getInt(r15)     // Catch:{ all -> 0x02d5 }
            r34 = 1
            if (r33 == 0) goto L_0x01bf
            r1 = 1
            goto L_0x01c0
        L_0x01bf:
            r1 = 0
        L_0x01c0:
            r0.setReadEngageEventSent(r1)     // Catch:{ all -> 0x02d5 }
            r1 = r32
            r32 = r4
            byte[] r4 = r3.getBlob(r1)     // Catch:{ all -> 0x02d5 }
            r0.setRawMessage(r4)     // Catch:{ all -> 0x02d5 }
            r4 = r17
            boolean r17 = r3.isNull(r4)     // Catch:{ all -> 0x02d5 }
            if (r17 == 0) goto L_0x01d9
            r17 = r35
            goto L_0x01e1
        L_0x01d9:
            int r17 = r3.getInt(r4)     // Catch:{ all -> 0x02d5 }
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x02d5 }
        L_0x01e1:
            if (r17 != 0) goto L_0x01e8
            r33 = r1
            r1 = r35
            goto L_0x01fb
        L_0x01e8:
            int r17 = r17.intValue()     // Catch:{ all -> 0x02d5 }
            if (r17 == 0) goto L_0x01f1
            r17 = 1
            goto L_0x01f3
        L_0x01f1:
            r17 = 0
        L_0x01f3:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r17)     // Catch:{ all -> 0x02d5 }
            r33 = r1
            r1 = r17
        L_0x01fb:
            r0.setShowAnim(r1)     // Catch:{ all -> 0x02d5 }
            r17 = r4
            r1 = r18
            java.lang.String r4 = r3.getString(r1)     // Catch:{ all -> 0x02d5 }
            r0.setMessageContent(r4)     // Catch:{ all -> 0x02d5 }
            r4 = r19
            int r18 = r3.getInt(r4)     // Catch:{ all -> 0x02d5 }
            if (r18 == 0) goto L_0x0215
            r18 = r1
            r1 = 1
            goto L_0x0218
        L_0x0215:
            r18 = r1
            r1 = 0
        L_0x0218:
            r0.setOperatorMessage(r1)     // Catch:{ all -> 0x02d5 }
            r19 = r4
            r1 = r20
            java.lang.String r4 = r3.getString(r1)     // Catch:{ all -> 0x02d5 }
            r0.setChannelType(r4)     // Catch:{ all -> 0x02d5 }
            r20 = r1
            r4 = r21
            java.lang.String r1 = r3.getString(r4)     // Catch:{ all -> 0x02d5 }
            r0.setCustomType(r1)     // Catch:{ all -> 0x02d5 }
            r21 = r4
            r1 = r22
            java.lang.String r4 = r3.getString(r1)     // Catch:{ all -> 0x02d5 }
            r0.setData(r4)     // Catch:{ all -> 0x02d5 }
            r22 = r1
            r4 = r23
            int r1 = r3.getInt(r4)     // Catch:{ all -> 0x02d5 }
            r0.setErrorCode(r1)     // Catch:{ all -> 0x02d5 }
            r1 = r24
            int r23 = r3.getInt(r1)     // Catch:{ all -> 0x02d5 }
            r24 = r1
            if (r23 == 0) goto L_0x0253
            r1 = 1
            goto L_0x0254
        L_0x0253:
            r1 = 0
        L_0x0254:
            r0.setSilent(r1)     // Catch:{ all -> 0x02d5 }
            r23 = r4
            r1 = r25
            java.lang.String r4 = r3.getString(r1)     // Catch:{ all -> 0x02d5 }
            r0.setMentionType(r4)     // Catch:{ all -> 0x02d5 }
            r25 = r1
            r4 = r26
            byte[] r1 = r3.getBlob(r4)     // Catch:{ all -> 0x02d5 }
            r0.setSender(r1)     // Catch:{ all -> 0x02d5 }
            r1 = r27
            boolean r26 = r3.isNull(r1)     // Catch:{ all -> 0x02d5 }
            if (r26 == 0) goto L_0x027a
        L_0x0275:
            r27 = r1
            r1 = r35
            goto L_0x0283
        L_0x027a:
            long r26 = r3.getLong(r1)     // Catch:{ all -> 0x02d5 }
            java.lang.Long r35 = java.lang.Long.valueOf(r26)     // Catch:{ all -> 0x02d5 }
            goto L_0x0275
        L_0x0283:
            r0.setParentMessageId(r1)     // Catch:{ all -> 0x02d5 }
            r26 = r4
            r1 = r28
            java.lang.String r4 = r3.getString(r1)     // Catch:{ all -> 0x02d5 }
            r0.setParentMessageText(r4)     // Catch:{ all -> 0x02d5 }
            r28 = r1
            r4 = r29
            java.lang.String r1 = r3.getString(r4)     // Catch:{ all -> 0x02d5 }
            r0.setType(r1)     // Catch:{ all -> 0x02d5 }
            r29 = r4
            r1 = r30
            java.lang.String r4 = r3.getString(r1)     // Catch:{ all -> 0x02d5 }
            r0.setFileUrl(r4)     // Catch:{ all -> 0x02d5 }
            r30 = r1
            r4 = r31
            java.lang.String r1 = r3.getString(r4)     // Catch:{ all -> 0x02d5 }
            r0.setFileName(r1)     // Catch:{ all -> 0x02d5 }
            r0.setMessagePreview(r2)     // Catch:{ all -> 0x02d5 }
            r1 = r38
            r1.add(r0)     // Catch:{ all -> 0x02d5 }
            r31 = r4
            r34 = r14
            r4 = r32
            r32 = r33
            r2 = r36
            r0 = r37
            r33 = r15
            r15 = r1
            r1 = r39
            goto L_0x00fd
        L_0x02cd:
            r1 = r15
            r3.close()
            r16.a()
            return r1
        L_0x02d5:
            r0 = move-exception
            goto L_0x02da
        L_0x02d7:
            r0 = move-exception
            r16 = r2
        L_0x02da:
            r3.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.getAllMessages():java.util.List");
    }

    public final h<List<ChatMessageEntity>> getMessageForChannel(String str) {
        final m a2 = m.a("SELECT * FROM ChatMessageEntity WHERE channelUrl = ?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        return androidx.room.rxjava3.b.a(this.__db, new String[]{"ChatMessageEntity"}, new Callable<List<ChatMessageEntity>>() {
            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0180 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0183 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0194 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0197 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x01b5 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x01b9 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x01d2 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x01d5 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x01df A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x01e4 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x020d A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x0211 A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x024d A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x024f A[Catch:{ all -> 0x02c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x0276 A[Catch:{ all -> 0x02c9 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity> call() throws java.lang.Exception {
                /*
                    r38 = this;
                    r1 = r38
                    com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl r0 = com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.this
                    androidx.room.j r0 = r0.__db
                    androidx.room.m r2 = r1
                    r3 = 0
                    android.database.Cursor r2 = androidx.room.b.c.a(r0, r2, r3)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.b.b.b(r2, r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r4 = "messageId"
                    int r4 = androidx.room.b.b.b(r2, r4)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r5 = "messageType"
                    int r5 = androidx.room.b.b.b(r2, r5)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r6 = "requestId"
                    int r6 = androidx.room.b.b.b(r2, r6)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r7 = "channelUrl"
                    int r7 = androidx.room.b.b.b(r2, r7)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r8 = "senderId"
                    int r8 = androidx.room.b.b.b(r2, r8)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r9 = "senderName"
                    int r9 = androidx.room.b.b.b(r2, r9)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r10 = "messageCustomType"
                    int r10 = androidx.room.b.b.b(r2, r10)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.b.b.b(r2, r11)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r12 = "updatedAt"
                    int r12 = androidx.room.b.b.b(r2, r12)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r13 = "messageState"
                    int r13 = androidx.room.b.b.b(r2, r13)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r14 = "readEngageEventSent"
                    int r14 = androidx.room.b.b.b(r2, r14)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r15 = "rawMessage"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r3 = "showAnim"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r16 = r3
                    java.lang.String r3 = "messageContent"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r17 = r3
                    java.lang.String r3 = "isOperatorMessage"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r18 = r3
                    java.lang.String r3 = "channelType"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r19 = r3
                    java.lang.String r3 = "customType"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r20 = r3
                    java.lang.String r3 = "data"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r21 = r3
                    java.lang.String r3 = "errorCode"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r22 = r3
                    java.lang.String r3 = "isSilent"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r23 = r3
                    java.lang.String r3 = "mentionType"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r24 = r3
                    java.lang.String r3 = "sender"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r25 = r3
                    java.lang.String r3 = "parentMessageId"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r26 = r3
                    java.lang.String r3 = "parentMessageText"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r27 = r3
                    java.lang.String r3 = "type"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r28 = r3
                    java.lang.String r3 = "fileUrl"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r29 = r3
                    java.lang.String r3 = "fileName"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r30 = r3
                    java.lang.String r3 = "previewText"
                    int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x02c9 }
                    r31 = r15
                    java.lang.String r15 = "previewDrawable"
                    int r15 = androidx.room.b.b.b(r2, r15)     // Catch:{ all -> 0x02c9 }
                    r32 = r14
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x02c9 }
                    r33 = r13
                    int r13 = r2.getCount()     // Catch:{ all -> 0x02c9 }
                    r14.<init>(r13)     // Catch:{ all -> 0x02c9 }
                L_0x00f2:
                    boolean r13 = r2.moveToNext()     // Catch:{ all -> 0x02c9 }
                    if (r13 == 0) goto L_0x02c5
                    boolean r13 = r2.isNull(r3)     // Catch:{ all -> 0x02c9 }
                    r34 = 0
                    if (r13 == 0) goto L_0x010e
                    boolean r13 = r2.isNull(r15)     // Catch:{ all -> 0x02c9 }
                    if (r13 != 0) goto L_0x0107
                    goto L_0x010e
                L_0x0107:
                    r36 = r3
                    r35 = r15
                    r15 = r34
                    goto L_0x013c
                L_0x010e:
                    java.lang.String r13 = r2.getString(r3)     // Catch:{ all -> 0x02c9 }
                    boolean r35 = r2.isNull(r15)     // Catch:{ all -> 0x02c9 }
                    if (r35 == 0) goto L_0x011f
                    r36 = r3
                    r35 = r15
                    r3 = r34
                    goto L_0x012d
                L_0x011f:
                    int r35 = r2.getInt(r15)     // Catch:{ all -> 0x02c9 }
                    java.lang.Integer r35 = java.lang.Integer.valueOf(r35)     // Catch:{ all -> 0x02c9 }
                    r36 = r3
                    r3 = r35
                    r35 = r15
                L_0x012d:
                    com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl r15 = com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.this     // Catch:{ all -> 0x02c9 }
                    com.paytm.android.chat.data.db.room.converters.Converters r15 = r15.__converters     // Catch:{ all -> 0x02c9 }
                    com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r3 = r15.fromMessagePreviewDrawable(r3)     // Catch:{ all -> 0x02c9 }
                    com.paytm.android.chat.data.models.messages.MPCMessagePreview r15 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02c9 }
                    r15.<init>(r13, r3)     // Catch:{ all -> 0x02c9 }
                L_0x013c:
                    com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r3 = new com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity     // Catch:{ all -> 0x02c9 }
                    r3.<init>()     // Catch:{ all -> 0x02c9 }
                    int r13 = r2.getInt(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setId(r13)     // Catch:{ all -> 0x02c9 }
                    r13 = r0
                    long r0 = r2.getLong(r4)     // Catch:{ all -> 0x02c9 }
                    r3.setMessageId(r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r0 = r2.getString(r5)     // Catch:{ all -> 0x02c9 }
                    r3.setMessageType(r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r0 = r2.getString(r6)     // Catch:{ all -> 0x02c9 }
                    r3.setRequestId(r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r0 = r2.getString(r7)     // Catch:{ all -> 0x02c9 }
                    r3.setChannelUrl(r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r0 = r2.getString(r8)     // Catch:{ all -> 0x02c9 }
                    r3.setSenderId(r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r0 = r2.getString(r9)     // Catch:{ all -> 0x02c9 }
                    r3.setSenderName(r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.String r0 = r2.getString(r10)     // Catch:{ all -> 0x02c9 }
                    r3.setMessageCustomType(r0)     // Catch:{ all -> 0x02c9 }
                    boolean r0 = r2.isNull(r11)     // Catch:{ all -> 0x02c9 }
                    if (r0 == 0) goto L_0x0183
                    r0 = r34
                    goto L_0x018b
                L_0x0183:
                    long r0 = r2.getLong(r11)     // Catch:{ all -> 0x02c9 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02c9 }
                L_0x018b:
                    r3.setCreatedAt(r0)     // Catch:{ all -> 0x02c9 }
                    boolean r0 = r2.isNull(r12)     // Catch:{ all -> 0x02c9 }
                    if (r0 == 0) goto L_0x0197
                    r0 = r34
                    goto L_0x019f
                L_0x0197:
                    long r0 = r2.getLong(r12)     // Catch:{ all -> 0x02c9 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02c9 }
                L_0x019f:
                    r3.setUpdatedAt(r0)     // Catch:{ all -> 0x02c9 }
                    r0 = r33
                    int r1 = r2.getInt(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setMessageState(r1)     // Catch:{ all -> 0x02c9 }
                    r1 = r32
                    int r32 = r2.getInt(r1)     // Catch:{ all -> 0x02c9 }
                    r33 = 1
                    if (r32 == 0) goto L_0x01b9
                    r32 = r0
                    r0 = 1
                    goto L_0x01bc
                L_0x01b9:
                    r32 = r0
                    r0 = 0
                L_0x01bc:
                    r3.setReadEngageEventSent(r0)     // Catch:{ all -> 0x02c9 }
                    r0 = r31
                    r31 = r1
                    byte[] r1 = r2.getBlob(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setRawMessage(r1)     // Catch:{ all -> 0x02c9 }
                    r1 = r16
                    boolean r16 = r2.isNull(r1)     // Catch:{ all -> 0x02c9 }
                    if (r16 == 0) goto L_0x01d5
                    r16 = r34
                    goto L_0x01dd
                L_0x01d5:
                    int r16 = r2.getInt(r1)     // Catch:{ all -> 0x02c9 }
                    java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x02c9 }
                L_0x01dd:
                    if (r16 != 0) goto L_0x01e4
                    r37 = r0
                    r0 = r34
                    goto L_0x01f7
                L_0x01e4:
                    int r16 = r16.intValue()     // Catch:{ all -> 0x02c9 }
                    if (r16 == 0) goto L_0x01ed
                    r16 = 1
                    goto L_0x01ef
                L_0x01ed:
                    r16 = 0
                L_0x01ef:
                    java.lang.Boolean r16 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x02c9 }
                    r37 = r0
                    r0 = r16
                L_0x01f7:
                    r3.setShowAnim(r0)     // Catch:{ all -> 0x02c9 }
                    r16 = r1
                    r0 = r17
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setMessageContent(r1)     // Catch:{ all -> 0x02c9 }
                    r1 = r18
                    int r17 = r2.getInt(r1)     // Catch:{ all -> 0x02c9 }
                    if (r17 == 0) goto L_0x0211
                    r17 = r0
                    r0 = 1
                    goto L_0x0214
                L_0x0211:
                    r17 = r0
                    r0 = 0
                L_0x0214:
                    r3.setOperatorMessage(r0)     // Catch:{ all -> 0x02c9 }
                    r18 = r1
                    r0 = r19
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setChannelType(r1)     // Catch:{ all -> 0x02c9 }
                    r19 = r0
                    r1 = r20
                    java.lang.String r0 = r2.getString(r1)     // Catch:{ all -> 0x02c9 }
                    r3.setCustomType(r0)     // Catch:{ all -> 0x02c9 }
                    r20 = r1
                    r0 = r21
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setData(r1)     // Catch:{ all -> 0x02c9 }
                    r21 = r0
                    r1 = r22
                    int r0 = r2.getInt(r1)     // Catch:{ all -> 0x02c9 }
                    r3.setErrorCode(r0)     // Catch:{ all -> 0x02c9 }
                    r0 = r23
                    int r22 = r2.getInt(r0)     // Catch:{ all -> 0x02c9 }
                    r23 = r0
                    if (r22 == 0) goto L_0x024f
                    r0 = 1
                    goto L_0x0250
                L_0x024f:
                    r0 = 0
                L_0x0250:
                    r3.setSilent(r0)     // Catch:{ all -> 0x02c9 }
                    r22 = r1
                    r0 = r24
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setMentionType(r1)     // Catch:{ all -> 0x02c9 }
                    r24 = r0
                    r1 = r25
                    byte[] r0 = r2.getBlob(r1)     // Catch:{ all -> 0x02c9 }
                    r3.setSender(r0)     // Catch:{ all -> 0x02c9 }
                    r0 = r26
                    boolean r25 = r2.isNull(r0)     // Catch:{ all -> 0x02c9 }
                    if (r25 == 0) goto L_0x0276
                L_0x0271:
                    r26 = r0
                    r0 = r34
                    goto L_0x027f
                L_0x0276:
                    long r25 = r2.getLong(r0)     // Catch:{ all -> 0x02c9 }
                    java.lang.Long r34 = java.lang.Long.valueOf(r25)     // Catch:{ all -> 0x02c9 }
                    goto L_0x0271
                L_0x027f:
                    r3.setParentMessageId(r0)     // Catch:{ all -> 0x02c9 }
                    r25 = r1
                    r0 = r27
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setParentMessageText(r1)     // Catch:{ all -> 0x02c9 }
                    r27 = r0
                    r1 = r28
                    java.lang.String r0 = r2.getString(r1)     // Catch:{ all -> 0x02c9 }
                    r3.setType(r0)     // Catch:{ all -> 0x02c9 }
                    r28 = r1
                    r0 = r29
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setFileUrl(r1)     // Catch:{ all -> 0x02c9 }
                    r29 = r0
                    r1 = r30
                    java.lang.String r0 = r2.getString(r1)     // Catch:{ all -> 0x02c9 }
                    r3.setFileName(r0)     // Catch:{ all -> 0x02c9 }
                    r3.setMessagePreview(r15)     // Catch:{ all -> 0x02c9 }
                    r14.add(r3)     // Catch:{ all -> 0x02c9 }
                    r30 = r1
                    r0 = r13
                    r33 = r32
                    r15 = r35
                    r3 = r36
                    r1 = r38
                    r32 = r31
                    r31 = r37
                    goto L_0x00f2
                L_0x02c5:
                    r2.close()
                    return r14
                L_0x02c9:
                    r0 = move-exception
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.AnonymousClass2.call():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x019a A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x019d A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01ae A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01b1 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01cf A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01d1 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e8 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01eb A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01f5 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01fa A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0225 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0227 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0261 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0263 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x028a A[Catch:{ all -> 0x02e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity> getMessageBy(java.lang.String r38, long r39) {
        /*
            r37 = this;
            r1 = r37
            r0 = r38
            r2 = 2
            java.lang.String r3 = "SELECT * FROM ChatMessageEntity WHERE channelUrl = ? AND messageId = ?"
            androidx.room.m r3 = androidx.room.m.a((java.lang.String) r3, (int) r2)
            r4 = 1
            if (r0 != 0) goto L_0x0013
            int[] r0 = r3.f4477f
            r0[r4] = r4
            goto L_0x0016
        L_0x0013:
            r3.a((int) r4, (java.lang.String) r0)
        L_0x0016:
            r5 = r39
            r3.a((int) r2, (long) r5)
            androidx.room.j r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.j r0 = r1.__db
            r2 = 0
            android.database.Cursor r5 = androidx.room.b.c.a(r0, r3, r2)
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r5, r0)     // Catch:{ all -> 0x02e2 }
            java.lang.String r6 = "messageId"
            int r6 = androidx.room.b.b.b(r5, r6)     // Catch:{ all -> 0x02e2 }
            java.lang.String r7 = "messageType"
            int r7 = androidx.room.b.b.b(r5, r7)     // Catch:{ all -> 0x02e2 }
            java.lang.String r8 = "requestId"
            int r8 = androidx.room.b.b.b(r5, r8)     // Catch:{ all -> 0x02e2 }
            java.lang.String r9 = "channelUrl"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x02e2 }
            java.lang.String r10 = "senderId"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x02e2 }
            java.lang.String r11 = "senderName"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x02e2 }
            java.lang.String r12 = "messageCustomType"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x02e2 }
            java.lang.String r13 = "createdAt"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x02e2 }
            java.lang.String r14 = "updatedAt"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x02e2 }
            java.lang.String r15 = "messageState"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x02e2 }
            java.lang.String r2 = "readEngageEventSent"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x02e2 }
            java.lang.String r4 = "rawMessage"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02e2 }
            r16 = r3
            java.lang.String r3 = "showAnim"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r39 = r3
            java.lang.String r3 = "messageContent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r40 = r3
            java.lang.String r3 = "isOperatorMessage"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r17 = r3
            java.lang.String r3 = "channelType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r18 = r3
            java.lang.String r3 = "customType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r19 = r3
            java.lang.String r3 = "data"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r20 = r3
            java.lang.String r3 = "errorCode"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r21 = r3
            java.lang.String r3 = "isSilent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r22 = r3
            java.lang.String r3 = "mentionType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r23 = r3
            java.lang.String r3 = "sender"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r24 = r3
            java.lang.String r3 = "parentMessageId"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r25 = r3
            java.lang.String r3 = "parentMessageText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r26 = r3
            java.lang.String r3 = "type"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r27 = r3
            java.lang.String r3 = "fileUrl"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r28 = r3
            java.lang.String r3 = "fileName"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r29 = r3
            java.lang.String r3 = "previewText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02e0 }
            r30 = r4
            java.lang.String r4 = "previewDrawable"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02e0 }
            r31 = r2
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x02e0 }
            r32 = r15
            int r15 = r5.getCount()     // Catch:{ all -> 0x02e0 }
            r2.<init>(r15)     // Catch:{ all -> 0x02e0 }
        L_0x0110:
            boolean r15 = r5.moveToNext()     // Catch:{ all -> 0x02e0 }
            if (r15 == 0) goto L_0x02d9
            boolean r15 = r5.isNull(r3)     // Catch:{ all -> 0x02e0 }
            r33 = 0
            if (r15 == 0) goto L_0x012c
            boolean r15 = r5.isNull(r4)     // Catch:{ all -> 0x02e0 }
            if (r15 != 0) goto L_0x0125
            goto L_0x012c
        L_0x0125:
            r35 = r3
            r34 = r4
            r4 = r33
            goto L_0x0156
        L_0x012c:
            java.lang.String r15 = r5.getString(r3)     // Catch:{ all -> 0x02e0 }
            boolean r34 = r5.isNull(r4)     // Catch:{ all -> 0x02e0 }
            if (r34 == 0) goto L_0x013d
            r35 = r3
            r34 = r4
            r3 = r33
            goto L_0x014b
        L_0x013d:
            int r34 = r5.getInt(r4)     // Catch:{ all -> 0x02e0 }
            java.lang.Integer r34 = java.lang.Integer.valueOf(r34)     // Catch:{ all -> 0x02e0 }
            r35 = r3
            r3 = r34
            r34 = r4
        L_0x014b:
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r1.__converters     // Catch:{ all -> 0x02e0 }
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r3 = r4.fromMessagePreviewDrawable(r3)     // Catch:{ all -> 0x02e0 }
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r4 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02e0 }
            r4.<init>(r15, r3)     // Catch:{ all -> 0x02e0 }
        L_0x0156:
            com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r3 = new com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity     // Catch:{ all -> 0x02e0 }
            r3.<init>()     // Catch:{ all -> 0x02e0 }
            int r15 = r5.getInt(r0)     // Catch:{ all -> 0x02e0 }
            r3.setId(r15)     // Catch:{ all -> 0x02e0 }
            r15 = r0
            long r0 = r5.getLong(r6)     // Catch:{ all -> 0x02e0 }
            r3.setMessageId(r0)     // Catch:{ all -> 0x02e0 }
            java.lang.String r0 = r5.getString(r7)     // Catch:{ all -> 0x02e0 }
            r3.setMessageType(r0)     // Catch:{ all -> 0x02e0 }
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x02e0 }
            r3.setRequestId(r0)     // Catch:{ all -> 0x02e0 }
            java.lang.String r0 = r5.getString(r9)     // Catch:{ all -> 0x02e0 }
            r3.setChannelUrl(r0)     // Catch:{ all -> 0x02e0 }
            java.lang.String r0 = r5.getString(r10)     // Catch:{ all -> 0x02e0 }
            r3.setSenderId(r0)     // Catch:{ all -> 0x02e0 }
            java.lang.String r0 = r5.getString(r11)     // Catch:{ all -> 0x02e0 }
            r3.setSenderName(r0)     // Catch:{ all -> 0x02e0 }
            java.lang.String r0 = r5.getString(r12)     // Catch:{ all -> 0x02e0 }
            r3.setMessageCustomType(r0)     // Catch:{ all -> 0x02e0 }
            boolean r0 = r5.isNull(r13)     // Catch:{ all -> 0x02e0 }
            if (r0 == 0) goto L_0x019d
            r0 = r33
            goto L_0x01a5
        L_0x019d:
            long r0 = r5.getLong(r13)     // Catch:{ all -> 0x02e0 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02e0 }
        L_0x01a5:
            r3.setCreatedAt(r0)     // Catch:{ all -> 0x02e0 }
            boolean r0 = r5.isNull(r14)     // Catch:{ all -> 0x02e0 }
            if (r0 == 0) goto L_0x01b1
            r0 = r33
            goto L_0x01b9
        L_0x01b1:
            long r0 = r5.getLong(r14)     // Catch:{ all -> 0x02e0 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02e0 }
        L_0x01b9:
            r3.setUpdatedAt(r0)     // Catch:{ all -> 0x02e0 }
            r0 = r32
            int r1 = r5.getInt(r0)     // Catch:{ all -> 0x02e0 }
            r3.setMessageState(r1)     // Catch:{ all -> 0x02e0 }
            r1 = r31
            int r31 = r5.getInt(r1)     // Catch:{ all -> 0x02e0 }
            r32 = r0
            if (r31 == 0) goto L_0x01d1
            r0 = 1
            goto L_0x01d2
        L_0x01d1:
            r0 = 0
        L_0x01d2:
            r3.setReadEngageEventSent(r0)     // Catch:{ all -> 0x02e0 }
            r31 = r1
            r0 = r30
            byte[] r1 = r5.getBlob(r0)     // Catch:{ all -> 0x02e0 }
            r3.setRawMessage(r1)     // Catch:{ all -> 0x02e0 }
            r1 = r39
            boolean r30 = r5.isNull(r1)     // Catch:{ all -> 0x02e0 }
            if (r30 == 0) goto L_0x01eb
            r30 = r33
            goto L_0x01f3
        L_0x01eb:
            int r30 = r5.getInt(r1)     // Catch:{ all -> 0x02e0 }
            java.lang.Integer r30 = java.lang.Integer.valueOf(r30)     // Catch:{ all -> 0x02e0 }
        L_0x01f3:
            if (r30 != 0) goto L_0x01fa
            r39 = r0
            r0 = r33
            goto L_0x020d
        L_0x01fa:
            int r30 = r30.intValue()     // Catch:{ all -> 0x02e0 }
            if (r30 == 0) goto L_0x0203
            r30 = 1
            goto L_0x0205
        L_0x0203:
            r30 = 0
        L_0x0205:
            java.lang.Boolean r30 = java.lang.Boolean.valueOf(r30)     // Catch:{ all -> 0x02e0 }
            r39 = r0
            r0 = r30
        L_0x020d:
            r3.setShowAnim(r0)     // Catch:{ all -> 0x02e0 }
            r0 = r40
            r30 = r1
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02e0 }
            r3.setMessageContent(r1)     // Catch:{ all -> 0x02e0 }
            r1 = r17
            int r17 = r5.getInt(r1)     // Catch:{ all -> 0x02e0 }
            r40 = r0
            if (r17 == 0) goto L_0x0227
            r0 = 1
            goto L_0x0228
        L_0x0227:
            r0 = 0
        L_0x0228:
            r3.setOperatorMessage(r0)     // Catch:{ all -> 0x02e0 }
            r17 = r1
            r0 = r18
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02e0 }
            r3.setChannelType(r1)     // Catch:{ all -> 0x02e0 }
            r18 = r0
            r1 = r19
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02e0 }
            r3.setCustomType(r0)     // Catch:{ all -> 0x02e0 }
            r19 = r1
            r0 = r20
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02e0 }
            r3.setData(r1)     // Catch:{ all -> 0x02e0 }
            r20 = r0
            r1 = r21
            int r0 = r5.getInt(r1)     // Catch:{ all -> 0x02e0 }
            r3.setErrorCode(r0)     // Catch:{ all -> 0x02e0 }
            r0 = r22
            int r21 = r5.getInt(r0)     // Catch:{ all -> 0x02e0 }
            r22 = r0
            if (r21 == 0) goto L_0x0263
            r0 = 1
            goto L_0x0264
        L_0x0263:
            r0 = 0
        L_0x0264:
            r3.setSilent(r0)     // Catch:{ all -> 0x02e0 }
            r21 = r1
            r0 = r23
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02e0 }
            r3.setMentionType(r1)     // Catch:{ all -> 0x02e0 }
            r23 = r0
            r1 = r24
            byte[] r0 = r5.getBlob(r1)     // Catch:{ all -> 0x02e0 }
            r3.setSender(r0)     // Catch:{ all -> 0x02e0 }
            r0 = r25
            boolean r24 = r5.isNull(r0)     // Catch:{ all -> 0x02e0 }
            if (r24 == 0) goto L_0x028a
        L_0x0285:
            r25 = r0
            r0 = r33
            goto L_0x0293
        L_0x028a:
            long r24 = r5.getLong(r0)     // Catch:{ all -> 0x02e0 }
            java.lang.Long r33 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x02e0 }
            goto L_0x0285
        L_0x0293:
            r3.setParentMessageId(r0)     // Catch:{ all -> 0x02e0 }
            r24 = r1
            r0 = r26
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02e0 }
            r3.setParentMessageText(r1)     // Catch:{ all -> 0x02e0 }
            r26 = r0
            r1 = r27
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02e0 }
            r3.setType(r0)     // Catch:{ all -> 0x02e0 }
            r27 = r1
            r0 = r28
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02e0 }
            r3.setFileUrl(r1)     // Catch:{ all -> 0x02e0 }
            r28 = r0
            r1 = r29
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02e0 }
            r3.setFileName(r0)     // Catch:{ all -> 0x02e0 }
            r3.setMessagePreview(r4)     // Catch:{ all -> 0x02e0 }
            r2.add(r3)     // Catch:{ all -> 0x02e0 }
            r29 = r1
            r0 = r15
            r4 = r34
            r3 = r35
            r1 = r37
            r36 = r30
            r30 = r39
            r39 = r36
            goto L_0x0110
        L_0x02d9:
            r5.close()
            r16.a()
            return r2
        L_0x02e0:
            r0 = move-exception
            goto L_0x02e5
        L_0x02e2:
            r0 = move-exception
            r16 = r3
        L_0x02e5:
            r5.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.getMessageBy(java.lang.String, long):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x01a1 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01a4 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01b5 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01b8 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01d6 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01d8 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01ef A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01f2 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01fc A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0201 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x022a A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x022e A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0268 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x026c A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0295 A[Catch:{ all -> 0x02ff }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity> getMessageBy(java.lang.String r40, java.lang.String r41) {
        /*
            r39 = this;
            r1 = r39
            r0 = r40
            r2 = r41
            r3 = 2
            java.lang.String r4 = "SELECT * FROM ChatMessageEntity WHERE channelUrl = ? AND requestId = ?"
            androidx.room.m r4 = androidx.room.m.a((java.lang.String) r4, (int) r3)
            r5 = 1
            if (r0 != 0) goto L_0x0015
            int[] r0 = r4.f4477f
            r0[r5] = r5
            goto L_0x0018
        L_0x0015:
            r4.a((int) r5, (java.lang.String) r0)
        L_0x0018:
            if (r2 != 0) goto L_0x001f
            int[] r0 = r4.f4477f
            r0[r3] = r5
            goto L_0x0022
        L_0x001f:
            r4.a((int) r3, (java.lang.String) r2)
        L_0x0022:
            androidx.room.j r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.j r0 = r1.__db
            r2 = 0
            android.database.Cursor r3 = androidx.room.b.c.a(r0, r4, r2)
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r3, r0)     // Catch:{ all -> 0x0301 }
            java.lang.String r6 = "messageId"
            int r6 = androidx.room.b.b.b(r3, r6)     // Catch:{ all -> 0x0301 }
            java.lang.String r7 = "messageType"
            int r7 = androidx.room.b.b.b(r3, r7)     // Catch:{ all -> 0x0301 }
            java.lang.String r8 = "requestId"
            int r8 = androidx.room.b.b.b(r3, r8)     // Catch:{ all -> 0x0301 }
            java.lang.String r9 = "channelUrl"
            int r9 = androidx.room.b.b.b(r3, r9)     // Catch:{ all -> 0x0301 }
            java.lang.String r10 = "senderId"
            int r10 = androidx.room.b.b.b(r3, r10)     // Catch:{ all -> 0x0301 }
            java.lang.String r11 = "senderName"
            int r11 = androidx.room.b.b.b(r3, r11)     // Catch:{ all -> 0x0301 }
            java.lang.String r12 = "messageCustomType"
            int r12 = androidx.room.b.b.b(r3, r12)     // Catch:{ all -> 0x0301 }
            java.lang.String r13 = "createdAt"
            int r13 = androidx.room.b.b.b(r3, r13)     // Catch:{ all -> 0x0301 }
            java.lang.String r14 = "updatedAt"
            int r14 = androidx.room.b.b.b(r3, r14)     // Catch:{ all -> 0x0301 }
            java.lang.String r15 = "messageState"
            int r15 = androidx.room.b.b.b(r3, r15)     // Catch:{ all -> 0x0301 }
            java.lang.String r2 = "readEngageEventSent"
            int r2 = androidx.room.b.b.b(r3, r2)     // Catch:{ all -> 0x0301 }
            java.lang.String r5 = "rawMessage"
            int r5 = androidx.room.b.b.b(r3, r5)     // Catch:{ all -> 0x0301 }
            r16 = r4
            java.lang.String r4 = "showAnim"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r41 = r4
            java.lang.String r4 = "messageContent"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r17 = r4
            java.lang.String r4 = "isOperatorMessage"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r18 = r4
            java.lang.String r4 = "channelType"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r19 = r4
            java.lang.String r4 = "customType"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r20 = r4
            java.lang.String r4 = "data"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r21 = r4
            java.lang.String r4 = "errorCode"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r22 = r4
            java.lang.String r4 = "isSilent"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r23 = r4
            java.lang.String r4 = "mentionType"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r24 = r4
            java.lang.String r4 = "sender"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r25 = r4
            java.lang.String r4 = "parentMessageId"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r26 = r4
            java.lang.String r4 = "parentMessageText"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r27 = r4
            java.lang.String r4 = "type"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r28 = r4
            java.lang.String r4 = "fileUrl"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r29 = r4
            java.lang.String r4 = "fileName"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r30 = r4
            java.lang.String r4 = "previewText"
            int r4 = androidx.room.b.b.b(r3, r4)     // Catch:{ all -> 0x02ff }
            r31 = r5
            java.lang.String r5 = "previewDrawable"
            int r5 = androidx.room.b.b.b(r3, r5)     // Catch:{ all -> 0x02ff }
            r32 = r2
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x02ff }
            r33 = r15
            int r15 = r3.getCount()     // Catch:{ all -> 0x02ff }
            r2.<init>(r15)     // Catch:{ all -> 0x02ff }
        L_0x0117:
            boolean r15 = r3.moveToNext()     // Catch:{ all -> 0x02ff }
            if (r15 == 0) goto L_0x02f8
            boolean r15 = r3.isNull(r4)     // Catch:{ all -> 0x02ff }
            r34 = 0
            if (r15 == 0) goto L_0x0133
            boolean r15 = r3.isNull(r5)     // Catch:{ all -> 0x02ff }
            if (r15 != 0) goto L_0x012c
            goto L_0x0133
        L_0x012c:
            r36 = r4
            r35 = r5
            r5 = r34
            goto L_0x015d
        L_0x0133:
            java.lang.String r15 = r3.getString(r4)     // Catch:{ all -> 0x02ff }
            boolean r35 = r3.isNull(r5)     // Catch:{ all -> 0x02ff }
            if (r35 == 0) goto L_0x0144
            r36 = r4
            r35 = r5
            r4 = r34
            goto L_0x0152
        L_0x0144:
            int r35 = r3.getInt(r5)     // Catch:{ all -> 0x02ff }
            java.lang.Integer r35 = java.lang.Integer.valueOf(r35)     // Catch:{ all -> 0x02ff }
            r36 = r4
            r4 = r35
            r35 = r5
        L_0x0152:
            com.paytm.android.chat.data.db.room.converters.Converters r5 = r1.__converters     // Catch:{ all -> 0x02ff }
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r4 = r5.fromMessagePreviewDrawable(r4)     // Catch:{ all -> 0x02ff }
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r5 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02ff }
            r5.<init>(r15, r4)     // Catch:{ all -> 0x02ff }
        L_0x015d:
            com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r4 = new com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity     // Catch:{ all -> 0x02ff }
            r4.<init>()     // Catch:{ all -> 0x02ff }
            int r15 = r3.getInt(r0)     // Catch:{ all -> 0x02ff }
            r4.setId(r15)     // Catch:{ all -> 0x02ff }
            r15 = r0
            long r0 = r3.getLong(r6)     // Catch:{ all -> 0x02ff }
            r4.setMessageId(r0)     // Catch:{ all -> 0x02ff }
            java.lang.String r0 = r3.getString(r7)     // Catch:{ all -> 0x02ff }
            r4.setMessageType(r0)     // Catch:{ all -> 0x02ff }
            java.lang.String r0 = r3.getString(r8)     // Catch:{ all -> 0x02ff }
            r4.setRequestId(r0)     // Catch:{ all -> 0x02ff }
            java.lang.String r0 = r3.getString(r9)     // Catch:{ all -> 0x02ff }
            r4.setChannelUrl(r0)     // Catch:{ all -> 0x02ff }
            java.lang.String r0 = r3.getString(r10)     // Catch:{ all -> 0x02ff }
            r4.setSenderId(r0)     // Catch:{ all -> 0x02ff }
            java.lang.String r0 = r3.getString(r11)     // Catch:{ all -> 0x02ff }
            r4.setSenderName(r0)     // Catch:{ all -> 0x02ff }
            java.lang.String r0 = r3.getString(r12)     // Catch:{ all -> 0x02ff }
            r4.setMessageCustomType(r0)     // Catch:{ all -> 0x02ff }
            boolean r0 = r3.isNull(r13)     // Catch:{ all -> 0x02ff }
            if (r0 == 0) goto L_0x01a4
            r0 = r34
            goto L_0x01ac
        L_0x01a4:
            long r0 = r3.getLong(r13)     // Catch:{ all -> 0x02ff }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02ff }
        L_0x01ac:
            r4.setCreatedAt(r0)     // Catch:{ all -> 0x02ff }
            boolean r0 = r3.isNull(r14)     // Catch:{ all -> 0x02ff }
            if (r0 == 0) goto L_0x01b8
            r0 = r34
            goto L_0x01c0
        L_0x01b8:
            long r0 = r3.getLong(r14)     // Catch:{ all -> 0x02ff }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02ff }
        L_0x01c0:
            r4.setUpdatedAt(r0)     // Catch:{ all -> 0x02ff }
            r0 = r33
            int r1 = r3.getInt(r0)     // Catch:{ all -> 0x02ff }
            r4.setMessageState(r1)     // Catch:{ all -> 0x02ff }
            r1 = r32
            int r32 = r3.getInt(r1)     // Catch:{ all -> 0x02ff }
            r33 = r0
            if (r32 == 0) goto L_0x01d8
            r0 = 1
            goto L_0x01d9
        L_0x01d8:
            r0 = 0
        L_0x01d9:
            r4.setReadEngageEventSent(r0)     // Catch:{ all -> 0x02ff }
            r32 = r1
            r0 = r31
            byte[] r1 = r3.getBlob(r0)     // Catch:{ all -> 0x02ff }
            r4.setRawMessage(r1)     // Catch:{ all -> 0x02ff }
            r1 = r41
            boolean r31 = r3.isNull(r1)     // Catch:{ all -> 0x02ff }
            if (r31 == 0) goto L_0x01f2
            r31 = r34
            goto L_0x01fa
        L_0x01f2:
            int r31 = r3.getInt(r1)     // Catch:{ all -> 0x02ff }
            java.lang.Integer r31 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x02ff }
        L_0x01fa:
            if (r31 != 0) goto L_0x0201
            r41 = r0
            r0 = r34
            goto L_0x0214
        L_0x0201:
            int r31 = r31.intValue()     // Catch:{ all -> 0x02ff }
            if (r31 == 0) goto L_0x020a
            r31 = 1
            goto L_0x020c
        L_0x020a:
            r31 = 0
        L_0x020c:
            java.lang.Boolean r31 = java.lang.Boolean.valueOf(r31)     // Catch:{ all -> 0x02ff }
            r41 = r0
            r0 = r31
        L_0x0214:
            r4.setShowAnim(r0)     // Catch:{ all -> 0x02ff }
            r0 = r17
            r17 = r1
            java.lang.String r1 = r3.getString(r0)     // Catch:{ all -> 0x02ff }
            r4.setMessageContent(r1)     // Catch:{ all -> 0x02ff }
            r1 = r18
            int r18 = r3.getInt(r1)     // Catch:{ all -> 0x02ff }
            if (r18 == 0) goto L_0x022e
            r18 = r0
            r0 = 1
            goto L_0x0231
        L_0x022e:
            r18 = r0
            r0 = 0
        L_0x0231:
            r4.setOperatorMessage(r0)     // Catch:{ all -> 0x02ff }
            r0 = r19
            r19 = r1
            java.lang.String r1 = r3.getString(r0)     // Catch:{ all -> 0x02ff }
            r4.setChannelType(r1)     // Catch:{ all -> 0x02ff }
            r1 = r20
            r20 = r0
            java.lang.String r0 = r3.getString(r1)     // Catch:{ all -> 0x02ff }
            r4.setCustomType(r0)     // Catch:{ all -> 0x02ff }
            r0 = r21
            r21 = r1
            java.lang.String r1 = r3.getString(r0)     // Catch:{ all -> 0x02ff }
            r4.setData(r1)     // Catch:{ all -> 0x02ff }
            r1 = r22
            r22 = r0
            int r0 = r3.getInt(r1)     // Catch:{ all -> 0x02ff }
            r4.setErrorCode(r0)     // Catch:{ all -> 0x02ff }
            r0 = r23
            int r23 = r3.getInt(r0)     // Catch:{ all -> 0x02ff }
            if (r23 == 0) goto L_0x026c
            r23 = r0
            r0 = 1
            goto L_0x026f
        L_0x026c:
            r23 = r0
            r0 = 0
        L_0x026f:
            r4.setSilent(r0)     // Catch:{ all -> 0x02ff }
            r0 = r24
            r24 = r1
            java.lang.String r1 = r3.getString(r0)     // Catch:{ all -> 0x02ff }
            r4.setMentionType(r1)     // Catch:{ all -> 0x02ff }
            r1 = r25
            r25 = r0
            byte[] r0 = r3.getBlob(r1)     // Catch:{ all -> 0x02ff }
            r4.setSender(r0)     // Catch:{ all -> 0x02ff }
            r0 = r26
            boolean r26 = r3.isNull(r0)     // Catch:{ all -> 0x02ff }
            if (r26 == 0) goto L_0x0295
        L_0x0290:
            r26 = r0
            r0 = r34
            goto L_0x029e
        L_0x0295:
            long r37 = r3.getLong(r0)     // Catch:{ all -> 0x02ff }
            java.lang.Long r34 = java.lang.Long.valueOf(r37)     // Catch:{ all -> 0x02ff }
            goto L_0x0290
        L_0x029e:
            r4.setParentMessageId(r0)     // Catch:{ all -> 0x02ff }
            r0 = r27
            r27 = r1
            java.lang.String r1 = r3.getString(r0)     // Catch:{ all -> 0x02ff }
            r4.setParentMessageText(r1)     // Catch:{ all -> 0x02ff }
            r1 = r28
            r28 = r0
            java.lang.String r0 = r3.getString(r1)     // Catch:{ all -> 0x02ff }
            r4.setType(r0)     // Catch:{ all -> 0x02ff }
            r0 = r29
            r29 = r1
            java.lang.String r1 = r3.getString(r0)     // Catch:{ all -> 0x02ff }
            r4.setFileUrl(r1)     // Catch:{ all -> 0x02ff }
            r1 = r30
            r30 = r0
            java.lang.String r0 = r3.getString(r1)     // Catch:{ all -> 0x02ff }
            r4.setFileName(r0)     // Catch:{ all -> 0x02ff }
            r4.setMessagePreview(r5)     // Catch:{ all -> 0x02ff }
            r2.add(r4)     // Catch:{ all -> 0x02ff }
            r31 = r41
            r0 = r15
            r41 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r24
            r24 = r25
            r25 = r27
            r27 = r28
            r28 = r29
            r29 = r30
            r5 = r35
            r4 = r36
            r30 = r1
            r1 = r39
            goto L_0x0117
        L_0x02f8:
            r3.close()
            r16.a()
            return r2
        L_0x02ff:
            r0 = move-exception
            goto L_0x0304
        L_0x0301:
            r0 = move-exception
            r16 = r4
        L_0x0304:
            r3.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.getMessageBy(java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x017e A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0181 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0192 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0195 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01af A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01b1 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01c6 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01c9 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01d3 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01d6 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01f7 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01f9 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0229 A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x022b A[Catch:{ all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x024c A[Catch:{ all -> 0x0289 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity getLatestNotSucceededMessage(java.lang.String r36) {
        /*
            r35 = this;
            r1 = r35
            r0 = r36
            r2 = 1
            java.lang.String r3 = "SELECT * FROM ChatMessageEntity WHERE channelUrl = ? AND messageState IN (0, 1, 2, 4) ORDER BY createdAt DESC LIMIT 1"
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
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r5, r0)     // Catch:{ all -> 0x028b }
            java.lang.String r6 = "messageId"
            int r6 = androidx.room.b.b.b(r5, r6)     // Catch:{ all -> 0x028b }
            java.lang.String r7 = "messageType"
            int r7 = androidx.room.b.b.b(r5, r7)     // Catch:{ all -> 0x028b }
            java.lang.String r8 = "requestId"
            int r8 = androidx.room.b.b.b(r5, r8)     // Catch:{ all -> 0x028b }
            java.lang.String r9 = "channelUrl"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x028b }
            java.lang.String r10 = "senderId"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x028b }
            java.lang.String r11 = "senderName"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x028b }
            java.lang.String r12 = "messageCustomType"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x028b }
            java.lang.String r13 = "createdAt"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x028b }
            java.lang.String r14 = "updatedAt"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x028b }
            java.lang.String r15 = "messageState"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x028b }
            java.lang.String r2 = "readEngageEventSent"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x028b }
            java.lang.String r4 = "rawMessage"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x028b }
            r16 = r3
            java.lang.String r3 = "showAnim"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r17 = r3
            java.lang.String r3 = "messageContent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r18 = r3
            java.lang.String r3 = "isOperatorMessage"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r19 = r3
            java.lang.String r3 = "channelType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r20 = r3
            java.lang.String r3 = "customType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r21 = r3
            java.lang.String r3 = "data"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r22 = r3
            java.lang.String r3 = "errorCode"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r23 = r3
            java.lang.String r3 = "isSilent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r24 = r3
            java.lang.String r3 = "mentionType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r25 = r3
            java.lang.String r3 = "sender"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r26 = r3
            java.lang.String r3 = "parentMessageId"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r27 = r3
            java.lang.String r3 = "parentMessageText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r28 = r3
            java.lang.String r3 = "type"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r29 = r3
            java.lang.String r3 = "fileUrl"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r30 = r3
            java.lang.String r3 = "fileName"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r31 = r3
            java.lang.String r3 = "previewText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x0289 }
            r32 = r4
            java.lang.String r4 = "previewDrawable"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x0289 }
            boolean r33 = r5.moveToFirst()     // Catch:{ all -> 0x0289 }
            r34 = 0
            if (r33 == 0) goto L_0x0280
            boolean r33 = r5.isNull(r3)     // Catch:{ all -> 0x0289 }
            if (r33 == 0) goto L_0x0117
            boolean r33 = r5.isNull(r4)     // Catch:{ all -> 0x0289 }
            if (r33 != 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            r33 = r2
            r4 = r34
            goto L_0x013b
        L_0x0117:
            java.lang.String r3 = r5.getString(r3)     // Catch:{ all -> 0x0289 }
            boolean r33 = r5.isNull(r4)     // Catch:{ all -> 0x0289 }
            if (r33 == 0) goto L_0x0126
            r33 = r2
            r4 = r34
            goto L_0x0130
        L_0x0126:
            int r4 = r5.getInt(r4)     // Catch:{ all -> 0x0289 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0289 }
            r33 = r2
        L_0x0130:
            com.paytm.android.chat.data.db.room.converters.Converters r2 = r1.__converters     // Catch:{ all -> 0x0289 }
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r2 = r2.fromMessagePreviewDrawable(r4)     // Catch:{ all -> 0x0289 }
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r4 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x0289 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0289 }
        L_0x013b:
            com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r2 = new com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity     // Catch:{ all -> 0x0289 }
            r2.<init>()     // Catch:{ all -> 0x0289 }
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0289 }
            r2.setId(r0)     // Catch:{ all -> 0x0289 }
            long r0 = r5.getLong(r6)     // Catch:{ all -> 0x0289 }
            r2.setMessageId(r0)     // Catch:{ all -> 0x0289 }
            java.lang.String r0 = r5.getString(r7)     // Catch:{ all -> 0x0289 }
            r2.setMessageType(r0)     // Catch:{ all -> 0x0289 }
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x0289 }
            r2.setRequestId(r0)     // Catch:{ all -> 0x0289 }
            java.lang.String r0 = r5.getString(r9)     // Catch:{ all -> 0x0289 }
            r2.setChannelUrl(r0)     // Catch:{ all -> 0x0289 }
            java.lang.String r0 = r5.getString(r10)     // Catch:{ all -> 0x0289 }
            r2.setSenderId(r0)     // Catch:{ all -> 0x0289 }
            java.lang.String r0 = r5.getString(r11)     // Catch:{ all -> 0x0289 }
            r2.setSenderName(r0)     // Catch:{ all -> 0x0289 }
            java.lang.String r0 = r5.getString(r12)     // Catch:{ all -> 0x0289 }
            r2.setMessageCustomType(r0)     // Catch:{ all -> 0x0289 }
            boolean r0 = r5.isNull(r13)     // Catch:{ all -> 0x0289 }
            if (r0 == 0) goto L_0x0181
            r0 = r34
            goto L_0x0189
        L_0x0181:
            long r0 = r5.getLong(r13)     // Catch:{ all -> 0x0289 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0289 }
        L_0x0189:
            r2.setCreatedAt(r0)     // Catch:{ all -> 0x0289 }
            boolean r0 = r5.isNull(r14)     // Catch:{ all -> 0x0289 }
            if (r0 == 0) goto L_0x0195
            r0 = r34
            goto L_0x019d
        L_0x0195:
            long r0 = r5.getLong(r14)     // Catch:{ all -> 0x0289 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0289 }
        L_0x019d:
            r2.setUpdatedAt(r0)     // Catch:{ all -> 0x0289 }
            int r0 = r5.getInt(r15)     // Catch:{ all -> 0x0289 }
            r2.setMessageState(r0)     // Catch:{ all -> 0x0289 }
            r0 = r33
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0289 }
            if (r0 == 0) goto L_0x01b1
            r0 = 1
            goto L_0x01b2
        L_0x01b1:
            r0 = 0
        L_0x01b2:
            r2.setReadEngageEventSent(r0)     // Catch:{ all -> 0x0289 }
            r0 = r32
            byte[] r0 = r5.getBlob(r0)     // Catch:{ all -> 0x0289 }
            r2.setRawMessage(r0)     // Catch:{ all -> 0x0289 }
            r0 = r17
            boolean r1 = r5.isNull(r0)     // Catch:{ all -> 0x0289 }
            if (r1 == 0) goto L_0x01c9
            r0 = r34
            goto L_0x01d1
        L_0x01c9:
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0289 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0289 }
        L_0x01d1:
            if (r0 != 0) goto L_0x01d6
            r0 = r34
            goto L_0x01e3
        L_0x01d6:
            int r0 = r0.intValue()     // Catch:{ all -> 0x0289 }
            if (r0 == 0) goto L_0x01de
            r0 = 1
            goto L_0x01df
        L_0x01de:
            r0 = 0
        L_0x01df:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0289 }
        L_0x01e3:
            r2.setShowAnim(r0)     // Catch:{ all -> 0x0289 }
            r0 = r18
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setMessageContent(r0)     // Catch:{ all -> 0x0289 }
            r0 = r19
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0289 }
            if (r0 == 0) goto L_0x01f9
            r0 = 1
            goto L_0x01fa
        L_0x01f9:
            r0 = 0
        L_0x01fa:
            r2.setOperatorMessage(r0)     // Catch:{ all -> 0x0289 }
            r0 = r20
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setChannelType(r0)     // Catch:{ all -> 0x0289 }
            r0 = r21
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setCustomType(r0)     // Catch:{ all -> 0x0289 }
            r0 = r22
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setData(r0)     // Catch:{ all -> 0x0289 }
            r0 = r23
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0289 }
            r2.setErrorCode(r0)     // Catch:{ all -> 0x0289 }
            r0 = r24
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0289 }
            if (r0 == 0) goto L_0x022b
            r0 = 1
            goto L_0x022c
        L_0x022b:
            r0 = 0
        L_0x022c:
            r2.setSilent(r0)     // Catch:{ all -> 0x0289 }
            r0 = r25
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setMentionType(r0)     // Catch:{ all -> 0x0289 }
            r0 = r26
            byte[] r0 = r5.getBlob(r0)     // Catch:{ all -> 0x0289 }
            r2.setSender(r0)     // Catch:{ all -> 0x0289 }
            r0 = r27
            boolean r1 = r5.isNull(r0)     // Catch:{ all -> 0x0289 }
            if (r1 == 0) goto L_0x024c
        L_0x0249:
            r0 = r34
            goto L_0x0255
        L_0x024c:
            long r0 = r5.getLong(r0)     // Catch:{ all -> 0x0289 }
            java.lang.Long r34 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0289 }
            goto L_0x0249
        L_0x0255:
            r2.setParentMessageId(r0)     // Catch:{ all -> 0x0289 }
            r0 = r28
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setParentMessageText(r0)     // Catch:{ all -> 0x0289 }
            r0 = r29
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setType(r0)     // Catch:{ all -> 0x0289 }
            r0 = r30
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setFileUrl(r0)     // Catch:{ all -> 0x0289 }
            r0 = r31
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x0289 }
            r2.setFileName(r0)     // Catch:{ all -> 0x0289 }
            r2.setMessagePreview(r4)     // Catch:{ all -> 0x0289 }
            goto L_0x0282
        L_0x0280:
            r2 = r34
        L_0x0282:
            r5.close()
            r16.a()
            return r2
        L_0x0289:
            r0 = move-exception
            goto L_0x028e
        L_0x028b:
            r0 = move-exception
            r16 = r3
        L_0x028e:
            r5.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.getLatestNotSucceededMessage(java.lang.String):com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity");
    }

    public final Long getOldestMessageTsForChannel(String str) {
        m a2 = m.a("SELECT createdAt FROM ChatMessageEntity WHERE channelUrl = ? ORDER BY createdAt ASC LIMIT 1", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            return (!a3.moveToFirst() || a3.isNull(0)) ? null : Long.valueOf(a3.getLong(0));
        } finally {
            a3.close();
            a2.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0194 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0197 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01a8 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01ab A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01c9 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01cb A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e2 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01e5 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01ef A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01f4 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x021d A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0221 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x025d A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x025f A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0286 A[Catch:{ all -> 0x02d6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity> getNonAdminMessagesByChannelUrl(java.lang.String r39) {
        /*
            r38 = this;
            r1 = r38
            r0 = r39
            r2 = 1
            java.lang.String r3 = "SELECT * FROM ChatMessageEntity WHERE channelUrl = ? AND messageType != 'admin'"
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
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r5, r0)     // Catch:{ all -> 0x02d8 }
            java.lang.String r6 = "messageId"
            int r6 = androidx.room.b.b.b(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r7 = "messageType"
            int r7 = androidx.room.b.b.b(r5, r7)     // Catch:{ all -> 0x02d8 }
            java.lang.String r8 = "requestId"
            int r8 = androidx.room.b.b.b(r5, r8)     // Catch:{ all -> 0x02d8 }
            java.lang.String r9 = "channelUrl"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x02d8 }
            java.lang.String r10 = "senderId"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x02d8 }
            java.lang.String r11 = "senderName"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x02d8 }
            java.lang.String r12 = "messageCustomType"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x02d8 }
            java.lang.String r13 = "createdAt"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x02d8 }
            java.lang.String r14 = "updatedAt"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x02d8 }
            java.lang.String r15 = "messageState"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x02d8 }
            java.lang.String r2 = "readEngageEventSent"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x02d8 }
            java.lang.String r4 = "rawMessage"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02d8 }
            r16 = r3
            java.lang.String r3 = "showAnim"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r17 = r3
            java.lang.String r3 = "messageContent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r18 = r3
            java.lang.String r3 = "isOperatorMessage"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r19 = r3
            java.lang.String r3 = "channelType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r20 = r3
            java.lang.String r3 = "customType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r21 = r3
            java.lang.String r3 = "data"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r22 = r3
            java.lang.String r3 = "errorCode"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r23 = r3
            java.lang.String r3 = "isSilent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r24 = r3
            java.lang.String r3 = "mentionType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r25 = r3
            java.lang.String r3 = "sender"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r26 = r3
            java.lang.String r3 = "parentMessageId"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r27 = r3
            java.lang.String r3 = "parentMessageText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r28 = r3
            java.lang.String r3 = "type"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r29 = r3
            java.lang.String r3 = "fileUrl"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r30 = r3
            java.lang.String r3 = "fileName"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r31 = r3
            java.lang.String r3 = "previewText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r32 = r4
            java.lang.String r4 = "previewDrawable"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02d6 }
            r33 = r2
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x02d6 }
            r34 = r15
            int r15 = r5.getCount()     // Catch:{ all -> 0x02d6 }
            r2.<init>(r15)     // Catch:{ all -> 0x02d6 }
        L_0x010a:
            boolean r15 = r5.moveToNext()     // Catch:{ all -> 0x02d6 }
            if (r15 == 0) goto L_0x02cf
            boolean r15 = r5.isNull(r3)     // Catch:{ all -> 0x02d6 }
            r35 = 0
            if (r15 == 0) goto L_0x0126
            boolean r15 = r5.isNull(r4)     // Catch:{ all -> 0x02d6 }
            if (r15 != 0) goto L_0x011f
            goto L_0x0126
        L_0x011f:
            r37 = r3
            r36 = r4
            r4 = r35
            goto L_0x0150
        L_0x0126:
            java.lang.String r15 = r5.getString(r3)     // Catch:{ all -> 0x02d6 }
            boolean r36 = r5.isNull(r4)     // Catch:{ all -> 0x02d6 }
            if (r36 == 0) goto L_0x0137
            r37 = r3
            r36 = r4
            r3 = r35
            goto L_0x0145
        L_0x0137:
            int r36 = r5.getInt(r4)     // Catch:{ all -> 0x02d6 }
            java.lang.Integer r36 = java.lang.Integer.valueOf(r36)     // Catch:{ all -> 0x02d6 }
            r37 = r3
            r3 = r36
            r36 = r4
        L_0x0145:
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r1.__converters     // Catch:{ all -> 0x02d6 }
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r3 = r4.fromMessagePreviewDrawable(r3)     // Catch:{ all -> 0x02d6 }
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r4 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02d6 }
            r4.<init>(r15, r3)     // Catch:{ all -> 0x02d6 }
        L_0x0150:
            com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r3 = new com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity     // Catch:{ all -> 0x02d6 }
            r3.<init>()     // Catch:{ all -> 0x02d6 }
            int r15 = r5.getInt(r0)     // Catch:{ all -> 0x02d6 }
            r3.setId(r15)     // Catch:{ all -> 0x02d6 }
            r15 = r0
            long r0 = r5.getLong(r6)     // Catch:{ all -> 0x02d6 }
            r3.setMessageId(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r7)     // Catch:{ all -> 0x02d6 }
            r3.setMessageType(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x02d6 }
            r3.setRequestId(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r9)     // Catch:{ all -> 0x02d6 }
            r3.setChannelUrl(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r10)     // Catch:{ all -> 0x02d6 }
            r3.setSenderId(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r11)     // Catch:{ all -> 0x02d6 }
            r3.setSenderName(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r12)     // Catch:{ all -> 0x02d6 }
            r3.setMessageCustomType(r0)     // Catch:{ all -> 0x02d6 }
            boolean r0 = r5.isNull(r13)     // Catch:{ all -> 0x02d6 }
            if (r0 == 0) goto L_0x0197
            r0 = r35
            goto L_0x019f
        L_0x0197:
            long r0 = r5.getLong(r13)     // Catch:{ all -> 0x02d6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02d6 }
        L_0x019f:
            r3.setCreatedAt(r0)     // Catch:{ all -> 0x02d6 }
            boolean r0 = r5.isNull(r14)     // Catch:{ all -> 0x02d6 }
            if (r0 == 0) goto L_0x01ab
            r0 = r35
            goto L_0x01b3
        L_0x01ab:
            long r0 = r5.getLong(r14)     // Catch:{ all -> 0x02d6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02d6 }
        L_0x01b3:
            r3.setUpdatedAt(r0)     // Catch:{ all -> 0x02d6 }
            r0 = r34
            int r1 = r5.getInt(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMessageState(r1)     // Catch:{ all -> 0x02d6 }
            r1 = r33
            int r33 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            r34 = r0
            if (r33 == 0) goto L_0x01cb
            r0 = 1
            goto L_0x01cc
        L_0x01cb:
            r0 = 0
        L_0x01cc:
            r3.setReadEngageEventSent(r0)     // Catch:{ all -> 0x02d6 }
            r33 = r1
            r0 = r32
            byte[] r1 = r5.getBlob(r0)     // Catch:{ all -> 0x02d6 }
            r3.setRawMessage(r1)     // Catch:{ all -> 0x02d6 }
            r1 = r17
            boolean r17 = r5.isNull(r1)     // Catch:{ all -> 0x02d6 }
            if (r17 == 0) goto L_0x01e5
            r17 = r35
            goto L_0x01ed
        L_0x01e5:
            int r17 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x02d6 }
        L_0x01ed:
            if (r17 != 0) goto L_0x01f4
            r32 = r0
            r0 = r35
            goto L_0x0207
        L_0x01f4:
            int r17 = r17.intValue()     // Catch:{ all -> 0x02d6 }
            if (r17 == 0) goto L_0x01fd
            r17 = 1
            goto L_0x01ff
        L_0x01fd:
            r17 = 0
        L_0x01ff:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r17)     // Catch:{ all -> 0x02d6 }
            r32 = r0
            r0 = r17
        L_0x0207:
            r3.setShowAnim(r0)     // Catch:{ all -> 0x02d6 }
            r17 = r1
            r0 = r18
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMessageContent(r1)     // Catch:{ all -> 0x02d6 }
            r1 = r19
            int r18 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            if (r18 == 0) goto L_0x0221
            r18 = r0
            r0 = 1
            goto L_0x0224
        L_0x0221:
            r18 = r0
            r0 = 0
        L_0x0224:
            r3.setOperatorMessage(r0)     // Catch:{ all -> 0x02d6 }
            r19 = r1
            r0 = r20
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setChannelType(r1)     // Catch:{ all -> 0x02d6 }
            r20 = r0
            r1 = r21
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02d6 }
            r3.setCustomType(r0)     // Catch:{ all -> 0x02d6 }
            r21 = r1
            r0 = r22
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setData(r1)     // Catch:{ all -> 0x02d6 }
            r22 = r0
            r1 = r23
            int r0 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            r3.setErrorCode(r0)     // Catch:{ all -> 0x02d6 }
            r0 = r24
            int r23 = r5.getInt(r0)     // Catch:{ all -> 0x02d6 }
            r24 = r0
            if (r23 == 0) goto L_0x025f
            r0 = 1
            goto L_0x0260
        L_0x025f:
            r0 = 0
        L_0x0260:
            r3.setSilent(r0)     // Catch:{ all -> 0x02d6 }
            r23 = r1
            r0 = r25
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMentionType(r1)     // Catch:{ all -> 0x02d6 }
            r25 = r0
            r1 = r26
            byte[] r0 = r5.getBlob(r1)     // Catch:{ all -> 0x02d6 }
            r3.setSender(r0)     // Catch:{ all -> 0x02d6 }
            r0 = r27
            boolean r26 = r5.isNull(r0)     // Catch:{ all -> 0x02d6 }
            if (r26 == 0) goto L_0x0286
        L_0x0281:
            r27 = r0
            r0 = r35
            goto L_0x028f
        L_0x0286:
            long r26 = r5.getLong(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.Long r35 = java.lang.Long.valueOf(r26)     // Catch:{ all -> 0x02d6 }
            goto L_0x0281
        L_0x028f:
            r3.setParentMessageId(r0)     // Catch:{ all -> 0x02d6 }
            r26 = r1
            r0 = r28
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setParentMessageText(r1)     // Catch:{ all -> 0x02d6 }
            r28 = r0
            r1 = r29
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02d6 }
            r3.setType(r0)     // Catch:{ all -> 0x02d6 }
            r29 = r1
            r0 = r30
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setFileUrl(r1)     // Catch:{ all -> 0x02d6 }
            r30 = r0
            r1 = r31
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02d6 }
            r3.setFileName(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMessagePreview(r4)     // Catch:{ all -> 0x02d6 }
            r2.add(r3)     // Catch:{ all -> 0x02d6 }
            r31 = r1
            r0 = r15
            r4 = r36
            r3 = r37
            r1 = r38
            goto L_0x010a
        L_0x02cf:
            r5.close()
            r16.a()
            return r2
        L_0x02d6:
            r0 = move-exception
            goto L_0x02db
        L_0x02d8:
            r0 = move-exception
            r16 = r3
        L_0x02db:
            r5.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.getNonAdminMessagesByChannelUrl(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0194 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0197 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01a8 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01ab A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01c9 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01cb A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e2 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01e5 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01ef A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01f4 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x021d A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0221 A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x025d A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x025f A[Catch:{ all -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0286 A[Catch:{ all -> 0x02d6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity> getPreviewTextNotEmptyMessagesByChannelUrl(java.lang.String r39) {
        /*
            r38 = this;
            r1 = r38
            r0 = r39
            r2 = 1
            java.lang.String r3 = "SELECT * FROM ChatMessageEntity WHERE channelUrl = ? AND previewText IS NOT NULL AND previewText != ''"
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
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r5, r0)     // Catch:{ all -> 0x02d8 }
            java.lang.String r6 = "messageId"
            int r6 = androidx.room.b.b.b(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r7 = "messageType"
            int r7 = androidx.room.b.b.b(r5, r7)     // Catch:{ all -> 0x02d8 }
            java.lang.String r8 = "requestId"
            int r8 = androidx.room.b.b.b(r5, r8)     // Catch:{ all -> 0x02d8 }
            java.lang.String r9 = "channelUrl"
            int r9 = androidx.room.b.b.b(r5, r9)     // Catch:{ all -> 0x02d8 }
            java.lang.String r10 = "senderId"
            int r10 = androidx.room.b.b.b(r5, r10)     // Catch:{ all -> 0x02d8 }
            java.lang.String r11 = "senderName"
            int r11 = androidx.room.b.b.b(r5, r11)     // Catch:{ all -> 0x02d8 }
            java.lang.String r12 = "messageCustomType"
            int r12 = androidx.room.b.b.b(r5, r12)     // Catch:{ all -> 0x02d8 }
            java.lang.String r13 = "createdAt"
            int r13 = androidx.room.b.b.b(r5, r13)     // Catch:{ all -> 0x02d8 }
            java.lang.String r14 = "updatedAt"
            int r14 = androidx.room.b.b.b(r5, r14)     // Catch:{ all -> 0x02d8 }
            java.lang.String r15 = "messageState"
            int r15 = androidx.room.b.b.b(r5, r15)     // Catch:{ all -> 0x02d8 }
            java.lang.String r2 = "readEngageEventSent"
            int r2 = androidx.room.b.b.b(r5, r2)     // Catch:{ all -> 0x02d8 }
            java.lang.String r4 = "rawMessage"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02d8 }
            r16 = r3
            java.lang.String r3 = "showAnim"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r17 = r3
            java.lang.String r3 = "messageContent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r18 = r3
            java.lang.String r3 = "isOperatorMessage"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r19 = r3
            java.lang.String r3 = "channelType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r20 = r3
            java.lang.String r3 = "customType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r21 = r3
            java.lang.String r3 = "data"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r22 = r3
            java.lang.String r3 = "errorCode"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r23 = r3
            java.lang.String r3 = "isSilent"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r24 = r3
            java.lang.String r3 = "mentionType"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r25 = r3
            java.lang.String r3 = "sender"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r26 = r3
            java.lang.String r3 = "parentMessageId"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r27 = r3
            java.lang.String r3 = "parentMessageText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r28 = r3
            java.lang.String r3 = "type"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r29 = r3
            java.lang.String r3 = "fileUrl"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r30 = r3
            java.lang.String r3 = "fileName"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r31 = r3
            java.lang.String r3 = "previewText"
            int r3 = androidx.room.b.b.b(r5, r3)     // Catch:{ all -> 0x02d6 }
            r32 = r4
            java.lang.String r4 = "previewDrawable"
            int r4 = androidx.room.b.b.b(r5, r4)     // Catch:{ all -> 0x02d6 }
            r33 = r2
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x02d6 }
            r34 = r15
            int r15 = r5.getCount()     // Catch:{ all -> 0x02d6 }
            r2.<init>(r15)     // Catch:{ all -> 0x02d6 }
        L_0x010a:
            boolean r15 = r5.moveToNext()     // Catch:{ all -> 0x02d6 }
            if (r15 == 0) goto L_0x02cf
            boolean r15 = r5.isNull(r3)     // Catch:{ all -> 0x02d6 }
            r35 = 0
            if (r15 == 0) goto L_0x0126
            boolean r15 = r5.isNull(r4)     // Catch:{ all -> 0x02d6 }
            if (r15 != 0) goto L_0x011f
            goto L_0x0126
        L_0x011f:
            r37 = r3
            r36 = r4
            r4 = r35
            goto L_0x0150
        L_0x0126:
            java.lang.String r15 = r5.getString(r3)     // Catch:{ all -> 0x02d6 }
            boolean r36 = r5.isNull(r4)     // Catch:{ all -> 0x02d6 }
            if (r36 == 0) goto L_0x0137
            r37 = r3
            r36 = r4
            r3 = r35
            goto L_0x0145
        L_0x0137:
            int r36 = r5.getInt(r4)     // Catch:{ all -> 0x02d6 }
            java.lang.Integer r36 = java.lang.Integer.valueOf(r36)     // Catch:{ all -> 0x02d6 }
            r37 = r3
            r3 = r36
            r36 = r4
        L_0x0145:
            com.paytm.android.chat.data.db.room.converters.Converters r4 = r1.__converters     // Catch:{ all -> 0x02d6 }
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r3 = r4.fromMessagePreviewDrawable(r3)     // Catch:{ all -> 0x02d6 }
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r4 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview     // Catch:{ all -> 0x02d6 }
            r4.<init>(r15, r3)     // Catch:{ all -> 0x02d6 }
        L_0x0150:
            com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r3 = new com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity     // Catch:{ all -> 0x02d6 }
            r3.<init>()     // Catch:{ all -> 0x02d6 }
            int r15 = r5.getInt(r0)     // Catch:{ all -> 0x02d6 }
            r3.setId(r15)     // Catch:{ all -> 0x02d6 }
            r15 = r0
            long r0 = r5.getLong(r6)     // Catch:{ all -> 0x02d6 }
            r3.setMessageId(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r7)     // Catch:{ all -> 0x02d6 }
            r3.setMessageType(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x02d6 }
            r3.setRequestId(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r9)     // Catch:{ all -> 0x02d6 }
            r3.setChannelUrl(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r10)     // Catch:{ all -> 0x02d6 }
            r3.setSenderId(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r11)     // Catch:{ all -> 0x02d6 }
            r3.setSenderName(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.String r0 = r5.getString(r12)     // Catch:{ all -> 0x02d6 }
            r3.setMessageCustomType(r0)     // Catch:{ all -> 0x02d6 }
            boolean r0 = r5.isNull(r13)     // Catch:{ all -> 0x02d6 }
            if (r0 == 0) goto L_0x0197
            r0 = r35
            goto L_0x019f
        L_0x0197:
            long r0 = r5.getLong(r13)     // Catch:{ all -> 0x02d6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02d6 }
        L_0x019f:
            r3.setCreatedAt(r0)     // Catch:{ all -> 0x02d6 }
            boolean r0 = r5.isNull(r14)     // Catch:{ all -> 0x02d6 }
            if (r0 == 0) goto L_0x01ab
            r0 = r35
            goto L_0x01b3
        L_0x01ab:
            long r0 = r5.getLong(r14)     // Catch:{ all -> 0x02d6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x02d6 }
        L_0x01b3:
            r3.setUpdatedAt(r0)     // Catch:{ all -> 0x02d6 }
            r0 = r34
            int r1 = r5.getInt(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMessageState(r1)     // Catch:{ all -> 0x02d6 }
            r1 = r33
            int r33 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            r34 = r0
            if (r33 == 0) goto L_0x01cb
            r0 = 1
            goto L_0x01cc
        L_0x01cb:
            r0 = 0
        L_0x01cc:
            r3.setReadEngageEventSent(r0)     // Catch:{ all -> 0x02d6 }
            r33 = r1
            r0 = r32
            byte[] r1 = r5.getBlob(r0)     // Catch:{ all -> 0x02d6 }
            r3.setRawMessage(r1)     // Catch:{ all -> 0x02d6 }
            r1 = r17
            boolean r17 = r5.isNull(r1)     // Catch:{ all -> 0x02d6 }
            if (r17 == 0) goto L_0x01e5
            r17 = r35
            goto L_0x01ed
        L_0x01e5:
            int r17 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x02d6 }
        L_0x01ed:
            if (r17 != 0) goto L_0x01f4
            r32 = r0
            r0 = r35
            goto L_0x0207
        L_0x01f4:
            int r17 = r17.intValue()     // Catch:{ all -> 0x02d6 }
            if (r17 == 0) goto L_0x01fd
            r17 = 1
            goto L_0x01ff
        L_0x01fd:
            r17 = 0
        L_0x01ff:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r17)     // Catch:{ all -> 0x02d6 }
            r32 = r0
            r0 = r17
        L_0x0207:
            r3.setShowAnim(r0)     // Catch:{ all -> 0x02d6 }
            r17 = r1
            r0 = r18
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMessageContent(r1)     // Catch:{ all -> 0x02d6 }
            r1 = r19
            int r18 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            if (r18 == 0) goto L_0x0221
            r18 = r0
            r0 = 1
            goto L_0x0224
        L_0x0221:
            r18 = r0
            r0 = 0
        L_0x0224:
            r3.setOperatorMessage(r0)     // Catch:{ all -> 0x02d6 }
            r19 = r1
            r0 = r20
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setChannelType(r1)     // Catch:{ all -> 0x02d6 }
            r20 = r0
            r1 = r21
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02d6 }
            r3.setCustomType(r0)     // Catch:{ all -> 0x02d6 }
            r21 = r1
            r0 = r22
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setData(r1)     // Catch:{ all -> 0x02d6 }
            r22 = r0
            r1 = r23
            int r0 = r5.getInt(r1)     // Catch:{ all -> 0x02d6 }
            r3.setErrorCode(r0)     // Catch:{ all -> 0x02d6 }
            r0 = r24
            int r23 = r5.getInt(r0)     // Catch:{ all -> 0x02d6 }
            r24 = r0
            if (r23 == 0) goto L_0x025f
            r0 = 1
            goto L_0x0260
        L_0x025f:
            r0 = 0
        L_0x0260:
            r3.setSilent(r0)     // Catch:{ all -> 0x02d6 }
            r23 = r1
            r0 = r25
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMentionType(r1)     // Catch:{ all -> 0x02d6 }
            r25 = r0
            r1 = r26
            byte[] r0 = r5.getBlob(r1)     // Catch:{ all -> 0x02d6 }
            r3.setSender(r0)     // Catch:{ all -> 0x02d6 }
            r0 = r27
            boolean r26 = r5.isNull(r0)     // Catch:{ all -> 0x02d6 }
            if (r26 == 0) goto L_0x0286
        L_0x0281:
            r27 = r0
            r0 = r35
            goto L_0x028f
        L_0x0286:
            long r26 = r5.getLong(r0)     // Catch:{ all -> 0x02d6 }
            java.lang.Long r35 = java.lang.Long.valueOf(r26)     // Catch:{ all -> 0x02d6 }
            goto L_0x0281
        L_0x028f:
            r3.setParentMessageId(r0)     // Catch:{ all -> 0x02d6 }
            r26 = r1
            r0 = r28
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setParentMessageText(r1)     // Catch:{ all -> 0x02d6 }
            r28 = r0
            r1 = r29
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02d6 }
            r3.setType(r0)     // Catch:{ all -> 0x02d6 }
            r29 = r1
            r0 = r30
            java.lang.String r1 = r5.getString(r0)     // Catch:{ all -> 0x02d6 }
            r3.setFileUrl(r1)     // Catch:{ all -> 0x02d6 }
            r30 = r0
            r1 = r31
            java.lang.String r0 = r5.getString(r1)     // Catch:{ all -> 0x02d6 }
            r3.setFileName(r0)     // Catch:{ all -> 0x02d6 }
            r3.setMessagePreview(r4)     // Catch:{ all -> 0x02d6 }
            r2.add(r3)     // Catch:{ all -> 0x02d6 }
            r31 = r1
            r0 = r15
            r4 = r36
            r3 = r37
            r1 = r38
            goto L_0x010a
        L_0x02cf:
            r5.close()
            r16.a()
            return r2
        L_0x02d6:
            r0 = move-exception
            goto L_0x02db
        L_0x02d8:
            r0 = move-exception
            r16 = r3
        L_0x02db:
            r5.close()
            r16.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.dao.ChatMessageDao_Impl.getPreviewTextNotEmptyMessagesByChannelUrl(java.lang.String):java.util.List");
    }
}
