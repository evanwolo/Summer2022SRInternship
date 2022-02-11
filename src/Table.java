import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Set;

public class Table {

    ArrayList<Row> rows;
    Row header;
    ArrayList<Team> teams;

    public Table(String filepath) throws IOException {
        this.rows = new ArrayList<Row>();
        this.teams = parseJson(filepath);
        this.header = makeHeader();
        buildTable();
    }

    static ArrayList<Team> parseJson(String JSONFile) throws IOException {
        ArrayList<Team> teams = new ArrayList<Team>();

        URI uri = new File(JSONFile).toURI();
        JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
        JSONObject root = new JSONObject(tokener);

        Set<String> keys = root.keySet();

        for(String key : keys){
            Team team = new Team(key);
            JSONObject JTeam = root.getJSONObject(key);
            Set<String> inner = JTeam.keySet();
            for(String i : inner) {
                int w = JTeam.getJSONObject(i).getInt("W");
                team.addRecord(i,w);
            }
            teams.add(team);
        }
        return teams;
    }

    Row makeHeader() {
        Row header = new Row(this.rows.size());
        header.add("Tm");
        for (Team t : teams) {
            header.add(t.toString());
        }
        return header;
    }

    void buildTable(){
        for(Team team : teams){
            Row row = new Row(teams.size(), team.getName());
            row.add(team.getName());
            for (int i = 1; i < teams.size(); i++) {
                if(header.get(i).equals(team.getName())){
                    row.add("--");
                }
                else
                    row.add(team.getWins(header.get(i)));

            }
            rows.add(row);
        }

    }

    @Override
    public String toString() {
        String table = "";
        table += header + "\n";
        for(Row row : this.rows){
            table += row.toString() + "\n";
        }
        table += header;
        return table;
    }

    public static void main(String[] args) throws IOException {
        Table table = new Table("src/TeamWL.json");
        System.out.println(table);
    }

}
