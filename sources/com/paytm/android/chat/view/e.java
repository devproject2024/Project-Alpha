package com.paytm.android.chat.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f42571a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    f f42572b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        d dVar = (d) kotlin.a.k.a(this.f42571a, i2);
        if (dVar != null) {
            k.c(dVar, "item");
            RoboTextView roboTextView = (RoboTextView) aVar.f42573a.findViewById(R.id.txtTitle);
            k.a((Object) roboTextView, "view.txtTitle");
            roboTextView.setText(dVar.f42567a);
            b.b(aVar.f42573a.getContext()).a(dVar.f42568b).a((ImageView) (AppCompatImageView) aVar.f42573a.findViewById(R.id.imgIcon));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_viewholder_menu_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…menu_item, parent, false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f42571a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f42573a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f42574b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, View view) {
            super(view);
            k.c(view, "view");
            this.f42574b = eVar;
            this.f42573a = view;
            this.f42573a.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f42575a;

                {
                    this.f42575a = r1;
                }

                public final void onClick(View view) {
                    d dVar;
                    f fVar;
                    if (FastClickUtil.isFastClick() && (dVar = (d) kotlin.a.k.a(this.f42575a.f42574b.f42571a, this.f42575a.getAdapterPosition())) != null && (fVar = this.f42575a.f42574b.f42572b) != null) {
                        fVar.a(dVar);
                    }
                }
            });
        }
    }
}
