import { RentalUser } from './rentalUser.interface';

export interface Reference {
  refId?: number;
  refFirstName: string;
  refLastName: string;
  relationship: string;
  phoneNo: number;
  creditGrantor: string;
  address: string;
  city: string;
  state: string;
  zip: number;
  grantorNo: number;
  userId?: number;
  rentalUser?: RentalUser;
}
