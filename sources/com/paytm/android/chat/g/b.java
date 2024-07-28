package com.paytm.android.chat.g;

import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import kotlin.g.b.k;

public abstract class b implements com.paytm.android.chat.base.e {

    public static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        public final int f42147a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && this.f42147a == ((d) obj).f42147a;
            }
            return true;
        }

        public final int hashCode() {
            return this.f42147a;
        }

        public final String toString() {
            return "FinishState(returnResult=" + this.f42147a + ")";
        }

        private d() {
            super((byte) 0);
            this.f42147a = -1;
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    private b() {
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final int f42144a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && this.f42144a == ((a) obj).f42144a;
            }
            return true;
        }

        public final int hashCode() {
            return this.f42144a;
        }

        public final String toString() {
            return "ActivitySetResultState(result=" + this.f42144a + ")";
        }

        public a(int i2) {
            super((byte) 0);
            this.f42144a = i2;
        }
    }

    public static final class g extends b {

        /* renamed from: a  reason: collision with root package name */
        public final ChatGroupChannelDataModel f42154a;

        /* renamed from: b  reason: collision with root package name */
        public final ChatUserEntity.ChatPaymentMetadata f42155b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return k.a((Object) this.f42154a, (Object) gVar.f42154a) && k.a((Object) this.f42155b, (Object) gVar.f42155b);
        }

        public final int hashCode() {
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42154a;
            int i2 = 0;
            int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
            ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata = this.f42155b;
            if (chatPaymentMetadata != null) {
                i2 = chatPaymentMetadata.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "RenderProfilePageState(channel=" + this.f42154a + ", receiverChatPaymentMetadata=" + this.f42155b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ChatGroupChannelDataModel chatGroupChannelDataModel, ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata) {
            super((byte) 0);
            k.c(chatGroupChannelDataModel, "channel");
            this.f42154a = chatGroupChannelDataModel;
            this.f42155b = chatPaymentMetadata;
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42151a;

        /* renamed from: b  reason: collision with root package name */
        public final ChatGroupChannelDataModel f42152b;

        /* renamed from: c  reason: collision with root package name */
        public final String f42153c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f42151a == fVar.f42151a && k.a((Object) this.f42152b, (Object) fVar.f42152b) && k.a((Object) this.f42153c, (Object) fVar.f42153c);
        }

        public final int hashCode() {
            boolean z = this.f42151a;
            if (z) {
                z = true;
            }
            int i2 = (z ? 1 : 0) * true;
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42152b;
            int i3 = 0;
            int hashCode = (i2 + (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0)) * 31;
            String str = this.f42153c;
            if (str != null) {
                i3 = str.hashCode();
            }
            return hashCode + i3;
        }

        public final String toString() {
            return "MuteSuccessState(on=" + this.f42151a + ", channel=" + this.f42152b + ", name=" + this.f42153c + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel, String str) {
            super((byte) 0);
            k.c(chatGroupChannelDataModel, "channel");
            this.f42151a = z;
            this.f42152b = chatGroupChannelDataModel;
            this.f42153c = str;
        }
    }

    public static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42148a;

        /* renamed from: b  reason: collision with root package name */
        public final String f42149b;

        /* renamed from: c  reason: collision with root package name */
        private final ChatGroupChannelDataModel f42150c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f42148a == eVar.f42148a && k.a((Object) this.f42150c, (Object) eVar.f42150c) && k.a((Object) this.f42149b, (Object) eVar.f42149b);
        }

        public final int hashCode() {
            boolean z = this.f42148a;
            if (z) {
                z = true;
            }
            int i2 = (z ? 1 : 0) * true;
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42150c;
            int i3 = 0;
            int hashCode = (i2 + (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0)) * 31;
            String str = this.f42149b;
            if (str != null) {
                i3 = str.hashCode();
            }
            return hashCode + i3;
        }

        public final String toString() {
            return "MuteErrorState(on=" + this.f42148a + ", channel=" + this.f42150c + ", name=" + this.f42149b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel, String str) {
            super((byte) 0);
            k.c(chatGroupChannelDataModel, "channel");
            this.f42148a = z;
            this.f42150c = chatGroupChannelDataModel;
            this.f42149b = str;
        }
    }

    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public final String f42146a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && k.a((Object) this.f42146a, (Object) ((c) obj).f42146a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42146a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "BlockSuccessState(name=" + this.f42146a + ")";
        }

        public c(String str) {
            super((byte) 0);
            this.f42146a = str;
        }
    }

    /* renamed from: com.paytm.android.chat.g.b$b  reason: collision with other inner class name */
    public static final class C0698b extends b {

        /* renamed from: a  reason: collision with root package name */
        public final String f42145a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof C0698b) && k.a((Object) this.f42145a, (Object) ((C0698b) obj).f42145a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42145a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "BlockErrorState(name=" + this.f42145a + ")";
        }

        public C0698b(String str) {
            super((byte) 0);
            this.f42145a = str;
        }
    }

    public static final class j extends b {

        /* renamed from: a  reason: collision with root package name */
        public final String f42158a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof j) && k.a((Object) this.f42158a, (Object) ((j) obj).f42158a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42158a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "UnblockSuccessState(name=" + this.f42158a + ")";
        }

        public j(String str) {
            super((byte) 0);
            this.f42158a = str;
        }
    }

    public static final class i extends b {

        /* renamed from: a  reason: collision with root package name */
        private final String f42157a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof i) && k.a((Object) this.f42157a, (Object) ((i) obj).f42157a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42157a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "UnblockErrorState(name=" + this.f42157a + ")";
        }

        public i(String str) {
            super((byte) 0);
            this.f42157a = str;
        }
    }

    public static final class h extends b {

        /* renamed from: a  reason: collision with root package name */
        private final int f42156a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof h) && this.f42156a == ((h) obj).f42156a;
            }
            return true;
        }

        public final int hashCode() {
            return this.f42156a;
        }

        public final String toString() {
            return "SessionTimeoutState(errorCode=" + this.f42156a + ")";
        }

        public h(int i2) {
            super((byte) 0);
            this.f42156a = i2;
        }
    }
}
