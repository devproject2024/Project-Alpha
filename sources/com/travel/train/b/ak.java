package com.travel.train.b;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import com.travel.utils.n;
import java.util.ArrayList;

public final class ak extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    ab f26226a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<CJRTrainOrderSummaryAction> f26227b;

    /* renamed from: c  reason: collision with root package name */
    private Context f26228c;

    /* renamed from: d  reason: collision with root package name */
    private String f26229d = "CJRTrainOrderActionsAdapter";

    /* renamed from: e  reason: collision with root package name */
    private String f26230e;

    public ak(Context context, ab abVar, ArrayList<CJRTrainOrderSummaryAction> arrayList) {
        this.f26227b = arrayList;
        this.f26228c = context;
        this.f26226a = abVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_lyt_train_order_action_item, viewGroup, false);
        int a2 = b.a((Activity) this.f26228c);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        ArrayList<CJRTrainOrderSummaryAction> arrayList = this.f26227b;
        if (arrayList != null && arrayList.size() > 0) {
            if (this.f26227b.size() == 1) {
                layoutParams.width = a2;
                inflate.setLayoutParams(layoutParams);
            } else if (this.f26227b.size() == 2) {
                layoutParams.width = a2 / 2;
                inflate.setLayoutParams(layoutParams);
            } else if (this.f26227b.size() == 3) {
                layoutParams.width = a2 / 3;
                inflate.setLayoutParams(layoutParams);
            } else if (this.f26227b.size() > 3) {
                layoutParams.width = (int) (((double) a2) / 3.6d);
                inflate.setLayoutParams(layoutParams);
            }
        }
        return new a(inflate);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final a aVar = (a) vVar;
        final CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction = this.f26227b.get(i2);
        if (!(cJRTrainOrderSummaryAction == null || cJRTrainOrderSummaryAction.getLabel() == null)) {
            aVar.f26234a.setText(cJRTrainOrderSummaryAction.getLabel());
        }
        aVar.f26236c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ak.this.f26226a.a(cJRTrainOrderSummaryAction, ah.ORDER_ACTION_CLICK);
            }
        });
        if (cJRTrainOrderSummaryAction != null && cJRTrainOrderSummaryAction.getImageUrl() != null) {
            this.f26230e = cJRTrainOrderSummaryAction.getImageUrl();
            try {
                if (URLUtil.isValidUrl(this.f26230e)) {
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f26228c);
                    a2.f43753a = this.f26230e;
                    b.a.C0750a.a(a2, aVar.f26235b, (com.paytm.utility.b.b.b) null, 2);
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f26234a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f26235b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f26236c;

        public a(View view) {
            super(view);
            this.f26234a = (TextView) view.findViewById(R.id.item_text);
            this.f26236c = (LinearLayout) view.findViewById(R.id.item_root_layout);
            this.f26235b = (ImageView) view.findViewById(R.id.item_image);
            ResourceUtils.loadTrainImagesFromCDN(this.f26235b, "get_ticket.png", false, false, n.a.V1);
        }
    }

    public final int getItemCount() {
        return this.f26227b.size();
    }
}
