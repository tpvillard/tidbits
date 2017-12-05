package com.biffbangpow.shift;


public class MaxGain {

    public static Result maxGain(int[] prices) {

        int refPrice = prices[0];
        Result res = new Result(0, 0, 0);
        int ref_index = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int gainAti = price - refPrice;
            if (gainAti > res.getGain()) {
                res = new Result(ref_index, i, gainAti);
            }
            if (price < refPrice) {
                ref_index = i;
                refPrice = price;
            }
        }
        return res;
    }

    public static class Result {

        private final int refIndex;
        private final int maxIndex;
        private final int gain;

        public Result(int refIndex, int maxIndex, int gain) {
            this.refIndex = refIndex;
            this.maxIndex = maxIndex;
            this.gain = gain;
        }

        public int getGain() {
            return gain;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Result result = (Result) o;

            if (refIndex != result.refIndex) return false;
            if (maxIndex != result.maxIndex) return false;
            return gain == result.gain;
        }

        @Override
        public int hashCode() {
            int result = refIndex;
            result = 31 * result + maxIndex;
            result = 31 * result + gain;
            return result;
        }
    }
}
