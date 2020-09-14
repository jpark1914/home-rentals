import { RentalUser } from './rentalUser.interface';

export interface RentalProperty {
  unitId?: number;
  
  unitAddress: string;
  unitCity: string;
  unitState: string;
  unitZip: number;
  unitCountry: string;
  unitDescription: string;

  rentAmount: number;
  
  unitType: string;
  unitSquareFeet: number;
  unitNumBedrooms: number;
  unitNumBathrooms: number;
  unitWasherDryer: string;
  
  unitElectric: string;
  unitWaterSewage: string;
  unitHeat: string;
  unitAC: string;
  unitTrashRecycle: string;
  unitWifi: string;
  
  ownerFirstName?: string;
  ownerLastName?: string;
  ownerFullAddress?: string;
  ownerEmail?: string;
  ownerPhone?: number; 
  
  status?: string;
  startDate?: string;
  term?: number;
  
  userId?: number;
  rentalUser?: RentalUser;
}
