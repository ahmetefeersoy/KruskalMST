public class Edge implements Comparable<Edge>
{
   private final City x, y;

   
   private final double distance;

   public double getDistance() {
      return distance;
   }

   public Edge(City x, City y)   {
      this.x = x;
      this.y = y;
      this.distance =calculateDistance(x, y);
   }

   public City either()  {  return x;  }

   public City other(City vertex) {
      if (vertex == x) return y;
      else return x; 
   }

   public int compareTo(Edge that) {
      if      (this.distance < that.distance) return -1;
      else if (this.distance > that.distance) return +1;
      else                                    return  0;
   }

   public double calculateDistance(City node1 , City node2){
    double distanceY;
    double distanceX;
    double distanceTotal;
    distanceY=node1.getY()-node2.getY();
    distanceY=Math.pow(distanceY,2);
    distanceX=node1.getX()-node2.getX();
    distanceX=Math.pow(distanceX,2);
    distanceTotal = Math.sqrt(distanceX+distanceY);
    return roundToDecimalPlaces(distanceTotal, 1);
   }
   private static double roundToDecimalPlaces(double value, int decimalPlaces) {
      double scale = Math.pow(10, decimalPlaces);
      return Math.round(value * scale) / scale;
  }
}