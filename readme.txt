melitest


*This is a test java spring boot application to mercadolibre offer.

*This application have a vuejs cdn frontend embebed into java spring boot application and response as index page

*The application is made to deploy on docker then in this repo you can find docker file

*The Docker file has enviroment variables to define the redis server connection

*The redis server is a free plan in redis lab, in docker file you can find credential of this database

*To run this application you need dokcer

**locate terminal in this dir

**exec 'docker build -t [image_name] .'

**exec 'docker run -p [port_to_see_application]:8080 [image_name]'

**now you can see the application in localhost:[port_to_see_application]

**aditional you can see and use all backend endpoints with swagger interface on localhost:[port_to_see_application]/swagger-ui-custom.html

**the backend has a endpoint to delete distance info to reset the distance metters, you can see it in swagger interface

**Enjoy it