#docker rmi amdsolah/home-rental:front-end
cd home-rental-angular
cp ./dist/home-rental-angular/Dockerfile .
ng build
cp Dockerfile dist/home-rental-angular
cd dist/home-rental-angular
docker build -t amdsolah/home-rental:front-end .
docker push amdsolah/home-rental:front-end
cd ../../..