package com.paytm.android.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.e;
import com.paytm.android.chat.activity.APCChatActivity;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.fragment.f;
import com.paytm.android.chat.utils.ChannelAdapterEvent;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.ChatHomeDiffUtil;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.q;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBirdException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.aa;

public final class NotificationActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f41673a;

    /* renamed from: b  reason: collision with root package name */
    com.paytm.android.chat.a.e f41674b;

    /* renamed from: c  reason: collision with root package name */
    private io.reactivex.rxjava3.b.c f41675c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f41676d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<ChatGroupChannelDataModel> f41677e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private com.paytm.android.chat.fragment.f f41678f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f41679g;

    public final View a(int i2) {
        if (this.f41679g == null) {
            this.f41679g = new HashMap();
        }
        View view = (View) this.f41679g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f41679g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements io.reactivex.rxjava3.d.g<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41681a;

        b(NotificationActivity notificationActivity) {
            this.f41681a = notificationActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            if (!((Boolean) obj).booleanValue() && ((ImageView) this.f41681a.a(R.id.btnChatMarkasspam)) != null) {
                ImageView imageView = (ImageView) this.f41681a.a(R.id.btnChatMarkasspam);
                kotlin.g.b.k.a((Object) imageView, "btnChatMarkasspam");
                imageView.setEnabled(true);
                androidx.core.widget.e.a((ImageView) this.f41681a.a(R.id.btnChatMarkasspam), (ColorStateList) null);
            }
        }
    }

    static final class h<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41692a;

        h(NotificationActivity notificationActivity) {
            this.f41692a = notificationActivity;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            kotlin.g.b.k.a((Object) list, "list");
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                String customType = ((ChatGroupChannelDataModel) next).getCustomType();
                ArrayList<String> arrayList2 = this.f41692a.f41673a;
                if (arrayList2 != null ? kotlin.a.k.a(arrayList2, customType) : false) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    static final class i<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41693a;

        i(NotificationActivity notificationActivity) {
            this.f41693a = notificationActivity;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List<ChatGroupChannelDataModel> list = (List) obj;
            NotificationActivity notificationActivity = this.f41693a;
            kotlin.g.b.k.a((Object) list, "list");
            int i2 = 0;
            for (ChatGroupChannelDataModel unreadMessageCount : list) {
                i2 += unreadMessageCount.getUnreadMessageCount();
            }
            notificationActivity.f41676d = i2;
            h.b b2 = androidx.recyclerview.widget.h.b(new ChatHomeDiffUtil(this.f41693a.f41677e, list));
            kotlin.g.b.k.a((Object) b2, "DiffUtil.calculateDiff(C…ChannelList, list), true)");
            return new ChannelAdapterEvent(list, b2);
        }
    }

    static final class j<T> implements io.reactivex.rxjava3.d.g<ChannelAdapterEvent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41694a;

        j(NotificationActivity notificationActivity) {
            this.f41694a = notificationActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            ChannelAdapterEvent channelAdapterEvent = (ChannelAdapterEvent) obj;
            this.f41694a.f41677e = channelAdapterEvent.getNewList();
            if (this.f41694a.f41677e.isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) this.f41694a.a(R.id.ll_empty);
                kotlin.g.b.k.a((Object) linearLayout, "ll_empty");
                linearLayout.setVisibility(0);
            } else {
                com.paytm.android.chat.a.e eVar = this.f41694a.f41674b;
                if (eVar != null) {
                    eVar.a(this.f41694a.f41677e, channelAdapterEvent.getDiffResult());
                }
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f41694a.a(R.id.loadingAnimation);
            kotlin.g.b.k.a((Object) lottieAnimationView, "loadingAnimation");
            com.paytm.android.chat.f.a((View) lottieAnimationView, false);
            if (this.f41694a.f41676d > 0) {
                androidx.core.widget.e.a((ImageView) this.f41694a.a(R.id.btnChatMarkasspam), (ColorStateList) null);
                ImageView imageView = (ImageView) this.f41694a.a(R.id.btnChatMarkasspam);
                kotlin.g.b.k.a((Object) imageView, "btnChatMarkasspam");
                imageView.setEnabled(true);
                ImageView imageView2 = (ImageView) this.f41694a.a(R.id.btnChatMarkasspam);
                kotlin.g.b.k.a((Object) imageView2, "btnChatMarkasspam");
                com.paytm.android.chat.f.a((View) imageView2, true);
            } else {
                ImageView imageView3 = (ImageView) this.f41694a.a(R.id.btnChatMarkasspam);
                kotlin.g.b.k.a((Object) imageView3, "btnChatMarkasspam");
                com.paytm.android.chat.f.a((View) imageView3, false);
            }
            int size = channelAdapterEvent.getNewList().size();
            int c2 = this.f41694a.f41676d;
            TextView textView = (TextView) this.f41694a.a(R.id.cna_title);
            kotlin.g.b.k.a((Object) textView, "cna_title");
            ChatAnalyticsHelperKt.fireFilteredChatScreenLoadEvent(this.f41694a, size, c2, textView.getText().toString());
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_notification);
        TextView textView = (TextView) a(R.id.cna_title);
        kotlin.g.b.k.a((Object) textView, "cna_title");
        Intent intent = getIntent();
        kotlin.g.b.k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        textView.setText(String.valueOf(extras != null ? extras.get("title") : null));
        Intent intent2 = getIntent();
        kotlin.g.b.k.a((Object) intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        Object obj = extras2 != null ? extras2.get("filters") : null;
        if (!(obj instanceof ArrayList)) {
            obj = null;
        }
        this.f41673a = (ArrayList) obj;
        Context context = this;
        this.f41674b = new com.paytm.android.chat.a.e(context);
        RecyclerView recyclerView = (RecyclerView) a(R.id.channelList);
        kotlin.g.b.k.a((Object) recyclerView, "channelList");
        recyclerView.setAdapter(this.f41674b);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.channelList);
        kotlin.g.b.k.a((Object) recyclerView2, "channelList");
        recyclerView2.setLayoutManager(new LinearLayoutManager(context, 1, false));
        ((ImageView) a(R.id.btnBack)).setOnClickListener(new d(this));
        ((ImageView) a(R.id.btnChatMarkasspam)).setOnClickListener(new e(this));
        com.paytm.android.chat.a.e eVar = this.f41674b;
        if (eVar != null) {
            eVar.a((e.j) new f(this));
        }
        com.paytm.android.chat.a.e eVar2 = this.f41674b;
        if (eVar2 == null) {
            kotlin.g.b.k.a();
        }
        eVar2.a((e.k) new g(this));
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loadingAnimation);
        kotlin.g.b.k.a((Object) lottieAnimationView, "loadingAnimation");
        com.paytm.android.chat.f.a((View) lottieAnimationView, true);
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41683a;

        d(NotificationActivity notificationActivity) {
            this.f41683a = notificationActivity;
        }

        public final void onClick(View view) {
            this.f41683a.finish();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41684a;

        e(NotificationActivity notificationActivity) {
            this.f41684a = notificationActivity;
        }

        public final void onClick(View view) {
            if (SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.DONT_SHOW_MARK_AS_READ, false)) {
                NotificationActivity.a(this.f41684a);
            } else {
                NotificationActivity.b(this.f41684a);
            }
        }
    }

    static final class f implements e.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41685a;

        f(NotificationActivity notificationActivity) {
            this.f41685a = notificationActivity;
        }

        public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, Integer num) {
            NotificationActivity notificationActivity = this.f41685a;
            String channelUrl = chatGroupChannelDataModel.getChannelUrl();
            APCChatActivity.a aVar = APCChatActivity.f41472g;
            Context context = notificationActivity;
            if (channelUrl == null) {
                kotlin.g.b.k.a();
            }
            APCChatActivity.a.a(context, channelUrl, (String) null, (String) null, false);
        }
    }

    public static final class g implements e.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41686a;

        static final class b<T> implements io.reactivex.rxjava3.d.g<Throwable> {

            /* renamed from: a  reason: collision with root package name */
            public static final b f41691a = new b();

            b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object obj) {
            }
        }

        static final class a<T> implements io.reactivex.rxjava3.d.g<Integer> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f41687a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ChatGroupChannelDataModel f41688b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f41689c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f41690d;

            a(g gVar, ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z, int i2) {
                this.f41687a = gVar;
                this.f41688b = chatGroupChannelDataModel;
                this.f41689c = z;
                this.f41690d = i2;
            }

            public final /* synthetic */ void accept(Object obj) {
                if (kotlin.g.b.k.a(((Integer) obj).intValue(), 3) < 0) {
                    ChatManager b2 = ChatManager.b();
                    kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
                    b2.a().updateLocalChannelPinnedState(this.f41688b.getChannelUrl(), this.f41689c);
                    ChatAnalyticsHelperKt.firePinChatEvent(this.f41687a.f41686a, this.f41689c, this.f41688b, this.f41690d, this.f41687a.f41686a.f41676d);
                } else if (!this.f41687a.f41686a.isFinishing() && !this.f41687a.f41686a.isDestroyed()) {
                    Toast.makeText(this.f41687a.f41686a, R.string.chat_channel_pin_count_info, 1).show();
                }
            }
        }

        g(NotificationActivity notificationActivity) {
            this.f41686a = notificationActivity;
        }

        public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z, int i2) {
            kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
            if (z) {
                ChatManager b2 = ChatManager.b();
                kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
                b2.a().totalPinnedLocalChannelCount().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new a(this, chatGroupChannelDataModel, z, i2), (io.reactivex.rxjava3.d.g<? super Throwable>) b.f41691a);
                return;
            }
            ChatManager b3 = ChatManager.b();
            kotlin.g.b.k.a((Object) b3, "ChatManager.getInstance()");
            b3.a().updateLocalChannelPinnedState(chatGroupChannelDataModel.getChannelUrl(), z);
            NotificationActivity notificationActivity = this.f41686a;
            ChatAnalyticsHelperKt.firePinChatEvent(notificationActivity, z, chatGroupChannelDataModel, i2, notificationActivity.f41676d);
        }

        public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, String str, int i2) {
            kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
            kotlin.g.b.k.c(str, "name");
            NotificationActivity.a(this.f41686a, chatGroupChannelDataModel, !chatGroupChannelDataModel.isPushEnabled(), str, i2 + 1);
        }

        public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, int i2) {
            kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
            NotificationActivity.a(chatGroupChannelDataModel);
            if (chatGroupChannelDataModel.getLastMessage() != null) {
                NotificationActivity notificationActivity = this.f41686a;
                ChatAnalyticsHelperKt.fireDeleteChatEvent(notificationActivity, chatGroupChannelDataModel, i2 + 1, notificationActivity.f41676d);
            }
        }
    }

    public static final class a implements com.paytm.android.chat.fragment.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41680a;

        a(NotificationActivity notificationActivity) {
            this.f41680a = notificationActivity;
        }

        public final void onMarkAsReadConfirmationContinueClicked(boolean z) {
            SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.DONT_SHOW_MARK_AS_READ, z);
            NotificationActivity.a(this.f41680a);
        }
    }

    public final void onResume() {
        super.onResume();
        io.reactivex.rxjava3.b.c cVar = this.f41675c;
        if (cVar != null) {
            cVar.dispose();
        }
        ChatManager b2 = ChatManager.b();
        kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
        this.f41675c = b2.a().getLocalChannelsForDisplay().a(new h(this)).a(new i(this)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new j(this), (io.reactivex.rxjava3.d.g<? super Throwable>) new k(this));
    }

    public final void onPause() {
        super.onPause();
        io.reactivex.rxjava3.b.c cVar = this.f41675c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    static final class l implements GroupChannel.GroupChannelResetMyHistoryHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f41696a;

        l(ChatGroupChannelDataModel chatGroupChannelDataModel) {
            this.f41696a = chatGroupChannelDataModel;
        }

        public final void onResult(SendBirdException sendBirdException) {
            if (sendBirdException == null) {
                q.b("### resetMyHistory");
                ChatManager b2 = ChatManager.b();
                kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
                b2.a().deleteLocalChannel(this.f41696a.getChannelUrl());
            }
        }
    }

    static final class m implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f41698b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f41699c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f41700d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f41701e;

        m(NotificationActivity notificationActivity, boolean z, String str, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2) {
            this.f41697a = notificationActivity;
            this.f41698b = z;
            this.f41699c = str;
            this.f41700d = chatGroupChannelDataModel;
            this.f41701e = i2;
        }

        public final void run() {
            if (!this.f41697a.isFinishing() && !this.f41697a.isDestroyed()) {
                if (!this.f41698b) {
                    aa aaVar = aa.f47921a;
                    String a2 = com.paytm.android.chat.c.a(R.string.chat_module_toast_mute_user_success, "%s has been muted.");
                    kotlin.g.b.k.a((Object) a2, "ChatApplication.getStrin…ss, \"%s has been muted.\")");
                    String format = String.format(a2, Arrays.copyOf(new Object[]{this.f41699c}, 1));
                    kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                    Toast.makeText(this.f41697a, format, 0).show();
                    NotificationActivity notificationActivity = this.f41697a;
                    String localClassName = notificationActivity.getLocalClassName();
                    kotlin.g.b.k.a((Object) localClassName, "localClassName");
                    ChatAnalyticsHelperKt.fireMuteChatEvent(notificationActivity, true, localClassName, this.f41700d, this.f41701e, this.f41697a.f41676d);
                    return;
                }
                aa aaVar2 = aa.f47921a;
                String a3 = com.paytm.android.chat.c.a(R.string.chat_module_toast_unmute_user_success, "%s has been unmuted.");
                kotlin.g.b.k.a((Object) a3, "ChatApplication.getStrin…, \"%s has been unmuted.\")");
                String format2 = String.format(a3, Arrays.copyOf(new Object[]{this.f41699c}, 1));
                kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                Toast.makeText(this.f41697a, format2, 0).show();
                NotificationActivity notificationActivity2 = this.f41697a;
                String localClassName2 = notificationActivity2.getLocalClassName();
                kotlin.g.b.k.a((Object) localClassName2, "localClassName");
                ChatAnalyticsHelperKt.fireMuteChatEvent(notificationActivity2, false, localClassName2, this.f41700d, this.f41701e, this.f41697a.f41676d);
            }
        }
    }

    public static final /* synthetic */ void a(NotificationActivity notificationActivity) {
        ImageView imageView = (ImageView) notificationActivity.a(R.id.btnChatMarkasspam);
        kotlin.g.b.k.a((Object) imageView, "btnChatMarkasspam");
        imageView.setEnabled(false);
        androidx.core.widget.e.a((ImageView) notificationActivity.a(R.id.btnChatMarkasspam), ColorStateList.valueOf(androidx.core.content.b.c(notificationActivity, R.color.color_E8EDF3)));
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.b(notificationActivity.f41677e).a(new b(notificationActivity), (io.reactivex.rxjava3.d.g<? super Throwable>) new c(notificationActivity));
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41682a;

        c(NotificationActivity notificationActivity) {
            this.f41682a = notificationActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            if (((ImageView) this.f41682a.a(R.id.btnChatMarkasspam)) != null) {
                ImageView imageView = (ImageView) this.f41682a.a(R.id.btnChatMarkasspam);
                kotlin.g.b.k.a((Object) imageView, "btnChatMarkasspam");
                imageView.setEnabled(true);
                androidx.core.widget.e.a((ImageView) this.f41682a.a(R.id.btnChatMarkasspam), (ColorStateList) null);
            }
        }
    }

    public static final /* synthetic */ void b(NotificationActivity notificationActivity) {
        com.paytm.android.chat.fragment.f fVar = notificationActivity.f41678f;
        if (fVar != null) {
            fVar.dismiss();
        }
        f.a aVar = com.paytm.android.chat.fragment.f.f42082a;
        notificationActivity.f41678f = f.a.a(new a(notificationActivity));
        com.paytm.android.chat.fragment.f fVar2 = notificationActivity.f41678f;
        if (fVar2 != null) {
            fVar2.show(notificationActivity.getSupportFragmentManager(), (String) null);
        }
    }

    static final class k<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41695a;

        k(NotificationActivity notificationActivity) {
            this.f41695a = notificationActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41695a.finish();
        }
    }

    public static final /* synthetic */ void a(NotificationActivity notificationActivity, ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z, String str, int i2) {
        if (chatGroupChannelDataModel != null && com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl()) != null) {
            ChatManager b2 = ChatManager.b();
            kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
            b2.a().setChannelPushPreferences(chatGroupChannelDataModel, z).a(io.reactivex.rxjava3.android.b.a.a()).a(new m(notificationActivity, z, str, chatGroupChannelDataModel, i2), new n(notificationActivity, z));
        }
    }

    static final class n<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f41702a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f41703b;

        n(NotificationActivity notificationActivity, boolean z) {
            this.f41702a = notificationActivity;
            this.f41703b = z;
        }

        public final /* synthetic */ void accept(Object obj) {
            if (!this.f41702a.isFinishing() && !this.f41702a.isDestroyed()) {
                if (!this.f41703b) {
                    Toast.makeText(this.f41702a, com.paytm.android.chat.c.a(R.string.chat_module_toast_mute_user_failed, "Mute user failed."), 0).show();
                } else {
                    Toast.makeText(this.f41702a, com.paytm.android.chat.c.a(R.string.chat_module_toast_unmute_user_failed, "Cancel mute user failed."), 0).show();
                }
            }
        }
    }

    public static final /* synthetic */ void a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        GroupChannel a2;
        if (chatGroupChannelDataModel != null && (a2 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl())) != null) {
            a2.resetMyHistory(new l(chatGroupChannelDataModel));
        }
    }
}
