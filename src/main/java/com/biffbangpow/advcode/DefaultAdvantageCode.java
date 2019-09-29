package com.biffbangpow.advcode;


public class DefaultAdvantageCode implements AdvantageCode {

    final private String name;

    public DefaultAdvantageCode(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultAdvantageCode that = (DefaultAdvantageCode) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
