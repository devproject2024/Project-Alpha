package com.travel.flight.flightSRPV2.c;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b.bs;
import com.travel.flight.flightSRPV2.a.ae;
import com.travel.flight.flightSRPV2.a.ag;
import com.travel.flight.flightSRPV2.a.r;
import com.travel.flight.flightSRPV2.a.s;
import com.travel.flight.flightSRPV2.a.v;
import com.travel.flight.flightSRPV2.a.w;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.a.z;
import com.travel.flight.flightSRPV2.view.ui.a.m;
import com.travel.flight.flightSRPV2.view.ui.a.o;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight;
import com.travel.flight.flightticket.widget.RangeSeekBarFlight;
import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightPrice;
import com.travel.flight.pojo.flightticket.CJRFlightPriceDiscounts;
import com.travel.flight.pojo.flightticket.CJRFlightPriceDiscountsPromoDetails;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import com.travel.flight.span.TopAlignProportionalSpan;
import com.travel.model.CalendarDatePriceInfo;
import com.travel.utils.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f24155a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.g f24156b = kotlin.h.a(k.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.g f24157c = kotlin.h.a(a.INSTANCE);

    private c() {
    }

    static final class k extends l implements kotlin.g.a.a<SimpleDateFormat> {
        public static final k INSTANCE = new k();

        k() {
            super(0);
        }

        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    }

    static final class a extends l implements kotlin.g.a.a<SimpleDateFormat> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("EEE, dd MMM");
        }
    }

    public static final void a(TextView textView, String str) {
        kotlin.g.b.k.c(textView, "textView");
        CharSequence charSequence = str;
        boolean z = charSequence == null || charSequence.length() == 0;
        if (!z) {
            try {
                textView.setText(((SimpleDateFormat) f24157c.getValue()).format(((SimpleDateFormat) f24156b.getValue()).parse(str)));
            } catch (Exception unused) {
                z = true;
            }
        }
        if (z) {
            textView.setText("");
        }
    }

    public static final void a(TextView textView, int i2) {
        kotlin.g.b.k.c(textView, "textView");
        if (i2 == -1 || i2 == 0) {
            textView.setText("-");
        } else {
            textView.setText(com.travel.flight.utils.c.a((double) i2));
        }
    }

    public static final void a(RecyclerView recyclerView, List<CalendarDatePriceInfo> list, SRPSharedViewModel sRPSharedViewModel) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (list == null || sRPSharedViewModel == null) {
            recyclerView.setAdapter((RecyclerView.a) null);
            return;
        }
        int i2 = 0;
        Iterator<CalendarDatePriceInfo> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            }
            String date = it2.next().getDate();
            String value = sRPSharedViewModel.getSelectedOnwardDate().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            if (p.a(date, value, true)) {
                break;
            }
            i2++;
        }
        if (adapter == null || !(adapter instanceof m)) {
            recyclerView.setAdapter(new m(list, sRPSharedViewModel));
        } else {
            m mVar = (m) adapter;
            kotlin.g.b.k.c(list, "datePriceList");
            kotlin.g.b.k.c(sRPSharedViewModel, "parentViewModel");
            mVar.f24209a = list;
            mVar.f24210b = sRPSharedViewModel;
            mVar.notifyDataSetChanged();
        }
        if (i2 >= 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                recyclerView.scrollToPosition(i2);
                recyclerView.postDelayed(new g(layoutManager, i2, list, recyclerView), 10);
            }
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutManager f24166a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24167b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f24168c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView f24169d;

        g(RecyclerView.LayoutManager layoutManager, int i2, List list, RecyclerView recyclerView) {
            this.f24166a = layoutManager;
            this.f24167b = i2;
            this.f24168c = list;
            this.f24169d = recyclerView;
        }

        public final void run() {
            Integer num;
            int findFirstVisibleItemPosition = ((LinearLayoutManager) this.f24166a).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((LinearLayoutManager) this.f24166a).findLastVisibleItemPosition();
            int i2 = ((findLastVisibleItemPosition - findFirstVisibleItemPosition) + 1) / 2;
            int i3 = this.f24167b;
            if (i3 <= findFirstVisibleItemPosition) {
                num = Integer.valueOf(i3 - i2);
            } else {
                num = i3 >= findLastVisibleItemPosition ? Integer.valueOf(i3 + i2) : null;
            }
            if (num != null) {
                this.f24169d.scrollToPosition(Integer.valueOf(Math.max(0, Math.min(num.intValue() + 1, this.f24168c.size() - 1))).intValue());
            }
        }
    }

    public static final void a(ImageView imageView, String str, Drawable drawable, Drawable drawable2) {
        String str2;
        kotlin.g.b.k.c(imageView, "imageView");
        kotlin.g.b.k.c(drawable, "placeHolderDrawable");
        kotlin.g.b.k.c(drawable2, "errorDrawable");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            StringBuilder sb = new StringBuilder();
            kotlin.g.b.k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
            com.travel.flight.c b2 = com.travel.flight.b.b();
            kotlin.g.b.k.a((Object) b2, "FlightController.getInstance().flightEventListener");
            sb.append(b2.r());
            sb.append(str);
            sb.append(".png");
            str2 = sb.toString();
        } else {
            str2 = null;
        }
        b(imageView, str2, drawable, drawable2);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(android.widget.ImageView r2, java.lang.String r3, android.graphics.drawable.Drawable r4, android.graphics.drawable.Drawable r5) {
        /*
            java.lang.String r0 = "imageView"
            kotlin.g.b.k.c(r2, r0)
            com.paytm.utility.b.b$a r0 = com.paytm.utility.b.b.f43744a
            android.content.Context r0 = r2.getContext()
            java.lang.String r1 = "imageView.context"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a.a(r0)
            r0.f43753a = r3
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            if (r4 != 0) goto L_0x001e
            r4 = r3
        L_0x001e:
            com.paytm.utility.b.b$a$a r4 = r0.a((java.lang.Object) r4)
            if (r5 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r3 = r5
        L_0x0026:
            com.paytm.utility.b.b$a$a r3 = r4.b(r3)
            r4 = 1
            r3.m = r4
            r4 = 0
            r5 = 2
            com.paytm.utility.b.b.a.C0750a.a(r3, r2, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.c.c.b(android.widget.ImageView, java.lang.String, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable):void");
    }

    public static final void a(RecyclerView recyclerView, SRPOneWayViewModel sRPOneWayViewModel, List<? extends CJRFlightDetailsItem> list) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        if (sRPOneWayViewModel != null && list != null) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null || !(adapter instanceof o)) {
                recyclerView.setAdapter(new o(sRPOneWayViewModel, list));
                Context context = recyclerView.getContext();
                kotlin.g.b.k.a((Object) context, "recyclerView.context");
                recyclerView.addItemDecoration(new com.travel.flight.utils.l((int) context.getResources().getDimension(R.dimen.dimen_55dp)));
                return;
            }
            o oVar = (o) adapter;
            kotlin.g.b.k.c(sRPOneWayViewModel, "oneWayViewModel");
            kotlin.g.b.k.c(list, "flightList");
            oVar.f24215a = sRPOneWayViewModel;
            oVar.f24216b = list;
            oVar.notifyDataSetChanged();
            recyclerView.scrollToPosition(0);
        }
    }

    public static final void a(RecyclerView recyclerView, DRTListViewModel dRTListViewModel, List<? extends CJRFlightDetailsItem> list, boolean z) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        if (dRTListViewModel != null && list != null) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null || !(adapter instanceof com.travel.flight.flightSRPV2.view.ui.a.d)) {
                recyclerView.setAdapter(new com.travel.flight.flightSRPV2.view.ui.a.d(list, z, dRTListViewModel));
                return;
            }
            com.travel.flight.flightSRPV2.view.ui.a.d dVar = (com.travel.flight.flightSRPV2.view.ui.a.d) adapter;
            kotlin.g.b.k.c(list, "flightList");
            kotlin.g.b.k.c(dRTListViewModel, "viewModel");
            dVar.f24184a = list;
            dVar.f24185b = z;
            dVar.f24186c = dRTListViewModel;
            dVar.notifyDataSetChanged();
        }
    }

    public static final void a(RecyclerView recyclerView, IRTViewModel iRTViewModel, List<? extends CJRIntlFlightList> list) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        if (list != null && iRTViewModel != null) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null || !(adapter instanceof com.travel.flight.flightSRPV2.view.ui.a.f)) {
                recyclerView.setAdapter(new com.travel.flight.flightSRPV2.view.ui.a.f(iRTViewModel, list));
                Context context = recyclerView.getContext();
                kotlin.g.b.k.a((Object) context, "recyclerView.context");
                recyclerView.addItemDecoration(new com.travel.flight.utils.l((int) context.getResources().getDimension(R.dimen.dimen_50dp)));
                return;
            }
            com.travel.flight.flightSRPV2.view.ui.a.f fVar = (com.travel.flight.flightSRPV2.view.ui.a.f) adapter;
            kotlin.g.b.k.c(list, "flightList");
            fVar.f24189a = list;
            fVar.notifyDataSetChanged();
            recyclerView.scrollToPosition(0);
        }
    }

    public static final void a(RecyclerView recyclerView, IRTSplitViewModel iRTSplitViewModel, List<? extends CJRFlightDetailsItem> list, boolean z) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        kotlin.g.b.k.c(iRTSplitViewModel, "irtSplitViewModel");
        if (list != null) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null || !(adapter instanceof com.travel.flight.flightSRPV2.view.ui.a.g)) {
                recyclerView.setAdapter(new com.travel.flight.flightSRPV2.view.ui.a.g(iRTSplitViewModel, list, z));
                return;
            }
            com.travel.flight.flightSRPV2.view.ui.a.g gVar = (com.travel.flight.flightSRPV2.view.ui.a.g) adapter;
            kotlin.g.b.k.c(list, "flightList");
            gVar.f24191a = list;
            gVar.f24192b = z;
            gVar.notifyDataSetChanged();
        }
    }

    public static final void b(TextView textView, String str) {
        kotlin.g.b.k.c(textView, "textView");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            textView.setText("");
        } else {
            textView.setText(com.travel.flight.utils.c.a(str));
        }
    }

    public static final void a(ImageView imageView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(imageView, "imageView");
        if ((cJRFlightDetailsItem != null ? cJRFlightDetailsItem.getmPrice() : null) == null || cJRFlightDetailsItem.getmPrice().size() <= 0) {
            imageView.setVisibility(8);
            return;
        }
        CJRFlightPrice cJRFlightPrice = cJRFlightDetailsItem.getmPrice().get(0);
        if (cJRFlightPrice == null) {
            throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRFlightPrice");
        } else if (cJRFlightPrice.ismHandBaggageFare()) {
            imageView.setVisibility(0);
            ResourceUtils.loadFlightImagesFromCDN(imageView, "one_way_no_hand_baggage.png", false, false, n.a.V1);
        } else if (!cJRFlightDetailsItem.getMealsAvaialable()) {
            imageView.setVisibility(0);
            ResourceUtils.loadFlightImagesFromCDN(imageView, "rt_no_free_meal.png", false, false, n.a.V1);
        } else {
            imageView.setVisibility(8);
        }
    }

    public static final void a(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem, SRPOneWayViewModel sRPOneWayViewModel) {
        String str;
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation;
        kotlin.g.b.k.c(textView, "textView");
        textView.setVisibility(8);
        if (sRPOneWayViewModel != null && cJRFlightDetailsItem != null) {
            SRPSharedViewModel parentViewModel = sRPOneWayViewModel.getParentViewModel();
            CJRFlightSearchResult value = (parentViewModel != null ? parentViewModel.getSrpResult() : null).getValue();
            if (value == null || (cJROnwardReturnFlightInformation = value.getmOnwardReturnFlights()) == null || (str = cJROnwardReturnFlightInformation.getJourney_type()) == null) {
                str = "";
            }
            CharSequence charSequence = str;
            boolean z = true;
            boolean z2 = !(charSequence == null || p.a(charSequence)) && kotlin.g.b.k.a((Object) str, (Object) net.one97.paytmflight.common.b.b.f30019i);
            if (cJRFlightDetailsItem.getmPrice() != null && cJRFlightDetailsItem.getmPrice().size() > 0) {
                CJRFlightPrice cJRFlightPrice = cJRFlightDetailsItem.getmPrice().get(0);
                if (cJRFlightPrice != null) {
                    CJRFlightPrice cJRFlightPrice2 = cJRFlightPrice;
                    CharSequence charSequence2 = cJRFlightPrice2.getmRefundableText();
                    if (charSequence2 != null && !p.a(charSequence2)) {
                        z = false;
                    }
                    if (!z && !cJRFlightPrice2.ismRefundable()) {
                        if (!z2) {
                            kotlin.g.b.k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                            if (!com.travel.flight.b.b().z()) {
                                return;
                            }
                        }
                        textView.setText(cJRFlightPrice2.getmRefundableText());
                        textView.setVisibility(0);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRFlightPrice");
            }
        }
    }

    public static final void a(LinearLayout linearLayout, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(linearLayout, "lyt");
        linearLayout.setVisibility(8);
        if (cJRFlightDetailsItem != null) {
            ArrayList<CJRFlightPrice> arrayList = cJRFlightDetailsItem.getmPrice();
            Collection collection = arrayList;
            if (!(collection == null || collection.isEmpty()) && arrayList.size() > 0) {
                CJRFlightPriceDiscounts cJRFlightPriceDiscounts = arrayList.get(0).getmDiscounts();
                if ((cJRFlightPriceDiscounts != null ? cJRFlightPriceDiscounts.getPromo_details() : null) != null) {
                    CJRFlightPriceDiscountsPromoDetails promo_details = cJRFlightPriceDiscounts.getPromo_details();
                    if (promo_details == null) {
                        kotlin.g.b.k.a();
                    }
                    CharSequence supporting_text = promo_details.getSupporting_text();
                    if (!(supporting_text == null || supporting_text.length() == 0)) {
                        linearLayout.setVisibility(0);
                        if (linearLayout.getChildAt(0) instanceof ImageView) {
                            View childAt = linearLayout.getChildAt(0);
                            if (childAt != null) {
                                ResourceUtils.loadFlightImagesFromCDN((ImageView) childAt, "fligt_percentage_icon.png", false, false, n.a.V1);
                            } else {
                                throw new u("null cannot be cast to non-null type android.widget.ImageView");
                            }
                        }
                        if (linearLayout.getChildAt(1) instanceof TextView) {
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 != null) {
                                TextView textView = (TextView) childAt2;
                                CJRFlightPriceDiscountsPromoDetails promo_details2 = cJRFlightPriceDiscounts.getPromo_details();
                                if (promo_details2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                textView.setText(promo_details2.getSupporting_text());
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    }
                }
            }
        }
    }

    public static final void a(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        CJRFlightPriceDiscounts cJRFlightPriceDiscounts;
        kotlin.g.b.k.c(textView, "txt");
        textView.setVisibility(8);
        if (cJRFlightDetailsItem != null) {
            ArrayList<CJRFlightPrice> arrayList = cJRFlightDetailsItem.getmPrice();
            Collection collection = arrayList;
            if (!(collection == null || collection.isEmpty()) && arrayList.size() > 0 && (cJRFlightPriceDiscounts = arrayList.get(0).getmDiscounts()) != null) {
                CharSequence original_price = cJRFlightPriceDiscounts.getOriginal_price();
                if (!(original_price == null || original_price.length() == 0)) {
                    aa aaVar = aa.f47921a;
                    String string = textView.getResources().getString(R.string.flight_amount_in_rupees);
                    kotlin.g.b.k.a((Object) string, "txt.getResources().getSt….flight_amount_in_rupees)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{com.travel.flight.utils.c.h(cJRFlightPriceDiscounts.getOriginal_price())}, 1));
                    kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                    CharSequence charSequence = format;
                    String string2 = textView.getResources().getString(R.string.rupee_plain);
                    kotlin.g.b.k.a((Object) string2, "txt.getResources().getString(R.string.rupee_plain)");
                    int a2 = p.a(charSequence, string2, p.d(charSequence));
                    Spannable spannableString = new SpannableString(charSequence);
                    spannableString.setSpan(new TopAlignProportionalSpan(), a2, a2 + 1, 33);
                    spannableString.setSpan(new StrikethroughSpan(), a2, format.length(), 33);
                    textView.setText(spannableString);
                    textView.setVisibility(0);
                }
            }
        }
    }

    public static final void b(TextView textView, int i2) {
        kotlin.g.b.k.c(textView, "textView");
        textView.setVisibility((1 <= i2 && 3 >= i2) ? 0 : 8);
        String string = textView.getContext().getString(R.string.cheapest_flight_text);
        kotlin.g.b.k.a((Object) string, "textView.context.getStri…ing.cheapest_flight_text)");
        if (i2 == 1) {
            textView.setText(string);
        } else if (i2 == 2) {
            textView.setText(i2 + "nd " + string);
        } else if (i2 == 3) {
            textView.setText(i2 + "rd " + string);
        }
    }

    public static final void b(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(textView, "textView");
        ArrayList<CJRFlightStops> arrayList = null;
        if ((cJRFlightDetailsItem != null ? cJRFlightDetailsItem.getHopDisplayName() : null) != null) {
            textView.setText(cJRFlightDetailsItem.getHopDisplayName());
            return;
        }
        if (cJRFlightDetailsItem != null) {
            arrayList = cJRFlightDetailsItem.getmFlights();
        }
        if (arrayList == null || cJRFlightDetailsItem.getmFlights().size() <= 1) {
            textView.setText("");
        } else {
            textView.setText(com.travel.flight.c.d.a.a(cJRFlightDetailsItem.getmFlights(), textView.getContext()));
        }
    }

    public static final void b(ImageView imageView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(imageView, "imageView");
        a(imageView, cJRFlightDetailsItem, 0);
    }

    public static final void c(ImageView imageView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(imageView, "imageView");
        a(imageView, cJRFlightDetailsItem, 1);
    }

    private static void a(ImageView imageView, CJRFlightDetailsItem cJRFlightDetailsItem, int i2) {
        Boolean valueOf = cJRFlightDetailsItem != null ? Boolean.valueOf(cJRFlightDetailsItem.isStitchedAndMoreThanOneHop()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        if (valueOf.booleanValue()) {
            imageView.setVisibility(0);
            com.travel.flight.utils.c.a(cJRFlightDetailsItem.getmFlights().get(i2).getmAirLineCode(), imageView);
            return;
        }
        imageView.setVisibility(8);
    }

    public static final void d(ImageView imageView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(imageView, "imageView");
        if (cJRFlightDetailsItem == null || cJRFlightDetailsItem.isStitchedAndMoreThanOneHop()) {
            imageView.setVisibility(4);
            return;
        }
        imageView.setVisibility(0);
        com.travel.flight.utils.c.a(cJRFlightDetailsItem.getmAirLineCode(), imageView);
    }

    public static final void a(TextView textView, CJRFlightSearchInput cJRFlightSearchInput) {
        kotlin.g.b.k.c(textView, "textView");
        if (cJRFlightSearchInput == null) {
            textView.setText("");
            return;
        }
        Context context = textView.getContext();
        String a2 = com.travel.flight.c.d.a.a(cJRFlightSearchInput.getReturnDate() != null, cJRFlightSearchInput.getDate(), cJRFlightSearchInput.getReturnDate());
        String a3 = com.travel.flight.utils.c.a(cJRFlightSearchInput, context);
        String b2 = com.travel.flight.utils.c.b(cJRFlightSearchInput, context);
        textView.setText(a2 + ", " + a3 + ", " + b2);
    }

    public static final void a(View view, Integer num) {
        int i2;
        kotlin.g.b.k.c(view, "view");
        if (num != null && num.intValue() == 2) {
            i2 = R.drawable.pre_f_flight_top_rounded_rect_background;
        } else if (num != null && num.intValue() == 3) {
            i2 = R.drawable.pre_f_flight_bottom_rounded_rect_background;
        } else if (num != null && num.intValue() == 4) {
            i2 = R.drawable.pre_f_flight_rounded_rect_background;
        } else {
            i2 = R.drawable.pre_f_flight_left_right_shadow_rect_background;
        }
        view.setBackgroundResource(i2);
    }

    public static final void c(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(textView, "textView");
        if (cJRFlightDetailsItem != null) {
            ArrayList<CJRFlightPrice> arrayList = cJRFlightDetailsItem.getmPrice();
            Collection collection = arrayList;
            if (!(collection == null || collection.isEmpty())) {
                textView.setText(com.travel.flight.utils.c.h(arrayList.get(0).getmDisplayPrice()));
            } else {
                textView.setText("");
            }
        } else {
            textView.setText("");
        }
    }

    public static final void d(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(textView, "textView");
        textView.setText("");
        if (cJRFlightDetailsItem != null) {
            ArrayList<CJRFlightPrice> arrayList = cJRFlightDetailsItem.getmPrice();
            Collection collection = arrayList;
            boolean z = true;
            if (!(collection == null || collection.isEmpty()) && arrayList.size() > 0) {
                textView.setText(com.travel.flight.utils.c.h(arrayList.get(0).getmDisplayPrice()));
                CJRFlightPriceDiscounts cJRFlightPriceDiscounts = arrayList.get(0).getmDiscounts();
                if (cJRFlightPriceDiscounts != null) {
                    CharSequence effective_price = cJRFlightPriceDiscounts.getEffective_price();
                    if (!(effective_price == null || effective_price.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        textView.setText(com.travel.flight.utils.c.h(cJRFlightPriceDiscounts.getEffective_price()));
                    }
                }
            }
        }
    }

    public static final void a(ImageView imageView, String str) {
        kotlin.g.b.k.c(imageView, "imageView");
        if (URLUtil.isValidUrl(str)) {
            b.a aVar = com.paytm.utility.b.b.f43744a;
            Context context = imageView.getContext();
            kotlin.g.b.k.a((Object) context, "imageView.context");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = str;
            b.a.C0750a.a(a2.a(10, b.a.ALL), imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public static final void a(ViewGroup viewGroup, CJRFlightDetailsItem cJRFlightDetailsItem, SRPOneWayViewModel sRPOneWayViewModel, Boolean bool) {
        com.travel.flight.flightSRPV2.a.g<Long> gVar;
        DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight;
        kotlin.g.b.k.c(viewGroup, "viewGroup");
        if (cJRFlightDetailsItem != null && sRPOneWayViewModel != null && bool != null) {
            com.travel.flight.flightSRPV2.a.u value = sRPOneWayViewModel.getParentViewModel().getDefaultOnwardFilterInfo().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) value, "oneWayViewModel.parentVi…tOnwardFilterInfo.value!!");
            com.travel.flight.flightSRPV2.a.u uVar = value;
            if (bool.booleanValue()) {
                gVar = uVar.f24130e;
            } else {
                if (uVar == null) {
                    kotlin.g.b.k.a();
                }
                gVar = uVar.f24131f;
            }
            if (viewGroup.getChildCount() == 0) {
                Context context = viewGroup.getContext();
                kotlin.g.b.k.a((Object) context, "viewGroup.context");
                discreteRangeSeekBarFlight = d.a((Number) gVar.f24100a, (Number) gVar.f24101b, (Number) 600000L, context);
                viewGroup.addView(discreteRangeSeekBarFlight);
            } else {
                KeyEvent.Callback childAt = viewGroup.getChildAt(0);
                if (childAt != null) {
                    discreteRangeSeekBarFlight = (DiscreteRangeSeekBarFlight) childAt;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight<kotlin.Long>");
                }
            }
            discreteRangeSeekBarFlight.setOnRangeSeekBarChangeListener(new h(cJRFlightDetailsItem));
            Object obj = cJRFlightDetailsItem.getFilterSelectedMinValue().get();
            if (obj != null) {
                discreteRangeSeekBarFlight.setSelectedMinValue((Long) obj);
                Object obj2 = cJRFlightDetailsItem.getFilterSelectedMaxValue().get();
                if (obj2 != null) {
                    discreteRangeSeekBarFlight.setSelectedMaxValue((Long) obj2);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Long");
            }
            throw new u("null cannot be cast to non-null type kotlin.Long");
        }
    }

    public static final class h implements RangeSeekBarFlight.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24170a;

        h(CJRFlightDetailsItem cJRFlightDetailsItem) {
            this.f24170a = cJRFlightDetailsItem;
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            boolean z;
            long longValue = ((Number) obj).longValue();
            long longValue2 = ((Number) obj2).longValue();
            CJRFlightDetailsItem cJRFlightDetailsItem = this.f24170a;
            cJRFlightDetailsItem.getFilterSelectedMinValue().set(Long.valueOf(longValue));
            cJRFlightDetailsItem.getFilterSelectedMaxValue().set(Long.valueOf(longValue2));
            androidx.databinding.i<Boolean> isFilterRangeChanged = cJRFlightDetailsItem.getIsFilterRangeChanged();
            Object obj3 = cJRFlightDetailsItem.getFilterPrevSelectedMinValue().get();
            if ((obj3 instanceof Long) && longValue == ((Long) obj3).longValue()) {
                Object obj4 = cJRFlightDetailsItem.getFilterPrevSelectedMaxValue().get();
                if ((obj4 instanceof Long) && longValue2 == ((Long) obj4).longValue()) {
                    z = false;
                    isFilterRangeChanged.set(Boolean.valueOf(z));
                }
            }
            z = true;
            isFilterRangeChanged.set(Boolean.valueOf(z));
        }
    }

    public static final void a(ViewGroup viewGroup, CJRFlightDetailsItem cJRFlightDetailsItem, SRPOneWayViewModel sRPOneWayViewModel) {
        DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight;
        kotlin.g.b.k.c(viewGroup, "viewGroup");
        if (cJRFlightDetailsItem != null && sRPOneWayViewModel != null) {
            com.travel.flight.flightSRPV2.a.u value = sRPOneWayViewModel.getParentViewModel().getDefaultOnwardFilterInfo().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) value, "oneWayViewModel.parentVi…tOnwardFilterInfo.value!!");
            com.travel.flight.flightSRPV2.a.g<Integer> gVar = value.f24129d;
            if (viewGroup.getChildCount() == 0) {
                Context context = viewGroup.getContext();
                kotlin.g.b.k.a((Object) context, "viewGroup.context");
                discreteRangeSeekBarFlight = d.a((Number) gVar.f24100a, (Number) gVar.f24101b, (Number) 100, context);
                viewGroup.addView(discreteRangeSeekBarFlight);
            } else {
                KeyEvent.Callback childAt = viewGroup.getChildAt(0);
                if (childAt != null) {
                    discreteRangeSeekBarFlight = (DiscreteRangeSeekBarFlight) childAt;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight<kotlin.Int>");
                }
            }
            discreteRangeSeekBarFlight.setOnRangeSeekBarChangeListener(new f(cJRFlightDetailsItem));
            Object obj = cJRFlightDetailsItem.getFilterSelectedMinValue().get();
            if (obj != null) {
                discreteRangeSeekBarFlight.setSelectedMinValue((Integer) obj);
                Object obj2 = cJRFlightDetailsItem.getFilterSelectedMaxValue().get();
                if (obj2 != null) {
                    discreteRangeSeekBarFlight.setSelectedMaxValue((Integer) obj2);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Int");
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class f implements RangeSeekBarFlight.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24165a;

        f(CJRFlightDetailsItem cJRFlightDetailsItem) {
            this.f24165a = cJRFlightDetailsItem;
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            boolean z;
            int intValue = ((Number) obj).intValue();
            int intValue2 = ((Number) obj2).intValue();
            CJRFlightDetailsItem cJRFlightDetailsItem = this.f24165a;
            cJRFlightDetailsItem.getFilterSelectedMinValue().set(Integer.valueOf(intValue));
            cJRFlightDetailsItem.getFilterSelectedMaxValue().set(Integer.valueOf(intValue2));
            androidx.databinding.i<Boolean> isFilterRangeChanged = cJRFlightDetailsItem.getIsFilterRangeChanged();
            Object obj3 = cJRFlightDetailsItem.getFilterPrevSelectedMinValue().get();
            if ((obj3 instanceof Integer) && intValue == ((Integer) obj3).intValue()) {
                Object obj4 = cJRFlightDetailsItem.getFilterPrevSelectedMaxValue().get();
                if ((obj4 instanceof Integer) && intValue2 == ((Integer) obj4).intValue()) {
                    z = false;
                    isFilterRangeChanged.set(Boolean.valueOf(z));
                }
            }
            z = true;
            isFilterRangeChanged.set(Boolean.valueOf(z));
        }
    }

    public static final void b(ViewGroup viewGroup, CJRFlightDetailsItem cJRFlightDetailsItem, SRPOneWayViewModel sRPOneWayViewModel) {
        DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight;
        kotlin.g.b.k.c(viewGroup, "viewGroup");
        if (cJRFlightDetailsItem != null && sRPOneWayViewModel != null) {
            com.travel.flight.flightSRPV2.a.u value = sRPOneWayViewModel.getParentViewModel().getDefaultOnwardFilterInfo().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) value, "oneWayViewModel.parentVi…tOnwardFilterInfo.value!!");
            com.travel.flight.flightSRPV2.a.u uVar = value;
            if (viewGroup.getChildCount() == 0) {
                Context context = viewGroup.getContext();
                kotlin.g.b.k.a((Object) context, "viewGroup.context");
                discreteRangeSeekBarFlight = d.a((Number) uVar.f24128c.f24100a, (Number) uVar.f24128c.f24101b, (Number) 10, context);
                discreteRangeSeekBarFlight.setMinThumbEnable(false);
                viewGroup.addView(discreteRangeSeekBarFlight);
            } else {
                KeyEvent.Callback childAt = viewGroup.getChildAt(0);
                if (childAt != null) {
                    discreteRangeSeekBarFlight = (DiscreteRangeSeekBarFlight) childAt;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight<kotlin.Int>");
                }
            }
            discreteRangeSeekBarFlight.setOnRangeSeekBarChangeListener(new d(cJRFlightDetailsItem));
            Object obj = cJRFlightDetailsItem.getFilterSelectedMinValue().get();
            if (obj != null) {
                discreteRangeSeekBarFlight.setSelectedMinValue((Integer) obj);
                Object obj2 = cJRFlightDetailsItem.getFilterSelectedMaxValue().get();
                if (obj2 != null) {
                    discreteRangeSeekBarFlight.setSelectedMaxValue((Integer) obj2);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Int");
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class d implements RangeSeekBarFlight.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24162a;

        d(CJRFlightDetailsItem cJRFlightDetailsItem) {
            this.f24162a = cJRFlightDetailsItem;
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            boolean z;
            int intValue = ((Number) obj).intValue();
            int intValue2 = ((Number) obj2).intValue();
            CJRFlightDetailsItem cJRFlightDetailsItem = this.f24162a;
            cJRFlightDetailsItem.getFilterSelectedMinValue().set(Integer.valueOf(intValue));
            cJRFlightDetailsItem.getFilterSelectedMaxValue().set(Integer.valueOf(intValue2));
            androidx.databinding.i<Boolean> isFilterRangeChanged = cJRFlightDetailsItem.getIsFilterRangeChanged();
            Object obj3 = cJRFlightDetailsItem.getFilterPrevSelectedMinValue().get();
            if ((obj3 instanceof Integer) && intValue == ((Integer) obj3).intValue()) {
                Object obj4 = cJRFlightDetailsItem.getFilterPrevSelectedMaxValue().get();
                if ((obj4 instanceof Integer) && intValue2 == ((Integer) obj4).intValue()) {
                    z = false;
                    isFilterRangeChanged.set(Boolean.valueOf(z));
                }
            }
            z = true;
            isFilterRangeChanged.set(Boolean.valueOf(z));
        }
    }

    public static final void a(TextView textView, Integer num) {
        kotlin.g.b.k.c(textView, "textView");
        if (num != null) {
            textView.setText(com.travel.flight.utils.c.a(num.intValue()));
        } else {
            textView.setText("");
        }
    }

    public static final void a(TextView textView, CJRFlightSearchInput cJRFlightSearchInput, Boolean bool, Boolean bool2) {
        kotlin.g.b.k.c(textView, "textView");
        if (cJRFlightSearchInput == null || bool == null || bool2 == null) {
            textView.setText("");
            return;
        }
        Context context = textView.getContext();
        com.travel.flight.pojo.flightticket.b source = cJRFlightSearchInput.getSource();
        kotlin.g.b.k.a((Object) source, "searchInput.source");
        String cityName = source.getCityName();
        com.travel.flight.pojo.flightticket.b destination = cJRFlightSearchInput.getDestination();
        kotlin.g.b.k.a((Object) destination, "searchInput.destination");
        String cityName2 = destination.getCityName();
        String string = context.getString(bool2.booleanValue() ? R.string.Departure : R.string.arrival);
        kotlin.g.b.k.a((Object) string, "if (isDeparture) context…tString(R.string.arrival)");
        if (!bool.booleanValue() ? !bool2.booleanValue() : bool2.booleanValue()) {
            cityName2 = cityName;
        }
        String str = bool2.booleanValue() ? "from" : "in";
        CharSequence charSequence = cityName2;
        if (!(charSequence == null || p.a(charSequence))) {
            CharSequence charSequence2 = string + ' ' + str + ' ' + cityName2;
            int a2 = p.a(charSequence2, cityName2, p.d(charSequence2));
            SpannableString spannableString = new SpannableString(charSequence2);
            Typeface create = Typeface.create("sans-serif", 1);
            kotlin.g.b.k.a((Object) create, "Typeface.create(\"sans-serif\", Typeface.BOLD)");
            kotlin.g.b.k.a((Object) context, "context");
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.black)), a2, cityName2.length() + a2, 33);
            spannableString.setSpan(new CustomTypefaceSpan("", create), a2, cityName2.length() + a2, 33);
            textView.setText(spannableString);
            return;
        }
        textView.setText(string);
    }

    public static final void a(TextView textView, Long l, String str) {
        kotlin.g.b.k.c(textView, "textView");
        kotlin.g.b.k.c(str, "timeZone");
        textView.setText(com.travel.flight.utils.c.a(l != null ? l.longValue() : 0, "dd MMM hh:mm a", str));
    }

    public static final void a(RecyclerView recyclerView, List<com.travel.flight.flightSRPV2.a.d> list, FlightFilterViewModel flightFilterViewModel) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (flightFilterViewModel == null || list == null) {
            recyclerView.setAdapter((RecyclerView.a) null);
        } else if (adapter == null || !(adapter instanceof com.travel.flight.flightSRPV2.view.ui.a.a)) {
            recyclerView.setAdapter(new com.travel.flight.flightSRPV2.view.ui.a.a(list, flightFilterViewModel));
        } else {
            com.travel.flight.flightSRPV2.view.ui.a.a aVar = (com.travel.flight.flightSRPV2.view.ui.a.a) adapter;
            kotlin.g.b.k.c(flightFilterViewModel, "filterViewModel");
            aVar.f24178a = list;
            aVar.f24179b = flightFilterViewModel;
            aVar.notifyDataSetChanged();
            recyclerView.scrollToPosition(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        if ((r3 == null || kotlin.m.p.a(r3)) != false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r11.e() != 1) goto L_0x001a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(android.widget.ImageView r10, com.travel.flight.flightSRPV2.a.x r11) {
        /*
            java.lang.String r0 = "imageView"
            kotlin.g.b.k.c(r10, r0)
            r1 = 8
            r2 = 0
            if (r11 == 0) goto L_0x012a
            boolean r3 = r11.c()
            r4 = 1
            if (r3 != 0) goto L_0x001a
            r11.i()
            int r3 = r11.e()
            if (r3 == r4) goto L_0x012a
        L_0x001a:
            boolean r3 = r11.c()
            r5 = 0
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = r11.d()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0032
            boolean r3 = kotlin.m.p.a(r3)
            if (r3 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r3 = 0
            goto L_0x0033
        L_0x0032:
            r3 = 1
        L_0x0033:
            if (r3 == 0) goto L_0x0037
            goto L_0x012a
        L_0x0037:
            boolean r3 = r11.c()
            r6 = 2
            if (r3 == 0) goto L_0x00c0
            java.lang.String r11 = r11.d()
            int r1 = com.travel.flight.R.drawable.pre_f_defaultcarrier
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = com.travel.flight.R.drawable.pre_f_defaultcarrier
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            kotlin.g.b.k.c(r10, r0)
            r7 = r11
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x005f
            int r7 = r7.length()
            if (r7 != 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r7 = 0
            goto L_0x0060
        L_0x005f:
            r7 = 1
        L_0x0060:
            if (r7 != 0) goto L_0x008d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.travel.flight.b r8 = com.travel.flight.b.a()
            java.lang.String r9 = "FlightController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            com.travel.flight.c r8 = com.travel.flight.b.b()
            java.lang.String r9 = "FlightController.getInstance().flightEventListener"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r8 = r8.r()
            r7.append(r8)
            r7.append(r11)
            java.lang.String r11 = ".png"
            r7.append(r11)
            java.lang.String r11 = r7.toString()
            goto L_0x008e
        L_0x008d:
            r11 = r2
        L_0x008e:
            kotlin.g.b.k.c(r10, r0)
            com.paytm.utility.b.b$a r0 = com.paytm.utility.b.b.f43744a
            android.content.Context r0 = r10.getContext()
            java.lang.String r7 = "imageView.context"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a.a(r0)
            r0.f43753a = r11
            r0.m = r4
            r11 = -1
            if (r1 != 0) goto L_0x00ab
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
        L_0x00ab:
            com.paytm.utility.b.b$a$a r0 = r0.a((java.lang.Object) r1)
            if (r3 != 0) goto L_0x00b5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
        L_0x00b5:
            com.paytm.utility.b.b$a$a r11 = r0.b(r3)
            com.paytm.utility.b.b.a.C0750a.a(r11, r10, r2, r6)
            r10.setVisibility(r5)
            return
        L_0x00c0:
            boolean r0 = r11.c()
            if (r0 != 0) goto L_0x0123
            int r0 = r11.e()
            if (r0 == r4) goto L_0x0123
            int r0 = r11.e()
            if (r0 != r6) goto L_0x00db
            int r11 = com.travel.flight.R.drawable.ic_filter_max_one_stop_revamp
            r10.setImageResource(r11)
            r10.setVisibility(r5)
            goto L_0x010a
        L_0x00db:
            int r0 = r11.e()
            r3 = 3
            if (r0 != r3) goto L_0x00e6
            java.lang.String r11 = "clock.png"
        L_0x00e4:
            r0 = 1
            goto L_0x010d
        L_0x00e6:
            int r0 = r11.e()
            r3 = 4
            if (r0 != r3) goto L_0x00f0
            java.lang.String r11 = "rupee_icon.png"
            goto L_0x00e4
        L_0x00f0:
            int r0 = r11.e()
            r3 = 5
            if (r0 != r3) goto L_0x00fa
            java.lang.String r11 = "filter_departure_revamp.png"
            goto L_0x010c
        L_0x00fa:
            int r11 = r11.e()
            r0 = 6
            if (r11 != r0) goto L_0x0104
            java.lang.String r11 = "filter_arrival_revamp.png"
            goto L_0x010c
        L_0x0104:
            r10.setImageDrawable(r2)
            r10.setVisibility(r1)
        L_0x010a:
            java.lang.String r11 = ""
        L_0x010c:
            r0 = 0
        L_0x010d:
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r4 = 0
        L_0x0118:
            if (r4 == 0) goto L_0x0129
            com.travel.utils.n$a r1 = com.travel.utils.n.a.V1
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r10, r11, r5, r0, r1)
            r10.setVisibility(r5)
            return
        L_0x0123:
            r10.setImageDrawable(r2)
            r10.setVisibility(r1)
        L_0x0129:
            return
        L_0x012a:
            r10.setImageDrawable(r2)
            r10.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.c.c.a(android.widget.ImageView, com.travel.flight.flightSRPV2.a.x):void");
    }

    public static final void a(ImageView imageView, int i2) {
        kotlin.g.b.k.c(imageView, "imageView");
        imageView.setImageResource(i2);
    }

    public static final void a(RecyclerView recyclerView, List<? extends x> list, z zVar) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        if (list == null) {
            list = new ArrayList<>();
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null || !(adapter instanceof com.travel.flight.flightSRPV2.view.ui.a.n)) {
            recyclerView.setAdapter(new com.travel.flight.flightSRPV2.view.ui.a.n(list, zVar));
            return;
        }
        com.travel.flight.flightSRPV2.view.ui.a.n nVar = (com.travel.flight.flightSRPV2.view.ui.a.n) adapter;
        kotlin.g.b.k.c(list, "filterList");
        nVar.f24212a = list;
        nVar.f24213b = zVar;
        nVar.notifyDataSetChanged();
        recyclerView.scrollToPosition(0);
    }

    public static final void a(RecyclerView recyclerView, DRTListViewModel dRTListViewModel, List<? extends CJRDiscountedStrip> list, ArrayList<String> arrayList) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        kotlin.g.b.k.c(dRTListViewModel, "viewModel");
        if (list != null) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null || !(adapter instanceof com.travel.flight.flightSRPV2.view.ui.a.c)) {
                recyclerView.setAdapter(new com.travel.flight.flightSRPV2.view.ui.a.c(dRTListViewModel, list, arrayList));
                return;
            }
            com.travel.flight.flightSRPV2.view.ui.a.c cVar = (com.travel.flight.flightSRPV2.view.ui.a.c) adapter;
            kotlin.g.b.k.c(dRTListViewModel, "viewModel");
            kotlin.g.b.k.c(list, "discountedStrip");
            cVar.f24181a = dRTListViewModel;
            cVar.f24182b = list;
            cVar.f24183c = arrayList;
            cVar.notifyDataSetChanged();
            recyclerView.scrollToPosition(0);
        }
    }

    public static final void a(ConstraintLayout constraintLayout, Boolean bool) {
        kotlin.g.b.k.c(constraintLayout, "constraintLayout");
        if (bool == null || !bool.booleanValue()) {
            constraintLayout.setBackground(androidx.core.content.b.a(constraintLayout.getContext(), R.color.color_00000000));
        } else {
            constraintLayout.setBackground(androidx.core.content.b.a(constraintLayout.getContext(), R.color.color_cdf3ff));
        }
    }

    public static final void a(View view, Boolean bool) {
        kotlin.g.b.k.c(view, "view");
        if (bool == null || !bool.booleanValue()) {
            view.setBackground(androidx.core.content.b.a(view.getContext(), R.drawable.pre_f_flight_circle_with_grey_stroke));
        } else {
            view.setBackground(androidx.core.content.b.a(view.getContext(), R.drawable.pre_f_flight_circle_with_blue_stroke));
        }
    }

    public static final void a(TextView textView, CJRFlightSearchInput cJRFlightSearchInput, boolean z, boolean z2) {
        kotlin.g.b.k.c(textView, "textView");
        if (cJRFlightSearchInput == null) {
            return;
        }
        if (z) {
            if (z2) {
                StringBuilder sb = new StringBuilder();
                com.travel.flight.pojo.flightticket.b source = cJRFlightSearchInput.getSource();
                kotlin.g.b.k.a((Object) source, "searchInput.source");
                sb.append(source.getCityName());
                sb.append(" - ");
                com.travel.flight.pojo.flightticket.b destination = cJRFlightSearchInput.getDestination();
                kotlin.g.b.k.a((Object) destination, "searchInput.destination");
                sb.append(destination.getCityName());
                textView.setText(sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            com.travel.flight.pojo.flightticket.b source2 = cJRFlightSearchInput.getSource();
            kotlin.g.b.k.a((Object) source2, "searchInput.source");
            sb2.append(source2.getShortCityName());
            sb2.append(" - ");
            com.travel.flight.pojo.flightticket.b destination2 = cJRFlightSearchInput.getDestination();
            kotlin.g.b.k.a((Object) destination2, "searchInput.destination");
            sb2.append(destination2.getShortCityName());
            textView.setText(sb2.toString());
        } else if (z2) {
            StringBuilder sb3 = new StringBuilder();
            com.travel.flight.pojo.flightticket.b destination3 = cJRFlightSearchInput.getDestination();
            kotlin.g.b.k.a((Object) destination3, "searchInput.destination");
            sb3.append(destination3.getCityName());
            sb3.append(" - ");
            com.travel.flight.pojo.flightticket.b source3 = cJRFlightSearchInput.getSource();
            kotlin.g.b.k.a((Object) source3, "searchInput.source");
            sb3.append(source3.getCityName());
            textView.setText(sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder();
            com.travel.flight.pojo.flightticket.b destination4 = cJRFlightSearchInput.getDestination();
            kotlin.g.b.k.a((Object) destination4, "searchInput.destination");
            sb4.append(destination4.getShortCityName());
            sb4.append(" - ");
            com.travel.flight.pojo.flightticket.b source4 = cJRFlightSearchInput.getSource();
            kotlin.g.b.k.a((Object) source4, "searchInput.source");
            sb4.append(source4.getShortCityName());
            textView.setText(sb4.toString());
        }
    }

    public static final void a(TextView textView, List<? extends x> list) {
        kotlin.g.b.k.c(textView, "textView");
        if (list == null || list.size() > 2 || list.isEmpty()) {
            textView.setVisibility(8);
            textView.setText("");
            return;
        }
        boolean z = false;
        textView.setVisibility(0);
        String g2 = ((x) list.get(0)).g();
        String g3 = list.size() == 2 ? ((x) list.get(1)).g() : null;
        CharSequence charSequence = g3;
        if (charSequence == null || p.a(charSequence)) {
            z = true;
        }
        if (z || p.a(g2, g3, true)) {
            textView.setText(g2);
            return;
        }
        textView.setText(g2 + ", " + g3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[EDGE_INSN: B:23:0x003b->B:16:0x003b ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(android.widget.CompoundButton r6, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r7) {
        /*
            java.lang.String r0 = "button"
            kotlin.g.b.k.c(r6, r0)
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L_0x000a
            goto L_0x0040
        L_0x000a:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0010:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x003a
            java.lang.Object r2 = r7.next()
            r3 = r2
            com.travel.flight.flightSRPV2.a.x r3 = (com.travel.flight.flightSRPV2.a.x) r3
            int r4 = r3.e()
            r5 = 2
            if (r4 != r5) goto L_0x0036
            if (r3 == 0) goto L_0x002e
            com.travel.flight.flightSRPV2.a.af r3 = (com.travel.flight.flightSRPV2.a.af) r3
            int r3 = r3.f24086a
            if (r3 != r1) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x002e:
            kotlin.u r6 = new kotlin.u
            java.lang.String r7 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPStopsFilter"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0010
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            com.travel.flight.flightSRPV2.a.x r2 = (com.travel.flight.flightSRPV2.a.x) r2
            if (r2 == 0) goto L_0x0040
            r0 = 1
        L_0x0040:
            r6.setChecked(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.c.c.a(android.widget.CompoundButton, java.util.List):void");
    }

    public static final void a(View view, z zVar, Boolean bool, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(view, "view");
        if (zVar == null || bool == null || cJRFlightDetailsItem == null) {
            view.setOnClickListener((View.OnClickListener) null);
        } else {
            view.setOnClickListener(new i(cJRFlightDetailsItem, bool, zVar));
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24171a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Boolean f24172b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ z f24173c;

        i(CJRFlightDetailsItem cJRFlightDetailsItem, Boolean bool, z zVar) {
            this.f24171a = cJRFlightDetailsItem;
            this.f24172b = bool;
            this.f24173c = zVar;
        }

        public final void onClick(View view) {
            x xVar;
            Object obj = this.f24171a.getFilterSelectedMinValue().get();
            if (obj != null) {
                long longValue = ((Long) obj).longValue();
                Object obj2 = this.f24171a.getFilterSelectedMaxValue().get();
                if (obj2 != null) {
                    long longValue2 = ((Long) obj2).longValue();
                    if (this.f24172b.booleanValue()) {
                        xVar = new v(true, longValue, longValue2);
                    } else {
                        xVar = new s(true, longValue, longValue2);
                    }
                    this.f24173c.addOneWayFilter(xVar);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Long");
            }
            throw new u("null cannot be cast to non-null type kotlin.Long");
        }
    }

    /* renamed from: com.travel.flight.flightSRPV2.c.c$c  reason: collision with other inner class name */
    static final class C0457c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24160a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f24161b;

        C0457c(CJRFlightDetailsItem cJRFlightDetailsItem, z zVar) {
            this.f24160a = cJRFlightDetailsItem;
            this.f24161b = zVar;
        }

        public final void onClick(View view) {
            Object obj = this.f24160a.getFilterSelectedMaxValue().get();
            if (obj != null) {
                this.f24161b.addOneWayFilter(new w(true, ((Integer) obj).intValue()));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final void a(View view, z zVar, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(view, "view");
        if (zVar == null || cJRFlightDetailsItem == null) {
            view.setOnClickListener((View.OnClickListener) null);
        } else {
            view.setOnClickListener(new C0457c(cJRFlightDetailsItem, zVar));
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24163a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f24164b;

        e(CJRFlightDetailsItem cJRFlightDetailsItem, z zVar) {
            this.f24163a = cJRFlightDetailsItem;
            this.f24164b = zVar;
        }

        public final void onClick(View view) {
            Object obj = this.f24163a.getFilterSelectedMinValue().get();
            if (obj != null) {
                int intValue = ((Integer) obj).intValue();
                Object obj2 = this.f24163a.getFilterSelectedMaxValue().get();
                if (obj2 != null) {
                    this.f24164b.addOneWayFilter(new com.travel.flight.flightSRPV2.a.aa(true, intValue, ((Integer) obj2).intValue()));
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Int");
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final void b(View view, z zVar, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(view, "view");
        if (zVar == null || cJRFlightDetailsItem == null) {
            view.setOnClickListener((View.OnClickListener) null);
        } else {
            view.setOnClickListener(new e(cJRFlightDetailsItem, zVar));
        }
    }

    public static final void c(View view, z zVar, CJRFlightDetailsItem cJRFlightDetailsItem) {
        kotlin.g.b.k.c(view, "view");
        if (zVar == null || cJRFlightDetailsItem == null) {
            view.setOnClickListener((View.OnClickListener) null);
        } else {
            view.setOnClickListener(new b(cJRFlightDetailsItem, zVar));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24158a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f24159b;

        b(CJRFlightDetailsItem cJRFlightDetailsItem, z zVar) {
            this.f24158a = cJRFlightDetailsItem;
            this.f24159b = zVar;
        }

        public final void onClick(View view) {
            List<com.travel.flight.flightSRPV2.a.d> filterAirlinePriceList = this.f24158a.getFilterAirlinePriceList();
            kotlin.g.b.k.a((Object) filterAirlinePriceList, "filterInfo.filterAirlinePriceList");
            Collection arrayList = new ArrayList();
            for (Object next : filterAirlinePriceList) {
                Boolean bool = ((com.travel.flight.flightSRPV2.a.d) next).f24099e.get();
                if (bool == null) {
                    kotlin.g.b.k.a();
                }
                if (bool.booleanValue()) {
                    arrayList.add(next);
                }
            }
            Iterable<com.travel.flight.flightSRPV2.a.d> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
            for (com.travel.flight.flightSRPV2.a.d dVar : iterable) {
                kotlin.g.b.k.a((Object) dVar, "it");
                arrayList2.add(new r(true, dVar));
            }
            this.f24159b.addOneWayAirlineFilters((List) arrayList2);
        }
    }

    public static final void a(RecyclerView recyclerView, List<com.travel.flight.flightSRPV2.a.d> list) {
        kotlin.g.b.k.c(recyclerView, "recyclerView");
        if (list == null || list.isEmpty()) {
            recyclerView.setAdapter((RecyclerView.a) null);
            return;
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null || !(adapter instanceof com.travel.flight.flightSRPV2.view.ui.a.l)) {
            recyclerView.setAdapter(new com.travel.flight.flightSRPV2.view.ui.a.l(list));
            return;
        }
        com.travel.flight.flightSRPV2.view.ui.a.l lVar = (com.travel.flight.flightSRPV2.view.ui.a.l) adapter;
        kotlin.g.b.k.c(list, "airlineList");
        lVar.f24207a = list;
        lVar.notifyDataSetChanged();
        recyclerView.scrollToPosition(0);
    }

    public static final void b(View view, Boolean bool) {
        int i2;
        kotlin.g.b.k.c(view, "view");
        if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE)) {
            i2 = R.drawable.pre_f_flight_rounded_rect_with_4dp_radius_00b9f5_stroke;
        } else {
            i2 = R.drawable.pre_f_flight_rounded_rect_with_4dp_radius_grey_stroke;
        }
        view.setBackgroundResource(i2);
    }

    public static final void a(View view, ae aeVar, ae aeVar2) {
        kotlin.g.b.k.c(view, "view");
        if (aeVar2 == null || aeVar == null) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    public static final void a(View view, List<? extends x> list, List<? extends x> list2) {
        kotlin.g.b.k.c(view, "view");
        Collection collection = list;
        boolean z = true;
        if (collection == null || collection.isEmpty()) {
            Collection collection2 = list2;
            if (collection2 != null && !collection2.isEmpty()) {
                z = false;
            }
            if (z) {
                view.setVisibility(8);
                return;
            }
        }
        view.setVisibility(0);
    }

    public static final void b(TextView textView, Integer num) {
        CharSequence charSequence;
        kotlin.g.b.k.c(textView, "textView");
        if (num != null && num.intValue() != 0) {
            Context context = textView.getContext();
            kotlin.g.b.k.a((Object) context, "textView.context");
            charSequence = context.getResources().getString(num.intValue());
        }
        textView.setText(charSequence);
    }

    public static final void c(TextView textView, String str) {
        CharSequence charSequence;
        kotlin.g.b.k.c(textView, "textView");
        CharSequence charSequence2 = str;
        if (!(charSequence2 == null || p.a(charSequence2))) {
            charSequence = com.travel.flight.utils.c.b(str, "yyyy-MM-dd", "EEE, dd MMM yyyy");
        }
        textView.setText(charSequence);
    }

    public static final void a(TextView textView, int i2, int i3) {
        kotlin.g.b.k.c(textView, "textView");
        if (i2 == i3) {
            textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.color_000000));
            textView.setTypeface(textView.getTypeface(), 1);
            return;
        }
        textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.color_8c8c8c));
        textView.setTypeface(textView.getTypeface(), 0);
    }

    public static final void a(TextView textView, int i2, int i3, String str, String str2) {
        kotlin.g.b.k.c(textView, "textView");
        kotlin.g.b.k.c(str, "cityCode");
        kotlin.g.b.k.c(str2, "sortDisplayName");
        textView.setText(str2 + " (" + str + ')');
        if (i2 == i3) {
            textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.color_000000));
            textView.setTypeface(textView.getTypeface(), 1);
            return;
        }
        textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.color_8c8c8c));
        textView.setTypeface(textView.getTypeface(), 0);
    }

    public static final void a(ViewGroup viewGroup, List<ag> list) {
        kotlin.g.b.k.c(viewGroup, "viewGroup");
        viewGroup.removeAllViews();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (ag a2 : list) {
                bs a3 = bs.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
                kotlin.g.b.k.a((Object) a3, "LayoutSrpToolTipBinding.…ntext), viewGroup, false)");
                a3.a(a2);
                viewGroup.addView(a3.getRoot());
                a3.f23739a.setOnClickListener(new j(viewGroup, a3));
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f24174a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ bs f24175b;

        j(ViewGroup viewGroup, bs bsVar) {
            this.f24174a = viewGroup;
            this.f24175b = bsVar;
        }

        public final void onClick(View view) {
            this.f24174a.removeView(this.f24175b.getRoot());
        }
    }

    public static final void b(ImageView imageView, String str) {
        kotlin.g.b.k.c(imageView, "imageView");
        if (str == null) {
            imageView.setImageDrawable((Drawable) null);
        } else {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "tip_1.png", false, true, n.a.V1);
        }
    }

    public static final void b(View view, Integer num) {
        kotlin.g.b.k.c(view, "view");
        if (num != null && num.intValue() == 3) {
            view.setBackgroundResource(R.drawable.pre_f_flight_dark_background);
        } else {
            view.setBackgroundResource(R.drawable.pre_f_flight_dashed_line);
        }
    }

    public static final void a(TextView textView, String str, String str2) {
        kotlin.g.b.k.c(textView, "textView");
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                textView.setText(str + " - " + str2);
            }
        }
    }

    public static final void b(TextView textView, String str, String str2) {
        kotlin.g.b.k.c(textView, "textView");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = str2;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                textView.setText(textView.getResources().getString(R.string.flight_fetch_best_fares_default, new Object[]{str, str2}));
                return;
            }
        }
        textView.setText(textView.getResources().getString(R.string.flight_fetch_best_fares_default));
    }

    public static final void a(ImageView imageView, boolean z) {
        kotlin.g.b.k.c(imageView, "imageView");
        if (z) {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "fare_subscribed.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "fare_alert_unselected.png", false, false, n.a.V1);
        }
    }

    public static final void a(TextView textView, com.travel.flight.flightSRPV2.a.l lVar, String str, String str2) {
        kotlin.g.b.k.c(textView, "textView");
        if (lVar != null) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                CharSequence charSequence2 = str2;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    int i2 = lVar.f24103a;
                    if (i2 == 1) {
                        aa aaVar = aa.f47921a;
                        String string = textView.getResources().getString(R.string.fare_alert_sub_note_srp);
                        kotlin.g.b.k.a((Object) string, "textView.resources.getSt….fare_alert_sub_note_srp)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{str + " - " + str2 + ". " + textView.getResources().getString(R.string.fare_alert_message_text_revamp)}, 1));
                        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                        textView.setText(format);
                    } else if (i2 == 2) {
                        textView.setText(textView.getResources().getString(R.string.fare_alert_unsub_note_srp));
                    } else if (i2 == 3) {
                        textView.setText(lVar.f24104b);
                    }
                }
            }
        }
    }

    public static final void a(ImageView imageView, SRPSharedViewModel sRPSharedViewModel) {
        kotlin.g.b.k.c(imageView, "imageView");
        kotlin.g.b.k.c(sRPSharedViewModel, "viewModel");
        ResourceUtils.loadFlightImagesFromCDN(imageView, "fare_calendar.png", false, true, n.a.V1);
    }

    public static final void b(ImageView imageView, boolean z) {
        kotlin.g.b.k.c(imageView, "imageView");
        if (z) {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "filter_applied.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "filter.png", false, true, n.a.V1);
        }
    }

    public static final void b(ImageView imageView, SRPSharedViewModel sRPSharedViewModel) {
        kotlin.g.b.k.c(imageView, "imageView");
        kotlin.g.b.k.c(sRPSharedViewModel, "viewModel");
        ResourceUtils.loadFlightImagesFromCDN(imageView, "sort_revamp.png", false, false, n.a.V1);
    }

    public static final void c(ImageView imageView, SRPSharedViewModel sRPSharedViewModel) {
        kotlin.g.b.k.c(imageView, "imageView");
        kotlin.g.b.k.c(sRPSharedViewModel, "viewModel");
        ResourceUtils.loadFlightImagesFromCDN(imageView, "arrow_down.png", false, true, n.a.V1);
    }

    public static final void a(ImageView imageView, com.travel.flight.flightSRPV2.a.l lVar) {
        kotlin.g.b.k.c(imageView, "imageView");
        if (lVar == null) {
            return;
        }
        if (lVar.f24103a == 1) {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "fare_subscribed.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "fare_alert_unselected.png", false, false, n.a.V1);
        }
    }
}
