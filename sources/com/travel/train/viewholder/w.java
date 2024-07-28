package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.helper.i;
import com.travel.train.i.g;
import com.travel.train.model.trainticket.CJRTrainGstDetails;
import net.one97.paytm.common.utility.d;

public final class w extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public CJRTrainGstDetails f28269a;

    /* renamed from: b  reason: collision with root package name */
    public CheckBox f28270b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28271c;

    /* renamed from: d  reason: collision with root package name */
    private g f28272d;

    /* renamed from: e  reason: collision with root package name */
    private i f28273e;

    /* renamed from: f  reason: collision with root package name */
    private View f28274f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f28275g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f28276h;

    /* renamed from: i  reason: collision with root package name */
    private RoboTextView f28277i;
    private ImageView j;
    private boolean k;

    public w(View view, g gVar, i iVar, boolean z, CJRTrainGstDetails cJRTrainGstDetails) {
        super(view);
        this.f28271c = view.getContext();
        this.f28272d = gVar;
        this.k = z;
        this.f28273e = iVar;
        this.f28269a = cJRTrainGstDetails;
        this.f28274f = view.findViewById(R.id.trains_gst_lyt);
        this.f28275g = (RelativeLayout) view.findViewById(R.id.gst_parent_lyt);
        this.f28276h = (TextView) view.findViewById(R.id.gst_view_header);
        this.f28277i = (RoboTextView) view.findViewById(R.id.gst_view_sub_text);
        this.f28270b = (CheckBox) view.findViewById(R.id.gst_check);
        this.j = (ImageView) view.findViewById(R.id.iv_gst_arrow);
        this.f28275g.setOnClickListener(this);
        this.f28274f.setVisibility(this.k ? 0 : 8);
        a();
        this.f28270b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            }
        });
    }

    public final void a() {
        String string = this.f28271c.getString(R.string.optional);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f28269a.getGstIn()) || !TextUtils.isEmpty(this.f28269a.getNameOnGst()) || !TextUtils.isEmpty(this.f28269a.getFlat())) {
            if (!TextUtils.isEmpty(this.f28269a.getGstIn())) {
                sb.append(this.f28269a.getGstIn().trim());
            }
            if (!TextUtils.isEmpty(this.f28269a.getNameOnGst())) {
                if (!TextUtils.isEmpty(sb)) {
                    sb.append(AppConstants.COMMA);
                }
                sb.append(this.f28269a.getNameOnGst().trim());
            }
            if (!TextUtils.isEmpty(this.f28269a.getFlat())) {
                if (!TextUtils.isEmpty(sb)) {
                    sb.append(AppConstants.COMMA);
                }
                sb.append(this.f28269a.getFlat().trim());
            }
            if (!TextUtils.isEmpty(sb)) {
                if (!TextUtils.isEmpty(sb)) {
                    sb.append(AppConstants.COMMA);
                }
                string = v.a(sb.toString());
            }
            if (!TextUtils.isEmpty(sb)) {
                this.f28276h.setText(this.f28271c.getString(R.string.train_gst_details));
            } else {
                this.f28276h.setText(this.f28271c.getString(R.string.train_gst_details_txt));
            }
            this.f28277i.setText(string);
            return;
        }
        this.f28276h.setText(this.f28271c.getString(R.string.train_gst_details_txt));
        this.f28277i.setText(string);
    }

    public final boolean b() {
        CJRTrainGstDetails cJRTrainGstDetails = this.f28269a;
        if (cJRTrainGstDetails == null || TextUtils.isEmpty(cJRTrainGstDetails.getGstIn()) || TextUtils.isEmpty(this.f28269a.getNameOnGst()) || TextUtils.isEmpty(this.f28269a.getFlat()) || TextUtils.isEmpty(this.f28269a.getStreet())) {
            return true;
        }
        return false;
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.gst_parent_lyt) {
            this.f28273e.a(d.f381do);
            this.f28272d.a();
        }
    }
}
