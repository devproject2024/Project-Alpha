package net.one97.paytm.wallet.chatintegration;

public final class b {

    public enum a {
        NONE(0),
        FIXED(1),
        NOT_FIXED(2);
        
        private int type;

        protected a(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }
}
