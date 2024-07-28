package net.one97.paytm.recharge.common.d;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.b;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.n;
import net.one97.paytm.recharge.common.e.k;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class i extends n.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f61062a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f61063b;

    /* renamed from: c  reason: collision with root package name */
    private Context f61064c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61065d;

    /* renamed from: e  reason: collision with root package name */
    private k f61066e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f61067f;

    public i(View view, Context context, Boolean bool, k kVar) {
        super(view);
        this.f61062a = (TextView) view.findViewById(R.id.operator_name_v2);
        this.f61063b = (ImageView) view.findViewById(R.id.operator_image_v2);
        this.f61067f = (ImageView) view.findViewById(R.id.operator_bg_image);
        this.f61064c = context;
        this.f61065d = bool.booleanValue();
        this.f61066e = kVar;
        view.setOnClickListener(this);
        view.setOnTouchListener(new View.OnTouchListener(view) {
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return i.this.a(this.f$1, view, motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(final View view, View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.animate().scaleX(0.95f).scaleY(0.95f);
            return true;
        } else if (action == 1) {
            view.animate().scaleX(1.0f).scaleY(1.0f).setListener(new Animator.AnimatorListener() {
                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    view.performClick();
                }
            });
            return true;
        } else if (action != 3) {
            return false;
        } else {
            view.animate().scaleX(1.0f).scaleY(1.0f);
            return false;
        }
    }

    public final void a(CJRAggsItem cJRAggsItem) {
        if (cJRAggsItem != null) {
            b.c(this.f61062a);
            b.f(this.f61064c);
            this.f61062a.setText(cJRAggsItem.getDisplayValue().trim());
            if (cJRAggsItem.getBgImageUrl() == null) {
                this.f61067f.setVisibility(4);
            } else if (!TextUtils.isEmpty(cJRAggsItem.getBgImageUrl())) {
                this.f61067f.setVisibility(0);
                w.a().a(cJRAggsItem.getBgImageUrl().replace(" ", "%20")).a(this.f61067f, (e) null);
            } else {
                this.f61067f.setVisibility(4);
            }
            if (cJRAggsItem.getImageUrl() == null) {
                this.f61063b.setVisibility(4);
            } else if (!TextUtils.isEmpty(cJRAggsItem.getImageUrl())) {
                this.f61063b.setVisibility(0);
                w.a().a(cJRAggsItem.getImageUrl().replace(" ", "%20")).a(this.f61063b, (e) null);
            } else {
                this.f61063b.setVisibility(4);
            }
        }
    }

    public final void onClick(View view) {
        this.f61066e.c(getAdapterPosition());
    }
}
