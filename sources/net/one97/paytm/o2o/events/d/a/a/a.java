package net.one97.paytm.o2o.events.d.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import com.google.gson.f;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.events.CJREventPickupAddressInfo;
import net.one97.paytm.common.entity.events.CJRInputSeatInfo;
import net.one97.paytm.common.entity.events.CJRInsiderHoldCallResponse;
import net.one97.paytm.common.entity.events.CJRParticularEventDescriptionModel;
import net.one97.paytm.common.entity.events.CJRSeatDetailsModel;
import net.one97.paytm.common.entity.events.CJRSelectedInsiderSeats;
import net.one97.paytm.common.entity.events.EventsInputForm;
import net.one97.paytm.common.entity.events.EventsTravellerResponseModel;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.events.R;
import net.one97.paytm.o2o.events.b.c;
import net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2;
import net.one97.paytm.o2o.events.common.entity.events.CJRPinCodeValidationModel;
import net.one97.paytm.o2o.events.d.a.b.a;
import net.one97.paytm.o2o.events.view.EventsTravellerDetailsView;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends h implements View.OnClickListener, a.C1479a, EventsTravellerDetailsView.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f73740a = a.class.getSimpleName();
    private RelativeLayout A;
    private boolean B = false;
    private TextView C;
    private LinearLayout D;
    private View E;
    private View F;
    private TextView G;
    private String H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    private int M;
    private TextView N;
    /* access modifiers changed from: private */
    public int O = 0;
    private boolean P = false;
    private String Q = null;
    private View R;
    private int S;
    private EditText T;

    /* renamed from: b  reason: collision with root package name */
    private TextView f73741b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f73742c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f73743d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f73744e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f73745f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f73746g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f73747h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f73748i;
    private RelativeLayout j;
    private Button k;
    private TextView l;
    private ImageView m;
    private CJREventPickupAddressInfo n;
    private EventsTravellerResponseModel o;
    private EventsTravellerResponseModel p;
    private EventsTravellerDetailsView q;
    private EventsTravellerDetailsView r;
    private net.one97.paytm.o2o.events.c.a s;
    private CJRParticularEventDescriptionModel t;
    private List<CJRSeatDetailsModel> u;
    private List<CJRSelectedInsiderSeats> v;
    private EventsTravellerResponseModel w;
    private boolean x;
    private int y;
    private RelativeLayout z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getBundle("traveller_fragment_bundle_form") == null)) {
            Bundle bundle2 = arguments.getBundle("traveller_fragment_bundle_form");
            this.t = (CJRParticularEventDescriptionModel) bundle2.getSerializable("event-address-list");
            this.y = bundle2.getInt("delivery_option");
            this.u = (List) bundle2.getSerializable("package-selection");
            this.v = (List) bundle2.getSerializable("selected_insider_seat");
            this.I = arguments.getInt("event-venue-index", 0);
            this.J = arguments.getInt("event-date-index", 0);
            this.K = arguments.getInt("event-date-range-index", 0);
            this.L = arguments.getBoolean("season-pass-tab-selected", false);
            this.M = arguments.getInt("event-time-index", 0);
            CJRParticularEventDescriptionModel cJRParticularEventDescriptionModel = this.t;
            if (cJRParticularEventDescriptionModel != null) {
                this.n = cJRParticularEventDescriptionModel.getBoxOffice();
                if (this.L) {
                    this.H = net.one97.paytm.o2o.events.e.a.a(this.t, this.I, this.K, this.M);
                } else {
                    this.H = net.one97.paytm.o2o.events.e.a.b(this.t, this.I, this.J, this.M);
                }
            }
        }
        this.s = new net.one97.paytm.o2o.events.c.a(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.events_ticket_delivery, (ViewGroup) null);
        this.l = (TextView) inflate.findViewById(R.id.event_date_time);
        this.G = (TextView) inflate.findViewById(R.id.event_title);
        this.m = (ImageView) inflate.findViewById(R.id.event_imgvw);
        this.A = (RelativeLayout) inflate.findViewById(R.id.event_ticket_delivery_progressbar);
        this.D = (LinearLayout) inflate.findViewById(R.id.delivery_pickup_selector);
        this.f73741b = (TextView) inflate.findViewById(R.id.delivery_option);
        this.f73742c = (LinearLayout) inflate.findViewById(R.id.event_ticket_delivery_lyt);
        this.f73743d = (TextView) inflate.findViewById(R.id.pickup_option);
        this.f73744e = (LinearLayout) inflate.findViewById(R.id.pickup_details_lyt);
        this.f73745f = (TextView) inflate.findViewById(R.id.pickup_location);
        this.C = (TextView) inflate.findViewById(R.id.pickup_direction);
        this.f73746g = (RelativeLayout) inflate.findViewById(R.id.tnc_rel_layout);
        this.z = (RelativeLayout) inflate.findViewById(R.id.ticket_pickup_user_info);
        this.f73747h = (ImageView) inflate.findViewById(R.id.event_delivery_tnc_expand_collapse);
        this.f73748i = (TextView) inflate.findViewById(R.id.pickup_terms);
        this.j = (RelativeLayout) inflate.findViewById(R.id.ticket_pickup_user_info);
        this.k = (Button) inflate.findViewById(R.id.event_delivery_continue);
        inflate.findViewById(R.id.events_courier_back).setOnClickListener(this);
        this.E = inflate.findViewById(R.id.delivery_empty_view);
        this.F = inflate.findViewById(R.id.pickup_empty_view);
        this.N = (TextView) inflate.findViewById(R.id.event_courier_description);
        this.k.setOnClickListener(this);
        this.f73746g.setOnClickListener(this);
        this.f73741b.setOnClickListener(this);
        this.f73743d.setOnClickListener(this);
        this.G.setText(this.t.getName());
        if (!TextUtils.isEmpty(this.H)) {
            this.l.setText(this.H);
        } else {
            this.l.setVisibility(8);
        }
        String a2 = net.one97.paytm.o2o.events.e.a.a(this.t);
        if (!TextUtils.isEmpty(a2)) {
            w.a().a(a2.trim()).a(R.drawable.events_placeholder_bg).b(R.drawable.events_placeholder_bg).a(this.m, (e) null);
        }
        if (this.y == 1) {
            this.y = 2;
        } else {
            this.D.setVisibility(8);
            this.B = true;
        }
        int i2 = this.y;
        if (i2 == 2) {
            this.y = 1;
            e();
            j();
            this.N.setText(getResources().getString(R.string.event_delivery_charges));
        } else if (i2 == 0) {
            d();
            h();
            j();
            this.N.setText(getResources().getString(R.string.you_have_to_pick_tickets_up_at_venue));
        }
        return inflate;
    }

    private void d() {
        if (!this.B) {
            this.f73743d.setBackground(b.a((Context) getActivity(), R.drawable.selector_event_courier_right_tooltip));
            this.f73743d.setTextColor(b.c(getActivity(), R.color.white));
            this.f73741b.setBackground(b.a((Context) getActivity(), R.drawable.selector_event_left_bg));
            this.f73741b.setTextColor(b.c(getActivity(), R.color.paytm_blue));
            this.f73743d.setPadding(0, 0, 0, 12);
            this.f73741b.setPadding(0, 0, 0, 0);
            this.F.setVisibility(8);
            this.E.setVisibility(0);
            this.N.setText(getResources().getString(R.string.you_have_to_pick_tickets_up_at_venue));
            f();
        }
    }

    private void e() {
        if (!this.B) {
            this.f73741b.setBackground(b.a((Context) getActivity(), R.drawable.selector_event_courier_left_tooltip));
            this.f73741b.setTextColor(b.c(getActivity(), R.color.white));
            this.f73743d.setBackground(b.a((Context) getActivity(), R.drawable.selector_event_courier_right_bg));
            this.f73743d.setTextColor(b.c(getActivity(), R.color.paytm_blue));
            this.f73741b.setPadding(0, 0, 0, 12);
            this.f73743d.setPadding(0, 0, 0, 0);
            this.E.setVisibility(8);
            this.F.setVisibility(0);
            this.N.setText(getResources().getString(R.string.event_delivery_charges));
            g();
        }
    }

    private void f() {
        this.f73742c.setVisibility(8);
    }

    private void g() {
        this.f73744e.setVisibility(8);
    }

    private void h() {
        this.f73744e.setVisibility(0);
        CJREventPickupAddressInfo cJREventPickupAddressInfo = this.n;
        if (cJREventPickupAddressInfo != null) {
            String address = cJREventPickupAddressInfo.getAddress();
            if (TextUtils.isEmpty(address)) {
                address = this.n.getMessage();
            }
            if (!TextUtils.isEmpty(address)) {
                this.f73745f.setText(address);
            } else {
                this.f73745f.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.n.getGoogleMapLink())) {
                this.C.setVisibility(0);
                this.C.setOnClickListener(this);
            }
            String a2 = a(this.n.getTerms());
            if (!TextUtils.isEmpty(a2)) {
                this.f73746g.setVisibility(0);
                this.f73748i.setText(a2);
                return;
            }
            this.f73746g.setVisibility(8);
            this.f73748i.setVisibility(8);
            return;
        }
        this.f73744e.setVisibility(8);
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("\\*", "\n• ").replaceAll("\\.", "\\.\n ") : str;
    }

    public void onClick(View view) {
        EventsTravellerDetailsView eventsTravellerDetailsView;
        EventsTravellerDetailsView eventsTravellerDetailsView2;
        if (view.getId() == R.id.delivery_option) {
            this.y = 1;
            e();
            this.f73744e.setVisibility(8);
            this.j.setVisibility(8);
            if (this.q == null) {
                j();
            } else {
                this.f73742c.setVisibility(0);
            }
        } else if (view.getId() == R.id.pickup_option) {
            this.y = 0;
            d();
            this.f73742c.setVisibility(8);
            h();
            this.f73744e.setVisibility(0);
            if (this.r == null) {
                j();
            } else {
                this.j.setVisibility(0);
            }
        } else if (view.getId() == R.id.tnc_rel_layout) {
            if (!this.x) {
                this.x = true;
                this.f73748i.setVisibility(0);
                this.f73747h.setImageDrawable(b.a((Context) getActivity(), net.one97.paytm.common.assets.R.drawable.up));
                return;
            }
            this.x = false;
            this.f73748i.setVisibility(8);
            this.f73747h.setImageDrawable(b.a((Context) getActivity(), net.one97.paytm.common.assets.R.drawable.down));
        } else if (view.getId() == R.id.event_delivery_continue) {
            if (!this.P && this.y != 0) {
                int i2 = this.O;
                if (i2 == -1) {
                    i2 = 0;
                }
                this.T.setEnabled(false);
                net.one97.paytm.o2o.events.c.a aVar = this.s;
                String id = this.t.getId();
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("eventId", id);
                    jSONObject2.put("pinCode", i2);
                    jSONObject.put("data", jSONObject2);
                    aVar.f73725b.a((c.a) aVar, jSONObject.toString(), c.b.a.PINCODE_VALIDATION);
                } catch (JSONException unused) {
                }
                View view2 = this.R;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else if (this.y == 1 && (eventsTravellerDetailsView2 = this.q) != null) {
                eventsTravellerDetailsView2.a();
            } else if (this.y == 0 && (eventsTravellerDetailsView = this.r) != null) {
                eventsTravellerDetailsView.a();
            }
        } else if (view.getId() == R.id.pickup_direction) {
            if (!TextUtils.isEmpty(this.n.getGoogleMapLink())) {
                String googleMapLink = this.n.getGoogleMapLink();
                if (!googleMapLink.startsWith("http://") && !googleMapLink.startsWith("https://")) {
                    googleMapLink = "http://".concat(String.valueOf(googleMapLink));
                }
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(googleMapLink)));
                return;
            }
            com.paytm.utility.b.a((Context) getActivity(), "No link available to show directions");
        } else if (view.getId() == R.id.events_courier_back && getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public final void a(CJRInsiderHoldCallResponse cJRInsiderHoldCallResponse) {
        if (cJRInsiderHoldCallResponse != null && cJRInsiderHoldCallResponse.getStatus().equalsIgnoreCase("ok")) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("traveller-details", this.w);
            bundle.putInt("delivery_option", this.y);
            bundle.putDouble("delivery_price", cJRInsiderHoldCallResponse.getPrice());
            bundle.putSerializable("hold_call_response", cJRInsiderHoldCallResponse);
            new HashMap().put("traveller_fragment_bundle_form", bundle);
        }
    }

    public final void a(CJRPinCodeValidationModel cJRPinCodeValidationModel, String str) {
        this.Q = str;
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
        }
        if (cJRPinCodeValidationModel == null || !cJRPinCodeValidationModel.getStatus().equalsIgnoreCase("ok") || !cJRPinCodeValidationModel.getData().f73739a) {
            this.P = false;
            this.S = this.O;
            this.O = -1;
        } else {
            this.P = true;
        }
        i();
    }

    private void i() {
        this.f73742c.setVisibility(0);
        this.f73742c.removeAllViews();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.event_pincode_verification_view, (ViewGroup) null);
        this.T = (EditText) inflate.findViewById(R.id.pin_edit_text);
        TextView textView = (TextView) inflate.findViewById(R.id.events_passenger_form_textview_error_msg);
        this.R = inflate.findViewById(R.id.pin_progress);
        this.R.setVisibility(8);
        this.T.setEnabled(true);
        if (this.O == -1) {
            if (TextUtils.isEmpty(this.Q)) {
                this.Q = "Tickets are not delivered to this location";
            }
            textView.setText(this.Q);
            textView.setVisibility(0);
            int i2 = this.S;
            if (!(i2 == -1 || i2 == 0)) {
                this.T.setText(String.valueOf(i2));
            }
        } else {
            textView.setVisibility(8);
        }
        this.T.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return a.this.a(textView, i2, keyEvent);
            }
        });
        this.T.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                try {
                    int unused = a.this.O = Integer.parseInt(String.valueOf(charSequence));
                } catch (Exception unused2) {
                    int unused3 = a.this.O = 0;
                }
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.edit_image);
        appCompatImageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) inflate.findViewById(R.id.pin_applied_image);
        appCompatImageView2.setVisibility(8);
        appCompatImageView.setVisibility(8);
        this.f73742c.addView(inflate);
        if (this.P) {
            c(this.o);
            this.q = EventsTravellerDetailsView.a(getActivity(), d(this.o), this);
            this.f73742c.addView(this.q);
            int i3 = this.O;
            if (!(i3 == -1 || i3 == 0)) {
                this.T.setText(String.valueOf(i3));
            }
            this.T.setEnabled(false);
            appCompatImageView.setVisibility(0);
            appCompatImageView2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 3 && i2 != 6 && i2 != 5 && (keyEvent == null || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        if (keyEvent != null && keyEvent.isShiftPressed()) {
            return false;
        }
        this.k.callOnClick();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.P = false;
        this.O = 0;
        i();
    }

    private void c(EventsTravellerResponseModel eventsTravellerResponseModel) {
        ArrayList<ArrayList<EventsInputForm>> form = eventsTravellerResponseModel.getForm();
        if (form != null) {
            Iterator<ArrayList<EventsInputForm>> it2 = form.iterator();
            while (it2.hasNext()) {
                Iterator it3 = it2.next().iterator();
                while (it3.hasNext()) {
                    EventsInputForm eventsInputForm = (EventsInputForm) it3.next();
                    if (eventsInputForm.getId().contains("Pincode")) {
                        eventsInputForm.setApplied(String.valueOf(this.O));
                    }
                }
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            com.paytm.utility.b.b((Context) getActivity(), str2, str3);
        } else if (str.contains("/") || str.contains("\\")) {
            com.paytm.utility.b.b((Context) getActivity(), "Error", "Sorry! We are currently facing technical issues. Please try again in sometime. ".concat(String.valueOf(str)));
        } else {
            com.paytm.utility.b.b((Context) getActivity(), "Error", str3);
        }
    }

    public final void a() {
        this.A.setVisibility(0);
    }

    public final void b() {
        this.A.setVisibility(8);
    }

    public final void a(EventsTravellerResponseModel eventsTravellerResponseModel) {
        int i2 = this.y;
        if (i2 == 1) {
            this.o = eventsTravellerResponseModel;
            i();
        } else if (i2 == 0) {
            this.p = eventsTravellerResponseModel;
            this.j.setVisibility(0);
            this.r = EventsTravellerDetailsView.a(getActivity(), d(this.p), this);
            this.z.removeAllViews();
            this.z.addView(this.r);
        }
    }

    private void j() {
        if (this.t.getForm().equals("1")) {
            this.s.a(this.u, this.y, this.t);
        }
    }

    public final void b(EventsTravellerResponseModel eventsTravellerResponseModel) {
        this.w = eventsTravellerResponseModel;
        EventsTravellerResponseModel eventsTravellerResponseModel2 = this.w;
        if (eventsTravellerResponseModel2 != null && eventsTravellerResponseModel2.getForm() != null && this.w.getForm().size() > 0) {
            EventsTravellerResponseModel eventsTravellerResponseModel3 = this.w;
            net.one97.paytm.o2o.events.c.a aVar = this.s;
            List<CJRSeatDetailsModel> list = this.u;
            List<CJRSelectedInsiderSeats> list2 = this.v;
            CJRParticularEventDescriptionModel cJRParticularEventDescriptionModel = this.t;
            aVar.f73724a.a();
            CJRInputMetaDataModelV2 cJRInputMetaDataModelV2 = new CJRInputMetaDataModelV2();
            cJRInputMetaDataModelV2.setEntityType(EventsModuleManager.MODULE_NAME);
            cJRInputMetaDataModelV2.setEntityId(cJRParticularEventDescriptionModel.getId());
            cJRInputMetaDataModelV2.setEntityName(cJRParticularEventDescriptionModel.getName());
            cJRInputMetaDataModelV2.setProviderId(cJRParticularEventDescriptionModel.getProviderId());
            cJRInputMetaDataModelV2.setProviderName(cJRParticularEventDescriptionModel.getProviderName());
            if (list2 != null && list2.size() > 0) {
                cJRInputMetaDataModelV2.setSelectedInsiderSeat(list2);
            }
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (CJRSeatDetailsModel next : list) {
                    if (next.getSelectedQuantity() > 0) {
                        CJRInputSeatInfo cJRInputSeatInfo = new CJRInputSeatInfo();
                        cJRInputSeatInfo.setSeatId(next.getSeatId());
                        cJRInputSeatInfo.setSeatType(next.getSeatType());
                        cJRInputSeatInfo.setCount(next.getSelectedQuantity());
                        cJRInputSeatInfo.setDescription(next.getSeatDescription());
                        cJRInputSeatInfo.setPricePerSeat(String.valueOf(next.getPrice()));
                        cJRInputSeatInfo.setProviderSeatId(next.getProviderSeatId());
                        arrayList.add(cJRInputSeatInfo);
                    }
                }
                cJRInputMetaDataModelV2.setseatInfo(arrayList);
            }
            if (!(eventsTravellerResponseModel3 == null || eventsTravellerResponseModel3.getForm() == null || eventsTravellerResponseModel3.getForm().size() <= 0)) {
                cJRInputMetaDataModelV2.setPassenger(eventsTravellerResponseModel3.getForm());
            }
            cJRInputMetaDataModelV2.setVertical(EventsModuleManager.MODULE_NAME);
            cJRInputMetaDataModelV2.setProductId(cJRParticularEventDescriptionModel.getProductId());
            cJRInputMetaDataModelV2.setEntityCity(cJRParticularEventDescriptionModel.getEntityCity());
            cJRInputMetaDataModelV2.setCitySearched(cJRParticularEventDescriptionModel.getCitySearched());
            cJRInputMetaDataModelV2.setSeatMap(cJRParticularEventDescriptionModel.getSeatMap());
            cJRInputMetaDataModelV2.setMerchantId(cJRParticularEventDescriptionModel.getmMerchantId());
            aVar.f73725b.a((c.a) aVar, new f().b(cJRInputMetaDataModelV2), c.b.a.INSIDER_HOLD_CALL_RESPONSE);
        }
    }

    public final void c() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private static Bundle d(EventsTravellerResponseModel eventsTravellerResponseModel) {
        if (eventsTravellerResponseModel == null) {
            return null;
        }
        int i2 = 0;
        boolean z2 = true;
        if (eventsTravellerResponseModel.getFlag() != 0 && eventsTravellerResponseModel.getFlag() == 1) {
            z2 = false;
        }
        Bundle bundle = new Bundle();
        if (eventsTravellerResponseModel.getForm() != null) {
            i2 = eventsTravellerResponseModel.getForm().size();
        }
        bundle.putInt("traveller-num-of-passenger", i2);
        bundle.putBoolean("traveller-is-static-form", z2);
        bundle.putSerializable("traveller-details", eventsTravellerResponseModel);
        return bundle;
    }
}
