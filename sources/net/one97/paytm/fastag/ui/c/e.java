package net.one97.paytm.fastag.ui.c;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import java.io.Serializable;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.c.a;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.m;
import net.one97.paytm.upi.util.UpiConstants;

public class e extends Fragment {

    /* renamed from: d  reason: collision with root package name */
    private static final String f13919d = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f13920a = "outerTab";

    /* renamed from: b  reason: collision with root package name */
    int f13921b = 3;

    /* renamed from: c  reason: collision with root package name */
    boolean f13922c;

    /* renamed from: e  reason: collision with root package name */
    private TextView f13923e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13924f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13925g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f13926h;

    /* renamed from: i  reason: collision with root package name */
    private View f13927i = null;
    /* access modifiers changed from: private */
    public CJROrderSummary j = null;
    private String k;
    /* access modifiers changed from: private */
    public ProgressDialog l;

    public static e a(CJROrderSummary cJROrderSummary, boolean z, String str) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order_summary_key", cJROrderSummary);
        bundle.putBoolean("contact_us_key", z);
        bundle.putString("order_item_id", str);
        eVar.setArguments(bundle);
        return eVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.j = (CJROrderSummary) arguments.getSerializable("order_summary_key");
                this.f13922c = arguments.getBoolean("contact_us_key");
                this.k = arguments.getString("order_item_id");
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        View inflate = layoutInflater.inflate(R.layout.fastag_pending_layout, (ViewGroup) null);
        this.f13926h = (TextView) inflate.findViewById(R.id.tv_my_order_text);
        this.f13924f = (TextView) inflate.findViewById(R.id.tv_pending_payemnt_msg);
        this.f13923e = (TextView) inflate.findViewById(R.id.txt_order_date_time);
        this.f13925g = (TextView) inflate.findViewById(R.id.btn_money_deducted);
        this.f13925g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (e.this.getActivity() != null) {
                    e eVar = e.this;
                    e.a(eVar, eVar.j);
                }
            }
        });
        SpannableString spannableString = new SpannableString(getString(R.string.fastag_payment_confirmaton));
        spannableString.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                if (e.this.getActivity() != null) {
                    Intent intent = new Intent(e.this.getActivity(), a.a().f13559b.getPassbookActivityClass());
                    intent.putExtra(e.this.f13920a, e.this.f13921b);
                    e.this.getActivity().startActivity(intent);
                }
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(e.this.getResources().getColor(R.color.color_00b9f5));
            }
        }, spannableString.length() - 9, spannableString.length(), 33);
        this.f13926h.setText(spannableString);
        this.f13926h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f13926h.setHighlightColor(getResources().getColor(R.color.color_00b9f5));
        CJROrderSummary cJROrderSummary = this.j;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            this.f13923e.setText(a.a().f13559b.getFormattedOrderDate(this.j.getCreatedAt(), "hh:mm a, dd MMM yyyy").replace("PM", "pm").replace("AM", "am"));
            if (!TextUtils.isEmpty(this.j.getPaymentText())) {
                this.f13924f.setVisibility(0);
                this.f13924f.setText(this.j.getPaymentText());
            } else {
                this.f13924f.setVisibility(8);
            }
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    static /* synthetic */ void a(e eVar, CJROrderSummary cJROrderSummary) {
        try {
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            cJROrderedCart.setOrderId(cJROrderSummary.getId());
            Bundle bundle = new Bundle();
            f fVar = new f();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (Serializable) fVar.a(fVar.a((Object) cJROrderedCart), net.one97.paytm.common.entity.shopping.CJROrderedCart.class));
            a.a().f13559b.startCSTOrderIssuesActivity(eVar.getActivity(), bundle, new m() {
                public final void show() {
                    e eVar = e.this;
                    ProgressDialog unused = eVar.l = ProgressDialog.show(eVar.getActivity(), "Loading", "Please wait...", true);
                }

                public final void dismiss() {
                    e.this.l.dismiss();
                }
            });
        } catch (Exception unused) {
        }
    }
}
