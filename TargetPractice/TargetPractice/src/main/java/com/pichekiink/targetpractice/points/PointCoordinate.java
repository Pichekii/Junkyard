
package com.pichekiink.targetpractice.points;

/**
 * The {@code PointCoordinate} class contains the X and Y positions for a point.
 */
public class PointCoordinate {
    
    private final int xCooridnate;
    private final int yCoordinate;
    
    /**
     * Instantiates a {@code PointCoordinate} object provided a point coordinate
     * in the format of: <b>x/y</b>
     * @param coordinate The point coordinate.
     */
    public PointCoordinate(String coordinate) {
        String[] temp = coordinate.split("/");
        this.xCooridnate = Integer.valueOf(temp[0]);
        this.yCoordinate = Integer.valueOf(temp[1]);
    }
    
    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;
        
        if(object instanceof PointCoordinate) {
            PointCoordinate target = (PointCoordinate) object;
            
            if((this.xCooridnate == target.xCooridnate) && (this.yCoordinate == target.yCoordinate)) {
                isEqual = true;
            }
        }
        
        return isEqual;
    }
    
    /**
     * Returns the point coordinate.
     * @return The point coordinate.
     */
    public String getPointCoordinate() {
        return this.xCooridnate + "/" + this.yCoordinate;
    }
    
    /**
     * Returns the X position of the point.
     * @return The X position of the point.
     */
    public int getXCoordinate() {
        return this.xCooridnate;
    }
    
    /**
     * Returns the Y position of the point.
     * @return The Y position of the point.
     */
    public int getYCoordinate() {
        return this.yCoordinate;
    }
}
