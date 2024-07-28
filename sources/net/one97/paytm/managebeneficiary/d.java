package net.one97.paytm.managebeneficiary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, View> f53274a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f53275b = 400;

    /* renamed from: c  reason: collision with root package name */
    private Context f53276c;

    public d(Context context) {
        this.f53276c = context;
    }

    public final View a(View view, ViewGroup viewGroup, String str) {
        View b2 = b(view, viewGroup, str);
        if (b2 == null) {
            return null;
        }
        a(b2, (long) this.f53275b).start();
        return b2;
    }

    private View b(View view, ViewGroup viewGroup, String str) {
        if (view == null || viewGroup == null) {
            return null;
        }
        if (this.f53274a.containsKey(Integer.valueOf(view.getId()))) {
            return this.f53274a.get(Integer.valueOf(view.getId()));
        }
        TextView textView = new TextView(this.f53276c);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setTextSize(11.0f);
        textView.setText(str);
        textView.setPadding(5, 5, 5, 5);
        textView.setVisibility(4);
        a(textView);
        c(textView);
        viewGroup.addView(textView);
        a(textView, a(textView, view, viewGroup));
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        int id = view.getId();
        textView.setTag(Integer.valueOf(id));
        this.f53274a.put(Integer.valueOf(id), textView);
        return textView;
    }

    private void a(TextView textView, Point point) {
        a aVar = new a(textView);
        int i2 = point.y - aVar.f53284b;
        textView.setTranslationX((float) (point.x - aVar.f53283a));
        textView.setTranslationY((float) i2);
    }

    private void a(TextView textView) {
        if (Build.VERSION.SDK_INT >= 21) {
            textView.setOutlineProvider(new ViewOutlineProvider() {
                public final void getOutline(View view, Outline outline) {
                    outline.setEmpty();
                }
            });
            textView.setElevation(10.0f);
        }
    }

    public final void a() {
        if (!this.f53274a.isEmpty()) {
            for (Map.Entry value : new ArrayList(this.f53274a.entrySet())) {
                a((View) value.getValue());
            }
        }
        this.f53274a.clear();
    }

    public final boolean b(View view) {
        return this.f53274a.containsKey(Integer.valueOf(view.getId()));
    }

    private static ObjectAnimator a(View view, long j) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f})});
        ofPropertyValuesHolder.setDuration(j);
        ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator());
        return ofPropertyValuesHolder;
    }

    private static void c(View view) {
        Drawable a2 = a(view.getContext(), R.drawable.pb_mb_tooltip_arrow_down_right, Color.parseColor("#FFFFFF"));
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackground(a2);
        } else {
            view.setBackgroundDrawable(a2);
        }
    }

    private static Drawable a(Context context, int i2, int i3) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = context.getResources().getDrawable(i2, (Resources.Theme) null);
            if (drawable != null) {
                drawable.setTint(i3);
            }
        } else {
            drawable = context.getResources().getDrawable(i2);
            if (drawable != null) {
                drawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
            }
        }
        return drawable;
    }

    private Point a(TextView textView, View view, ViewGroup viewGroup) {
        Point point = new Point();
        a aVar = new a(view);
        a aVar2 = new a(viewGroup);
        textView.measure(-2, -2);
        point.x = (aVar.f53283a + view.getWidth()) - textView.getMeasuredWidth();
        a(textView, viewGroup, point, aVar, aVar2);
        point.y = aVar.f53284b - textView.getMeasuredHeight();
        point.x += 0;
        point.y += 0;
        point.x -= viewGroup.getPaddingLeft();
        point.y -= viewGroup.getPaddingTop();
        return point;
    }

    private static void a(TextView textView, ViewGroup viewGroup, Point point, a aVar, a aVar2) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        int paddingLeft = aVar2.f53283a + viewGroup.getPaddingLeft();
        if (point.x < paddingLeft) {
            point.x = paddingLeft;
            layoutParams.width = aVar.f53285c - paddingLeft;
            layoutParams.height = -2;
            textView.setLayoutParams(layoutParams);
            a(textView, layoutParams.width);
        }
    }

    private static void a(TextView textView, int i2) {
        textView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), -2);
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f53283a;

        /* renamed from: b  reason: collision with root package name */
        int f53284b;

        /* renamed from: c  reason: collision with root package name */
        int f53285c;

        /* renamed from: d  reason: collision with root package name */
        int f53286d;

        a(View view) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.f53283a = iArr[0];
            this.f53285c = this.f53283a + view.getWidth();
            this.f53284b = iArr[1];
            this.f53286d = this.f53284b + view.getHeight();
        }
    }

    public final boolean a(final View view) {
        if (view != null) {
            if (view.getVisibility() == 0) {
                this.f53274a.remove(Integer.valueOf(((Integer) view.getTag()).intValue()));
                long j = (long) this.f53275b;
                final AnonymousClass3 r1 = new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                    }
                };
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.0f})});
                ofPropertyValuesHolder.setDuration(j);
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        view.setVisibility(8);
                        AnimatorListenerAdapter animatorListenerAdapter = r1;
                        if (animatorListenerAdapter != null) {
                            animatorListenerAdapter.onAnimationEnd(animator);
                        }
                    }
                });
                ofPropertyValuesHolder.setInterpolator(new AnticipateOvershootInterpolator());
                ofPropertyValuesHolder.start();
                return true;
            }
        }
        return false;
    }
}
