import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Frequency {
    private int maxFrequency = 0;
    private long[][] grid;
    private Location[] locations;
    private Map<Long, Integer> gridMap = new HashMap<Long, Integer>();



    public Frequency(long[][] grid, Location[] locations) {
        this.grid = grid;
        this.locations = locations;
        convertGridIntoMap();
    }

    private Map convertGridIntoMap() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                long key = grid[i][j];
                if(gridMap.containsKey(key))
                {
                    int freq = gridMap.get(key);
                    freq++;
                    gridMap.put(key, freq);
                }
                else
                {
                    gridMap.put(key, 1);
                }
            }
        }
        return gridMap;
    }

    public int maxFrequencyOfHashMap() {
        return Collections.max(gridMap.values());
    }




}
