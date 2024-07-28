package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.URLUtil;
import com.alipay.mobile.nebulacore.plugin.H5LongClickPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import org.json.JSONObject;

public final class ax extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f59535a;

    public ax() {
        super(H5LongClickPlugin.SAVE_IMAGE);
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        JSONObject params = h5Event.getParams();
        this.f59535a = h5Event.getActivity();
        String optString = params != null ? params.optString("src") : null;
        if (params != null) {
            Boolean.valueOf(params.optBoolean("showActionSheet"));
        }
        boolean a2 = a(optString, h5Event);
        if (TextUtils.isEmpty(optString)) {
            a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "");
            return true;
        } else if (a2) {
            return true;
        } else {
            if (!URLUtil.isValidUrl(optString)) {
                a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "");
                return true;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new a(this, new URL(optString), h5Event, (d) null), 3, (Object) null);
            return true;
        }
    }

    private final boolean a(String str, H5Event h5Event) {
        try {
            byte[] decode = Base64.decode(str, 0);
            k.a((Object) decode, "Base64.decode(url, Base64.DEFAULT)");
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            k.a((Object) decodeByteArray, "bitmap");
            a(decodeByteArray, h5Event);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Bitmap a(URL url) {
        k.c(url, "$this$toBitmap");
        try {
            return BitmapFactory.decodeStream(FirebasePerfUrlConnection.openStream(url));
        } catch (IOException unused) {
            return null;
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixSaveImagePlugin.kt", c = {56}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixSaveImagePlugin$handleEvent$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ H5Event $event;
        final /* synthetic */ URL $urlImage;
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ ax this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ax axVar, URL url, H5Event h5Event, d dVar) {
            super(2, dVar);
            this.this$0 = axVar;
            this.$urlImage = url;
            this.$event = h5Event;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, this.$urlImage, this.$event, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                final Bitmap a2 = ax.a(this.$urlImage);
                this.L$0 = coroutineScope;
                this.L$1 = a2;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new m<CoroutineScope, d<? super x>, Object>(this, (d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ a this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final d<x> create(Object obj, d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        /* access modifiers changed from: package-private */
                        public final void a(Bitmap bitmap, H5Event h5Event) {
                            Activity activity = this.f59535a;
                            MediaStore.Images.Media.insertImage(activity != null ? activity.getContentResolver() : null, bitmap, "", "");
                            a("success", (Object) Boolean.TRUE);
                            net.one97.paytm.phoenix.core.a.a(this, h5Event, (Object) null, true, 2);
                        }
                    }
