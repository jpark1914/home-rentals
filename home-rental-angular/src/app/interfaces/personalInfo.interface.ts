import { RentalUser } from './rentalUser.interface';

export interface PersonalInfo {
  personId?: number;
  userId?: number;
  dateOfBirth: string;
  firstName: string;
  lastName: string;
  phoneNumber: number;
  driverLicense: number;
  ssn: number;
  address: string;
  city: string;
  state: string;
  zip: number;
  rentalUser?: RentalUser;
}
