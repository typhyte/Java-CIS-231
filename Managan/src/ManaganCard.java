public class ManaganCard {
    String name;
    int id;
    double price;
    int rarity;
    boolean isOwned;
    String cardArt;

    ManaganCard(String name, int id, double price, boolean isOwned, String cardArt) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.isOwned = isOwned;
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
            case 0:
                return "Common";
            case 1:
                return "Uncommon";
            case 2:
                return "Rare";
            default:
                return "Rarity N/A.";
        }
    }
}
