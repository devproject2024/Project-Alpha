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

public final class z extends y implements a.C0556a {
    private static final ViewDataBinding.b v;
    private static final SparseIntArray w = null;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private final View.OnClickListener I;
    private long J;
    private final ac x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(17);
        v = bVar;
        bVar.a(0, new String[]{"feed_hide_post"}, new int[]{16}, new int[]{R.layout.feed_hide_post});
    }

    public z(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 17, v, w));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private z(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[15], objArr[14], objArr[11], objArr[8], objArr[9], objArr[10], objArr[5], objArr[0], objArr[13], objArr[12], objArr[3], objArr[4], objArr[6], objArr[7], objArr[2]);
        this.J = -1;
        this.f34242a.setTag((Object) null);
        this.f34243b.setTag((Object) null);
        this.f34244c.setTag((Object) null);
        this.f34245d.setTag((Object) null);
        this.f34246e.setTag((Object) null);
        this.f34247f.setTag((Object) null);
        this.f34248g.setTag((Object) null);
        this.x = objArr[16];
        setContainedBinding(this.x);
        this.f34249h.setTag((Object) null);
        this.f34250i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        setRootTag(view);
        this.y = new a(this, 11);
        this.z = new a(this, 6);
        this.A = new a(this, 2);
        this.B = new a(this, 9);
        this.C = new a(this, 5);
        this.D = new a(this, 1);
        this.E = new a(this, 8);
        this.F = new a(this, 4);
        this.G = new a(this, 10);
        this.H = new a(this, 7);
        this.I = new a(this, 3);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.J = 128;
        }
        this.x.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.x.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.J     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.feed.b.ac r0 = r6.x
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.z.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33780g == i2) {
            this.q = (FeedGeneric) obj;
            synchronized (this) {
                this.J |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33778e == i2) {
            this.r = (Integer) obj;
            synchronized (this) {
                this.J |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33778e);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.s = (net.one97.paytm.feed.ui.feed.a) obj;
            synchronized (this) {
                this.J |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.m == i2) {
            this.u = (Integer) obj;
            synchronized (this) {
                this.J |= 16;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.m);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33777d != i2) {
            return false;
        } else {
            net.one97.paytm.feed.ui.feed.d.a aVar = (net.one97.paytm.feed.ui.feed.d.a) obj;
            updateRegistration(0, (h) aVar);
            this.t = aVar;
            synchronized (this) {
                this.J |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33777d);
            super.requestRebind();
        }
        return true;
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.x.setLifecycleOwner(qVar);
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
                this.J |= 1;
            }
            return true;
        } else if (i2 == net.one97.paytm.feed.a.B) {
            synchronized (this) {
                this.J |= 32;
            }
            return true;
        } else if (i2 != net.one97.paytm.feed.a.G) {
            return false;
        } else {
            synchronized (this) {
                this.J |= 64;
            }
            return true;
        }
    }

    public final void executeBindings() {
        long j;
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z3;
        String str10;
        int i7;
        float f2;
        int i8;
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
            j = this.J;
            this.J = 0;
        }
        FeedGeneric feedGeneric = this.q;
        Integer num4 = this.u;
        net.one97.paytm.feed.ui.feed.d.a aVar = this.t;
        String str18 = null;
        int i9 = ((j & 130) > 0 ? 1 : ((j & 130) == 0 ? 0 : -1));
        if (i9 != 0) {
            FeedGenericData feedGenericData = feedGeneric != null ? feedGeneric.getFeedGenericData() : null;
            if (feedGenericData != null) {
                str16 = feedGenericData.getStreamUrl();
                str9 = feedGenericData.getCreatedAt();
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
                str9 = null;
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
            boolean z8 = str16 == null;
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            boolean z9 = str14 == null;
            int safeUnbox2 = ViewDataBinding.safeUnbox(num3);
            int safeUnbox3 = ViewDataBinding.safeUnbox(num2);
            int safeUnbox4 = ViewDataBinding.safeUnbox(num);
            int b2 = b.b(str11);
            if (i9 != 0) {
                j |= z8 ? 2048 : 1024;
            }
            if ((j & 130) != 0) {
                j |= z9 ? 524288 : 262144;
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
            int i10 = 8;
            int i11 = z8 ? 8 : 0;
            int i12 = z9 ? 8 : 0;
            boolean z10 = safeUnbox2 <= 0;
            boolean z11 = safeUnbox3 <= 0;
            boolean z12 = safeUnbox4 <= 0;
            if ((j & 130) != 0) {
                j |= z10 ? 8192 : 4096;
            }
            if ((j & 130) != 0) {
                j |= z11 ? 512 : 256;
            }
            if ((j & 130) != 0) {
                j |= z12 ? 131072 : 65536;
            }
            int i13 = z10 ? 8 : 0;
            int i14 = z11 ? 8 : 0;
            if (!z12) {
                i10 = 0;
            }
            str2 = str17;
            i5 = i11;
            str10 = str18;
            str6 = num5;
            str8 = str15;
            z2 = safeUnbox;
            str7 = str14;
            str18 = num6;
            str5 = str13;
            str4 = str12;
            str3 = num7;
            i2 = i10;
            z3 = z7;
            str = str11;
            i7 = i12;
            i3 = i13;
            i6 = i14;
            i4 = b2;
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
            i7 = 0;
            z3 = false;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            z2 = false;
            i2 = 0;
        }
        int i15 = ((j & 144) > 0 ? 1 : ((j & 144) == 0 ? 0 : -1));
        if (i15 != 0) {
            i8 = ViewDataBinding.safeUnbox(num4);
            boolean z13 = i8 == 1;
            if (i15 != 0) {
                j |= z13 ? 32768 : 16384;
            }
            f2 = this.f34250i.getResources().getDimension(z13 ? R.dimen.no_dp : R.dimen.feed_left_right_margin_);
        } else {
            i8 = 0;
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
            net.one97.paytm.feed.utility.a.a(this.f34242a, i8);
            net.one97.paytm.feed.utility.a.b((View) this.f34250i, f2);
        }
        if ((j & 128) != 0) {
            this.f34242a.setOnClickListener(this.D);
            this.f34243b.setOnClickListener(this.y);
            this.f34244c.setOnClickListener(this.G);
            this.f34245d.setOnClickListener(this.E);
            this.f34247f.setOnClickListener(this.H);
            this.f34249h.setOnClickListener(this.F);
            this.j.setOnClickListener(this.B);
            this.l.setOnClickListener(this.A);
            this.m.setOnClickListener(this.I);
            net.one97.paytm.feed.utility.a.a(this.m);
            this.n.setOnClickListener(this.C);
            this.o.setOnClickListener(this.z);
        }
        if ((j & 130) != 0) {
            String str19 = str5;
            net.one97.paytm.feed.utility.a.a(this.f34242a, str4, str8, str19);
            net.one97.paytm.feed.utility.a.a((View) this.f34242a, str8, str19);
            net.one97.paytm.feed.utility.a.a(this.f34243b, z3);
            d.a(this.f34245d, (CharSequence) str3);
            this.f34245d.setVisibility(i2);
            this.f34246e.setVisibility(i7);
            d.a(this.f34246e, (CharSequence) str7);
            net.one97.paytm.feed.utility.a.c((View) this.f34247f, z2);
            d.a(this.f34248g, (CharSequence) str6);
            this.f34248g.setVisibility(i3);
            d.a(this.k, (CharSequence) str18);
            this.k.setVisibility(i6);
            net.one97.paytm.feed.utility.a.c((ImageView) this.l, str2);
            d.a(this.m, (CharSequence) str10);
            d.a(this.n, (CharSequence) str9);
            d.a(this.o, (CharSequence) str);
            this.o.setVisibility(i4);
            this.p.setVisibility(i5);
        }
        if ((j & 193) != 0) {
            this.x.a(Boolean.valueOf(z4));
        }
        if ((j & 161) != 0) {
            net.one97.paytm.feed.utility.a.a((View) this.f34249h, z5);
        }
        executeBindingsOn(this.x);
    }

    public final void a(int i2, View view) {
        boolean z2 = true;
        boolean z3 = false;
        switch (i2) {
            case 1:
                net.one97.paytm.feed.ui.feed.a aVar = this.s;
                Integer num = this.r;
                FeedGeneric feedGeneric = this.q;
                if (aVar == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, feedGeneric, num.intValue());
                    return;
                }
                return;
            case 2:
                net.one97.paytm.feed.ui.feed.a aVar2 = this.s;
                FeedGeneric feedGeneric2 = this.q;
                if (aVar2 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric2);
                    return;
                }
                return;
            case 3:
                net.one97.paytm.feed.ui.feed.a aVar3 = this.s;
                FeedGeneric feedGeneric3 = this.q;
                if (aVar3 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric3);
                    return;
                }
                return;
            case 4:
                net.one97.paytm.feed.ui.feed.a aVar4 = this.s;
                Integer num2 = this.r;
                net.one97.paytm.feed.ui.feed.d.a aVar5 = this.t;
                FeedGeneric feedGeneric4 = this.q;
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
                net.one97.paytm.feed.ui.feed.a aVar6 = this.s;
                FeedGeneric feedGeneric5 = this.q;
                if (aVar6 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric5);
                    return;
                }
                return;
            case 6:
                net.one97.paytm.feed.ui.feed.a aVar7 = this.s;
                Integer num3 = this.r;
                FeedGeneric feedGeneric6 = this.q;
                if (aVar7 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, feedGeneric6, num3.intValue());
                    return;
                }
                return;
            case 7:
                net.one97.paytm.feed.ui.feed.a aVar8 = this.s;
                Integer num4 = this.r;
                net.one97.paytm.feed.ui.feed.d.a aVar9 = this.t;
                FeedGeneric feedGeneric7 = this.q;
                if (aVar8 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric7, num4.intValue(), (ai) aVar9);
                    return;
                }
                return;
            case 8:
                net.one97.paytm.feed.ui.feed.a aVar10 = this.s;
                Integer num5 = this.r;
                FeedGeneric feedGeneric8 = this.q;
                if (aVar10 == null) {
                    z2 = false;
                }
                if (z2) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric8, num5.intValue(), false);
                    return;
                }
                return;
            case 9:
                net.one97.paytm.feed.ui.feed.a aVar11 = this.s;
                net.one97.paytm.feed.ui.feed.d.a aVar12 = this.t;
                FeedGeneric feedGeneric9 = this.q;
                if (aVar11 == null) {
                    z2 = false;
                }
                if (z2) {
                    aVar11.b(view, feedGeneric9, aVar12);
                    return;
                }
                return;
            case 10:
                net.one97.paytm.feed.ui.feed.a aVar13 = this.s;
                Integer num6 = this.r;
                FeedGeneric feedGeneric10 = this.q;
                if (aVar13 != null) {
                    z3 = true;
                }
                if (z3) {
                    net.one97.paytm.feed.ui.feed.a.a(view, (FeedItem) feedGeneric10, num6.intValue(), true);
                    return;
                }
                return;
            case 11:
                net.one97.paytm.feed.ui.feed.a aVar14 = this.s;
                net.one97.paytm.feed.ui.feed.d.a aVar15 = this.t;
                FeedGeneric feedGeneric11 = this.q;
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
