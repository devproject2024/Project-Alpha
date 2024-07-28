package net.one97.paytm.landingpage.e;

import net.one97.paytm.landingpage.widgets.CartMenuView;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f52752a;

    /* renamed from: b  reason: collision with root package name */
    public CartMenuView f52753b;

    public final void a(String str) {
        CartMenuView cartMenuView = this.f52753b;
        if (cartMenuView != null) {
            cartMenuView.setCartMenuText(str, this.f52752a);
            a(0);
        }
    }

    public final void a(int i2) {
        CartMenuView cartMenuView = this.f52753b;
        if (cartMenuView != null) {
            cartMenuView.setCartMenuTextVisibility(i2);
        }
    }
}
