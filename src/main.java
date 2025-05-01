import fileReader.FileReader;
import jobListing.JobListing;
import resume.Resume;

import java.util.ArrayList;

public class main {
    main m = new main();


    public static void main(String[] args) {

        Resume resume = FileReader.readResume("Resume.txt");
        JobListing jobListing = FileReader.jobPosting("JobPosting.txt");


    }



}
