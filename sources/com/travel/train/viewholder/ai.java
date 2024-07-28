package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ai extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    ab f27794a;

    /* renamed from: b  reason: collision with root package name */
    CJRTrainOrderSummaryAction f27795b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27796c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f27797d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27798e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27799f;

    /* renamed from: g  reason: collision with root package name */
    private CJRTrainSummaryItem f27800g;

    /* renamed from: h  reason: collision with root package name */
    private String f27801h = "CJRTrainCPViewHolder";

    public ai(View view, ab abVar) {
        super(view);
        this.f27797d = (ImageView) view.findViewById(R.id.cancellation_protect_icon);
        this.f27798e = (TextView) view.findViewById(R.id.title_view);
        this.f27799f = (TextView) view.findViewById(R.id.subtitle_view);
        this.f27794a = abVar;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27796c = context;
        this.f27800g = (CJRTrainSummaryItem) iJRDataModel;
        this.f27795b = (CJRTrainOrderSummaryAction) this.f27800g.getItem();
        CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction = this.f27795b;
        if (cJRTrainOrderSummaryAction != null) {
            if (!TextUtils.isEmpty(cJRTrainOrderSummaryAction.getLabel())) {
                this.f27798e.setText(this.f27795b.getLabel());
            }
            if (this.f27795b.getImageUrl() != null) {
                String imageUrl = this.f27795b.getImageUrl();
                try {
                    if (URLUtil.isValidUrl(imageUrl)) {
                        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                        a2.f43753a = imageUrl;
                        b.a.C0750a.a(a2, this.f27797d, (com.paytm.utility.b.b.b) null, 2);
                    }
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
            if (!TextUtils.isEmpty(this.f27795b.getmTnc_text()) && !TextUtils.isEmpty(this.f27795b.getmTnc_url())) {
                String str = this.f27795b.getmText();
                String str2 = this.f27795b.getmTnc_text();
                this.f27795b.getmTnc_url();
                AnonymousClass1 r0 = new ClickableSpan() {
                    public final void onClick(View view) {
                        ai.this.f27794a.a(ai.this.f27795b, ah.CP_TnC);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(Color.parseColor("#E6FFFFFF"));
                    }
                };
                String str3 = str2 + AppUtility.CENTER_DOT;
                String str4 = str + ".  " + str3;
                int indexOf = str4.indexOf(str3);
                if (indexOf != -1) {
                    SpannableString spannableString = new SpannableString(str4);
                    spannableString.setSpan(r0, indexOf, str3.length() + indexOf, 33);
                    spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_00b9f5)), indexOf, str3.length() + indexOf, 33);
                    this.f27799f.setText(spannableString);
                    this.f27799f.setMovementMethod(LinkMovementMethod.getInstance());
                }
            } else if (!TextUtils.isEmpty(this.f27795b.getmText())) {
                this.f27799f.setText(this.f27795b.getmText());
            }
        }
    }
}
