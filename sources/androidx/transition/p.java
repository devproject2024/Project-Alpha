package androidx.transition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    int f4817a = -1;

    /* renamed from: b  reason: collision with root package name */
    ViewGroup f4818b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4819c;

    /* renamed from: d  reason: collision with root package name */
    private View f4820d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f4821e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f4822f;

    public p(ViewGroup viewGroup, View view) {
        this.f4818b = viewGroup;
        this.f4820d = view;
    }

    public final void a() {
        Runnable runnable;
        if (a(this.f4818b) == this && (runnable = this.f4822f) != null) {
            runnable.run();
        }
    }

    public final void b() {
        if (this.f4817a > 0 || this.f4820d != null) {
            this.f4818b.removeAllViews();
            if (this.f4817a > 0) {
                LayoutInflater.from(this.f4819c).inflate(this.f4817a, this.f4818b);
            } else {
                this.f4818b.addView(this.f4820d);
            }
        }
        Runnable runnable = this.f4821e;
        if (runnable != null) {
            runnable.run();
        }
        a(this.f4818b, this);
    }

    static void a(ViewGroup viewGroup, p pVar) {
        viewGroup.setTag(R.id.transition_current_scene, pVar);
    }

    public static p a(ViewGroup viewGroup) {
        return (p) viewGroup.getTag(R.id.transition_current_scene);
    }
}
