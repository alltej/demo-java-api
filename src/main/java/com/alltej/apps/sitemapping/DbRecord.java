package com.alltej.apps.sitemapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Allan Tejano
 * 3/6/2018
 */
public class DbRecord {
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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName( String siteName ) {
        this.siteName = siteName;
    }

    public DbRecord( LocalDateTime time, BigDecimal value, String siteName ) {
        this.time = time;
        this.value = value;
        this.siteName = siteName;
    }

    LocalDateTime time;
    BigDecimal value;
    String siteName;
}
