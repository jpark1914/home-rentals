import { PersonalInfo } from 'src/app/interfaces/personalInfo.interface';

export const DEFAULT_PERSONAL_INFO : PersonalInfo = {
  personId: null,

  firstName: "",
  lastName: "",
  dateOfBirth: null,
  
  driverLicense: null,
  ssn: null,
  
  address: "",
  city: "",
  state: "",
  zip: null,
  phoneNumber: null,
  timeAtPresentAddr: null,

  landlord: "",
  landlordPhone: null,

  contactPersonFirstName: "",
  contactPersonLastName: "",
  contactPersonPhone: null,

  employer: "",
  occupation: "",
  currentSalary: null,
  timeEmployed: null,

  priorAddress: "",
  priorCity: "",
  priorState: "",
  priorZip: null,
  timeAtPriorAddr: null,
    
  userId: null,
  rentalUser: null,
};
