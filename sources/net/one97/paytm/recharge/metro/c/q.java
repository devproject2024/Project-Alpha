package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.List;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.a.f;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;

public class q extends h {

    /* renamed from: b  reason: collision with root package name */
    protected static String f63433b = "station_list";

    /* renamed from: c  reason: collision with root package name */
    protected static String f63434c = "source_station";

    /* renamed from: a  reason: collision with root package name */
    protected a f63435a;

    /* renamed from: d  reason: collision with root package name */
    protected List<CJRMetroStationModel> f63436d;

    /* renamed from: e  reason: collision with root package name */
    protected CJRMetroStationModel f63437e;

    /* renamed from: f  reason: collision with root package name */
    protected Bundle f63438f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f63439g;

    /* renamed from: h  reason: collision with root package name */
    private f f63440h = null;

    public interface a {
        void a(CJRMetroStationModel cJRMetroStationModel);

        void a(CJRMetroStationModel cJRMetroStationModel, CJRMetroStationModel cJRMetroStationModel2);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public static q a(List<CJRMetroStationModel> list, String str, CJRMetroStationModel cJRMetroStationModel) {
        q qVar = new q();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f63433b, (Serializable) list);
        bundle.putString("title", str);
        bundle.putSerializable(f63434c, cJRMetroStationModel);
        qVar.setArguments(bundle);
        return qVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.f63435a = (a) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnStationSelectionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f63438f = getArguments();
        Bundle bundle2 = this.f63438f;
        if (bundle2 != null) {
            if (bundle2.containsKey(f63433b)) {
                this.f63436d = (List) this.f63438f.getSerializable(f63433b);
            }
            this.f63439g = this.f63438f.getString("title");
            if (this.f63438f.containsKey(f63434c)) {
                this.f63437e = (CJRMetroStationModel) this.f63438f.getSerializable(f63434c);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_station_selection_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        ((TextView) view.findViewById(R.id.title)).setText(this.f63439g);
        a((RecyclerView) view.findViewById(R.id.stations_list));
        CJRMetroStationModel cJRMetroStationModel = this.f63437e;
        if (cJRMetroStationModel != null && !TextUtils.isEmpty(cJRMetroStationModel.getName())) {
            TextView textView = (TextView) view.findViewById(R.id.information_action);
            textView.setVisibility(0);
            String string = getString(R.string.from_station_to_destination, this.f63437e.getName());
            SpannableString spannableString = new SpannableString(string);
            int indexOf = string.indexOf(this.f63437e.getName()) + this.f63437e.getName().length();
            spannableString.setSpan(new ImageSpan(getContext(), R.drawable.ic_metro_station_from_to), indexOf, indexOf + 1, 33);
            textView.setText(spannableString);
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f63435a = null;
    }

    /* access modifiers changed from: protected */
    public void a(RecyclerView recyclerView) {
        this.f63440h = new f(this.f63437e, this.f63436d, this.f63435a);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.f63440h);
        recyclerView.addItemDecoration(new g(androidx.appcompat.widget.f.b().a(getContext(), R.drawable.grid_divider)));
    }
}
