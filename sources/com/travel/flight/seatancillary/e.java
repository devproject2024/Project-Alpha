package com.travel.flight.seatancillary;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gsonhtcfix.f;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.pojo.model.CJRSeatSelection;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.pojo.seatancillaryentity.a;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatAvail;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatNotes;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatPClass;
import com.travel.flight.pojo.seatancillaryentity.b;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeat;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatJourneyType;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatText;
import com.travel.flight.seatancillary.CustomScrollView;
import com.travel.flight.seatancillary.b.a;
import com.travel.flight.tooltipwidget.ToolTipRelativeLayout;
import com.travel.flight.tooltipwidget.ToolTipView;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.i.h;

public class e extends h implements View.OnClickListener, ToolTipView.c {
    private String A;
    private View B;
    private b C;
    private ArrayList<a> D = new ArrayList<>();
    private int E = 0;
    private int F = -1;
    private boolean G;

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f25475a;

    /* renamed from: b  reason: collision with root package name */
    com.travel.flight.seatancillary.a.a f25476b;

    /* renamed from: c  reason: collision with root package name */
    int f25477c;

    /* renamed from: d  reason: collision with root package name */
    int f25478d;

    /* renamed from: e  reason: collision with root package name */
    boolean f25479e = true;

    /* renamed from: f  reason: collision with root package name */
    CJRSeatNotes f25480f;

    /* renamed from: g  reason: collision with root package name */
    View f25481g;

    /* renamed from: h  reason: collision with root package name */
    TextView f25482h;

    /* renamed from: i  reason: collision with root package name */
    TextView f25483i;
    TextView j;
    TextView k;
    ImageView l;
    AlertDialog.Builder m;
    AlertDialog n;
    CustomScrollView o;
    Handler p = new Handler();
    Runnable q;
    String r;
    private CJRSeatJourneyType s;
    private CJRSeatJourneyType t;
    private ViewGroup u;
    private a.C0476a v;
    private CJRTravellerSeatTransition w;
    private ToolTipView x;
    private ToolTipRelativeLayout y;
    private String z;

