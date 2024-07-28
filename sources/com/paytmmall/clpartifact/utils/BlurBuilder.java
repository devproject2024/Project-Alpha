package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class BlurBuilder {
    /* access modifiers changed from: private */
    public static final float BITMAP_SCALE = BITMAP_SCALE;
    /* access modifiers changed from: private */
    public static final float BLUR_RADIUS = BLUR_RADIUS;
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Bitmap blur(Context context, Bitmap bitmap) {
            k.c(bitmap, H5ResourceHandlerUtil.IMAGE);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * BlurBuilder.BITMAP_SCALE), Math.round(((float) bitmap.getHeight()) * BlurBuilder.BITMAP_SCALE), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(BlurBuilder.BLUR_RADIUS);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            k.a((Object) createBitmap, "outputBitmap");
            return createBitmap;
        }
    }
}
