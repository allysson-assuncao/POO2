package org.example.generics2.Teste;

import org.example.generics.Ex3.Pair;

import java.util.Date;

class DateInterval extends Pair<Date> {

    public void setSecond(Date second) {
        if (second.compareTo(getFirst()) >= 0)
            super.setSecond(second);
    }

}
