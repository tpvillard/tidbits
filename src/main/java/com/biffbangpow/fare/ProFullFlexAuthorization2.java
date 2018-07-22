package com.biffbangpow.fare;

import java.util.Arrays;
import java.util.function.Predicate;

public class ProFullFlexAuthorization2 {

    private static final String GRAND_COMPTE = "2";
    private static final String CONTRAT_PRO = "7";

    private UserProfile profile;

    public boolean isAuthorized() {
        switch (getFceTypologie()) {
            case GRAND_COMPTE:
                return profile.getNegociatedFareAuthorization() == NegociatedFareAuthorization.AUTHORIZED;
            case CONTRAT_PRO:
                return true;
            default:
                return false;

        }
    }

    private String getFceTypologie() {
        return "5";
    }
}
