package net.one97.paytm.feed.repository.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.x;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.FeedDBDeserializer;
import net.one97.paytm.feed.repository.db.a;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.feed.repository.models.Result;
import net.one97.paytm.feed.repository.models.bookmark.ResultBookmark;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.repository.models.comment.CommentResult;
import net.one97.paytm.feed.repository.models.cricket.FeedScore;
import net.one97.paytm.feed.repository.models.language.FeedLanguage;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.repository.models.livetv.ChannelCategories;
import net.one97.paytm.feed.repository.models.livetv.ChannelCategory;
import net.one97.paytm.feed.repository.models.livetv.ChannelsWrapper;
import net.one97.paytm.feed.repository.models.polls.PollsResponse;
import net.one97.paytm.feed.repository.models.profile.FeedProfile;
import net.one97.paytm.feed.repository.models.profile.Following;
import net.one97.paytm.feed.repository.models.provider.ProviderResult;
import net.one97.paytm.feed.repository.models.weather.FeedWeatherDetails;
import net.one97.paytm.feed.ui.feed.FeedFragment;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34365a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f34366b = new b();

    static final class a extends kotlin.g.b.l implements kotlin.g.a.b<List<? extends FeedItem>, kotlin.x> {
        final /* synthetic */ Context $it$inlined;
        final /* synthetic */ String $url;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Context context) {
            super(1);
            this.$url = str;
            this.$it$inlined = context;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends FeedItem>) (List) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(List<? extends FeedItem> list) {
            net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
            if (net.one97.paytm.feed.e.c.j()) {
                net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
                b a2 = net.one97.paytm.feed.c.a.a();
                Context context = this.$it$inlined;
                net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
                Context context2 = this.$it$inlined;
                String str = this.$url;
                FeedFragment.a aVar2 = FeedFragment.f34877i;
                String a3 = net.one97.paytm.feed.utility.l.a(context2, str, FeedFragment.C, "PREFETCH", "");
                FeedFragment.a aVar3 = FeedFragment.f34877i;
                b.a(a2, context, a3, FeedFragment.C, (kotlin.g.a.b) c.INSTANCE);
            }
        }
    }

    static {
        String simpleName = b.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "VolleyService::class.java.simpleName");
        f34365a = simpleName;
    }

    private b() {
    }

    public static String a() {
        return f34365a;
    }

    static final class aa<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34367a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34368b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34369c;

        aa(Context context, String str, kotlin.g.a.b bVar) {
            this.f34367a = context;
            this.f34368b = str;
            this.f34369c = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchFeed request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            b bVar3 = b.f34366b;
            Context context = this.f34367a;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            List a2 = b.a(context, jSONObject, this.f34368b);
            this.f34369c.invoke(a2);
            if (!a2.isEmpty()) {
                net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
                if (net.one97.paytm.feed.events.f.d()) {
                    net.one97.paytm.feed.events.f fVar2 = net.one97.paytm.feed.events.f.f34346d;
                    net.one97.paytm.feed.events.f.e();
                    net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                    net.one97.paytm.feed.repository.db.a.a(this.f34367a, (List<? extends FeedItem>) a2, this.f34368b);
                } else {
                    net.one97.paytm.feed.repository.db.a aVar2 = net.one97.paytm.feed.repository.db.a.f34614a;
                    net.one97.paytm.feed.repository.db.a.b(this.f34367a, (List<? extends FeedItem>) a2, this.f34368b);
                }
            }
            net.one97.paytm.feed.events.a.a aVar3 = net.one97.paytm.feed.events.a.a.f34296a;
            net.one97.paytm.feed.events.a.a.a("v2_feed_for_you_success", "for you screen");
        }
    }

    public static final class z extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34603a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34604b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f34605c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f34606d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34607e;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        z(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, android.content.Context r9, java.lang.String r10, kotlin.g.a.b r11, int r12, org.json.JSONObject r13, com.android.volley.Response.ErrorListener r14) {
            /*
                r6 = this;
                r6.f34603a = r7
                r6.f34604b = r8
                r6.f34605c = r9
                r6.f34606d = r10
                r6.f34607e = r11
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r12
                r4 = r13
                r5 = r14
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.z.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, android.content.Context, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            return b.b();
        }
    }

    static final class ab implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34370a;

        ab(kotlin.g.a.b bVar) {
            this.f34370a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            "fetchFeed request fail! Error : ".concat(String.valueOf(volleyError));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34370a.invoke(null);
        }
    }

    public final void a(Context context, String str, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "languages");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, "/content-users/v1/setUserlanguage/", (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ch chVar = new ch(this, str, b2, bVar, context, b2, new ci(bVar), new cj(bVar, context));
        chVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(chVar);
        }
    }

    public static final class ch extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34523b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34524c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34525d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f34526e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ch(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, java.lang.String r3, kotlin.g.a.b r4, android.content.Context r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34522a = r1
                r0.f34523b = r2
                r0.f34524c = r3
                r0.f34525d = r4
                r0.f34526e = r5
                r1 = 1
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ch.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("request body : ").append(this.f34523b);
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            Charset charset = kotlin.m.d.f47971a;
            String str = this.f34523b;
            if (str != null) {
                byte[] bytes = str.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class ci<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34527a;

        ci(kotlin.g.a.b bVar) {
            this.f34527a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/setLanguage request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34527a.invoke(str.toString());
            net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
            net.one97.paytm.feed.events.a.b bVar3 = net.one97.paytm.feed.events.a.b.f34303a;
            net.one97.paytm.feed.events.a.a.a(net.one97.paytm.feed.events.a.b.a(), "");
        }
    }

    static final class cj implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34529b;

        cj(kotlin.g.a.b bVar, Context context) {
            this.f34528a = bVar;
            this.f34529b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/setLanguage request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34528a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34529b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
            net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
            net.one97.paytm.feed.events.a.b bVar4 = net.one97.paytm.feed.events.a.b.f34303a;
            net.one97.paytm.feed.events.a.a.a(net.one97.paytm.feed.events.a.b.b(), "");
        }
    }

    public final void b(Context context, String str, kotlin.g.a.b<? super List<ChannelCategory>, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, "/content-channels/v1/channel_categories", (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        q qVar = new q(this, b2, bVar, b2, new r(bVar), new s(bVar));
        qVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(qVar);
        }
    }

    public static final class q extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34586a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34587b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34588c;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        q(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, kotlin.g.a.b r9, int r10, org.json.JSONObject r11, com.android.volley.Response.ErrorListener r12) {
            /*
                r6 = this;
                r6.f34586a = r7
                r6.f34587b = r8
                r6.f34588c = r9
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r10
                r4 = r11
                r5 = r12
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.q.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class r<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34589a;

        r(kotlin.g.a.b bVar) {
            this.f34589a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchCategories request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34589a;
            b bVar4 = b.f34366b;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            bVar3.invoke(b.a(jSONObject));
        }
    }

    static final class s implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34590a;

        s(kotlin.g.a.b bVar) {
            this.f34590a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/fetchCategories request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34590a.invoke(null);
        }
    }

    public final void c(Context context, String str, kotlin.g.a.b<? super List<Channel>, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, str, (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        t tVar = new t(this, b2, bVar, b2, new u(bVar), new v(bVar));
        tVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(tVar);
        }
    }

    public static final class t extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34591a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34592b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34593c;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        t(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, kotlin.g.a.b r9, int r10, org.json.JSONObject r11, com.android.volley.Response.ErrorListener r12) {
            /*
                r6 = this;
                r6.f34591a = r7
                r6.f34592b = r8
                r6.f34593c = r9
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r10
                r4 = r11
                r5 = r12
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.t.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class u<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34594a;

        u(kotlin.g.a.b bVar) {
            this.f34594a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchCategories request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34594a;
            b bVar4 = b.f34366b;
            bVar3.invoke(b.b(jSONObject));
        }
    }

    static final class v implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34595a;

        v(kotlin.g.a.b bVar) {
            this.f34595a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/fetchCategories request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34595a.invoke(null);
        }
    }

    public static final class bp extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34471a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34472b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34473c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34474d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f34475e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bp(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, android.content.Context r4, java.lang.String r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34471a = r1
                r0.f34472b = r2
                r0.f34473c = r3
                r0.f34474d = r4
                r0.f34475e = r5
                r1 = 1
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.bp.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    public static final class bq<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34476a;

        public bq(kotlin.g.a.b bVar) {
            this.f34476a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/postLike request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34476a.invoke(str.toString());
        }
    }

    public static final class br implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34478b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34479c;

        public br(Context context, String str, kotlin.g.a.b bVar) {
            this.f34477a = context;
            this.f34478b = str;
            this.f34479c = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postLike request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            net.one97.paytm.feed.repository.db.a.c(this.f34477a, this.f34478b);
            this.f34479c.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34477a, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class bs extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34480a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34481b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f34482c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34483d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f34484e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        bs(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, int r3, kotlin.g.a.b r4, android.content.Context r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34480a = r1
                r0.f34481b = r2
                r0.f34482c = r3
                r0.f34483d = r4
                r0.f34484e = r5
                r1 = 1
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.bs.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, int, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
            if (!TextUtils.isEmpty(net.one97.paytm.feed.e.c.d())) {
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String d2 = net.one97.paytm.feed.e.c.d();
                if (d2 != null) {
                    b2.put("session_token", d2);
                }
            }
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", this.f34481b);
            jSONObject.put("like", this.f34482c);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "jso.toString()");
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class bt<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34485a;

        bt(kotlin.g.a.b bVar) {
            this.f34485a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/postLikeMerchant request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34485a.invoke(str.toString());
        }
    }

    public final void a(Context context, String str, int i2, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "pID");
        kotlin.g.b.k.c(bVar, "completionHandler");
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        sb.append(net.one97.paytm.feed.e.b.m());
        sb.append("/feed/user/relation");
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        StringBuilder sb2 = new StringBuilder();
        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
        sb2.append(net.one97.paytm.feed.e.b.m());
        sb2.append("/feed/user/relation");
        bs bsVar = new bs(this, str, i2, bVar, context, sb2.toString(), new bt(bVar), new bu(context, str, bVar));
        bsVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(bsVar);
        }
    }

    static final class bu implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34487b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34488c;

        bu(Context context, String str, kotlin.g.a.b bVar) {
            this.f34486a = context;
            this.f34487b = str;
            this.f34488c = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postLikeMerchant request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            net.one97.paytm.feed.repository.db.a.c(this.f34486a, this.f34487b);
            this.f34488c.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34486a, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class by extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34497a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34498b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34499c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34500d;

        /* JADX WARNING: type inference failed for: r5v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public by(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, android.content.Context r4, int r5, com.android.volley.Response.Listener r6, com.android.volley.Response.ErrorListener r7) {
            /*
                r0 = this;
                r0.f34497a = r1
                r0.f34498b = r2
                r0.f34499c = r3
                r0.f34500d = r4
                r1 = 1
                r0.<init>(r1, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.by.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
            if (!TextUtils.isEmpty(net.one97.paytm.feed.e.c.d())) {
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String d2 = net.one97.paytm.feed.e.c.d();
                if (d2 != null) {
                    b2.put("session_token", d2);
                }
            }
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", this.f34498b);
            jSONObject.put("share", 1);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "jso.toString()");
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class bz<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34501a;

        public bz(kotlin.g.a.b bVar) {
            this.f34501a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/postShareFeedMerchant request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34501a.invoke(str.toString());
        }
    }

    public static final class ca implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34503a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34504b;

        public ca(kotlin.g.a.b bVar, Context context) {
            this.f34503a = bVar;
            this.f34504b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postShareFeedMerchant request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34503a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34504b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class cb extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34505a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34506b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34507c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34508d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f34509e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public cb(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, android.content.Context r4, java.lang.String r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34505a = r1
                r0.f34506b = r2
                r0.f34507c = r3
                r0.f34508d = r4
                r0.f34509e = r5
                r1 = 3
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.cb.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    public static final class cc<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34510a;

        public cc(kotlin.g.a.b bVar) {
            this.f34510a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/postUnLike request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34510a.invoke(str.toString());
        }
    }

    public static final class cd implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34511a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34512b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34513c;

        public cd(Context context, String str, kotlin.g.a.b bVar) {
            this.f34511a = context;
            this.f34512b = str;
            this.f34513c = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postUnLike request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            net.one97.paytm.feed.repository.db.a.b(this.f34511a, this.f34512b);
            this.f34513c.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34511a, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class bv extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34489a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34490b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34491c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34492d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f34493e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bv(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, java.lang.String r3, kotlin.g.a.b r4, android.content.Context r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34489a = r1
                r0.f34490b = r2
                r0.f34491c = r3
                r0.f34492d = r4
                r0.f34493e = r5
                r1 = 1
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.bv.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.f34490b);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "jso.toString()");
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class bw<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34494a;

        public bw(kotlin.g.a.b bVar) {
            this.f34494a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/postShare request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34494a.invoke(str.toString());
        }
    }

    public static final class bx implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34495a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34496b;

        public bx(kotlin.g.a.b bVar, Context context) {
            this.f34495a = bVar;
            this.f34496b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postShare request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34495a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34496b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class bm extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34463a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34464b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34465c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34466d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f34467e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bm(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, java.lang.String r3, kotlin.g.a.b r4, android.content.Context r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34463a = r1
                r0.f34464b = r2
                r0.f34465c = r3
                r0.f34466d = r4
                r0.f34467e = r5
                r1 = 1
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.bm.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.f34464b);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "jso.toString()");
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class bn<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34468a;

        public bn(kotlin.g.a.b bVar) {
            this.f34468a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/postFlag request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34468a.invoke(str.toString());
        }
    }

    public static final class bo implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34469a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34470b;

        public bo(kotlin.g.a.b bVar, Context context) {
            this.f34469a = bVar;
            this.f34470b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postFlag request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34469a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34470b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class w extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34596a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34597b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34598c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34599d;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public w(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, kotlin.g.a.b r9, android.content.Context r10, int r11, org.json.JSONObject r12, com.android.volley.Response.ErrorListener r13) {
            /*
                r6 = this;
                r6.f34596a = r7
                r6.f34597b = r8
                r6.f34598c = r9
                r6.f34599d = r10
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r11
                r4 = r12
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.w.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    public static final class x<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34600a;

        public x(kotlin.g.a.b bVar) {
            this.f34600a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchComments request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34600a;
            b bVar4 = b.f34366b;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            bVar3.invoke(b.c(jSONObject));
        }
    }

    public static final class y implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34601a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34602b;

        public y(kotlin.g.a.b bVar, Context context) {
            this.f34601a = bVar;
            this.f34602b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/fetchComments request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34601a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34602b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class bj extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34454a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34455b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34456c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f34457d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34458e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f34459f;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r5v1, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bj(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, kotlin.g.a.b r5, android.content.Context r6, int r7, org.json.JSONObject r8, com.android.volley.Response.ErrorListener r9) {
            /*
                r0 = this;
                r0.f34454a = r1
                r0.f34455b = r2
                r0.f34456c = r3
                r0.f34457d = r4
                r0.f34458e = r5
                r0.f34459f = r6
                r2 = 1
                r4 = 0
                r1 = r0
                r3 = r7
                r5 = r8
                r6 = r9
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.bj.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("postId", this.f34455b);
            jSONObject.put(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, this.f34456c);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "obj.toString()");
            Charset charset = kotlin.m.d.f47971a;
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class bk<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34460a;

        public bk(kotlin.g.a.b bVar) {
            this.f34460a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/postComment request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34460a.invoke(jSONObject.getString("result"));
        }
    }

    public static final class bl implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34461a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34462b;

        public bl(kotlin.g.a.b bVar, Context context) {
            this.f34461a = bVar;
            this.f34462b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postComment request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34461a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34462b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class k extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34570a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34571b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34572c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f34573d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34574e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f34575f;

        /* JADX WARNING: type inference failed for: r7v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public k(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, kotlin.g.a.b r5, android.content.Context r6, int r7, com.android.volley.Response.Listener r8, com.android.volley.Response.ErrorListener r9) {
            /*
                r0 = this;
                r0.f34570a = r1
                r0.f34571b = r2
                r0.f34572c = r3
                r0.f34573d = r4
                r0.f34574e = r5
                r0.f34575f = r6
                r1 = 7
                r0.<init>(r1, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.k.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("postId", this.f34571b);
            jSONObject.put(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, this.f34572c);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "jso.toString()");
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class l<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34576a;

        public l(kotlin.g.a.b bVar) {
            this.f34576a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/commentUpdate request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34576a.invoke(str);
        }
    }

    public static final class m implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34577a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34578b;

        public m(kotlin.g.a.b bVar, Context context) {
            this.f34577a = bVar;
            this.f34578b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/postDelete request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34577a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34578b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class e extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34552a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34553b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f34554c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f34555d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34556e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public e(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, android.content.Context r3, java.lang.String r4, kotlin.g.a.b r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34552a = r1
                r0.f34553b = r2
                r0.f34554c = r3
                r0.f34555d = r4
                r0.f34556e = r5
                r1 = 3
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.e.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, android.content.Context, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    public static final class f<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34557a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34558b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34559c;

        public f(Context context, String str, kotlin.g.a.b bVar) {
            this.f34557a = context;
            this.f34558b = str;
            this.f34559c = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/commentDelete request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            net.one97.paytm.feed.repository.db.a.a(this.f34557a, this.f34558b, false);
            this.f34559c.invoke(str);
            net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
            FeedCommentActivity.a aVar3 = FeedCommentActivity.f34935e;
            net.one97.paytm.feed.events.a.a.a("v2_eed_comment_delete", FeedCommentActivity.r);
        }
    }

    public static final class g implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34560a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34561b;

        public g(kotlin.g.a.b bVar, Context context) {
            this.f34560a = bVar;
            this.f34561b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/commentDelete request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34560a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34561b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class h extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34562a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34563b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34564c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34565d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f34566e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public h(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, java.lang.String r3, kotlin.g.a.b r4, android.content.Context r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34562a = r1
                r0.f34563b = r2
                r0.f34564c = r3
                r0.f34565d = r4
                r0.f34566e = r5
                r1 = 2
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.h.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.f34563b);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "jso.toString()");
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class i<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34567a;

        public i(kotlin.g.a.b bVar) {
            this.f34567a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/commentFlag request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34567a.invoke(str);
        }
    }

    public static final class j implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34568a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34569b;

        public j(kotlin.g.a.b bVar, Context context) {
            this.f34568a = bVar;
            this.f34569b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/commentFlag request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34568a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34569b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public final void b(Context context, String str, String str2, kotlin.g.a.b<? super FeedLanguage, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(str2, "baseURL");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, str, (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        au auVar = new au(this, b2, bVar, b2, new av(bVar), new aw(bVar));
        auVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(auVar, "lang");
        }
    }

    public static final class au extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34415a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34416b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34417c;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        au(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, kotlin.g.a.b r9, int r10, org.json.JSONObject r11, com.android.volley.Response.ErrorListener r12) {
            /*
                r6 = this;
                r6.f34415a = r7
                r6.f34416b = r8
                r6.f34417c = r9
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r10
                r4 = r11
                r5 = r12
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.au.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class av<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34418a;

        av(kotlin.g.a.b bVar) {
            this.f34418a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/getLanguages request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34418a;
            b bVar4 = b.f34366b;
            bVar3.invoke(b.d(jSONObject));
        }
    }

    static final class aw implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34419a;

        aw(kotlin.g.a.b bVar) {
            this.f34419a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/getLanguages request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34419a.invoke(null);
        }
    }

    public final void a(Context context, String str, String str2, String str3, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(str2, "baseURL");
        kotlin.g.b.k.c(str3, "body");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, str, (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ce ceVar = new ce(this, str3, b2, bVar, context, b2, new cf(bVar), new cg(bVar, context));
        ceVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(ceVar);
        }
    }

    public static final class ce extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34514a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34515b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34516c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34517d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f34518e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ce(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, java.lang.String r3, kotlin.g.a.b r4, android.content.Context r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34514a = r1
                r0.f34515b = r2
                r0.f34516c = r3
                r0.f34517d = r4
                r0.f34518e = r5
                r1 = 1
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ce.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header :").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            String str = this.f34515b;
            if (str != null) {
                byte[] bytes = str.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                b bVar = b.f34366b;
                b.a();
                new StringBuilder("request body : ").append(this.f34515b);
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class cf<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34519a;

        cf(kotlin.g.a.b bVar) {
            this.f34519a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/sendEvent request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34519a.invoke(str.toString());
        }
    }

    static final class cg implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34520a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34521b;

        cg(kotlin.g.a.b bVar, Context context) {
            this.f34520a = bVar;
            this.f34521b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/sendEvent request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34520a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34521b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static DefaultRetryPolicy a(Context context) {
        if (context == null) {
            return new DefaultRetryPolicy();
        }
        net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
        return new DefaultRetryPolicy(net.one97.paytm.feed.utility.j.c(context), 0, 1.0f);
    }

    public static final class ai extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34390b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f34391c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34392d;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ai(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, android.content.Context r9, kotlin.g.a.b r10, int r11, org.json.JSONObject r12, com.android.volley.Response.ErrorListener r13) {
            /*
                r6 = this;
                r6.f34389a = r7
                r6.f34390b = r8
                r6.f34391c = r9
                r6.f34392d = r10
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r11
                r4 = r12
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ai.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, android.content.Context, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            return b.b();
        }
    }

    public static final class aj<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34393a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34394b;

        public aj(Context context, kotlin.g.a.b bVar) {
            this.f34393a = context;
            this.f34394b = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            final JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchSharedPost request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            b bVar3 = b.f34366b;
            Context context = this.f34393a;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            FeedItem a2 = b.a(context, jSONObject);
            if (a2 != null) {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                Context context2 = this.f34393a;
                kotlin.g.a.b r2 = new kotlin.g.a.b<String, kotlin.x>(this) {
                    final /* synthetic */ aj this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return kotlin.x.f47997a;
                    }

                    public final void invoke(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            this.this$0.f34394b.invoke(jSONObject.toString());
                        } else {
                            this.this$0.f34394b.invoke(null);
                        }
                    }
                };
                kotlin.g.b.k.c(context2, "context");
                kotlin.g.b.k.c(a2, "feedMinimal");
                kotlin.g.b.k.c(r2, "completionHandler");
                x.e eVar = new x.e();
                eVar.element = net.one97.paytm.feed.repository.db.a.a((FeedDataMinimal) a2);
                io.reactivex.rxjava3.a.y.a(new a.az(context2, eVar)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new a.ba(r2), (io.reactivex.rxjava3.d.g<? super Throwable>) new a.bb(r2));
                return;
            }
            this.f34394b.invoke(null);
        }
    }

    public static final class ak implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34395a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34396b;

        public ak(kotlin.g.a.b bVar, Context context) {
            this.f34395a = bVar;
            this.f34396b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/fetchSharedPost request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34395a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34396b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context) {
        if (context != null) {
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            String h2 = net.one97.paytm.feed.e.b.h();
            if (h2 != null) {
                net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
                b a2 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
                FeedFragment.a aVar2 = FeedFragment.f34877i;
                String a3 = net.one97.paytm.feed.utility.l.a(context, h2, FeedFragment.z, "PREFETCH", "");
                FeedFragment.a aVar3 = FeedFragment.f34877i;
                a2.a(context, a3, FeedFragment.z, (kotlin.g.a.b<? super List<? extends FeedItem>, kotlin.x>) new a(h2, context));
            }
        }
    }

    public static final class ac extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34371a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34372b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f34373c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f34374d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34375e;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ac(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, android.content.Context r9, java.lang.String r10, kotlin.g.a.b r11, int r12, org.json.JSONObject r13, com.android.volley.Response.ErrorListener r14) {
            /*
                r6 = this;
                r6.f34371a = r7
                r6.f34372b = r8
                r6.f34373c = r9
                r6.f34374d = r10
                r6.f34375e = r11
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r12
                r4 = r13
                r5 = r14
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ac.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, android.content.Context, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            return b.b();
        }
    }

    static final class ad<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34376a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34377b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34378c;

        ad(Context context, String str, kotlin.g.a.b bVar) {
            this.f34376a = context;
            this.f34377b = str;
            this.f34378c = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchFeed request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            b bVar3 = b.f34366b;
            Context context = this.f34376a;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            List a2 = b.a(context, jSONObject, this.f34377b);
            this.f34378c.invoke(a2);
            if (!a2.isEmpty()) {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.b(this.f34376a, (List<? extends FeedItem>) a2, this.f34377b);
            }
        }
    }

    static final class ae implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34379a;

        ae(kotlin.g.a.b bVar) {
            this.f34379a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("fetchFeed request fail! Error : ").append(volleyError.toString());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34379a.invoke(null);
        }
    }

    public static final class cn extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34535a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34536b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34537c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34538d;

        /* JADX WARNING: type inference failed for: r5v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public cn(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, android.content.Context r4, int r5, com.android.volley.Response.Listener r6, com.android.volley.Response.ErrorListener r7) {
            /*
                r0 = this;
                r0.f34535a = r1
                r0.f34536b = r2
                r0.f34537c = r3
                r0.f34538d = r4
                r1 = 0
                r0.<init>(r1, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.cn.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            "request header : ".concat(String.valueOf(b2));
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    public static final class co<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34539a;

        public co(kotlin.g.a.b bVar) {
            this.f34539a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/updateUserProfile request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34539a.invoke(str.toString());
        }
    }

    public static final class cp implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34540a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34541b;

        public cp(kotlin.g.a.b bVar, Context context) {
            this.f34540a = bVar;
            this.f34541b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/updateUserProfile request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34540a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34541b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class ar extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34409a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34410b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34411c;

        /* JADX WARNING: type inference failed for: r4v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ar(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, int r4, com.android.volley.Response.Listener r5, com.android.volley.Response.ErrorListener r6) {
            /*
                r0 = this;
                r0.f34409a = r1
                r0.f34410b = r2
                r0.f34411c = r3
                r1 = 0
                r0.<init>(r1, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ar.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            "request header : ".concat(String.valueOf(b2));
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class as<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34412a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34413b;

        as(kotlin.g.a.b bVar, String str) {
            this.f34412a = bVar;
            this.f34413b = str;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/getCricketScore request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34412a;
            b bVar4 = b.f34366b;
            bVar3.invoke(b.b(str, this.f34413b));
        }
    }

    static final class at implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34414a;

        at(kotlin.g.a.b bVar) {
            this.f34414a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/getCricketScore request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34414a.invoke(null);
        }
    }

    /* access modifiers changed from: private */
    public static FeedScore b(String str, String str2) {
        NodeList elementsByTagName;
        try {
            net.one97.paytm.feed.utility.m mVar = net.one97.paytm.feed.utility.m.f35407a;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            Document a2 = net.one97.paytm.feed.utility.m.a(str);
            Node node = null;
            NodeList elementsByTagName2 = a2 != null ? a2.getElementsByTagName("currentscores") : null;
            if ((a2 != null ? a2.getElementsByTagName("match") : null) != null) {
                NodeList elementsByTagName3 = a2.getElementsByTagName("match");
                if ((elementsByTagName3 != null ? elementsByTagName3.item(0) : null) != null) {
                    NodeList elementsByTagName4 = a2.getElementsByTagName("match");
                    Node item = elementsByTagName4 != null ? elementsByTagName4.item(0) : null;
                    if (item != null) {
                        String attribute = ((Element) item).getAttribute("id");
                        kotlin.g.b.k.a((Object) attribute, "(doc.getElementsByTagNam…ement).getAttribute(\"id\")");
                        FeedScore feedScore = new FeedScore(attribute);
                        NodeList elementsByTagName5 = a2.getElementsByTagName("match");
                        Node item2 = elementsByTagName5 != null ? elementsByTagName5.item(0) : null;
                        if (item2 != null) {
                            String attribute2 = ((Element) item2).getAttribute("status");
                            NodeList elementsByTagName6 = a2.getElementsByTagName("match");
                            Node item3 = elementsByTagName6 != null ? elementsByTagName6.item(0) : null;
                            if (item3 != null) {
                                feedScore.setResulttype(((Element) item3).getAttribute("resulttype"));
                                feedScore.setStatus(attribute2);
                                if (elementsByTagName2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                int length = elementsByTagName2.getLength();
                                int i2 = 0;
                                while (i2 < length) {
                                    Node item4 = elementsByTagName2.item(i2);
                                    if (item4 != null) {
                                        Element element = (Element) item4;
                                        net.one97.paytm.feed.utility.m mVar2 = net.one97.paytm.feed.utility.m.f35407a;
                                        String a3 = net.one97.paytm.feed.utility.m.a(element, "innings");
                                        feedScore.setInnings(a3 != null ? Integer.valueOf(Integer.parseInt(a3)) : null);
                                        Integer innings = feedScore.getInnings();
                                        if (innings != null) {
                                            if (innings.intValue() == -1) {
                                                i2++;
                                            }
                                        }
                                        net.one97.paytm.feed.utility.m mVar3 = net.one97.paytm.feed.utility.m.f35407a;
                                        feedScore.setBatteamname(Integer.valueOf(Integer.parseInt(net.one97.paytm.feed.utility.m.a(element, "batteamname"))));
                                        net.one97.paytm.feed.utility.m mVar4 = net.one97.paytm.feed.utility.m.f35407a;
                                        feedScore.setBwlteamname(Integer.valueOf(Integer.parseInt(net.one97.paytm.feed.utility.m.a(element, "bwlteamname"))));
                                        net.one97.paytm.feed.utility.m mVar5 = net.one97.paytm.feed.utility.m.f35407a;
                                        feedScore.setBatteamruns(Integer.valueOf(Integer.parseInt(net.one97.paytm.feed.utility.m.a(element, "batteamruns"))));
                                        net.one97.paytm.feed.utility.m mVar6 = net.one97.paytm.feed.utility.m.f35407a;
                                        feedScore.setBatteamwkts(Integer.valueOf(Integer.parseInt(net.one97.paytm.feed.utility.m.a(element, "batteamwkts"))));
                                        net.one97.paytm.feed.utility.m mVar7 = net.one97.paytm.feed.utility.m.f35407a;
                                        feedScore.setBatteamovers(Float.valueOf(Float.parseFloat(net.one97.paytm.feed.utility.m.a(element, "batteamovers"))));
                                        net.one97.paytm.feed.utility.m mVar8 = net.one97.paytm.feed.utility.m.f35407a;
                                        feedScore.setMaxovers(Float.valueOf(Float.parseFloat(net.one97.paytm.feed.utility.m.a(element, "maxovers"))));
                                        i2++;
                                    } else {
                                        throw new kotlin.u("null cannot be cast to non-null type org.w3c.dom.Element");
                                    }
                                }
                                Integer innings2 = feedScore.getInnings();
                                if (innings2 != null) {
                                    if (innings2.intValue() == 1 && (elementsByTagName = a2.getElementsByTagName("innings")) != null) {
                                        int length2 = elementsByTagName.getLength();
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 >= length2) {
                                                break;
                                            }
                                            Node item5 = elementsByTagName.item(i3);
                                            if (item5 != null) {
                                                Element element2 = (Element) item5;
                                                if (element2.getAttribute("number").equals("0")) {
                                                    String attribute3 = element2.getAttribute("overs");
                                                    feedScore.setInning0Overs(attribute3 != null ? Float.valueOf(Float.parseFloat(attribute3)) : null);
                                                    String attribute4 = element2.getAttribute("wkts");
                                                    feedScore.setInning0Wkts(attribute4 != null ? Integer.valueOf(Integer.parseInt(attribute4)) : null);
                                                    String attribute5 = element2.getAttribute("runs");
                                                    feedScore.setInning0runs(attribute5 != null ? Integer.valueOf(Integer.parseInt(attribute5)) : null);
                                                    String attribute6 = element2.getAttribute("team");
                                                    feedScore.setInning0Team(attribute6 != null ? Integer.valueOf(Integer.parseInt(attribute6)) : null);
                                                } else {
                                                    i3++;
                                                }
                                            } else {
                                                throw new kotlin.u("null cannot be cast to non-null type org.w3c.dom.Element");
                                            }
                                        }
                                    }
                                }
                                Integer innings3 = feedScore.getInnings();
                                if (innings3 != null) {
                                    if (innings3.intValue() == -1) {
                                        NodeList elementsByTagName7 = a2.getElementsByTagName("team");
                                        Node item6 = elementsByTagName7 != null ? elementsByTagName7.item(0) : null;
                                        if (item6 != null) {
                                            String attribute7 = ((Element) item6).getAttribute("id");
                                            kotlin.g.b.k.a((Object) attribute7, "team1");
                                            feedScore.setBatteamname(Integer.valueOf(Integer.parseInt(attribute7)));
                                            NodeList elementsByTagName8 = a2.getElementsByTagName("team");
                                            if (elementsByTagName8 != null) {
                                                node = elementsByTagName8.item(1);
                                            }
                                            if (node != null) {
                                                String attribute8 = ((Element) node).getAttribute("id");
                                                kotlin.g.b.k.a((Object) attribute8, "team2");
                                                feedScore.setBwlteamname(Integer.valueOf(Integer.parseInt(attribute8)));
                                            } else {
                                                throw new kotlin.u("null cannot be cast to non-null type org.w3c.dom.Element");
                                            }
                                        } else {
                                            throw new kotlin.u("null cannot be cast to non-null type org.w3c.dom.Element");
                                        }
                                    }
                                }
                                return feedScore;
                            }
                            throw new kotlin.u("null cannot be cast to non-null type org.w3c.dom.Element");
                        }
                        throw new kotlin.u("null cannot be cast to non-null type org.w3c.dom.Element");
                    }
                    throw new kotlin.u("null cannot be cast to non-null type org.w3c.dom.Element");
                }
            }
            net.one97.paytm.feed.utility.m mVar9 = net.one97.paytm.feed.utility.m.f35407a;
            return new FeedScore(net.one97.paytm.feed.utility.m.b(str2));
        } catch (Exception unused) {
            net.one97.paytm.feed.utility.m mVar10 = net.one97.paytm.feed.utility.m.f35407a;
            return new FeedScore(net.one97.paytm.feed.utility.m.b(str2));
        }
    }

    public final void a(Context context, kotlin.g.a.b<? super FeedProfile, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, "/content-feed/v1/userProfile/following", kotlin.a.ae.a(new kotlin.o("maxId", net.one97.paytm.feed.b.u())));
        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ba baVar = new ba(this, b2, bVar, context, b2, new bb(bVar, context), new bc(bVar, context));
        baVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(baVar);
        }
    }

    public static final class ba extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34432a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34433b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34434c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34435d;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ba(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, kotlin.g.a.b r9, android.content.Context r10, int r11, org.json.JSONObject r12, com.android.volley.Response.ErrorListener r13) {
            /*
                r6 = this;
                r6.f34432a = r7
                r6.f34433b = r8
                r6.f34434c = r9
                r6.f34435d = r10
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r11
                r4 = r12
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ba.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            "request header : ".concat(String.valueOf(b2));
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class bb<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34436a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34437b;

        bb(kotlin.g.a.b bVar, Context context) {
            this.f34436a = bVar;
            this.f34437b = context;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/getUserProfile request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34436a;
            b bVar4 = b.f34366b;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            bVar3.invoke(b.e(jSONObject));
        }
    }

    static final class bc implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34438a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34439b;

        bc(kotlin.g.a.b bVar, Context context) {
            this.f34438a = bVar;
            this.f34439b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/getUserProfile request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34438a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34439b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public final void b(Context context, kotlin.g.a.b<? super FeedProfile, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, "/content-feed/v2/userProfile/bookmark", kotlin.a.ae.a(new kotlin.o("maxId", net.one97.paytm.feed.b.v())));
        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ax axVar = new ax(this, b2, bVar, context, b2, new ay(bVar, context), new az(bVar, context));
        axVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(axVar);
        }
    }

    public static final class ax extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34421b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34422c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34423d;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ax(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, kotlin.g.a.b r9, android.content.Context r10, int r11, org.json.JSONObject r12, com.android.volley.Response.ErrorListener r13) {
            /*
                r6 = this;
                r6.f34420a = r7
                r6.f34421b = r8
                r6.f34422c = r9
                r6.f34423d = r10
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r11
                r4 = r12
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ax.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            "request header : ".concat(String.valueOf(b2));
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class ay<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34424a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34425b;

        ay(kotlin.g.a.b bVar, Context context) {
            this.f34424a = bVar;
            this.f34425b = context;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/getUserBookmarks request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34424a;
            b bVar4 = b.f34366b;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            bVar3.invoke(b.f(jSONObject));
        }
    }

    static final class az implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34426a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34427b;

        az(kotlin.g.a.b bVar, Context context) {
            this.f34426a = bVar;
            this.f34427b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/getUserBookmarks request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34426a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34427b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class af extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34381b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f34382c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ProviderResult f34383d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34384e;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        af(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, android.content.Context r9, net.one97.paytm.feed.repository.models.provider.ProviderResult r10, kotlin.g.a.b r11, int r12, org.json.JSONObject r13, com.android.volley.Response.ErrorListener r14) {
            /*
                r6 = this;
                r6.f34380a = r7
                r6.f34381b = r8
                r6.f34382c = r9
                r6.f34383d = r10
                r6.f34384e = r11
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r12
                r4 = r13
                r5 = r14
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.af.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, android.content.Context, net.one97.paytm.feed.repository.models.provider.ProviderResult, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            return b.b();
        }
    }

    static final class ag<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34385a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProviderResult f34386b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34387c;

        ag(Context context, ProviderResult providerResult, kotlin.g.a.b bVar) {
            this.f34385a = context;
            this.f34386b = providerResult;
            this.f34387c = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchFeed request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            b bVar3 = b.f34366b;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            ProviderResult a2 = b.a(jSONObject, this.f34385a);
            if (!a2.getFeed().isEmpty()) {
                ProviderResult providerResult = this.f34386b;
                if (providerResult != null) {
                    a2.setProviderData(providerResult.getProviderData());
                }
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.a(this.f34385a, (List<? extends FeedItem>) a2.getFeed(), a2.getProviderData());
            }
            this.f34387c.invoke(a2);
        }
    }

    static final class ah implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34388a;

        ah(kotlin.g.a.b bVar) {
            this.f34388a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("fetchFeed request fail! Error : ").append(volleyError.toString());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34388a.invoke(null);
        }
    }

    public final void b(Context context, String str, int i2, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, str, (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        cq cqVar = new cq(this, i2, b2, bVar, context, b2, new cr(bVar), new cs(bVar, context));
        cqVar.setRetryPolicy(a(context));
        a.f34362b.a(context).a(cqVar);
    }

    public static final class cq extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34542a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34543b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34544c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34545d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f34546e;

        /* JADX WARNING: type inference failed for: r6v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        cq(net.one97.paytm.feed.repository.a.b r1, int r2, java.lang.String r3, kotlin.g.a.b r4, android.content.Context r5, int r6, com.android.volley.Response.Listener r7, com.android.volley.Response.ErrorListener r8) {
            /*
                r0 = this;
                r0.f34542a = r1
                r0.f34543b = r2
                r0.f34544c = r3
                r0.f34545d = r4
                r0.f34546e = r5
                r1 = 1
                r0.<init>(r1, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.cq.<init>(net.one97.paytm.feed.repository.a.b, int, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("toUserId", this.f34543b);
            b bVar = b.f34366b;
            b.a();
            "request body : ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "jso.toString()");
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class cr<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34547a;

        cr(kotlin.g.a.b bVar) {
            this.f34547a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/userFollow request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34547a.invoke(str.toString());
        }
    }

    static final class cs implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34549b;

        cs(kotlin.g.a.b bVar, Context context) {
            this.f34548a = bVar;
            this.f34549b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/userFollow request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34548a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34549b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public final void d(Context context, String str, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, str, (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        C0563b bVar4 = new C0563b(this, b2, bVar, context, b2, new c(bVar), new d(bVar, context));
        bVar4.setRetryPolicy(a(context));
        a.f34362b.a(context).a(bVar4);
    }

    /* renamed from: net.one97.paytm.feed.repository.a.b$b  reason: collision with other inner class name */
    public static final class C0563b extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34428a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34429b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34430c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34431d;

        /* JADX WARNING: type inference failed for: r5v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        C0563b(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, android.content.Context r4, int r5, com.android.volley.Response.Listener r6, com.android.volley.Response.ErrorListener r7) {
            /*
                r0 = this;
                r0.f34428a = r1
                r0.f34429b = r2
                r0.f34430c = r3
                r0.f34431d = r4
                r1 = 1
                r0.<init>(r1, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.C0563b.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class c<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34502a;

        c(kotlin.g.a.b bVar) {
            this.f34502a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/userFollow request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34502a.invoke(str.toString());
        }
    }

    static final class d implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34551b;

        d(kotlin.g.a.b bVar, Context context) {
            this.f34550a = bVar;
            this.f34551b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/userFollow request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34550a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34551b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public final void e(Context context, String str, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, str, (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        n nVar = new n(this, b2, bVar, context, b2, new o(bVar), new p(bVar, context));
        nVar.setRetryPolicy(a(context));
        a.f34362b.a(context).a(nVar);
    }

    public static final class n extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34579a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34580b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34581c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34582d;

        /* JADX WARNING: type inference failed for: r5v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        n(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, android.content.Context r4, int r5, com.android.volley.Response.Listener r6, com.android.volley.Response.ErrorListener r7) {
            /*
                r0 = this;
                r0.f34579a = r1
                r0.f34580b = r2
                r0.f34581c = r3
                r0.f34582d = r4
                r1 = 3
                r0.<init>(r1, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.n.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class o<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34583a;

        o(kotlin.g.a.b bVar) {
            this.f34583a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "/userFollow request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34583a.invoke(str.toString());
        }
    }

    static final class p implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34584a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34585b;

        p(kotlin.g.a.b bVar, Context context) {
            this.f34584a = bVar;
            this.f34585b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/userFollow request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34584a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34585b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public static final class ck extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34530a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34531b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34532c;

        /* JADX WARNING: type inference failed for: r4v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ck(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, int r4, com.android.volley.Response.Listener r5, com.android.volley.Response.ErrorListener r6) {
            /*
                r0 = this;
                r0.f34530a = r1
                r0.f34531b = r2
                r0.f34532c = r3
                r1 = 0
                r0.<init>(r1, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ck.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }
    }

    public static final class cl<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34533a;

        public cl(kotlin.g.a.b bVar) {
            this.f34533a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "trainPnrStatus request OK! Response: ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34533a.invoke((net.one97.paytm.feed.f.a.i) new com.google.gson.f().a(str, net.one97.paytm.feed.f.a.i.class));
        }
    }

    public static final class cm implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34534a;

        public cm(kotlin.g.a.b bVar) {
            this.f34534a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("trainPnrStatus request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34534a.invoke(null);
        }
    }

    public final void f(Context context, String str, kotlin.g.a.b<? super FeedWeatherDetails, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "dataUrl");
        kotlin.g.b.k.c(bVar, "completionHandler");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("?lat=");
        net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
        sb.append(net.one97.paytm.feed.e.c.e());
        sb.append("&lon=");
        net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
        sb.append(net.one97.paytm.feed.e.c.f());
        String sb2 = sb.toString();
        "Url to hit : ".concat(String.valueOf(sb2));
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ao aoVar = new ao(this, sb2, bVar, sb2, new ap(bVar), new aq(bVar));
        aoVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(aoVar, "weather");
        }
    }

    public static final class ao extends StringRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34405b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34406c;

        /* JADX WARNING: type inference failed for: r4v0, types: [int, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ao(net.one97.paytm.feed.repository.a.b r1, java.lang.String r2, kotlin.g.a.b r3, int r4, com.android.volley.Response.Listener r5, com.android.volley.Response.ErrorListener r6) {
            /*
                r0 = this;
                r0.f34404a = r1
                r0.f34405b = r2
                r0.f34406c = r3
                r1 = 0
                r0.<init>(r1, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.ao.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            "request header : ".concat(String.valueOf(b2));
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }
    }

    static final class ap<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34407a;

        ap(kotlin.g.a.b bVar) {
            this.f34407a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            b bVar = b.f34366b;
            b.a();
            "Weather response : ".concat(String.valueOf(str));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34407a.invoke((FeedWeatherDetails) new com.google.gson.f().a(str, FeedWeatherDetails.class));
        }
    }

    static final class aq implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34408a;

        aq(kotlin.g.a.b bVar) {
            this.f34408a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            "Weather error : ".concat(String.valueOf(volleyError));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34408a.invoke(null);
        }
    }

    public final void g(Context context, String str, kotlin.g.a.b<? super FeedOfFeed, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "postId");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        String b2 = net.one97.paytm.feed.utility.l.b(context, net.one97.paytm.feed.e.b.h(), "content-feed/v2/posts/".concat(String.valueOf(str)), (Map<String, ? extends Object>) null);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        al alVar = new al(this, b2, context, bVar, b2, new am(context, bVar), new an(bVar));
        alVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(alVar);
        }
    }

    public static final class al extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34397a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34398b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f34399c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34400d;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        al(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, android.content.Context r9, kotlin.g.a.b r10, int r11, org.json.JSONObject r12, com.android.volley.Response.ErrorListener r13) {
            /*
                r6 = this;
                r6.f34397a = r7
                r6.f34398b = r8
                r6.f34399c = r9
                r6.f34400d = r10
                r1 = 0
                r3 = 0
                r0 = r6
                r2 = r11
                r4 = r12
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.al.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, android.content.Context, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            return b.b();
        }
    }

    static final class am<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34401a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34402b;

        am(Context context, kotlin.g.a.b bVar) {
            this.f34401a = context;
            this.f34402b = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchStory request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            b bVar3 = b.f34366b;
            Context context = this.f34401a;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            FeedItem b2 = b.b(context, jSONObject);
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            if (b2 != null) {
                this.f34402b.invoke(net.one97.paytm.feed.repository.db.a.b((FeedDataMinimal) b2));
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.FeedDataMinimal");
        }
    }

    static final class an implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34403a;

        an(kotlin.g.a.b bVar) {
            this.f34403a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/fetchStory request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34403a.invoke(null);
        }
    }

    public static final class bd extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34440a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34441b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34442c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34443d;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bd(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, java.lang.String r9, kotlin.g.a.b r10, int r11, org.json.JSONObject r12, com.android.volley.Response.ErrorListener r13) {
            /*
                r6 = this;
                r6.f34440a = r7
                r6.f34441b = r8
                r6.f34442c = r9
                r6.f34443d = r10
                r1 = 1
                r3 = 0
                r0 = r6
                r2 = r11
                r4 = r12
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.bd.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, java.lang.String, kotlin.g.a.b, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            HashMap b2 = b.b();
            b bVar2 = b.f34366b;
            b.a();
            new StringBuilder("/onStoryWatched request header : ").append(b2.toString());
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return b2;
        }

        public final byte[] getBody() {
            Charset charset = kotlin.m.d.f47971a;
            com.google.gson.i iVar = new com.google.gson.i();
            String str = this.f34441b;
            iVar.f39472a.add(str == null ? com.google.gson.n.f39635a : new com.google.gson.r(str));
            b bVar = b.f34366b;
            b.a();
            "/onStoryWatched request body : ".concat(String.valueOf(iVar));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            String iVar2 = iVar.toString();
            kotlin.g.b.k.a((Object) iVar2, "jsa.toString()");
            if (iVar2 != null) {
                byte[] bytes = iVar2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class be<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34444a;

        public be(kotlin.g.a.b bVar) {
            this.f34444a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            b bVar = b.f34366b;
            b.a();
            "/onStoryWatched request OK! Response: ".concat(String.valueOf((JSONObject) obj));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34444a.invoke(null);
        }
    }

    public static final class bf implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34445a;

        public bf(kotlin.g.a.b bVar) {
            this.f34445a = bVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/onStoryWatched request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34445a.invoke(null);
        }
    }

    public static final class bg extends JsonObjectRequest {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34446a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34447b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34448c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f34449d;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bg(net.one97.paytm.feed.repository.a.b r7, java.lang.String r8, kotlin.g.a.b r9, android.content.Context r10, int r11, org.json.JSONObject r12, com.android.volley.Response.ErrorListener r13) {
            /*
                r6 = this;
                r6.f34446a = r7
                r6.f34447b = r8
                r6.f34448c = r9
                r6.f34449d = r10
                r1 = 1
                r3 = 0
                r0 = r6
                r2 = r11
                r4 = r12
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.a.b.bg.<init>(net.one97.paytm.feed.repository.a.b, java.lang.String, kotlin.g.a.b, android.content.Context, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getHeaders() {
            b bVar = b.f34366b;
            return b.b();
        }
    }

    public static final class bh<T> implements Response.Listener<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34450a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34451b;

        public bh(kotlin.g.a.b bVar, Context context) {
            this.f34450a = bVar;
            this.f34451b = context;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            b bVar = b.f34366b;
            b.a();
            "/fetchPolls request OK! Response: ".concat(String.valueOf(jSONObject));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            kotlin.g.a.b bVar3 = this.f34450a;
            b bVar4 = b.f34366b;
            kotlin.g.b.k.a((Object) jSONObject, Payload.RESPONSE);
            bVar3.invoke(((PollsResponse) new com.google.gson.f().a(jSONObject.toString(), PollsResponse.class)).getOptions());
        }
    }

    public static final class bi implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f34452a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34453b;

        public bi(kotlin.g.a.b bVar, Context context) {
            this.f34452a = bVar;
            this.f34453b = context;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b bVar = b.f34366b;
            b.a();
            new StringBuilder("/fetchPolls request fail! Error: ").append(volleyError.getMessage());
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f34452a.invoke(null);
            try {
                b bVar3 = b.f34366b;
                b.a(this.f34453b, volleyError.networkResponse);
            } catch (Exception unused) {
            }
        }
    }

    public final void a(Context context, String str, String str2, kotlin.g.a.b<? super List<? extends FeedItem>, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "finalUrl");
        kotlin.g.b.k.c(str2, "category");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        z zVar = new z(this, str, context, str2, bVar, str, new aa(context, str2, bVar), new ab(bVar));
        zVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(zVar);
        }
    }

    public final void c(Context context, String str, String str2, kotlin.g.a.b<? super FeedScore, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(str2, "url");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ar arVar = new ar(this, str2, bVar, str2, new as(bVar, str2), new at(bVar));
        arVar.setRetryPolicy(a(context));
        a a2 = a.f34362b.a(context);
        if (a2 != null) {
            a2.a(arVar, "score");
        }
    }

    public final void a(Context context, String str, ProviderResult providerResult, kotlin.g.a.b<? super ProviderResult, kotlin.x> bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "finalUrl");
        kotlin.g.b.k.c(bVar, "completionHandler");
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        af afVar = new af(this, str, context, providerResult, bVar, str, new ag(context, providerResult, bVar), new ah(bVar));
        afVar.setRetryPolicy(a(context));
        a.f34362b.a(context).a(afVar);
    }

    public static final /* synthetic */ HashMap b() {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
        if (!TextUtils.isEmpty(net.one97.paytm.feed.e.c.d())) {
            net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
            String d2 = net.one97.paytm.feed.e.c.d();
            if (d2 != null) {
                hashMap.put(AppConstants.SSO_TOKEN, d2);
            }
        }
        net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "FeedManager.application.applicationContext");
        if (kotlin.g.b.k.a((Object) net.one97.paytm.feed.utility.j.d(applicationContext), (Object) "")) {
            map.put("X-DEVICE-ID", "paytmx");
        } else {
            net.one97.paytm.feed.utility.j jVar2 = net.one97.paytm.feed.utility.j.f35397a;
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Context applicationContext2 = net.one97.paytm.feed.e.b.g().getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext2, "FeedManager.application.applicationContext");
            map.put("X-DEVICE-ID", net.one97.paytm.feed.utility.j.d(applicationContext2));
        }
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        return hashMap;
    }

    public static final /* synthetic */ List a(Context context, JSONObject jSONObject, String str) {
        FeedFragment.a aVar = FeedFragment.f34877i;
        if (kotlin.g.b.k.a((Object) str, (Object) FeedFragment.B)) {
            ResultBookmark resultBookmark = (ResultBookmark) new com.google.gson.g().a(FeedItem.class, new FeedDBDeserializer(context)).a().a(jSONObject.getJSONObject("result").toString(), ResultBookmark.class);
            net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
            if (resultBookmark == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.b.b(resultBookmark.getMaxId());
            net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b.h(resultBookmark.getFeed().size());
            return resultBookmark.getFeed();
        }
        FeedFragment.a aVar2 = FeedFragment.f34877i;
        if (kotlin.g.b.k.a((Object) str, (Object) FeedFragment.C)) {
            Result result = (Result) new com.google.gson.g().a(FeedItem.class, new FeedDBDeserializer(context)).a().a(jSONObject.getJSONObject("result").toString(), Result.class);
            net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
            if (result == null) {
                kotlin.g.b.k.a();
            }
            String requestId = result.getRequestId();
            if (requestId == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.b.c(requestId);
            net.one97.paytm.feed.b bVar4 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b.i(result.getNextPageNo());
            net.one97.paytm.feed.b bVar5 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b.j(result.getTotalPageCount());
            net.one97.paytm.feed.b bVar6 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b.g(result.getFeed().size());
            return result.getFeed();
        }
        Result result2 = (Result) new com.google.gson.g().a(FeedItem.class, new FeedDBDeserializer(context)).a().a(jSONObject.getJSONObject("result").toString(), Result.class);
        net.one97.paytm.feed.b bVar7 = net.one97.paytm.feed.b.f33792d;
        if (result2 == null) {
            kotlin.g.b.k.a();
        }
        String requestId2 = result2.getRequestId();
        if (requestId2 == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.feed.b.b(requestId2);
        net.one97.paytm.feed.b bVar8 = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.d(result2.getNextPageNo());
        net.one97.paytm.feed.b bVar9 = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.e(result2.getTotalPageCount());
        net.one97.paytm.feed.b bVar10 = net.one97.paytm.feed.b.f33792d;
        boolean z2 = net.one97.paytm.feed.b.f33789a;
        if (z2) {
            int i2 = net.one97.paytm.feed.b.f33791c;
            net.one97.paytm.feed.repository.b bVar11 = net.one97.paytm.feed.repository.b.f34608a;
            net.one97.paytm.feed.repository.b.a(i2);
            "current topRank : ".concat(String.valueOf(i2));
            net.one97.paytm.feed.e.b bVar12 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
        } else if (!z2) {
            int i3 = net.one97.paytm.feed.b.f33790b;
            net.one97.paytm.feed.repository.b bVar13 = net.one97.paytm.feed.repository.b.f34608a;
            net.one97.paytm.feed.repository.b.b(i3);
            "current bottomRank : ".concat(String.valueOf(i3));
            net.one97.paytm.feed.e.b bVar14 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
        } else {
            throw new kotlin.m();
        }
        net.one97.paytm.feed.b bVar15 = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.f(result2.getFeed().size());
        return result2.getFeed();
    }

    public static final /* synthetic */ void a(Context context, NetworkResponse networkResponse) {
        if (networkResponse == null) {
            return;
        }
        if (networkResponse.statusCode == 406 || networkResponse.statusCode == 410 || networkResponse.statusCode == 401) {
            Toast.makeText(context, R.string.feed_session_expired, 0).show();
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.a(context);
            return;
        }
        Toast.makeText(context, R.string.feed_server_error, 0).show();
    }

    public static final /* synthetic */ List a(JSONObject jSONObject) {
        ChannelCategories channelCategories = (ChannelCategories) new com.google.gson.f().a(jSONObject.toString(), ChannelCategories.class);
        if (channelCategories == null) {
            kotlin.g.b.k.a();
        }
        return channelCategories.getCategories();
    }

    public static final /* synthetic */ List b(JSONObject jSONObject) {
        ChannelsWrapper channelsWrapper = (ChannelsWrapper) new com.google.gson.f().a(String.valueOf(jSONObject), ChannelsWrapper.class);
        if (channelsWrapper == null) {
            kotlin.g.b.k.a();
        }
        return channelsWrapper.getChannels();
    }

    public static final /* synthetic */ List c(JSONObject jSONObject) {
        CommentResult commentResult = (CommentResult) new com.google.gson.f().a(jSONObject.getString("result"), CommentResult.class);
        if (commentResult == null) {
            kotlin.g.b.k.a();
        }
        for (CommentResponse feedItemType : commentResult.getCommentResponseList()) {
            feedItemType.setFeedItemType(net.one97.paytm.feed.utility.k.COMMENTS.getType());
        }
        return commentResult.getCommentResponseList();
    }

    public static final /* synthetic */ FeedLanguage d(JSONObject jSONObject) {
        FeedLanguage feedLanguage = (FeedLanguage) new com.google.gson.f().a(String.valueOf(jSONObject), FeedLanguage.class);
        kotlin.g.b.k.a((Object) feedLanguage, "feedLanguageResponse");
        return feedLanguage;
    }

    public static final /* synthetic */ FeedItem a(Context context, JSONObject jSONObject) {
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        FeedFragment.a aVar = FeedFragment.f34877i;
        net.one97.paytm.feed.b.a(FeedFragment.A);
        return (FeedItem) new com.google.gson.g().a(FeedItem.class, new FeedDBDeserializer(context)).a().a(jSONObject.getJSONObject("result").toString(), FeedItem.class);
    }

    public static final /* synthetic */ void a(b bVar, Context context, String str, String str2, kotlin.g.a.b bVar2) {
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ac acVar = new ac(bVar, str, context, str2, bVar2, str, new ad(context, str2, bVar2), new ae(bVar2));
        acVar.setRetryPolicy(a(context));
        a.f34362b.a(context).a(acVar);
    }

    public static final /* synthetic */ FeedProfile e(JSONObject jSONObject) {
        FeedProfile feedProfile = (FeedProfile) new com.google.gson.f().a(jSONObject.toString(), FeedProfile.class);
        for (Following following : feedProfile.getResult().getFollowing()) {
            following.setFollowing(true);
        }
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.a(feedProfile.getResult().getMaxId());
        kotlin.g.b.k.a((Object) feedProfile, "feedProfile");
        return feedProfile;
    }

    public static final /* synthetic */ FeedProfile f(JSONObject jSONObject) {
        FeedProfile feedProfile = (FeedProfile) new com.google.gson.f().a(jSONObject.toString(), FeedProfile.class);
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.b(feedProfile.getResult().getMaxId());
        kotlin.g.b.k.a((Object) feedProfile, "feedProfile");
        return feedProfile;
    }

    public static final /* synthetic */ ProviderResult a(JSONObject jSONObject, Context context) {
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.a("providerId");
        ProviderResult providerResult = (ProviderResult) new com.google.gson.g().a(FeedItem.class, new FeedDBDeserializer(context)).a().a(jSONObject.getJSONObject("result").toString(), ProviderResult.class);
        if (providerResult == null) {
            kotlin.g.b.k.a();
        }
        return providerResult;
    }

    public static final /* synthetic */ FeedItem b(Context context, JSONObject jSONObject) {
        return (FeedItem) new com.google.gson.g().a(FeedItem.class, new FeedDBDeserializer(context)).a().a(jSONObject.getJSONObject("result").toString(), FeedItem.class);
    }
}
