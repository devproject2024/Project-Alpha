package com.google.android.exoplayer2.f;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.t;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public interface v extends i {

    /* renamed from: a  reason: collision with root package name */
    public static final t<String> f32460a = $$Lambda$v$u8tA2fGeUI917kX_xG1OWfGR48Q.INSTANCE;

    public interface b extends i.a {

        /* renamed from: com.google.android.exoplayer2.f.v$b$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        /* synthetic */ i a();

        v b();
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f32462a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f32463b;

        public final synchronized Map<String, String> a() {
            if (this.f32463b == null) {
                this.f32463b = Collections.unmodifiableMap(new HashMap(this.f32462a));
            }
            return this.f32463b;
        }
    }

    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final f f32461a = new f();

        /* access modifiers changed from: protected */
        public abstract v a(f fVar);

        /* renamed from: b */
        public final v a() {
            return a(this.f32461a);
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.v$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean a(String str) {
            String d2 = ae.d(str);
            if (!TextUtils.isEmpty(d2)) {
                return (!d2.contains(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX) || d2.contains("text/vtt")) && !d2.contains("html") && !d2.contains("xml");
            }
            return false;
        }
    }

    public static class c extends IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final l dataSpec;
        public final int type;

        public c(l lVar, int i2) {
            this.dataSpec = lVar;
            this.type = i2;
        }

        public c(String str, l lVar, int i2) {
            super(str);
            this.dataSpec = lVar;
            this.type = i2;
        }

        public c(IOException iOException, l lVar, int i2) {
            super(iOException);
            this.dataSpec = lVar;
            this.type = i2;
        }

        public c(String str, IOException iOException, l lVar, int i2) {
            super(str, iOException);
            this.dataSpec = lVar;
            this.type = i2;
        }
    }

    public static final class d extends c {
        public final String contentType;

        public d(String str, l lVar) {
            super("Invalid content type: ".concat(String.valueOf(str)), lVar, 1);
            this.contentType = str;
        }
    }

    public static final class e extends c {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;
        public final String responseMessage;

        @Deprecated
        public e(int i2, Map<String, List<String>> map, l lVar) {
            this(i2, (String) null, map, lVar);
        }

        public e(int i2, String str, Map<String, List<String>> map, l lVar) {
            super("Response code: ".concat(String.valueOf(i2)), lVar, 1);
            this.responseCode = i2;
            this.responseMessage = str;
            this.headerFields = map;
        }
    }
}
