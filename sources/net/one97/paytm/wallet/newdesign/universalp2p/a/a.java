package net.one97.paytm.wallet.newdesign.universalp2p.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    Context f71353a;

    /* renamed from: b  reason: collision with root package name */
    List<b.c> f71354b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    int f71355c;

    /* renamed from: d  reason: collision with root package name */
    C1449a f71356d;

    /* renamed from: e  reason: collision with root package name */
    boolean f71357e;

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.a.a$a  reason: collision with other inner class name */
    public interface C1449a {
        void a(b.c cVar);

        void a(boolean z);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        String str;
        final b bVar = (b) vVar;
        if (this.f71354b.get(i2).getPaymentInstrumentationType() == b.d.UPI_LEAD) {
            bVar.f71369a.setVisibility(0);
            bVar.f71369a.setText(this.f71354b.get(i2).getPaymentInstrumentationName());
            bVar.f71370b.setVisibility(0);
            bVar.f71370b.setText(this.f71354b.get(i2).getPaymentInstrumentAccount());
            bVar.f71371c.setVisibility(0);
            bVar.f71371c.setText(this.f71354b.get(i2).getPaymentInstrumentationMetaData());
            bVar.f71371c.setTextColor(Color.parseColor("#26d07c"));
        } else {
            if (this.f71354b.get(i2).getPaymentInstrumentationType() == b.d.UPI) {
                str = this.f71353a.getString(R.string.uni_p2p_account_number) + " " + com.paytm.utility.b.R(net.one97.paytm.wallet.communicator.b.a().maskNumber(this.f71354b.get(i2).getPaymentInstrumentAccount()));
            } else {
                str = this.f71354b.get(i2).getPaymentInstrumentationMetaData();
            }
            if (this.f71354b.get(i2).getPaymentInstrumentationType() != b.d.WALLET) {
                TextView textView = bVar.f71369a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f71354b.get(i2).getPaymentInstrumentationName());
                sb.append("  XX ");
                String paymentInstrumentAccount = this.f71354b.get(i2).getPaymentInstrumentAccount();
                sb.append(!TextUtils.isEmpty(paymentInstrumentAccount) ? paymentInstrumentAccount.substring(paymentInstrumentAccount.length() - 4) : null);
                textView.setText(sb.toString());
            } else {
                bVar.f71369a.setText(this.f71354b.get(i2).getPaymentInstrumentationName());
            }
            if (this.f71354b.get(i2).getPaymentInstrumentationType().equals(b.d.PPB)) {
                bVar.f71370b.setVisibility(8);
                bVar.f71371c.setVisibility(0);
                bVar.f71371c.setText("Check Balance");
                bVar.f71371c.setTextColor(Color.parseColor("#00b9f5"));
            } else {
                bVar.f71370b.setVisibility(8);
                bVar.f71371c.setVisibility(0);
                if (this.f71354b.get(i2).getMpinSet() != null) {
                    bVar.f71371c.setText("Check Balance");
                    if ("Y".equalsIgnoreCase(this.f71354b.get(i2).getMpinSet())) {
                        bVar.f71371c.setText("Check Balance");
                    } else if ("Paytm Payments Bank".equalsIgnoreCase(this.f71354b.get(i2).getPaymentInstrumentationName())) {
                        bVar.f71371c.setText("Check Balance");
                    } else {
                        bVar.f71371c.setText("Set UPI Pin");
                    }
                    bVar.f71371c.setTextColor(Color.parseColor("#00b9f5"));
                } else {
                    bVar.f71371c.setText(str);
                    bVar.f71371c.setTextColor(this.f71353a.getResources().getColor(R.color.color_506d85));
                }
            }
            bVar.f71373e.setVisibility(0);
            int i3 = AnonymousClass4.f71367a[this.f71354b.get(i2).getPaymentInstrumentationType().ordinal()];
            if (i3 == 1) {
                bVar.f71375g.setImageDrawable(this.f71353a.getResources().getDrawable(R.drawable.uni_p2p_bhim_upi));
            } else if (i3 == 2) {
                w.a().a(UpiRequestBuilder.getBankIconUrl(this.f71353a, this.f71354b.get(i2).getIfscCode())).a(this.f71353a.getResources().getDrawable(R.drawable.ic_bhim)).a(bVar.f71375g, (e) null);
            } else if (i3 == 3) {
                bVar.f71375g.setImageDrawable(this.f71353a.getResources().getDrawable(R.drawable.ic_savings_account));
            } else if (i3 == 4) {
                bVar.f71375g.setImageDrawable(this.f71353a.getResources().getDrawable(R.drawable.ic_savings_account));
            } else if (i3 == 5) {
                bVar.f71375g.setImageDrawable(this.f71353a.getResources().getDrawable(R.drawable.uni_p2p_wallet));
            }
        }
        if (this.f71355c != i2) {
            bVar.f71372d.setChecked(false);
            bVar.a(this.f71354b.get(i2), false);
        } else {
            bVar.f71372d.setChecked(true);
            bVar.a(this.f71354b.get(i2), true);
        }
        if (!this.f71357e && this.f71355c == 0) {
            this.f71356d.a(true);
        }
        bVar.f71374f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                bVar.f71372d.setChecked(true);
                a aVar = a.this;
                aVar.f71355c = i2;
                aVar.notifyDataSetChanged();
                if (a.this.f71357e || i2 != 0) {
                    a.this.f71356d.a(false);
                    a.this.f71356d.a(a.this.f71354b.get(i2));
                    return;
                }
                a.this.f71356d.a(true);
            }
        });
        bVar.f71371c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if ((a.this.f71354b.get(i2).getPaymentInstrumentationType() == b.d.UPI || a.this.f71354b.get(i2).getPaymentInstrumentationType() == b.d.PPB) && a.this.f71354b.get(i2).getAvailBalance() == null) {
                    net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
                    a2.j = a.e.WALLET_PAY;
                    a2.l = a.C1450a.CHECK_BALANCE_CLICKED;
                    a2.k = a.b.WAlLET_SEND_MONEY;
                    a2.b(a.this.f71353a);
                    if (com.paytm.utility.b.c(a.this.f71353a)) {
                        a aVar = a.this;
                        b bVar = bVar;
                        b.c cVar = aVar.f71354b.get(i2);
                        if (cVar != null) {
                            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                            BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
                            bankAccount.setAccount(cVar.getPaymentInstrumentAccount());
                            bankAccount.setAccountType(cVar.getAccountType());
                            bankAccount.setAccRefNumber(cVar.getPaymentInstrumentAccount());
                            bankAccount.setAccRefId(cVar.getAccRefId());
                            bankAccount.setAeba(cVar.getMpinSet());
                            bankAccount.setBankLogoUrl("");
                            bankAccount.setBankName(cVar.getPaymentInstrumentationName());
                            bankAccount.setCustomerName("");
                            bankAccount.setIfsc(cVar.getIfscCode());
                            bankAccount.setMbeba(cVar.getMpinSet());
                            bankAccount.setMmid("");
                            ArrayList arrayList = new ArrayList();
                            ArrayList<ConsolidatePaymentInstrumentationRes.BankAccountCredentials> credsAlolowed = cVar.getCredsAlolowed();
                            if (credsAlolowed != null && credsAlolowed.size() > 0) {
                                for (ConsolidatePaymentInstrumentationRes.BankAccountCredentials next : credsAlolowed) {
                                    BankAccountDetails.BankAccountCredentials bankAccountCredentials = new BankAccountDetails.BankAccountCredentials();
                                    bankAccountCredentials.setCredsAllowedDLength(next.getCredsAllowedDLength());
                                    bankAccountCredentials.setCredsAllowedDType(next.getCredsAllowedDType());
                                    bankAccountCredentials.setCredsAllowedSubType1(next.getCredsAllowedSubType());
                                    bankAccountCredentials.setCredsAllowedType(next.getCredsAllowedType());
                                    arrayList.add(bankAccountCredentials);
                                }
                            }
                            bankAccount.setBankCredsAllowed(arrayList);
                            upiProfileDefaultBank.setDebitBank(bankAccount);
                            upiProfileDefaultBank.setVirtualAddress(cVar.getVpaId());
                            new UPICheckBalanceHelper.UPICheckBalanceBuilder(aVar.f71353a, new n.c(bVar, cVar) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ b f71364a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ b.c f71365b;

                                {
                                    this.f71364a = r2;
                                    this.f71365b = r3;
                                }

                                public final void Z_() {
                                    this.f71364a.f71371c.setVisibility(8);
                                    try {
                                        net.one97.paytm.common.widgets.a.a(this.f71364a.f71376h);
                                    } catch (Exception unused) {
                                    }
                                }

                                public final void b() {
                                    try {
                                        net.one97.paytm.common.widgets.a.b(this.f71364a.f71376h);
                                    } catch (Exception unused) {
                                    }
                                    this.f71364a.f71371c.setVisibility(0);
                                    this.f71364a.f71371c.setTextColor(Color.parseColor("#00b9f5"));
                                }

                                public final void a(String str, String str2, String str3) {
                                    if (str2 != null) {
                                        this.f71364a.f71371c.setText(String.format(a.this.f71353a.getString(R.string.available_balance), new Object[]{str2}));
                                        this.f71364a.f71371c.setTextColor(a.this.f71353a.getResources().getColor(R.color.color_506d85));
                                        this.f71365b.setAvailBalance(str2);
                                    }
                                }

                                public final void a(n.b bVar) {
                                    switch (AnonymousClass4.f71368b[bVar.ordinal()]) {
                                        case 1:
                                            Toast.makeText(a.this.f71353a, "Incorrect pin, please try again!", 0).show();
                                            break;
                                        case 2:
                                        case 3:
                                            Toast.makeText(a.this.f71353a, "Unable to check balance", 0).show();
                                            break;
                                        case 4:
                                            Toast.makeText(a.this.f71353a, "Please check your internet connection!", 0).show();
                                            break;
                                        case 5:
                                            net.one97.paytm.wallet.communicator.b.a().handleSessionTimeout((Activity) a.this.f71353a, new NetworkCustomError(), (String) null, (Bundle) null, true);
                                            Toast.makeText(a.this.f71353a, "Session timed out, please try again!", 0).show();
                                            break;
                                        case 6:
                                            Toast.makeText(a.this.f71353a, "Too many, Incorrect attempts!", 0).show();
                                            break;
                                    }
                                    this.f71364a.f71371c.setVisibility(0);
                                    this.f71364a.f71371c.setTextColor(Color.parseColor("#00b9f5"));
                                }
                            }).setDeviceBindingRequestCode(102).setOnActivityResultRecieverAfterDeviceBinding((Activity) aVar.f71353a).build().getUpiAccountBalance(upiProfileDefaultBank);
                            return;
                        }
                        return;
                    }
                    Toast.makeText(a.this.f71353a, "Please check your internet connection!", 0).show();
                }
            }
        });
    }

    public a(Context context, C1449a aVar, List<b.c> list, int i2, boolean z) {
        this.f71353a = context;
        this.f71356d = aVar;
        if (!z) {
            b.c cVar = new b.c();
            cVar.setIdentifier(SDKConstants.GA_UPI_ONBOARDING);
            cVar.setAddMoney(false);
            cVar.setDisabled(false);
            cVar.setPaymentInstrumentAccount(this.f71353a.getString(R.string.p2p_upi_onboarding_subtitle));
            cVar.setPaymentInstrumentationMetaDataTextColor((Integer) null);
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f71353a, "offlineUpiPromotionalText");
            cVar.setPaymentInstrumentationMetaData(TextUtils.isEmpty(stringFromGTM) ? this.f71353a.getString(R.string.p2p_upi_onboarding_offer) : stringFromGTM);
            cVar.setPaymentInstrumentationType(b.d.UPI_LEAD);
            cVar.setPaymentInstrumentationName(this.f71353a.getString(R.string.p2p_upi_onboarding_title));
            this.f71354b.add(cVar);
            this.f71354b.addAll(list);
            this.f71355c = i2 + 1;
        } else {
            this.f71355c = i2;
            this.f71354b.addAll(list);
        }
        this.f71357e = z;
    }

    public final int getItemCount() {
        List<b.c> list = this.f71354b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71369a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71370b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71371c;

        /* renamed from: d  reason: collision with root package name */
        RadioButton f71372d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f71373e;

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f71374f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f71375g;

        /* renamed from: h  reason: collision with root package name */
        LottieAnimationView f71376h;

        public b(View view) {
            super(view);
            this.f71369a = (TextView) view.findViewById(R.id.tv_payment_inst_name);
            this.f71371c = (TextView) view.findViewById(R.id.tv_payment_inst_metadata);
            this.f71372d = (RadioButton) view.findViewById(R.id.rb_payment_inst);
            this.f71373e = (RelativeLayout) view.findViewById(R.id.uni_p2p_collapse_lyt);
            this.f71374f = (RelativeLayout) view.findViewById(R.id.rl_payment_instrumentation_container);
            this.f71370b = (TextView) view.findViewById(R.id.tv_payment_inst_account_no);
            this.f71375g = (ImageView) view.findViewById(R.id.uni_p2p_instrument_icon);
            this.f71376h = (LottieAnimationView) view.findViewById(R.id.lav_lottie_loader_1);
        }

        public final void a(b.c cVar, boolean z) {
            if (z) {
                try {
                    this.f71369a.setTypeface(Typeface.create("sans-serif", 1));
                } catch (Exception e2) {
                    q.d(String.valueOf(e2));
                    return;
                }
            } else {
                this.f71369a.setTypeface(Typeface.create("sans-serif-medium", 0));
            }
            if (cVar.getAvailBalance() != null && cVar.getPaymentInstrumentationType() != b.d.WALLET) {
                this.f71371c.setText(String.format(a.this.f71353a.getString(R.string.available_balance), new Object[]{cVar.getAvailBalance()}));
                this.f71371c.setTextColor(a.this.f71353a.getResources().getColor(R.color.color_506d85));
            }
        }
    }

    public final void a(b.f fVar) {
        for (b.c next : this.f71354b) {
            if (next.getPaymentInstrumentationType().equals(fVar.f71419e) && fVar.f71422h.equalsIgnoreCase(next.getIdentifier()) && fVar.f71417c.equalsIgnoreCase(next.getPaymentInstrumentationName())) {
                this.f71355c = this.f71354b.indexOf(next);
                notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.a.a$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f71367a = new int[b.d.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f71368b = new int[n.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007c */
        static {
            /*
                net.one97.paytm.common.utility.n$b[] r0 = net.one97.paytm.common.utility.n.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f71368b = r0
                r0 = 1
                int[] r1 = f71368b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.common.utility.n$b r2 = net.one97.paytm.common.utility.n.b.INCORRECT_MPIN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f71368b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.common.utility.n$b r3 = net.one97.paytm.common.utility.n.b.UNABLE_TO_CHECK_BALANCE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f71368b     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.common.utility.n$b r4 = net.one97.paytm.common.utility.n.b.ERROR_UNDEFINED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f71368b     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.common.utility.n$b r5 = net.one97.paytm.common.utility.n.b.NO_NETWORK     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f71368b     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.common.utility.n$b r6 = net.one97.paytm.common.utility.n.b.SESSION_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r5 = f71368b     // Catch:{ NoSuchFieldError -> 0x004b }
                net.one97.paytm.common.utility.n$b r6 = net.one97.paytm.common.utility.n.b.INCORRECT_MPIN_TOO_MANY_TIMES     // Catch:{ NoSuchFieldError -> 0x004b }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d[] r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f71367a = r5
                int[] r5 = f71367a     // Catch:{ NoSuchFieldError -> 0x005e }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r6 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.UPI_LEAD     // Catch:{ NoSuchFieldError -> 0x005e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = f71367a     // Catch:{ NoSuchFieldError -> 0x0068 }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.UPI     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f71367a     // Catch:{ NoSuchFieldError -> 0x0072 }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.PPB     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f71367a     // Catch:{ NoSuchFieldError -> 0x007c }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.BANK     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f71367a     // Catch:{ NoSuchFieldError -> 0x0086 }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.a.a.AnonymousClass4.<clinit>():void");
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_uni_p2p_payment_inst_row, viewGroup, false));
    }
}
