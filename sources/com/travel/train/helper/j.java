package com.travel.train.helper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.travel.train.R;
import com.travel.train.b.ap;
import com.travel.train.model.trainticket.CJRTrainQuota;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public int f27320a;

    /* renamed from: b  reason: collision with root package name */
    ap.a f27321b;

    /* renamed from: c  reason: collision with root package name */
    a f27322c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f27323d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRTrainQuota> f27324e;

    public interface a {
        void c(ap.a aVar, int i2);
    }

    public j(Activity activity, ap.a aVar, ArrayList<CJRTrainQuota> arrayList, a aVar2) {
        k.c(activity, "mContext");
        k.c(aVar, "mHolder");
        k.c(arrayList, "mQuotaList");
        this.f27323d = activity;
        this.f27321b = aVar;
        this.f27324e = arrayList;
        this.f27322c = aVar2;
        ArrayList<CJRTrainQuota> arrayList2 = this.f27324e;
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.f27321b.f26272d.removeAllViews();
            LinearLayout linearLayout = this.f27321b.f26272d;
            k.a((Object) linearLayout, "mHolder.mQuotaInnerLayout");
            linearLayout.setWeightSum((float) this.f27324e.size());
            int i2 = 0;
            int size = this.f27324e.size() - 1;
            if (size >= 0) {
                while (true) {
                    View a2 = a(i2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams.weight = 1.0f;
                    layoutParams.leftMargin = com.paytm.utility.b.a(10.0f, (Context) this.f27323d);
                    a2.setLayoutParams(layoutParams);
                    this.f27321b.f26272d.addView(a2);
                    if (i2 != size) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private View a(int i2) {
        View inflate = LayoutInflater.from(this.f27323d).inflate(R.layout.pre_t_train_quota_type_list_item, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.quota_type_text);
        CJRTrainQuota cJRTrainQuota = this.f27324e.get(i2);
        k.a((Object) cJRTrainQuota, "mQuotaList.get(quotaPosition)");
        CJRTrainQuota cJRTrainQuota2 = cJRTrainQuota;
        if (textView != null) {
            textView.setText(cJRTrainQuota2.getQuotaName());
        }
        if (textView != null) {
            textView.setOnClickListener(new b(this, i2));
        }
        a(this.f27321b, i2, i2 == 0);
        k.a((Object) inflate, "itemView");
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f27325a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f27326b;

        b(j jVar, int i2) {
            this.f27325a = jVar;
            this.f27326b = i2;
        }

        public final void onClick(View view) {
            a aVar = this.f27325a.f27322c;
            if (aVar != null) {
                aVar.c(this.f27325a.f27321b, this.f27326b);
            }
        }
    }

    public final void a(ap.a aVar, int i2, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        k.c(aVar, "mHolder");
        try {
            CJRTrainQuota cJRTrainQuota = this.f27324e.get(i2);
            k.a((Object) cJRTrainQuota, "mQuotaList[pos]");
            cJRTrainQuota.setIsSelected(z);
            if (z) {
                this.f27320a = i2;
            }
            View childAt = aVar.f26272d.getChildAt(i2);
            k.a((Object) childAt, "mHolder.mQuotaInnerLayout.getChildAt(pos)");
            childAt.setSelected(z);
            if (z) {
                View childAt2 = aVar.f26272d.getChildAt(i2);
                if (childAt2 != null && (imageView2 = (ImageView) childAt2.findViewById(R.id.quota_type_divider)) != null) {
                    imageView2.setVisibility(0);
                    return;
                }
                return;
            }
            View childAt3 = aVar.f26272d.getChildAt(i2);
            if (childAt3 != null && (imageView = (ImageView) childAt3.findViewById(R.id.quota_type_divider)) != null) {
                imageView.setVisibility(4);
            }
        } catch (Exception unused) {
        }
    }
}
