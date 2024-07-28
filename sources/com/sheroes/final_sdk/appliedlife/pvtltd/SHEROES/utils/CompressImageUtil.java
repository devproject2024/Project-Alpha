package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.squareup.picasso.w;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import java.io.IOException;

public class CompressImageUtil {
    public static p<Bitmap> createBitmap(Context context, final String str, final int i2, final int i3) {
        return p.create(new s<Bitmap>() {
            public final void subscribe(r<Bitmap> rVar) {
                try {
                    rVar.onNext(w.a().a(str).a(com.squareup.picasso.s.NO_CACHE, com.squareup.picasso.s.NO_STORE).a(i2, i3).d().e());
                    rVar.onComplete();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }
}
