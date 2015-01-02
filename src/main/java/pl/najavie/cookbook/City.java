package pl.najavie.cookbook;

import java.util.Date;

/**
 * Created by krzysztof on 1/2/15.
 */
public enum City {
    WARSZAWA,GDYNIA;

    public static City getCity() {
        if(new Date().getTime() %2 == 0) {
            return WARSZAWA;
        }
        return GDYNIA;
    }
}
