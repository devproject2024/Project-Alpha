package net.one97.paytm.common.widgets;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.SectionIndexer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class k extends RecyclerView.c {
    private float A;
    private int B = -1;

    /* renamed from: a  reason: collision with root package name */
    float f49924a;

    /* renamed from: b  reason: collision with root package name */
    float f49925b;

    /* renamed from: c  reason: collision with root package name */
    float f49926c;

    /* renamed from: d  reason: collision with root package name */
    float f49927d;

    /* renamed from: e  reason: collision with root package name */
    float f49928e;

    /* renamed from: f  reason: collision with root package name */
    int f49929f;

    /* renamed from: g  reason: collision with root package name */
    int f49930g;

    /* renamed from: h  reason: collision with root package name */
    int f49931h = -1;

    /* renamed from: i  reason: collision with root package name */
    RecyclerView f49932i = null;
    String[] j = null;
    RectF k;
    int l;
    int m;
    boolean n = true;
    int o;
    Typeface p = null;
    Boolean q = Boolean.TRUE;
    Boolean r = Boolean.FALSE;
    String s;
    String t;
    String u;
    int v;
    Handler w = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                k.this.f49932i.invalidate();
            }
        }
    };
    private boolean x = false;
    private SectionIndexer y = null;
    private float z;

    public k(Context context, IndexFastScrollRecyclerView indexFastScrollRecyclerView) {
        this.l = indexFastScrollRecyclerView.f49852a;
        this.z = indexFastScrollRecyclerView.f49853b;
        this.A = indexFastScrollRecyclerView.f49854c;
        this.m = indexFastScrollRecyclerView.f49855d;
        this.o = indexFastScrollRecyclerView.f49856e;
        this.s = indexFastScrollRecyclerView.f49858g;
        this.t = indexFastScrollRecyclerView.f49859h;
        this.u = indexFastScrollRecyclerView.f49860i;
        this.v = (int) (indexFastScrollRecyclerView.f49857f * 255.0f);
        this.f49927d = context.getResources().getDisplayMetrics().density;
        this.f49928e = context.getResources().getDisplayMetrics().scaledDensity;
        this.f49932i = indexFastScrollRecyclerView;
        a(this.f49932i.getAdapter());
        float f2 = this.z;
        float f3 = this.f49927d;
        this.f49924a = f2 * f3;
        this.f49925b = this.A * f3;
        this.f49926c = ((float) this.m) * f3;
    }

    public final boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.x) {
                    if (a(motionEvent.getX(), motionEvent.getY())) {
                        this.f49931h = a(motionEvent.getY());
                        String[] strArr = this.j;
                        if (strArr != null && this.f49931h > strArr.length - 1) {
                            this.f49931h = strArr.length - 1;
                        }
                        a();
                    }
                    return true;
                }
            } else if (this.x) {
                this.x = false;
                this.f49931h = -1;
            }
        } else if (a(motionEvent.getX(), motionEvent.getY())) {
            this.x = true;
            this.f49931h = a(motionEvent.getY());
            String[] strArr2 = this.j;
            if (strArr2 != null && this.f49931h > strArr2.length - 1) {
                this.f49931h = strArr2.length - 1;
            }
            a();
            return true;
        }
        return false;
    }

    private void a() {
        try {
            int positionForSection = this.y.getPositionForSection(this.f49931h);
            RecyclerView.LayoutManager layoutManager = this.f49932i.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(positionForSection, 0);
            } else {
                layoutManager.scrollToPosition(positionForSection);
            }
        } catch (Exception unused) {
        }
    }

    public final void a(RecyclerView.a aVar) {
        if (aVar instanceof SectionIndexer) {
            aVar.registerAdapterDataObserver(this);
            this.y = (SectionIndexer) aVar;
            this.j = (String[]) this.y.getSections();
        }
    }

    public final void onChanged() {
        super.onChanged();
        this.j = (String[]) this.y.getSections();
    }

    public final boolean a(float f2, float f3) {
        return f2 >= this.k.left && f3 >= this.k.top && f3 <= this.k.top + this.k.height();
    }

    private int a(float f2) {
        String[] strArr = this.j;
        if (strArr == null || strArr.length == 0 || f2 < this.k.top + this.f49925b) {
            return 0;
        }
        if (f2 >= (this.k.top + this.k.height()) - this.f49925b) {
            return this.j.length - 1;
        }
        return (int) (((f2 - this.k.top) - this.f49925b) / ((this.k.height() - (this.f49925b * 2.0f)) / 26.0f));
    }
}
