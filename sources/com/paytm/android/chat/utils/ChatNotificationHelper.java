package com.paytm.android.chat.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.h;
import androidx.core.app.l;
import androidx.core.graphics.drawable.IconCompat;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.bean.jsonbean.PushBean;
import com.paytm.android.chat.data.db.room.db_entities.SendbirdNotificationEntity;
import com.paytm.android.chat.data.db.room.helper.NotificationDBHelperKt;
import com.paytm.android.chat.utils.MessageContentUtils;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.Sender;
import com.sendbird.android.UserMessage;
import com.sendbird.android.constant.StringSet;
import io.reactivex.rxjava3.a.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.paytm_finance.R;
import org.json.JSONObject;

public final class ChatNotificationHelper {
    private static final String CHAT_NOTIFICATION_CHANNEL_ID = CHAT_NOTIFICATION_CHANNEL_ID;
    private static final String CHAT_NOTIFICATION_CHANNEL_NAME = CHAT_NOTIFICATION_CHANNEL_NAME;
    private static String GROUP_KEY_CHAT = "net.one97.paytm.chat.CHAT";
    /* access modifiers changed from: private */
    public static final int INITIAL_NOTIFICATION_ID = INITIAL_NOTIFICATION_ID;
    public static final ChatNotificationHelper INSTANCE = new ChatNotificationHelper();
    /* access modifiers changed from: private */
    public static final int SUMMARY_NOTIFICATION_ID = SUMMARY_NOTIFICATION_ID;
    /* access modifiers changed from: private */
    public static final com.google.gsonhtcfix.f gson = new com.google.gsonhtcfix.f();
    private static boolean init;
    /* access modifiers changed from: private */
    public static io.reactivex.rxjava3.j.b<PushBean> notificationHandlePublishSubject = io.reactivex.rxjava3.j.b.a();

    static final class c<T> implements io.reactivex.rxjava3.d.g<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f42326a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class d<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f42327a = new d();

        d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class f<T> implements io.reactivex.rxjava3.d.g<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f42329a = new f();

        f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class g<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f42330a = new g();

        g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class j<T> implements io.reactivex.rxjava3.d.g<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final j f42335a = new j();

        j() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class k<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f42336a = new k();

        k() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class e<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f42328a;

        e(Context context) {
            this.f42328a = context;
        }

