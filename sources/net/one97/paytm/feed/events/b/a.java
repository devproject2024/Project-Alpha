package net.one97.paytm.feed.events.b;

import kotlin.g.b.k;
import net.one97.paytm.feed.events.models.BaseEventDTO;
import net.one97.paytm.feed.events.models.MetaInfo;

public final class a extends BaseEventDTO {

    /* renamed from: a  reason: collision with root package name */
    public static final C0560a f34338a = new C0560a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f34339c = f34339c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f34340d = f34340d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f34341e = f34341e;

    /* renamed from: b  reason: collision with root package name */
    private String f34342b = this.f34342b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, String str2, String str3, MetaInfo metaInfo, String str4) {
        super(str, str2, (String) null, str3, metaInfo, str4);
        k.c(str, "userId");
    }

    /* renamed from: net.one97.paytm.feed.events.b.a$a  reason: collision with other inner class name */
    public static final class C0560a {
        private C0560a() {
        }

        public /* synthetic */ C0560a(byte b2) {
            this();
        }
    }
}
