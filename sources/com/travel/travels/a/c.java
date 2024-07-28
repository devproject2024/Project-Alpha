package com.travel.travels.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.R;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f28436a;

    /* renamed from: b  reason: collision with root package name */
    private Context f28437b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f28438c;

    public c(Context context, List<String> list) {
        k.c(list, "arrayList");
        this.f28436a = list;
        this.f28438c = Integer.valueOf(list.size());
        this.f28437b = context;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "viewHolder");
        TextView textView = aVar.f28439a;
        if (textView == null) {
            k.a();
        }
        textView.setText(this.f28436a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f28437b).inflate(R.layout.vh_offer_tc_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(mCon…_tc_item,viewGroup,false)");
        return new a(inflate);
    }

    public final int getItemCount() {
        Integer num = this.f28438c;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f28439a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "view");
            View findViewById = view.findViewById(R.id.tv_title);
            if (findViewById != null) {
                this.f28439a = (TextView) findViewById;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
