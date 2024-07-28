package com.travel.train.b;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.i.ab;
import com.travel.train.i.ai;
import com.travel.train.i.b;
import com.travel.train.i.f;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import com.travel.train.viewholder.ah;
import com.travel.train.viewholder.an;
import com.travel.train.viewholder.ap;
import com.travel.train.viewholder.as;
import com.travel.train.viewholder.at;
import com.travel.train.viewholder.bc;
import com.travel.train.viewholder.bd;
import com.travel.train.viewholder.be;
import com.travel.train.viewholder.bf;
import com.travel.train.viewholder.bi;
import com.travel.train.viewholder.bk;
import com.travel.train.viewholder.bm;
import com.travel.train.viewholder.bn;
import com.travel.train.viewholder.bq;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public final class al extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<? extends IJRDataModel> f26238a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f26239b;

    /* renamed from: c  reason: collision with root package name */
    private ab f26240c;

    /* renamed from: d  reason: collision with root package name */
    private f f26241d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26242e;

    public al(Activity activity, ArrayList<? extends IJRDataModel> arrayList, ab abVar, f fVar) {
        this.f26239b = activity;
        this.f26238a = arrayList;
        this.f26240c = abVar;
        this.f26241d = fVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        ai fromIndex = ai.fromIndex(i2);
        ab abVar = this.f26240c;
        f fVar = this.f26241d;
        switch (bf.AnonymousClass1.f27960a[fromIndex.ordinal()]) {
            case 1:
                return new be(bf.a(viewGroup, fromIndex), abVar);
            case 2:
                return new bc(bf.a(viewGroup, fromIndex), abVar);
            case 3:
                return new ah(bf.a(viewGroup, fromIndex), abVar, fVar);
            case 4:
                return new bn(bf.a(viewGroup, fromIndex), abVar);
            case 5:
                return new bm(bf.a(viewGroup, fromIndex), abVar);
            case 6:
                return new bi(bf.a(viewGroup, fromIndex), abVar);
            case 7:
                return new com.travel.train.viewholder.ai(bf.a(viewGroup, fromIndex), abVar);
            case 8:
                return new an(bf.a(viewGroup, fromIndex), abVar);
            case 9:
                return new as(bf.a(viewGroup, fromIndex), abVar);
            case 10:
                return new bk(bf.a(viewGroup, fromIndex), abVar);
            case 11:
                return new bd(bf.a(viewGroup, fromIndex), abVar);
            case 12:
                return new at(bf.a(viewGroup, fromIndex), abVar);
            case 13:
                return new ap(bf.a(viewGroup, fromIndex), abVar);
            default:
                return null;
        }
    }

    public final int getItemViewType(int i2) {
        ai aiVar;
        if (!this.f26242e || i2 < this.f26238a.size()) {
            aiVar = i2 < this.f26238a.size() ? ai.fromName(((CJRTrainSummaryItem) ((IJRDataModel) this.f26238a.get(i2))).getLayoutType()) : ai.IGNORE_LAYOUT;
        } else {
            aiVar = ai.FOOTER_PROGRESS_BAR;
        }
        return aiVar.getIndex();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (!(vVar instanceof bq)) {
            ((b) vVar).a(this.f26239b, (IJRDataModel) this.f26238a.get(i2), i2);
        }
    }

    public final int getItemCount() {
        int i2 = 0;
        if (this.f26242e) {
            ArrayList<? extends IJRDataModel> arrayList = this.f26238a;
            if (arrayList != null) {
                i2 = arrayList.size();
            }
            return i2 + 1;
        }
        ArrayList<? extends IJRDataModel> arrayList2 = this.f26238a;
        if (arrayList2 == null) {
            return 0;
        }
        return arrayList2.size();
    }
}