        public final /* synthetic */ Object apply(Object obj) {
            PushBean pushBean = (PushBean) obj;
            StringBuilder sb = new StringBuilder();
            kotlin.g.b.k.a((Object) pushBean, "pushBean");
            PushBean.ChannelBean channel = pushBean.getChannel();
            kotlin.g.b.k.a((Object) channel, "pushBean.channel");
            sb.append(channel.getChannel_url());
            sb.append(pushBean.getMessage_id());
            String sb2 = sb.toString();
            PushBean.RecipientBean recipient = pushBean.getRecipient();
            kotlin.g.b.k.a((Object) recipient, "pushBean.recipient");
            if (recipient.getId() != null && !p.a(SharedPreferencesUtil.getUserId(), H5BridgeContext.INVALID_ID, true)) {
                PushBean.ChannelBean channel2 = pushBean.getChannel();
                kotlin.g.b.k.a((Object) channel2, "pushBean.channel");
                if (ChatVariantUtilKt.isNotificationToBeShownForVariant(channel2.getData())) {
                    PushBean.RecipientBean recipient2 = pushBean.getRecipient();
                    kotlin.g.b.k.a((Object) recipient2, "pushBean.recipient");
                    if (p.a(recipient2.getId(), SharedPreferencesUtil.getUserId(), true)) {
                        String a2 = ChatNotificationHelper.gson.a((Object) pushBean);
                        if (!TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(a2)) {
                            ChatNotificationHelper.INSTANCE.markMessageAsDelivered(pushBean);
                            PushBean.ChannelBean channel3 = pushBean.getChannel();
                            kotlin.g.b.k.a((Object) channel3, "pushBean.channel");
                            String channel_url = channel3.getChannel_url();
                            kotlin.g.b.k.a((Object) channel_url, "pushBean.channel.channel_url");
                            kotlin.g.b.k.a((Object) a2, "payload");
                            NotificationDBHelperKt.addNotificationEntry(sb2, channel_url, a2);
                            Iterable<SendbirdNotificationEntity> allNotificationMessage = NotificationDBHelperKt.getAllNotificationMessage();
                            Collection arrayList = new ArrayList(kotlin.a.k.a(allNotificationMessage));
                            for (SendbirdNotificationEntity payload : allNotificationMessage) {
                                arrayList.add((PushBean) ChatNotificationHelper.gson.a(payload.getPayload(), PushBean.class));
                            }
                            ChatNotificationHelper.INSTANCE.triggerNotification(this.f42328a, (List) arrayList);
                        }
                    }
                }
            }
            return x.f47997a;
        }
    }

    static final class i<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f42334a = new i();

        i() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            ChatNotificationHelper.notificationHandlePublishSubject.onNext((PushBean) obj);
            return x.f47997a;
        }
    }

    private ChatNotificationHelper() {
    }

    public final void clearAllNotification(Context context) {
        if (context != null) {
            y.a(new b(context)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(c.f42326a, (io.reactivex.rxjava3.d.g<? super Throwable>) d.f42327a);
        }
    }

    public final void postNotification(Context context, PushBean pushBean) {
        if (isValidNotification(pushBean) && context != null) {
            ChatNotificationHelper chatNotificationHelper = INSTANCE;
            Context applicationContext = context.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
            chatNotificationHelper.init(applicationContext);
            if (pushBean != null) {
                notificationHandlePublishSubject.onNext(pushBean);
            }
        }
    }

    public final void postNotification(Context context, BaseChannel baseChannel, BaseMessage baseMessage) {
        if (context != null) {
            ChatNotificationHelper chatNotificationHelper = INSTANCE;
            Context applicationContext = context.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
            chatNotificationHelper.init(applicationContext);
            if (baseChannel != null && !(baseChannel instanceof OpenChannel)) {
                if ((!(baseChannel instanceof GroupChannel) || ((GroupChannel) baseChannel).isPushEnabled()) && baseMessage != null) {
                    y.a(new h(context, baseChannel, baseMessage)).b(i.f42334a).b(io.reactivex.rxjava3.i.a.a()).a(io.reactivex.rxjava3.i.a.a()).a(j.f42335a, (io.reactivex.rxjava3.d.g<? super Throwable>) k.f42336a);
                }
            }
        }
    }

    static final class h<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f42331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f42332b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseMessage f42333c;

        h(Context context, BaseChannel baseChannel, BaseMessage baseMessage) {
            this.f42331a = context;
            this.f42332b = baseChannel;
            this.f42333c = baseMessage;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public PushBean call() {
            boolean z;
            String str;
            Object obj;
            String str2;
            try {
                z = new JSONObject(this.f42333c.getData()).getBoolean("send_push");
            } catch (Exception unused) {
                z = true;
            }
            if (z) {
                Sender sender = this.f42333c.getSender();
                PushBean pushBean = new PushBean();
                pushBean.setMessage_id(this.f42333c.getMessageId());
                BaseMessage baseMessage = this.f42333c;
                if (baseMessage instanceof UserMessage) {
                    pushBean.setType(StringSet.MESG);
                    MessageContentUtils.MessageContentBean contentBean = MessageContentUtils.getContentBean(this.f42333c);
                    if (contentBean == null || (str2 = contentBean.content) == null) {
                        str2 = "";
                    }
                    pushBean.setMessage(str2);
                } else if (baseMessage instanceof FileMessage) {
                    pushBean.setType(StringSet.FILE);
                    Map linkedHashMap = new LinkedHashMap();
                    String name = ((FileMessage) this.f42333c).getName();
                    kotlin.g.b.k.a((Object) name, "baseMessage.name");
                    linkedHashMap.put("name", name);
                    String url = ((FileMessage) this.f42333c).getUrl();
                    kotlin.g.b.k.a((Object) url, "baseMessage.url");
                    linkedHashMap.put("url", url);
                    String type = ((FileMessage) this.f42333c).getType();
                    kotlin.g.b.k.a((Object) type, "baseMessage.type");
                    linkedHashMap.put(StringSet.custom_type, type);
                    pushBean.setFiles(kotlin.a.k.d(linkedHashMap));
                } else if (baseMessage instanceof AdminMessage) {
                    pushBean.setType(StringSet.ADMM);
                }
                PushBean.ChannelBean channelBean = new PushBean.ChannelBean();
                channelBean.setName(this.f42332b.getName());
                channelBean.setChannel_url(this.f42332b.getUrl());
                channelBean.setData(this.f42332b.getData());
                BaseChannel baseChannel = this.f42332b;
                if (!(baseChannel instanceof GroupChannel)) {
                    baseChannel = null;
                }
                GroupChannel groupChannel = (GroupChannel) baseChannel;
                if (groupChannel == null || (str = groupChannel.getCustomType()) == null) {
                    BaseChannel baseChannel2 = this.f42332b;
                    if (!(baseChannel2 instanceof OpenChannel)) {
                        baseChannel2 = null;
                    }
                    OpenChannel openChannel = (OpenChannel) baseChannel2;
                    str = openChannel != null ? openChannel.getCustomType() : null;
                }
                channelBean.setCustom_type(str);
                pushBean.setChannel(channelBean);
                PushBean.SenderBean senderBean = new PushBean.SenderBean();
                senderBean.setName(sender != null ? sender.getNickname() : null);
                senderBean.setProfile_url(sender != null ? sender.getProfileUrl() : null);
                senderBean.setId(sender != null ? sender.getUserId() : null);
                pushBean.setSender(senderBean);
                PushBean.RecipientBean recipientBean = new PushBean.RecipientBean();
                if (this.f42332b instanceof GroupChannel) {
                    String userId = SharedPreferencesUtil.getUserId();
                    List<Member> members = ((GroupChannel) this.f42332b).getMembers();
                    kotlin.g.b.k.a((Object) members, "baseChannel.members");
                    Iterator it2 = members.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        Member member = (Member) obj;
                        kotlin.g.b.k.a((Object) member, "it");
                        if (kotlin.g.b.k.a((Object) member.getUserId(), (Object) userId)) {
                            break;
                        }
                    }
                    Member member2 = (Member) obj;
                    if (member2 != null) {
                        recipientBean.setId(member2.getUserId());
                        recipientBean.setName(member2.getNickname());
                    }
                }
                pushBean.setRecipient(recipientBean);
                return pushBean;
            }
            throw new Exception("SendPush is false");
        }
    }

    private final void init(Context context) {
        if (!init) {
            init = true;
            notificationHandlePublishSubject.toFlowable(io.reactivex.rxjava3.a.a.BUFFER).a(io.reactivex.rxjava3.i.a.b()).a(new e(context)).d().a(f.f42329a, (io.reactivex.rxjava3.d.g<? super Throwable>) g.f42330a);
        }
    }

    /* access modifiers changed from: private */
    public final void triggerNotification(Context context, List<? extends PushBean> list) {
        Bitmap bitmap;
        long j2;
        if (!list.isEmpty()) {
            androidx.core.app.k a2 = androidx.core.app.k.a(context);
            ChatNotificationHelper chatNotificationHelper = INSTANCE;
            kotlin.g.b.k.a((Object) a2, "this");
            chatNotificationHelper.createChatNotificationChannel(a2);
            Map linkedHashMap = new LinkedHashMap();
            for (PushBean pushBean : list) {
                PushBean.ChannelBean channel = pushBean.getChannel();
                kotlin.g.b.k.a((Object) channel, "item.channel");
                String channel_url = channel.getChannel_url();
                List list2 = (List) linkedHashMap.get(channel_url);
                if (list2 != null) {
                    list2.add(pushBean);
                } else {
                    kotlin.g.b.k.a((Object) channel_url, "key");
                    linkedHashMap.put(channel_url, kotlin.a.k.c(pushBean));
                }
            }
            int size = list.size();
            int size2 = linkedHashMap.size();
            for (String str : linkedHashMap.keySet()) {
                List<PushBean> list3 = (List) linkedHashMap.get(str);
                if (list3 != null && list3.size() > 0) {
                    int abs = Math.abs(str.hashCode()) + INITIAL_NOTIFICATION_ID;
                    PushBean pushBean2 = (PushBean) kotlin.a.k.f(list3);
                    a notificationContent = INSTANCE.getNotificationContent(pushBean2);
                    PushBean.ChannelBean channel2 = pushBean2.getChannel();
                    kotlin.g.b.k.a((Object) channel2, "latestMessage.channel");
                    String channel_url2 = channel2.getChannel_url();
                    try {
                        bitmap = (Bitmap) com.bumptech.glide.b.b(context).d().a(notificationContent.f42319c).a().get();
                    } catch (Exception unused) {
                        com.bumptech.glide.h<Bitmap> d2 = com.bumptech.glide.b.b(context).d();
                        com.paytm.android.chat.e.a();
                        bitmap = (Bitmap) d2.a(Integer.valueOf(R.drawable.chat_icon_notification_avatar)).a().get();
                    }
                    ChatNotificationHelper chatNotificationHelper2 = INSTANCE;
                    kotlin.g.b.k.a((Object) bitmap, "largeIcon");
                    Bitmap circleBitmap = chatNotificationHelper2.getCircleBitmap(bitmap);
                    h.e a3 = new h.e(context).b(CHAT_NOTIFICATION_CHANNEL_ID).a((CharSequence) notificationContent.f42317a).b((CharSequence) notificationContent.f42318b).a(INSTANCE.getMessagePendingIntent(context, channel_url2, abs)).a(circleBitmap).a(true);
                    com.paytm.android.chat.e.a();
                    h.e a4 = a3.a((int) R.drawable.ic_launcher_small).a(GROUP_KEY_CHAT);
                    if (list3.size() != 1 || !p.a("Image", notificationContent.f42322f, true) || TextUtils.isEmpty(notificationContent.f42321e)) {
                        IconCompat a5 = IconCompat.a(circleBitmap);
                        l.a aVar = new l.a();
                        String str2 = notificationContent.f42317a;
                        if (str2 == null) {
                            str2 = "User";
                        }
                        l a6 = aVar.a((CharSequence) str2).a(a5).a();
                        kotlin.g.b.k.a((Object) a6, "Person.Builder().setName…r\").setIcon(icon).build()");
                        h.g gVar = new h.g(a6);
                        for (PushBean notificationContent2 : list3) {
                            a notificationContent3 = INSTANCE.getNotificationContent(notificationContent2);
                            Long l = notificationContent3.f42320d;
                            if (l != null) {
                                j2 = l.longValue();
                            } else {
                                j2 = System.currentTimeMillis();
                            }
                            gVar.a(notificationContent3.f42318b, j2, a6);
                        }
                        a4.a((h.C0039h) gVar);
                    } else {
                        try {
                            a4.a((h.C0039h) new h.b().a((Bitmap) com.bumptech.glide.b.b(context).d().a(notificationContent.f42321e).a().get()));
                        } catch (Exception unused2) {
                        }
                    }
                    a2.a(abs, a4.d());
                }
            }
            if (size <= 1 || size2 <= 1) {
                a2.a(SUMMARY_NOTIFICATION_ID);
                return;
            }
            int i2 = SUMMARY_NOTIFICATION_ID;
            a2.a(i2, INSTANCE.getSummaryNotification(context, i2, size, size2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x019f, code lost:
        if (r2.equals("image/gif") != false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01a1, code lost:
        r7 = "📷 Photo";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0039, code lost:
        r3 = r1.getChannelUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0165, code lost:
        if (r2.equals(com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil.IMAGE) != false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x016e, code lost:
        if (r2.equals(com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil.AUDIO) != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0177, code lost:
        if (r2.equals("Image") != false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0180, code lost:
        if (r2.equals("Audio") != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0182, code lost:
        r7 = "🎵 Audio";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x018c, code lost:
        if (r2.equals(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.TYPE_FILE) != false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0193, code lost:
        if (r2.equals("File") != false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0195, code lost:
        r7 = "📄 Document";
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.paytm.android.chat.utils.ChatNotificationHelper.a getNotificationContent(com.paytm.android.chat.bean.jsonbean.PushBean r17) {
        /*
            r16 = this;
            com.paytm.android.chat.bean.jsonbean.PushBean$SenderBean r0 = r17.getSender()
            com.paytm.android.chat.utils.ContactManager r1 = com.paytm.android.chat.utils.ContactManager.getInstance()
            com.paytm.android.chat.bean.jsonbean.PushBean$ChannelBean r2 = r17.getChannel()
            java.lang.String r2 = r2.getChannel_url()
            r1.searchContactDBByUrl(r2)
            com.paytm.android.chat.ChatManager r1 = com.paytm.android.chat.ChatManager.b()
            java.lang.String r2 = "ChatManager.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            com.paytm.android.chat.data.repository.ChatRepository r1 = r1.a()
            com.paytm.android.chat.bean.jsonbean.PushBean$ChannelBean r2 = r17.getChannel()
            java.lang.String r3 = "pushBean.channel"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r2 = r2.getChannel_url()
            java.lang.String r3 = "pushBean.channel.channel_url"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r1 = r1.getLocalChannelByIdBlocking(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0044
            java.lang.String r3 = r1.getChannelUrl()
            if (r3 == 0) goto L_0x0044
            com.sendbird.android.GroupChannel r3 = com.paytm.android.chat.d.a.b.a(r3)
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            if (r1 == 0) goto L_0x004c
            com.paytm.android.chat.bean.ReceiverDisplayInfo r4 = r1.getReceiverDisplayInfo()
            goto L_0x004d
        L_0x004c:
            r4 = r2
        L_0x004d:
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r5 = com.paytm.android.chat.utils.ChatConfigUtil.Companion
            com.paytm.android.chat.utils.ChatConfigUtil r5 = r5.getInstance()
            boolean r5 = r5.isP4B()
            if (r5 == 0) goto L_0x0086
            if (r3 == 0) goto L_0x0086
            com.sendbird.android.Member r3 = com.paytm.android.chat.utils.ChatVariantUtilKt.getChannelDisplayMember((com.sendbird.android.GroupChannel) r3)
            if (r4 == 0) goto L_0x0066
            com.paytm.android.chat.bean.UserType r5 = com.paytm.android.chat.bean.UserType.CHANNEL
            r4.setUserType(r5)
        L_0x0066:
            if (r4 == 0) goto L_0x006c
            r5 = 0
            r4.setFromContact(r5)
        L_0x006c:
            if (r4 == 0) goto L_0x0079
            if (r3 == 0) goto L_0x0075
            java.lang.String r5 = r3.getNickname()
            goto L_0x0076
        L_0x0075:
            r5 = r2
        L_0x0076:
            r4.setName(r5)
        L_0x0079:
            if (r4 == 0) goto L_0x0086
            if (r3 == 0) goto L_0x0082
            java.lang.String r3 = r3.getProfileUrl()
            goto L_0x0083
        L_0x0082:
            r3 = r2
        L_0x0083:
            r4.setProfileImage(r3)
        L_0x0086:
            long r5 = r17.getCreated_at()
            java.lang.String r3 = r17.getType()
            java.lang.String r14 = r17.getCustom_type()
            if (r1 == 0) goto L_0x009d
            if (r4 == 0) goto L_0x009b
            java.lang.String r7 = r4.getName()
            goto L_0x00a1
        L_0x009b:
            r9 = r2
            goto L_0x00a2
        L_0x009d:
            java.lang.String r7 = r0.getName()
        L_0x00a1:
            r9 = r7
        L_0x00a2:
            java.lang.String r7 = r17.getMessage()
            if (r1 == 0) goto L_0x00b1
            if (r4 == 0) goto L_0x00af
            java.lang.String r0 = r4.getProfileImage()
            goto L_0x00b5
        L_0x00af:
            r11 = r2
            goto L_0x00b6
        L_0x00b1:
            java.lang.String r0 = r0.getProfile_url()
        L_0x00b5:
            r11 = r0
        L_0x00b6:
            if (r3 != 0) goto L_0x00ba
            goto L_0x01b2
        L_0x00ba:
            int r0 = r3.hashCode()
            r1 = 2157948(0x20ed7c, float:3.023929E-39)
            if (r0 == r1) goto L_0x0104
            r1 = 2362860(0x240dec, float:3.311072E-39)
            if (r0 == r1) goto L_0x00ca
            goto L_0x01b2
        L_0x00ca:
            java.lang.String r0 = "MESG"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x01b2
            if (r14 != 0) goto L_0x00d6
            goto L_0x01b2
        L_0x00d6:
            int r0 = r14.hashCode()
            r1 = -1678787584(0xffffffff9befbc00, float:-3.9660725E-22)
            if (r0 == r1) goto L_0x00ef
            r1 = 951526432(0x38b72420, float:8.732849E-5)
            if (r0 == r1) goto L_0x00e6
            goto L_0x01b2
        L_0x00e6:
            java.lang.String r0 = "contact"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x01b2
            goto L_0x00f7
        L_0x00ef:
            java.lang.String r0 = "Contact"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x01b2
        L_0x00f7:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "👤 "
            java.lang.String r7 = r1.concat(r0)
            goto L_0x01b2
        L_0x0104:
            java.lang.String r0 = "FILE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x01b2
            java.util.List r0 = r17.getFiles()
            if (r0 == 0) goto L_0x0117
            java.lang.Object r0 = kotlin.a.k.e(r0)
            goto L_0x0118
        L_0x0117:
            r0 = r2
        L_0x0118:
            boolean r1 = r0 instanceof java.util.Map
            if (r1 != 0) goto L_0x011d
            r0 = r2
        L_0x011d:
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x01b2
            java.lang.String r1 = "custom_type"
            java.lang.Object r1 = r0.get(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 != 0) goto L_0x012c
            r1 = r2
        L_0x012c:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = "url"
            java.lang.Object r0 = r0.get(r3)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 != 0) goto L_0x013a
            r0 = r2
        L_0x013a:
            java.lang.String r0 = (java.lang.String) r0
            if (r1 == 0) goto L_0x0152
            if (r1 == 0) goto L_0x014a
            java.lang.String r2 = r1.toLowerCase()
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            goto L_0x0152
        L_0x014a:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L_0x0152:
            java.lang.String r3 = "File"
            if (r2 != 0) goto L_0x0157
            goto L_0x01a5
        L_0x0157:
            int r4 = r2.hashCode()
            switch(r4) {
                case -879267568: goto L_0x0199;
                case 2189724: goto L_0x018f;
                case 3143036: goto L_0x0186;
                case 63613878: goto L_0x017a;
                case 70760763: goto L_0x0171;
                case 93166550: goto L_0x0168;
                case 100313435: goto L_0x015f;
                default: goto L_0x015e;
            }
        L_0x015e:
            goto L_0x01a5
        L_0x015f:
            java.lang.String r4 = "image"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01a5
            goto L_0x01a1
        L_0x0168:
            java.lang.String r4 = "audio"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01a5
            goto L_0x0182
        L_0x0171:
            java.lang.String r4 = "Image"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01a5
            goto L_0x01a1
        L_0x017a:
            java.lang.String r4 = "Audio"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01a5
        L_0x0182:
            java.lang.String r7 = "🎵 Audio"
            goto L_0x01af
        L_0x0186:
            java.lang.String r4 = "file"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01a5
            goto L_0x0195
        L_0x018f:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x01a5
        L_0x0195:
            java.lang.String r7 = "📄 Document"
            goto L_0x01af
        L_0x0199:
            java.lang.String r4 = "image/gif"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01a5
        L_0x01a1:
            java.lang.String r7 = "📷 Photo"
            goto L_0x01af
        L_0x01a5:
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x01af
            r7 = r3
        L_0x01af:
            r13 = r0
            r15 = r1
            goto L_0x01b4
        L_0x01b2:
            r13 = r2
            r15 = r13
        L_0x01b4:
            r10 = r7
            com.paytm.android.chat.utils.ChatNotificationHelper$a r0 = new com.paytm.android.chat.utils.ChatNotificationHelper$a
            long r1 = r17.getMessage_id()
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            java.lang.Long r12 = java.lang.Long.valueOf(r5)
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatNotificationHelper.getNotificationContent(com.paytm.android.chat.bean.jsonbean.PushBean):com.paytm.android.chat.utils.ChatNotificationHelper$a");
    }

    private final Notification getSummaryNotification(Context context, int i2, int i3, int i4) {
        StringBuilder sb;
        String str;
        String str2;
        StringBuilder sb2;
        if (i4 > 1) {
            sb.append(i4);
            str = " chats";
        } else {
            sb = new StringBuilder();
            sb.append(i4);
            str = " chat";
        }
        sb.append(str);
        String sb3 = sb.toString();
        if (i3 > 1) {
            sb2 = new StringBuilder();
            sb2.append(i3);
            str2 = " messages";
        } else {
            sb2 = new StringBuilder();
            sb2.append(i3);
            str2 = " message";
        }
        sb2.append(str2);
        CharSequence charSequence = sb2.toString() + " from " + sb3;
        h.e a2 = new h.e(context).b(CHAT_NOTIFICATION_CHANNEL_ID).b(charSequence).a(getSummaryPendingIntent(context, i2));
        com.paytm.android.chat.e.a();
        Notification d2 = a2.a((int) R.drawable.ic_launcher_small).b(7).a((h.C0039h) new h.f().a(charSequence)).a(GROUP_KEY_CHAT).b().d();
        kotlin.g.b.k.a((Object) d2, "NotificationCompat.Build…\n                .build()");
        return d2;
    }

    private final void createChatNotificationChannel(androidx.core.app.k kVar) {
        if (Build.VERSION.SDK_INT >= 26 && kVar.a(CHAT_NOTIFICATION_CHANNEL_ID) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(CHAT_NOTIFICATION_CHANNEL_ID, CHAT_NOTIFICATION_CHANNEL_NAME, 4);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            kVar.a(notificationChannel);
        }
    }

    private final Bitmap getCircleBitmap(Bitmap bitmap) {
        int height = bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight() : bitmap.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(height, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, height, height);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-65536);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        kotlin.g.b.k.a((Object) createBitmap, "output");
        return createBitmap;
    }

    private final boolean isValidNotification(PushBean pushBean) {
        if (!(pushBean == null || pushBean.getChannel() == null)) {
            PushBean.ChannelBean channel = pushBean.getChannel();
            kotlin.g.b.k.a((Object) channel, "pushBean.channel");
            return !TextUtils.isEmpty(channel.getChannel_url());
        }
    }

    private final PendingIntent getMessagePendingIntent(Context context, String str, int i2) {
        if (context == null || str == null || com.paytm.android.chat.f.a(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("groupChannelUrl", str);
        bundle.putString("fromFCM", "true");
        bundle.putString("launch_page", "channel");
        bundle.putString("deepLinkUrl", "chat");
        if (ChatConfigUtil.Companion.getInstance().isP4B()) {
            bundle.putString("url", "paytmba://chat?featuretype=click_notify&groupChannelUrl=" + str + "&fromFCM=true");
        } else {
            bundle.putString("url", "paytmmp://chat?featuretype=click_notify&groupChannelUrl=" + str + "&fromFCM=true");
        }
        return PendingIntent.getBroadcast(context, i2, INSTANCE.getNotificationActionReceiverIntent(bundle), 134217728);
    }

    private final PendingIntent getSummaryPendingIntent(Context context, int i2) {
        if (context == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("fromFCM", "true");
        bundle.putString("launch_page", "channel_list");
        bundle.putString("deepLinkUrl", "chat");
        if (ChatConfigUtil.Companion.getInstance().isP4B()) {
            bundle.putString("url", "paytmba://paytmupdate?featuretype=chat");
        } else {
            bundle.putString("url", "paytmmp://paytmupdate?featuretype=chat");
        }
        return PendingIntent.getBroadcast(context, i2, INSTANCE.getNotificationActionReceiverIntent(bundle), 134217728);
    }

    private final Intent getNotificationActionReceiverIntent(Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.notification.OPENED");
        if (ChatConfigUtil.Companion.getInstance().isP4B()) {
            intent.addCategory("com.paytm.business");
            intent.setClassName("com.paytm.business", "com.paytm.business.topicPush.PushNotificationReceiver");
            intent.putExtra("isFrom", "chat");
        } else {
            intent.addCategory("net.one97.paytm");
            intent.setClassName("net.one97.paytm", "net.one97.paytm.pushnotifcation.NotificationActionReceiver");
        }
        intent.putExtra("MESSAGE_BUNDLE", bundle);
        return intent;
    }

    /* access modifiers changed from: private */
    public final void markMessageAsDelivered(PushBean pushBean) {
        PushBean.ChannelBean channel;
        String channel_url;
        String a2;
        if (pushBean != null && (channel = pushBean.getChannel()) != null && (channel_url = channel.getChannel_url()) != null && (a2 = com.paytm.android.chat.f.a(channel_url)) != null) {
            ChatManager b2 = ChatManager.b();
            kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
            b2.a().markAsDelivered(a2);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f42317a;

        /* renamed from: b  reason: collision with root package name */
        final String f42318b;

        /* renamed from: c  reason: collision with root package name */
        final String f42319c;

        /* renamed from: d  reason: collision with root package name */
        final Long f42320d;

        /* renamed from: e  reason: collision with root package name */
        final String f42321e;

        /* renamed from: f  reason: collision with root package name */
        final String f42322f;

        /* renamed from: g  reason: collision with root package name */
        private final Long f42323g;

        /* renamed from: h  reason: collision with root package name */
        private final String f42324h;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.g.b.k.a((Object) this.f42323g, (Object) aVar.f42323g) && kotlin.g.b.k.a((Object) this.f42317a, (Object) aVar.f42317a) && kotlin.g.b.k.a((Object) this.f42318b, (Object) aVar.f42318b) && kotlin.g.b.k.a((Object) this.f42319c, (Object) aVar.f42319c) && kotlin.g.b.k.a((Object) this.f42320d, (Object) aVar.f42320d) && kotlin.g.b.k.a((Object) this.f42321e, (Object) aVar.f42321e) && kotlin.g.b.k.a((Object) this.f42324h, (Object) aVar.f42324h) && kotlin.g.b.k.a((Object) this.f42322f, (Object) aVar.f42322f);
        }

        public final int hashCode() {
            Long l = this.f42323g;
            int i2 = 0;
            int hashCode = (l != null ? l.hashCode() : 0) * 31;
            String str = this.f42317a;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f42318b;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f42319c;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Long l2 = this.f42320d;
            int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str4 = this.f42321e;
            int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f42324h;
            int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.f42322f;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            return hashCode7 + i2;
        }

        public final String toString() {
            return "NotificationContentWrapper(messageId=" + this.f42323g + ", title=" + this.f42317a + ", content=" + this.f42318b + ", profileUrl=" + this.f42319c + ", createdAt=" + this.f42320d + ", url=" + this.f42321e + ", messageCustomType=" + this.f42324h + ", fileCustomType=" + this.f42322f + ")";
        }

        public a(Long l, String str, String str2, String str3, Long l2, String str4, String str5, String str6) {
            this.f42323g = l;
            this.f42317a = str;
            this.f42318b = str2;
            this.f42319c = str3;
            this.f42320d = l2;
            this.f42321e = str4;
            this.f42324h = str5;
            this.f42322f = str6;
        }
    }

    static final class b<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f42325a;

        b(Context context) {
            this.f42325a = context;
        }

        public final /* synthetic */ Object call() {
            androidx.core.app.k a2 = androidx.core.app.k.a(this.f42325a);
            for (SendbirdNotificationEntity channelUrl : NotificationDBHelperKt.getAllNotificationMessage()) {
                String channelUrl2 = channelUrl.getChannelUrl();
                a2.a(Math.abs(channelUrl2 != null ? channelUrl2.hashCode() : 0) + ChatNotificationHelper.INITIAL_NOTIFICATION_ID);
            }
            a2.a(ChatNotificationHelper.SUMMARY_NOTIFICATION_ID);
            NotificationDBHelperKt.clearNotificationTable();
            return x.f47997a;
        }
    }
}
