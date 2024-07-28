package net.one97.paytm;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.q;
import com.paytm.utility.a;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.CJRCatalogSavedState;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.landingpage.leftNavigation.d;
import net.one97.paytm.paytm_finance.R;

public final class c implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public static CJRCatalogItem f52344a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f52345b = 500;

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<CJRCatalogItem> f52346d;

    /* renamed from: c  reason: collision with root package name */
    CJRActionBarBaseActivity f52347c;

    /* renamed from: e  reason: collision with root package name */
    d f52348e;

    /* renamed from: f  reason: collision with root package name */
    private final int f52349f = R.id.flyout_frame;

    /* renamed from: g  reason: collision with root package name */
    private CJRCatalog f52350g;

    /* renamed from: h  reason: collision with root package name */
    private View f52351h;

    /* renamed from: i  reason: collision with root package name */
    private int f52352i;
    private int j;
    private DrawerLayout k;
    private ArrayList<String> l;

    public final void onAnimationEnd(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    public c(CJRActionBarBaseActivity cJRActionBarBaseActivity, CJRCatalog cJRCatalog, DrawerLayout drawerLayout) {
        this.f52347c = cJRActionBarBaseActivity;
        this.f52350g = cJRCatalog;
        this.k = drawerLayout;
        b();
        this.f52352i = a.t(this.f52347c);
        this.j = this.f52352i / 2;
        this.f52351h = View.inflate(this.f52347c, R.layout.catalog_cell_layout, (ViewGroup) null);
        ((RelativeLayout) this.f52351h.findViewById(R.id.rly_selectbank_container)).getLayoutParams().height = (int) (((double) this.f52352i) * 2.8d);
        if (this.f52350g != null) {
            CJRCatalogSavedState cJRCatalogSavedState = ((CJRJarvisApplication) this.f52347c.getApplication()).f49006b;
            f52346d = this.f52350g.getCatalogList();
            if (!(cJRCatalogSavedState == null || cJRCatalogSavedState.getSelectedItem() == null || cJRCatalogSavedState.getSelectedItem().getParentName() == null)) {
                this.l = new ArrayList<>(cJRCatalogSavedState.getSelectedItem().getParentName());
                f52344a = cJRCatalogSavedState.getSelectedItem();
            }
            try {
                if (this.f52348e == null) {
                    this.f52348e = new d();
                    q a2 = this.f52347c.getSupportFragmentManager().a();
                    a2.a(R.id.flyout_frame, this.f52348e, "fragment_flyout");
                    a2.c();
                    this.f52347c.getSupportFragmentManager().b();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void b() {
        ArrayList<CJRCatalogItem> catalogList;
        ArrayList<CJRCatalogItem> subItems;
        ArrayList<CJRCatalogItem> subItems2;
        new CJRCatalogItem().setName("Paytm Home");
        CJRCatalog cJRCatalog = this.f52350g;
        if (cJRCatalog != null && (catalogList = cJRCatalog.getCatalogList()) != null) {
            Iterator<CJRCatalogItem> it2 = catalogList.iterator();
            CJRCatalogItem cJRCatalogItem = null;
            CJRCatalogItem cJRCatalogItem2 = null;
            CJRCatalogItem cJRCatalogItem3 = null;
            CJRCatalogItem cJRCatalogItem4 = null;
            while (it2.hasNext()) {
                CJRCatalogItem next = it2.next();
                ArrayList<CJRCatalogItem> subItems3 = next.getSubItems();
                if (subItems3 != null) {
                    Iterator<CJRCatalogItem> it3 = subItems3.iterator();
                    while (it3.hasNext()) {
                        CJRCatalogItem next2 = it3.next();
                        if (next2.getURLType() != null && next2.getURLType().equalsIgnoreCase("mobile-postpaid")) {
                            cJRCatalogItem = next;
                            cJRCatalogItem2 = next2;
                        }
                        if (next2.getURLType() != null && next2.getURLType().equalsIgnoreCase("datacard-postpaid")) {
                            cJRCatalogItem3 = next;
                            cJRCatalogItem4 = next2;
                        }
                    }
                }
            }
            if (!(cJRCatalogItem == null || cJRCatalogItem2 == null || (subItems2 = cJRCatalogItem.getSubItems()) == null)) {
                subItems2.remove(cJRCatalogItem2);
            }
            if (cJRCatalogItem3 != null && cJRCatalogItem4 != null && (subItems = cJRCatalogItem3.getSubItems()) != null) {
                subItems.remove(cJRCatalogItem4);
            }
        }
    }

    public static String a() {
        String sb = new StringBuilder().toString();
        CJRCatalogItem cJRCatalogItem = f52344a;
        if (cJRCatalogItem != null) {
            cJRCatalogItem.getCategoryId();
        }
        return sb;
    }
}
