docker rmi amdsolah/home-rental:back-end
cd home-rental-app
mvn package
docker build -t amdsolah/home-rental:back-end .
docker push amdsolah/home-rental:back-end
cd ..