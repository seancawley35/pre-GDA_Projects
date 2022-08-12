/*

DNA
DNA, the carrier of genetic information in living things, has been used in criminal justice for decades. 
But how, exactly, does DNA profiling work? Given a sequence of DNA, how can forensic investigators identify to whom it belongs?

Well, DNA is really just a sequence of molecules called nucleotides, arranged into a particular shape (a double helix).
Each nucleotide of DNA contains one of four different bases: adenine (A), cytosine (C), guanine (G), or thymine (T).
Every human cell has billions of these nucleotides arranged in sequence. Some portions of this sequence (i.e. genome)
are the same, or at least very similar, across almost all humans, but other portions of the sequence have a higher
genetic diversity and thus vary more across the population.

One place where DNA tends to have high genetic diversity is in Short Tandem Repeats (STRs). 
An STR is a short sequence of DNA bases that tends to be repeated back-to-back numerous times 
at specific locations in DNA. The number of times any particular STR repeats varies a lot among different people. 
In the DNA samples below, for example, Alice has the STR AGAT repeated four times in her DNA, while Bob has the same STR repeated five times.

Alice: CTAGATAGATAGATAGATGACTA.

Bob: CTAGATAGATAGATAGATAGATT.

Using multiple STRs, rather than just one, can improve the accuracy of DNA profiling. If the probability that two people have the same number of repeats for a single STR is 5%, and the analyst looks at 10 different STRs, then the probability that two DNA samples match purely by chance is about 1 in 1 quadrillion (assuming all STRs are independent of each other). So if two DNA samples match in the number of repeats for each of the STRs, the analyst can be pretty confident they came from the same person. CODIS, The FBI's DNA database, uses 20 different STRs as part of its DNA profiling process.

Consider the following database, containing the information about 3 STRs for two people:
3 AGAT AATG TATC
2
Alice 28 42 14
Bob 17 22 19
This database encodes that supported STRs are AGAT, AATG and TATC; and that Alice has the sequence AGAT 
repeated 28 times consecutively somewhere in her DNA, the sequence AATG repeated 42 times, and TATC repeated 
14 times. Bob, meanwhile, has those same three STRs repeated 17 times, 22 times, and 19 times, respectively.
So given a sequence of DNA, how might you identify to whom it belongs? Well, imagine that you looked through 
the DNA sequence for the longest consecutive sequence of repeated AGATs and found that the longest sequence
was 17 repeats long. If you then found that the longest sequence of AATGs is 22 repeats long, and the longest 
sequence of TATC is 19 repeats long, that would provide pretty good evidence that the DNA was Bob's. Of course, 
it's also possible that once you take the counts for each of the STRs, it doesn't match anyone in your DNA database,
in which case you have no match.

Your task is to write a program that will take a DNA database with STR counts for a list of individuals,
a list of DNAs, and then output to whom the DNAs (most likely) belong.

Source: http://nifty.stanford.edu/2020/dna/.

Input
The first line of the input contains S: the number of STRs, followed by the STRs themselves. Each STR is 
a string containing capital latin letters A, C, G, or T.

The next line contains N: the number of people in the database.

The next N lines contain the information about every person: their name, and the number of times 
the corresponding STR is replicated in their DNA.

The next line contains M: the number of samples to identify.

The following M lines are test cases: strings containing capital latin letters A, C, G, or T.

Output
For each sample, output one line containing Case #x: y, where x is the sample number (starting from 1),
and y is either the name of the person, to whom the sample belongs, or string No match if such person does not exist in the database.

*/


import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

class dna {

