package net.one97.paytm.landingpage.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.lifecycle.k;
import com.paytm.utility.a;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.CJRCatalogSavedState;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.activity.HomeBaseActivity;
import net.one97.paytm.landingpage.leftNavigation.d;

public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static CJRCatalogItem f52895d = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f52896e = 500;

    /* renamed from: f  reason: collision with root package name */
    public static ArrayList<CJRCatalogItem> f52897f;

    /* renamed from: a  reason: collision with root package name */
    public d f52898a;

    /* renamed from: b  reason: collision with root package name */
    public HomeBaseActivity f52899b;

    /* renamed from: c  reason: collision with root package name */
    public CJRCatalog f52900c;

    public b(HomeBaseActivity homeBaseActivity, CJRCatalog cJRCatalog) {
        this.f52899b = homeBaseActivity;
        this.f52900c = cJRCatalog;
        a();
        a.t(this.f52899b);
        if (this.f52900c != null) {
            CJRCatalogSavedState f2 = net.one97.paytm.common.b.d.b().f();
            f52897f = this.f52900c.getCatalogList();
            if (f2 != null && f2.getSelectedItem() != null && f2.getSelectedItem().getParentName() != null) {
                f52895d = f2.getSelectedItem();
            }
        }
    }

    public final void a() {
        ArrayList<CJRCatalogItem> catalogList;
        ArrayList<CJRCatalogItem> subItems;
        ArrayList<CJRCatalogItem> subItems2;
        new CJRCatalogItem().setName("Paytm Home");
        CJRCatalog cJRCatalog = this.f52900c;
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

    public final void b() {
        if (d() == null) {
            this.f52898a = new d();
            net.one97.paytm.common.utility.b.br = false;
            q a2 = this.f52899b.getSupportFragmentManager().a();
            a2.a(R.id.flyout_frame, this.f52898a, "fragment_flyout");
            a2.a((Fragment) this.f52898a, k.b.RESUMED);
            a2.c();
            HomeBaseActivity homeBaseActivity = this.f52899b;
            if (homeBaseActivity != null && !homeBaseActivity.isFinishing()) {
                this.f52899b.getSupportFragmentManager().b();
            }
        }
    }

    public static void c() {
        CJRCatalogSavedState cJRCatalogSavedState = new CJRCatalogSavedState();
        cJRCatalogSavedState.setSelectedItem(f52895d);
        net.one97.paytm.common.b.d.a().a(cJRCatalogSavedState);
    }

    public final Fragment d() {
        Fragment c2 = this.f52899b.getSupportFragmentManager().c(R.id.flyout_frame);
        if (c2 instanceof d) {
            this.f52898a = (d) c2;
        }
        return this.f52898a;
    }

    public final void e() {
        this.f52899b.getSupportFragmentManager().a((String) null);
    }

    public final void f() {
        d dVar = this.f52898a;
        if (dVar != null) {
            dVar.c();
            this.f52898a.a();
        }
    }
}
