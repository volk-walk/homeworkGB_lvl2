public class Cat extends Participant{
    private int heightOfJump;
    private int longOfRun;
    Cat(int heightOfJump, int longOfRun) {
        this.heightOfJump = heightOfJump;
        this.longOfRun = longOfRun;
    }
    @Override
    public void run() {
        System.out.print("Котик побегал");
    }

    @Override
    public void jump() {
        System.out.print("Котик попрыгал");
    }

    @Override
    public int getHeightOfJump() {
        return heightOfJump;
    }

    @Override
    public int getLongOfRun() {
        return longOfRun;
    }
}
