package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.play.core.splitcompat.a;
import com.one97.travelpass.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.travelpass.R;
import net.one97.travelpass.b.e;
import net.one97.travelpass.ui.b.b;
import net.one97.travelpass.ui.c.j;

public final class k extends g implements c {

    /* renamed from: a  reason: collision with root package name */
    private e f30749a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<j> f30750b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap f30751c;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f30751c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onItemClickedItem(j jVar, Integer num, Integer num2) {
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        this.f30749a = (e) f.a(layoutInflater, R.layout.fragment_travel_pass_details, viewGroup, false);
        e eVar = this.f30749a;
        if (eVar == null) {
            kotlin.g.b.k.a();
        }
        return eVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        new j();
        j jVar = new j();
        jVar.a(b.TRAVEL_PASS_TEAMS_CONDITIONS);
        this.f30750b.add(jVar);
        j jVar2 = new j();
        jVar2.a(b.TRAVEL_PASS_BUTTON);
        this.f30750b.add(jVar2);
        j jVar3 = new j();
        jVar3.a(b.TRAVEL_PASS_KNOW_MORE);
        this.f30750b.add(jVar3);
        j jVar4 = new j();
        jVar4.a(b.TRAVEL_PASS_KNOW_MORE);
        this.f30750b.add(jVar4);
        net.one97.travelpass.a.c cVar = new net.one97.travelpass.a.c(getActivity(), this.f30750b, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        e eVar = this.f30749a;
        if (eVar == null) {
            kotlin.g.b.k.a();
        }
        RecyclerView recyclerView = eVar.f30232e;
        kotlin.g.b.k.a((Object) recyclerView, "binding!!.recyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        e eVar2 = this.f30749a;
        if (eVar2 == null) {
            kotlin.g.b.k.a();
        }
        RecyclerView recyclerView2 = eVar2.f30232e;
        kotlin.g.b.k.a((Object) recyclerView2, "binding!!.recyclerView");
        recyclerView2.setAdapter(cVar);
        c cVar2 = new c();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        cVar2.show(activity.getSupportFragmentManager(), cVar2.getTag());
        super.onViewCreated(view, bundle);
    }
}
