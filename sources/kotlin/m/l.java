package kotlin.m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a.r;
import kotlin.g.b.j;
import kotlin.g.b.k;
import kotlin.j.e;
import kotlin.m.m;

public final class l implements Serializable {
    public static final a Companion = new a((byte) 0);
    private Set<? extends n> _options;
    private final Pattern nativePattern;

    public l(Pattern pattern) {
        k.d(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.g.b.k.d(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.g.b.k.b(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.m.l.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(java.lang.String r2, kotlin.m.n r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.g.b.k.d(r2, r0)
            java.lang.String r0 = "option"
            kotlin.g.b.k.d(r3, r0)
            int r3 = r3.getValue()
            int r3 = kotlin.m.l.a.a(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.g.b.k.b(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.m.l.<init>(java.lang.String, kotlin.m.n):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(java.lang.String r2, java.util.Set<? extends kotlin.m.n> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.g.b.k.d(r2, r0)
            java.lang.String r0 = "options"
            kotlin.g.b.k.d(r3, r0)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            int r3 = kotlin.m.m.a(r3)
            int r3 = kotlin.m.l.a.a(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            kotlin.g.b.k.b(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.m.l.<init>(java.lang.String, java.util.Set):void");
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        k.b(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final Set<n> getOptions() {
        Set<? extends n> set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet<E> allOf = EnumSet.allOf(n.class);
        Iterable iterable = allOf;
        kotlin.g.a.b aVar = new m.a(flags);
        k.d(iterable, "$this$retainAll");
        k.d(aVar, "predicate");
        r.a(iterable, aVar, false);
        Set<? extends n> unmodifiableSet = Collections.unmodifiableSet(allOf);
        k.b(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final boolean matches(CharSequence charSequence) {
        k.d(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        k.d(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public static /* synthetic */ j find$default(l lVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lVar.find(charSequence, i2);
    }

    public final j find(CharSequence charSequence, int i2) {
        k.d(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        k.b(matcher, "nativePattern.matcher(input)");
        return m.a(matcher, i2, charSequence);
    }

    public static /* synthetic */ kotlin.l.d findAll$default(l lVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lVar.findAll(charSequence, i2);
    }

    public final kotlin.l.d<j> findAll(CharSequence charSequence, int i2) {
        k.d(charSequence, "input");
        if (i2 < 0 || i2 > charSequence.length()) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + i2 + ", input length: " + charSequence.length());
        }
        kotlin.g.a.a cVar = new c(this, charSequence, i2);
        kotlin.g.a.b bVar = d.INSTANCE;
        k.d(cVar, "seedFunction");
        k.d(bVar, "nextFunction");
        return new kotlin.l.c<>(cVar, bVar);
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.a<j> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;
        final /* synthetic */ l this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(l lVar, CharSequence charSequence, int i2) {
            super(0);
            this.this$0 = lVar;
            this.$input = charSequence;
            this.$startIndex = i2;
        }

        public final j invoke() {
            return this.this$0.find(this.$input, this.$startIndex);
        }
    }

    static final /* synthetic */ class d extends j implements kotlin.g.a.b<j, j> {
        public static final d INSTANCE = new d();

        d() {
            super(1, j.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        public final j invoke(j jVar) {
            k.d(jVar, "p1");
            return jVar.c();
        }
    }

    public final j matchEntire(CharSequence charSequence) {
        k.d(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        k.b(matcher, "nativePattern.matcher(input)");
        return !matcher.matches() ? null : new k(matcher, charSequence);
    }

    public final String replace(CharSequence charSequence, String str) {
        k.d(charSequence, "input");
        k.d(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        k.b(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replace(CharSequence charSequence, kotlin.g.a.b<? super j, ? extends CharSequence> bVar) {
        k.d(charSequence, "input");
        k.d(bVar, "transform");
        int i2 = 0;
        j find$default = find$default(this, charSequence, 0, 2, (Object) null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            k.a((Object) find$default);
            sb.append(charSequence, i2, find$default.a().f47939a);
            sb.append((CharSequence) bVar.invoke(find$default));
            i2 = find$default.a().f47940b + 1;
            find$default = find$default.c();
            if (i2 >= length) {
                break;
            }
        } while (find$default != null);
        if (i2 < length) {
            sb.append(charSequence, i2, length);
        }
        String sb2 = sb.toString();
        k.b(sb2, "sb.toString()");
        return sb2;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        k.d(charSequence, "input");
        k.d(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        k.b(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public static /* synthetic */ List split$default(l lVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lVar.split(charSequence, i2);
    }

    public final List<String> split(CharSequence charSequence, int i2) {
        k.d(charSequence, "input");
        int i3 = 0;
        if (i2 >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (!matcher.find() || i2 == 1) {
                return kotlin.a.k.a(charSequence.toString());
            }
            int i4 = 10;
            if (i2 > 0) {
                i4 = e.c(i2, 10);
            }
            ArrayList arrayList = new ArrayList(i4);
            int i5 = i2 - 1;
            do {
                arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
                i3 = matcher.end();
                if ((i5 >= 0 && arrayList.size() == i5) || !matcher.find()) {
                    arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
                i3 = matcher.end();
                break;
            } while (!matcher.find());
            arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public final String toString() {
        String pattern = this.nativePattern.toString();
        k.b(pattern, "nativePattern.toString()");
        return pattern;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        k.b(pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    static final class b implements Serializable {
        public static final a Companion = new a((byte) 0);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public b(String str, int i2) {
            k.d(str, "pattern");
            this.pattern = str;
            this.flags = i2;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            k.b(compile, "Pattern.compile(pattern, flags)");
            return new l(compile);
        }
    }

    public static final class a {
        static int a(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
