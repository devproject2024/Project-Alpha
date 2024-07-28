package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public class p extends h {

    /* renamed from: a  reason: collision with root package name */
    public static String f63425a = p.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static int f63426b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f63427c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f63428d = 2;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f63429e;

    /* renamed from: f  reason: collision with root package name */
    private CJRProceedWidgetV8 f63430f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f63431g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f63432h = f63426b;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof View.OnClickListener) {
            this.f63429e = (View.OnClickListener) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            if (getArguments().containsKey(AppManagerUtil.EXTEND_TYPE)) {
                this.f63432h = getArguments().getInt(AppManagerUtil.EXTEND_TYPE);
            }
            if (getArguments().containsKey("hasNoOfflineTickets")) {
                this.f63431g = getArguments().getBoolean("hasNoOfflineTickets");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_offline_data, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        d dVar = d.f64967a;
        CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        if (a2.getFlowName() == null) {
            a2.setFlowName(new CRUFlowModel());
        }
        a2.getFlowName().setErrorType(ERROR_TYPE.NO_CONNECTION.name());
        az azVar = az.f61525a;
        az.a(a2);
        TextView textView = (TextView) view.findViewById(R.id.no_connection_header);
        TextView textView2 = (TextView) view.findViewById(R.id.no_connection_msg);
        TextView textView3 = (TextView) view.findViewById(R.id.see_offline_ticket);
        this.f63430f = (CJRProceedWidgetV8) view.findViewById(R.id.retry_button);
        this.f63430f.setProceedBtnText(getString(R.string.recharge_retry_bill_payment));
        this.f63430f.setOnClickListener(this.f63429e);
        int i2 = this.f63432h;
        if (i2 == f63427c) {
            if (this.f63431g) {
                textView.setText(getString(R.string.no_offline_header_msg));
                textView2.setText(getString(R.string.no_offline_msg));
                textView3.setVisibility(8);
            }
            textView3.setOnClickListener(this.f63429e);
        } else if (i2 == f63428d) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(8);
            if (!net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this)) {
                textView3.setOnClickListener(this.f63429e);
            }
        }
    }

    public final void a() {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63430f;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.a();
        }
    }

    public final void b() {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63430f;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f63429e = onClickListener;
    }
}
