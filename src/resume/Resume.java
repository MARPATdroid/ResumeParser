package resume;

import java.util.ArrayList;

/**
 * a class to represent a resume imported into the program
 */
public class Resume {

    ArrayList<String> skills;
    ArrayList<String> experience;

    /**
     * constructor for the resume object
     * @param skills skills imported from the resume
     * @param experience imported from the resume
     */
    public Resume(ArrayList<String> skills, ArrayList<String> experience) {
        this.skills = skills;
        this.experience = experience;

    }

    /**
     * simple getter for skills
     * @return skills
     */
    public ArrayList<String> getSkills() {
        return skills;
    }

    /**
     * simple getter for Experience
     * @return
     */
    public ArrayList<String> getExperience() {
        return experience;
    }


}
