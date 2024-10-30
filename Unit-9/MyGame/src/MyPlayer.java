public class MyPlayer {
    private int id;
    private String name;
    private int power;

    public MyPlayer(int id, String name, int power) {
        this.id = id;
        this.name = name;

        if (power <= 2) {
            this.power = 10;
        } else {
            this.power = power;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power > 0) {
            if (this.power >= power) {
                this.power -= power;
            } else {
                this.power = 0;
            }
        }
    }

    public MyPlayer deepCopy() {
        return new MyPlayer(this.id, this.name, this.power);
    }

    public boolean equals (MyPlayer playerX) {
        return this.power == playerX.power;
    }

    @Override
    public String toString() {
        return "MyPlayer\tid=" + this.id + "\tname=" + this.name + "\tpower=" + this.power;
    }
}