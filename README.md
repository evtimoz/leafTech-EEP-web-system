# leafTech-EEP-web-system

This Java Swing web-based application is merged Leaf Tech and EEP inventory management systems under one common interface. </br> </br>
Authentification for users by three different roles (order/inventory/shipping) provided. </br> </br>
After log-in user can see the screen to manipulate with products depending on his role. </br> </br>
Application is supplied in <a href="https://github.com/evtimoz/leafTech-EEP-web-system/releases/tag/1.0"> one jar-file </a>, that can be <a href="https://ru.wikihow.com/%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D1%82%D0%B8%D1%82%D1%8C-.JAR-%D1%84%D0%B0%D0%B9%D0%BB"> easily executed on any PC </a> without any additional installations (only Java pre-installed).</br> </br>
**Important**: the time and date on your machine should be correct and syncronized by the internet.

There are three user accounts with different roles in system:

1. **Inventory management** </br>
*user*: inventory </br>
*password*: qwerty </br>
logs activity: https://us-central1-leaftech-eep-web-system.cloudfunctions.net/app/view-logs/inventory

2. **Order management** </br>
*user*: order </br>
*password*: qwerty </br>
logs activity: https://us-central1-leaftech-eep-web-system.cloudfunctions.net/app/view-logs/order

3. **Shipping management**</br>
*user*: shipping </br>
*password*: qwerty </br>
logs activity: https://us-central1-leaftech-eep-web-system.cloudfunctions.net/app/view-logs/shipping

All the data about products, orders and users is stored in online <a href="https://github.com/evtimoz/leafTech-EEP-web-system/blob/master/migration/data_model.png"> NoSQL database Firebase </a>. </br>  </br>
Data was migrated from old MySQL database by selecting data from relational data model, saving in json file and importing in Firebase with help of node.js script. All the required files and instructions for migration are in <a href="https://github.com/evtimoz/leafTech-EEP-web-system/tree/master/migration"> this folder </a>. All passwords are <a href="https://github.com/evtimoz/leafTech-EEP-web-system/commit/d08fa7d9ef03d6e484905e042d1ea49cf18112d9"> ecrypted </a> and stored in a secure way.
The process of data migration takes less than 5 minutes.


