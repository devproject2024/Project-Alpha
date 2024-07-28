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
import net.one97.travelpass.ui.c.j;

public final class v extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f30444a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30445b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30446c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_benefits);
        if (recyclerView != null) {
            this.f30444a = recyclerView;
            TextView textView = (TextView) view.findViewById(R.id.header_title);
            if (textView != null) {
                this.f30445b = textView;
                TextView textView2 = (TextView) view.findViewById(R.id.selected_pass_text);
                if (textView2 != null) {
                    this.f30446c = textView2;
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        TextView textView = this.f30445b;
        if (textView != null) {
            textView.setText(jVar.l());
        }
        CharSequence m = jVar.m();
        if (!(m == null || m.length() == 0)) {
            TextView textView2 = this.f30446c;
            if (textView2 != null) {
                textView2.setText(jVar.m());
            }
            TextView textView3 = this.f30446c;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else {
            TextView textView4 = this.f30446c;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        ArrayList<j> a2 = jVar.a();
        k.a((Object) a2, "viewHolderModel.viewHolderData");
        net.one97.travelpass.a.c cVar2 = new net.one97.travelpass.a.c(context, a2, cVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        RecyclerView recyclerView = this.f30444a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.f30444a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cVar2);
        }
        RecyclerView recyclerView3 = this.f30444a;
        if (recyclerView3 != null) {
            recyclerView3.addOnScrollListener(new a(this, jVar, cVar));
        }
    }

    public static final class a extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f30447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f30449c;

        a(v vVar, j jVar, c cVar) {
            this.f30447a = vVar;
            this.f30448b = jVar;
            this.f30449c = cVar;
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                RecyclerView recyclerView2 = this.f30447a.f30444a;
                RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
                if (layoutManager != null) {
                    int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    int size = this.f30448b.a().size();
                    if (findLastVisibleItemPosition < size && size > 0) {
                        Integer valueOf = Integer.valueOf(findLastVisibleItemPosition);
                        net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                        this.f30449c.onItemClickedItem(this.f30448b.a().get(findLastVisibleItemPosition), valueOf, Integer.valueOf(net.one97.travelpass.ui.a.c()));
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        }
    }
}
