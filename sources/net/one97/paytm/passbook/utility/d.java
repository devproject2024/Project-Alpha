package net.one97.paytm.passbook.utility;

import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.sendbird.android.constant.StringSet;

public interface d {

    public enum b {
        TAB_ALL(0, StringSet.all),
        TAB_PAID(1, "TAB_PAID"),
        TAB_RECEIVED(2, "received"),
        TAB_ADDED(3, SyncContactBean.Status.STATUS_ADDED),
        TAB_AUTHORISED(4, "authorised");
        
        private final int position;
        private final String tabName;

        private b(int i2, String str) {
            this.position = i2;
            this.tabName = str;
        }

        public final String getTabName() {
            return this.tabName;
        }
    }

    public enum a {
        ;
        
        private String mWalletUserState;
        private String mv2UserState;

        private a(String str, String str2) {
            this.mv2UserState = str;
            this.mWalletUserState = str2;
        }

        public final String getv2UserState() {
            return this.mv2UserState;
        }

        public final String getWalletUserState() {
            return this.mWalletUserState;
        }
    }
}
