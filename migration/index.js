const admin = require('./node_modules/firebase-admin');
const serviceAccount = require("./creds.json");
admin.initializeApp({  credential: admin.credential.cert(serviceAccount),  databaseURL: "https://leaftech-eep-web-system.firebaseio.com"});
const firestore = admin.firestore();
const settings = {timestampsInSnapshots: true};
firestore.settings(settings);

const data = require("./data.json");
const collectionKey = "products"; //name of the collection
if (data && (typeof data === "object")) {Object.keys(data).forEach(docKey => { firestore.collection(collectionKey).doc().set(data[docKey]).then((res) => {    console.log("Document " + docKey + " successfully written!");}).catch((error) => {   console.error("Error writing document: ", error);});});}