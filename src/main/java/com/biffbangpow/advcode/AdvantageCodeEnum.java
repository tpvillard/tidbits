package com.biffbangpow.advcode;


public enum AdvantageCodeEnum implements AdvantageCode {

    GH03C {
        @Override
        public String getId() {
            return name();
        }
    };
}
