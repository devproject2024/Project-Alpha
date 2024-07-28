package com.travel.train.b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.i.af;
import com.travel.train.i.b;
import com.travel.train.i.r;
import com.travel.train.model.trainticket.CJRTrainSmartIcons;
import com.travel.train.viewholder.au;
import com.travel.train.viewholder.av;
import com.travel.train.viewholder.bl;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class ae extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRTrainSmartIcons> f26200a;

    /* renamed from: b  reason: collision with root package name */
    private r f26201b;

    /* renamed from: c  reason: collision with root package name */
    private Context f26202c;

    public ae(Context context, ArrayList<CJRTrainSmartIcons> arrayList, r rVar) {
        this.f26202c = context;
        this.f26200a = arrayList;
        this.f26201b = rVar;
    }

    public final void a(ArrayList<CJRTrainSmartIcons> arrayList) {
        this.f26200a = arrayList;
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        af afVar;
        af.a aVar = af.Companion;
        af[] values = af.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                afVar = af.IGNORE_LAYOUT;
                break;
            }
            afVar = values[i3];
            if (afVar.getIndex() == i2) {
                break;
            }
            i3++;
        }
        au.a aVar2 = au.f27878a;
        r rVar = this.f26201b;
        k.c(viewGroup, "parent");
        k.c(afVar, "cardType");
        k.c(rVar, "clickListener");
        if (av.f27879a[afVar.ordinal()] != 1) {
            return new bl(au.a.a(viewGroup, afVar), rVar);
        }
        return new bl(au.a.a(viewGroup, afVar), rVar);
    }

    public final int getItemViewType(int i2) {
        return af.SMART_ICON_TYPE.getIndex();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((b) vVar).a(this.f26202c, this.f26200a.get(i2), i2);
    }

    public final int getItemCount() {
        ArrayList<CJRTrainSmartIcons> arrayList = this.f26200a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
