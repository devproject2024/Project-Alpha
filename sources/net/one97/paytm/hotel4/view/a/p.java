package net.one97.paytm.hotel4.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.widget.b;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.RoomTypeSelection;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionListViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ee;
import net.one97.paytm.hotels2.b.eg;

public final class p extends RecyclerView.a<RecyclerView.v> implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final List<RoomTypeSelection> f28714a;

    /* renamed from: b  reason: collision with root package name */
    final DetailsViewModel f28715b;

    /* renamed from: c  reason: collision with root package name */
    final RoomSelectionViewModel f28716c;

    /* renamed from: d  reason: collision with root package name */
    final PagerGalleryViewModel f28717d;

    /* renamed from: e  reason: collision with root package name */
    final FragmentActivity f28718e;

    /* renamed from: f  reason: collision with root package name */
    private final RoomSelectionListViewModel f28719f;

    public p(List<RoomTypeSelection> list, DetailsViewModel detailsViewModel, RoomSelectionViewModel roomSelectionViewModel, RoomSelectionListViewModel roomSelectionListViewModel, PagerGalleryViewModel pagerGalleryViewModel, FragmentActivity fragmentActivity) {
        k.c(list, "RoomOptions");
        k.c(detailsViewModel, "detailsViewModel");
        k.c(roomSelectionViewModel, "roomSelectViewModel");
        k.c(roomSelectionListViewModel, "roomSelectionListViewModel");
        k.c(pagerGalleryViewModel, "pagerGalleryViewModel");
        this.f28715b = detailsViewModel;
        this.f28716c = roomSelectionViewModel;
        this.f28719f = roomSelectionListViewModel;
        this.f28717d = pagerGalleryViewModel;
        this.f28718e = fragmentActivity;
        this.f28714a = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 != 1) {
            ee a2 = ee.a(from, viewGroup);
            k.a((Object) a2, "H4RsSelectRoomStickyBind…  false\n                )");
            return new b(this, a2);
        }
        eg a3 = eg.a(from, viewGroup);
        k.a((Object) a3, "H4RsStickyHeaderBinding.…  false\n                )");
        return new a(this, a3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:144:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x04a0  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0594  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x05c1  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0641  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0231  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r12, int r13) {
        /*
            r11 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r12, r0)
            boolean r0 = r12 instanceof net.one97.paytm.hotel4.view.a.p.b
            if (r0 == 0) goto L_0x065c
            net.one97.paytm.hotel4.view.a.p$b r12 = (net.one97.paytm.hotel4.view.a.p.b) r12
            net.one97.paytm.hotel4.view.a.p r0 = r12.f28725b
            java.util.List<net.one97.paytm.hotel4.service.model.details.RoomTypeSelection> r0 = r0.f28714a
            java.lang.Object r0 = r0.get(r13)
            net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r0 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r0
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r0 = r0.getSubRoomOptionse()
            net.one97.paytm.hotel4.view.a.p r1 = r12.f28725b
            java.util.List<net.one97.paytm.hotel4.service.model.details.RoomTypeSelection> r1 = r1.f28714a
            java.lang.Object r1 = r1.get(r13)
            net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r1 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r1
            net.one97.paytm.hotel4.service.model.details.RoomOption r1 = r1.getRoomOptions()
            net.one97.paytm.hotel4.view.a.p r2 = r12.f28725b
            java.util.List<net.one97.paytm.hotel4.service.model.details.RoomTypeSelection> r2 = r2.f28714a
            java.lang.Object r2 = r2.get(r13)
            net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r2 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r2
            boolean r2 = r2.isGalleryVisible()
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            android.widget.TextView r3 = r3.q
            java.lang.String r4 = "binding.tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            if (r0 != 0) goto L_0x0043
            kotlin.g.b.k.a()
        L_0x0043:
            java.lang.String r4 = r0.getPaytmRoomName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            net.one97.paytm.hotel4.utils.a$a r3 = net.one97.paytm.hotel4.utils.a.f28631a
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            android.widget.TextView r3 = r3.m
            java.util.List r4 = r0.getSubRoomProviders()
            if (r4 != 0) goto L_0x005b
            kotlin.g.b.k.a()
        L_0x005b:
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r4 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r4
            net.one97.paytm.hotel4.service.model.details.PriceData r4 = r4.getPriceData()
            if (r4 != 0) goto L_0x006b
            kotlin.g.b.k.a()
        L_0x006b:
            double r6 = r4.getFinalPrice()
            net.one97.paytm.hotel4.utils.a.C0498a.a((android.widget.TextView) r3, (double) r6)
            java.util.List r3 = r0.getSubRoomProviders()
            if (r3 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            java.lang.Object r3 = r3.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r3 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r3
            net.one97.paytm.hotel4.service.model.details.PriceData r3 = r3.getPriceData()
            if (r3 != 0) goto L_0x008a
            kotlin.g.b.k.a()
        L_0x008a:
            double r3 = r3.getOriginalPrice()
            java.util.List r6 = r0.getSubRoomProviders()
            if (r6 != 0) goto L_0x0097
            kotlin.g.b.k.a()
        L_0x0097:
            java.lang.Object r6 = r6.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r6 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r6
            net.one97.paytm.hotel4.service.model.details.PriceData r6 = r6.getPriceData()
            if (r6 != 0) goto L_0x00a6
            kotlin.g.b.k.a()
        L_0x00a6:
            double r6 = r6.getFinalPrice()
            java.lang.String r8 = "binding.tvDiscountPrice"
            r9 = 4
            int r10 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x00e1
            net.one97.paytm.hotel4.utils.a$a r3 = net.one97.paytm.hotel4.utils.a.f28631a
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            android.widget.TextView r3 = r3.f29587g
            java.util.List r4 = r0.getSubRoomProviders()
            if (r4 != 0) goto L_0x00c0
            kotlin.g.b.k.a()
        L_0x00c0:
            java.lang.Object r4 = r4.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r4 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r4
            net.one97.paytm.hotel4.service.model.details.PriceData r4 = r4.getPriceData()
            if (r4 != 0) goto L_0x00cf
            kotlin.g.b.k.a()
        L_0x00cf:
            double r6 = r4.getOriginalPrice()
            net.one97.paytm.hotel4.utils.a.C0498a.a((android.widget.TextView) r3, (double) r6)
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            android.widget.TextView r3 = r3.f29587g
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            r3.setVisibility(r5)
            goto L_0x00eb
        L_0x00e1:
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            android.widget.TextView r3 = r3.f29587g
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            r3.setVisibility(r9)
        L_0x00eb:
            net.one97.paytm.hotel4.view.a.p r3 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r3 = r3.f28715b
            androidx.lifecycle.y r3 = r3.getSelectedData()
            java.lang.Object r3 = r3.getValue()
            if (r3 != 0) goto L_0x00fc
            kotlin.g.b.k.a()
        L_0x00fc:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r3 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r3
            java.util.List r3 = r3.getPromos()
            java.lang.String r4 = "binding.tvCashback"
            r6 = 8
            if (r3 == 0) goto L_0x0157
            net.one97.paytm.hotel4.view.a.p r3 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r3 = r3.f28715b
            androidx.lifecycle.y r3 = r3.getSelectedData()
            java.lang.Object r3 = r3.getValue()
            if (r3 != 0) goto L_0x0119
            kotlin.g.b.k.a()
        L_0x0119:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r3 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r3
            java.util.List r3 = r3.getPromos()
            if (r3 != 0) goto L_0x0124
            kotlin.g.b.k.a()
        L_0x0124:
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0157
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            android.widget.TextView r3 = r3.f29586f
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.hotel4.view.a.p r7 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r7 = r7.f28715b
            androidx.lifecycle.y r7 = r7.getSelectedData()
            java.lang.Object r7 = r7.getValue()
            if (r7 != 0) goto L_0x0142
            kotlin.g.b.k.a()
        L_0x0142:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r7 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r7
            java.util.List r7 = r7.getPromos()
            if (r7 != 0) goto L_0x014d
            kotlin.g.b.k.a()
        L_0x014d:
            java.lang.Object r7 = r7.get(r5)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.setText(r7)
            goto L_0x0161
        L_0x0157:
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            android.widget.TextView r3 = r3.f29586f
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r3.setVisibility(r6)
        L_0x0161:
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            net.one97.paytm.hotel4.view.a.p r7 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r7 = r7.f28716c
            r3.a((net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel) r7)
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            r3.a((net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r0)
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            net.one97.paytm.hotel4.view.a.p r7 = r12.f28725b
            java.util.List<net.one97.paytm.hotel4.service.model.details.RoomTypeSelection> r7 = r7.f28714a
            java.lang.Object r7 = r7.get(r13)
            net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r7 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r7
            net.one97.paytm.hotel4.service.model.details.RoomOption r7 = r7.getRoomOptions()
            r3.a((net.one97.paytm.hotel4.service.model.details.RoomOption) r7)
            net.one97.paytm.hotels2.b.ee r3 = r12.f28724a
            androidx.recyclerview.widget.RecyclerView r3 = r3.f29584d
            java.lang.String r7 = "binding.rvImages"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            net.one97.paytm.hotels2.b.ee r7 = r12.f28724a
            android.widget.ImageView r7 = r7.f29582b
            java.lang.String r8 = "binding.ivNoRoom"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            r8 = 1
            if (r3 == 0) goto L_0x0221
            if (r2 == 0) goto L_0x0221
            r3.setVisibility(r5)
            net.one97.paytm.hotel4.view.a.q r2 = new net.one97.paytm.hotel4.view.a.q
            net.one97.paytm.hotel4.view.a.p r10 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel r10 = r10.f28717d
            r2.<init>(r10, r13)
            r10 = r2
            androidx.recyclerview.widget.RecyclerView$a r10 = (androidx.recyclerview.widget.RecyclerView.a) r10
            r3.setAdapter(r10)
            if (r1 != 0) goto L_0x01b0
            kotlin.g.b.k.a()
        L_0x01b0:
            net.one97.paytm.hotel4.service.model.details.Images r10 = r1.getImages()
            if (r10 != 0) goto L_0x01b9
            kotlin.g.b.k.a()
        L_0x01b9:
            java.util.List r10 = r10.getFull()
            r2.a(r10)
            r2.notifyDataSetChanged()
            net.one97.paytm.hotel4.service.model.details.Images r1 = r1.getImages()
            if (r1 != 0) goto L_0x01cc
            kotlin.g.b.k.a()
        L_0x01cc:
            java.util.List r1 = r1.getFull()
            if (r1 != 0) goto L_0x01d5
            kotlin.g.b.k.a()
        L_0x01d5:
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x01e2
            r3.setVisibility(r5)
            r7.setVisibility(r6)
            goto L_0x01e8
        L_0x01e2:
            r3.setVisibility(r9)
            r7.setVisibility(r5)
        L_0x01e8:
            net.one97.paytm.hotel4.view.a.p r1 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel r1 = r1.f28717d
            java.lang.String r1 = r1.getCurrentScreenName()
            java.lang.String r2 = "7"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0224
            net.one97.paytm.hotel4.view.a.p r1 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel r1 = r1.f28717d
            int r1 = r1.getRoomTypeRecyclerViewIndex()
            if (r1 != r13) goto L_0x0224
            net.one97.paytm.hotel4.view.a.p r13 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel r13 = r13.f28717d
            androidx.lifecycle.y r13 = r13.getPagerGalleryImageIndex()
            java.lang.Object r13 = r13.getValue()
            java.lang.Integer r13 = (java.lang.Integer) r13
            if (r13 == 0) goto L_0x0224
            net.one97.paytm.hotels2.b.ee r1 = r12.f28724a
            androidx.recyclerview.widget.RecyclerView r1 = r1.f29584d
            int r13 = r13.intValue()
            int r13 = r13 - r8
            r1.smoothScrollToPosition(r13)
            kotlin.x r13 = kotlin.x.f47997a
            goto L_0x0224
        L_0x0221:
            r3.setVisibility(r6)
        L_0x0224:
            java.util.List r13 = r0.getSubRoomProviders()
            if (r13 != 0) goto L_0x022d
            kotlin.g.b.k.a()
        L_0x022d:
            r1 = 2
            r2 = 0
            if (r13 == 0) goto L_0x0354
            java.util.List r13 = r0.getSubRoomProviders()
            if (r13 != 0) goto L_0x023a
            kotlin.g.b.k.a()
        L_0x023a:
            java.util.Collection r13 = (java.util.Collection) r13
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r8
            if (r13 == 0) goto L_0x0354
            java.util.List r13 = r0.getSubRoomProviders()
            if (r13 != 0) goto L_0x024c
            kotlin.g.b.k.a()
        L_0x024c:
            java.lang.Object r13 = r13.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r13 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r13
            java.util.List r13 = r13.getIncludes()
            if (r13 != 0) goto L_0x025b
            kotlin.g.b.k.a()
        L_0x025b:
            int r13 = r13.size()
            java.lang.String r3 = "binding.tvRoomOptnOne"
            if (r13 <= 0) goto L_0x0297
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.n
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r5)
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.n
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            java.util.List r3 = r0.getSubRoomProviders()
            if (r3 != 0) goto L_0x027d
            kotlin.g.b.k.a()
        L_0x027d:
            java.lang.Object r3 = r3.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r3 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r3
            java.util.List r3 = r3.getIncludes()
            if (r3 == 0) goto L_0x0290
            java.lang.Object r3 = r3.get(r5)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0291
        L_0x0290:
            r3 = r2
        L_0x0291:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r13.setText(r3)
            goto L_0x02a1
        L_0x0297:
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.n
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r6)
        L_0x02a1:
            java.util.List r13 = r0.getSubRoomProviders()
            if (r13 != 0) goto L_0x02aa
            kotlin.g.b.k.a()
        L_0x02aa:
            java.lang.Object r13 = r13.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r13 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r13
            java.util.List r13 = r13.getIncludes()
            if (r13 != 0) goto L_0x02b9
            kotlin.g.b.k.a()
        L_0x02b9:
            int r13 = r13.size()
            java.lang.String r3 = "binding.tvRoomOptnTwo"
            if (r13 <= r8) goto L_0x02f5
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.o
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            java.util.List r7 = r0.getSubRoomProviders()
            if (r7 != 0) goto L_0x02d1
            kotlin.g.b.k.a()
        L_0x02d1:
            java.lang.Object r7 = r7.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r7 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r7
            java.util.List r7 = r7.getIncludes()
            if (r7 == 0) goto L_0x02e4
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x02e5
        L_0x02e4:
            r7 = r2
        L_0x02e5:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r13.setText(r7)
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.o
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r5)
            goto L_0x02ff
        L_0x02f5:
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.o
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r6)
        L_0x02ff:
            java.util.List r13 = r0.getSubRoomProviders()
            if (r13 != 0) goto L_0x0308
            kotlin.g.b.k.a()
        L_0x0308:
            java.lang.Object r13 = r13.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r13 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r13
            java.util.List r13 = r13.getIncludes()
            if (r13 != 0) goto L_0x0317
            kotlin.g.b.k.a()
        L_0x0317:
            int r13 = r13.size()
            if (r13 <= r1) goto L_0x0348
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.f29589i
            java.lang.String r3 = "binding.tvOptionsOne"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            java.util.List r3 = r0.getSubRoomProviders()
            if (r3 != 0) goto L_0x032f
            kotlin.g.b.k.a()
        L_0x032f:
            java.lang.Object r3 = r3.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r3 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r3
            java.util.List r3 = r3.getIncludes()
            if (r3 == 0) goto L_0x0342
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0343
        L_0x0342:
            r3 = r2
        L_0x0343:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r13.setText(r3)
        L_0x0348:
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.f29589i
            java.lang.String r3 = "binding.tvOptionsOne"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r6)
        L_0x0354:
            java.util.List r13 = r0.getSubRoomProviders()
            if (r13 != 0) goto L_0x035d
            kotlin.g.b.k.a()
        L_0x035d:
            java.lang.Object r13 = r13.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r13 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r13
            java.util.List r13 = r13.getIncludes()
            if (r13 != 0) goto L_0x036c
            kotlin.g.b.k.a()
        L_0x036c:
            int r13 = r13.size()
            java.lang.String r3 = "binding.tvPlusRoomInclusion"
            if (r13 <= r1) goto L_0x03bb
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.l
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "+ "
            r7.<init>(r8)
            java.util.List r8 = r0.getSubRoomProviders()
            if (r8 != 0) goto L_0x038b
            kotlin.g.b.k.a()
        L_0x038b:
            java.lang.Object r8 = r8.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r8 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r8
            java.util.List r8 = r8.getIncludes()
            if (r8 != 0) goto L_0x039a
            kotlin.g.b.k.a()
        L_0x039a:
            int r8 = r8.size()
            int r8 = r8 - r1
            r7.append(r8)
            java.lang.String r1 = " more inclusions"
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.setText(r1)
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.l
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r5)
            goto L_0x03c5
        L_0x03bb:
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.l
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r6)
        L_0x03c5:
            net.one97.paytm.hotel4.view.a.p r13 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r13 = r13.f28715b
            androidx.lifecycle.y r13 = r13.getSelectedData()
            java.lang.Object r13 = r13.getValue()
            if (r13 != 0) goto L_0x03d6
            kotlin.g.b.k.a()
        L_0x03d6:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r13 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r13
            java.util.List r13 = r13.getPromos()
            if (r13 == 0) goto L_0x042d
            net.one97.paytm.hotel4.view.a.p r13 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r13 = r13.f28715b
            androidx.lifecycle.y r13 = r13.getSelectedData()
            java.lang.Object r13 = r13.getValue()
            if (r13 != 0) goto L_0x03ef
            kotlin.g.b.k.a()
        L_0x03ef:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r13 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r13
            java.util.List r13 = r13.getPromos()
            if (r13 != 0) goto L_0x03fa
            kotlin.g.b.k.a()
        L_0x03fa:
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x042d
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.f29586f
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            net.one97.paytm.hotel4.view.a.p r1 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r1 = r1.f28715b
            androidx.lifecycle.y r1 = r1.getSelectedData()
            java.lang.Object r1 = r1.getValue()
            if (r1 != 0) goto L_0x0418
            kotlin.g.b.k.a()
        L_0x0418:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r1 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r1
            java.util.List r1 = r1.getPromos()
            if (r1 == 0) goto L_0x0427
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0428
        L_0x0427:
            r1 = r2
        L_0x0428:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.setText(r1)
        L_0x042d:
            org.json.JSONObject r13 = new org.json.JSONObject
            java.util.List r1 = r0.getSubRoomProviders()
            if (r1 != 0) goto L_0x0438
            kotlin.g.b.k.a()
        L_0x0438:
            java.lang.Object r1 = r1.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r1 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r1
            com.google.gsonhtcfix.o r1 = r1.getBookParams()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r13.<init>(r1)
            net.one97.paytm.hotels2.b.ee r1 = r12.f28724a
            android.widget.TextView r1 = r1.f29585e
            java.lang.String r3 = "binding.tvAddon"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r3 = "mealPlan"
            java.lang.String r3 = r13.optString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            java.lang.String r1 = "freeCancellable"
            boolean r1 = r13.optBoolean(r1)
            java.lang.String r3 = ""
            java.lang.String r4 = "binding.tvOptionsNoRefund"
            java.lang.String r7 = "binding.tvOptionsRefund"
            if (r1 == 0) goto L_0x04a0
            net.one97.paytm.hotels2.b.ee r1 = r12.f28724a
            android.widget.TextView r1 = r1.j
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            r1.setVisibility(r5)
            net.one97.paytm.hotels2.b.ee r1 = r12.f28724a
            android.widget.TextView r1 = r1.f29588h
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r9)
            net.one97.paytm.hotels2.b.ee r1 = r12.f28724a
            android.widget.TextView r1 = r1.j
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "Free Cancellation till "
            r4.<init>(r7)
            java.lang.String r7 = "freeCancellableTill"
            java.lang.String r13 = r13.optString(r7, r3)
            r4.append(r13)
            java.lang.String r13 = r4.toString()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r1.setText(r13)
            goto L_0x04c2
        L_0x04a0:
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.j
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r7)
            r13.setVisibility(r9)
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.f29588h
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            r13.setVisibility(r5)
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            android.widget.TextView r13 = r13.f29588h
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            java.lang.String r1 = "Non-Refundable"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.setText(r1)
        L_0x04c2:
            org.json.JSONObject r13 = new org.json.JSONObject
            java.util.List r1 = r0.getSubRoomProviders()
            if (r1 != 0) goto L_0x04cd
            kotlin.g.b.k.a()
        L_0x04cd:
            java.lang.Object r1 = r1.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r1 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r1
            com.google.gsonhtcfix.o r1 = r1.getBookParams()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r13.<init>(r1)
            java.lang.String r1 = "rotc"
            java.lang.Object r13 = r13.get(r1)
            org.json.JSONObject r4 = new org.json.JSONObject
            java.util.List r0 = r0.getSubRoomProviders()
            if (r0 != 0) goto L_0x04ef
            kotlin.g.b.k.a()
        L_0x04ef:
            java.lang.Object r0 = r0.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r0 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r0
            com.google.gsonhtcfix.o r0 = r0.getBookParams()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.<init>(r0)
            java.lang.String r0 = "rpc"
            java.lang.Object r0 = r4.get(r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r13 = r13.toString()
            r4.append(r13)
            java.lang.String r13 = r0.toString()
            r4.append(r13)
            java.lang.String r13 = r4.toString()
            net.one97.paytm.hotel4.view.a.p r0 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r0 = r0.f28716c
            androidx.lifecycle.y r0 = r0.get_selectedRoomData()
            java.lang.Object r0 = r0.getValue()
            if (r0 == 0) goto L_0x0594
            org.json.JSONObject r0 = new org.json.JSONObject
            net.one97.paytm.hotel4.view.a.p r4 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r4.f28716c
            androidx.lifecycle.y r4 = r4.get_selectedRoomData()
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x053e
            kotlin.g.b.k.a()
        L_0x053e:
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r4 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r4
            java.util.List r4 = r4.getSubRoomProviders()
            if (r4 != 0) goto L_0x0549
            kotlin.g.b.k.a()
        L_0x0549:
            java.lang.Object r4 = r4.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r4 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r4
            com.google.gsonhtcfix.o r4 = r4.getBookParams()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.<init>(r4)
            java.lang.Object r0 = r0.get(r1)
            org.json.JSONObject r1 = new org.json.JSONObject
            net.one97.paytm.hotel4.view.a.p r4 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r4.f28716c
            androidx.lifecycle.y r4 = r4.get_selectedRoomData()
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x0571
            kotlin.g.b.k.a()
        L_0x0571:
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r4 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r4
            java.util.List r4 = r4.getSubRoomProviders()
            if (r4 != 0) goto L_0x057c
            kotlin.g.b.k.a()
        L_0x057c:
            java.lang.Object r4 = r4.get(r5)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r4 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r4
            com.google.gsonhtcfix.o r4 = r4.getBookParams()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.<init>(r4)
            java.lang.String r4 = "rpc"
            java.lang.Object r1 = r1.get(r4)
            goto L_0x0596
        L_0x0594:
            r0 = r2
            r1 = r0
        L_0x0596:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.append(r0)
            java.lang.String r0 = java.lang.String.valueOf(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            net.one97.paytm.hotel4.view.a.p r1 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r1 = r1.f28716c
            androidx.lifecycle.y r1 = r1.get_selectedRoomData()
            java.lang.Object r1 = r1.getValue()
            if (r1 == 0) goto L_0x0641
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r0)
            if (r13 == 0) goto L_0x0641
            net.one97.paytm.hotel4.utils.e r13 = net.one97.paytm.hotel4.utils.e.f28642a
            net.one97.paytm.hotel4.view.a.p r13 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r13 = r13.f28716c
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r13 = r13.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r13 = r13.getSearchInput()
            if (r13 == 0) goto L_0x05e0
            java.util.ArrayList r13 = r13.getRooms()
            if (r13 == 0) goto L_0x05e0
            int r13 = r13.size()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            goto L_0x05e1
        L_0x05e0:
            r13 = r2
        L_0x05e1:
            java.lang.String r0 = " Room"
            java.lang.String r13 = net.one97.paytm.hotel4.utils.e.a(r0, r3, r13)
            net.one97.paytm.hotels2.b.ee r0 = r12.f28724a
            net.one97.paytm.hotels2.b.ea r0 = r0.r
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.f29563a
            java.lang.String r1 = "binding.vSelectedRoom.clRoot"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r5)
            net.one97.paytm.hotels2.b.ee r0 = r12.f28724a
            net.one97.paytm.hotels2.b.ea r0 = r0.r
            android.widget.TextView r0 = r0.f29566d
            java.lang.String r1 = "binding.vSelectedRoom.tvSelectedRoom"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.hotel4.view.a.p r3 = r12.f28725b
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r3 = r3.f28716c
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r3.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r3.getSearchInput()
            if (r3 == 0) goto L_0x0621
            java.util.ArrayList r3 = r3.getRooms()
            if (r3 == 0) goto L_0x0621
            int r2 = r3.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0621:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r0.setText(r13)
            net.one97.paytm.hotels2.b.ee r12 = r12.f28724a
            android.widget.TextView r12 = r12.p
            java.lang.String r13 = "binding.tvSelectRoom"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r12.setVisibility(r6)
            return
        L_0x0641:
            net.one97.paytm.hotels2.b.ee r13 = r12.f28724a
            net.one97.paytm.hotels2.b.ea r13 = r13.r
            androidx.constraintlayout.widget.ConstraintLayout r13 = r13.f29563a
            java.lang.String r0 = "binding.vSelectedRoom.clRoot"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            r13.setVisibility(r6)
            net.one97.paytm.hotels2.b.ee r12 = r12.f28724a
            android.widget.TextView r12 = r12.p
            java.lang.String r13 = "binding.tvSelectRoom"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r12.setVisibility(r5)
            return
        L_0x065c:
            boolean r0 = r12 instanceof net.one97.paytm.hotel4.view.a.p.a
            if (r0 == 0) goto L_0x0665
            net.one97.paytm.hotel4.view.a.p$a r12 = (net.one97.paytm.hotel4.view.a.p.a) r12
            r12.a(r13)
        L_0x0665:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.a.p.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemViewType(int i2) {
        return this.f28714a.get(i2).getViewType();
    }

    public final int getItemCount() {
        return this.f28714a.size();
    }

    public final int a(int i2) {
        while (!b(i2)) {
            i2--;
            if (i2 < 0) {
                return 0;
            }
        }
        return i2;
    }

    public final int a() {
        return R.layout.h4_rs_sticky_header;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x006c, code lost:
        r0 = r0.getBasic();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "itemView"
            kotlin.g.b.k.c(r6, r0)
            int r0 = net.one97.paytm.hotels2.R.id.tv_title
            android.view.View r0 = r6.findViewById(r0)
            java.lang.String r1 = "itemView.findViewById(R.id.tv_title)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.hotels2.R.id.tv_sub_title
            android.view.View r1 = r6.findViewById(r1)
            java.lang.String r2 = "itemView.findViewById(R.id.tv_sub_title)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.hotels2.R.id.tv_amenities_view_all
            android.view.View r2 = r6.findViewById(r2)
            java.lang.String r3 = "itemView.findViewById(R.id.tv_amenities_view_all)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = net.one97.paytm.hotels2.R.id.rv_amnts
            android.view.View r6 = r6.findViewById(r3)
            java.lang.String r3 = "itemView.findViewById(R.id.rv_amnts)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            java.util.List<net.one97.paytm.hotel4.service.model.details.RoomTypeSelection> r3 = r5.f28714a
            int r3 = r3.size()
            if (r3 != 0) goto L_0x0042
            return
        L_0x0042:
            java.util.List<net.one97.paytm.hotel4.service.model.details.RoomTypeSelection> r3 = r5.f28714a
            java.lang.Object r7 = r3.get(r7)
            net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r7 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r7
            net.one97.paytm.hotel4.service.model.details.RoomOption r7 = r7.getRoomOptions()
            if (r7 != 0) goto L_0x0053
            kotlin.g.b.k.a()
        L_0x0053:
            java.lang.String r3 = r7.getPaytmRoomName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            java.lang.String r0 = r7.getBedType()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            net.one97.paytm.hotel4.service.model.details.Facilities r0 = r7.getFacilities()
            r1 = 0
            if (r0 == 0) goto L_0x0079
            net.one97.paytm.hotel4.service.model.details.Basic r0 = r0.getBasic()
            if (r0 == 0) goto L_0x0079
            net.one97.paytm.hotel4.service.model.details.Basic$Companion r3 = net.one97.paytm.hotel4.service.model.details.Basic.Companion
            java.util.List r0 = r3.getAmenitiesList(r0)
            goto L_0x007a
        L_0x0079:
            r0 = r1
        L_0x007a:
            net.one97.paytm.hotel4.service.model.details.Facilities r7 = r7.getFacilities()
            if (r7 == 0) goto L_0x0084
            java.util.ArrayList r1 = r7.getMore()
        L_0x0084:
            if (r1 != 0) goto L_0x0089
            kotlin.g.b.k.a()
        L_0x0089:
            java.util.Iterator r7 = r1.iterator()
        L_0x008d:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r0 == 0) goto L_0x008d
            java.lang.String r3 = "item"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r0.add(r1)
            goto L_0x008d
        L_0x00a4:
            if (r0 != 0) goto L_0x00a9
            kotlin.g.b.k.a()
        L_0x00a9:
            int r7 = r0.size()
            r1 = 0
            r3 = 3
            if (r7 > r3) goto L_0x00b7
            r7 = 8
            r2.setVisibility(r7)
            goto L_0x00d7
        L_0x00b7:
            r2.setVisibility(r1)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r4 = "+"
            r7.<init>(r4)
            int r4 = r0.size()
            int r4 = r4 - r3
            r7.append(r4)
            java.lang.String r4 = " More"
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
        L_0x00d7:
            net.one97.paytm.hotel4.view.a.p$c r7 = new net.one97.paytm.hotel4.view.a.p$c
            r7.<init>(r5, r0)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r2.setOnClickListener(r7)
            net.one97.paytm.hotel4.view.a.o r7 = new net.one97.paytm.hotel4.view.a.o
            r7.<init>()
            r2 = r7
            androidx.recyclerview.widget.RecyclerView$a r2 = (androidx.recyclerview.widget.RecyclerView.a) r2
            r6.setAdapter(r2)
            int r6 = r0.size()
            if (r6 <= r3) goto L_0x00fa
            java.util.List r6 = r0.subList(r1, r3)
            r7.a(r6)
            return
        L_0x00fa:
            r7.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.a.p.a(android.view.View, int):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f28726a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f28727b;

        c(p pVar, List list) {
            this.f28726a = pVar;
            this.f28727b = list;
        }

        public final void onClick(View view) {
            if (this.f28726a.f28718e != null) {
                e eVar = e.f28642a;
                FragmentActivity fragmentActivity = this.f28726a.f28718e;
                List list = this.f28727b;
                FragmentActivity fragmentActivity2 = this.f28726a.f28718e;
                e.a(fragmentActivity, (List<String>) list, fragmentActivity2 != null ? fragmentActivity2.getString(R.string.h4_amenities) : null, this.f28726a.f28715b.getParent());
            }
        }
    }

    public final boolean b(int i2) {
        return this.f28714a.size() > 0 && this.f28714a.get(i2).getViewType() == 1;
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f28720a;

        /* renamed from: b  reason: collision with root package name */
        private eg f28721b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p pVar, eg egVar) {
            super(egVar.getRoot());
            k.c(egVar, "binding");
            this.f28720a = pVar;
            this.f28721b = egVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0047, code lost:
            r0 = r0.getBasic();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r6) {
            /*
                r5 = this;
                net.one97.paytm.hotel4.view.a.p r0 = r5.f28720a
                java.util.List<net.one97.paytm.hotel4.service.model.details.RoomTypeSelection> r0 = r0.f28714a
                java.lang.Object r6 = r0.get(r6)
                net.one97.paytm.hotel4.service.model.details.RoomTypeSelection r6 = (net.one97.paytm.hotel4.service.model.details.RoomTypeSelection) r6
                net.one97.paytm.hotel4.service.model.details.RoomOption r6 = r6.getRoomOptions()
                if (r6 != 0) goto L_0x0013
                kotlin.g.b.k.a()
            L_0x0013:
                net.one97.paytm.hotels2.b.eg r0 = r5.f28721b
                net.one97.paytm.hotel4.view.a.p r1 = r5.f28720a
                net.one97.paytm.hotel4.viewmodel.DetailsViewModel r1 = r1.f28715b
                r0.a(r1)
                net.one97.paytm.hotels2.b.eg r0 = r5.f28721b
                android.widget.TextView r0 = r0.f29593d
                java.lang.String r1 = "binding.tvTitle"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.String r1 = r6.getPaytmRoomName()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                net.one97.paytm.hotels2.b.eg r0 = r5.f28721b
                android.widget.TextView r0 = r0.f29592c
                java.lang.String r1 = "binding.tvSubTitle"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.String r1 = r6.getBedType()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                net.one97.paytm.hotel4.service.model.details.Facilities r0 = r6.getFacilities()
                r1 = 0
                if (r0 == 0) goto L_0x0054
                net.one97.paytm.hotel4.service.model.details.Basic r0 = r0.getBasic()
                if (r0 == 0) goto L_0x0054
                net.one97.paytm.hotel4.service.model.details.Basic$Companion r2 = net.one97.paytm.hotel4.service.model.details.Basic.Companion
                java.util.List r0 = r2.getAmenitiesList(r0)
                goto L_0x0055
            L_0x0054:
                r0 = r1
            L_0x0055:
                net.one97.paytm.hotel4.service.model.details.Facilities r6 = r6.getFacilities()
                if (r6 == 0) goto L_0x005f
                java.util.ArrayList r1 = r6.getMore()
            L_0x005f:
                if (r1 != 0) goto L_0x0064
                kotlin.g.b.k.a()
            L_0x0064:
                java.util.Iterator r6 = r1.iterator()
            L_0x0068:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x007f
                java.lang.Object r1 = r6.next()
                java.lang.String r1 = (java.lang.String) r1
                if (r0 == 0) goto L_0x0068
                java.lang.String r2 = "item"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                r0.add(r1)
                goto L_0x0068
            L_0x007f:
                net.one97.paytm.hotels2.b.eg r6 = r5.f28721b
                android.widget.TextView r6 = r6.f29591b
                net.one97.paytm.hotel4.view.a.p$a$a r1 = new net.one97.paytm.hotel4.view.a.p$a$a
                r1.<init>(r5, r0)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r6.setOnClickListener(r1)
                if (r0 != 0) goto L_0x0092
                kotlin.g.b.k.a()
            L_0x0092:
                int r6 = r0.size()
                r1 = 0
                java.lang.String r2 = "binding.tvAmenitiesViewAll"
                r3 = 3
                if (r6 > r3) goto L_0x00a9
                net.one97.paytm.hotels2.b.eg r6 = r5.f28721b
                android.widget.TextView r6 = r6.f29591b
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
                r2 = 8
                r6.setVisibility(r2)
                goto L_0x00d7
            L_0x00a9:
                net.one97.paytm.hotels2.b.eg r6 = r5.f28721b
                android.widget.TextView r6 = r6.f29591b
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
                r6.setVisibility(r1)
                net.one97.paytm.hotels2.b.eg r6 = r5.f28721b
                android.widget.TextView r6 = r6.f29591b
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r4 = "+"
                r2.<init>(r4)
                int r4 = r0.size()
                int r4 = r4 - r3
                r2.append(r4)
                java.lang.String r4 = " More"
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r6.setText(r2)
            L_0x00d7:
                net.one97.paytm.hotel4.view.a.o r6 = new net.one97.paytm.hotel4.view.a.o
                r6.<init>()
                net.one97.paytm.hotels2.b.eg r2 = r5.f28721b
                androidx.recyclerview.widget.RecyclerView r2 = r2.f29590a
                java.lang.String r4 = "binding.rvAmnts"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                r4 = r6
                androidx.recyclerview.widget.RecyclerView$a r4 = (androidx.recyclerview.widget.RecyclerView.a) r4
                r2.setAdapter(r4)
                int r2 = r0.size()
                if (r2 <= r3) goto L_0x00f9
                java.util.List r0 = r0.subList(r1, r3)
                r6.a(r0)
                return
            L_0x00f9:
                r6.a(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.a.p.a.a(int):void");
        }

        /* renamed from: net.one97.paytm.hotel4.view.a.p$a$a  reason: collision with other inner class name */
        static final class C0502a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f28722a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ List f28723b;

            C0502a(a aVar, List list) {
                this.f28722a = aVar;
                this.f28723b = list;
            }

            public final void onClick(View view) {
                if (this.f28722a.f28720a.f28718e != null) {
                    e eVar = e.f28642a;
                    FragmentActivity fragmentActivity = this.f28722a.f28720a.f28718e;
                    List list = this.f28723b;
                    FragmentActivity fragmentActivity2 = this.f28722a.f28720a.f28718e;
                    e.a(fragmentActivity, (List<String>) list, fragmentActivity2 != null ? fragmentActivity2.getString(R.string.h4_amenities) : null, this.f28722a.f28720a.f28715b.getParent());
                }
            }
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ee f28724a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f28725b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p pVar, ee eeVar) {
            super(eeVar.getRoot());
            k.c(eeVar, "binding");
            this.f28725b = pVar;
            this.f28724a = eeVar;
        }
    }
}
