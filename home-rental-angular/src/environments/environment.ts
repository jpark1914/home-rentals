// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

//const backendHost = 'http://ec2-3-134-245-222.us-east-2.compute.amazonaws.com:9000';
const backendHost = 'http://localhost:9000';

export const environment = {
  production: false,
  backendHost: backendHost,
  user: {
    getUser: `${ backendHost }/user/get`,
    register: `${ backendHost }/user/save`,
  },
  personal: {
    get: `${ backendHost }/personal/get`,
    save: `${ backendHost }/personal/save`,
    getInfo: `${ backendHost }/personal/getInfo/`
  },
  spouse: {
    get: `${ backendHost }/spouse/get`,
    save: `${ backendHost }/spouse/save`,
  },
  vehicle: {
    save: `${ backendHost }/vehicle/save`,
    get: `${ backendHost }/vehicle/get`
  },
  bank: {
    save: `${ backendHost }/bank/save`,
    get: `${ backendHost }/bank/get`
  },
  reference: {
    save: `${ backendHost }/references/save`,
    get: `${ backendHost }/references/get`
  },
  other: {
    save: `${ backendHost }/other/save`,
    get: `${ backendHost }/other/get`
  },
  rentalprops: {
    save: `${ backendHost }/rentalprops/save`,
    getProp: `${ backendHost }/rentalprops/get/`,
    getPage: `${ backendHost }/rentalprops/getPage/`,
    getPageAdmin: `${ backendHost }/rentalprops/getPageAdmin/`
  }
  
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
