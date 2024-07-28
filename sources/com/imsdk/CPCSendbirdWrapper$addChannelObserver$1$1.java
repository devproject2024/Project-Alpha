package com.imsdk;

import com.imsdk.CPCSendbirdWrapper;
import com.paytm.android.chat.data.mappers.CPCDataMapperKt;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.ReactionEvent;
import com.sendbird.android.SendBird;
import com.sendbird.android.ThreadInfoUpdateEvent;
import com.sendbird.android.User;
import java.util.List;
import java.util.Map;

public final class CPCSendbirdWrapper$addChannelObserver$1$1 extends SendBird.ChannelHandler {
    final /* synthetic */ io.reactivex.rxjava3.a.r $emitter;

    CPCSendbirdWrapper$addChannelObserver$1$1(io.reactivex.rxjava3.a.r rVar) {
        this.$emitter = rVar;
    }

    public final void onUserMuted(BaseChannel baseChannel, User user) {
        super.onUserMuted(baseChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new ab(this, baseChannel, user));
        }
    }

    static final class ab implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40612a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40613b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40614c;

        ab(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, User user) {
            this.f40612a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40613b = baseChannel;
            this.f40614c = user;
        }

        public final void run() {
            this.f40612a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserMuted(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40613b), this.f40614c));
        }
    }

    public final void onMessageReceived(BaseChannel baseChannel, BaseMessage baseMessage) {
        kotlin.g.b.k.c(baseChannel, "channel");
        kotlin.g.b.k.c(baseMessage, "message");
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed()) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new i(this, baseChannel, baseMessage));
        }
    }

    static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40642a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40643b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseMessage f40644c;

        i(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, BaseMessage baseMessage) {
            this.f40642a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40643b = baseChannel;
            this.f40644c = baseMessage;
        }

        public final void run() {
            this.f40642a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MessageReceived(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40643b), this.f40644c));
        }
    }

    public final void onReadReceiptUpdated(GroupChannel groupChannel) {
        kotlin.g.b.k.c(groupChannel, "channel");
        super.onReadReceiptUpdated(groupChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed()) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new s(this, groupChannel));
        }
    }

    static final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40671a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40672b;

        s(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel) {
            this.f40671a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40672b = groupChannel;
        }

        public final void run() {
            this.f40671a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ReadReceiptUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40672b)));
        }
    }

    public final void onDeliveryReceiptUpdated(GroupChannel groupChannel) {
        kotlin.g.b.k.c(groupChannel, "channel");
        super.onDeliveryReceiptUpdated(groupChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed()) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new f(this, groupChannel));
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40634a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40635b;

        f(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel) {
            this.f40634a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40635b = groupChannel;
        }

        public final void run() {
            this.f40634a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.DeliveryReceiptUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40635b)));
        }
    }

    public final void onTypingStatusUpdated(GroupChannel groupChannel) {
        kotlin.g.b.k.c(groupChannel, "channel");
        super.onTypingStatusUpdated(groupChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed()) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new u(this, groupChannel));
        }
    }

    static final class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40676a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40677b;

        u(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel) {
            this.f40676a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40677b = groupChannel;
        }

        public final void run() {
            this.f40676a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.TypingStatusUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40677b)));
        }
    }

    public final void onMentionReceived(BaseChannel baseChannel, BaseMessage baseMessage) {
        super.onMentionReceived(baseChannel, baseMessage);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && baseMessage != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new g(this, baseChannel, baseMessage));
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40636a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40637b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseMessage f40638c;

        g(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, BaseMessage baseMessage) {
            this.f40636a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40637b = baseChannel;
            this.f40638c = baseMessage;
        }

        public final void run() {
            this.f40636a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MentionReceived(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40637b), this.f40638c));
        }
    }

    public final void onMessageDeleted(BaseChannel baseChannel, long j2) {
        super.onMessageDeleted(baseChannel, j2);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new h(this, baseChannel, j2));
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40639a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40640b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f40641c;

        h(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, long j) {
            this.f40639a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40640b = baseChannel;
            this.f40641c = j;
        }

        public final void run() {
            this.f40639a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MessageDeleted(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40640b), this.f40641c));
        }
    }

    public final void onMessageUpdated(BaseChannel baseChannel, BaseMessage baseMessage) {
        super.onMessageUpdated(baseChannel, baseMessage);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && baseMessage != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new j(this, baseChannel, baseMessage));
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40645a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40646b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseMessage f40647c;

        j(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, BaseMessage baseMessage) {
            this.f40645a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40646b = baseChannel;
            this.f40647c = baseMessage;
        }

        public final void run() {
            this.f40645a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MessageUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40646b), this.f40647c));
        }
    }

    public final void onChannelChanged(BaseChannel baseChannel) {
        super.onChannelChanged(baseChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new a(this, baseChannel));
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40607a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40608b;

        a(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel) {
            this.f40607a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40608b = baseChannel;
        }

        public final void run() {
            this.f40607a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ChannelChanged(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40608b)));
        }
    }

    public final void onChannelDeleted(String str, BaseChannel.ChannelType channelType) {
        super.onChannelDeleted(str, channelType);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && str != null && channelType != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new b(this, str, channelType));
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40625a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f40626b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseChannel.ChannelType f40627c;

        b(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, String str, BaseChannel.ChannelType channelType) {
            this.f40625a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40626b = str;
            this.f40627c = channelType;
        }

        public final void run() {
            this.f40625a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ChannelDeleted(this.f40626b, this.f40627c));
        }
    }

    public final void onReactionUpdated(BaseChannel baseChannel, ReactionEvent reactionEvent) {
        super.onReactionUpdated(baseChannel, reactionEvent);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && reactionEvent != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new r(this, baseChannel, reactionEvent));
        }
    }

    static final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40669b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactionEvent f40670c;

        r(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, ReactionEvent reactionEvent) {
            this.f40668a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40669b = baseChannel;
            this.f40670c = reactionEvent;
        }

        public final void run() {
            this.f40668a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ReactionUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40669b), this.f40670c));
        }
    }

    public final void onUserReceivedInvitation(GroupChannel groupChannel, User user, List<User> list) {
        super.onUserReceivedInvitation(groupChannel, user, list);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && groupChannel != null && user != null && list != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new ac(this, groupChannel, user, list));
        }
    }

    static final class ac implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40615a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40616b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40617c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f40618d;

        ac(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel, User user, List list) {
            this.f40615a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40616b = groupChannel;
            this.f40617c = user;
            this.f40618d = list;
        }

        public final void run() {
            this.f40615a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserReceivedInvitation(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40616b), this.f40617c, this.f40618d));
        }
    }

    public final void onUserJoined(GroupChannel groupChannel, User user) {
        super.onUserJoined(groupChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && groupChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new z(this, groupChannel, user));
        }
    }

    static final class z implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40691a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40692b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40693c;

        z(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel, User user) {
            this.f40691a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40692b = groupChannel;
            this.f40693c = user;
        }

        public final void run() {
            this.f40691a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserJoined(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40692b), this.f40693c));
        }
    }

    public final void onUserDeclinedInvitation(GroupChannel groupChannel, User user, User user2) {
        super.onUserDeclinedInvitation(groupChannel, user, user2);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && groupChannel != null && user != null && user2 != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new w(this, groupChannel, user, user2));
        }
    }

    static final class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40681a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40682b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40683c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ User f40684d;

        w(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel, User user, User user2) {
            this.f40681a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40682b = groupChannel;
            this.f40683c = user;
            this.f40684d = user2;
        }

        public final void run() {
            this.f40681a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserDeclinedInvitation(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40682b), this.f40683c, this.f40684d));
        }
    }

    public final void onUserLeft(GroupChannel groupChannel, User user) {
        super.onUserLeft(groupChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && groupChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new aa(this, groupChannel, user));
        }
    }

    static final class aa implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40609a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40610b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40611c;

        aa(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel, User user) {
            this.f40609a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40610b = groupChannel;
            this.f40611c = user;
        }

        public final void run() {
            this.f40609a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserLeft(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40610b), this.f40611c));
        }
    }

    public final void onUserEntered(OpenChannel openChannel, User user) {
        super.onUserEntered(openChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && openChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new x(this, openChannel, user));
        }
    }

    static final class x implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40685a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OpenChannel f40686b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40687c;

        x(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, OpenChannel openChannel, User user) {
            this.f40685a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40686b = openChannel;
            this.f40687c = user;
        }

        public final void run() {
            this.f40685a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserEntered(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40686b), this.f40687c));
        }
    }

    public final void onUserExited(OpenChannel openChannel, User user) {
        super.onUserExited(openChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && openChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new y(this, openChannel, user));
        }
    }

    static final class y implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40688a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OpenChannel f40689b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40690c;

        y(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, OpenChannel openChannel, User user) {
            this.f40688a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40689b = openChannel;
            this.f40690c = user;
        }

        public final void run() {
            this.f40688a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserExited(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40689b), this.f40690c));
        }
    }

    public final void onUserUnmuted(BaseChannel baseChannel, User user) {
        super.onUserUnmuted(baseChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new ae(this, baseChannel, user));
        }
    }

    static final class ae implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40622a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40623b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40624c;

        ae(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, User user) {
            this.f40622a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40623b = baseChannel;
            this.f40624c = user;
        }

        public final void run() {
            this.f40622a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserUnmuted(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40623b), this.f40624c));
        }
    }

    public final void onUserBanned(BaseChannel baseChannel, User user) {
        super.onUserBanned(baseChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new v(this, baseChannel, user));
        }
    }

    static final class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40678a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40679b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40680c;

        v(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, User user) {
            this.f40678a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40679b = baseChannel;
            this.f40680c = user;
        }

        public final void run() {
            this.f40678a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserBanned(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40679b), this.f40680c));
        }
    }

    public final void onUserUnbanned(BaseChannel baseChannel, User user) {
        super.onUserUnbanned(baseChannel, user);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && user != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new ad(this, baseChannel, user));
        }
    }

    static final class ad implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40619a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40620b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ User f40621c;

        ad(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, User user) {
            this.f40619a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40620b = baseChannel;
            this.f40621c = user;
        }

        public final void run() {
            this.f40619a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.UserUnbanned(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40620b), this.f40621c));
        }
    }

    public final void onChannelFrozen(BaseChannel baseChannel) {
        super.onChannelFrozen(baseChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new c(this, baseChannel));
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40628a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40629b;

        c(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel) {
            this.f40628a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40629b = baseChannel;
        }

        public final void run() {
            this.f40628a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ChannelFrozen(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40629b)));
        }
    }

    public final void onChannelUnfrozen(BaseChannel baseChannel) {
        super.onChannelUnfrozen(baseChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new e(this, baseChannel));
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40632a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40633b;

        e(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel) {
            this.f40632a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40633b = baseChannel;
        }

        public final void run() {
            this.f40632a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ChannelUnfrozen(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40633b)));
        }
    }

    public final void onMetaDataCreated(BaseChannel baseChannel, Map<String, String> map) {
        super.onMetaDataCreated(baseChannel, map);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && map != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new n(this, baseChannel, map));
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40657a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40658b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f40659c;

        n(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, Map map) {
            this.f40657a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40658b = baseChannel;
            this.f40659c = map;
        }

        public final void run() {
            this.f40657a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MetaDataCreated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40658b), this.f40659c));
        }
    }

    public final void onMetaDataUpdated(BaseChannel baseChannel, Map<String, String> map) {
        super.onMetaDataUpdated(baseChannel, map);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && map != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new p(this, baseChannel, map));
        }
    }

    static final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40663a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40664b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f40665c;

        p(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, Map map) {
            this.f40663a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40664b = baseChannel;
            this.f40665c = map;
        }

        public final void run() {
            this.f40663a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MetaDataUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40664b), this.f40665c));
        }
    }

    public final void onMetaDataDeleted(BaseChannel baseChannel, List<String> list) {
        super.onMetaDataDeleted(baseChannel, list);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && list != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new o(this, baseChannel, list));
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f40662c;

        o(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, List list) {
            this.f40660a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40661b = baseChannel;
            this.f40662c = list;
        }

        public final void run() {
            this.f40660a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MetaDataDeleted(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40661b), this.f40662c));
        }
    }

    public final void onMetaCountersCreated(BaseChannel baseChannel, Map<String, Integer> map) {
        super.onMetaCountersCreated(baseChannel, map);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && map != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new k(this, baseChannel, map));
        }
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40648a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40649b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f40650c;

        k(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, Map map) {
            this.f40648a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40649b = baseChannel;
            this.f40650c = map;
        }

        public final void run() {
            this.f40648a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MetaCountersCreated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40649b), this.f40650c));
        }
    }

    public final void onMetaCountersUpdated(BaseChannel baseChannel, Map<String, Integer> map) {
        super.onMetaCountersUpdated(baseChannel, map);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && map != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new m(this, baseChannel, map));
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40655b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f40656c;

        m(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, Map map) {
            this.f40654a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40655b = baseChannel;
            this.f40656c = map;
        }

        public final void run() {
            this.f40654a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MetaCountersUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40655b), this.f40656c));
        }
    }

    public final void onMetaCountersDeleted(BaseChannel baseChannel, List<String> list) {
        super.onMetaCountersDeleted(baseChannel, list);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && list != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new l(this, baseChannel, list));
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40651a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40652b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f40653c;

        l(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, List list) {
            this.f40651a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40652b = baseChannel;
            this.f40653c = list;
        }

        public final void run() {
            this.f40651a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.MetaCountersDeleted(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40652b), this.f40653c));
        }
    }

    public final void onChannelHidden(GroupChannel groupChannel) {
        super.onChannelHidden(groupChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && groupChannel != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new d(this, groupChannel));
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40630a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f40631b;

        d(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, GroupChannel groupChannel) {
            this.f40630a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40631b = groupChannel;
        }

        public final void run() {
            this.f40630a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ChannelHidden(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40631b)));
        }
    }

    public final void onOperatorUpdated(BaseChannel baseChannel) {
        super.onOperatorUpdated(baseChannel);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new q(this, baseChannel));
        }
    }

    static final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40667b;

        q(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel) {
            this.f40666a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40667b = baseChannel;
        }

        public final void run() {
            this.f40666a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.OperatorUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40667b)));
        }
    }

    public final void onThreadInfoUpdated(BaseChannel baseChannel, ThreadInfoUpdateEvent threadInfoUpdateEvent) {
        super.onThreadInfoUpdated(baseChannel, threadInfoUpdateEvent);
        io.reactivex.rxjava3.a.r rVar = this.$emitter;
        kotlin.g.b.k.a((Object) rVar, "emitter");
        if (!rVar.isDisposed() && baseChannel != null && threadInfoUpdateEvent != null) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new t(this, baseChannel, threadInfoUpdateEvent));
        }
    }

    static final class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$addChannelObserver$1$1 f40673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40674b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThreadInfoUpdateEvent f40675c;

        t(CPCSendbirdWrapper$addChannelObserver$1$1 cPCSendbirdWrapper$addChannelObserver$1$1, BaseChannel baseChannel, ThreadInfoUpdateEvent threadInfoUpdateEvent) {
            this.f40673a = cPCSendbirdWrapper$addChannelObserver$1$1;
            this.f40674b = baseChannel;
            this.f40675c = threadInfoUpdateEvent;
        }

        public final void run() {
            this.f40673a.$emitter.onNext(new CPCSendbirdWrapper.ChannelUpdate.ThreadInfoUpdated(CPCDataMapperKt.mapBaseChannelToChatChannel(this.f40674b), this.f40675c));
        }
    }
}
