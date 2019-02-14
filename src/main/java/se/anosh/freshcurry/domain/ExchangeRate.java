package se.anosh.freshcurry.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * This is a domain class used for JSON serialization & de-serialization
 * 
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@XmlRootElement
public class ExchangeRate {
    
    private String base;
    private String date;
    private Map<String,BigDecimal> rates;
    
    public ExchangeRate() {
        
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, BigDecimal> getRates() {
        return Collections.unmodifiableMap(rates);
    }

    @Override
    public String toString() {
        return "Currency{" + "base=" + base + ", date=" + date + ", rates=" + rates + '}';
    }

    
}
