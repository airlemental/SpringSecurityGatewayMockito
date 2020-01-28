# Admin, Gateway, and UI all have Angular Frontends that have to be compiled locally the first time.
If this is a fresh download from the repo, it will not have NODE.JS or Angular modules, they are large and don't like to work with Git so they
are all  in the .gitignore file.

Navigate to each service in the terminal, execute command `ng build`
SpringSecurityGatewayMockito\admin
SpringSecurityGatewayMockito\gateway
SpringSecurityGatewayMockito\ui

# Services requires Redis Docker Container to be RUNNING
# Selenium requires hub and browser nodes to be RUNNING
These commands will download, compile, and run all necessary docker services.
 
 Have Docker compose installed.
 
 Have docker-compose.yml file in root of project. `SpringSecurityGatewayMockito`
 Execute command in terminal:
  `docker-compose up -d`
 Once they are up and running, start service 'gateway' to test.
 
 # In seleniumtests_01 and up this file now includes Selenium Server and Firefox drivers
 
 # To stop the grid and cleanup the created containers, run 
 docker-compose down
 
 
 
 
 # When you are done using the grid and the containers have exited, the network can be removed with the following command:
 
 # Remove all unused networks
 $ docker network prune
 # OR
 # Removes the grid network
 $ docker network rm grid
