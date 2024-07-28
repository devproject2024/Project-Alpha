package com.travel.train.viewholder;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.h;
import com.travel.train.R;
import com.travel.train.b.as;
import com.travel.train.helper.i;
import com.travel.train.helper.n;
import com.travel.train.i.aj;
import com.travel.train.i.g;
import com.travel.train.i.y;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRCountryCode;
import com.travel.train.model.trainticket.CJRPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainConfig;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.travellerProfile.a.a;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.utility.d;

public final class z extends RecyclerView.v implements View.OnClickListener, y, com.travel.train.i.z {
    private LinearLayout A;
    private LinearLayout B;
    private RoboTextView C;
    private TextView D;
    private TextView E;
    private final TextView F;

    /* renamed from: a  reason: collision with root package name */
    public Context f28300a;

    /* renamed from: b  reason: collision with root package name */
    public g f28301b;

    /* renamed from: c  reason: collision with root package name */
    public n f28302c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f28303d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f28304e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f28305f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<CJRCountryCode> f28306g;

    /* renamed from: h  reason: collision with root package name */
    public int f28307h;

    /* renamed from: i  reason: collision with root package name */
    public int f28308i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public LinearLayout s;
    public LinearLayout t;
    private i u;
    private CJRTrainDetailsBody v;
    private CJRTrainSearchInput w;
    private HashMap<Integer, CJRTpUserProfileContact> x = new HashMap<>();
    private View y;
    private TextView z;

