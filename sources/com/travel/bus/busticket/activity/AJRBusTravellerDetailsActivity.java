package com.travel.bus.busticket.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.f.h;
import com.travel.bus.busticket.fragment.l;
import com.travel.bus.busticket.fragment.m;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusUserProfile;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRBusTravellerDetailsActivity extends CJRActionBarBaseActivity implements b, h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f21905a = m.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static int f21906b = 1;

    /* renamed from: c  reason: collision with root package name */
    private m f21907c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<TripBusDetailsItem> f21908d;

    /* renamed from: e  reason: collision with root package name */
    private CJRBusSearchInput f21909e;

    /* renamed from: f  reason: collision with root package name */
    private CJRBusSearchItem f21910f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<CJRPassengerDetails> f21911g;

    /* renamed from: h  reason: collision with root package name */
    private String f21912h;

    /* renamed from: i  reason: collision with root package name */
    private TripBusDetail f21913i;
    private CJRLocation j;
    private CJRLocation k;
    private boolean l = false;
    private CJRBusUserProfile m;
    private HashMap<String, CJRBusSearchOperatorTagInfo> n = null;
    private boolean o;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void attachBaseContext(Context context) {
        q.a(context);
        super.attachBaseContext(context);
        a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) this);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-traveller");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        Intent intent = getIntent();
        if (intent != null) {
            this.f21908d = (ArrayList) intent.getSerializableExtra("intent_extra_selected_seats");
            this.f21909e = (CJRBusSearchInput) intent.getSerializableExtra("intent_extra_bus_search_input");
            this.f21910f = (CJRBusSearchItem) intent.getSerializableExtra("intent_extra_bus_search_result_item");
            this.f21911g = (ArrayList) intent.getSerializableExtra("intent_extra_passenger_details");
            this.f21912h = intent.getStringExtra("requestid");
            this.f21913i = (TripBusDetail) intent.getSerializableExtra("intent_extra_bus_trip_detail");
            this.j = (CJRLocation) intent.getSerializableExtra("intent_extra_selected_boarding_point");
            this.k = (CJRLocation) intent.getSerializableExtra("intent_extra_selected_dropping_point");
            this.l = intent.getBooleanExtra("isSingleLady", false);
            if (intent.hasExtra("intent_extra_bus_search_load_data")) {
                this.n = (HashMap) intent.getSerializableExtra("intent_extra_bus_search_load_data");
            }
            this.m = (CJRBusUserProfile) intent.getSerializableExtra("traveller_details_key");
        }
        setBackButtonEnabled(true);
        setTitle(getResources().getString(R.string.traveller_details_title));
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("intent_extra_selected_seats", this.f21908d);
        bundle2.putSerializable("intent_extra_bus_search_input", this.f21909e);
        bundle2.putSerializable("intent_extra_bus_search_result_item", this.f21910f);
        bundle2.putSerializable("intent_extra_passenger_details", this.f21911g);
        bundle2.putSerializable("requestid", this.f21912h);
        bundle2.putSerializable("intent_extra_bus_trip_detail", this.f21913i);
        bundle2.putSerializable("intent_extra_selected_boarding_point", this.j);
        bundle2.putSerializable("intent_extra_selected_dropping_point", this.k);
        bundle2.putBoolean("isSingleLady", this.l);
        bundle2.putSerializable("intent_extra_bus_search_load_data", this.n);
        CJRBusUserProfile cJRBusUserProfile = this.m;
        if (cJRBusUserProfile != null) {
            bundle2.putSerializable("traveller_details_key", cJRBusUserProfile);
        }
        this.f21907c = m.b(bundle2);
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        a2.a(frameLayout.getId(), this.f21907c, f21905a);
        a2.b();
        if (this.mActionBar == null) {
            this.mActionBar = getSupportActionBar();
        }
        this.mActionBar.a(false);
        this.mActionBar.b(false);
        this.mActionBar.a(1.0f);
        this.mActionBar.a(R.layout.pre_b_lyt_bus_traveler_detail_action_bar);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.bus_seat_title_text_start);
        RoboTextView roboTextView2 = (RoboTextView) findViewById(R.id.bus_seat_title_text_end);
        RoboTextView roboTextView3 = (RoboTextView) findViewById(R.id.bus_seat_subtitle_text_start);
        CJRBusSearchItem cJRBusSearchItem = this.f21910f;
        String str2 = null;
        String source = (cJRBusSearchItem == null || TextUtils.isEmpty(cJRBusSearchItem.getSource())) ? null : this.f21910f.getSource();
        CJRBusSearchItem cJRBusSearchItem2 = this.f21910f;
        String destination = (cJRBusSearchItem2 == null || TextUtils.isEmpty(cJRBusSearchItem2.getDestination())) ? null : this.f21910f.getDestination();
        if (!TextUtils.isEmpty(source) && !TextUtils.isEmpty(destination)) {
            roboTextView.setText(source);
            roboTextView2.setText(destination);
        }
        CJRBusSearchItem cJRBusSearchItem3 = this.f21910f;
        if (cJRBusSearchItem3 == null || TextUtils.isEmpty(cJRBusSearchItem3.getDepartureDatetime())) {
            str = null;
        } else {
            getApplicationContext();
            str = com.paytm.utility.b.d(this.f21910f.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "E, d MMM");
        }
        CJRBusSearchItem cJRBusSearchItem4 = this.f21910f;
        if (cJRBusSearchItem4 != null && !TextUtils.isEmpty(cJRBusSearchItem4.getArrivalDatetime())) {
            getApplicationContext();
            str2 = com.paytm.utility.b.d(this.f21910f.getArrivalDatetime(), "yyyy-MM-dd HH:mm:ss", "E, d MMM");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            roboTextView3.setText(str);
        }
        ((ImageView) findViewById(R.id.bus_seat_back_button)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusTravellerDetailsActivity.this.a(view);
            }
        });
        com.travel.bus.a.a();
        com.travel.bus.a.b().a("/bus-tickets/passenger-details", "BusTicket", (Context) this);
        com.travel.bus.a.a();
        com.travel.bus.a.b().a("/bus-tickets-traveller", "BusTicket", (Context) this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.o = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        a(-1);
        HashMap hashMap = new HashMap();
        hashMap.put("event_label2", this.f21909e.getSource().getDisplayCityName() + "/" + this.f21909e.getDestination().getDisplayCityName());
        try {
            hashMap.put("event_label3", this.f21913i.getMeta().getProvider().getName());
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-traveller", "bus_passenger", "back_clicked", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Passenger Details Screen");
        com.travel.bus.a.a();
        com.travel.bus.a.b().a("bus_passenger_back_clicked", (Map<String, Object>) hashMap2, (Context) this);
    }

    private void a(int i2) {
        m mVar = (m) getSupportFragmentManager().c(f21905a);
        if (mVar != null) {
            Bundle a2 = mVar.a();
            this.f21911g = (ArrayList) a2.getSerializable("intent_extra_passenger_details");
            this.j = (CJRLocation) a2.getSerializable("intent_extra_selected_boarding_point");
        }
        Intent intent = new Intent();
        ArrayList<CJRPassengerDetails> arrayList = this.f21911g;
        if (arrayList != null) {
            intent.putExtra("intent_extra_passenger_details", arrayList);
        }
        CJRLocation cJRLocation = this.j;
        if (cJRLocation != null) {
            intent.putExtra("intent_extra_selected_boarding_point", cJRLocation);
        }
        setResult(i2, intent);
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        m mVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2 && i3 == 3) {
            a(3);
        } else if (i3 == 4) {
            finish();
            Intent intent2 = new Intent(this, AJRBusSearchSRPActivity.class);
            intent2.addFlags(67108864);
            intent2.addFlags(268435456);
            startActivity(intent2);
        } else if (i3 == 9) {
            setResult(9);
        } else if (i2 == 2 && i3 == 11 && (mVar = this.f21907c) != null) {
            mVar.onActivityResult(i2, i3, intent);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if ((currentFocus instanceof EditText) && !(currentFocus instanceof AutoCompleteTextView)) {
                Rect rect = new Rect();
                currentFocus.getGlobalVisibleRect(rect);
                if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void a(String str, String str2, String str3) {
        if (!this.o) {
            l lVar = new l();
            lVar.setCancelable(false);
            Bundle bundle = new Bundle();
            bundle.putString("bus_sold_out_title", str);
            bundle.putString("bus_sold_out_message", str2);
            bundle.putString("bus_sold_out_button_txt", str3);
            lVar.setArguments(bundle);
            lVar.show(getSupportFragmentManager(), "bus_sold_out_tag");
        }
    }

    public final void a() {
        Intent intent = new Intent(this, AJRBusSearchSRPActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
    }
}
