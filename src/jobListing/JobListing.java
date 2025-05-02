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
            if (!this.wordsInListing.contains(s)) {
                this.wordsInListing.add(s);
            }
        }

        for (String s : desires) {
            if (!this.wordsInListing.contains(s)) {
                this.wordsInListing.add(s);
            }
        }

        for (String s : others) {
            if (!this.wordsInListing.contains(s)) {
                this.wordsInListing.add(s);
            }
        }
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
