package net.one97.paytm.fastag.ui.c;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.f.h;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.ui.activity.FasTagKYCActivity;

public class c extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13899b = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    boolean f13900a;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13901c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f13902d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f13903e;

    /* renamed from: f  reason: collision with root package name */
    private View f13904f = null;

    /* renamed from: g  reason: collision with root package name */
    private CJROrderSummary f13905g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f13906h;

    public static c a(CJROrderSummary cJROrderSummary, boolean z, String str) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order_summary_key", cJROrderSummary);
        bundle.putBoolean("contact_us_key", z);
        bundle.putString("order_item_id", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.f13905g = (CJROrderSummary) arguments.getSerializable("order_summary_key");
                this.f13900a = arguments.getBoolean("contact_us_key");
                this.f13906h = arguments.getString("order_item_id");
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        View inflate = layoutInflater.inflate(R.layout.fastag_failed_layout, (ViewGroup) null);
        this.f13902d = (TextView) inflate.findViewById(R.id.tv_payment_failed_message);
        this.f13901c = (TextView) inflate.findViewById(R.id.txt_order_date_time);
        this.f13903e = (TextView) inflate.findViewById(R.id.btn_try_again);
        this.f13903e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.getActivity() != null) {
                    c cVar = c.this;
                    cVar.startActivity(new Intent(cVar.getActivity(), FasTagKYCActivity.class));
                }
            }
        });
        CJROrderSummary cJROrderSummary = this.f13905g;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            this.f13901c.setText(h.j(this.f13905g.getCreatedAt(), "hh:mm a, dd MMM yyyy").replace("PM", "pm").replace("AM", "am"));
            if (!TextUtils.isEmpty(this.f13905g.getPaymentText())) {
                this.f13902d.setVisibility(0);
                this.f13902d.setText(this.f13905g.getPaymentText());
            } else {
                this.f13902d.setVisibility(8);
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
}
