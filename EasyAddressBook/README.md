EasyAddressBook: Kitchensink Example using Spring 4.x
==============================================================
Easy Address Mini Project was created from the KitchenSink eaxample quick start,
it has been designed for using Wildfly 10 as our Development server, this is a j2ee 6 Application that uses JSP UI, JPA 2.0 , Spring 4 Hibernate, The Project uses the Persistence Unit to access the Database, In this case Mysql DB has been used as well as the internal H2 has been used for running tests(for test Spring Junit Runner has been used). JNDI has been used to access the db.



System Requirements
-------------------

The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform (EAP) 6.1 or 
later with the Red Hat JBoss Web Framework Kit (WFK) 2.7.

To run the quickstart with the provided build script, you need the following:

1. Java 1.6, to run JBoss and Maven. You can choose from the following:
    * OpenJDK
    * Oracle Java SE
    * Oracle JRockit

2. Maven 3.0.0 or later, to build and deploy the examples
    * If you have not yet installed Maven, see the [Maven Getting Started Guide](http://maven.apache.org/guides/getting-started/index.html) for details.
    * If you have installed Maven, you can check the version by typing the following in a command line:

            mvn --version 

3. The JBoss EAP distribution ZIP.
    * For information on how to install and run JBoss, refer to the product documentation.


Configure Maven
---------------

If you have not yet done so, you must [Configure Maven](../README.md#configure-maven) before testing the quickstarts.


Start the JBoss EAP Server
-------------------------

1. Open a command line and navigate to the root of the JBoss EAP directory.
2. The following shows the command line to start the server:

        For Linux:   EAP_HOME/bin/standalone.sh
        For Windows: EAP_HOME\bin\standalone.bat

 
Build and Deploy the Quickstart
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include 
Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](../README.md#build-and-deploy-the-quickstarts) 
for complete instructions and additional options._

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean install jboss-as:deploy

4. This will deploy `target/EasyAddressBook.war` to the running instance of the server.


Access the application
----------------------

The application will be running at the following URL: <http://localhost:8080/EasyAddressBook/>.


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Run the Arquillian Functional Tests
-----------------------------------

This quickstart provides Arquillian functional tests as well. They are located in the functional-tests/ subdirectory under 
the root directory of this quickstart. Functional tests verify that your application behaves correctly from the user's point 
of view. The tests open a browser instance, simulate clicking around the page as a normal user would do, and then close the browser instance.

To run these tests, you must build the main project as described above.

1. Open a command line and navigate to the root directory of this quickstart.
2. Build the quickstart WAR using the following command:

        mvn clean package

3. Navigate to the functional-tests/ directory in this quickstart.
4. If you have a running instance of the JBoss EAP server, as described above, run the remote tests by typing the following command:

        mvn clean verify -Parq-jbossas-remote

5. If you prefer to run the functional tests using managed instance of the JBoss EAP server, meaning the tests will start the 
server for you, type the following command:

        mvn clean verify -Parq-jbossas-managed


Run the Quickstart in JBoss Developer Studio or Eclipse
-------------------------------------

You can also start the server and deploy the quickstart from Eclipse using JBoss tools. For more information, see 
[Use JBoss Developer Studio or Eclipse to Run the Quickstart](../README.md#use-jboss-developer-studio-or-eclipse-to-run-the-quickstarts)


Debug the Application
---------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following 
commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc
