import fileReader.FileReader;
import jobListing.JobListing;
import resume.Resume;

import java.text.DecimalFormat;

public class main {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private int skillNeeds = 0;
    private int skillDesires = 0;
    private int skillOthers = 0;
    private int expNeeds = 0;
    private int expDesires = 0;
    private int expOthers = 0;



    public static void main(String[] args) {

        main m = new main();
        Resume resume = FileReader.readResume("Resume2.txt");
        JobListing jobListing = FileReader.jobPosting("JobPosting.txt");


        m.compareSkills(resume, jobListing);
        m.compareExperience(resume, jobListing);
        m.printResults(resume);
        m.printWordsMissing(resume, jobListing);





    }

    /**
     * method to compare and start setting the data for the skills to check alignment
     * @param resume that is being compared
     * @param jobListing that is being compared against
     */
    private void compareSkills(Resume resume, JobListing jobListing) {
        String regex = "[-_\\s]+";
        for (String s : resume.getSkills()) {   //get each line from resume Skills section
            for(String s2 : jobListing.getNeeds()){  //get each line from the job listing
                String[] splitS = s.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                String[] splitS2 = s2.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                double count = 0.0;  //initialize a count for matches
                double score = 0.0;  //intitialize a score to add to the object
                for (String s3 : splitS) {              //itterate over the words in the resume skills
                    for (String s4 : splitS2) {         //itterate over the words in the job listing
                        if (s3.equals(s4)) {
                            count += 1.0;

                        }
                    }
                }
                score = count / splitS2.length;
                if ((score * 100) > 70 ){
                    skillNeeds += 1;
                    resume.setMatchedLine(s, s2);
                }
                resume.setSkillScores(s, score, "Needs" );
            }
            for(String s2 : jobListing.getDesires()){  //get each line from the job listing
                String[] splitS = s.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                String[] splitS2 = s2.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                double count = 0.0;  //initialize a count for matches
                double score = 0.0;  //intitialize a score to add to the object
                for (String s3 : splitS) {              //itterate over the words in the resume skills
                    for (String s4 : splitS2) {         //itterate over the words in the job listing
                        if (s3.equals(s4)) {
                            count += 1.0;

                        }
                    }
                }
                score = count / splitS2.length;
                if ((score * 100) > 70 ){
                    skillDesires += 1;
                    resume.setMatchedLine(s, s2);
                }
                resume.setSkillScores(s, score, "Desires" );
            }
            for(String s2 : jobListing.getOthers()){  //get each line from the job listing
                String[] splitS = s.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                String[] splitS2 = s2.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                double count = 0.0;  //initialize a count for matches
                double score = 0.0;  //intitialize a score to add to the object
                for (String s3 : splitS) {              //itterate over the words in the resume skills
                    for (String s4 : splitS2) {         //itterate over the words in the job listing
                        if (s3.equals(s4)) {
                            count += 1.0;

                        }
                    }
                }
                score = count / splitS2.length;
                if ((score * 100) > 70 ){
                    skillOthers += 1;
                    resume.setMatchedLine(s, s2);
                }
                resume.setSkillScores(s, score, "Others" );
            }

        }

    }

    /***
     * Gets and compares experience to the job posting per word
     * @param resume that is being examined
     * @param jobListing that is being compared to
     */
    private void compareExperience(Resume resume, JobListing jobListing) {
        String regex = "[-_\\s]+";
        for (String s : resume.getExperience()) {   //get each line from resume Skills section
            for(String s2 : jobListing.getNeeds()){  //get each line from the job listing
                String[] splitS = s.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                String[] splitS2 = s2.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                double count = 0.0;  //initialize a count for matches
                double score = 0.0;  //intitialize a score to add to the object
                for (String s3 : splitS) {              //itterate over the words in the resume skills
                    for (String s4 : splitS2) {         //itterate over the words in the job listing
                        if (s3.equals(s4)) {
                            count += 1.0;

                        }
                    }
                }
                score = count / splitS2.length;
                if ((score * 100) > 70 ){
                    expNeeds += 1;
                    resume.setMatchedLine(s, s2);
                }
                resume.setExpScores(s, score, "Needs" );
            }
            for(String s2 : jobListing.getDesires()){  //get each line from the job listing
                String[] splitS = s.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                String[] splitS2 = s2.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                double count = 0.0;  //initialize a count for matches
                double score = 0.0;  //intitialize a score to add to the object
                for (String s3 : splitS) {              //itterate over the words in the resume skills
                    for (String s4 : splitS2) {         //itterate over the words in the job listing
                        if (s3.equals(s4)) {
                            count += 1.0;

                        }
                    }
                }
                score = count / splitS2.length;
                if ((score * 100.00) > 70 ){
                    expDesires += 1;
                    resume.setMatchedLine(s, s2);
                }
                resume.setExpScores(s, score, "Desires" );
            }
            for(String s2 : jobListing.getOthers()){  //get each line from the job listing
                String[] splitS = s.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                String[] splitS2 = s2.trim().toLowerCase().split(regex);  //split each line into words all lowercase with no extra whitespace
                double count = 0.0;  //initialize a count for matches
                double score = 0.0;  //intitialize a score to add to the object
                for (String s3 : splitS) {              //itterate over the words in the resume skills
                    for (String s4 : splitS2) {         //itterate over the words in the job listing
                        if (s3.equals(s4)) {
                            count += 1.0;

                        }
                    }
                }
                score = count / splitS2.length;
                if ((score * 100) > 70 ){
                    expOthers += 1;
                    resume.setMatchedLine(s, s2);
                }
                resume.setExpScores(s, score, "Others" );
            }

        }

    }

