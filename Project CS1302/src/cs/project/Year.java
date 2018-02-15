package cs.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cs.project.children.Boy;
import cs.project.children.Child;
import cs.project.children.Girl;

public class Year {
    private static final String BASE_LOCATION = "C:\\Users\\Justin\\Desktop\\";
    private List<Child> children;
    private int year;

    public Year(int year) {
        this.children = new ArrayList<>();
        this.year = year;

        try {
            //iterate through the baby name file, and store it in the child array.
            File file = new File(BASE_LOCATION + "Babynamesranking" + year + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                //Use a regular expression to remove everything but tabs, and alphanumeric characters
                line = line.replaceAll("[^0-9a-zA-Z\t]", "");
                String[] values = line.split("\t");

                //creates a Boy and Girl object and stores it in the Children ArrayList
                int rank = Integer.parseInt(values[0]);
                this.children.add(new Boy(rank, values[1], Integer.parseInt(values[2])));
                this.children.add(new Girl(rank, values[3], Integer.parseInt(values[4])));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("baby names for the year are not found.");
            this.year = 0;
        }
    }

    /**
     * 
     * @param type Uses the Child.Type enumerator, which states whether or not the child is a boy or girl.
     * @param name The name to find the rank of
     * @return Integer | Rank of the specified name
     */
    public int getRank(char gender, String name) {
        gender = Character.toUpperCase(gender);
        for (Child child : this.children) {
            if (child.getGender() == gender && child.getName().toLowerCase().equals(name.toLowerCase())) {
                return child.getRank();
            }
        }
        return 0;
    }

    public int getYear() {
        return this.year;
    }
}
