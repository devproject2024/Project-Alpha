package com.travel.bus.busticket.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.busticket.a.o;
import com.travel.bus.busticket.activity.AJRBusPhotoViewActivity;
import com.travel.bus.pojo.photos.CJRBusPhoto;
import java.util.ArrayList;

public final class o extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f21717a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRBusPhoto> f21718b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b.a.C0750a a2 = b.a(this.f21717a);
        a2.f43753a = this.f21718b.get(i2).getPhoto();
        b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity)), ((a) vVar).f21719a, (com.paytm.utility.b.b.b) null, 2);
    }

    public o(Context context, ArrayList<CJRBusPhoto> arrayList) {
        this.f21718b = arrayList;
        this.f21717a = context;
    }

    public final int getItemCount() {
        ArrayList<CJRBusPhoto> arrayList = this.f21718b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f21719a;

        public a(View view, ArrayList<CJRBusPhoto> arrayList) {
            super(view);
            this.f21719a = (ImageView) view.findViewById(R.id.bus_photo);
            this.f21719a.setOnClickListener(new View.OnClickListener(arrayList) {
                private final /* synthetic */ ArrayList f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    o.a.this.a(this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(ArrayList arrayList, View view) {
            Intent intent = new Intent(o.this.f21717a, AJRBusPhotoViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("photos", arrayList);
            bundle.putSerializable("photo_position", Integer.valueOf(getAdapterPosition()));
            intent.putExtras(bundle);
            o.this.f21717a.startActivity(intent);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bus_photos_view, viewGroup, false), this.f21718b);
    }
}
