package com.mx.persist.contants;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 季先生 on 2017/8/2 14:33.
 */
@Component
public class ApplicationPorperties {

    @Value("${random.str}")
    private String randomStr;

    @Value("${random1.int}")
    private String randomInt;

    @Value("${random1.long}")
    private String randomLong;

    @Value("${random1.int10}")
    private String randomInt10;

    @Value("${random1.number.1020}")
    private String randomInt1020;

    public String getRandomStr() {
        return randomStr;
    }

    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr;
    }

    public String getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(String randomInt) {
        this.randomInt = randomInt;
    }

    public String getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(String randomLong) {
        this.randomLong = randomLong;
    }

    public String getRandomInt10() {
        return randomInt10;
    }

    public void setRandomInt10(String randomInt10) {
        this.randomInt10 = randomInt10;
    }

    public String getRandomInt1020() {
        return randomInt1020;
    }

    public void setRandomInt1020(String randomInt1020) {
        this.randomInt1020 = randomInt1020;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ApplicationPorperties that = (ApplicationPorperties) o;

        return new EqualsBuilder()
                .append(randomStr, that.randomStr)
                .append(randomInt, that.randomInt)
                .append(randomLong, that.randomLong)
                .append(randomInt10, that.randomInt10)
                .append(randomInt1020, that.randomInt1020)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(randomStr)
                .append(randomInt)
                .append(randomLong)
                .append(randomInt10)
                .append(randomInt1020)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ApplicationPorperties{" +
                "randomStr='" + randomStr + '\'' +
                ", randomInt='" + randomInt + '\'' +
                ", randomLong='" + randomLong + '\'' +
                ", randomInt10='" + randomInt10 + '\'' +
                ", randomInt1020='" + randomInt1020 + '\'' +
                '}';
    }
}