    /**
     * simple display method
     * @param resume to be displayed
     */
    private void printResults(Resume resume) {
        DecimalFormat f = new DecimalFormat("#.##");

        System.out.println("---------------------------------------------");
        System.out.println("              Skills Section                 ");
        System.out.println("---------------------------------------------");
        System.out.println("Skill Needs: " + skillNeeds);
        System.out.println("skill Desires: " + skillDesires);
        System.out.println("skill Others: " + skillOthers);
        for (String s : resume.getSkills()) {
            if(resume.getSkillScores().get(s) * 100 < 40.0) {
                System.out.print(ANSI_RED);
            } else if(resume.getSkillScores().get(s) * 100 < 60.0) {
                System.out.print(ANSI_YELLOW);
            } else if (resume.getSkillScores().get(s) * 100 < 80.0) {
                System.out.print(ANSI_BLUE);
            } else {
                System.out.print(ANSI_GREEN);
            }
            System.out.println(s + " || Match " + f.format(resume.getSkillScores().get(s) * 100) + "% of type " + resume.getSkillType().get(s));
            System.out.print(ANSI_RESET);
            if (resume.getSkillScores().get(s) * 100 > 70.0) {
                for (String s2 : resume.getMatchedLine().get(s)) {
                    System.out.println("          " + s2);
                }
            }
        }

        System.out.println("---------------------------------------------");
        System.out.println("              Experience Section             ");
        System.out.println("---------------------------------------------");
        System.out.println("Experience Needs: " + expNeeds);
        System.out.println("Experience Desires: " + expDesires);
        System.out.println("Experience Others: " + expOthers);

        for (String s : resume.getExperience()) {

            if(resume.getExpScores().get(s) * 100 < 40.0) {
                System.out.print(ANSI_RED);
            } else if(resume.getExpScores().get(s) * 100 < 60.0) {
                System.out.print(ANSI_YELLOW);
            } else if (resume.getExpScores().get(s) * 100 < 80.0) {
                System.out.print(ANSI_BLUE);
            } else {
                System.out.print(ANSI_GREEN);
            }
            System.out.println(s + " || Match " + f.format(resume.getExpScores().get(s) * 100) + "% of type " + resume.getExpType().get(s));
            System.out.print(ANSI_RESET);
            if (resume.getExpScores().get(s) * 100 > 70.0) {
                for (String s2 : resume.getMatchedLine().get(s)) {
                    System.out.println("          " + s2);
                }
            }
        }
    }

    private void printWordsMissing(Resume resume, JobListing jobListing) {
        double counter = 0;
        int newline = 0;
        System.out.println("---------------------------------------------");
        System.out.println("              Words Missing              ");
        System.out.println("---------------------------------------------");
        for (String s : jobListing.getWordsInListing()) {
            boolean found = false;
            if (resume.getWordsInResume().contains(s) ) {
                found = true;
                counter += 1;
            }

            if (!found) {
                System.out.print(s.toLowerCase() + " | ");
                newline += 1;
                if (newline == 7) {
                    System.out.println();
                    newline = 0;
                }
            }
        }
        System.out.println("\n---------------------------------------------");
        double percent = counter / jobListing.getWordsInListing().size();
        System.out.println(percent * 100 + "% of words matched");
    }



}
