package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.h.r;
import androidx.fragment.R;

final class c {
    static a a(Context context, d dVar, Fragment fragment, boolean z) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        View a2 = dVar.a(fragment.mContainerId);
        if (!(a2 == null || a2.getTag(R.id.visible_removing_fragment_view_tag) == null)) {
            a2.setTag(R.id.visible_removing_fragment_view_tag, (Object) null);
        }
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (nextTransition == 0) {
            return null;
        }
        int i2 = -1;
        if (nextTransition == 4097) {
            i2 = z ? R.anim.fragment_open_enter : R.anim.fragment_open_exit;
        } else if (nextTransition == 4099) {
            i2 = z ? R.anim.fragment_fade_enter : R.anim.fragment_fade_exit;
        } else if (nextTransition == 8194) {
            i2 = z ? R.anim.fragment_close_enter : R.anim.fragment_close_exit;
        }
        if (i2 < 0) {
            return null;
        }
        return new a(AnimationUtils.loadAnimation(context, i2));
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0012 A[LOOP:0: B:2:0x0012->B:28:0x0012, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(final androidx.fragment.app.Fragment r7, androidx.fragment.app.c.a r8, final androidx.fragment.app.r.a r9) {
        /*
            android.view.View r2 = r7.mView
            android.view.ViewGroup r1 = r7.mContainer
            r1.startViewTransition(r2)
            androidx.core.d.b r5 = new androidx.core.d.b
            r5.<init>()
            androidx.fragment.app.c$1 r0 = new androidx.fragment.app.c$1
            r0.<init>(r7)
            monitor-enter(r5)
        L_0x0012:
            boolean r3 = r5.f2851c     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x001a
            r5.wait()     // Catch:{ InterruptedException -> 0x0012 }
            goto L_0x0012
        L_0x001a:
            androidx.core.d.b$a r3 = r5.f2850b     // Catch:{ all -> 0x0068 }
            if (r3 != r0) goto L_0x0020
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            goto L_0x002c
        L_0x0020:
            r5.f2850b = r0     // Catch:{ all -> 0x0068 }
            boolean r3 = r5.f2849a     // Catch:{ all -> 0x0068 }
            if (r3 != 0) goto L_0x0028
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            goto L_0x002c
        L_0x0028:
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            r0.a()
        L_0x002c:
            r9.a(r7, r5)
            android.view.animation.Animation r0 = r8.f3405a
            if (r0 == 0) goto L_0x004d
            androidx.fragment.app.c$b r0 = new androidx.fragment.app.c$b
            android.view.animation.Animation r8 = r8.f3405a
            r0.<init>(r8, r1, r2)
            android.view.View r8 = r7.mView
            r7.setAnimatingAway(r8)
            androidx.fragment.app.c$2 r8 = new androidx.fragment.app.c$2
            r8.<init>(r1, r7, r9, r5)
            r0.setAnimationListener(r8)
            android.view.View r7 = r7.mView
            r7.startAnimation(r0)
            return
        L_0x004d:
            android.animation.Animator r6 = r8.f3406b
            android.animation.Animator r8 = r8.f3406b
            r7.setAnimator(r8)
            androidx.fragment.app.c$3 r8 = new androidx.fragment.app.c$3
            r0 = r8
            r3 = r7
            r4 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r6.addListener(r8)
            android.view.View r7 = r7.mView
            r6.setTarget(r7)
            r6.start()
            return
        L_0x0068:
            r7 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c.a(androidx.fragment.app.Fragment, androidx.fragment.app.c$a, androidx.fragment.app.r$a):void");
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f3405a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f3406b;

        a(Animation animation) {
            this.f3405a = animation;
            this.f3406b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f3405a = null;
            this.f3406b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class b extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f3407a;

        /* renamed from: b  reason: collision with root package name */
        private final View f3408b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3409c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3410d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3411e = true;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3407a = viewGroup;
            this.f3408b = view;
            addAnimation(animation);
            this.f3407a.post(this);
        }

        public final boolean getTransformation(long j, Transformation transformation) {
            this.f3411e = true;
            if (!this.f3409c) {
                if (!super.getTransformation(j, transformation)) {
                    this.f3409c = true;
                    r.a(this.f3407a, this);
                }
                return true;
            } else if (!this.f3410d) {
                return true;
            } else {
                return false;
            }
        }

        public final boolean getTransformation(long j, Transformation transformation, float f2) {
            this.f3411e = true;
            if (!this.f3409c) {
                if (!super.getTransformation(j, transformation, f2)) {
                    this.f3409c = true;
                    r.a(this.f3407a, this);
                }
                return true;
            } else if (!this.f3410d) {
                return true;
            } else {
                return false;
            }
        }

        public final void run() {
            if (this.f3409c || !this.f3411e) {
                this.f3407a.endViewTransition(this.f3408b);
                this.f3410d = true;
                return;
            }
            this.f3411e = false;
            this.f3407a.post(this);
        }
    }
}
