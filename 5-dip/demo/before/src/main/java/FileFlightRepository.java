import java.io.*;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Low level implementation detail
public class FileFlightRepository implements FlightRepository {
    private String path;

    public FileFlightRepository(String path) {
        this.path = path;
    }

    public List<Flight> findAll() {
        var result = new ArrayList<Flight>();

        try
        {
            var file=new File(path.toString());     //creates a new file instance
            var fr=new FileReader(file);            //reads the file
            var br=new BufferedReader(fr);          //creates a buffering character input stream

            String line;
            while((line=br.readLine())!=null)
            {
                var flight = parseLine(line);
                result.add(flight);
            }

            fr.close();    //closes the stream and release the resources
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Flight parseLine(String line){
        var fields = line.split(",");

        var timeFields = fields[2].split(":");
        var hour = Integer.parseInt(timeFields[0]);
        var minutes = Integer.parseInt(timeFields[1]);

        return new Flight(fields[0], fields[1], LocalTime.of(hour, minutes), fields[3]);
    }
}
