package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRPNRPAXInformation;
import com.travel.train.model.trainticket.CJRPNRPrediction;
import com.travel.train.model.trainticket.CJRPNRStatusMeta;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ac extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f27758a = "#00baf2";

    /* renamed from: b  reason: collision with root package name */
    private String f27759b = "#f6f6f6";

    /* renamed from: c  reason: collision with root package name */
    private CJRPNRStatusMeta f27760c;

    /* renamed from: d  reason: collision with root package name */
    private CJRPNRPrediction f27761d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27762e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27763f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f27764g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f27765h;

    /* renamed from: i  reason: collision with root package name */
    private CJRPNRPAXInformation f27766i;
    private Context j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ac(View view, CJRPNRStatusMeta cJRPNRStatusMeta, CJRPNRPrediction cJRPNRPrediction) {
        super(view);
        k.c(view, "itemView");
        k.c(cJRPNRStatusMeta, "pnrMeta");
        Context context = view.getContext();
        k.a((Object) context, "itemView.context");
        this.j = context;
        View findViewById = view.findViewById(R.id.txt_passengerName);
        k.a((Object) findViewById, "itemView.findViewById(R.id.txt_passengerName)");
        this.f27762e = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.txt_seatStatus);
        k.a((Object) findViewById2, "itemView.findViewById(R.id.txt_seatStatus)");
        this.f27763f = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.prediction_progressBar);
        k.a((Object) findViewById3, "itemView.findViewById(R.id.prediction_progressBar)");
        this.f27764g = (ProgressBar) findViewById3;
        View findViewById4 = view.findViewById(R.id.prediction_progressBar_txt);
        k.a((Object) findViewById4, "itemView.findViewById(R.…ediction_progressBar_txt)");
        this.f27765h = (TextView) findViewById4;
        this.f27760c = cJRPNRStatusMeta;
        this.f27761d = cJRPNRPrediction;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        k.c(iJRDataModel, "traveller");
        this.f27766i = (CJRPNRPAXInformation) iJRDataModel;
        TextView textView = this.f27762e;
        CJRPNRPAXInformation cJRPNRPAXInformation = this.f27766i;
        if (cJRPNRPAXInformation == null) {
            k.a("travellerInfo");
        }
        textView.setText(cJRPNRPAXInformation.getmPassengerName());
        CJRPNRPAXInformation cJRPNRPAXInformation2 = this.f27766i;
        if (cJRPNRPAXInformation2 == null) {
            k.a("travellerInfo");
        }
        if (!TextUtils.isEmpty(cJRPNRPAXInformation2.getmCurrentStatus())) {
            TextView textView2 = this.f27763f;
            CJRPNRPAXInformation cJRPNRPAXInformation3 = this.f27766i;
            if (cJRPNRPAXInformation3 == null) {
                k.a("travellerInfo");
            }
            textView2.setText(cJRPNRPAXInformation3.getmCurrentStatus());
        } else {
            TextView textView3 = this.f27763f;
            if (context == null) {
                k.a();
            }
            textView3.setText(context.getResources().getString(R.string.emptyFeed));
        }
        CJRPNRPrediction cJRPNRPrediction = this.f27761d;
        if (cJRPNRPrediction != null) {
            ProgressBar progressBar = this.f27764g;
            if (cJRPNRPrediction == null) {
                k.a();
            }
            progressBar.setProgress(cJRPNRPrediction.getValue());
            TextView textView4 = this.f27765h;
            StringBuilder sb = new StringBuilder();
            CJRPNRPrediction cJRPNRPrediction2 = this.f27761d;
            if (cJRPNRPrediction2 == null) {
                k.a();
            }
            sb.append(String.valueOf(cJRPNRPrediction2.getValue()));
            sb.append("%");
            textView4.setText(sb.toString());
            CJRPNRPrediction cJRPNRPrediction3 = this.f27761d;
            String color = cJRPNRPrediction3 != null ? cJRPNRPrediction3.getColor() : null;
            if (TextUtils.isEmpty(color)) {
                color = this.f27758a;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.f27764g.getProgressDrawable().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
                return;
            }
            return;
        }
        this.f27765h.setText("-");
        this.f27764g.setProgress(100);
        String str = this.f27759b;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f27764g.getProgressDrawable().setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
        }
    }
}
