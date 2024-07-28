package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.hotel4.service.model.details.PriceData;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.service.model.details.SubRoomProvider;
import net.one97.paytm.hotel4.service.model.details.TaxData;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotel4.view.a.l;
import net.one97.paytm.hotel4.view.a.m;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ae;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import org.json.JSONObject;

public final class g extends ab {

    /* renamed from: a  reason: collision with root package name */
    public ae f28844a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f28845b;

    /* renamed from: c  reason: collision with root package name */
    public RoomSelectionViewModel f28846c;

    /* renamed from: d  reason: collision with root package name */
    public l f28847d;

    /* renamed from: e  reason: collision with root package name */
    public m f28848e;

    static final class a<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f28849a;

        a(g gVar) {
            this.f28849a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "flag");
            if (bool.booleanValue()) {
                this.f28849a.dismiss();
            }
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window == null) {
            k.a();
        }
        k.a((Object) window, "dialog?.window!!");
        window.getAttributes().windowAnimations = R.style.H4BottomSheet;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        RoomSelectionViewModel roomSelectionViewModel = this.f28846c;
        if (roomSelectionViewModel == null) {
            k.a("viewModel");
        }
        roomSelectionViewModel.getCloseFareBreakUpButtonClickListener().observe(this, new a(this));
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28845b = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28845b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a3 = am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(RoomSelectionViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…ionViewModel::class.java)");
            this.f28846c = (RoomSelectionViewModel) a3;
        }
        ae a4 = ae.a(layoutInflater, viewGroup);
        k.a((Object) a4, "H4FareBreakupBottomSheet…flater, container, false)");
        this.f28844a = a4;
        ae aeVar = this.f28844a;
        if (aeVar == null) {
            k.a("dataBinding");
        }
        RoomSelectionViewModel roomSelectionViewModel = this.f28846c;
        if (roomSelectionViewModel == null) {
            k.a("viewModel");
        }
        aeVar.a(roomSelectionViewModel);
        ae aeVar2 = this.f28844a;
        if (aeVar2 == null) {
            k.a("dataBinding");
        }
        aeVar2.setLifecycleOwner(this);
        RoomSelectionViewModel roomSelectionViewModel2 = this.f28846c;
        if (roomSelectionViewModel2 == null) {
            k.a("viewModel");
        }
        SubRoomOptions value = roomSelectionViewModel2.get_selectedRoomData().getValue();
        SharedViewModel sharedViewModel2 = this.f28845b;
        if (sharedViewModel2 == null) {
            k.a("sharedViewModel");
        }
        CJRHotelSearchInput searchInput = sharedViewModel2.getSearchInput();
        if (searchInput == null) {
            k.a();
        }
        this.f28847d = new l(value, searchInput.getNumOfNights());
        ae aeVar3 = this.f28844a;
        if (aeVar3 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = aeVar3.f29124c;
        k.a((Object) recyclerView, "this.dataBinding.rvRoomConfig");
        l lVar = this.f28847d;
        if (lVar == null) {
            k.a("roomConfigAdapter");
        }
        recyclerView.setAdapter(lVar);
        l lVar2 = this.f28847d;
        if (lVar2 == null) {
            k.a("roomConfigAdapter");
        }
        SharedViewModel sharedViewModel3 = this.f28845b;
        if (sharedViewModel3 == null) {
            k.a("sharedViewModel");
        }
        CJRHotelSearchInput searchInput2 = sharedViewModel3.getSearchInput();
        if (searchInput2 == null) {
            k.a();
        }
        lVar2.a(searchInput2.getRooms());
        RoomSelectionViewModel roomSelectionViewModel3 = this.f28846c;
        if (roomSelectionViewModel3 == null) {
            k.a("viewModel");
        }
        SubRoomOptions value2 = roomSelectionViewModel3.get_selectedRoomData().getValue();
        if (value2 == null) {
            k.a();
        }
        List<SubRoomProvider> subRoomProviders = value2.getSubRoomProviders();
        if (subRoomProviders == null) {
            k.a();
        }
        PriceData priceData = subRoomProviders.get(0).getPriceData();
        if (priceData == null) {
            k.a();
        }
        ArrayList<o> mTaxesList = priceData.getMTaxesList();
        List arrayList = new ArrayList();
        if (mTaxesList != null && mTaxesList.size() > 0) {
            Iterator<o> it2 = mTaxesList.iterator();
            while (it2.hasNext()) {
                e eVar = e.f28642a;
                TaxData a5 = e.a(new JSONObject(it2.next().toString()));
                if (!p.a(a5.getPrice(), "0.0", false)) {
                    arrayList.add(a5);
                }
            }
        }
        this.f28848e = new m();
        ae aeVar4 = this.f28844a;
        if (aeVar4 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView2 = aeVar4.f29125d;
        k.a((Object) recyclerView2, "this.dataBinding.rvRoomConfigTax");
        m mVar = this.f28848e;
        if (mVar == null) {
            k.a("roomConfigTaxAdapter");
        }
        recyclerView2.setAdapter(mVar);
        if (arrayList.size() > 0) {
            ae aeVar5 = this.f28844a;
            if (aeVar5 == null) {
                k.a("dataBinding");
            }
            View view = aeVar5.j;
            k.a((Object) view, "dataBinding.vLine");
            view.setVisibility(0);
            ae aeVar6 = this.f28844a;
            if (aeVar6 == null) {
                k.a("dataBinding");
            }
            RecyclerView recyclerView3 = aeVar6.f29125d;
            k.a((Object) recyclerView3, "dataBinding.rvRoomConfigTax");
            recyclerView3.setVisibility(0);
            ae aeVar7 = this.f28844a;
            if (aeVar7 == null) {
                k.a("dataBinding");
            }
            TextView textView = aeVar7.f29127f;
            k.a((Object) textView, "dataBinding.tvTax");
            textView.setVisibility(0);
            m mVar2 = this.f28848e;
            if (mVar2 == null) {
                k.a("roomConfigTaxAdapter");
            }
            mVar2.a(arrayList);
        } else {
            ae aeVar8 = this.f28844a;
            if (aeVar8 == null) {
                k.a("dataBinding");
            }
            View view2 = aeVar8.j;
            k.a((Object) view2, "dataBinding.vLine");
            view2.setVisibility(8);
            ae aeVar9 = this.f28844a;
            if (aeVar9 == null) {
                k.a("dataBinding");
            }
            RecyclerView recyclerView4 = aeVar9.f29125d;
            k.a((Object) recyclerView4, "dataBinding.rvRoomConfigTax");
            recyclerView4.setVisibility(8);
            ae aeVar10 = this.f28844a;
            if (aeVar10 == null) {
                k.a("dataBinding");
            }
            TextView textView2 = aeVar10.f29127f;
            k.a((Object) textView2, "dataBinding.tvTax");
            textView2.setVisibility(8);
        }
        ae aeVar11 = this.f28844a;
        if (aeVar11 == null) {
            k.a("dataBinding");
        }
        return aeVar11.getRoot();
    }
}
