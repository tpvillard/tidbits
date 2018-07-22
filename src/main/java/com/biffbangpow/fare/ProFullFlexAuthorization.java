package com.biffbangpow.fare;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class ProFullFlexAuthorization {

    enum FceType {

        CONTRAT_PRO("7") {
            @Override
            boolean isAuthorized(NegociatedFareAuthorization authorization) {
                return true;
            }
        },
        GRAND_COMPTE("2") {
            @Override
            boolean isAuthorized(NegociatedFareAuthorization authorization) {
                return authorization == NegociatedFareAuthorization.AUTHORIZED;
            }
        },
        OTHER(null) {
            @Override
            boolean isAuthorized(NegociatedFareAuthorization authorization) {
                return false;
            }
        };

        private final String fceTypologie;

        FceType(String fceTypologie) {
            this.fceTypologie = fceTypologie;
        }

        String getFceTypologie() {
            return fceTypologie;
        }

        abstract boolean isAuthorized(NegociatedFareAuthorization authorization);

        static FceType of(String fceTypologie) {
            return Arrays.stream(FceType.values()).filter(getFceTypePredicate(fceTypologie)).findFirst().orElse(OTHER);
        }

        private static Predicate<FceType> getFceTypePredicate(String fceTypologie) {
            return fceType -> fceType.getFceTypologie().equalsIgnoreCase(fceTypologie);
        }
    }

    private UserProfile profile;

    public boolean isAuthorized() {
        return FceType.of(getFceTypologie()).isAuthorized(profile.getNegociatedFareAuthorization());
    }

    private String getFceTypologie() {
        return "5";
    }
}
