package kotlin.m;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.g.a.b;
import kotlin.g.b.l;
import kotlin.j.d;
import kotlin.j.e;
import kotlin.l.g;

final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final h f47990a = new a(this);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Matcher f47991b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f47992c;

    public k(Matcher matcher, CharSequence charSequence) {
        kotlin.g.b.k.d(matcher, "matcher");
        kotlin.g.b.k.d(charSequence, "input");
        this.f47991b = matcher;
        this.f47992c = charSequence;
    }

    public static final class a extends kotlin.a.a<g> implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f47993a;

        public final boolean isEmpty() {
            return false;
        }

        /* renamed from: kotlin.m.k$a$a  reason: collision with other inner class name */
        static final class C0838a extends l implements b<Integer, g> {
            final /* synthetic */ a this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0838a(a aVar) {
                super(1);
                this.this$0 = aVar;
            }

            public final /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final g invoke(int i2) {
                a aVar = this.this$0;
                MatchResult a2 = aVar.f47993a.f47991b;
                d a3 = e.a(a2.start(i2), a2.end(i2));
                if (a3.f47939a < 0) {
                    return null;
                }
                String group = aVar.f47993a.f47991b.group(i2);
                kotlin.g.b.k.b(group, "matchResult.group(index)");
                return new g(group, a3);
            }
        }

        a(k kVar) {
            this.f47993a = kVar;
        }

        public final /* bridge */ boolean contains(Object obj) {
            boolean z;
            if (obj != null) {
                z = obj instanceof g;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            return super.contains((g) obj);
        }

        public final int a() {
            return this.f47993a.f47991b.groupCount() + 1;
        }

        public final Iterator<g> iterator() {
            return g.a(kotlin.a.k.k(kotlin.a.k.a((Collection<?>) this)), new C0838a(this)).a();
        }
    }

    public final d a() {
        MatchResult matchResult = this.f47991b;
        return e.a(matchResult.start(), matchResult.end());
    }

    public final String b() {
        String group = this.f47991b.group();
        kotlin.g.b.k.b(group, "matchResult.group()");
        return group;
    }

    public final j c() {
        int end = this.f47991b.end() + (this.f47991b.end() == this.f47991b.start() ? 1 : 0);
        if (end > this.f47992c.length()) {
            return null;
        }
        Matcher matcher = this.f47991b.pattern().matcher(this.f47992c);
        kotlin.g.b.k.b(matcher, "matcher.pattern().matcher(input)");
        return m.a(matcher, end, this.f47992c);
    }
}
