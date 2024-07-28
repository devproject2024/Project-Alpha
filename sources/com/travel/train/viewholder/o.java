package com.travel.train.viewholder;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.b.as;
import com.travel.train.helper.n;
import com.travel.train.i.e;
import com.travel.train.i.y;
import com.travel.train.i.z;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRCountryCode;
import com.travel.train.model.trainticket.CJRPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainConfig;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class o extends RecyclerView.v implements View.OnClickListener, y, z {
    private LinearLayout A;
    private TextView B;
    private TextView C;
    private String D = "CJRIternaryTravellerViewHolder";

    /* renamed from: a  reason: collision with root package name */
    public Context f28181a;

    /* renamed from: b  reason: collision with root package name */
    public e f28182b;

    /* renamed from: c  reason: collision with root package name */
    public n f28183c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f28184d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f28185e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f28186f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<CJRCountryCode> f28187g;

    /* renamed from: h  reason: collision with root package name */
    public int f28188h;

    /* renamed from: i  reason: collision with root package name */
    public int f28189i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public TextView s;
    public LinearLayout t;
    public LinearLayout u;
    public LinearLayout v;
    private CJRTrainConfig w;
    private CJRTrainDetailsBody x;
    private CJRTrainSearchInput y;
    private HashMap<Integer, CJRTpUserProfileContact> z = new HashMap<>();

    public o(View view, e eVar, CJRTrainSearchInput cJRTrainSearchInput, CJRTrainDetailsBody cJRTrainDetailsBody) {
        super(view);
        this.f28181a = view.getContext();
        this.f28182b = eVar;
        this.x = cJRTrainDetailsBody;
        this.y = cJRTrainSearchInput;
        this.w = this.x.getTrainConfig();
        CJRTrainConfig cJRTrainConfig = this.w;
        if (cJRTrainConfig != null) {
            this.q = cJRTrainConfig.isChildBerthMandatory();
            this.r = this.w.isSeniorCitizenApplicable();
        }
        this.s = (TextView) view.findViewById(R.id.traveller_edit);
        this.s.setOnClickListener(this);
        this.t = (LinearLayout) view.findViewById(R.id.adult_traveller_container);
        this.v = (LinearLayout) view.findViewById(R.id.extra_traveller_container);
        this.u = (LinearLayout) view.findViewById(R.id.child_traveller_container);
        this.A = (LinearLayout) view.findViewById(R.id.child_lyt);
        this.B = (TextView) view.findViewById(R.id.add_extra_traveller);
        this.C = (TextView) view.findViewById(R.id.add_extra_infants);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f28183c = new n(this.f28182b.u(), this.w, this.x, this, this);
        this.f28183c.a(this.t, this.u, this.A);
        this.f28183c.a();
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.traveller_edit) {
            this.s.setVisibility(8);
            this.v.setVisibility(0);
            LinearLayout linearLayout = this.t;
            if (linearLayout != null) {
                if (linearLayout.getChildCount() > 1) {
                    for (int i2 = 0; i2 < this.t.getChildCount(); i2++) {
                        View childAt = this.t.getChildAt(i2);
                        ((RelativeLayout) childAt.findViewById(R.id.add_passenger_layout)).setClickable(true);
                        childAt.findViewById(R.id.delete_passenger).setVisibility(0);
                    }
                } else {
                    View childAt2 = this.t.getChildAt(0);
                    childAt2.findViewById(R.id.add_passenger_layout).setClickable(true);
                    childAt2.findViewById(R.id.delete_passenger).setVisibility(4);
                }
            }
            LinearLayout linearLayout2 = this.u;
            if (linearLayout2 != null && linearLayout2.getChildCount() > 0) {
                for (int i3 = 0; i3 < this.u.getChildCount(); i3++) {
                    View childAt3 = this.u.getChildAt(i3);
                    ((RelativeLayout) childAt3.findViewById(R.id.add_passenger_layout)).setClickable(true);
                    childAt3.findViewById(R.id.delete_passenger).setVisibility(0);
                }
            }
            this.f28182b.j();
            com.travel.train.j.o.a("train_review_itinerary", (String) null, "edit_traveller_detail", "/trains/review-itinerary", this.f28181a);
        } else if (id == R.id.add_extra_infants) {
            if (this.u.getChildCount() < this.f28183c.f27345g) {
                this.f28183c.a(true, true, false, false);
                return;
            }
            Context context = this.f28181a;
            b.b(context, context.getString(R.string.train_travellers_error), this.f28181a.getString(R.string.maximum_number_of_infant, new Object[]{Integer.valueOf(this.f28183c.f27345g)}));
        } else if (id != R.id.add_extra_traveller) {
        } else {
            if (this.t.getChildCount() < this.f28183c.f27346h) {
                this.f28183c.a(false, true, false, false);
                return;
            }
            Context context2 = this.f28181a;
            b.b(context2, context2.getString(R.string.train_travellers_error), this.f28181a.getString(R.string.maximum_number_of_passenger, new Object[]{Integer.valueOf(this.f28183c.f27346h)}));
        }
    }

    public final void a() {
        this.f28182b.t();
    }

    public final void a(View view) {
        View view2 = (View) view.getParent();
        CJRPassengerInfo cJRPassengerInfo = this.f28183c.l.get(((Integer) view2.getTag()).intValue());
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
                this.f28189i--;
                this.f28188h--;
            }
        }
        if (((Integer) view2.getTag()).intValue() < this.f28183c.l.size()) {
            this.f28183c.l.set(((Integer) view2.getTag()).intValue(), (Object) null);
        }
        this.t.removeView(view2);
        if (this.t.getChildCount() == 1) {
            this.t.getChildAt(0).findViewById(R.id.delete_passenger).setVisibility(4);
        }
        int parseInt = Integer.parseInt(((TextView) view2.findViewById(R.id.passenger_count)).getText().toString().split(" ")[0]);
        if (parseInt <= this.t.getChildCount()) {
            for (int i2 = parseInt - 1; i2 < this.t.getChildCount(); i2++) {
                RelativeLayout relativeLayout = (RelativeLayout) this.t.getChildAt(i2);
                ((TextView) relativeLayout.findViewById(R.id.passenger_count)).setText(String.valueOf(parseInt));
                ((TextView) relativeLayout.findViewById(R.id.train_passenger_count)).setText("# ".concat(String.valueOf(parseInt)));
                parseInt++;
            }
        }
        this.z.remove(Integer.valueOf(((Integer) view.getTag()).intValue()));
    }

    public final void b(View view) {
        View view2 = (View) view.getParent();
        if (((Integer) view2.getTag()).intValue() < this.f28183c.l.size()) {
            this.f28183c.l.set(((Integer) view2.getTag()).intValue(), (Object) null);
        }
        this.u.removeView(view2);
        int parseInt = Integer.parseInt(((TextView) view2.findViewById(R.id.passenger_count)).getText().toString().split(" ")[0]);
        if (parseInt <= this.u.getChildCount()) {
            for (int i2 = parseInt - 1; i2 < this.u.getChildCount(); i2++) {
                RelativeLayout relativeLayout = (RelativeLayout) this.u.getChildAt(i2);
                ((TextView) relativeLayout.findViewById(R.id.passenger_count)).setText(String.valueOf(parseInt));
                ((TextView) relativeLayout.findViewById(R.id.train_passenger_count)).setText("# ".concat(String.valueOf(parseInt)));
                parseInt++;
            }
        }
        if (this.u.getChildCount() <= 0) {
            b(8);
        }
    }

    public final ArrayList<CJRCountryCode> b() {
        return this.f28187g;
    }

    public final int c() {
        return this.f28189i;
    }

    public final void a(int i2) {
        this.f28189i = i2;
    }

    public final ArrayList<CJRTpUserProfileContact> d() {
        return this.f28185e;
    }

    public final ArrayList<CJRTpUserProfileContact> e() {
        return this.f28184d;
    }

    public final HashMap<Integer, CJRTpUserProfileContact> f() {
        return this.z;
    }

    public final CJRTrainSearchInput g() {
        return this.y;
    }

    public final void b(int i2) {
        this.A.setVisibility(i2);
    }

    public final void a(CJRTpUserProfileContact cJRTpUserProfileContact, View view) {
        if (cJRTpUserProfileContact != null) {
            this.f28182b.a(cJRTpUserProfileContact);
            String str = d.dv;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", b.n(this.f28181a) != null ? b.n(this.f28181a) : "");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/review-itinerary");
                com.travel.train.b.a();
                com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, this.f28181a);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
            as asVar = (as) autoCompleteTextView.getAdapter();
            ArrayList<CJRTpUserProfileContact> arrayList = asVar.f26321b;
            arrayList.remove(cJRTpUserProfileContact);
            asVar.a(arrayList, autoCompleteTextView.getText());
            this.f28184d.remove(cJRTpUserProfileContact);
            this.f28185e.remove(cJRTpUserProfileContact);
            new Handler().post(new Runnable() {
                public final void run() {
                    autoCompleteTextView.showDropDown();
                }
            });
        }
    }
}
