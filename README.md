#Library Management System

The Library Management System can be used in a casual setting to keep track of book or video information all while using a simple to understand graphical user interface

The program is written entirely in Java using SQL to store information in a DB. Users are encouraged to run a local server on XAMPP for data administration purposes.

# Steps to set up
1. Make sure to install XAMPP, Eclipse, and download our project directory
2. Check to make sure that port 3306 is not taken by any other application. If port 3306 is taken, then XAMPP will let you know that it cannot start the SQL server. 
3. If port 3306 is free, start Apache and MySQL servers from XAMPP
4. Once started, head over to any browser and type in localhost/phpmyadmin
5. Create a new database and name it 'test'
6. Import the database settings by clicking the 'test' database and clicking the 'import' button
7. Select the SQL file located in our project directory under a folder titled 'sql files' and import test.sql 
8. Click 'Go' in PHPMyAdmin interface
9. Database should be successfully loaded
10. Open Eclipse IDE, and import project by clicking 'File' > 'Open Projects From File System'>'Directory' and navigate to where our project directory is stored in your local machine then click 'Finish'
11. Go to 'Package Explorer' and click the folder that has a 'J' icon 
12. Expand the dropdown menu of that folder in the Package Explorer, click the 'JRE System Library' option
13. Right-click the 'JRE System Library' option and click 'Configure Build Path'
14. Set the proper directory path for the JAVA external libraries listed under Modulepath and Classpath respectively by clicking 'Edit' button and navigating to the external libraries stored in the project directory under a folder named 'libararies'
15. Click 'Apply and Close'
16. Go to Package Explorer and head on over to the 'src' directory and open Login.java
17. Check one more time to make sure that Apache and mysql is running in XAMPP
18. Click 'Run' in Eclipse, the program's terminal should reutrn 'Connected to the database..' and a Login form should appear
19. Feel free to login with any of the accounts in the database (default username for admin account is 'test' and password is '123')
20. Program should work just fine at this point

Set up video : https://www.youtube.com/watch?v=Puo8JXrnfyI
