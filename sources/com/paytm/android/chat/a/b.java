package com.paytm.android.chat.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.view.AttachBottomSheet;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class b extends RecyclerView.a<C0688b> {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f41037a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    final AttachBottomSheet.a f41038b;

    public b(AttachBottomSheet.a aVar) {
        k.c(aVar, "listener");
        this.f41038b = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0688b bVar = (C0688b) vVar;
        k.c(bVar, "holder");
        a aVar = (a) kotlin.a.k.a(this.f41037a, i2);
        if (aVar != null) {
            k.c(aVar, "dataHolder");
            TextView textView = (TextView) bVar.f41041a.findViewById(R.id.tv_item_multi_view_name);
            k.a((Object) textView, "view.tv_item_multi_view_name");
            textView.setText(aVar.f41039a);
            int i3 = aVar.f41040b;
            Context context = bVar.f41041a.getContext();
            k.a((Object) context, "view.context");
            ((TextView) bVar.f41041a.findViewById(R.id.tv_item_multi_view_name)).setTextColor(context.getResources().getColor(R.color.color_1D2F54));
            ((ImageView) bVar.f41041a.findViewById(R.id.iv_item_multi_view_icon)).setImageResource(i3);
            if (i2 == bVar.f41042b.f41037a.size() - 1) {
                View findViewById = bVar.f41041a.findViewById(R.id.divider);
                k.a((Object) findViewById, "view.divider");
                findViewById.setVisibility(8);
                return;
            }
            View findViewById2 = bVar.f41041a.findViewById(R.id.divider);
            k.a((Object) findViewById2, "view.divider");
            findViewById2.setVisibility(0);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_multi_funtion_view, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…tion_view, parent, false)");
        return new C0688b(this, inflate);
    }

    public final int getItemCount() {
        return this.f41037a.size();
    }

    /* renamed from: com.paytm.android.chat.a.b$b  reason: collision with other inner class name */
    public final class C0688b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f41041a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f41042b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0688b(b bVar, View view) {
            super(view);
            k.c(view, "view");
            this.f41042b = bVar;
            this.f41041a = view;
            this.itemView.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C0688b f41043a;

                {
                    this.f41043a = r1;
                }

                public final void onClick(View view) {
                    a aVar = (a) kotlin.a.k.a(this.f41043a.f41042b.f41037a, this.f41043a.getAdapterPosition());
                    if (aVar != null) {
                        this.f41043a.f41042b.f41038b.a(aVar, aVar.f41039a);
                    }
                }
            });
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f41039a;

        /* renamed from: b  reason: collision with root package name */
        int f41040b;

        public a(String str, int i2) {
            k.c(str, "title");
            this.f41039a = str;
            this.f41040b = i2;
        }
    }
}
