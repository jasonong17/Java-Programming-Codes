class Circle{
    public Circle(){
    }
    public static Point circleCentre(Point a, Point b){
        Point midpoint = a.getMidpoint(b);
        double distance = a.getDistance(b);
        double angle = a.getAngle(b) + Math.PI/2;
        double distanceCentre = Math.sqrt(1 - ((distance/2)*(distance/2)));

        return midpoint.angleDistance(angle, distanceCentre);
    }
}