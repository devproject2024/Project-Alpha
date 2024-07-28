package com.sendbird.android;

import android.text.TextUtils;
import android.util.Pair;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.Command;
import com.sendbird.android.GroupChannelListQuery;
import com.sendbird.android.GroupChannelTotalUnreadMessageCountParams;
import com.sendbird.android.Member;
import com.sendbird.android.SendBird;
import com.sendbird.android.TimeoutScheduler;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.k;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class GroupChannel extends BaseChannel {
    protected static final ConcurrentHashMap<String, GroupChannel> sCachedChannels = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static long sMarkAsReadAllLastSentAt;
    protected User createdBy;
    private boolean isBroadcast;
    private ConcurrentHashMap<String, Long> mCachedDeliveryReceipt;
    private ConcurrentHashMap<String, Long> mCachedReadReceiptStatus;
    private ConcurrentHashMap<String, Pair<Long, User>> mCachedTypingStatus = new ConcurrentHashMap<>();
    private String mCustomType;
    private long mEndTypingLastSentAt;
    boolean mHasBeenUpdated;
    private HiddenState mHiddenState;
    private long mInvitedAt;
    private User mInviter;
    private boolean mIsAccessCodeRequired;
    private boolean mIsDiscoverable;
    private boolean mIsDistinct;
    private boolean mIsHidden;
    private boolean mIsPublic;
    /* access modifiers changed from: private */
    public boolean mIsPushEnabled;
    private boolean mIsSuper;
    private int mJoinedMemberCount;
    private BaseMessage mLastMessage;
    protected long mMarkAsReadLastSentAt;
    private boolean mMarkAsReadScheduled;
    private int mMemberCount;
    private long mMemberCountUpdatedAt;
    protected Map<String, Member> mMemberMap;
    private List<Member> mMembers;
    private long mMessageOffsetTimestamp;
    /* access modifiers changed from: private */
    public CountPreference mMyCountPreference;
    private long mMyLastRead;
    private Member.MemberState mMyMemberState;
    private Member.MutedState mMyMutedState;
    /* access modifiers changed from: private */
    public PushTriggerOption mMyPushTriggerOption;
    private Member.Role mMyRole;
    private long mStartTypingLastSentAt;
    private int mUnreadMentionCount;
    /* access modifiers changed from: private */
    public int mUnreadMessageCount;
    private AtomicLong memberRoleUpdatedAt;
    private int messageSurvivalSeconds;
    private TimeoutScheduler rateLimitScheduler;

    public enum CountPreference {
        ALL,
        UNREAD_MESSAGE_COUNT_ONLY,
        UNREAD_MENTION_COUNT_ONLY,
        OFF
    }

    public interface GroupChannelAcceptInvitationHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelBanHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelChannelCountHandler {
        void onResult(int i2, SendBirdException sendBirdException);
    }

    public interface GroupChannelCreateDistinctChannelIfNotExistHandler {
        void onResult(GroupChannel groupChannel, boolean z, SendBirdException sendBirdException);
    }

    public interface GroupChannelCreateHandler {
        void onResult(GroupChannel groupChannel, SendBirdException sendBirdException);
    }

    public interface GroupChannelDeclineInvitationHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelDeleteHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelFreezeHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelGetHandler {
        void onResult(GroupChannel groupChannel, SendBirdException sendBirdException);
    }

    public interface GroupChannelGetMyPushTriggerOptionHandler {
        void onResult(PushTriggerOption pushTriggerOption, SendBirdException sendBirdException);
    }

    @Deprecated
    public interface GroupChannelGetPushPreferenceHandler {
        @Deprecated
        void onResult(boolean z, SendBirdException sendBirdException);
    }

    public interface GroupChannelGetUnreadItemCountHandler {
        void onResult(Map<UnreadItemKey, Integer> map, SendBirdException sendBirdException);
    }

    public interface GroupChannelHideHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelInviteHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelJoinHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelLeaveHandler {
        void onResult(SendBirdException sendBirdException);
    }

    @Deprecated
    public interface GroupChannelMarkAsReadHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelMuteHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelRefreshHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelResetMyHistoryHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelSetMyCountPreferenceHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelSetMyPushTriggerOptionHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelSetPushPreferenceHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelTotalUnreadChannelCountHandler {
        void onResult(int i2, SendBirdException sendBirdException);
    }

    public interface GroupChannelTotalUnreadMessageCountHandler {
        void onResult(int i2, SendBirdException sendBirdException);
    }

    public interface GroupChannelUnbanHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelUnfreezeHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelUnhideHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelUnmuteHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GroupChannelUpdateHandler {
        void onResult(GroupChannel groupChannel, SendBirdException sendBirdException);
    }

    public enum HiddenState {
        UNHIDDEN,
        HIDDEN_ALLOW_AUTO_UNHIDE,
        HIDDEN_PREVENT_AUTO_UNHIDE
    }

    @Deprecated
    public enum MemberState {
        ALL,
        INVITED,
        INVITED_BY_FRIEND,
        INVITED_BY_NON_FRIEND,
        JOINED
    }

    public enum PushTriggerOption {
        ALL,
        OFF,
        MENTION_ONLY,
        DEFAULT
    }

    public interface RegisterScheduledUserMessageHandler {
        void onRegistered(ScheduledUserMessage scheduledUserMessage, SendBirdException sendBirdException);
    }

    public enum UnreadItemKey {
        GROUP_CHANNEL_UNREAD_MESSAGE_COUNT,
        GROUP_CHANNEL_UNREAD_MENTION_COUNT,
        GROUP_CHANNEL_INVITATION_COUNT,
        NONSUPER_UNREAD_MESSAGE_COUNT,
        SUPER_UNREAD_MESSAGE_COUNT,
        NONSUPER_UNREAD_MENTION_COUNT,
        SUPER_UNREAD_MENTION_COUNT,
        NONSUPER_INVITATION_COUNT,
        SUPER_INVITATION_COUNT
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f44373a;

        /* renamed from: b  reason: collision with root package name */
        final long f44374b;

        a(long j, long j2) {
            this.f44373a = j;
            this.f44374b = j2;
        }

        public final boolean equals(Object obj) {
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f44373a == aVar.f44373a && this.f44374b == aVar.f44374b) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return p.a(Long.valueOf(this.f44373a), Long.valueOf(this.f44374b));
        }

        public final String toString() {
            return "DeliveredReceiptData{msgId=" + this.f44373a + ", createdAt=" + this.f44374b + '}';
        }
    }

    static synchronized void clearCache() {
        synchronized (GroupChannel.class) {
            sCachedChannels.clear();
        }
    }

    static synchronized void removeChannelFromCache(String str) {
        synchronized (GroupChannel.class) {
            sCachedChannels.remove(str);
        }
    }

    public final void refresh(final GroupChannelRefreshHandler groupChannelRefreshHandler) {
        getChannelWithoutCache(getUrl(), new GroupChannelGetHandler() {
            public final void onResult(GroupChannel groupChannel, SendBirdException sendBirdException) {
                GroupChannelRefreshHandler groupChannelRefreshHandler = groupChannelRefreshHandler;
                if (groupChannelRefreshHandler != null) {
                    groupChannelRefreshHandler.onResult(sendBirdException);
                }
            }
        });
    }

    public static GroupChannelListQuery createMyGroupChannelListQuery() {
        return new GroupChannelListQuery(SendBird.getCurrentUser());
    }

    public static PublicGroupChannelListQuery createPublicGroupChannelListQuery() {
        return new PublicGroupChannelListQuery();
    }

    public static void createChannel(List<User> list, boolean z, final GroupChannelCreateHandler groupChannelCreateHandler) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
            createChannelWithUserIds(arrayList, z, (String) null, (Object) null, (String) null, groupChannelCreateHandler);
        } else if (groupChannelCreateHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelCreateHandler.onResult((GroupChannel) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    @Deprecated
    public static void createChannel(List<User> list, boolean z, String str, Object obj, String str2, final GroupChannelCreateHandler groupChannelCreateHandler) throws ClassCastException {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
            createChannelWithUserIds(arrayList, z, str, obj, str2, groupChannelCreateHandler);
        } else if (groupChannelCreateHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelCreateHandler.onResult((GroupChannel) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public static void createChannel(List<User> list, boolean z, String str, Object obj, String str2, String str3, final GroupChannelCreateHandler groupChannelCreateHandler) throws ClassCastException {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
            createChannelWithUserIds(arrayList, z, str, obj, str2, str3, groupChannelCreateHandler);
        } else if (groupChannelCreateHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelCreateHandler.onResult((GroupChannel) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public static void createChannelWithUserIds(List<String> list, boolean z, GroupChannelCreateHandler groupChannelCreateHandler) {
        createChannelWithUserIds(list, z, (String) null, (Object) null, (String) null, groupChannelCreateHandler);
    }

    @Deprecated
    public static void createChannelWithUserIds(List<String> list, boolean z, String str, Object obj, String str2, GroupChannelCreateHandler groupChannelCreateHandler) throws ClassCastException {
        createChannelWithUserIds(list, z, str, obj, str2, (String) null, groupChannelCreateHandler);
    }

    public static void createChannelWithUserIds(List<String> list, boolean z, String str, Object obj, String str2, String str3, GroupChannelCreateHandler groupChannelCreateHandler) throws ClassCastException {
        localCreateChannel(list, (List<String>) null, (Boolean) null, (Boolean) null, (Boolean) null, Boolean.valueOf(z), (Boolean) null, (String) null, str, obj, str2, str3, (String) null, (Boolean) null, (Boolean) null, (Integer) null, groupChannelCreateHandler);
    }

    public static void createChannel(GroupChannelParams groupChannelParams, GroupChannelCreateHandler groupChannelCreateHandler) throws ClassCastException {
        GroupChannelParams groupChannelParams2 = groupChannelParams;
        final GroupChannelCreateHandler groupChannelCreateHandler2 = groupChannelCreateHandler;
        if (groupChannelParams2 != null) {
            localCreateChannel(groupChannelParams2.mUserIds, groupChannelParams2.mOperatorUserIds, groupChannelParams2.mIsSuper, groupChannelParams2.mIsPublic, groupChannelParams2.mIsEphemeral, groupChannelParams2.mIsDistinct, groupChannelParams2.mIsDiscoverable, groupChannelParams2.mChannelUrl, groupChannelParams2.mName, groupChannelParams2.mCoverUrlOrImage, groupChannelParams2.mData, groupChannelParams2.mCustomType, groupChannelParams2.mAccessCode, groupChannelParams2.mStrict, groupChannelParams2.isBroadcast, groupChannelParams2.messageSurvivalSeconds, groupChannelCreateHandler);
        } else if (groupChannelCreateHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelCreateHandler2.onResult((GroupChannel) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public static void createDistinctChannelIfNotExist(GroupChannelParams groupChannelParams, GroupChannelCreateDistinctChannelIfNotExistHandler groupChannelCreateDistinctChannelIfNotExistHandler) throws ClassCastException {
        GroupChannelParams groupChannelParams2 = groupChannelParams;
        final GroupChannelCreateDistinctChannelIfNotExistHandler groupChannelCreateDistinctChannelIfNotExistHandler2 = groupChannelCreateDistinctChannelIfNotExistHandler;
        if (groupChannelParams2 != null) {
            localCreateChannel(groupChannelParams2.mUserIds, groupChannelParams2.mOperatorUserIds, groupChannelParams2.mIsSuper, groupChannelParams2.mIsPublic, groupChannelParams2.mIsEphemeral, Boolean.TRUE, groupChannelParams2.mIsDiscoverable, groupChannelParams2.mChannelUrl, groupChannelParams2.mName, groupChannelParams2.mCoverUrlOrImage, groupChannelParams2.mData, groupChannelParams2.mCustomType, groupChannelParams2.mAccessCode, groupChannelParams2.mStrict, groupChannelParams2.isBroadcast, groupChannelParams2.messageSurvivalSeconds, groupChannelCreateDistinctChannelIfNotExistHandler);
        } else if (groupChannelCreateDistinctChannelIfNotExistHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelCreateDistinctChannelIfNotExistHandler2.onResult((GroupChannel) null, false, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    private static void localCreateChannel(List<String> list, List<String> list2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str, String str2, Object obj, String str3, String str4, String str5, Boolean bool6, Boolean bool7, Integer num, Object obj2) throws ClassCastException {
        Object obj3 = obj;
        if ((obj3 instanceof String) || (obj3 instanceof File) || obj3 == null) {
            final List<String> list3 = list2;
            final Object obj4 = obj;
            final List<String> list4 = list;
            final Boolean bool8 = bool;
            final Boolean bool9 = bool2;
            final Boolean bool10 = bool3;
            final Boolean bool11 = bool4;
            final Boolean bool12 = bool5;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final String str9 = str4;
            final String str10 = str5;
            final Boolean bool13 = bool6;
            final Boolean bool14 = bool7;
            final Integer num2 = num;
            final Object obj5 = obj2;
            d.a(new s<Boolean>() {
                /* access modifiers changed from: private */
                /* JADX WARNING: Removed duplicated region for block: B:89:0x01a2 A[Catch:{ SendBirdException -> 0x01af }] */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Boolean call() {
                    /*
                        r22 = this;
                        r1 = r22
                        java.lang.String r0 = "is_created"
                        java.util.List r2 = r1     // Catch:{ SendBirdException -> 0x01af }
                        java.util.List r3 = r1     // Catch:{ SendBirdException -> 0x01af }
                        if (r3 == 0) goto L_0x0020
                        java.util.List r3 = r1     // Catch:{ SendBirdException -> 0x01af }
                        int r3 = r3.size()     // Catch:{ SendBirdException -> 0x01af }
                        if (r3 <= 0) goto L_0x0020
                        java.util.LinkedHashSet r2 = new java.util.LinkedHashSet     // Catch:{ SendBirdException -> 0x01af }
                        java.util.List r3 = r1     // Catch:{ SendBirdException -> 0x01af }
                        r2.<init>(r3)     // Catch:{ SendBirdException -> 0x01af }
                        java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SendBirdException -> 0x01af }
                        r3.<init>(r2)     // Catch:{ SendBirdException -> 0x01af }
                        r6 = r3
                        goto L_0x0021
                    L_0x0020:
                        r6 = r2
                    L_0x0021:
                        java.lang.Object r2 = r2     // Catch:{ SendBirdException -> 0x01af }
                        boolean r2 = r2 instanceof java.lang.String     // Catch:{ SendBirdException -> 0x01af }
                        if (r2 != 0) goto L_0x0147
                        java.lang.Object r2 = r2     // Catch:{ SendBirdException -> 0x01ab }
                        if (r2 != 0) goto L_0x002d
                        goto L_0x0147
                    L_0x002d:
                        com.sendbird.android.APIClient r2 = com.sendbird.android.APIClient.a()     // Catch:{ SendBirdException -> 0x01ab }
                        java.util.List r3 = r3     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.Boolean r4 = r4     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.Boolean r5 = r5     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.Boolean r7 = r6     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.Boolean r8 = r7     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.Boolean r9 = r8     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r10 = r9     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r11 = r10     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.Object r12 = r2     // Catch:{ SendBirdException -> 0x01ab }
                        java.io.File r12 = (java.io.File) r12     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r13 = r11     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r14 = r12     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r15 = r13     // Catch:{ SendBirdException -> 0x01ab }
                        r21 = r0
                        java.lang.Boolean r0 = r14     // Catch:{ SendBirdException -> 0x01ab }
                        r16 = r2
                        java.lang.Boolean r2 = r15     // Catch:{ SendBirdException -> 0x01ab }
                        r17 = r2
                        java.lang.Integer r2 = r16     // Catch:{ SendBirdException -> 0x01ab }
                        com.sendbird.android.User r18 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ SendBirdException -> 0x01ab }
                        if (r18 == 0) goto L_0x0142
                        com.sendbird.android.b r18 = com.sendbird.android.b.GROUPCHANNELS     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r1 = r18.publicUrl()     // Catch:{ SendBirdException -> 0x01ab }
                        r18 = r1
                        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ SendBirdException -> 0x01ab }
                        r1.<init>()     // Catch:{ SendBirdException -> 0x01ab }
                        r19 = 0
                        r20 = r2
                        java.util.LinkedHashSet r2 = new java.util.LinkedHashSet     // Catch:{ SendBirdException -> 0x01ab }
                        r2.<init>(r3)     // Catch:{ SendBirdException -> 0x01ab }
                        com.sendbird.android.User r3 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r3 = r3.getUserId()     // Catch:{ SendBirdException -> 0x01ab }
                        r2.add(r3)     // Catch:{ SendBirdException -> 0x01ab }
                        java.lang.String r3 = "user_ids"
                        java.lang.String r2 = com.sendbird.android.b.urlEncodeUTF8((java.util.Collection<java.lang.String>) r2)     // Catch:{ SendBirdException -> 0x01ab }
                        r1.put(r3, r2)     // Catch:{ SendBirdException -> 0x01ab }
                        if (r6 == 0) goto L_0x0093
                        java.lang.String r2 = "operator_ids"
                        java.lang.String r3 = com.sendbird.android.b.urlEncodeUTF8((java.util.Collection<java.lang.String>) r6)     // Catch:{ SendBirdException -> 0x01ab }
                        r1.put(r2, r3)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x0093:
                        java.lang.String r2 = "true"
                        java.lang.String r3 = "false"
                        if (r4 == 0) goto L_0x00a8
                        java.lang.String r6 = "is_super"
                        boolean r4 = r4.booleanValue()     // Catch:{ SendBirdException -> 0x01ab }
                        if (r4 == 0) goto L_0x00a4
                        r4 = r2
                        goto L_0x00a5
                    L_0x00a4:
                        r4 = r3
                    L_0x00a5:
                        r1.put(r6, r4)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x00a8:
                        if (r5 == 0) goto L_0x00b8
                        java.lang.String r4 = "is_public"
                        boolean r5 = r5.booleanValue()     // Catch:{ SendBirdException -> 0x01ab }
                        if (r5 == 0) goto L_0x00b4
                        r5 = r2
                        goto L_0x00b5
                    L_0x00b4:
                        r5 = r3
                    L_0x00b5:
                        r1.put(r4, r5)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x00b8:
                        if (r7 == 0) goto L_0x00c8
                        java.lang.String r4 = "is_ephemeral"
                        boolean r5 = r7.booleanValue()     // Catch:{ SendBirdException -> 0x01ab }
                        if (r5 == 0) goto L_0x00c4
                        r5 = r2
                        goto L_0x00c5
                    L_0x00c4:
                        r5 = r3
                    L_0x00c5:
                        r1.put(r4, r5)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x00c8:
                        if (r8 == 0) goto L_0x00d8
                        java.lang.String r4 = "is_distinct"
                        boolean r5 = r8.booleanValue()     // Catch:{ SendBirdException -> 0x01ab }
                        if (r5 == 0) goto L_0x00d4
                        r5 = r2
                        goto L_0x00d5
                    L_0x00d4:
                        r5 = r3
                    L_0x00d5:
                        r1.put(r4, r5)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x00d8:
                        if (r9 == 0) goto L_0x00e8
                        java.lang.String r4 = "is_discoverable"
                        boolean r5 = r9.booleanValue()     // Catch:{ SendBirdException -> 0x01ab }
                        if (r5 == 0) goto L_0x00e4
                        r5 = r2
                        goto L_0x00e5
                    L_0x00e4:
                        r5 = r3
                    L_0x00e5:
                        r1.put(r4, r5)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x00e8:
                        if (r10 == 0) goto L_0x00ef
                        java.lang.String r4 = "channel_url"
                        r1.put(r4, r10)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x00ef:
                        if (r11 == 0) goto L_0x00f6
                        java.lang.String r4 = "name"
                        r1.put(r4, r11)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x00f6:
                        if (r12 == 0) goto L_0x00fa
                        java.lang.String r19 = "cover_file"
                    L_0x00fa:
                        r4 = r19
                        if (r13 == 0) goto L_0x0103
                        java.lang.String r5 = "data"
                        r1.put(r5, r13)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x0103:
                        if (r14 == 0) goto L_0x010a
                        java.lang.String r5 = "custom_type"
                        r1.put(r5, r14)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x010a:
                        if (r15 == 0) goto L_0x0111
                        java.lang.String r5 = "access_code"
                        r1.put(r5, r15)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x0111:
                        if (r0 == 0) goto L_0x0121
                        java.lang.String r5 = "strict"
                        boolean r0 = r0.booleanValue()     // Catch:{ SendBirdException -> 0x01ab }
                        if (r0 == 0) goto L_0x011d
                        goto L_0x011e
                    L_0x011d:
                        r2 = r3
                    L_0x011e:
                        r1.put(r5, r2)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x0121:
                        if (r17 == 0) goto L_0x012c
                        java.lang.String r0 = "is_broadcast"
                        java.lang.String r2 = java.lang.String.valueOf(r17)     // Catch:{ SendBirdException -> 0x01ab }
                        r1.put(r0, r2)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x012c:
                        if (r20 == 0) goto L_0x0137
                        java.lang.String r0 = "message_survival_seconds"
                        java.lang.String r2 = r20.toString()     // Catch:{ SendBirdException -> 0x01ab }
                        r1.put(r0, r2)     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x0137:
                        r0 = r16
                        r2 = r18
                        com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r0.a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r1, (java.lang.String) r4, (java.io.File) r12)     // Catch:{ SendBirdException -> 0x01ab }
                        r1 = r22
                        goto L_0x017e
                    L_0x0142:
                        com.sendbird.android.SendBirdException r0 = com.sendbird.android.u.b()     // Catch:{ SendBirdException -> 0x01ab }
                        throw r0     // Catch:{ SendBirdException -> 0x01ab }
                    L_0x0147:
                        r21 = r0
                        com.sendbird.android.APIClient r4 = com.sendbird.android.APIClient.a()     // Catch:{ SendBirdException -> 0x01ab }
                        r1 = r22
                        java.util.List r5 = r3     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.Boolean r7 = r4     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.Boolean r8 = r5     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.Boolean r9 = r6     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.Boolean r10 = r7     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.Boolean r11 = r8     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.String r12 = r9     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.String r13 = r10     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.Object r0 = r2     // Catch:{ SendBirdException -> 0x01af }
                        r14 = r0
                        java.lang.String r14 = (java.lang.String) r14     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.String r15 = r11     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.String r0 = r12     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.String r2 = r13     // Catch:{ SendBirdException -> 0x01af }
                        java.lang.Boolean r3 = r14     // Catch:{ SendBirdException -> 0x01af }
                        r18 = r3
                        java.lang.Boolean r3 = r15     // Catch:{ SendBirdException -> 0x01af }
                        r19 = r3
                        java.lang.Integer r3 = r16     // Catch:{ SendBirdException -> 0x01af }
                        r16 = r0
                        r17 = r2
                        r20 = r3
                        com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SendBirdException -> 0x01af }
                    L_0x017e:
                        r2 = 0
                        com.sendbird.android.GroupChannel r3 = com.sendbird.android.GroupChannel.upsert(r0, r2)     // Catch:{ SendBirdException -> 0x01af }
                        com.sendbird.android.shadow.com.google.gson.JsonObject r4 = r0.getAsJsonObject()     // Catch:{ SendBirdException -> 0x01af }
                        r5 = r21
                        boolean r4 = r4.has(r5)     // Catch:{ SendBirdException -> 0x01af }
                        if (r4 == 0) goto L_0x019e
                        com.sendbird.android.shadow.com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ SendBirdException -> 0x01af }
                        com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r0.get(r5)     // Catch:{ SendBirdException -> 0x01af }
                        boolean r0 = r0.getAsBoolean()     // Catch:{ SendBirdException -> 0x01af }
                        if (r0 == 0) goto L_0x019e
                        r2 = 1
                    L_0x019e:
                        java.lang.Object r0 = r17     // Catch:{ SendBirdException -> 0x01af }
                        if (r0 == 0) goto L_0x01b8
                        com.sendbird.android.GroupChannel$48$1 r0 = new com.sendbird.android.GroupChannel$48$1     // Catch:{ SendBirdException -> 0x01af }
                        r0.<init>(r3, r2)     // Catch:{ SendBirdException -> 0x01af }
                        com.sendbird.android.SendBird.runOnUIThread(r0)     // Catch:{ SendBirdException -> 0x01af }
                        goto L_0x01b8
                    L_0x01ab:
                        r0 = move-exception
                        r1 = r22
                        goto L_0x01b0
                    L_0x01af:
                        r0 = move-exception
                    L_0x01b0:
                        com.sendbird.android.GroupChannel$48$2 r2 = new com.sendbird.android.GroupChannel$48$2
                        r2.<init>(r0)
                        com.sendbird.android.SendBird.runOnUIThread(r2)
                    L_0x01b8:
                        java.lang.Boolean r0 = java.lang.Boolean.TRUE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannel.AnonymousClass48.call():java.lang.Boolean");
                }
            });
            return;
        }
        throw new ClassCastException();
    }

    static boolean hasCachedChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return sCachedChannels.containsKey(str);
    }

    protected static void getChannelWithoutCache(String str, GroupChannelGetHandler groupChannelGetHandler) {
        getChannelWithoutCache(false, str, groupChannelGetHandler);
    }

    static void getChannelWithoutCacheInternal(String str, GroupChannelGetHandler groupChannelGetHandler) {
        getChannelWithoutCache(true, str, groupChannelGetHandler);
    }

    public static void getChannel(String str, GroupChannelGetHandler groupChannelGetHandler) {
        getChannel(false, str, groupChannelGetHandler);
    }

    static void getChannelInternal(String str, GroupChannelGetHandler groupChannelGetHandler) {
        getChannel(true, str, groupChannelGetHandler);
    }

    private static void getChannel(boolean z, final String str, final GroupChannelGetHandler groupChannelGetHandler) {
        if (str == null) {
            if (groupChannelGetHandler != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        groupChannelGetHandler.onResult((GroupChannel) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
        } else if (!sCachedChannels.containsKey(str) || sCachedChannels.get(str).isDirty()) {
            getChannelWithoutCache(z, str, new GroupChannelGetHandler() {
                public final void onResult(final GroupChannel groupChannel, final SendBirdException sendBirdException) {
                    if (groupChannelGetHandler != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                if (groupChannel != null || sendBirdException != null) {
                                    groupChannelGetHandler.onResult(groupChannel, sendBirdException);
                                }
                            }
                        });
                    }
                }
            });
        } else if (groupChannelGetHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    if (GroupChannel.sCachedChannels.get(str) != null) {
                        groupChannelGetHandler.onResult(GroupChannel.sCachedChannels.get(str), (SendBirdException) null);
                    }
                }
            });
        }
    }

    private static void getChannelWithoutCache(final boolean z, final String str, final GroupChannelGetHandler groupChannelGetHandler) {
        d.a(new q<GroupChannel>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannel groupChannel = (GroupChannel) obj;
                GroupChannelGetHandler groupChannelGetHandler = groupChannelGetHandler;
                if (groupChannelGetHandler != null) {
                    groupChannelGetHandler.onResult(groupChannel, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String str = str;
                String format = String.format(b.GROUPCHANNELS_CHANNELURL.url(z), new Object[]{b.urlEncodeUTF8(str)});
                HashMap hashMap = new HashMap();
                hashMap.put(StringSet.member, "true");
                hashMap.put(StringSet.show_read_receipt, "true");
                hashMap.put(StringSet.show_delivery_receipt, "true");
                return GroupChannel.upsert(a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null), false);
            }
        });
    }

    @Deprecated
    public static void getTotalUnreadMessageCount(GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        SendBird.localGetTotalUnreadMessageCount((GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter) null, (List<String>) null, groupChannelTotalUnreadMessageCountHandler);
    }

    @Deprecated
    public static void getTotalUnreadMessageCount(List<String> list, GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        SendBird.localGetTotalUnreadMessageCount((GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter) null, list, groupChannelTotalUnreadMessageCountHandler);
    }

    @Deprecated
    public static void getTotalUnreadMessageCount(GroupChannelTotalUnreadMessageCountParams groupChannelTotalUnreadMessageCountParams, GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        SendBird.localGetTotalUnreadMessageCount(groupChannelTotalUnreadMessageCountParams.mSuperChannelFilter, groupChannelTotalUnreadMessageCountParams.mChannelCustomTypes, groupChannelTotalUnreadMessageCountHandler);
    }

    @Deprecated
    public static void getUnreadItemCount(final Collection<UnreadItemKey> collection, final GroupChannelGetUnreadItemCountHandler groupChannelGetUnreadItemCountHandler) {
        d.a(new q<Map<UnreadItemKey, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                GroupChannelGetUnreadItemCountHandler groupChannelGetUnreadItemCountHandler = groupChannelGetUnreadItemCountHandler;
                if (groupChannelGetUnreadItemCountHandler != null) {
                    groupChannelGetUnreadItemCountHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                Collection collection = collection;
                if (collection == null || collection.size() <= 0) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                JsonObject asJsonObject = APIClient.a().a((Collection<UnreadItemKey>) collection).getAsJsonObject();
                HashMap hashMap = new HashMap();
                for (Map.Entry next : asJsonObject.entrySet()) {
                    if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                        UnreadItemKey unreadItemKey = null;
                        String str = (String) next.getKey();
                        if (str.equals("group_channel_unread_message_count")) {
                            unreadItemKey = UnreadItemKey.GROUP_CHANNEL_UNREAD_MESSAGE_COUNT;
                        } else if (str.equals("group_channel_unread_mention_count")) {
                            unreadItemKey = UnreadItemKey.GROUP_CHANNEL_UNREAD_MENTION_COUNT;
                        } else if (str.equals("group_channel_invitation_count")) {
                            unreadItemKey = UnreadItemKey.GROUP_CHANNEL_INVITATION_COUNT;
                        } else if (str.equals("non_super_group_channel_unread_message_count")) {
                            unreadItemKey = UnreadItemKey.NONSUPER_UNREAD_MESSAGE_COUNT;
                        } else if (str.equals("super_group_channel_unread_message_count")) {
                            unreadItemKey = UnreadItemKey.SUPER_UNREAD_MESSAGE_COUNT;
                        } else if (str.equals("non_super_group_channel_unread_mention_count")) {
                            unreadItemKey = UnreadItemKey.NONSUPER_UNREAD_MENTION_COUNT;
                        } else if (str.equals("super_group_channel_unread_mention_count")) {
                            unreadItemKey = UnreadItemKey.SUPER_UNREAD_MENTION_COUNT;
                        } else if (str.equals("non_super_group_channel_invitation_count")) {
                            unreadItemKey = UnreadItemKey.NONSUPER_INVITATION_COUNT;
                        } else if (str.equals("super_group_channel_invitation_count")) {
                            unreadItemKey = UnreadItemKey.SUPER_INVITATION_COUNT;
                        }
                        if (unreadItemKey != null) {
                            hashMap.put(unreadItemKey, Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                }
                return hashMap;
            }
        });
    }

    @Deprecated
    public static void getTotalUnreadChannelCount(final GroupChannelTotalUnreadChannelCountHandler groupChannelTotalUnreadChannelCountHandler) {
        d.a(new q<Integer>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Integer num = (Integer) obj;
                GroupChannelTotalUnreadChannelCountHandler groupChannelTotalUnreadChannelCountHandler = groupChannelTotalUnreadChannelCountHandler;
                if (groupChannelTotalUnreadChannelCountHandler != null) {
                    groupChannelTotalUnreadChannelCountHandler.onResult(num != null ? num.intValue() : 0, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                return Integer.valueOf(APIClient.a().g().getAsJsonObject().get(CLPConstants.FLAG_NOTIFICATIONS_UNREAD_COUNT).getAsInt());
            }
        });
    }

    @Deprecated
    public static void getChannelCount(MemberState memberState, GroupChannelChannelCountHandler groupChannelChannelCountHandler) {
        int i2 = AnonymousClass46.f44336a[memberState.ordinal()];
        SendBird.localGetGroupChannelCount(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? null : StringSet.joined : StringSet.invited_by_non_friend : StringSet.invited_by_friend : "invited" : StringSet.all, groupChannelChannelCountHandler);
    }

    @Deprecated
    public static void getChannelCount(GroupChannelListQuery.MemberStateFilter memberStateFilter, GroupChannelChannelCountHandler groupChannelChannelCountHandler) {
        int i2 = AnonymousClass46.f44337b[memberStateFilter.ordinal()];
        SendBird.localGetGroupChannelCount(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? null : StringSet.joined : StringSet.invited_by_non_friend : StringSet.invited_by_friend : "invited" : StringSet.all, groupChannelChannelCountHandler);
    }

    public final GroupChannelMemberListQuery createMemberListQuery() {
        return new GroupChannelMemberListQuery(this);
    }

    protected static synchronized GroupChannel upsert(JsonElement jsonElement, boolean z) {
        GroupChannel groupChannel;
        synchronized (GroupChannel.class) {
            String asString = jsonElement.getAsJsonObject().get(StringSet.channel_url).getAsString();
            if (sCachedChannels.containsKey(asString)) {
                GroupChannel groupChannel2 = sCachedChannels.get(asString);
                if (!z || groupChannel2.isDirty()) {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    if ((asJsonObject.has("is_ephemeral") && asJsonObject.get("is_ephemeral").getAsBoolean()) && !z) {
                        if (groupChannel2.getLastMessage() != null) {
                            asJsonObject.add("last_message", groupChannel2.getLastMessage().toJson());
                        }
                        asJsonObject.addProperty("unread_message_count", (Number) Integer.valueOf(groupChannel2.getUnreadMessageCount()));
                        asJsonObject.addProperty("unread_mention_count", (Number) Integer.valueOf(groupChannel2.getUnreadMentionCount()));
                    }
                    groupChannel2.update(asJsonObject);
                    groupChannel2.setDirty(z);
                }
            } else {
                sCachedChannels.put(asString, new GroupChannel(jsonElement));
            }
            groupChannel = sCachedChannels.get(asString);
        }
        return groupChannel;
    }

    protected static synchronized void setDirtyToAllCachedChannels(boolean z) {
        synchronized (GroupChannel.class) {
            if (sCachedChannels != null) {
                for (GroupChannel dirty : sCachedChannels.values()) {
                    dirty.setDirty(z);
                }
            }
        }
    }

    protected GroupChannel(JsonElement jsonElement) {
        super(jsonElement);
    }

    /* access modifiers changed from: protected */
    public final void update(JsonElement jsonElement) {
        super.update(jsonElement);
        parse(jsonElement);
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0417  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0422  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void parse(com.sendbird.android.shadow.com.google.gson.JsonElement r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.sendbird.android.shadow.com.google.gson.JsonObject r9 = r9.getAsJsonObject()     // Catch:{ all -> 0x044f }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r0 = r8.mCachedReadReceiptStatus     // Catch:{ all -> 0x044f }
            if (r0 != 0) goto L_0x0010
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x044f }
            r0.<init>()     // Catch:{ all -> 0x044f }
            r8.mCachedReadReceiptStatus = r0     // Catch:{ all -> 0x044f }
        L_0x0010:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r0 = r8.mCachedDeliveryReceipt     // Catch:{ all -> 0x044f }
            if (r0 != 0) goto L_0x001b
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x044f }
            r0.<init>()     // Catch:{ all -> 0x044f }
            r8.mCachedDeliveryReceipt = r0     // Catch:{ all -> 0x044f }
        L_0x001b:
            java.lang.String r0 = "is_super"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = "is_super"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            r8.mIsSuper = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "is_public"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x004c
            java.lang.String r0 = "is_public"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            r8.mIsPublic = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "is_distinct"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            r8.mIsDistinct = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "is_discoverable"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x006e
            java.lang.String r0 = "is_discoverable"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            goto L_0x0070
        L_0x006e:
            boolean r0 = r8.mIsPublic     // Catch:{ all -> 0x044f }
        L_0x0070:
            r8.mIsDiscoverable = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "is_access_code_required"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0088
            java.lang.String r0 = "is_access_code_required"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0088
            r0 = 1
            goto L_0x0089
        L_0x0088:
            r0 = 0
        L_0x0089:
            r8.mIsAccessCodeRequired = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "is_broadcast"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x00a0
            java.lang.String r0 = "is_broadcast"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            r8.isBroadcast = r1     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "unread_message_count"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x044f }
            r8.mUnreadMessageCount = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "unread_mention_count"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x00c6
            java.lang.String r0 = "unread_mention_count"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x044f }
            r8.mUnreadMentionCount = r0     // Catch:{ all -> 0x044f }
        L_0x00c6:
            java.lang.String r0 = "read_receipt"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x010d
            java.lang.String r0 = "read_receipt"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            com.sendbird.android.shadow.com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ all -> 0x044f }
            java.util.Set r1 = r0.entrySet()     // Catch:{ all -> 0x044f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x044f }
        L_0x00e0:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x044f }
            if (r3 == 0) goto L_0x0100
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x044f }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x044f }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x044f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x044f }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x044f }
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = (com.sendbird.android.shadow.com.google.gson.JsonElement) r3     // Catch:{ all -> 0x044f }
            long r5 = r3.getAsLong()     // Catch:{ all -> 0x044f }
            r8.updateReadReceipt(r4, r5)     // Catch:{ all -> 0x044f }
            goto L_0x00e0
        L_0x0100:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = r8.mCachedReadReceiptStatus     // Catch:{ all -> 0x044f }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x044f }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x044f }
            r1.retainAll(r0)     // Catch:{ all -> 0x044f }
        L_0x010d:
            java.lang.String r0 = "delivery_receipt"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0154
            java.lang.String r0 = "delivery_receipt"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            com.sendbird.android.shadow.com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ all -> 0x044f }
            java.util.Set r1 = r0.entrySet()     // Catch:{ all -> 0x044f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x044f }
        L_0x0127:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x044f }
            if (r3 == 0) goto L_0x0147
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x044f }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x044f }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x044f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x044f }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x044f }
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = (com.sendbird.android.shadow.com.google.gson.JsonElement) r3     // Catch:{ all -> 0x044f }
            long r5 = r3.getAsLong()     // Catch:{ all -> 0x044f }
            r8.updateDeliveryReceipt(r4, r5)     // Catch:{ all -> 0x044f }
            goto L_0x0127
        L_0x0147:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = r8.mCachedDeliveryReceipt     // Catch:{ all -> 0x044f }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x044f }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x044f }
            r1.retainAll(r0)     // Catch:{ all -> 0x044f }
        L_0x0154:
            java.lang.String r0 = "members"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x01b0
            java.util.List<com.sendbird.android.Member> r0 = r8.mMembers     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0166
            java.util.List<com.sendbird.android.Member> r0 = r8.mMembers     // Catch:{ all -> 0x044f }
            r0.clear()     // Catch:{ all -> 0x044f }
            goto L_0x016d
        L_0x0166:
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x044f }
            r0.<init>()     // Catch:{ all -> 0x044f }
            r8.mMembers = r0     // Catch:{ all -> 0x044f }
        L_0x016d:
            java.util.Map<java.lang.String, com.sendbird.android.Member> r0 = r8.mMemberMap     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0177
            java.util.Map<java.lang.String, com.sendbird.android.Member> r0 = r8.mMemberMap     // Catch:{ all -> 0x044f }
            r0.clear()     // Catch:{ all -> 0x044f }
            goto L_0x017e
        L_0x0177:
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x044f }
            r0.<init>()     // Catch:{ all -> 0x044f }
            r8.mMemberMap = r0     // Catch:{ all -> 0x044f }
        L_0x017e:
            java.lang.String r0 = "members"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            com.sendbird.android.shadow.com.google.gson.JsonArray r0 = r0.getAsJsonArray()     // Catch:{ all -> 0x044f }
        L_0x0188:
            int r1 = r0.size()     // Catch:{ all -> 0x044f }
            if (r2 >= r1) goto L_0x01a8
            com.sendbird.android.Member r1 = new com.sendbird.android.Member     // Catch:{ all -> 0x044f }
            com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r0.get(r2)     // Catch:{ all -> 0x044f }
            r1.<init>(r3)     // Catch:{ all -> 0x044f }
            java.util.List<com.sendbird.android.Member> r3 = r8.mMembers     // Catch:{ all -> 0x044f }
            r3.add(r1)     // Catch:{ all -> 0x044f }
            java.util.Map<java.lang.String, com.sendbird.android.Member> r3 = r8.mMemberMap     // Catch:{ all -> 0x044f }
            java.lang.String r4 = r1.getUserId()     // Catch:{ all -> 0x044f }
            r3.put(r4, r1)     // Catch:{ all -> 0x044f }
            int r2 = r2 + 1
            goto L_0x0188
        L_0x01a8:
            java.util.List<com.sendbird.android.Member> r0 = r8.mMembers     // Catch:{ all -> 0x044f }
            int r0 = r0.size()     // Catch:{ all -> 0x044f }
            r8.mMemberCount = r0     // Catch:{ all -> 0x044f }
        L_0x01b0:
            java.lang.String r0 = "member_count"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x01c4
            java.lang.String r0 = "member_count"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x044f }
            r8.mMemberCount = r0     // Catch:{ all -> 0x044f }
        L_0x01c4:
            java.lang.String r0 = "joined_member_count"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x01d8
            java.lang.String r0 = "joined_member_count"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x044f }
            r8.mJoinedMemberCount = r0     // Catch:{ all -> 0x044f }
        L_0x01d8:
            java.lang.String r0 = "invited_at"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x01f9
            java.lang.String r0 = "invited_at"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.isJsonNull()     // Catch:{ all -> 0x044f }
            if (r0 != 0) goto L_0x01f9
            java.lang.String r0 = "invited_at"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            long r0 = r0.getAsLong()     // Catch:{ all -> 0x044f }
            r8.setInvitedAt(r0)     // Catch:{ all -> 0x044f }
        L_0x01f9:
            java.lang.String r0 = "last_message"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            r1 = 0
            if (r0 == 0) goto L_0x0223
            java.lang.String r0 = "last_message"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.isJsonObject()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0223
            java.lang.String r0 = "last_message"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            java.lang.String r2 = r8.getUrl()     // Catch:{ all -> 0x044f }
            java.lang.String r3 = r8.getType()     // Catch:{ all -> 0x044f }
            com.sendbird.android.BaseMessage r0 = com.sendbird.android.BaseMessage.build(r0, r2, r3)     // Catch:{ all -> 0x044f }
            r8.mLastMessage = r0     // Catch:{ all -> 0x044f }
            goto L_0x0225
        L_0x0223:
            r8.mLastMessage = r1     // Catch:{ all -> 0x044f }
        L_0x0225:
            java.lang.String r0 = "inviter"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x024b
            java.lang.String r0 = "inviter"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.isJsonObject()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x024b
            com.sendbird.android.User r0 = new com.sendbird.android.User     // Catch:{ all -> 0x044f }
            java.lang.String r2 = "inviter"
            com.sendbird.android.shadow.com.google.gson.JsonElement r2 = r9.get(r2)     // Catch:{ all -> 0x044f }
            com.sendbird.android.shadow.com.google.gson.JsonObject r2 = r2.getAsJsonObject()     // Catch:{ all -> 0x044f }
            r0.<init>(r2)     // Catch:{ all -> 0x044f }
            r8.mInviter = r0     // Catch:{ all -> 0x044f }
            goto L_0x024d
        L_0x024b:
            r8.mInviter = r1     // Catch:{ all -> 0x044f }
        L_0x024d:
            java.lang.String r0 = "custom_type"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0261
            java.lang.String r0 = "custom_type"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x044f }
            r8.mCustomType = r0     // Catch:{ all -> 0x044f }
        L_0x0261:
            java.lang.String r0 = "is_push_enabled"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0275
            java.lang.String r0 = "is_push_enabled"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            r8.mIsPushEnabled = r0     // Catch:{ all -> 0x044f }
        L_0x0275:
            java.lang.String r0 = "push_trigger_option"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x02c2
            java.lang.String r0 = "push_trigger_option"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.isJsonNull()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x028c
            java.lang.String r0 = "default"
            goto L_0x0296
        L_0x028c:
            java.lang.String r0 = "push_trigger_option"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x044f }
        L_0x0296:
            java.lang.String r2 = "all"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x02a3
            com.sendbird.android.GroupChannel$PushTriggerOption r0 = com.sendbird.android.GroupChannel.PushTriggerOption.ALL     // Catch:{ all -> 0x044f }
            r8.mMyPushTriggerOption = r0     // Catch:{ all -> 0x044f }
            goto L_0x02c6
        L_0x02a3:
            java.lang.String r2 = "off"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x02b0
            com.sendbird.android.GroupChannel$PushTriggerOption r0 = com.sendbird.android.GroupChannel.PushTriggerOption.OFF     // Catch:{ all -> 0x044f }
            r8.mMyPushTriggerOption = r0     // Catch:{ all -> 0x044f }
            goto L_0x02c6
        L_0x02b0:
            java.lang.String r2 = "mention_only"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x02bd
            com.sendbird.android.GroupChannel$PushTriggerOption r0 = com.sendbird.android.GroupChannel.PushTriggerOption.MENTION_ONLY     // Catch:{ all -> 0x044f }
            r8.mMyPushTriggerOption = r0     // Catch:{ all -> 0x044f }
            goto L_0x02c6
        L_0x02bd:
            java.lang.String r2 = "default"
            r0.equals(r2)     // Catch:{ all -> 0x044f }
        L_0x02c2:
            com.sendbird.android.GroupChannel$PushTriggerOption r0 = com.sendbird.android.GroupChannel.PushTriggerOption.DEFAULT     // Catch:{ all -> 0x044f }
            r8.mMyPushTriggerOption = r0     // Catch:{ all -> 0x044f }
        L_0x02c6:
            java.lang.String r0 = "count_preference"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0310
            java.lang.String r0 = "count_preference"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0314
            java.lang.String r2 = "all"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 != 0) goto L_0x030b
            java.lang.String r2 = "unread_message_count_only"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x02f0
            com.sendbird.android.GroupChannel$CountPreference r0 = com.sendbird.android.GroupChannel.CountPreference.UNREAD_MESSAGE_COUNT_ONLY     // Catch:{ all -> 0x044f }
            r8.mMyCountPreference = r0     // Catch:{ all -> 0x044f }
            goto L_0x0314
        L_0x02f0:
            java.lang.String r2 = "unread_mention_count_only"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x02fe
            com.sendbird.android.GroupChannel$CountPreference r0 = com.sendbird.android.GroupChannel.CountPreference.UNREAD_MENTION_COUNT_ONLY     // Catch:{ all -> 0x044f }
            r8.mMyCountPreference = r0     // Catch:{ all -> 0x044f }
            goto L_0x0314
        L_0x02fe:
            java.lang.String r2 = "off"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x030b
            com.sendbird.android.GroupChannel$CountPreference r0 = com.sendbird.android.GroupChannel.CountPreference.OFF     // Catch:{ all -> 0x044f }
            r8.mMyCountPreference = r0     // Catch:{ all -> 0x044f }
            goto L_0x0314
        L_0x030b:
            com.sendbird.android.GroupChannel$CountPreference r0 = com.sendbird.android.GroupChannel.CountPreference.ALL     // Catch:{ all -> 0x044f }
            r8.mMyCountPreference = r0     // Catch:{ all -> 0x044f }
            goto L_0x0314
        L_0x0310:
            com.sendbird.android.GroupChannel$CountPreference r0 = com.sendbird.android.GroupChannel.CountPreference.ALL     // Catch:{ all -> 0x044f }
            r8.mMyCountPreference = r0     // Catch:{ all -> 0x044f }
        L_0x0314:
            java.lang.String r0 = "is_hidden"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0328
            java.lang.String r0 = "is_hidden"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            r8.mIsHidden = r0     // Catch:{ all -> 0x044f }
        L_0x0328:
            java.lang.String r0 = "hidden_state"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0365
            java.lang.String r0 = "hidden_state"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x044f }
            java.lang.String r2 = "unhidden"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 != 0) goto L_0x035f
            java.lang.String r2 = "hidden_allow_auto_unhide"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x0351
            com.sendbird.android.GroupChannel$HiddenState r0 = com.sendbird.android.GroupChannel.HiddenState.HIDDEN_ALLOW_AUTO_UNHIDE     // Catch:{ all -> 0x044f }
            r8.setHiddenState(r0)     // Catch:{ all -> 0x044f }
            goto L_0x036a
        L_0x0351:
            java.lang.String r2 = "hidden_prevent_auto_unhide"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x035f
            com.sendbird.android.GroupChannel$HiddenState r0 = com.sendbird.android.GroupChannel.HiddenState.HIDDEN_PREVENT_AUTO_UNHIDE     // Catch:{ all -> 0x044f }
            r8.setHiddenState(r0)     // Catch:{ all -> 0x044f }
            goto L_0x036a
        L_0x035f:
            com.sendbird.android.GroupChannel$HiddenState r0 = com.sendbird.android.GroupChannel.HiddenState.UNHIDDEN     // Catch:{ all -> 0x044f }
            r8.setHiddenState(r0)     // Catch:{ all -> 0x044f }
            goto L_0x036a
        L_0x0365:
            com.sendbird.android.GroupChannel$HiddenState r0 = com.sendbird.android.GroupChannel.HiddenState.UNHIDDEN     // Catch:{ all -> 0x044f }
            r8.setHiddenState(r0)     // Catch:{ all -> 0x044f }
        L_0x036a:
            com.sendbird.android.Member$MemberState r0 = com.sendbird.android.Member.MemberState.NONE     // Catch:{ all -> 0x044f }
            r8.mMyMemberState = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "member_state"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x03ae
            java.lang.String r0 = "member_state"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x03ae
            int r2 = r0.length()     // Catch:{ all -> 0x044f }
            if (r2 <= 0) goto L_0x03ae
            java.lang.String r2 = "none"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x0395
            com.sendbird.android.Member$MemberState r0 = com.sendbird.android.Member.MemberState.NONE     // Catch:{ all -> 0x044f }
            r8.mMyMemberState = r0     // Catch:{ all -> 0x044f }
            goto L_0x03ae
        L_0x0395:
            java.lang.String r2 = "invited"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r2 == 0) goto L_0x03a2
            com.sendbird.android.Member$MemberState r0 = com.sendbird.android.Member.MemberState.INVITED     // Catch:{ all -> 0x044f }
            r8.mMyMemberState = r0     // Catch:{ all -> 0x044f }
            goto L_0x03ae
        L_0x03a2:
            java.lang.String r2 = "joined"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x03ae
            com.sendbird.android.Member$MemberState r0 = com.sendbird.android.Member.MemberState.JOINED     // Catch:{ all -> 0x044f }
            r8.mMyMemberState = r0     // Catch:{ all -> 0x044f }
        L_0x03ae:
            com.sendbird.android.Member$Role r0 = com.sendbird.android.Member.Role.NONE     // Catch:{ all -> 0x044f }
            r8.mMyRole = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "my_role"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x03ca
            java.lang.String r0 = "my_role"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x044f }
            com.sendbird.android.Member$Role r0 = com.sendbird.android.Member.Role.fromValue(r0)     // Catch:{ all -> 0x044f }
            r8.mMyRole = r0     // Catch:{ all -> 0x044f }
        L_0x03ca:
            com.sendbird.android.Member$MutedState r0 = com.sendbird.android.Member.MutedState.UNMUTED     // Catch:{ all -> 0x044f }
            r8.mMyMutedState = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "is_muted"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x03e9
            java.lang.String r0 = "is_muted"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x03e5
            com.sendbird.android.Member$MutedState r0 = com.sendbird.android.Member.MutedState.MUTED     // Catch:{ all -> 0x044f }
            goto L_0x03e7
        L_0x03e5:
            com.sendbird.android.Member$MutedState r0 = com.sendbird.android.Member.MutedState.UNMUTED     // Catch:{ all -> 0x044f }
        L_0x03e7:
            r8.mMyMutedState = r0     // Catch:{ all -> 0x044f }
        L_0x03e9:
            java.lang.String r0 = "user_last_read"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            r2 = 0
            if (r0 == 0) goto L_0x0408
            java.lang.String r0 = "user_last_read"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            long r4 = r0.getAsLong()     // Catch:{ all -> 0x044f }
            long r6 = r8.mMyLastRead     // Catch:{ all -> 0x044f }
            long r4 = java.lang.Math.max(r6, r4)     // Catch:{ all -> 0x044f }
            r8.mMyLastRead = r4     // Catch:{ all -> 0x044f }
            goto L_0x040a
        L_0x0408:
            r8.mMyLastRead = r2     // Catch:{ all -> 0x044f }
        L_0x040a:
            r8.mMemberCountUpdatedAt = r2     // Catch:{ all -> 0x044f }
            r8.parseMessageOffset(r9)     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "message_survival_seconds"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x0422
            java.lang.String r0 = "message_survival_seconds"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x044f }
            goto L_0x0423
        L_0x0422:
            r0 = -1
        L_0x0423:
            r8.messageSurvivalSeconds = r0     // Catch:{ all -> 0x044f }
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong     // Catch:{ all -> 0x044f }
            r0.<init>(r2)     // Catch:{ all -> 0x044f }
            r8.memberRoleUpdatedAt = r0     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "created_by"
            boolean r0 = r9.has(r0)     // Catch:{ all -> 0x044f }
            if (r0 == 0) goto L_0x044b
            java.lang.String r0 = "created_by"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ all -> 0x044f }
            boolean r0 = r0.isJsonNull()     // Catch:{ all -> 0x044f }
            if (r0 != 0) goto L_0x044b
            com.sendbird.android.User r1 = new com.sendbird.android.User     // Catch:{ all -> 0x044f }
            java.lang.String r0 = "created_by"
            com.sendbird.android.shadow.com.google.gson.JsonElement r9 = r9.get(r0)     // Catch:{ all -> 0x044f }
            r1.<init>(r9)     // Catch:{ all -> 0x044f }
        L_0x044b:
            r8.createdBy = r1     // Catch:{ all -> 0x044f }
            monitor-exit(r8)
            return
        L_0x044f:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannel.parse(com.sendbird.android.shadow.com.google.gson.JsonElement):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized JsonElement toJson() {
        JsonObject asJsonObject;
        asJsonObject = super.toJson().getAsJsonObject();
        asJsonObject.addProperty(StringSet.channel_type, BaseChannel.ChannelType.GROUP.value());
        asJsonObject.addProperty("is_super", Boolean.valueOf(this.mIsSuper));
        asJsonObject.addProperty("is_public", Boolean.valueOf(this.mIsPublic));
        asJsonObject.addProperty("is_distinct", Boolean.valueOf(this.mIsDistinct));
        asJsonObject.addProperty("is_access_code_required", Boolean.valueOf(this.mIsAccessCodeRequired));
        asJsonObject.addProperty("unread_message_count", (Number) Integer.valueOf(this.mUnreadMessageCount));
        asJsonObject.addProperty("unread_mention_count", (Number) Integer.valueOf(this.mUnreadMentionCount));
        asJsonObject.addProperty("member_count", (Number) Integer.valueOf(this.mMemberCount));
        asJsonObject.addProperty("joined_member_count", (Number) Integer.valueOf(this.mJoinedMemberCount));
        asJsonObject.addProperty("invited_at", (Number) Long.valueOf(this.mInvitedAt));
        asJsonObject.addProperty("is_push_enabled", Boolean.valueOf(this.mIsPushEnabled));
        asJsonObject.addProperty("user_last_read", (Number) Long.valueOf(this.mMyLastRead));
        asJsonObject.addProperty("is_broadcast", Boolean.valueOf(this.isBroadcast));
        if (this.mMyCountPreference == CountPreference.ALL) {
            asJsonObject.addProperty("count_preference", StringSet.all);
        } else if (this.mMyCountPreference == CountPreference.UNREAD_MESSAGE_COUNT_ONLY) {
            asJsonObject.addProperty("count_preference", "unread_message_count_only");
        } else if (this.mMyCountPreference == CountPreference.UNREAD_MENTION_COUNT_ONLY) {
            asJsonObject.addProperty("count_preference", "unread_mention_count_only");
        } else if (this.mMyCountPreference == CountPreference.OFF) {
            asJsonObject.addProperty("count_preference", StringSet.off);
        }
        asJsonObject.addProperty("is_hidden", Boolean.valueOf(this.mIsHidden));
        if (this.mHiddenState == HiddenState.UNHIDDEN) {
            asJsonObject.addProperty("hidden_state", StringSet.unhidden);
        } else if (this.mHiddenState == HiddenState.HIDDEN_ALLOW_AUTO_UNHIDE) {
            asJsonObject.addProperty("hidden_state", StringSet.hidden_allow_auto_unhide);
        } else if (this.mHiddenState == HiddenState.HIDDEN_PREVENT_AUTO_UNHIDE) {
            asJsonObject.addProperty("hidden_state", StringSet.hidden_prevent_auto_unhide);
        }
        if (this.mMyPushTriggerOption == PushTriggerOption.ALL) {
            asJsonObject.addProperty(StringSet.push_trigger_option, StringSet.all);
        } else if (this.mMyPushTriggerOption == PushTriggerOption.OFF) {
            asJsonObject.addProperty(StringSet.push_trigger_option, StringSet.off);
        } else if (this.mMyPushTriggerOption == PushTriggerOption.MENTION_ONLY) {
            asJsonObject.addProperty(StringSet.push_trigger_option, StringSet.mention_only);
        } else if (this.mMyPushTriggerOption == PushTriggerOption.DEFAULT) {
            asJsonObject.addProperty(StringSet.push_trigger_option, "default");
        }
        if (this.mCustomType != null) {
            asJsonObject.addProperty(StringSet.custom_type, this.mCustomType);
        }
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry next : this.mCachedReadReceiptStatus.entrySet()) {
            jsonObject.addProperty((String) next.getKey(), (Number) next.getValue());
        }
        asJsonObject.add("read_receipt", jsonObject);
        if (this.mCachedDeliveryReceipt != null && this.mCachedDeliveryReceipt.size() > 0) {
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry next2 : this.mCachedDeliveryReceipt.entrySet()) {
                jsonObject2.addProperty((String) next2.getKey(), (Number) next2.getValue());
            }
            asJsonObject.add("delivery_receipt", jsonObject2);
        }
        if (this.mMembers != null) {
            JsonArray jsonArray = new JsonArray();
            for (Member json : this.mMembers) {
                jsonArray.add(json.toJson());
            }
            asJsonObject.add("members", jsonArray);
        }
        if (this.mLastMessage != null) {
            asJsonObject.add("last_message", this.mLastMessage.toJson());
        }
        if (this.mInviter != null) {
            asJsonObject.add("inviter", this.mInviter.toJson());
        }
        if (this.mMyMemberState == Member.MemberState.NONE) {
            asJsonObject.addProperty(StringSet.member_state, "none");
        } else if (this.mMyMemberState == Member.MemberState.INVITED) {
            asJsonObject.addProperty(StringSet.member_state, "invited");
        } else if (this.mMyMemberState == Member.MemberState.JOINED) {
            asJsonObject.addProperty(StringSet.member_state, StringSet.joined);
        }
        asJsonObject.addProperty("my_role", this.mMyRole.getValue());
        if (this.mMyMutedState == Member.MutedState.UNMUTED) {
            asJsonObject.addProperty(StringSet.is_muted, "false");
        } else if (this.mMyMutedState == Member.MutedState.MUTED) {
            asJsonObject.addProperty(StringSet.is_muted, "true");
        }
        asJsonObject.addProperty("ts_message_offset", (Number) Long.valueOf(this.mMessageOffsetTimestamp));
        asJsonObject.addProperty(StringSet.message_survival_seconds, (Number) Integer.valueOf(this.messageSurvivalSeconds));
        if (this.createdBy != null) {
            asJsonObject.add(StringSet.created_by, this.createdBy.toJson());
        }
        return asJsonObject;
    }

    public final BaseMessage getLastMessage() {
        return this.mLastMessage;
    }

    /* access modifiers changed from: protected */
    public final synchronized void setLastMessage(BaseMessage baseMessage) {
        this.mLastMessage = baseMessage;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean setLastMessageByCreatedAt(BaseMessage baseMessage) {
        if (getLastMessage() != null && getLastMessage().getCreatedAt() >= baseMessage.getCreatedAt()) {
            return false;
        }
        setLastMessage(baseMessage);
        return true;
    }

    public final User getInviter() {
        return this.mInviter;
    }

    public final int getUnreadMessageCount() {
        return this.mUnreadMessageCount;
    }

    /* access modifiers changed from: protected */
    public final synchronized void setUnreadMessageCount(int i2) {
        if (!isMyUnreadMessageCountEnabled()) {
            this.mUnreadMessageCount = 0;
        } else if (isSuper()) {
            this.mUnreadMessageCount = Math.min(SendBird.getMaxUnreadMessageCountOnSuperGroup(), i2);
        } else {
            this.mUnreadMessageCount = i2;
        }
    }

    public final int getUnreadMentionCount() {
        return this.mUnreadMentionCount;
    }

    /* access modifiers changed from: protected */
    public final synchronized void setUnreadMentionCount(int i2) {
        if (isMyUnreadMentionCountEnabled()) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.mUnreadMentionCount = i2;
            return;
        }
        this.mUnreadMentionCount = 0;
    }

    public final List<Member> getMembers() {
        return Arrays.asList(this.mMembers.toArray(new Member[0]));
    }

    public final int getMemberCount() {
        return this.mMemberCount;
    }

    public final int getJoinedMemberCount() {
        return this.mJoinedMemberCount;
    }

    public final long getInvitedAt() {
        return this.mInvitedAt;
    }

    /* access modifiers changed from: package-private */
    public final void setInvitedAt(long j) {
        this.mInvitedAt = j;
    }

    public final boolean isSuper() {
        return this.mIsSuper;
    }

    public final boolean isPublic() {
        return this.mIsPublic;
    }

    public final boolean isDistinct() {
        return this.mIsDistinct;
    }

    public final boolean isDiscoverable() {
        return this.mIsDiscoverable;
    }

    public final boolean isPushEnabled() {
        return this.mIsPushEnabled;
    }

    public final PushTriggerOption getMyPushTriggerOption() {
        return this.mMyPushTriggerOption;
    }

    public final boolean isAccessCodeRequired() {
        return this.mIsAccessCodeRequired;
    }

    public final CountPreference getMyCountPreference() {
        return this.mMyCountPreference;
    }

    /* access modifiers changed from: package-private */
    public final boolean isMyUnreadMessageCountEnabled() {
        return this.mMyCountPreference == CountPreference.ALL || this.mMyCountPreference == CountPreference.UNREAD_MESSAGE_COUNT_ONLY;
    }

    /* access modifiers changed from: package-private */
    public final boolean isMyUnreadMentionCountEnabled() {
        return this.mMyCountPreference == CountPreference.ALL || this.mMyCountPreference == CountPreference.UNREAD_MENTION_COUNT_ONLY;
    }

    public final boolean isHidden() {
        return this.mIsHidden;
    }

    private void setIsHidden(boolean z) {
        this.mIsHidden = z;
    }

    public final HiddenState getHiddenState() {
        return this.mHiddenState;
    }

    /* access modifiers changed from: package-private */
    public final void setHiddenState(HiddenState hiddenState) {
        this.mHiddenState = hiddenState;
        if (hiddenState == HiddenState.UNHIDDEN) {
            setIsHidden(false);
        } else if (hiddenState == HiddenState.HIDDEN_ALLOW_AUTO_UNHIDE) {
            setIsHidden(true);
        } else if (hiddenState == HiddenState.HIDDEN_PREVENT_AUTO_UNHIDE) {
            setIsHidden(true);
        }
    }

    public final long getMessageOffsetTimestamp() {
        return this.mMessageOffsetTimestamp;
    }

    /* access modifiers changed from: package-private */
    public final void parseMessageOffset(JsonElement jsonElement) {
        if (jsonElement.getAsJsonObject().has("ts_message_offset")) {
            setMessageOffsetTimestamp(jsonElement.getAsJsonObject().get("ts_message_offset").getAsLong());
        }
    }

    private void setMessageOffsetTimestamp(long j) {
        this.mMessageOffsetTimestamp = j;
    }

    public final boolean isBroadcast() {
        return this.isBroadcast;
    }

    public final void updateChannel(String str, Object obj, String str2, GroupChannelUpdateHandler groupChannelUpdateHandler) throws ClassCastException {
        updateChannel(isDistinct(), str, obj, str2, groupChannelUpdateHandler);
    }

    @Deprecated
    public final void updateChannel(boolean z, String str, Object obj, String str2, GroupChannelUpdateHandler groupChannelUpdateHandler) throws ClassCastException {
        updateChannel(z, str, obj, str2, (String) null, groupChannelUpdateHandler);
    }

    public final void updateChannel(boolean z, String str, Object obj, String str2, String str3, GroupChannelUpdateHandler groupChannelUpdateHandler) throws ClassCastException {
        localUpdateChannel((Boolean) null, (Boolean) null, Boolean.valueOf(z), (Boolean) null, str, obj, str2, str3, (String) null, (Boolean) null, (Integer) null, (List<String>) null, groupChannelUpdateHandler);
    }

    public final void updateChannel(GroupChannelParams groupChannelParams, GroupChannelUpdateHandler groupChannelUpdateHandler) throws ClassCastException {
        GroupChannelParams groupChannelParams2 = groupChannelParams;
        final GroupChannelUpdateHandler groupChannelUpdateHandler2 = groupChannelUpdateHandler;
        if (groupChannelParams2 != null) {
            localUpdateChannel(groupChannelParams2.mIsPublic, (Boolean) null, groupChannelParams2.mIsDistinct, groupChannelParams2.mIsDiscoverable, groupChannelParams2.mName, groupChannelParams2.mCoverUrlOrImage, groupChannelParams2.mData, groupChannelParams2.mCustomType, groupChannelParams2.mAccessCode, groupChannelParams2.mStrict, groupChannelParams2.messageSurvivalSeconds, groupChannelParams2.mOperatorUserIds, groupChannelUpdateHandler);
        } else if (groupChannelUpdateHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelUpdateHandler2.onResult((GroupChannel) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    private void localUpdateChannel(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str, Object obj, String str2, String str3, String str4, Boolean bool5, Integer num, List<String> list, GroupChannelUpdateHandler groupChannelUpdateHandler) throws ClassCastException {
        Object obj2 = obj;
        if ((obj2 instanceof String) || (obj2 instanceof File) || obj2 == null) {
            final Object obj3 = obj;
            final Boolean bool6 = bool;
            final Boolean bool7 = bool2;
            final Boolean bool8 = bool3;
            final Boolean bool9 = bool4;
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            final Boolean bool10 = bool5;
            final Integer num2 = num;
            final List<String> list2 = list;
            final GroupChannelUpdateHandler groupChannelUpdateHandler2 = groupChannelUpdateHandler;
            d.a(new q<GroupChannel>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    GroupChannel groupChannel = (GroupChannel) obj;
                    GroupChannelUpdateHandler groupChannelUpdateHandler = groupChannelUpdateHandler2;
                    if (groupChannelUpdateHandler != null) {
                        groupChannelUpdateHandler.onResult(groupChannel, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    JsonElement jsonElement;
                    Object obj;
                    Object obj2;
                    Object obj3 = obj3;
                    if ((obj3 instanceof String) || obj3 == null) {
                        String str = StringSet.operator_ids;
                        String str2 = StringSet.message_survival_seconds;
                        String str3 = StringSet.custom_type;
                        APIClient a2 = APIClient.a();
                        String url = GroupChannel.this.getUrl();
                        Boolean bool = bool6;
                        Boolean bool2 = bool7;
                        APIClient aPIClient = a2;
                        Boolean bool3 = bool8;
                        String str4 = str;
                        Boolean bool4 = bool9;
                        String str5 = str2;
                        String str6 = str5;
                        String str7 = "strict";
                        String str8 = (String) obj3;
                        String str9 = "access_code";
                        String str10 = str6;
                        String str11 = str3;
                        String str12 = str7;
                        String str13 = str8;
                        Boolean bool5 = bool10;
                        Integer num = num2;
                        List<String> list = list2;
                        String format = String.format(b.GROUPCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                        JsonObject e2 = APIClient.e();
                        if (bool != null) {
                            e2.addProperty("is_public", bool);
                        }
                        if (bool2 != null) {
                            e2.addProperty("is_ephemeral", bool2);
                        }
                        if (bool3 != null) {
                            e2.addProperty("is_distinct", bool3);
                        }
                        if (bool4 != null) {
                            e2.addProperty("is_discoverable", bool4);
                        }
                        if (str6 != null) {
                            e2.addProperty("name", str6);
                        }
                        if (str8 != null) {
                            e2.addProperty("cover_url", str8);
                        }
                        if (str10 != null) {
                            e2.addProperty("data", str10);
                        }
                        if (str12 != null) {
                            e2.addProperty(str11, str12);
                        }
                        if (str13 != null) {
                            e2.addProperty(str9, str13);
                        }
                        if (bool5 != null) {
                            e2.addProperty(str7, bool5);
                        }
                        if (num != null) {
                            e2.addProperty(str5, (Number) num);
                        }
                        if (list != null) {
                            JsonArray jsonArray = new JsonArray();
                            for (String add : list) {
                                jsonArray.add(add);
                            }
                            e2.add(str4, jsonArray);
                        }
                        jsonElement = aPIClient.b(format, e2);
                    } else {
                        APIClient a3 = APIClient.a();
                        String url2 = GroupChannel.this.getUrl();
                        Boolean bool6 = bool6;
                        Boolean bool7 = bool7;
                        APIClient aPIClient2 = a3;
                        Boolean bool8 = bool8;
                        Object obj4 = StringSet.operator_ids;
                        Boolean bool9 = bool9;
                        Object obj5 = StringSet.message_survival_seconds;
                        String str14 = str5;
                        Object obj6 = "strict";
                        File file = (File) obj3;
                        Object obj7 = "access_code";
                        String str15 = str6;
                        Object obj8 = StringSet.custom_type;
                        String str16 = str7;
                        String str17 = str8;
                        Boolean bool10 = bool10;
                        Integer num2 = num2;
                        List list2 = list2;
                        String format2 = String.format(b.GROUPCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(url2)});
                        HashMap hashMap = new HashMap();
                        String str18 = null;
                        if (bool6 != null) {
                            hashMap.put("is_public", bool6.booleanValue() ? "true" : "false");
                        }
                        if (bool7 != null) {
                            hashMap.put("is_ephemeral", bool7.booleanValue() ? "true" : "false");
                        }
                        if (bool8 != null) {
                            hashMap.put("is_distinct", bool8.booleanValue() ? "true" : "false");
                        }
                        if (bool9 != null) {
                            hashMap.put("is_discoverable", bool9.booleanValue() ? "true" : "false");
                        }
                        if (str14 != null) {
                            hashMap.put("name", str14);
                        }
                        if (file != null) {
                            str18 = "cover_file";
                        }
                        if (str15 != null) {
                            hashMap.put("data", str15);
                        }
                        if (str16 != null) {
                            hashMap.put(obj8, str16);
                        }
                        if (str17 != null) {
                            hashMap.put(obj7, str17);
                        }
                        if (bool10 != null) {
                            if (bool10.booleanValue()) {
                                obj2 = "true";
                                obj = obj6;
                            } else {
                                obj = obj6;
                                obj2 = "false";
                            }
                            hashMap.put(obj, obj2);
                        }
                        if (num2 != null) {
                            hashMap.put(obj5, num2.toString());
                        }
                        if (list2 != null) {
                            hashMap.put(obj4, b.urlEncodeUTF8((Collection<String>) list2));
                        }
                        jsonElement = aPIClient2.b(format2, hashMap, str18, file);
                    }
                    return GroupChannel.upsert(jsonElement, false);
                }
            });
            return;
        }
        throw new ClassCastException();
    }

    public final void invite(User user, final GroupChannelInviteHandler groupChannelInviteHandler) {
        if (user != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(user.getUserId());
            inviteWithUserIds(arrayList, groupChannelInviteHandler);
        } else if (groupChannelInviteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelInviteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void invite(List<User> list, final GroupChannelInviteHandler groupChannelInviteHandler) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
            inviteWithUserIds(arrayList, groupChannelInviteHandler);
        } else if (groupChannelInviteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelInviteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void inviteWithUserId(String str, final GroupChannelInviteHandler groupChannelInviteHandler) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            inviteWithUserIds(arrayList, groupChannelInviteHandler);
        } else if (groupChannelInviteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelInviteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void inviteWithUserIds(final List<String> list, final GroupChannelInviteHandler groupChannelInviteHandler) {
        d.a(new q<GroupChannel>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelInviteHandler groupChannelInviteHandler = groupChannelInviteHandler;
                if (groupChannelInviteHandler != null) {
                    groupChannelInviteHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                List list = list;
                if (list != null) {
                    return GroupChannel.upsert(APIClient.a().a(GroupChannel.this.getUrl(), (List<String>) new ArrayList(new LinkedHashSet(list))), false);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void join(GroupChannelJoinHandler groupChannelJoinHandler) {
        join((String) null, groupChannelJoinHandler);
    }

    public final void join(final String str, final GroupChannelJoinHandler groupChannelJoinHandler) {
        d.a(new q<GroupChannel>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelJoinHandler groupChannelJoinHandler = groupChannelJoinHandler;
                if (groupChannelJoinHandler != null) {
                    groupChannelJoinHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                String str = str;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.GROUPCHANNELS_CHANNELURL_JOIN.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    if (str != null) {
                        e2.addProperty("access_code", str);
                    }
                    return GroupChannel.upsert(a2.b(format, e2), false);
                }
                throw u.b();
            }
        });
    }

    public final void hide(GroupChannelHideHandler groupChannelHideHandler) {
        hide(false, groupChannelHideHandler);
    }

    public final void hide(boolean z, GroupChannelHideHandler groupChannelHideHandler) {
        hide(z, true, groupChannelHideHandler);
    }

    public final void hide(final boolean z, final boolean z2, final GroupChannelHideHandler groupChannelHideHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelHideHandler groupChannelHideHandler = groupChannelHideHandler;
                if (groupChannelHideHandler != null) {
                    groupChannelHideHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                boolean z = z;
                boolean z2 = z2;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.GROUPCHANNELS_CHANNELURL_HIDE.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    e2.addProperty("hide_previous_messages", Boolean.valueOf(z));
                    e2.addProperty("allow_auto_unhide", Boolean.valueOf(z2));
                    JsonElement b2 = a2.b(format, e2);
                    if (z2) {
                        GroupChannel.this.setHiddenState(HiddenState.HIDDEN_ALLOW_AUTO_UNHIDE);
                    } else {
                        GroupChannel.this.setHiddenState(HiddenState.HIDDEN_PREVENT_AUTO_UNHIDE);
                    }
                    if (z) {
                        GroupChannel.this.setUnreadMessageCount(0);
                        GroupChannel.this.setUnreadMentionCount(0);
                        GroupChannel.this.parseMessageOffset(b2);
                    }
                    return b2;
                }
                throw u.b();
            }
        });
    }

    public final void unhide(final GroupChannelUnhideHandler groupChannelUnhideHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelUnhideHandler groupChannelUnhideHandler = groupChannelUnhideHandler;
                if (groupChannelUnhideHandler != null) {
                    groupChannelUnhideHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.GROUPCHANNELS_CHANNELURL_HIDE.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    return a2.a(format, (Map<String, Collection<String>>) null, (JsonElement) e2);
                }
                throw u.b();
            }
        });
    }

    public final void leave(final GroupChannelLeaveHandler groupChannelLeaveHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelLeaveHandler groupChannelLeaveHandler = groupChannelLeaveHandler;
                if (groupChannelLeaveHandler != null) {
                    groupChannelLeaveHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.GROUPCHANNELS_CHANNELURL_LEAVE.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    return a2.b(format, e2);
                }
                throw u.b();
            }
        });
    }

    public final void acceptInvitation(GroupChannelAcceptInvitationHandler groupChannelAcceptInvitationHandler) {
        acceptInvitation((String) null, groupChannelAcceptInvitationHandler);
    }

    public final void acceptInvitation(final String str, final GroupChannelAcceptInvitationHandler groupChannelAcceptInvitationHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelAcceptInvitationHandler groupChannelAcceptInvitationHandler = groupChannelAcceptInvitationHandler;
                if (groupChannelAcceptInvitationHandler != null) {
                    groupChannelAcceptInvitationHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                String str = str;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.GROUPCHANNELS_CHANNELURL_ACCEPT.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    if (str != null) {
                        e2.addProperty("access_code", str);
                    }
                    return a2.b(format, e2);
                }
                throw u.b();
            }
        });
    }

    public final void declineInvitation(final GroupChannelDeclineInvitationHandler groupChannelDeclineInvitationHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelDeclineInvitationHandler groupChannelDeclineInvitationHandler = groupChannelDeclineInvitationHandler;
                if (groupChannelDeclineInvitationHandler != null) {
                    groupChannelDeclineInvitationHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.GROUPCHANNELS_CHANNELURL_DECLINE.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    return a2.b(format, e2);
                }
                throw u.b();
            }
        });
    }

    public final void setPushPreference(final boolean z, final GroupChannelSetPushPreferenceHandler groupChannelSetPushPreferenceHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelSetPushPreferenceHandler groupChannelSetPushPreferenceHandler = groupChannelSetPushPreferenceHandler;
                if (groupChannelSetPushPreferenceHandler != null) {
                    groupChannelSetPushPreferenceHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                boolean z = z;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_PUSHPREFERENCE_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("enable", Boolean.valueOf(z));
                    JsonElement b2 = a2.b(format, e2);
                    boolean unused = GroupChannel.this.mIsPushEnabled = z;
                    if (!z) {
                        PushTriggerOption unused2 = GroupChannel.this.mMyPushTriggerOption = PushTriggerOption.OFF;
                    }
                    return b2;
                }
                throw u.b();
            }
        });
    }

    @Deprecated
    public final void getPushPreference(final GroupChannelGetPushPreferenceHandler groupChannelGetPushPreferenceHandler) {
        d.a(new q<Boolean>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Boolean bool = (Boolean) obj;
                GroupChannelGetPushPreferenceHandler groupChannelGetPushPreferenceHandler = groupChannelGetPushPreferenceHandler;
                if (groupChannelGetPushPreferenceHandler != null) {
                    groupChannelGetPushPreferenceHandler.onResult(bool != null ? bool.booleanValue() : false, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                if (SendBird.getCurrentUser() != null) {
                    return Boolean.valueOf(a2.a(String.format(b.USERS_USERID_PUSHPREFERENCE_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(url)}), (Map<String, String>) null, (Map<String, Collection<String>>) null).getAsJsonObject().get("enable").getAsBoolean());
                }
                throw u.b();
            }
        });
    }

    public final void setMyPushTriggerOption(final PushTriggerOption pushTriggerOption, final GroupChannelSetMyPushTriggerOptionHandler groupChannelSetMyPushTriggerOptionHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelSetMyPushTriggerOptionHandler groupChannelSetMyPushTriggerOptionHandler = groupChannelSetMyPushTriggerOptionHandler;
                if (groupChannelSetMyPushTriggerOptionHandler != null) {
                    groupChannelSetMyPushTriggerOptionHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                PushTriggerOption pushTriggerOption = pushTriggerOption;
                if (SendBird.getCurrentUser() != null) {
                    JsonObject e2 = APIClient.e();
                    if (pushTriggerOption == PushTriggerOption.ALL) {
                        e2.addProperty(StringSet.push_trigger_option, StringSet.all);
                    } else if (pushTriggerOption == PushTriggerOption.OFF) {
                        e2.addProperty(StringSet.push_trigger_option, StringSet.off);
                    } else if (pushTriggerOption == PushTriggerOption.MENTION_ONLY) {
                        e2.addProperty(StringSet.push_trigger_option, StringSet.mention_only);
                    } else if (pushTriggerOption == PushTriggerOption.DEFAULT) {
                        e2.addProperty(StringSet.push_trigger_option, "default");
                    }
                    JsonElement b2 = a2.b(String.format(b.USERS_USERID_PUSHPREFERENCE_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(url)}), e2);
                    PushTriggerOption unused = GroupChannel.this.mMyPushTriggerOption = pushTriggerOption;
                    return b2;
                }
                throw u.b();
            }
        });
    }

    public final void getMyPushTriggerOption(final GroupChannelGetMyPushTriggerOptionHandler groupChannelGetMyPushTriggerOptionHandler) {
        d.a(new q<PushTriggerOption>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                PushTriggerOption pushTriggerOption = (PushTriggerOption) obj;
                GroupChannelGetMyPushTriggerOptionHandler groupChannelGetMyPushTriggerOptionHandler = groupChannelGetMyPushTriggerOptionHandler;
                if (groupChannelGetMyPushTriggerOptionHandler != null) {
                    groupChannelGetMyPushTriggerOptionHandler.onResult(pushTriggerOption, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                if (SendBird.getCurrentUser() != null) {
                    JsonElement a3 = a2.a(String.format(b.USERS_USERID_PUSHPREFERENCE_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(url)}), (Map<String, String>) null, (Map<String, Collection<String>>) null);
                    if (a3.getAsJsonObject().has(StringSet.push_trigger_option)) {
                        String asString = a3.getAsJsonObject().get(StringSet.push_trigger_option).isJsonNull() ? "default" : a3.getAsJsonObject().get(StringSet.push_trigger_option).getAsString();
                        if (asString.equals(StringSet.all)) {
                            PushTriggerOption unused = GroupChannel.this.mMyPushTriggerOption = PushTriggerOption.ALL;
                        } else if (asString.equals(StringSet.off)) {
                            PushTriggerOption unused2 = GroupChannel.this.mMyPushTriggerOption = PushTriggerOption.OFF;
                        } else if (asString.equals(StringSet.mention_only)) {
                            PushTriggerOption unused3 = GroupChannel.this.mMyPushTriggerOption = PushTriggerOption.MENTION_ONLY;
                        } else if (asString.equals("default")) {
                            PushTriggerOption unused4 = GroupChannel.this.mMyPushTriggerOption = PushTriggerOption.DEFAULT;
                        } else {
                            PushTriggerOption unused5 = GroupChannel.this.mMyPushTriggerOption = PushTriggerOption.DEFAULT;
                        }
                    }
                    return GroupChannel.this.mMyPushTriggerOption;
                }
                throw u.b();
            }
        });
    }

    public final void setMyCountPreference(final CountPreference countPreference, final GroupChannelSetMyCountPreferenceHandler groupChannelSetMyCountPreferenceHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelSetMyCountPreferenceHandler groupChannelSetMyCountPreferenceHandler = groupChannelSetMyCountPreferenceHandler;
                if (groupChannelSetMyCountPreferenceHandler != null) {
                    groupChannelSetMyCountPreferenceHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String asString;
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                CountPreference countPreference = countPreference;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_COUNTPREFERENCE_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(url)});
                    JsonObject e2 = APIClient.e();
                    if (countPreference != null) {
                        if (countPreference == CountPreference.ALL) {
                            e2.addProperty("count_preference", StringSet.all);
                        } else if (countPreference == CountPreference.UNREAD_MESSAGE_COUNT_ONLY) {
                            e2.addProperty("count_preference", "unread_message_count_only");
                        } else if (countPreference == CountPreference.UNREAD_MENTION_COUNT_ONLY) {
                            e2.addProperty("count_preference", "unread_mention_count_only");
                        } else if (countPreference == CountPreference.OFF) {
                            e2.addProperty("count_preference", StringSet.off);
                        }
                    }
                    JsonElement b2 = a2.b(format, e2);
                    if (b2.getAsJsonObject().has("count_preference") && (asString = b2.getAsJsonObject().get("count_preference").getAsString()) != null) {
                        if (asString.equals(StringSet.all)) {
                            CountPreference unused = GroupChannel.this.mMyCountPreference = CountPreference.ALL;
                        } else if (asString.equals("unread_message_count_only")) {
                            CountPreference unused2 = GroupChannel.this.mMyCountPreference = CountPreference.UNREAD_MESSAGE_COUNT_ONLY;
                        } else if (asString.equals("unread_mention_count_only")) {
                            CountPreference unused3 = GroupChannel.this.mMyCountPreference = CountPreference.UNREAD_MENTION_COUNT_ONLY;
                        } else if (asString.equals(StringSet.off)) {
                            CountPreference unused4 = GroupChannel.this.mMyCountPreference = CountPreference.OFF;
                        }
                    }
                    if (!GroupChannel.this.isMyUnreadMessageCountEnabled()) {
                        GroupChannel.this.setUnreadMessageCount(0);
                    }
                    if (!GroupChannel.this.isMyUnreadMentionCountEnabled()) {
                        GroupChannel.this.setUnreadMentionCount(0);
                    }
                    return b2;
                }
                throw u.b();
            }
        });
    }

    @Deprecated
    public static void markAsReadAll(final GroupChannelMarkAsReadHandler groupChannelMarkAsReadHandler) {
        localMarkAsReadAll((List<String>) null, new SendBird.MarkAsReadHandler() {
            public final void onResult(SendBirdException sendBirdException) {
                GroupChannelMarkAsReadHandler groupChannelMarkAsReadHandler = groupChannelMarkAsReadHandler;
                if (groupChannelMarkAsReadHandler != null) {
                    groupChannelMarkAsReadHandler.onResult(sendBirdException);
                }
            }
        });
    }

    static void localMarkAsReadAll(final List<String> list, final SendBird.MarkAsReadHandler markAsReadHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                SendBird.MarkAsReadHandler markAsReadHandler = markAsReadHandler;
                if (markAsReadHandler != null) {
                    markAsReadHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (System.currentTimeMillis() - GroupChannel.sMarkAsReadAllLastSentAt >= 1000) {
                    long unused = GroupChannel.sMarkAsReadAllLastSentAt = System.currentTimeMillis();
                    APIClient a2 = APIClient.a();
                    List<String> list = list;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_MARKASREADALL.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        JsonObject e2 = APIClient.e();
                        if (list != null) {
                            JsonArray jsonArray = new JsonArray();
                            for (String add : list) {
                                jsonArray.add(add);
                            }
                            e2.add(StringSet.channel_urls, jsonArray);
                        }
                        JsonElement b2 = a2.b(format, e2);
                        List<String> list2 = list;
                        if (list2 == null) {
                            for (GroupChannel next : GroupChannel.sCachedChannels.values()) {
                                next.setUnreadMessageCount(0);
                                next.setUnreadMentionCount(0);
                            }
                        } else {
                            for (String str : list2) {
                                GroupChannel groupChannel = GroupChannel.sCachedChannels.get(str);
                                if (groupChannel != null) {
                                    groupChannel.setUnreadMessageCount(0);
                                    groupChannel.setUnreadMentionCount(0);
                                }
                            }
                        }
                        return b2;
                    }
                    throw u.b();
                }
                throw new SendBirdException("MarkAsRead rate limit exceeded.", SendBirdError.ERR_MARK_AS_READ_RATE_LIMIT_EXCEEDED);
            }
        });
    }

    static void localMarkAsReadWithChannelUrls(List<String> list, final SendBird.MarkAsReadHandler markAsReadHandler) {
        if (list != null) {
            localMarkAsReadAll(list, markAsReadHandler);
        } else if (markAsReadHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    markAsReadHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void sendMarkAsRead(final GroupChannelMarkAsReadHandler groupChannelMarkAsReadHandler) {
        u.a().a(Command.a(getUrl()), true, (Command.SendCommandHandler) new Command.SendCommandHandler() {
            public final void onResult(Command command, SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    GroupChannelMarkAsReadHandler groupChannelMarkAsReadHandler = groupChannelMarkAsReadHandler;
                    if (groupChannelMarkAsReadHandler != null) {
                        groupChannelMarkAsReadHandler.onResult(sendBirdException);
                        return;
                    }
                    return;
                }
                if (SendBird.getCurrentUser() != null) {
                    JsonObject asJsonObject = command.c().getAsJsonObject();
                    if (asJsonObject.has(StringSet.ts)) {
                        GroupChannel.this.updateReadReceipt(SendBird.getCurrentUser().getUserId(), asJsonObject.get(StringSet.ts).getAsLong());
                    }
                }
                if (GroupChannel.this.mUnreadMessageCount > 0) {
                    GroupChannel.this.setUnreadMessageCount(0);
                    GroupChannel.this.setUnreadMentionCount(0);
                    k.a.f44826a.a((BaseChannel) GroupChannel.this);
                }
                GroupChannelMarkAsReadHandler groupChannelMarkAsReadHandler2 = groupChannelMarkAsReadHandler;
                if (groupChannelMarkAsReadHandler2 != null) {
                    groupChannelMarkAsReadHandler2.onResult((SendBirdException) null);
                }
            }
        });
    }

    public final void markAsDelivered() {
        markAsDelivered(0, 0);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void markAsDelivered(long j, long j2) {
        Logger.d("++ request data msgId : " + j + ", createdAt : " + j2);
        a aVar = new a(j, j2);
        if (this.rateLimitScheduler == null) {
            this.rateLimitScheduler = new TimeoutScheduler(1000, 1000, false, new TimeoutScheduler.TimeoutEventhandler() {
                public final void onTimeout(Object obj) {
                    Logger.d("++ onTimeout() request Delivery receipt");
                    a aVar = (a) obj;
                    Logger.d("++ data : ".concat(String.valueOf(aVar)));
                    try {
                        APIClient a2 = APIClient.a();
                        String url = GroupChannel.this.getUrl();
                        long j = aVar.f44373a;
                        long j2 = aVar.f44374b;
                        String format = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES_MARKASDELIVERED.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                        JsonObject e2 = APIClient.e();
                        if (SendBird.getCurrentUser() != null) {
                            e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                        }
                        if (j > 0) {
                            e2.addProperty(StringSet.msg_id, (Number) Long.valueOf(j));
                        }
                        if (j2 > 0) {
                            e2.addProperty(StringSet.ts, (Number) Long.valueOf(j2));
                        }
                        JsonElement b2 = a2.b(format, e2);
                        Logger.d("++ mark as delivered response : ".concat(String.valueOf(b2)));
                        if (SendBird.getCurrentUser() != null) {
                            JsonObject asJsonObject = b2.getAsJsonObject();
                            if (asJsonObject.has(StringSet.ts)) {
                                GroupChannel.this.updateDeliveryReceipt(SendBird.getCurrentUser().getUserId(), asJsonObject.get(StringSet.ts).getAsLong());
                            }
                        }
                    } catch (SendBirdException e3) {
                        Logger.e((Throwable) e3);
                    }
                }
            }, aVar);
        }
        Logger.d("++ isRunning : " + this.rateLimitScheduler.f44672a.get());
        this.rateLimitScheduler.f44675d = aVar;
        if (this.rateLimitScheduler.f44672a.get()) {
            Logger.d("++ change delivery datas");
        } else {
            this.rateLimitScheduler.c();
        }
    }

    public final void markAsRead() {
        sendMarkAsRead((GroupChannelMarkAsReadHandler) null);
    }

    public final void resetMyHistory(final GroupChannelResetMyHistoryHandler groupChannelResetMyHistoryHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelResetMyHistoryHandler groupChannelResetMyHistoryHandler = groupChannelResetMyHistoryHandler;
                if (groupChannelResetMyHistoryHandler != null) {
                    groupChannelResetMyHistoryHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String url = GroupChannel.this.getUrl();
                JsonElement b2 = a2.b(String.format(b.GROUPCHANNELS_CHANNELURL_RESETUSERHISTORY.publicUrl(), new Object[]{b.urlEncodeUTF8(url)}), APIClient.e());
                GroupChannel.this.parseMessageOffset(b2);
                return b2;
            }
        });
    }

    @Deprecated
    public final long getLastSeenAtBy(User user) {
        if (user == null) {
            return 0;
        }
        return getLastSeenAtByWithUserId(user.getUserId());
    }

    @Deprecated
    public final long getLastSeenAtByWithUserId(String str) {
        Long l;
        if (!this.mCachedReadReceiptStatus.containsKey(str) || (l = this.mCachedReadReceiptStatus.get(str)) == null) {
            return 0;
        }
        return l.longValue();
    }

    /* access modifiers changed from: package-private */
    public final long getMyReadTs() {
        Long l;
        if (SendBird.getCurrentUser() != null) {
            String userId = SendBird.getCurrentUser().getUserId();
            if (!this.mCachedReadReceiptStatus.containsKey(userId) || (l = this.mCachedReadReceiptStatus.get(userId)) == null) {
                return 0;
            }
            return l.longValue();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final long getMyLastDeliveredTs() {
        if (SendBird.getCurrentUser() != null) {
            return getLastDeliveredTs(SendBird.getCurrentUser().getUserId());
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final long getLastDeliveredTs(String str) {
        Long l;
        if (!this.mCachedDeliveryReceipt.containsKey(str) || (l = this.mCachedDeliveryReceipt.get(str)) == null) {
            return 0;
        }
        return l.longValue();
    }

    @Deprecated
    public final synchronized List<Member> getReadMembers(BaseMessage baseMessage) {
        return localGetReadMembers(baseMessage, false);
    }

    public final synchronized List<Member> getReadMembers(BaseMessage baseMessage, boolean z) {
        return localGetReadMembers(baseMessage, z);
    }

    private List<Member> localGetReadMembers(BaseMessage baseMessage, boolean z) {
        User currentUser;
        ArrayList arrayList = new ArrayList();
        if (baseMessage == null || (baseMessage instanceof AdminMessage) || this.mIsSuper || (currentUser = SendBird.getCurrentUser()) == null) {
            return arrayList;
        }
        Sender sender = baseMessage.getSender();
        long createdAt = baseMessage.getCreatedAt();
        for (Member next : getMembers()) {
            String userId = next.getUserId();
            if (z || (!currentUser.getUserId().equals(userId) && (sender == null || !sender.getUserId().equals(userId)))) {
                Long l = this.mCachedReadReceiptStatus.get(userId);
                if (l == null) {
                    l = 0L;
                }
                if (l.longValue() >= createdAt) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    public final synchronized List<Member> getUnreadMembers(BaseMessage baseMessage) {
        return localGetUnreadMembers(baseMessage, false);
    }

    public final synchronized List<Member> getUnreadMembers(BaseMessage baseMessage, boolean z) {
        return localGetUnreadMembers(baseMessage, z);
    }

    private List<Member> localGetUnreadMembers(BaseMessage baseMessage, boolean z) {
        User currentUser;
        ArrayList arrayList = new ArrayList();
        if (baseMessage == null || (baseMessage instanceof AdminMessage) || this.mIsSuper || (currentUser = SendBird.getCurrentUser()) == null) {
            return arrayList;
        }
        Sender sender = baseMessage.getSender();
        long createdAt = baseMessage.getCreatedAt();
        for (Member next : getMembers()) {
            String userId = next.getUserId();
            if (z || (!currentUser.getUserId().equals(userId) && (sender == null || !sender.getUserId().equals(userId)))) {
                Long l = this.mCachedReadReceiptStatus.get(userId);
                if (l == null) {
                    l = 0L;
                }
                if (l.longValue() < createdAt) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    public final synchronized Map<String, ReadStatus> getReadStatus() {
        return localGetReadStatus(false);
    }

    public final synchronized Map<String, ReadStatus> getReadStatus(boolean z) {
        return localGetReadStatus(z);
    }

    private Map<String, ReadStatus> localGetReadStatus(boolean z) {
        HashMap hashMap = new HashMap();
        User currentUser = SendBird.getCurrentUser();
        if (currentUser != null && !this.mIsSuper) {
            for (Member next : getMembers()) {
                String userId = next.getUserId();
                if (z || !currentUser.getUserId().equals(userId)) {
                    Long l = this.mCachedReadReceiptStatus.get(userId);
                    hashMap.put(userId, new ReadStatus(next, l == null ? 0 : l.longValue()));
                }
            }
        }
        return hashMap;
    }

    public final long getMyLastRead() {
        return this.mMyLastRead;
    }

    public final synchronized int getReadReceipt(BaseMessage baseMessage) {
        return getUnreadMemberCount(baseMessage);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0074, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int getUnreadMemberCount(com.sendbird.android.BaseMessage r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            if (r9 == 0) goto L_0x0073
            boolean r1 = r9 instanceof com.sendbird.android.AdminMessage     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x0073
            boolean r1 = r8.mIsSuper     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x000d
            goto L_0x0073
        L_0x000d:
            com.sendbird.android.User r1 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x0015
            monitor-exit(r8)
            return r0
        L_0x0015:
            com.sendbird.android.Sender r2 = r9.getSender()     // Catch:{ all -> 0x0070 }
            long r3 = r9.getCreatedAt()     // Catch:{ all -> 0x0070 }
            java.util.List r9 = r8.getMembers()     // Catch:{ all -> 0x0070 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0070 }
        L_0x0025:
            boolean r5 = r9.hasNext()     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x006e
            java.lang.Object r5 = r9.next()     // Catch:{ all -> 0x0070 }
            com.sendbird.android.Member r5 = (com.sendbird.android.Member) r5     // Catch:{ all -> 0x0070 }
            java.lang.String r6 = r5.getUserId()     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = r1.getUserId()     // Catch:{ all -> 0x0070 }
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x0070 }
            if (r7 != 0) goto L_0x0025
            if (r2 == 0) goto L_0x004b
            java.lang.String r7 = r2.getUserId()     // Catch:{ all -> 0x0070 }
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x0070 }
            if (r7 != 0) goto L_0x0025
        L_0x004b:
            com.sendbird.android.Member$MemberState r5 = r5.getMemberState()     // Catch:{ all -> 0x0070 }
            com.sendbird.android.Member$MemberState r7 = com.sendbird.android.Member.MemberState.JOINED     // Catch:{ all -> 0x0070 }
            if (r5 != r7) goto L_0x0025
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r5 = r8.mCachedReadReceiptStatus     // Catch:{ all -> 0x0070 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x0070 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0070 }
            if (r5 != 0) goto L_0x0063
            r5 = 0
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0070 }
        L_0x0063:
            long r5 = r5.longValue()     // Catch:{ all -> 0x0070 }
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0025
            int r0 = r0 + 1
            goto L_0x0025
        L_0x006e:
            monitor-exit(r8)
            return r0
        L_0x0070:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        L_0x0073:
            monitor-exit(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannel.getUnreadMemberCount(com.sendbird.android.BaseMessage):int");
    }

    /* access modifiers changed from: protected */
    public final synchronized void updateReadReceipt(String str, long j) {
        Long l = this.mCachedReadReceiptStatus.get(str);
        if (l == null || l.longValue() < j) {
            if (SendBird.getCurrentUser() != null && SendBird.getCurrentUser().getUserId().equals(str)) {
                this.mMyLastRead = Math.max(this.mMyLastRead, j);
            }
            this.mCachedReadReceiptStatus.put(str, Long.valueOf(j));
        }
    }

    public final synchronized int getDeliveryReceipt(BaseMessage baseMessage) {
        return getUndeliveredMemberCount(baseMessage);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0080, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int getUndeliveredMemberCount(com.sendbird.android.BaseMessage r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            if (r9 == 0) goto L_0x007f
            boolean r1 = r9 instanceof com.sendbird.android.AdminMessage     // Catch:{ all -> 0x007c }
            if (r1 != 0) goto L_0x007f
            boolean r1 = r8.mIsSuper     // Catch:{ all -> 0x007c }
            if (r1 != 0) goto L_0x007f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = r8.mCachedDeliveryReceipt     // Catch:{ all -> 0x007c }
            if (r1 == 0) goto L_0x007f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = r8.mCachedDeliveryReceipt     // Catch:{ all -> 0x007c }
            int r1 = r1.size()     // Catch:{ all -> 0x007c }
            if (r1 > 0) goto L_0x0019
            goto L_0x007f
        L_0x0019:
            com.sendbird.android.User r1 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ all -> 0x007c }
            if (r1 != 0) goto L_0x0021
            monitor-exit(r8)
            return r0
        L_0x0021:
            com.sendbird.android.Sender r2 = r9.getSender()     // Catch:{ all -> 0x007c }
            long r3 = r9.getCreatedAt()     // Catch:{ all -> 0x007c }
            java.util.List r9 = r8.getMembers()     // Catch:{ all -> 0x007c }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x007c }
        L_0x0031:
            boolean r5 = r9.hasNext()     // Catch:{ all -> 0x007c }
            if (r5 == 0) goto L_0x007a
            java.lang.Object r5 = r9.next()     // Catch:{ all -> 0x007c }
            com.sendbird.android.Member r5 = (com.sendbird.android.Member) r5     // Catch:{ all -> 0x007c }
            java.lang.String r6 = r5.getUserId()     // Catch:{ all -> 0x007c }
            java.lang.String r7 = r1.getUserId()     // Catch:{ all -> 0x007c }
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x007c }
            if (r7 != 0) goto L_0x0031
            if (r2 == 0) goto L_0x0057
            java.lang.String r7 = r2.getUserId()     // Catch:{ all -> 0x007c }
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x007c }
            if (r7 != 0) goto L_0x0031
        L_0x0057:
            com.sendbird.android.Member$MemberState r5 = r5.getMemberState()     // Catch:{ all -> 0x007c }
            com.sendbird.android.Member$MemberState r7 = com.sendbird.android.Member.MemberState.JOINED     // Catch:{ all -> 0x007c }
            if (r5 != r7) goto L_0x0031
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r5 = r8.mCachedDeliveryReceipt     // Catch:{ all -> 0x007c }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x007c }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x007c }
            if (r5 != 0) goto L_0x006f
            r5 = 0
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x007c }
        L_0x006f:
            long r5 = r5.longValue()     // Catch:{ all -> 0x007c }
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0031
            int r0 = r0 + 1
            goto L_0x0031
        L_0x007a:
            monitor-exit(r8)
            return r0
        L_0x007c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        L_0x007f:
            monitor-exit(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannel.getUndeliveredMemberCount(com.sendbird.android.BaseMessage):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void updateDeliveryReceipt(java.lang.String r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r0 = r3.mCachedDeliveryReceipt     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r0 = r3.mCachedDeliveryReceipt     // Catch:{ all -> 0x0024 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0024 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0019
            long r0 = r0.longValue()     // Catch:{ all -> 0x0024 }
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0022
        L_0x0019:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r0 = r3.mCachedDeliveryReceipt     // Catch:{ all -> 0x0024 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0024 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r3)
            return
        L_0x0024:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannel.updateDeliveryReceipt(java.lang.String, long):void");
    }

    public final void startTyping() {
        if (System.currentTimeMillis() - this.mStartTypingLastSentAt >= ((long) SendBird.Options.typingIndicatorThrottle)) {
            this.mEndTypingLastSentAt = 0;
            this.mStartTypingLastSentAt = System.currentTimeMillis();
            SendBird.getInstance().sendCommand(Command.a(getUrl(), this.mStartTypingLastSentAt), true, (Command.SendCommandHandler) null);
        }
    }

    public final void endTyping() {
        if (System.currentTimeMillis() - this.mEndTypingLastSentAt >= ((long) SendBird.Options.typingIndicatorThrottle)) {
            this.mStartTypingLastSentAt = 0;
            this.mEndTypingLastSentAt = System.currentTimeMillis();
            SendBird.getInstance().sendCommand(Command.b(getUrl(), this.mEndTypingLastSentAt), true, (Command.SendCommandHandler) null);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized boolean invalidateTypingStatus() {
        boolean z;
        z = false;
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry next : this.mCachedTypingStatus.entrySet()) {
            if (currentTimeMillis - ((Long) ((Pair) next.getValue()).first).longValue() >= 10000) {
                this.mCachedTypingStatus.remove(next.getKey());
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public final synchronized boolean updateTypingStatus(User user, boolean z) {
        if (z) {
            this.mCachedTypingStatus.put(user.getUserId(), new Pair(Long.valueOf(System.currentTimeMillis()), user));
            return true;
        } else if (this.mCachedTypingStatus.remove(user.getUserId()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean isTyping() {
        return this.mCachedTypingStatus.size() > 0;
    }

    public final List<Member> getTypingMembers() {
        ArrayList arrayList = new ArrayList();
        Enumeration<String> keys = this.mCachedTypingStatus.keys();
        while (keys.hasMoreElements()) {
            Member member = this.mMemberMap.get(keys.nextElement());
            if (member != null) {
                arrayList.add(member);
            }
        }
        return arrayList;
    }

    public final List<User> getTypingUsers() {
        ArrayList arrayList = new ArrayList();
        for (Pair<Long, User> pair : this.mCachedTypingStatus.values()) {
            arrayList.add(pair.second);
        }
        return arrayList;
    }

    public final String getCustomType() {
        return this.mCustomType;
    }

    public final Member.MemberState getMyMemberState() {
        return this.mMyMemberState;
    }

    public final Member.Role getMyRole() {
        return this.mMyRole;
    }

    /* access modifiers changed from: package-private */
    public final void setMyRole(Member.Role role) {
        this.mMyRole = role;
    }

    public final Member.MutedState getMyMutedState() {
        return this.mMyMutedState;
    }

    /* access modifiers changed from: package-private */
    public final void setMyMutedState(Member.MutedState mutedState) {
        this.mMyMutedState = mutedState;
    }

    /* access modifiers changed from: package-private */
    public final void setMyMemberState(Member.MemberState memberState) {
        this.mMyMemberState = memberState;
    }

    public final int getMessageSurvivalSeconds() {
        return this.messageSurvivalSeconds;
    }

    /* access modifiers changed from: protected */
    public final synchronized void addMember(Member member, long j) {
        Member removeMember = removeMember(member);
        if (removeMember != null && removeMember.getMemberState() == Member.MemberState.JOINED) {
            member.setState(Member.MemberState.JOINED);
        }
        this.mMemberMap.put(member.getUserId(), member);
        this.mMembers.add(member);
        this.mMemberCount++;
        updateReadReceipt(member.getUserId(), j);
        updateDeliveryReceipt(member.getUserId(), j);
    }

    /* access modifiers changed from: protected */
    public final synchronized Member removeMember(User user) {
        if (!this.mMemberMap.containsKey(user.getUserId())) {
            return null;
        }
        Member remove = this.mMemberMap.remove(user.getUserId());
        this.mMembers.remove(remove);
        this.mMemberCount--;
        return remove;
    }

    /* access modifiers changed from: protected */
    public final synchronized void updateJoinedMemberCount() {
        int i2 = 0;
        for (Member memberState : this.mMembers) {
            if (memberState.getMemberState() == Member.MemberState.JOINED) {
                i2++;
            }
        }
        this.mJoinedMemberCount = i2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void updateOperators(List<User> list, long j) {
        if (j > this.memberRoleUpdatedAt.get()) {
            this.memberRoleUpdatedAt.set(j);
            for (Member next : this.mMembers) {
                boolean z = false;
                Iterator<User> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (next.getUserId().equals(it2.next().getUserId())) {
                            next.setRole(Member.Role.OPERATOR);
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    next.setRole(Member.Role.NONE);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void setMemberCount(JsonElement jsonElement, long j) {
        if (this.mMemberCountUpdatedAt < j) {
            if (jsonElement.getAsJsonObject().has("member_count")) {
                this.mMemberCount = jsonElement.getAsJsonObject().get("member_count").getAsInt();
            }
            if (jsonElement.getAsJsonObject().has("joined_member_count")) {
                this.mJoinedMemberCount = jsonElement.getAsJsonObject().get("joined_member_count").getAsInt();
            }
            this.mMemberCountUpdatedAt = j;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void updateMutedState(String str, boolean z) {
        User currentUser = SendBird.getCurrentUser();
        if (currentUser != null && currentUser.getUserId().equals(str)) {
            setMyMutedState(z ? Member.MutedState.MUTED : Member.MutedState.UNMUTED);
        }
        for (Member next : this.mMembers) {
            if (next != null && next.getUserId().equals(str)) {
                next.setMuted(z);
                return;
            }
        }
    }

    public final BannedUserListQuery createBannedUserListQuery() {
        return new BannedUserListQuery(this);
    }

    public final void banUser(User user, String str, int i2, final GroupChannelBanHandler groupChannelBanHandler) {
        if (user != null) {
            banUserWithUserId(user.getUserId(), str, i2, groupChannelBanHandler);
        } else if (groupChannelBanHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelBanHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void banUserWithUserId(String str, String str2, int i2, GroupChannelBanHandler groupChannelBanHandler) {
        final String str3 = str;
        final String str4 = str2;
        final int i3 = i2;
        final GroupChannelBanHandler groupChannelBanHandler2 = groupChannelBanHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelBanHandler groupChannelBanHandler = groupChannelBanHandler2;
                if (groupChannelBanHandler != null) {
                    groupChannelBanHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str3 != null) {
                    return APIClient.a().a(false, GroupChannel.this.getUrl(), str3, str4, i3);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void unbanUser(User user, final GroupChannelUnbanHandler groupChannelUnbanHandler) {
        if (user != null) {
            unbanUserWithUserId(user.getUserId(), groupChannelUnbanHandler);
        } else if (groupChannelUnbanHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelUnbanHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void unbanUserWithUserId(final String str, final GroupChannelUnbanHandler groupChannelUnbanHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelUnbanHandler groupChannelUnbanHandler = groupChannelUnbanHandler;
                if (groupChannelUnbanHandler != null) {
                    groupChannelUnbanHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    return APIClient.a().a(false, GroupChannel.this.getUrl(), str);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void muteUser(User user, final GroupChannelMuteHandler groupChannelMuteHandler) {
        if (user != null) {
            localMuteUserWithUserId(user.getUserId(), (String) null, (Integer) null, groupChannelMuteHandler);
        } else if (groupChannelMuteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelMuteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void muteUserWithUserId(String str, GroupChannelMuteHandler groupChannelMuteHandler) {
        localMuteUserWithUserId(str, (String) null, (Integer) null, groupChannelMuteHandler);
    }

    public final void muteUser(User user, String str, int i2, final GroupChannelMuteHandler groupChannelMuteHandler) {
        if (user != null) {
            localMuteUserWithUserId(user.getUserId(), str, Integer.valueOf(i2), groupChannelMuteHandler);
        } else if (groupChannelMuteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelMuteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void muteUserWithUserId(String str, String str2, int i2, GroupChannelMuteHandler groupChannelMuteHandler) {
        localMuteUserWithUserId(str, str2, Integer.valueOf(i2), groupChannelMuteHandler);
    }

    private void localMuteUserWithUserId(String str, String str2, Integer num, GroupChannelMuteHandler groupChannelMuteHandler) {
        final String str3 = str;
        final String str4 = str2;
        final Integer num2 = num;
        final GroupChannelMuteHandler groupChannelMuteHandler2 = groupChannelMuteHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelMuteHandler groupChannelMuteHandler = groupChannelMuteHandler2;
                if (groupChannelMuteHandler != null) {
                    groupChannelMuteHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str3 != null) {
                    return APIClient.a().a(false, GroupChannel.this.getUrl(), str3, str4, num2);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void unmuteUser(User user, final GroupChannelUnmuteHandler groupChannelUnmuteHandler) {
        if (user != null) {
            unmuteUserWithUserId(user.getUserId(), groupChannelUnmuteHandler);
        } else if (groupChannelUnmuteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    groupChannelUnmuteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void unmuteUserWithUserId(final String str, final GroupChannelUnmuteHandler groupChannelUnmuteHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelUnmuteHandler groupChannelUnmuteHandler = groupChannelUnmuteHandler;
                if (groupChannelUnmuteHandler != null) {
                    groupChannelUnmuteHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    return APIClient.a().b(false, GroupChannel.this.getUrl(), str);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void freeze(final GroupChannelFreezeHandler groupChannelFreezeHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelFreezeHandler groupChannelFreezeHandler = groupChannelFreezeHandler;
                if (groupChannelFreezeHandler != null) {
                    groupChannelFreezeHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                JsonElement a2 = APIClient.a().a(GroupChannel.this.getUrl(), true);
                GroupChannel.this.mFreeze = true;
                return a2;
            }
        });
    }

    public final void unfreeze(final GroupChannelUnfreezeHandler groupChannelUnfreezeHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelUnfreezeHandler groupChannelUnfreezeHandler = groupChannelUnfreezeHandler;
                if (groupChannelUnfreezeHandler != null) {
                    groupChannelUnfreezeHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                JsonElement a2 = APIClient.a().a(GroupChannel.this.getUrl(), false);
                GroupChannel.this.mFreeze = false;
                return a2;
            }
        });
    }

    public final void registerScheduledUserMessage(final ScheduledUserMessageParams scheduledUserMessageParams, final RegisterScheduledUserMessageHandler registerScheduledUserMessageHandler) {
        d.a(new q<ScheduledUserMessage>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                ScheduledUserMessage scheduledUserMessage = (ScheduledUserMessage) obj;
                RegisterScheduledUserMessageHandler registerScheduledUserMessageHandler = registerScheduledUserMessageHandler;
                if (registerScheduledUserMessageHandler != null) {
                    registerScheduledUserMessageHandler.onRegistered(scheduledUserMessage, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                ScheduledUserMessageParams scheduledUserMessageParams = scheduledUserMessageParams;
                if (scheduledUserMessageParams == null || scheduledUserMessageParams.getScheduledString() == null) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                } else if (SendBird.getCurrentUser() != null) {
                    if (scheduledUserMessageParams.mMessage == null) {
                        scheduledUserMessageParams.mMessage = "";
                    }
                    APIClient a2 = APIClient.a();
                    String url = GroupChannel.this.getUrl();
                    String scheduledString = scheduledUserMessageParams.getScheduledString();
                    String str = scheduledUserMessageParams.mMessage;
                    String str2 = scheduledUserMessageParams.mData;
                    String str3 = scheduledUserMessageParams.mCustomType;
                    BaseMessageParams.MentionType mentionType = scheduledUserMessageParams.mMentionType;
                    List<String> list = scheduledUserMessageParams.mMentionedUserIds;
                    BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption = scheduledUserMessageParams.mPushNotificationDeliveryOption;
                    List<MessageMetaArray> list2 = scheduledUserMessageParams.mMetaArrays;
                    List<String> list3 = scheduledUserMessageParams.mTargetLanguages;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.GROUPCHANNELS_CHANNELURL_SCHEDULED_MESSAGES.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                        JsonObject e2 = APIClient.e();
                        e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                        e2.addProperty("scheduled_dt", scheduledString);
                        e2.addProperty("message", str);
                        if (str2 != null) {
                            e2.addProperty("data", str2);
                        }
                        if (str3 != null) {
                            e2.addProperty(StringSet.custom_type, str3);
                        }
                        if (mentionType == BaseMessageParams.MentionType.USERS) {
                            e2.addProperty(StringSet.mention_type, StringSet.users);
                            if (list != null && list.size() > 0) {
                                JsonArray jsonArray = new JsonArray();
                                for (String add : list) {
                                    jsonArray.add(add);
                                }
                                e2.add(StringSet.mentioned_user_ids, jsonArray);
                            }
                        } else if (mentionType == BaseMessageParams.MentionType.CHANNEL) {
                            e2.addProperty(StringSet.mention_type, "channel");
                        }
                        if (list != null && list.size() > 0) {
                            JsonArray jsonArray2 = new JsonArray();
                            for (String add2 : list) {
                                jsonArray2.add(add2);
                            }
                            e2.add(StringSet.mentioned_user_ids, jsonArray2);
                        }
                        if (pushNotificationDeliveryOption != null && pushNotificationDeliveryOption == BaseMessageParams.PushNotificationDeliveryOption.SUPPRESS) {
                            e2.addProperty("push_option", "suppress");
                        }
                        if (list2 != null && list2.size() > 0) {
                            JsonObject jsonObject = new JsonObject();
                            JsonArray jsonArray3 = new JsonArray();
                            for (MessageMetaArray messageMetaArray : list2) {
                                String key = messageMetaArray.getKey();
                                List<String> value = messageMetaArray.getValue();
                                if (key != null) {
                                    JsonArray jsonArray4 = new JsonArray();
                                    for (String add3 : value) {
                                        jsonArray4.add(add3);
                                    }
                                    jsonObject.add(key, jsonArray4);
                                    jsonArray3.add(key);
                                }
                            }
                            e2.add("metaarray", jsonObject);
                            e2.add("metaarray_key_order", jsonArray3);
                        }
                        if (list3 != null && list3.size() > 0) {
                            JsonArray jsonArray5 = new JsonArray();
                            for (String add4 : list3) {
                                jsonArray5.add(add4);
                            }
                            e2.add("translation_target_langs", jsonArray5);
                        }
                        return new ScheduledUserMessage(a2.a(format, (JsonElement) e2).getAsJsonObject());
                    }
                    throw u.b();
                } else {
                    throw new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED);
                }
            }
        });
    }

    public final void delete(final GroupChannelDeleteHandler groupChannelDeleteHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GroupChannelDeleteHandler groupChannelDeleteHandler = groupChannelDeleteHandler;
                if (groupChannelDeleteHandler != null) {
                    groupChannelDeleteHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String url = GroupChannel.this.getUrl();
                JsonElement a2 = APIClient.a().a(false, url);
                GroupChannel.removeChannelFromCache(url);
                return a2;
            }
        });
    }

    public final User getCreator() {
        return this.createdBy;
    }

    /* access modifiers changed from: package-private */
    public final Member.Role getCurrentUserRole() {
        return getMyRole();
    }

    public final String toString() {
        return super.toString() + "\nGroupChannel{mCachedTypingStatus=" + this.mCachedTypingStatus + ", mCachedReadReceiptStatus=" + this.mCachedReadReceiptStatus + ", mCachedDeliveryReceipt=" + this.mCachedDeliveryReceipt + ", mIsSuper=" + this.mIsSuper + ", mIsPublic=" + this.mIsPublic + ", mIsDistinct=" + this.mIsDistinct + ", mIsDiscoverable=" + this.mIsDiscoverable + ", mUnreadMessageCount=" + this.mUnreadMessageCount + ", mUnreadMentionCount=" + this.mUnreadMentionCount + ", mMembers=" + this.mMembers + ", mMemberMap=" + this.mMemberMap + ", mLastMessage=" + this.mLastMessage + ", mInviter=" + this.mInviter + ", mMemberCount=" + this.mMemberCount + ", mJoinedMemberCount=" + this.mJoinedMemberCount + ", mInvitedAt=" + this.mInvitedAt + ", mStartTypingLastSentAt=" + this.mStartTypingLastSentAt + ", mEndTypingLastSentAt=" + this.mEndTypingLastSentAt + ", mMarkAsReadLastSentAt=" + this.mMarkAsReadLastSentAt + ", mMyLastRead=" + this.mMyLastRead + ", mMarkAsReadScheduled=" + this.mMarkAsReadScheduled + ", mMessageOffsetTimestamp=" + this.mMessageOffsetTimestamp + ", mCustomType='" + this.mCustomType + '\'' + ", mIsPushEnabled=" + this.mIsPushEnabled + ", mMyPushTriggerOption=" + this.mMyPushTriggerOption + ", mMyCountPreference=" + this.mMyCountPreference + ", mIsHidden=" + this.mIsHidden + ", mHiddenState=" + this.mHiddenState + ", mIsAccessCodeRequired=" + this.mIsAccessCodeRequired + ", mMyMemberState=" + this.mMyMemberState + ", mMyRole=" + this.mMyRole + ", mMyMutedState=" + this.mMyMutedState + ", rateLimitScheduler=" + this.rateLimitScheduler + ", isBroadcast=" + this.isBroadcast + ", mHasBeenUpdated=" + this.mHasBeenUpdated + ", mMemberCountUpdatedAt=" + this.mMemberCountUpdatedAt + ", messageSurvivalSeconds=" + this.messageSurvivalSeconds + ", createdBy=" + this.createdBy + '}';
    }

    /* renamed from: com.sendbird.android.GroupChannel$46  reason: invalid class name */
    static /* synthetic */ class AnonymousClass46 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44336a = new int[MemberState.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f44337b = new int[GroupChannelListQuery.MemberStateFilter.values().length];

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f44338c = new int[GroupChannelListQuery.Order.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a2 */
        static {
            /*
                com.sendbird.android.GroupChannelListQuery$Order[] r0 = com.sendbird.android.GroupChannelListQuery.Order.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44338c = r0
                r0 = 1
                int[] r1 = f44338c     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.GroupChannelListQuery$Order r2 = com.sendbird.android.GroupChannelListQuery.Order.CHRONOLOGICAL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f44338c     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.GroupChannelListQuery$Order r3 = com.sendbird.android.GroupChannelListQuery.Order.LATEST_LAST_MESSAGE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f44338c     // Catch:{ NoSuchFieldError -> 0x002a }
                com.sendbird.android.GroupChannelListQuery$Order r4 = com.sendbird.android.GroupChannelListQuery.Order.CHANNEL_NAME_ALPHABETICAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f44338c     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.sendbird.android.GroupChannelListQuery$Order r5 = com.sendbird.android.GroupChannelListQuery.Order.METADATA_VALUE_ALPHABETICAL     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter[] r4 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f44337b = r4
                int[] r4 = f44337b     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r5 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.ALL     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r4 = f44337b     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r5 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.INVITED     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r4 = f44337b     // Catch:{ NoSuchFieldError -> 0x005c }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r5 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.INVITED_BY_FRIEND     // Catch:{ NoSuchFieldError -> 0x005c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r4 = f44337b     // Catch:{ NoSuchFieldError -> 0x0066 }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r5 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.INVITED_BY_NON_FRIEND     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                r4 = 5
                int[] r5 = f44337b     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r6 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.JOINED     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                com.sendbird.android.GroupChannel$MemberState[] r5 = com.sendbird.android.GroupChannel.MemberState.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f44336a = r5
                int[] r5 = f44336a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.sendbird.android.GroupChannel$MemberState r6 = com.sendbird.android.GroupChannel.MemberState.ALL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f44336a     // Catch:{ NoSuchFieldError -> 0x008e }
                com.sendbird.android.GroupChannel$MemberState r5 = com.sendbird.android.GroupChannel.MemberState.INVITED     // Catch:{ NoSuchFieldError -> 0x008e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                int[] r0 = f44336a     // Catch:{ NoSuchFieldError -> 0x0098 }
                com.sendbird.android.GroupChannel$MemberState r1 = com.sendbird.android.GroupChannel.MemberState.INVITED_BY_FRIEND     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                int[] r0 = f44336a     // Catch:{ NoSuchFieldError -> 0x00a2 }
                com.sendbird.android.GroupChannel$MemberState r1 = com.sendbird.android.GroupChannel.MemberState.INVITED_BY_NON_FRIEND     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                int[] r0 = f44336a     // Catch:{ NoSuchFieldError -> 0x00ac }
                com.sendbird.android.GroupChannel$MemberState r1 = com.sendbird.android.GroupChannel.MemberState.JOINED     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ac }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00ac }
            L_0x00ac:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannel.AnonymousClass46.<clinit>():void");
        }
    }

    public static int compareTo(GroupChannel groupChannel, GroupChannel groupChannel2, GroupChannelListQuery.Order order) {
        long j;
        int i2 = AnonymousClass46.f44338c[order.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                BaseMessage lastMessage = groupChannel.getLastMessage();
                BaseMessage lastMessage2 = groupChannel2.getLastMessage();
                long j2 = -1;
                if (lastMessage != null && lastMessage2 != null) {
                    j2 = lastMessage.getCreatedAt();
                    j = lastMessage2.getCreatedAt();
                } else if (lastMessage == null && lastMessage2 != null) {
                    j = lastMessage2.getCreatedAt();
                } else if (lastMessage != null) {
                    j = -1;
                    j2 = lastMessage.getCreatedAt();
                } else {
                    j2 = groupChannel.getCreatedAt();
                    j = groupChannel2.getCreatedAt();
                }
                int i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i3 > 0) {
                    return -1;
                }
                return i3 < 0 ? 1 : 0;
            } else if (i2 != 3) {
                return 0;
            } else {
                return groupChannel.getName().compareTo(groupChannel2.getName());
            }
        } else if (groupChannel.getCreatedAt() > groupChannel2.getCreatedAt()) {
            return -1;
        } else {
            return groupChannel.getCreatedAt() < groupChannel2.getCreatedAt() ? 1 : 0;
        }
    }

    public static GroupChannel clone(GroupChannel groupChannel) {
        return new GroupChannel(groupChannel.toJson());
    }
}
