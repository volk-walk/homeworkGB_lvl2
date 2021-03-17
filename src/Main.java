import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList <Participant> participants = new ArrayList<>();
        Participant cat1 = new Cat(1, 5);
        Participant robot1 = new Robot(6, 3);
        Participant human1 = new Human(1, 6);
        participants.add(cat1);
        participants.add(robot1);
        participants.add(human1);
        Iterator<Participant> participantIterator = participants.iterator();

        Obstacles[] obstacles = {
                new Wall(5),
                new Treadmill(5),
        };
        while (participantIterator.hasNext()) {
            Participant nextParticipant = participantIterator.next();
            for (Obstacles o: obstacles) {
                if (o.getHeight() > nextParticipant.getHeightOfJump() || o.getIsLong() > nextParticipant.getLongOfRun()){
                    System.out.println("Участник не преодолел препятсвие и выбыл");
                    participantIterator.remove();
                    break;
                }
                else {
                    o.runOrJump(nextParticipant);
                }
            }
        }
    }
}
