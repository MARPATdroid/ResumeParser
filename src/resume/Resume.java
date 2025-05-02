package resume;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * a class to represent a resume imported into the program
 */
public class Resume {

    ArrayList<String> skills;
    ArrayList<String> experience;

    // both sets of these data types occupy the same setters
    public HashMap<String, Double> skillScores = new HashMap<String, Double>();  //store skill scores as a KVP for the score
    public HashMap<String, String> skillScoresType = new HashMap<String, String>();        //Store the skill score type as a KvP

    public HashMap<String, Double> expScores = new HashMap<String, Double>();              //Store expeience score as a KvP
    public HashMap<String, String> expScoresType = new HashMap<String, String>();          //Store the Type of score as a KvP

    public HashMap<String, ArrayList<String>> matchedLine = new HashMap<String, ArrayList<String>>();

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

    /**
     * simple getter for the skill scores
     * @return
     */
    public HashMap<String, Double> getSkillScores() {
        return skillScores;
    }

    public HashMap<String, String> getSkillType() {
        return skillScoresType;
    }

    public HashMap<String, Double> getExpScores() {
        return expScores;
    }
    public HashMap<String, String> getExpType() {
        return expScoresType;
    }

    public HashMap<String, ArrayList<String>> getMatchedLine() {
        return matchedLine;
    }

    public void setMatchedLine(String key, String value) {
        ArrayList<String> temp = new ArrayList<>();
        if (!this.matchedLine.containsKey(key)) {
            temp.add(value);
            this.matchedLine.put(key, temp);
        } else {
            temp = this.matchedLine.get(key);
            temp.add(value);
            this.matchedLine.put(key, temp);
        }

    }

    /**
     * simple setter for the skill score map
     * @param skill being stored as key
     * @param score being stored as value
     */
    public void setSkillScores(String skill, double score, String type) {
        if (!this.skillScores.containsKey(skill)) {
            this.skillScores.put(skill, score);
            this.skillScoresType.put(skill, type);
        } else {
            if(this.skillScores.get(skill) < score) {
                this.skillScores.put(skill, score);
                this.skillScoresType.put(skill, type);
            }
        }

    }

    /**
     * simple setter for the expereience scores
     * @param exp being stored as key
     * @param score being stored as value
     */
    public void setExpScores(String exp, double score, String type) {
        if (!this.expScores.containsKey(exp)) {   //if exp doesn't exist add it

            this.expScores.put(exp, score);
            this.expScoresType.put(exp, type);
        } else {
            if(this.expScores.get(exp) < score) {   //if exp score stored is less than new score replace data
                this.expScores.put(exp, score);
                this.expScoresType.put(exp, type);
            }
        }
    }




}
