### JSF variant of [blog app](https://github.com/solairerove/blog-app) with Liferay 6.1.2 GA3 integration


##### Build `*.war` file: 

* `git clone *git`
* `cd project`
* `mvn clean install`

___

##### Build ubuntu:liferay [image](https://github.com/solairerove/docker/tree/master/ubuntu-liferay):

* `cd ubuntu-git/`
* `docker build -t name-of-image:tag-of-image .`
* `docker run -t -i -p 8080:8080 name-of-image:tag-of-image`
* `docker rename old-name new-nam`

or crash your host machine

___

##### Start liferay portal:

* `cd liferay/tomcat/bin`
* `./catalina.sh start`
* `cd liferay/tomcat/logs`
* `tail -f -n 100 ./catalina.out`
* `cp *.war /liferay/deploy`

___

##### Mems:


