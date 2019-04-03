class Point{

    private double x;
    private double y;
    
    public Point (double x, double y){ 
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public Point getMidpoint(Point another){
        double midpointX = (this.x + another.getX())/2;
        double midpointY = (this.y + another.getY())/2;
        return new Point(midpointX, midpointY);
    }
    public double getAngle(Point another){
        double angle = Math.atan2(this.y - another.getY(), this.x - another.getX());
        return angle;
    }
    public String toString(){
        return "(" + String.format("%.3f", this.x) + ", " + String.format("%.3f", this.y) + ")";
    }
}