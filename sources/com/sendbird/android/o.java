package com.sendbird.android;

import android.text.TextUtils;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.k;
import com.sendbird.android.log.Logger;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

final class o {

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final o f44853a = new o((byte) 0);
    }

    /* synthetic */ o(byte b2) {
        this();
    }

    private o() {
    }

    /* access modifiers changed from: package-private */
    public final void a(final Command command) {
        String g2 = command.g();
        final boolean hasCachedChannel = GroupChannel.hasCachedChannel(command.g());
        if (!TextUtils.isEmpty(g2)) {
            BaseChannel.getChannel(command, new BaseChannel.a() {
                public final void a(BaseChannel baseChannel) {
                    if (command.f()) {
                        o.this.a(command, baseChannel);
                    } else {
                        o.a(command, baseChannel, hasCachedChannel);
                    }
                }
            });
        } else if (command.f()) {
            a(command, (BaseChannel) null);
        } else {
            a(command, (BaseChannel) null, hasCachedChannel);
        }
    }

    /* access modifiers changed from: private */
    public void a(Command command, BaseChannel baseChannel) {
        Logger.d("processRequestedMessage() => " + command.f44217c + AppConstants.COLON + command.f44215a + AppConstants.COLON + command.f44216b);
        m mVar = command.f44215a;
        if (command.f()) {
            int i2 = AnonymousClass3.f44852a[mVar.ordinal()];
            if (i2 == 1 || i2 == 2) {
                BaseMessage createMessage = BaseMessage.createMessage(command);
                createMessage.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                Sender sender = createMessage.mSender;
                User currentUser = SendBird.getCurrentUser();
                if (!(sender == null || currentUser == null || !sender.getUserId().equals(currentUser.getUserId()))) {
                    currentUser.updatePropertiesByUser(sender);
                }
                if (baseChannel instanceof GroupChannel) {
                    final GroupChannel groupChannel = (GroupChannel) baseChannel;
                    groupChannel.setLastMessageByCreatedAt(createMessage);
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            k.a.f44826a.a((BaseChannel) groupChannel);
                        }
                    });
                }
            }
        }
    }

    static void a(Command command, BaseChannel baseChannel, boolean z) {
        Logger.d("processMessage() => " + command.f44217c + AppConstants.COLON + command.f44215a + AppConstants.COLON + command.f44216b);
        if (SendBird.isAppBackground()) {
            Logger.d("[ignored] messageReceived() => " + command.f44217c + AppConstants.COLON + command.f44215a + AppConstants.COLON + command.f44216b);
            return;
        }
        switch (command.f44215a) {
            case MESG:
            case FILE:
            case BRDM:
            case ADMM:
                k.a.f44826a.a(command, baseChannel, z);
                return;
            case MEDI:
            case FEDI:
            case AEDI:
                k.a.f44826a.b(command, baseChannel, z);
                return;
            case MRCT:
                k.a.f44826a.a(command, baseChannel);
                return;
            case READ:
                k.a.f44826a.c(command, baseChannel, z);
                return;
            case DLVR:
                k.a.f44826a.d(command, baseChannel, z);
                return;
            case TPST:
            case TPEN:
            case MTIO:
                return;
            case SYEV:
                k.a.f44826a.b(command, baseChannel);
                return;
            case USEV:
                k.a.f44826a.a(command);
                return;
            case DELM:
                k.a.f44826a.c(command, baseChannel);
                return;
            case LEAV:
            case JOIN:
                return;
            case MTHD:
                k.a.f44826a.d(command, baseChannel);
                return;
            default:
                Logger.d("Discard a command: " + command.f44215a);
                return;
        }
    }
}
