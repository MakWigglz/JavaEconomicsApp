import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.io.IOException;



public class DataVisualizer {
    public static void createTimeSeriesChart(String title, String xLabel, String yLabel, List<Date> dates, List<Double> values) throws IOException {
        TimeSeries series = new TimeSeries(title);
        for (int i = 0; i < dates.size(); i++) {
            series.add(new Day(dates.get(i)), values.get(i));
        }
        
        TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            title, xLabel, yLabel, dataset, true, true, false
        );
        
        ChartUtils.saveChartAsPNG(new File("charts/" + title + ".png"), chart, 800, 400);
    }
}

