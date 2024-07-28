package com.sendbird.android;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.ReactionEvent;
import com.sendbird.android.SendBird;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public abstract class BaseMessage {
    static final int NEVER_DELETED_AUTOMATICALLY = -1;
    protected static final Set<Integer> RESENDABLE_ERROR_CODES = new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(SendBirdError.ERR_CONNECTION_REQUIRED), Integer.valueOf(SendBirdError.ERR_NETWORK), Integer.valueOf(SendBirdError.ERR_ACK_TIMEOUT), Integer.valueOf(SendBirdError.ERR_WEBSOCKET_CONNECTION_CLOSED), Integer.valueOf(SendBirdError.ERR_WEBSOCKET_CONNECTION_FAILED), Integer.valueOf(SendBirdError.ERR_PENDING)}));
    private boolean forceUpdateLastMessage;
    private boolean isOperatorMessage;
    protected String mChannelType;
    protected String mChannelUrl;
    protected long mCreatedAt;
    protected String mCustomType;
    protected String mData;
    protected int mErrorCode;
    protected boolean mIsGlobalBlocked;
    private boolean mIsSilent;
    protected BaseMessageParams.MentionType mMentionType;
    protected List<String> mMentionedUserIds;
    protected List<User> mMentionedUsers;
    protected long mMessageId;
    protected List<MessageMetaArray> mMetaArrays;
    protected Sender mSender;
    protected long mUpdatedAt;
    private int messageSurvivalSeconds;
    private OGMetaData ogMetaData;
    protected long parentMessageId;
    private String parentMessageText;
    private final List<Reaction> reactionList;
    protected long rootMessageId;
    private SendingStatus sendingStatus;
    private ThreadInfo threadInfo;

    public interface GetMessageHandler {
        void onResult(BaseMessage baseMessage, SendBirdException sendBirdException);
    }

    public interface GetThreadedMessagesHandler {
        void onResult(BaseMessage baseMessage, List<BaseMessage> list, SendBirdException sendBirdException);
    }

    public abstract String getMessage();

    public abstract String getRequestId();

    public enum SendingStatus {
        NONE("none"),
        PENDING(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING),
        FAILED("failed"),
        SUCCEEDED("succeeded"),
        CANCELED("canceled");
        
        private String value;

        private SendingStatus(String str) {
            this.value = str;
        }

        public static SendingStatus fromValue(String str) {
            for (SendingStatus sendingStatus : values()) {
                if (sendingStatus.getValue().equals(str)) {
                    return sendingStatus;
                }
            }
            return NONE;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static void getMessage(final MessageRetrievalParams messageRetrievalParams, final GetMessageHandler getMessageHandler) {
        d.a(new q<BaseMessage>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                BaseMessage baseMessage = (BaseMessage) obj;
                GetMessageHandler getMessageHandler = getMessageHandler;
                if (getMessageHandler != null) {
                    getMessageHandler.onResult(baseMessage, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (messageRetrievalParams != null) {
                    return BaseMessage.build(APIClient.a().a(messageRetrievalParams), messageRetrievalParams.channelUrl, messageRetrievalParams.channelType.value());
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public Sender getSender() {
        User user;
        if (this.mSender == null) {
            return null;
        }
        if (SendBird.Options.useMemberAsMessageSender && GroupChannel.sCachedChannels.containsKey(this.mChannelUrl) && (user = GroupChannel.sCachedChannels.get(this.mChannelUrl).mMemberMap.get(this.mSender.getUserId())) != null) {
            this.mSender.updatePropertiesByUser(user);
        }
        return this.mSender;
    }

    /* access modifiers changed from: package-private */
    public void setSendingStatus(SendingStatus sendingStatus2) {
        this.sendingStatus = sendingStatus2;
    }

    public SendingStatus getSendingStatus() {
        return this.sendingStatus;
    }

    public boolean isResendable() {
        if (this.sendingStatus != SendingStatus.CANCELED) {
            return this.sendingStatus == SendingStatus.FAILED && RESENDABLE_ERROR_CODES.contains(Integer.valueOf(this.mErrorCode));
        }
        return true;
    }

    public static boolean belongsTo(BaseMessage baseMessage, String str) {
        Sender sender;
        if (TextUtils.isEmpty(str) || baseMessage == null || (sender = baseMessage.mSender) == null || !str.equalsIgnoreCase(sender.getUserId())) {
            return false;
        }
        return true;
    }

    public static boolean belongsTo(BaseMessage baseMessage, User user) {
        if (user == null) {
            return false;
        }
        return belongsTo(baseMessage, user.getUserId());
    }

    /* JADX WARNING: Removed duplicated region for block: B:163:0x0372 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x037b A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0382 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x038d A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0395 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03a0 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03a8 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03b3 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03bb A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03c6 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03d8 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03db A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03e5 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03f2 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0404 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0407 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0419 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x041c A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0432 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0434 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0549 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0552 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0559 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0564 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x056c A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0577 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x057f A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x058a A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0592 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x059d A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x05af A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x05b2 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x05bc A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x05c9 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x05db A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x05de A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x05f0 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x05f3 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x05ff A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0611 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0627 A[Catch:{ Exception -> 0x066f }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0629 A[Catch:{ Exception -> 0x066f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.sendbird.android.BaseMessage build(com.sendbird.android.shadow.com.google.gson.JsonElement r49, java.lang.String r50, java.lang.String r51) {
        /*
            com.sendbird.android.shadow.com.google.gson.JsonObject r0 = r49.getAsJsonObject()     // Catch:{ Exception -> 0x066f }
            java.lang.String r2 = "type"
            com.sendbird.android.shadow.com.google.gson.JsonElement r2 = r0.get(r2)     // Catch:{ Exception -> 0x066f }
            java.lang.String r2 = r2.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r3 = "user"
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r3)     // Catch:{ Exception -> 0x066f }
            if (r3 == 0) goto L_0x0023
            boolean r4 = r3.isJsonNull()     // Catch:{ Exception -> 0x066f }
            if (r4 != 0) goto L_0x0023
            com.sendbird.android.shadow.com.google.gson.JsonObject r4 = r3.getAsJsonObject()     // Catch:{ Exception -> 0x066f }
            goto L_0x0024
        L_0x0023:
            r4 = 0
        L_0x0024:
            if (r4 == 0) goto L_0x0045
            java.lang.String r5 = "user_id"
            boolean r4 = r4.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r4 != 0) goto L_0x003e
            com.sendbird.android.shadow.com.google.gson.JsonObject r4 = r3.getAsJsonObject()     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = "guest_id"
            boolean r4 = r4.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r4 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r4 = 0
            goto L_0x0043
        L_0x003e:
            com.sendbird.android.Sender r4 = new com.sendbird.android.Sender     // Catch:{ Exception -> 0x066f }
            r4.<init>(r3)     // Catch:{ Exception -> 0x066f }
        L_0x0043:
            r13 = r4
            goto L_0x0046
        L_0x0045:
            r13 = 0
        L_0x0046:
            java.lang.String r3 = "root_message_id"
            boolean r3 = r0.has(r3)     // Catch:{ Exception -> 0x066f }
            if (r3 == 0) goto L_0x005b
            java.lang.String r3 = "root_message_id"
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r3)     // Catch:{ Exception -> 0x066f }
            long r6 = r3.getAsLong()     // Catch:{ Exception -> 0x066f }
            r16 = r6
            goto L_0x005d
        L_0x005b:
            r16 = 0
        L_0x005d:
            java.lang.String r3 = "parent_message_id"
            boolean r3 = r0.has(r3)     // Catch:{ Exception -> 0x066f }
            if (r3 == 0) goto L_0x0072
            java.lang.String r3 = "parent_message_id"
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r3)     // Catch:{ Exception -> 0x066f }
            long r6 = r3.getAsLong()     // Catch:{ Exception -> 0x066f }
            r18 = r6
            goto L_0x0074
        L_0x0072:
            r18 = 0
        L_0x0074:
            java.lang.String r3 = "parent_message_text"
            boolean r3 = r0.has(r3)     // Catch:{ Exception -> 0x066f }
            if (r3 == 0) goto L_0x0089
            java.lang.String r3 = "parent_message_text"
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r3)     // Catch:{ Exception -> 0x066f }
            java.lang.String r3 = r3.getAsString()     // Catch:{ Exception -> 0x066f }
            r40 = r3
            goto L_0x008b
        L_0x0089:
            r40 = 0
        L_0x008b:
            java.lang.String r3 = "thread_info"
            boolean r3 = r0.has(r3)     // Catch:{ Exception -> 0x066f }
            if (r3 == 0) goto L_0x00a1
            com.sendbird.android.ThreadInfo r3 = new com.sendbird.android.ThreadInfo     // Catch:{ Exception -> 0x066f }
            java.lang.String r6 = "thread_info"
            com.sendbird.android.shadow.com.google.gson.JsonElement r6 = r0.get(r6)     // Catch:{ Exception -> 0x066f }
            r3.<init>(r6)     // Catch:{ Exception -> 0x066f }
            goto L_0x00a6
        L_0x00a1:
            com.sendbird.android.ThreadInfo r3 = new com.sendbird.android.ThreadInfo     // Catch:{ Exception -> 0x066f }
            r3.<init>()     // Catch:{ Exception -> 0x066f }
        L_0x00a6:
            r41 = r3
            java.lang.String r3 = "message_survival_seconds"
            boolean r3 = r0.has(r3)     // Catch:{ Exception -> 0x066f }
            if (r3 == 0) goto L_0x00bd
            java.lang.String r3 = "message_survival_seconds"
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r3)     // Catch:{ Exception -> 0x066f }
            int r3 = r3.getAsInt()     // Catch:{ Exception -> 0x066f }
            r39 = r3
            goto L_0x00c0
        L_0x00bd:
            r3 = -1
            r39 = -1
        L_0x00c0:
            r3 = -1
            int r6 = r2.hashCode()     // Catch:{ Exception -> 0x066f }
            r7 = 1
            switch(r6) {
                case 2004227: goto L_0x00e8;
                case 2047193: goto L_0x00de;
                case 2157948: goto L_0x00d4;
                case 2362860: goto L_0x00ca;
                default: goto L_0x00c9;
            }     // Catch:{ Exception -> 0x066f }
        L_0x00c9:
            goto L_0x00f1
        L_0x00ca:
            java.lang.String r6 = "MESG"
            boolean r6 = r2.equals(r6)     // Catch:{ Exception -> 0x066f }
            if (r6 == 0) goto L_0x00f1
            r3 = 0
            goto L_0x00f1
        L_0x00d4:
            java.lang.String r6 = "FILE"
            boolean r6 = r2.equals(r6)     // Catch:{ Exception -> 0x066f }
            if (r6 == 0) goto L_0x00f1
            r3 = 1
            goto L_0x00f1
        L_0x00de:
            java.lang.String r6 = "BRDM"
            boolean r6 = r2.equals(r6)     // Catch:{ Exception -> 0x066f }
            if (r6 == 0) goto L_0x00f1
            r3 = 2
            goto L_0x00f1
        L_0x00e8:
            java.lang.String r6 = "ADMM"
            boolean r6 = r2.equals(r6)     // Catch:{ Exception -> 0x066f }
            if (r6 == 0) goto L_0x00f1
            r3 = 3
        L_0x00f1:
            java.lang.String r6 = "force_update_last_message"
            java.lang.String r9 = "silent"
            java.lang.String r10 = "is_global_block"
            java.lang.String r11 = "sorted_metaarray"
            java.lang.String r12 = "metaarray_key_order"
            java.lang.String r14 = "metaarray"
            java.lang.String r15 = "reactions"
            java.lang.String r4 = "mentioned_users"
            java.lang.String r5 = "mention_type"
            java.lang.String r8 = "custom_type"
            java.lang.String r1 = "updated_at"
            if (r3 == 0) goto L_0x0478
            if (r3 == r7) goto L_0x0268
            r13 = 2
            if (r3 == r13) goto L_0x0123
            r13 = 3
            if (r3 == r13) goto L_0x0123
            java.lang.String r0 = "Unknown message type: "
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x066f }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ Exception -> 0x066f }
            com.sendbird.android.log.Logger.e((java.lang.String) r0)     // Catch:{ Exception -> 0x066f }
            goto L_0x0673
        L_0x0123:
            java.lang.String r2 = "message_id"
            com.sendbird.android.shadow.com.google.gson.JsonElement r2 = r0.get(r2)     // Catch:{ Exception -> 0x066f }
            long r2 = r2.getAsLong()     // Catch:{ Exception -> 0x066f }
            java.lang.String r13 = "message"
            com.sendbird.android.shadow.com.google.gson.JsonElement r13 = r0.get(r13)     // Catch:{ Exception -> 0x066f }
            java.lang.String r22 = r13.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r13 = "data"
            com.sendbird.android.shadow.com.google.gson.JsonElement r13 = r0.get(r13)     // Catch:{ Exception -> 0x066f }
            java.lang.String r23 = r13.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r13 = "created_at"
            com.sendbird.android.shadow.com.google.gson.JsonElement r13 = r0.get(r13)     // Catch:{ Exception -> 0x066f }
            long r25 = r13.getAsLong()     // Catch:{ Exception -> 0x066f }
            boolean r13 = r0.has(r1)     // Catch:{ Exception -> 0x066f }
            if (r13 == 0) goto L_0x015c
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r1)     // Catch:{ Exception -> 0x066f }
            long r20 = r1.getAsLong()     // Catch:{ Exception -> 0x066f }
            r27 = r20
            goto L_0x015e
        L_0x015c:
            r27 = 0
        L_0x015e:
            boolean r1 = r0.has(r8)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x016f
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r8)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x066f }
            r24 = r1
            goto L_0x0171
        L_0x016f:
            r24 = 0
        L_0x0171:
            com.sendbird.android.BaseMessageParams$MentionType r1 = com.sendbird.android.BaseMessageParams.MentionType.USERS     // Catch:{ Exception -> 0x066f }
            boolean r8 = r0.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r8 == 0) goto L_0x0199
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.getAsString()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0199
            java.lang.String r8 = "users"
            boolean r8 = r5.equals(r8)     // Catch:{ Exception -> 0x066f }
            if (r8 == 0) goto L_0x018f
            com.sendbird.android.BaseMessageParams$MentionType r1 = com.sendbird.android.BaseMessageParams.MentionType.USERS     // Catch:{ Exception -> 0x066f }
            goto L_0x0199
        L_0x018f:
            java.lang.String r8 = "channel"
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0199
            com.sendbird.android.BaseMessageParams$MentionType r1 = com.sendbird.android.BaseMessageParams.MentionType.CHANNEL     // Catch:{ Exception -> 0x066f }
        L_0x0199:
            r29 = r1
            boolean r1 = r0.has(r4)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x01ac
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r4)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x066f }
            r31 = r1
            goto L_0x01ae
        L_0x01ac:
            r31 = 0
        L_0x01ae:
            boolean r1 = r0.has(r15)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x01bf
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r15)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x066f }
            r32 = r1
            goto L_0x01c1
        L_0x01bf:
            r32 = 0
        L_0x01c1:
            boolean r1 = r0.has(r14)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x01d2
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r14)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x066f }
            r33 = r1
            goto L_0x01d4
        L_0x01d2:
            r33 = 0
        L_0x01d4:
            boolean r1 = r0.has(r12)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x01e5
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r12)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x066f }
            r34 = r1
            goto L_0x01e7
        L_0x01e5:
            r34 = 0
        L_0x01e7:
            boolean r1 = r0.has(r11)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x01f8
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r11)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x066f }
            r35 = r1
            goto L_0x01fa
        L_0x01f8:
            r35 = 0
        L_0x01fa:
            boolean r1 = r0.has(r10)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x020d
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r10)     // Catch:{ Exception -> 0x066f }
            boolean r1 = r1.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x020d
            r36 = 1
            goto L_0x020f
        L_0x020d:
            r36 = 0
        L_0x020f:
            boolean r1 = r0.has(r9)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x0222
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r9)     // Catch:{ Exception -> 0x066f }
            boolean r1 = r1.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x0222
            r37 = 1
            goto L_0x0224
        L_0x0222:
            r37 = 0
        L_0x0224:
            boolean r1 = r0.has(r6)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x0237
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r6)     // Catch:{ Exception -> 0x066f }
            boolean r1 = r1.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x0237
            r38 = 1
            goto L_0x0239
        L_0x0237:
            r38 = 0
        L_0x0239:
            java.lang.String r1 = "og_tag"
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r1)     // Catch:{ Exception -> 0x066f }
            boolean r1 = r1 instanceof com.sendbird.android.shadow.com.google.gson.JsonObject     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x0255
            com.sendbird.android.OGMetaData r1 = new com.sendbird.android.OGMetaData     // Catch:{ Exception -> 0x066f }
            java.lang.String r4 = "og_tag"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r0.get(r4)     // Catch:{ Exception -> 0x066f }
            com.sendbird.android.shadow.com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x066f }
            r1.<init>(r0)     // Catch:{ Exception -> 0x066f }
            r42 = r1
            goto L_0x0257
        L_0x0255:
            r42 = 0
        L_0x0257:
            com.sendbird.android.AdminMessage r0 = new com.sendbird.android.AdminMessage     // Catch:{ Exception -> 0x066f }
            r30 = 0
            r14 = r2
            r20 = r50
            r21 = r51
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = com.sendbird.android.AdminMessage.build(r14, r16, r18, r20, r21, r22, r23, r24, r25, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)     // Catch:{ Exception -> 0x066f }
            r0.<init>(r1)     // Catch:{ Exception -> 0x066f }
            return r0
        L_0x0268:
            java.lang.String r2 = "req_id"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x066f }
            if (r2 == 0) goto L_0x027b
            java.lang.String r2 = "req_id"
            com.sendbird.android.shadow.com.google.gson.JsonElement r2 = r0.get(r2)     // Catch:{ Exception -> 0x066f }
            java.lang.String r2 = r2.getAsString()     // Catch:{ Exception -> 0x066f }
            goto L_0x027d
        L_0x027b:
            java.lang.String r2 = ""
        L_0x027d:
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.SUCCEEDED     // Catch:{ Exception -> 0x066f }
            java.lang.String r7 = "request_state"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x0295
            java.lang.String r3 = "request_state"
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r3)     // Catch:{ Exception -> 0x066f }
            java.lang.String r3 = r3.getAsString()     // Catch:{ Exception -> 0x066f }
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.fromValue(r3)     // Catch:{ Exception -> 0x066f }
        L_0x0295:
            java.lang.String r7 = "message_id"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            long r23 = r7.getAsLong()     // Catch:{ Exception -> 0x066f }
            java.lang.String r7 = "file"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            com.sendbird.android.shadow.com.google.gson.JsonObject r7 = r7.getAsJsonObject()     // Catch:{ Exception -> 0x066f }
            r26 = r13
            java.lang.String r13 = "url"
            com.sendbird.android.shadow.com.google.gson.JsonElement r13 = r7.get(r13)     // Catch:{ Exception -> 0x066f }
            java.lang.String r25 = r13.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r13 = "name"
            com.sendbird.android.shadow.com.google.gson.JsonElement r13 = r7.get(r13)     // Catch:{ Exception -> 0x066f }
            java.lang.String r27 = r13.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r13 = "type"
            com.sendbird.android.shadow.com.google.gson.JsonElement r13 = r7.get(r13)     // Catch:{ Exception -> 0x066f }
            java.lang.String r28 = r13.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r13 = "size"
            com.sendbird.android.shadow.com.google.gson.JsonElement r13 = r7.get(r13)     // Catch:{ Exception -> 0x066f }
            int r30 = r13.getAsInt()     // Catch:{ Exception -> 0x066f }
            java.lang.String r13 = "data"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r7.get(r13)     // Catch:{ Exception -> 0x066f }
            java.lang.String r31 = r7.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r7 = "created_at"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            long r32 = r7.getAsLong()     // Catch:{ Exception -> 0x066f }
            boolean r7 = r0.has(r1)     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x02fb
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r1)     // Catch:{ Exception -> 0x066f }
            long r20 = r1.getAsLong()     // Catch:{ Exception -> 0x066f }
            r34 = r20
            goto L_0x02fd
        L_0x02fb:
            r34 = 0
        L_0x02fd:
            boolean r1 = r0.has(r8)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x030e
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r8)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x066f }
            r21 = r1
            goto L_0x0310
        L_0x030e:
            r21 = 0
        L_0x0310:
            java.lang.String r1 = "thumbnails"
            boolean r1 = r0.has(r1)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x0325
            java.lang.String r1 = "thumbnails"
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r1)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x066f }
            goto L_0x0326
        L_0x0325:
            r1 = 0
        L_0x0326:
            java.lang.String r7 = "require_auth"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x033d
            java.lang.String r7 = "require_auth"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            boolean r7 = r7.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x033d
            r36 = 1
            goto L_0x033f
        L_0x033d:
            r36 = 0
        L_0x033f:
            com.sendbird.android.BaseMessageParams$MentionType r7 = com.sendbird.android.BaseMessageParams.MentionType.USERS     // Catch:{ Exception -> 0x066f }
            boolean r8 = r0.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r8 == 0) goto L_0x036a
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.getAsString()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x036a
            java.lang.String r8 = "users"
            boolean r8 = r5.equals(r8)     // Catch:{ Exception -> 0x066f }
            if (r8 == 0) goto L_0x035f
            com.sendbird.android.BaseMessageParams$MentionType r5 = com.sendbird.android.BaseMessageParams.MentionType.USERS     // Catch:{ Exception -> 0x066f }
        L_0x035c:
            r37 = r5
            goto L_0x036c
        L_0x035f:
            java.lang.String r8 = "channel"
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x036a
            com.sendbird.android.BaseMessageParams$MentionType r5 = com.sendbird.android.BaseMessageParams.MentionType.CHANNEL     // Catch:{ Exception -> 0x066f }
            goto L_0x035c
        L_0x036a:
            r37 = r7
        L_0x036c:
            boolean r5 = r0.has(r4)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x037b
            com.sendbird.android.shadow.com.google.gson.JsonElement r4 = r0.get(r4)     // Catch:{ Exception -> 0x066f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x066f }
            goto L_0x037c
        L_0x037b:
            r4 = 0
        L_0x037c:
            boolean r5 = r0.has(r15)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x038d
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r15)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r38 = r5
            goto L_0x038f
        L_0x038d:
            r38 = 0
        L_0x038f:
            boolean r5 = r0.has(r14)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x03a0
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r14)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r42 = r5
            goto L_0x03a2
        L_0x03a0:
            r42 = 0
        L_0x03a2:
            boolean r5 = r0.has(r12)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x03b3
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r12)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r43 = r5
            goto L_0x03b5
        L_0x03b3:
            r43 = 0
        L_0x03b5:
            boolean r5 = r0.has(r11)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x03c6
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r11)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r44 = r5
            goto L_0x03c8
        L_0x03c6:
            r44 = 0
        L_0x03c8:
            boolean r5 = r0.has(r10)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x03db
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r10)     // Catch:{ Exception -> 0x066f }
            boolean r5 = r5.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x03db
            r45 = 1
            goto L_0x03dd
        L_0x03db:
            r45 = 0
        L_0x03dd:
            java.lang.String r5 = "error_code"
            boolean r5 = r0.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x03f2
            java.lang.String r5 = "error_code"
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            int r5 = r5.getAsInt()     // Catch:{ Exception -> 0x066f }
            r46 = r5
            goto L_0x03f4
        L_0x03f2:
            r46 = 0
        L_0x03f4:
            boolean r5 = r0.has(r9)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0407
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r9)     // Catch:{ Exception -> 0x066f }
            boolean r5 = r5.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0407
            r47 = 1
            goto L_0x0409
        L_0x0407:
            r47 = 0
        L_0x0409:
            boolean r5 = r0.has(r6)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x041c
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r6)     // Catch:{ Exception -> 0x066f }
            boolean r5 = r5.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x041c
            r48 = 1
            goto L_0x041e
        L_0x041c:
            r48 = 0
        L_0x041e:
            java.lang.String r5 = "is_op_msg"
            boolean r5 = r0.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0434
            java.lang.String r5 = "is_op_msg"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r0 == 0) goto L_0x0434
            r0 = 1
            goto L_0x0435
        L_0x0434:
            r0 = 0
        L_0x0435:
            com.sendbird.android.FileMessage r15 = new com.sendbird.android.FileMessage     // Catch:{ Exception -> 0x066f }
            r29 = 0
            r5 = r2
            r6 = r3
            r7 = r23
            r9 = r16
            r11 = r18
            r13 = r26
            r14 = r50
            r2 = r15
            r15 = r51
            r16 = r25
            r17 = r27
            r18 = r28
            r19 = r30
            r20 = r31
            r22 = r1
            r23 = r36
            r24 = r32
            r26 = r34
            r28 = r37
            r30 = r4
            r31 = r38
            r32 = r42
            r33 = r43
            r34 = r44
            r35 = r45
            r36 = r46
            r37 = r47
            r38 = r48
            r42 = r0
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = com.sendbird.android.FileMessage.build(r5, r6, r7, r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)     // Catch:{ Exception -> 0x066f }
            r2.<init>(r0)     // Catch:{ Exception -> 0x066f }
            return r2
        L_0x0478:
            r26 = r13
            java.lang.String r2 = "req_id"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x066f }
            if (r2 == 0) goto L_0x048d
            java.lang.String r2 = "req_id"
            com.sendbird.android.shadow.com.google.gson.JsonElement r2 = r0.get(r2)     // Catch:{ Exception -> 0x066f }
            java.lang.String r2 = r2.getAsString()     // Catch:{ Exception -> 0x066f }
            goto L_0x048f
        L_0x048d:
            java.lang.String r2 = ""
        L_0x048f:
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.SUCCEEDED     // Catch:{ Exception -> 0x066f }
            java.lang.String r7 = "request_state"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x04a7
            java.lang.String r3 = "request_state"
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r3)     // Catch:{ Exception -> 0x066f }
            java.lang.String r3 = r3.getAsString()     // Catch:{ Exception -> 0x066f }
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.fromValue(r3)     // Catch:{ Exception -> 0x066f }
        L_0x04a7:
            java.lang.String r7 = "message_id"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x04ba
            java.lang.String r7 = "message_id"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            long r23 = r7.getAsLong()     // Catch:{ Exception -> 0x066f }
            goto L_0x04bc
        L_0x04ba:
            r23 = 0
        L_0x04bc:
            java.lang.String r7 = "message"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            java.lang.String r27 = r7.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r7 = "data"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            java.lang.String r28 = r7.getAsString()     // Catch:{ Exception -> 0x066f }
            java.lang.String r7 = "created_at"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            long r29 = r7.getAsLong()     // Catch:{ Exception -> 0x066f }
            boolean r7 = r0.has(r1)     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x04eb
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r1)     // Catch:{ Exception -> 0x066f }
            long r20 = r1.getAsLong()     // Catch:{ Exception -> 0x066f }
            r31 = r20
            goto L_0x04ed
        L_0x04eb:
            r31 = 0
        L_0x04ed:
            boolean r1 = r0.has(r8)     // Catch:{ Exception -> 0x066f }
            if (r1 == 0) goto L_0x04fc
            com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r0.get(r8)     // Catch:{ Exception -> 0x066f }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x066f }
            goto L_0x04fd
        L_0x04fc:
            r1 = 0
        L_0x04fd:
            java.lang.String r7 = "translations"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x066f }
            if (r7 == 0) goto L_0x0514
            java.lang.String r7 = "translations"
            com.sendbird.android.shadow.com.google.gson.JsonElement r7 = r0.get(r7)     // Catch:{ Exception -> 0x066f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x066f }
            r20 = r7
            goto L_0x0516
        L_0x0514:
            r20 = 0
        L_0x0516:
            com.sendbird.android.BaseMessageParams$MentionType r7 = com.sendbird.android.BaseMessageParams.MentionType.USERS     // Catch:{ Exception -> 0x066f }
            boolean r8 = r0.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r8 == 0) goto L_0x0541
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.getAsString()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0541
            java.lang.String r8 = "users"
            boolean r8 = r5.equals(r8)     // Catch:{ Exception -> 0x066f }
            if (r8 == 0) goto L_0x0536
            com.sendbird.android.BaseMessageParams$MentionType r5 = com.sendbird.android.BaseMessageParams.MentionType.USERS     // Catch:{ Exception -> 0x066f }
        L_0x0533:
            r33 = r5
            goto L_0x0543
        L_0x0536:
            java.lang.String r8 = "channel"
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0541
            com.sendbird.android.BaseMessageParams$MentionType r5 = com.sendbird.android.BaseMessageParams.MentionType.CHANNEL     // Catch:{ Exception -> 0x066f }
            goto L_0x0533
        L_0x0541:
            r33 = r7
        L_0x0543:
            boolean r5 = r0.has(r4)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0552
            com.sendbird.android.shadow.com.google.gson.JsonElement r4 = r0.get(r4)     // Catch:{ Exception -> 0x066f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x066f }
            goto L_0x0553
        L_0x0552:
            r4 = 0
        L_0x0553:
            boolean r5 = r0.has(r15)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0564
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r15)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r34 = r5
            goto L_0x0566
        L_0x0564:
            r34 = 0
        L_0x0566:
            boolean r5 = r0.has(r14)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0577
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r14)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r35 = r5
            goto L_0x0579
        L_0x0577:
            r35 = 0
        L_0x0579:
            boolean r5 = r0.has(r12)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x058a
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r12)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r36 = r5
            goto L_0x058c
        L_0x058a:
            r36 = 0
        L_0x058c:
            boolean r5 = r0.has(r11)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x059d
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r11)     // Catch:{ Exception -> 0x066f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x066f }
            r37 = r5
            goto L_0x059f
        L_0x059d:
            r37 = 0
        L_0x059f:
            boolean r5 = r0.has(r10)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x05b2
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r10)     // Catch:{ Exception -> 0x066f }
            boolean r5 = r5.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x05b2
            r38 = 1
            goto L_0x05b4
        L_0x05b2:
            r38 = 0
        L_0x05b4:
            java.lang.String r5 = "error_code"
            boolean r5 = r0.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x05c9
            java.lang.String r5 = "error_code"
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            int r5 = r5.getAsInt()     // Catch:{ Exception -> 0x066f }
            r42 = r5
            goto L_0x05cb
        L_0x05c9:
            r42 = 0
        L_0x05cb:
            boolean r5 = r0.has(r9)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x05de
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r9)     // Catch:{ Exception -> 0x066f }
            boolean r5 = r5.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x05de
            r43 = 1
            goto L_0x05e0
        L_0x05de:
            r43 = 0
        L_0x05e0:
            boolean r5 = r0.has(r6)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x05f3
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r6)     // Catch:{ Exception -> 0x066f }
            boolean r5 = r5.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x05f3
            r44 = 1
            goto L_0x05f5
        L_0x05f3:
            r44 = 0
        L_0x05f5:
            java.lang.String r5 = "og_tag"
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            boolean r5 = r5 instanceof com.sendbird.android.shadow.com.google.gson.JsonObject     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0611
            com.sendbird.android.OGMetaData r5 = new com.sendbird.android.OGMetaData     // Catch:{ Exception -> 0x066f }
            java.lang.String r6 = "og_tag"
            com.sendbird.android.shadow.com.google.gson.JsonElement r6 = r0.get(r6)     // Catch:{ Exception -> 0x066f }
            com.sendbird.android.shadow.com.google.gson.JsonObject r6 = r6.getAsJsonObject()     // Catch:{ Exception -> 0x066f }
            r5.<init>(r6)     // Catch:{ Exception -> 0x066f }
            r45 = r5
            goto L_0x0613
        L_0x0611:
            r45 = 0
        L_0x0613:
            java.lang.String r5 = "is_op_msg"
            boolean r5 = r0.has(r5)     // Catch:{ Exception -> 0x066f }
            if (r5 == 0) goto L_0x0629
            java.lang.String r5 = "is_op_msg"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r0.get(r5)     // Catch:{ Exception -> 0x066f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ Exception -> 0x066f }
            if (r0 == 0) goto L_0x0629
            r0 = 1
            goto L_0x062a
        L_0x0629:
            r0 = 0
        L_0x062a:
            com.sendbird.android.UserMessage r15 = new com.sendbird.android.UserMessage     // Catch:{ Exception -> 0x066f }
            r25 = 0
            r5 = r2
            r6 = r3
            r7 = r23
            r9 = r16
            r11 = r18
            r13 = r26
            r14 = r50
            r2 = r15
            r15 = r51
            r16 = r27
            r17 = r28
            r18 = r1
            r19 = r20
            r20 = r29
            r22 = r31
            r24 = r33
            r26 = r4
            r27 = r34
            r28 = r35
            r29 = r36
            r30 = r37
            r31 = r38
            r32 = r42
            r33 = r43
            r34 = r44
            r35 = r39
            r36 = r40
            r37 = r41
            r38 = r45
            r39 = r0
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = com.sendbird.android.UserMessage.build(r5, r6, r7, r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)     // Catch:{ Exception -> 0x066f }
            r2.<init>(r0)     // Catch:{ Exception -> 0x066f }
            return r2
        L_0x066f:
            r0 = move-exception
            com.sendbird.android.log.Logger.e((java.lang.Throwable) r0)
        L_0x0673:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.BaseMessage.build(com.sendbird.android.shadow.com.google.gson.JsonElement, java.lang.String, java.lang.String):com.sendbird.android.BaseMessage");
    }

    public BaseMessage(String str, long j, long j2) {
        this.mData = "";
        this.mCustomType = "";
        this.mMentionType = BaseMessageParams.MentionType.USERS;
        this.mErrorCode = 0;
        this.mIsSilent = false;
        this.forceUpdateLastMessage = false;
        this.reactionList = new ArrayList();
        this.sendingStatus = SendingStatus.NONE;
        this.mChannelUrl = str;
        this.mMessageId = j;
        this.mCreatedAt = j2;
    }

    protected BaseMessage(JsonElement jsonElement) {
        String str = "";
        this.mData = str;
        this.mCustomType = str;
        this.mMentionType = BaseMessageParams.MentionType.USERS;
        boolean z = false;
        this.mErrorCode = 0;
        this.mIsSilent = false;
        this.forceUpdateLastMessage = false;
        this.reactionList = new ArrayList();
        this.sendingStatus = SendingStatus.NONE;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.mMessageId = asJsonObject.has(StringSet.msg_id) ? asJsonObject.get(StringSet.msg_id).getAsLong() : 0;
        this.rootMessageId = asJsonObject.has(StringSet.root_message_id) ? asJsonObject.get(StringSet.root_message_id).getAsLong() : 0;
        this.parentMessageId = asJsonObject.has(StringSet.parent_message_id) ? asJsonObject.get(StringSet.parent_message_id).getAsLong() : 0;
        this.mChannelUrl = asJsonObject.has(StringSet.channel_url) ? asJsonObject.get(StringSet.channel_url).getAsString() : str;
        this.mChannelType = asJsonObject.has(StringSet.channel_type) ? asJsonObject.get(StringSet.channel_type).getAsString() : BaseChannel.ChannelType.GROUP.value();
        this.mCreatedAt = asJsonObject.has(StringSet.ts) ? asJsonObject.get(StringSet.ts).getAsLong() : 0;
        this.mUpdatedAt = asJsonObject.has(StringSet.updated_at) ? asJsonObject.get(StringSet.updated_at).getAsLong() : 0;
        if (asJsonObject.has(StringSet.mention_type)) {
            String asString = asJsonObject.get(StringSet.mention_type).getAsString();
            if (asString.equals(StringSet.users)) {
                this.mMentionType = BaseMessageParams.MentionType.USERS;
            } else if (asString.equals("channel")) {
                this.mMentionType = BaseMessageParams.MentionType.CHANNEL;
            }
        }
        this.mMentionedUserIds = new ArrayList();
        if (asJsonObject.has(StringSet.mentioned_user_ids)) {
            JsonArray asJsonArray = asJsonObject.getAsJsonArray(StringSet.mentioned_user_ids);
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                if (asJsonArray.get(i2) != null) {
                    this.mMentionedUserIds.add(asJsonArray.get(i2).getAsString());
                }
            }
        }
        this.mMentionedUsers = new ArrayList();
        if (asJsonObject.has("mentioned_users")) {
            JsonArray asJsonArray2 = asJsonObject.getAsJsonArray("mentioned_users");
            for (int i3 = 0; i3 < asJsonArray2.size(); i3++) {
                this.mMentionedUsers.add(new User(asJsonArray2.get(i3)));
            }
        }
        if (asJsonObject.has("reactions")) {
            JsonArray asJsonArray3 = asJsonObject.getAsJsonArray("reactions");
            for (int i4 = 0; i4 < asJsonArray3.size(); i4++) {
                Reaction reaction = new Reaction(asJsonArray3.get(i4));
                if (reaction.getUserIds().size() > 0) {
                    addReaction(reaction);
                }
            }
        }
        this.mMetaArrays = new ArrayList();
        OGMetaData oGMetaData = null;
        if (asJsonObject.has("metaarray")) {
            HashMap hashMap = new HashMap();
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("metaarray");
            for (String next : asJsonObject2.keySet()) {
                if (next != null) {
                    ArrayList arrayList = new ArrayList();
                    JsonArray asJsonArray4 = asJsonObject2.get(next).getAsJsonArray();
                    for (int i5 = 0; i5 < asJsonArray4.size(); i5++) {
                        arrayList.add(asJsonArray4.get(i5).getAsString());
                    }
                    hashMap.put(next, new MessageMetaArray(next, arrayList));
                }
            }
            if (asJsonObject.has("metaarray_key_order")) {
                JsonArray asJsonArray5 = asJsonObject.getAsJsonArray("metaarray_key_order");
                for (int i6 = 0; i6 < asJsonArray5.size(); i6++) {
                    String asString2 = asJsonArray5.get(i6).getAsString();
                    if (hashMap.containsKey(asString2)) {
                        this.mMetaArrays.add(hashMap.get(asString2));
                    }
                }
            } else {
                this.mMetaArrays.addAll(hashMap.values());
            }
        } else if (asJsonObject.has("sorted_metaarray")) {
            JsonArray asJsonArray6 = asJsonObject.get("sorted_metaarray").getAsJsonArray();
            for (int i7 = 0; i7 < asJsonArray6.size(); i7++) {
                JsonObject asJsonObject3 = asJsonArray6.get(i7).getAsJsonObject();
                String asString3 = asJsonObject3.has("key") ? asJsonObject3.get("key").getAsString() : null;
                JsonArray asJsonArray7 = asJsonObject3.has("value") ? asJsonObject3.get("value").getAsJsonArray() : null;
                if (asString3 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    if (asJsonArray7 != null) {
                        for (int i8 = 0; i8 < asJsonArray7.size(); i8++) {
                            arrayList2.add(asJsonArray7.get(i8).getAsString());
                        }
                    }
                    this.mMetaArrays.add(new MessageMetaArray(asString3, arrayList2));
                }
            }
        }
        this.mIsGlobalBlocked = asJsonObject.has("is_global_block") && asJsonObject.get("is_global_block").getAsBoolean();
        this.mIsSilent = asJsonObject.has("silent") && asJsonObject.get("silent").getAsBoolean();
        this.forceUpdateLastMessage = asJsonObject.has("force_update_last_message") && asJsonObject.get("force_update_last_message").getAsBoolean();
        if (asJsonObject.has("request_state")) {
            this.sendingStatus = SendingStatus.fromValue(asJsonObject.get("request_state").getAsString());
        }
        if (this.sendingStatus == SendingStatus.NONE && this.mMessageId > 0) {
            this.sendingStatus = SendingStatus.SUCCEEDED;
        }
        this.messageSurvivalSeconds = asJsonObject.has(StringSet.message_survival_seconds) ? asJsonObject.get(StringSet.message_survival_seconds).getAsInt() : -1;
        this.parentMessageText = asJsonObject.has(StringSet.parent_message_text) ? asJsonObject.get(StringSet.parent_message_text).getAsString() : null;
        if (asJsonObject.has(StringSet.thread_info)) {
            this.threadInfo = new ThreadInfo(asJsonObject.get(StringSet.thread_info));
        } else {
            this.threadInfo = new ThreadInfo();
        }
        JsonElement jsonElement2 = asJsonObject.get(StringSet.user);
        JsonObject asJsonObject4 = (jsonElement2 == null || jsonElement2.isJsonNull()) ? null : jsonElement2.getAsJsonObject();
        if (asJsonObject4 != null) {
            this.mSender = (asJsonObject4.has("user_id") || jsonElement2.getAsJsonObject().has(StringSet.guest_id)) ? new Sender(jsonElement2) : null;
        }
        this.ogMetaData = asJsonObject.get(StringSet.og_tag) instanceof JsonObject ? new OGMetaData(asJsonObject.get(StringSet.og_tag).getAsJsonObject()) : oGMetaData;
        if (asJsonObject.has(StringSet.is_op_msg) && asJsonObject.get(StringSet.is_op_msg).getAsBoolean()) {
            z = true;
        }
        this.isOperatorMessage = z;
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.message_id, (Number) Long.valueOf(this.mMessageId));
        jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(this.rootMessageId));
        jsonObject.addProperty(StringSet.parent_message_id, (Number) Long.valueOf(this.parentMessageId));
        jsonObject.addProperty(StringSet.channel_url, this.mChannelUrl);
        jsonObject.addProperty(StringSet.channel_type, this.mChannelType);
        jsonObject.addProperty("created_at", (Number) Long.valueOf(this.mCreatedAt));
        jsonObject.addProperty(StringSet.updated_at, (Number) Long.valueOf(this.mUpdatedAt));
        if (this.mMentionType == BaseMessageParams.MentionType.USERS) {
            jsonObject.addProperty(StringSet.mention_type, StringSet.users);
        } else if (this.mMentionType == BaseMessageParams.MentionType.CHANNEL) {
            jsonObject.addProperty(StringSet.mention_type, "channel");
        }
        List<String> list = this.mMentionedUserIds;
        if (list != null && list.size() > 0) {
            JsonArray jsonArray = new JsonArray();
            for (String next : this.mMentionedUserIds) {
                if (next != null) {
                    jsonArray.add(next);
                }
            }
            jsonObject.add(StringSet.mentioned_user_ids, jsonArray);
        }
        List<User> list2 = this.mMentionedUsers;
        if (list2 != null && list2.size() > 0) {
            JsonArray jsonArray2 = new JsonArray();
            for (User next2 : this.mMentionedUsers) {
                if (next2 != null) {
                    jsonArray2.add(next2.toJson());
                }
            }
            jsonObject.add("mentioned_users", jsonArray2);
        }
        if (this.reactionList.size() > 0) {
            JsonArray jsonArray3 = new JsonArray();
            synchronized (this.reactionList) {
                for (Reaction next3 : this.reactionList) {
                    if (next3 != null) {
                        jsonArray3.add(next3.toJson());
                    }
                }
            }
            jsonObject.add("reactions", jsonArray3);
        }
        List<MessageMetaArray> list3 = this.mMetaArrays;
        if (list3 != null && list3.size() > 0) {
            JsonArray jsonArray4 = new JsonArray();
            for (MessageMetaArray json : this.mMetaArrays) {
                jsonArray4.add((JsonElement) json.toJson());
            }
            jsonObject.add("sorted_metaarray", jsonArray4);
        }
        jsonObject.addProperty("is_global_block", Boolean.valueOf(this.mIsGlobalBlocked));
        jsonObject.addProperty("silent", Boolean.valueOf(this.mIsSilent));
        jsonObject.addProperty("force_update_last_message", Boolean.valueOf(this.forceUpdateLastMessage));
        jsonObject.addProperty("request_state", this.sendingStatus.getValue());
        jsonObject.addProperty(StringSet.message_survival_seconds, (Number) Integer.valueOf(this.messageSurvivalSeconds));
        String str = this.parentMessageText;
        if (str != null) {
            jsonObject.addProperty(StringSet.parent_message_text, str);
        }
        jsonObject.add(StringSet.thread_info, this.threadInfo.toJson());
        Sender sender = this.mSender;
        jsonObject.add(StringSet.user, sender != null ? sender.toJson() : null);
        OGMetaData oGMetaData = this.ogMetaData;
        if (oGMetaData != null) {
            jsonObject.add(StringSet.og_tag, oGMetaData.toJson());
        }
        jsonObject.addProperty(StringSet.is_op_msg, Boolean.valueOf(this.isOperatorMessage));
        return jsonObject;
    }

    public static BaseMessage buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            JsonObject asJsonObject = new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)).getAsJsonObject();
            return build(asJsonObject, asJsonObject.get(StringSet.channel_url).getAsString(), asJsonObject.get(StringSet.channel_type).getAsString());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static BaseMessage buildFromSerializedData(byte[] bArr, SendingStatus sendingStatus2) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            JsonObject asJsonObject = new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)).getAsJsonObject();
            BaseMessage build = build(asJsonObject, asJsonObject.get(StringSet.channel_url).getAsString(), asJsonObject.get(StringSet.channel_type).getAsString());
            if (build == null) {
                Logger.e("msg is null");
                return null;
            }
            SendingStatus sendingStatus3 = build.getSendingStatus();
            build.setSendingStatus(sendingStatus2);
            if (SendingStatus.PENDING != sendingStatus2) {
                if (SendingStatus.SUCCEEDED != sendingStatus2) {
                    if (SendingStatus.FAILED == sendingStatus2 && SendingStatus.PENDING == sendingStatus3) {
                        build.setErrorCode(SendBirdError.ERR_PENDING);
                    }
                    return build;
                }
            }
            build.setErrorCode(0);
            return build;
        } catch (UnsupportedEncodingException e2) {
            Logger.e((Throwable) e2);
            return null;
        }
    }

    public byte[] serialize() {
        JsonObject asJsonObject = toJson().getAsJsonObject();
        asJsonObject.addProperty("version", SendBird.getSDKVersion());
        try {
            byte[] encode = Base64.encode(asJsonObject.toString().getBytes(AppConstants.UTF_8), 0);
            for (int i2 = 0; i2 < encode.length; i2++) {
                encode[i2] = (byte) (encode[i2] ^ (i2 & 255));
            }
            return encode;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public long getMessageId() {
        return this.mMessageId;
    }

    /* access modifiers changed from: package-private */
    public long getRootMessageId() {
        return this.rootMessageId;
    }

    public long getParentMessageId() {
        return this.parentMessageId;
    }

    public long getCreatedAt() {
        return this.mCreatedAt;
    }

    public long getUpdatedAt() {
        return this.mUpdatedAt;
    }

    public BaseMessageParams.MentionType getMentionType() {
        return this.mMentionType;
    }

    public List<User> getMentionedUsers() {
        return this.mMentionedUsers;
    }

    /* access modifiers changed from: package-private */
    public List<String> getMentionedUserIds() {
        List<String> list;
        if (this.sendingStatus != SendingStatus.SUCCEEDED && (list = this.mMentionedUserIds) != null && list.size() > 0) {
            return new ArrayList(this.mMentionedUserIds);
        }
        List<User> list2 = this.mMentionedUsers;
        if (list2 == null || list2.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (User next : this.mMentionedUsers) {
            if (!(next == null || next.getUserId() == null || next.getUserId().length() <= 0)) {
                arrayList.add(next.getUserId());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean isMentionedFromSomeoneToMe() {
        List<User> list;
        String userId = SendBird.getCurrentUser() != null ? SendBird.getCurrentUser().getUserId() : null;
        if (!belongsTo(this, SendBird.getCurrentUser())) {
            if (this.mMentionType == BaseMessageParams.MentionType.CHANNEL) {
                return true;
            }
            if (userId != null && userId.length() > 0 && (list = this.mMentionedUsers) != null && list.size() > 0) {
                for (User userId2 : this.mMentionedUsers) {
                    if (userId2.getUserId().equals(userId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getChannelUrl() {
        return this.mChannelUrl;
    }

    public boolean isOpenChannel() {
        return this.mChannelType.equals(BaseChannel.ChannelType.OPEN.value());
    }

    public boolean isGroupChannel() {
        return this.mChannelType.equals(BaseChannel.ChannelType.GROUP.value());
    }

    public String getData() {
        return this.mData;
    }

    public String getCustomType() {
        return this.mCustomType;
    }

    public List<Reaction> getReactions() {
        return Collections.unmodifiableList(this.reactionList);
    }

    public Map<String, List<String>> getAllMetaArray() {
        HashMap hashMap = new HashMap();
        for (MessageMetaArray next : this.mMetaArrays) {
            hashMap.put(next.getKey(), next.getValue());
        }
        return hashMap;
    }

    public List<MessageMetaArray> getAllMetaArrays() {
        return new ArrayList(this.mMetaArrays);
    }

    public Map<String, List<String>> getMetaArray(Collection<String> collection) {
        HashMap hashMap = new HashMap();
        for (MessageMetaArray next : getMetaArrays(collection)) {
            hashMap.put(next.getKey(), next.getValue());
        }
        return hashMap;
    }

    public List<MessageMetaArray> getMetaArrays(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        if (!(this.mMetaArrays == null || collection == null || collection.size() <= 0)) {
            for (String metaArrayByKey : collection) {
                MessageMetaArray metaArrayByKey2 = getMetaArrayByKey(metaArrayByKey);
                if (metaArrayByKey2 != null) {
                    arrayList.add(metaArrayByKey2);
                }
            }
        }
        return arrayList;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    /* access modifiers changed from: package-private */
    public void setErrorCode(int i2) {
        this.mErrorCode = i2;
    }

    public int getMessageSurvivalSeconds() {
        return this.messageSurvivalSeconds;
    }

    private void addReaction(Reaction reaction) {
        synchronized (this.reactionList) {
            this.reactionList.add(reaction);
        }
    }

    private void removeReaction(Reaction reaction) {
        synchronized (this.reactionList) {
            this.reactionList.remove(reaction);
        }
    }

    private Reaction getReaction(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.reactionList) {
            for (Reaction next : this.reactionList) {
                if (str.equals(next.getKey())) {
                    return next;
                }
            }
            return null;
        }
    }

    public boolean applyReactionEvent(ReactionEvent reactionEvent) {
        if (reactionEvent == null || this.mMessageId != reactionEvent.getMessageId()) {
            return false;
        }
        Reaction reaction = getReaction(reactionEvent.getKey());
        if (reaction != null) {
            if (!reaction.merge(reactionEvent)) {
                return false;
            }
            if (reactionEvent.getOperation() == ReactionEvent.ReactionEventAction.DELETE && reaction.getUserIds().size() == 0) {
                removeReaction(reaction);
            }
            return true;
        } else if (reactionEvent.getOperation() != ReactionEvent.ReactionEventAction.ADD) {
            return false;
        } else {
            addReaction(new Reaction(reactionEvent));
            return true;
        }
    }

    public boolean applyThreadInfoUpdateEvent(ThreadInfoUpdateEvent threadInfoUpdateEvent) {
        if (threadInfoUpdateEvent == null || threadInfoUpdateEvent.getTargetMessageId() != this.mMessageId) {
            return false;
        }
        if (threadInfoUpdateEvent.getThreadInfo() != null) {
            return this.threadInfo.merge(threadInfoUpdateEvent.getThreadInfo());
        }
        this.threadInfo = new ThreadInfo();
        return true;
    }

    public void getThreadedMessagesByTimestamp(long j, ThreadMessageListParams threadMessageListParams, GetThreadedMessagesHandler getThreadedMessagesHandler) {
        final ThreadMessageListParams threadMessageListParams2 = threadMessageListParams;
        final long j2 = j;
        final GetThreadedMessagesHandler getThreadedMessagesHandler2 = getThreadedMessagesHandler;
        d.a(new q<Pair<BaseMessage, List<BaseMessage>>>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.List} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ void a(java.lang.Object r3, com.sendbird.android.SendBirdException r4) {
                /*
                    r2 = this;
                    android.util.Pair r3 = (android.util.Pair) r3
                    com.sendbird.android.BaseMessage$GetThreadedMessagesHandler r0 = r5
                    if (r0 == 0) goto L_0x001c
                    r0 = 0
                    if (r3 != 0) goto L_0x000b
                    r1 = r0
                    goto L_0x000f
                L_0x000b:
                    java.lang.Object r1 = r3.first
                    com.sendbird.android.BaseMessage r1 = (com.sendbird.android.BaseMessage) r1
                L_0x000f:
                    if (r3 != 0) goto L_0x0012
                    goto L_0x0017
                L_0x0012:
                    java.lang.Object r3 = r3.second
                    r0 = r3
                    java.util.List r0 = (java.util.List) r0
                L_0x0017:
                    com.sendbird.android.BaseMessage$GetThreadedMessagesHandler r3 = r5
                    r3.onResult(r1, r0, r4)
                L_0x001c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.BaseMessage.AnonymousClass2.a(java.lang.Object, com.sendbird.android.SendBirdException):void");
            }

            public final /* synthetic */ Object call() throws Exception {
                ThreadMessageListParams threadMessageListParams = threadMessageListParams2;
                if (threadMessageListParams != null) {
                    LinkedHashSet linkedHashSet = null;
                    String value = (threadMessageListParams.messageType == null || threadMessageListParams2.messageType == BaseChannel.MessageTypeFilter.ALL) ? null : threadMessageListParams2.messageType.value();
                    if (threadMessageListParams2.senderUserIds != null) {
                        linkedHashSet = new LinkedHashSet(threadMessageListParams2.senderUserIds);
                    }
                    JsonArray asJsonArray = APIClient.a().a(BaseMessage.this.isOpenChannel(), BaseMessage.this.mChannelUrl, BaseMessage.this.mMessageId, j2, threadMessageListParams2.previousResultSize, threadMessageListParams2.nextResultSize, threadMessageListParams2.isInclusive, threadMessageListParams2.reverse, value, threadMessageListParams2.customType, linkedHashSet, threadMessageListParams2.includeMetaArray, threadMessageListParams2.includeReactions, true, true, threadMessageListParams2.includeParentMessageText, false).getAsJsonObject().get(StringSet.messages).getAsJsonArray();
                    ArrayList arrayList = new ArrayList();
                    BaseMessage build = BaseMessage.build(asJsonArray.get(0), BaseMessage.this.mChannelUrl, (BaseMessage.this.isOpenChannel() ? BaseChannel.ChannelType.OPEN : BaseChannel.ChannelType.GROUP).value());
                    for (int i2 = 1; i2 < asJsonArray.size(); i2++) {
                        BaseMessage build2 = BaseMessage.build(asJsonArray.get(i2), BaseMessage.this.mChannelUrl, (BaseMessage.this.isOpenChannel() ? BaseChannel.ChannelType.OPEN : BaseChannel.ChannelType.GROUP).value());
                        if (build2 != null) {
                            arrayList.add(build2);
                        }
                    }
                    return new Pair(build, arrayList);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public String getParentMessageText() {
        return this.parentMessageText;
    }

    /* access modifiers changed from: package-private */
    public MessageMetaArray getMetaArrayByKey(String str) {
        if (str == null) {
            return null;
        }
        for (MessageMetaArray next : this.mMetaArrays) {
            if (str.equals(next.getKey())) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void addMetaArray(String str) {
        addMetaArray(str, new ArrayList());
    }

    /* access modifiers changed from: package-private */
    public void addMetaArray(String str, List<String> list) {
        if (str != null) {
            for (MessageMetaArray key : this.mMetaArrays) {
                if (str.equals(key.getKey())) {
                    return;
                }
            }
            this.mMetaArrays.add(new MessageMetaArray(str, list));
        }
    }

    /* access modifiers changed from: package-private */
    public void setMetaArray(String str, List<String> list) {
        if (str != null) {
            for (MessageMetaArray next : this.mMetaArrays) {
                if (str.equals(next.getKey())) {
                    next.setValue(list);
                    return;
                }
            }
            this.mMetaArrays.add(new MessageMetaArray(str, list));
        }
    }

    /* access modifiers changed from: package-private */
    public void removeMetaArrayByKey(String str) {
        if (str != null) {
            for (int i2 = 0; i2 < this.mMetaArrays.size(); i2++) {
                if (str.equals(this.mMetaArrays.get(i2).getKey())) {
                    this.mMetaArrays.remove(i2);
                    return;
                }
            }
        }
    }

    public boolean isSilent() {
        return this.mIsSilent;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldForceUpdateLastMessage() {
        return this.forceUpdateLastMessage;
    }

    public OGMetaData getOgMetaData() {
        return this.ogMetaData;
    }

    public boolean isOperatorMessage() {
        return this.isOperatorMessage;
    }

    /* access modifiers changed from: package-private */
    public void setIsOperatorMessage(boolean z) {
        this.isOperatorMessage = z;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            BaseMessage baseMessage = (BaseMessage) obj;
            if (getMessageId() == baseMessage.getMessageId() && getChannelUrl().equals(baseMessage.getChannelUrl()) && getCreatedAt() == baseMessage.getCreatedAt()) {
                if (getMessageId() == 0 && baseMessage.getMessageId() == 0) {
                    return getRequestId().equals(baseMessage.getRequestId());
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return p.a(Long.valueOf(getMessageId()), getChannelUrl(), Long.valueOf(getCreatedAt()), getRequestId());
    }

    public String toString() {
        return "BaseMessage{mMessageId=" + this.mMessageId + ", parentMessageId='" + this.parentMessageId + '\'' + ", mChannelUrl='" + this.mChannelUrl + '\'' + ", mChannelType='" + this.mChannelType + '\'' + ", mData='" + this.mData + '\'' + ", mCustomType='" + this.mCustomType + '\'' + ", mCreatedAt=" + this.mCreatedAt + ", mUpdatedAt=" + this.mUpdatedAt + ", mMentionType=" + this.mMentionType + ", mMentionedUserIds=" + this.mMentionedUserIds + ", mMentionedUsers=" + this.mMentionedUsers + ", mMetaArrays=" + this.mMetaArrays + ", mIsGlobalBlocked=" + this.mIsGlobalBlocked + ", mErrorCode=" + this.mErrorCode + ", mIsSilent=" + this.mIsSilent + ", forceUpdateLastMessage=" + this.forceUpdateLastMessage + ", reactionList=" + this.reactionList + ", sendingStatus=" + this.sendingStatus + ", messageSurvivalSeconds=" + this.messageSurvivalSeconds + ", parentMessageText=" + this.parentMessageText + ", threadInfo=" + this.threadInfo + ", mSender=" + this.mSender + ", ogMetaData=" + this.ogMetaData + ", isOpMsg=" + this.isOperatorMessage + '}';
    }

    public static BaseMessage clone(BaseMessage baseMessage) {
        return build(baseMessage.toJson(), baseMessage.getChannelUrl(), baseMessage.isOpenChannel() ? "open" : "group");
    }

    static BaseMessage createMessage(Command command) {
        switch (command.f44215a) {
            case MESG:
            case MEDI:
                UserMessage userMessage = new UserMessage(command.c());
                userMessage.setSendingStatus(SendingStatus.SUCCEEDED);
                return userMessage;
            case FILE:
            case FEDI:
                FileMessage fileMessage = new FileMessage(command.c());
                fileMessage.setSendingStatus(SendingStatus.SUCCEEDED);
                return fileMessage;
            case BRDM:
            case ADMM:
            case AEDI:
                return new AdminMessage(command.c());
            default:
                Logger.d("Discard a command: " + command.f44215a);
                return null;
        }
    }
}
