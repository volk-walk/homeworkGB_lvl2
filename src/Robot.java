public class Robot extends Participant {
    private int heightOfJump;
    private int longOfRun;
    Robot (int heightOfJump, int longOfRun) {
        this.heightOfJump = heightOfJump;
        this.longOfRun = longOfRun;
    }
    @Override
    public void run() {
        System.out.print("Робот побегал");
    }

    @Override
    public void jump() {
        System.out.print("Робот попрыгал");
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
