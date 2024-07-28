package com.travel.flight.flightticket.j;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.g;
import com.travel.utils.n;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;

public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f25199a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f25200b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f25201c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25202d;

    /* renamed from: e  reason: collision with root package name */
    TextView f25203e;

    /* renamed from: f  reason: collision with root package name */
    TextView f25204f;

    /* renamed from: g  reason: collision with root package name */
    public Context f25205g;

    /* renamed from: h  reason: collision with root package name */
    g f25206h;

    /* renamed from: i  reason: collision with root package name */
    View f25207i;

    public q(Context context, View view, g gVar, View view2) {
        this.f25205g = context;
        this.f25206h = gVar;
        this.f25207i = view2;
        this.f25199a = (TextView) view.findViewById(R.id.txt_traveller_name);
        this.f25200b = (LinearLayout) view.findViewById(R.id.btn_delete_traveller);
        this.f25200b.setOnClickListener(this);
        this.f25201c = (LinearLayout) view.findViewById(R.id.lyt_delete_traveller);
        LinearLayout linearLayout = this.f25201c;
        linearLayout.setX((float) linearLayout.getWidth());
        this.f25202d = (TextView) view.findViewById(R.id.txt_delete_traveller_title);
        this.f25202d.setOnClickListener(this);
        this.f25203e = (TextView) view.findViewById(R.id.btn_delete_traveller_yes);
        this.f25203e.setOnClickListener(this);
        this.f25204f = (TextView) view.findViewById(R.id.btn_delete_traveller_no);
        this.f25204f.setOnClickListener(this);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) view.findViewById(R.id.delete_traveller_icon), "close_icon.png", false, false, n.a.V1);
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_delete_traveller) {
            this.f25201c.setVisibility(0);
            this.f25201c.setAnimation(AnimationUtils.loadAnimation(this.f25205g, R.anim.anim_traveller_delete));
        } else if (id == R.id.txt_delete_traveller_title) {
            this.f25201c.setAnimation(AnimationUtils.loadAnimation(this.f25205g, R.anim.anim_traveller_delete_cancel));
            this.f25201c.setVisibility(8);
        } else if (id == R.id.btn_delete_traveller_yes) {
            this.f25201c.setAnimation(AnimationUtils.loadAnimation(this.f25205g, R.anim.anim_traveller_delete_cancel));
            this.f25201c.setVisibility(8);
            this.f25206h.a((CJRTpUserProfileContact) this.f25201c.getTag(), this.f25207i);
        } else if (id == R.id.btn_delete_traveller_no) {
            this.f25201c.setAnimation(AnimationUtils.loadAnimation(this.f25205g, R.anim.anim_traveller_delete_cancel));
            this.f25201c.setVisibility(8);
        }
    }
}
