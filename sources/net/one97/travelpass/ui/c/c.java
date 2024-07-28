package net.one97.travelpass.ui.c;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.d;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.e.e;

public final class c extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f30625a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30626b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_benefits_internal);
        if (recyclerView != null) {
            this.f30625a = recyclerView;
            TextView textView = (TextView) view.findViewById(R.id.header_title);
            this.f30626b = !(textView instanceof TextView) ? null : textView;
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void a(Context context, int i2, j jVar, com.one97.travelpass.a.c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        CharSequence l = jVar.l();
        if (!(l == null || l.length() == 0)) {
            TextView textView = this.f30626b;
            if (textView != null) {
                textView.setText(jVar.l());
            }
            TextView textView2 = this.f30626b;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        } else {
            TextView textView3 = this.f30626b;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        ArrayList<j> a2 = jVar.a();
        k.a((Object) a2, "viewHolderModel.viewHolderData");
        net.one97.travelpass.a.c cVar2 = new net.one97.travelpass.a.c(context, a2, cVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        RecyclerView recyclerView = this.f30625a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.f30625a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cVar2);
        }
        RecyclerView recyclerView3 = this.f30625a;
        if ((recyclerView3 != null ? recyclerView3.getOnFlingListener() : null) == null) {
            new e().attachToRecyclerView(this.f30625a);
        }
    }
}
