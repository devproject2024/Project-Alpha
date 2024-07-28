package net.one97.paytm.o2o.movies.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ac;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.fragment.l;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.upi.util.UpiUtils;

public class k extends b implements TextWatcher, View.OnClickListener, b, ac.a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f75377a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f75378b;

    /* renamed from: c  reason: collision with root package name */
    public ac f75379c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJROfferCode> f75380d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75381e;

    /* renamed from: f  reason: collision with root package name */
    private View f75382f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f75383g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f75384h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f75385i;
    private String j;
    private l.a k;
    private ImageView l;
    private ProgressBar m;
    private RelativeLayout n;
    private ImageView o;
    private LinearLayout p;
    private ArrayList<CJRFoodBeverageItemV2> q;

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f75382f = layoutInflater.inflate(R.layout.movie_promo, viewGroup, false);
        this.f75384h = (EditText) this.f75382f.findViewById(R.id.edit_txt_promocode);
        this.o = (ImageView) this.f75382f.findViewById(R.id.promo_remove_image);
        this.f75377a = (RelativeLayout) this.f75382f.findViewById(R.id.promocode_input_lyt);
        this.f75378b = (RelativeLayout) this.f75382f.findViewById(R.id.promocode_success_lyt);
        this.f75381e = (TextView) this.f75382f.findViewById(R.id.promo_status_message);
        this.f75385i = (RecyclerView) this.f75382f.findViewById(R.id.offers_list);
        this.f75385i.setHasFixedSize(true);
        this.f75385i.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f75385i.addItemDecoration(new net.one97.paytm.o2o.movies.utils.ac(getActivity()));
        this.l = (ImageView) this.f75382f.findViewById(R.id.id_movie_promo_activiy_back_btn);
        this.m = (ProgressBar) this.f75382f.findViewById(R.id.update_progress_bar_offers);
        this.n = (RelativeLayout) this.f75382f.findViewById(R.id.offers_layout);
        this.f75383g = (RelativeLayout) this.f75382f.findViewById(R.id.apply_btn_lyt);
        this.p = (LinearLayout) this.f75382f.findViewById(R.id.no_offers_layout);
        Bundle arguments = getArguments();
        this.j = arguments.getString("productid");
        this.q = (ArrayList) arguments.getSerializable("foodBevWithQuantity");
        if (com.paytm.utility.b.r((Context) getActivity())) {
            a();
        } else {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.signOut(getActivity(), false, (VolleyError) null);
            startActivityForResult(new Intent(getActivity(), net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), 4);
        }
        this.o.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.f75384h.addTextChangedListener(this);
        this.f75383g.setOnClickListener(this);
        return this.f75382f;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof l.a) {
            this.k = (l.a) activity;
        }
    }

    private void a() {
        if (com.paytm.utility.b.c((Context) getActivity())) {
            c.a();
            String a2 = c.a("postOrderPromoSearchUrl", (String) null);
            c.a();
            String a3 = c.a("postOrderPromoSearchUrlExtension", (String) null);
            c.a();
            this.j = c.a("postFoodOrderProductId", (String) null);
            String str = a2 + this.j + a3;
            if (URLUtil.isValidUrl(str)) {
                String b2 = com.paytm.utility.b.b((Context) getActivity(), str);
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                cVar.f42877a = getActivity();
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.GET;
                cVar.f42880d = b2;
                cVar.f42881e = null;
                cVar.f42882f = null;
                cVar.f42883g = null;
                cVar.f42884h = null;
                cVar.f42885i = new CJROffers();
                cVar.j = this;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("FJRPostOrderFoodAndBeverages");
                a l2 = cVar.l();
                l2.f42859c = false;
                l2.a();
            }
        }
    }

    private void b() {
        this.m.setVisibility(8);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
    }

    public void afterTextChanged(Editable editable) {
        if (editable.length() > 0) {
            a(true);
            this.o.setVisibility(0);
            return;
        }
        a(false);
    }

    private void a(boolean z) {
        if (z) {
            this.f75383g.setVisibility(0);
        } else {
            this.f75383g.setVisibility(8);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 4) {
            getActivity();
            if (i3 == -1 && com.paytm.utility.b.r((Context) getActivity())) {
                a();
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.apply_btn_lyt) {
            String obj = this.f75384h.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                b(obj);
                n.b((View) this.f75384h);
            }
        } else if (id == R.id.id_movie_promo_activiy_back_btn) {
            getActivity().onBackPressed();
        } else if (id == R.id.promo_remove_image) {
            this.f75384h.setText((CharSequence) null);
            this.o.setVisibility(8);
            this.f75377a.setVisibility(0);
            this.f75378b.setVisibility(8);
            this.f75381e.setVisibility(8);
        }
    }

    private static void b(String str) {
        str.trim().replace(" ", "");
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJROffers) {
            CJROffers cJROffers = (CJROffers) iJRPaytmDataModel;
            if (cJROffers == null || cJROffers.getOfferCodes() == null || cJROffers.getOfferCodes().size() <= 0) {
                b();
                this.p.setVisibility(0);
                return;
            }
            this.n.setVisibility(0);
            b();
            this.f75380d = cJROffers.getOfferCodes();
            this.f75379c = new ac(getActivity(), this.f75380d, "", this);
            this.f75382f.findViewById(R.id.choose_offer_header).setVisibility(0);
            this.f75385i.setAdapter(this.f75379c);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b();
        if (networkCustomError != null) {
            try {
                if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.handleError(getActivity(), networkCustomError, (String) null, (Bundle) null, false);
                } else if (networkCustomError.getMessage() != null && !net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.reportError(getActivity(), networkCustomError, "error.movies@paytm.com")) {
                    if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                        com.paytm.utility.b.b((Context) getActivity(), getActivity().getResources().getString(R.string.network_error_heading), getActivity().getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                        return;
                    }
                    com.paytm.utility.b.d((Context) getActivity(), networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                }
            } catch (Resources.NotFoundException | Exception unused) {
            }
        }
    }
}
