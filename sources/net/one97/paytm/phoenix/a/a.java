package net.one97.paytm.phoenix.a;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.R;
import net.one97.paytm.phoenix.data.PhoenixMenuDialogItems;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    C1145a f59363a = this.f59365c;

    /* renamed from: b  reason: collision with root package name */
    private List<PhoenixMenuDialogItems> f59364b;

    /* renamed from: c  reason: collision with root package name */
    private C1145a f59365c;

    /* renamed from: net.one97.paytm.phoenix.a.a$a  reason: collision with other inner class name */
    public interface C1145a {
        void a(PhoenixMenuDialogItems phoenixMenuDialogItems);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        PhoenixMenuDialogItems phoenixMenuDialogItems;
        ImageView imageView;
        ImageView imageView2;
        View view;
        View view2;
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        List<PhoenixMenuDialogItems> list = this.f59364b;
        if (list != null && (phoenixMenuDialogItems = list.get(i2)) != null) {
            k.c(phoenixMenuDialogItems, "menuDialogSheetItems");
            bVar.f59368c = phoenixMenuDialogItems;
            TextView textView = bVar.f59367b;
            if (textView != null) {
                textView.setText(phoenixMenuDialogItems.getDescription());
            }
            if (i2 == 0 && Build.VERSION.SDK_INT <= 25 && (view2 = bVar.f59369d) != null) {
                view2.setVisibility(4);
            }
            if (i2 == bVar.f59370e.getItemCount() - 1 && (view = bVar.f59369d) != null) {
                view.setVisibility(4);
            }
            if (i2 == 0 && (imageView2 = bVar.f59366a) != null) {
                imageView2.setBackgroundResource(R.drawable.ic_invite_friends);
            }
            if (i2 == 1 && (imageView = bVar.f59366a) != null) {
                imageView.setBackgroundResource(R.drawable.ic_add_to_homescreen);
            }
            bVar.itemView.setOnClickListener(new c(phoenixMenuDialogItems, this, bVar, i2));
            if (i2 != 1) {
                return;
            }
            if (Build.VERSION.SDK_INT <= 25) {
                View view3 = bVar.itemView;
                k.a((Object) view3, "holder.itemView");
                view3.setVisibility(8);
                View view4 = bVar.itemView;
                k.a((Object) view4, "holder.itemView");
                view4.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
                View view5 = bVar.f59369d;
                if (view5 != null) {
                    view5.setVisibility(4);
                    return;
                }
                return;
            }
            View view6 = bVar.itemView;
            k.a((Object) view6, "holder.itemView");
            view6.setVisibility(0);
            View view7 = bVar.itemView;
            k.a((Object) view7, "holder.itemView");
            view7.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ph5_menu_dialog_item_layout, viewGroup, false);
        k.a((Object) inflate, "view");
        return new b(this, inflate);
    }

    public a(List<PhoenixMenuDialogItems> list, C1145a aVar) {
        k.c(aVar, "mListener");
        this.f59364b = list;
        this.f59365c = aVar;
    }

    public final int getItemCount() {
        List<PhoenixMenuDialogItems> list = this.f59364b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f59366a;

        /* renamed from: b  reason: collision with root package name */
        TextView f59367b;

        /* renamed from: c  reason: collision with root package name */
        PhoenixMenuDialogItems f59368c;

        /* renamed from: d  reason: collision with root package name */
        View f59369d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a f59370e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(view);
            k.c(view, "view");
            this.f59370e = aVar;
            this.f59366a = (ImageView) view.findViewById(R.id.ivItemImage);
            this.f59367b = (TextView) view.findViewById(R.id.tvItemText);
            this.f59369d = view.findViewById(R.id.lineView);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixMenuDialogItems f59371a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f59372b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f59373c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f59374d;

        c(PhoenixMenuDialogItems phoenixMenuDialogItems, a aVar, b bVar, int i2) {
            this.f59371a = phoenixMenuDialogItems;
            this.f59372b = aVar;
            this.f59373c = bVar;
            this.f59374d = i2;
        }

        public final void onClick(View view) {
            this.f59372b.f59363a.a(this.f59371a);
        }
    }
}
