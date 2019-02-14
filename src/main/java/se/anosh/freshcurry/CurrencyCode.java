/**
 *
 * This file defines the permissible currency codes
 * accepted by the REST-service
 *
 * The codes are defined in ISO 4217
 *
 * Enum code by Istvan Devai 2018
 *
 */
package se.anosh.freshcurry;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public enum CurrencyCode {
    /**
     * € Euro. It is the server's default base-currency
     */
    EUR(1),
    /**
     * Australian dollar
     */
    AUD(2),
    /**
     * Bulgarian lev
     */
    BGN(3),
    /**
     * Brazilian real
     */
    BRL(4),
    /**
     * Canadian dollar
     */
    CAD(5),
    /**
     * Swiss franc
     */
    CHF(6),
    /**
     * Renminbi (Chinese) yuan
     */
    CNY(7),
    /**
     * Czech koruna
     */
    CZK(8),
    /**
     * Danish krone
     */
    DKK(9),
    /**
     * £ British pound sterling
     */
    GBP(10),
    /**
     * Hong Kong dollar
     */
    HKD(11),
    /**
     * Croatian kuna
     */
    HRK(12),
    /**
     * Hungarian forint
     */
    HUF(13),
    /**
     * Indonesian rupiah
     */
    IDR(14),
    /**
     * ₪ Israeli new shekel
     */
    ILS(15),
    /**
     * Indian rupee
     */
    INR(16),
    /**
     * Icelandic króna
     */
    ISK(17),
    /**
     * ¥ Japanese yen
     */
    JPY(18),
    /**
     * South Korean won
     */
    KRW(19),
    /**
     * Mexican peso
     */
    MXN(20),
    /**
     * Malaysian ringgit
     */
    MYR(21),
    /**
     * Norwegian krone
     */
    NOK(22),
    /**
     * New Zealand dollar
     */
    NZD(23),
    /**
     * Philippine peso
     */
    PHP(24),
    /**
     * Polish złoty
     */
    PLN(25),
    /**
     * Romanian leu
     */
    RON(26),
    /**
     * Russian ruble
     */
    RUB(27),
    /**
     * Swedish krona
     */
    SEK(28),
    /**
     * Singapore dollar
     */
    SGD(29),
    /**
     * Thai baht
     */
    THB(30),
    /**
     * Turkish lira
     */
    TRY(31),
    /**
     * United States dollar $
     */
    USD(32),
    /**
     * South African rand
     */
    ZAR(33);

    private int code;
     private static final Map<Integer,CurrencyCode> lookup 
          = new HashMap<Integer,CurrencyCode>();

     static {
          for(CurrencyCode w : EnumSet.allOf(CurrencyCode.class))
               lookup.put(w.getCode(), w);
     }

     private CurrencyCode(int code) {
          this.code = code;
     }

     public int getCode() { return code; }

     public static CurrencyCode get(int code) { 
          return lookup.get(code); 
     }
}
