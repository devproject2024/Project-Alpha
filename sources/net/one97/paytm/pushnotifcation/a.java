package net.one97.paytm.pushnotifcation;

import android.os.Bundle;
import com.paytm.notification.models.PushMessage;
import net.one97.paytm.notification.b;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private PushMessage f59815a;

    public a(PushMessage pushMessage) {
        this.f59815a = pushMessage;
    }

    public final String a() {
        PushMessage pushMessage = this.f59815a;
        return (pushMessage == null || pushMessage.getNotification() == null || this.f59815a.getNotification().getContent() == null || this.f59815a.getNotification().getContent().getBody() == null) ? "" : this.f59815a.getNotification().getContent().getBody();
    }

    public final Bundle b() {
        PushMessage pushMessage = this.f59815a;
        if (pushMessage == null || pushMessage.getBundle() == null) {
            return new Bundle();
        }
        return this.f59815a.getBundle();
    }
}
