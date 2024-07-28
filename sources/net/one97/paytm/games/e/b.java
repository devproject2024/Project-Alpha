package net.one97.paytm.games.e;

import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.m.p;
import net.one97.paytm.games.e.a.d;
import net.one97.paytm.games.model.pfg.GamesHeaderSmsData;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f35599a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final String f35600b = f35600b;

    /* renamed from: c  reason: collision with root package name */
    private static final g<GamesHeaderSmsData> f35601c = h.a(a.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    private static final g<Boolean> f35602d = h.a(C0595b.INSTANCE);

    private b() {
    }

    static final class a extends l implements kotlin.g.a.a<GamesHeaderSmsData> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final GamesHeaderSmsData invoke() {
            g a2 = g.a();
            k.a((Object) a2, "GpSingleton.getInstance()");
            a2.b();
            String gtmString = g.a().c().getGtmString("games_header_sms");
            try {
                d dVar = d.f35594a;
                if (gtmString == null) {
                    k.a();
                }
                return (GamesHeaderSmsData) d.a(gtmString, GamesHeaderSmsData.class);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static g<GamesHeaderSmsData> a() {
        return f35601c;
    }

    public static boolean b() {
        GamesHeaderSmsData value = f35601c.getValue();
        if (value != null) {
            CharSequence text = value.getText();
            if (!(text == null || p.a(text))) {
                CharSequence template = value.getTemplate();
                if (!(template == null || p.a(template))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: net.one97.paytm.games.e.b$b  reason: collision with other inner class name */
    static final class C0595b extends l implements kotlin.g.a.a<Boolean> {
        public static final C0595b INSTANCE = new C0595b();

        C0595b() {
            super(0);
        }

        public final boolean invoke() {
            g a2 = g.a();
            k.a((Object) a2, "GpSingleton.getInstance()");
            a2.b();
            g a3 = g.a();
            k.a((Object) a3, "GpSingleton.getInstance()");
            return a3.c().getGtmBoolean("pfg_wallet_total_v2", true);
        }
    }

    public static g<Boolean> c() {
        return f35602d;
    }
}