    public z(View view, g gVar, i iVar, CJRTrainDetailsBody cJRTrainDetailsBody, CJRTrainSearchInput cJRTrainSearchInput) {
        super(view);
        this.f28300a = view.getContext();
        this.y = view;
        this.f28301b = gVar;
        this.w = cJRTrainSearchInput;
        this.u = iVar;
        this.v = cJRTrainDetailsBody;
        CJRTrainConfig trainConfig = this.v.getTrainConfig();
        if (trainConfig != null) {
            this.q = trainConfig.isChildBerthMandatory();
            this.r = trainConfig.isSeniorCitizenApplicable();
        }
        this.z = (TextView) view.findViewById(R.id.child_traveller_detail_heading);
        this.A = (LinearLayout) view.findViewById(R.id.child_msg_lyt);
        this.B = (LinearLayout) view.findViewById(R.id.msgLyt);
        this.s = (LinearLayout) view.findViewById(R.id.passenger_add_layout);
        this.t = (LinearLayout) view.findViewById(R.id.add_infants_lyt);
        this.C = (RoboTextView) view.findViewById(R.id.add_extra_infants);
        this.D = (TextView) view.findViewById(R.id.add_extra_traveller);
        this.E = (TextView) this.B.findViewById(R.id.msgBox);
        this.F = (TextView) view.findViewById(R.id.child_msg_box);
        this.D.setOnClickListener(this);
        this.C.setOnClickListener(this);
        if (com.travel.train.j.g.f27551a != null) {
            if (this.E != null && !TextUtils.isEmpty(com.travel.train.j.g.f27551a.getAdultTravellerMessage())) {
                this.E.setText(new SpannableString(com.travel.train.j.g.f27551a.getAdultTravellerMessage()));
            }
            if (this.F != null && !TextUtils.isEmpty(com.travel.train.j.g.f27551a.getInfantMessage())) {
                this.F.setText(com.travel.train.j.g.f27551a.getInfantMessage());
            }
        }
        this.f28302c = new n((Activity) this.f28300a, trainConfig, this.v, this, this);
        this.f28302c.a(this.s, this.t, this.A);
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.add_extra_traveller) {
            if (this.s.getChildCount() < this.f28302c.f27346h) {
                a(false);
                return;
            }
            Context context = this.f28300a;
            b.b(context, context.getString(R.string.train_travellers_error), this.f28300a.getString(R.string.maximum_number_of_passenger, new Object[]{Integer.valueOf(this.f28302c.f27346h)}));
        } else if (id == R.id.add_extra_infants) {
            this.u.a(d.dm);
            if (this.t.getChildCount() < this.f28302c.f27345g) {
                a(true);
                return;
            }
            Context context2 = this.f28300a;
            b.b(context2, context2.getString(R.string.train_travellers_error), this.f28300a.getString(R.string.maximum_number_of_infant, new Object[]{Integer.valueOf(this.f28302c.f27345g)}));
        }
    }

    public final void a() {
        this.f28301b.a(aj.START_COUNTRY_LIST_VIEW);
    }

    public final void a(View view) {
        View view2 = (View) view.getParent();
        CJRPassengerInfo cJRPassengerInfo = this.f28302c.l.get(((Integer) view2.getTag()).intValue());
        if (cJRPassengerInfo != null) {
            String str = cJRPassengerInfo.getmCategory();
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 2650) {
                if (hashCode == 2660 && str.equals("SW")) {
                    c2 = 0;
                }
            } else if (str.equals("SM")) {
                c2 = 1;
            }
            if ((c2 == 0 || c2 == 1) && ((CheckBox) view2.findViewById(R.id.radio_senior_citizen)).isChecked()) {
                this.f28308i--;
                this.f28307h--;
            }
        }
        if (((Integer) view2.getTag()).intValue() < this.f28302c.l.size()) {
            this.f28302c.l.set(((Integer) view2.getTag()).intValue(), (Object) null);
        }
        this.s.removeView(view2);
        if (this.s.getChildCount() == 1) {
            this.s.getChildAt(0).findViewById(R.id.delete_passenger).setVisibility(4);
        }
        int parseInt = Integer.parseInt(((TextView) view2.findViewById(R.id.passenger_count)).getText().toString().split(" ")[0]);
        if (parseInt <= this.s.getChildCount()) {
            for (int i2 = parseInt - 1; i2 < this.s.getChildCount(); i2++) {
                RelativeLayout relativeLayout = (RelativeLayout) this.s.getChildAt(i2);
                ((TextView) relativeLayout.findViewById(R.id.passenger_count)).setText(String.valueOf(parseInt));
                ((TextView) relativeLayout.findViewById(R.id.train_passenger_count)).setText("# ".concat(String.valueOf(parseInt)));
                parseInt++;
            }
        }
        this.x.remove(Integer.valueOf(((Integer) view.getTag()).intValue()));
    }

    public final void b(View view) {
        View view2 = (View) view.getParent();
        if (((Integer) view2.getTag()).intValue() < this.f28302c.l.size()) {
            this.f28302c.l.set(((Integer) view2.getTag()).intValue(), (Object) null);
        }
        this.t.removeView(view2);
        int parseInt = Integer.parseInt(((TextView) view2.findViewById(R.id.passenger_count)).getText().toString().split(" ")[0]);
        if (parseInt <= this.t.getChildCount()) {
            for (int i2 = parseInt - 1; i2 < this.t.getChildCount(); i2++) {
                RelativeLayout relativeLayout = (RelativeLayout) this.t.getChildAt(i2);
                ((TextView) relativeLayout.findViewById(R.id.passenger_count)).setText(String.valueOf(parseInt));
                ((TextView) relativeLayout.findViewById(R.id.train_passenger_count)).setText("# ".concat(String.valueOf(parseInt)));
                parseInt++;
            }
        }
        if (this.t.getChildCount() <= 0) {
            b(8);
        }
    }

    public final boolean h() {
        LinearLayout linearLayout = this.s;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.s.getChildCount(); i2++) {
                View childAt = this.s.getChildAt(i2);
                String obj = ((AutoCompleteTextView) childAt.findViewById(R.id.full_name)).getText().toString();
                String obj2 = ((EditText) childAt.findViewById(R.id.age)).getText().toString();
                if (!TextUtils.isEmpty(obj) || !TextUtils.isEmpty(obj2)) {
                    return true;
                }
            }
            if (this.t != null) {
                for (int i3 = 0; i3 < this.t.getChildCount(); i3++) {
                    View childAt2 = this.t.getChildAt(i3);
                    String obj3 = ((AutoCompleteTextView) childAt2.findViewById(R.id.full_name)).getText().toString();
                    String obj4 = ((EditText) childAt2.findViewById(R.id.age)).getText().toString();
                    if (!TextUtils.isEmpty(obj3) || !TextUtils.isEmpty(obj4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void b(int i2) {
        this.z.setVisibility(i2);
        this.A.setVisibility(i2);
        this.t.setVisibility(i2);
    }

    public final ArrayList<CJRCountryCode> b() {
        return this.f28306g;
    }

    public final void a(boolean z2) {
        this.f28302c.a(z2, false, false, true);
    }

    public final void a(int i2) {
        this.f28308i = i2;
    }

    public final ArrayList<CJRTpUserProfileContact> d() {
        return this.f28304e;
    }

    public final ArrayList<CJRTpUserProfileContact> e() {
        return this.f28303d;
    }

    public final int c() {
        return this.f28308i;
    }

    public final HashMap<Integer, CJRTpUserProfileContact> f() {
        return this.x;
    }

    public final CJRTrainSearchInput g() {
        return this.w;
    }

    public final void a(CJRTpUserProfileContact cJRTpUserProfileContact, View view) {
        if (cJRTpUserProfileContact != null) {
            i iVar = this.u;
            a.a().a(iVar.f27313a.e().getApplicationContext(), cJRTpUserProfileContact, (com.paytm.network.listener.b) iVar);
            this.u.a(d.dv);
            final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
            as asVar = (as) autoCompleteTextView.getAdapter();
            ArrayList<CJRTpUserProfileContact> arrayList = asVar.f26321b;
            arrayList.remove(cJRTpUserProfileContact);
            asVar.a(arrayList, autoCompleteTextView.getText());
            this.f28303d.remove(cJRTpUserProfileContact);
            this.f28304e.remove(cJRTpUserProfileContact);
            new Handler().post(new Runnable() {
                public final void run() {
                    autoCompleteTextView.showDropDown();
                }
            });
        }
    }

    public final void a(ArrayList<CJRPassengerInfo> arrayList) {
        this.f28302c.a(arrayList);
    }

    public final void i() {
        boolean z2 = false;
        if (this.f28302c.l != null && this.f28302c.l.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 < this.f28302c.l.size()) {
                    CJRPassengerInfo cJRPassengerInfo = this.f28302c.l.get(i2);
                    if (cJRPassengerInfo != null && cJRPassengerInfo.getmCategory() != null && cJRPassengerInfo.getmCategory().equalsIgnoreCase("CH") && cJRPassengerInfo.isIsBerthFlag()) {
                        final h hVar = new h(this.f28300a);
                        hVar.setCancelable(false);
                        hVar.a(this.f28300a.getString(R.string.child_berth_choice_warning));
                        hVar.a(-3, this.f28300a.getString(R.string.ok), new View.OnClickListener() {
                            public final void onClick(View view) {
                                z.this.j();
                                hVar.cancel();
                            }
                        });
                        hVar.show();
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        Window window = hVar.getWindow();
                        layoutParams.copyFrom(window.getAttributes());
                        layoutParams.width = -1;
                        layoutParams.height = -2;
                        window.setAttributes(layoutParams);
                        z2 = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        if (!z2) {
            j();
        }
    }

    public final void j() {
        if (this.v.getTrainPreferences() == null || this.v.getMessage() == null || !this.v.getMessage().isTravellerMessageEnable()) {
            this.f28301b.a(aj.START_REVIEW_ITERNARY_VIEW);
            return;
        }
        final h hVar = new h(this.f28300a);
        hVar.setCancelable(false);
        hVar.a(this.v.getMessage().getTravellerMessage());
        hVar.a(-3, this.f28300a.getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                z.this.f28301b.a(aj.START_REVIEW_ITERNARY_VIEW);
                hVar.cancel();
            }
        });
        hVar.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = hVar.getWindow();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        window.setAttributes(layoutParams);
    }
}
