package net.one97.paytm.recharge.common.utils;

import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.widget.EditView;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public CJRRechargeBaseActivity f61725a;

    /* renamed from: b  reason: collision with root package name */
    public int f61726b;

    /* renamed from: c  reason: collision with root package name */
    public int f61727c;

    /* renamed from: d  reason: collision with root package name */
    public EditView f61728d;

    /* renamed from: e  reason: collision with root package name */
    public RechargeIconMenuView f61729e;

    public final void a(String str) {
        RechargeIconMenuView rechargeIconMenuView;
        CJRRechargeBaseActivity cJRRechargeBaseActivity = this.f61725a;
        if (cJRRechargeBaseActivity != null && !cJRRechargeBaseActivity.isFinishing() && (rechargeIconMenuView = this.f61729e) != null) {
            rechargeIconMenuView.setIconMenuVisibility(0);
            this.f61729e.setImageIconFromURL(str);
        }
    }

    public final void a() {
        RechargeIconMenuView rechargeIconMenuView = this.f61729e;
        if (rechargeIconMenuView != null) {
            rechargeIconMenuView.setIconMenuVisibility(8);
        }
    }
}
