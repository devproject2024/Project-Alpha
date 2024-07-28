package net.one97.paytm.passbook.main.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.upi.BankAccountDetails;
import net.one97.paytm.passbook.utility.f;

public final class PassbookBalanceCardView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f57843a;

    /* renamed from: b  reason: collision with root package name */
    public BankAccountDetails.BankAccount f57844b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f57845c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f57846d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f57847e;

    public final View a(int i2) {
        if (this.f57847e == null) {
            this.f57847e = new HashMap();
        }
        View view = (View) this.f57847e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57847e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View getMView() {
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void setMView(View view) {
        k.c(view, "<set-?>");
        this.f57843a = view;
    }

    public final BankAccountDetails.BankAccount getMUpiBankAccount() {
        BankAccountDetails.BankAccount bankAccount = this.f57844b;
        if (bankAccount == null) {
            k.a("mUpiBankAccount");
        }
        return bankAccount;
    }

    public final void setMUpiBankAccount(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "<set-?>");
        this.f57844b = bankAccount;
    }

    public final void setHeader(boolean z) {
        this.f57845c = z;
    }

    public final boolean getShouldHighlight() {
        return this.f57846d;
    }

    public final void setShouldHighlight(boolean z) {
        this.f57846d = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassbookBalanceCardView(Context context) {
        super(context, (AttributeSet) null);
        k.c(context, "context");
        setView(R.layout.pass_balance_card_view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassbookBalanceCardView(Context context, int i2) {
        super(context, (AttributeSet) null);
        k.c(context, "context");
        setView(i2);
    }

    private final void setView(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…late(layout, this, false)");
        this.f57843a = inflate;
        removeAllViews();
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        addView(view);
    }

    private final void setAmount(String str) {
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        View findViewById = view.findViewById(R.id.tvAmount);
        k.a((Object) findViewById, "mView.findViewById<AppCo…tTextView>(R.id.tvAmount)");
        String string = getContext().getString(R.string.pass_rupee, new Object[]{str});
        k.a((Object) string, "context.getString(R.string.pass_rupee, amount)");
        f.a((TextView) findViewById, string);
    }

    public final void setAmount(double d2) {
        String b2 = f.b(d2);
        if (b2 != null) {
            setAmount(b2);
        }
    }

    public final void setIconBackground(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            View view = this.f57843a;
            if (view == null) {
                k.a("mView");
            }
            ((AppCompatImageView) view.findViewById(R.id.ivWalletIcon)).setBackgroundResource(intValue);
            return;
        }
        View view2 = this.f57843a;
        if (view2 == null) {
            k.a("mView");
        }
        ((AppCompatImageView) view2.findViewById(R.id.ivWalletIcon)).setBackgroundResource(0);
    }

    public final void a(boolean z) {
        int i2 = z ? 8 : 0;
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        View findViewById = view.findViewById(R.id.tvAmount);
        k.a((Object) findViewById, "mView.findViewById<AppCo…tTextView>(R.id.tvAmount)");
        ((AppCompatTextView) findViewById).setVisibility(i2);
    }

    public final void b(boolean z) {
        int i2 = z ? 4 : 0;
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        View findViewById = view.findViewById(R.id.tvCheckBalance);
        k.a((Object) findViewById, "mView.findViewById<AppCo…iew>(R.id.tvCheckBalance)");
        ((AppCompatTextView) findViewById).setVisibility(i2);
    }

    public final void a(String str) {
        k.c(str, "title");
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        View findViewById = view.findViewById(R.id.tvCheckBalance);
        k.a((Object) findViewById, "mView.findViewById<AppCo…iew>(R.id.tvCheckBalance)");
        ((AppCompatTextView) findViewById).setText(str);
    }

    public final void setTitle(int i2) {
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        ((AppCompatTextView) view.findViewById(R.id.tvTitle)).setText(i2);
    }

    public final void setTitle(String str) {
        k.c(str, "title");
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        View findViewById = view.findViewById(R.id.tvTitle);
        k.a((Object) findViewById, "mView.findViewById<AppCo…atTextView>(R.id.tvTitle)");
        ((AppCompatTextView) findViewById).setText(str);
    }

    public final void setIcon(int i2) {
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        ((AppCompatImageView) view.findViewById(R.id.ivWalletIcon)).setImageResource(i2);
    }

    public final void setFullIcon(boolean z) {
        int dimension = (int) getResources().getDimension(R.dimen.wallet_8_dp);
        if (z) {
            dimension = 0;
        }
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        ((AppCompatImageView) view.findViewById(R.id.ivWalletIcon)).setPadding(dimension, dimension, dimension, dimension);
    }

    public final void setBankAccount(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        this.f57844b = bankAccount;
    }

    public final void setCustomBackgroundColor(Integer num) {
        if (num != null) {
            num.intValue();
            View view = this.f57843a;
            if (view == null) {
                k.a("mView");
            }
            view.setBackgroundColor(b.c(getContext(), num.intValue()));
            return;
        }
        PassbookBalanceCardView passbookBalanceCardView = this;
        View view2 = passbookBalanceCardView.f57843a;
        if (view2 == null) {
            k.a("mView");
        }
        view2.setBackgroundColor(b.c(passbookBalanceCardView.getContext(), R.color.color_fafafa));
    }

    public final void a() {
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view.findViewById(R.id.cardShimmerLayout);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.b();
            shimmerFrameLayout.setVisibility(8);
        }
    }

    public final void b() {
        View view = this.f57843a;
        if (view == null) {
            k.a("mView");
        }
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view.findViewById(R.id.cardShimmerLayout);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setVisibility(0);
            shimmerFrameLayout.a();
        }
    }
}
