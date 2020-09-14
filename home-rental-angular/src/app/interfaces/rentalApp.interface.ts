import { RentalUser } from './rentalUser.interface';
import { RentalProperty } from './rentalProperty.interface';

export interface RentalApp {
  formId?: number;
  numberOccAdults: number;
  numberOccChildren: number;
  numberPets: number;
  petsWeight: number;
  appSubmitDate: string;
  status: string;
  
  userId?: number;
  rentalUser?: RentalUser;

  unitId?: number;
  rentalProp?: RentalProperty; 
}
