package com.paytm.android.chat.utils;

import android.widget.TextView;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.bean.p4b.KybChannel;
import com.paytm.android.chat.bean.p4b.KybData;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.h;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;

public final class P4BNotificationHelper {

    public interface ChatUnreadCountListener {
        void onTotalUnreadCountUpdate(String str);
    }

    static final class a<T> implements g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatUnreadCountListener f42353a;

        a(ChatUnreadCountListener chatUnreadCountListener) {
            this.f42353a = chatUnreadCountListener;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42353a.onTotalUnreadCountUpdate(String.valueOf((Integer) obj));
        }
    }

    static final class b<T, R> implements h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KybData f42354a;

        b(KybData kybData) {
            this.f42354a = kybData;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List<ChatGroupChannelDataModel> list = (List) obj;
            int i2 = 0;
            for (KybChannel next : this.f42354a.getChannels()) {
                for (ChatGroupChannelDataModel chatGroupChannelDataModel : list) {
                    for (ChatUserDataModel sendbirdUserId : chatGroupChannelDataModel.getMembers()) {
                        if (p.a(sendbirdUserId.getSendbirdUserId(), next.getId(), true)) {
                            i2 += chatGroupChannelDataModel.getUnreadMessageCount();
                        }
                    }
                }
            }
            return Integer.valueOf(i2);
        }
    }

    static final class c<T> implements g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f42355a;

        c(TextView textView) {
            this.f42355a = textView;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            if (k.a(num.intValue(), 0) <= 0) {
                this.f42355a.setText(" ");
            } else if (num != null && num.intValue() == 1) {
                TextView textView = this.f42355a;
                textView.setText(num + " unread message");
            } else {
                TextView textView2 = this.f42355a;
                textView2.setText(num + " unread messages");
            }
        }
    }

    static final class d<T, R> implements h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f42356a;

        d(String str) {
            this.f42356a = str;
        }

        public final /* synthetic */ Object apply(Object obj) {
            int i2 = 0;
            for (ChatGroupChannelDataModel chatGroupChannelDataModel : (List) obj) {
                for (ChatUserDataModel sendbirdUserId : chatGroupChannelDataModel.getMembers()) {
                    if (p.a(sendbirdUserId.getSendbirdUserId(), this.f42356a, true)) {
                        i2 += chatGroupChannelDataModel.getUnreadMessageCount();
                    }
                }
            }
            return Integer.valueOf(i2);
        }
    }

    static final class e<T> implements g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f42357a;

        e(TextView textView) {
            this.f42357a = textView;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            if (k.a(num.intValue(), 0) > 0) {
                this.f42357a.setVisibility(0);
                this.f42357a.setText(String.valueOf(num));
                return;
            }
            this.f42357a.setVisibility(4);
        }
    }

    public final void setTotalUnreadCount(TextView textView, KybData kybData) {
        k.c(textView, "tv");
        k.c(kybData, "kybData");
        ChatManager b2 = ChatManager.b();
        k.a((Object) b2, "ChatManager.getInstance()");
        b2.a().getLocalChannelsForDisplay().a(new b(kybData)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).b(new c(textView));
    }

    public final void getChatTotalUnreadCount(ChatUnreadCountListener chatUnreadCountListener) {
        k.c(chatUnreadCountListener, "listener");
        ChatManager b2 = ChatManager.b();
        k.a((Object) b2, "ChatManager.getInstance()");
        b2.a().observeUnreadCountOnLocalChannels().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).b(new a(chatUnreadCountListener));
    }

    public final void setUnreadCountBadgePerStore(String str, TextView textView) {
        k.c(str, "storeId");
        k.c(textView, "tv");
        ChatManager b2 = ChatManager.b();
        k.a((Object) b2, "ChatManager.getInstance()");
        b2.a().getLocalChannelsForDisplay().a(new d(str)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).b(new e(textView));
    }
}
