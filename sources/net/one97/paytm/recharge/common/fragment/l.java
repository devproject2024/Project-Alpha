package net.one97.paytm.recharge.common.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.b;
import net.one97.paytm.recharge.ordersummary.h.d;

public class l extends h implements View.OnClickListener, ExpandableListView.OnChildClickListener {

    /* renamed from: a  reason: collision with root package name */
    public List<CJROfferCode> f61303a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView.a f61304b;

    /* renamed from: c  reason: collision with root package name */
    public String f61305c;

    /* renamed from: d  reason: collision with root package name */
    private String f61306d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f61307e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f61308f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f61309g = false;

    /* renamed from: h  reason: collision with root package name */
    private Button f61310h;

    /* renamed from: i  reason: collision with root package name */
    private CJRItem f61311i;
    private int j = 0;
    private d k;

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
        return false;
    }

    public l() {
    }

    public l(List<CJROfferCode> list, CJRItem cJRItem, String str) {
        this.f61303a = list;
        this.f61311i = cJRItem;
        this.f61305c = str;
        if (cJRItem != null && cJRItem.getName() != null) {
            this.f61307e = cJRItem.getName().toLowerCase();
            if (cJRItem.getName().toLowerCase().contains("mobile")) {
                this.f61306d = "recharge_mobile";
                return;
            }
            this.f61306d = "utilities_" + cJRItem.getName().toLowerCase();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.offers_empty_view, (ViewGroup) null, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.utility_offers_list);
        this.f61310h = (Button) view.findViewById(R.id.show_more_btn);
        this.k = new d(getContext());
        if (this.f61308f > 0) {
            this.f61304b = new RecyclerView.a<a>() {
                public final int getItemViewType(int i2) {
                    return i2;
                }

                public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
                    a aVar = (a) vVar;
                    CJROfferCode cJROfferCode = (CJROfferCode) l.this.f61303a.get(i2);
                    aVar.f61313a.setText("");
                    aVar.f61314b.setText(cJROfferCode.getCode());
                    aVar.f61315c.setText(cJROfferCode.getOfferText().trim());
                    aVar.f61318f.setVisibility(8);
                    aVar.f61317e.setVisibility(8);
                    aVar.f61316d.setImageResource(R.drawable.right_arrow_re);
                }

                public final int getItemCount() {
                    if (l.this.f61309g) {
                        return l.this.f61308f;
                    }
                    if (l.this.f61303a == null) {
                        return 0;
                    }
                    return l.this.f61303a.size();
                }

                public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
                    return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recharge_utility_offer_item_view, viewGroup, false), i2);
                }
            };
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(this.f61304b);
            if (this.f61309g) {
                CJRRechargeUtilities.INSTANCE.debugLog(getString(R.string.clog_offers_with_show_more));
                this.f61310h.setVisibility(0);
                this.f61310h.setText(R.string.show_more);
            }
            this.f61310h.setOnClickListener(this);
            return;
        }
        CJRRechargeUtilities.INSTANCE.debugLog(getString(R.string.clog_no_offers));
        recyclerView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x a(int i2) {
        if ("78640".equals(this.f61311i.getCategoryId())) {
            this.k.a("gas_pipeline", "offers_item_clicked", "", "", "cylinder_booking", "", "");
            return null;
        } else if ("166690".equals(this.f61311i.getCategoryId())) {
            this.k.a("book_cylinder", "offers_item_clicked", "", "", "cylinder_booking", "", "");
            return null;
        } else if (e.z.equalsIgnoreCase(this.f61311i.getCategoryId())) {
            this.k.a(this.f61305c, "offers_selected", "", "", ab.f61496a, "", "");
            return null;
        } else if (i2 == -1) {
            return null;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("recharge_utilities_offer_promocode", this.f61303a.get(i2).getCode());
            if (this.f61311i.getURLType().contains(BaseViewModel.PaymentType.POSTPAID)) {
                hashMap.put("recharge_utilities_service_type", BaseViewModel.PaymentType.POSTPAID);
            } else if (this.f61311i.getURLType().contains("prepaid")) {
                hashMap.put("recharge_utilities_service_type", "prepaid");
            }
            b bVar = b.f62652a;
            b.a(this.f61311i, (Map<String, Object>) hashMap, "recharge_utilities_offer_clicked_bottom_tab", getActivity());
            return null;
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.show_more_btn) {
            CJRRechargeUtilities.INSTANCE.debugLog(getString(R.string.clog_offers_show_more));
            this.j = 5;
            this.f61309g = false;
            view.setVisibility(8);
            this.f61304b.notifyDataSetChanged();
            a(view);
        }
    }

    class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f61313a;

        /* renamed from: b  reason: collision with root package name */
        TextView f61314b;

        /* renamed from: c  reason: collision with root package name */
        TextView f61315c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f61316d;

        /* renamed from: e  reason: collision with root package name */
        View f61317e;

        /* renamed from: f  reason: collision with root package name */
        LinearLayout f61318f;

        public a(View view, int i2) {
            super(view);
            this.f61313a = (TextView) view.findViewById(R.id.offer_item_label);
            this.f61314b = (TextView) view.findViewById(R.id.offer_item_code);
            this.f61315c = (TextView) view.findViewById(R.id.offer_item_hint_text);
            this.f61316d = (ImageView) view.findViewById(R.id.arrow_icon_view);
            this.f61317e = view.findViewById(R.id.divider);
            this.f61318f = (LinearLayout) view.findViewById(R.id.order_datails_linear);
            this.f61316d.setImageResource(R.drawable.right_arrow_re);
            l.a(l.this, (CJROfferCode) l.this.f61303a.get(i2), this.f61318f);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.f61318f.getVisibility() == 8) {
                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(adapterPosition) {
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object invoke() {
                        return l.this.a(this.f$1);
                    }
                });
                this.f61318f.setVisibility(0);
                this.f61317e.setVisibility(0);
                this.f61316d.setImageResource(R.drawable.down_arrow_re);
            } else {
                this.f61318f.setVisibility(8);
                this.f61317e.setVisibility(8);
                this.f61316d.setImageResource(R.drawable.right_arrow_re);
            }
            l.this.a(view);
        }
    }

    public final void a() {
        List<CJROfferCode> list = this.f61303a;
        if (list != null && list.size() > 0) {
            this.f61308f = this.f61303a.size();
            if (this.f61308f > 5) {
                this.f61309g = true;
                this.f61308f = 5;
                Button button = this.f61310h;
                if (button != null) {
                    button.setVisibility(0);
                    this.f61310h.setText(R.string.show_more);
                    return;
                }
                return;
            }
            Button button2 = this.f61310h;
            if (button2 != null) {
                button2.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        View currentFocus;
        ba.a(getContext(), view);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
        if (!(appCompatActivity == null || (currentFocus = appCompatActivity.getCurrentFocus()) == null || (currentFocus instanceof RecyclerView))) {
            currentFocus.clearFocus();
        }
        view.requestFocus();
    }

    static /* synthetic */ void a(l lVar, CJROfferCode cJROfferCode, LinearLayout linearLayout) {
        try {
            String replace = cJROfferCode.getTerms().replace("*", "");
            if (replace.contains("<br>")) {
                for (String text : replace.split("<br>")) {
                    View inflate = LayoutInflater.from(lVar.getContext()).inflate(R.layout.recharge_offer_list_item_layout, (ViewGroup) null);
                    ((RoboTextView) inflate.findViewById(R.id.offer_details_text)).setText(text);
                    linearLayout.addView(inflate);
                }
                return;
            }
            ((RoboTextView) LayoutInflater.from(lVar.getContext()).inflate(R.layout.recharge_offer_list_item_layout, (ViewGroup) null).findViewById(R.id.offer_details_text)).setText(replace);
        } catch (NullPointerException e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }
}
