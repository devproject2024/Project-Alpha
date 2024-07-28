package com.travel.bus.busticket.e;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.b.f;
import com.travel.bus.pojo.common.entity.travel.CJRBusTpUserProfileContact;
import java.util.Map;
import net.one97.paytm.common.utility.d;

public final class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f22197a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f22198b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22199c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22200d;

    /* renamed from: e  reason: collision with root package name */
    TextView f22201e;

    /* renamed from: f  reason: collision with root package name */
    TextView f22202f;

    /* renamed from: g  reason: collision with root package name */
    public Context f22203g;

    /* renamed from: h  reason: collision with root package name */
    ImageView f22204h;

    /* renamed from: i  reason: collision with root package name */
    f f22205i;
    View j;

    public p(Context context, View view, f fVar, View view2) {
        this.f22203g = context;
        this.f22205i = fVar;
        this.j = view2;
        this.f22204h = (ImageView) view.findViewById(R.id.close_bus_traveller);
        this.f22204h.setImageResource(R.drawable.bus_close_normal);
        this.f22197a = (TextView) view.findViewById(R.id.txt_traveller_name);
        this.f22198b = (LinearLayout) view.findViewById(R.id.btn_delete_traveller);
        this.f22198b.setOnClickListener(this);
        this.f22199c = (LinearLayout) view.findViewById(R.id.lyt_delete_traveller);
        LinearLayout linearLayout = this.f22199c;
        linearLayout.setX((float) linearLayout.getWidth());
        this.f22200d = (TextView) view.findViewById(R.id.txt_delete_traveller_title);
        this.f22201e = (TextView) view.findViewById(R.id.btn_delete_traveller_yes);
        this.f22201e.setOnClickListener(this);
        this.f22202f = (TextView) view.findViewById(R.id.btn_delete_traveller_no);
        this.f22202f.setOnClickListener(this);
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_delete_traveller) {
            this.f22199c.setVisibility(0);
            this.f22199c.setAnimation(AnimationUtils.loadAnimation(this.f22203g, R.anim.pre_b_anim_traveller_delete));
            a.a();
            a.b().a(d.cH, (Map<String, Object>) null, this.f22203g);
        } else if (id == R.id.btn_delete_traveller_yes) {
            this.f22199c.setAnimation(AnimationUtils.loadAnimation(this.f22203g, R.anim.pre_b_anim_traveller_delete_cancel));
            this.f22199c.setVisibility(8);
            this.f22205i.a((CJRBusTpUserProfileContact) this.f22199c.getTag(), this.j);
        } else if (id == R.id.btn_delete_traveller_no) {
            this.f22199c.setAnimation(AnimationUtils.loadAnimation(this.f22203g, R.anim.pre_b_anim_traveller_delete_cancel));
            this.f22199c.setVisibility(8);
        }
    }
}
