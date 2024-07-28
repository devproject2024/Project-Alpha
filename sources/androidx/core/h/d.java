package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f3091a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int l = ViewConfiguration.getLongPressTimeout();
        private static final int m = ViewConfiguration.getTapTimeout();
        private static final int n = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        final Handler f3092a = new a();

        /* renamed from: b  reason: collision with root package name */
        final GestureDetector.OnGestureListener f3093b;

        /* renamed from: c  reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f3094c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3095d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3096e;

        /* renamed from: f  reason: collision with root package name */
        boolean f3097f;

        /* renamed from: g  reason: collision with root package name */
        MotionEvent f3098g;

        /* renamed from: h  reason: collision with root package name */
        private int f3099h;

        /* renamed from: i  reason: collision with root package name */
        private int f3100i;
        private int j;
        private int k;
        private boolean o;
        private boolean p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        class a extends Handler {
            a() {
            }

            public final void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    b.this.f3093b.onShowPress(b.this.f3098g);
                } else if (i2 == 2) {
                    b bVar = b.this;
                    bVar.f3092a.removeMessages(3);
                    bVar.f3096e = false;
                    bVar.f3097f = true;
                    bVar.f3093b.onLongPress(bVar.f3098g);
                } else if (i2 != 3) {
                    throw new RuntimeException("Unknown message ".concat(String.valueOf(message)));
                } else if (b.this.f3094c == null) {
                } else {
                    if (!b.this.f3095d) {
                        b.this.f3094c.onSingleTapConfirmed(b.this.f3098g);
                    } else {
                        b.this.f3096e = true;
                    }
                }
            }
        }

        b(Context context, GestureDetector.OnGestureListener onGestureListener) {
            this.f3093b = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                this.f3094c = (GestureDetector.OnDoubleTapListener) onGestureListener;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f3093b != null) {
                this.w = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.j = viewConfiguration.getScaledMinimumFlingVelocity();
                this.k = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f3099h = scaledTouchSlop * scaledTouchSlop;
                this.f3100i = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:106:0x024b  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0273  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x028a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.view.MotionEvent r14) {
            /*
                r13 = this;
                int r0 = r14.getAction()
                android.view.VelocityTracker r1 = r13.x
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r13.x = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r13.x
                r1.addMovement(r14)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r4 = 1
                goto L_0x001d
            L_0x001c:
                r4 = 0
            L_0x001d:
                if (r4 == 0) goto L_0x0024
                int r5 = r14.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                int r6 = r14.getPointerCount()
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
            L_0x002d:
                if (r8 >= r6) goto L_0x003e
                if (r5 == r8) goto L_0x003b
                float r11 = r14.getX(r8)
                float r9 = r9 + r11
                float r11 = r14.getY(r8)
                float r10 = r10 + r11
            L_0x003b:
                int r8 = r8 + 1
                goto L_0x002d
            L_0x003e:
                if (r4 == 0) goto L_0x0043
                int r4 = r6 + -1
                goto L_0x0044
            L_0x0043:
                r4 = r6
            L_0x0044:
                float r4 = (float) r4
                float r9 = r9 / r4
                float r10 = r10 / r4
                r4 = 2
                r5 = 3
                if (r0 == 0) goto L_0x01f8
                r8 = 1000(0x3e8, float:1.401E-42)
                r11 = 0
                if (r0 == r2) goto L_0x016b
                if (r0 == r4) goto L_0x00f6
                if (r0 == r5) goto L_0x00ce
                r11 = 5
                if (r0 == r11) goto L_0x00a7
                if (r0 == r1) goto L_0x005b
                goto L_0x02b9
            L_0x005b:
                r13.s = r9
                r13.u = r9
                r13.t = r10
                r13.v = r10
                android.view.VelocityTracker r0 = r13.x
                int r1 = r13.k
                float r1 = (float) r1
                r0.computeCurrentVelocity(r8, r1)
                int r0 = r14.getActionIndex()
                int r1 = r14.getPointerId(r0)
                android.view.VelocityTracker r2 = r13.x
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r13.x
                float r1 = r4.getYVelocity(r1)
                r4 = 0
            L_0x0080:
                if (r4 >= r6) goto L_0x02b9
                if (r4 == r0) goto L_0x00a4
                int r5 = r14.getPointerId(r4)
                android.view.VelocityTracker r8 = r13.x
                float r8 = r8.getXVelocity(r5)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r13.x
                float r5 = r9.getYVelocity(r5)
                float r5 = r5 * r1
                float r8 = r8 + r5
                int r5 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x00a4
                android.view.VelocityTracker r14 = r13.x
                r14.clear()
                goto L_0x02b9
            L_0x00a4:
                int r4 = r4 + 1
                goto L_0x0080
            L_0x00a7:
                r13.s = r9
                r13.u = r9
                r13.t = r10
                r13.v = r10
                android.os.Handler r14 = r13.f3092a
                r14.removeMessages(r2)
                android.os.Handler r14 = r13.f3092a
                r14.removeMessages(r4)
                android.os.Handler r14 = r13.f3092a
                r14.removeMessages(r5)
                r13.r = r3
                r13.o = r3
                r13.p = r3
                r13.f3096e = r3
                boolean r14 = r13.f3097f
                if (r14 == 0) goto L_0x02b9
                r13.f3097f = r3
                goto L_0x02b9
            L_0x00ce:
                android.os.Handler r14 = r13.f3092a
                r14.removeMessages(r2)
                android.os.Handler r14 = r13.f3092a
                r14.removeMessages(r4)
                android.os.Handler r14 = r13.f3092a
                r14.removeMessages(r5)
                android.view.VelocityTracker r14 = r13.x
                r14.recycle()
                r13.x = r11
                r13.r = r3
                r13.f3095d = r3
                r13.o = r3
                r13.p = r3
                r13.f3096e = r3
                boolean r14 = r13.f3097f
                if (r14 == 0) goto L_0x02b9
                r13.f3097f = r3
                goto L_0x02b9
            L_0x00f6:
                boolean r0 = r13.f3097f
                if (r0 != 0) goto L_0x02b9
                float r0 = r13.s
                float r0 = r0 - r9
                float r1 = r13.t
                float r1 = r1 - r10
                boolean r6 = r13.r
                if (r6 == 0) goto L_0x010d
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f3094c
                boolean r14 = r0.onDoubleTapEvent(r14)
                r3 = r3 | r14
                goto L_0x02b9
            L_0x010d:
                boolean r6 = r13.o
                if (r6 == 0) goto L_0x014b
                float r6 = r13.u
                float r6 = r9 - r6
                int r6 = (int) r6
                float r7 = r13.v
                float r7 = r10 - r7
                int r7 = (int) r7
                int r6 = r6 * r6
                int r7 = r7 * r7
                int r6 = r6 + r7
                int r7 = r13.f3099h
                if (r6 <= r7) goto L_0x0142
                android.view.GestureDetector$OnGestureListener r7 = r13.f3093b
                android.view.MotionEvent r8 = r13.f3098g
                boolean r14 = r7.onScroll(r8, r14, r0, r1)
                r13.s = r9
                r13.t = r10
                r13.o = r3
                android.os.Handler r0 = r13.f3092a
                r0.removeMessages(r5)
                android.os.Handler r0 = r13.f3092a
                r0.removeMessages(r2)
                android.os.Handler r0 = r13.f3092a
                r0.removeMessages(r4)
                goto L_0x0143
            L_0x0142:
                r14 = 0
            L_0x0143:
                int r0 = r13.f3099h
                if (r6 <= r0) goto L_0x01f5
                r13.p = r3
                goto L_0x01f5
            L_0x014b:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x015d
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x02b9
            L_0x015d:
                android.view.GestureDetector$OnGestureListener r2 = r13.f3093b
                android.view.MotionEvent r3 = r13.f3098g
                boolean r3 = r2.onScroll(r3, r14, r0, r1)
                r13.s = r9
                r13.t = r10
                goto L_0x02b9
            L_0x016b:
                r13.f3095d = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r14)
                boolean r1 = r13.r
                if (r1 == 0) goto L_0x017d
                android.view.GestureDetector$OnDoubleTapListener r1 = r13.f3094c
                boolean r14 = r1.onDoubleTapEvent(r14)
                r14 = r14 | r3
                goto L_0x01d5
            L_0x017d:
                boolean r1 = r13.f3097f
                if (r1 == 0) goto L_0x0189
                android.os.Handler r14 = r13.f3092a
                r14.removeMessages(r5)
                r13.f3097f = r3
                goto L_0x01cb
            L_0x0189:
                boolean r1 = r13.o
                if (r1 == 0) goto L_0x01a0
                android.view.GestureDetector$OnGestureListener r1 = r13.f3093b
                boolean r1 = r1.onSingleTapUp(r14)
                boolean r5 = r13.f3096e
                if (r5 == 0) goto L_0x019e
                android.view.GestureDetector$OnDoubleTapListener r5 = r13.f3094c
                if (r5 == 0) goto L_0x019e
                r5.onSingleTapConfirmed(r14)
            L_0x019e:
                r14 = r1
                goto L_0x01d5
            L_0x01a0:
                android.view.VelocityTracker r1 = r13.x
                int r5 = r14.getPointerId(r3)
                int r6 = r13.k
                float r6 = (float) r6
                r1.computeCurrentVelocity(r8, r6)
                float r6 = r1.getYVelocity(r5)
                float r1 = r1.getXVelocity(r5)
                float r5 = java.lang.Math.abs(r6)
                int r7 = r13.j
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 > 0) goto L_0x01cd
                float r5 = java.lang.Math.abs(r1)
                int r7 = r13.j
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 <= 0) goto L_0x01cb
                goto L_0x01cd
            L_0x01cb:
                r14 = 0
                goto L_0x01d5
            L_0x01cd:
                android.view.GestureDetector$OnGestureListener r5 = r13.f3093b
                android.view.MotionEvent r7 = r13.f3098g
                boolean r14 = r5.onFling(r7, r14, r1, r6)
            L_0x01d5:
                android.view.MotionEvent r1 = r13.q
                if (r1 == 0) goto L_0x01dc
                r1.recycle()
            L_0x01dc:
                r13.q = r0
                android.view.VelocityTracker r0 = r13.x
                if (r0 == 0) goto L_0x01e7
                r0.recycle()
                r13.x = r11
            L_0x01e7:
                r13.r = r3
                r13.f3096e = r3
                android.os.Handler r0 = r13.f3092a
                r0.removeMessages(r2)
                android.os.Handler r0 = r13.f3092a
                r0.removeMessages(r4)
            L_0x01f5:
                r3 = r14
                goto L_0x02b9
            L_0x01f8:
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f3094c
                if (r0 == 0) goto L_0x0266
                android.os.Handler r0 = r13.f3092a
                boolean r0 = r0.hasMessages(r5)
                if (r0 == 0) goto L_0x0209
                android.os.Handler r1 = r13.f3092a
                r1.removeMessages(r5)
            L_0x0209:
                android.view.MotionEvent r1 = r13.f3098g
                if (r1 == 0) goto L_0x025e
                android.view.MotionEvent r6 = r13.q
                if (r6 == 0) goto L_0x025e
                if (r0 == 0) goto L_0x025e
                boolean r0 = r13.p
                if (r0 == 0) goto L_0x0248
                long r7 = r14.getEventTime()
                long r11 = r6.getEventTime()
                long r7 = r7 - r11
                int r0 = n
                long r11 = (long) r0
                int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r0 > 0) goto L_0x0248
                float r0 = r1.getX()
                int r0 = (int) r0
                float r6 = r14.getX()
                int r6 = (int) r6
                int r0 = r0 - r6
                float r1 = r1.getY()
                int r1 = (int) r1
                float r6 = r14.getY()
                int r6 = (int) r6
                int r1 = r1 - r6
                int r0 = r0 * r0
                int r1 = r1 * r1
                int r0 = r0 + r1
                int r1 = r13.f3100i
                if (r0 >= r1) goto L_0x0248
                r0 = 1
                goto L_0x0249
            L_0x0248:
                r0 = 0
            L_0x0249:
                if (r0 == 0) goto L_0x025e
                r13.r = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f3094c
                android.view.MotionEvent r1 = r13.f3098g
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r13.f3094c
                boolean r1 = r1.onDoubleTapEvent(r14)
                r0 = r0 | r1
                goto L_0x0267
            L_0x025e:
                android.os.Handler r0 = r13.f3092a
                int r1 = n
                long r6 = (long) r1
                r0.sendEmptyMessageDelayed(r5, r6)
            L_0x0266:
                r0 = 0
            L_0x0267:
                r13.s = r9
                r13.u = r9
                r13.t = r10
                r13.v = r10
                android.view.MotionEvent r1 = r13.f3098g
                if (r1 == 0) goto L_0x0276
                r1.recycle()
            L_0x0276:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14)
                r13.f3098g = r1
                r13.o = r2
                r13.p = r2
                r13.f3095d = r2
                r13.f3097f = r3
                r13.f3096e = r3
                boolean r1 = r13.w
                if (r1 == 0) goto L_0x02a2
                android.os.Handler r1 = r13.f3092a
                r1.removeMessages(r4)
                android.os.Handler r1 = r13.f3092a
                android.view.MotionEvent r3 = r13.f3098g
                long r5 = r3.getDownTime()
                int r3 = m
                long r7 = (long) r3
                long r5 = r5 + r7
                int r3 = l
                long r7 = (long) r3
                long r5 = r5 + r7
                r1.sendEmptyMessageAtTime(r4, r5)
            L_0x02a2:
                android.os.Handler r1 = r13.f3092a
                android.view.MotionEvent r3 = r13.f3098g
                long r3 = r3.getDownTime()
                int r5 = m
                long r5 = (long) r5
                long r3 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r3)
                android.view.GestureDetector$OnGestureListener r1 = r13.f3093b
                boolean r14 = r1.onDown(r14)
                r3 = r0 | r14
            L_0x02b9:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.h.d.b.a(android.view.MotionEvent):boolean");
        }
    }

    static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f3102a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener) {
            this.f3102a = new GestureDetector(context, onGestureListener, (Handler) null);
        }

        public final boolean a(MotionEvent motionEvent) {
            return this.f3102a.onTouchEvent(motionEvent);
        }
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private d(Context context, GestureDetector.OnGestureListener onGestureListener, byte b2) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f3091a = new c(context, onGestureListener);
        } else {
            this.f3091a = new b(context, onGestureListener);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        return this.f3091a.a(motionEvent);
    }
}
