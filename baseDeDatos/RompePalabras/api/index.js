const MongoClient = require('mongodb').MongoClient;
const uri = "mongodb+srv://MaximoDiNapoli:<password>@cluster0.9gizt.gcp.mongodb.net/<dbname>?retryWrites=true&w=majority";
const client = new MongoClient(uri, { useNewUrlParser: true });
client.connect(err => {
  const collection = client.db("test").collection("devices");
  // perform actions on the collection object
  client.close();
});
module.exports = (req, res) => {
    res.send('hola mundo')
}