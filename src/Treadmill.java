public class Treadmill extends Obstacles{
    private int isLong;
    Treadmill(int isLong){
        this.isLong = isLong;
    }
    public void runOrJump(Participant participant){
        participant.run();
        System.out.println(" - пробежал дорожку");
    }


    @Override
    public int getIsLong() {
        return isLong;
    }
}
