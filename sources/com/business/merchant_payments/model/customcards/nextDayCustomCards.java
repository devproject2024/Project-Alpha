package com.business.merchant_payments.model.customcards;

import kotlin.g.b.k;

public final class nextDayCustomCards {
    public String cards;
    public final long timestamp;

    public static /* synthetic */ nextDayCustomCards copy$default(nextDayCustomCards nextdaycustomcards, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nextdaycustomcards.cards;
        }
        if ((i2 & 2) != 0) {
            j = nextdaycustomcards.timestamp;
        }
        return nextdaycustomcards.copy(str, j);
    }

    public final String component1() {
        return this.cards;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final nextDayCustomCards copy(String str, long j) {
        k.d(str, "cards");
        return new nextDayCustomCards(str, j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nextDayCustomCards)) {
            return false;
        }
        nextDayCustomCards nextdaycustomcards = (nextDayCustomCards) obj;
        return k.a((Object) this.cards, (Object) nextdaycustomcards.cards) && this.timestamp == nextdaycustomcards.timestamp;
    }

    public final int hashCode() {
        String str = this.cards;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.timestamp;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "nextDayCustomCards(cards=" + this.cards + ", timestamp=" + this.timestamp + ")";
    }

    public nextDayCustomCards(String str, long j) {
        k.d(str, "cards");
        this.cards = str;
        this.timestamp = j;
    }

    public final String getCards() {
        return this.cards;
    }

    public final void setCards(String str) {
        k.d(str, "<set-?>");
        this.cards = str;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
