package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PublicGroupChannelListQuery {
    private static final String MEMBER_STATE_ALL = "all";
    private static final String MEMBER_STATE_INVITED_BY_FRIEND_ONLY = "invited_by_friend";
    private static final String MEMBER_STATE_INVITED_BY_NON_FRIEND_ONLY = "invited_by_non_friend";
    private static final String MEMBER_STATE_INVITED_ONLY = "invited_only";
    private static final String MEMBER_STATE_JOINED_ONLY = "joined_only";
    private static final String ORDER_CHANNEL_NAME_ALPHABETICAL = "channel_name_alphabetical";
    private static final String ORDER_CHRONOLOGICAL = "chronological";
    static final String ORDER_METADATA_VALUE_ALPHABETICAL = "metadata_value_alphabetical";
    /* access modifiers changed from: private */
    public boolean includeFrozen = true;
    /* access modifiers changed from: private */
    public ArrayList<String> mChannelUrls;
    /* access modifiers changed from: private */
    public String mCustomTypeStartsWith;
    /* access modifiers changed from: private */
    public ArrayList<String> mCustomTypes;
    /* access modifiers changed from: private */
    public boolean mHasNext = true;
    /* access modifiers changed from: private */
    public boolean mIncludeEmpty = true;
    /* access modifiers changed from: private */
    public int mLimit = 20;
    private boolean mLoading = false;
    /* access modifiers changed from: private */
    public String mMemberState = "all";
    /* access modifiers changed from: private */
    public MembershipFilter mMembershipFilter = MembershipFilter.JOINED;
    /* access modifiers changed from: private */
    public String mMetaDataOrderKey;
    /* access modifiers changed from: private */
    public String mNameContains;
    /* access modifiers changed from: private */
    public String mOrder = "chronological";
    /* access modifiers changed from: private */
    public SuperChannelFilter mSuperChannelFilter = SuperChannelFilter.ALL;
    /* access modifiers changed from: private */
    public String mToken = "";

    public enum MembershipFilter {
        ALL,
        JOINED
    }

    public enum Order {
        CHRONOLOGICAL,
        CHANNEL_NAME_ALPHABETICAL,
        METADATA_VALUE_ALPHABETICAL
    }

    public interface PublicGroupChannelListQueryResultHandler {
        void onResult(List<GroupChannel> list, SendBirdException sendBirdException);
    }

    public enum SuperChannelFilter {
        ALL,
        SUPER_CHANNEL_ONLY,
        NONSUPER_CHANNEL_ONLY
    }

    PublicGroupChannelListQuery() {
    }

    public final int getLimit() {
        return this.mLimit;
    }

    public final void setLimit(int i2) {
        this.mLimit = i2;
    }

    public final boolean isIncludeEmpty() {
        return this.mIncludeEmpty;
    }

    public final void setIncludeEmpty(boolean z) {
        this.mIncludeEmpty = z;
    }

    public final Order getOrder() {
        if (this.mOrder.equals("channel_name_alphabetical")) {
            return Order.CHANNEL_NAME_ALPHABETICAL;
        }
        if (this.mOrder.equals("metadata_value_alphabetical")) {
            return Order.METADATA_VALUE_ALPHABETICAL;
        }
        return Order.CHRONOLOGICAL;
    }

    public final void setOrder(Order order) {
        if (order == Order.CHRONOLOGICAL) {
            this.mOrder = "chronological";
        } else if (order == Order.CHANNEL_NAME_ALPHABETICAL) {
            this.mOrder = "channel_name_alphabetical";
        } else if (order == Order.METADATA_VALUE_ALPHABETICAL) {
            this.mOrder = "metadata_value_alphabetical";
        }
    }

    public final String getMetaDataOrderKeyFilter() {
        return this.mMetaDataOrderKey;
    }

    public final void setMetaDataOrderKeyFilter(String str) {
        this.mMetaDataOrderKey = str;
    }

    public final String getCustomTypeStartsWithFilter() {
        return this.mCustomTypeStartsWith;
    }

    public final void setCustomTypeStartsWithFilter(String str) {
        this.mCustomTypeStartsWith = str;
    }

    public final List<String> getCustomTypesFilter() {
        return this.mCustomTypes;
    }

    public final void setCustomTypesFilter(List<String> list) {
        if (list != null && list.size() > 0) {
            this.mCustomTypes = new ArrayList<>();
            this.mCustomTypes.addAll(list);
        }
    }

    public final List<String> getChannelUrlsFilter() {
        return this.mChannelUrls;
    }

    public final void setChannelUrlsFilter(List<String> list) {
        if (list != null && list.size() > 0) {
            this.mChannelUrls = new ArrayList<>();
            this.mChannelUrls.addAll(list);
        }
    }

    public final String getChannelNameContainsFilter() {
        return this.mNameContains;
    }

    public final void setChannelNameContainsFilter(String str) {
        this.mNameContains = str;
    }

    public final SuperChannelFilter getSuperChannelFilter() {
        return this.mSuperChannelFilter;
    }

    public final void setSuperChannelFilter(SuperChannelFilter superChannelFilter) {
        this.mSuperChannelFilter = superChannelFilter;
    }

    public final MembershipFilter getMembershipFilter() {
        return this.mMembershipFilter;
    }

    public final void setMembershipFilter(MembershipFilter membershipFilter) {
        this.mMembershipFilter = membershipFilter;
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

    public final boolean isIncludeFrozen() {
        return this.includeFrozen;
    }

    public final void setIncludeFrozen(boolean z) {
        this.includeFrozen = z;
    }

    public final synchronized void next(final PublicGroupChannelListQueryResultHandler publicGroupChannelListQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    PublicGroupChannelListQueryResultHandler publicGroupChannelListQueryResultHandler = publicGroupChannelListQueryResultHandler;
                    if (publicGroupChannelListQueryResultHandler != null) {
                        publicGroupChannelListQueryResultHandler.onResult((List<GroupChannel>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasNext()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    PublicGroupChannelListQueryResultHandler publicGroupChannelListQueryResultHandler = publicGroupChannelListQueryResultHandler;
                    if (publicGroupChannelListQueryResultHandler != null) {
                        publicGroupChannelListQueryResultHandler.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<GroupChannel>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    PublicGroupChannelListQuery.this.setLoading(false);
                    PublicGroupChannelListQueryResultHandler publicGroupChannelListQueryResultHandler = publicGroupChannelListQueryResultHandler;
                    if (publicGroupChannelListQueryResultHandler != null) {
                        publicGroupChannelListQueryResultHandler.onResult(list, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    APIClient a2 = APIClient.a();
                    String access$000 = PublicGroupChannelListQuery.this.mToken;
                    int access$100 = PublicGroupChannelListQuery.this.mLimit;
                    boolean access$200 = PublicGroupChannelListQuery.this.mIncludeEmpty;
                    boolean access$300 = PublicGroupChannelListQuery.this.includeFrozen;
                    String access$400 = PublicGroupChannelListQuery.this.mOrder;
                    String access$500 = PublicGroupChannelListQuery.this.mMetaDataOrderKey;
                    String access$600 = PublicGroupChannelListQuery.this.mCustomTypeStartsWith;
                    String access$700 = PublicGroupChannelListQuery.this.mMemberState;
                    ArrayList access$800 = PublicGroupChannelListQuery.this.mChannelUrls;
                    String access$900 = PublicGroupChannelListQuery.this.mNameContains;
                    ArrayList access$1000 = PublicGroupChannelListQuery.this.mCustomTypes;
                    SuperChannelFilter access$1100 = PublicGroupChannelListQuery.this.mSuperChannelFilter;
                    MembershipFilter access$1200 = PublicGroupChannelListQuery.this.mMembershipFilter;
                    String publicUrl = b.GROUPCHANNELS.publicUrl();
                    HashMap hashMap = new HashMap();
                    APIClient aPIClient = a2;
                    String str = publicUrl;
                    hashMap.put(StringSet.public_mode, StringSet.PUBLIC);
                    hashMap.put(StringSet.token, access$000);
                    hashMap.put("limit", String.valueOf(access$100));
                    hashMap.put(StringSet.show_read_receipt, "true");
                    hashMap.put(StringSet.show_delivery_receipt, "true");
                    hashMap.put(StringSet.show_member, "true");
                    hashMap.put(StringSet.show_empty, String.valueOf(access$200));
                    hashMap.put(StringSet.show_frozen, String.valueOf(access$300));
                    hashMap.put(StringSet.distinct_mode, "all");
                    hashMap.put(StringSet.order, access$400);
                    if (access$400.equals("metadata_value_alphabetical") && access$500 != null) {
                        hashMap.put(StringSet.metadata_order_key, access$500);
                    }
                    if (access$600 != null) {
                        hashMap.put(StringSet.custom_type_startswith, access$600);
                    }
                    if (access$700 != null) {
                        hashMap.put(StringSet.member_state_filter, access$700);
                    }
                    if (access$900 != null) {
                        hashMap.put(StringSet.name_contains, access$900);
                    }
                    HashMap hashMap2 = new HashMap();
                    if (access$800 != null && access$800.size() > 0) {
                        hashMap2.put(StringSet.channel_urls, access$800);
                    }
                    if (access$1000 != null && access$1000.size() > 0) {
                        hashMap2.put(StringSet.custom_types, access$1000);
                    }
                    if (access$1100 == SuperChannelFilter.ALL) {
                        hashMap.put(StringSet.super_mode, "all");
                    } else if (access$1100 == SuperChannelFilter.SUPER_CHANNEL_ONLY) {
                        hashMap.put(StringSet.super_mode, StringSet.SUPER);
                    } else if (access$1100 == SuperChannelFilter.NONSUPER_CHANNEL_ONLY) {
                        hashMap.put(StringSet.super_mode, StringSet.nonsuper);
                    }
                    if (access$1200 == MembershipFilter.ALL) {
                        hashMap.put(StringSet.public_membership_mode, "all");
                    } else if (access$1200 == MembershipFilter.JOINED) {
                        hashMap.put(StringSet.public_membership_mode, StringSet.joined);
                    }
                    JsonObject asJsonObject = aPIClient.a(str, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2).getAsJsonObject();
                    String unused = PublicGroupChannelListQuery.this.mToken = asJsonObject.get("next").getAsString();
                    if (PublicGroupChannelListQuery.this.mToken == null || PublicGroupChannelListQuery.this.mToken.length() <= 0) {
                        boolean unused2 = PublicGroupChannelListQuery.this.mHasNext = false;
                    }
                    JsonArray asJsonArray = asJsonObject.get("channels").getAsJsonArray();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                        arrayList.add(GroupChannel.upsert(asJsonArray.get(i2), false));
                    }
                    return arrayList;
                }
            });
        }
    }
}
