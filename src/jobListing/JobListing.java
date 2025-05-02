package jobListing;

import java.util.ArrayList;

/**
 * an object to represent a job listing
 */
public class JobListing {

    ArrayList<String> needs;            //lIST OF NEEDS
    ArrayList<String> desires;          //lIST OF DESIREs
    ArrayList<String> others;           //ist of others
    ArrayList<String> wordsInListing = new ArrayList<String>();   //all words in listing

    /**
     * constructor for job Listings
     * @param needs of the job listing
     * @param desires of the job listing
     * @param others  others of the job listing
     */
    public JobListing(ArrayList<String> needs, ArrayList<String> desires, ArrayList<String> others) {
        this.needs = needs;
        this.desires = desires;
        this.others = others;

        for (String s : needs) {
            String[] splitS = s.trim().toLowerCase().split("[-,;_+&\\s]+");  //split each line into words all lowercase with no extra whitespace
            for (String s2 : splitS) {
                if (!this.wordsInListing.contains(s2.trim().toLowerCase())) {
                    this.wordsInListing.add(s2.trim().toLowerCase());
                }
            }
        }

        for (String s : desires) {
            String[] splitS = s.trim().toLowerCase().split("[-,;_+&\\s]+");  //split each line into words all lowercase with no extra whitespace
            for (String s2 : splitS) {
                if (!this.wordsInListing.contains(s2.trim().toLowerCase())) {
                    this.wordsInListing.add(s2.trim().toLowerCase());
                }
            }
        }

        for (String s : others) {
            String[] splitS = s.trim().toLowerCase().split("[-,;_+&\\s]+");  //split each line into words all lowercase with no extra whitespace
            for (String s2 : splitS) {
                if (!this.wordsInListing.contains(s2.trim().toLowerCase())) {
                    this.wordsInListing.add(s2.trim().toLowerCase());
                }
            }
        }

        System.out.println("Length of words in listing: " + this.wordsInListing.size() + "");
    }

    /**
     * simple getter for needs
     * @return needs
     */
    public ArrayList<String> getNeeds() {
        return needs;
    }

    /**
     * simple getter for desires
     * @return desires
     */
    public ArrayList<String> getDesires() {
        return desires;
    }

    /**
     * simle getter for others
     * @return others
     */
    public ArrayList<String> getOthers() {
        return others;
    }

    public ArrayList<String> getWordsInListing() {
        return wordsInListing;
    }


}
