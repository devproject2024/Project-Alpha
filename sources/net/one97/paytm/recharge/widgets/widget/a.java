package net.one97.paytm.recharge.widgets.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.widgets.R;
import net.one97.paytm.recharge.widgets.c.e;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public static String f64986a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static int f64987b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f64988c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f64989d = 2;

    /* renamed from: e  reason: collision with root package name */
    private View.OnClickListener f64990e;

    /* renamed from: f  reason: collision with root package name */
    private CJRProceedWidgetV8 f64991f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f64992g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f64993h = f64987b;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof View.OnClickListener) {
            this.f64990e = (View.OnClickListener) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            if (getArguments().containsKey(AppManagerUtil.EXTEND_TYPE)) {
                this.f64993h = getArguments().getInt(AppManagerUtil.EXTEND_TYPE);
            }
            if (getArguments().containsKey("hasNoOfflineTickets")) {
                this.f64992g = getArguments().getBoolean("hasNoOfflineTickets");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_offline_data, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        TextView textView = (TextView) view.findViewById(R.id.no_connection_header);
        TextView textView2 = (TextView) view.findViewById(R.id.no_connection_msg);
        TextView textView3 = (TextView) view.findViewById(R.id.see_offline_ticket);
        this.f64991f = (CJRProceedWidgetV8) view.findViewById(R.id.retry_button);
        this.f64991f.setProceedBtnText(getString(R.string.recharge_retry_bill_payment));
        this.f64991f.setOnClickListener(this.f64990e);
        int i2 = this.f64993h;
        if (i2 == f64988c) {
            if (this.f64992g) {
                textView.setText(getString(R.string.no_offline_header_msg));
                textView2.setText(getString(R.string.no_offline_msg));
                textView3.setVisibility(8);
            }
            textView3.setOnClickListener(this.f64990e);
        } else if (i2 == f64989d) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(8);
            if (!e.INSTANCE.validateIsAlreadyClicked(this)) {
                textView3.setOnClickListener(this.f64990e);
            }
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f64990e = onClickListener;
    }
}
