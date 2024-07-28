package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.n;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class k extends n.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f61075a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f61076b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f61077c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f61078d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f61079e;

    /* renamed from: f  reason: collision with root package name */
    private Context f61080f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f61081g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.recharge.common.e.k f61082h;

    public k(View view, Context context, Boolean bool, Boolean bool2, net.one97.paytm.recharge.common.e.k kVar) {
        super(view);
        this.f61080f = context;
        this.f61081g = bool.booleanValue();
        this.f61079e = bool2.booleanValue();
        this.f61082h = kVar;
        this.f61075a = (RoboTextView) view.findViewById(R.id.operator_name_v2);
        this.f61076b = (ImageView) view.findViewById(R.id.operator_image_v2);
        this.f61077c = (TextView) view.findViewById(R.id.tv_utilities_coming_soon);
        this.f61078d = (ImageView) view.findViewById(R.id.ic_next_selection);
        view.setOnClickListener(this);
    }

    public final void a(CJRAggsItem cJRAggsItem) {
        if (cJRAggsItem != null) {
            b.a(this.f61075a);
            int f2 = b.f(this.f61080f);
            this.f61075a.setText(cJRAggsItem.getDisplayValue().trim());
            if (!TextUtils.isEmpty(cJRAggsItem.getImageUrl())) {
                int i2 = f2 * 3;
                this.f61076b.getLayoutParams().width = i2;
                this.f61076b.getLayoutParams().height = i2;
                this.f61076b.setVisibility(0);
                w.a().a(cJRAggsItem.getImageUrl().replace(" ", "%20")).a(this.f61076b, (e) null);
            } else {
                this.f61076b.setVisibility(8);
            }
            this.f61078d.setVisibility(this.f61079e ? 0 : 8);
            if (!this.f61081g || cJRAggsItem.isSchedulable()) {
                this.f61077c.setVisibility(8);
            } else {
                this.f61077c.setVisibility(0);
            }
        }
    }

    public final void onClick(View view) {
        this.f61082h.c(getAdapterPosition());
    }
}
