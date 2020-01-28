# SpringSecurityGatewayToUI
 Functional Gateway to Backend Resources
 This will not run without a Redis database running on default port
 
 Have Docker compose installed.
 Have docker-compose.yml file in root of project.
 Execute command in terminal:
  docker-compose up -d
 Once it is up and running, start service gateway to test.
 
 # In seleniumtests_01 and up this file now includes Selenium Server and Firefox drivers
 
 # To stop the grid and cleanup the created containers, run 
 docker-compose down
 
 # When you are done using the grid and the containers have exited, the network can be removed with the following command:
 
 # Remove all unused networks
 $ docker network prune
 # OR
 # Removes the grid network
 $ docker network rm grid
