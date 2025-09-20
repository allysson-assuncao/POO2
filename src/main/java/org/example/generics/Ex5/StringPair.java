package org.example.generics.Ex5;

public class StringPair extends Pair<String> {
    public StringPair() { super(); }
    public StringPair(String first, String second) { super(first, second); }

    public int totalLength() {
        int a = getFirst() == null ? 0 : getFirst().length();
        int b = getSecond() == null ? 0 : getSecond().length();
        return a + b;
    }
}
