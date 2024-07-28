package com.travel.bus.orders.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.pojo.photos.BoardingPhoto;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public String f22547a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BoardingPhoto> f22548b;

    /* renamed from: c  reason: collision with root package name */
    final FragmentActivity f22549c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22550d = 4;

    /* renamed from: com.travel.bus.orders.a.a$a  reason: collision with other inner class name */
    enum C0440a {
        PHOTO,
        FOOTER
    }

    public a(ArrayList<BoardingPhoto> arrayList, FragmentActivity fragmentActivity) {
        k.c(arrayList, "photos");
        k.c(fragmentActivity, "activity");
        this.f22548b = arrayList;
        this.f22549c = fragmentActivity;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == C0440a.PHOTO.ordinal()) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo_boardin_point, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…din_point, parent, false)");
            return new com.travel.bus.orders.i.b(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_footer_bp_photos, viewGroup, false);
        k.a((Object) inflate2, "LayoutInflater.from(pare…bp_photos, parent, false)");
        return new com.travel.bus.orders.i.a(inflate2);
    }

    public final int getItemViewType(int i2) {
        return (i2 == this.f22550d ? C0440a.FOOTER : C0440a.PHOTO).ordinal();
    }

    public final int getItemCount() {
        int size = this.f22548b.size();
        int i2 = this.f22550d;
        return size > i2 ? i2 + 1 : this.f22548b.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof com.travel.bus.orders.i.b) {
            com.travel.bus.orders.i.b bVar = (com.travel.bus.orders.i.b) vVar;
            BoardingPhoto boardingPhoto = this.f22548b.get(i2);
            k.a((Object) boardingPhoto, "photos[position]");
            String thumbnail = boardingPhoto.getThumbnail();
            k.a((Object) thumbnail, "photos[position].thumbnail");
            k.c(thumbnail, "item");
            b.a aVar = com.paytm.utility.b.b.f43744a;
            Context context = bVar.f22647a.getContext();
            k.a((Object) context, "ivPhoto.context");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = thumbnail;
            a2.l = true;
            a2.M = true;
            b.a.C0750a.a(a2.a(com.paytm.utility.b.b.a.AUTOMATIC).a(30, b.a.ALL), bVar.f22647a, (com.paytm.utility.b.b.b) null, 2);
        } else if (vVar instanceof com.travel.bus.orders.i.a) {
            int size = this.f22548b.size() - this.f22550d;
            TextView textView = ((com.travel.bus.orders.i.a) vVar).f22646a;
            textView.setText("+" + size + " More");
        }
        vVar.itemView.setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22551a;

        b(a aVar) {
            this.f22551a = aVar;
        }

        public final void onClick(View view) {
            com.travel.bus.orders.c.b bVar = new com.travel.bus.orders.c.b(this.f22551a.f22548b, this.f22551a.f22547a);
            FragmentActivity fragmentActivity = this.f22551a.f22549c;
            bVar.show(fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null, "PhotosBottomSheet");
        }
    }
}
