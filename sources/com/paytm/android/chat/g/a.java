package com.paytm.android.chat.g;

import androidx.recyclerview.widget.h;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse;
import com.sendbird.android.FileMessage;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class a implements com.paytm.android.chat.base.e {
    private a() {
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    /* renamed from: com.paytm.android.chat.g.a$a  reason: collision with other inner class name */
    public static final class C0697a extends a {

        /* renamed from: a  reason: collision with root package name */
        public final ChatGroupChannelDataModel f42101a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof C0697a) && kotlin.g.b.k.a((Object) this.f42101a, (Object) ((C0697a) obj).f42101a);
            }
            return true;
        }

        public final int hashCode() {
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42101a;
            if (chatGroupChannelDataModel != null) {
                return chatGroupChannelDataModel.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "ChannelUpdateState(chatGroupChannelDataModel=" + this.f42101a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0697a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
            super((byte) 0);
            kotlin.g.b.k.c(chatGroupChannelDataModel, "chatGroupChannelDataModel");
            this.f42101a = chatGroupChannelDataModel;
        }
    }

    public static final class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f42108a = true;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && this.f42108a == ((d) obj).f42108a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42108a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "FinishActivityState(finish=" + this.f42108a + ")";
        }

        public d() {
            super((byte) 0);
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42106a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && this.f42106a == ((b) obj).f42106a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42106a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "EnablePushState(enable=" + this.f42106a + ")";
        }

        public b(boolean z) {
            super((byte) 0);
            this.f42106a = z;
        }
    }

    public static final class j extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f42121a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof j) && kotlin.g.b.k.a((Object) this.f42121a, (Object) ((j) obj).f42121a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42121a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "P4BMemberIdSetState(id=" + this.f42121a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "id");
            this.f42121a = str;
        }
    }

    public static final class aa extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f42102a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof aa) && kotlin.g.b.k.a((Object) this.f42102a, (Object) ((aa) obj).f42102a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42102a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "UserNameState(userName=" + this.f42102a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public aa(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "userName");
            this.f42102a = str;
        }
    }

    public static final class z extends a {

        /* renamed from: a  reason: collision with root package name */
        public final ChatUserDataModel f42140a;

        /* renamed from: b  reason: collision with root package name */
        public final ChatGroupChannelDataModel f42141b;

        /* renamed from: c  reason: collision with root package name */
        public final com.paytm.android.chat.e.c f42142c;

        /* renamed from: d  reason: collision with root package name */
        private final GetUserInfoByIdsResponse f42143d;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof z)) {
                return false;
            }
            z zVar = (z) obj;
            return kotlin.g.b.k.a((Object) this.f42140a, (Object) zVar.f42140a) && kotlin.g.b.k.a((Object) this.f42141b, (Object) zVar.f42141b) && kotlin.g.b.k.a((Object) this.f42142c, (Object) zVar.f42142c) && kotlin.g.b.k.a((Object) this.f42143d, (Object) zVar.f42143d);
        }

        public final int hashCode() {
            ChatUserDataModel chatUserDataModel = this.f42140a;
            int i2 = 0;
            int hashCode = (chatUserDataModel != null ? chatUserDataModel.hashCode() : 0) * 31;
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42141b;
            int hashCode2 = (hashCode + (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0)) * 31;
            com.paytm.android.chat.e.c cVar = this.f42142c;
            int hashCode3 = (hashCode2 + (cVar != null ? cVar.hashCode() : 0)) * 31;
            GetUserInfoByIdsResponse getUserInfoByIdsResponse = this.f42143d;
            if (getUserInfoByIdsResponse != null) {
                i2 = getUserInfoByIdsResponse.hashCode();
            }
            return hashCode3 + i2;
        }

        public final String toString() {
            return "UserInfoState(user=" + this.f42140a + ", channel=" + this.f42141b + ", listener=" + this.f42142c + ", userInfo=" + this.f42143d + ")";
        }

        public z(ChatUserDataModel chatUserDataModel, ChatGroupChannelDataModel chatGroupChannelDataModel, com.paytm.android.chat.e.c cVar, GetUserInfoByIdsResponse getUserInfoByIdsResponse) {
            super((byte) 0);
            this.f42140a = chatUserDataModel;
            this.f42141b = chatGroupChannelDataModel;
            this.f42142c = cVar;
            this.f42143d = getUserInfoByIdsResponse;
        }
    }

    public static final class y extends a {

        /* renamed from: a  reason: collision with root package name */
        public final ChatGroupChannelDataModel f42139a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof y) && kotlin.g.b.k.a((Object) this.f42139a, (Object) ((y) obj).f42139a);
            }
            return true;
        }

        public final int hashCode() {
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42139a;
            if (chatGroupChannelDataModel != null) {
                return chatGroupChannelDataModel.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "UpdateBottomBarState(chatGroupChannelDataModel=" + this.f42139a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(ChatGroupChannelDataModel chatGroupChannelDataModel) {
            super((byte) 0);
            kotlin.g.b.k.c(chatGroupChannelDataModel, "chatGroupChannelDataModel");
            this.f42139a = chatGroupChannelDataModel;
        }
    }

    public static final class t extends a {

        /* renamed from: a  reason: collision with root package name */
        private final String f42134a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof t) && kotlin.g.b.k.a((Object) this.f42134a, (Object) ((t) obj).f42134a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42134a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "ShowInviteViewState(userName=" + this.f42134a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "userName");
            this.f42134a = str;
        }
    }

    public static final class s extends a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42133a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof s) && this.f42133a == ((s) obj).f42133a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42133a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "ShowFirstTimeChatQuickReplies(show=" + this.f42133a + ")";
        }

        public s(boolean z) {
            super((byte) 0);
            this.f42133a = z;
        }
    }

    public static final class p extends a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42129a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f42130b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            return this.f42129a == pVar.f42129a && kotlin.g.b.k.a((Object) this.f42130b, (Object) pVar.f42130b);
        }

        public final int hashCode() {
            boolean z = this.f42129a;
            if (z) {
                z = true;
            }
            int i2 = (z ? 1 : 0) * true;
            String[] strArr = this.f42130b;
            return i2 + (strArr != null ? Arrays.hashCode(strArr) : 0);
        }

        public final String toString() {
            return "SetQuickReplyState(isVisible=" + this.f42129a + ", replies=" + Arrays.toString(this.f42130b) + ")";
        }

        public p(boolean z, String[] strArr) {
            super((byte) 0);
            this.f42129a = z;
            this.f42130b = strArr;
        }
    }

    public static final class f extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f42110a;

        /* renamed from: b  reason: collision with root package name */
        public final String f42111b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return kotlin.g.b.k.a((Object) this.f42110a, (Object) fVar.f42110a) && kotlin.g.b.k.a((Object) this.f42111b, (Object) fVar.f42111b);
        }

        public final int hashCode() {
            String str = this.f42110a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f42111b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "MessageSendingFailedState(type=" + this.f42110a + ", messageType=" + this.f42111b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, String str2) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "type");
            kotlin.g.b.k.c(str2, "messageType");
            this.f42110a = str;
            this.f42111b = str2;
        }
    }

    public static final class u extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f42135a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof u) && kotlin.g.b.k.a((Object) this.f42135a, (Object) ((u) obj).f42135a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f42135a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "ShowToastState(message=" + this.f42135a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(String str) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "message");
            this.f42135a = str;
        }
    }

    public static final class g extends a {

        /* renamed from: a  reason: collision with root package name */
        public final int f42112a = 0;

        /* renamed from: b  reason: collision with root package name */
        public final String f42113b;

        /* renamed from: c  reason: collision with root package name */
        public final String f42114c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f42112a == gVar.f42112a && kotlin.g.b.k.a((Object) this.f42113b, (Object) gVar.f42113b) && kotlin.g.b.k.a((Object) this.f42114c, (Object) gVar.f42114c);
        }

        public final int hashCode() {
            int i2 = this.f42112a * 31;
            String str = this.f42113b;
            int i3 = 0;
            int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f42114c;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return hashCode + i3;
        }

        public final String toString() {
            return "MessageSentState(charCount=" + this.f42112a + ", type=" + this.f42113b + ", messageType=" + this.f42114c + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str, String str2) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "type");
            kotlin.g.b.k.c(str2, "messageType");
            this.f42113b = str;
            this.f42114c = str2;
        }
    }

    public static final class q extends a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42131a = false;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof q) && this.f42131a == ((q) obj).f42131a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42131a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "SetRefreshingState(flag=" + this.f42131a + ")";
        }

        public q() {
            super((byte) 0);
        }
    }

    public static final class l extends a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f42124a = true;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof l) && this.f42124a == ((l) obj).f42124a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42124a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "RefreshAdapterState(refresh=" + this.f42124a + ")";
        }

        public l() {
            super((byte) 0);
        }
    }

    public static final class v extends a {

        /* renamed from: a  reason: collision with root package name */
        public final int f42136a = 0;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof v) && this.f42136a == ((v) obj).f42136a;
            }
            return true;
        }

        public final int hashCode() {
            return this.f42136a;
        }

        public final String toString() {
            return "SmoothScrollToPosState(position=" + this.f42136a + ")";
        }

        public v() {
            super((byte) 0);
        }
    }

    public static final class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f42109a = true;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof e) && this.f42109a == ((e) obj).f42109a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42109a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "ForwardSuccessState(flag=" + this.f42109a + ")";
        }

        public e() {
            super((byte) 0);
        }
    }

    public static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private final int f42107a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && this.f42107a == ((c) obj).f42107a;
            }
            return true;
        }

        public final int hashCode() {
            return this.f42107a;
        }

        public final String toString() {
            return "ErrorState(errorCode=" + this.f42107a + ")";
        }

        public c(int i2) {
            super((byte) 0);
            this.f42107a = i2;
        }
    }

    public static final class r extends a {

        /* renamed from: a  reason: collision with root package name */
        public final FileMessage f42132a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof r) && kotlin.g.b.k.a((Object) this.f42132a, (Object) ((r) obj).f42132a);
            }
            return true;
        }

        public final int hashCode() {
            FileMessage fileMessage = this.f42132a;
            if (fileMessage != null) {
                return fileMessage.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "ShowDownloadConfirmState(fileMessage=" + this.f42132a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(FileMessage fileMessage) {
            super((byte) 0);
            kotlin.g.b.k.c(fileMessage, "fileMessage");
            this.f42132a = fileMessage;
        }
    }

    public static final class m extends a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f42125a = true;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof m) && this.f42125a == ((m) obj).f42125a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42125a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "RequestMemoryPermissionState(flag=" + this.f42125a + ")";
        }

        public m() {
            super((byte) 0);
        }
    }

    public static final class n extends a {

        /* renamed from: a  reason: collision with root package name */
        private final FileMessage f42126a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof n) && kotlin.g.b.k.a((Object) this.f42126a, (Object) ((n) obj).f42126a);
            }
            return true;
        }

        public final int hashCode() {
            FileMessage fileMessage = this.f42126a;
            if (fileMessage != null) {
                return fileMessage.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "SetDownImageSuccessState(fileMessage=" + this.f42126a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(FileMessage fileMessage) {
            super((byte) 0);
            kotlin.g.b.k.c(fileMessage, "fileMessage");
            this.f42126a = fileMessage;
        }
    }

    public static final class x extends a {

        /* renamed from: a  reason: collision with root package name */
        public final File f42138a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof x) && kotlin.g.b.k.a((Object) this.f42138a, (Object) ((x) obj).f42138a);
            }
            return true;
        }

        public final int hashCode() {
            File file = this.f42138a;
            if (file != null) {
                return file.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "UpGalleryState(file=" + this.f42138a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(File file) {
            super((byte) 0);
            kotlin.g.b.k.c(file, CommunityPostActivity.TYPE_FILE);
            this.f42138a = file;
        }
    }

    public static final class o extends a {

        /* renamed from: a  reason: collision with root package name */
        public final int f42127a;

        /* renamed from: b  reason: collision with root package name */
        public final FileMessage f42128b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return this.f42127a == oVar.f42127a && kotlin.g.b.k.a((Object) this.f42128b, (Object) oVar.f42128b);
        }

        public final int hashCode() {
            int i2 = this.f42127a * 31;
            FileMessage fileMessage = this.f42128b;
            return i2 + (fileMessage != null ? fileMessage.hashCode() : 0);
        }

        public final String toString() {
            return "SetDownProgressState(progress=" + this.f42127a + ", message=" + this.f42128b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(int i2, FileMessage fileMessage) {
            super((byte) 0);
            kotlin.g.b.k.c(fileMessage, "message");
            this.f42127a = i2;
            this.f42128b = fileMessage;
        }
    }

    public static final class ab extends a {

        /* renamed from: a  reason: collision with root package name */
        public final File f42103a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof ab) && kotlin.g.b.k.a((Object) this.f42103a, (Object) ((ab) obj).f42103a);
            }
            return true;
        }

        public final int hashCode() {
            File file = this.f42103a;
            if (file != null) {
                return file.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "WatchFileState(file=" + this.f42103a + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ab(File file) {
            super((byte) 0);
            kotlin.g.b.k.c(file, CommunityPostActivity.TYPE_FILE);
            this.f42103a = file;
        }
    }

    public static final class ac extends a {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<com.zhihu.matisse.a.a> f42104a;

        /* renamed from: b  reason: collision with root package name */
        public final int f42105b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ac)) {
                return false;
            }
            ac acVar = (ac) obj;
            return kotlin.g.b.k.a((Object) this.f42104a, (Object) acVar.f42104a) && this.f42105b == acVar.f42105b;
        }

        public final int hashCode() {
            ArrayList<com.zhihu.matisse.a.a> arrayList = this.f42104a;
            return ((arrayList != null ? arrayList.hashCode() : 0) * 31) + this.f42105b;
        }

        public final String toString() {
            return "WatchImageState(imageBeans=" + this.f42104a + ", position=" + this.f42105b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ac(ArrayList<com.zhihu.matisse.a.a> arrayList, int i2) {
            super((byte) 0);
            kotlin.g.b.k.c(arrayList, "imageBeans");
            this.f42104a = arrayList;
            this.f42105b = i2;
        }
    }

    public static final class h extends a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f42115a = true;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof h) && this.f42115a == ((h) obj).f42115a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42115a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "NoState(doNothing=" + this.f42115a + ")";
        }

        public h() {
            super((byte) 0);
        }
    }

    public static final class i extends a {

        /* renamed from: a  reason: collision with root package name */
        public final ChatGroupChannelDataModel f42116a;

        /* renamed from: b  reason: collision with root package name */
        public final List<ChatMessageDataModel> f42117b;

        /* renamed from: c  reason: collision with root package name */
        public final h.b f42118c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f42119d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f42120e;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return kotlin.g.b.k.a((Object) this.f42116a, (Object) iVar.f42116a) && kotlin.g.b.k.a((Object) this.f42117b, (Object) iVar.f42117b) && kotlin.g.b.k.a((Object) this.f42118c, (Object) iVar.f42118c) && this.f42119d == iVar.f42119d && this.f42120e == iVar.f42120e;
        }

        public final int hashCode() {
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42116a;
            int i2 = 0;
            int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
            List<ChatMessageDataModel> list = this.f42117b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            h.b bVar = this.f42118c;
            if (bVar != null) {
                i2 = bVar.hashCode();
            }
            int i3 = (hashCode2 + i2) * 31;
            boolean z = this.f42119d;
            if (z) {
                z = true;
            }
            int i4 = (i3 + (z ? 1 : 0)) * 31;
            boolean z2 = this.f42120e;
            if (z2) {
                z2 = true;
            }
            return i4 + (z2 ? 1 : 0);
        }

        public final String toString() {
            return "NotifyDataSetChangedState(channel=" + this.f42116a + ", newList=" + this.f42117b + ", diffResult=" + this.f42118c + ", isSentByMe=" + this.f42119d + ", autoScroll=" + this.f42120e + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ChatGroupChannelDataModel chatGroupChannelDataModel, List<? extends ChatMessageDataModel> list, h.b bVar, boolean z, boolean z2) {
            super((byte) 0);
            kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
            kotlin.g.b.k.c(list, "newList");
            this.f42116a = chatGroupChannelDataModel;
            this.f42117b = list;
            this.f42118c = bVar;
            this.f42119d = z;
            this.f42120e = z2;
        }
    }

    public static final class w extends a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42137a = false;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof w) && this.f42137a == ((w) obj).f42137a;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.f42137a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            return "ToggleLoadingState(flag=" + this.f42137a + ")";
        }

        public w() {
            super((byte) 0);
        }
    }

    public static final class k extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f42122a;

        /* renamed from: b  reason: collision with root package name */
        public final String f42123b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return kotlin.g.b.k.a((Object) this.f42122a, (Object) kVar.f42122a) && kotlin.g.b.k.a((Object) this.f42123b, (Object) kVar.f42123b);
        }

        public final int hashCode() {
            String str = this.f42122a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f42123b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "PlayAudioState(audioUrl=" + this.f42122a + ", messageId=" + this.f42123b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str, String str2) {
            super((byte) 0);
            kotlin.g.b.k.c(str, "audioUrl");
            kotlin.g.b.k.c(str2, "messageId");
            this.f42122a = str;
            this.f42123b = str2;
        }
    }
}
