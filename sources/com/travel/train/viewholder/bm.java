package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainOrderTextHolder;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class bm extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f28029a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f28030b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f28031c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f28032d;

    /* renamed from: e  reason: collision with root package name */
    private CJRTrainSummaryItem f28033e;

    /* renamed from: f  reason: collision with root package name */
    private CJRTrainOrderTextHolder f28034f;

    /* renamed from: g  reason: collision with root package name */
    private ab f28035g;

    /* renamed from: h  reason: collision with root package name */
    private String f28036h = "CJRTrainTextHolderViewHolder";

    public bm(View view, ab abVar) {
        super(view);
        this.f28030b = (LinearLayout) view.findViewById(R.id.lv_container);
        this.f28031c = (TextView) view.findViewById(R.id.tv_message);
        this.f28032d = (ImageView) view.findViewById(R.id.iv_icon);
        this.f28035g = abVar;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f28029a = context;
        this.f28033e = (CJRTrainSummaryItem) iJRDataModel;
        this.f28034f = (CJRTrainOrderTextHolder) this.f28033e.getItem();
        CJRTrainOrderTextHolder cJRTrainOrderTextHolder = this.f28034f;
        if (cJRTrainOrderTextHolder != null && !TextUtils.isEmpty(cJRTrainOrderTextHolder.getText())) {
            this.f28030b.setVisibility(0);
            this.f28031c.setText(this.f28034f.getText());
            if (!TextUtils.isEmpty(this.f28034f.getIcon())) {
                try {
                    if (URLUtil.isValidUrl(this.f28034f.getIcon())) {
                        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                        a2.f43753a = this.f28034f.getIcon();
                        b.a.C0750a.a(a2, this.f28032d, (com.paytm.utility.b.b.b) null, 2);
                    }
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        }
    }
}
