db = db.getSiblingDB('profanity_db');

db.profanity.insertOne({
  profanities: [
    "cazzo",
    "merda",
    "coglione",
    "stronzo",
    "bastardo"
  ]
});
