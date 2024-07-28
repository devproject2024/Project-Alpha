package net.one97.paytm.upi.a;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    final LiveData<String> f66517a = this.j;

    /* renamed from: b  reason: collision with root package name */
    final LiveData<String> f66518b = this.k;

    /* renamed from: c  reason: collision with root package name */
    final LiveData<String> f66519c = this.l;

    /* renamed from: d  reason: collision with root package name */
    final LiveData<List<a>> f66520d = this.m;

    /* renamed from: e  reason: collision with root package name */
    final LiveData<String> f66521e = this.n;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public final y<Boolean> f66522f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    final LiveData<Boolean> f66523g = this.f66522f;

    /* renamed from: h  reason: collision with root package name */
    final LiveData<Boolean> f66524h = this.o;

    /* renamed from: i  reason: collision with root package name */
    final net.one97.paytm.upi.registration.b.a.b f66525i;
    /* access modifiers changed from: private */
    public final y<String> j = new y<>();
    /* access modifiers changed from: private */
    public final y<String> k = new y<>();
    /* access modifiers changed from: private */
    public final y<String> l = new y<>();
    /* access modifiers changed from: private */
    public final y<List<a>> m = new y<>();
    /* access modifiers changed from: private */
    public final y<String> n = new y<>();
    /* access modifiers changed from: private */
    public final y<Boolean> o = new y<>();

    public interface b {
        void a(NetworkCustomError networkCustomError);

        void a(CJRHomePageV2 cJRHomePageV2);
    }

    public c(net.one97.paytm.upi.registration.b.a.b bVar) {
        k.c(bVar, "upiRegistrationRepository");
        this.f66525i = bVar;
    }

    /* renamed from: net.one97.paytm.upi.a.c$c  reason: collision with other inner class name */
    public static final class C1340c implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f66529a;

        C1340c(c cVar) {
            this.f66529a = cVar;
        }

        public final void a(CJRHomePageV2 cJRHomePageV2) {
            k.c(cJRHomePageV2, "cjrHomePageV2");
            CJRHomePageLayoutV2 cJRHomePageLayoutV2 = cJRHomePageV2.mPage.get(0).mHomePageLayoutList.get(0);
            k.a((Object) cJRHomePageLayoutV2, "cjrHomePageV2.mPage[0].mHomePageLayoutList[0]");
            String str = cJRHomePageLayoutV2.getHomePageItemList().get(0).mName;
            CJRHomePageLayoutV2 cJRHomePageLayoutV22 = cJRHomePageV2.mPage.get(1).mHomePageLayoutList.get(0);
            k.a((Object) cJRHomePageLayoutV22, "cjrHomePageV2.mPage[1].mHomePageLayoutList[0]");
            String str2 = cJRHomePageLayoutV22.getHomePageItemList().get(0).mName;
            CJRHomePageLayoutV2 cJRHomePageLayoutV23 = cJRHomePageV2.mPage.get(2).mHomePageLayoutList.get(0);
            k.a((Object) cJRHomePageLayoutV23, "cjrHomePageV2.mPage[2].mHomePageLayoutList[0]");
            String str3 = cJRHomePageLayoutV23.getHomePageItemList().get(0).mName;
            CJRHomePageLayoutV2 cJRHomePageLayoutV24 = cJRHomePageV2.mPage.get(4).mHomePageLayoutList.get(0);
            k.a((Object) cJRHomePageLayoutV24, "cjrHomePageV2.mPage[4].mHomePageLayoutList[0]");
            String str4 = cJRHomePageLayoutV24.getHomePageItemList().get(0).mName;
            CJRHomePageLayoutV2 cJRHomePageLayoutV25 = cJRHomePageV2.mPage.get(3).mHomePageLayoutList.get(0);
            k.a((Object) cJRHomePageLayoutV25, "cjrHomePageV2.mPage[3]\n …  .mHomePageLayoutList[0]");
            ArrayList<CJRHomePageItem> homePageItemList = cJRHomePageLayoutV25.getHomePageItemList();
            k.a((Object) homePageItemList, "cjrHomePageV2.mPage[3]\n …        .homePageItemList");
            Iterable<CJRHomePageItem> iterable = homePageItemList;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (CJRHomePageItem cJRHomePageItem : iterable) {
                String str5 = cJRHomePageItem.mName;
                k.a((Object) str5, "it.mName");
                String str6 = cJRHomePageItem.mImageUrl;
                k.a((Object) str6, "it.mImageUrl");
                String str7 = cJRHomePageItem.mUrl;
                k.a((Object) str7, "it.mUrl");
                arrayList.add(new a(str5, str6, str7));
            }
            this.f66529a.j.setValue(str);
            this.f66529a.k.setValue(str2);
            this.f66529a.l.setValue(str3);
            this.f66529a.m.setValue((List) arrayList);
            this.f66529a.n.setValue(str4);
            this.f66529a.f66522f.setValue(Boolean.FALSE);
        }

        public final void a(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkCustomError");
            this.f66529a.o.setValue(Boolean.TRUE);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f66526a;

        /* renamed from: b  reason: collision with root package name */
        final String f66527b;

        /* renamed from: c  reason: collision with root package name */
        final String f66528c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k.a((Object) this.f66526a, (Object) aVar.f66526a) && k.a((Object) this.f66527b, (Object) aVar.f66527b) && k.a((Object) this.f66528c, (Object) aVar.f66528c);
        }

        public final int hashCode() {
            String str = this.f66526a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f66527b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f66528c;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "BottomSheetOptions(title=" + this.f66526a + ", imgUrl=" + this.f66527b + ", deepLink=" + this.f66528c + ")";
        }

        public a(String str, String str2, String str3) {
            k.c(str, "title");
            k.c(str2, "imgUrl");
            k.c(str3, "deepLink");
            this.f66526a = str;
            this.f66527b = str2;
            this.f66528c = str3;
        }
    }
}
