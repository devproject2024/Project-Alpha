package net.one97.paytm.fastag.ui.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.network.b.h;
import com.paytm.utility.b;
import com.paytm.utility.q;
import net.one97.paytm.common.widgets.RoundedImageView;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.c.a;
import net.one97.paytm.fastag.model.CJROrderSummary;

public class f extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13931b = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    boolean f13932a;

    /* renamed from: c  reason: collision with root package name */
    private RoundedImageView f13933c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f13934d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f13935e;

    /* renamed from: f  reason: collision with root package name */
    private View f13936f = null;

    /* renamed from: g  reason: collision with root package name */
    private CJROrderSummary f13937g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f13938h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f13939i;

    public static f a(CJROrderSummary cJROrderSummary, boolean z, String str) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order_summary_key", cJROrderSummary);
        bundle.putBoolean("contact_us_key", z);
        bundle.putString("order_item_id", str);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.f13937g = (CJROrderSummary) arguments.getSerializable("order_summary_key");
                this.f13932a = arguments.getBoolean("contact_us_key");
                this.f13938h = arguments.getString("order_item_id");
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        View inflate = layoutInflater.inflate(R.layout.fastag_success_layout, (ViewGroup) null);
        this.f13933c = (RoundedImageView) inflate.findViewById(R.id.logo);
        this.f13939i = (ImageView) inflate.findViewById(R.id.img_default);
        this.f13934d = (TextView) inflate.findViewById(R.id.txt_recharge_amount);
        this.f13935e = (TextView) inflate.findViewById(R.id.txt_order_date_time);
        CJROrderSummary cJROrderSummary = this.f13937g;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            String imageUrl = this.f13937g.getOrderedCartList().get(0).getProductDetail().getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                this.f13939i.setVisibility(8);
                this.f13933c.setImageUrl(imageUrl, h.INSTANCE.getImageLoader());
            }
            this.f13934d.setText(getString(R.string.rupee, b.x(this.f13937g.getOrderedCartList().get(0).getAggregateItemPrice())));
            this.f13935e.setText(a.a().f13559b.getFormattedOrderDate(this.f13937g.getCreatedAt(), "hh:mm a, dd MMM yyyy").replace("PM", "pm").replace("AM", "am"));
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
