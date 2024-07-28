package net.one97.paytm.feed.ui.feed.o;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.cs;
import net.one97.paytm.feed.f.a.d;
import net.one97.paytm.feed.f.a.e;
import net.one97.paytm.feed.f.a.f;
import net.one97.paytm.feed.f.a.i;

public final class a extends net.one97.paytm.feed.ui.feed.actions.a<cs, net.one97.paytm.feed.ui.feed.actions.b> {

    /* renamed from: d  reason: collision with root package name */
    public static final C0583a f35162d = new C0583a((byte) 0);

    /* renamed from: e  reason: collision with root package name */
    private HashMap f35163e;

    public final boolean e() {
        return true;
    }

    public final void f() {
        HashMap hashMap = this.f35163e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.o.a$a  reason: collision with other inner class name */
    public static final class C0583a {
        private C0583a() {
        }

        public /* synthetic */ C0583a(byte b2) {
            this();
        }
    }

    public final int b() {
        return R.layout.feed_train_pnr_status;
    }

    public final HashMap<Integer, Object> c() {
        return new HashMap<>();
    }

    public final void d() {
        Serializable serializable;
        String str;
        CharSequence charSequence;
        List<e> paxInfo;
        Map<String, String> classes;
        f reservationUpto;
        f reservationUpto2;
        f reservationUpto3;
        net.one97.paytm.feed.f.a.a boardingStation;
        net.one97.paytm.feed.f.a.a boardingStation2;
        net.one97.paytm.feed.f.a.a boardingStation3;
        ((cs) a()).A.setLayoutManager(new LinearLayoutManager(this.f34931c));
        Bundle arguments = getArguments();
        if (!(arguments == null || (serializable = arguments.getSerializable("pnrData")) == null)) {
            if (serializable != null) {
                i iVar = (i) serializable;
                TextView textView = ((cs) a()).q;
                k.a((Object) textView, "dataBinding.pnrHeader");
                StringBuilder sb = new StringBuilder("PNR Status # ");
                net.one97.paytm.feed.f.a.b body = iVar.getBody();
                Boolean bool = null;
                sb.append(body != null ? body.getPnrNumber() : null);
                textView.setText(sb.toString());
                TextView textView2 = ((cs) a()).z;
                k.a((Object) textView2, "dataBinding.trainName");
                StringBuilder sb2 = new StringBuilder();
                net.one97.paytm.feed.f.a.b body2 = iVar.getBody();
                sb2.append(body2 != null ? body2.getTrainName() : null);
                sb2.append(" (");
                net.one97.paytm.feed.f.a.b body3 = iVar.getBody();
                sb2.append(body3 != null ? body3.getTrainNumber() : null);
                sb2.append(")");
                textView2.setText(sb2.toString());
                TextView textView3 = ((cs) a()).y;
                k.a((Object) textView3, "dataBinding.trainDepartureTime");
                net.one97.paytm.feed.f.a.b body4 = iVar.getBody();
                textView3.setText((body4 == null || (boardingStation3 = body4.getBoardingStation()) == null) ? null : boardingStation3.getDepartureTime());
                TextView textView4 = ((cs) a()).x;
                k.a((Object) textView4, "dataBinding.trainDepartureDate");
                net.one97.paytm.feed.f.a.b body5 = iVar.getBody();
                textView4.setText(body5 != null ? body5.getDate() : null);
                TextView textView5 = ((cs) a()).f34089b;
                k.a((Object) textView5, "dataBinding.boardingStationName");
                StringBuilder sb3 = new StringBuilder();
                net.one97.paytm.feed.f.a.b body6 = iVar.getBody();
                sb3.append((body6 == null || (boardingStation2 = body6.getBoardingStation()) == null) ? null : boardingStation2.getStationCode());
                sb3.append(" - ");
                net.one97.paytm.feed.f.a.b body7 = iVar.getBody();
                sb3.append((body7 == null || (boardingStation = body7.getBoardingStation()) == null) ? null : boardingStation.getStationName());
                textView5.setText(sb3.toString());
                TextView textView6 = ((cs) a()).w;
                k.a((Object) textView6, "dataBinding.trainArrivalTime");
                net.one97.paytm.feed.f.a.b body8 = iVar.getBody();
                textView6.setText((body8 == null || (reservationUpto3 = body8.getReservationUpto()) == null) ? null : reservationUpto3.getArrivalTime());
                TextView textView7 = ((cs) a()).v;
                k.a((Object) textView7, "dataBinding.trainArrivalDate");
                textView7.setText(" lkmsndklk ");
                TextView textView8 = ((cs) a()).f34095h;
                k.a((Object) textView8, "dataBinding.destinationStation");
                StringBuilder sb4 = new StringBuilder();
                net.one97.paytm.feed.f.a.b body9 = iVar.getBody();
                sb4.append((body9 == null || (reservationUpto2 = body9.getReservationUpto()) == null) ? null : reservationUpto2.getStationCode());
                sb4.append(" - ");
                net.one97.paytm.feed.f.a.b body10 = iVar.getBody();
                sb4.append((body10 == null || (reservationUpto = body10.getReservationUpto()) == null) ? null : reservationUpto.getStationName());
                textView8.setText(sb4.toString());
                TextView textView9 = ((cs) a()).f34094g;
                k.a((Object) textView9, "dataBinding.coachType");
                d meta = iVar.getMeta();
                if (meta == null || (classes = meta.getClasses()) == null) {
                    str = null;
                } else {
                    net.one97.paytm.feed.f.a.b body11 = iVar.getBody();
                    str = classes.get(body11 != null ? body11.get_class() : null);
                }
                textView9.setText(str);
                TextView textView10 = ((cs) a()).t;
                k.a((Object) textView10, "dataBinding.reservationQuotaType");
                net.one97.paytm.feed.f.a.b body12 = iVar.getBody();
                textView10.setText(body12 != null ? body12.getQuota() : null);
                TextView textView11 = ((cs) a()).r;
                k.a((Object) textView11, "dataBinding.pnrMessage");
                net.one97.paytm.feed.f.a.b body13 = iVar.getBody();
                textView11.setText(body13 != null ? body13.getPnrMessage() : null);
                TextView textView12 = ((cs) a()).f34090c;
                k.a((Object) textView12, "dataBinding.chatPrepared");
                net.one97.paytm.feed.f.a.b body14 = iVar.getBody();
                if (body14 != null) {
                    bool = body14.getChartPrepared();
                }
                if (k.a((Object) bool, (Object) Boolean.TRUE)) {
                    charSequence = getString(R.string.feed_chat_prepared);
                } else {
                    charSequence = getString(R.string.feed_chat_not_prepared);
                }
                textView12.setText(charSequence);
                net.one97.paytm.feed.f.a.b body15 = iVar.getBody();
                if (!(body15 == null || (paxInfo = body15.getPaxInfo()) == null)) {
                    RecyclerView recyclerView = ((cs) a()).A;
                    k.a((Object) recyclerView, "dataBinding.travellerList");
                    recyclerView.setAdapter(new c(paxInfo));
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.train.model.TrainPnrStatus");
            }
        }
        ((cs) a()).f34091d.setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35164a;

        b(a aVar) {
            this.f35164a = aVar;
        }

        public final void onClick(View view) {
            this.f35164a.dismiss();
        }
    }
}
