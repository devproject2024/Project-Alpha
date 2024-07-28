package com.imsdk;

import com.imsdk.CPCSendbirdWrapper;
import com.imsdk.Datawrapper;
import com.sendbird.android.SendBird;
import kotlin.g.b.g;

public final class CPCSendbirdWrapper$listenConnectionManagement$1 implements SendBird.ConnectionHandler {
    final /* synthetic */ String $userId;
    final /* synthetic */ CPCSendbirdWrapper this$0;

    public final void onReconnectStarted() {
    }

    CPCSendbirdWrapper$listenConnectionManagement$1(CPCSendbirdWrapper cPCSendbirdWrapper, String str) {
        this.this$0 = cPCSendbirdWrapper;
        this.$userId = str;
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$listenConnectionManagement$1 f40718a;

        b(CPCSendbirdWrapper$listenConnectionManagement$1 cPCSendbirdWrapper$listenConnectionManagement$1) {
            this.f40718a = cPCSendbirdWrapper$listenConnectionManagement$1;
        }

        public final void run() {
            this.f40718a.this$0.connectionStatusPublisher.onNext(new Datawrapper.Success(new CPCSendbirdWrapper.ConnectionStatus(this.f40718a.$userId, (String) null, true, false)));
        }
    }

    public final void onReconnectSucceeded() {
        io.reactivex.rxjava3.i.a.b().a((Runnable) new b(this));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper$listenConnectionManagement$1 f40717a;

        a(CPCSendbirdWrapper$listenConnectionManagement$1 cPCSendbirdWrapper$listenConnectionManagement$1) {
            this.f40717a = cPCSendbirdWrapper$listenConnectionManagement$1;
        }

        public final void run() {
            this.f40717a.this$0.connectionStatusPublisher.onNext(new Datawrapper.Failure((Throwable) null, 1, (g) null));
        }
    }

    public final void onReconnectFailed() {
        io.reactivex.rxjava3.i.a.b().a((Runnable) new a(this));
    }
}
