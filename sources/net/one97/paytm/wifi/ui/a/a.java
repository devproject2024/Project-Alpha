package net.one97.paytm.wifi.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.wifi.R;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final b<WifiAccessPoint, x> f21257a;

    /* renamed from: b  reason: collision with root package name */
    private final LayoutInflater f21258b;

    /* renamed from: c  reason: collision with root package name */
    private final List<WifiAccessPoint> f21259c;

    public a(Context context, List<WifiAccessPoint> list, b<? super WifiAccessPoint, x> bVar) {
        k.c(context, "context");
        k.c(list, "accessPointList");
        k.c(bVar, "accessPointSelecton");
        this.f21259c = list;
        this.f21257a = bVar;
        LayoutInflater from = LayoutInflater.from(context);
        k.a((Object) from, "LayoutInflater.from(context)");
        this.f21258b = from;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        k.c(vVar, "holder");
        if (vVar instanceof C0417a) {
            C0417a aVar = (C0417a) vVar;
            WifiAccessPoint wifiAccessPoint = this.f21259c.get(i2);
            k.c(wifiAccessPoint, "point");
            View view = aVar.itemView;
            k.a((Object) view, "itemView");
            RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.name);
            k.a((Object) roboTextView, "itemView.name");
            roboTextView.setText(wifiAccessPoint.getSSID());
            View view2 = aVar.itemView;
            k.a((Object) view2, "itemView");
            RoboTextView roboTextView2 = (RoboTextView) view2.findViewById(R.id.time);
            k.a((Object) roboTextView2, "itemView.time");
            String connectionStatus = wifiAccessPoint.getConnectionStatus();
            if (connectionStatus != null) {
                charSequence = connectionStatus;
            } else {
                View view3 = aVar.itemView;
                k.a((Object) view3, "itemView");
                charSequence = view3.getContext().getString(R.string.connection_open);
            }
            roboTextView2.setText(charSequence);
            aVar.itemView.setOnClickListener(new C0417a.C0418a(aVar, wifiAccessPoint));
        }
    }

    public final int getItemCount() {
        return this.f21259c.size();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = this.f21258b.inflate(R.layout.avalaible_connection_layout_item, (ViewGroup) null, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…layout_item, null, false)");
        return new C0417a(this, inflate);
    }

    /* renamed from: net.one97.paytm.wifi.ui.a.a$a  reason: collision with other inner class name */
    public final class C0417a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f21260a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0417a(a aVar, View view) {
            super(view);
            k.c(view, "view");
            this.f21260a = aVar;
        }

        /* renamed from: net.one97.paytm.wifi.ui.a.a$a$a  reason: collision with other inner class name */
        static final class C0418a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0417a f21261a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ WifiAccessPoint f21262b;

            C0418a(C0417a aVar, WifiAccessPoint wifiAccessPoint) {
                this.f21261a = aVar;
                this.f21262b = wifiAccessPoint;
            }

            public final void onClick(View view) {
                this.f21261a.f21260a.f21257a.invoke(this.f21262b);
            }
        }
    }
}
