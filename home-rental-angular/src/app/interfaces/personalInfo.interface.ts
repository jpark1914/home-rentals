import { RentalUser } from './rentalUser.interface';

export interface PersonalInfo {
  personId?: number;
  
  firstName: string;
  lastName: string;
  phoneNumber: number;
  dateOfBirth: string;
  
  driverLicense: number;
  ssn: number;
  
  address: string;
  city: string;
  state: string;
  zip: number;
  timeAtPresentAddr: string;
  
  landlord: string;
  landlordPhone: number;

  contactPersonFirstName: string;
  contactPersonLastName: string;
  contactPersonPhone: number;

  employer: string;
  occupation: string;
  currentSalary: number;
  timeEmployed: number;

  priorAddress: string;
  priorCity: string;
  priorState: string;
  priorZip: number;
  timeAtPriorAddr: number;

  userId?: number;
  rentalUser?: RentalUser;
}
