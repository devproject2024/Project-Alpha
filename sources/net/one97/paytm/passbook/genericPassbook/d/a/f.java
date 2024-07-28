package net.one97.paytm.passbook.genericPassbook.d.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.passbook.caching.db.PassbookCacheDB;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.utility.m;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static Dialog f57461a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f57462b = new f();

    private f() {
    }

    public static void a(Context context) {
        k.c(context, "context");
        try {
            Dialog f2 = c.f((Activity) context);
            k.a((Object) f2, "CJRWalletUtility.getWall…alog(context as Activity)");
            f57461a = f2;
            if (f2 != null) {
                Dialog dialog = f57461a;
                if (dialog == null) {
                    k.a("mProgressDialog");
                }
                if (!dialog.isShowing()) {
                    Dialog dialog2 = f57461a;
                    if (dialog2 == null) {
                        k.a("mProgressDialog");
                    }
                    dialog2.show();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a() {
        try {
            if (f57461a != null) {
                Dialog dialog = f57461a;
                if (dialog == null) {
                    k.a("mProgressDialog");
                }
                if (dialog.isShowing()) {
                    Dialog dialog2 = f57461a;
                    if (dialog2 == null) {
                        k.a("mProgressDialog");
                    }
                    dialog2.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(LottieAnimationView lottieAnimationView, boolean z) {
        if (z) {
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
            }
            net.one97.paytm.passbook.utility.a.a(lottieAnimationView);
            return;
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        net.one97.paytm.passbook.utility.a.b(lottieAnimationView);
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            l.a(th);
        }
    }

    public static boolean a(String str) {
        k.c(str, "type");
        int hashCode = str.hashCode();
        if (hashCode == 55) {
            return !str.equals("7");
        }
        if (hashCode == 56) {
            return !str.equals("8");
        }
        if (hashCode == 1568) {
            return !str.equals("11");
        }
        if (hashCode == 1598) {
            return !str.equals("20");
        }
        if (hashCode == 1600) {
            return !str.equals("22");
        }
        if (hashCode == 1635) {
            return !str.equals("36");
        }
        if (hashCode == 1669) {
            return !str.equals("49");
        }
        if (hashCode == 1691) {
            return !str.equals("50");
        }
        if (hashCode == 1694) {
            return !str.equals("53");
        }
        if (hashCode == 1761) {
            return !str.equals("78");
        }
        if (hashCode == 1606) {
            return !str.equals("28");
        }
        if (hashCode == 1607) {
            return !str.equals("29");
        }
        if (hashCode == 1730) {
            return !str.equals("68");
        }
        if (hashCode == 1731) {
            return !str.equals("69");
        }
        if (hashCode == 1755) {
            return !str.equals("72");
        }
        if (hashCode == 1756) {
            return !str.equals("73");
        }
        switch (hashCode) {
            case 49:
                return !str.equals("1");
            case 50:
                return !str.equals("2");
            case 51:
                return !str.equals("3");
            case 52:
                return !str.equals("4");
            case 53:
                return !str.equals("5");
            default:
                switch (hashCode) {
                    case 1570:
                        return !str.equals("13");
                    case 1571:
                        return !str.equals("14");
                    case 1572:
                        return !str.equals("15");
                    case 1573:
                        return !str.equals("16");
                    default:
                        switch (hashCode) {
                            case 1664:
                                return !str.equals("44");
                            case 1665:
                                return !str.equals("45");
                            case 1666:
                                return !str.equals("46");
                            case 1667:
                                return !str.equals("47");
                            default:
                                switch (hashCode) {
                                    case 1696:
                                        return !str.equals("55");
                                    case 1697:
                                        return !str.equals("56");
                                    case 1698:
                                        return !str.equals("57");
                                    default:
                                        return true;
                                }
                        }
                }
        }
    }

    public static void b() {
        m.a aVar = m.f59265a;
        net.one97.paytm.passbook.mapping.f b2 = d.b();
        k.a((Object) b2, "PassbookHelper.getImplListener()");
        Context b3 = b2.b();
        k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
        com.paytm.b.a.a a2 = m.a.a(b3);
        String b4 = a2.b("userId", "", true);
        if (true ^ k.a((Object) b4, (Object) a2.b("pbCacheUserId", "", false))) {
            PassbookCacheDB.a aVar2 = PassbookCacheDB.f57107a;
            net.one97.paytm.passbook.mapping.f b5 = d.b();
            k.a((Object) b5, "PassbookHelper.getImplListener()");
            Context b6 = b5.b();
            k.a((Object) b6, "PassbookHelper.getImplLi…ener().applicationContext");
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new a(CoroutineExceptionHandler.Key), (CoroutineStart) null, new b(PassbookCacheDB.a.a(b6), (kotlin.d.d) null), 2, (Object) null);
            } catch (Exception e2) {
                l.a((Throwable) e2);
            }
        }
        a2.a("pbCacheUserId", b4, false);
    }

    @kotlin.d.b.a.f(b = "WalletUtility.kt", c = {78}, d = "invokeSuspend", e = "net/one97/paytm/passbook/genericPassbook/wallet/paytm_wallet/WalletUtility$clearPbCache$1")
    static final class b extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ PassbookCacheDB $db;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PassbookCacheDB passbookCacheDB, kotlin.d.d dVar) {
            super(2, dVar);
            this.$db = passbookCacheDB;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.$db, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                PassbookCacheDB passbookCacheDB = this.$db;
                if (passbookCacheDB != null) {
                    passbookCacheDB.clearAllTables();
                }
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }
}
