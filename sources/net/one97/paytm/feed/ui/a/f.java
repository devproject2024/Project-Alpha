package net.one97.paytm.feed.ui.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.ui.a.a.b;

public final class f extends i {

    /* renamed from: a  reason: collision with root package name */
    private b f34841a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f34842b;

    public final void a(View view) {
        k.c(view, "view");
    }

    public final void b() {
        HashMap hashMap = this.f34842b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public final int a() {
        return R.layout.feed_language_success;
    }

    public final void a(b bVar) {
        k.c(bVar, "listener");
        this.f34841a = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        c();
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener(new a(this));
        return onCreateDialog;
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f34843a;

        a(f fVar) {
            this.f34843a = fVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setBottomSheetCallback(new BottomSheetBehavior.a(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f34844a;

                    public final void onSlide(View view, float f2) {
                        k.c(view, "bottomSheet");
                    }

                    {
                        this.f34844a = r1;
                    }

                    public final void onStateChanged(View view, int i2) {
                        k.c(view, "bottomSheet");
                        if (i2 == 5) {
                            this.f34844a.f34843a.c();
                            this.f34844a.f34843a.dismiss();
                        }
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        this.f34865c = null;
        b bVar = this.f34841a;
        if (bVar != null) {
            bVar.a(true);
        }
        this.f34841a = null;
    }
}
