package com.devstackio.maven.couchbase;

import com.couchbase.client.java.document.JsonDocument;
import com.google.gson.Gson;
import javax.enterprise.context.RequestScoped;

/**
 * objects extending EntityCbDao requirements : 
 * - set (protected) bucketName related to entity in constructor
 * - define Object convert(JsonDocument jsonDoc) throws NullPointerException method
 * @author devstackio
 */
@RequestScoped
public class ContractCbDao extends EntityCbDao {

	@Override
	public Object convert(JsonDocument jd) throws NullPointerException {
		
		this.gson = new Gson();
		String entityJson = "";
		entityJson = jd.content().toString();
		return this.gson.fromJson( entityJson, ContractEntity.class );

	}

	@Override
	public String getBucketName() {
		return this.appData.getMainCbBucket();
	}
	
}
