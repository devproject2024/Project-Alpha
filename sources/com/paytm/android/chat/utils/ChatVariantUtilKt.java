package com.paytm.android.chat.utils;

import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.l;
import com.google.gsonhtcfix.o;
import com.paytm.android.chat.c.b.a.a;
import com.paytm.android.chat.c.b.a.b;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType;
import org.json.JSONObject;

public final class ChatVariantUtilKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChatUserType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChatUserType.BANK.ordinal()] = 1;
            $EnumSwitchMapping$0[ChatUserType.VPA.ordinal()] = 2;
            $EnumSwitchMapping$0[ChatUserType.CUSTOMER.ordinal()] = 3;
            $EnumSwitchMapping$0[ChatUserType.MOBILE_NUMBER.ordinal()] = 4;
            $EnumSwitchMapping$0[ChatUserType.MERCHANT.ordinal()] = 5;
        }
    }

    public static final List<ChatGroupChannelDataModel> getFilteredListForVariant(List<ChatGroupChannelDataModel> list) {
        k.c(list, "allChannelDataModelList");
        if (ChatConfigUtil.Companion.getInstance().isP4B()) {
            new b();
            return b.a(list);
        } else if (!ChatConfigUtil.Companion.getInstance().isConsumer()) {
            return list;
        } else {
            new a();
            return a.a(list);
        }
    }

    public static final boolean isNotificationToBeShownForVariant(String str) {
        if (ChatConfigUtil.Companion.getInstance().isP4B()) {
            new b();
            return true;
        } else if (!ChatConfigUtil.Companion.getInstance().isConsumer()) {
            return true;
        } else {
            new a();
            return a.a(str);
        }
    }

    public static final Member getChannelDisplayMember(GroupChannel groupChannel) {
        k.c(groupChannel, "channel");
        try {
            Object a2 = new f().a(groupChannel.getData(), o.class);
            k.a(a2, "Gson().fromJson(channel.…, JsonObject::class.java)");
            o d2 = ((o) a2).d("channelInfoFetchStrategy");
            k.a((Object) d2, "metaObject.getAsJsonObje…hannelInfoFetchStrategy\")");
            o d3 = d2.d("siteIdMap");
            k.a((Object) d3, "strategyObject.getAsJsonObject(\"siteIdMap\")");
            o d4 = d3.d(ChatConfigUtil.Companion.getInstance().getActiveSiteID());
            k.a((Object) d4, "siteIdMap.getAsJsonObjec…stance.getActiveSiteID())");
            l b2 = d4.b("id");
            k.a((Object) b2, "displayObject.get(\"id\")");
            String b3 = b2.b();
            for (Member next : groupChannel.getMembers()) {
                k.a((Object) next, StringSet.member);
                if (p.a(next.getUserId(), b3, true)) {
                    return next;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final ChatUserDataModel getChannelDisplayMember(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "channel");
        try {
            Object a2 = new f().a(chatGroupChannelDataModel.getData(), o.class);
            k.a(a2, "Gson().fromJson(channel.…, JsonObject::class.java)");
            o d2 = ((o) a2).d("channelInfoFetchStrategy");
            k.a((Object) d2, "metaObject.getAsJsonObje…hannelInfoFetchStrategy\")");
            o d3 = d2.d("siteIdMap");
            k.a((Object) d3, "strategyObject.getAsJsonObject(\"siteIdMap\")");
            o d4 = d3.d(ChatConfigUtil.Companion.getInstance().getActiveSiteID());
            k.a((Object) d4, "siteIdMap.getAsJsonObjec…stance.getActiveSiteID())");
            l b2 = d4.b("id");
            k.a((Object) b2, "displayObject.get(\"id\")");
            String b3 = b2.b();
            for (ChatUserDataModel next : chatGroupChannelDataModel.getMembers()) {
                if (p.a(next.getSendbirdUserId(), b3, true)) {
                    return next;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final boolean isReplyAllowed(GroupChannel groupChannel) {
        if ((groupChannel != null ? groupChannel.getData() : null) == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupChannel.getData());
            String optString = jSONObject.optString("type", (String) null);
            String optString2 = jSONObject.optString("replyStatus", (String) null);
            if (optString != null) {
                if (optString.hashCode() == 78497) {
                    if (optString.equals("P2C")) {
                        if (optString2 == null) {
                            return false;
                        }
                        if (!p.a(p.b(optString2).toString(), "REPLY_ALLOWED", true) && !p.a(p.b(optString2).toString(), "allowed", true)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            if (optString2 != null && !p.a(p.b(optString2).toString(), "REPLY_ALLOWED", true) && !p.a(p.b(optString2).toString(), "allowed", true)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0086, code lost:
        if (r4.equals("p2c::vertical") != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0088, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008a, code lost:
        r4 = kotlin.m.p.a(kotlin.m.p.b(r5).toString(), "1", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a9, code lost:
        if (r4.equals("p2p::user") != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ab, code lost:
        if (r5 == null) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ad, code lost:
        r4 = kotlin.m.p.a(kotlin.m.p.b(r5).toString(), "1", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d A[SYNTHETIC, Splitter:B:16:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c0 A[Catch:{ Exception -> 0x00cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isPayAllowed(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x00cf
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00cf }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00cf }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            r2 = 1
            if (r5 == 0) goto L_0x0017
            int r5 = r5.length()     // Catch:{ Exception -> 0x00cf }
            if (r5 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r5 = 0
            goto L_0x0018
        L_0x0017:
            r5 = 1
        L_0x0018:
            r3 = 0
            if (r5 == 0) goto L_0x0021
            java.lang.String r4 = "type"
            java.lang.String r4 = r1.optString(r4, r3)     // Catch:{ Exception -> 0x00cf }
        L_0x0021:
            java.lang.String r5 = "pay:site:1"
            java.lang.String r5 = r1.optString(r5, r3)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = "1"
            if (r4 != 0) goto L_0x002d
            goto L_0x00be
        L_0x002d:
            int r3 = r4.hashCode()     // Catch:{ Exception -> 0x00cf }
            switch(r3) {
                case -1291414663: goto L_0x00a3;
                case -803607946: goto L_0x009a;
                case -396921769: goto L_0x0080;
                case 78497: goto L_0x0077;
                case 78507: goto L_0x006e;
                case 78510: goto L_0x0065;
                case 55966151: goto L_0x005c;
                case 474319559: goto L_0x0053;
                case 1081923241: goto L_0x004a;
                case 1732312992: goto L_0x0040;
                case 1941468006: goto L_0x0036;
                default: goto L_0x0034;
            }     // Catch:{ Exception -> 0x00cf }
        L_0x0034:
            goto L_0x00be
        L_0x0036:
            java.lang.String r3 = "p2c::vpa"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x0040:
            java.lang.String r3 = "p2c::store"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x004a:
            java.lang.String r3 = "p2c::merchant"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x0053:
            java.lang.String r3 = "p2bk::bank"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x005c:
            java.lang.String r3 = "p2c::vpam"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x0065:
            java.lang.String r3 = "P2P"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x006e:
            java.lang.String r3 = "P2M"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x0077:
            java.lang.String r3 = "P2C"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x0080:
            java.lang.String r3 = "p2c::vertical"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
        L_0x0088:
            if (r5 == 0) goto L_0x00cf
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            java.lang.CharSequence r4 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cf }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x00cf }
        L_0x0098:
            r0 = r4
            goto L_0x00cf
        L_0x009a:
            java.lang.String r3 = "p2p::merchant"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x00a3:
            java.lang.String r3 = "p2p::user"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
        L_0x00ab:
            if (r5 == 0) goto L_0x00bc
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            java.lang.CharSequence r4 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cf }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0098
        L_0x00bc:
            r0 = 1
            goto L_0x00cf
        L_0x00be:
            if (r5 == 0) goto L_0x00bc
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            java.lang.CharSequence r4 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cf }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0098
        L_0x00cf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatVariantUtilKt.isPayAllowed(java.lang.String, java.lang.String):boolean");
    }

    public static final ChatUserDataModel getOtherUser(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "channel");
        for (ChatUserDataModel chatUserDataModel : chatGroupChannelDataModel.getMembers()) {
            if (!k.a((Object) chatUserDataModel.getSendbirdUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                return chatUserDataModel;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser} */
    /* JADX WARNING: type inference failed for: r3v7, types: [net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getPaymentInfoHeaderText(com.paytm.android.chat.data.models.users.ChatUserDataModel r3) {
        /*
            java.lang.String r0 = ""
            if (r3 == 0) goto L_0x0009
            net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r3 = r3.constructChatPayeeUser()     // Catch:{ Exception -> 0x003b }
            goto L_0x000a
        L_0x0009:
            r3 = 0
        L_0x000a:
            boolean r1 = r3 instanceof net.one97.paytm.common.entity.chat.moneytransfer.VpaChatPayeeUser     // Catch:{ Exception -> 0x003b }
            if (r1 == 0) goto L_0x0015
            net.one97.paytm.common.entity.chat.moneytransfer.VpaChatPayeeUser r3 = (net.one97.paytm.common.entity.chat.moneytransfer.VpaChatPayeeUser) r3     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = r3.getVpa()     // Catch:{ Exception -> 0x003b }
            goto L_0x003b
        L_0x0015:
            boolean r1 = r3 instanceof net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser     // Catch:{ Exception -> 0x003b }
            if (r1 == 0) goto L_0x003b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003b }
            r1.<init>()     // Catch:{ Exception -> 0x003b }
            r2 = r3
            net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser r2 = (net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser) r2     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getBankName()     // Catch:{ Exception -> 0x003b }
            r1.append(r2)     // Catch:{ Exception -> 0x003b }
            r2 = 45
            r1.append(r2)     // Catch:{ Exception -> 0x003b }
            net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser r3 = (net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser) r3     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getMaskedAccNo()     // Catch:{ Exception -> 0x003b }
            r1.append(r3)     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x003b }
            r0 = r3
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatVariantUtilKt.getPaymentInfoHeaderText(com.paytm.android.chat.data.models.users.ChatUserDataModel):java.lang.String");
    }

    public static final ChatUserDataModel getOfflineReceiver(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata;
        String bankLogoUrl;
        k.c(chatGroupChannelDataModel, "chatGroupChannelDataModel");
        for (ChatUserDataModel chatUserDataModel : chatGroupChannelDataModel.getMembers()) {
            if (!chatUserDataModel.isMe()) {
                ChatUserType type = chatUserDataModel.getType();
                if (!(type == null || type != ChatUserType.BANK || (chatPaymentMetadata = chatUserDataModel.getChatPaymentMetadata()) == null || (bankLogoUrl = chatPaymentMetadata.getBankLogoUrl()) == null)) {
                    chatUserDataModel.setAvatarUrl(bankLogoUrl);
                }
                return chatUserDataModel;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b2, code lost:
        r0 = r0.getVpa();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getOfflineDisplayNameForReceiver(com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5) {
        /*
            java.lang.String r0 = "chatGroupChannelDataModel"
            kotlin.g.b.k.c(r5, r0)
            java.util.List r5 = r5.getMembers()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x000f:
            boolean r0 = r5.hasNext()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r5.next()
            r3 = r0
            com.paytm.android.chat.data.models.users.ChatUserDataModel r3 = (com.paytm.android.chat.data.models.users.ChatUserDataModel) r3
            boolean r3 = r3.isMe()
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x000f
            goto L_0x0027
        L_0x0026:
            r0 = r2
        L_0x0027:
            com.paytm.android.chat.data.models.users.ChatUserDataModel r0 = (com.paytm.android.chat.data.models.users.ChatUserDataModel) r0
            java.lang.String r5 = ""
            if (r0 == 0) goto L_0x00e4
            net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r3 = r0.getType()
            if (r3 == 0) goto L_0x00e4
            int[] r4 = com.paytm.android.chat.utils.ChatVariantUtilKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r1) goto L_0x00ba
            r1 = 2
            if (r3 == r1) goto L_0x00ac
            r1 = 3
            java.lang.String r2 = "Paytm user "
            if (r3 == r1) goto L_0x0071
            r1 = 4
            if (r3 == r1) goto L_0x004b
            r0 = 5
            goto L_0x00e4
        L_0x004b:
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r1 = r0.getChatPaymentMetadata()
            if (r1 == 0) goto L_0x0058
            java.lang.String r1 = r1.getName()
            if (r1 == 0) goto L_0x0058
            r5 = r1
        L_0x0058:
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.m.p.a(r1)
            if (r1 == 0) goto L_0x00e4
            java.lang.String r0 = r0.getIdentifier()
            if (r0 == 0) goto L_0x00e4
            java.lang.String r5 = java.lang.String.valueOf(r0)
            java.lang.String r5 = r2.concat(r5)
            goto L_0x00e4
        L_0x0071:
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r1 = r0.getChatPaymentMetadata()
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = r1.getName()
            if (r1 == 0) goto L_0x007e
            r5 = r1
        L_0x007e:
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.m.p.a(r1)
            if (r1 == 0) goto L_0x0094
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r1 = r0.getChatPaymentMetadata()
            if (r1 == 0) goto L_0x0094
            java.lang.String r1 = r1.getMobileNo()
            if (r1 == 0) goto L_0x0094
            r5 = r1
        L_0x0094:
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.m.p.a(r1)
            if (r1 == 0) goto L_0x00e4
            java.lang.String r0 = r0.getIdentifier()
            if (r0 == 0) goto L_0x00e4
            java.lang.String r5 = java.lang.String.valueOf(r0)
            java.lang.String r5 = r2.concat(r5)
            goto L_0x00e4
        L_0x00ac:
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r0 = r0.getChatPaymentMetadata()
            if (r0 == 0) goto L_0x00e4
            java.lang.String r0 = r0.getVpa()
            if (r0 == 0) goto L_0x00e4
            r5 = r0
            goto L_0x00e4
        L_0x00ba:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r1 = r0.getChatPaymentMetadata()
            if (r1 == 0) goto L_0x00ca
            java.lang.String r1 = r1.getBankName()
            goto L_0x00cb
        L_0x00ca:
            r1 = r2
        L_0x00cb:
            r5.append(r1)
            r1 = 45
            r5.append(r1)
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r0 = r0.getChatPaymentMetadata()
            if (r0 == 0) goto L_0x00dd
            java.lang.String r2 = r0.getMaskedAccNo()
        L_0x00dd:
            r5.append(r2)
            java.lang.String r5 = r5.toString()
        L_0x00e4:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatVariantUtilKt.getOfflineDisplayNameForReceiver(com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0086, code lost:
        if (r4.equals("p2c::vertical") != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0088, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008a, code lost:
        r4 = kotlin.m.p.a(kotlin.m.p.b(r5).toString(), "1", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a9, code lost:
        if (r4.equals("p2p::user") != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ab, code lost:
        if (r5 == null) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ad, code lost:
        r4 = kotlin.m.p.a(kotlin.m.p.b(r5).toString(), "1", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d A[SYNTHETIC, Splitter:B:16:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c0 A[Catch:{ Exception -> 0x00cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isRequestAllowed(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x00cf
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00cf }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00cf }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            r2 = 1
            if (r5 == 0) goto L_0x0017
            int r5 = r5.length()     // Catch:{ Exception -> 0x00cf }
            if (r5 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r5 = 0
            goto L_0x0018
        L_0x0017:
            r5 = 1
        L_0x0018:
            r3 = 0
            if (r5 == 0) goto L_0x0021
            java.lang.String r4 = "type"
            java.lang.String r4 = r1.optString(r4, r3)     // Catch:{ Exception -> 0x00cf }
        L_0x0021:
            java.lang.String r5 = "request:site:1"
            java.lang.String r5 = r1.optString(r5, r3)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = "1"
            if (r4 != 0) goto L_0x002d
            goto L_0x00be
        L_0x002d:
            int r3 = r4.hashCode()     // Catch:{ Exception -> 0x00cf }
            switch(r3) {
                case -1291414663: goto L_0x00a3;
                case -803607946: goto L_0x009a;
                case -396921769: goto L_0x0080;
                case 78497: goto L_0x0077;
                case 78507: goto L_0x006e;
                case 78510: goto L_0x0065;
                case 55966151: goto L_0x005c;
                case 474319559: goto L_0x0053;
                case 1081923241: goto L_0x004a;
                case 1732312992: goto L_0x0040;
                case 1941468006: goto L_0x0036;
                default: goto L_0x0034;
            }     // Catch:{ Exception -> 0x00cf }
        L_0x0034:
            goto L_0x00be
        L_0x0036:
            java.lang.String r3 = "p2c::vpa"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x0040:
            java.lang.String r3 = "p2c::store"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x004a:
            java.lang.String r3 = "p2c::merchant"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x0053:
            java.lang.String r3 = "p2bk::bank"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x005c:
            java.lang.String r3 = "p2c::vpam"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x0065:
            java.lang.String r3 = "P2P"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x006e:
            java.lang.String r3 = "P2M"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x0077:
            java.lang.String r3 = "P2C"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x0088
        L_0x0080:
            java.lang.String r3 = "p2c::vertical"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
        L_0x0088:
            if (r5 == 0) goto L_0x00cf
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            java.lang.CharSequence r4 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cf }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x00cf }
        L_0x0098:
            r0 = r4
            goto L_0x00cf
        L_0x009a:
            java.lang.String r3 = "p2p::merchant"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
            goto L_0x00ab
        L_0x00a3:
            java.lang.String r3 = "p2p::user"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00be
        L_0x00ab:
            if (r5 == 0) goto L_0x00bc
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            java.lang.CharSequence r4 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cf }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0098
        L_0x00bc:
            r0 = 1
            goto L_0x00cf
        L_0x00be:
            if (r5 == 0) goto L_0x00bc
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00cf }
            java.lang.CharSequence r4 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cf }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0098
        L_0x00cf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatVariantUtilKt.isRequestAllowed(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0087, code lost:
        if (r5.equals("p2c::vertical") != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0089, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009a, code lost:
        if (kotlin.m.p.a(kotlin.m.p.b(r6).toString(), "REPLY_ALLOWED", true) != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00aa, code lost:
        if (kotlin.m.p.a(kotlin.m.p.b(r6).toString(), "allowed", true) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bd, code lost:
        if (r5.equals("p2p::user") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bf, code lost:
        if (r6 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d0, code lost:
        if (kotlin.m.p.a(kotlin.m.p.b(r6).toString(), "REPLY_ALLOWED", true) != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e0, code lost:
        if (kotlin.m.p.a(kotlin.m.p.b(r6).toString(), "allowed", true) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[Catch:{ Exception -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[SYNTHETIC, Splitter:B:16:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isReplyAllowed(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0107
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0107 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0107 }
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0107 }
            r2 = 1
            if (r6 == 0) goto L_0x0017
            int r6 = r6.length()     // Catch:{ Exception -> 0x0107 }
            if (r6 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r6 = 0
            goto L_0x0018
        L_0x0017:
            r6 = 1
        L_0x0018:
            r3 = 0
            if (r6 == 0) goto L_0x0021
            java.lang.String r5 = "type"
            java.lang.String r5 = r1.optString(r5, r3)     // Catch:{ Exception -> 0x0107 }
        L_0x0021:
            java.lang.String r6 = "replyStatus"
            java.lang.String r6 = r1.optString(r6, r3)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r1 = "allowed"
            java.lang.String r3 = "REPLY_ALLOWED"
            if (r5 != 0) goto L_0x002f
            goto L_0x00e3
        L_0x002f:
            int r4 = r5.hashCode()     // Catch:{ Exception -> 0x0107 }
            switch(r4) {
                case -1291414663: goto L_0x00b7;
                case -803607946: goto L_0x00ae;
                case -396921769: goto L_0x0081;
                case 78497: goto L_0x0078;
                case 78507: goto L_0x006f;
                case 78510: goto L_0x0066;
                case 55966151: goto L_0x005d;
                case 474319559: goto L_0x0054;
                case 1081923241: goto L_0x004b;
                case 1732312992: goto L_0x0041;
                case 1941468006: goto L_0x0038;
                default: goto L_0x0036;
            }     // Catch:{ Exception -> 0x0107 }
        L_0x0036:
            goto L_0x00e3
        L_0x0038:
            java.lang.String r4 = "p2c::vpa"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x0089
        L_0x0041:
            java.lang.String r4 = "p2c::store"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x00bf
        L_0x004b:
            java.lang.String r4 = "p2c::merchant"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x0089
        L_0x0054:
            java.lang.String r4 = "p2bk::bank"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x0089
        L_0x005d:
            java.lang.String r4 = "p2c::vpam"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x0089
        L_0x0066:
            java.lang.String r4 = "P2P"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x00bf
        L_0x006f:
            java.lang.String r4 = "P2M"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x00bf
        L_0x0078:
            java.lang.String r4 = "P2C"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x0089
        L_0x0081:
            java.lang.String r4 = "p2c::vertical"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
        L_0x0089:
            if (r6 == 0) goto L_0x0107
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0107 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0107 }
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r3, (boolean) r2)     // Catch:{ Exception -> 0x0107 }
            if (r5 != 0) goto L_0x00ac
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0107 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r6)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0107 }
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x0107
        L_0x00ac:
            r0 = 1
            goto L_0x0107
        L_0x00ae:
            java.lang.String r4 = "p2p::merchant"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
            goto L_0x00bf
        L_0x00b7:
            java.lang.String r4 = "p2p::user"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00e3
        L_0x00bf:
            if (r6 == 0) goto L_0x00ac
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0107 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0107 }
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r3, (boolean) r2)     // Catch:{ Exception -> 0x0107 }
            if (r5 != 0) goto L_0x00ac
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0107 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r6)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0107 }
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x0107
            goto L_0x00ac
        L_0x00e3:
            if (r6 == 0) goto L_0x00ac
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0107 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0107 }
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r3, (boolean) r2)     // Catch:{ Exception -> 0x0107 }
            if (r5 != 0) goto L_0x00ac
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0107 }
            java.lang.CharSequence r5 = kotlin.m.p.b(r6)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0107 }
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x0107
            goto L_0x00ac
        L_0x0107:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatVariantUtilKt.isReplyAllowed(java.lang.String, java.lang.String):boolean");
    }
}
