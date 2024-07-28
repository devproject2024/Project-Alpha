package com.paytm.utility.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.d.a.f;
import java.security.MessageDigest;

public final class a extends f {

    /* renamed from: b  reason: collision with root package name */
    private RenderScript f43713b;

    public a(Context context) {
        this.f43713b = RenderScript.create(context);
    }

    public final Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f43713b, copy, Allocation.MipmapControl.MIPMAP_FULL, 128);
        Allocation createTyped = Allocation.createTyped(this.f43713b, createFromBitmap.getType());
        RenderScript renderScript = this.f43713b;
        ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        create.setInput(createFromBitmap);
        create.setRadius(10.0f);
        create.forEach(createTyped);
        createTyped.copyTo(copy);
        return copy;
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("blur transformation".getBytes());
    }
}
