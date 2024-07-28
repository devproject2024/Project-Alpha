package com.paytm.android.chat.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.p4b.KybChannel;
import com.paytm.android.chat.e.d;
import com.paytm.android.chat.e.e;
import com.paytm.android.chat.view.b.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;

public final class h extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f41382a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f41383b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Object> f41384c;

    /* renamed from: d  reason: collision with root package name */
    private d f41385d;

    public h(Context context, ArrayList<Object> arrayList, d dVar) {
        k.c(context, "mContext");
        k.c(arrayList, "storeList");
        k.c(dVar, "itemClickListener");
        this.f41383b = context;
        this.f41384c = arrayList;
        this.f41385d = dVar;
        Object systemService = this.f41383b.getSystemService("layout_inflater");
        if (systemService != null) {
            this.f41382a = (LayoutInflater) systemService;
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == a.KYB_CHANNEL_LAYOUT.getIndex()) {
            LayoutInflater layoutInflater = this.f41382a;
            if (layoutInflater == null) {
                k.a();
            }
            View inflate = layoutInflater.inflate(R.layout.chat_kyb_channel_item, viewGroup, false);
            k.a((Object) inflate, "view");
            return new com.paytm.android.chat.view.b.a(inflate, this.f41385d);
        }
        LayoutInflater layoutInflater2 = this.f41382a;
        if (layoutInflater2 == null) {
            k.a();
        }
        View inflate2 = layoutInflater2.inflate(R.layout.chat_kyb_item, viewGroup, false);
        k.a((Object) inflate2, "view");
        return new b(inflate2, this.f41385d);
    }

    public final int getItemViewType(int i2) {
        if (this.f41384c.get(i2) instanceof KybChannel) {
            return a.KYB_CHANNEL_LAYOUT.getIndex();
        }
        return a.KYB_ITEM_LAYOUT.getIndex();
    }

    public final int getItemCount() {
        return this.f41384c.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        Object obj = this.f41384c.get(i2);
        k.a(obj, "storeList.get(position)");
        this.f41384c.size();
        ((e) vVar).a(obj, i2);
    }

    public enum a {
        KYB_ITEM_LAYOUT(123),
        KYB_CHANNEL_LAYOUT(234);
        
        private int index;

        private a(int i2) {
            this.index = i2;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }
}
