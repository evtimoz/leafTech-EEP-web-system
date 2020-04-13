# leafTech-EEP-web-system

This Java Swing web-based application is merged Leaf Tech and EEP inventory management systems under one common interface. </br> </br>
Authentification for users by three different roles (order/inventory/shipping) provided. </br> </br>
After log-in user can see the screen to manipulate with products depending on his role. </br> </br>
Application is supplied in one jar-file, that can be easily executed on any PC without any additional installations.</br>
Only Java VM should be preinstalled. </br> </br>

There are three user accounts with different roles in system:

1. Inventory management </br>
user: inventory </br>
password: qwerty </br>
logs activity: https://us-central1-leaftech-eep-web-system.cloudfunctions.net/app/view-logs/inventory

2. Order management </br>
user: order </br>
password: qwerty </br>
logs activity: https://us-central1-leaftech-eep-web-system.cloudfunctions.net/app/view-logs/order

3. Shipping management</br>
user: shipping </br>
password: qwerty </br>
logs activity: https://us-central1-leaftech-eep-web-system.cloudfunctions.net/app/view-logs/shipping

All the data about products, orders and users is stored in online NoSQL database Firebase. </br>
Data was migrated from old MySQL database was migrated by selecting data from relational data model, saving in json file and importing in Firebase with help of node.js script.
The process of data migration takes less than 5 minutes.


