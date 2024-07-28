package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.train.R;
import com.travel.train.i.b;
import com.travel.train.i.r;
import com.travel.train.model.trainticket.CJRTrainSmartIcons;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;

public final class bl extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f28021a;

    /* renamed from: b  reason: collision with root package name */
    CJRTrainSmartIcons f28022b;

    /* renamed from: c  reason: collision with root package name */
    r f28023c;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintLayout f28024d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f28025e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f28026f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f28027g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bl(View view, r rVar) {
        super(view);
        k.c(view, "itemV");
        k.c(rVar, "clickListener");
        this.f28023c = rVar;
        View findViewById = view.findViewById(R.id.grid_container_1);
        k.a((Object) findViewById, "itemV.findViewById(R.id.grid_container_1)");
        this.f28024d = (ConstraintLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_label);
        k.a((Object) findViewById2, "itemV.findViewById(R.id.tv_label)");
        this.f28025e = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.iv_smart_icon);
        k.a((Object) findViewById3, "itemV.findViewById(R.id.iv_smart_icon)");
        this.f28026f = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_title);
        k.a((Object) findViewById4, "itemV.findViewById(R.id.tv_title)");
        this.f28027g = (TextView) findViewById4;
        this.f28024d.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ bl f28028a;

            {
                this.f28028a = r1;
            }

            public final void onClick(View view) {
                bl blVar = this.f28028a;
                r rVar = blVar.f28023c;
                IJRDataModel iJRDataModel = blVar.f28022b;
                CJRTrainSmartIcons cJRTrainSmartIcons = blVar.f28022b;
                rVar.a(iJRDataModel, cJRTrainSmartIcons != null ? cJRTrainSmartIcons.getClickActionType() : null);
            }
        });
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        Context context2 = this.f28024d.getContext();
        k.a((Object) context2, "parentView.context");
        this.f28021a = context2;
        if (iJRDataModel != null) {
            this.f28022b = (CJRTrainSmartIcons) iJRDataModel;
            this.f28025e.setVisibility(8);
            TextView textView = this.f28027g;
            CJRTrainSmartIcons cJRTrainSmartIcons = this.f28022b;
            textView.setText(cJRTrainSmartIcons != null ? cJRTrainSmartIcons.getName() : null);
            CJRTrainSmartIcons cJRTrainSmartIcons2 = this.f28022b;
            if (URLUtil.isValidUrl(cJRTrainSmartIcons2 != null ? cJRTrainSmartIcons2.getImageUrl() : null)) {
                b.a aVar = com.paytm.utility.b.b.f43744a;
                Context context3 = this.f28021a;
                if (context3 == null) {
                    k.a("mContext");
                }
                b.a.C0750a a2 = b.a.a(context3);
                CJRTrainSmartIcons cJRTrainSmartIcons3 = this.f28022b;
                a2.f43753a = cJRTrainSmartIcons3 != null ? cJRTrainSmartIcons3.getImageUrl() : null;
                a2.m = true;
                Context context4 = this.f28021a;
                if (context4 == null) {
                    k.a("mContext");
                }
                Drawable a3 = androidx.core.content.b.a(context4, R.drawable.pre_t_oval_shape_home);
                if (a3 == null) {
                    k.a();
                }
                k.a((Object) a3, "ContextCompat.getDrawabl….pre_t_oval_shape_home)!!");
                b.a.C0750a b2 = a2.b(a3);
                Context context5 = this.f28021a;
                if (context5 == null) {
                    k.a("mContext");
                }
                Drawable a4 = androidx.core.content.b.a(context5, R.drawable.pre_t_oval_shape_home);
                if (a4 == null) {
                    k.a();
                }
                k.a((Object) a4, "ContextCompat.getDrawabl….pre_t_oval_shape_home)!!");
                b.a.C0750a.a(b2.a((Object) a4), this.f28026f, (com.paytm.utility.b.b.b) null, 2);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainSmartIcons");
    }
}
