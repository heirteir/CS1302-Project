package cs.project.children;

public class Child {
    //Making all fields final, because they won't change after we import the data.
    private final char gender;
    private final int rank;
    private final String name;
    private final int occurrences;

    //Constructor that will take in the data from the file
    protected Child(char gender, int rank, String name, int occurrences) {
        this.gender = gender;
        this.name = name;
        this.rank = rank;
        this.occurrences = occurrences;
    }

    /**
     * Get the name for this child name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Get the rank for this child name
     * 
     * @return Integer
     */
    public int getRank() {
        return rank;
    }

    /**
     * Get occurrences of child name for a specific year
     * 
     * @return
     */
    public int getOccurrences() {
        return occurrences;
    }

    /**
     * returns the type of child EG. (Boy or Girl)
     * 
     * @return Child.Type
     */
    public char getGender() {
        return this.gender;
    }
}
