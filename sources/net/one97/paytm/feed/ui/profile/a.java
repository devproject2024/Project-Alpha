package net.one97.paytm.feed.ui.profile;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.t;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.dc;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.profile.f;
import net.one97.paytm.feed.utility.u;

public final class a extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    dc f35270a = ((dc) dc.bind(f.a(), this.f35272c, R.layout.view_holder_bookmark));

    /* renamed from: b  reason: collision with root package name */
    private final String f35271b = "BookmarkViewHolder";

    /* renamed from: c  reason: collision with root package name */
    private View f35272c;

    static final class d implements t.a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f35283a = new d();

        d() {
        }

        public final void a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
        this.f35272c = view;
    }

    /* renamed from: net.one97.paytm.feed.ui.profile.a$a  reason: collision with other inner class name */
    static final class C0587a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f35273a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedItem f35274b;

        C0587a(f.a aVar, FeedItem feedItem) {
            this.f35273a = aVar;
            this.f35274b = feedItem;
        }

        public final void onClick(View view) {
            this.f35273a.a((FeedGeneric) this.f35274b);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35275a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35276b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a f35277c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FeedItem f35278d;

        b(a aVar, int i2, f.a aVar2, FeedItem feedItem) {
            this.f35275a = aVar;
            this.f35276b = i2;
            this.f35277c = aVar2;
            this.f35278d = feedItem;
        }

        public final void onClick(View view) {
            k.a((Object) view, "it");
            int i2 = this.f35276b;
            f.a aVar = this.f35277c;
            String id = ((FeedGeneric) this.f35278d).getFeedGenericData().getId();
            k.c(view, "view");
            k.c(aVar, "profileDiscoveryClickListener");
            k.c(id, "id");
            net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
            if (net.one97.paytm.feed.e.c.a(view.getContext())) {
                u uVar = u.f35438a;
                if (!u.a()) {
                    t tVar = new t(new androidx.appcompat.view.d(view.getContext(), R.style.popupMenuStyle), view);
                    MenuInflater b2 = tVar.b();
                    k.a((Object) b2, "popup.menuInflater");
                    b2.inflate(R.menu.feed_bookmark_menu, tVar.f1796a);
                    tVar.f1798c = new c(view, id, aVar, i2);
                    try {
                        Field declaredField = t.class.getDeclaredField("b");
                        k.a((Object) declaredField, "PopupMenu::class.java.getDeclaredField(\"mPopup\")");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(tVar);
                        if (obj != null) {
                            Class[] clsArr = new Class[1];
                            Class cls = Boolean.TYPE;
                            if (cls == null) {
                                k.a();
                            }
                            clsArr[0] = cls;
                            obj.getClass().getDeclaredMethod("setForceShowIcon", (Class[]) Arrays.copyOf(clsArr, 1)).invoke(obj, new Object[]{Boolean.TRUE});
                            tVar.f1797b.a();
                            tVar.f1799d = d.f35283a;
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type java.lang.Object");
                    } catch (Exception unused) {
                        tVar.f1797b.a();
                    }
                }
            }
        }
    }

    static final class c implements t.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f35279a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35280b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a f35281c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f35282d;

        c(View view, String str, f.a aVar, int i2) {
            this.f35279a = view;
            this.f35280b = str;
            this.f35281c = aVar;
            this.f35282d = i2;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            Boolean valueOf = menuItem != null ? Boolean.valueOf(Integer.valueOf(menuItem.getItemId()).equals(Integer.valueOf(R.id.remove))) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue()) {
                return false;
            }
            net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
            net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
            Context context = this.f35279a.getContext();
            k.a((Object) context, "view.context");
            a2.e(context, "/content-actions/v1/actions/" + this.f35280b + "/bookmarks", new kotlin.g.a.b<String, x>(this) {
                final /* synthetic */ c this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return x.f47997a;
                }

                public final void invoke(String str) {
                    if (str != null) {
                        this.this$0.f35281c.b(this.this$0.f35282d);
                    } else {
                        Toast.makeText(this.this$0.f35279a.getContext(), this.this$0.f35279a.getContext().getString(R.string.feed_server_error), 0).show();
                    }
                }
            });
            return false;
        }
    }
}
