package tesla;

public enum WorldManufacturer{
    US("5YJ", 'F'), CHINA("LRW", 'C');
    String id;
    char c;
    private WorldManufacturer(String id, char c){
        this.id = id;
        this.c = c;
    }
}