public class ManaganCard {
    String name;
    double price;
    int rarity;
    String cardArt;

    ManaganCard(String name, double price, int rarity, String cardArt) {
        this.name = name;
        this.price = price;
        this.rarity = rarity;
        this.cardArt = cardArt;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String getCardArt() {
        return cardArt;
    }

    public void setCardArt(String cardArt) {
        this.cardArt = cardArt;
    }

    // rarity will be taken as an int and translated into strings
    // i.e. 1 is a common, 2 is a holo, 3 is an sir, etc etc

    public String returnCardRarity(int rarity) {
        switch (rarity) {
            case 1:
                return "Common";
            case 2:
                return "Uncommon";
            case 3:
                return "Rare";
            default:
                return "Rarity N/A.";
        }
    }
}
