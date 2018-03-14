package SiteMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Allan Tejano
 * 3/6/2018
 */
public class SiteValues {
    public SiteValues( Map<String, List<Meaurement>> siteToValues ) {
        this.siteToValues = siteToValues;
    }

    public Map<String, List<Meaurement>> getSiteToValues() {
        return siteToValues;
    }

    Map<String, List<Meaurement>> siteToValues = new HashMap<>();
}
