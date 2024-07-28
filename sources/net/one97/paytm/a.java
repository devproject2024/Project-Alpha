package net.one97.paytm;

import net.one97.paytm.landingpage.widgets.IconMenuView;
import net.one97.paytm.landingpage.widgets.SignInMenuView;
import net.one97.paytm.widget.EditView;
import net.one97.paytm.widget.NotificationView;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    CJRActionBarBaseActivity f51947a;

    /* renamed from: b  reason: collision with root package name */
    int f51948b;

    /* renamed from: c  reason: collision with root package name */
    int f51949c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationView f51950d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationView f51951e;

    /* renamed from: f  reason: collision with root package name */
    EditView f51952f;

    /* renamed from: g  reason: collision with root package name */
    SignInMenuView f51953g;

    /* renamed from: h  reason: collision with root package name */
    IconMenuView f51954h;

    /* renamed from: i  reason: collision with root package name */
    IconMenuView f51955i;

    public final void a(int i2) {
        NotificationView notificationView = this.f51950d;
        if (notificationView != null) {
            notificationView.setNotificationTextVisibility(i2);
        }
    }

    public final void b(int i2) {
        IconMenuView iconMenuView = this.f51954h;
        if (iconMenuView != null) {
            iconMenuView.setIconMenuVisibility(i2);
        }
    }
}
