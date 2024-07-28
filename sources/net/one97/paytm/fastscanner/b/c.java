package net.one97.paytm.fastscanner.b;

import android.graphics.Bitmap;
import android.hardware.Camera;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f50425a = new c();

    private c() {
    }

    public static void a(byte[] bArr, Camera.Parameters parameters, int i2, int i3) {
        k.c(bArr, "data");
        if (parameters != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new a(parameters, (d) null, bArr, i2, i3), 3, (Object) null);
        }
    }

    public static boolean a(Bitmap bitmap) {
        k.c(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < width) {
            int height = bitmap.getHeight();
            int i5 = i3;
            for (int i6 = 0; i6 < height; i6++) {
                int pixel = bitmap.getPixel(i2, i6);
                int[] iArr = {(pixel >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID, (pixel >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID, pixel & PriceRangeSeekBar.INVALID_POINTER_ID};
                if (Math.max(Math.max(iArr[0], iArr[1]), iArr[2]) < 128) {
                    i4++;
                } else {
                    i5++;
                }
            }
            i2++;
            i3 = i5;
        }
        return (i3 - i4) / (bitmap.getWidth() * bitmap.getHeight()) < 0;
    }

    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ byte[] $data$inlined;
        final /* synthetic */ int $height$inlined;
        final /* synthetic */ Camera.Parameters $it;
        final /* synthetic */ int $width$inlined;
        Object L$0;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Camera.Parameters parameters, d dVar, byte[] bArr, int i2, int i3) {
            super(2, dVar);
            this.$it = parameters;
            this.$data$inlined = bArr;
            this.$width$inlined = i2;
            this.$height$inlined = i3;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.$it, dVar, this.$data$inlined, this.$width$inlined, this.$height$inlined);
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
                this.L$0 = this.p$;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new m<CoroutineScope, d<? super x>, Object>(this, (d) null) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    boolean Z$0;
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ a this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final d<x> create(Object obj, d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 
                    }
