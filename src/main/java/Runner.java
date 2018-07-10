import db.DBGolfer;
import models.Golfer;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Golfer golfer1 = new Golfer("Tiger", "Woods", 42);
        DBGolfer.save(golfer1);
        Golfer golfer2 = new Golfer("Jordan", "Speith", 24);
        DBGolfer.save(golfer2);
        Golfer golfer3 = new Golfer("Phil", "Michelson", 48);
        DBGolfer.save(golfer3);

        List<Golfer> Golfers = DBGolfer.getAll();

        Golfer phil = DBGolfer.find(golfer3.getId());

        System.exit(0);

    }
}
