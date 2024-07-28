package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.ab;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.am;
import net.one97.paytm.recharge.common.e.v;
import net.one97.paytm.recharge.common.fragment.l;
import net.one97.paytm.recharge.common.fragment.m;
import net.one97.paytm.recharge.common.fragment.s;
import net.one97.paytm.recharge.common.widget.CJRCustomTabLayout;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;

public final class u extends o implements ab.a, ai, m.b {
    private s A;

    /* renamed from: a  reason: collision with root package name */
    public final Context f60688a;

    /* renamed from: b  reason: collision with root package name */
    public List<CJRAutomaticSubscriptionItemModel> f60689b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f60690c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f60691d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<CJRFrequentOrder> f60692e;

    /* renamed from: f  reason: collision with root package name */
    public Fragment f60693f;

    /* renamed from: g  reason: collision with root package name */
    public ab f60694g;

    /* renamed from: h  reason: collision with root package name */
    public l f60695h;

    /* renamed from: i  reason: collision with root package name */
    public CJRCustomTabLayout f60696i;
    public String j;
    public View.OnClickListener k;
    public boolean l = false;
    public String m = null;
    private HashMap<Integer, String> n;
    private v o;
    private List<CJROfferCode> p;
    private AdapterView.OnItemClickListener q;
    private int r = -1;
    private CJRItem s;
    private boolean t = false;
    private am u;
    private String v;
    private boolean w = true;
    private boolean x = false;
    private String y = null;
    private String z = null;

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public u(CJRItem cJRItem, v vVar, AdapterView.OnItemClickListener onItemClickListener, j jVar, List<CJRFrequentOrder> list, List<CJROfferCode> list2, Context context, am amVar, String str, List<CJRAutomaticSubscriptionItemModel> list3, CJRCustomTabLayout cJRCustomTabLayout, String str2, String str3) {
        super(jVar);
        this.o = vVar;
        this.q = onItemClickListener;
        this.f60689b = list3;
        this.n = new HashMap<>();
        this.f60692e = list;
        this.p = list2;
        this.s = cJRItem;
        this.t = false;
        this.f60688a = context;
        this.u = amVar;
        this.v = str;
        this.f60696i = cJRCustomTabLayout;
        this.j = str2;
        this.y = this.s.getCategoryId();
        this.z = this.s.getCategoryId();
        this.m = str3;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        Object instantiateItem = super.instantiateItem(viewGroup, i2);
        if (instantiateItem instanceof Fragment) {
            this.n.put(Integer.valueOf(i2), ((Fragment) instantiateItem).getTag());
        }
        return instantiateItem;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: net.one97.paytm.recharge.common.fragment.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: net.one97.paytm.recharge.common.fragment.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: net.one97.paytm.recharge.common.a.ab} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: net.one97.paytm.recharge.common.fragment.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: net.one97.paytm.recharge.common.fragment.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: net.one97.paytm.recharge.common.fragment.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: net.one97.paytm.recharge.common.fragment.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: net.one97.paytm.recharge.common.fragment.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: net.one97.paytm.recharge.common.fragment.m} */
    /* JADX WARNING: type inference failed for: r10v8, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: type inference failed for: r10v16, types: [net.one97.paytm.recharge.common.fragment.s] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.fragment.app.Fragment getItem(int r10) {
        /*
            r9 = this;
            java.util.List<java.lang.String> r0 = r9.f60690c
            if (r0 == 0) goto L_0x00e7
            int r0 = r0.size()
            if (r10 >= r0) goto L_0x00e7
            java.util.List<java.lang.String> r0 = r9.f60690c
            java.lang.Object r0 = r0.get(r10)
            java.lang.String r0 = (java.lang.String) r0
            android.content.Context r1 = r9.f60688a
            int r2 = net.one97.paytm.recharge.R.string.recents_title_str
            java.lang.String r1 = r1.getString(r2)
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x003c
            net.one97.paytm.recharge.common.fragment.m r10 = new net.one97.paytm.recharge.common.fragment.m
            net.one97.paytm.common.entity.CJRItem r3 = r9.s
            boolean r4 = r9.t
            net.one97.paytm.recharge.common.e.v r5 = r9.o
            android.widget.AdapterView$OnItemClickListener r6 = r9.q
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r7 = r9.f60692e
            r2 = r10
            r8 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0 = r10
            net.one97.paytm.recharge.common.fragment.m r0 = (net.one97.paytm.recharge.common.fragment.m) r0
            android.view.View$OnClickListener r1 = r9.k
            r0.f61320a = r1
            r9.f60693f = r10
            goto L_0x00e8
        L_0x003c:
            android.content.Context r1 = r9.f60688a
            int r2 = net.one97.paytm.recharge.R.string.offers_title_str
            java.lang.String r1 = r1.getString(r2)
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x009e
            boolean r10 = r9.l
            if (r10 == 0) goto L_0x008d
            java.lang.String r10 = r9.z
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0064
            java.lang.String r10 = r9.z
            java.lang.String r0 = r9.y
            boolean r10 = r10.equalsIgnoreCase(r0)
            if (r10 == 0) goto L_0x0064
            net.one97.paytm.recharge.common.fragment.s r10 = r9.A
            if (r10 != 0) goto L_0x008a
        L_0x0064:
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
            java.lang.String r0 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r1 = r9.y
            r10.putString(r0, r1)
            java.lang.String r0 = r9.m
            java.lang.String r1 = "vertical_id"
            r10.putString(r1, r0)
            java.lang.String r0 = r9.j
            java.lang.String r1 = "screen_name"
            r10.putString(r1, r0)
            net.one97.paytm.recharge.common.fragment.s r0 = new net.one97.paytm.recharge.common.fragment.s
            r0.<init>()
            r9.A = r0
            net.one97.paytm.recharge.common.fragment.s r0 = r9.A
            r0.setArguments(r10)
        L_0x008a:
            net.one97.paytm.recharge.common.fragment.s r10 = r9.A
            goto L_0x00e8
        L_0x008d:
            net.one97.paytm.recharge.common.fragment.l r10 = new net.one97.paytm.recharge.common.fragment.l
            java.util.List<net.one97.paytm.common.entity.shopping.CJROfferCode> r0 = r9.p
            net.one97.paytm.common.entity.CJRItem r1 = r9.s
            java.lang.String r2 = r9.j
            r10.<init>(r0, r1, r2)
            r0 = r10
            net.one97.paytm.recharge.common.fragment.l r0 = (net.one97.paytm.recharge.common.fragment.l) r0
            r9.f60695h = r0
            goto L_0x00e8
        L_0x009e:
            android.content.Context r1 = r9.f60688a
            int r2 = net.one97.paytm.recharge.R.string.help_title_str
            java.lang.String r1 = r1.getString(r2)
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00c9
            if (r10 <= 0) goto L_0x00b1
            r10 = 1
            r9.x = r10
        L_0x00b1:
            java.lang.String r10 = r9.v
            boolean r0 = r9.x
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            net.one97.paytm.common.entity.CJRItem r1 = r9.s
            java.lang.String r1 = r1.getCategoryId()
            net.one97.paytm.recharge.common.a.ab r10 = net.one97.paytm.recharge.common.a.ab.a(r10, r0, r9, r1)
            r0 = r10
            net.one97.paytm.recharge.common.a.ab r0 = (net.one97.paytm.recharge.common.a.ab) r0
            r9.f60694g = r0
            goto L_0x00e8
        L_0x00c9:
            android.content.Context r10 = r9.f60688a
            int r1 = net.one97.paytm.recharge.R.string.automatic
            java.lang.String r10 = r10.getString(r1)
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x00e7
            java.util.List<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel> r10 = r9.f60689b
            net.one97.paytm.common.entity.CJRItem r0 = r9.s
            androidx.fragment.app.Fragment r10 = net.one97.paytm.recharge.automatic.d.a.a(r10, r0, r9)
            r0 = r10
            net.one97.paytm.recharge.automatic.d.a r0 = (net.one97.paytm.recharge.automatic.d.a) r0
            android.view.View$OnClickListener r1 = r9.k
            r0.f60264a = r1
            goto L_0x00e8
        L_0x00e7:
            r10 = 0
        L_0x00e8:
            if (r10 != 0) goto L_0x00ef
            androidx.fragment.app.Fragment r10 = new androidx.fragment.app.Fragment
            r10.<init>()
        L_0x00ef:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.a.u.getItem(int):androidx.fragment.app.Fragment");
    }

    public final int getCount() {
        List<String> list = this.f60690c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f60690c.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r8 != 1) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        if (r0 > 5) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r2 > 0) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        if (r0 > 5) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPrimaryItem(android.view.ViewGroup r7, int r8, java.lang.Object r9) {
        /*
            r6 = this;
            super.setPrimaryItem(r7, r8, r9)
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            net.one97.paytm.recharge.common.widget.CJRUnScrollableViewPager r7 = (net.one97.paytm.recharge.common.widget.CJRUnScrollableViewPager) r7
            if (r9 == 0) goto L_0x006e
            android.view.View r0 = r9.getView()
            if (r0 == 0) goto L_0x006e
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r0 = r6.f60692e
            r1 = 0
            if (r0 == 0) goto L_0x0021
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0021
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r0 = r6.f60692e
            int r0 = r0.size()
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            java.util.List<net.one97.paytm.common.entity.shopping.CJROfferCode> r2 = r6.p
            if (r2 == 0) goto L_0x0033
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0033
            java.util.List<net.one97.paytm.common.entity.shopping.CJROfferCode> r2 = r6.p
            int r2 = r2.size()
            goto L_0x0034
        L_0x0033:
            r2 = 0
        L_0x0034:
            r3 = 1
            if (r8 == 0) goto L_0x003c
            if (r8 == r3) goto L_0x003a
            goto L_0x005f
        L_0x003a:
            r0 = r2
            goto L_0x0060
        L_0x003c:
            java.util.List<java.lang.String> r8 = r6.f60690c
            int r8 = r8.size()
            r4 = 9
            r5 = 5
            if (r8 != r3) goto L_0x0056
            if (r0 <= 0) goto L_0x0053
            boolean r8 = r6.w
            if (r8 == 0) goto L_0x0051
            if (r0 <= r5) goto L_0x0051
        L_0x004f:
            r0 = 9
        L_0x0051:
            r3 = 0
            goto L_0x0060
        L_0x0053:
            if (r2 <= 0) goto L_0x005f
            goto L_0x003a
        L_0x0056:
            if (r0 <= 0) goto L_0x005f
            boolean r8 = r6.w
            if (r8 == 0) goto L_0x0051
            if (r0 <= r5) goto L_0x0051
            goto L_0x004f
        L_0x005f:
            r0 = 0
        L_0x0060:
            r7.setViewType(r3)
            r7.f61974b = r0
            android.view.View r8 = r9.getView()
            r7.f61973a = r8
            r7.requestLayout()
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.a.u.setPrimaryItem(android.view.ViewGroup, int, java.lang.Object):void");
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        ((Fragment) obj).getView();
        this.n.remove(Integer.valueOf(i2));
        super.destroyItem(viewGroup, i2, obj);
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f60690c.get(i2);
    }

    public final void a(List<CJRFrequentOrder> list) {
        this.f60692e.addAll(list);
        Calendar instance = Calendar.getInstance();
        instance.add(5, 1);
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        new Date(instance.getTimeInMillis());
        if (this.f60690c.contains(this.f60688a.getString(R.string.recents_title_str))) {
            this.f60690c.remove(this.f60688a.getString(R.string.recents_title_str));
            notifyDataSetChanged();
        }
        this.f60690c.add(0, this.f60688a.getString(R.string.recents_title_str));
        this.f60691d.add(0, Integer.valueOf(R.string.recents_title_str));
        CJRCustomTabLayout cJRCustomTabLayout = this.f60696i;
        if (cJRCustomTabLayout != null) {
            cJRCustomTabLayout.setNumberOfTabs(this.f60690c.size());
        }
        notifyDataSetChanged();
    }

    public final void a(ViewPager viewPager, List<CJROfferCode> list) {
        Object instantiateItem = instantiateItem(viewPager, this.f60690c.indexOf(this.f60688a.getString(R.string.offers_title_str)));
        if (instantiateItem instanceof l) {
            this.p = list;
            l lVar = (l) instantiateItem;
            List<CJROfferCode> list2 = this.p;
            if (lVar.f61304b != null && lVar.getActivity() != null && lVar.isAdded()) {
                CJRRechargeUtilities.INSTANCE.debugLog(lVar.getString(R.string.clog_offers_show_for_other_category));
                lVar.f61303a = list2;
                lVar.a();
                lVar.f61304b.notifyDataSetChanged();
            }
        }
    }

    public final void b(List<CJROfferCode> list) {
        this.p = list;
        if (!this.f60690c.contains(this.f60688a.getString(R.string.offers_title_str))) {
            int size = this.f60690c.size();
            int indexOf = this.f60690c.indexOf(this.f60688a.getString(R.string.help_title_str));
            if (size > 0) {
                if (indexOf != -1) {
                    if (size > 1) {
                        size--;
                    }
                }
                this.f60690c.add(size, this.f60688a.getString(R.string.offers_title_str));
                this.f60691d.add(size, Integer.valueOf(R.string.offers_title_str));
            }
            size = 0;
            this.f60690c.add(size, this.f60688a.getString(R.string.offers_title_str));
            this.f60691d.add(size, Integer.valueOf(R.string.offers_title_str));
        }
        CJRCustomTabLayout cJRCustomTabLayout = this.f60696i;
        if (cJRCustomTabLayout != null) {
            cJRCustomTabLayout.setNumberOfTabs(this.f60690c.size());
        }
        notifyDataSetChanged();
    }

    public final void a(String str) {
        this.z = new String(this.y);
        this.y = str;
    }

    public final void a() {
        if (this.f60690c.contains(this.f60688a.getString(R.string.offers_title_str))) {
            this.p = null;
            int indexOf = this.f60690c.indexOf(this.f60688a.getString(R.string.offers_title_str));
            if (this.f60690c.size() > indexOf) {
                this.f60690c.remove(indexOf);
            }
            if (this.f60691d.size() > indexOf && this.f60691d.contains(Integer.valueOf(R.string.offers_title_str))) {
                this.f60691d.remove(indexOf);
            }
            CJRCustomTabLayout cJRCustomTabLayout = this.f60696i;
            if (cJRCustomTabLayout != null) {
                cJRCustomTabLayout.setNumberOfTabs(this.f60690c.size());
            }
            notifyDataSetChanged();
        }
    }

    public final boolean b() {
        return this.f60690c.contains(this.f60688a.getString(R.string.offers_title_str));
    }

    public final boolean c() {
        return this.f60690c.contains(this.f60688a.getString(R.string.recents_title_str));
    }

    public final void a(Boolean bool) {
        this.w = bool.booleanValue();
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        this.f60690c.remove(this.f60688a.getString(R.string.automatic));
        notifyDataSetChanged();
    }

    public final void b(Boolean bool) {
        this.x = bool.booleanValue();
    }
}
