public class Wall extends Obstacles{
    private int height;
    Wall(int height){
        this.height = height;
    }
    public void runOrJump(Participant participant){
        participant.jump();
        System.out.println(" - перепрыгнул стену");
    }

    @Override
    public int getHeight() {
        return height;
    }

}