    public static e a(CJRSeatJourneyType cJRSeatJourneyType, CJRSeatJourneyType cJRSeatJourneyType2, CJRTravellerSeatTransition cJRTravellerSeatTransition, a.C0476a aVar, CJRSeatNotes cJRSeatNotes) {
        e eVar = new e();
        eVar.v = aVar;
        Bundle bundle = new Bundle();
        bundle.putSerializable("flightSeatancillaryLayoutArgument", cJRSeatJourneyType);
        bundle.putSerializable("flightSeatAvailabilityancillaryLayoutArgument", cJRSeatJourneyType2);
        bundle.putSerializable("extra_intent_travellers_list", cJRTravellerSeatTransition);
        bundle.putParcelable("extra_intent_notes", cJRSeatNotes);
        eVar.setArguments(bundle);
        return eVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (CJRSeatJourneyType) getArguments().getSerializable("flightSeatancillaryLayoutArgument");
        this.t = (CJRSeatJourneyType) getArguments().getSerializable("flightSeatAvailabilityancillaryLayoutArgument");
        this.w = (CJRTravellerSeatTransition) getArguments().getSerializable("extra_intent_travellers_list");
        this.f25480f = (CJRSeatNotes) getArguments().getParcelable("extra_intent_notes");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pre_f_fragment_seatancillary_base, (ViewGroup) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        int[] iArr;
        TextView textView;
        int i2;
        CJRSeatJourneyType cJRSeatJourneyType;
        boolean z2;
        char c2;
        super.onViewCreated(view, bundle);
        this.f25477c = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel(10.0f, getContext());
        this.f25478d = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel(14.0f, getContext());
        this.u = (ViewGroup) getView().findViewById(R.id.layoutSeat);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) getView().findViewById(R.id.flight_head), "flight_head.png", false, false, n.a.V1);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) getView().findViewById(R.id.flight_tail), "flight_tail.png", false, false, n.a.V1);
        this.f25475a = (RecyclerView) getView().findViewById(R.id.recyclerView);
        this.y = (ToolTipRelativeLayout) getView().findViewById(R.id.activity_main_tooltipframelayout);
        this.o = (CustomScrollView) getView().findViewById(R.id.scrollView);
        this.f25475a.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        CJRSeatJourneyType cJRSeatJourneyType2 = this.s;
        CJRSeatJourneyType cJRSeatJourneyType3 = this.t;
        if (!(cJRSeatJourneyType2 == null || cJRSeatJourneyType3 == null)) {
            new f();
            int[] displayHeightWidth = com.travel.flight.seatancillary.c.a.getDisplayHeightWidth(getActivity());
            List<CJRSeat> cJRSeats = cJRSeatJourneyType2.getLower().getCJRSeatWidgets().getCJRSeats();
            List<CJRSeatText> cJRSeatTexts = cJRSeatJourneyType2.getLower().getCJRSeatWidgets().getCJRSeatTexts();
            cJRSeatJourneyType2.getLower().getCJRSeatWidgets().getCJRSeatWings();
            boolean z3 = true;
            float convertPixelsToDp = com.travel.flight.seatancillary.c.a.convertPixelsToDp((float) displayHeightWidth[1], getContext()) / ((float) cJRSeatJourneyType2.getLower().getWidgetMeta().getCJRSeatLayout().getWidth().intValue());
            HashMap<String, CJRSeatAvail> availibility = cJRSeatJourneyType3.getLower().getAvailibility();
            HashMap<String, CJRSeatPClass> groups = cJRSeatJourneyType3.getLower().getGroups();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, CJRSeatPClass> value : groups.entrySet()) {
                arrayList.add(value.getValue());
            }
            this.f25476b = new com.travel.flight.seatancillary.a.a(getContext(), arrayList);
            this.f25475a.setAdapter(this.f25476b);
            if (!com.travel.flight.seatancillary.c.a.isSeatsAlreadySelected(cJRSeatJourneyType3.getFlightNumber(), cJRSeatJourneyType3.getOrigin(), cJRSeatJourneyType3.getDestination(), this.w) && cJRSeatJourneyType3.getPreselects() != null && cJRSeatJourneyType3.getPreselects().size() > 0) {
                com.travel.flight.seatancillary.c.a.setPreselectSeatsToTravelerList(cJRSeatJourneyType3.getPreselects(), cJRSeatJourneyType3.getFlightNumber(), cJRSeatJourneyType3.getOrigin(), cJRSeatJourneyType3.getDestination(), this.w);
            }
            if (cJRSeatJourneyType3 != null) {
                this.A = cJRSeatJourneyType3.getDestination();
                this.z = cJRSeatJourneyType3.getOrigin();
                this.r = cJRSeatJourneyType3.getFlightNumber();
            }
            int i3 = 0;
            while (i3 < cJRSeats.size()) {
                TextView textView2 = new TextView(getContext());
                b bVar = new b();
                bVar.setOrigin(cJRSeatJourneyType2.getOrigin());
                bVar.setDestination(cJRSeatJourneyType2.getDestination());
                bVar.setFlightNumber(cJRSeatJourneyType2.getFlightNumber());
                if (cJRSeatJourneyType2.getLower() != null) {
                    bVar.setDeck("lower");
                } else if (cJRSeatJourneyType2.getUpper() != null) {
                    bVar.setDeck("upper");
                }
                if (availibility.containsKey(cJRSeats.get(i3).getNumber())) {
                    CJRSeatAvail cJRSeatAvail = availibility.get(cJRSeats.get(i3).getNumber());
                    bVar.setSeatAvailable(z3);
                    bVar.setSelectMsg(cJRSeatAvail.getSelectMsg());
                    cJRSeatJourneyType = cJRSeatJourneyType2;
                    z2 = com.travel.flight.seatancillary.c.a.isSeatTobeSelected(cJRSeatJourneyType2.getFlightNumber(), cJRSeatJourneyType2.getOrigin(), cJRSeatJourneyType2.getDestination(), cJRSeats.get(i3).getNumber(), this.w);
                    if (groups.containsKey(cJRSeatAvail.getGroup())) {
                        CJRSeatPClass cJRSeatPClass = groups.get(cJRSeatAvail.getGroup());
                        bVar.setSeatNumber(cJRSeats.get(i3).getNumber());
                        bVar.setSeatCode(cJRSeatAvail.getCode());
                        bVar.setSeatPrice((double) cJRSeatPClass.getAmount().intValue());
                        bVar.setCJRSeatTaxes(cJRSeatPClass.getCJRSeatTaxes());
                        bVar.setSeatColor(cJRSeatPClass.getCJRSeatLegend().getColor());
                        bVar.setEmergencyExit(Boolean.valueOf(cJRSeatAvail.getEmExit()));
                        textView2.setBackgroundResource(R.drawable.pre_f_ic_seats_book);
                        if (Build.VERSION.SDK_INT >= 21) {
                            textView2.getBackground().setTint(Color.parseColor(cJRSeatPClass.getCJRSeatLegend().getColor()));
                        } else {
                            textView2.getBackground().mutate().setColorFilter(Color.parseColor(cJRSeatPClass.getCJRSeatLegend().getColor()), PorterDuff.Mode.SRC_ATOP);
                        }
                    } else {
                        textView2.setBackgroundResource(R.drawable.pre_f_ic_seats_book);
                    }
                    c2 = 1;
                } else {
                    cJRSeatJourneyType = cJRSeatJourneyType2;
                    textView2.setBackgroundResource(R.drawable.pre_f_ic_seats_book);
                    if (Build.VERSION.SDK_INT >= 21) {
                        textView2.getBackground().setTint(-3355444);
                    } else {
                        textView2.getBackground().mutate().setColorFilter(-3355444, PorterDuff.Mode.SRC_ATOP);
                    }
                    bVar.setSeatAvailable(false);
                    c2 = 1;
                    z2 = false;
                }
                int convertDpToPixel = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel((com.travel.flight.seatancillary.c.a.convertPixelsToDp((float) displayHeightWidth[c2], getContext()) / 1080.0f) * 100.0f, getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(convertDpToPixel, convertDpToPixel);
                layoutParams.topMargin = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) cJRSeats.get(i3).getY().intValue()) * convertPixelsToDp, getContext());
                layoutParams.leftMargin = ((int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) cJRSeats.get(i3).getX().intValue()) * convertPixelsToDp, getContext())) + this.f25477c;
                this.u.addView(textView2, layoutParams);
                textView2.setTextColor(-1);
                textView2.setTag(bVar);
                textView2.setText("");
                textView2.setTextSize(1, 9.0f);
                textView2.setId(i3);
                textView2.setOnClickListener(this);
                textView2.setGravity(17);
                textView2.setPadding(0, 0, 0, 5);
                if (z2) {
                    b(textView2, bVar);
                }
                i3++;
                cJRSeatJourneyType2 = cJRSeatJourneyType;
                z3 = true;
            }
            int i4 = 0;
            while (i4 < cJRSeatTexts.size()) {
                TextView textView3 = new TextView(getContext());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                int convertDpToPixel2 = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel((com.travel.flight.seatancillary.c.a.convertPixelsToDp((float) displayHeightWidth[1], getContext()) / 1080.0f) * 100.0f, getContext());
                if (cJRSeatTexts.get(i4).getText().length() < 5) {
                    textView = textView3;
                    iArr = displayHeightWidth;
                    layoutParams2.topMargin = ((int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) cJRSeatTexts.get(i4).getY().intValue()) * convertPixelsToDp, getContext())) + 14;
                    layoutParams2.leftMargin = ((int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) (cJRSeatTexts.get(i4).getX().intValue() + 1)) * convertPixelsToDp, getContext())) + this.f25478d;
                    textView.setTextSize(1, 12.0f);
                    this.u.addView(textView, layoutParams2);
                    i2 = 17;
                } else if ("EXTRA LEGROOM".equals(cJRSeatTexts.get(i4).getText())) {
                    com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) cJRSeatTexts.get(i4).getWidth().intValue()) * convertPixelsToDp, getContext());
                    int convertDpToPixel3 = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) cJRSeatTexts.get(i4).getHeight().intValue()) * convertPixelsToDp, getContext());
                    LinearLayout linearLayout = new LinearLayout(getContext());
                    linearLayout.setOrientation(0);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams3.setMarginEnd(5);
                    }
                    ImageView imageView = new ImageView(getContext());
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, convertDpToPixel3, 2.0f);
                    ResourceUtils.loadFlightImagesFromCDN(imageView, "ss_double_arrow.png", false, false, n.a.V1);
                    layoutParams4.gravity = 16;
                    TextView textView4 = new TextView(getContext());
                    iArr = displayHeightWidth;
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2, 6.0f);
                    textView4.setTextSize(1, 12.0f);
                    textView4.setText(cJRSeatTexts.get(i4).getText());
                    textView4.setTextColor(-16777216);
                    textView4.setGravity(17);
                    if (Build.VERSION.SDK_INT >= 21) {
                        textView4.setLetterSpacing(0.4f);
                    }
                    layoutParams5.gravity = 17;
                    ImageView imageView2 = new ImageView(getContext());
                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, convertDpToPixel3, 2.0f);
                    ResourceUtils.loadFlightImagesFromCDN(imageView2, "ss_double_arrow.png", false, false, n.a.V1);
                    layoutParams6.gravity = 16;
                    layoutParams3.topMargin = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) (cJRSeatTexts.get(i4).getY().intValue() - 2)) * convertPixelsToDp, getContext());
                    layoutParams3.leftMargin = ((int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) (cJRSeatTexts.get(i4).getX().intValue() - 1)) * convertPixelsToDp, getContext())) + this.f25478d;
                    linearLayout.addView(imageView, layoutParams4);
                    linearLayout.addView(textView4, layoutParams5);
                    linearLayout.addView(imageView2, layoutParams6);
                    this.u.addView(linearLayout, layoutParams3);
                    textView = textView3;
                    i2 = 17;
                } else {
                    TextView textView5 = textView3;
                    iArr = displayHeightWidth;
                    FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(convertDpToPixel2, -2);
                    layoutParams7.topMargin = (int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) cJRSeatTexts.get(i4).getY().intValue()) * convertPixelsToDp, getContext());
                    layoutParams7.leftMargin = ((int) com.travel.flight.seatancillary.c.a.convertDpToPixel(((float) (cJRSeatTexts.get(i4).getX().intValue() - 1)) * convertPixelsToDp, getContext())) + this.f25478d;
                    textView = textView5;
                    textView.setTextSize(1, 9.0f);
                    this.u.addView(textView, layoutParams7);
                    i2 = 17;
                }
                textView.setGravity(i2);
                textView.setTag(cJRSeatTexts.get(i4));
                textView.setText(cJRSeatTexts.get(i4).getText());
                textView.setTextColor(-16777216);
                i4++;
                displayHeightWidth = iArr;
            }
        }
        this.o.setOnScrollChangedListener(new CustomScrollView.a() {
            public final void a() {
                e.this.a();
            }
        });
    }

    public void setMenuVisibility(boolean z2) {
        String str;
        a.C0476a aVar;
        super.setMenuVisibility(z2);
        if (z2 && (str = this.r) != null && (aVar = this.v) != null) {
            aVar.a(str, this.z, this.A);
        }
    }

    public void onClick(final View view) {
        CJRTravellerSeatTransition cJRTravellerSeatTransition;
        final b bVar = (b) view.getTag();
        if (bVar.isSeatAvailable()) {
            if (!bVar.isSeatSelected()) {
                if (com.travel.flight.seatancillary.c.a.isSeatLimitReached(bVar, this.w)) {
                    ArrayList<com.travel.flight.pojo.seatancillaryentity.a> arrayList = this.D;
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList<com.travel.flight.pojo.seatancillaryentity.a> arrayList2 = this.D;
                        if (!(arrayList2 == null || arrayList2.size() <= 0 || (cJRTravellerSeatTransition = this.w) == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null || this.w.getOnwardSeatSelections().size() <= 0)) {
                            for (int i2 = 0; i2 < this.w.getOnwardSeatSelections().size(); i2++) {
                                CJRSeatSelection cJRSeatSelection = this.w.getOnwardSeatSelections().get(i2);
                                if (com.travel.flight.seatancillary.c.a.isHopMatched(bVar.getFlightNumber(), bVar.getOrigin(), bVar.getDestination(), cJRSeatSelection)) {
                                    if (this.E == 0) {
                                        this.E = cJRSeatSelection.getmSeatSelectedItems().size();
                                    }
                                    int i3 = this.E;
                                    if (i3 - 1 >= 0 && i3 - 1 < this.D.size()) {
                                        a(this.D.get(this.E - 1).getView(), this.D.get(this.E - 1).getCJRSeatInfo());
                                    }
                                }
                            }
                        }
                        this.E--;
                    } else {
                        return;
                    }
                }
                if (bVar.getEmergencyExit().booleanValue()) {
                    if (this.f25481g == null) {
                        this.f25481g = getLayoutInflater().inflate(R.layout.pre_f_layout_emergency_exit_dialog, (ViewGroup) null);
                        this.f25482h = (TextView) this.f25481g.findViewById(R.id.title);
                        this.f25483i = (TextView) this.f25481g.findViewById(R.id.content);
                        this.j = (TextView) this.f25481g.findViewById(R.id.desc);
                        this.k = (TextView) this.f25481g.findViewById(R.id.agree);
                        this.l = (ImageView) this.f25481g.findViewById(R.id.closeAlert);
                        ResourceUtils.loadFlightImagesFromCDN(this.l, "close_icon.png", false, false, n.a.V1);
                        this.m = new AlertDialog.Builder(getActivity());
                        this.m.setView(this.f25481g);
                        this.m.setCancelable(true);
                        this.f25482h.setText(this.f25480f.getCJRSeatEmergencyExit().getTitle());
                        this.j.setText(this.f25480f.getCJRSeatEmergencyExit().getDescription());
                        StringBuilder sb = new StringBuilder();
                        for (String str : this.f25480f.getCJRSeatEmergencyExit().getContents()) {
                            sb.append("• " + str + StringUtility.NEW_LINE);
                        }
                        this.f25483i.setText(sb.toString());
                        this.n = this.m.create();
                        this.l.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                e.this.n.dismiss();
                            }
                        });
                    }
                    this.k.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            view.setBackgroundResource(R.drawable.pre_f_ic_seats_booked);
                            if (Build.VERSION.SDK_INT >= 21) {
                                ((TextView) view).getBackground().setTint(Color.parseColor(bVar.getSeatColor()));
                            } else {
                                ((TextView) view).getBackground().mutate().setColorFilter(Color.parseColor(bVar.getSeatColor()), PorterDuff.Mode.SRC_ATOP);
                            }
                            e.this.b(view, bVar);
                            e.this.n.dismiss();
                            e.this.c(view, bVar);
                        }
                    });
                    this.n.show();
                } else {
                    view.setBackgroundResource(R.drawable.pre_f_ic_seats_booked);
                    b(view, bVar);
                    c(view, bVar);
                }
            } else {
                this.G = true;
                a(view, bVar);
                a();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ((TextView) view).getBackground().setTint(Color.parseColor(bVar.getSeatColor()));
            } else {
                ((TextView) view).getBackground().mutate().setColorFilter(Color.parseColor(bVar.getSeatColor()), PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            Toast.makeText(getContext(), "This seat is not available", 0).show();
        }
    }

    private void a(View view, b bVar) {
        view.setBackgroundResource(R.drawable.pre_f_ic_seats_book);
        if (Build.VERSION.SDK_INT >= 21) {
            ((TextView) view).getBackground().setTint(Color.parseColor(bVar.getSeatColor()));
        } else {
            ((TextView) view).getBackground().mutate().setColorFilter(Color.parseColor(bVar.getSeatColor()), PorterDuff.Mode.SRC_ATOP);
        }
        ((TextView) view).setText("");
        bVar.setSeatSelected(false);
        a.C0476a aVar = this.v;
        if (aVar != null) {
            aVar.b(bVar);
        }
        int i2 = this.E;
        if (i2 == 0 || i2 - 1 >= this.D.size() || this.G) {
            this.G = false;
            com.travel.flight.pojo.seatancillaryentity.a aVar2 = new com.travel.flight.pojo.seatancillaryentity.a();
            aVar2.setCJRSeatInfo(bVar);
            aVar2.setView(view);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.D.size(); i3++) {
                com.travel.flight.pojo.seatancillaryentity.a aVar3 = this.D.get(i3);
                if (aVar3 == null || aVar3.getCJRSeatInfo() == null || aVar3.getCJRSeatInfo().getSeatNumber() == null || aVar2.getCJRSeatInfo() == null || aVar2.getCJRSeatInfo().getSeatNumber() == null || !aVar2.getCJRSeatInfo().getSeatNumber().equals(aVar3.getCJRSeatInfo().getSeatNumber())) {
                    arrayList.add(aVar3);
                } else {
                    this.F = i3;
                }
            }
            this.D.clear();
            this.D.addAll(arrayList);
            return;
        }
        ArrayList<com.travel.flight.pojo.seatancillaryentity.a> arrayList2 = this.D;
        arrayList2.remove(arrayList2.get(this.E - 1));
    }

    /* access modifiers changed from: private */
    public void b(View view, b bVar) {
        this.C = bVar;
        this.B = view;
        view.setBackgroundResource(R.drawable.pre_f_ic_seats_booked);
        if (Build.VERSION.SDK_INT >= 21) {
            ((TextView) view).getBackground().setTint(Color.parseColor(bVar.getSeatColor()));
        } else {
            ((TextView) view).getBackground().mutate().setColorFilter(Color.parseColor(bVar.getSeatColor()), PorterDuff.Mode.SRC_ATOP);
        }
        ((TextView) view).setText(bVar.getSeatNumber());
        bVar.setSeatSelected(true);
        a.C0476a aVar = this.v;
        if (aVar != null) {
            aVar.a(bVar);
        }
        int i2 = this.E;
        if (i2 != 0 && i2 <= this.D.size()) {
            com.travel.flight.pojo.seatancillaryentity.a aVar2 = new com.travel.flight.pojo.seatancillaryentity.a();
            aVar2.setCJRSeatInfo(bVar);
            aVar2.setView(view);
            this.D.add(this.E, aVar2);
        } else if (this.F >= 0) {
            com.travel.flight.pojo.seatancillaryentity.a aVar3 = new com.travel.flight.pojo.seatancillaryentity.a();
            aVar3.setCJRSeatInfo(bVar);
            aVar3.setView(view);
            this.D.add(this.F, aVar3);
            this.F = -1;
        } else {
            com.travel.flight.pojo.seatancillaryentity.a aVar4 = new com.travel.flight.pojo.seatancillaryentity.a();
            aVar4.setCJRSeatInfo(bVar);
            aVar4.setView(view);
            this.D.add(aVar4);
        }
    }

    /* access modifiers changed from: private */
    public void c(View view, b bVar) {
        String str;
        if (this.x != null) {
            a();
        }
        String selectMsg = bVar.getSelectMsg();
        char c2 = 65535;
        switch (selectMsg.hashCode()) {
            case -1451690673:
                if (selectMsg.equals("non_reclining")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1333600325:
                if (selectMsg.equals("extra_leg_room")) {
                    c2 = 1;
                    break;
                }
                break;
            case -433482760:
                if (selectMsg.equals("free_seat")) {
                    c2 = 3;
                    break;
                }
                break;
            case 27234275:
                if (selectMsg.equals("SG_combo")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            str = this.f25480f.getSGCombo();
        } else if (c2 == 1) {
            str = this.f25480f.getExtraLegRoom();
        } else if (c2 != 2) {
            str = c2 != 3 ? "" : this.f25480f.getFreeSeat();
        } else {
            str = this.f25480f.getNonReclining();
        }
        com.travel.flight.tooltipwidget.a a2 = new com.travel.flight.tooltipwidget.a().a(getString(R.string.rupees) + String.valueOf((int) bVar.getSeatPrice()), com.travel.flight.seatancillary.c.a.getPassengerName(bVar.getSeatNumber(), this.w, this.r, this.z, this.A) + " - " + bVar.getSeatNumber(), str);
        a2.f25517f = true;
        this.x = this.y.a(a2, view);
        this.x.setOnToolTipViewClickedListener(this);
        Runnable runnable = this.q;
        if (runnable != null) {
            this.p.removeCallbacks(runnable);
        }
        this.q = new Runnable() {
            public final void run() {
                e.this.a();
            }
        };
        this.p.postDelayed(this.q, 2000);
    }

    /* access modifiers changed from: private */
    public void a() {
        ToolTipView toolTipView = this.x;
        if (toolTipView != null) {
            toolTipView.a();
            this.x = null;
        }
    }
}
