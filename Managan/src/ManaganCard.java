public class ManaganCard {
    String name;
    int id;
    int price;
    int rarity;
    boolean isOwned;
    String cardArt;

    ManaganCard(String name, int id, int price, boolean isOwned, String cardArt, int rarity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.isOwned = isOwned;
        this.cardArt = cardArt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    @Override
    public String toString() {
        return this.name + "," + this.id + "," + this.price + "," + this.isOwned + "," + this.cardArt + "," + this.rarity;
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
                return "Not Collected";
        }
    }
}
