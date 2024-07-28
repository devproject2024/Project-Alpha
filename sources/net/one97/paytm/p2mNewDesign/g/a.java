package net.one97.paytm.p2mNewDesign.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.wallet.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f51261a;

    /* renamed from: b  reason: collision with root package name */
    public View f51262b = this.f51266f.inflate(R.layout.mlv_balance_detail_tooltip, (ViewGroup) null);

    /* renamed from: c  reason: collision with root package name */
    public Context f51263c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51264d = ((TextView) this.f51262b.findViewById(R.id.tv_policy_text));

    /* renamed from: e  reason: collision with root package name */
    public TextView f51265e = ((TextView) this.f51262b.findViewById(R.id.tv_total_balance));

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f51266f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f51267g = ((RelativeLayout) this.f51262b.findViewById(R.id.mlv_balance_detail_container));

    public a(Context context) {
        this.f51263c = context;
        this.f51261a = new PopupWindow(context);
        this.f51266f = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f51267g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        PopupWindow popupWindow = this.f51261a;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f51261a.dismiss();
        }
    }
}
