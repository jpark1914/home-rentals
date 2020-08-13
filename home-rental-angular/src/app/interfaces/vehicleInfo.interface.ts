import { RentalUser } from './rentalUser.interface';

export interface VehicleInfo {
  carId: number;
  userId: number;
  make: string;
  model: string;
  year: number;
  color: string;
  tagNumber: number;
  state: string;
  rentalUser?: RentalUser;
}
