package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.a.a.i;
import com.google.firebase.crashlytics.c;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainPromoInfo;
import com.travel.train.model.trainticket.CJRTrainPromoItems;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class an extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    ab f27821a;

    /* renamed from: b  reason: collision with root package name */
    CJRTrainPromoInfo f27822b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27823c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainSummaryItem f27824d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27825e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27826f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f27827g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f27828h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f27829i;
    private TextView j;
    private IJRDataModel k;
    private RelativeLayout l;
    private LinearLayout m;

    public an(final View view, ab abVar) {
        super(view);
        Drawable drawable;
        this.f27821a = abVar;
        this.f27823c = view.getContext();
        this.l = (RelativeLayout) view.findViewById(R.id.cashback_background_img);
        this.f27825e = (TextView) view.findViewById(R.id.cashback_value);
        this.m = (LinearLayout) view.findViewById(R.id.cashback_details_container);
        this.f27827g = (TextView) view.findViewById(R.id.cashback_desc);
        this.f27828h = (TextView) view.findViewById(R.id.cashback_text);
        this.f27829i = (TextView) view.findViewById(R.id.header_value);
        this.j = (TextView) view.findViewById(R.id.cashback_header);
        this.f27826f = (TextView) view.findViewById(R.id.view_passbook);
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                drawable = i.a(this.f27823c.getResources(), R.drawable.pre_t_cash_back_bg, this.f27823c.getTheme());
            } else {
                drawable = this.f27823c.getResources().getDrawable(R.drawable.pre_t_cash_back_bg, this.f27823c.getTheme());
            }
            this.l.setBackground(drawable);
        } catch (Exception e2) {
            c.a().a(e2.getMessage());
        }
        this.f27826f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                an.this.f27821a.a(an.this.f27822b, ah.VIEW_PASSBOOK_CLICK);
            }
        });
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27823c = context;
        this.k = iJRDataModel;
        this.f27824d = (CJRTrainSummaryItem) iJRDataModel;
        this.f27822b = (CJRTrainPromoInfo) this.f27824d.getItem();
        this.m.removeAllViews();
        CJRTrainPromoInfo cJRTrainPromoInfo = this.f27822b;
        if (cJRTrainPromoInfo != null) {
            String cashbackText = cJRTrainPromoInfo.getCashbackText();
            String promoText = this.f27822b.getPromoText();
            String travellersKey = this.f27822b.getTravellersKey();
            String cashbackKey = this.f27822b.getCashbackKey();
            if (cashbackText != null) {
                this.f27825e.setVisibility(0);
                this.f27825e.setText(cashbackText);
            }
            if (promoText != null) {
                this.f27827g.setVisibility(0);
                this.f27827g.setText(promoText);
            }
            if (travellersKey != null) {
                this.f27829i.setVisibility(0);
                this.f27829i.setText(travellersKey);
            }
            if (cashbackKey != null) {
                this.j.setVisibility(0);
                this.j.setText(cashbackKey);
            }
            if (this.f27822b.getPaxInfo() == null || this.f27822b.getPaxInfo().size() == 0) {
                this.f27826f.setVisibility(8);
                return;
            }
            for (int i3 = 0; i3 < this.f27822b.getPaxInfo().size(); i3++) {
                CJRTrainPromoItems cJRTrainPromoItems = this.f27822b.getPaxInfo().get(i3);
                if (cJRTrainPromoItems != null) {
                    this.f27826f.setVisibility(0);
                    View inflate = LayoutInflater.from(this.f27823c).inflate(R.layout.pre_t_train_cashback_passenger_lyt, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.pax_name);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.cashback_value);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.credit_desc);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.cashback_image);
                    View findViewById = inflate.findViewById(R.id.separator_line);
                    if (!TextUtils.isEmpty(cJRTrainPromoItems.getPaxName()) && cJRTrainPromoItems.getPaxName() != null) {
                        textView.setVisibility(0);
                        textView.setText(cJRTrainPromoItems.getPaxName());
                    }
                    if (!TextUtils.isEmpty(cJRTrainPromoItems.getCashback()) && cJRTrainPromoItems.getCashback() != null) {
                        textView2.setVisibility(0);
                        textView2.setText(cJRTrainPromoItems.getCashback());
                    }
                    if (!TextUtils.isEmpty(cJRTrainPromoItems.getText()) && cJRTrainPromoItems.getText() != null) {
                        textView3.setVisibility(0);
                        textView3.setText(cJRTrainPromoItems.getText());
                    }
                    if (cJRTrainPromoItems.getCashbackStatus() == 1) {
                        imageView.setImageResource(R.drawable.pre_t_cash_back);
                        imageView.setVisibility(0);
                    }
                    if (cJRTrainPromoItems.getCashbackStatus() == 2) {
                        imageView.setImageResource(R.drawable.pre_t_cashback_pending);
                        imageView.setVisibility(0);
                    }
                    if (cJRTrainPromoItems.getCashbackStatus() == 3) {
                        imageView.setImageResource(R.drawable.pre_t_cashback_pending);
                        imageView.setVisibility(0);
                    }
                    findViewById.setVisibility(0);
                    if (i3 == this.f27822b.getPaxInfo().size() - 1) {
                        findViewById.setVisibility(8);
                    }
                    this.m.addView(inflate, i3);
                }
            }
        }
    }
}
