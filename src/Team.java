import java.util.HashMap;

public class Team {
    String name;
    HashMap<String, Integer> records;

    public Team(String name) {
        this.name = name;
        this.records = new HashMap<String, Integer>();
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getRecords() {
        return records;
    }

    public void addRecord(String name, int wins){
        records.put(name, wins);
    }

    public String getWins(String team){
        return String.valueOf(records.get(team));
    }

    @Override
    public String toString() {
        return name;
    }
}
