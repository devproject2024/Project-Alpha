package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class PFGWalletResponse extends IJRDataModel {
    @b(a = "code")
    private int code;
    @b(a = "data")
    private final PFGWalletBalances data;
    @b(a = "message")
    private String message;
    @b(a = "status")
    private String status;

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final PFGWalletBalances getData() {
        return this.data;
    }

    public static final class PFGWalletBalances {
        @b(a = "bonus_balance")
        private String bonus_balance;
        @b(a = "deposit_balance")
        private String deposit_balance;
        @b(a = "deposit_winning_balance")
        private String deposit_winning_balance;
        @b(a = "total_balance")
        private String total_balance;
        @b(a = "winning_balance")
        private String winning_balance;

        public PFGWalletBalances() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
        }

        public static /* synthetic */ PFGWalletBalances copy$default(PFGWalletBalances pFGWalletBalances, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = pFGWalletBalances.deposit_balance;
            }
            if ((i2 & 2) != 0) {
                str2 = pFGWalletBalances.winning_balance;
            }
            String str6 = str2;
            if ((i2 & 4) != 0) {
                str3 = pFGWalletBalances.bonus_balance;
            }
            String str7 = str3;
            if ((i2 & 8) != 0) {
                str4 = pFGWalletBalances.deposit_winning_balance;
            }
            String str8 = str4;
            if ((i2 & 16) != 0) {
                str5 = pFGWalletBalances.total_balance;
            }
            return pFGWalletBalances.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.deposit_balance;
        }

        public final String component2() {
            return this.winning_balance;
        }

        public final String component3() {
            return this.bonus_balance;
        }

        public final String component4() {
            return this.deposit_winning_balance;
        }

        public final String component5() {
            return this.total_balance;
        }

        public final PFGWalletBalances copy(String str, String str2, String str3, String str4, String str5) {
            return new PFGWalletBalances(str, str2, str3, str4, str5);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PFGWalletBalances)) {
                return false;
            }
            PFGWalletBalances pFGWalletBalances = (PFGWalletBalances) obj;
            return k.a((Object) this.deposit_balance, (Object) pFGWalletBalances.deposit_balance) && k.a((Object) this.winning_balance, (Object) pFGWalletBalances.winning_balance) && k.a((Object) this.bonus_balance, (Object) pFGWalletBalances.bonus_balance) && k.a((Object) this.deposit_winning_balance, (Object) pFGWalletBalances.deposit_winning_balance) && k.a((Object) this.total_balance, (Object) pFGWalletBalances.total_balance);
        }

        public final int hashCode() {
            String str = this.deposit_balance;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.winning_balance;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.bonus_balance;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.deposit_winning_balance;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.total_balance;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return hashCode4 + i2;
        }

        public final String toString() {
            return "PFGWalletBalances(deposit_balance=" + this.deposit_balance + ", winning_balance=" + this.winning_balance + ", bonus_balance=" + this.bonus_balance + ", deposit_winning_balance=" + this.deposit_winning_balance + ", total_balance=" + this.total_balance + ")";
        }

        public PFGWalletBalances(String str, String str2, String str3, String str4, String str5) {
            this.deposit_balance = str;
            this.winning_balance = str2;
            this.bonus_balance = str3;
            this.deposit_winning_balance = str4;
            this.total_balance = str5;
        }

        public final String getDeposit_balance() {
            return this.deposit_balance;
        }

        public final void setDeposit_balance(String str) {
            this.deposit_balance = str;
        }

        public final String getWinning_balance() {
            return this.winning_balance;
        }

        public final void setWinning_balance(String str) {
            this.winning_balance = str;
        }

        public final String getBonus_balance() {
            return this.bonus_balance;
        }

        public final void setBonus_balance(String str) {
            this.bonus_balance = str;
        }

        public final String getDeposit_winning_balance() {
            return this.deposit_winning_balance;
        }

        public final void setDeposit_winning_balance(String str) {
            this.deposit_winning_balance = str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ PFGWalletBalances(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
            /*
                r4 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto L_0x0007
                r11 = r0
                goto L_0x0008
            L_0x0007:
                r11 = r5
            L_0x0008:
                r5 = r10 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r10 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r10 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r10 & 16
                if (r5 == 0) goto L_0x0023
                r10 = r0
                goto L_0x0024
            L_0x0023:
                r10 = r9
            L_0x0024:
                r5 = r4
                r6 = r11
                r7 = r1
                r8 = r2
                r9 = r3
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.PFGWalletResponse.PFGWalletBalances.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
        }

        public final String getTotal_balance() {
            return this.total_balance;
        }

        public final void setTotal_balance(String str) {
            this.total_balance = str;
        }
    }
}
