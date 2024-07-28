package net.one97.paytm.landingpage.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.f;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.ga.GaBuilder;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.IClientListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.GAPromotionImpression;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.Promotion;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.landingpage.a.a;

public final class a extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    public List<View> f52644a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<android.view.View> f52645b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52646c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, Boolean> f52647d;

    /* renamed from: e  reason: collision with root package name */
    public Map<RecyclerView.v, View> f52648e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Integer> f52649f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Item> f52650g;

    /* renamed from: h  reason: collision with root package name */
    public IGAHandlerListener f52651h = new IGAHandlerListener() {
        public final boolean IsClickEnable() {
            return true;
        }

        public /* synthetic */ void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
            IGAHandlerListener.CC.$default$fireInfiniteGridProductImpression(this, cJRGridProduct, i2);
        }

        public /* synthetic */ int getClient() {
            return IClientListener.CC.$default$getClient(this);
        }

        public /* synthetic */ String getClientRequestID() {
            return IAdListener.CC.$default$getClientRequestID(this);
        }

        public final void OnItemClick(Item item, int i2) {
            a.this.a(item, i2);
        }

        public final void OnItemClick(Item item, int i2, boolean z) {
            a.this.a(item, i2);
        }

        public final void fireImpression(Item item, int i2) {
            if (a.this.f52649f != null) {
                String id = item.getId();
                int intValue = a.this.f52649f.containsKey(id) ? a.this.f52649f.get(id).intValue() : -1;
                StringBuilder sb = new StringBuilder(" item impression fire event, type is : ");
                sb.append(item.getType());
                sb.append(" parent type : ");
                sb.append(item.getParentType());
                sb.append(" position : ");
                sb.append(i2);
                sb.append(" parent position : ");
                sb.append(intValue);
                sb.append(" item id is : ");
                sb.append(item.getId());
                if (intValue != -1) {
                    boolean booleanValue = a.this.f52647d.containsKey(Integer.valueOf(intValue)) ? a.this.f52647d.get(Integer.valueOf(intValue)).booleanValue() : false;
                    if (!a.this.f52646c) {
                        booleanValue = true;
                    }
                    if (!booleanValue || item.isGaAdded()) {
                        a.this.f52650g.put(id, item);
                        return;
                    }
                    item.setGaAdded(true);
                    com.paytm.utility.d.a.a(new kotlin.g.a.a(intValue, item, i2) {
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ Item f$2;
                        private final /* synthetic */ int f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final Object invoke() {
                            return a.AnonymousClass1.this.a(this.f$1, this.f$2, this.f$3);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ x a(int i2, Item item, int i3) {
            new HashMap();
            View view = a.this.f52644a.get(i2);
            if (!(view == null || view.getGaData() == null)) {
                Promotion buildPromotion = GaBuilder.buildPromotion(item, i3, i2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(buildPromotion);
                buildPromotion.setName((String) view.getGaData().get(GAUtil.KEY_GA));
                GAPromotionImpression gAPromotionImpression = new GAPromotionImpression();
                GAPromotionImpression.PromoView promoView = new GAPromotionImpression.PromoView();
                promoView.setImpressionsList(arrayList);
                gAPromotionImpression.setPromotion(promoView);
                HashMap hashMap = new HashMap();
                hashMap.put(GAUtil.event, GAUtil.eventPromotionImpression);
                hashMap.put(GAUtil.screenName, "/");
                hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
                hashMap.put(GAUtil.verticalName, "travel");
                hashMap.put("ecommerce", new f().a(gAPromotionImpression.toJson(), new com.google.gson.b.a<HashMap<String, Object>>() {
                }.getType()));
                CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, CLPArtifact.getInstance().getContext());
                StringBuilder sb = new StringBuilder("item fire event, type is : ");
                sb.append(item.getType());
                sb.append(" parent type : ");
                sb.append(item.getParentType());
                sb.append(" position : ");
                sb.append(i3);
                sb.append(" is visible");
            }
            return null;
        }

        public final void fireImpression(View view, int i2) {
            StringBuilder sb = new StringBuilder(" 2 fire event, type is : ");
            sb.append(view.getType());
            sb.append(" position : ");
            sb.append(i2);
            for (Item next : view.getItems()) {
                String id = next.getId();
                if (!TextUtils.isEmpty(id) && a.this.f52650g.containsKey(id)) {
                    Item item = a.this.f52650g.get(id);
                    if (item != null) {
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= view.getItems().size()) {
                                break;
                            } else if (view.getItems().get(i4).getId().equalsIgnoreCase(id)) {
                                i3 = i4;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        fireImpression(item, i3);
                        StringBuilder sb2 = new StringBuilder("view fire event for item type : ");
                        sb2.append(next.getType());
                        sb2.append(" parent type : ");
                        sb2.append(next.getParentType());
                        sb2.append(" is visible");
                        a.this.f52650g.remove(id);
                    }
                } else if (i2 == 0 && view != null && view.getItems() != null && view.getItems().size() > 0) {
                    Item item2 = view.getItems().get(i2);
                    if (item2.getAddedtoGA() != null && !item2.getAddedtoGA().booleanValue()) {
                        fireImpression(item2, i2);
                    }
                }
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private j f52652i;
    private int j = 0;
    private Activity k;
    private C0941a l;

    /* renamed from: net.one97.paytm.landingpage.a.a$a  reason: collision with other inner class name */
    public interface C0941a {
        void a(CJRHomePageItem cJRHomePageItem, int i2, String str, String str2);
    }

    /* access modifiers changed from: package-private */
    public final void a(Item item, int i2) {
        String str;
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) new com.google.gsonhtcfix.f().a(new f().b(item), CJRHomePageItem.class);
        cJRHomePageItem.setLayoutType(item.getParentType());
        if (this.l != null) {
            String containerinstatnceid = item.getContainerinstatnceid();
            new HashMap();
            int intValue = this.f52649f.containsKey(item.getId()) ? this.f52649f.get(item.getId()).intValue() : -1;
            if (intValue != -1) {
                View view = this.f52644a.get(intValue);
                if (view != null && view.getGaData() != null) {
                    str = view.getTitle();
                } else {
                    return;
                }
            } else {
                str = "";
            }
            this.l.a(cJRHomePageItem, i2, containerinstatnceid, str);
        }
    }

    public final void a() {
        if (this.f52644a != null) {
            for (int i2 = 0; i2 < this.f52644a.size(); i2++) {
                for (Item id : this.f52644a.get(i2).mItems) {
                    String id2 = id.getId();
                    if (!this.f52649f.containsKey(id2)) {
                        this.f52649f.put(id2, Integer.valueOf(i2));
                    }
                }
            }
        }
    }

    public a(Activity activity, List<View> list, j jVar, WeakReference<android.view.View> weakReference, C0941a aVar) {
        this.f52644a = list;
        this.f52652i = jVar;
        this.f52648e = new HashMap();
        this.f52647d = new HashMap();
        this.f52649f = new HashMap();
        this.f52650g = new HashMap();
        this.f52645b = weakReference;
        this.k = activity;
        a();
        this.l = aVar;
    }

    public final int getItemViewType(int i2) {
        return ViewHolderFactory.getViewType(this.f52644a.get(i2).getType());
    }

    public final int getItemCount() {
        List<View> list = this.f52644a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f52651h);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        View view = this.f52644a.get(i2);
        HashMap hashMap = new HashMap();
        hashMap.put(GAUtil.KEY_GA, "/-" + view.getGaKey() + "-" + view.getTitle() + "_" + view.getType());
        view.setGaData(hashMap);
        ((CLPBaseViewHolder) vVar).bind(view, (CLPBaseViewHolder.IParentListProvider) null);
        if (!this.f52647d.containsKey(Integer.valueOf(i2))) {
            this.f52648e.put(vVar, this.f52644a.get(i2));
            this.f52647d.put(Integer.valueOf(i2), Boolean.FALSE);
        }
    }
}
