package net.one97.paytm.utils;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.utility.a;

public final class am implements View.OnTouchListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f69610a;

    /* renamed from: b  reason: collision with root package name */
    private float f69611b;

    /* renamed from: c  reason: collision with root package name */
    private float f69612c;

    /* renamed from: d  reason: collision with root package name */
    private float f69613d;

    /* renamed from: e  reason: collision with root package name */
    private float f69614e;

    public am(Activity activity) {
        this.f69610a = activity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f69611b = motionEvent.getX();
            this.f69612c = motionEvent.getY();
            return true;
        } else if (action != 1) {
            return false;
        } else {
            this.f69613d = motionEvent.getX();
            this.f69614e = motionEvent.getY();
            float f2 = this.f69611b - this.f69613d;
            float f3 = this.f69612c - this.f69614e;
            if (Math.abs(f2) > 200.0f && (f2 < 0.0f || f2 > 0.0f)) {
                return true;
            }
            if (Math.abs(f3) > 100.0f) {
                if (f3 < 0.0f) {
                    final View findViewById = this.f69610a.findViewById(R.id.lyt_scan_main);
                    this.f69610a.findViewById(R.id.qrCodeSurfaceView).setVisibility(8);
                    this.f69610a.findViewById(R.id.scan_align_rect).setVisibility(8);
                    this.f69610a.findViewById(R.id.lyt_side_buttons).setVisibility(8);
                    if (Build.VERSION.SDK_INT >= 21) {
                        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth() / 2, findViewById.getBottom() - a.a(80, (Context) this.f69610a), (float) Math.max(findViewById.getWidth(), findViewById.getHeight()), 48.0f);
                        createCircularReveal.addListener(new Animator.AnimatorListener() {
                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }

                            public final void onAnimationEnd(Animator animator) {
                                findViewById.setVisibility(8);
                                am.this.f69610a.findViewById(R.id.scan_only_main_layout).setVisibility(8);
                                am.this.f69610a.finish();
                                am.this.f69610a.overridePendingTransition(0, 0);
                            }
                        });
                        createCircularReveal.setDuration(400);
                        createCircularReveal.start();
                    } else {
                        this.f69610a.onBackPressed();
                    }
                    return true;
                } else if (f3 > 0.0f) {
                    e eVar = e.f50261a;
                    this.f69610a.startActivityForResult(e.a((Context) this.f69610a, e.c.SCANNER.getType()), 3001);
                    this.f69610a.overridePendingTransition(R.anim.wallet_bottom_up, R.anim.do_not_move);
                    return true;
                }
            }
            return false;
        }
    }
}
