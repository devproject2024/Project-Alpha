package net.one97.paytm.hotel4.view.ui.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.travel.widget.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.hotel4.service.model.details.Data;
import net.one97.paytm.hotel4.service.model.details.HotelDetails;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.RoomTypeSelection;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.service.model.details.SubRoomProvider;
import net.one97.paytm.hotel4.view.a.p;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionListViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.dy;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import org.json.JSONObject;

public final class v extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f28997c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public DetailsViewModel f28998a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f28999b;

    /* renamed from: d  reason: collision with root package name */
    private dy f29000d;

    /* renamed from: e  reason: collision with root package name */
    private RoomSelectionViewModel f29001e;

    /* renamed from: f  reason: collision with root package name */
    private RoomSelectionListViewModel f29002f;

    /* renamed from: g  reason: collision with root package name */
    private PagerGalleryViewModel f29003g;

    /* renamed from: h  reason: collision with root package name */
    private String f29004h = "";

    /* renamed from: i  reason: collision with root package name */
    private p f29005i;
    private LottieAnimationView j;

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f29010a;

        d(v vVar) {
            this.f29010a = vVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            v vVar = this.f29010a;
            k.a((Object) bool, "status");
            v.a(vVar, bool.booleanValue());
        }
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f29011a;

        e(v vVar) {
            this.f29011a = vVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            v vVar = this.f29011a;
            k.a((Object) bool, "status");
            v.b(vVar, bool.booleanValue());
        }
    }

    static final class f<T> implements z<SubRoomOptions> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f29012a;

        f(v vVar) {
            this.f29012a = vVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (((SubRoomOptions) obj) != null) {
                v.a(this.f29012a);
            }
        }
    }

    static final class g<T> implements z<HotelDetails> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f29013a;

        g(v vVar) {
            this.f29013a = vVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            v.a(this.f29013a, (HotelDetails) obj);
        }
    }

    static final class h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f29014a;

        h(v vVar) {
            this.f29014a = vVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            v vVar = this.f29014a;
            k.a((Object) bool, "status");
            v.c(vVar, bool.booleanValue());
        }
    }

    static final class i<T> implements z<List<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f29015a;

        i(v vVar) {
            this.f29015a = vVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            FragmentActivity activity = this.f29015a.getActivity();
            FragmentActivity activity2 = this.f29015a.getActivity();
            String string = activity2 != null ? activity2.getString(R.string.h4_room_inclusion) : null;
            SharedViewModel sharedViewModel = this.f29015a.f28999b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            net.one97.paytm.hotel4.utils.e.a(activity, (List<String>) list, string, sharedViewModel);
        }
    }

    public static final /* synthetic */ dy b(v vVar) {
        dy dyVar = vVar.f29000d;
        if (dyVar == null) {
            k.a("dataBinding");
        }
        return dyVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        dy a2 = dy.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4RoomSelectionVpagerBin…flater, container, false)");
        this.f29000d = a2;
        dy dyVar = this.f29000d;
        if (dyVar == null) {
            k.a("dataBinding");
        }
        return dyVar.getRoot();
    }

    public final void onCreate(Bundle bundle) {
        Data data;
        String name;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28999b = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28999b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            al.b viewModelFactory = new ViewModelFactory(sharedViewModel);
            ai a3 = am.a(activity, viewModelFactory).a(DetailsViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…ilsViewModel::class.java)");
            this.f28998a = (DetailsViewModel) a3;
            ai a4 = am.a(activity, viewModelFactory).a(RoomSelectionViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…ionViewModel::class.java)");
            this.f29001e = (RoomSelectionViewModel) a4;
            ai a5 = am.a(activity, viewModelFactory).a(RoomSelectionListViewModel.class);
            k.a((Object) a5, "ViewModelProviders.of(it…istViewModel::class.java)");
            this.f29002f = (RoomSelectionListViewModel) a5;
            ai a6 = am.a(activity, viewModelFactory).a(PagerGalleryViewModel.class);
            k.a((Object) a6, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f29003g = (PagerGalleryViewModel) a6;
        }
        RoomSelectionViewModel roomSelectionViewModel = this.f29001e;
        if (roomSelectionViewModel == null) {
            k.a("roomSelectionViewModel");
        }
        q qVar = this;
        roomSelectionViewModel.get_refreshAddHotelData().observe(qVar, new d(this));
        RoomSelectionViewModel roomSelectionViewModel2 = this.f29001e;
        if (roomSelectionViewModel2 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel2.get_refreshRemoveHotelData().observe(qVar, new e(this));
        RoomSelectionViewModel roomSelectionViewModel3 = this.f29001e;
        if (roomSelectionViewModel3 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel3.get_selectedRoomData().observe(qVar, new f(this));
        DetailsViewModel detailsViewModel = this.f28998a;
        if (detailsViewModel == null) {
            k.a("detailsViewModel");
        }
        detailsViewModel.getApiCallSuccess().observe(qVar, new g(this));
        DetailsViewModel detailsViewModel2 = this.f28998a;
        if (detailsViewModel2 == null) {
            k.a("detailsViewModel");
        }
        detailsViewModel2.isApiCalling().observe(qVar, new h(this));
        RoomSelectionViewModel roomSelectionViewModel4 = this.f29001e;
        if (roomSelectionViewModel4 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel4.getAllInclusionsDialogListener().observe(qVar, new i(this));
        DetailsViewModel detailsViewModel3 = this.f28998a;
        if (detailsViewModel3 == null) {
            k.a("detailsViewModel");
        }
        HotelDetails detailsResponse = detailsViewModel3.getDetailsResponse();
        if (detailsResponse != null && (data = detailsResponse.getData()) != null && (name = data.getName()) != null) {
            RoomSelectionViewModel roomSelectionViewModel5 = this.f29001e;
            if (roomSelectionViewModel5 == null) {
                k.a("roomSelectionViewModel");
            }
            roomSelectionViewModel5.sendPageOpenPulseEvent("select_room", name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e6, code lost:
        r0 = r0.getData();
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r4, r0)
            super.onViewCreated(r4, r5)
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L_0x015b
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r3.f28999b
            if (r4 != 0) goto L_0x0019
            java.lang.String r5 = "sharedViewModel"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0019:
            androidx.lifecycle.y r4 = r4.isFromRoomSelection()
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r4.postValue(r5)
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            java.lang.String r5 = "roomSelectionViewModel"
            if (r4 != 0) goto L_0x002b
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x002b:
            androidx.lifecycle.y r4 = r4.get_selectedRoomData()
            java.lang.Object r4 = r4.getValue()
            if (r4 == 0) goto L_0x0046
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x003c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x003c:
            androidx.lifecycle.y r4 = r4.get_selectedRoomDataContinue()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r4.postValue(r0)
            goto L_0x0056
        L_0x0046:
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x004d:
            androidx.lifecycle.y r4 = r4.get_selectedRoomDataContinue()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.postValue(r0)
        L_0x0056:
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x005d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x005d:
            androidx.lifecycle.y r4 = r4.get_selectedRoomData()
            java.lang.Object r4 = r4.getValue()
            if (r4 == 0) goto L_0x0085
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x006e
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x006e:
            boolean r4 = r4.isRoomSelectedPopUpCancelled()
            if (r4 != 0) goto L_0x0085
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x007b
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x007b:
            androidx.lifecycle.y r4 = r4.get_roomSelectedPopUp()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r4.postValue(r0)
            goto L_0x0095
        L_0x0085:
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x008c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x008c:
            androidx.lifecycle.y r4 = r4.get_roomSelectedPopUp()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.postValue(r0)
        L_0x0095:
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x009c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x009c:
            r0 = 0
            r4.set_showingProgress(r0)
            net.one97.paytm.hotels2.b.dy r4 = r3.f29000d
            java.lang.String r0 = "dataBinding"
            if (r4 != 0) goto L_0x00a9
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00a9:
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r1 = r3.f29001e
            if (r1 != 0) goto L_0x00b0
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00b0:
            r4.a(r1)
            net.one97.paytm.hotels2.b.dy r4 = r3.f29000d
            if (r4 != 0) goto L_0x00ba
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00ba:
            r1 = r3
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            r4.setLifecycleOwner(r1)
            net.one97.paytm.hotels2.b.dy r4 = r3.f29000d
            if (r4 != 0) goto L_0x00c7
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00c7:
            com.airbnb.lottie.LottieAnimationView r4 = r4.f29547b
            r3.j = r4
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x00d2
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00d2:
            androidx.lifecycle.y r4 = r4.get_title()
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r3.f28998a
            java.lang.String r1 = "detailsViewModel"
            if (r0 != 0) goto L_0x00df
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00df:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r0 = r0.getDetailsResponse()
            r2 = 0
            if (r0 == 0) goto L_0x00f1
            net.one97.paytm.hotel4.service.model.details.Data r0 = r0.getData()
            if (r0 == 0) goto L_0x00f1
            java.lang.String r0 = r0.getName()
            goto L_0x00f2
        L_0x00f1:
            r0 = r2
        L_0x00f2:
            r4.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x00fc
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00fc:
            r4.makeSubHeader()
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r3.f29001e
            if (r4 != 0) goto L_0x0106
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0106:
            androidx.lifecycle.y r4 = r4.get_roomTypeCount()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r3.f28998a
            if (r0 != 0) goto L_0x0116
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0116:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r0 = r0.getDetailsResponse()
            if (r0 == 0) goto L_0x0131
            net.one97.paytm.hotel4.service.model.details.Data r0 = r0.getData()
            if (r0 == 0) goto L_0x0131
            java.util.List r0 = r0.getRoomOptions()
            if (r0 == 0) goto L_0x0131
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0132
        L_0x0131:
            r0 = r2
        L_0x0132:
            r5.append(r0)
            java.lang.String r0 = " Room types Available"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.postValue(r5)
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r4 = r3.f28998a
            if (r4 != 0) goto L_0x0148
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0148:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r4 = r4.getDetailsResponse()
            if (r4 == 0) goto L_0x0158
            net.one97.paytm.hotel4.service.model.details.Data r4 = r4.getData()
            if (r4 == 0) goto L_0x0158
            java.util.List r2 = r4.getRoomOptions()
        L_0x0158:
            r3.a((java.util.List<net.one97.paytm.hotel4.service.model.details.RoomOption>) r2)
        L_0x015b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.v.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public static final class b<T> implements Comparator<T> {
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            r5 = (r5 = (r5 = r5.getSubRoomProviders()).get(0)).getPriceData();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int compare(T r5, T r6) {
            /*
                r4 = this;
                net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r5 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r5
                net.one97.paytm.hotel4.service.model.details.SubRoomOptions r5 = r5.getSubRoomOptionse()
                r0 = 0
                r1 = 0
                if (r5 == 0) goto L_0x0027
                java.util.List r5 = r5.getSubRoomProviders()
                if (r5 == 0) goto L_0x0027
                java.lang.Object r5 = r5.get(r0)
                net.one97.paytm.hotel4.service.model.details.SubRoomProvider r5 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r5
                if (r5 == 0) goto L_0x0027
                net.one97.paytm.hotel4.service.model.details.PriceData r5 = r5.getPriceData()
                if (r5 == 0) goto L_0x0027
                double r2 = r5.getFinalPrice()
                java.lang.Double r5 = java.lang.Double.valueOf(r2)
                goto L_0x0028
            L_0x0027:
                r5 = r1
            L_0x0028:
                java.lang.Comparable r5 = (java.lang.Comparable) r5
                net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r6 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r6
                net.one97.paytm.hotel4.service.model.details.SubRoomOptions r6 = r6.getSubRoomOptionse()
                if (r6 == 0) goto L_0x004e
                java.util.List r6 = r6.getSubRoomProviders()
                if (r6 == 0) goto L_0x004e
                java.lang.Object r6 = r6.get(r0)
                net.one97.paytm.hotel4.service.model.details.SubRoomProvider r6 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r6
                if (r6 == 0) goto L_0x004e
                net.one97.paytm.hotel4.service.model.details.PriceData r6 = r6.getPriceData()
                if (r6 == 0) goto L_0x004e
                double r0 = r6.getFinalPrice()
                java.lang.Double r1 = java.lang.Double.valueOf(r0)
            L_0x004e:
                java.lang.Comparable r1 = (java.lang.Comparable) r1
                int r5 = kotlin.b.a.a(r5, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.v.b.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    private final void a() {
        RoomSelectionViewModel roomSelectionViewModel = this.f29001e;
        if (roomSelectionViewModel == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel.set_showingProgress(true);
        net.one97.paytm.common.widgets.a.a(this.j);
    }

    private final void a(List<RoomOption> list) {
        SubRoomOptions subRoomOptions;
        RoomOption roomOption;
        int i2;
        int i3;
        int i4;
        Object obj;
        Object obj2;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        SubRoomOptions subRoomOptions2 = null;
        boolean z = false;
        int i5 = -1;
        if (list != null) {
            RoomOption roomOption2 = null;
            SubRoomOptions subRoomOptions3 = null;
            for (RoomOption next : list) {
                arrayList2.clear();
                arrayList.add(new RoomTypeSelection(1, next, subRoomOptions2, z));
                List<SubRoomOptions> subRoomOptionses = next.getSubRoomOptionses();
                if (subRoomOptionses == null) {
                    k.a();
                }
                for (SubRoomOptions next2 : subRoomOptionses) {
                    List<SubRoomProvider> subRoomProviders = next2.getSubRoomProviders();
                    if (subRoomProviders == null) {
                        k.a();
                    }
                    Object obj3 = new JSONObject(String.valueOf(subRoomProviders.get(z ? 1 : 0).getBookParams())).get("rotc");
                    List<SubRoomProvider> subRoomProviders2 = next2.getSubRoomProviders();
                    if (subRoomProviders2 == null) {
                        k.a();
                    }
                    Object obj4 = new JSONObject(String.valueOf(subRoomProviders2.get(z).getBookParams())).get(H5RpcPlugin.RPC);
                    String str = obj3.toString() + obj4.toString();
                    RoomSelectionViewModel roomSelectionViewModel = this.f29001e;
                    if (roomSelectionViewModel == null) {
                        k.a("roomSelectionViewModel");
                    }
                    if (roomSelectionViewModel.get_selectedRoomData().getValue() != null) {
                        RoomSelectionViewModel roomSelectionViewModel2 = this.f29001e;
                        if (roomSelectionViewModel2 == null) {
                            k.a("roomSelectionViewModel");
                        }
                        SubRoomOptions value = roomSelectionViewModel2.get_selectedRoomData().getValue();
                        if (value == null) {
                            k.a();
                        }
                        List<SubRoomProvider> subRoomProviders3 = value.getSubRoomProviders();
                        if (subRoomProviders3 == null) {
                            k.a();
                        }
                        i4 = i3;
                        obj2 = new JSONObject(String.valueOf(subRoomProviders3.get(0).getBookParams())).get("rotc");
                        RoomSelectionViewModel roomSelectionViewModel3 = this.f29001e;
                        if (roomSelectionViewModel3 == null) {
                            k.a("roomSelectionViewModel");
                        }
                        SubRoomOptions value2 = roomSelectionViewModel3.get_selectedRoomData().getValue();
                        if (value2 == null) {
                            k.a();
                        }
                        List<SubRoomProvider> subRoomProviders4 = value2.getSubRoomProviders();
                        if (subRoomProviders4 == null) {
                            k.a();
                        }
                        obj = new JSONObject(String.valueOf(subRoomProviders4.get(0).getBookParams())).get(H5RpcPlugin.RPC);
                    } else {
                        i4 = i3;
                        obj2 = null;
                        obj = null;
                    }
                    String str2 = String.valueOf(obj2) + String.valueOf(obj);
                    RoomSelectionViewModel roomSelectionViewModel4 = this.f29001e;
                    if (roomSelectionViewModel4 == null) {
                        k.a("roomSelectionViewModel");
                    }
                    if (roomSelectionViewModel4.get_selectedRoomData().getValue() == null || !k.a((Object) str, (Object) str2)) {
                        i3 = i4;
                    } else {
                        i3 = arrayList.size();
                        roomOption2 = next;
                        subRoomOptions3 = next2;
                    }
                    arrayList2.add(new RoomTypeSelection(0, next, next2, false));
                    z = false;
                }
                int i6 = i3;
                if (arrayList2.size() > 0) {
                    if (arrayList2.size() > 1) {
                        kotlin.a.k.a(arrayList2, new b());
                    }
                    ((RoomTypeSelection) arrayList2.get(0)).setGalleryVisible(true);
                    arrayList.addAll(arrayList2);
                }
                i5 = i6;
                subRoomOptions2 = null;
                z = false;
            }
            i2 = i3;
            roomOption = roomOption2;
            subRoomOptions = subRoomOptions3;
        } else {
            i2 = -1;
            roomOption = null;
            subRoomOptions = null;
        }
        if (arrayList.size() == 0) {
            RoomSelectionViewModel roomSelectionViewModel5 = this.f29001e;
            if (roomSelectionViewModel5 == null) {
                k.a("roomSelectionViewModel");
            }
            roomSelectionViewModel5.loadNoRoomView();
            return;
        }
        PagerGalleryViewModel pagerGalleryViewModel = this.f29003g;
        if (pagerGalleryViewModel == null) {
            k.a("pagerGalleryViewModel");
        }
        pagerGalleryViewModel.setRoomTypeSelection((List<RoomTypeSelection>) arrayList);
        DetailsViewModel detailsViewModel = this.f28998a;
        if (detailsViewModel == null) {
            k.a("detailsViewModel");
        }
        RoomSelectionViewModel roomSelectionViewModel6 = this.f29001e;
        if (roomSelectionViewModel6 == null) {
            k.a("roomSelectionViewModel");
        }
        RoomSelectionListViewModel roomSelectionListViewModel = this.f29002f;
        if (roomSelectionListViewModel == null) {
            k.a("roomSelectionListViewModel");
        }
        PagerGalleryViewModel pagerGalleryViewModel2 = this.f29003g;
        if (pagerGalleryViewModel2 == null) {
            k.a("pagerGalleryViewModel");
        }
        this.f29005i = new p(arrayList, detailsViewModel, roomSelectionViewModel6, roomSelectionListViewModel, pagerGalleryViewModel2, getActivity());
        dy dyVar = this.f29000d;
        if (dyVar == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = dyVar.f29548c;
        k.a((Object) recyclerView, "this.dataBinding.roomOptionsRecycleview");
        recyclerView.setAdapter(this.f29005i);
        dy dyVar2 = this.f29000d;
        if (dyVar2 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView2 = dyVar2.f29548c;
        p pVar = this.f29005i;
        if (pVar == null) {
            k.a();
        }
        recyclerView2.addItemDecoration(new com.travel.widget.b(pVar, new c(this)));
        if (i2 > 0) {
            RoomSelectionViewModel roomSelectionViewModel7 = this.f29001e;
            if (roomSelectionViewModel7 == null) {
                k.a("roomSelectionViewModel");
            }
            if (!(roomSelectionViewModel7.get_selectedRoomData().getValue() == null || roomOption == null || subRoomOptions == null)) {
                RoomSelectionViewModel roomSelectionViewModel8 = this.f29001e;
                if (roomSelectionViewModel8 == null) {
                    k.a("roomSelectionViewModel");
                }
                roomSelectionViewModel8.selectDefaultRoomSelect(subRoomOptions, roomOption);
            }
            dy dyVar3 = this.f29000d;
            if (dyVar3 == null) {
                k.a("dataBinding");
            }
            dyVar3.f29548c.scrollToPosition(i2);
            return;
        }
        RoomSelectionViewModel roomSelectionViewModel9 = this.f29001e;
        if (roomSelectionViewModel9 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel9.get_selectedRoomData().postValue(null);
        RoomSelectionViewModel roomSelectionViewModel10 = this.f29001e;
        if (roomSelectionViewModel10 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel10.get_selectedRoomDataContinue().postValue(Boolean.FALSE);
        RoomSelectionViewModel roomSelectionViewModel11 = this.f29001e;
        if (roomSelectionViewModel11 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel11.get_roomSelectedPopUp().postValue(Boolean.FALSE);
        RoomSelectionViewModel roomSelectionViewModel12 = this.f29001e;
        if (roomSelectionViewModel12 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel12.setRoomSelectedPopUpCancelled(false);
        if (arrayList.size() == 0) {
            RoomSelectionViewModel roomSelectionViewModel13 = this.f29001e;
            if (roomSelectionViewModel13 == null) {
                k.a("roomSelectionViewModel");
            }
            roomSelectionViewModel13.loadNoRoomView();
        }
    }

    public static final class c implements b.C0495b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f29006a;

        c(v vVar) {
            this.f29006a = vVar;
        }

        public final void a(int i2, View view) {
            k.c(view, "view");
            x.e eVar = new x.e();
            T t = v.b(this.f29006a).f29546a;
            k.a((Object) t, "this@FJRRoomSelectionFra…ng.llRoomTypeStickyHeader");
            eVar.element = t;
            LinearLayout linearLayout = (LinearLayout) eVar.element;
            if (linearLayout != null) {
                linearLayout.post(new a(view, i2, eVar));
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f29007a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f29008b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ x.e f29009c;

            a(View view, int i2, x.e eVar) {
                this.f29007a = view;
                this.f29008b = i2;
                this.f29009c = eVar;
            }

            public final void run() {
                this.f29007a.setTag(Integer.valueOf(this.f29008b));
                ((LinearLayout) this.f29009c.element).removeAllViews();
                ((LinearLayout) this.f29009c.element).addView(this.f29007a);
            }
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        RoomSelectionViewModel roomSelectionViewModel = this.f29001e;
        if (roomSelectionViewModel == null) {
            k.a("roomSelectionViewModel");
        }
        if (roomSelectionViewModel.get_selectedRoomData().getValue() != null) {
            RoomSelectionViewModel roomSelectionViewModel2 = this.f29001e;
            if (roomSelectionViewModel2 == null) {
                k.a("roomSelectionViewModel");
            }
            if (roomSelectionViewModel2.isRoomSelectedPopUpCancelled()) {
                RoomSelectionViewModel roomSelectionViewModel3 = this.f29001e;
                if (roomSelectionViewModel3 == null) {
                    k.a("roomSelectionViewModel");
                }
                roomSelectionViewModel3.setRoomSelectedPopUpCancelled(true);
                return;
            }
        }
        RoomSelectionViewModel roomSelectionViewModel4 = this.f29001e;
        if (roomSelectionViewModel4 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel4.setRoomSelectedPopUpCancelled(false);
    }

    public final void onDetach() {
        super.onDetach();
        SharedViewModel sharedViewModel = this.f28999b;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        sharedViewModel.isFromRoomSelection().postValue(Boolean.FALSE);
    }

    public static final /* synthetic */ void a(v vVar, boolean z) {
        if (z) {
            vVar.f29004h = "+";
            RoomSelectionViewModel roomSelectionViewModel = vVar.f29001e;
            if (roomSelectionViewModel == null) {
                k.a("roomSelectionViewModel");
            }
            if (!roomSelectionViewModel.addRoom()) {
                Toast.makeText(vVar.getActivity(), "Not a valid room selection", 0).show();
            } else if (com.paytm.utility.b.c((Context) vVar.getActivity())) {
                vVar.a();
                DetailsViewModel detailsViewModel = vVar.f28998a;
                if (detailsViewModel == null) {
                    k.a("detailsViewModel");
                }
                detailsViewModel.fetchDetailForRoomSelection();
                RoomSelectionViewModel roomSelectionViewModel2 = vVar.f29001e;
                if (roomSelectionViewModel2 == null) {
                    k.a("roomSelectionViewModel");
                }
                roomSelectionViewModel2.get_refreshAddHotelData().postValue(Boolean.valueOf(!z));
            } else {
                com.paytm.utility.b.a((Context) vVar.getActivity(), vVar.getResources().getString(R.string.hotels_hotel_no_internet_title), vVar.getResources().getString(R.string.hotels_hotel_no_internet_message));
            }
        }
    }

    public static final /* synthetic */ void b(v vVar, boolean z) {
        if (z) {
            RoomSelectionViewModel roomSelectionViewModel = vVar.f29001e;
            if (roomSelectionViewModel == null) {
                k.a("roomSelectionViewModel");
            }
            boolean removeLastAddedRoom = roomSelectionViewModel.removeLastAddedRoom();
            vVar.f29004h = "-";
            if (!removeLastAddedRoom) {
                return;
            }
            if (com.paytm.utility.b.c((Context) vVar.getActivity())) {
                vVar.a();
                DetailsViewModel detailsViewModel = vVar.f28998a;
                if (detailsViewModel == null) {
                    k.a("detailsViewModel");
                }
                detailsViewModel.fetchDetailForRoomSelection();
                RoomSelectionViewModel roomSelectionViewModel2 = vVar.f29001e;
                if (roomSelectionViewModel2 == null) {
                    k.a("roomSelectionViewModel");
                }
                roomSelectionViewModel2.get_refreshRemoveHotelData().postValue(Boolean.valueOf(!removeLastAddedRoom));
                return;
            }
            com.paytm.utility.b.a((Context) vVar.getActivity(), vVar.getResources().getString(R.string.hotels_hotel_no_internet_title), vVar.getResources().getString(R.string.hotels_hotel_no_internet_message));
        }
    }

    public static final /* synthetic */ void a(v vVar) {
        p pVar = vVar.f29005i;
        if (pVar != null) {
            pVar.notifyDataSetChanged();
        }
    }

    public static final /* synthetic */ void a(v vVar, HotelDetails hotelDetails) {
        List<RoomOption> roomOptions;
        net.one97.paytm.common.widgets.a.b(vVar.j);
        RoomSelectionViewModel roomSelectionViewModel = vVar.f29001e;
        if (roomSelectionViewModel == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel.set_showingProgress(false);
        if (hotelDetails != null) {
            Data data = hotelDetails.getData();
            List<RoomOption> list = null;
            List<RoomOption> roomOptions2 = data != null ? data.getRoomOptions() : null;
            if (roomOptions2 == null) {
                k.a();
            }
            if (roomOptions2.size() > 0) {
                SharedViewModel sharedViewModel = vVar.f28999b;
                if (sharedViewModel == null) {
                    k.a("sharedViewModel");
                }
                if (sharedViewModel.getSearchTemporaryInput() != null) {
                    SharedViewModel sharedViewModel2 = vVar.f28999b;
                    if (sharedViewModel2 == null) {
                        k.a("sharedViewModel");
                    }
                    if (sharedViewModel2.getSearchTemporaryInput() != null) {
                        SharedViewModel sharedViewModel3 = vVar.f28999b;
                        if (sharedViewModel3 == null) {
                            k.a("sharedViewModel");
                        }
                        CJRHotelSearchInput searchTemporaryInput = sharedViewModel3.getSearchTemporaryInput();
                        Integer valueOf = searchTemporaryInput != null ? Integer.valueOf(searchTemporaryInput.getNumOfNights()) : null;
                        if (valueOf == null) {
                            k.a();
                        }
                        if (valueOf.intValue() == 0) {
                            SharedViewModel sharedViewModel4 = vVar.f28999b;
                            if (sharedViewModel4 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput = sharedViewModel4.getSearchInput();
                            if (searchInput != null) {
                                SharedViewModel sharedViewModel5 = vVar.f28999b;
                                if (sharedViewModel5 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput2 = sharedViewModel5.getSearchTemporaryInput();
                                searchInput.setRooms(searchTemporaryInput2 != null ? searchTemporaryInput2.getRooms() : null);
                            }
                            SharedViewModel sharedViewModel6 = vVar.f28999b;
                            if (sharedViewModel6 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput2 = sharedViewModel6.getSearchInput();
                            if (searchInput2 != null) {
                                SharedViewModel sharedViewModel7 = vVar.f28999b;
                                if (sharedViewModel7 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput3 = sharedViewModel7.getSearchTemporaryInput();
                                searchInput2.setCheckInDate(searchTemporaryInput3 != null ? searchTemporaryInput3.getCheckInDate() : null);
                            }
                            SharedViewModel sharedViewModel8 = vVar.f28999b;
                            if (sharedViewModel8 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput3 = sharedViewModel8.getSearchInput();
                            if (searchInput3 != null) {
                                SharedViewModel sharedViewModel9 = vVar.f28999b;
                                if (sharedViewModel9 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput4 = sharedViewModel9.getSearchTemporaryInput();
                                searchInput3.setCheckOutDate(searchTemporaryInput4 != null ? searchTemporaryInput4.getCheckOutDate() : null);
                            }
                            SharedViewModel sharedViewModel10 = vVar.f28999b;
                            if (sharedViewModel10 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput4 = sharedViewModel10.getSearchInput();
                            if (searchInput4 != null) {
                                SharedViewModel sharedViewModel11 = vVar.f28999b;
                                if (sharedViewModel11 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput5 = sharedViewModel11.getSearchTemporaryInput();
                                searchInput4.setCity(searchTemporaryInput5 != null ? searchTemporaryInput5.getCity() : null);
                            }
                            SharedViewModel sharedViewModel12 = vVar.f28999b;
                            if (sharedViewModel12 == null) {
                                k.a("sharedViewModel");
                            }
                            sharedViewModel12.setSearchTemporaryInput((CJRHotelSearchInput) null);
                        } else {
                            SharedViewModel sharedViewModel13 = vVar.f28999b;
                            if (sharedViewModel13 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput5 = sharedViewModel13.getSearchInput();
                            if (searchInput5 != null) {
                                SharedViewModel sharedViewModel14 = vVar.f28999b;
                                if (sharedViewModel14 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput6 = sharedViewModel14.getSearchTemporaryInput();
                                Integer valueOf2 = searchTemporaryInput6 != null ? Integer.valueOf(searchTemporaryInput6.getAdultCount()) : null;
                                if (valueOf2 == null) {
                                    k.a();
                                }
                                searchInput5.setAdultCount(valueOf2.intValue());
                            }
                            SharedViewModel sharedViewModel15 = vVar.f28999b;
                            if (sharedViewModel15 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput6 = sharedViewModel15.getSearchInput();
                            if (searchInput6 != null) {
                                SharedViewModel sharedViewModel16 = vVar.f28999b;
                                if (sharedViewModel16 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput7 = sharedViewModel16.getSearchTemporaryInput();
                                Integer valueOf3 = searchTemporaryInput7 != null ? Integer.valueOf(searchTemporaryInput7.getChildCount()) : null;
                                if (valueOf3 == null) {
                                    k.a();
                                }
                                searchInput6.setChildCount(valueOf3.intValue());
                            }
                            SharedViewModel sharedViewModel17 = vVar.f28999b;
                            if (sharedViewModel17 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput7 = sharedViewModel17.getSearchInput();
                            if (searchInput7 != null) {
                                SharedViewModel sharedViewModel18 = vVar.f28999b;
                                if (sharedViewModel18 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput8 = sharedViewModel18.getSearchTemporaryInput();
                                searchInput7.setRooms(searchTemporaryInput8 != null ? searchTemporaryInput8.getRooms() : null);
                            }
                            SharedViewModel sharedViewModel19 = vVar.f28999b;
                            if (sharedViewModel19 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput8 = sharedViewModel19.getSearchInput();
                            if (searchInput8 != null) {
                                SharedViewModel sharedViewModel20 = vVar.f28999b;
                                if (sharedViewModel20 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput9 = sharedViewModel20.getSearchTemporaryInput();
                                searchInput8.setCheckInDate(searchTemporaryInput9 != null ? searchTemporaryInput9.getCheckInDate() : null);
                            }
                            SharedViewModel sharedViewModel21 = vVar.f28999b;
                            if (sharedViewModel21 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput9 = sharedViewModel21.getSearchInput();
                            if (searchInput9 != null) {
                                SharedViewModel sharedViewModel22 = vVar.f28999b;
                                if (sharedViewModel22 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput10 = sharedViewModel22.getSearchTemporaryInput();
                                searchInput9.setCheckOutDate(searchTemporaryInput10 != null ? searchTemporaryInput10.getCheckOutDate() : null);
                            }
                            SharedViewModel sharedViewModel23 = vVar.f28999b;
                            if (sharedViewModel23 == null) {
                                k.a("sharedViewModel");
                            }
                            CJRHotelSearchInput searchInput10 = sharedViewModel23.getSearchInput();
                            if (searchInput10 != null) {
                                SharedViewModel sharedViewModel24 = vVar.f28999b;
                                if (sharedViewModel24 == null) {
                                    k.a("sharedViewModel");
                                }
                                CJRHotelSearchInput searchTemporaryInput11 = sharedViewModel24.getSearchTemporaryInput();
                                Integer valueOf4 = searchTemporaryInput11 != null ? Integer.valueOf(searchTemporaryInput11.getNumOfNights()) : null;
                                if (valueOf4 == null) {
                                    k.a();
                                }
                                searchInput10.setNumOfNights(valueOf4.intValue());
                            }
                            SharedViewModel sharedViewModel25 = vVar.f28999b;
                            if (sharedViewModel25 == null) {
                                k.a("sharedViewModel");
                            }
                            sharedViewModel25.setSearchTemporaryInput((CJRHotelSearchInput) null);
                        }
                    }
                }
                DetailsViewModel detailsViewModel = vVar.f28998a;
                if (detailsViewModel == null) {
                    k.a("detailsViewModel");
                }
                detailsViewModel.setDetailsDta(hotelDetails);
                RoomSelectionViewModel roomSelectionViewModel2 = vVar.f29001e;
                if (roomSelectionViewModel2 == null) {
                    k.a("roomSelectionViewModel");
                }
                y<String> yVar = roomSelectionViewModel2.get_title();
                Data data2 = hotelDetails.getData();
                yVar.postValue(data2 != null ? data2.getName() : null);
                RoomSelectionViewModel roomSelectionViewModel3 = vVar.f29001e;
                if (roomSelectionViewModel3 == null) {
                    k.a("roomSelectionViewModel");
                }
                roomSelectionViewModel3.makeSubHeader();
                RoomSelectionViewModel roomSelectionViewModel4 = vVar.f29001e;
                if (roomSelectionViewModel4 == null) {
                    k.a("roomSelectionViewModel");
                }
                y<String> yVar2 = roomSelectionViewModel4.get_roomTypeCount();
                StringBuilder sb = new StringBuilder();
                Data data3 = hotelDetails.getData();
                sb.append((data3 == null || (roomOptions = data3.getRoomOptions()) == null) ? null : Integer.valueOf(roomOptions.size()));
                sb.append(" Room types Available");
                yVar2.postValue(sb.toString());
                p pVar = vVar.f29005i;
                if (pVar != null) {
                    pVar.f28714a.clear();
                    pVar.notifyDataSetChanged();
                }
                Data data4 = hotelDetails.getData();
                if (data4 != null) {
                    list = data4.getRoomOptions();
                }
                vVar.a(list);
                return;
            }
        }
        RoomSelectionViewModel roomSelectionViewModel5 = vVar.f29001e;
        if (roomSelectionViewModel5 == null) {
            k.a("roomSelectionViewModel");
        }
        roomSelectionViewModel5.loadNoRoomView();
    }

    public static final /* synthetic */ void c(v vVar, boolean z) {
        if (z) {
            vVar.a();
            DetailsViewModel detailsViewModel = vVar.f28998a;
            if (detailsViewModel == null) {
                k.a("detailsViewModel");
            }
            detailsViewModel.isApiCalling().postValue(Boolean.FALSE);
        }
    }
}
