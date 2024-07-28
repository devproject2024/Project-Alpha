package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.lifecycle.ai;
import androidx.lifecycle.q;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.utility.b;

public final class cx extends cw implements a.C0556a {
    private static final ViewDataBinding.b x;
    private static final SparseIntArray y;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private final View.OnClickListener I;
    private final View.OnClickListener J;
    private final View.OnClickListener K;
    private long L;
    private final ac z;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(19);
        x = bVar;
        bVar.a(0, new String[]{"feed_hide_post"}, new int[]{16}, new int[]{R.layout.feed_hide_post});
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.progress, 17);
        y.put(R.id.mute, 18);
    }

    public cx(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 19, x, y));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private cx(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[15], objArr[14], objArr[11], objArr[8], objArr[9], objArr[10], objArr[18], objArr[5], objArr[1], objArr[17], objArr[0], objArr[13], objArr[12], objArr[3], objArr[4], objArr[6], objArr[7]);
        this.L = -1;
        this.f34106a.setTag((Object) null);
        this.f34107b.setTag((Object) null);
        this.f34108c.setTag((Object) null);
        this.f34109d.setTag((Object) null);
        this.f34110e.setTag((Object) null);
        this.f34111f.setTag((Object) null);
        this.f34112g.setTag((Object) null);
        this.z = objArr[16];
        setContainedBinding(this.z);
        this.f34114i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.q.setTag((Object) null);
        this.r.setTag((Object) null);
        setRootTag(view);
        this.A = new a(this, 8);
        this.B = new a(this, 4);
        this.C = new a(this, 11);
        this.D = new a(this, 5);
        this.E = new a(this, 1);
        this.F = new a(this, 6);
        this.G = new a(this, 2);
        this.H = new a(this, 9);
        this.I = new a(this, 7);
        this.J = new a(this, 3);
        this.K = new a(this, 10);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.L = 128;
        }
        this.z.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.z.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.L     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.feed.b.ac r0 = r6.z
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.cx.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33780g == i2) {
            this.s = (FeedGeneric) obj;
            synchronized (this) {
                this.L |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33778e == i2) {
            this.t = (Integer) obj;
            synchronized (this) {
                this.L |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33778e);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.u = (net.one97.paytm.feed.ui.feed.a) obj;
            synchronized (this) {
                this.L |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.m == i2) {
            this.w = (Integer) obj;
            synchronized (this) {
                this.L |= 16;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.m);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33777d != i2) {
            return false;
        } else {
            net.one97.paytm.feed.ui.feed.d.a aVar = (net.one97.paytm.feed.ui.feed.d.a) obj;
            updateRegistration(0, (h) aVar);
            this.v = aVar;
            synchronized (this) {
                this.L |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33777d);
            super.requestRebind();
        }
        return true;
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.z.setLifecycleOwner(qVar);
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
                this.L |= 1;
            }
            return true;
        } else if (i2 == net.one97.paytm.feed.a.B) {
            synchronized (this) {
                this.L |= 32;
            }
            return true;
        } else if (i2 != net.one97.paytm.feed.a.G) {
            return false;
        } else {
            synchronized (this) {
                this.L |= 64;
            }
            return true;
        }
    }

    public final void executeBindings() {
        long j;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z2;
        String str7;
        String str8;
        String str9;
        int i4;
        String str10;
        int i5;
        int i6;
        boolean z3;
        float f2;
        int i7;
        boolean z4;
        boolean z5;
        boolean z6;
        String str11;
        boolean z7;
        Integer num;
        Integer num2;
        String str12;
        String str13;
        Integer num3;
        String str14;
        Boolean bool;
        String str15;
        String str16;
        CreatedBy createdBy;
        String str17;
        synchronized (this) {
            j = this.L;
            this.L = 0;
        }
        FeedGeneric feedGeneric = this.s;
        Integer num4 = this.w;
        net.one97.paytm.feed.ui.feed.d.a aVar = this.v;
        String str18 = null;
        int i8 = ((j & 130) > 0 ? 1 : ((j & 130) == 0 ? 0 : -1));
        if (i8 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                str16 = feedGenericData.getCreatedAt();
                str15 = feedGenericData.getWidth();
                bool = feedGenericData.isLiked();
                str14 = feedGenericData.getDescription();
                num3 = feedGenericData.getLikeCount();
                str13 = feedGenericData.getHeight();
                str12 = feedGenericData.getImageUrl();
                num2 = feedGenericData.getShareCount();
                num = feedGenericData.getCommentCount();
                z7 = feedGenericData.isBookmarked();
                str11 = feedGenericData.getTitle();
                createdBy = feedGenericData.getCreatedBy();
            } else {
                createdBy = null;
                str16 = null;
                str15 = null;
                bool = null;
                str14 = null;
                num3 = null;
                str13 = null;
                str12 = null;
                num2 = null;
                num = null;
                str11 = null;
                z7 = false;
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            boolean z8 = str14 == null;
            int safeUnbox2 = ViewDataBinding.safeUnbox(num3);
            int safeUnbox3 = ViewDataBinding.safeUnbox(num2);
            int safeUnbox4 = ViewDataBinding.safeUnbox(num);
            int b2 = b.b(str11);
            if (i8 != 0) {
                j |= z8 ? 131072 : 65536;
            }
            String num5 = num3 != null ? num3.toString() : null;
            String num6 = num2 != null ? num2.toString() : null;
            String num7 = num != null ? num.toString() : null;
            if (createdBy != null) {
                str18 = createdBy.getName();
                str17 = createdBy.getImageUrl();
            } else {
                str17 = null;
            }
            int i9 = 8;
            int i10 = z8 ? 8 : 0;
            boolean z9 = safeUnbox2 <= 0;
            boolean z10 = safeUnbox3 <= 0;
            boolean z11 = safeUnbox4 <= 0;
            if ((j & 130) != 0) {
                j |= z9 ? 2048 : 1024;
            }
            if ((j & 130) != 0) {
                j |= z10 ? 512 : 256;
            }
            if ((j & 130) != 0) {
                j |= z11 ? 32768 : 16384;
            }
            int i11 = z9 ? 8 : 0;
            int i12 = z10 ? 8 : 0;
            if (!z11) {
                i9 = 0;
            }
            str = str17;
            str9 = str16;
            str7 = str15;
            str8 = str18;
            str5 = num5;
            z2 = safeUnbox;
            str6 = str14;
            str10 = num6;
            str4 = str13;
            str3 = str12;
            str2 = num7;
            i3 = i9;
            z3 = z7;
            str18 = str11;
            i2 = i10;
            i4 = i11;
            i5 = i12;
            i6 = b2;
        } else {
            str10 = null;
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            z3 = false;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            z2 = false;
            i3 = 0;
            i2 = 0;
        }
        int i13 = ((j & 144) > 0 ? 1 : ((j & 144) == 0 ? 0 : -1));
        if (i13 != 0) {
            i7 = ViewDataBinding.safeUnbox(num4);
            boolean z12 = i7 == 1;
            if (i13 != 0) {
                j |= z12 ? 8192 : 4096;
            }
            f2 = this.l.getResources().getDimension(z12 ? R.dimen.no_dp : R.dimen.feed_left_right_margin_);
        } else {
            i7 = 0;
            f2 = 0.0f;
        }
        if ((j & 225) != 0) {
            z4 = ((j & 193) == 0 || aVar == null) ? false : aVar.f34251a;
            if ((j & 161) != 0) {
                if (aVar != null) {
                    z6 = aVar.f34252b;
                } else {
                    z6 = false;
                }
                z5 = !z6;
            } else {
                z5 = false;
            }
        } else {
            z5 = false;
            z4 = false;
        }
        if ((j & 144) != 0) {
            net.one97.paytm.feed.utility.a.a(this.f34106a, i7);
            net.one97.paytm.feed.utility.a.a((View) this.l, f2);
        }
        if ((j & 128) != 0) {
            this.f34106a.setOnClickListener(this.E);
            this.f34107b.setOnClickListener(this.C);
            this.f34108c.setOnClickListener(this.K);
            this.f34109d.setOnClickListener(this.A);
            this.f34111f.setOnClickListener(this.I);
            this.f34114i.setOnClickListener(this.B);
            this.m.setOnClickListener(this.H);
            this.o.setOnClickListener(this.G);
            this.p.setOnClickListener(this.J);
            net.one97.paytm.feed.utility.a.a(this.p);
            this.q.setOnClickListener(this.D);
            this.r.setOnClickListener(this.F);
        }
        if ((j & 130) != 0) {
            String str19 = str7;
            String str20 = str4;
            net.one97.paytm.feed.utility.a.a(this.f34106a, str3, str19, str20);
            net.one97.paytm.feed.utility.a.a((View) this.f34106a, str19, str20);
            net.one97.paytm.feed.utility.a.a(this.f34107b, z3);
            d.a(this.f34109d, (CharSequence) str2);
            this.f34109d.setVisibility(i3);
            this.f34110e.setVisibility(i2);
            d.a(this.f34110e, (CharSequence) str6);
            net.one97.paytm.feed.utility.a.c((View) this.f34111f, z2);
            d.a(this.f34112g, (CharSequence) str5);
            this.f34112g.setVisibility(i4);
            net.one97.paytm.feed.utility.a.a((View) this.j, str19, str20);
            d.a(this.n, (CharSequence) str10);
            this.n.setVisibility(i5);
            net.one97.paytm.feed.utility.a.c((ImageView) this.o, str);
            d.a(this.p, (CharSequence) str8);
            d.a(this.q, (CharSequence) str9);
            d.a(this.r, (CharSequence) str18);
            this.r.setVisibility(i6);
        }
        if ((j & 193) != 0) {
            this.z.a(Boolean.valueOf(z4));
        }
        if ((j & 161) != 0) {
            net.one97.paytm.feed.utility.a.a((View) this.f34114i, z5);
        }
        executeBindingsOn(this.z);
    }

    public final void a(int i2, View view) {
        boolean z2 = true;
        boolean z3 = false;
        switch (i2) {
            case 1:
                net.one97.paytm.feed.ui.feed.a aVar = this.u;
                Integer num = this.t;
                FeedGeneric feedGeneric = this.s;
                if (aVar == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, feedGeneric, num.intValue());
                    return;
                }
                return;
            case 2:
                net.one97.paytm.feed.ui.feed.a aVar2 = this.u;
                FeedGeneric feedGeneric2 = this.s;
                if (aVar2 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric2);
                    return;
                }
                return;
            case 3:
                net.one97.paytm.feed.ui.feed.a aVar3 = this.u;
                FeedGeneric feedGeneric3 = this.s;
                if (aVar3 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric3);
                    return;
                }
                return;
            case 4:
                net.one97.paytm.feed.ui.feed.a aVar4 = this.u;
                Integer num2 = this.t;
                net.one97.paytm.feed.ui.feed.d.a aVar5 = this.v;
                FeedGeneric feedGeneric4 = this.s;
                if (aVar4 == null) {
                    z2 = false;
                }
                if (z2) {
                    num2.intValue();
                    aVar4.d(view, feedGeneric4, aVar5);
                    return;
                }
                return;
            case 5:
                net.one97.paytm.feed.ui.feed.a aVar6 = this.u;
                FeedGeneric feedGeneric5 = this.s;
                if (aVar6 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric5);
                    return;
                }
                return;
            case 6:
                net.one97.paytm.feed.ui.feed.a aVar7 = this.u;
                Integer num3 = this.t;
                FeedGeneric feedGeneric6 = this.s;
                if (aVar7 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, feedGeneric6, num3.intValue());
                    return;
                }
                return;
            case 7:
                net.one97.paytm.feed.ui.feed.a aVar8 = this.u;
                Integer num4 = this.t;
                net.one97.paytm.feed.ui.feed.d.a aVar9 = this.v;
                FeedGeneric feedGeneric7 = this.s;
                if (aVar8 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric7, num4.intValue(), (ai) aVar9);
                    return;
                }
                return;
            case 8:
                net.one97.paytm.feed.ui.feed.a aVar10 = this.u;
                Integer num5 = this.t;
                FeedGeneric feedGeneric8 = this.s;
                if (aVar10 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric8, num5.intValue(), false);
                    return;
                }
                return;
            case 9:
                net.one97.paytm.feed.ui.feed.a aVar11 = this.u;
                net.one97.paytm.feed.ui.feed.d.a aVar12 = this.v;
                FeedGeneric feedGeneric9 = this.s;
                if (aVar11 == null) {
                    z2 = false;
                }
                if (z2) {
                    aVar11.b(view, feedGeneric9, aVar12);
                    return;
                }
                return;
            case 10:
                net.one97.paytm.feed.ui.feed.a aVar13 = this.u;
                Integer num6 = this.t;
                FeedGeneric feedGeneric10 = this.s;
                if (aVar13 != null) {
                    z3 = true;
                }
                if (z3) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric10, num6.intValue(), true);
                    return;
                }
                return;
            case 11:
                net.one97.paytm.feed.ui.feed.a aVar14 = this.u;
                net.one97.paytm.feed.ui.feed.d.a aVar15 = this.v;
                FeedGeneric feedGeneric11 = this.s;
                if (aVar14 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.c(view, feedGeneric11, aVar15);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
