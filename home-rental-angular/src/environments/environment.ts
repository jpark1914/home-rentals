// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  user: {
    getUser: 'http://localhost:9000/user/get',
    register: 'http://localhost:9000/user/save',
  },
  personal: {
    get: 'http://localhost:9000/personal/get',
    save: 'http://localhost:9000/personal/save',
  },
  spouse: {
    get: 'http://localhost:9000/spouse/get',
    save: 'http://localhost:9000/spouse/save',
  },
  vehicle: {
    save: 'http://localhost:9000/vehicle/save',
    get: 'http://localhost:9000/vehicle/get'
  },
  bank: {
    save: 'http://localhost:9000/bank/save',
    get: 'http://localhost:9000/bank/get'
  },
  reference: {
    save: 'http://localhost:9000/references/save',
    get: 'http://localhost:9000/references/get'
  },
  other: {
    save: 'http://localhost:9000/other/save',
    get: 'http://localhost:9000/other/get'
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
