package net.one97.paytm.moneytransfer.view.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.SwipeRevealLayout;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.q;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public final class d extends RecyclerView.a<c> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BeneficiaryEntity> f54239a;

    /* renamed from: b  reason: collision with root package name */
    public b f54240b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<BeneficiaryEntity> f54241c;

    /* renamed from: d  reason: collision with root package name */
    private Filter f54242d = new a();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f54243e = "";

    /* renamed from: f  reason: collision with root package name */
    private q f54244f = new q();

    /* renamed from: g  reason: collision with root package name */
    private final int f54245g = 1;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f54246h = "";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f54247i = "";

    public interface b {
        void a(BeneficiaryEntity beneficiaryEntity);

        void a(UpiDBTransactionModel upiDBTransactionModel);

        void a(boolean z);

        void b(BeneficiaryEntity beneficiaryEntity);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        String str2;
        String str3;
        Context context;
        c cVar = (c) vVar;
        k.c(cVar, "holder");
        q qVar = this.f54244f;
        SwipeRevealLayout swipeRevealLayout = cVar.f54253e;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.getAdapterPosition());
        qVar.a(swipeRevealLayout, sb.toString());
        q qVar2 = cVar.f54255g.f54244f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.getAdapterPosition());
        qVar2.a(sb2.toString());
        ArrayList<BeneficiaryEntity> arrayList = cVar.f54255g.f54241c;
        if (arrayList != null) {
            BeneficiaryEntity beneficiaryEntity = arrayList.get(i2);
            if (beneficiaryEntity != null) {
                BeneficiaryEntity beneficiaryEntity2 = beneficiaryEntity;
                String str4 = "";
                if (beneficiaryEntity2.instrumentPreferences.otherBank != null) {
                    BeneficiaryEntity beneficiaryEntity3 = arrayList.get(i2);
                    if (beneficiaryEntity3 != null) {
                        BeneficiaryEntity.OtherBank otherBank = beneficiaryEntity3.instrumentPreferences.otherBank;
                        str4 = otherBank.accounts.get(0).accountDetail.accountHolderName;
                        String str5 = otherBank.accounts.get(0).accountDetail.logoUrl;
                        String str6 = otherBank.accounts.get(0).accountDetail.accountNumber;
                        String str7 = str5;
                        str2 = otherBank.accounts.get(0).accountDetail.ifscCode;
                        str3 = str6;
                        str = str7;
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity");
                    }
                } else if (beneficiaryEntity2.instrumentPreferences.upi != null) {
                    BeneficiaryEntity beneficiaryEntity4 = arrayList.get(i2);
                    if (beneficiaryEntity4 != null) {
                        BeneficiaryEntity.UPI upi = beneficiaryEntity4.instrumentPreferences.upi;
                        String str8 = upi.accounts.get(0).accountDetail.accountHolderName;
                        str3 = upi.accounts.get(0).accountDetail.vpa;
                        str = str4;
                        str4 = str8;
                        str2 = str;
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity");
                    }
                } else {
                    str3 = str4;
                    str2 = str3;
                    str = str2;
                }
                String f2 = m.f(str4);
                if (f2 != null) {
                    cVar.f54255g.a(f2, cVar.f54251c);
                }
                cVar.f54250b.setText(m.a(f2));
                if (!(str3 == null || (context = cVar.f54252d.getContext()) == null)) {
                    if (UpiAppUtils.checkIsVpa(str3)) {
                        d dVar = cVar.f54255g;
                        aa aaVar = aa.f47921a;
                        String string = context.getString(R.string.money_transfer_upi_without_bold);
                        k.a((Object) string, "context.getString(R.stri…ransfer_upi_without_bold)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{str3}, 1));
                        k.a((Object) format, "java.lang.String.format(format, *args)");
                        dVar.a(format, cVar.f54252d);
                    } else {
                        d dVar2 = cVar.f54255g;
                        aa aaVar2 = aa.f47921a;
                        String string2 = context.getString(R.string.money_transfer_acc_no_with_placeholder_without_bold);
                        k.a((Object) string2, "context.getString(R.stri…placeholder_without_bold)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{UpiUtils.maskAccNumberWithSpace(str3)}, 1));
                        k.a((Object) format2, "java.lang.String.format(format, *args)");
                        dVar2.a(format2, cVar.f54252d);
                    }
                }
                cVar.f54250b.setVisibility(0);
                Object obj = cVar.f54254f.get(i2 % 10);
                k.a(obj, "mColorsArray.get(index)");
                int intValue = ((Number) obj).intValue();
                Drawable background = cVar.f54250b.getBackground();
                if (background != null) {
                    GradientDrawable gradientDrawable = (GradientDrawable) background;
                    gradientDrawable.setColor(intValue);
                    cVar.f54250b.setBackground(gradientDrawable);
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        cVar.f54250b.setVisibility(8);
                        if (!TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) {
                            c.a(cVar.f54249a, str2);
                        } else {
                            w.a().a(str).a(R.drawable.mt_dummy_beneficiary_icon).b(R.drawable.ic_default_bank).a(cVar.f54249a);
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity");
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_beneficiay_item, (ViewGroup) null, false);
        k.a((Object) inflate, "view");
        return new c(this, inflate);
    }

    public d(ArrayList<BeneficiaryEntity> arrayList) {
        this.f54241c = arrayList;
        this.f54244f.a();
    }

    public final int getItemCount() {
        ArrayList<BeneficiaryEntity> arrayList = this.f54241c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final class c extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        ImageView f54249a;

        /* renamed from: b  reason: collision with root package name */
        TextView f54250b;

        /* renamed from: c  reason: collision with root package name */
        TextView f54251c;

        /* renamed from: d  reason: collision with root package name */
        TextView f54252d;

        /* renamed from: e  reason: collision with root package name */
        SwipeRevealLayout f54253e;

        /* renamed from: f  reason: collision with root package name */
        final a f54254f = new a();

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f54255g;

        /* renamed from: h  reason: collision with root package name */
        private RelativeLayout f54256h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f54257i;
        private TextView j;
        private RelativeLayout k;

        public final void onClick(View view) {
            if (view != null && view.getId() == R.id.history_tv) {
                d.a(this.f54255g, getAdapterPosition());
            } else if (view != null && view.getId() == R.id.delete_tv) {
                d.b(this.f54255g, getAdapterPosition());
            } else if (view != null && view.getId() == R.id.cl_listitem) {
                d.c(this.f54255g, getAdapterPosition());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d dVar, View view) {
            super(view);
            k.c(view, "view");
            this.f54255g = dVar;
            View findViewById = view.findViewById(R.id.rl_imageview);
            k.a((Object) findViewById, "view.findViewById(R.id.rl_imageview)");
            this.f54256h = (RelativeLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.iv_bank_icon);
            k.a((Object) findViewById2, "view.findViewById(R.id.iv_bank_icon)");
            this.f54249a = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.tv_initials);
            k.a((Object) findViewById3, "view.findViewById(R.id.tv_initials)");
            this.f54250b = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.tv_name);
            k.a((Object) findViewById4, "view.findViewById(R.id.tv_name)");
            this.f54251c = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.tv_account_number);
            k.a((Object) findViewById5, "view.findViewById(R.id.tv_account_number)");
            this.f54252d = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.pl_swipe_rl);
            k.a((Object) findViewById6, "view.findViewById(R.id.pl_swipe_rl)");
            this.f54253e = (SwipeRevealLayout) findViewById6;
            View findViewById7 = view.findViewById(R.id.delete_tv);
            k.a((Object) findViewById7, "view.findViewById(R.id.delete_tv)");
            this.f54257i = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.history_tv);
            k.a((Object) findViewById8, "view.findViewById(R.id.history_tv)");
            this.j = (TextView) findViewById8;
            View findViewById9 = view.findViewById(R.id.cl_listitem);
            k.a((Object) findViewById9, "view.findViewById(R.id.cl_listitem)");
            this.k = (RelativeLayout) findViewById9;
            View.OnClickListener onClickListener = this;
            this.j.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.f54257i.setOnClickListener(onClickListener);
        }

        public static final class a extends ArrayList<Integer> {
            a() {
                add(Integer.valueOf(Color.parseColor("#2cce86")));
                add(Integer.valueOf(Color.parseColor("#6c7cff")));
                add(Integer.valueOf(Color.parseColor("#ffa400")));
                add(Integer.valueOf(Color.parseColor("#b069ec")));
                add(Integer.valueOf(Color.parseColor("#40cdd8")));
                add(Integer.valueOf(Color.parseColor("#fd5c7f")));
                add(Integer.valueOf(Color.parseColor("#f2c110")));
                add(Integer.valueOf(Color.parseColor("#f36bb4")));
                add(Integer.valueOf(Color.parseColor("#3ab6f4")));
                add(Integer.valueOf(Color.parseColor("#a6b7be")));
            }

            public final /* bridge */ boolean contains(Integer num) {
                return super.contains(num);
            }

            public final /* bridge */ boolean contains(Object obj) {
                if (!(obj instanceof Integer)) {
                    return false;
                }
                return contains((Integer) obj);
            }

            public final int getSize() {
                return super.size();
            }

            public final /* bridge */ int indexOf(Integer num) {
                return super.indexOf(num);
            }

            public final /* bridge */ int indexOf(Object obj) {
                if (!(obj instanceof Integer)) {
                    return -1;
                }
                return indexOf((Integer) obj);
            }

            public final /* bridge */ int lastIndexOf(Integer num) {
                return super.lastIndexOf(num);
            }

            public final /* bridge */ int lastIndexOf(Object obj) {
                if (!(obj instanceof Integer)) {
                    return -1;
                }
                return lastIndexOf((Integer) obj);
            }

            public final Integer remove(int i2) {
                return removeAt(i2);
            }

            public final /* bridge */ boolean remove(Integer num) {
                return super.remove(num);
            }

            public final /* bridge */ boolean remove(Object obj) {
                if (!(obj instanceof Integer)) {
                    return false;
                }
                return remove((Integer) obj);
            }

            public final Integer removeAt(int i2) {
                return (Integer) super.remove(i2);
            }

            public final int size() {
                return getSize();
            }
        }

        public static void a(ImageView imageView, String str) {
            k.c(imageView, "imageView");
            k.c(str, "ifscCode");
            Context context = imageView.getContext();
            if (context != null) {
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence) && p.a(charSequence, (CharSequence) "ICIC", false)) {
                    imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.icici_bank_logo));
                } else if (!TextUtils.isEmpty(charSequence) && p.a(str, "UPI", true)) {
                    imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_bhim));
                } else if (!TextUtils.isEmpty(charSequence)) {
                    w.a().a(UpiRequestBuilder.getBankIconUrl(context.getApplicationContext(), str)).a(R.drawable.mt_dummy_beneficiary_icon).b(R.drawable.ic_default_bank).a(imageView);
                }
            }
        }
    }

    public final class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            String valueOf = String.valueOf(charSequence);
            if (valueOf != null) {
                String lowerCase = valueOf.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                d.this.f54243e = lowerCase;
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (lowerCase == null || lowerCase.length() <= 0) {
                    ArrayList a2 = d.this.f54241c;
                    Integer valueOf2 = a2 != null ? Integer.valueOf(a2.size()) : null;
                    if (valueOf2 == null) {
                        k.a();
                    }
                    filterResults.count = valueOf2.intValue();
                    filterResults.values = d.this.f54241c;
                } else {
                    String b2 = d.this.f54243e;
                    if (b2 == null) {
                        k.a();
                    }
                    ArrayList<BeneficiaryEntity> a3 = a(b2);
                    filterResults.count = a3.size();
                    filterResults.values = a3;
                }
                return filterResults;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ea  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0112 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> a(java.lang.String r11) {
            /*
                r10 = this;
                net.one97.paytm.moneytransfer.view.a.d r0 = net.one97.paytm.moneytransfer.view.a.d.this
                java.lang.String r1 = r0.f54246h
                r0.f54247i = r1
                net.one97.paytm.moneytransfer.view.a.d r0 = net.one97.paytm.moneytransfer.view.a.d.this
                r0.f54246h = r11
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                net.one97.paytm.moneytransfer.view.a.d r1 = net.one97.paytm.moneytransfer.view.a.d.this
                java.util.ArrayList r1 = r1.f54239a
                if (r1 == 0) goto L_0x0128
                int r2 = r1.size()
                r3 = 0
                r4 = 0
            L_0x0021:
                if (r4 >= r2) goto L_0x0128
                java.lang.Object r5 = r1.get(r4)
                java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity"
                if (r5 == 0) goto L_0x0122
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r5 = r5.instrumentPreferences
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r5 = r5.otherBank
                java.lang.String r7 = ""
                if (r5 == 0) goto L_0x0060
                java.lang.Object r5 = r1.get(r4)
                if (r5 == 0) goto L_0x005a
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r5 = r5.instrumentPreferences
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r5 = r5.otherBank
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r6 = r5.accounts
                java.lang.Object r6 = r6.get(r3)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r6 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r6
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r6 = r6.accountDetail
                java.lang.String r7 = r6.accountHolderName
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r5 = r5.accounts
                java.lang.Object r5 = r5.get(r3)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r5 = r5.accountDetail
                java.lang.String r5 = r5.accountNumber
                goto L_0x009a
            L_0x005a:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x0060:
                java.lang.Object r5 = r1.get(r4)
                if (r5 == 0) goto L_0x011c
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r5 = r5.instrumentPreferences
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r5 = r5.upi
                if (r5 == 0) goto L_0x0099
                java.lang.Object r5 = r1.get(r4)
                if (r5 == 0) goto L_0x0093
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r5 = r5.instrumentPreferences
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r5 = r5.upi
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r6 = r5.accounts
                java.lang.Object r6 = r6.get(r3)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r6 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r6
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r6 = r6.accountDetail
                java.lang.String r7 = r6.accountHolderName
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r5 = r5.accounts
                java.lang.Object r5 = r5.get(r3)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r5 = r5.accountDetail
                java.lang.String r5 = r5.vpa
                goto L_0x009a
            L_0x0093:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x0099:
                r5 = r7
            L_0x009a:
                java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
                java.lang.String r8 = "(this as java.lang.String).toLowerCase()"
                if (r7 == 0) goto L_0x00da
                r9 = r7
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                boolean r9 = android.text.TextUtils.isEmpty(r9)
                if (r9 != 0) goto L_0x00da
                if (r7 == 0) goto L_0x00d4
                java.lang.String r7 = r7.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                if (r11 == 0) goto L_0x00ce
                java.lang.String r9 = r11.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r9, false)
                if (r7 == 0) goto L_0x00da
                java.lang.Object r7 = r1.get(r4)
                r0.add(r7)
                r7 = 1
                goto L_0x00db
            L_0x00ce:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x00d4:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x00da:
                r7 = 0
            L_0x00db:
                if (r5 == 0) goto L_0x0118
                if (r7 != 0) goto L_0x0118
                r7 = r5
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                boolean r7 = android.text.TextUtils.isEmpty(r7)
                if (r7 != 0) goto L_0x0118
                if (r5 == 0) goto L_0x0112
                java.lang.String r5 = r5.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                if (r11 == 0) goto L_0x010c
                java.lang.String r6 = r11.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r6, false)
                if (r5 == 0) goto L_0x0118
                java.lang.Object r5 = r1.get(r4)
                r0.add(r5)
                goto L_0x0118
            L_0x010c:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x0112:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x0118:
                int r4 = r4 + 1
                goto L_0x0021
            L_0x011c:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x0122:
                kotlin.u r11 = new kotlin.u
                r11.<init>(r6)
                throw r11
            L_0x0128:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.a.d.a.a(java.lang.String):java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            d dVar = d.this;
            Object obj = filterResults != null ? filterResults.values : null;
            if (obj != null) {
                dVar.a((ArrayList<BeneficiaryEntity>) (ArrayList) obj);
                return;
            }
            throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity>");
        }
    }

    public final void a(ArrayList<BeneficiaryEntity> arrayList) {
        k.c(arrayList, "newList");
        if (arrayList.size() == 0) {
            this.f54241c = arrayList;
            notifyDataSetChanged();
            b bVar = this.f54240b;
            if (bVar != null) {
                bVar.a(true);
                return;
            }
            return;
        }
        b bVar2 = this.f54240b;
        if (bVar2 != null) {
            bVar2.a(false);
        }
        ArrayList<BeneficiaryEntity> arrayList2 = this.f54241c;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
        }
        h.b a2 = h.a(new C0973d(this, arrayList2, arrayList));
        k.a((Object) a2, "DiffUtil.calculateDiff(b…llback(newList, oldList))");
        this.f54241c = arrayList;
        a2.a((RecyclerView.a) this);
    }

    /* renamed from: net.one97.paytm.moneytransfer.view.a.d$d  reason: collision with other inner class name */
    public static final class C0973d extends h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f54258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f54259b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f54260c;

        C0973d(d dVar, ArrayList arrayList, ArrayList arrayList2) {
            this.f54258a = dVar;
            this.f54259b = arrayList;
            this.f54260c = arrayList2;
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            return k.a((Object) this.f54258a.f54247i, (Object) this.f54258a.f54246h);
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            return k.a((Object) ((BeneficiaryEntity) this.f54259b.get(i2)).beneficiaryId, (Object) ((BeneficiaryEntity) this.f54260c.get(i3)).beneficiaryId);
        }

        public final int getNewListSize() {
            return this.f54260c.size();
        }

        public final int getOldListSize() {
            return this.f54259b.size();
        }

        public final Object getChangePayload(int i2, int i3) {
            return this.f54258a.f54246h;
        }
    }

    public final Filter getFilter() {
        return this.f54242d;
    }

    public final void a(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        this.f54243e = str;
    }

    private void a(String str, TextView textView) {
        k.c(str, "data");
        k.c(textView, "view");
        String str2 = this.f54243e;
        if (str2 != null) {
            if (!TextUtils.isEmpty(str2)) {
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence)) {
                    try {
                        String lowerCase = str.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        CharSequence charSequence2 = lowerCase;
                        if (str2 != null) {
                            String lowerCase2 = str2.toLowerCase();
                            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                            int a2 = p.a(charSequence2, lowerCase2, 0, false, 6);
                            int length = str2.length() + a2;
                            Spannable spannableString = new SpannableString(str);
                            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(textView.getContext(), R.color.black)), a2, length, 33);
                            spannableString.setSpan(new StyleSpan(1), a2, length, 33);
                            textView.setText(spannableString);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    } catch (Exception unused) {
                        if (!TextUtils.isEmpty(charSequence)) {
                            textView.setText(charSequence);
                            return;
                        }
                        return;
                    }
                }
            }
            CharSequence charSequence3 = str;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView.setText(charSequence3);
            }
        }
    }

    public static final /* synthetic */ void a(d dVar, int i2) {
        b bVar;
        dVar.f54244f.a(String.valueOf(i2));
        ArrayList<BeneficiaryEntity> arrayList = dVar.f54241c;
        if (arrayList != null && (bVar = dVar.f54240b) != null) {
            BeneficiaryEntity beneficiaryEntity = arrayList.get(i2);
            k.a((Object) beneficiaryEntity, "it.get(position)");
            bVar.b(beneficiaryEntity);
        }
    }

    public static final /* synthetic */ void b(d dVar, int i2) {
        b bVar;
        dVar.f54244f.a(String.valueOf(i2));
        ArrayList<BeneficiaryEntity> arrayList = dVar.f54241c;
        if (arrayList != null && (bVar = dVar.f54240b) != null) {
            BeneficiaryEntity beneficiaryEntity = arrayList.get(i2);
            k.a((Object) beneficiaryEntity, "it.get(position)");
            bVar.a(beneficiaryEntity);
        }
    }

    public static final /* synthetic */ void c(d dVar, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        dVar.f54244f.a(String.valueOf(i2));
        try {
            ArrayList<BeneficiaryEntity> arrayList = dVar.f54241c;
            BeneficiaryEntity beneficiaryEntity = arrayList != null ? arrayList.get(i2) : null;
            if (beneficiaryEntity != null) {
                if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                    BeneficiaryEntity.OtherBank otherBank = beneficiaryEntity.instrumentPreferences.otherBank;
                    str4 = otherBank.accounts.get(0).accountDetail.accountHolderName;
                    str3 = otherBank.accounts.get(0).accountDetail.bankName;
                    String str6 = otherBank.accounts.get(0).accountDetail.accountNumber;
                    str = otherBank.accounts.get(0).accountDetail.ifscCode;
                    str2 = str6;
                } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                    BeneficiaryEntity.UPI upi = beneficiaryEntity.instrumentPreferences.upi;
                    str4 = upi.accounts.get(0).accountDetail.accountHolderName;
                    str2 = upi.accounts.get(0).accountDetail.vpa;
                    str3 = "";
                    str = str3;
                } else {
                    str4 = "";
                    str3 = str4;
                    str2 = str3;
                    str = str2;
                }
                String f2 = m.f(str4);
                if (TextUtils.isEmpty(str3)) {
                    str5 = "";
                } else {
                    str5 = str3;
                }
                UpiDBTransactionModel upiDBTransactionModel = new UpiDBTransactionModel("", str2, f2, str5, str, "", "");
                upiDBTransactionModel.setSelf(false);
                b bVar = dVar.f54240b;
                if (bVar != null) {
                    bVar.a(upiDBTransactionModel);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity");
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }
}
