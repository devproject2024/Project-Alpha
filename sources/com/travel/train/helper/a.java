package com.travel.train.helper;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.i.c;

public final class a implements RecyclerView.k {

    /* renamed from: a  reason: collision with root package name */
    private c f27255a;

    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public a(c cVar) {
        this.f27255a = cVar;
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY()) != null) {
            return false;
        }
        this.f27255a.a();
        return true;
    }
}
