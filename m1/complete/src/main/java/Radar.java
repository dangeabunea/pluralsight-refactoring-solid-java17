import java.util.List;

public class Radar {
    private int originLat;
    private int originLon;

    public Radar(int originLat, int originLon){
        this.originLat = originLat;
        this.originLon = originLon;
    }

    public String getAircraftInRange(int range, List<Aircraft> allAircraft, boolean latFirst){
        var aircraftInRange = allAircraft
                .stream()
                .filter(a -> calculateDistanceToPoint(a.lat(), a.lon()) <= range)
                .toList();

        var sb = new StringBuilder();
        if(latFirst) {
            aircraftInRange.forEach(a -> sb
                    .append("[")
                    .append(a.lat())
                    .append(" ")
                    .append(a.lon())
                    .append("] "));
        } else{
            aircraftInRange.forEach(a -> sb
                    .append("[")
                    .append(a.lon())
                    .append(" ")
                    .append(a.lat())
                    .append("] "));
        }

        return sb.toString();
    }

    private int calculateDistanceToPoint(int dstLat, int dstLon){
        return (int) Math.sqrt(
                (originLat-dstLat)*(originLat-dstLat) +
                        (originLon-dstLon)*(originLon-dstLon)
        );
    }
}
