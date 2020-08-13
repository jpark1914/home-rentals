import { RentalUser } from './rentalUser.interface';

export interface SpouseInfo {
  spouseId?: number;
  userId?: number;
  spouseFirstName: string;
  spouseLastName: string;
  DOB: string;
  spousePhone: number;
  ssn: number;
  driverLicense: string;
  employer: string;
  occupation: string;
  salary: number;
  timeEmployed: number;
  contactFirstName: string;
  contactLastName: string;
  contactPhone: number;
  rentalUser?: RentalUser;
}
