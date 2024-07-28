package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.b;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.n;
import net.one97.paytm.recharge.common.e.k;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class j extends n.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f61070a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f61071b;

    /* renamed from: c  reason: collision with root package name */
    private Context f61072c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61073d;

    /* renamed from: e  reason: collision with root package name */
    private k f61074e;

    public j(View view, Context context, Boolean bool, k kVar) {
        super(view);
        this.f61070a = (TextView) view.findViewById(R.id.operator_name_v2);
        this.f61071b = (ImageView) view.findViewById(R.id.operator_image_v2);
        this.f61072c = context;
        this.f61073d = bool.booleanValue();
        this.f61074e = kVar;
        view.setOnClickListener(this);
    }

    public final void a(CJRAggsItem cJRAggsItem) {
        if (cJRAggsItem != null) {
            b.c(this.f61070a);
            int f2 = b.f(this.f61072c);
            this.f61070a.setText(cJRAggsItem.getDisplayValue().trim());
            if (cJRAggsItem.getImageUrl() == null) {
                this.f61071b.setVisibility(4);
            } else if (!TextUtils.isEmpty(cJRAggsItem.getImageUrl())) {
                int i2 = f2 * 3;
                this.f61071b.getLayoutParams().width = i2;
                this.f61071b.getLayoutParams().height = i2;
                this.f61071b.setVisibility(0);
                w.a().a(cJRAggsItem.getImageUrl().replace(" ", "%20")).a(this.f61071b, (e) null);
            } else {
                this.f61071b.setVisibility(4);
            }
        }
    }

    public final void onClick(View view) {
        this.f61074e.c(getAdapterPosition());
    }
}
