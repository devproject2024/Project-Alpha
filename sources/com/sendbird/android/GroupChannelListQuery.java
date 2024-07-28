package com.sendbird.android;

import android.util.Base64;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GroupChannelListQuery {
    /* access modifiers changed from: private */
    public boolean includeFrozen;
    /* access modifiers changed from: private */
    public ArrayList<String> mChannelUrls;
    /* access modifiers changed from: private */
    public String mCustomType;
    /* access modifiers changed from: private */
    public String mCustomTypeStartsWith;
    /* access modifiers changed from: private */
    public ArrayList<String> mCustomTypes;
    /* access modifiers changed from: private */
    public ArrayList<String> mFilter;
    /* access modifiers changed from: private */
    public a mFilterMode;
    /* access modifiers changed from: private */
    public boolean mHasNext;
    /* access modifiers changed from: private */
    public HiddenChannelFilter mHiddenChannelFilter;
    /* access modifiers changed from: private */
    public boolean mIncludeEmpty;
    /* access modifiers changed from: private */
    public int mLimit;
    private boolean mLoading;
    /* access modifiers changed from: private */
    public String mMemberState;
    /* access modifiers changed from: private */
    public String mMetaDataOrderKey;
    /* access modifiers changed from: private */
    public String mNameContains;
    /* access modifiers changed from: private */
    public String mOrder;
    /* access modifiers changed from: private */
    public PublicChannelFilter mPublicChannelFilter;
    /* access modifiers changed from: private */
    public QueryType mQueryType;
    /* access modifiers changed from: private */
    public List<SearchField> mSearchFields;
    /* access modifiers changed from: private */
    public String mSearchQuery;
    /* access modifiers changed from: private */
    public SuperChannelFilter mSuperChannelFilter;
    /* access modifiers changed from: private */
    public String mToken;
    /* access modifiers changed from: private */
    public UnreadChannelFilter mUnreadChannelFilter;
    private final User mUser;

    public interface GroupChannelListQueryResultHandler {
        void onResult(List<GroupChannel> list, SendBirdException sendBirdException);
    }

    public enum HiddenChannelFilter {
        UNHIDDEN,
        HIDDEN,
        HIDDEN_ALLOW_AUTO_UNHIDE,
        HIDDEN_PREVENT_AUTO_UNHIDE
    }

    @Deprecated
    public enum MemberState {
        ALL,
        INVITED_ONLY,
        JOINED_ONLY
    }

    public enum MemberStateFilter {
        ALL,
        INVITED,
        INVITED_BY_FRIEND,
        INVITED_BY_NON_FRIEND,
        JOINED
    }

    public enum Order {
        CHRONOLOGICAL,
        LATEST_LAST_MESSAGE,
        CHANNEL_NAME_ALPHABETICAL,
        METADATA_VALUE_ALPHABETICAL
    }

    public enum PublicChannelFilter {
        ALL,
        PUBLIC,
        PRIVATE
    }

    public enum QueryType {
        AND,
        OR
    }

    public enum SearchField {
        MEMBER_NICKNAME,
        CHANNEL_NAME
    }

    public enum SuperChannelFilter {
        ALL,
        SUPER_CHANNEL_ONLY,
        NONSUPER_CHANNEL_ONLY
    }

    public enum UnreadChannelFilter {
        ALL,
        UNREAD_MESSAGE
    }

    enum a {
        ALL,
        MEMBERS_EXACTLY_IN,
        MEMBERS_NICKNAME_CONTAINS,
        MEMBERS_INCLUDE_IN
    }

    GroupChannelListQuery(User user) {
        this.mToken = "";
        this.mHasNext = true;
        this.mLimit = 20;
        this.mLoading = false;
        this.mIncludeEmpty = false;
        this.includeFrozen = true;
        this.mOrder = StringSet.latest_last_message;
        this.mFilterMode = a.ALL;
        this.mQueryType = QueryType.AND;
        this.mMemberState = StringSet.all;
        this.mSuperChannelFilter = SuperChannelFilter.ALL;
        this.mPublicChannelFilter = PublicChannelFilter.ALL;
        this.mUnreadChannelFilter = UnreadChannelFilter.ALL;
        this.mHiddenChannelFilter = HiddenChannelFilter.UNHIDDEN;
        this.mUser = user;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0422, code lost:
        if (r12.equals(com.sendbird.android.constant.StringSet.unhidden) != false) goto L_0x0430;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x042f A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0432  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0202  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    GroupChannelListQuery(com.sendbird.android.shadow.com.google.gson.JsonElement r12) {
        /*
            r11 = this;
            r11.<init>()
            java.lang.String r0 = ""
            r11.mToken = r0
            r1 = 1
            r11.mHasNext = r1
            r2 = 20
            r11.mLimit = r2
            r3 = 0
            r11.mLoading = r3
            r11.mIncludeEmpty = r3
            r11.includeFrozen = r1
            java.lang.String r4 = "latest_last_message"
            r11.mOrder = r4
            com.sendbird.android.GroupChannelListQuery$a r5 = com.sendbird.android.GroupChannelListQuery.a.ALL
            r11.mFilterMode = r5
            com.sendbird.android.GroupChannelListQuery$QueryType r5 = com.sendbird.android.GroupChannelListQuery.QueryType.AND
            r11.mQueryType = r5
            java.lang.String r5 = "all"
            r11.mMemberState = r5
            com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r6 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.ALL
            r11.mSuperChannelFilter = r6
            com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r6 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.ALL
            r11.mPublicChannelFilter = r6
            com.sendbird.android.GroupChannelListQuery$UnreadChannelFilter r6 = com.sendbird.android.GroupChannelListQuery.UnreadChannelFilter.ALL
            r11.mUnreadChannelFilter = r6
            com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r6 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.UNHIDDEN
            r11.mHiddenChannelFilter = r6
            com.sendbird.android.shadow.com.google.gson.JsonObject r12 = r12.getAsJsonObject()
            java.lang.String r6 = "user"
            boolean r7 = r12.has(r6)
            r8 = 0
            if (r7 == 0) goto L_0x004d
            com.sendbird.android.User r7 = new com.sendbird.android.User
            com.sendbird.android.shadow.com.google.gson.JsonElement r6 = r12.get(r6)
            r7.<init>(r6)
            goto L_0x004e
        L_0x004d:
            r7 = r8
        L_0x004e:
            r11.mUser = r7
            java.lang.String r6 = "token"
            boolean r7 = r12.has(r6)
            if (r7 == 0) goto L_0x0061
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r6)
            java.lang.String r0 = r0.getAsString()
        L_0x0061:
            r11.mToken = r0
            java.lang.String r0 = "has_next"
            boolean r6 = r12.has(r0)
            if (r6 == 0) goto L_0x0074
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            boolean r0 = r0.getAsBoolean()
            goto L_0x0075
        L_0x0074:
            r0 = 1
        L_0x0075:
            r11.mHasNext = r0
            java.lang.String r0 = "limit"
            boolean r6 = r12.has(r0)
            if (r6 == 0) goto L_0x0087
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            int r2 = r0.getAsInt()
        L_0x0087:
            r11.mLimit = r2
            java.lang.String r0 = "include_empty"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x009c
            java.lang.String r0 = "include_empty"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            boolean r0 = r0.getAsBoolean()
            goto L_0x009d
        L_0x009c:
            r0 = 0
        L_0x009d:
            r11.mIncludeEmpty = r0
            java.lang.String r0 = "include_frozen"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x00b2
            java.lang.String r0 = "include_frozen"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            boolean r0 = r0.getAsBoolean()
            goto L_0x00b3
        L_0x00b2:
            r0 = 1
        L_0x00b3:
            r11.includeFrozen = r0
            java.lang.String r0 = "order"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = "order"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r4 = r0.getAsString()
        L_0x00c7:
            r11.mOrder = r4
            java.lang.String r0 = "meta_data_order_key"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x00dc
            java.lang.String r0 = "meta_data_order_key"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x00dd
        L_0x00dc:
            r0 = r8
        L_0x00dd:
            r11.mMetaDataOrderKey = r0
            java.lang.String r0 = "filter_mode"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x00f2
            java.lang.String r0 = "filter_mode"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x00f3
        L_0x00f2:
            r0 = r5
        L_0x00f3:
            int r2 = r0.hashCode()
            r4 = 3
            r6 = -1
            r7 = 2
            switch(r2) {
                case -1518560982: goto L_0x011a;
                case 96673: goto L_0x0112;
                case 819269378: goto L_0x0108;
                case 2101750878: goto L_0x00fe;
                default: goto L_0x00fd;
            }
        L_0x00fd:
            goto L_0x0124
        L_0x00fe:
            java.lang.String r2 = "members_exactly_in"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0124
            r0 = 1
            goto L_0x0125
        L_0x0108:
            java.lang.String r2 = "members_include_in"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0124
            r0 = 2
            goto L_0x0125
        L_0x0112:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0124
            r0 = 0
            goto L_0x0125
        L_0x011a:
            java.lang.String r2 = "members_nickname_contains"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0124
            r0 = 3
            goto L_0x0125
        L_0x0124:
            r0 = -1
        L_0x0125:
            if (r0 == 0) goto L_0x0141
            if (r0 == r1) goto L_0x013c
            if (r0 == r7) goto L_0x0137
            if (r0 == r4) goto L_0x0132
            com.sendbird.android.GroupChannelListQuery$a r0 = com.sendbird.android.GroupChannelListQuery.a.ALL
            r11.mFilterMode = r0
            goto L_0x0145
        L_0x0132:
            com.sendbird.android.GroupChannelListQuery$a r0 = com.sendbird.android.GroupChannelListQuery.a.MEMBERS_NICKNAME_CONTAINS
            r11.mFilterMode = r0
            goto L_0x0145
        L_0x0137:
            com.sendbird.android.GroupChannelListQuery$a r0 = com.sendbird.android.GroupChannelListQuery.a.MEMBERS_INCLUDE_IN
            r11.mFilterMode = r0
            goto L_0x0145
        L_0x013c:
            com.sendbird.android.GroupChannelListQuery$a r0 = com.sendbird.android.GroupChannelListQuery.a.MEMBERS_EXACTLY_IN
            r11.mFilterMode = r0
            goto L_0x0145
        L_0x0141:
            com.sendbird.android.GroupChannelListQuery$a r0 = com.sendbird.android.GroupChannelListQuery.a.ALL
            r11.mFilterMode = r0
        L_0x0145:
            java.lang.String r0 = "query_type"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x0158
            java.lang.String r0 = "query_type"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x015a
        L_0x0158:
            java.lang.String r0 = "and"
        L_0x015a:
            int r2 = r0.hashCode()
            r9 = 3555(0xde3, float:4.982E-42)
            if (r2 == r9) goto L_0x0172
            r9 = 96727(0x179d7, float:1.35543E-40)
            if (r2 == r9) goto L_0x0168
            goto L_0x017c
        L_0x0168:
            java.lang.String r2 = "and"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x017c
            r0 = 0
            goto L_0x017d
        L_0x0172:
            java.lang.String r2 = "or"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x017c
            r0 = 1
            goto L_0x017d
        L_0x017c:
            r0 = -1
        L_0x017d:
            if (r0 == 0) goto L_0x018b
            if (r0 == r1) goto L_0x0186
            com.sendbird.android.GroupChannelListQuery$QueryType r0 = com.sendbird.android.GroupChannelListQuery.QueryType.AND
            r11.mQueryType = r0
            goto L_0x018f
        L_0x0186:
            com.sendbird.android.GroupChannelListQuery$QueryType r0 = com.sendbird.android.GroupChannelListQuery.QueryType.OR
            r11.mQueryType = r0
            goto L_0x018f
        L_0x018b:
            com.sendbird.android.GroupChannelListQuery$QueryType r0 = com.sendbird.android.GroupChannelListQuery.QueryType.AND
            r11.mQueryType = r0
        L_0x018f:
            java.lang.String r0 = "filter"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x01a2
            java.lang.String r0 = "filter"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            com.sendbird.android.shadow.com.google.gson.JsonArray r0 = r0.getAsJsonArray()
            goto L_0x01a3
        L_0x01a2:
            r0 = r8
        L_0x01a3:
            if (r0 == 0) goto L_0x01c3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r11.mFilter = r2
            r2 = 0
        L_0x01ad:
            int r9 = r0.size()
            if (r2 >= r9) goto L_0x01c3
            java.util.ArrayList<java.lang.String> r9 = r11.mFilter
            com.sendbird.android.shadow.com.google.gson.JsonElement r10 = r0.get(r2)
            java.lang.String r10 = r10.getAsString()
            r9.add(r10)
            int r2 = r2 + 1
            goto L_0x01ad
        L_0x01c3:
            java.lang.String r0 = "custom_type"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x01d6
            java.lang.String r0 = "custom_type"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x01d7
        L_0x01d6:
            r0 = r8
        L_0x01d7:
            r11.mCustomType = r0
            java.lang.String r0 = "custom_type_starts_with"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x01ec
            java.lang.String r0 = "custom_type_starts_with"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x01ed
        L_0x01ec:
            r0 = r8
        L_0x01ed:
            r11.mCustomTypeStartsWith = r0
            java.lang.String r0 = "member_state"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x0202
            java.lang.String r0 = "member_state"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x0203
        L_0x0202:
            r0 = r5
        L_0x0203:
            r11.mMemberState = r0
            java.lang.String r0 = "channel_urls"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x0218
            java.lang.String r0 = "channel_urls"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            com.sendbird.android.shadow.com.google.gson.JsonArray r0 = r0.getAsJsonArray()
            goto L_0x0219
        L_0x0218:
            r0 = r8
        L_0x0219:
            if (r0 == 0) goto L_0x0239
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r11.mChannelUrls = r2
            r2 = 0
        L_0x0223:
            int r9 = r0.size()
            if (r2 >= r9) goto L_0x0239
            java.util.ArrayList<java.lang.String> r9 = r11.mChannelUrls
            com.sendbird.android.shadow.com.google.gson.JsonElement r10 = r0.get(r2)
            java.lang.String r10 = r10.getAsString()
            r9.add(r10)
            int r2 = r2 + 1
            goto L_0x0223
        L_0x0239:
            java.lang.String r0 = "name_contains"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x024c
            java.lang.String r0 = "name_contains"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x024d
        L_0x024c:
            r0 = r8
        L_0x024d:
            r11.mNameContains = r0
            java.lang.String r0 = "search_query"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x0262
            java.lang.String r0 = "search_query"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x0263
        L_0x0262:
            r0 = r8
        L_0x0263:
            r11.mSearchQuery = r0
            java.lang.String r0 = "search_fields"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x0278
            java.lang.String r0 = "search_fields"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            com.sendbird.android.shadow.com.google.gson.JsonArray r0 = r0.getAsJsonArray()
            goto L_0x0279
        L_0x0278:
            r0 = r8
        L_0x0279:
            if (r0 == 0) goto L_0x02b3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r11.mSearchFields = r2
            r2 = 0
        L_0x0283:
            int r9 = r0.size()
            if (r2 >= r9) goto L_0x02b3
            com.sendbird.android.shadow.com.google.gson.JsonElement r9 = r0.get(r2)
            java.lang.String r9 = r9.getAsString()
            java.lang.String r10 = "member_nickname"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x02a1
            java.util.List<com.sendbird.android.GroupChannelListQuery$SearchField> r9 = r11.mSearchFields
            com.sendbird.android.GroupChannelListQuery$SearchField r10 = com.sendbird.android.GroupChannelListQuery.SearchField.MEMBER_NICKNAME
            r9.add(r10)
            goto L_0x02b0
        L_0x02a1:
            java.lang.String r10 = "channel_name"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x02b0
            java.util.List<com.sendbird.android.GroupChannelListQuery$SearchField> r9 = r11.mSearchFields
            com.sendbird.android.GroupChannelListQuery$SearchField r10 = com.sendbird.android.GroupChannelListQuery.SearchField.CHANNEL_NAME
            r9.add(r10)
        L_0x02b0:
            int r2 = r2 + 1
            goto L_0x0283
        L_0x02b3:
            java.lang.String r0 = "custom_types"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x02c5
            java.lang.String r0 = "custom_types"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            com.sendbird.android.shadow.com.google.gson.JsonArray r8 = r0.getAsJsonArray()
        L_0x02c5:
            if (r8 == 0) goto L_0x02e5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11.mCustomTypes = r0
            r0 = 0
        L_0x02cf:
            int r2 = r8.size()
            if (r0 >= r2) goto L_0x02e5
            java.util.ArrayList<java.lang.String> r2 = r11.mCustomTypes
            com.sendbird.android.shadow.com.google.gson.JsonElement r9 = r8.get(r0)
            java.lang.String r9 = r9.getAsString()
            r2.add(r9)
            int r0 = r0 + 1
            goto L_0x02cf
        L_0x02e5:
            java.lang.String r0 = "super_channel_filter"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x02fa
            java.lang.String r0 = "super_channel_filter"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x02fb
        L_0x02fa:
            r0 = r5
        L_0x02fb:
            int r2 = r0.hashCode()
            r8 = 96673(0x179a1, float:1.35468E-40)
            if (r2 == r8) goto L_0x0324
            r9 = 1628979116(0x61183fac, float:1.7553082E20)
            if (r2 == r9) goto L_0x0319
            r9 = 2124760670(0x7ea5465e, float:1.0984399E38)
            if (r2 == r9) goto L_0x030f
            goto L_0x032c
        L_0x030f:
            java.lang.String r2 = "non_super_channel_only"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x032c
            r0 = 2
            goto L_0x032d
        L_0x0319:
            java.lang.String r2 = "super_channel_only"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x032c
            r0 = 1
            goto L_0x032d
        L_0x0324:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x032c
            r0 = 0
            goto L_0x032d
        L_0x032c:
            r0 = -1
        L_0x032d:
            if (r0 == 0) goto L_0x0342
            if (r0 == r1) goto L_0x033d
            if (r0 == r7) goto L_0x0338
            com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.ALL
            r11.mSuperChannelFilter = r0
            goto L_0x0346
        L_0x0338:
            com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.NONSUPER_CHANNEL_ONLY
            r11.mSuperChannelFilter = r0
            goto L_0x0346
        L_0x033d:
            com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.SUPER_CHANNEL_ONLY
            r11.mSuperChannelFilter = r0
            goto L_0x0346
        L_0x0342:
            com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.ALL
            r11.mSuperChannelFilter = r0
        L_0x0346:
            java.lang.String r0 = "public_channel_filter"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x0359
            java.lang.String r0 = "public_channel_filter"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x035a
        L_0x0359:
            r0 = r5
        L_0x035a:
            int r2 = r0.hashCode()
            r9 = -977423767(0xffffffffc5bdb269, float:-6070.3013)
            if (r2 == r9) goto L_0x037d
            r9 = -314497661(0xffffffffed412583, float:-3.7359972E27)
            if (r2 == r9) goto L_0x0373
            if (r2 == r8) goto L_0x036b
            goto L_0x0387
        L_0x036b:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0387
            r0 = 0
            goto L_0x0388
        L_0x0373:
            java.lang.String r2 = "private"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0387
            r0 = 2
            goto L_0x0388
        L_0x037d:
            java.lang.String r2 = "public"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0387
            r0 = 1
            goto L_0x0388
        L_0x0387:
            r0 = -1
        L_0x0388:
            if (r0 == 0) goto L_0x039d
            if (r0 == r1) goto L_0x0398
            if (r0 == r7) goto L_0x0393
            com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.ALL
            r11.mPublicChannelFilter = r0
            goto L_0x03a1
        L_0x0393:
            com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.PRIVATE
            r11.mPublicChannelFilter = r0
            goto L_0x03a1
        L_0x0398:
            com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.PUBLIC
            r11.mPublicChannelFilter = r0
            goto L_0x03a1
        L_0x039d:
            com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.ALL
            r11.mPublicChannelFilter = r0
        L_0x03a1:
            java.lang.String r0 = "unread_channel_filter"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x03b6
            java.lang.String r0 = "unread_channel_filter"
            com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r12.get(r0)
            java.lang.String r0 = r0.getAsString()
            goto L_0x03b7
        L_0x03b6:
            r0 = r5
        L_0x03b7:
            int r2 = r0.hashCode()
            if (r2 == r8) goto L_0x03ce
            r5 = 571079543(0x2209fb77, float:1.8700087E-18)
            if (r2 == r5) goto L_0x03c3
            goto L_0x03d6
        L_0x03c3:
            java.lang.String r2 = "unread_message"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x03d6
            r0 = 1
            goto L_0x03d7
        L_0x03ce:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x03d6
            r0 = 0
            goto L_0x03d7
        L_0x03d6:
            r0 = -1
        L_0x03d7:
            if (r0 == 0) goto L_0x03e5
            if (r0 == r1) goto L_0x03e0
            com.sendbird.android.GroupChannelListQuery$UnreadChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.UnreadChannelFilter.ALL
            r11.mUnreadChannelFilter = r0
            goto L_0x03e9
        L_0x03e0:
            com.sendbird.android.GroupChannelListQuery$UnreadChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.UnreadChannelFilter.UNREAD_MESSAGE
            r11.mUnreadChannelFilter = r0
            goto L_0x03e9
        L_0x03e5:
            com.sendbird.android.GroupChannelListQuery$UnreadChannelFilter r0 = com.sendbird.android.GroupChannelListQuery.UnreadChannelFilter.ALL
            r11.mUnreadChannelFilter = r0
        L_0x03e9:
            java.lang.String r0 = "hidden_channel_filter"
            boolean r0 = r12.has(r0)
            if (r0 == 0) goto L_0x03fc
            java.lang.String r0 = "hidden_channel_filter"
            com.sendbird.android.shadow.com.google.gson.JsonElement r12 = r12.get(r0)
            java.lang.String r12 = r12.getAsString()
            goto L_0x03ff
        L_0x03fc:
            java.lang.String r12 = "unhidden"
        L_0x03ff:
            int r0 = r12.hashCode()
            switch(r0) {
                case -1217487446: goto L_0x0425;
                case -330984061: goto L_0x041b;
                case -2969440: goto L_0x0411;
                case 1304298991: goto L_0x0407;
                default: goto L_0x0406;
            }
        L_0x0406:
            goto L_0x042f
        L_0x0407:
            java.lang.String r0 = "hidden_prevent_auto_unhide"
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto L_0x042f
            r3 = 3
            goto L_0x0430
        L_0x0411:
            java.lang.String r0 = "hidden_allow_auto_unhide"
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto L_0x042f
            r3 = 2
            goto L_0x0430
        L_0x041b:
            java.lang.String r0 = "unhidden"
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto L_0x042f
            goto L_0x0430
        L_0x0425:
            java.lang.String r0 = "hidden"
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto L_0x042f
            r3 = 1
            goto L_0x0430
        L_0x042f:
            r3 = -1
        L_0x0430:
            if (r3 == 0) goto L_0x044c
            if (r3 == r1) goto L_0x0447
            if (r3 == r7) goto L_0x0442
            if (r3 == r4) goto L_0x043d
            com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r12 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.UNHIDDEN
            r11.mHiddenChannelFilter = r12
            return
        L_0x043d:
            com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r12 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.HIDDEN_PREVENT_AUTO_UNHIDE
            r11.mHiddenChannelFilter = r12
            return
        L_0x0442:
            com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r12 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.HIDDEN_ALLOW_AUTO_UNHIDE
            r11.mHiddenChannelFilter = r12
            return
        L_0x0447:
            com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r12 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.HIDDEN
            r11.mHiddenChannelFilter = r12
            return
        L_0x044c:
            com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r12 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.UNHIDDEN
            r11.mHiddenChannelFilter = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannelListQuery.<init>(com.sendbird.android.shadow.com.google.gson.JsonElement):void");
    }

    /* access modifiers changed from: package-private */
    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        User user = this.mUser;
        if (user != null) {
            jsonObject.add(StringSet.user, user.toJson());
        }
        jsonObject.addProperty(StringSet.token, this.mToken);
        jsonObject.addProperty(StringSet.has_next, Boolean.valueOf(this.mHasNext));
        jsonObject.addProperty("limit", (Number) Integer.valueOf(this.mLimit));
        jsonObject.addProperty(StringSet.include_empty, Boolean.valueOf(this.mIncludeEmpty));
        jsonObject.addProperty(StringSet.include_frozen, Boolean.valueOf(this.includeFrozen));
        jsonObject.addProperty(StringSet.order, this.mOrder);
        String str = this.mMetaDataOrderKey;
        if (str != null) {
            jsonObject.addProperty(StringSet.meta_data_order_key, str);
        }
        int i2 = AnonymousClass4.f44381a[this.mFilterMode.ordinal()];
        if (i2 == 1) {
            jsonObject.addProperty(StringSet.filter_mode, StringSet.all);
        } else if (i2 == 2) {
            jsonObject.addProperty(StringSet.filter_mode, StringSet.members_exactly_in);
        } else if (i2 == 3) {
            jsonObject.addProperty(StringSet.filter_mode, StringSet.members_include_in);
        } else if (i2 != 4) {
            jsonObject.addProperty(StringSet.filter_mode, StringSet.all);
        } else {
            jsonObject.addProperty(StringSet.filter_mode, StringSet.members_nickname_contains);
        }
        int i3 = AnonymousClass4.f44382b[this.mQueryType.ordinal()];
        if (i3 == 1) {
            jsonObject.addProperty(StringSet.query_type, StringSet.and);
        } else if (i3 != 2) {
            jsonObject.addProperty(StringSet.query_type, StringSet.and);
        } else {
            jsonObject.addProperty(StringSet.query_type, "or");
        }
        if (this.mFilter != null) {
            JsonArray jsonArray = new JsonArray();
            Iterator<String> it2 = this.mFilter.iterator();
            while (it2.hasNext()) {
                jsonArray.add(it2.next());
            }
            jsonObject.add(StringSet.filter, jsonArray);
        }
        String str2 = this.mSearchQuery;
        if (str2 != null) {
            jsonObject.addProperty(StringSet.search_query, str2);
        }
        if (this.mSearchFields != null) {
            JsonArray jsonArray2 = new JsonArray();
            for (SearchField next : this.mSearchFields) {
                if (next == SearchField.MEMBER_NICKNAME) {
                    jsonArray2.add(StringSet.member_nickname);
                } else if (next == SearchField.CHANNEL_NAME) {
                    jsonArray2.add(StringSet.channel_name);
                }
            }
            jsonObject.add(StringSet.search_fields, jsonArray2);
        }
        String str3 = this.mCustomType;
        if (str3 != null) {
            jsonObject.addProperty(StringSet.custom_type, str3);
        }
        String str4 = this.mCustomTypeStartsWith;
        if (str4 != null) {
            jsonObject.addProperty(StringSet.custom_type_starts_with, str4);
        }
        jsonObject.addProperty(StringSet.member_state, this.mMemberState);
        if (this.mChannelUrls != null) {
            JsonArray jsonArray3 = new JsonArray();
            Iterator<String> it3 = this.mChannelUrls.iterator();
            while (it3.hasNext()) {
                jsonArray3.add(it3.next());
            }
            jsonObject.add(StringSet.channel_urls, jsonArray3);
        }
        String str5 = this.mNameContains;
        if (str5 != null) {
            jsonObject.addProperty(StringSet.name_contains, str5);
        }
        if (this.mCustomTypes != null) {
            JsonArray jsonArray4 = new JsonArray();
            Iterator<String> it4 = this.mCustomTypes.iterator();
            while (it4.hasNext()) {
                jsonArray4.add(it4.next());
            }
            jsonObject.add(StringSet.custom_types, jsonArray4);
        }
        int i4 = AnonymousClass4.f44383c[this.mSuperChannelFilter.ordinal()];
        if (i4 == 1) {
            jsonObject.addProperty(StringSet.super_channel_filter, StringSet.all);
        } else if (i4 == 2) {
            jsonObject.addProperty(StringSet.super_channel_filter, StringSet.super_channel_only);
        } else if (i4 != 3) {
            jsonObject.addProperty(StringSet.super_channel_filter, StringSet.all);
        } else {
            jsonObject.addProperty(StringSet.super_channel_filter, StringSet.non_super_channel_only);
        }
        int i5 = AnonymousClass4.f44384d[this.mPublicChannelFilter.ordinal()];
        if (i5 == 1) {
            jsonObject.addProperty(StringSet.public_channel_filter, StringSet.all);
        } else if (i5 == 2) {
            jsonObject.addProperty(StringSet.public_channel_filter, StringSet.PUBLIC);
        } else if (i5 != 3) {
            jsonObject.addProperty(StringSet.public_channel_filter, StringSet.all);
        } else {
            jsonObject.addProperty(StringSet.public_channel_filter, StringSet.PRIVATE);
        }
        int i6 = AnonymousClass4.f44385e[this.mUnreadChannelFilter.ordinal()];
        if (i6 == 1) {
            jsonObject.addProperty(StringSet.unread_channel_filter, StringSet.all);
        } else if (i6 != 2) {
            jsonObject.addProperty(StringSet.unread_channel_filter, StringSet.all);
        } else {
            jsonObject.addProperty(StringSet.unread_channel_filter, StringSet.unread_message);
        }
        int i7 = AnonymousClass4.f44386f[this.mHiddenChannelFilter.ordinal()];
        if (i7 == 1) {
            jsonObject.addProperty(StringSet.hidden_channel_filter, StringSet.unhidden);
        } else if (i7 == 2) {
            jsonObject.addProperty(StringSet.hidden_channel_filter, StringSet.hidden);
        } else if (i7 == 3) {
            jsonObject.addProperty(StringSet.hidden_channel_filter, StringSet.hidden_allow_auto_unhide);
        } else if (i7 == 4) {
            jsonObject.addProperty(StringSet.hidden_channel_filter, StringSet.hidden_prevent_auto_unhide);
        }
        return jsonObject;
    }

    /* renamed from: com.sendbird.android.GroupChannelListQuery$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44381a = new int[a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f44382b = new int[QueryType.values().length];

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f44383c = new int[SuperChannelFilter.values().length];

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f44384d = new int[PublicChannelFilter.values().length];

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ int[] f44385e = new int[UnreadChannelFilter.values().length];

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ int[] f44386f = new int[HiddenChannelFilter.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|(2:27|28)|29|31|32|33|34|(2:35|36)|37|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|(2:27|28)|29|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00d0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00da */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00e4 */
        static {
            /*
                com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter[] r0 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44386f = r0
                r0 = 1
                int[] r1 = f44386f     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r2 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.UNHIDDEN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f44386f     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r3 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.HIDDEN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f44386f     // Catch:{ NoSuchFieldError -> 0x002a }
                com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r4 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.HIDDEN_ALLOW_AUTO_UNHIDE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f44386f     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.sendbird.android.GroupChannelListQuery$HiddenChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.HiddenChannelFilter.HIDDEN_PREVENT_AUTO_UNHIDE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.sendbird.android.GroupChannelListQuery$UnreadChannelFilter[] r4 = com.sendbird.android.GroupChannelListQuery.UnreadChannelFilter.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f44385e = r4
                int[] r4 = f44385e     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.sendbird.android.GroupChannelListQuery$UnreadChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.UnreadChannelFilter.ALL     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r4 = f44385e     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.sendbird.android.GroupChannelListQuery$UnreadChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.UnreadChannelFilter.UNREAD_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                com.sendbird.android.GroupChannelListQuery$PublicChannelFilter[] r4 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f44384d = r4
                int[] r4 = f44384d     // Catch:{ NoSuchFieldError -> 0x0065 }
                com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.ALL     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r4 = f44384d     // Catch:{ NoSuchFieldError -> 0x006f }
                com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.PUBLIC     // Catch:{ NoSuchFieldError -> 0x006f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r4 = f44384d     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.sendbird.android.GroupChannelListQuery$PublicChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.PublicChannelFilter.PRIVATE     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                com.sendbird.android.GroupChannelListQuery$SuperChannelFilter[] r4 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f44383c = r4
                int[] r4 = f44383c     // Catch:{ NoSuchFieldError -> 0x008c }
                com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.ALL     // Catch:{ NoSuchFieldError -> 0x008c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                int[] r4 = f44383c     // Catch:{ NoSuchFieldError -> 0x0096 }
                com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.SUPER_CHANNEL_ONLY     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                int[] r4 = f44383c     // Catch:{ NoSuchFieldError -> 0x00a0 }
                com.sendbird.android.GroupChannelListQuery$SuperChannelFilter r5 = com.sendbird.android.GroupChannelListQuery.SuperChannelFilter.NONSUPER_CHANNEL_ONLY     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.sendbird.android.GroupChannelListQuery$QueryType[] r4 = com.sendbird.android.GroupChannelListQuery.QueryType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f44382b = r4
                int[] r4 = f44382b     // Catch:{ NoSuchFieldError -> 0x00b3 }
                com.sendbird.android.GroupChannelListQuery$QueryType r5 = com.sendbird.android.GroupChannelListQuery.QueryType.AND     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                int[] r4 = f44382b     // Catch:{ NoSuchFieldError -> 0x00bd }
                com.sendbird.android.GroupChannelListQuery$QueryType r5 = com.sendbird.android.GroupChannelListQuery.QueryType.OR     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                com.sendbird.android.GroupChannelListQuery$a[] r4 = com.sendbird.android.GroupChannelListQuery.a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f44381a = r4
                int[] r4 = f44381a     // Catch:{ NoSuchFieldError -> 0x00d0 }
                com.sendbird.android.GroupChannelListQuery$a r5 = com.sendbird.android.GroupChannelListQuery.a.ALL     // Catch:{ NoSuchFieldError -> 0x00d0 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d0 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00d0 }
            L_0x00d0:
                int[] r0 = f44381a     // Catch:{ NoSuchFieldError -> 0x00da }
                com.sendbird.android.GroupChannelListQuery$a r4 = com.sendbird.android.GroupChannelListQuery.a.MEMBERS_EXACTLY_IN     // Catch:{ NoSuchFieldError -> 0x00da }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00da }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00da }
            L_0x00da:
                int[] r0 = f44381a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.sendbird.android.GroupChannelListQuery$a r1 = com.sendbird.android.GroupChannelListQuery.a.MEMBERS_INCLUDE_IN     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f44381a     // Catch:{ NoSuchFieldError -> 0x00ee }
                com.sendbird.android.GroupChannelListQuery$a r1 = com.sendbird.android.GroupChannelListQuery.a.MEMBERS_NICKNAME_CONTAINS     // Catch:{ NoSuchFieldError -> 0x00ee }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ee }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00ee }
            L_0x00ee:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.GroupChannelListQuery.AnonymousClass4.<clinit>():void");
        }
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
        if (this.mOrder.equals(StringSet.chronological)) {
            return Order.CHRONOLOGICAL;
        }
        if (this.mOrder.equals(StringSet.channel_name_alphabetical)) {
            return Order.CHANNEL_NAME_ALPHABETICAL;
        }
        if (this.mOrder.equals(StringSet.metadata_value_alphabetical)) {
            return Order.METADATA_VALUE_ALPHABETICAL;
        }
        return Order.LATEST_LAST_MESSAGE;
    }

    public final void setOrder(Order order) {
        if (order == Order.CHRONOLOGICAL) {
            this.mOrder = StringSet.chronological;
        } else if (order == Order.CHANNEL_NAME_ALPHABETICAL) {
            this.mOrder = StringSet.channel_name_alphabetical;
        } else if (order == Order.METADATA_VALUE_ALPHABETICAL) {
            this.mOrder = StringSet.metadata_value_alphabetical;
        } else {
            this.mOrder = StringSet.latest_last_message;
        }
    }

    public final String getMetaDataOrderKeyFilter() {
        return this.mMetaDataOrderKey;
    }

    public final void setMetaDataOrderKeyFilter(String str) {
        this.mMetaDataOrderKey = str;
    }

    public final String getNicknameContainsFilter() {
        ArrayList<String> arrayList;
        if (this.mFilterMode != a.MEMBERS_NICKNAME_CONTAINS || (arrayList = this.mFilter) == null) {
            return null;
        }
        return arrayList.get(0);
    }

    public final void setNicknameContainsFilter(String str) {
        if (str == null || str.length() == 0) {
            this.mFilterMode = a.ALL;
            return;
        }
        this.mFilterMode = a.MEMBERS_NICKNAME_CONTAINS;
        this.mFilter = new ArrayList<>();
        this.mFilter.add(str);
    }

    @Deprecated
    public final void setUserIdsFilter(List<String> list, boolean z) {
        if (list == null) {
            this.mFilterMode = a.ALL;
            return;
        }
        if (z) {
            this.mFilterMode = a.MEMBERS_EXACTLY_IN;
        } else {
            this.mFilterMode = a.MEMBERS_INCLUDE_IN;
        }
        this.mFilter = new ArrayList<>();
        this.mFilter.addAll(list);
    }

    public final List<String> getUserIdsIncludeFilter() {
        ArrayList<String> arrayList;
        if (this.mFilterMode != a.MEMBERS_INCLUDE_IN || (arrayList = this.mFilter) == null) {
            return null;
        }
        return new ArrayList(arrayList);
    }

    public final QueryType getUserIdsIncludeFilterQueryType() {
        return this.mQueryType;
    }

    public final void setUserIdsIncludeFilter(List<String> list, QueryType queryType) {
        if (list == null) {
            this.mFilterMode = a.ALL;
            return;
        }
        this.mFilterMode = a.MEMBERS_INCLUDE_IN;
        this.mQueryType = queryType;
        this.mFilter = new ArrayList<>();
        this.mFilter.addAll(list);
    }

    public final List<String> getUserIdsExactFilter() {
        ArrayList<String> arrayList;
        if (this.mFilterMode != a.MEMBERS_EXACTLY_IN || (arrayList = this.mFilter) == null) {
            return null;
        }
        return new ArrayList(arrayList);
    }

    public final void setUserIdsExactFilter(List<String> list) {
        if (list == null) {
            this.mFilterMode = a.ALL;
            return;
        }
        this.mFilterMode = a.MEMBERS_EXACTLY_IN;
        this.mFilter = new ArrayList<>();
        this.mFilter.addAll(list);
    }

    public final void setSearchFilter(List<SearchField> list, String str) {
        if (list != null && list.size() != 0 && str != null && !str.isEmpty()) {
            this.mSearchQuery = str;
            this.mSearchFields = list;
        }
    }

    public final String getSearchQuery() {
        return this.mSearchQuery;
    }

    public final List<SearchField> getSearchFields() {
        List<SearchField> list = this.mSearchFields;
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    @Deprecated
    public final void setCustomTypeFilter(String str) {
        this.mCustomType = str;
    }

    public final String getCustomTypeStartsWithFilter() {
        return this.mCustomTypeStartsWith;
    }

    public final void setCustomTypeStartsWithFilter(String str) {
        this.mCustomTypeStartsWith = str;
    }

    public final List<String> getCustomTypesFilter() {
        ArrayList<String> arrayList = this.mCustomTypes;
        if (arrayList == null) {
            return null;
        }
        return new ArrayList(arrayList);
    }

    public final void setCustomTypesFilter(List<String> list) {
        if (list != null && list.size() > 0) {
            this.mCustomTypes = new ArrayList<>();
            this.mCustomTypes.addAll(list);
        }
    }

    @Deprecated
    public final void setMemberStateFilter(MemberState memberState) {
        if (memberState == MemberState.INVITED_ONLY) {
            this.mMemberState = StringSet.invited_only;
        } else if (memberState == MemberState.JOINED_ONLY) {
            this.mMemberState = StringSet.joined_only;
        } else {
            this.mMemberState = StringSet.all;
        }
    }

    @Deprecated
    public final void setMemberStateFilter(GroupChannel.MemberState memberState) {
        if (memberState == GroupChannel.MemberState.INVITED) {
            this.mMemberState = StringSet.invited_only;
        } else if (memberState == GroupChannel.MemberState.INVITED_BY_FRIEND) {
            this.mMemberState = StringSet.invited_by_friend;
        } else if (memberState == GroupChannel.MemberState.INVITED_BY_NON_FRIEND) {
            this.mMemberState = StringSet.invited_by_non_friend;
        } else if (memberState == GroupChannel.MemberState.JOINED) {
            this.mMemberState = StringSet.joined_only;
        } else {
            this.mMemberState = StringSet.all;
        }
    }

    public final MemberStateFilter getMemberStateFilter() {
        if (this.mMemberState.equals(StringSet.invited_only)) {
            return MemberStateFilter.INVITED;
        }
        if (this.mMemberState.equals(StringSet.invited_by_friend)) {
            return MemberStateFilter.INVITED_BY_FRIEND;
        }
        if (this.mMemberState.equals(StringSet.invited_by_non_friend)) {
            return MemberStateFilter.INVITED_BY_NON_FRIEND;
        }
        if (this.mMemberState.equals(StringSet.joined_only)) {
            return MemberStateFilter.JOINED;
        }
        return MemberStateFilter.ALL;
    }

    public final void setMemberStateFilter(MemberStateFilter memberStateFilter) {
        if (memberStateFilter == MemberStateFilter.INVITED) {
            this.mMemberState = StringSet.invited_only;
        } else if (memberStateFilter == MemberStateFilter.INVITED_BY_FRIEND) {
            this.mMemberState = StringSet.invited_by_friend;
        } else if (memberStateFilter == MemberStateFilter.INVITED_BY_NON_FRIEND) {
            this.mMemberState = StringSet.invited_by_non_friend;
        } else if (memberStateFilter == MemberStateFilter.JOINED) {
            this.mMemberState = StringSet.joined_only;
        } else {
            this.mMemberState = StringSet.all;
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

    public final PublicChannelFilter getPublicChannelFilter() {
        return this.mPublicChannelFilter;
    }

    public final void setPublicChannelFilter(PublicChannelFilter publicChannelFilter) {
        this.mPublicChannelFilter = publicChannelFilter;
    }

    public final UnreadChannelFilter getUnreadChannelFilter() {
        return this.mUnreadChannelFilter;
    }

    public final void setUnreadChannelFilter(UnreadChannelFilter unreadChannelFilter) {
        this.mUnreadChannelFilter = unreadChannelFilter;
    }

    public final HiddenChannelFilter getHiddenChannelFilter() {
        return this.mHiddenChannelFilter;
    }

    public final void setHiddenChannelFilter(HiddenChannelFilter hiddenChannelFilter) {
        this.mHiddenChannelFilter = hiddenChannelFilter;
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

    public final synchronized void next(final GroupChannelListQueryResultHandler groupChannelListQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    GroupChannelListQueryResultHandler groupChannelListQueryResultHandler = groupChannelListQueryResultHandler;
                    if (groupChannelListQueryResultHandler != null) {
                        groupChannelListQueryResultHandler.onResult((List<GroupChannel>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasNext()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    GroupChannelListQueryResultHandler groupChannelListQueryResultHandler = groupChannelListQueryResultHandler;
                    if (groupChannelListQueryResultHandler != null) {
                        groupChannelListQueryResultHandler.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<GroupChannel>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    GroupChannelListQuery.this.setLoading(false);
                    GroupChannelListQueryResultHandler groupChannelListQueryResultHandler = groupChannelListQueryResultHandler;
                    if (groupChannelListQueryResultHandler != null) {
                        groupChannelListQueryResultHandler.onResult(list, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    boolean z;
                    APIClient a2 = APIClient.a();
                    String access$000 = GroupChannelListQuery.this.mToken;
                    int access$100 = GroupChannelListQuery.this.mLimit;
                    boolean access$200 = GroupChannelListQuery.this.mIncludeEmpty;
                    boolean access$300 = GroupChannelListQuery.this.includeFrozen;
                    String access$400 = GroupChannelListQuery.this.mOrder;
                    String access$500 = GroupChannelListQuery.this.mMetaDataOrderKey;
                    a access$600 = GroupChannelListQuery.this.mFilterMode;
                    ArrayList access$700 = GroupChannelListQuery.this.mFilter;
                    QueryType access$800 = GroupChannelListQuery.this.mQueryType;
                    String access$900 = GroupChannelListQuery.this.mSearchQuery;
                    List access$1000 = GroupChannelListQuery.this.mSearchFields;
                    String access$1100 = GroupChannelListQuery.this.mCustomType;
                    String access$1200 = GroupChannelListQuery.this.mCustomTypeStartsWith;
                    String access$1300 = GroupChannelListQuery.this.mMemberState;
                    APIClient aPIClient = a2;
                    ArrayList access$1400 = GroupChannelListQuery.this.mChannelUrls;
                    String access$1500 = GroupChannelListQuery.this.mNameContains;
                    List<SearchField> list = access$1000;
                    ArrayList access$1600 = GroupChannelListQuery.this.mCustomTypes;
                    SuperChannelFilter access$1700 = GroupChannelListQuery.this.mSuperChannelFilter;
                    PublicChannelFilter access$1800 = GroupChannelListQuery.this.mPublicChannelFilter;
                    UnreadChannelFilter access$1900 = GroupChannelListQuery.this.mUnreadChannelFilter;
                    HiddenChannelFilter access$2000 = GroupChannelListQuery.this.mHiddenChannelFilter;
                    if (SendBird.getCurrentUser() != null) {
                        HiddenChannelFilter hiddenChannelFilter = access$2000;
                        String str = access$900;
                        String format = String.format(b.USERS_USERID_MYGROUPCHANNELS.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        HashMap hashMap = new HashMap();
                        hashMap.put(StringSet.token, access$000);
                        hashMap.put("limit", String.valueOf(access$100));
                        hashMap.put(StringSet.show_read_receipt, "true");
                        hashMap.put(StringSet.show_delivery_receipt, "true");
                        hashMap.put(StringSet.show_member, "true");
                        hashMap.put(StringSet.show_empty, String.valueOf(access$200));
                        hashMap.put(StringSet.show_frozen, String.valueOf(access$300));
                        hashMap.put(StringSet.distinct_mode, StringSet.all);
                        hashMap.put(StringSet.order, access$400);
                        if (access$400.equals(StringSet.metadata_value_alphabetical) && access$500 != null) {
                            hashMap.put(StringSet.metadata_order_key, access$500);
                        }
                        if (access$1100 != null) {
                            hashMap.put(StringSet.custom_type, access$1100);
                        }
                        if (access$1200 != null) {
                            hashMap.put(StringSet.custom_type_startswith, access$1200);
                        }
                        if (access$1300 != null) {
                            hashMap.put(StringSet.member_state_filter, access$1300);
                        }
                        if (access$1500 != null) {
                            hashMap.put(StringSet.name_contains, access$1500);
                        }
                        String str2 = null;
                        if (access$600 == a.MEMBERS_EXACTLY_IN) {
                            str2 = StringSet.members_exactly_in;
                        } else if (access$600 == a.MEMBERS_NICKNAME_CONTAINS) {
                            str2 = StringSet.members_nickname_contains;
                        } else if (access$600 == a.MEMBERS_INCLUDE_IN) {
                            if (access$800 == QueryType.AND) {
                                str2 = "AND";
                            } else if (access$800 == QueryType.OR) {
                                str2 = "OR";
                            }
                            if (str2 != null) {
                                hashMap.put(StringSet.query_type, str2);
                            }
                            str2 = StringSet.members_include_in;
                        }
                        HashMap hashMap2 = new HashMap();
                        if (!(str2 == null || access$700 == null || access$700.size() <= 0)) {
                            hashMap2.put(str2, access$700);
                        }
                        if (!(str == null || list == null)) {
                            hashMap.put(StringSet.search_query, str);
                            boolean z2 = false;
                            boolean z3 = false;
                            for (SearchField searchField : list) {
                                if (searchField == SearchField.CHANNEL_NAME) {
                                    z3 = true;
                                }
                                if (searchField == SearchField.MEMBER_NICKNAME) {
                                    z2 = true;
                                }
                            }
                            String str3 = "";
                            String str4 = z3 ? StringSet.channel_name : str3;
                            if (z2) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str4);
                                if (!str4.isEmpty()) {
                                    str3 = AppConstants.COMMA;
                                }
                                sb.append(str3);
                                str4 = sb.toString() + StringSet.member_nickname;
                            }
                            if (!str4.isEmpty()) {
                                hashMap.put(StringSet.search_fields, str4);
                            }
                        }
                        if (access$1400 != null && access$1400.size() > 0) {
                            hashMap2.put(StringSet.channel_urls, access$1400);
                        }
                        if (access$1600 != null && access$1600.size() > 0) {
                            hashMap2.put(StringSet.custom_types, access$1600);
                        }
                        SuperChannelFilter superChannelFilter = access$1700;
                        if (superChannelFilter == SuperChannelFilter.ALL) {
                            hashMap.put(StringSet.super_mode, StringSet.all);
                        } else if (superChannelFilter == SuperChannelFilter.SUPER_CHANNEL_ONLY) {
                            hashMap.put(StringSet.super_mode, StringSet.SUPER);
                        } else if (superChannelFilter == SuperChannelFilter.NONSUPER_CHANNEL_ONLY) {
                            hashMap.put(StringSet.super_mode, StringSet.nonsuper);
                        }
                        PublicChannelFilter publicChannelFilter = access$1800;
                        if (publicChannelFilter == PublicChannelFilter.ALL) {
                            hashMap.put(StringSet.public_mode, StringSet.all);
                        } else if (publicChannelFilter == PublicChannelFilter.PUBLIC) {
                            hashMap.put(StringSet.public_mode, StringSet.PUBLIC);
                        } else if (publicChannelFilter == PublicChannelFilter.PRIVATE) {
                            hashMap.put(StringSet.public_mode, StringSet.PRIVATE);
                        }
                        UnreadChannelFilter unreadChannelFilter = access$1900;
                        if (unreadChannelFilter == UnreadChannelFilter.ALL) {
                            hashMap.put(StringSet.unread_filter, StringSet.all);
                        } else if (unreadChannelFilter == UnreadChannelFilter.UNREAD_MESSAGE) {
                            hashMap.put(StringSet.unread_filter, StringSet.unread_message);
                        }
                        HiddenChannelFilter hiddenChannelFilter2 = hiddenChannelFilter;
                        if (hiddenChannelFilter2 == HiddenChannelFilter.UNHIDDEN) {
                            hashMap.put(StringSet.hidden_mode, StringSet.unhidden_only);
                        } else if (hiddenChannelFilter2 == HiddenChannelFilter.HIDDEN) {
                            hashMap.put(StringSet.hidden_mode, StringSet.hidden_only);
                        } else if (hiddenChannelFilter2 == HiddenChannelFilter.HIDDEN_ALLOW_AUTO_UNHIDE) {
                            hashMap.put(StringSet.hidden_mode, StringSet.hidden_allow_auto_unhide);
                        } else if (hiddenChannelFilter2 == HiddenChannelFilter.HIDDEN_PREVENT_AUTO_UNHIDE) {
                            hashMap.put(StringSet.hidden_mode, StringSet.hidden_prevent_auto_unhide);
                        }
                        JsonObject asJsonObject = aPIClient.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2).getAsJsonObject();
                        String unused = GroupChannelListQuery.this.mToken = asJsonObject.get("next").getAsString();
                        if (GroupChannelListQuery.this.mToken == null || GroupChannelListQuery.this.mToken.length() <= 0) {
                            z = false;
                            boolean unused2 = GroupChannelListQuery.this.mHasNext = false;
                        } else {
                            z = false;
                        }
                        JsonArray asJsonArray = asJsonObject.get("channels").getAsJsonArray();
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            arrayList.add(GroupChannel.upsert(asJsonArray.get(i2), z));
                        }
                        return arrayList;
                    }
                    throw u.b();
                }
            });
        }
    }

    public static GroupChannelListQuery buildFromSerializedData(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
            }
            try {
                return new GroupChannelListQuery(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public final byte[] serialize() {
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
}
