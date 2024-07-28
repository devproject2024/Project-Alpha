package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.ui.spherical.b;

final class f extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, b.a {

    /* renamed from: a  reason: collision with root package name */
    e f33640a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f33641b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private final PointF f33642c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    private final a f33643d;

    /* renamed from: e  reason: collision with root package name */
    private final float f33644e;

    /* renamed from: f  reason: collision with root package name */
    private final GestureDetector f33645f;

    /* renamed from: g  reason: collision with root package name */
    private volatile float f33646g;

    interface a {
        void a(PointF pointF);
    }

    public f(Context context, a aVar) {
        this.f33643d = aVar;
        this.f33644e = 25.0f;
        this.f33645f = new GestureDetector(context, this);
        this.f33646g = 3.1415927f;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f33645f.onTouchEvent(motionEvent);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.f33641b.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x = (motionEvent2.getX() - this.f33641b.x) / this.f33644e;
        float y = (motionEvent2.getY() - this.f33641b.y) / this.f33644e;
        this.f33641b.set(motionEvent2.getX(), motionEvent2.getY());
        double d2 = (double) this.f33646g;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        this.f33642c.x -= (cos * x) - (sin * y);
        this.f33642c.y += (sin * x) + (cos * y);
        PointF pointF = this.f33642c;
        pointF.y = Math.max(-45.0f, Math.min(45.0f, pointF.y));
        this.f33643d.a(this.f33642c);
        return true;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        e eVar = this.f33640a;
        if (eVar != null) {
            return eVar.g();
        }
        return false;
    }

    public final void a(float[] fArr, float f2) {
        this.f33646g = -f2;
    }
}
