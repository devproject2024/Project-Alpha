package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.a;
import com.travel.train.model.CJROfferItems;

public final class aw extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f27881a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27882b;

    /* renamed from: c  reason: collision with root package name */
    public CJROfferItems f27883c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f27884d;

    /* renamed from: e  reason: collision with root package name */
    private a f27885e;

    public aw(Context context, View view, a aVar) {
        super(view);
        this.f27882b = context;
        this.f27885e = aVar;
        this.f27881a = (ImageView) view.findViewById(R.id.image_view_banner_logo);
        this.f27884d = (ImageView) view.findViewById(R.id.image_view_close);
        this.f27884d.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f27881a.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, 0);
        this.f27881a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aw.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar = this.f27885e;
        if (aVar != null) {
            aVar.onBannerClick(this.f27883c, 0);
        }
    }
}
