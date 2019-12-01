package com.skillenza.parkinglotjava;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkinglotjavaApplicationTests {

 //your test goes here

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init()
    {
        System.setOut( new PrintStream(outContent));
    }

    @Test
    public void getAllParkedVehicles throws Exception
    {
        ParkingLotController plc = new ParkingLotController();
        ParkingLot pl = new ParkingLot();
        pl.setLot(1);
        pl.setDuration(0);
        pl.setVehicle_number(12345678912);

        plc.createParkingLot(pl);

        int num = plc.getAllParkedVehicles().size();
        String str = "Total number of parked vehicle: " + num;
        assertTrue("Total number of parked vehicle: 1".equalsIgnoreCase(str));
    }

    @Test
    public void createParkingLot(@RequestBody ParkingLot pl) throws Exception
    {
        ParkingLotController plc = new ParkingLotController();
        ParkingLot pl = new ParkingLot();
        pl.setLot(1);
        pl.setDuration(0);
        pl.setVehicle_number(12345678912);

        plc.createParkingLot(pl);

        int num = plc.getAllParkedVehicles().size();
        String str = "Total number of parked vehicle: " + num;
        assertTrue("Total number of parked vehicle: 1".equalsIgnoreCase(str));
    }

    @After
    public void cleanup()
    {
        System.setOut(null);
    }
}
