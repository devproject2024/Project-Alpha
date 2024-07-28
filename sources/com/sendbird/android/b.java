package com.sendbird.android;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

enum b {
    USERS("/users"),
    USERS_USERID_LOGIN("/users/%s/login"),
    USERS_USERID("/users/%s"),
    USERS_USERID_UNREADCOUNT("/users/%s/unread_count"),
    USERS_USERID_UNREADMESSAGECOUNT("/users/%s/unread_message_count"),
    USERS_USERID_UNREADITEMCOUNT("/users/%s/unread_item_count"),
    USERS_USERID_UNREADCHANNELCOUNT("/users/%s/unread_channel_count"),
    USERS_USERID_GROUPCHANNELCOUNT("/users/%s/group_channel_count"),
    USERS_USERID_MARKASREADALL("/users/%s/mark_as_read_all"),
    USERS_USERID_PUSH_REGISTER("/users/%s/push/%s"),
    USERS_USERID_PUSH_UNREGISTER("/users/%s/push/%s/%s"),
    USERS_USERID_PUSH_TOKENTYPE_DEVICETOKENS("/users/%s/push/%s/device_tokens"),
    USERS_USERID_PUSH("/users/%s/push"),
    USERS_USERID_PUSH_TEMPLATE("/users/%s/push/template"),
    USERS_USERID_PUSHPREFERENCE_CHANNELURL("/users/%s/push_preference/%s"),
    USERS_USERID_PUSHPREFERENCE("/users/%s/push_preference/"),
    USERS_USERID_COUNTPREFERENCE_CHANNELURL("/users/%s/count_preference/%s"),
    USERS_USERID_BLOCK("/users/%s/block"),
    USERS_USERID_BLOCK_TARGETID("/users/%s/block/%s"),
    USERS_USERID_FRIENDS("/users/%s/friends"),
    USERS_USERID_FRIENDS_USERID("/users/%s/friends/%s"),
    USERS_USERID_FRIENDDISCOVERIES("/users/%s/friend_discoveries"),
    USERS_USERID_FRIENDDISCOVERIES_DISCOVERYKEY("/users/%s/friend_discoveries/%s"),
    USERS_USERID_FRIENDS_CHANGELOGS("/users/%s/friends/changelogs"),
    USERS_USERID_MYGROUPCHANNELS_CHANGELOGS("/users/%s/my_group_channels/changelogs"),
    USERS_USERID_MYGROUPCHANNELS("/users/%s/my_group_channels"),
    USERS_USERID_MYGROUPCHANNELS_CHANNELURL_MEMBERS("/users/%s/my_group_channels/%s/members"),
    USERS_USERID_CHANNELINVITATIONPREFERENCE("/users/%s/channel_invitation_preference"),
    USERS_USERID_METADATA("/users/%s/metadata"),
    USERS_USERID_METADATA_KEY("/users/%s/metadata/%s"),
    OPENCHANNELS("/open_channels"),
    OPENCHANNELS_CHANNELURL("/open_channels/%s"),
    OPENCHANNELS_CHANNELURL_MESSAGES("/open_channels/%s/messages"),
    OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_TRANSLATION("/open_channels/%s/messages/%s/translation"),
    OPENCHANNELS_CHANNELURL_SCHEDULED_MESSAGES("/open_channels/%s/scheduled_messages"),
    OPENCHANNELS_CHANNELURL_MESSAGES_CHANGELOGS("/open_channels/%s/messages/changelogs"),
    OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID("/open_channels/%s/messages/%s"),
    OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_METAARRAY("/open_channels/%s/messages/%s/metaarray"),
    OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_REACTIONS("/open_channels/%s/messages/%s/reactions"),
    OPENCHANNELS_CHANNELURL_PARTICIPANTS("/open_channels/%s/participants"),
    OPENCHANNELS_CHANNELURL_METADATA("/open_channels/%s/metadata"),
    OPENCHANNELS_CHANNELURL_METADATA_KEY("/open_channels/%s/metadata/%s"),
    OPENCHANNELS_CHANNELURL_METACOUNTER("/open_channels/%s/metacounter"),
    OPENCHANNELS_CHANNELURL_METACOUNTER_KEY("/open_channels/%s/metacounter/%s"),
    OPENCHANNELS_CHANNELURL_BAN("/open_channels/%s/ban"),
    OPENCHANNELS_CHANNELURL_BAN_USERID("/open_channels/%s/ban/%s"),
    OPENCHANNELS_CHANNELURL_MUTE("/open_channels/%s/mute"),
    OPENCHANNELS_CHANNELURL_MUTE_USERID("/open_channels/%s/mute/%s"),
    OPENCHANNELS_CHANNELURL_OPERATORS("/open_channels/%s/operators"),
    GROUPCHANNELS("/group_channels"),
    GROUPCHANNELS_CHANNELURL("/group_channels/%s"),
    GROUPCHANNELS_CHANNELURL_INVITE("/group_channels/%s/invite"),
    GROUPCHANNELS_CHANNELURL_JOIN("/group_channels/%s/join"),
    GROUPCHANNELS_CHANNELURL_HIDE("/group_channels/%s/hide"),
    GROUPCHANNELS_CHANNELURL_LEAVE("/group_channels/%s/leave"),
    GROUPCHANNELS_CHANNELURL_ACCEPT("/group_channels/%s/accept"),
    GROUPCHANNELS_CHANNELURL_DECLINE("/group_channels/%s/decline"),
    GROUPCHANNELS_CHANNELURL_MESSAGES("/group_channels/%s/messages"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_TRANSLATION("/group_channels/%s/messages/%s/translation"),
    GROUPCHANNELS_CHANNELURL_SCHEDULED_MESSAGES("/group_channels/%s/scheduled_messages"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_CHANGELOGS("/group_channels/%s/messages/changelogs"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_MARKASREAD("/group_channels/%s/messages/mark_as_read"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_MARKASDELIVERED("/group_channels/%s/messages/mark_as_delivered"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_TOTALCOUNT("/group_channels/%s/messages/total_count"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_UNREADCOUNT("/group_channels/%s/messages/unread_count"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID("/group_channels/%s/messages/%s"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_METAARRAY("/group_channels/%s/messages/%s/metaarray"),
    GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_REACTIONS("/group_channels/%s/messages/%s/reactions"),
    GROUPCHANNELS_CHANNELURL_MEMBERS("/group_channels/%s/members"),
    GROUPCHANNELS_CHANNELURL_METADATA("/group_channels/%s/metadata"),
    GROUPCHANNELS_CHANNELURL_METADATA_KEY("/group_channels/%s/metadata/%s"),
    GROUPCHANNELS_CHANNELURL_METACOUNTER("/group_channels/%s/metacounter"),
    GROUPCHANNELS_CHANNELURL_METACOUNTER_KEY("/group_channels/%s/metacounter/%s"),
    GROUPCHANNELS_CHANNELURL_RESETUSERHISTORY("/group_channels/%s/reset_user_history"),
    GROUPCHANNELS_CHANNELURL_BAN("/group_channels/%s/ban"),
    GROUPCHANNELS_CHANNELURL_BAN_USERID("/group_channels/%s/ban/%s"),
    GROUPCHANNELS_CHANNELURL_MUTE("/group_channels/%s/mute"),
    GROUPCHANNELS_CHANNELURL_MUTE_USERID("/group_channels/%s/mute/%s"),
    GROUPCHANNELS_CHANNELURL_FREEZE("/group_channels/%s/freeze"),
    GROUPCHANNELS_CHANNELURL_OPERATORS("/group_channels/%s/operators"),
    STORAGE_FILE("/storage/file"),
    STORAGE_PROFILEIMAGE("/storage/profile_image"),
    REPORT_OPENCHANNELS_CHANNELURL("/report/open_channels/%s"),
    REPORT_GROUPCHANNELS_CHANNELURL("/report/group_channels/%s"),
    REPORT_USERS_OFFENDINGUSERID("/report/users/%s"),
    REPORT_OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID("/report/open_channels/%s/messages/%s"),
    REPORT_GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID("/report/group_channels/%s/messages/%s"),
    SEARCH_MESSAGES("/search/messages"),
    EMOJI_CATEGORIES("/emoji_categories"),
    EMOJI_CATEGORY("/emoji_categories/%s"),
    EMOJI("/emojis/%s");
    
    private String postfix;

    private b(String str) {
        this.postfix = str;
    }

    /* access modifiers changed from: package-private */
    public final String url(boolean z) {
        return z ? internalUrl() : publicUrl();
    }

    /* access modifiers changed from: package-private */
    public final String publicUrl() {
        return "/v3" + this.postfix;
    }

    /* access modifiers changed from: package-private */
    public final String internalUrl() {
        return "/v3" + "/sdk" + this.postfix;
    }

    static String urlEncodeUTF8(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    static String urlEncodeUTF8(Collection<String> collection) {
        if (collection == null || collection.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (String urlEncodeUTF8 : collection) {
            sb.append(str);
            sb.append(urlEncodeUTF8(urlEncodeUTF8));
            str = AppConstants.COMMA;
        }
        return sb.toString();
    }

    static String urlEncodeUTF8(Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(AppConstants.AND_SIGN);
            }
            sb.append(String.format("%s=%s", new Object[]{urlEncodeUTF8(next.getKey().toString()), urlEncodeUTF8(next.getValue().toString())}));
        }
        return sb.toString();
    }
}
