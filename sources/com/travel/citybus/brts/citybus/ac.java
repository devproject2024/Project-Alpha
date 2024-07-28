package com.travel.citybus.brts.citybus;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.citybus.R;
import com.travel.citybus.brts.model.CitybusQrCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class ac extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f23275a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<CitybusQrCode> f23276b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CitybusQrCode citybusQrCode = this.f23276b.get(i2);
        k.a((Object) citybusQrCode, "list[position]");
        List<String> qrstrings = citybusQrCode.getQrstrings();
        if (qrstrings != null && qrstrings.size() > 0) {
            int size = qrstrings.size();
            for (int i3 = 0; i3 < size; i3++) {
                aVar.f23277a.setImageBitmap(com.google.zxing.client.android.d.a.a(qrstrings.get(i3), a(this.f23275a), a(this.f23275a), false));
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bcll_qr_items, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…           parent, false)");
        return new a(inflate);
    }

    public ac(Activity activity, ArrayList<CitybusQrCode> arrayList) {
        k.c(activity, "context");
        k.c(arrayList, "list");
        this.f23275a = activity;
        this.f23276b = arrayList;
    }

    public final int getItemCount() {
        return this.f23276b.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final AppCompatImageView f23277a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.e_qr_image);
            if (appCompatImageView != null) {
                this.f23277a = appCompatImageView;
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        }
    }

    private static int a(Activity activity) {
        Resources resources = activity.getResources();
        k.a((Object) resources, "context.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        k.a((Object) displayMetrics, "resources.displayMetrics");
        return (int) ((((float) displayMetrics.densityDpi) / 160.0f) * 144.0f);
    }
}
