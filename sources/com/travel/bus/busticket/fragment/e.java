package com.travel.bus.busticket.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.travel.bus.busticket.a.aa;
import com.travel.bus.busticket.a.k;
import com.travel.bus.busticket.activity.AJRConfirmBookingActivity;
import com.travel.bus.busticket.f.c;
import com.travel.bus.pojo.bussearch.CJRDealDecorator;
import com.travel.bus.pojo.busticket.CJRBlockOneModel;
import com.travel.bus.pojo.busticket.CJRBlockOneResponse;
import com.travel.bus.pojo.busticket.CJRBusCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusInsuranceItem;
import com.travel.bus.pojo.busticket.CJRBusInsurancePlans;
import com.travel.bus.pojo.busticket.CJRBusReviewCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusReviewCancellationPolicyBody;
import com.travel.bus.pojo.busticket.CJRBusReviewCancellationPolicyOnward;
import com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRTaxItem;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import com.travel.bus.pojo.busticket.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class e extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BottomSheetBehavior f22240a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f22241b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f22242c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22243d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22244e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f22245f;

    /* renamed from: g  reason: collision with root package name */
    private RoboTextView f22246g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f22247h;

    /* renamed from: i  reason: collision with root package name */
    private RoboTextView f22248i;
    private LinearLayout j;
    private LinearLayout k;
    private Button l;
    private CJRBusInsuranceItem m;
    private CJRBusInsurancePlans n;
    private ArrayList<TripBusDetailsItem> o;
    private boolean p = false;
    private TripBusDetail q;
    private CJRBusSearchInput r;
    private CJRBusSearchItem s;
    private CJRBlockOneResponse t;
    private CJRBusReviewCancellationPolicy u;
    private double v = 0.0d;
    private c w;
    private LinearLayout x;
    private TextView y;

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                e.this.a(dialogInterface);
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        if (frameLayout != null) {
            this.f22240a = BottomSheetBehavior.from(frameLayout);
        }
        this.f22240a.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    e.this.f22240a.setState(3);
                }
                if (i2 == 5 && e.this.getDialog() != null) {
                    e.this.getDialog().dismiss();
                }
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
        if (context instanceof AJRConfirmBookingActivity) {
            this.w = (c) context;
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.travel.bus.R.layout.bus_fare_breakup_bottom_sheet_view, viewGroup, false);
        this.l = (Button) inflate.findViewById(com.travel.bus.R.id.btn_pay_now);
        this.f22241b = (LinearLayout) inflate.findViewById(com.travel.bus.R.id.fare_breakup_recycler);
        this.f22242c = (RelativeLayout) inflate.findViewById(com.travel.bus.R.id.lyt_insurance);
        this.f22244e = (TextView) inflate.findViewById(com.travel.bus.R.id.lbl_insurance);
        this.f22243d = (TextView) inflate.findViewById(com.travel.bus.R.id.value_insurance);
        this.f22245f = (RelativeLayout) inflate.findViewById(com.travel.bus.R.id.lyt_total);
        this.f22246g = (RoboTextView) inflate.findViewById(com.travel.bus.R.id.value_total);
        this.j = (LinearLayout) inflate.findViewById(com.travel.bus.R.id.ll_fare_breakup);
        this.k = (LinearLayout) inflate.findViewById(com.travel.bus.R.id.clTravellerFareBreakup);
        this.f22248i = (RoboTextView) inflate.findViewById(com.travel.bus.R.id.tvTravellerTotalFare);
        this.x = (LinearLayout) inflate.findViewById(com.travel.bus.R.id.awesomeTextLayout);
        this.y = (TextView) inflate.findViewById(com.travel.bus.R.id.awesomeText);
        this.f22247h = (RoboTextView) inflate.findViewById(com.travel.bus.R.id.ri_cancellation_policy);
        this.f22247h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.d(view);
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.c(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.b(view);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.a(view);
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        ArrayList<TripBusDetailsItem> arrayList;
        super.onViewCreated(view, bundle);
        if (getArguments() != null && getArguments().containsKey("bus_select_insurance_intent")) {
            this.m = (CJRBusInsuranceItem) getArguments().getSerializable("bus_select_insurance_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_insurance_plan_intent")) {
            this.n = (CJRBusInsurancePlans) getArguments().getSerializable("bus_insurance_plan_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_select_seat_intent")) {
            this.o = (ArrayList) getArguments().getSerializable("bus_select_seat_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_confirm_trip_intent")) {
            this.q = (TripBusDetail) getArguments().getSerializable("bus_confirm_trip_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_insurance_check_box_intent")) {
            this.p = getArguments().getBoolean("bus_insurance_check_box_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_search_input_intent")) {
            this.r = (CJRBusSearchInput) getArguments().getSerializable("bus_search_input_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_grand_total_intent")) {
            this.v = getArguments().getDouble("bus_grand_total_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_search_item_intent")) {
            this.s = (CJRBusSearchItem) getArguments().getSerializable("bus_search_item_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_block_data_intent")) {
            this.t = (CJRBlockOneResponse) getArguments().getSerializable("bus_block_data_intent");
        }
        if (getArguments() != null && getArguments().containsKey("bus_cancellation_policy_intent")) {
            this.u = (CJRBusReviewCancellationPolicy) getArguments().getSerializable("bus_cancellation_policy_intent");
        }
        CJRBusInsurancePlans cJRBusInsurancePlans = this.n;
        this.m = cJRBusInsurancePlans != null ? cJRBusInsurancePlans.getInsuranceAtIndex(0) : null;
        if (!this.p || (arrayList = this.o) == null || arrayList.size() <= 0 || this.m == null) {
            this.f22242c.setVisibility(8);
        } else {
            this.f22242c.setVisibility(0);
            if (this.m.getTitle() != null) {
                this.f22244e.setText(this.m.getTitle());
            } else {
                this.f22244e.setText(getString(com.travel.bus.R.string.free_cancellation));
            }
            TextView textView = this.f22243d;
            textView.setText(getResources().getString(com.travel.bus.R.string.rs) + " " + (this.m.getPrice() * ((double) this.o.size())));
        }
        this.f22245f.setVisibility(0);
        RoboTextView roboTextView = this.f22246g;
        roboTextView.setText("₹ " + b.a(this.v, "###,###,###.##"));
        this.f22248i.setText(b.a(this.v, "###,###,###.##"));
        a();
    }

    private void a() {
        CJRBlockOneModel blockResponse;
        CJRBlockOneResponse cJRBlockOneResponse = this.t;
        if (cJRBlockOneResponse != null && (blockResponse = cJRBlockOneResponse.getBlockResponse()) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new h(getResources().getString(com.travel.bus.R.string.bus_fare_txt), String.valueOf(blockResponse.getOnwardLeg().getTotalBaseFare())));
            List<CJRTaxItem> taxDetails = blockResponse.getOnwardLeg().getFareBreakup().getFareDetails().getTaxDetails();
            if (taxDetails != null && !taxDetails.isEmpty()) {
                for (CJRTaxItem next : taxDetails) {
                    if (next != null && next.getName() != null && next.getValue() > 0.0d && !next.getName().equalsIgnoreCase("Insurance")) {
                        arrayList.add(new h(next.getName(), String.valueOf(next.getValue())));
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                LayoutInflater from = LayoutInflater.from(getActivity());
                int size = !arrayList.isEmpty() ? arrayList.size() : 0;
                RoboTextView[] roboTextViewArr = new RoboTextView[size];
                RoboTextView[] roboTextViewArr2 = new RoboTextView[size];
                for (int i2 = 0; i2 < size; i2++) {
                    View inflate = from.inflate(com.travel.bus.R.layout.pre_b_bus_farebreakup_item, (ViewGroup) null);
                    roboTextViewArr[i2] = (RoboTextView) inflate.findViewById(com.travel.bus.R.id.item_label_view);
                    roboTextViewArr2[i2] = (RoboTextView) inflate.findViewById(com.travel.bus.R.id.item_value_view);
                    h hVar = (h) arrayList.get(i2);
                    if (hVar != null) {
                        roboTextViewArr[i2].setText(hVar.f22816a);
                        roboTextViewArr2[i2].setText(v.a(getResources().getString(com.travel.bus.R.string.rs), " ", b.b(hVar.f22817b, "###,###,###.##")));
                    }
                    this.f22241b.addView(inflate);
                }
                CJRDealDecorator cJRDealDecorator = blockResponse.getOnwardLeg().dealTextObj;
                if (cJRDealDecorator != null) {
                    this.x.setVisibility(0);
                    this.y.setText(cJRDealDecorator.getDealTxt());
                    try {
                        this.y.setTextColor(Color.parseColor(cJRDealDecorator.getColourTag()));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.w.b();
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b();
    }

    private void b() {
        this.w.c();
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        CJRBusReviewCancellationPolicyBody policyBody;
        ArrayList<CJRBusSearchCancellationPolicy> oldOrderSummaryCancellationPolicy;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Review Itinerary Screen");
            com.travel.bus.a.a();
            com.travel.bus.a.b().a("bus_review_cancellation_policy", (Map<String, Object>) hashMap, (Context) getActivity());
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("event_label", this.s.getOperatorObj().getName());
        hashMap2.put("event_label2", this.r.getSource().getDisplayCityName() + "/" + this.r.getDestination().getDisplayCityName());
        try {
            hashMap2.put("event_label3", this.q.getMeta().getProvider().getName());
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        hashMap2.put("userid", b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-review", "bus_review", "cancellation_policy", hashMap2);
        CJRBusReviewCancellationPolicy cJRBusReviewCancellationPolicy = this.u;
        if (cJRBusReviewCancellationPolicy != null && cJRBusReviewCancellationPolicy.getPolicyBody() != null && (policyBody = this.u.getPolicyBody()) != null && policyBody.getPolicyOnward() != null) {
            CJRBusReviewCancellationPolicyOnward policyOnward = policyBody.getPolicyOnward();
            if (policyOnward != null && policyOnward.getNewOrderSummaryCancellationPolicy() != null && policyOnward.getNewOrderSummaryCancellationPolicy().size() > 0) {
                ArrayList<CJRBusCancellationPolicy> newOrderSummaryCancellationPolicy = policyOnward.getNewOrderSummaryCancellationPolicy();
                if (newOrderSummaryCancellationPolicy != null && newOrderSummaryCancellationPolicy.size() > 0) {
                    k kVar = new k(newOrderSummaryCancellationPolicy);
                    Dialog dialog = new Dialog(getActivity());
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(com.travel.bus.R.layout.pre_b_bus_new_cancellation_policy_dialog);
                    Window window = dialog.getWindow();
                    window.setBackgroundDrawableResource(17170445);
                    window.setLayout(-1, -2);
                    RecyclerView recyclerView = (RecyclerView) dialog.findViewById(com.travel.bus.R.id.recycler_view);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
                    recyclerView.setAdapter(kVar);
                    ((Button) dialog.findViewById(com.travel.bus.R.id.button_submit_password)).setOnClickListener(new View.OnClickListener(dialog) {
                        private final /* synthetic */ Dialog f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onClick(View view) {
                            this.f$0.dismiss();
                        }
                    });
                    dialog.show();
                }
            } else if (policyOnward != null && policyOnward.getOldOrderSummaryCancellationPolicy() != null && policyOnward.getOldOrderSummaryCancellationPolicy().size() > 0 && (oldOrderSummaryCancellationPolicy = policyOnward.getOldOrderSummaryCancellationPolicy()) != null && oldOrderSummaryCancellationPolicy.size() > 0) {
                aa aaVar = new aa(getActivity(), oldOrderSummaryCancellationPolicy, "");
                Dialog dialog2 = new Dialog(getActivity());
                dialog2.requestWindowFeature(1);
                dialog2.setContentView(com.travel.bus.R.layout.pre_b_bus_cancellation_policy_dialog);
                Window window2 = dialog2.getWindow();
                window2.setBackgroundDrawableResource(17170445);
                window2.setLayout(-1, -2);
                ((ListView) dialog2.findViewById(com.travel.bus.R.id.cancellation_policy_listview)).setAdapter(aaVar);
                ((Button) dialog2.findViewById(com.travel.bus.R.id.button_submit_password)).setOnClickListener(new View.OnClickListener(dialog2) {
                    private final /* synthetic */ Dialog f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onClick(View view) {
                        this.f$0.dismiss();
                    }
                });
                dialog2.show();
            }
        }
    }
}
