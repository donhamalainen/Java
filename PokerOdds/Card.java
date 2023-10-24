package PokerOdds;

public class Card {
    ////////////////////////////////
    // Cards
    ////////////////////////////////
    private final char MAA;
    private final char ARVO;

    public Card(char country, char value) {
        this.MAA = country;
        this.ARVO = value;
    }

    public char getMAA() {
        return this.MAA;
    }

    public char getArvo() {
        return this.ARVO;
    }
}
