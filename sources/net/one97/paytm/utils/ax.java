package net.one97.paytm.utils;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.recyclerview.widget.RecyclerView;

public final class ax implements RecyclerView.k {

    /* renamed from: a  reason: collision with root package name */
    a f69696a;

    /* renamed from: b  reason: collision with root package name */
    GestureDetector f69697b;

    /* renamed from: c  reason: collision with root package name */
    private Context f69698c;

    public interface a {
        void a(int i2);
    }

    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public ax(Context context, final RecyclerView recyclerView, a aVar) {
        this.f69698c = context;
        this.f69696a = aVar;
        this.f69697b = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (findChildViewUnder != null && ax.this.f69696a != null) {
                    recyclerView.getChildAdapterPosition(findChildViewUnder);
                }
            }
        });
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        Context context = this.f69698c;
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            View currentFocus = ((Activity) this.f69698c).getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            }
        }
        if (findChildViewUnder == null || this.f69696a == null || !this.f69697b.onTouchEvent(motionEvent)) {
            return false;
        }
        this.f69696a.a(recyclerView.getChildAdapterPosition(findChildViewUnder));
        return false;
    }
}
