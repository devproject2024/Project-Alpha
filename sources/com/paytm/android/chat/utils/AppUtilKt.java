package com.paytm.android.chat.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.b;
import com.alipay.mobile.h5container.api.H5Event;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gson.o;
import com.google.gsonhtcfix.f;
import com.imsdk.LoginInfo;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.RegistrationStatus;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.bean.UserType;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.bean.jsonbean.AdminMessageBean;
import com.paytm.android.chat.d;
import com.paytm.android.chat.g;
import com.paytm.android.chat.network.requests.RegistUserRequest;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.SendBird;
import com.sendbird.android.User;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public final class AppUtilKt {
    private static final f gson = new f();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[ChatUserType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChatUserType.CUSTOMER.ordinal()] = 1;
            $EnumSwitchMapping$0[ChatUserType.MERCHANT.ordinal()] = 2;
            $EnumSwitchMapping$0[ChatUserType.VPA.ordinal()] = 3;
            $EnumSwitchMapping$0[ChatUserType.BANK.ordinal()] = 4;
            $EnumSwitchMapping$0[ChatUserType.MOBILE_NUMBER.ordinal()] = 5;
            int[] iArr2 = new int[ChatUserType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ChatUserType.CUSTOMER.ordinal()] = 1;
            int[] iArr3 = new int[ChatUserType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ChatUserType.VPA.ordinal()] = 1;
            int[] iArr4 = new int[UserType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[UserType.CUSTOMER.ordinal()] = 1;
            $EnumSwitchMapping$3[UserType.MERCHANT.ordinal()] = 2;
            $EnumSwitchMapping$3[UserType.CHANNEL.ordinal()] = 3;
        }
    }

    public static final ReceiverDisplayInfo getReceiverDisplayInfo() {
        return getReceiverDisplayInfo$default((GroupChannel) null, (SyncContactBean) null, 3, (Object) null);
    }

    public static final ReceiverDisplayInfo getReceiverDisplayInfo(GroupChannel groupChannel) {
        return getReceiverDisplayInfo$default(groupChannel, (SyncContactBean) null, 2, (Object) null);
    }

    public static final f getGson() {
        return gson;
    }

    public static final boolean isMe(String str) {
        k.c(str, "userId");
        return k.a((Object) str, (Object) SharedPreferencesUtil.getUserId());
    }

    public static final void reInitializeChatManager(Context context) {
        Context context2;
        if (context != null) {
            try {
                context2 = context.getApplicationContext();
            } catch (Exception unused) {
                return;
            }
        } else {
            context2 = null;
        }
        if (!(context2 instanceof Application)) {
            context2 = null;
        }
        Application application = (Application) context2;
        if (application != null) {
            Class<?> cls = Class.forName("net.one97.paytm.chat.ChatImplProvider");
            k.a((Object) cls, "Class.forName(\"net.one97…m.chat.ChatImplProvider\")");
            Method declaredMethod = cls.getDeclaredMethod("init", new Class[]{Application.class});
            k.a((Object) declaredMethod, "chatImpProviderClass.get… Application::class.java)");
            declaredMethod.invoke((Object) null, new Object[]{application});
        }
    }

    public static final String sanitizeToken(String str) {
        String a2;
        String a3;
        String a4;
        if (str == null) {
            return null;
        }
        if (str != null) {
            String obj = p.b(str).toString();
            if (obj == null || (a2 = p.a(obj, StringUtility.NEW_LINE, "", false)) == null || (a3 = p.a(a2, "\t", "", false)) == null || (a4 = p.a(a3, "\r", "", false)) == null) {
                return null;
            }
            return p.a(a4, " ", "", false);
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final boolean isSpecialSymbols(String str) {
        return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@①#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).find();
    }

    public static final boolean isNumber(String str) {
        return Pattern.compile("[0-9]").matcher(str).find();
    }

    public static final boolean hasPermission(Context context, String str) {
        k.c(str, "permission");
        return context != null && b.a(context, str) == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final net.one97.paytm.common.entity.wallet.chatintegration.MTSDKReceiverDetail convertChatUserEntityToMTSDKReceiverDetail(com.paytm.android.chat.data.models.users.ChatUserDataModel r27, net.one97.paytm.common.entity.IJRDataModel r28) {
        /*
            r0 = 0
            if (r27 == 0) goto L_0x00d0
            net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r1 = r27.getType()
            if (r1 != 0) goto L_0x000a
            goto L_0x0021
        L_0x000a:
            int[] r2 = com.paytm.android.chat.utils.AppUtilKt.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0095
            r2 = 2
            if (r1 == r2) goto L_0x0075
            r2 = 3
            if (r1 == r2) goto L_0x005c
            r2 = 4
            if (r1 == r2) goto L_0x003b
            r2 = 5
            if (r1 == r2) goto L_0x0024
        L_0x0021:
            r15 = r0
            goto L_0x00ae
        L_0x0024:
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail r1 = new net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail
            r4 = 3
            r5 = 0
            java.lang.String r6 = r27.getIdentifier()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 506(0x1fa, float:7.09E-43)
            r14 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00ad
        L_0x003b:
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail r1 = new net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail
            r16 = 2
            r17 = 0
            java.lang.String r24 = r27.getIdentifier()
            java.lang.String r18 = r27.getPhoneNumber()
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 250(0xfa, float:3.5E-43)
            r26 = 0
            r15 = r1
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x00ae
        L_0x005c:
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail r1 = new net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail
            r3 = 4
            r4 = 0
            java.lang.String r8 = r27.getIdentifier()
            java.lang.String r5 = r27.getPhoneNumber()
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 474(0x1da, float:6.64E-43)
            r13 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x00ad
        L_0x0075:
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail r1 = new net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail
            r15 = 1
            java.lang.String r16 = r27.getIdentifier()
            java.lang.String r17 = r27.getPhoneNumber()
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 504(0x1f8, float:7.06E-43)
            r25 = 0
            r14 = r1
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x00ad
        L_0x0095:
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail r1 = new net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail
            r3 = 1
            java.lang.String r4 = r27.getIdentifier()
            java.lang.String r5 = r27.getPhoneNumber()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 504(0x1f8, float:7.06E-43)
            r13 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x00ad:
            r15 = r1
        L_0x00ae:
            if (r15 == 0) goto L_0x00d0
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKReceiverDetail r0 = new net.one97.paytm.common.entity.wallet.chatintegration.MTSDKReceiverDetail
            java.lang.String r1 = r27.getSendbirdUsername()
            if (r1 != 0) goto L_0x00ba
            java.lang.String r1 = ""
        L_0x00ba:
            r16 = r1
            java.lang.String r17 = r27.getAvatarUrl()
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 56
            r23 = 0
            r14 = r0
            r21 = r28
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23)
        L_0x00d0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.AppUtilKt.convertChatUserEntityToMTSDKReceiverDetail(com.paytm.android.chat.data.models.users.ChatUserDataModel, net.one97.paytm.common.entity.IJRDataModel):net.one97.paytm.common.entity.wallet.chatintegration.MTSDKReceiverDetail");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e A[Catch:{ Exception -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final net.one97.paytm.common.entity.moneytransfer.requestmoney.MTRequestMoneyDetails convertChatUserEntityToMTRequestMoneyDetails(com.paytm.android.chat.data.models.users.ChatUserDataModel r12, com.paytm.android.chat.bean.ReceiverDisplayInfo r13) {
        /*
            java.lang.String r0 = "receiverDisplayInfo"
            kotlin.g.b.k.c(r13, r0)
            r0 = 0
            if (r12 == 0) goto L_0x0076
            net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r1 = r12.constructChatPayeeUser()     // Catch:{ Exception -> 0x0068 }
            if (r1 == 0) goto L_0x0076
            java.lang.String r2 = r12.getSendbirdUsername()     // Catch:{ Exception -> 0x0068 }
            if (r2 != 0) goto L_0x0016
            java.lang.String r2 = ""
        L_0x0016:
            net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r3 = r1.getType()     // Catch:{ Exception -> 0x0068 }
            int[] r4 = com.paytm.android.chat.utils.AppUtilKt.WhenMappings.$EnumSwitchMapping$1     // Catch:{ Exception -> 0x0068 }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x0068 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x0068 }
            r4 = 1
            if (r3 == r4) goto L_0x0027
            r3 = r0
            goto L_0x002c
        L_0x0027:
            java.lang.String r1 = r1.getIdentifier()     // Catch:{ Exception -> 0x0068 }
            r3 = r1
        L_0x002c:
            net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r1 = r12.getType()     // Catch:{ Exception -> 0x0068 }
            if (r1 != 0) goto L_0x0033
            goto L_0x003d
        L_0x0033:
            int[] r5 = com.paytm.android.chat.utils.AppUtilKt.WhenMappings.$EnumSwitchMapping$2     // Catch:{ Exception -> 0x0068 }
            int r1 = r1.ordinal()     // Catch:{ Exception -> 0x0068 }
            r1 = r5[r1]     // Catch:{ Exception -> 0x0068 }
            if (r1 == r4) goto L_0x003f
        L_0x003d:
            r5 = r0
            goto L_0x0044
        L_0x003f:
            java.lang.String r1 = r12.getIdentifier()     // Catch:{ Exception -> 0x0068 }
            r5 = r1
        L_0x0044:
            java.lang.String r11 = r12.getAvatarUrl()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r12 = r12.getPhoneNumber()     // Catch:{ Exception -> 0x0068 }
            if (r12 != 0) goto L_0x0052
            java.lang.String r12 = r13.getPhoneNumber()     // Catch:{ Exception -> 0x0068 }
        L_0x0052:
            r4 = r12
            if (r3 != 0) goto L_0x005a
            if (r5 != 0) goto L_0x005a
            if (r4 != 0) goto L_0x005a
            goto L_0x0076
        L_0x005a:
            net.one97.paytm.common.entity.moneytransfer.requestmoney.MTRequestMoneyDetails r12 = new net.one97.paytm.common.entity.moneytransfer.requestmoney.MTRequestMoneyDetails     // Catch:{ Exception -> 0x0068 }
            java.lang.String r6 = ""
            r7 = 1
            r8 = 0
            r9 = 1
            r10 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0068 }
            r0 = r12
            goto L_0x0076
        L_0x0068:
            r12 = move-exception
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r13 = "error creating chatPayeeuser : "
            java.lang.String r12 = r13.concat(r12)
            com.paytm.utility.q.d(r12)
        L_0x0076:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.AppUtilKt.convertChatUserEntityToMTRequestMoneyDetails(com.paytm.android.chat.data.models.users.ChatUserDataModel, com.paytm.android.chat.bean.ReceiverDisplayInfo):net.one97.paytm.common.entity.moneytransfer.requestmoney.MTRequestMoneyDetails");
    }

    public static /* synthetic */ ReceiverDisplayInfo getReceiverDisplayInfo$default(GroupChannel groupChannel, SyncContactBean syncContactBean, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            groupChannel = null;
        }
        if ((i2 & 2) != 0) {
            syncContactBean = null;
        }
        return getReceiverDisplayInfo(groupChannel, syncContactBean);
    }

    public static final ReceiverDisplayInfo getReceiverDisplayInfo(GroupChannel groupChannel, SyncContactBean syncContactBean) {
        Member member;
        RegistrationStatus registrationStatus;
        UserType userType;
        String str;
        String str2;
        String name;
        Object obj;
        ReceiverDisplayInfo receiverDisplayInfo = new ReceiverDisplayInfo();
        if (syncContactBean == null) {
            syncContactBean = getContactIfAvailable(groupChannel);
        }
        if (syncContactBean != null) {
            receiverDisplayInfo.setPhoneNumber(syncContactBean.getContactPhone());
            if (!TextUtils.isEmpty(syncContactBean.getContactName())) {
                receiverDisplayInfo.setProfileImage(syncContactBean.getContactPic());
                receiverDisplayInfo.setName(syncContactBean.getContactName());
                receiverDisplayInfo.setFromContact(true);
            }
        }
        if (groupChannel != null) {
            ChannelMetaData a2 = g.a((BaseChannel) groupChannel);
            if (a2 != null) {
                receiverDisplayInfo.setChatType(a2.getChatType());
                receiverDisplayInfo.setSource(a2.getSource());
            }
            List<Member> members = groupChannel.getMembers();
            String str3 = null;
            if (members != null) {
                Iterator it2 = members.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    Member member2 = (Member) obj;
                    String userId = SharedPreferencesUtil.getUserId();
                    k.a((Object) member2, "it");
                    if (!k.a((Object) userId, (Object) member2.getUserId())) {
                        break;
                    }
                }
                member = (Member) obj;
            } else {
                member = null;
            }
            receiverDisplayInfo.setReceiver(member);
            Member receiver = receiverDisplayInfo.getReceiver();
            if (receiver != null) {
                UserMetaData a3 = g.a((User) receiver);
                if (a3 == null || (registrationStatus = a3.getRegistrationStatus()) == null) {
                    registrationStatus = RegistrationStatus.COMPLETE;
                }
                receiverDisplayInfo.setRegistrationStatus(registrationStatus);
                if (a3 == null || (userType = a3.getUserType()) == null) {
                    userType = UserType.CUSTOMER;
                }
                receiverDisplayInfo.setUserType(userType);
                receiverDisplayInfo.setLocationString(a3 != null ? a3.getLocationString() : null);
                receiverDisplayInfo.setAddress(a3 != null ? a3.getAddressString() : null);
                receiverDisplayInfo.setPaytmChannelId(a3 != null ? a3.getPaytmChannelId() : null);
                receiverDisplayInfo.setBusinessNameAvailable(((a3 == null || (name = a3.getName()) == null) ? null : com.paytm.android.chat.f.a(name)) != null);
                int i2 = WhenMappings.$EnumSwitchMapping$3[receiverDisplayInfo.getUserType().ordinal()];
                if (i2 == 1) {
                    if (!receiverDisplayInfo.isFromContact()) {
                        receiverDisplayInfo.setName(receiver.getNickname());
                    }
                    String profileImage = receiverDisplayInfo.getProfileImage();
                    if (profileImage != null) {
                        str3 = com.paytm.android.chat.f.a(profileImage);
                    }
                    if (str3 == null) {
                        receiverDisplayInfo.setProfileImage(receiver.getProfileUrl());
                    }
                } else if (i2 == 2 || i2 == 3) {
                    if (!receiverDisplayInfo.isFromContact()) {
                        if (a3 == null || (str2 = a3.getName()) == null) {
                            str2 = receiver.getNickname();
                        }
                        receiverDisplayInfo.setName(str2);
                    }
                    String profileImage2 = receiverDisplayInfo.getProfileImage();
                    if ((profileImage2 != null ? com.paytm.android.chat.f.a(profileImage2) : null) == null) {
                        if (a3 == null || (str = a3.getLogoUrl()) == null) {
                            str = receiver.getProfileUrl();
                        }
                        receiverDisplayInfo.setProfileImage(str);
                    }
                    if (a3 != null) {
                        str3 = a3.getName();
                    }
                    receiverDisplayInfo.setBusinessName(str3);
                }
            }
        }
        return receiverDisplayInfo;
    }

    public static final SyncContactBean getContactIfAvailable(GroupChannel groupChannel) {
        Object obj;
        if (groupChannel == null) {
            return null;
        }
        SyncContactBean searchContactDBByUrl = ContactManager.getInstance().searchContactDBByUrl(groupChannel.getUrl());
        if (searchContactDBByUrl != null) {
            return searchContactDBByUrl;
        }
        List<Member> members = groupChannel.getMembers();
        if (members == null) {
            return null;
        }
        Iterator it2 = members.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            Member member = (Member) obj;
            String userId = SharedPreferencesUtil.getUserId();
            k.a((Object) member, "it");
            if (!k.a((Object) userId, (Object) member.getUserId())) {
                break;
            }
        }
        Member member2 = (Member) obj;
        if (member2 != null) {
            return ContactManager.getInstance().searchContactById(member2.getUserId());
        }
        return null;
    }

    public static final String getMyProfilePic(Context context) {
        String str;
        if (context != null) {
            a.C0708a aVar = a.f42641a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            String b2 = a.C0708a.a(applicationContext, a.c.CHAT).b(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, "", true);
            if (b2 == null || (str = com.paytm.android.chat.f.a(b2)) == null) {
                str = "";
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static final AdminMessageBean getAdminMessage(BaseMessage baseMessage) {
        Object obj;
        AdminMessageBean adminMessageBean = new AdminMessageBean();
        if (baseMessage != null) {
            adminMessageBean.parseMetaData(baseMessage.getData());
            ArrayList<AdminMessageBean.AdminMetaData> metaData = adminMessageBean.getMetaData();
            k.a((Object) metaData, "metaData");
            Iterator it2 = metaData.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                AdminMessageBean.AdminMetaData adminMetaData = (AdminMessageBean.AdminMetaData) obj;
                k.a((Object) adminMetaData, "it");
                if (k.a((Object) adminMetaData.getUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                    break;
                }
            }
            AdminMessageBean.AdminMetaData adminMetaData2 = (AdminMessageBean.AdminMetaData) obj;
            if (adminMetaData2 != null) {
                AdminMessageBean.Data data = adminMetaData2.getData();
                k.a((Object) data, "data.data");
                adminMessageBean.message = data.getMessage();
                adminMessageBean.previewText = adminMetaData2.getPreviewText();
                adminMessageBean.messageId = baseMessage.getMessageId();
                adminMessageBean.time = baseMessage.getCreatedAt();
            }
        }
        return adminMessageBean;
    }

    public static final AdminMessageBean getValidAdminMessage(BaseMessage baseMessage) {
        Object obj;
        if (!(baseMessage instanceof AdminMessage) || !p.a("ADMM_TEXT", baseMessage.getCustomType(), true)) {
            return null;
        }
        AdminMessageBean adminMessageBean = new AdminMessageBean();
        adminMessageBean.parseMetaData(baseMessage.getData());
        ArrayList<AdminMessageBean.AdminMetaData> metaData = adminMessageBean.getMetaData();
        k.a((Object) metaData, "metaData");
        Iterator it2 = metaData.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            AdminMessageBean.AdminMetaData adminMetaData = (AdminMessageBean.AdminMetaData) obj;
            k.a((Object) adminMetaData, "it");
            if (k.a((Object) adminMetaData.getUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                break;
            }
        }
        AdminMessageBean.AdminMetaData adminMetaData2 = (AdminMessageBean.AdminMetaData) obj;
        if (adminMetaData2 != null) {
            AdminMessageBean.Data data = adminMetaData2.getData();
            k.a((Object) data, "data.data");
            adminMessageBean.message = data.getMessage();
            adminMessageBean.previewText = adminMetaData2.getPreviewText();
            adminMessageBean.messageId = baseMessage.getMessageId();
            adminMessageBean.time = baseMessage.getCreatedAt();
        }
        if (TextUtils.isEmpty(adminMessageBean.message)) {
            return null;
        }
        return adminMessageBean;
    }

    public static final UserMetaData getCurrentUserMetaData() {
        try {
            return g.a(SendBird.getCurrentUser());
        } catch (Exception unused) {
            return null;
        }
    }

    public static final AdminMessageBean.CTADetail getMyAdminMessageCtaDetails(AdminMessageBean adminMessageBean) {
        ArrayList<AdminMessageBean.AdminMetaData> metaData;
        Object obj;
        AdminMessageBean.Data data;
        if (!(adminMessageBean == null || (metaData = adminMessageBean.getMetaData()) == null)) {
            Iterator it2 = metaData.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                AdminMessageBean.AdminMetaData adminMetaData = (AdminMessageBean.AdminMetaData) obj;
                k.a((Object) adminMetaData, "it");
                if (k.a((Object) adminMetaData.getUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                    break;
                }
            }
            AdminMessageBean.AdminMetaData adminMetaData2 = (AdminMessageBean.AdminMetaData) obj;
            if (!(adminMetaData2 == null || (data = adminMetaData2.getData()) == null)) {
                return data.getCtaDetail();
            }
        }
        return null;
    }

    public static final AdminMessageBean.UIInfo getMyAdminMessageUiInfoDetails(AdminMessageBean adminMessageBean) {
        ArrayList<AdminMessageBean.AdminMetaData> metaData;
        Object obj;
        if (!(adminMessageBean == null || (metaData = adminMessageBean.getMetaData()) == null)) {
            Iterator it2 = metaData.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                AdminMessageBean.AdminMetaData adminMetaData = (AdminMessageBean.AdminMetaData) obj;
                k.a((Object) adminMetaData, "it");
                if (k.a((Object) adminMetaData.getUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                    break;
                }
            }
            AdminMessageBean.AdminMetaData adminMetaData2 = (AdminMessageBean.AdminMetaData) obj;
            if (adminMetaData2 != null) {
                return adminMetaData2.getUiInfo();
            }
        }
        return null;
    }

    public static final String setImageReplyThumb(BaseMessage baseMessage) {
        String str;
        k.c(baseMessage, "baseMessage");
        String data = baseMessage.getData();
        if (!TextUtils.isEmpty(data)) {
            Object a2 = new com.google.gson.f().a(data, o.class);
            k.a(a2, "com.google.gson.Gson().f…, JsonObject::class.java)");
            o oVar = (o) a2;
            if (oVar.a("url")) {
                str = oVar.b("url").c();
                k.a((Object) str, "jsonObject.get(\"url\").getAsString()");
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static final void registerChatToServer(Context context, RegistUserRequest.PFRegistCallBack pFRegistCallBack) {
        k.c(pFRegistCallBack, H5Event.TYPE_CALL_BACK);
        ChatManager.b().a(SharedPreferencesUtil.getPFId().toString(), SharedPreferencesUtil.getNickname(), SharedPreferencesUtil.getMobileNumber(), getMyProfilePic(context), SharedPreferencesUtil.getToken(), pFRegistCallBack);
    }

    public static final boolean checkIfRegisterIsUptoDateWithVersion() {
        String string = SharedPreferencesUtil.getString(SharedPreferencesUtil.Key.LAST_REGISTER_CALLED_FOR_VERSION, "");
        ChatManager b2 = ChatManager.b();
        k.a((Object) b2, "ChatManager.getInstance()");
        d g2 = b2.g();
        k.a((Object) g2, "ChatManager.getInstance().chatGenericListener");
        return p.a(string, g2.a(), true);
    }

    public static /* synthetic */ void connectChatToServer$default(Context context, kotlin.g.a.b bVar, m mVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bVar = null;
        }
        if ((i2 & 4) != 0) {
            mVar = null;
        }
        connectChatToServer(context, bVar, mVar);
    }

    public static final void connectChatToServer(Context context, kotlin.g.a.b<? super LoginInfo, x> bVar, m<? super Integer, ? super String, x> mVar) {
        ChatManager b2 = ChatManager.b();
        k.a((Object) b2, "ChatManager.getInstance()");
        if (!b2.a().isSenbirdWSConnected()) {
            ChatManager.b().a((ChatManager.c) new AppUtilKt$connectChatToServer$1(context));
        }
        ChatManager.b().a(SharedPreferencesUtil.getUserId(), SharedPreferencesUtil.getNickname(), SharedPreferencesUtil.getMobileNumber(), SharedPreferencesUtil.getProfileImg(), SharedPreferencesUtil.getToken(), SharedPreferencesUtil.getSBToken(), new AppUtilKt$connectChatToServer$2(mVar, bVar));
    }

    public static final boolean areStringsEqual(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null && str2 != null) {
            return false;
        }
        if (str == null || str2 != null) {
            return p.a(str, str2, true);
        }
        return false;
    }

    public static final String convertToHash(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            k.a((Object) instance, "MessageDigest.getInstance(\"SHA-256\")");
            Charset forName = Charset.forName(AppConstants.UTF_8);
            k.a((Object) forName, "Charset.forName(\"UTF-8\")");
            if (str != null) {
                byte[] bytes = str.getBytes(forName);
                k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                StringBuilder sb = new StringBuilder(new BigInteger(1, instance.digest(bytes)).toString(16));
                while (sb.length() < 32) {
                    sb.insert(0, '0');
                }
                return sb.toString();
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String sanitizeContact(String str) {
        k.c(str, "string");
        if (str.charAt(0) == '0') {
            str = str.substring(1);
            k.a((Object) str, "(this as java.lang.String).substring(startIndex)");
        }
        String a2 = p.a(p.a(p.a(p.a(p.a(str, "+91", "", false), "-", "", false), "(", "", false), ")", "", false), " ", "", false);
        int min = Math.min(a2.length(), 10);
        if (a2 != null) {
            String substring = a2.substring(0, min);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean isAppOnForeground() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
