public class Human extends Participant{
    private int heightOfJump;
    private int longOfRun;
    Human(int heightOfJump, int longOfRun){
        this.heightOfJump = heightOfJump;
        this.longOfRun = longOfRun;
    }
    @Override
    public void run() {
        System.out.print("Человек побегал");
    }

    @Override
    public void jump() {
        System.out.print("Человек попрыгал");
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
