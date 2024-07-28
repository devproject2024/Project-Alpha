package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b.g;
import androidx.transition.Transition;
import com.business.merchant_payments.utility.StringUtility;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet extends Transition {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Transition> f4707a = new ArrayList<>();
    int o;
    boolean p = false;
    private boolean q = true;
    private int r = 0;

    public TransitionSet() {
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f4833i);
        b(g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public final TransitionSet b(int i2) {
        if (i2 == 0) {
            this.q = true;
        } else if (i2 == 1) {
            this.q = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(i2)));
        }
        return this;
    }

    public final TransitionSet a(Transition transition) {
        b(transition);
        if (this.f4692c >= 0) {
            transition.a(this.f4692c);
        }
        if ((this.r & 1) != 0) {
            transition.a(this.f4693d);
        }
        if ((this.r & 2) != 0) {
            transition.a(this.l);
        }
        if ((this.r & 4) != 0) {
            transition.a(this.n);
        }
        if ((this.r & 8) != 0) {
            transition.a(this.m);
        }
        return this;
    }

    private void b(Transition transition) {
        this.f4707a.add(transition);
        transition.f4698i = this;
    }

    public final Transition c(int i2) {
        if (i2 < 0 || i2 >= this.f4707a.size()) {
            return null;
        }
        return this.f4707a.get(i2);
    }

    /* renamed from: c */
    public final TransitionSet a(long j) {
        ArrayList<Transition> arrayList;
        super.a(j);
        if (this.f4692c >= 0 && (arrayList = this.f4707a) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4707a.get(i2).a(j);
            }
        }
        return this;
    }

    /* renamed from: b */
    public final TransitionSet a(TimeInterpolator timeInterpolator) {
        this.r |= 1;
        ArrayList<Transition> arrayList = this.f4707a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4707a.get(i2).a(timeInterpolator);
            }
        }
        return (TransitionSet) super.a(timeInterpolator);
    }

    public final Transition a(View view, boolean z) {
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            this.f4707a.get(i2).a(view, z);
        }
        return super.a(view, z);
    }

    public final Transition a(String str, boolean z) {
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            this.f4707a.get(i2).a(str, z);
        }
        return super.a(str, z);
    }

    public final Transition a(int i2, boolean z) {
        for (int i3 = 0; i3 < this.f4707a.size(); i3++) {
            this.f4707a.get(i3).a(i2, z);
        }
        return super.a(i2, z);
    }

    public final Transition a(Class<?> cls, boolean z) {
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            this.f4707a.get(i2).a(cls, z);
        }
        return super.a(cls, z);
    }

    public final void a(PathMotion pathMotion) {
        super.a(pathMotion);
        this.r |= 4;
        if (this.f4707a != null) {
            for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
                this.f4707a.get(i2).a(pathMotion);
            }
        }
    }

    static class a extends u {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f4710a;

        a(TransitionSet transitionSet) {
            this.f4710a = transitionSet;
        }

        public final void b(Transition transition) {
            if (!this.f4710a.p) {
                this.f4710a.c();
                this.f4710a.p = true;
            }
        }

        public final void a(Transition transition) {
            TransitionSet transitionSet = this.f4710a;
            transitionSet.o--;
            if (this.f4710a.o == 0) {
                TransitionSet transitionSet2 = this.f4710a;
                transitionSet2.p = false;
                transitionSet2.d();
            }
            transition.b((Transition.d) this);
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (this.f4707a.isEmpty()) {
            c();
            d();
            return;
        }
        a aVar = new a(this);
        Iterator<Transition> it2 = this.f4707a.iterator();
        while (it2.hasNext()) {
            it2.next().a((Transition.d) aVar);
        }
        this.o = this.f4707a.size();
        if (!this.q) {
            for (int i2 = 1; i2 < this.f4707a.size(); i2++) {
                final Transition transition = this.f4707a.get(i2);
                this.f4707a.get(i2 - 1).a((Transition.d) new u() {
                    public final void a(Transition transition) {
                        transition.b();
                        transition.b((Transition.d) this);
                    }
                });
            }
            Transition transition2 = this.f4707a.get(0);
            if (transition2 != null) {
                transition2.b();
                return;
            }
            return;
        }
        Iterator<Transition> it3 = this.f4707a.iterator();
        while (it3.hasNext()) {
            it3.next().b();
        }
    }

    public final void a(y yVar) {
        if (b(yVar.f4851b)) {
            Iterator<Transition> it2 = this.f4707a.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.b(yVar.f4851b)) {
                    next.a(yVar);
                    yVar.f4852c.add(next);
                }
            }
        }
    }

    public final void b(y yVar) {
        if (b(yVar.f4851b)) {
            Iterator<Transition> it2 = this.f4707a.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.b(yVar.f4851b)) {
                    next.b(yVar);
                    yVar.f4852c.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(y yVar) {
        super.c(yVar);
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).c(yVar);
        }
    }

    public final void e(View view) {
        super.e(view);
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).e(view);
        }
    }

    public final void f(View view) {
        super.f(view);
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).f(view);
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        super.e();
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).e();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z) {
        super.b(z);
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).b(z);
        }
    }

    public final void a(w wVar) {
        super.a(wVar);
        this.r |= 2;
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).a(wVar);
        }
    }

    public final void a(Transition.c cVar) {
        super.a(cVar);
        this.r |= 8;
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).a(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final String b(String str) {
        String b2 = super.b(str);
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(b2);
            sb.append(StringUtility.NEW_LINE);
            sb.append(this.f4707a.get(i2).b(str + "  "));
            b2 = sb.toString();
        }
        return b2;
    }

    /* renamed from: g */
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f4707a = new ArrayList<>();
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            transitionSet.b(this.f4707a.get(i2).clone());
        }
        return transitionSet;
    }

    /* access modifiers changed from: protected */
    public final void a(ViewGroup viewGroup, z zVar, z zVar2, ArrayList<y> arrayList, ArrayList<y> arrayList2) {
        long j = this.f4691b;
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.f4707a.get(i2);
            if (j > 0 && (this.q || i2 == 0)) {
                long j2 = transition.f4691b;
                if (j2 > 0) {
                    transition.b(j2 + j);
                } else {
                    transition.b(j);
                }
            }
            transition.a(viewGroup, zVar, zVar2, arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Transition b(ViewGroup viewGroup) {
        super.b(viewGroup);
        int size = this.f4707a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4707a.get(i2).b(viewGroup);
        }
        return this;
    }

    public final /* bridge */ /* synthetic */ Transition b(Transition.d dVar) {
        return (TransitionSet) super.b(dVar);
    }

    public final /* bridge */ /* synthetic */ Transition a(Transition.d dVar) {
        return (TransitionSet) super.a(dVar);
    }

    public final /* synthetic */ Transition d(View view) {
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            this.f4707a.get(i2).d(view);
        }
        return (TransitionSet) super.d(view);
    }

    public final /* synthetic */ Transition a(Class cls) {
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            this.f4707a.get(i2).a((Class<?>) cls);
        }
        return (TransitionSet) super.a((Class<?>) cls);
    }

    public final /* synthetic */ Transition a(String str) {
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            this.f4707a.get(i2).a(str);
        }
        return (TransitionSet) super.a(str);
    }

    public final /* synthetic */ Transition a(int i2) {
        for (int i3 = 0; i3 < this.f4707a.size(); i3++) {
            this.f4707a.get(i3).a(i2);
        }
        return (TransitionSet) super.a(i2);
    }

    public final /* synthetic */ Transition c(View view) {
        for (int i2 = 0; i2 < this.f4707a.size(); i2++) {
            this.f4707a.get(i2).c(view);
        }
        return (TransitionSet) super.c(view);
    }

    public final /* bridge */ /* synthetic */ Transition b(long j) {
        return (TransitionSet) super.b(j);
    }
}
