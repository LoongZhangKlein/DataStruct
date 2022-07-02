package arithmetic.search.hashsearch;

public class Emp {
    public String id;
    public String name;
    public Emp next;

    public Emp(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id+"=>"+name+" ";
    }
}
