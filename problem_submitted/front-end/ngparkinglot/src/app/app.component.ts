import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  // your code goes here

  createForm()
  {
   vehicleForm = new FormGroup(
   {
      vehicleLot : new FormControl(''),
      vehicleNumber : new FormControl(''),
      vehicleDuration : new FormControl(''),
      vehicleAmount : new FormControl(''),
   })

   return vehicleForm;
  }

   onSubmit()
   {
      vehicleForm = createForm();

      vehicleForm.value;
   }

  getAllParking:
  {

  }

  calculateAmount(event)
  {

  }

  parkNewvehicle(vehicle)
  {

  }

}
