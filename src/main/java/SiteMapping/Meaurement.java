package SiteMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Allan Tejano
 * 3/6/2018
 */
public class Meaurement {
    public Meaurement( LocalDateTime time, BigDecimal value ) {
        this.time = time;
        this.value = value;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime( LocalDateTime time ) {
        this.time = time;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue( BigDecimal value ) {
        this.value = value;
    }

    LocalDateTime time;
    BigDecimal value;
}
