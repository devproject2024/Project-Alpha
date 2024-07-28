package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.y;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class bo implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f28041a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28042b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f28043c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f28044d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28045e;

    /* renamed from: f  reason: collision with root package name */
    TextView f28046f;

    /* renamed from: g  reason: collision with root package name */
    TextView f28047g;

    /* renamed from: h  reason: collision with root package name */
    Context f28048h;

    /* renamed from: i  reason: collision with root package name */
    y f28049i;
    View j;
    private String k = "CJRTrainTravellerViewHolder";

    public bo(Context context, View view, y yVar, View view2) {
        this.f28048h = context;
        this.f28049i = yVar;
        this.j = view2;
        this.f28041a = (TextView) view.findViewById(R.id.txt_traveller_name);
        this.f28043c = (LinearLayout) view.findViewById(R.id.btn_delete_traveller);
        this.f28043c.setOnClickListener(this);
        this.f28044d = (LinearLayout) view.findViewById(R.id.lyt_delete_traveller);
        LinearLayout linearLayout = this.f28044d;
        linearLayout.setX((float) linearLayout.getWidth());
        this.f28045e = (TextView) view.findViewById(R.id.txt_delete_traveller_title);
        this.f28046f = (TextView) view.findViewById(R.id.btn_delete_traveller_yes);
        this.f28046f.setOnClickListener(this);
        this.f28047g = (TextView) view.findViewById(R.id.btn_delete_traveller_no);
        this.f28047g.setOnClickListener(this);
        this.f28042b = (TextView) view.findViewById(R.id.txt_traveller_age);
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_delete_traveller) {
            String str = d.dG;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", b.n(this.f28048h) != null ? b.n(this.f28048h) : "");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/traveller-details");
                com.travel.train.b.a();
                com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, this.f28048h);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            this.f28044d.setVisibility(0);
            this.f28044d.setAnimation(AnimationUtils.loadAnimation(this.f28048h, R.anim.anim_traveller_delete));
        } else if (id == R.id.btn_delete_traveller_yes) {
            this.f28044d.setAnimation(AnimationUtils.loadAnimation(this.f28048h, R.anim.anim_traveller_delete_cancel));
            this.f28044d.setVisibility(8);
            this.f28049i.a((CJRTpUserProfileContact) this.f28044d.getTag(), this.j);
        } else if (id == R.id.btn_delete_traveller_no) {
            this.f28044d.setAnimation(AnimationUtils.loadAnimation(this.f28048h, R.anim.anim_traveller_delete_cancel));
            this.f28044d.setVisibility(8);
        }
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c2 : str.toCharArray()) {
            if (Character.isSpaceChar(c2)) {
                z = true;
            } else if (z) {
                c2 = Character.toTitleCase(c2);
                z = false;
            }
            sb.append(c2);
        }
        return sb.toString();
    }
}