    //string matching function to scan DNA sequence for matching STR's
    public static int findOccurances(String dnaSequence, String strPattern){
        int strLength = 0;
        int sequenceCtr = 0;
        int patternCtr = 0;
        int count = 0;
        while (sequenceCtr < dnaSequence.length()) {
            int startCtr = sequenceCtr;
            while (patternCtr < strPattern.length() && sequenceCtr < dnaSequence.length()) {
                if (dnaSequence.charAt(sequenceCtr) != strPattern.charAt(patternCtr)) {
                    if (count > 0) {
                        strLength = Math.max(strLength, count);
                        count = 0;
                        sequenceCtr++;
                    } else {
                        sequenceCtr = startCtr+1;
                    }
                    patternCtr = 0;
                    break;
                } else {
                    if (patternCtr == strPattern.length()-1) {
                        count++;
                        patternCtr = 0;
                    } else {
                        patternCtr++;
                    }
                }
                sequenceCtr++;
            }
        }
        if (count > 0) {
            strLength = Math.max(strLength, count);
        }
        return strLength;
    }

    public static ArrayList<String> getStrs(Scanner sc) {
        int numStr = sc.nextInt();
        ArrayList<String> Strs = new ArrayList<String>();
        int count = 0;
        while (count < numStr){
            String name = sc.next();
            Strs.add(name);
            count++;
        }
        return Strs;
    }

    public static HashMap<String, HashMap<String, Integer>> getPeopleStrs(Scanner sc, ArrayList<String> Strs) {
        int numUsers = sc.nextInt();
        HashMap<String, HashMap<String, Integer>> peopleMap = new HashMap<String, HashMap<String, Integer>>();
        int userCount = 0;
        while (userCount < numUsers){
            String userName = sc.next();
            HashMap<String,Integer> userStrs = new HashMap<String, Integer>();
            for (int i = 0; i < Strs.size(); i++){ 
                int strNum = sc.nextInt();
                userStrs.put(Strs.get(i),strNum);
            }
            peopleMap.put(userName, userStrs);
            userCount++;
        }
        return peopleMap;
    }

    public static HashMap<String, HashMap<String, Integer>> getDnaSeqStrs(Scanner sc, ArrayList<String> Strs) {
        int numDnaSequences = sc.nextInt();
        HashMap<String, HashMap<String, Integer>> dnaSeqResults = new  HashMap<String, HashMap<String, Integer>>();
        int seqCounter = 0;
        while (seqCounter < numDnaSequences){
            String dnaSeq = sc.next();
            HashMap<String, Integer> strOccurances = new HashMap<String, Integer>();
            for(int i = 0; i < Strs.size(); i++){
                strOccurances.put(Strs.get(i), findOccurances(dnaSeq, Strs.get(i)));
            }
            String caseName = "Case #" + (seqCounter+1);
            dnaSeqResults.put(caseName, strOccurances);
            seqCounter++;
        }
        return dnaSeqResults;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Strs = getStrs(sc);
        HashMap<String, HashMap<String, Integer>> peopleMap = getPeopleStrs(sc, Strs);
        HashMap<String, HashMap<String, Integer>> dnaSeqResults = getDnaSeqStrs(sc, Strs);

        ArrayList<String> results = new ArrayList<String>();
        int caseNum = 1;
        while (caseNum <= dnaSeqResults.size()) {
            String caseName = "Case #" + caseNum;
            HashMap<String, Integer> caseValue = dnaSeqResults.get(caseName);

            boolean matchFound = false;
            for (Map.Entry<String,HashMap<String, Integer>> userEntry : peopleMap.entrySet()){
                // iterate over Strs arraylist and check if DNA sequences strs match the user's strs
                boolean allStrsMatch = true;
                for (int i = 0; i < Strs.size(); i++){
                    String strName = Strs.get(i);
                    // user's str length
                    int userStrLength = userEntry.getValue().get(strName);
                    if (caseValue.get(strName) != userStrLength) {
                        allStrsMatch = false;
                        break;
                    }
                }
                if (allStrsMatch) {
                    matchFound = true;
                    results.add(caseName + ": " + userEntry.getKey());
                    break;
                }

            }
            if (!matchFound) {
                results.add(caseName + ": No match");
            }
            caseNum++;
        }
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
