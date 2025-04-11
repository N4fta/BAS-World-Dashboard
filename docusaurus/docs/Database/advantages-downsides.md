---
sidebar_position: 2
sidebar_label: "Advantages & Downsides"
---

# Advantages & Downsides of MongoDB

## **✅ Advantages**

### **1. Flexibility**
- Fields can differ between documents, making MongoDB **perfect for event-based systems**.
- Supports **dynamic structures**, allowing future updates with minimal disruptions.

### **2. Ease of Use**
- **Multi-Language Support**: Works with JavaScript, Java, C#, C++, Python, and more.
- **Data Retrieval Simplicity**: Simple queries reduce complexity depending on the chosen language.

``` javascript, title="JavaScript"
const database = 'Nameless_DB';
const collection = 'mainEventCollection';

use(database);

db.mainEventCollection.find();
```

```java, title="Java (Spring Boot)"
private MainEventEntityRepository mainEventEntityRepository;

public List<MainEvent> GetAllEvents(){
    return mainEventEntityRepository.findAll();
}
```

---

## **🚫 Downsides**

### **1. Data Duplication Risk**
- Due to its document-based structure, **duplicate data** can occur.
- **Solution**: Normalize data or use relationships where possible.

### **2. Learning Curve**
- **SQL Incompatibility**: MongoDB isn’t SQL-based, meaning:
  - **SQL Knowledge Does Not Transfer Easily.**
  - Requires **learning new querying methods**.

### **3. Aggregation Queries Complexity**
- Aggregated data querying may **differ between languages**.
- **Syntax Variations**: Queries in JavaScript may be different from those in Java or Python.
``` javascript, title="Query in JavaScript"
const database = 'Nameless DB';
const collection = 'mainEventCollection';

use(database);

db[collection].aggregate([
  {
    $unwind: {
      path: "$eventPayload.event.data.items",
      preserveNullAndEmptyArrays: true
    }
  },
  {
    $group: {
      _id: "$eventPayload.event.data.items.items_name",
      count: { $sum: 1 }
    }
  },
  {
    $match: {
      _id: { $ne: null }
    }
  },
  {
    $project: {
      item_name: "$_id",
      count: 1,
      _id: 0
    }
  }
]);
```


```java, title="Query in Java"
public List<ItemCount> getItemCountTrucks() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("eventPayload.event.data.items", true),
                Aggregation.group("eventPayload.event.data.items.item_name")
                        .count().as("count"),
                Aggregation.match(Criteria.where("_id").ne(null)),
                Aggregation.project("count")
                        .and("_id").as("item")
                        .andExclude("_id")
        );

        AggregationResults<ItemCountEntity> results = mongoTemplate.aggregate(aggregation, MainEventEntity.class, ItemCountEntity.class);
        return convertItemNameToDomainList(results.getMappedResults());
    }
```