package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.view.d;
import androidx.appcompat.widget.t;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.e.c;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.ui.feed.actions.comment.b;
import net.one97.paytm.feed.ui.feed.actions.comment.i;

public final class n extends m implements a.C0556a {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p;
    private final LinearLayout q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private long t;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.feed_user_image, 10);
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, o, p));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[5], objArr[4], objArr[7], objArr[8], objArr[1], objArr[3], objArr[10], objArr[2], objArr[9]);
        this.t = -1;
        this.f34191a.setTag((Object) null);
        this.f34192b.setTag((Object) null);
        this.f34193c.setTag((Object) null);
        this.f34194d.setTag((Object) null);
        this.f34195e.setTag((Object) null);
        this.f34196f.setTag((Object) null);
        this.f34197g.setTag((Object) null);
        this.f34199i.setTag((Object) null);
        this.q = objArr[0];
        this.q.setTag((Object) null);
        this.j.setTag((Object) null);
        setRootTag(view);
        this.r = new a(this, 2);
        this.s = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.t = 64;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.t != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33778e == i2) {
            this.k = (Integer) obj;
            synchronized (this) {
                this.t |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33778e);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g == i2) {
            this.l = (CommentResponse) obj;
            synchronized (this) {
                this.t |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.m = (b) obj;
            synchronized (this) {
                this.t |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33777d != i2) {
            return false;
        } else {
            i iVar = (i) obj;
            updateRegistration(0, (h) iVar);
            this.n = iVar;
            synchronized (this) {
                this.t |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33777d);
            super.requestRebind();
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
        if (i2 == net.one97.paytm.feed.a.f33774a) {
            synchronized (this) {
                this.t |= 1;
            }
            return true;
        } else if (i2 == net.one97.paytm.feed.a.C) {
            synchronized (this) {
                this.t |= 16;
            }
            return true;
        } else if (i2 != net.one97.paytm.feed.a.r) {
            return false;
        } else {
            synchronized (this) {
                this.t |= 32;
            }
            return true;
        }
    }

    /* JADX WARNING: type inference failed for: r16v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.t     // Catch:{ all -> 0x00d7 }
            r4 = 0
            r1.t = r4     // Catch:{ all -> 0x00d7 }
            monitor-exit(r17)     // Catch:{ all -> 0x00d7 }
            net.one97.paytm.feed.repository.models.comment.CommentResponse r0 = r1.l
            net.one97.paytm.feed.ui.feed.actions.comment.i r6 = r1.n
            r7 = 68
            long r7 = r7 & r2
            r9 = 0
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x003a
            if (r0 == 0) goto L_0x0025
            net.one97.paytm.feed.repository.models.comment.CreatedBy r7 = r0.getCreatedBy()
            java.lang.String r8 = r0.getText()
            java.lang.String r0 = r0.getCreatedAt()
            goto L_0x0028
        L_0x0025:
            r0 = r9
            r7 = r0
            r8 = r7
        L_0x0028:
            if (r7 == 0) goto L_0x0033
            java.lang.String r11 = r7.getImageUrl()
            java.lang.String r7 = r7.getName()
            goto L_0x0035
        L_0x0033:
            r7 = r9
            r11 = r7
        L_0x0035:
            java.lang.String r0 = net.one97.paytm.feed.utility.b.a((java.lang.String) r0)
            goto L_0x003e
        L_0x003a:
            r0 = r9
            r7 = r0
            r8 = r7
            r11 = r8
        L_0x003e:
            r12 = 113(0x71, double:5.6E-322)
            long r12 = r12 & r2
            r14 = 0
            int r15 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0075
            if (r6 == 0) goto L_0x004e
            boolean r9 = r6.f34972d
            boolean r6 = r6.f34973e
            r14 = r9
            goto L_0x004f
        L_0x004e:
            r6 = 0
        L_0x004f:
            int r9 = net.one97.paytm.feed.utility.b.a((boolean) r14, (boolean) r6)
            android.view.View r12 = r17.getRoot()
            android.content.Context r12 = r12.getContext()
            java.lang.String r12 = net.one97.paytm.feed.utility.b.b(r14, r6, r12)
            android.view.View r13 = r17.getRoot()
            android.content.Context r13 = r13.getContext()
            java.lang.String r13 = net.one97.paytm.feed.utility.b.a((boolean) r14, (boolean) r6, (android.content.Context) r13)
            int r16 = net.one97.paytm.feed.utility.b.b((boolean) r14, (boolean) r6)
            r4 = r12
            r12 = r6
            r6 = r14
            r14 = r16
            goto L_0x007a
        L_0x0075:
            r4 = r9
            r13 = r4
            r6 = 0
            r9 = 0
            r12 = 0
        L_0x007a:
            if (r15 == 0) goto L_0x00a9
            android.widget.ImageView r5 = r1.f34191a
            r5.setVisibility(r9)
            android.widget.ImageView r5 = r1.f34192b
            r5.setVisibility(r14)
            android.widget.ImageView r5 = r1.f34194d
            r5.setVisibility(r9)
            android.widget.ImageView r5 = r1.f34194d
            net.one97.paytm.feed.utility.a.a((android.widget.ImageView) r5, (boolean) r6, (boolean) r12)
            android.widget.TextView r5 = r1.f34195e
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r13)
            android.widget.TextView r5 = r1.f34195e
            r5.setVisibility(r9)
            android.widget.TextView r5 = r1.f34197g
            r5.setVisibility(r14)
            android.widget.TextView r5 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r4)
            android.widget.TextView r4 = r1.j
            r4.setVisibility(r9)
        L_0x00a9:
            r4 = 64
            long r2 = r2 & r4
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00c0
            android.widget.ImageView r2 = r1.f34192b
            android.view.View$OnClickListener r3 = r1.s
            r2.setOnClickListener(r3)
            android.widget.TextView r2 = r1.j
            android.view.View$OnClickListener r3 = r1.r
            r2.setOnClickListener(r3)
        L_0x00c0:
            if (r10 == 0) goto L_0x00d6
            android.widget.TextView r2 = r1.f34193c
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
            com.makeramen.roundedimageview.RoundedImageView r0 = r1.f34196f
            net.one97.paytm.feed.utility.a.c((android.widget.ImageView) r0, (java.lang.String) r11)
            android.widget.TextView r0 = r1.f34197g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            android.widget.TextView r0 = r1.f34199i
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x00d6:
            return
        L_0x00d7:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x00d7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.n.executeBindings():void");
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.actions.comment.e eVar;
        boolean z = true;
        if (i2 == 1) {
            b bVar = this.m;
            Integer num = this.k;
            i iVar = this.n;
            CommentResponse commentResponse = this.l;
            if (bVar != null) {
                int intValue = num.intValue();
                k.c(view, "view");
                k.c(commentResponse, CJRQRScanResultModel.KEY_COMMENT_SMALL);
                k.c(iVar, "viewModel");
                net.one97.paytm.feed.ui.feed.actions.comment.e eVar2 = bVar.f34958d;
                if (eVar2 != null) {
                    eVar2.f();
                }
                bVar.f34955a = view.getContext();
                bVar.f34956b = iVar;
                bVar.f34957c = intValue;
                t tVar = new t(new d(view.getContext(), R.style.popupMenuStyle), view);
                MenuInflater b2 = tVar.b();
                k.a((Object) b2, "popup.menuInflater");
                c cVar = c.f34275a;
                if (p.a(c.i(), commentResponse.getUserId(), true)) {
                    b2.inflate(R.menu.feed_comment_actions_menu, tVar.f1796a);
                } else {
                    b2.inflate(R.menu.feed_comment_report_menu, tVar.f1796a);
                }
                tVar.f1798c = bVar;
                try {
                    Field declaredField = t.class.getDeclaredField("b");
                    k.a((Object) declaredField, "PopupMenu::class.java.getDeclaredField(\"mPopup\")");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(tVar);
                    if (obj != null) {
                        Class[] clsArr = new Class[1];
                        Class cls = Boolean.TYPE;
                        if (cls == null) {
                            k.a();
                        }
                        clsArr[0] = cls;
                        obj.getClass().getDeclaredMethod("setForceShowIcon", (Class[]) Arrays.copyOf(clsArr, 1)).invoke(obj, new Object[]{Boolean.TRUE});
                        tVar.f1797b.a();
                        tVar.f1799d = new b.C0570b(bVar);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type java.lang.Object");
                } catch (Exception unused) {
                    tVar.f1797b.a();
                }
            }
        } else if (i2 == 2) {
            b bVar2 = this.m;
            i iVar2 = this.n;
            if (bVar2 == null) {
                z = false;
            }
            if (z) {
                k.c(view, "view");
                k.c(iVar2, "viewModel");
                if (iVar2.f34972d) {
                    iVar2.f34972d = false;
                    iVar2.a(androidx.databinding.library.baseAdapters.a.sensitive);
                    CommentResponse commentResponse2 = iVar2.f34974f;
                    if (commentResponse2 != null) {
                        commentResponse2.setModerationType(net.one97.paytm.feed.ui.feed.actions.comment.a.UNMODERATED.getType());
                    }
                } else if (iVar2.f34973e && (eVar = bVar2.f34958d) != null) {
                    eVar.a(iVar2, bVar2.f34957c);
                }
            }
        }
    }
}
