package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.b;
import com.travel.train.i.u;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRNearByStation;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;

public final class q extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    CJRNearByStation f28200a;

    /* renamed from: b  reason: collision with root package name */
    u f28201b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f28202c = ((TextView) this.f28208i.findViewById(R.id.tv_source_name));

    /* renamed from: d  reason: collision with root package name */
    private TextView f28203d = ((TextView) this.f28208i.findViewById(R.id.tv_destination_name));

    /* renamed from: e  reason: collision with root package name */
    private TextView f28204e = ((TextView) this.f28208i.findViewById(R.id.tv_src_distance));

    /* renamed from: f  reason: collision with root package name */
    private TextView f28205f = ((TextView) this.f28208i.findViewById(R.id.tv_dest_distance));

    /* renamed from: g  reason: collision with root package name */
    private TextView f28206g = ((TextView) this.f28208i.findViewById(R.id.tv_number_of_trains));

    /* renamed from: h  reason: collision with root package name */
    private Context f28207h = this.f28208i.getContext();

    /* renamed from: i  reason: collision with root package name */
    private View f28208i;
    private CJRTrainSearchInput j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(View view, CJRTrainSearchInput cJRTrainSearchInput, u uVar) {
        super(view);
        k.c(view, "parentView");
        k.c(cJRTrainSearchInput, "mTrainSearchInput");
        this.f28208i = view;
        this.j = cJRTrainSearchInput;
        this.f28201b = uVar;
        this.f28208i.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ q f28209a;

            {
                this.f28209a = r1;
            }

            public final void onClick(View view) {
                if (this.f28209a.f28201b != null) {
                    u uVar = this.f28209a.f28201b;
                    if (uVar == null) {
                        k.a();
                    }
                    uVar.a(this.f28209a.f28200a);
                }
            }
        });
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        TextView textView;
        TextView textView2;
        if (iJRDataModel != null && (iJRDataModel instanceof CJRNearByStation)) {
            this.f28200a = (CJRNearByStation) iJRDataModel;
            CJRNearByStation cJRNearByStation = this.f28200a;
            if (cJRNearByStation == null) {
                k.a();
            }
            if (!TextUtils.isEmpty(cJRNearByStation.getSrcName()) && (textView2 = this.f28202c) != null) {
                StringBuilder sb = new StringBuilder();
                CJRNearByStation cJRNearByStation2 = this.f28200a;
                if (cJRNearByStation2 == null) {
                    k.a();
                }
                sb.append(cJRNearByStation2.getSrcName());
                sb.append("(");
                CJRNearByStation cJRNearByStation3 = this.f28200a;
                if (cJRNearByStation3 == null) {
                    k.a();
                }
                sb.append(cJRNearByStation3.getSrcCode());
                sb.append(")");
                textView2.setText(sb.toString());
            }
            CJRNearByStation cJRNearByStation4 = this.f28200a;
            if (cJRNearByStation4 == null) {
                k.a();
            }
            if (!TextUtils.isEmpty(cJRNearByStation4.getDestName()) && (textView = this.f28203d) != null) {
                StringBuilder sb2 = new StringBuilder();
                CJRNearByStation cJRNearByStation5 = this.f28200a;
                if (cJRNearByStation5 == null) {
                    k.a();
                }
                sb2.append(cJRNearByStation5.getDestName());
                sb2.append("(");
                CJRNearByStation cJRNearByStation6 = this.f28200a;
                if (cJRNearByStation6 == null) {
                    k.a();
                }
                sb2.append(cJRNearByStation6.getDestCode());
                sb2.append(")");
                textView.setText(sb2.toString());
            }
            String str = this.j.getmSourceCityCode();
            CJRNearByStation cJRNearByStation7 = this.f28200a;
            if (cJRNearByStation7 == null) {
                k.a();
            }
            if (p.a(str, cJRNearByStation7.getSrcCode(), true)) {
                TextView textView3 = this.f28204e;
                if (textView3 != null) {
                    Context context2 = this.f28207h;
                    if (context2 == null) {
                        k.a();
                    }
                    textView3.setText(context2.getString(R.string.same_source));
                }
                TextView textView4 = this.f28204e;
                if (textView4 != null) {
                    Context context3 = this.f28207h;
                    if (context3 == null) {
                        k.a();
                    }
                    textView4.setTextColor(context3.getResources().getColor(R.color.color_a9a9a9));
                }
            } else {
                CJRNearByStation cJRNearByStation8 = this.f28200a;
                if (cJRNearByStation8 == null) {
                    k.a();
                }
                if (!TextUtils.isEmpty(cJRNearByStation8.getD1())) {
                    TextView textView5 = this.f28204e;
                    if (textView5 != null) {
                        CJRNearByStation cJRNearByStation9 = this.f28200a;
                        if (cJRNearByStation9 == null) {
                            k.a();
                        }
                        textView5.setText(cJRNearByStation9.getD1());
                    }
                    TextView textView6 = this.f28204e;
                    if (textView6 != null) {
                        Context context4 = this.f28207h;
                        if (context4 == null) {
                            k.a();
                        }
                        textView6.setTextColor(context4.getResources().getColor(R.color.color_da9800));
                    }
                }
            }
            String str2 = this.j.getmDestCityCode();
            CJRNearByStation cJRNearByStation10 = this.f28200a;
            if (cJRNearByStation10 == null) {
                k.a();
            }
            if (p.a(str2, cJRNearByStation10.getDestCode(), true)) {
                TextView textView7 = this.f28205f;
                if (textView7 != null) {
                    Context context5 = this.f28207h;
                    if (context5 == null) {
                        k.a();
                    }
                    textView7.setText(context5.getString(R.string.same_destination));
                }
                TextView textView8 = this.f28205f;
                if (textView8 != null) {
                    Context context6 = this.f28207h;
                    if (context6 == null) {
                        k.a();
                    }
                    textView8.setTextColor(context6.getResources().getColor(R.color.color_a9a9a9));
                    return;
                }
                return;
            }
            CJRNearByStation cJRNearByStation11 = this.f28200a;
            if (cJRNearByStation11 == null) {
                k.a();
            }
            if (!TextUtils.isEmpty(cJRNearByStation11.getD2())) {
                TextView textView9 = this.f28205f;
                if (textView9 != null) {
                    CJRNearByStation cJRNearByStation12 = this.f28200a;
                    if (cJRNearByStation12 == null) {
                        k.a();
                    }
                    textView9.setText(cJRNearByStation12.getD2());
                }
                TextView textView10 = this.f28205f;
                if (textView10 != null) {
                    Context context7 = this.f28207h;
                    if (context7 == null) {
                        k.a();
                    }
                    textView10.setTextColor(context7.getResources().getColor(R.color.color_da9800));
                }
            }
        }
    }
}
