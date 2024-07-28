package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRFnBDialog;
import net.one97.paytm.o2o.movies.adapter.p;
import net.one97.paytm.o2o.movies.common.b.b;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.utils.g;

public class n extends b implements p.c {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<CJRFoodBeverageItemV2> f75401a;

    /* renamed from: b  reason: collision with root package name */
    protected RecyclerView f75402b;

    /* renamed from: c  reason: collision with root package name */
    protected p f75403c;

    /* renamed from: d  reason: collision with root package name */
    private View f75404d;

    /* renamed from: e  reason: collision with root package name */
    private CJRMoviesSession f75405e;

    /* renamed from: f  reason: collision with root package name */
    private CJRMovies f75406f;

    public final void a(boolean z, boolean z2) {
    }

    public static n a() {
        return new n();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f75405e = (CJRMoviesSession) getArguments().getParcelable("moviesession");
            this.f75406f = (CJRMovies) getArguments().getParcelable("selectedmovie");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f75404d = layoutInflater.inflate(R.layout.fnb_dialog_fragment, viewGroup, false);
        this.f75402b = (RecyclerView) this.f75404d.findViewById(R.id.id_fnb_list);
        b();
        this.f75403c = new p(getActivity(), this.f75401a, this);
        this.f75402b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f75402b.setAdapter(this.f75403c);
        return this.f75404d;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f75401a = g.a().f75925b;
    }

    public void c() {
        this.f75403c.notifyDataSetChanged();
    }

    public final void a(boolean z) {
        ((AJRFnBDialog) getActivity()).a();
    }

    public final void a(int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
            hashMap.put(b.f75007b, b.B);
            String str = b.f75008c;
            hashMap.put(str, "Food Item Added|" + (i2 + 1));
            if (!(this.f75406f == null || this.f75405e == null)) {
                String str2 = b.f75009d;
                hashMap.put(str2, this.f75406f.getTitle() + "|" + this.f75406f.getCode() + "|" + this.f75405e.getCinemaName() + "|" + this.f75405e.getCinemaID());
            }
            hashMap.put(b.p, b.r);
            if (com.paytm.utility.b.r((Context) getActivity())) {
                hashMap.put(b.q, com.paytm.utility.b.n((Context) getActivity()));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(b.f75006a, hashMap, getActivity());
        } catch (Exception unused) {
        }
    }

    public final void b(int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
            hashMap.put(b.f75007b, b.B);
            String str = b.f75008c;
            hashMap.put(str, "Food Item Removed|" + (i2 + 1));
            if (!(this.f75406f == null || this.f75405e == null)) {
                String str2 = b.f75009d;
                hashMap.put(str2, this.f75406f.getTitle() + "|" + this.f75406f.getCode() + "|" + this.f75405e.getCinemaName() + "|" + this.f75405e.getCinemaID());
            }
            hashMap.put(b.p, b.r);
            if (com.paytm.utility.b.r((Context) getActivity())) {
                hashMap.put(b.q, com.paytm.utility.b.n((Context) getActivity()));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(b.f75006a, hashMap, getActivity());
        } catch (Exception unused) {
        }
    }
}
