class Point{

    private double x;
    private double y;
    
    public Point(double x, double y){ 
        this.x = x;
        this.y = y;
    }
 
    @Override
    public String toString(){
        return "(" + String.format("%.3f", x) + ", " + String.format("%.3f", y) + ")";
    }
    public Point getMidpoint(Point another){
        double midpointX = (x + another.x)/2;
        double midpointY = (y + another.y)/2;
        return new Point(midpointX, midpointY);
    }
    public double getAngle(Point another){
        double angle = Math.atan2(another.y - y, another.x - x);
        return angle;
    }
    public double getDistance(Point another){
        double distance = Math.sqrt((x - another.x)*(x - another.x) + (y - another.y)*(y - another.y));
        return distance;
    }
    public Point angleDistance(double angle, double distance){
        return new Point(x + (distance*Math.cos(angle)), y + (distance*Math.sin(angle)));
    }
}