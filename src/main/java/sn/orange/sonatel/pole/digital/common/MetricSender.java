package sn.orange.sonatel.pole.digital.common;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class MetricSender {
	
	private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://10.137.18.24:8086", "supervision", "smc_sco@2018#");
    private static final String DATABASE = "supervision";

    static{
        INFLXUDB.setDatabase(DATABASE);
    }

    public static void send(final Point point){
        INFLXUDB.write(point);
    }

}
