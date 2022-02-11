import java.util.ArrayList;

public class Row {

    private ArrayList<String> spaces;
    private String name;

    public Row(int length, String name) {
        this.spaces = new ArrayList<String>(length);
        this.name = name;
    }

    public Row(int length) {
        this.spaces = new ArrayList<String>(length);
        this.name = name;
    }

    public void add(String item){
        this.spaces.add(item);
    }

    public int length(){
        return this.spaces.size();
    }

    public String get(int index){
        return String.valueOf(spaces.get(index));
    }

    @Override
    public String toString() {
        String row = "";
        for(String element : spaces){
            row += element + " ";
        }
        return row;
    }
}
