package com.sendbird.android;

enum m {
    EROR(false),
    LOGI(false),
    MESG(true),
    FILE(true),
    EXIT(true),
    READ(true),
    MEDI(true),
    FEDI(true),
    ENTR(true),
    BRDM(false),
    ADMM(false),
    AEDI(false),
    TPST(false),
    TPEN(false),
    MTIO(false),
    SYEV(false),
    USEV(false),
    DELM(false),
    LEAV(false),
    UNRD(false),
    DLVR(false),
    NOOP(false),
    MRCT(false),
    PING(false),
    PONG(false),
    MACK(false),
    JOIN(false),
    MTHD(false),
    NONE(false);
    
    private final boolean isAckRequired;

    private m(boolean z) {
        this.isAckRequired = z;
    }

    public final boolean isAckRequired() {
        return this.isAckRequired;
    }

    static m from(String str) {
        for (m mVar : values()) {
            if (mVar.name().equals(str)) {
                return mVar;
            }
        }
        return NONE;
    }
}
