package PokerOdds;

public class ConstantValues {
    ////////////////////////////////
    // Constants Values
    ////////////////////////////////
    public int PAKAN_KOKO = 52;
    public int PELAAJIEN_LUKUMAARA = 0;

    public void setPakka(int pakka) {
        this.PAKAN_KOKO = pakka;
    }

    public int getPakka() {
        return this.PAKAN_KOKO;
    }

    public void setPelaajienlukumaara(int value) {
        this.PELAAJIEN_LUKUMAARA = value;
    }

    public int getPelaajienlukumaara() {
        return this.PELAAJIEN_LUKUMAARA;
    }
}
