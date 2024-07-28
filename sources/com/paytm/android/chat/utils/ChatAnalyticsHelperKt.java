package com.paytm.android.chat.utils;

import android.content.Context;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.c;
import com.paytm.android.chat.d;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.g;
import com.paytm.android.chat.network.response.HomeChips;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.User;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class ChatAnalyticsHelperKt {
    public static final String APP_PLATFORM = "android";
    public static final String DEFAULT_CHAT_PAYMENT_MODE = "UPI";
    public static final String KEY_EVENT_ACTION = "event_action";
    public static final String KEY_EVENT_CATEGORY = "event_category";
    public static final String KEY_EVENT_LABEL = "event_label";
    public static final String KEY_EVENT_LABEL2 = "event_label2";
    public static final String KEY_EVENT_LABEL3 = "event_label3";
    public static final String KEY_EVENT_TYPE = "event_type";
    private static final String TAG = "ChatAnalyticsHelper";
    public static final String VALUE_EVENT_CATEGORY_ALL_CHAT = "chat-home-screen";
    public static final String VALUE_EVENT_CATEGORY_ENGAGE_MESSAGE = "engage-message";
    public static final String VALUE_EVENT_CATEGORY_FILTERED_SCREEN = "chat-filtered-screen";
    public static final String VALUE_EVENT_CATEGORY_MAIN_SCREEN = "main-chat-screen";
    public static final String VALUE_EVENT_CATEGORY_USER_PROFILE = "user-profile-screen";
    public static final String VALUE_EVENT_DEVICE_PLATFORM_CONSUMER = "consumer";
    public static final String VALUE_EVENT_DEVICE_PLATFORM_P4B = "p4b";

    public static final void fireChatHomeLoadEvent(Context context, String str, int i2, int i3, boolean z, int i4, boolean z2) {
        k.c(context, "context");
        k.c(str, "source");
        try {
            boolean r = b.r(context);
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Chat Home Screen Load");
            Map map = newMapForAnalytics;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" | ");
            sb.append(r);
            sb.append(" | ");
            sb.append(i2);
            sb.append(" | ");
            sb.append(i3);
            sb.append(" | ");
            sb.append(z);
            sb.append(" | ");
            sb.append(i4);
            sb.append(" | ");
            sb.append(z2);
            sb.append(" | ");
            UserMetaData currentUserMetaData = AppUtilKt.getCurrentUserMetaData();
            sb.append(currentUserMetaData != null ? currentUserMetaData.getUserType() : null);
            map.put("event_label", sb.toString());
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireChatHomeLoadEvent");
        }
    }

    public static final void fireNewChatEvent(Context context, int i2, int i3) {
        k.c(context, "context");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "New Chat CTA Click");
            newMapForAnalytics.put("event_label", i2 + " | " + i3 + " | " + c.b());
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireNewChatEvent");
        }
    }

    public static final void fireChatOpenEvent(Context context, int i2, boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(context, "context");
        k.c(chatGroupChannelDataModel, "channel");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Existing Chat Click");
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            if (!k.a((Object) receiverDisplayInfo.getChatType().name(), (Object) "P2C")) {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + z);
            } else if (chatGroupChannelDataModel.getMemberCount() > 2) {
                GroupChannel a2 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                String str = null;
                Member channelDisplayMember = a2 != null ? ChatVariantUtilKt.getChannelDisplayMember(a2) : null;
                UserMetaData a3 = g.a((User) channelDisplayMember);
                String name = a3 != null ? a3.getName() : null;
                if (name == null) {
                    if (channelDisplayMember != null) {
                        str = channelDisplayMember.getNickname();
                    }
                    name = str;
                }
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + z + " | " + name);
            } else {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + z + " | " + receiverDisplayInfo.getName());
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireChatOpenEvent");
        }
    }

    public static final void fireDeleteChatEvent(Context context, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, int i3) {
        k.c(context, "context");
        k.c(chatGroupChannelDataModel, "channel");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Delete Chat Confirm");
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            if (!k.a((Object) receiverDisplayInfo.getChatType().name(), (Object) "P2C")) {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3);
            } else if (chatGroupChannelDataModel.getMemberCount() > 2) {
                GroupChannel a2 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                String str = null;
                Member channelDisplayMember = a2 != null ? ChatVariantUtilKt.getChannelDisplayMember(a2) : null;
                UserMetaData a3 = g.a((User) channelDisplayMember);
                String name = a3 != null ? a3.getName() : null;
                if (name == null) {
                    if (channelDisplayMember != null) {
                        str = channelDisplayMember.getNickname();
                    }
                    name = str;
                }
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + name);
            } else {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + receiverDisplayInfo.getName());
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireDeleteChatEvent");
        }
    }

    public static final void fireMuteChatEvent(Context context, boolean z, String str, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, int i3) {
        UserMetaData a2;
        k.c(context, "context");
        k.c(str, "source");
        k.c(chatGroupChannelDataModel, "channel");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Mute Chat Click");
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            if (!k.a((Object) receiverDisplayInfo.getChatType().name(), (Object) "P2C")) {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + z + " | " + str);
            } else if (chatGroupChannelDataModel.getMemberCount() > 2) {
                GroupChannel a3 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                String str2 = null;
                Member channelDisplayMember = a3 != null ? ChatVariantUtilKt.getChannelDisplayMember(a3) : null;
                String name = (channelDisplayMember == null || (a2 = g.a((User) channelDisplayMember)) == null) ? null : a2.getName();
                if (name == null) {
                    if (channelDisplayMember != null) {
                        str2 = channelDisplayMember.getNickname();
                    }
                    name = str2;
                }
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + name + " | " + z + " | " + str);
            } else {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + receiverDisplayInfo.getName() + " | " + z + " | " + str);
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireMuteChatEvent");
        }
    }

    public static final void firePinChatEvent(Context context, boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, int i3) {
        UserMetaData a2;
        k.c(context, "context");
        k.c(chatGroupChannelDataModel, "channel");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Pin Chat Click");
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            if (!k.a((Object) receiverDisplayInfo.getChatType().name(), (Object) "P2C")) {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + z);
            } else if (chatGroupChannelDataModel.getMemberCount() > 2) {
                GroupChannel a3 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                String str = null;
                Member channelDisplayMember = a3 != null ? ChatVariantUtilKt.getChannelDisplayMember(a3) : null;
                String name = (channelDisplayMember == null || (a2 = g.a((User) channelDisplayMember)) == null) ? null : a2.getName();
                if (name == null) {
                    if (channelDisplayMember != null) {
                        str = channelDisplayMember.getNickname();
                    }
                    name = str;
                }
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + name + " | " + z);
            } else {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + i3 + " | " + receiverDisplayInfo.getName() + " | " + z);
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("firePinChatEvent");
        }
    }

    public static final void fireChatScreenLoadEvent(Context context, boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel) {
        UserMetaData a2;
        k.c(context, "context");
        k.c(chatGroupChannelDataModel, "channel");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Chat Screen Load");
            String str = z ? "deeplink" : "internal";
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            if (!k.a((Object) receiverDisplayInfo.getChatType().name(), (Object) "P2C")) {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + str);
            } else if (chatGroupChannelDataModel.getMemberCount() > 2) {
                GroupChannel a3 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                String str2 = null;
                Member channelDisplayMember = a3 != null ? ChatVariantUtilKt.getChannelDisplayMember(a3) : null;
                String name = (channelDisplayMember == null || (a2 = g.a((User) channelDisplayMember)) == null) ? null : a2.getName();
                if (name == null) {
                    if (channelDisplayMember != null) {
                        str2 = channelDisplayMember.getNickname();
                    }
                    name = str2;
                }
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + str + " | " + name);
            } else {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + str + " | " + receiverDisplayInfo.getName());
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireChatScreenLoadEvent");
        }
    }

    public static final void fireBottomFunctionClickEvent(Context context, String str, int i2) {
        k.c(context, "context");
        k.c(str, "type");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Bottom Nav Icon Click");
            newMapForAnalytics.put("event_label", str + " | " + i2);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireBottomFunctionClickEvent");
        }
    }

    public static final void fireChatPayClickEvent(Context context) {
        k.c(context, "context");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Pay Button Click");
            String b2 = c.b();
            k.a((Object) b2, "ChatApplication.isIsNewUser()");
            newMapForAnalytics.put("event_label", b2);
            ChatManager b3 = ChatManager.b();
            k.a((Object) b3, "ChatManager.getInstance()");
            b3.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireChatPayClickEvent");
        }
    }

    public static final void fireOpenFromNotificationEvent(Context context, String str) {
        k.c(context, "context");
        k.c(str, "type");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Push Notification Click");
            newMapForAnalytics.put("event_label", str);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireOpenFromNotificationEvent");
        }
    }

    public static final void fireUserProfileClickEvent(Context context, String str, boolean z) {
        k.c(context, "context");
        k.c(str, "type");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Profile Icon Click");
            newMapForAnalytics.put("event_label", str + " | " + z);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireUserProfileClickEvent");
        }
    }

    public static final void fireUserProfileScreenLoadedEvent(Context context, String str, boolean z, boolean z2, boolean z3) {
        k.c(context, "context");
        k.c(str, "type");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_USER_PROFILE);
            newMapForAnalytics.put("event_action", "Profile Screen Load");
            newMapForAnalytics.put("event_label", str + " | " + z + " | " + z2 + " | " + z3);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireUserProfileScreenLoadedEvent");
        }
    }

    public static final void fireUserBlockedEvent(Context context, boolean z, String str, boolean z2, boolean z3) {
        k.c(context, "context");
        k.c(str, "type");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_USER_PROFILE);
            newMapForAnalytics.put("event_action", "Block User");
            newMapForAnalytics.put("event_label", str + " | " + z2 + ' ' + z3 + " | " + z);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireUserBlockedEvent");
        }
    }

    public static final void fireMerchantVisitStoreEvent(Context context, boolean z, String str, boolean z2, boolean z3) {
        k.c(context, "context");
        k.c(str, "type");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_USER_PROFILE);
            newMapForAnalytics.put("event_action", "Store CTA Click");
            newMapForAnalytics.put("event_label", str + " | " + z2 + ' ' + z3 + " | " + z);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireMerchantVisitStoreEvent");
        }
    }

    public static final void firePaymentSuccessEvent(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "type");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Payment success");
            Map map = newMapForAnalytics;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" | ");
            if (str2 == null) {
                str2 = "0";
            }
            sb.append(str2);
            sb.append(" | UPI | ");
            sb.append(c.b());
            map.put("event_label", sb.toString());
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("firePaymentSuccessEvent");
        }
    }

    public static final void fireMessageSentEvent(Context context, int i2, String str, String str2) {
        k.c(context, "context");
        k.c(str, "type");
        k.c(str2, "messageType");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "File Share Success");
            newMapForAnalytics.put("event_label", i2 + " | " + str + " | " + str2 + " | " + c.b());
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireMessageSentEvent");
        }
    }

    public static final void firePaymentQuickReplyEvent(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "type");
        k.c(str2, "replyString");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "QR Payment Click");
            newMapForAnalytics.put("event_label", str + " | " + str2 + " | " + c.b());
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("firePaymentQuickReplyEvent");
        }
    }

    public static final void fireMessageSendingFailedEvent(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "type");
        k.c(str2, "messageType");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "File Share Fail");
            newMapForAnalytics.put("event_label", str + " | " + str2);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireMessageSendingFailedEvent");
        }
    }

    public static final void fireViewFriendsClickedEvent(Context context, int i2, int i3, boolean z, int i4) {
        k.c(context, "context");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "View Friends CTA Click");
            newMapForAnalytics.put("event_label", i2 + " | " + i3 + " | " + z + ' ' + i4);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireViewFriendsClickedEvent");
        }
    }

    public static final void fireFriendsClickedEvent(Context context, String str, String str2, int i2, int i3, boolean z, int i4) {
        k.c(context, "context");
        k.c(str, "rank");
        k.c(str2, "previewText");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Friend Suggestion Click");
            newMapForAnalytics.put("event_label", i2 + " | " + i3 + " | " + z + ' ' + i4 + ' ' + str + " | " + str2);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireFriendsClickedEvent");
        }
    }

    public static final void fireNewUserRegisteredEvent(Context context, String str) {
        k.c(context, "context");
        k.c(str, "userType");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "New User Registered");
            newMapForAnalytics.put("event_label", str);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireNewUserRegisteredEvent");
        }
    }

    public static final void fireCampaignMessageReceivedEvent(Context context, String str) {
        k.c(context, "context");
        k.c(str, "campaignId");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ENGAGE_MESSAGE);
            newMapForAnalytics.put("event_action", "Message Received");
            newMapForAnalytics.put("event_label", str);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireCampaignMessageReceivedEvent");
        }
    }

    public static final void fireCampaignMessageViewedEvent(Context context, String str) {
        k.c(context, "context");
        k.c(str, "campaignId");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ENGAGE_MESSAGE);
            newMapForAnalytics.put("event_action", "Message Viewed");
            newMapForAnalytics.put("event_label", str);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireCampaignMessageViewedEvent");
        }
    }

    public static final void fireCampaignMessageClickedEvent(Context context, String str) {
        k.c(context, "context");
        k.c(str, "campaignId");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ENGAGE_MESSAGE);
            newMapForAnalytics.put("event_action", "Message Clicked");
            newMapForAnalytics.put("event_label", str);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireCampaignMessageClickedEvent");
        }
    }

    public static final void fireGenericNotificationCtaClickEvent(Context context, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, String str) {
        UserMetaData a2;
        k.c(context, "context");
        k.c(chatGroupChannelDataModel, "channel");
        k.c(str, "ctaText");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Generic Notif CTA Clicked");
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            if (!k.a((Object) receiverDisplayInfo.getChatType().name(), (Object) "P2C")) {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + str);
            } else if (chatGroupChannelDataModel.getMemberCount() > 2) {
                GroupChannel a3 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                String str2 = null;
                Member channelDisplayMember = a3 != null ? ChatVariantUtilKt.getChannelDisplayMember(a3) : null;
                String name = (channelDisplayMember == null || (a2 = g.a((User) channelDisplayMember)) == null) ? null : a2.getName();
                if (name == null) {
                    if (channelDisplayMember != null) {
                        str2 = channelDisplayMember.getNickname();
                    }
                    name = str2;
                }
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + str + " | " + name);
            } else {
                newMapForAnalytics.put("event_label", receiverDisplayInfo.getChatType().name() + " | " + i2 + " | " + str + " | " + receiverDisplayInfo.getName());
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireGenericNotificationCtaClickEvent");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        r4 = (r4 = r4.getReceiverDisplayInfo()).getChatType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fireRequestViewClickEvent(android.content.Context r3, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r4) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r3 = "main-chat-screen"
            java.util.HashMap r3 = getNewMapForAnalytics(r3)     // Catch:{ Exception -> 0x0046 }
            r0 = r3
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0046 }
            java.lang.String r1 = "event_action"
            java.lang.String r2 = "Request View CTA Click"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0046 }
            r0 = r3
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0046 }
            java.lang.String r1 = "event_label"
            if (r4 == 0) goto L_0x002d
            com.paytm.android.chat.bean.ReceiverDisplayInfo r4 = r4.getReceiverDisplayInfo()     // Catch:{ Exception -> 0x0046 }
            if (r4 == 0) goto L_0x002d
            com.paytm.android.chat.bean.ChatType r4 = r4.getChatType()     // Catch:{ Exception -> 0x0046 }
            if (r4 == 0) goto L_0x002d
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x0046 }
            goto L_0x002e
        L_0x002d:
            r4 = 0
        L_0x002e:
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0046 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0046 }
            com.paytm.android.chat.ChatManager r4 = com.paytm.android.chat.ChatManager.b()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r0 = "ChatManager.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x0046 }
            com.paytm.android.chat.d r4 = r4.g()     // Catch:{ Exception -> 0x0046 }
            r4.a((java.util.HashMap<java.lang.String, java.lang.Object>) r3)     // Catch:{ Exception -> 0x0046 }
            return
        L_0x0046:
            java.lang.String r3 = "fireRequestViewClickEvent"
            com.paytm.utility.q.c(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireRequestViewClickEvent(android.content.Context, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel):void");
    }

    public static final void fireTabClickEvent(Context context, HomeChips homeChips, int i2) {
        k.c(context, "context");
        k.c(homeChips, "chip");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Tab Click");
            String action = homeChips.getAction();
            Locale locale = Locale.ROOT;
            k.a((Object) locale, "Locale.ROOT");
            if (action != null) {
                String lowerCase = action.toLowerCase(locale);
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String str = k.a((Object) lowerCase, (Object) StringSet.filter) ? "Filter" : "Deep Link";
                newMapForAnalytics.put("event_label", str + " | " + i2 + " | " + homeChips.getShowDot());
                ChatManager b2 = ChatManager.b();
                k.a((Object) b2, "ChatManager.getInstance()");
                b2.g().a(newMapForAnalytics);
                return;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            q.c("fireTabClickEvent");
        }
    }

    public static final void fireToolbarIconClickEvent(Context context, String str, int i2, int i3, boolean z, int i4, boolean z2) {
        k.c(context, "context");
        k.c(str, "typeOfAction");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", str);
            newMapForAnalytics.put("event_label", i2 + " | " + i3 + " | " + z + " | " + i4 + " | " + z2);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireToolbarIconClickEvent");
        }
    }

    public static final void fireContactPermissionConfirmEvent(Context context, String str, int i2, int i3, boolean z, int i4) {
        k.c(context, "context");
        k.c(str, "typeOfAction");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", str);
            newMapForAnalytics.put("event_label", i2 + " | " + i3 + " | " + z + " | " + i4);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireContactPermissionConfirmEvent");
        }
    }

    public static final void fireFilteredChatScreenLoadEvent(Context context, int i2, int i3, String str) {
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_FILTERED_SCREEN);
            newMapForAnalytics.put("event_action", "Filtered Chat Screen Load");
            newMapForAnalytics.put("event_label", i2 + " | " + i3 + " | " + str);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireFilteredChatScreenLoadEvent");
        }
    }

    public static final void fireHelloQuickReplyClickEvent(Context context, ChatGroupChannelDataModel chatGroupChannelDataModel, String str, String str2) {
        k.c(context, "context");
        k.c(chatGroupChannelDataModel, "channel");
        k.c(str, "type");
        k.c(str2, "source");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Hello Quick Reply Click");
            String name = getName(chatGroupChannelDataModel);
            if (name.length() > 0) {
                newMapForAnalytics.put("event_label", str + " | " + str2 + " | " + name);
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireHelloQuickReplyClickEvent");
        }
    }

    public static final void firePaymentQuickReplyClickEvent(Context context, ChatGroupChannelDataModel chatGroupChannelDataModel, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(chatGroupChannelDataModel, "channel");
        k.c(str, "type");
        k.c(str2, "message");
        k.c(str3, "source");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", "Payment Quick Reply Click");
            if (getName(chatGroupChannelDataModel).length() > 0) {
                newMapForAnalytics.put("event_label", str + " | " + str2 + " | " + str3);
            }
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("firePaymentQuickReplyClickEvent");
        }
    }

    public static final void fireSendTextMessageCTAClickEvent(Context context, String str, String str2, int i2) {
        k.c(context, "context");
        k.c(str, "eventAction");
        k.c(str2, "chatType");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", str);
            newMapForAnalytics.put("event_label", str2 + " | " + i2);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("firePaymentQuickReplyClickEvent");
        }
    }

    public static final void fireMTPaymentSuccessEvent(Context context, String str, String str2, String str3, String str4) {
        k.c(context, "context");
        k.c(str, "transferType");
        k.c(str2, "type");
        k.c(str3, "messageTheme");
        k.c(str4, "hasDesc");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_MAIN_SCREEN);
            newMapForAnalytics.put("event_action", str);
            newMapForAnalytics.put("event_label", str2 + " | Source | " + str3 + " | " + str4);
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireMTPaymentSuccessEvent");
        }
    }

    public static final void fireLoginCTAClickEvent(Context context) {
        k.c(context, "context");
        try {
            HashMap<String, Object> newMapForAnalytics = getNewMapForAnalytics(VALUE_EVENT_CATEGORY_ALL_CHAT);
            newMapForAnalytics.put("event_action", "Login CTA Click");
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a(newMapForAnalytics);
        } catch (Exception unused) {
            q.c("fireLoginCTAClickEvent");
        }
    }

    public static final HashMap<String, Object> getNewMapForAnalytics(String str) {
        k.c(str, "eventCategory");
        HashMap<String, Object> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put("event_category", str);
        StringBuilder sb = new StringBuilder();
        ChatManager b2 = ChatManager.b();
        k.a((Object) b2, "ChatManager.getInstance()");
        d g2 = b2.g();
        k.a((Object) g2, "ChatManager.getInstance().chatGenericListener");
        sb.append(g2.a());
        sb.append(" | android");
        map.put("event_label2", sb.toString());
        if (ChatConfigUtil.Companion.getInstance().isP4B()) {
            map.put("event_label3", VALUE_EVENT_DEVICE_PLATFORM_P4B);
        } else if (ChatConfigUtil.Companion.getInstance().isConsumer()) {
            map.put("event_label3", VALUE_EVENT_DEVICE_PLATFORM_CONSUMER);
        }
        return hashMap;
    }

    public static final String getName(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        UserMetaData a2;
        k.c(chatGroupChannelDataModel, "channel");
        ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
        if (k.a((Object) receiverDisplayInfo.getChatType().name(), (Object) "P2C")) {
            if (chatGroupChannelDataModel.getMemberCount() > 2) {
                GroupChannel a3 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                String str = null;
                Member channelDisplayMember = a3 != null ? ChatVariantUtilKt.getChannelDisplayMember(a3) : null;
                String name = (channelDisplayMember == null || (a2 = g.a((User) channelDisplayMember)) == null) ? null : a2.getName();
                if (name != null) {
                    str = name;
                } else if (channelDisplayMember != null) {
                    str = channelDisplayMember.getNickname();
                }
                if (str != null) {
                    return str;
                }
            } else {
                String name2 = receiverDisplayInfo.getName();
                if (name2 == null) {
                    return "";
                }
                return name2;
            }
        }
        return "";
    }
}
