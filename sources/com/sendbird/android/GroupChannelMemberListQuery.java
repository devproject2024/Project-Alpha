package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GroupChannelMemberListQuery {
    private static final String MEMBER_STATE_ALL = "all";
    private static final String MEMBER_STATE_INVITED_BY_FRIEND_ONLY = "invited_by_friend";
    private static final String MEMBER_STATE_INVITED_BY_NON_FRIEND_ONLY = "invited_by_non_friend";
    private static final String MEMBER_STATE_INVITED_ONLY = "invited_only";
    private static final String MEMBER_STATE_JOINED_ONLY = "joined_only";
    /* access modifiers changed from: private */
    public GroupChannel mGroupChannel;
    /* access modifiers changed from: private */
    public boolean mHasNext = true;
    /* access modifiers changed from: private */
    public int mLimit = 20;
    private boolean mLoading = false;
    /* access modifiers changed from: private */
    public String mMemberState = "all";
    /* access modifiers changed from: private */
    public MutedMemberFilter mMutedMemberFilter = MutedMemberFilter.ALL;
    /* access modifiers changed from: private */
    public String mNicknameStartsWith;
    /* access modifiers changed from: private */
    public OperatorFilter mOperatorFilter = OperatorFilter.ALL;
    /* access modifiers changed from: private */
    public Order mOrder = Order.MEMBER_NICKNAME_ALPHABETICAL;
    /* access modifiers changed from: private */
    public String mToken = "";

    public interface GroupChannelMemberListQueryResultHandler {
        void onResult(List<Member> list, SendBirdException sendBirdException);
    }

    public enum MemberStateFilter {
        ALL,
        INVITED,
        INVITED_BY_FRIEND,
        INVITED_BY_NON_FRIEND,
        JOINED
    }

    public enum MutedMemberFilter {
        ALL,
        MUTED,
        UNMUTED
    }

    public enum OperatorFilter {
        ALL("all"),
        OPERATOR(StringSet.operator),
        NONOPERATOR(StringSet.nonoperator);
        
        private String value;

        private OperatorFilter(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public enum Order {
        MEMBER_NICKNAME_ALPHABETICAL(StringSet.member_nickname_alphabetical),
        OPERATOR_THEN_MEMBER_ALPHABETICAL(StringSet.operator_then_member_alphabetical);
        
        /* access modifiers changed from: private */
        public final String value;

        private Order(String str) {
            this.value = str;
        }
    }

    GroupChannelMemberListQuery(GroupChannel groupChannel) {
        this.mGroupChannel = groupChannel;
    }

    public final void setOperatorFilter(OperatorFilter operatorFilter) {
        this.mOperatorFilter = operatorFilter;
    }

    public final void setMutedMemberFilter(MutedMemberFilter mutedMemberFilter) {
        this.mMutedMemberFilter = mutedMemberFilter;
    }

    public final void setMemberStateFilter(MemberStateFilter memberStateFilter) {
        if (memberStateFilter == MemberStateFilter.INVITED) {
            this.mMemberState = "invited_only";
        } else if (memberStateFilter == MemberStateFilter.INVITED_BY_FRIEND) {
            this.mMemberState = "invited_by_friend";
        } else if (memberStateFilter == MemberStateFilter.INVITED_BY_NON_FRIEND) {
            this.mMemberState = "invited_by_non_friend";
        } else if (memberStateFilter == MemberStateFilter.JOINED) {
            this.mMemberState = "joined_only";
        } else {
            this.mMemberState = "all";
        }
    }

    public final void setNicknameStartsWithFilter(String str) {
        this.mNicknameStartsWith = str;
    }

    public final void setLimit(int i2) {
        this.mLimit = i2;
    }

    public final void setOrder(Order order) {
        this.mOrder = order;
    }

    public final boolean hasNext() {
        return this.mHasNext;
    }

    public final synchronized boolean isLoading() {
        return this.mLoading;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void setLoading(boolean z) {
        this.mLoading = z;
    }

    public final synchronized void next(final GroupChannelMemberListQueryResultHandler groupChannelMemberListQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    GroupChannelMemberListQueryResultHandler groupChannelMemberListQueryResultHandler = groupChannelMemberListQueryResultHandler;
                    if (groupChannelMemberListQueryResultHandler != null) {
                        groupChannelMemberListQueryResultHandler.onResult((List<Member>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasNext()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    GroupChannelMemberListQueryResultHandler groupChannelMemberListQueryResultHandler = groupChannelMemberListQueryResultHandler;
                    if (groupChannelMemberListQueryResultHandler != null) {
                        groupChannelMemberListQueryResultHandler.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<Member>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    GroupChannelMemberListQuery.this.setLoading(false);
                    GroupChannelMemberListQueryResultHandler groupChannelMemberListQueryResultHandler = groupChannelMemberListQueryResultHandler;
                    if (groupChannelMemberListQueryResultHandler != null) {
                        groupChannelMemberListQueryResultHandler.onResult(list, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    APIClient a2 = APIClient.a();
                    String url = GroupChannelMemberListQuery.this.mGroupChannel.getUrl();
                    String access$100 = GroupChannelMemberListQuery.this.mToken;
                    int access$200 = GroupChannelMemberListQuery.this.mLimit;
                    OperatorFilter access$300 = GroupChannelMemberListQuery.this.mOperatorFilter;
                    MutedMemberFilter access$400 = GroupChannelMemberListQuery.this.mMutedMemberFilter;
                    String access$600 = GroupChannelMemberListQuery.this.mOrder.value;
                    String access$700 = GroupChannelMemberListQuery.this.mMemberState;
                    String access$800 = GroupChannelMemberListQuery.this.mNicknameStartsWith;
                    String format = String.format(b.GROUPCHANNELS_CHANNELURL_MEMBERS.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    HashMap hashMap = new HashMap();
                    if (access$100 != null) {
                        hashMap.put(StringSet.token, access$100);
                    }
                    hashMap.put("limit", String.valueOf(access$200));
                    hashMap.put(StringSet.order, access$600);
                    hashMap.put(StringSet.operator_filter, access$300.getValue());
                    if (access$400 == MutedMemberFilter.ALL) {
                        hashMap.put("muted_member_filter", "all");
                    } else if (access$400 == MutedMemberFilter.MUTED) {
                        hashMap.put("muted_member_filter", "muted");
                    } else if (access$400 == MutedMemberFilter.UNMUTED) {
                        hashMap.put("muted_member_filter", "unmuted");
                    }
                    hashMap.put(StringSet.member_state_filter, access$700);
                    if (access$800 != null) {
                        hashMap.put("nickname_startswith", access$800);
                    }
                    hashMap.put(StringSet.show_read_receipt, "true");
                    hashMap.put(StringSet.show_delivery_receipt, "true");
                    hashMap.put(StringSet.show_member_is_muted, "true");
                    JsonObject asJsonObject = a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject();
                    String unused = GroupChannelMemberListQuery.this.mToken = asJsonObject.get("next").getAsString();
                    if (GroupChannelMemberListQuery.this.mToken == null || GroupChannelMemberListQuery.this.mToken.length() <= 0) {
                        boolean unused2 = GroupChannelMemberListQuery.this.mHasNext = false;
                    }
                    JsonArray asJsonArray = asJsonObject.get("members").getAsJsonArray();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                        arrayList.add(new Member(asJsonArray.get(i2)));
                    }
                    return arrayList;
                }
            });
        }
    }
}
