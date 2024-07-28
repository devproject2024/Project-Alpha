package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ui.b.b;
import net.one97.travelpass.ui.c.j;

public final class q extends RecyclerView.v implements c, d {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f30401a;

    /* renamed from: b  reason: collision with root package name */
    private c f30402b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<j> f30403c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.travelpass.a.c f30404d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f30405e;

    /* renamed from: f  reason: collision with root package name */
    private j f30406f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f30407g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30405e = -1;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_faq_details);
        if (recyclerView != null) {
            this.f30401a = recyclerView;
            TextView textView = (TextView) view.findViewById(R.id.header_text);
            if (textView != null) {
                this.f30407g = textView;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void onItemClickedItem(j jVar, Integer num, Integer num2) {
        ArrayList<j> arrayList;
        if ((num == null || num.intValue() != -1) && (arrayList = this.f30403c) != null && this.f30404d != null) {
            if (arrayList == null) {
                k.a();
            }
            if (num == null) {
                k.a();
            }
            j jVar2 = arrayList.get(num.intValue());
            k.a((Object) jVar2, "viewHolderDataList!!.get(position!!)");
            j jVar3 = jVar2;
            ArrayList<j> arrayList2 = this.f30403c;
            if (arrayList2 == null) {
                k.a();
            }
            j jVar4 = arrayList2.get(num.intValue());
            k.a((Object) jVar4, "viewHolderDataList!!.get(position!!)");
            jVar3.a(!jVar4.h());
            net.one97.travelpass.a.c cVar = this.f30404d;
            if (cVar != null) {
                cVar.notifyItemChanged(num.intValue());
            }
            c cVar2 = this.f30402b;
            if (cVar2 != null) {
                cVar2.onItemClickedItem(jVar, num, num2);
            }
        }
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        int i3;
        TextView textView;
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        this.f30402b = cVar;
        this.f30406f = jVar;
        this.f30403c = jVar.a();
        this.f30405e = Integer.valueOf(i2);
        ArrayList<j> arrayList = this.f30403c;
        if (arrayList == null) {
            k.a();
        }
        this.f30404d = new net.one97.travelpass.a.c(context, arrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        RecyclerView recyclerView = this.f30401a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.f30401a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f30404d);
        }
        b c2 = jVar.c();
        k.a((Object) c2, "viewHolderModel.getmType()");
        k.c(c2, "type");
        if (c2 == b.TRAVEL_PASS_FAQ) {
            i3 = R.string.travel_pass_faq;
        } else {
            i3 = -1;
        }
        if (i3 != -1 && (textView = this.f30407g) != null) {
            textView.setText(i3);
        }
    }
}
