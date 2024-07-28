package androidx.work;

import android.app.Notification;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f5096a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5097b;

    /* renamed from: c  reason: collision with root package name */
    public final Notification f5098c;

    public h(int i2, Notification notification, int i3) {
        this.f5096a = i2;
        this.f5098c = notification;
        this.f5097b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f5096a == hVar.f5096a && this.f5097b == hVar.f5097b) {
            return this.f5098c.equals(hVar.f5098c);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f5096a * 31) + this.f5097b) * 31) + this.f5098c.hashCode();
    }

    public final String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f5096a + ", mForegroundServiceType=" + this.f5097b + ", mNotification=" + this.f5098c + '}';
    }
}
