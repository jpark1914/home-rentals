import { RentalUser } from './rentalUser.interface'
export interface OtherInfo {
    bankruptcy: boolean;
    evictNotice: boolean;
    refusedRentPay: boolean;
    suedForUnlawfulDetainer: boolean;
    referralDesc: string;
    referralId?: number;
    //referral: Referral;
    userId?: number;
    rentalUser?: RentalUser;
}