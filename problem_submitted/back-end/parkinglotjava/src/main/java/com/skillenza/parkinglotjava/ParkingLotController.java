package com.skillenza.parkinglotjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ParkingLotController {

    // your code goes here

    @Autowired
    private ParkingLotRepository plRepo;

    @GetMapping(value="api/parkings")
    public List<ParkingLot> getAllParkedVehicles()
    {
        return plRepo.findAll();
    }

    @PostMapping(value="api/parkings")
    public void createParkingLot()
    {
        List<ParkingLot> pls = plRepo.findAll();

        if(pls.size() >0)
        {
            List<ParkingLot> pls2 = new ArrayList<>();

            for (int i = 0; i < pls.size(); i++)
            {
                ParkingLot pl = (ParkingLot) pls.get(i);

                pl.setUpdated_at(Instant.now());

                pl.setParking_duration(Duration.between(pl.getCreated_at(), pl.getUpdated_at()));

                int amount = 20;
                int diffInMinutes = Duration.between(pl.getCreated_at(), pl.getUpdated_at()) / (1000 * 60);

                if (diffInMinutes <= 60) {
                    amount = 20;
                } else {
                    amount = 20 + (diffInMinutes - 60) * (1 / 3);
                }
                pl.setParking_amount(amount);

                pls2.add(pl);
            }
            plRepo.saveAll(pls2);
        }
        else
        {
            plRepo.save(parkingLot);
        }
    }

    @PostMapping(value="api/parkings")
    public void createParkingLot(@RequestBody PartkingLot parkingLot)
    {
        plRepo.save(parkingLot);
    }

}

