import { RentalUser } from './rentalUser.interface';

export interface BankInfo {
  bankId?: number;
  userId?: number;
  bankName: string;
  phoneNumber: number;
  bankAddress: string;
  bankCity: string;
  bankState: string;
  bankZip: number;
  checkingAccNo: number;
  savingsAccNo: number;
  rentalUser?: RentalUser;
}
