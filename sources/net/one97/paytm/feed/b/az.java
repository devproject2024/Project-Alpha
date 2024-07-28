package net.one97.paytm.feed.b;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.polls.Polls;
import net.one97.paytm.feed.ui.feed.i.a;
import net.one97.paytm.feed.ui.feed.i.c;
import net.one97.paytm.feed.utility.l;

public final class az extends ay {
    private static final ViewDataBinding.b A = null;
    private static final SparseIntArray B = null;
    private final ConstraintLayout C;
    private a D;
    private long E;

    public az(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, A, B));
    }

    private az(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[8], objArr[9], objArr[2], objArr[10], objArr[12], objArr[11], objArr[3], objArr[13], objArr[15], objArr[14], objArr[4], objArr[16], objArr[18], objArr[17], objArr[5], objArr[19], objArr[21], objArr[20], objArr[1], objArr[6], objArr[7]);
        this.E = -1;
        this.f33903a.setTag((Object) null);
        this.f33904b.setTag((Object) null);
        this.C = objArr[0];
        this.C.setTag((Object) null);
        this.f33905c.setTag((Object) null);
        this.f33906d.setTag((Object) null);
        this.f33907e.setTag((Object) null);
        this.f33908f.setTag((Object) null);
        this.f33909g.setTag((Object) null);
        this.f33910h.setTag((Object) null);
        this.f33911i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.q.setTag((Object) null);
        this.r.setTag((Object) null);
        this.s.setTag((Object) null);
        this.t.setTag((Object) null);
        this.u.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.E = 64;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.E != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33780g == i2) {
            this.v = (Polls) obj;
            synchronized (this) {
                this.E |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.o == i2) {
            this.x = (String) obj;
            synchronized (this) {
                this.E |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.o);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33778e == i2) {
            this.w = (Integer) obj;
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.z = (net.one97.paytm.feed.ui.feed.i.a) obj;
            synchronized (this) {
                this.E |= 16;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33777d != i2) {
            return false;
        } else {
            c cVar = (c) obj;
            updateRegistration(0, (h) cVar);
            this.y = cVar;
            synchronized (this) {
                this.E |= 1;
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
                this.E |= 1;
            }
            return true;
        } else if (i2 != net.one97.paytm.feed.a.x) {
            return false;
        } else {
            synchronized (this) {
                this.E |= 32;
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01af, code lost:
        if (r7 != null) goto L_0x01b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r52 = this;
            r1 = r52
            monitor-enter(r52)
            long r2 = r1.E     // Catch:{ all -> 0x03ec }
            r4 = 0
            r1.E = r4     // Catch:{ all -> 0x03ec }
            monitor-exit(r52)     // Catch:{ all -> 0x03ec }
            net.one97.paytm.feed.repository.models.polls.Polls r0 = r1.v
            java.lang.String r6 = r1.x
            net.one97.paytm.feed.ui.feed.i.a r7 = r1.z
            net.one97.paytm.feed.ui.feed.i.c r8 = r1.y
            r9 = 70
            long r11 = r2 & r9
            r13 = 2
            r18 = 1048576(0x100000, double:5.180654E-318)
            r15 = 3
            r20 = 8
            r21 = 66
            r9 = 1
            r10 = 0
            int r26 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x0179
            long r11 = r2 & r21
            int r26 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x0036
            if (r0 == 0) goto L_0x0036
            java.lang.String r11 = r0.getTitle()
            java.lang.String r12 = r0.getLogoUrl()
            goto L_0x0038
        L_0x0036:
            r11 = 0
            r12 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x0041
            java.util.List r27 = r0.getPollsList()
            r14 = r27
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            if (r14 == 0) goto L_0x004b
            java.lang.Object r28 = r14.get(r10)
            net.one97.paytm.feed.repository.models.polls.PollsData r28 = (net.one97.paytm.feed.repository.models.polls.PollsData) r28
            goto L_0x004d
        L_0x004b:
            r28 = 0
        L_0x004d:
            if (r28 == 0) goto L_0x0056
            java.util.List r29 = r28.getOptions()
            r4 = r29
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            if (r26 == 0) goto L_0x00be
            if (r4 == 0) goto L_0x0080
            java.lang.Object r5 = getFromList(r4, (int) r13)
            net.one97.paytm.feed.repository.models.polls.Options r5 = (net.one97.paytm.feed.repository.models.polls.Options) r5
            java.lang.Object r31 = r4.get(r10)
            net.one97.paytm.feed.repository.models.polls.Options r31 = (net.one97.paytm.feed.repository.models.polls.Options) r31
            java.lang.Object r32 = getFromList(r4, (int) r9)
            net.one97.paytm.feed.repository.models.polls.Options r32 = (net.one97.paytm.feed.repository.models.polls.Options) r32
            java.lang.Object r33 = getFromList(r4, (int) r10)
            net.one97.paytm.feed.repository.models.polls.Options r33 = (net.one97.paytm.feed.repository.models.polls.Options) r33
            java.lang.Object r34 = r4.get(r9)
            net.one97.paytm.feed.repository.models.polls.Options r34 = (net.one97.paytm.feed.repository.models.polls.Options) r34
            java.lang.Object r35 = getFromList(r4, (int) r15)
            net.one97.paytm.feed.repository.models.polls.Options r35 = (net.one97.paytm.feed.repository.models.polls.Options) r35
            goto L_0x008b
        L_0x0080:
            r5 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
        L_0x008b:
            if (r5 == 0) goto L_0x0092
            java.lang.String r5 = r5.getOptionslabel()
            goto L_0x0093
        L_0x0092:
            r5 = 0
        L_0x0093:
            if (r31 == 0) goto L_0x009a
            java.lang.String r31 = r31.getOptionslabel()
            goto L_0x009c
        L_0x009a:
            r31 = 0
        L_0x009c:
            if (r32 == 0) goto L_0x00a3
            java.lang.String r32 = r32.getOptionslabel()
            goto L_0x00a5
        L_0x00a3:
            r32 = 0
        L_0x00a5:
            if (r33 == 0) goto L_0x00ac
            java.lang.String r33 = r33.getOptionslabel()
            goto L_0x00ae
        L_0x00ac:
            r33 = 0
        L_0x00ae:
            if (r34 == 0) goto L_0x00b5
            java.lang.String r34 = r34.getOptionslabel()
            goto L_0x00b7
        L_0x00b5:
            r34 = 0
        L_0x00b7:
            if (r35 == 0) goto L_0x00c7
            java.lang.String r35 = r35.getOptionslabel()
            goto L_0x00c9
        L_0x00be:
            r5 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
        L_0x00c7:
            r35 = 0
        L_0x00c9:
            if (r4 == 0) goto L_0x00d3
            int r36 = r4.size()
            r13 = r36
            r10 = 4
            goto L_0x00d5
        L_0x00d3:
            r10 = 4
            r13 = 0
        L_0x00d5:
            if (r13 < r10) goto L_0x00d9
            r10 = 1
            goto L_0x00da
        L_0x00d9:
            r10 = 0
        L_0x00da:
            if (r13 < r15) goto L_0x00df
            r37 = 1
            goto L_0x00e1
        L_0x00df:
            r37 = 0
        L_0x00e1:
            if (r26 == 0) goto L_0x00ec
            if (r10 == 0) goto L_0x00e8
            r38 = 16384(0x4000, double:8.0948E-320)
            goto L_0x00ea
        L_0x00e8:
            r38 = 8192(0x2000, double:4.0474E-320)
        L_0x00ea:
            long r2 = r2 | r38
        L_0x00ec:
            r23 = 70
            long r38 = r2 & r23
            r29 = 0
            int r26 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r26 == 0) goto L_0x0103
            if (r10 == 0) goto L_0x00fe
            r16 = 67108864(0x4000000, double:3.31561842E-316)
            long r2 = r2 | r16
            goto L_0x0103
        L_0x00fe:
            r38 = 33554432(0x2000000, double:1.6578092E-316)
            long r2 = r2 | r38
        L_0x0103:
            long r38 = r2 & r21
            int r26 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r26 == 0) goto L_0x0114
            if (r37 == 0) goto L_0x010f
            r38 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0112
        L_0x010f:
            r38 = 32768(0x8000, double:1.61895E-319)
        L_0x0112:
            long r2 = r2 | r38
        L_0x0114:
            r23 = 70
            long r38 = r2 & r23
            int r26 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r26 == 0) goto L_0x0126
            if (r37 == 0) goto L_0x0121
            long r2 = r2 | r18
            goto L_0x0126
        L_0x0121:
            r38 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r38
        L_0x0126:
            long r38 = r2 & r21
            int r26 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r26 == 0) goto L_0x0139
            if (r10 == 0) goto L_0x0131
            r38 = 0
            goto L_0x0133
        L_0x0131:
            r38 = 8
        L_0x0133:
            if (r37 == 0) goto L_0x0136
            goto L_0x013b
        L_0x0136:
            r39 = 8
            goto L_0x013d
        L_0x0139:
            r38 = 0
        L_0x013b:
            r39 = 0
        L_0x013d:
            if (r26 == 0) goto L_0x0162
            if (r28 == 0) goto L_0x0162
            java.lang.String r26 = r28.getCreatedAt()
            java.lang.String r40 = r28.getTitle()
            r42 = r5
            r46 = r11
            r47 = r12
            r41 = r26
            r12 = r31
            r45 = r32
            r44 = r33
            r43 = r34
            r48 = r35
            r5 = r38
            r11 = r39
            r49 = r40
            goto L_0x0196
        L_0x0162:
            r42 = r5
            r46 = r11
            r47 = r12
            r12 = r31
            r45 = r32
            r44 = r33
            r43 = r34
            r48 = r35
            r5 = r38
            r11 = r39
            r41 = 0
            goto L_0x0194
        L_0x0179:
            r4 = 0
            r5 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r28 = 0
            r37 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
        L_0x0194:
            r49 = 0
        L_0x0196:
            r31 = 80
            long r33 = r2 & r31
            r29 = 0
            int r26 = (r33 > r29 ? 1 : (r33 == r29 ? 0 : -1))
            if (r26 == 0) goto L_0x01b1
            if (r7 == 0) goto L_0x01b1
            net.one97.paytm.feed.b.az$a r15 = r1.D
            if (r15 != 0) goto L_0x01ad
            net.one97.paytm.feed.b.az$a r15 = new net.one97.paytm.feed.b.az$a
            r15.<init>()
            r1.D = r15
        L_0x01ad:
            r15.f33912a = r7
            if (r7 != 0) goto L_0x01b2
        L_0x01b1:
            r15 = 0
        L_0x01b2:
            r33 = 99
            long r38 = r2 & r33
            r50 = 97
            r29 = 0
            int r7 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r7 == 0) goto L_0x0212
            if (r8 == 0) goto L_0x01c3
            boolean r8 = r8.f35078a
            goto L_0x01c4
        L_0x01c3:
            r8 = 0
        L_0x01c4:
            if (r8 != r9) goto L_0x01c8
            r8 = 1
            goto L_0x01c9
        L_0x01c8:
            r8 = 0
        L_0x01c9:
            if (r7 == 0) goto L_0x01dc
            if (r8 == 0) goto L_0x01d4
            r38 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r38
            r38 = 4096(0x1000, double:2.0237E-320)
            goto L_0x01da
        L_0x01d4:
            r38 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r38
            r38 = 2048(0x800, double:1.0118E-320)
        L_0x01da:
            long r2 = r2 | r38
        L_0x01dc:
            long r38 = r2 & r50
            r29 = 0
            int r7 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r7 == 0) goto L_0x01f7
            if (r8 == 0) goto L_0x01ee
            r38 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r38
            r38 = 262144(0x40000, double:1.295163E-318)
            goto L_0x01f5
        L_0x01ee:
            r38 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r38
            r38 = 131072(0x20000, double:6.47582E-319)
        L_0x01f5:
            long r2 = r2 | r38
        L_0x01f7:
            long r38 = r2 & r50
            r29 = 0
            int r7 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r7 == 0) goto L_0x0210
            if (r8 == 0) goto L_0x0203
            r7 = 0
            goto L_0x0205
        L_0x0203:
            r7 = 8
        L_0x0205:
            if (r8 == 0) goto L_0x020a
            r35 = 4
            goto L_0x020c
        L_0x020a:
            r35 = 0
        L_0x020c:
            r9 = r7
            r7 = r35
            goto L_0x0215
        L_0x0210:
            r7 = 0
            goto L_0x0214
        L_0x0212:
            r7 = 0
            r8 = 0
        L_0x0214:
            r9 = 0
        L_0x0215:
            r38 = 67113216(0x4001100, double:3.31583344E-316)
            long r38 = r2 & r38
            r29 = 0
            int r40 = (r38 > r29 ? 1 : (r38 == r29 ? 0 : -1))
            if (r40 == 0) goto L_0x02b1
            if (r0 == 0) goto L_0x0226
            java.util.List r14 = r0.getPollsList()
        L_0x0226:
            r0 = 0
            if (r14 == 0) goto L_0x0231
            java.lang.Object r14 = r14.get(r0)
            r28 = r14
            net.one97.paytm.feed.repository.models.polls.PollsData r28 = (net.one97.paytm.feed.repository.models.polls.PollsData) r28
        L_0x0231:
            if (r28 == 0) goto L_0x0237
            java.util.List r4 = r28.getOptions()
        L_0x0237:
            r16 = 67108864(0x4000000, double:3.31561842E-316)
            long r16 = r2 & r16
            r28 = 0
            int r14 = (r16 > r28 ? 1 : (r16 == r28 ? 0 : -1))
            if (r14 == 0) goto L_0x0256
            if (r4 == 0) goto L_0x024e
            r14 = 3
            java.lang.Object r16 = r4.get(r14)
            r14 = r16
            net.one97.paytm.feed.repository.models.polls.Options r14 = (net.one97.paytm.feed.repository.models.polls.Options) r14
            goto L_0x024f
        L_0x024e:
            r14 = 0
        L_0x024f:
            if (r14 == 0) goto L_0x0256
            java.lang.String r14 = r14.getOptionslabel()
            goto L_0x0257
        L_0x0256:
            r14 = 0
        L_0x0257:
            r16 = 4352(0x1100, double:2.15E-320)
            long r16 = r2 & r16
            r28 = 0
            int r30 = (r16 > r28 ? 1 : (r16 == r28 ? 0 : -1))
            if (r30 == 0) goto L_0x02ae
            if (r4 == 0) goto L_0x0267
            int r13 = r4.size()
        L_0x0267:
            r16 = 256(0x100, double:1.265E-321)
            long r16 = r2 & r16
            int r30 = (r16 > r28 ? 1 : (r16 == r28 ? 0 : -1))
            if (r30 == 0) goto L_0x0274
            r0 = 4
            if (r13 != r0) goto L_0x0274
            r0 = 1
            goto L_0x0275
        L_0x0274:
            r0 = 0
        L_0x0275:
            r16 = 4096(0x1000, double:2.0237E-320)
            long r16 = r2 & r16
            int r25 = (r16 > r28 ? 1 : (r16 == r28 ? 0 : -1))
            r16 = r0
            if (r25 == 0) goto L_0x02ab
            r0 = 3
            if (r13 < r0) goto L_0x0285
            r35 = 1
            goto L_0x0287
        L_0x0285:
            r35 = 0
        L_0x0287:
            long r25 = r2 & r21
            int r0 = (r25 > r28 ? 1 : (r25 == r28 ? 0 : -1))
            if (r0 == 0) goto L_0x0298
            if (r35 == 0) goto L_0x0293
            r25 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0296
        L_0x0293:
            r25 = 32768(0x8000, double:1.61895E-319)
        L_0x0296:
            long r2 = r2 | r25
        L_0x0298:
            r23 = 70
            long r25 = r2 & r23
            int r0 = (r25 > r28 ? 1 : (r25 == r28 ? 0 : -1))
            if (r0 == 0) goto L_0x02b6
            if (r35 == 0) goto L_0x02a5
            long r2 = r2 | r18
            goto L_0x02b6
        L_0x02a5:
            r25 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r25
            goto L_0x02b6
        L_0x02ab:
            r35 = r37
            goto L_0x02b6
        L_0x02ae:
            r35 = r37
            goto L_0x02b4
        L_0x02b1:
            r35 = r37
            r14 = 0
        L_0x02b4:
            r16 = 0
        L_0x02b6:
            long r25 = r2 & r33
            r28 = 0
            int r0 = (r25 > r28 ? 1 : (r25 == r28 ? 0 : -1))
            if (r0 == 0) goto L_0x02f7
            if (r8 == 0) goto L_0x02c1
            goto L_0x02c3
        L_0x02c1:
            r16 = 0
        L_0x02c3:
            if (r8 == 0) goto L_0x02c8
            r8 = r35
            goto L_0x02c9
        L_0x02c8:
            r8 = 0
        L_0x02c9:
            if (r0 == 0) goto L_0x02d6
            if (r16 == 0) goto L_0x02d1
            r25 = 16777216(0x1000000, double:8.289046E-317)
            goto L_0x02d4
        L_0x02d1:
            r25 = 8388608(0x800000, double:4.144523E-317)
        L_0x02d4:
            long r2 = r2 | r25
        L_0x02d6:
            long r25 = r2 & r33
            r28 = 0
            int r0 = (r25 > r28 ? 1 : (r25 == r28 ? 0 : -1))
            if (r0 == 0) goto L_0x02e9
            if (r8 == 0) goto L_0x02e4
            r25 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x02e7
        L_0x02e4:
            r25 = 2097152(0x200000, double:1.0361308E-317)
        L_0x02e7:
            long r2 = r2 | r25
        L_0x02e9:
            if (r16 == 0) goto L_0x02ed
            r0 = 0
            goto L_0x02ef
        L_0x02ed:
            r0 = 8
        L_0x02ef:
            if (r8 == 0) goto L_0x02f3
            r20 = 0
        L_0x02f3:
            r8 = r0
            r0 = r20
            goto L_0x02f9
        L_0x02f7:
            r0 = 0
            r8 = 0
        L_0x02f9:
            r16 = 70
            long r16 = r2 & r16
            r23 = 0
            int r13 = (r16 > r23 ? 1 : (r16 == r23 ? 0 : -1))
            if (r13 == 0) goto L_0x0308
            if (r10 == 0) goto L_0x0306
            goto L_0x0309
        L_0x0306:
            r14 = r6
            goto L_0x0309
        L_0x0308:
            r14 = 0
        L_0x0309:
            long r16 = r2 & r18
            int r10 = (r16 > r23 ? 1 : (r16 == r23 ? 0 : -1))
            if (r10 == 0) goto L_0x0321
            if (r4 == 0) goto L_0x0319
            r10 = 2
            java.lang.Object r4 = r4.get(r10)
            net.one97.paytm.feed.repository.models.polls.Options r4 = (net.one97.paytm.feed.repository.models.polls.Options) r4
            goto L_0x031a
        L_0x0319:
            r4 = 0
        L_0x031a:
            if (r4 == 0) goto L_0x0321
            java.lang.String r4 = r4.getOptionslabel()
            goto L_0x0322
        L_0x0321:
            r4 = 0
        L_0x0322:
            if (r13 == 0) goto L_0x0329
            if (r35 == 0) goto L_0x0327
            goto L_0x032a
        L_0x0327:
            r4 = r6
            goto L_0x032a
        L_0x0329:
            r4 = 0
        L_0x032a:
            long r16 = r2 & r21
            r18 = 0
            int r6 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r6 == 0) goto L_0x0381
            android.widget.TextView r6 = r1.f33903a
            r10 = r41
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
            android.widget.TextView r6 = r1.f33904b
            r10 = r49
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
            android.widget.RadioButton r6 = r1.f33905c
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r12)
            android.widget.TextView r6 = r1.f33906d
            r10 = r44
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
            android.widget.RadioButton r6 = r1.f33909g
            r10 = r43
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
            android.widget.TextView r6 = r1.f33910h
            r10 = r45
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
            android.widget.RadioButton r6 = r1.k
            r6.setVisibility(r11)
            android.widget.TextView r6 = r1.l
            r10 = r42
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r10)
            android.widget.RadioButton r6 = r1.o
            r6.setVisibility(r5)
            android.widget.TextView r5 = r1.p
            r6 = r48
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r6)
            net.one97.paytm.feed.utility.RoundCornersImageView r5 = r1.t
            r12 = r47
            r6 = 0
            net.one97.paytm.feed.utility.a.a(r5, r12, r6, r6)
            android.widget.TextView r5 = r1.u
            r11 = r46
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r11)
        L_0x0381:
            long r5 = r2 & r50
            r10 = 0
            int r12 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x03ac
            android.widget.TextView r5 = r1.f33906d
            r5.setVisibility(r9)
            android.widget.ProgressBar r5 = r1.f33907e
            r5.setVisibility(r9)
            android.widget.TextView r5 = r1.f33908f
            r5.setVisibility(r9)
            android.widget.TextView r5 = r1.f33910h
            r5.setVisibility(r9)
            android.widget.ProgressBar r5 = r1.f33911i
            r5.setVisibility(r9)
            android.widget.TextView r5 = r1.j
            r5.setVisibility(r9)
            android.widget.RadioGroup r5 = r1.s
            r5.setVisibility(r7)
        L_0x03ac:
            if (r13 == 0) goto L_0x03b8
            android.widget.RadioButton r5 = r1.k
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r4)
            android.widget.RadioButton r4 = r1.o
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r14)
        L_0x03b8:
            long r4 = r2 & r33
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x03de
            android.widget.TextView r4 = r1.l
            r4.setVisibility(r0)
            android.widget.ProgressBar r4 = r1.m
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.n
            r4.setVisibility(r0)
            android.widget.TextView r0 = r1.p
            r0.setVisibility(r8)
            android.widget.ProgressBar r0 = r1.q
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.r
            r0.setVisibility(r8)
        L_0x03de:
            long r2 = r2 & r31
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x03eb
            android.widget.RadioGroup r0 = r1.s
            r0.setOnCheckedChangeListener(r15)
        L_0x03eb:
            return
        L_0x03ec:
            r0 = move-exception
            monitor-exit(r52)     // Catch:{ all -> 0x03ec }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.az.executeBindings():void");
    }

    public static class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        net.one97.paytm.feed.ui.feed.i.a f33912a;

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            String str;
            net.one97.paytm.feed.ui.feed.i.a aVar = this.f33912a;
            k.c(radioGroup, "radioGroup");
            if (i2 == R.id.option1) {
                str = aVar.f35073b.f35079b.getPollsList().get(0).getOptions().get(0).getOptionsid();
            } else if (i2 == R.id.option2) {
                str = aVar.f35073b.f35079b.getPollsList().get(0).getOptions().get(1).getOptionsid();
            } else if (i2 == R.id.option3) {
                str = aVar.f35073b.f35079b.getPollsList().get(0).getOptions().get(2).getOptionsid();
            } else {
                str = i2 == R.id.option4 ? aVar.f35073b.f35079b.getPollsList().get(0).getOptions().get(3).getOptionsid() : null;
            }
            if (!aVar.f35072a && str != null) {
                Context context = radioGroup.getContext();
                k.a((Object) context, "radioGroup.context");
                b bVar = b.f34366b;
                String id = aVar.f35073b.f35079b.getPollsList().get(0).getId();
                kotlin.g.a.b aVar2 = new a.C0581a(aVar, context, radioGroup);
                k.c(context, "context");
                k.c(id, "id");
                k.c(str, "optionsid");
                k.c(aVar2, "completionHandler");
                l lVar = l.f35406a;
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                String h2 = net.one97.paytm.feed.e.b.h();
                String b2 = l.b(context, h2, "content-actions/v1/actions/" + id + "/polls/" + str, new HashMap());
                String str2 = b.f34365a;
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                b.bg bgVar = new b.bg(bVar, b2, aVar2, context, b2, new b.bh(aVar2, context), new b.bi(aVar2, context));
                bgVar.setRetryPolicy(b.a(context));
                net.one97.paytm.feed.repository.a.a a2 = net.one97.paytm.feed.repository.a.a.f34362b.a(context);
                if (a2 != null) {
                    a2.a(bgVar);
                }
            }
            aVar.f35072a = false;
        }
    }
}
