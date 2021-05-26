package com.example.springbootmongodbintegrat;

import com.example.springbootmongodbintegrat.bean.User;
import com.mongodb.client.*;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@SpringBootTest
class SpringBootMongodbIntegratApplicationTests {

	@Autowired
	MongoTemplate mongoTemplate;


	@Test
	void contextLoads() {
		//获取当前数据库:
		MongoDatabase db = mongoTemplate.getDb();
		System.out.println(db.getName()); //打印当前数据库的名称
		//创建集合
		db.createCollection("user");
		//获取所有集合名称
		ListCollectionsIterable<Document> documents = db.listCollections();
		documents.forEach(i -> System.out.println(i.getString("name")));
	}

	/**
	 * 获取集合插入文档
	 */
	@Test
	void createCollection(){
		MongoCollection<Document> user = mongoTemplate.getDb().getCollection("user");
		Document document = new Document("title","MongoDB");
		document.append("age",10);
		document.append("name","小明");
		user.insertOne(document);

//		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDbFactory(MongoClients.create(), "database"));
//		mongoOps.insert()
	}



	/**
	 * 查询文档:
	 */
	@Test
	void  findCollection(){
		MongoCollection<Document> user = mongoTemplate.getDb().getCollection("user");
		FindIterable<Document> documents = user.find();
		documents.forEach(i -> System.out.println(i));

		ListIndexesIterable<Document> documents1 = user.listIndexes();
		documents1.forEach(i->System.out.println(i));
	}

	/**
	 * 删除文档
	 */
	@Test
	void  dropCollection(){
		MongoCollection<Document> user = mongoTemplate.getDb().getCollection("user");
		user.drop();
	}


}
