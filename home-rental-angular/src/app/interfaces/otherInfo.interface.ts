import { RentalUser } from './rentalUser.interface'
import { ReferralInfo } from './referralInfo.interface'
    
export interface OtherInfo {
    bankruptcy: boolean;
    evictNotice: boolean;
    refusedRentPay: boolean;
    suedForUnlawfulDetainer: boolean;
    userId?: number;
    rentalUser?: RentalUser;
}

