package net.one97.paytm.deeplink;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.addmoney.d;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.b.d;
import net.one97.paytm.p2b.c;
import net.one97.paytm.upi.n;
import net.one97.paytm.utils.aa;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.bc;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50349a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean a(Context context, String str, Bundle bundle) {
            String str2;
            aa aaVar = aa.f69597a;
            aa.c();
            d.b().k();
            CJRJarvisApplication.s();
            aa aaVar2 = aa.f69597a;
            aa.a();
            CharSequence charSequence = str;
            boolean z = true;
            if ((!(charSequence == null || charSequence.length() == 0) || bundle != null) && context != null) {
                i iVar = i.f50350a;
                DeepLinkData a2 = i.a(context, str, bundle);
                if (a2 == null) {
                    aa aaVar3 = aa.f69597a;
                    aa.b();
                    return false;
                }
                i iVar2 = i.f50350a;
                if (i.b(context, a2)) {
                    i iVar3 = i.f50350a;
                    i.a(context, a2, bundle);
                    aa aaVar4 = aa.f69597a;
                    aa.a(a2.f50283a, a2.f50284b);
                    return true;
                } else if (p.a(a2.f50284b, "nolink", false)) {
                    aa aaVar5 = aa.f69597a;
                    aa.b();
                    return false;
                } else {
                    if (!TextUtils.isEmpty(charSequence)) {
                        i iVar4 = i.f50350a;
                        i.a(context, a2.f50289g);
                        i iVar5 = i.f50350a;
                        i.a(context, a2);
                    }
                    p pVar = p.f50364a;
                    if (p.a(context, a2)) {
                        p pVar2 = p.f50364a;
                        p.b(context, a2);
                        aa aaVar6 = aa.f69597a;
                        aa.a(a2.f50283a, a2.f50284b);
                        return true;
                    }
                    u.a();
                    if (u.a(a2)) {
                        aa aaVar7 = aa.f69597a;
                        aa.a((String) null);
                        u.a().a(context, a2);
                        aa aaVar8 = aa.f69597a;
                        aa.a(a2.f50283a, a2.f50284b);
                        return true;
                    }
                    d.a aVar = net.one97.paytm.addmoney.d.f48562a;
                    net.one97.paytm.addmoney.d a3 = d.a.a();
                    if (a3 == null) {
                        k.a();
                    }
                    if (a3.a(a2)) {
                        d.a aVar2 = net.one97.paytm.addmoney.d.f48562a;
                        net.one97.paytm.addmoney.d a4 = d.a.a();
                        if (a4 != null) {
                            a4.a(context, a2);
                        }
                        aa aaVar9 = aa.f69597a;
                        aa.a(a2.f50283a, a2.f50284b);
                        return true;
                    }
                    c cVar = c.f56880a;
                    if (c.a(a2)) {
                        c cVar2 = c.f56880a;
                        c.a(context, a2);
                        aa aaVar10 = aa.f69597a;
                        aa.a(a2.f50283a, a2.f50284b);
                        return true;
                    } else if (ac.a(a2)) {
                        ac.a(context, a2);
                        aa aaVar11 = aa.f69597a;
                        aa.a(a2.f50283a, a2.f50284b);
                        return true;
                    } else {
                        e eVar = e.f50333a;
                        if (e.a(a2)) {
                            e eVar2 = e.f50333a;
                            e.a(context, a2);
                            aa aaVar12 = aa.f69597a;
                            aa.a(a2.f50283a, a2.f50284b);
                            return true;
                        }
                        net.one97.paytm.moneytransfer.c cVar3 = net.one97.paytm.moneytransfer.c.f53587a;
                        if (net.one97.paytm.moneytransfer.c.a(a2)) {
                            net.one97.paytm.moneytransfer.c cVar4 = net.one97.paytm.moneytransfer.c.f53587a;
                            net.one97.paytm.moneytransfer.c.a(context, a2);
                            aa aaVar13 = aa.f69597a;
                            aa.a(a2.f50283a, a2.f50284b);
                            return true;
                        }
                        n nVar = n.f67609a;
                        if (n.a(a2)) {
                            n nVar2 = n.f67609a;
                            n.a(context, a2);
                            aa aaVar14 = aa.f69597a;
                            aa.a(a2.f50283a, a2.f50284b);
                            return true;
                        }
                        a aVar3 = a.f50291a;
                        if (a.a(a2)) {
                            a aVar4 = a.f50291a;
                            a.a(context, a2);
                            aa aaVar15 = aa.f69597a;
                            aa.a(a2.f50283a, a2.f50284b);
                            return true;
                        } else if (bc.a(a2)) {
                            bc.a(context, a2.f50283a, a2);
                            aa aaVar16 = aa.f69597a;
                            aa.a(a2.f50283a, a2.f50284b);
                            return true;
                        } else {
                            ak akVar = ak.f50322a;
                            if (ak.a(a2)) {
                                ak akVar2 = ak.f50322a;
                                ak.a(context, a2);
                                aa aaVar17 = aa.f69597a;
                                aa.a(a2.f50283a, a2.f50284b);
                                return true;
                            }
                            m mVar = m.f50358c;
                            if (m.a(context, a2)) {
                                m mVar2 = m.f50358c;
                                m.b(context, a2);
                                aa aaVar18 = aa.f69597a;
                                aa.a(a2.f50283a, a2.f50284b);
                                return true;
                            } else if (o.a(a2)) {
                                o.a(context, a2);
                                aa aaVar19 = aa.f69597a;
                                aa.a(a2.f50283a, a2.f50284b);
                                return true;
                            } else {
                                aj ajVar = aj.f50320a;
                                if (aj.a(a2)) {
                                    aj ajVar2 = aj.f50320a;
                                    aj.a(context, a2);
                                    aa aaVar20 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                }
                                ae aeVar = ae.f50307a;
                                if (ae.a(a2)) {
                                    if (bundle != null && bundle.containsKey("qrCodeId")) {
                                        a2.f50290h = bundle;
                                    }
                                    ae aeVar2 = ae.f50307a;
                                    ae.a(context, a2);
                                    aa aaVar21 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                }
                                net.one97.paytm.nearbuy_h5.a aVar5 = net.one97.paytm.nearbuy_h5.a.f55773a;
                                if (net.one97.paytm.nearbuy_h5.a.a(a2)) {
                                    net.one97.paytm.nearbuy_h5.a aVar6 = net.one97.paytm.nearbuy_h5.a.f55773a;
                                    net.one97.paytm.nearbuy_h5.a.a(context, a2);
                                    aa aaVar22 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                }
                                n nVar3 = n.f50361a;
                                if (n.a(a2)) {
                                    n nVar4 = n.f50361a;
                                    n.a(context, a2);
                                    aa aaVar23 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                }
                                ab abVar = ab.f50295a;
                                if (ab.a(a2)) {
                                    ab abVar2 = ab.f50295a;
                                    ab.a(context, a2);
                                    aa aaVar24 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                }
                                s sVar = s.f50367a;
                                if (s.a(a2)) {
                                    s sVar2 = s.f50367a;
                                    s.a(context, a2);
                                    aa aaVar25 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                } else if (z.a(a2)) {
                                    z.a(context, a2);
                                    aa aaVar26 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                } else if (b.a(a2)) {
                                    b.a(context, a2);
                                    aa aaVar27 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                } else if (k.a(a2)) {
                                    k.a(context, a2);
                                    aa aaVar28 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                } else if (d.a(a2)) {
                                    if (bundle != null) {
                                        str2 = bundle.getString("issueTicketNumber");
                                    } else {
                                        str2 = null;
                                    }
                                    Bundle bundle2 = a2.f50290h;
                                    if (bundle2 != null) {
                                        bundle2.putString("issueTicketNumber", str2);
                                    }
                                    d.a(context, (Bundle) null, a2);
                                    aa aaVar29 = aa.f69597a;
                                    aa.a(a2.f50283a, a2.f50284b);
                                    return true;
                                } else {
                                    l lVar = l.f50355a;
                                    if (l.a(a2)) {
                                        l lVar2 = l.f50355a;
                                        l.a(context, a2);
                                        aa aaVar30 = aa.f69597a;
                                        aa.a(a2.f50283a, a2.f50284b);
                                        return true;
                                    }
                                    q qVar = q.f50365a;
                                    if (q.a(a2)) {
                                        q qVar2 = q.f50365a;
                                        q.a(context, a2, bundle);
                                        aa aaVar31 = aa.f69597a;
                                        aa.a(a2.f50283a, a2.f50284b);
                                        return true;
                                    }
                                    w wVar = w.f50379a;
                                    if (w.a(a2)) {
                                        w wVar2 = w.f50379a;
                                        w.a(context, a2);
                                        aa aaVar32 = aa.f69597a;
                                        aa.a(a2.f50283a, a2.f50284b);
                                        return true;
                                    } else if (j.a(a2)) {
                                        j.a(context, a2);
                                        aa aaVar33 = aa.f69597a;
                                        aa.a(a2.f50283a, a2.f50284b);
                                        return true;
                                    } else {
                                        g gVar = g.f50348a;
                                        if (g.a(a2)) {
                                            g gVar2 = g.f50348a;
                                            g.a(context, a2);
                                            aa aaVar34 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        v vVar = v.f50378a;
                                        if (v.a(a2)) {
                                            v vVar2 = v.f50378a;
                                            v.a(context, a2);
                                            aa aaVar35 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        ad adVar = ad.f50306a;
                                        if (ad.a(a2)) {
                                            ad adVar2 = ad.f50306a;
                                            ad.a(context, a2);
                                            aa aaVar36 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        ai aiVar = ai.f50315a;
                                        if (ai.a(context, a2)) {
                                            ai aiVar2 = ai.f50315a;
                                            ai.b(context, a2);
                                            aa aaVar37 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        aa aaVar38 = aa.f50292a;
                                        if (aa.a(a2)) {
                                            aa aaVar39 = aa.f50292a;
                                            aa.a(context, a2);
                                            aa aaVar40 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        ag.a();
                                        if (ag.a(a2)) {
                                            ag.a(context, a2);
                                            aa aaVar41 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        t tVar = t.f50368a;
                                        if (t.a(context, a2)) {
                                            t tVar2 = t.f50368a;
                                            t.b(context, a2);
                                            aa aaVar42 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        ah ahVar = ah.f50314a;
                                        if (ah.a(a2)) {
                                            ah ahVar2 = ah.f50314a;
                                            ah.a(context, a2);
                                            aa aaVar43 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        f fVar = f.f50341a;
                                        if (f.a(a2)) {
                                            if (bundle != null) {
                                                a2.f50290h = bundle;
                                            }
                                            f fVar2 = f.f50341a;
                                            f.a(context, a2);
                                            aa aaVar44 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        r rVar = r.f50366a;
                                        if (r.a(a2)) {
                                            r rVar2 = r.f50366a;
                                            r.a(context, a2);
                                            aa aaVar45 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        af afVar = af.f50311a;
                                        if (af.a(a2)) {
                                            af afVar2 = af.f50311a;
                                            af.a(context, a2);
                                            aa aaVar46 = aa.f69597a;
                                            aa.a(a2.f50283a, a2.f50284b);
                                            return true;
                                        }
                                        au.e eVar3 = new au.e();
                                        au.b bVar = new au.b();
                                        bVar.f69677a = a2.f50283a;
                                        bVar.f69679c = a2.f50284b;
                                        if (bundle == null) {
                                            bVar.f69680d = false;
                                        }
                                        eVar3.y = bVar;
                                        eVar3.f69690e = au.c.DeepLinkLog.stringValue;
                                        if (a2.f50283a != null) {
                                            CharSequence charSequence2 = a2.f50283a;
                                            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                                                z = false;
                                            }
                                            if (!z && !"open".equals(a2.f50284b)) {
                                                t tVar3 = t.f50368a;
                                                t.a(context);
                                                aa aaVar47 = aa.f69597a;
                                                aa.a(a2.f50283a, a2.f50284b);
                                                return false;
                                            }
                                        }
                                        au.a(eVar3, au.c.DeepLinkLog.stringValue, context);
                                        aa aaVar472 = aa.f69597a;
                                        aa.a(a2.f50283a, a2.f50284b);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                aa aaVar48 = aa.f69597a;
                aa.b();
                return false;
            }
        }
    }
}
