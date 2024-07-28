package com.paytm.android.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.DensityUtil;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.k;

public final class g extends l.a {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f42576a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView.v f42577b;

    /* renamed from: c  reason: collision with root package name */
    private View f42578c;

    /* renamed from: d  reason: collision with root package name */
    private float f42579d;

    /* renamed from: e  reason: collision with root package name */
    private float f42580e;

    /* renamed from: f  reason: collision with root package name */
    private long f42581f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f42582g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f42583h;

    /* renamed from: i  reason: collision with root package name */
    private final Context f42584i;
    /* access modifiers changed from: private */
    public final h j;

    public final void a(RecyclerView.v vVar) {
        k.c(vVar, "viewHolder");
    }

    public final boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
        k.c(recyclerView, "recyclerView");
        k.c(vVar, "viewHolder");
        k.c(vVar2, "target");
        return false;
    }

    public static final /* synthetic */ View b(g gVar) {
        View view = gVar.f42578c;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public g(Context context, h hVar) {
        k.c(context, "context");
        k.c(hVar, "swipeControllerActions");
        this.f42584i = context;
        this.j = hVar;
    }

    public final int a(RecyclerView recyclerView, RecyclerView.v vVar) {
        k.c(recyclerView, "recyclerView");
        k.c(vVar, "viewHolder");
        View view = vVar.itemView;
        k.a((Object) view, "viewHolder.itemView");
        this.f42578c = view;
        this.f42576a = this.f42584i.getResources().getDrawable(R.drawable.chat_ic_msg_reply);
        if (!(vVar instanceof a)) {
            return l.a.b(0, 0);
        }
        if (((a) vVar).t) {
            return l.a.b(0, 8);
        }
        return l.a.b(0, 0);
    }

    public final int c(int i2, int i3) {
        if (!this.f42582g) {
            return super.c(i2, i3);
        }
        this.f42582g = false;
        return 0;
    }

    static final class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f42585a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f42586b;

        a(g gVar, RecyclerView.v vVar) {
            this.f42585a = gVar;
            this.f42586b = vVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            g gVar = this.f42585a;
            k.a((Object) motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            boolean z = true;
            if (!(motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                z = false;
            }
            gVar.f42582g = z;
            if (this.f42585a.f42582g && Math.abs(g.b(this.f42585a).getTranslationX()) >= ((float) g.a(100))) {
                this.f42585a.j.a(this.f42586b.getAdapterPosition());
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static int a(int i2) {
        return Math.round(DensityUtil.px2dp((float) i2));
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
        float f4;
        float f5;
        int i3;
        k.c(canvas, "c");
        k.c(recyclerView, "recyclerView");
        k.c(vVar, "viewHolder");
        boolean z2 = true;
        if (i2 == 1) {
            recyclerView.setOnTouchListener(new a(this, vVar));
        }
        View view = this.f42578c;
        if (view == null) {
            k.a("mView");
        }
        if (view.getTranslationX() < ((float) a(530)) || f2 < this.f42579d) {
            super.a(canvas, recyclerView, vVar, f2, f3, i2, z);
            this.f42579d = f2;
            this.f42583h = true;
        }
        this.f42577b = vVar;
        if (this.f42577b != null) {
            View view2 = this.f42578c;
            if (view2 == null) {
                k.a("mView");
            }
            float translationX = view2.getTranslationX();
            long currentTimeMillis = System.currentTimeMillis();
            long min = Math.min(17, currentTimeMillis - this.f42581f);
            this.f42581f = currentTimeMillis;
            if (translationX < ((float) a(30))) {
                z2 = false;
            }
            if (z2) {
                float f6 = this.f42580e;
                if (f6 < 1.0f) {
                    this.f42580e = f6 + (((float) min) / 180.0f);
                    if (this.f42580e > 1.0f) {
                        this.f42580e = 1.0f;
                    } else {
                        View view3 = this.f42578c;
                        if (view3 == null) {
                            k.a("mView");
                        }
                        view3.invalidate();
                    }
                }
            } else if (translationX <= 0.0f) {
                this.f42580e = 0.0f;
                this.f42583h = false;
            } else {
                float f7 = this.f42580e;
                if (f7 > 0.0f) {
                    this.f42580e = f7 - (((float) min) / 180.0f);
                    if (this.f42580e < 0.1f) {
                        this.f42580e = 0.0f;
                    } else {
                        View view4 = this.f42578c;
                        if (view4 == null) {
                            k.a("mView");
                        }
                        view4.invalidate();
                    }
                }
            }
            if (z2) {
                float f8 = this.f42580e;
                f4 = f8 <= 0.8f ? (f8 / 0.8f) * 1.2f : 1.2f - (((f8 - 0.8f) / 0.2f) * 0.2f);
                f5 = Math.min(255.0f, (this.f42580e / 0.8f) * 255.0f);
            } else {
                f4 = this.f42580e;
                f5 = Math.min(255.0f, f4 * 255.0f);
            }
            int i4 = (int) f5;
            Drawable drawable = this.f42576a;
            if (drawable != null) {
                drawable.setAlpha(i4);
            }
            View view5 = this.f42578c;
            if (view5 == null) {
                k.a("mView");
            }
            if (view5.getTranslationX() > ((float) a(530))) {
                i3 = a(530) / 2;
            } else {
                View view6 = this.f42578c;
                if (view6 == null) {
                    k.a("mView");
                }
                i3 = (int) (view6.getTranslationX() / 2.0f);
            }
            View view7 = this.f42578c;
            if (view7 == null) {
                k.a("mView");
            }
            int top = view7.getTop();
            View view8 = this.f42578c;
            if (view8 == null) {
                k.a("mView");
            }
            float measuredHeight = (float) (top + (view8.getMeasuredHeight() / 2));
            Drawable drawable2 = this.f42576a;
            if (drawable2 != null) {
                float f9 = (float) i3;
                drawable2.setBounds((int) (f9 - (((float) a(40)) * f4)), (int) (measuredHeight - (((float) a(40)) * f4)), (int) (f9 + (((float) a(40)) * f4)), (int) (measuredHeight + (((float) a(40)) * f4)));
            }
            Drawable drawable3 = this.f42576a;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            Drawable drawable4 = this.f42576a;
            if (drawable4 != null) {
                drawable4.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
            }
        }
    }
}
