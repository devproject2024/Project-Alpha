package net.one97.paytm.feed.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.business.merchant_payments.utility.StringUtility;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.e.c;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchantData;
import net.one97.paytm.feed.ui.feed.h.a.a;
import net.one97.paytm.feed.ui.feed.h.a.b;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.s;
import net.one97.paytm.feed.utility.u;

public final class ar extends aq implements a.C0556a {
    private static final ViewDataBinding.b q = null;
    private static final SparseIntArray r = null;
    private long A;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    public ar(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, q, r));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ar(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[6], objArr[7], objArr[8], objArr[0], objArr[10], objArr[9], objArr[2], objArr[3], objArr[4], objArr[5]);
        this.A = -1;
        this.f33872a.setTag((Object) null);
        this.f33873b.setTag((Object) null);
        this.f33874c.setTag((Object) null);
        this.f33875d.setTag((Object) null);
        this.f33876e.setTag((Object) null);
        this.f33877f.setTag((Object) null);
        this.f33878g.setTag((Object) null);
        this.f33879h.setTag((Object) null);
        this.f33880i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        setRootTag(view);
        this.s = new a(this, 2);
        this.t = new a(this, 5);
        this.u = new a(this, 3);
        this.v = new a(this, 6);
        this.w = new a(this, 4);
        this.x = new a(this, 7);
        this.y = new a(this, 1);
        this.z = new a(this, 8);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.A = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33780g == i2) {
            this.l = (FeedMerchant) obj;
            synchronized (this) {
                this.A |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33778e == i2) {
            this.m = (Integer) obj;
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.n = (b) obj;
            synchronized (this) {
                this.A |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.m == i2) {
            this.o = (Integer) obj;
            synchronized (this) {
                this.A |= 16;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.m);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33777d != i2) {
            return false;
        } else {
            net.one97.paytm.feed.ui.feed.h.a.a aVar = (net.one97.paytm.feed.ui.feed.h.a.a) obj;
            updateRegistration(0, (h) aVar);
            this.p = aVar;
            synchronized (this) {
                this.A |= 1;
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
        if (i2 != net.one97.paytm.feed.a.f33774a) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        int i2;
        boolean z2;
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i4;
        int i5;
        String str8;
        String str9;
        String str10;
        String str11;
        int i6;
        String str12;
        int i7;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        FeedMerchant feedMerchant = this.l;
        Integer num = this.o;
        int i8 = ((j & 34) > 0 ? 1 : ((j & 34) == 0 ? 0 : -1));
        if (i8 != 0) {
            FeedMerchantData feedMerchantData = feedMerchant != null ? feedMerchant.getFeedMerchantData() : null;
            if (feedMerchantData != null) {
                str5 = feedMerchantData.getCreatedAt();
                str4 = feedMerchantData.getName();
                str = feedMerchantData.getImageUrl();
                z2 = feedMerchantData.isLiked();
                str12 = feedMerchantData.getTitle();
                i6 = feedMerchantData.getShareCount();
                str11 = feedMerchantData.getLogoUrl();
                str10 = feedMerchantData.getDescription();
                i7 = feedMerchantData.getLikeCount();
            } else {
                i7 = 0;
                str5 = null;
                str4 = null;
                str = null;
                z2 = false;
                str12 = null;
                i6 = 0;
                str11 = null;
                str10 = null;
            }
            int b2 = net.one97.paytm.feed.utility.b.b(str12);
            str3 = net.one97.paytm.feed.utility.b.a((Object) Integer.valueOf(i6), this.f33878g.getResources().getString(R.string.empty));
            boolean z3 = i6 <= 0;
            i4 = net.one97.paytm.feed.utility.b.b(str10);
            str7 = net.one97.paytm.feed.utility.b.a((Object) Integer.valueOf(i7), this.f33875d.getResources().getString(R.string.empty));
            boolean z4 = i7 <= 0;
            if (i8 != 0) {
                j |= z3 ? 128 : 64;
            }
            if ((j & 34) != 0) {
                j |= z4 ? 512 : 256;
            }
            int i9 = 8;
            i3 = z3 ? 8 : 0;
            if (!z4) {
                i9 = 0;
            }
            i5 = i9;
            str2 = str12;
            str6 = str11;
            str8 = str10;
            i2 = b2;
        } else {
            str8 = null;
            i5 = 0;
            i4 = 0;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            i3 = 0;
            str2 = null;
            str = null;
            z2 = false;
            i2 = 0;
        }
        int i10 = ((j & 48) > 0 ? 1 : ((j & 48) == 0 ? 0 : -1));
        int safeUnbox = i10 != 0 ? ViewDataBinding.safeUnbox(num) : 0;
        String str13 = str2;
        if (i10 != 0) {
            net.one97.paytm.feed.utility.a.a(this.f33872a, safeUnbox);
        }
        if ((j & 32) != 0) {
            this.f33872a.setOnClickListener(this.y);
            this.f33873b.setOnClickListener(this.v);
            this.f33874c.setOnClickListener(this.x);
            str9 = str5;
            net.one97.paytm.feed.utility.a.b((View) this.f33876e, this.f33876e.getResources().getDimension(R.dimen.feed_left_right_margin_));
            this.f33877f.setOnClickListener(this.z);
            this.f33879h.setOnClickListener(this.s);
            this.f33880i.setOnClickListener(this.u);
            this.j.setOnClickListener(this.w);
            this.k.setOnClickListener(this.t);
        } else {
            str9 = str5;
        }
        if ((j & 34) != 0) {
            net.one97.paytm.feed.utility.a.a(this.f33872a, str, (String) null, (String) null);
            d.a(this.f33873b, (CharSequence) str8);
            this.f33873b.setVisibility(i4);
            net.one97.paytm.feed.utility.a.c((View) this.f33874c, z2);
            d.a(this.f33875d, (CharSequence) str7);
            this.f33875d.setVisibility(i5);
            d.a(this.f33878g, (CharSequence) str3);
            this.f33878g.setVisibility(i3);
            net.one97.paytm.feed.utility.a.d(this.f33879h, str6);
            d.a(this.f33880i, (CharSequence) str4);
            d.a(this.j, (CharSequence) str9);
            d.a(this.k, (CharSequence) str13);
            this.k.setVisibility(i2);
        }
    }

    public final void a(int i2, View view) {
        View view2 = view;
        boolean z2 = true;
        switch (i2) {
            case 1:
                b bVar = this.n;
                FeedMerchant feedMerchant = this.l;
                if (bVar == null) {
                    z2 = false;
                }
                if (z2) {
                    b.a(view2, feedMerchant);
                    return;
                }
                return;
            case 2:
                b bVar2 = this.n;
                FeedMerchant feedMerchant2 = this.l;
                if (bVar2 == null) {
                    z2 = false;
                }
                if (z2) {
                    b.a(view2, feedMerchant2);
                    return;
                }
                return;
            case 3:
                b bVar3 = this.n;
                FeedMerchant feedMerchant3 = this.l;
                if (bVar3 == null) {
                    z2 = false;
                }
                if (z2) {
                    b.a(view2, feedMerchant3);
                    return;
                }
                return;
            case 4:
                b bVar4 = this.n;
                FeedMerchant feedMerchant4 = this.l;
                if (bVar4 == null) {
                    z2 = false;
                }
                if (z2) {
                    b.a(view2, feedMerchant4);
                    return;
                }
                return;
            case 5:
                b bVar5 = this.n;
                FeedMerchant feedMerchant5 = this.l;
                if (bVar5 == null) {
                    z2 = false;
                }
                if (z2) {
                    b.a(view2, feedMerchant5);
                    return;
                }
                return;
            case 6:
                b bVar6 = this.n;
                FeedMerchant feedMerchant6 = this.l;
                if (bVar6 == null) {
                    z2 = false;
                }
                if (z2) {
                    b.a(view2, feedMerchant6);
                    return;
                }
                return;
            case 7:
                b bVar7 = this.n;
                net.one97.paytm.feed.ui.feed.h.a.a aVar = this.p;
                FeedMerchant feedMerchant7 = this.l;
                if (bVar7 != null) {
                    k.c(view2, "view");
                    k.c(feedMerchant7, "post");
                    k.c(aVar, "viewModel");
                    j jVar = j.f35397a;
                    Context context = view.getContext();
                    k.a((Object) context, "view.context");
                    if (j.e(context)) {
                        c cVar = c.f34275a;
                        if (c.a(view.getContext())) {
                            u uVar = u.f35438a;
                            if (!u.a()) {
                                k.c(feedMerchant7, "post");
                                if (!feedMerchant7.getFeedMerchantData().isLiked()) {
                                    net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
                                    net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                                    net.one97.paytm.feed.e.b bVar8 = net.one97.paytm.feed.e.b.f34268c;
                                    a2.a((Context) net.one97.paytm.feed.e.b.x(), feedMerchant7.getFeedMerchantData().getId(), 1, (kotlin.g.a.b<? super String, x>) new a.C0580a(aVar));
                                } else {
                                    net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                                    net.one97.paytm.feed.repository.a.b a3 = net.one97.paytm.feed.c.a.a();
                                    net.one97.paytm.feed.e.b bVar9 = net.one97.paytm.feed.e.b.f34268c;
                                    a3.a((Context) net.one97.paytm.feed.e.b.x(), feedMerchant7.getFeedMerchantData().getId(), 0, (kotlin.g.a.b<? super String, x>) new a.b(aVar));
                                }
                                ImageView imageView = (ImageView) view2;
                                String id = feedMerchant7.getFeedMerchantData().getId();
                                if (feedMerchant7.getFeedMerchantData().isLiked()) {
                                    net.one97.paytm.feed.repository.db.a aVar4 = net.one97.paytm.feed.repository.db.a.f34614a;
                                    Context context2 = imageView.getContext();
                                    k.a((Object) context2, "view.context");
                                    net.one97.paytm.feed.repository.db.a.c(context2, id);
                                    return;
                                }
                                net.one97.paytm.feed.repository.db.a aVar5 = net.one97.paytm.feed.repository.db.a.f34614a;
                                Context context3 = imageView.getContext();
                                k.a((Object) context3, "view.context");
                                net.one97.paytm.feed.repository.db.a.b(context3, id);
                                return;
                            } else if (view2 instanceof CheckBox) {
                                CheckBox checkBox = (CheckBox) view2;
                                if (!feedMerchant7.getFeedMerchantData().isLiked()) {
                                    z2 = false;
                                }
                                checkBox.setChecked(z2);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
                        return;
                    }
                } else {
                    return;
                }
            case 8:
                b bVar10 = this.n;
                net.one97.paytm.feed.ui.feed.h.a.a aVar6 = this.p;
                FeedMerchant feedMerchant8 = this.l;
                if (bVar10 == null) {
                    z2 = false;
                }
                if (z2) {
                    k.c(view2, "view");
                    k.c(feedMerchant8, "post");
                    k.c(aVar6, "viewModel");
                    c cVar2 = c.f34275a;
                    if (c.a(view.getContext())) {
                        if (!TextUtils.isEmpty(feedMerchant8.getFeedMerchantData().getShareUrl())) {
                            s sVar = s.f35433a;
                            Context context4 = view.getContext();
                            k.a((Object) context4, "view.context");
                            s.a(feedMerchant8.getFeedMerchantData().getTitle() + StringUtility.NEW_LINE + feedMerchant8.getFeedMerchantData().getDescription() + StringUtility.NEW_LINE + feedMerchant8.getFeedMerchantData().getShareUrl(), context4);
                        }
                        Context context5 = view.getContext();
                        k.a((Object) context5, "view.context");
                        k.c(feedMerchant8, "post");
                        k.c(context5, "context");
                        net.one97.paytm.feed.c.a aVar7 = net.one97.paytm.feed.c.a.f34255a;
                        net.one97.paytm.feed.repository.a.b a4 = net.one97.paytm.feed.c.a.a();
                        String pid = feedMerchant8.getPid();
                        kotlin.g.a.b cVar3 = new a.c(aVar6);
                        k.c(context5, "context");
                        k.c(pid, "pID");
                        k.c(cVar3, "completionHandler");
                        String str = net.one97.paytm.feed.repository.a.b.f34365a;
                        StringBuilder sb = new StringBuilder();
                        net.one97.paytm.feed.e.b bVar11 = net.one97.paytm.feed.e.b.f34268c;
                        sb.append(net.one97.paytm.feed.e.b.m());
                        sb.append("/feed/user/relation");
                        net.one97.paytm.feed.e.b bVar12 = net.one97.paytm.feed.e.b.f34268c;
                        net.one97.paytm.feed.e.b.k();
                        StringBuilder sb2 = new StringBuilder();
                        net.one97.paytm.feed.e.b bVar13 = net.one97.paytm.feed.e.b.f34268c;
                        sb2.append(net.one97.paytm.feed.e.b.m());
                        sb2.append("/feed/user/relation");
                        b.by byVar = new b.by(a4, pid, cVar3, context5, sb2.toString(), new b.bz(cVar3), new b.ca(cVar3, context5));
                        byVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(context5));
                        net.one97.paytm.feed.repository.a.a a5 = net.one97.paytm.feed.repository.a.a.f34362b.a(context5);
                        if (a5 != null) {
                            a5.a(byVar);
                        }
                        net.one97.paytm.feed.events.a.a aVar8 = net.one97.paytm.feed.events.a.a.f34296a;
                        net.one97.paytm.feed.events.a.a.a("v2_feed_share", "");
                        try {
                            net.one97.paytm.feed.repository.db.a aVar9 = net.one97.paytm.feed.repository.db.a.f34614a;
                            Context context6 = view.getContext();
                            k.a((Object) context6, "view.context");
                            net.one97.paytm.feed.repository.db.a.e(context6, feedMerchant8.getPid());
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
