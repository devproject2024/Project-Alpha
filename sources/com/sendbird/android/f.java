package com.sendbird.android;

import com.sendbird.android.Command;
import com.sendbird.android.TimeoutScheduler;
import com.sendbird.android.log.Logger;

final class f implements TimeoutScheduler.TimeoutEventhandler {

    /* renamed from: a  reason: collision with root package name */
    final TimeoutScheduler f44705a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Command.SendCommandHandler f44706b;

    f(long j, Command.SendCommandHandler sendCommandHandler) {
        this.f44706b = sendCommandHandler;
        this.f44705a = new TimeoutScheduler(j, this);
    }

    public final void onTimeout(Object obj) {
        Logger.d(">> AckSession::onTimeout()");
        a((Command) null, new SendBirdException("Command received no ack.", SendBirdError.ERR_ACK_TIMEOUT));
    }

    /* access modifiers changed from: package-private */
    public final void a(final Command command, final SendBirdException sendBirdException) {
        SendBird.runOnUIThread(new Runnable() {
            public final void run() {
                if (f.this.f44706b != null) {
                    f.this.f44706b.onResult(command, sendBirdException);
                }
            }
        });
    }
}
