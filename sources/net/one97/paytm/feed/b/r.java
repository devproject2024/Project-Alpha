package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.cricket.FeedCricket;
import net.one97.paytm.feed.ui.feed.c.b;

public final class r extends q implements a.C0556a {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t;
    private final ConstraintLayout u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private long x;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.vs_line, 7);
        t.put(R.id.vs, 8);
        t.put(R.id.team1_score, 9);
        t.put(R.id.team1_overs, 10);
        t.put(R.id.team2_score, 11);
        t.put(R.id.team2_overs, 12);
        t.put(R.id.team_winning_info, 13);
        t.put(R.id.refresh_score, 14);
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, s, t));
    }

    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[14], objArr[3], objArr[4], objArr[10], objArr[9], objArr[5], objArr[6], objArr[12], objArr[11], objArr[13], objArr[8], objArr[7]);
        this.x = -1;
        this.f34206a.setTag((Object) null);
        this.f34207b.setTag((Object) null);
        this.u = objArr[0];
        this.u.setTag((Object) null);
        this.f34209d.setTag((Object) null);
        this.f34210e.setTag((Object) null);
        this.f34213h.setTag((Object) null);
        this.f34214i.setTag((Object) null);
        setRootTag(view);
        this.v = new a(this, 1);
        this.w = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.x = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.x != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33778e == i2) {
            this.q = (Integer) obj;
        } else if (net.one97.paytm.feed.a.f33780g == i2) {
            this.p = (FeedCricket) obj;
            synchronized (this) {
                this.x |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.o = (net.one97.paytm.feed.ui.feed.a) obj;
            synchronized (this) {
                this.x |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33777d != i2) {
            return false;
        } else {
            this.r = (b) obj;
        }
        return true;
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.feed.a.f33774a) {
            return false;
        }
        synchronized (this) {
            this.x |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r12 = this;
            monitor-enter(r12)
            long r0 = r12.x     // Catch:{ all -> 0x0071 }
            r2 = 0
            r12.x = r2     // Catch:{ all -> 0x0071 }
            monitor-exit(r12)     // Catch:{ all -> 0x0071 }
            net.one97.paytm.feed.repository.models.cricket.FeedCricket r4 = r12.p
            r5 = 20
            long r5 = r5 & r0
            r7 = 0
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0035
            if (r4 == 0) goto L_0x0019
            net.one97.paytm.feed.repository.models.cricket.FeedCricketData r4 = r4.getFeedCricketData()
            goto L_0x001a
        L_0x0019:
            r4 = r7
        L_0x001a:
            if (r4 == 0) goto L_0x0035
            java.lang.String r5 = r4.getAwayTeamLogo()
            java.lang.String r6 = r4.getHomeTeamLogo()
            java.lang.String r9 = r4.getAwayTeamAbbr()
            java.lang.String r10 = r4.getDescription()
            java.lang.String r11 = r4.getTitle()
            java.lang.String r4 = r4.getHomeTeamAbbr()
            goto L_0x003b
        L_0x0035:
            r4 = r7
            r5 = r4
            r6 = r5
            r9 = r6
            r10 = r9
            r11 = r10
        L_0x003b:
            if (r8 == 0) goto L_0x005b
            android.widget.TextView r8 = r12.f34206a
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r10)
            android.widget.TextView r8 = r12.f34207b
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r11)
            android.widget.ImageView r8 = r12.f34209d
            net.one97.paytm.feed.utility.a.a(r8, r6, r7, r7)
            android.widget.TextView r6 = r12.f34210e
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r4)
            android.widget.ImageView r4 = r12.f34213h
            net.one97.paytm.feed.utility.a.a(r4, r5, r7, r7)
            android.widget.TextView r4 = r12.f34214i
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r9)
        L_0x005b:
            r4 = 16
            long r0 = r0 & r4
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0070
            android.widget.TextView r0 = r12.f34206a
            android.view.View$OnClickListener r1 = r12.w
            r0.setOnClickListener(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r12.u
            android.view.View$OnClickListener r1 = r12.v
            r0.setOnClickListener(r1)
        L_0x0070:
            return
        L_0x0071:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0071 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.r.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            net.one97.paytm.feed.ui.feed.a aVar = this.o;
            FeedCricket feedCricket = this.p;
            if (aVar != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.a.a(view, feedCricket);
            }
        } else if (i2 == 2) {
            net.one97.paytm.feed.ui.feed.a aVar2 = this.o;
            FeedCricket feedCricket2 = this.p;
            if (aVar2 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.a.a(view, feedCricket2);
            }
        }
    }
}
