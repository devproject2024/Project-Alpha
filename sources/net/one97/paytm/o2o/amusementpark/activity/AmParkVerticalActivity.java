package net.one97.paytm.o2o.amusementpark.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.utils.m;

public final class AmParkVerticalActivity extends PaytmActivity {

    public interface a {
        void a(boolean z);
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        if (net.one97.paytm.o2o.amusementpark.a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            a.b a2 = net.one97.paytm.o2o.amusementpark.a.a();
            super.attachBaseContext(a2 != null ? a2.getBaseContext(context) : null);
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_amusement_park_home_root);
        a(getIntent());
    }

    private final void a(Intent intent) {
        b b2 = b(intent);
        if (b2.f73384c instanceof CJRHomePageItem) {
            CJRItem cJRItem = b2.f73384c;
            if (cJRItem != null) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) cJRItem;
                a.C1469a b3 = net.one97.paytm.o2o.amusementpark.a.b();
                if (b3 != null) {
                    b3.sendDeepLinkOpen(b2.f73383b, cJRHomePageItem, this);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRHomePageItem");
            }
        }
        a(b2.f73382a, b2);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f73382a = 2;

        /* renamed from: b  reason: collision with root package name */
        final String f73383b;

        /* renamed from: c  reason: collision with root package name */
        final CJRItem f73384c;

        /* renamed from: d  reason: collision with root package name */
        private final String f73385d;

        /* renamed from: e  reason: collision with root package name */
        private final String f73386e;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f73382a == bVar.f73382a && k.a((Object) this.f73383b, (Object) bVar.f73383b) && k.a((Object) this.f73384c, (Object) bVar.f73384c) && k.a((Object) this.f73385d, (Object) bVar.f73385d) && k.a((Object) this.f73386e, (Object) bVar.f73386e);
        }

        public final int hashCode() {
            int i2 = this.f73382a * 31;
            String str = this.f73383b;
            int i3 = 0;
            int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            CJRItem cJRItem = this.f73384c;
            int hashCode2 = (hashCode + (cJRItem != null ? cJRItem.hashCode() : 0)) * 31;
            String str2 = this.f73385d;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f73386e;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return hashCode3 + i3;
        }

        public final String toString() {
            return "ScreenType(type=" + this.f73382a + ", attrib=" + this.f73383b + ", mItem=" + this.f73384c + ", origin=" + this.f73385d + ", url=" + this.f73386e + ")";
        }

        public b(String str, CJRItem cJRItem, String str2, String str3) {
            k.c(str, "attrib");
            this.f73383b = str;
            this.f73384c = cJRItem;
            this.f73385d = str2;
            this.f73386e = str3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = r0.getURLType();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String a() {
            /*
                r1 = this;
                net.one97.paytm.common.entity.CJRItem r0 = r1.f73384c
                if (r0 == 0) goto L_0x000a
                java.lang.String r0 = r0.getURLType()
                if (r0 != 0) goto L_0x000c
            L_0x000a:
                java.lang.String r0 = r1.f73386e
            L_0x000c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.activity.AmParkVerticalActivity.b.a():java.lang.String");
        }

        public final Bundle a(Context context) {
            k.c(context, "context");
            CJRSelectCityModel a2 = net.one97.paytm.o2o.amusementpark.f.b.a(context, this.f73383b);
            Bundle bundle = new Bundle();
            bundle.putParcelable("city_extra_item", a2);
            bundle.putSerializable("extra_home_data", this.f73384c);
            bundle.putString("url_type", a());
            bundle.putString("origin", this.f73385d);
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            return bundle;
        }
    }

    private static b b(Intent intent) {
        String str;
        String str2;
        CJRItem cJRItem = null;
        if (intent != null) {
            cJRItem = (CJRItem) intent.getSerializableExtra("extra_home_data");
            str2 = intent.getStringExtra("origin");
            str = intent.getStringExtra("extra_url_type");
        } else {
            str = null;
            str2 = null;
        }
        return new b("ampark", cJRItem, str2, str);
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    private final void a(int i2, b bVar) {
        Fragment c2 = getSupportFragmentManager().c(R.id.frame_layout);
        if (i2 == 2) {
            if (!(c2 instanceof net.one97.paytm.o2o.amusementpark.c.c)) {
                net.one97.paytm.o2o.amusementpark.c.c cVar = new net.one97.paytm.o2o.amusementpark.c.c();
                cVar.setArguments(bVar.a(this));
                c2 = cVar;
            } else if (bVar.f73384c != null) {
                net.one97.paytm.o2o.amusementpark.c.c cVar2 = (net.one97.paytm.o2o.amusementpark.c.c) c2;
                CJRItem cJRItem = bVar.f73384c;
                if (cJRItem != null) {
                    cVar2.a((CJRHomePageItem) cJRItem);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRHomePageItem");
            } else {
                return;
            }
        }
        if (c2 != null) {
            getSupportFragmentManager().a().b(R.id.frame_layout, c2, String.valueOf(i2)).b();
        }
    }

    public final void onBackPressed() {
        finish();
    }

    public static final class c extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f73387a;

        c(a aVar) {
            this.f73387a = aVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            if (recyclerView.getLayoutManager() != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                } else if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() > 1) {
                    a aVar = this.f73387a;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                } else {
                    a aVar2 = this.f73387a;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                }
            }
        }
    }

    public static void a(RecyclerView recyclerView, a aVar) {
        k.c(recyclerView, "recyclerView");
        recyclerView.setOnScrollListener(new c(aVar));
    }
}
