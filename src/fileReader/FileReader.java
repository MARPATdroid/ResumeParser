package fileReader;

import jobListing.JobListing;
import resume.Resume;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    /**
     * method to read in a file to begin parsing it properly
     * @param fileName the name of the file to be read in
     * @return a list of all of the lines in the file
     */
    public static List<String> parseFile(String fileName) {


        //define list that will hold book dataset's information
        List<String> book = new ArrayList<String>();


        File file = new File(fileName);        //create file object
        java.io.FileReader fr = null;  // create file reader  set to null to avoid error
        BufferedReader br = null;   //create buffered reader   set to null to avoid error

        try {
            fr = new java.io.FileReader(file);  // activate the file reader with the input file we created above
            br = new BufferedReader(fr); // activate the buffer reader to the file reader we just created

            String line;   // create a string to store the data we are reading in

            while ((line = br.readLine()) != null) {   //read in the next line in the buffer and make sure it's not null
                line = line.trim();   //trim off leading and trailing whitespace
                if (line != null && !line.isEmpty()) {   //if the line is empty in any way ignore it and go on to the next line
                    book.add(line);						//if it has something in it then add it to the list.
                }
            }
        } catch (FileNotFoundException e) {
            //gets and prints file name if not found
            System.out.println("Sorry, " + file.getName() + " was not found.");
        } catch (IOException e) {
            //print the error message and info about which line
            e.printStackTrace();
        } finally {
            //regardless of what happens close file objects
            try {
                fr.close();  //close file reader
                br.close();			//close buffered reader
            } catch (IOException e) {
                e.printStackTrace();			//if there is an error print a stack trace
            }
        }
        return book;			//return the list
    }

    /**
     * Parses out resume to get skills in ArrayList sub 0; and experience in ArrayList sub 1
     * @param resume The resume name to be parsed
     * @return An ArrayList of Arraylists containing the contents of Skills and experiences
     */
    public static Resume readResume(String resume) {

        List<String> parsedResume = parseFile(resume);   //get the parsed resume that we are going to use to break out into the resume's component parts.
        boolean skills = false; //boolean flag to track skills section

        ArrayList<String> skillsList = new ArrayList<>();          //skills array list
        ArrayList<String> expList = new ArrayList<>();              //Experience array List

        for (String s : parsedResume) {
            if (s.trim().toLowerCase().equals("skills")) {
                skills = true;  //I know this does nothing but it's just here incase
                continue;      //continue we don't want to keep this line
            }

            if (s.trim().toLowerCase().equals("----------")) {
                skills = false;  //if we hit the delimiter then kill off the skills flag
                continue;
            }

            if (s.trim().toLowerCase().equals("experience")) {
                continue;      //continue we don't want to keep this line
            }

            if (skills) {
                if (!s.trim().isEmpty()) {
                    skillsList.add(s.trim());  //if skills add skills to the skills array list
                }
            } else {
                if (!s.trim().isEmpty()) {
                    expList.add(s.trim());  //otherwise add to the experience list
                }
            }
        }

        Resume sendMe = new Resume(skillsList, expList);

        return sendMe;   //return the list
    }

    /**
     * PArses a job posting for comparison against a resume, sub 0 is needs, sub 1 is desires, sub 2 is other
     * @param jobPosting is the simple text copy of a job posting
     * @return an array list with the job posting details for comparison.
     */
    public static JobListing jobPosting(String jobPosting) {

        List<String> parsedListing = parseFile(jobPosting);   //create the job listing as a basic object
        boolean need = false;       //flow control for sections of posting
        boolean desired = false;    //flow control for sections of posting
        boolean other = false;      //flow control for sections of posting

        ArrayList<String> needs = new ArrayList<>();                //Array list of needs
        ArrayList<String> desireds = new ArrayList<>();             //Array list of Desires
        ArrayList<String> others = new ArrayList<>();               //Array List of others



        for (String s : parsedListing) {
            if (s.trim().toLowerCase().equals("need")) {   //manage flags for needs
                need = true;
                desired = false;
                other = false;
                continue;
            }else if (s.trim().toLowerCase().equals("desired")) {       //manage flags for desired
                need = false;
                desired = true;
                other = false;
                continue;
            }else if (s.trim().toLowerCase().equals("other")) {     //manage flags for other
                need = false;
                desired = false;
                other = true;
                continue;
            }

            if(s.equals("----------")){
                continue;
            }

            if (need) {
                if (!s.trim().isEmpty()) {
                    needs.add(s.trim());            //put non blank lines into need
                }
            } else if (desired) {
                if (!s.trim().isEmpty()) {
                    desireds.add(s.trim());         //put non blank lines into desires
                }
            } else if (other) {
                if (!s.trim().isEmpty()) {
                    others.add(s.trim());           //put non blank lines into other
                }
            }

        }

        JobListing job = new JobListing(needs, desireds, others);


        return job;          //send the AL back to the main body
    }
 }
