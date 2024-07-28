package net.one97.paytm.orders.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import net.one97.paytm.paytm_finance.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f56855a;

    /* renamed from: b  reason: collision with root package name */
    protected LinearLayout f56856b;

    /* renamed from: c  reason: collision with root package name */
    protected RadioGroup f56857c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f56858d = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_0));

    /* renamed from: e  reason: collision with root package name */
    private RadioButton f56859e = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_1));

    /* renamed from: f  reason: collision with root package name */
    private RadioButton f56860f = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_2));

    /* renamed from: g  reason: collision with root package name */
    private RadioButton f56861g = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_3));

    /* renamed from: h  reason: collision with root package name */
    private RadioButton f56862h = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_4));

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f56863i = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_5));
    private RadioButton j = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_6));
    private RadioButton k = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_7));
    private RadioButton l = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_8));
    private RadioButton m = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_9));
    private RadioButton n = ((RadioButton) this.f56857c.findViewById(R.id.rating_value_10));
    private C1056a o;

    /* renamed from: net.one97.paytm.orders.b.a$a  reason: collision with other inner class name */
    public interface C1056a {
    }

    public a(Context context, View view) {
        this.f56855a = context;
        this.o = (C1056a) context;
        int u = com.paytm.utility.a.u(this.f56855a);
        this.f56856b = (LinearLayout) view.findViewById(R.id.nps_capture_lyt);
        this.f56856b.setPadding(u, u, u, u * 2);
        this.f56857c = (RadioGroup) view.findViewById(R.id.nps_radiogroup);
    }
}
