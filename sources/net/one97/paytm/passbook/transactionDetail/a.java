package net.one97.paytm.passbook.transactionDetail;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f59009a = new a();

    private a() {
    }

    public static String a(Context context, CJRTransaction cJRTransaction) {
        k.c(context, "context");
        k.c(cJRTransaction, "transaction");
        String type = cJRTransaction.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != 49) {
                if (hashCode != 50) {
                    if (hashCode != 53) {
                        if (hashCode != 1568) {
                            if (hashCode != 1598) {
                                if (hashCode != 1600) {
                                    if (hashCode != 1635) {
                                        if (hashCode != 1669) {
                                            if (hashCode != 1691) {
                                                if (hashCode != 1694) {
                                                    if (hashCode != 1761) {
                                                        if (hashCode != 55) {
                                                            if (hashCode != 56) {
                                                                if (hashCode != 1606) {
                                                                    if (hashCode != 1607) {
                                                                        if (hashCode != 1730) {
                                                                            if (hashCode != 1731) {
                                                                                if (hashCode != 1755) {
                                                                                    if (hashCode != 1756) {
                                                                                        switch (hashCode) {
                                                                                            case 1570:
                                                                                                if (type.equals("13")) {
                                                                                                    String string = context.getString(R.string.recent_disputes);
                                                                                                    k.a((Object) string, "context.getString(R.string.recent_disputes)");
                                                                                                    return string;
                                                                                                }
                                                                                                break;
                                                                                            case 1571:
                                                                                                if (type.equals("14")) {
                                                                                                    String string2 = context.getString(R.string.recent_disputes);
                                                                                                    k.a((Object) string2, "context.getString(R.string.recent_disputes)");
                                                                                                    return string2;
                                                                                                }
                                                                                                break;
                                                                                            case 1572:
                                                                                                if (type.equals("15")) {
                                                                                                    String string3 = context.getString(R.string.recent_disputed_resolutions);
                                                                                                    k.a((Object) string3, "context.getString(R.stri…ent_disputed_resolutions)");
                                                                                                    return string3;
                                                                                                }
                                                                                                break;
                                                                                            case 1573:
                                                                                                if (type.equals("16")) {
                                                                                                    String string4 = context.getString(R.string.recent_disputed_resolutions);
                                                                                                    k.a((Object) string4, "context.getString(R.stri…ent_disputed_resolutions)");
                                                                                                    return string4;
                                                                                                }
                                                                                                break;
                                                                                            default:
                                                                                                switch (hashCode) {
                                                                                                    case 1664:
                                                                                                        if (type.equals("44")) {
                                                                                                            String string5 = context.getString(R.string.recent_commission_rollback);
                                                                                                            k.a((Object) string5, "context.getString(R.stri…cent_commission_rollback)");
                                                                                                            return string5;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1665:
                                                                                                        if (type.equals("45")) {
                                                                                                            String string6 = context.getString(R.string.recent_additions);
                                                                                                            k.a((Object) string6, "context.getString(R.string.recent_additions)");
                                                                                                            return string6;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1666:
                                                                                                        if (type.equals("46")) {
                                                                                                            String string7 = context.getString(R.string.recent_additions);
                                                                                                            k.a((Object) string7, "context.getString(R.string.recent_additions)");
                                                                                                            return string7;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1667:
                                                                                                        if (type.equals("47")) {
                                                                                                            String string8 = context.getString(R.string.recent_disputed_resolutions);
                                                                                                            k.a((Object) string8, "context.getString(R.stri…ent_disputed_resolutions)");
                                                                                                            return string8;
                                                                                                        }
                                                                                                        break;
                                                                                                    default:
                                                                                                        switch (hashCode) {
                                                                                                            case 1696:
                                                                                                                if (type.equals("55")) {
                                                                                                                    String string9 = context.getString(R.string.recent_additions);
                                                                                                                    k.a((Object) string9, "context.getString(R.string.recent_additions)");
                                                                                                                    return string9;
                                                                                                                }
                                                                                                                break;
                                                                                                            case 1697:
                                                                                                                if (type.equals("56")) {
                                                                                                                    String string10 = context.getString(R.string.recent_additions);
                                                                                                                    k.a((Object) string10, "context.getString(R.string.recent_additions)");
                                                                                                                    return string10;
                                                                                                                }
                                                                                                                break;
                                                                                                            case 1698:
                                                                                                                if (type.equals("57")) {
                                                                                                                    String string11 = context.getString(R.string.recent_additions);
                                                                                                                    k.a((Object) string11, "context.getString(R.string.recent_additions)");
                                                                                                                    return string11;
                                                                                                                }
                                                                                                                break;
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                    } else if (type.equals("73")) {
                                                                                        String string12 = context.getString(R.string.recent_additions);
                                                                                        k.a((Object) string12, "context.getString(R.string.recent_additions)");
                                                                                        return string12;
                                                                                    }
                                                                                } else if (type.equals("72")) {
                                                                                    String string13 = context.getString(R.string.recent_lien_deductions);
                                                                                    k.a((Object) string13, "context.getString(R.string.recent_lien_deductions)");
                                                                                    return string13;
                                                                                }
                                                                            } else if (type.equals("69")) {
                                                                                if (p.a("DR", cJRTransaction.getTxnType(), true)) {
                                                                                    String string14 = context.getString(R.string.recent_transaction_with_merchant);
                                                                                    k.a((Object) string14, "context.getString(R.stri…ransaction_with_merchant)");
                                                                                    return string14;
                                                                                }
                                                                                String string15 = context.getString(R.string.recent_payment_from_, new Object[]{a(cJRTransaction)});
                                                                                k.a((Object) string15, "context.getString(R.stri…erchantName(transaction))");
                                                                                return string15;
                                                                            }
                                                                        } else if (type.equals("68")) {
                                                                            String string16 = context.getString(R.string.recent_gift_vouchers);
                                                                            k.a((Object) string16, "context.getString(R.string.recent_gift_vouchers)");
                                                                            return string16;
                                                                        }
                                                                    } else if (type.equals("29")) {
                                                                        String string17 = context.getString(R.string.recent_transfers_to_bank);
                                                                        k.a((Object) string17, "context.getString(R.stri…recent_transfers_to_bank)");
                                                                        return string17;
                                                                    }
                                                                } else if (type.equals("28")) {
                                                                    String string18 = context.getString(R.string.recent_cashbacks_rollbacks);
                                                                    k.a((Object) string18, "context.getString(R.stri…cent_cashbacks_rollbacks)");
                                                                    return string18;
                                                                }
                                                            } else if (type.equals("8")) {
                                                                String string19 = context.getString(R.string.recent_rollbacks);
                                                                k.a((Object) string19, "context.getString(R.string.recent_rollbacks)");
                                                                return string19;
                                                            }
                                                        } else if (type.equals("7")) {
                                                            String string20 = context.getString(R.string.recent_cashbacks);
                                                            k.a((Object) string20, "context.getString(R.string.recent_cashbacks)");
                                                            return string20;
                                                        }
                                                    } else if (type.equals("78")) {
                                                        String string21 = context.getString(R.string.recent_lien_refunds);
                                                        k.a((Object) string21, "context.getString(R.string.recent_lien_refunds)");
                                                        return string21;
                                                    }
                                                } else if (type.equals("53")) {
                                                    String string22 = context.getString(R.string.recent_automatic_wallet_topups);
                                                    k.a((Object) string22, "context.getString(R.stri…_automatic_wallet_topups)");
                                                    return string22;
                                                }
                                            } else if (type.equals("50")) {
                                                String string23 = context.getString(R.string.recent_lifafa_sent);
                                                k.a((Object) string23, "context.getString(R.string.recent_lifafa_sent)");
                                                return string23;
                                            }
                                        } else if (type.equals("49")) {
                                            String string24 = context.getString(R.string.recent_additions);
                                            k.a((Object) string24, "context.getString(R.string.recent_additions)");
                                            return string24;
                                        }
                                    } else if (type.equals("36")) {
                                        String string25 = context.getString(R.string.recent_cash_topups);
                                        k.a((Object) string25, "context.getString(R.string.recent_cash_topups)");
                                        return string25;
                                    }
                                } else if (type.equals("22")) {
                                    String string26 = context.getString(R.string.recent_on_hold_transactions);
                                    k.a((Object) string26, "context.getString(R.stri…ent_on_hold_transactions)");
                                    return string26;
                                }
                            } else if (type.equals("20")) {
                                String string27 = context.getString(R.string.recent_wallet_topups);
                                k.a((Object) string27, "context.getString(R.string.recent_wallet_topups)");
                                return string27;
                            }
                        } else if (type.equals("11")) {
                            String string28 = context.getString(R.string.recents_refund_to_source);
                            k.a((Object) string28, "context.getString(R.stri…recents_refund_to_source)");
                            return string28;
                        }
                    } else if (type.equals("5")) {
                        if (p.a("DR", cJRTransaction.getTxnType(), true)) {
                            String string29 = context.getString(R.string.recent_transaction_with_, new Object[]{a(cJRTransaction)});
                            k.a((Object) string29, "context.getString(R.stri…erchantName(transaction))");
                            return string29;
                        }
                        String string30 = context.getString(R.string.recent_transaction_with_, new Object[]{a(cJRTransaction)});
                        k.a((Object) string30, "context.getString(R.stri…erchantName(transaction))");
                        return string30;
                    }
                } else if (type.equals("2")) {
                    String string31 = context.getString(R.string.recent_transaction_with_, new Object[]{a(cJRTransaction)});
                    k.a((Object) string31, "context.getString(R.stri…erchantName(transaction))");
                    return string31;
                }
            } else if (type.equals("1")) {
                String string32 = context.getString(R.string.recent_transaction_with_, new Object[]{a(cJRTransaction)});
                k.a((Object) string32, "context.getString(R.stri…erchantName(transaction))");
                return string32;
            }
        }
        String string33 = context.getString(R.string.recent);
        k.a((Object) string33, "context.getString(R.string.recent)");
        return string33;
    }

    public static String a(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String type = cJRTransaction.getType();
        if ((p.a("5", type, true) || p.a("69", type, true) || p.a("4", type, true) || p.a("20", type, true)) && !TextUtils.isEmpty(cJRTransaction.getTxnDesc1())) {
            String txnDesc1 = cJRTransaction.getTxnDesc1();
            k.a((Object) txnDesc1, "transaction.txnDesc1");
            if (p.b(txnDesc1, "To: ", true)) {
                String txnDesc12 = cJRTransaction.getTxnDesc1();
                k.a((Object) txnDesc12, "transaction.txnDesc1");
                if (txnDesc12 != null) {
                    String substring = txnDesc12.substring(4);
                    k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                    return substring;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            String txnDesc13 = cJRTransaction.getTxnDesc1();
            k.a((Object) txnDesc13, "transaction.txnDesc1");
            if (p.b(txnDesc13, "from: ", true)) {
                String txnDesc14 = cJRTransaction.getTxnDesc1();
                k.a((Object) txnDesc14, "transaction.txnDesc1");
                if (txnDesc14 != null) {
                    String substring2 = txnDesc14.substring(6);
                    k.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                    return substring2;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            String txnDesc15 = cJRTransaction.getTxnDesc1();
            k.a((Object) txnDesc15, "transaction.txnDesc1");
            return txnDesc15;
        } else if (p.a("1", type, true) && !TextUtils.isEmpty(cJRTransaction.getTxnTo())) {
            String txnTo = cJRTransaction.getTxnTo();
            k.a((Object) txnTo, "transaction.txnTo");
            return txnTo;
        } else if ((p.a("7", type, true) || p.a("2", type, true)) && !TextUtils.isEmpty(cJRTransaction.getTxnFrom())) {
            String txnFrom = cJRTransaction.getTxnFrom();
            k.a((Object) txnFrom, "transaction.txnFrom");
            return txnFrom;
        } else if (p.a("29", type, true) && !TextUtils.isEmpty(cJRTransaction.getTxnDesc4())) {
            String txnDesc4 = cJRTransaction.getTxnDesc4();
            k.a((Object) txnDesc4, "transaction.txnDesc4");
            return txnDesc4;
        } else if (p.a("11", type, true) && !TextUtils.isEmpty(cJRTransaction.getTxnDesc4())) {
            String txnDesc42 = cJRTransaction.getTxnDesc4();
            k.a((Object) txnDesc42, "transaction.txnDesc4");
            return txnDesc42;
        } else if (!p.a("50", type, true) || TextUtils.isEmpty(cJRTransaction.getTxnDesc1())) {
            return "";
        } else {
            String txnDesc16 = cJRTransaction.getTxnDesc1();
            k.a((Object) txnDesc16, "transaction.txnDesc1");
            return txnDesc16;
        }
    }

    public static boolean b(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String type = cJRTransaction.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != 49) {
                if (hashCode != 50) {
                    if (hashCode != 53) {
                        if (hashCode != 1568) {
                            if (hashCode != 1598) {
                                if (hashCode != 1600) {
                                    if (hashCode != 1635) {
                                        if (hashCode != 1669) {
                                            if (hashCode != 1691) {
                                                if (hashCode != 1694) {
                                                    if (hashCode != 1761) {
                                                        if (hashCode != 55) {
                                                            if (hashCode != 56) {
                                                                if (hashCode != 1606) {
                                                                    if (hashCode != 1607) {
                                                                        if (hashCode != 1730) {
                                                                            if (hashCode != 1731) {
                                                                                if (hashCode != 1755) {
                                                                                    if (hashCode != 1756) {
                                                                                        switch (hashCode) {
                                                                                            case 1570:
                                                                                                if (type.equals("13")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            case 1571:
                                                                                                if (type.equals("14")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            case 1572:
                                                                                                if (type.equals("15")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            case 1573:
                                                                                                if (type.equals("16")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            default:
                                                                                                switch (hashCode) {
                                                                                                    case 1664:
                                                                                                        if (type.equals("44")) {
                                                                                                            return true;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1665:
                                                                                                        if (type.equals("45")) {
                                                                                                            return false;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1666:
                                                                                                        if (type.equals("46")) {
                                                                                                            return false;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1667:
                                                                                                        if (type.equals("47")) {
                                                                                                            return true;
                                                                                                        }
                                                                                                        break;
                                                                                                    default:
                                                                                                        switch (hashCode) {
                                                                                                            case 1696:
                                                                                                                if (type.equals("55")) {
                                                                                                                    return false;
                                                                                                                }
                                                                                                                break;
                                                                                                            case 1697:
                                                                                                                if (type.equals("56")) {
                                                                                                                    return false;
                                                                                                                }
                                                                                                                break;
                                                                                                            case 1698:
                                                                                                                if (type.equals("57")) {
                                                                                                                    return false;
                                                                                                                }
                                                                                                                break;
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                    } else if (type.equals("73")) {
                                                                                        return false;
                                                                                    }
                                                                                } else if (type.equals("72")) {
                                                                                    return true;
                                                                                }
                                                                            } else if (type.equals("69")) {
                                                                                return true;
                                                                            }
                                                                        } else if (type.equals("68")) {
                                                                            return false;
                                                                        }
                                                                    } else if (type.equals("29")) {
                                                                        return true;
                                                                    }
                                                                } else if (type.equals("28")) {
                                                                    return true;
                                                                }
                                                            } else if (type.equals("8")) {
                                                                return false;
                                                            }
                                                        } else if (type.equals("7")) {
                                                            return false;
                                                        }
                                                    } else if (type.equals("78")) {
                                                        return false;
                                                    }
                                                } else if (type.equals("53")) {
                                                    return false;
                                                }
                                            } else if (type.equals("50")) {
                                                return true;
                                            }
                                        } else if (type.equals("49")) {
                                            return false;
                                        }
                                    } else if (type.equals("36")) {
                                        return false;
                                    }
                                } else if (type.equals("22")) {
                                    return false;
                                }
                            } else if (type.equals("20")) {
                                return false;
                            }
                        } else if (type.equals("11")) {
                            return true;
                        }
                    } else if (type.equals("5")) {
                        return true;
                    }
                } else if (type.equals("2")) {
                    return true;
                }
            } else if (type.equals("1")) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String type = cJRTransaction.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != 49) {
                if (hashCode != 50) {
                    if (hashCode != 53) {
                        if (hashCode != 1568) {
                            if (hashCode != 1598) {
                                if (hashCode != 1600) {
                                    if (hashCode != 1635) {
                                        if (hashCode != 1669) {
                                            if (hashCode != 1691) {
                                                if (hashCode != 1694) {
                                                    if (hashCode != 1761) {
                                                        if (hashCode != 55) {
                                                            if (hashCode != 56) {
                                                                if (hashCode != 1606) {
                                                                    if (hashCode != 1607) {
                                                                        if (hashCode != 1730) {
                                                                            if (hashCode != 1731) {
                                                                                if (hashCode != 1755) {
                                                                                    if (hashCode != 1756) {
                                                                                        switch (hashCode) {
                                                                                            case 1570:
                                                                                                if (type.equals("13")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            case 1571:
                                                                                                if (type.equals("14")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            case 1572:
                                                                                                if (type.equals("15")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            case 1573:
                                                                                                if (type.equals("16")) {
                                                                                                    return true;
                                                                                                }
                                                                                                break;
                                                                                            default:
                                                                                                switch (hashCode) {
                                                                                                    case 1664:
                                                                                                        if (type.equals("44")) {
                                                                                                            return false;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1665:
                                                                                                        if (type.equals("45")) {
                                                                                                            return true;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1666:
                                                                                                        if (type.equals("46")) {
                                                                                                            return true;
                                                                                                        }
                                                                                                        break;
                                                                                                    case 1667:
                                                                                                        if (type.equals("47")) {
                                                                                                            return true;
                                                                                                        }
                                                                                                        break;
                                                                                                    default:
                                                                                                        switch (hashCode) {
                                                                                                            case 1696:
                                                                                                                if (type.equals("55")) {
                                                                                                                    return true;
                                                                                                                }
                                                                                                                break;
                                                                                                            case 1697:
                                                                                                                if (type.equals("56")) {
                                                                                                                    return true;
                                                                                                                }
                                                                                                                break;
                                                                                                            case 1698:
                                                                                                                if (type.equals("57")) {
                                                                                                                    return true;
                                                                                                                }
                                                                                                                break;
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                    } else if (type.equals("73")) {
                                                                                        return true;
                                                                                    }
                                                                                } else if (type.equals("72")) {
                                                                                    return false;
                                                                                }
                                                                            } else if (type.equals("69")) {
                                                                                return true;
                                                                            }
                                                                        } else if (type.equals("68")) {
                                                                            return true;
                                                                        }
                                                                    } else if (type.equals("29")) {
                                                                        return false;
                                                                    }
                                                                } else if (type.equals("28")) {
                                                                    return false;
                                                                }
                                                            } else if (type.equals("8")) {
                                                                return true;
                                                            }
                                                        } else if (type.equals("7")) {
                                                            return true;
                                                        }
                                                    } else if (type.equals("78")) {
                                                        return true;
                                                    }
                                                } else if (type.equals("53")) {
                                                    return true;
                                                }
                                            } else if (type.equals("50")) {
                                                return false;
                                            }
                                        } else if (type.equals("49")) {
                                            return true;
                                        }
                                    } else if (type.equals("36")) {
                                        return true;
                                    }
                                } else if (type.equals("22")) {
                                    return false;
                                }
                            } else if (type.equals("20")) {
                                return true;
                            }
                        } else if (type.equals("11")) {
                            return false;
                        }
                    } else if (type.equals("5")) {
                        return true;
                    }
                } else if (type.equals("2")) {
                    return true;
                }
            } else if (type.equals("1")) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context, CJRTransaction cJRTransaction) {
        k.c(context, "context");
        k.c(cJRTransaction, "transaction");
        String type = cJRTransaction.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != 1568) {
                if (hashCode != 1570) {
                    if (hashCode != 1606) {
                        if (hashCode != 1664) {
                            if (hashCode == 1755 && type.equals("72")) {
                                String string = context.getString(R.string.pass_lien_deductions);
                                k.a((Object) string, "context.getString(R.string.pass_lien_deductions)");
                                return string;
                            }
                        } else if (type.equals("44")) {
                            String string2 = context.getString(R.string.pass_commission_reversed);
                            k.a((Object) string2, "context.getString(R.stri…pass_commission_reversed)");
                            return string2;
                        }
                    } else if (type.equals("28")) {
                        String string3 = context.getString(R.string.pass_cashback_reversed);
                        k.a((Object) string3, "context.getString(R.string.pass_cashback_reversed)");
                        return string3;
                    }
                } else if (type.equals("13")) {
                    String string4 = context.getString(R.string.pass_money_disputed);
                    k.a((Object) string4, "context.getString(R.string.pass_money_disputed)");
                    return string4;
                }
            } else if (type.equals("11")) {
                String string5 = context.getString(R.string.pass_refunds_to_source);
                k.a((Object) string5, "context.getString(R.string.pass_refunds_to_source)");
                return string5;
            }
        }
        String string6 = context.getString(R.string.money_sent);
        k.a((Object) string6, "context.getString(R.string.money_sent)");
        return string6;
    }

    public static String c(Context context, CJRTransaction cJRTransaction) {
        k.c(context, "context");
        k.c(cJRTransaction, "transaction");
        String type = cJRTransaction.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != 55) {
                if (hashCode != 56) {
                    if (hashCode != 1570) {
                        if (hashCode != 1598) {
                            if (hashCode != 1635) {
                                if (hashCode != 1694) {
                                    if (hashCode != 1730) {
                                        if (hashCode == 1761 && type.equals("78")) {
                                            String string = context.getString(R.string.pass_lien_refunds);
                                            k.a((Object) string, "context.getString(R.string.pass_lien_refunds)");
                                            return string;
                                        }
                                    } else if (type.equals("68")) {
                                        String string2 = context.getString(R.string.money_added);
                                        k.a((Object) string2, "context.getString(R.string.money_added)");
                                        return string2;
                                    }
                                } else if (type.equals("53")) {
                                    String string3 = context.getString(R.string.money_added);
                                    k.a((Object) string3, "context.getString(R.string.money_added)");
                                    return string3;
                                }
                            } else if (type.equals("36")) {
                                String string4 = context.getString(R.string.pass_cash_added);
                                k.a((Object) string4, "context.getString(R.string.pass_cash_added)");
                                return string4;
                            }
                        } else if (type.equals("20")) {
                            String string5 = context.getString(R.string.money_added);
                            k.a((Object) string5, "context.getString(R.string.money_added)");
                            return string5;
                        }
                    } else if (type.equals("13")) {
                        String string6 = context.getString(R.string.pass_disputes_resolved);
                        k.a((Object) string6, "context.getString(R.string.pass_disputes_resolved)");
                        return string6;
                    }
                } else if (type.equals("8")) {
                    String string7 = context.getString(R.string.pass_rollback_received);
                    k.a((Object) string7, "context.getString(R.string.pass_rollback_received)");
                    return string7;
                }
            } else if (type.equals("7")) {
                String string8 = context.getString(R.string.cashback_received);
                k.a((Object) string8, "context.getString(R.string.cashback_received)");
                return string8;
            }
        }
        String string9 = context.getString(R.string.money_received);
        k.a((Object) string9, "context.getString(R.string.money_received)");
        return string9;
    }

    public static List<CJRTransaction> a(ArrayList<CJRTransaction> arrayList) {
        k.c(arrayList, "transactionList");
        Collection arrayList2 = new ArrayList();
        for (Object next : arrayList) {
            if (!p.a(((CJRTransaction) next).getTxnStatus(), "FAILURE", true)) {
                arrayList2.add(next);
            }
        }
        return (List) arrayList2;
    }
}
