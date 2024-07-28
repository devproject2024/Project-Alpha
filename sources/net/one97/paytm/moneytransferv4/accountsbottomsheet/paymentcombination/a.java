package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.ah;
import net.one97.paytm.moneytransfer.c.w;
import net.one97.paytm.moneytransfer.c.x;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final int f55066a = 12;

    /* renamed from: b  reason: collision with root package name */
    final int f55067b = 4;

    /* renamed from: c  reason: collision with root package name */
    boolean f55068c = true;

    /* renamed from: d  reason: collision with root package name */
    int f55069d = -1;

    /* renamed from: e  reason: collision with root package name */
    int f55070e = -1;

    /* renamed from: f  reason: collision with root package name */
    boolean f55071f = a(this.f55074i);

    /* renamed from: g  reason: collision with root package name */
    boolean f55072g;

    /* renamed from: h  reason: collision with root package name */
    boolean f55073h;

    /* renamed from: i  reason: collision with root package name */
    List<PaymentOptionItem> f55074i;
    final b j;
    final Map<String, String> k;
    private final int l = 1;
    private final int m = 2;
    private final int n = 3;

    public interface b {
        void a(int i2, PaymentOptionItem paymentOptionItem);

        void a(View view, PaymentOptionItem paymentOptionItem, CircularProgressBar circularProgressBar);

        void a(PaymentOptionItem paymentOptionItem);

        void a(PaymentOptionItem paymentOptionItem, int i2);

        void c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005b, code lost:
        r1 = r0.getSourcePayment();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(java.util.List<net.one97.paytm.common.entity.p2p.PaymentOptionItem> r5, net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a.b r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "paymentOptionsList"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "listener"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "balanceMap"
            kotlin.g.b.k.c(r7, r0)
            r4.<init>()
            r4.f55074i = r5
            r4.j = r6
            r4.k = r7
            r5 = 12
            r4.f55066a = r5
            r5 = 4
            r4.f55067b = r5
            r5 = 1
            r4.f55068c = r5
            r6 = -1
            r4.f55069d = r6
            r4.f55070e = r6
            r4.l = r5
            r6 = 2
            r4.m = r6
            r6 = 3
            r4.n = r6
            java.util.List<net.one97.paytm.common.entity.p2p.PaymentOptionItem> r6 = r4.f55074i
            boolean r6 = a(r6)
            r4.f55071f = r6
            java.util.List<net.one97.paytm.common.entity.p2p.PaymentOptionItem> r6 = r4.f55074i
            int r7 = r6.size()
            java.util.Iterator r6 = r6.iterator()
        L_0x0041:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0093
            java.lang.Object r0 = r6.next()
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r0 = (net.one97.paytm.common.entity.p2p.PaymentOptionItem) r0
            java.lang.String r1 = r0.getCombinationName()
            java.lang.String r2 = "UPI_NEW_BANK_ACCOUNT_ADDITION"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r5)
            if (r1 != 0) goto L_0x0090
            if (r0 == 0) goto L_0x0066
            net.one97.paytm.common.entity.p2p.SourcePayment r1 = r0.getSourcePayment()
            if (r1 == 0) goto L_0x0066
            java.lang.String r1 = r1.getPaymentInstrumentStatus()
            goto L_0x0067
        L_0x0066:
            r1 = 0
        L_0x0067:
            if (r1 != 0) goto L_0x006a
            goto L_0x0090
        L_0x006a:
            int r2 = r1.hashCode()
            r3 = -891611359(0xffffffffcadb1721, float:-7179152.5)
            if (r2 == r3) goto L_0x008a
            r3 = 1053567612(0x3ecc2a7c, float:0.39876163)
            if (r2 == r3) goto L_0x0079
            goto L_0x0090
        L_0x0079:
            java.lang.String r2 = "DISABLED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0090
            net.one97.paytm.common.entity.p2p.SenderDisplayInformation r0 = r0.getSenderDisplayInformation()
            if (r0 == 0) goto L_0x0041
            int r7 = r7 + 1
            goto L_0x0041
        L_0x008a:
            java.lang.String r0 = "ENABLED"
            boolean r0 = r1.equals(r0)
        L_0x0090:
            int r7 = r7 + -1
            goto L_0x0041
        L_0x0093:
            if (r7 <= 0) goto L_0x0097
            r4.f55073h = r5
        L_0x0097:
            boolean r5 = r4.f55073h
            r4.f55073h = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a.<init>(java.util.List, net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a$b, java.util.Map):void");
    }

    public final void a(List<PaymentOptionItem> list, int i2) {
        k.c(list, "list");
        this.f55070e = i2;
        this.f55074i = list;
        this.f55071f = a(this.f55074i);
        notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r3 = r2.getSourcePayment();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.util.List<net.one97.paytm.common.entity.p2p.PaymentOptionItem> r7) {
        /*
            java.util.Iterator r7 = r7.iterator()
            r0 = 0
            r1 = 0
        L_0x0006:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r7.next()
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r2 = (net.one97.paytm.common.entity.p2p.PaymentOptionItem) r2
            java.lang.String r3 = r2.getCombinationName()
            r4 = 1
            java.lang.String r5 = "UPI_NEW_BANK_ACCOUNT_ADDITION"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r4)
            if (r3 != 0) goto L_0x0006
            if (r2 == 0) goto L_0x002c
            net.one97.paytm.common.entity.p2p.SourcePayment r3 = r2.getSourcePayment()
            if (r3 == 0) goto L_0x002c
            java.lang.String r3 = r3.getPaymentInstrumentStatus()
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            if (r3 != 0) goto L_0x0030
            goto L_0x0006
        L_0x0030:
            int r5 = r3.hashCode()
            r6 = -891611359(0xffffffffcadb1721, float:-7179152.5)
            if (r5 == r6) goto L_0x004f
            r6 = 1053567612(0x3ecc2a7c, float:0.39876163)
            if (r5 == r6) goto L_0x003f
            goto L_0x0006
        L_0x003f:
            java.lang.String r5 = "DISABLED"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0006
            net.one97.paytm.common.entity.p2p.SenderDisplayInformation r2 = r2.getSenderDisplayInformation()
            if (r2 == 0) goto L_0x0006
            r1 = 1
            goto L_0x0006
        L_0x004f:
            java.lang.String r2 = "ENABLED"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0006
            goto L_0x0059
        L_0x0058:
            r0 = r1
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a.a(java.util.List):boolean");
    }

    public final void a() {
        this.f55068c = true;
        notifyItemChanged(this.f55069d);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.n) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_add_bank_list_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…list_item, parent, false)");
            w a2 = w.a(inflate);
            k.a((Object) a2, "MtV4AddBankListItemBinding.bind(view)");
            return new C0996a(this, a2);
        } else if (i2 == this.m) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_lead_case_list_item, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…list_item, parent, false)");
            ah a3 = ah.a(inflate2);
            k.a((Object) a3, "MtV4LeadCaseListItemBinding.bind(view)");
            return new d(this, a3);
        } else {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_all_acccounts_list_item, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(pare…list_item, parent, false)");
            x a4 = x.a(inflate3);
            k.a((Object) a4, "MtV4AllAcccountsListItemBinding.bind(view)");
            return new c(this, a4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r2.equals("BANK_ACCOUNT_OPENING") != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r2.equals("UPI_RE_REGISTRATION") != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        return r1.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r2.equals("UPI_ONBOARDING") != false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getItemViewType(int r2) {
        /*
            r1 = this;
            java.util.List<net.one97.paytm.common.entity.p2p.PaymentOptionItem> r0 = r1.f55074i
            java.lang.Object r2 = r0.get(r2)
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r2 = (net.one97.paytm.common.entity.p2p.PaymentOptionItem) r2
            if (r2 == 0) goto L_0x000f
            java.lang.String r2 = r2.getCombinationName()
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            if (r2 != 0) goto L_0x0013
            goto L_0x0043
        L_0x0013:
            int r0 = r2.hashCode()
            switch(r0) {
                case -770941420: goto L_0x0038;
                case -704144125: goto L_0x002f;
                case 370508577: goto L_0x0024;
                case 407411180: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0043
        L_0x001b:
            java.lang.String r0 = "UPI_ONBOARDING"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0043
            goto L_0x0040
        L_0x0024:
            java.lang.String r0 = "UPI_NEW_BANK_ACCOUNT_ADDITION"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0043
            int r2 = r1.n
            return r2
        L_0x002f:
            java.lang.String r0 = "BANK_ACCOUNT_OPENING"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0043
            goto L_0x0040
        L_0x0038:
            java.lang.String r0 = "UPI_RE_REGISTRATION"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0043
        L_0x0040:
            int r2 = r1.m
            return r2
        L_0x0043:
            int r2 = r1.l
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a.getItemViewType(int):int");
    }

    public final int getItemCount() {
        return this.f55074i.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        SourcePayment sourcePayment;
        SourcePayment sourcePayment2;
        SourcePayment sourcePayment3;
        k.c(vVar, "holder");
        if (i2 != -1) {
            String str = null;
            if (vVar instanceof c) {
                c cVar = (c) vVar;
                PaymentOptionItem paymentOptionItem = cVar.k.f55074i.get(i2);
                if (!(paymentOptionItem == null || (sourcePayment2 = paymentOptionItem.getSourcePayment()) == null)) {
                    String paymentType = sourcePayment2.getPaymentType();
                    if (paymentType != null) {
                        int hashCode = paymentType.hashCode();
                        if (hashCode != -1741862919) {
                            if (hashCode != 84238) {
                                if (hashCode == 2031164 && paymentType.equals(SDKConstants.TYPE_BANK)) {
                                    cVar.a(sourcePayment2);
                                    cVar.a(sourcePayment2.getIfscCode());
                                    cVar.a(i2, sourcePayment2);
                                }
                            } else if (paymentType.equals("UPI")) {
                                cVar.a(sourcePayment2);
                                cVar.a(sourcePayment2.getIfscCode());
                                cVar.a(i2, sourcePayment2);
                            }
                        } else if (paymentType.equals(SDKConstants.AI_KEY_WALLET)) {
                            Context context = cVar.f55082e.getContext();
                            cVar.a();
                            cVar.f55082e.setText(context.getString(R.string.upi_paytm_wallet));
                            if (!TextUtils.isEmpty(sourcePayment2 != null ? sourcePayment2.getBalance() : null)) {
                                TextView textView = cVar.f55081d;
                                Context context2 = cVar.f55080c.getContext();
                                int i3 = R.string.mt_v4_available_balance;
                                Object[] objArr = new Object[1];
                                objArr[0] = UpiAppUtils.priceToString(sourcePayment2 != null ? sourcePayment2.getBalance() : null);
                                textView.setText(context2.getString(i3, objArr));
                                f.a((View) cVar.f55080c);
                                f.a((View) cVar.f55079b);
                                f.b((View) cVar.f55081d);
                            } else {
                                f.a((View) cVar.f55080c);
                                f.a((View) cVar.f55079b);
                                f.b((View) cVar.f55081d);
                                cVar.f55081d.setText(cVar.f55080c.getContext().getString(R.string.upi_available_balance));
                            }
                            cVar.f55083f.setPadding(cVar.k.f55066a, cVar.k.f55066a, cVar.k.f55066a, cVar.k.f55066a);
                            cVar.f55083f.setImageDrawable(androidx.core.content.b.a(context, R.drawable.mt_v4_wallet));
                        }
                    }
                    if (!(paymentOptionItem == null || (sourcePayment3 = paymentOptionItem.getSourcePayment()) == null)) {
                        str = sourcePayment3.getPaymentInstrumentStatus();
                    }
                    if (str != null) {
                        int hashCode2 = str.hashCode();
                        if (hashCode2 != -891611359) {
                            if (hashCode2 == 1053567612 && str.equals("DISABLED")) {
                                f.b((View) cVar.j);
                                if (paymentOptionItem.getSenderDisplayInformation() != null) {
                                    f.b((View) cVar.f55084g);
                                    f.b((View) cVar.f55085h);
                                    cVar.f55084g.setAlpha(1.0f);
                                } else {
                                    f.a((View) cVar.f55085h);
                                    f.a((View) cVar.f55084g);
                                }
                            }
                        } else if (str.equals("ENABLED")) {
                            f.a((View) cVar.j);
                            f.a((View) cVar.f55084g);
                            f.a((View) cVar.f55085h);
                        }
                    }
                    if (cVar.k.f55070e == i2) {
                        cVar.f55078a.setChecked(true);
                        cVar.f55082e.setTypeface(Typeface.create("sans-serif", 1));
                    } else {
                        cVar.f55078a.setChecked(false);
                        cVar.f55082e.setTypeface(Typeface.create("sans-serif", 0));
                    }
                }
                if (cVar.k.f55071f && !cVar.k.f55072g && paymentOptionItem.getSenderDisplayInformation() != null) {
                    cVar.k.f55072g = true;
                    net.one97.paytm.moneytransfer.utils.f.a(cVar.f55086i.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_ALL_DISABLED_COMBO, CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
                    cVar.f55084g.postDelayed(new c.C0997a(cVar, i2), 300);
                }
            } else if (vVar instanceof d) {
                d dVar = (d) vVar;
                PaymentOptionItem paymentOptionItem2 = dVar.f55098f.f55074i.get(i2);
                if (paymentOptionItem2 != null && (sourcePayment = paymentOptionItem2.getSourcePayment()) != null) {
                    dVar.f55094b.setText(sourcePayment.getHeading());
                    dVar.f55095c.setText(sourcePayment.getSubHeading());
                    if (!k.a((Object) "UPI_ONBOARDING", (Object) paymentOptionItem2.getCombinationName())) {
                        f.a((View) dVar.f55097e);
                    } else if (UpiUtils.isInActiveProfileExist(dVar.f55097e.getContext()) || UpiUtils.isUpiUser(dVar.f55097e.getContext())) {
                        f.a((View) dVar.f55097e);
                    } else {
                        UpiGTMLoader instance = UpiGTMLoader.getInstance();
                        k.a((Object) instance, "UpiGTMLoader.getInstance()");
                        CharSequence upiOfferText = instance.getUpiOfferText();
                        if (TextUtils.isEmpty(upiOfferText)) {
                            dVar.f55097e.setText(upiOfferText);
                            f.b((View) dVar.f55097e);
                        } else {
                            f.a((View) dVar.f55097e);
                        }
                    }
                    dVar.f55096d.setPadding(dVar.f55098f.f55067b, dVar.f55098f.f55067b, dVar.f55098f.f55067b, dVar.f55098f.f55067b);
                    if (paymentOptionItem2 != null) {
                        str = paymentOptionItem2.getCombinationName();
                    }
                    if (k.a((Object) "BANK_ACCOUNT_OPENING", (Object) str)) {
                        dVar.f55096d.setPadding(dVar.f55098f.f55066a, dVar.f55098f.f55066a, dVar.f55098f.f55066a, dVar.f55098f.f55066a);
                        m.a(dVar.f55096d, "PYTM0123456", dVar.f55096d.getContext());
                    } else {
                        dVar.f55096d.setImageDrawable(androidx.core.content.b.a(dVar.f55096d.getContext(), R.drawable.mt_upi_logo_upi));
                    }
                    if (dVar.f55098f.f55070e == i2) {
                        dVar.f55093a.setChecked(true);
                        dVar.f55094b.setTypeface(Typeface.create("sans-serif", 1));
                        return;
                    }
                    dVar.f55093a.setChecked(false);
                    dVar.f55094b.setTypeface(Typeface.create("sans-serif", 0));
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a$a  reason: collision with other inner class name */
    public final class C0996a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55075a;

        /* renamed from: b  reason: collision with root package name */
        private final ConstraintLayout f55076b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0996a(a aVar, w wVar) {
            super(wVar.a());
            k.c(wVar, "itemViewBinding");
            this.f55075a = aVar;
            ConstraintLayout constraintLayout = wVar.f53863a;
            k.a((Object) constraintLayout, "itemViewBinding.addBank");
            this.f55076b = constraintLayout;
            this.f55076b.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C0996a f55077a;

                {
                    this.f55077a = r1;
                }

                public final void onClick(View view) {
                    this.f55077a.f55075a.j.c();
                }
            });
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RadioButton f55093a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f55094b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f55095c;

        /* renamed from: d  reason: collision with root package name */
        final ImageView f55096d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f55097e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a f55098f;

        /* renamed from: g  reason: collision with root package name */
        private final RelativeLayout f55099g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, ah ahVar) {
            super(ahVar.a());
            k.c(ahVar, "itemViewBinding");
            this.f55098f = aVar;
            RelativeLayout relativeLayout = ahVar.f53647c;
            k.a((Object) relativeLayout, "itemViewBinding.leadRoot");
            this.f55099g = relativeLayout;
            RadioButton radioButton = ahVar.f53649e;
            k.a((Object) radioButton, "itemViewBinding.radioButton");
            this.f55093a = radioButton;
            TextView textView = ahVar.f53646b;
            k.a((Object) textView, "itemViewBinding.heading");
            this.f55094b = textView;
            TextView textView2 = ahVar.f53650f;
            k.a((Object) textView2, "itemViewBinding.subheading");
            this.f55095c = textView2;
            ImageView imageView = ahVar.f53645a;
            k.a((Object) imageView, "itemViewBinding.bankImage");
            this.f55096d = imageView;
            TextView textView3 = ahVar.f53648d;
            k.a((Object) textView3, "itemViewBinding.offer");
            this.f55097e = textView3;
            this.f55099g.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f55100a;

                {
                    this.f55100a = r1;
                }

                public final void onClick(View view) {
                    this.f55100a.f55098f.f55070e = this.f55100a.getLayoutPosition();
                    this.f55100a.f55098f.notifyDataSetChanged();
                    this.f55100a.f55098f.j.a(this.f55100a.getLayoutPosition(), this.f55100a.f55098f.f55074i.get(this.f55100a.getLayoutPosition()));
                }
            });
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RadioButton f55078a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f55079b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f55080c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f55081d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f55082e;

        /* renamed from: f  reason: collision with root package name */
        final ImageView f55083f;

        /* renamed from: g  reason: collision with root package name */
        final CircularProgressBar f55084g;

        /* renamed from: h  reason: collision with root package name */
        final TextView f55085h;

        /* renamed from: i  reason: collision with root package name */
        final RelativeLayout f55086i;
        final FrameLayout j;
        final /* synthetic */ a k;
        private final LottieAnimationView l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, x xVar) {
            super(xVar.a());
            k.c(xVar, "itemViewBinding");
            this.k = aVar;
            RadioButton radioButton = xVar.k;
            k.a((Object) radioButton, "itemViewBinding.radioButton");
            this.f55078a = radioButton;
            TextView textView = xVar.f53870d;
            k.a((Object) textView, "itemViewBinding.checkBalanceTv");
            this.f55079b = textView;
            TextView textView2 = xVar.l;
            k.a((Object) textView2, "itemViewBinding.setmpin");
            this.f55080c = textView2;
            TextView textView3 = xVar.f53867a;
            k.a((Object) textView3, "itemViewBinding.availableBalance");
            this.f55081d = textView3;
            TextView textView4 = xVar.m;
            k.a((Object) textView4, "itemViewBinding.sourceName");
            this.f55082e = textView4;
            ImageView imageView = xVar.f53868b;
            k.a((Object) imageView, "itemViewBinding.bankImage");
            this.f55083f = imageView;
            LottieAnimationView lottieAnimationView = xVar.n;
            k.a((Object) lottieAnimationView, "itemViewBinding.walletLoader");
            this.l = lottieAnimationView;
            CircularProgressBar circularProgressBar = xVar.f53873g;
            k.a((Object) circularProgressBar, "itemViewBinding.infoProgressBar");
            this.f55084g = circularProgressBar;
            TextView textView5 = xVar.f53874h;
            k.a((Object) textView5, "itemViewBinding.infoText");
            this.f55085h = textView5;
            RelativeLayout relativeLayout = xVar.f53875i;
            k.a((Object) relativeLayout, "itemViewBinding.itemRlRoot");
            this.f55086i = relativeLayout;
            FrameLayout frameLayout = xVar.j;
            k.a((Object) frameLayout, "itemViewBinding.overlay");
            this.j = frameLayout;
            this.f55079b.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f55087a;

                {
                    this.f55087a = r1;
                }

                public final void onClick(View view) {
                    this.f55087a.k.f55069d = this.f55087a.getLayoutPosition();
                    SourcePayment sourcePayment = this.f55087a.k.f55074i.get(this.f55087a.getLayoutPosition()).getSourcePayment();
                    String paymentInstrumentStatus = sourcePayment != null ? sourcePayment.getPaymentInstrumentStatus() : null;
                    if (paymentInstrumentStatus != null && paymentInstrumentStatus.hashCode() == -891611359 && paymentInstrumentStatus.equals("ENABLED")) {
                        this.f55087a.k.j.a(this.f55087a.k.f55074i.get(this.f55087a.getLayoutPosition()), this.f55087a.getLayoutPosition());
                    }
                }
            });
            this.f55080c.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f55088a;

                {
                    this.f55088a = r1;
                }

                public final void onClick(View view) {
                    SourcePayment sourcePayment = this.f55088a.k.f55074i.get(this.f55088a.getLayoutPosition()).getSourcePayment();
                    String paymentInstrumentStatus = sourcePayment != null ? sourcePayment.getPaymentInstrumentStatus() : null;
                    if (paymentInstrumentStatus != null && paymentInstrumentStatus.hashCode() == -891611359 && paymentInstrumentStatus.equals("ENABLED")) {
                        this.f55088a.k.j.a(this.f55088a.k.f55074i.get(this.f55088a.getLayoutPosition()));
                    }
                }
            });
            this.f55086i.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f55089a;

                {
                    this.f55089a = r1;
                }

                public final void onClick(View view) {
                    if (this.f55089a.k.f55070e != this.f55089a.getLayoutPosition()) {
                        if (f.d(this.f55089a.f55084g)) {
                            this.f55089a.k.j.a(this.f55089a.f55086i, this.f55089a.k.f55074i.get(this.f55089a.getLayoutPosition()), this.f55089a.f55084g);
                            return;
                        }
                        SourcePayment sourcePayment = this.f55089a.k.f55074i.get(this.f55089a.getLayoutPosition()).getSourcePayment();
                        String paymentInstrumentStatus = sourcePayment != null ? sourcePayment.getPaymentInstrumentStatus() : null;
                        if (paymentInstrumentStatus != null && paymentInstrumentStatus.hashCode() == -891611359 && paymentInstrumentStatus.equals("ENABLED")) {
                            this.f55089a.k.f55070e = this.f55089a.getLayoutPosition();
                            this.f55089a.k.notifyDataSetChanged();
                            this.f55089a.k.j.a(this.f55089a.k.f55070e, this.f55089a.k.f55074i.get(this.f55089a.k.f55070e));
                        }
                    }
                }
            });
            this.f55084g.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f55090a;

                {
                    this.f55090a = r1;
                }

                public final void onClick(View view) {
                    this.f55090a.k.j.a(this.f55090a.f55086i, this.f55090a.k.f55074i.get(this.f55090a.getLayoutPosition()), this.f55090a.f55084g);
                }
            });
        }

        /* renamed from: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a$c$a  reason: collision with other inner class name */
        static final class C0997a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f55091a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f55092b;

            C0997a(c cVar, int i2) {
                this.f55091a = cVar;
                this.f55092b = i2;
            }

            public final void run() {
                this.f55091a.k.j.a(this.f55091a.f55086i, this.f55091a.k.f55074i.get(this.f55092b), this.f55091a.f55084g);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, SourcePayment sourcePayment) {
            String str = null;
            if (this.k.f55069d == i2) {
                if (this.k.f55068c) {
                    b();
                    return;
                }
                a();
                if (!TextUtils.isEmpty(sourcePayment != null ? sourcePayment.getBankAccountNumber() : null)) {
                    Map<String, String> map = this.k.k;
                    if (sourcePayment != null) {
                        str = sourcePayment.getBankAccountNumber();
                    }
                    CharSequence charSequence = map.get(str);
                    if (!TextUtils.isEmpty(charSequence)) {
                        this.f55081d.setText(charSequence);
                        f.a((View) this.f55079b);
                        f.a((View) this.f55080c);
                        f.b((View) this.f55081d);
                        return;
                    }
                    f.a((View) this.f55080c);
                    f.a((View) this.f55081d);
                    f.b((View) this.f55079b);
                    return;
                }
                f.a((View) this.f55080c);
                f.a((View) this.f55081d);
                f.b((View) this.f55079b);
            } else if (this.k.k.get(sourcePayment.getBankAccountNumber()) != null) {
                Map<String, String> map2 = this.k.k;
                if (sourcePayment != null) {
                    str = sourcePayment.getBankAccountNumber();
                }
                CharSequence charSequence2 = map2.get(str);
                if (!TextUtils.isEmpty(charSequence2)) {
                    this.f55081d.setText(charSequence2);
                    f.a((View) this.f55079b);
                    f.a((View) this.f55080c);
                    f.b((View) this.f55081d);
                    return;
                }
                f.a((View) this.f55080c);
                f.a((View) this.f55081d);
                f.b((View) this.f55079b);
            } else {
                a();
                b(sourcePayment);
            }
        }

        private final void b(SourcePayment sourcePayment) {
            String ifscCode;
            if (TextUtils.isEmpty(sourcePayment.getMpinSet())) {
                f.a((View) this.f55081d);
                f.a((View) this.f55080c);
                f.b((View) this.f55079b);
            } else if (k.a((Object) "Y", (Object) sourcePayment.getMpinSet()) || ((ifscCode = sourcePayment.getIfscCode()) != null && p.a((CharSequence) ifscCode, (CharSequence) "PYTM", true))) {
                f.a((View) this.f55081d);
                f.a((View) this.f55080c);
                f.b((View) this.f55079b);
            } else {
                f.a((View) this.f55079b);
                f.a((View) this.f55081d);
                f.b((View) this.f55080c);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(SourcePayment sourcePayment) {
            CharSequence a2 = m.a(sourcePayment.getBankName(), sourcePayment.getBankAccountNumber());
            if (!TextUtils.isEmpty(a2)) {
                this.f55082e.setText(a2);
                return;
            }
            TextView textView = this.f55082e;
            textView.setText(textView.getContext().getString(R.string.money_tranfer_balance_paytm_bank_string));
        }

        /* access modifiers changed from: package-private */
        public final void a(String str) {
            this.f55083f.setPadding(this.k.f55067b, this.k.f55067b, this.k.f55067b, this.k.f55067b);
            if (!TextUtils.isEmpty(str)) {
                ImageView imageView = this.f55083f;
                m.a(imageView, str, imageView.getContext());
                return;
            }
            ImageView imageView2 = this.f55083f;
            imageView2.setImageDrawable(androidx.core.content.b.a(imageView2.getContext(), R.drawable.mt_upi_logo_upi));
        }

        private final void b() {
            f.a((View) this.f55079b);
            AnimationFactory.startWalletLoader(this.l);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            f.b((View) this.f55079b);
            AnimationFactory.stopWalletLoader(this.l);
        }
    }
}
