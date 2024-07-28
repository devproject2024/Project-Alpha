package net.one97.paytm.recharge.common.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.rechargeutility.CJRSuccessRateAlertMessage;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class g extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60996a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f60997e;

    /* renamed from: b  reason: collision with root package name */
    private CJRSuccessRateAlertMessage f60998b;

    /* renamed from: c  reason: collision with root package name */
    private String f60999c;

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f61000d;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f61001f;

    public g(CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage, String str, View.OnClickListener onClickListener) {
        k.c(cJRSuccessRateAlertMessage, "successRateAlertMessage");
        this.f60998b = cJRSuccessRateAlertMessage;
        this.f60999c = str;
        this.f61000d = onClickListener;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = g.class.getSimpleName();
        k.a((Object) simpleName, "FJROperatorAlertBottomSh…V8::class.java.simpleName");
        f60997e = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_operator_alert_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.txt_alert_message);
        k.a((Object) findViewById, "view.findViewById<TextVi…>(R.id.txt_alert_message)");
        TextView textView = (TextView) findViewById;
        String message = this.f60998b.getMessage();
        if (message == null) {
            message = "";
        }
        textView.setText(message);
        View.OnClickListener onClickListener = this;
        view.findViewById(R.id.close_button).setOnClickListener(onClickListener);
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) view.findViewById(R.id.btn_proceed);
        cJRProceedWidgetV8.setProceedBtnText(this.f60999c);
        cJRProceedWidgetV8.setOnClickListener(onClickListener);
    }

    public final void a(CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage) {
        TextView textView;
        k.c(cJRSuccessRateAlertMessage, "successRateAlertMessage");
        this.f60998b = cJRSuccessRateAlertMessage;
        View view = getView();
        if (view != null && (textView = (TextView) view.findViewById(R.id.txt_alert_message)) != null) {
            String message = cJRSuccessRateAlertMessage.getMessage();
            if (message == null) {
                message = "";
            }
            textView.setText(message);
        }
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.close_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            return;
        }
        int i3 = R.id.btn_proceed;
        if (valueOf != null && valueOf.intValue() == i3 && (onClickListener = this.f61000d) != null) {
            onClickListener.onClick(view);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f61001f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
