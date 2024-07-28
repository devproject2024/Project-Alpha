package net.one97.paytm.paymentsBank.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.i;

public class n extends l {

    /* renamed from: a  reason: collision with root package name */
    private TextView f18531a;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18532c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18533d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18534e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18535f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18536g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f18537h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f18538i;
    private TextView j;
    private TextView k;
    private NomineeModel l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private FrameLayout w;

    public int a() {
        return 0;
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_payment_bank_nominee_details, (ViewGroup) null);
        this.f18531a = (TextView) inflate.findViewById(R.id.tv_nominee_name);
        this.f18532c = (TextView) inflate.findViewById(R.id.tv_nominee_relationship);
        this.f18533d = (TextView) inflate.findViewById(R.id.tv_nominee_dob);
        this.f18534e = (TextView) inflate.findViewById(R.id.tv_nominee_address_line_1);
        this.f18535f = (TextView) inflate.findViewById(R.id.tv_nominee_address_line_2);
        this.k = (TextView) inflate.findViewById(R.id.tv_nominee_address_line_3);
        this.f18536g = (TextView) inflate.findViewById(R.id.tv_pincode);
        this.f18537h = (TextView) inflate.findViewById(R.id.tv_city);
        this.f18538i = (TextView) inflate.findViewById(R.id.tv_state);
        this.j = (TextView) inflate.findViewById(R.id.tv_nominee_email);
        this.m = (TextView) inflate.findViewById(R.id.tv_nominee_name_heading);
        this.n = (TextView) inflate.findViewById(R.id.tv_nominee_relationship_heading);
        this.o = (TextView) inflate.findViewById(R.id.tv_nominee_dob_heading);
        this.p = (TextView) inflate.findViewById(R.id.tv_nominee_address_line_1_heading);
        this.q = (TextView) inflate.findViewById(R.id.tv_nominee_address_line_2_heading);
        this.v = (TextView) inflate.findViewById(R.id.tv_nominee_address_line_3_heading);
        this.r = (TextView) inflate.findViewById(R.id.tv_pincode_heading);
        this.s = (TextView) inflate.findViewById(R.id.tv_city_heading);
        this.t = (TextView) inflate.findViewById(R.id.tv_state_heading);
        this.u = (TextView) inflate.findViewById(R.id.tv_nominee_email_heading);
        this.w = (FrameLayout) inflate.findViewById(R.id.container_framelayout);
        this.l = (NomineeModel) getArguments().getSerializable("NOMINEE_ITEM");
        if (!TextUtils.isEmpty(this.l.getName())) {
            this.f18531a.setText(this.l.getName());
        } else {
            this.m.setVisibility(8);
            this.f18531a.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getRelationship())) {
            this.f18532c.setText(this.l.getRelationship());
        } else {
            this.f18532c.setVisibility(8);
            this.n.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getDob())) {
            this.f18533d.setText(this.l.getDob());
        } else {
            this.f18533d.setVisibility(8);
            this.o.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getHouseNo())) {
            this.f18534e.setText(this.l.getHouseNo());
        } else {
            this.f18534e.setVisibility(8);
            this.p.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getStreetName())) {
            this.f18535f.setText(this.l.getStreetName());
        } else {
            this.f18535f.setVisibility(8);
            this.q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getAreaName())) {
            this.k.setText(this.l.getAreaName());
        } else {
            this.k.setVisibility(8);
            this.v.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getPinCode())) {
            this.f18536g.setText(this.l.getPinCode());
        } else {
            this.f18536g.setVisibility(8);
            this.r.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getCity())) {
            this.f18537h.setText(this.l.getCity());
        } else {
            this.f18537h.setVisibility(8);
            this.s.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getState())) {
            this.f18538i.setText(this.l.getState());
        } else {
            this.f18538i.setVisibility(8);
            this.t.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.l.getEmail())) {
            this.j.setText(this.l.getEmail());
        } else {
            this.j.setVisibility(8);
            this.u.setVisibility(8);
        }
        if (a() == 0 && this.l.getGuardians() != null && this.l.getGuardians().size() > 0 && this.l.getGuardians().get(0) != null) {
            this.w.setVisibility(0);
            i.a aVar = i.f18520a;
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("NOMINEE_ITEM", this.l.getGuardians().get(0));
            i iVar = new i();
            iVar.setArguments(bundle2);
            getChildFragmentManager().a().a(R.id.container_framelayout, (Fragment) iVar).b();
        }
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }
}
