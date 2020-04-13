## Data migration from MySQL to NoSQL Firebase


1. Execute <a href="https://github.com/evtimoz/leafTech-EEP-web-system/blob/master/migration/migration.sql"> migration.sql </a> file in your MySQL console to export all stroed data about products and orders into one <a href="https://github.com/evtimoz/leafTech-EEP-web-system/blob/master/migration/data.json"> large json file </a>
2. Create <a href="https://firebase.google.com/docs/firestore"> firestore database </a> and get credentionals in json format to manipulate data remotely
3. Create new node.js module with <a href="https://github.com/evtimoz/leafTech-EEP-web-system/blob/master/migration/index.js"> this script </a> and execute it
4. Data successfully uploaded in new NoSQL firestore!


More detailed steps with screenshots are here: <a href="https://medium.com/@impaachu/how-to-upload-data-to-firebase-firestore-cloud-database-63543d7b34c5"> instruction </a>.
