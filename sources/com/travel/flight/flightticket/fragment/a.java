package com.travel.flight.flightticket.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.l;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.a.d;
import com.travel.flight.flightticket.activity.AJRFareAlertSubscribeActivity;
import com.travel.flight.flightticket.e.k;
import com.travel.flight.flightticket.g.f;
import com.travel.flight.flightticket.i.c;
import com.travel.flight.pojo.flightticket.CJRFareAlertHomeAnalyticsModel;
import com.travel.flight.pojo.flightticket.CJRFareAlertsSubscribeResponse;
import com.travel.flight.utils.h;
import com.travel.utils.n;
import java.util.List;
import net.one97.paytm.i.h;

public class a extends h implements View.OnClickListener, d.b, k.a, c {

    /* renamed from: a  reason: collision with root package name */
    private f f24923a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f24924b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRFareAlertHomeAnalyticsModel.a> f24925c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressDialog f24926d;

    /* renamed from: e  reason: collision with root package name */
    private com.travel.flight.flightticket.f.c f24927e;

    /* renamed from: f  reason: collision with root package name */
    private int f24928f;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pre_f_fragment_fare_alert_home_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.lyt_create_alert).setOnClickListener(this);
        this.f24924b = (RecyclerView) view.findViewById(R.id.recycler_fare_alert_home);
        this.f24924b.setLayoutManager(new LinearLayoutManager(getContext()) {
            public final boolean canScrollVertically() {
                return false;
            }
        });
        this.f24924b.setItemAnimator(new g());
        this.f24923a = new f(this, getActivity());
        ResourceUtils.loadFlightImagesFromCDN((ImageView) view.findViewById(R.id.bell_alert_icon), "bell_alert.png", false, false, n.a.V1);
        if (b.r(getContext())) {
            this.f24923a.a();
        }
        d.a.a.c.a().a((Object) this, false);
    }

    public void onDestroyView() {
        d.a.a.c.a().b(this);
        super.onDestroyView();
    }

    public static void a() {
        h.a aVar = new h.a();
        aVar.f25586a = true;
        d.a.a.c.a().c(aVar);
    }

    public final void a(List<CJRFareAlertHomeAnalyticsModel.a> list) {
        if (list != null) {
            this.f24925c = list;
            this.f24924b.setAdapter(new d(getContext(), this, list));
        }
        new l(new k(this)).a(this.f24924b);
    }

    public final void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.lyt_create_alert) {
            startActivity(new Intent(getContext(), AJRFareAlertSubscribeActivity.class));
        }
    }

    public final void a(View view, int i2) {
        List<CJRFareAlertHomeAnalyticsModel.a> list = this.f24925c;
        if (list != null) {
            try {
                CJRFareAlertHomeAnalyticsModel.a aVar = list.get(i2);
                int id = view.getId();
                if (id == R.id.whole_item_container) {
                    this.f24927e.onFareAlertOnClick(aVar);
                } else if (id != R.id.img_blue_bell) {
                } else {
                    if (aVar.f25431g) {
                        f fVar = this.f24923a;
                        if (!b.c(fVar.f25025b)) {
                            fVar.f25024a.b();
                            return;
                        }
                        fVar.f25024a.a(fVar.f25025b.getString(R.string.pre_f_please_wait_progress_msg));
                        com.travel.flight.flightticket.e.b.a(fVar.f25025b, b.d(aVar.f25429e, "dd MMM yyyy", "yyyyMMdd"), aVar.f25427c, aVar.f25428d, new CJRFareAlertsSubscribeResponse(), new com.paytm.network.listener.b(aVar) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ CJRFareAlertHomeAnalyticsModel.a f25027a;

                            {
                                this.f25027a = r2;
                            }

                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                f.this.f25024a.c();
                                if (iJRPaytmDataModel instanceof CJRFareAlertsSubscribeResponse) {
                                    Toast.makeText(f.this.f25025b, ((CJRFareAlertsSubscribeResponse) iJRPaytmDataModel).body, 0).show();
                                    this.f25027a.f25431g = false;
                                    f.this.f25024a.d();
                                }
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                f.a(f.this, networkCustomError);
                                f.this.f25024a.c();
                            }
                        });
                        return;
                    }
                    this.f24923a.a(aVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str) {
        if (getContext() != null || getActivity().isFinishing()) {
            ProgressDialog progressDialog = this.f24926d;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f24926d = new ProgressDialog(getContext());
                try {
                    this.f24926d.setProgressStyle(0);
                    this.f24926d.setMessage(str);
                    this.f24926d.setCancelable(false);
                    this.f24926d.setCanceledOnTouchOutside(false);
                    this.f24926d.show();
                } catch (Exception | IllegalArgumentException unused) {
                }
            }
        }
    }

    public final void c() {
        try {
            if (this.f24926d != null && this.f24926d.isShowing() && !getActivity().isFinishing()) {
                this.f24926d.dismiss();
                this.f24926d = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void d() {
        RecyclerView recyclerView;
        if (getView() != null && (recyclerView = this.f24924b) != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public final void e() {
        this.f24925c.remove(this.f24928f);
        d();
    }

    public final void a(int i2) {
        List<CJRFareAlertHomeAnalyticsModel.a> list = this.f24925c;
        if (list != null) {
            try {
                CJRFareAlertHomeAnalyticsModel.a aVar = list.get(i2);
                this.f24928f = i2;
                this.f24923a.a(aVar);
            } catch (Exception unused) {
            }
        }
    }

    public void onEvent(h.a aVar) {
        f fVar = this.f24923a;
        if (fVar != null) {
            fVar.a();
        }
    }
}
