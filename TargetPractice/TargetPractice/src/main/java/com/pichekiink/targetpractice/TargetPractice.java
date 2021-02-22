
package com.pichekiink.targetpractice;

import com.pichekiink.targetpractice.points.PointCoordinate;
import com.pichekiink.targetpractice.cli.InputFiles;
import com.pichekiink.targetpractice.cli.VerifyArguments;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * The {@code TargetPractice} class determines which target was being shot at.
 * <br /><br />
 * It accepts two CLI flags:
 * <ul>
 * <li>-s</li>
 * <li>-t</li>
 * </ul>
 * The <i>-t</i> flag is used to provide the path to the file containing the
 * point coordinates for the targets, and the <i>-s</i> flag is used to provide
 * the path to the file containing the point coordinates for the shots fired at
 * the targets.
 */
public class TargetPractice {
    
    private static final String FIRST_TARGET_KEY = "first-target";
    private static final String SECOND_TARGET_KEY = "second-target";
    
    /**
     * The main method for the class; determines which target was being shot at and displays the results.
     * @param args The CLI arguments passed to the program.
     * @throws IOException
     * @throws URISyntaxException 
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        VerifyArguments verifyArguments = new VerifyArguments();
        InputFiles arguments = verifyArguments.parseParameters(args);
        
        Properties properties = parseTargets(arguments.getTargets());
        List<PointCoordinate> shotsFired = parseShotsFired(arguments.getShotsFired());
        
        PointCoordinate targetOne = new PointCoordinate(properties.getProperty(FIRST_TARGET_KEY));
        PointCoordinate targetTwo = new PointCoordinate(properties.getProperty(SECOND_TARGET_KEY));
        determineTarget(targetOne, targetTwo, shotsFired);
    }
    
    /**
     * Determines which target was being aimed at.
     * @param targetOne The point coordinate for the first target.
     * @param targetTwo The point coordinate for the second target.
     * @param shotsFired A {@code List} containing the point coordinates for the shots fired.
     */
    private static void determineTarget(PointCoordinate targetOne, PointCoordinate targetTwo, List<PointCoordinate> shotsFired) {
        PointCoordinate targetTryingToHit = null;
        int numberOfCloseShots = 0;
        int targetOneTally = 0;
        int targetTwoTally = 0;
        
        for(PointCoordinate shot : shotsFired) {
            if(targetOne.equals(shot)) {
                targetTryingToHit = targetOne;
            } else if(targetTwo.equals(shot)) {
                targetTryingToHit = targetTwo;
            }
            
            if(targetTryingToHit != null) {
                System.out.println("You hit a target!");
                break;
            } else {
                int distanceFromTargetOne = getDistance(targetOne, shot);
                int distanceFromTargetTwo = getDistance(targetTwo, shot);
                
                if(distanceFromTargetOne < distanceFromTargetTwo) {
                    targetOneTally++;
                } else if(distanceFromTargetTwo < distanceFromTargetOne) {
                    targetTwoTally++;
                }
            }
        }
        
        if(targetTryingToHit == null) {
            if (targetOneTally > targetTwoTally) {
                targetTryingToHit = targetOne;
                numberOfCloseShots = targetOneTally;
            } else if (targetTwoTally > targetOneTally) {
                targetTryingToHit = targetTwo;
                numberOfCloseShots = targetTwoTally;
            }
        }
        
        displayResults(targetTryingToHit, numberOfCloseShots);
    }
    
    /**
     * Displays which target was being shot at with the number of shots closest to it.
     * @param point The target being shot at.
     * @param numberOfShots The number of shots fired at the target.
     */
    private static void displayResults(PointCoordinate point, int numberOfShots) {
        if(point != null) {
            System.out.println("The target you were aiming for was at point: " + point.getPointCoordinate());
            
            if(numberOfShots > 0) {
                System.out.println("With " + numberOfShots + " shots near the target.");
            }
        } else {
            System.out.println("Could not determine what you were aiming for.");
        }
    }
    
    /**
     * Returns the distance between two point coordinates.
     * @param pointOne The first point coordinate.
     * @param pointTwo The second point coordinate.
     * @return The distance between two point coordinates.
     */
    private static int getDistance(PointCoordinate pointOne, PointCoordinate pointTwo) {
        double distanceOfX = Math.pow((pointOne.getXCoordinate() - pointTwo.getXCoordinate()), 2);
        double distanceOfY = Math.pow((pointOne.getYCoordinate() - pointTwo.getYCoordinate()), 2);
        int distance = (int) Math.sqrt(distanceOfX + distanceOfY);
        
        return distance;
    }
    
    /**
     * Returns a {@code Properties} object containing the point coordinates for two targets.
     * @return The point coordinates for the two targets.
     * @throws IOException 
     */
    private static Properties parseTargets(String file) throws IOException {
        Properties properties = new Properties();
        BufferedReader reader = Files.newBufferedReader(Paths.get(file));
        properties.load(reader);
        
        return properties;
    }
    
    /**
     * Returns a {@code List} of {@code PointCoordinate} objects of the shots fired.
     * @return A {@code List} of {@code PointCoordinate} objects.
     * @throws IOException 
     */
    private static List<PointCoordinate> parseShotsFired(String file) throws IOException {
        List<PointCoordinate> shotsFired = new LinkedList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(file));
        String line = null;
        
        while((line = reader.readLine()) != null) {
            shotsFired.add(new PointCoordinate(line));
        }
        
        return shotsFired;
    }
}
