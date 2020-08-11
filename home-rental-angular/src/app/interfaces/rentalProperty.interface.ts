import { RentalUser } from './rentalUser.interface';

export interface RentalProperty {
  unitId?: number;
  unitAddress: string;
  unitCity: string;
  unitState: string;
  unitZip: number;
  unitCountry: string;
  unitNumBedrooms: number;
  unitNumBathrooms: number;
  unitSquareFeet: number;
  unitType: string;
  rentAmount: number;
  leaseStart?: string;
  leaseTerm?: number;
  userId?: number;
  rentalUser?: RentalUser;
}
