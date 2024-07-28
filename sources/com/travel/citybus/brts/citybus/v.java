package com.travel.citybus.brts.citybus;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import com.travel.citybus.brts.model.CJRBrtsPaxInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.i.f;

public final class v extends f {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f23353a;

    /* renamed from: b  reason: collision with root package name */
    private AppCompatImageView f23354b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends CJRBrtsPaxInfo> f23355c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.travel.citybus.brts.a.a f23356d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f23357e;

    private View a(int i2) {
        if (this.f23357e == null) {
            this.f23357e = new HashMap();
        }
        View view = (View) this.f23357e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23357e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public v(com.travel.citybus.brts.a.a aVar) {
        k.c(aVar, "listener");
        this.f23356d = aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_fare_breakup, viewGroup, false);
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f23355c = arguments.getParcelableArrayList("pax_list_key");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Window window;
        Window window2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        int i2 = 0;
        if (!(dialog == null || (window2 = dialog.getWindow()) == null)) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
            window.addFlags(67108864);
        }
        View findViewById = view.findViewById(R.id.lnrFareBreakUpContainer);
        k.a((Object) findViewById, "view.findViewById(R.id.lnrFareBreakUpContainer)");
        this.f23353a = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.ibCloseFareBreakup);
        k.a((Object) findViewById2, "view.findViewById(R.id.ibCloseFareBreakup)");
        this.f23354b = (AppCompatImageView) findViewById2;
        List<? extends CJRBrtsPaxInfo> list = this.f23355c;
        if (list != null) {
            if (list == null) {
                k.a();
            }
            if (!list.isEmpty()) {
                List<? extends CJRBrtsPaxInfo> list2 = this.f23355c;
                if (list2 == null) {
                    k.a();
                }
                double d2 = 0.0d;
                for (CJRBrtsPaxInfo cJRBrtsPaxInfo : list2) {
                    if (cJRBrtsPaxInfo.getCount() > 0) {
                        if (cJRBrtsPaxInfo.getPaxName().equals("Senior")) {
                            a("Senior Citizen", cJRBrtsPaxInfo.getCount(), ((double) cJRBrtsPaxInfo.getCount()) * cJRBrtsPaxInfo.getFare());
                        } else if (cJRBrtsPaxInfo.getPaxName().equals("Adult")) {
                            a("Adult", cJRBrtsPaxInfo.getCount(), ((double) cJRBrtsPaxInfo.getCount()) * cJRBrtsPaxInfo.getFare());
                        } else if (cJRBrtsPaxInfo.getPaxName().equals("Child")) {
                            a("Child", cJRBrtsPaxInfo.getCount(), ((double) cJRBrtsPaxInfo.getCount()) * cJRBrtsPaxInfo.getFare());
                        } else if (cJRBrtsPaxInfo.getPaxName().equals("PH")) {
                            a("Differently Abled Citizen", cJRBrtsPaxInfo.getCount(), ((double) cJRBrtsPaxInfo.getCount()) * cJRBrtsPaxInfo.getFare());
                        } else if (cJRBrtsPaxInfo.getPaxName().equals("Student")) {
                            a("Student", cJRBrtsPaxInfo.getCount(), ((double) cJRBrtsPaxInfo.getCount()) * cJRBrtsPaxInfo.getFare());
                        }
                        i2 += cJRBrtsPaxInfo.getCount();
                        d2 += ((double) cJRBrtsPaxInfo.getCount()) * cJRBrtsPaxInfo.getFare();
                    }
                }
                if (i2 > 1) {
                    TextView textView = (TextView) a(R.id.total_passenger_no_text);
                    k.a((Object) textView, "total_passenger_no_text");
                    textView.setText("Total for " + i2 + " passengers");
                } else if (i2 == 1) {
                    TextView textView2 = (TextView) a(R.id.total_passenger_no_text);
                    k.a((Object) textView2, "total_passenger_no_text");
                    textView2.setText("Total for " + i2 + " passenger");
                }
                if (d2 > 0.0d) {
                    TextView textView3 = (TextView) a(R.id.text_complete_price);
                    k.a((Object) textView3, "text_complete_price");
                    textView3.setText(com.travel.citybus.brts.utils.a.a(Double.valueOf(d2)));
                }
            }
        }
        AppCompatImageView appCompatImageView = this.f23354b;
        if (appCompatImageView == null) {
            k.a("ibCloseFareBreakup");
        }
        appCompatImageView.setOnClickListener(new a(this));
        ((TextView) a(R.id.total_passenger_no_text)).setOnClickListener(new b(this));
        ((Button) a(R.id.button_proceed)).setOnClickListener(new c(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f23358a;

        a(v vVar) {
            this.f23358a = vVar;
        }

        public final void onClick(View view) {
            this.f23358a.dismissAllowingStateLoss();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f23359a;

        b(v vVar) {
            this.f23359a = vVar;
        }

        public final void onClick(View view) {
            this.f23359a.dismissAllowingStateLoss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f23360a;

        c(v vVar) {
            this.f23360a = vVar;
        }

        public final void onClick(View view) {
            if (this.f23360a.f23356d != null) {
                com.travel.citybus.brts.a.a a2 = this.f23360a.f23356d;
                if (a2 == null) {
                    k.a();
                }
                a2.a();
            }
            this.f23360a.dismissAllowingStateLoss();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "activity");
        com.travel.citybus.a.a.a(context);
        super.onAttach(context);
    }

    private final void a(String str, int i2, double d2) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int i3 = R.layout.fare_breakup_item;
        LinearLayout linearLayout = this.f23353a;
        if (linearLayout == null) {
            k.a("lnrFareBreakUpContainer");
        }
        View inflate = from.inflate(i3, linearLayout, false);
        k.a((Object) inflate, "view");
        RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.tvFareBreakUpType);
        k.a((Object) roboTextView, "view.tvFareBreakUpType");
        roboTextView.setText(str);
        if (i2 > 1) {
            RoboTextView roboTextView2 = (RoboTextView) inflate.findViewById(R.id.tvFareBreakUpCount);
            k.a((Object) roboTextView2, "view.tvFareBreakUpCount");
            roboTextView2.setText("(" + i2 + " Passengers)");
        } else {
            RoboTextView roboTextView3 = (RoboTextView) inflate.findViewById(R.id.tvFareBreakUpCount);
            k.a((Object) roboTextView3, "view.tvFareBreakUpCount");
            roboTextView3.setText("(" + i2 + " Passenger)");
        }
        RoboTextView roboTextView4 = (RoboTextView) inflate.findViewById(R.id.tvFareBreakUpTotal);
        k.a((Object) roboTextView4, "view.tvFareBreakUpTotal");
        roboTextView4.setText("₹ " + com.travel.citybus.brts.utils.a.a(Double.valueOf(d2)));
        LinearLayout linearLayout2 = this.f23353a;
        if (linearLayout2 == null) {
            k.a("lnrFareBreakUpContainer");
        }
        linearLayout2.addView(inflate);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23357e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
